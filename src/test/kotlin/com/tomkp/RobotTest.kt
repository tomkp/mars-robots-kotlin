package com.tomkp

import com.tomkp.Instruction.*
import com.tomkp.Orientation.*
import org.junit.Assert.assertEquals
import org.junit.Test

class RobotTest {

    @Test
    fun forward() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(F)
        assertEquals(Position(Coordinate(1, 2), N), robot.position)
    }

    @Test
    fun left() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(L)
        assertEquals(Position(Coordinate(1, 1), W), robot.position)
    }

    @Test
    fun right() {
        val robot = Robot(Mars(10, 10), Position(Coordinate(1, 1), N))
        robot.move(R)
        assertEquals(Position(Coordinate(1, 1), E), robot.position)
    }

    @Test
    fun sequence1() {
        val robot = Robot(Mars(5, 3), Position(Coordinate(1, 1), E))
        robot.move(R, F, R, F, R, F, R, F)
        assertEquals(Position(Coordinate(1, 1), E), robot.position)
    }

    @Test
    fun sequence2() {
        val robot = Robot(Mars(5, 3), Position(Coordinate(3, 2), N))
        robot.move(F, R, R, F, L, L, F, F, R, R, F, L, L)
        assertEquals(Position(Coordinate(3, 3), N), robot.position)
    }

    @Test
    fun multiRobotSequence() {
        val mars = Mars(5, 3)

        val robot1 = Robot(mars, Position(Coordinate(1, 1), E))
        robot1.move(R, F, R, F, R, F, R, F)
        assertEquals(Position(Coordinate(1, 1), E), robot1.position)

        val robot2 = Robot(mars, Position(Coordinate(3, 2), N))
        robot2.move(F, R, R, F, L, L, F, F, R, R, F, L, L)
        assertEquals(Position(Coordinate(3, 3), N), robot2.position)

        val robot3 = Robot(mars, Position(Coordinate(0, 3), W))
        robot3.move(L, L, F, F, F, L, F, L, F, L)
        assertEquals(Position(Coordinate(2, 3), S), robot3.position)
    }
}