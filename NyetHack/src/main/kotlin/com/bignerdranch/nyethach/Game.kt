package com.bignerdranch.nyethach

fun main() {
    val player = Player("madrigal")
    player.castFireball()

    val currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NONE"})")
    println("${player.name} ${player.formatHealthStatus()}")
}