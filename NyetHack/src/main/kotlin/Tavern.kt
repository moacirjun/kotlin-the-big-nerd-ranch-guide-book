import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastNamesList = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt").readLines()

fun main() {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yeah, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    (0..9).forEach {
        val firstName = patronList.shuffled().first()
        val lastName = lastNamesList.shuffled().first()
        val fullName = "$firstName $lastName"

        uniquePatrons += fullName
    }
    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
}

fun performPurchase(price: Double) {
    displayBalance()

    val totalPurse = playerGold + (playerSilver / 100.0)

    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    playerGold = remainingBalance.toInt()
    playerSilver = (remainingBalance % 1 * 100).roundToInt()
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold $playerGold, Silver $playerSilver.")
}

fun placeOrder(patronName: String, menu: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menu.split(',')
    val message = "$patronName buys a $name ($type) for $price mangos."

    println(message)
//    performPurchase(price.toDouble())

    val phrase = if (name == "DrAgon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name")}"
    } else {
        "$patronName says: Thanks for the $name"
    }

    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[a-uA-U]")) {
        when(it.value) {
            in listOf("a", "A") -> "4"
            in listOf("e", "E") -> "3"
            in listOf("i", "I") -> "1"
            in listOf("o", "O") -> "0"
            in listOf("u", "U") -> "|_|"
            else -> it.value
        }
    }