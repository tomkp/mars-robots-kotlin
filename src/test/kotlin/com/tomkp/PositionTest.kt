package com.tomkp

import com.tomkp.Orientation.*
import org.junit.Assert.assertEquals
import org.junit.Test

class PositionTest {

    @Test
    fun `should move position forward`() {
        assertEquals(Position(Coordinate(0, 1), N), Position(Coordinate(0, 0), N).forward())
        assertEquals(Position(Coordinate(1, 0), E), Position(Coordinate(0, 0), E).forward())
        assertEquals(Position(Coordinate(0, -1), S), Position(Coordinate(0, 0), S).forward())
        assertEquals(Position(Coordinate(-1, 0), W), Position(Coordinate(0, 0), W).forward())
    }

    @Test
    fun `should rotate position anti-clockwise`() {
        assertEquals(Position(Coordinate(0, 0), W), Position(Coordinate(0, 0), N).rotateAntiClockwise())
        assertEquals(Position(Coordinate(0, 0), N), Position(Coordinate(0, 0), E).rotateAntiClockwise())
        assertEquals(Position(Coordinate(0, 0), E), Position(Coordinate(0, 0), S).rotateAntiClockwise())
        assertEquals(Position(Coordinate(0, 0), S), Position(Coordinate(0, 0), W).rotateAntiClockwise())
    }

    @Test
    fun `should rotate position clockwise`() {
        assertEquals(Position(Coordinate(0, 0), E), Position(Coordinate(0, 0), N).rotateClockwise())
        assertEquals(Position(Coordinate(0, 0), S), Position(Coordinate(0, 0), E).rotateClockwise())
        assertEquals(Position(Coordinate(0, 0), W), Position(Coordinate(0, 0), S).rotateClockwise())
        assertEquals(Position(Coordinate(0, 0), N), Position(Coordinate(0, 0), W).rotateClockwise())
    }
}