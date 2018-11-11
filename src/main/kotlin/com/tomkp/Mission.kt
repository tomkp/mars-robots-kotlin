package com.tomkp

object Mission {

    fun process(input: String): String {
        val lines = input.split("\n")
        val mars = Mars.create(lines.first())
        val filtered = lines.filter(String::isNotEmpty)
        val output = mutableListOf<String>()
        for (index in 1 until filtered.size step 2) {
            val robot = Robot(mars, Position.create(filtered[index]))
            robot.move(Instructions(filtered[index + 1]))
            output.add("$robot")
        }
        return output.joinToString("\n")
    }
}