package com.tomkp

import com.tomkp.Instruction.*

class Robot(private val mars: Mars, var position: Position) {

    fun move(vararg instructions: Instruction) {
        println("move ${instructions.joinToString(", ")}")
        for (instruction in instructions) {
            val alive = move(instruction)
            if (!alive) break
        }
    }

    private fun move(instruction: Instruction): Boolean {
        val newPosition = calculateNextPosition(instruction)
        println("move $instruction $position -> $newPosition")
        return when {
            mars.isOnPlanet(newPosition.coordinate) -> {
                position = newPosition
                true
            }
            mars.hasScent(position.coordinate) -> {
                println("${newPosition.coordinate} has scent, ignore")
                true
            }
            else -> {
                println("lost at ${newPosition.coordinate}, add scent")
                mars.addScent(position.coordinate)
                false
            }
        }
    }

    private fun calculateNextPosition(instruction: Instruction): Position =
            when (instruction) {
                F -> position.forward()
                L -> position.rotateAntiClockwise()
                R -> position.rotateClockwise()
            }
}