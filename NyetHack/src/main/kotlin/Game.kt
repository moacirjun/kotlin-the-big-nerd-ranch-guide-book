fun main(args: Array<String>) {
    val name = "Modrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraStatus = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraStatus, isBlessed, name, healthStatus)

    blastFireBall()
}

private fun printPlayerStatus(
    auraStatus: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraStatus) (Blessed: ${if (isBlessed) "YES" else "NONE"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraIsVisible = isBlessed && healthPoints > 50 || isImmortal;

    return if (auraIsVisible) "GREEN" else "NONE"
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

private fun blastFireBall(qty: Int = 2) =
    println("Fireball was blasted (x$qty).");