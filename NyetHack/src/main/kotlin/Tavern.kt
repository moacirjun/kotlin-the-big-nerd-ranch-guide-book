fun main() {
    var beverage = readLine()
//    beverage = null

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't perform that. The beverage is null!")
    }

    val beverageServed = beverage ?: "Buttered Ale"
    println(beverageServed)
}