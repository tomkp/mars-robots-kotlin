package com.tomkp

import org.junit.Assert.assertEquals
import org.junit.Test

class MissionTest {

    @Test
    fun shouldParse() {
        val input = """
            5 3
            1 1 E
            RFRFRFRF

            3 2 N
            FRRFLLFFRRFLL

            0 3 W
            LLFFFLFLFL
        """.trimIndent().trimMargin()

        val output = """
            1 1 E
            3 3 N LOST
            2 3 S
        """.trimIndent().trimMargin()

        assertEquals(output, Mission.process(input))
    }
}