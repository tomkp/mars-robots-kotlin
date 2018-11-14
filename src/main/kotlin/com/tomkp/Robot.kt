package com.tomkp

import com.tomkp.Instruction.*

enum class Instruction { L, R, F }

data class Instructions(val instructions: List<Instruction>) {
    constructor(vararg instructions: Instruction) : this(instructions.toList())
}

class Robot(private val mars: Mars, var position: Position) {

    private var lost = false

    fun move(instructions: Instructions) {
        for (instruction in instructions.instructions) {
            move(instruction)
            if (lost) break
        }
    }

    fun isLost(): Boolean = lost

    private fun move(instruction: Instruction) {
        val nextPosition = calculateNextPosition(instruction)
        when {
            mars.isOnPlanet(nextPosition.coordinate) -> position = nextPosition
            mars.hasNoScent(position.coordinate) -> {
                mars.addScent(position.coordinate)
                lost = true
            }
        }
    }

    private fun calculateNextPosition(instruction: Instruction): Position =
            when (instruction) {
                F -> position.forward()
                L -> position.rotateAntiClockwise()
                R -> position.rotateClockwise()
            }

    override fun toString(): String = "$position${if (lost) " LOST" else ""}"
}