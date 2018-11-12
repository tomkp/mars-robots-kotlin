package com.tomkp

import org.junit.Test

import org.junit.Assert.*

class MarsTest {

    @Test
    fun isOnPlanet() {
        val mars = Mars(1, 1)
        assertTrue(mars.isOnPlanet(Coordinate(0, 0)))
        assertTrue(mars.isOnPlanet(Coordinate(0, 1)))
        assertTrue(mars.isOnPlanet(Coordinate(1, 0)))
        assertTrue(mars.isOnPlanet(Coordinate(1, 1)))

        assertFalse(mars.isOnPlanet(Coordinate(-1, 0)))
        assertFalse(mars.isOnPlanet(Coordinate(0, -1)))
        assertFalse(mars.isOnPlanet(Coordinate(2, 0)))
        assertFalse(mars.isOnPlanet(Coordinate(0, 2)))
    }

    @Test
    fun scent() {
        val mars = Mars(1, 1)
        mars.addScent(Coordinate(0, 1))
        assertTrue(mars.hasNoScent(Coordinate(0, 0)))
        assertFalse(mars.hasNoScent(Coordinate(0, 1)))
        assertTrue(mars.hasNoScent(Coordinate(1, 0)))
        assertTrue(mars.hasNoScent(Coordinate(1, 1)))
    }
}