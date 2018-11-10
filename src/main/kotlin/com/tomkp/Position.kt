package com.tomkp

import com.tomkp.Orientation.*

data class Position(val coordinate: Coordinate, val orientation: Orientation) {

    fun forward(): Position {
        val newCoordinate = when (orientation) {
            N -> Coordinate(coordinate.x, coordinate.y + 1)
            E -> Coordinate(coordinate.x + 1, coordinate.y)
            S -> Coordinate(coordinate.x, coordinate.y -1)
            W -> Coordinate(coordinate.x - 1, coordinate.y)
        }
        return Position(newCoordinate, orientation)
    }

    fun rotateAntiClockwise(): Position {
        val newOrientation = when (orientation) {
            N -> W
            E -> N
            S -> E
            W -> S
        }
        return Position(coordinate, newOrientation)
    }

    fun rotateClockwise(): Position {
        val newOrientation = when (orientation) {
            N -> E
            E -> S
            S -> W
            W -> N
        }
        return Position(coordinate, newOrientation)
    }
}