fun main() {
    runSimulation("Saterê Mawê")
}

fun runSimulation(playerName: String) {
    val greetingFunction = configureGreetingFunction()

    println(greetingFunction(playerName))
    println(greetingFunction(playerName))
}

fun printConstructionCost(builds: Int) {
    val cost = 356
    println("Building cost: ${cost * builds}")
}

fun configureGreetingFunction(): (String) -> String {
    val numBuilds = (1..9).shuffled().first()

    return configureGreetingFunction(numBuilds)
}

fun configureGreetingFunction(numBuilds: Int): (String) -> String {
    val structureType = "hospitals"
    var actualBuilds = numBuilds

    return { playerName ->
        val currentYear = 2021
        actualBuilds++

        println("Adding $actualBuilds $structureType")
        printConstructionCost(actualBuilds)

        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}