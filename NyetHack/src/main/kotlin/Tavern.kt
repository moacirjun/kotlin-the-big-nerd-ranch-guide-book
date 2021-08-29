import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("Bebida,DrAgon's Breath,5.12")
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

fun placeOrder(menu: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menu.split(',')
    val message = "Madrigal buys a $name ($type) for $price mangos."

    println(message)
    performPurchase(price.toDouble())

    val phrase = if (name == "DrAgon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name")}"
    } else {
        "Madrigal says: Thanks for the $name"
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