const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("Bebida,DrAgon's Breath,5.12")
}

fun placeOrder(menu: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menu.split(',')
    val message = "Madrigal buys a $name ($type) for $price mangos."

    println(message)

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