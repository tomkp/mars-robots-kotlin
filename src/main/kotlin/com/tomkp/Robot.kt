package com.tomkp

class Robot(private val mars: Mars, var position: Position) {

    fun move(vararg instructions: Instruction) {

        println(toString())

        println("move ${instructions.joinToString(", ")}")

        for (instruction in instructions) {
            val alive = move(instruction)
            if (!alive) break
        }
    }

    private fun move(instruction: Instruction): Boolean {

        val newPosition = when (instruction) {
            Instruction.F -> position.forward()
            Instruction.L -> position.rotateAntiClockwise()
            Instruction.R -> position.rotateClockwise()
        }

        println("move $instruction $position -> $newPosition")

        val alive = when {
            mars.contains(newPosition.coordinate) -> {
                position = newPosition
                true
            }
            mars.hasScent(position.coordinate) -> {
                println("${newPosition.coordinate} has scent, ignore")
                true
            }
            else -> {
                println("lost at ${newPosition.coordinate}")
                mars.addScent(position.coordinate)
                false
            }
        }

        println(toString())

        return alive
    }


    override fun toString(): String {
        val s = StringBuilder()
        s.append("\n")
        for (y in mars.height downTo 0) {
            for (x in 0..mars.width) {
                val coordinate = position.coordinate
                when {
                    coordinate == Coordinate(x,y) -> s.append(position.orientation.render())
                    mars.hasScent(Coordinate(x, y)) -> s.append("x")
                    else -> s.append(".")
                }
            }
            s.append("\n")
        }
        return s.toString()
    }
}