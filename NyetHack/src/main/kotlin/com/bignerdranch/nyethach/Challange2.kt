package com.bignerdranch.nyethach

fun main(args: Array<String>) {
    val name = "Modrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraIsVisible = isBlessed && healthPoints > 50 || isImmortal;
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0 * 20)).toInt()

    val auraStatus = if (!auraIsVisible) {
        "NONE"
    } else {
        when(karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            in 16..20 -> "green"
            else -> "none"
        }
    }

    val healthStatus = when(healthPoints) {
        100 -> "is excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt."
        else ->  "is in awful condition!"
    }

    //B A H HP
    val statusFormatString = "(HP)(H) | B | A";

    val blessedStatus = if (isBlessed) "YES" else "NO"

    println("(Aura: $auraStatus) (Blessed: ${if (isBlessed) "YES" else "NONE"})")
    println("$name $healthStatus")
}