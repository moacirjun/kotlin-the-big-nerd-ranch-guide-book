package com.bignerdranch.nyethach

class Player {
    var name = "modrigal"
    get() = field.replaceFirstChar { if (it.isLowerCase()) it.uppercase() else it.toString() }
    set(value) {
        field = value.trim()
    }

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) =
        println("a glass of Fireball springs into existence. ($numFireballs)")

    fun auraColor(): String {
        val auraIsVisible = isBlessed && healthPoints > 50 || isImmortal

        return if (auraIsVisible) "GREEN" else "NONE"
    }

    fun formatHealthStatus() =
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
}