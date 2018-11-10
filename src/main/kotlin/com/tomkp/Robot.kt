package com.tomkp

import com.tomkp.Instruction.*

class Robot(private val mars: Mars, var position: Position) {

    var alive = true

    fun move(instructions: Instructions) {
        for (instruction in instructions.instructions) {
            move(instruction)
            if (!alive) break
        }
    }

    private fun move(instruction: Instruction) {
        val newPosition = calculateNextPosition(instruction)
        when {
            mars.isOnPlanet(newPosition.coordinate) -> position = newPosition
            mars.hasNoScent(position.coordinate) ->  {
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