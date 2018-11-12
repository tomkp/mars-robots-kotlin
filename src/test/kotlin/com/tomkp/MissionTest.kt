package com.tomkp

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

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

        assertEquals(output, Mission.run(input))
    }


    @Test
    fun throwExceptionWithInvalidDimensions() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("W 9\n0 0 N\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 H\n0 0 N\nL")
        }
    }

    @Test
    fun throwExceptionWithInvalidPosition() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\ninvalid\nL")
        }
    }

    @Test
    fun throwExceptionWithMissingOrientation() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 a N\nL")
        }
    }

    @Test
    fun throwExceptionOnInvalidInstructions() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 N\nX")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 N\nLX")
        }
    }

}