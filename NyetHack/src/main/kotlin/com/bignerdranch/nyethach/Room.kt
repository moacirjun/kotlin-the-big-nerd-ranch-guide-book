package com.bignerdranch.nyethach

open class Room(val name: String) {
    protected open val dangerLevel = 5
    var monster: Monster? = Goblin()

    fun description() = "Room: $name. Danger Level: $dangerLevel. Creature ${monster?.name ?: "none"}."
    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private val bellSound = "oficina g3"

    override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}