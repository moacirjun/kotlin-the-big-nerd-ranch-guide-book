package com.bignerdranch.nyethach

import kotlin.system.exitProcess

fun main() {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()
    private val worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("Welcome to the jungle!!")
        player.castFireball()
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus()

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            player.currentPosition = newPosition

            val newRoom = worldMap[newPosition.y][newPosition.x]
            currentRoom = newRoom

            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }

        "Combat completed."
    } ?: "There's nothing here to fight."

    private fun slay(monster: Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        if (player.healthPoints <= 0) {
            println(">>>>>>>>>> You have been defeated! Thanks for playing. <<<<<<<<<<<")
            exitProcess(0)
        }

        println("${player.name} did ${player.attack(monster)} damage!")
        if (monster.healthPoints <= 0) {
            println(">>>>>>>>>> ${monster.name} defeated! <<<<<<<<<<<")
            currentRoom.monster = null
        }
    }

    private fun printPlayerStatus() {
        println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NONE"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput (args: String?) {
        private val input = args ?: ""
        val command = input.split(" ").first()
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            "fight" -> fight()
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "Command not found!"
    }
}