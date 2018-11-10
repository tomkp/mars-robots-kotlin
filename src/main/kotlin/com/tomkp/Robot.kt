package com.tomkp

import com.tomkp.Instruction.*

class Robot(private val mars: Mars, var position: Position) {

    var alive = true

    fun move(vararg instructions: Instruction) {
        println("move ${instructions.joinToString(", ")}")
        for (instruction in instructions) {
            move(instruction)
            if (!alive) break
        }
    }

    private fun move(instruction: Instruction) {
        val newPosition = calculateNextPosition(instruction)
        println("move $instruction $position -> $newPosition")
        when {
            mars.isOnPlanet(newPosition.coordinate) -> position = newPosition
            mars.hasNoScent(position.coordinate) ->  {
                println("lost moving to ${newPosition.coordinate}, add scent at ${position.coordinate}")
                mars.addScent(position.coordinate)
                alive = false
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