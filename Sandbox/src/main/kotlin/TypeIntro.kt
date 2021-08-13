const val MAX_EXPERIENCE: Int = 5

fun main() {
    val name = "Jeredy"
    var experiencePoints = 5
    var hasSteed = false
    var currentMoney = 50000
    val mirroredName = name.reversed();

    val pubName = "Unicorn's Horn"
    val pabMenu: List<String> = listOf("Mead", "Wine", "LaCroix")

    experiencePoints += 5
    println(experiencePoints)
    println(name)
    println(mirroredName)
    println(hasSteed)
    println(currentMoney)
}