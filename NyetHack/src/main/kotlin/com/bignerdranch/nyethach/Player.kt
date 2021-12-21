package com.bignerdranch.nyethach

import java.io.File

class Player(
    _name: String,
    override var healthPoints: Int,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) : Fightable {
    var name = _name
        get() = "${capitalizeString(field)} of $hometown"
        set(value) {
            field = value.trim()
        }

    val hometown = selectHometown()
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0) { "health points must be greater than 0." }
        require(name.isNotBlank()) { "Player must have a name." }
    }

    constructor(name: String) : this(name, healthPoints = 100, isBlessed = true, isImmortal = false) {
        if (name.lowercase() == "kar") healthPoints = 40
    }

    private fun capitalizeString(text: String) = text.replaceFirstChar { if (it.isLowerCase()) it.uppercase() else it.toString() }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

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

    override val diceCount = 3
    override val diceSides = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt

        return damageDealt
    }
}