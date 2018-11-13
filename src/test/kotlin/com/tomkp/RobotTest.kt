package com.tomkp

import com.tomkp.Instruction.*
import com.tomkp.Orientation.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RobotTest {

    @Test
    fun `should move Robot forwards`() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(Instructions(F))
        assertEquals(Position(Coordinate(1, 2), N), robot.position)
    }

    @Test
    fun `should rotate Robot left`() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(Instructions(L))
        assertEquals(Position(Coordinate(1, 1), W), robot.position)
    }

    @Test
    fun `should rotate Robot right`() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(Instructions(R))
        assertEquals(Position(Coordinate(1, 1), E), robot.position)
    }

    @Test
    fun `should move Robot according to a sequence of instructions #1`() {
        val robot = Robot(Mars(5, 3), Position(Coordinate(1, 1), E))
        robot.move(Instructions(R, F, R, F, R, F, R, F))
        assertEquals(Position(Coordinate(1, 1), E), robot.position)
    }

    @Test
    fun `should move Robot according to a sequence of instructions #2`() {
        val robot = Robot(Mars(5, 3), Position(Coordinate(3, 2), N))
        robot.move(Instructions(F, R, R, F, L, L, F, F, R, R, F, L, L))
        assertEquals(Position(Coordinate(3, 3), N), robot.position)
    }

    @Test
    fun `should move Robots according to sequences of instructions`() {
        val mars = Mars(5, 3)

        val robot1 = Robot(mars, Position(Coordinate(1, 1), E))
        robot1.move(Instructions(R, F, R, F, R, F, R, F))
        assertEquals(Position(Coordinate(1, 1), E), robot1.position)
        assertFalse(robot1.isLost())

        val robot2 = Robot(mars, Position(Coordinate(3, 2), N))
        robot2.move(Instructions(F, R, R, F, L, L, F, F, R, R, F, L, L))
        assertEquals(Position(Coordinate(3, 3), N), robot2.position)
        assertTrue(robot2.isLost())

        val robot3 = Robot(mars, Position(Coordinate(0, 3), W))
        robot3.move(Instructions(L, L, F, F, F, L, F, L, F, L))
        assertEquals(Position(Coordinate(2, 3), S), robot3.position)
        assertFalse(robot3.isLost())
    }
}