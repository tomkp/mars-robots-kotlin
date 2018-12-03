package com.tomkp

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MarsTest {

    @Test
    fun `should return true when a coordinate is on the planet`() {
        val mars = Mars(1, 1)
        assertTrue(mars.isOnPlanet(Coordinate(0, 0)))
        assertTrue(mars.isOnPlanet(Coordinate(0, 1)))
        assertTrue(mars.isOnPlanet(Coordinate(1, 0)))
        assertTrue(mars.isOnPlanet(Coordinate(1, 1)))
    }

    @Test
    fun `should return false when a coordinate is NOT on the planet`() {
        val mars = Mars(1, 1)
        assertFalse(mars.isOnPlanet(Coordinate(-1, 0)))
        assertFalse(mars.isOnPlanet(Coordinate(0, -1)))
        assertFalse(mars.isOnPlanet(Coordinate(2, 0)))
        assertFalse(mars.isOnPlanet(Coordinate(0, 2)))
    }

    @Test
    fun `should return true when a coordinate has no scent`() {
        val mars = Mars(1, 1)
        mars.addScent(Coordinate(0, 1))
        assertTrue(mars.hasNoScent(Coordinate(0, 0)))
        assertFalse(mars.hasNoScent(Coordinate(0, 1)))
        assertTrue(mars.hasNoScent(Coordinate(1, 0)))
        assertTrue(mars.hasNoScent(Coordinate(1, 1)))
    }
}