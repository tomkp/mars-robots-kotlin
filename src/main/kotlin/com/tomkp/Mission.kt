package com.tomkp

import com.tomkp.Instruction.valueOf

object Mission {

    fun run(input: String): String {
        val lines = input.split("\n")
        val mars = createMars(lines.first())
        val filtered = lines.filter(String::isNotEmpty)
        val output = mutableListOf<String>()
        for (index in 1 until filtered.size step 2) {
            val robot = Robot(mars, createPosition(filtered[index]))
            robot.move(createInstructions(filtered[index + 1]))
            output.add("$robot")
        }
        return output.joinToString("\n")
    }

    private fun createPosition(position: String): Position {
        val tokens = position.split(" ")
        if (tokens.size != 3) {
            throw IllegalArgumentException("Unable to create position '$position', invalid format")
        }
        val coordinate: Coordinate
        try {
            coordinate = Coordinate(tokens[0].toInt(), tokens[1].toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Unable to create coordinate '${tokens[0]} ${tokens[1]}'", e)
        }
        val orientation = Orientation.valueOf(tokens[2])
        return Position(coordinate, orientation)
    }

    private fun createMars(dimensions: String): Mars {
        val tokens = dimensions.split(" ")
        return Mars(tokens[0].toInt(), tokens[1].toInt())
    }

    private fun createInstructions(instructions: String):Instructions {
        return Instructions(instructions
                .replace(" ", "")
                .toCharArray()
                .map { valueOf(it.toString()) })
    }
}