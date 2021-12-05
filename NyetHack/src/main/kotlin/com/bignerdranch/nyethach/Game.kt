package com.bignerdranch.nyethach

fun main() {
    val player = Player()
    player.castFireball()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NONE"})")
    println("${player.name} ${player.formatHealthStatus()}")
}