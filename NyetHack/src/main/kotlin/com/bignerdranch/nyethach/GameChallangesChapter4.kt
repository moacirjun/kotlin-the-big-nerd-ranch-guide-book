package com.bignerdranch.nyethach

fun main() {
    val name = "Modrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraStatus = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    val inebriationLevel = castFireBall(6)
    printPlayerStatus(auraStatus, isBlessed, name, healthStatus, inebriationLevel)
}

private fun printPlayerStatus(
    auraStatus: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    inebriationLevel: Int = 0
) {
    println("(Aura: $auraStatus) (Blessed: ${if (isBlessed) "YES" else "NONE"}) (Inebriation: ${inebriationStatus(inebriationLevel)})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

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

private fun castFireBall(qty: Int = 2) : Int {
    if (qty < 0) {
        return 1;
    }

    println("Fireball was blasted (x$qty).");

    return (qty * 10).coerceAtMost(50);
}

private fun inebriationStatus(inebriationLevel: Int) =
    when (inebriationLevel) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        in 41..50 -> "t0aSt3d"
        else -> "Unknown Inebriation Status"
    }