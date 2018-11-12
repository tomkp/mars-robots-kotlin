package com.tomkp

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class MissionTest {

    @Test
    fun `should parse and run valid set of instructions`() {
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
    fun `should throw an Exception when creating Mars with invalid dimensions`() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("W 9\n0 0 N\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 H\n0 0 N\nL")
        }
    }

    @Test
    fun `should throw an Exception when using an invalid position for the Robot`() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\ninvalid\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 X N\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\nX 0 N\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\nX X N\nL")
        }
    }

    @Test
    fun `should throw an Exception when using an invalid orientation for the Robot`() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0\nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 \nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 \nL")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 X\nL")
        }
    }

    @Test
    fun `should throw an Exception when using an invalid instruction`() {
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 N\nX")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Mission.run("9 9\n0 0 N\nLX")
        }
    }
}