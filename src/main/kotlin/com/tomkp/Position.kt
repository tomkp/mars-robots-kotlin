package com.tomkp

data class Position(var coordinate: Coordinate, val orientation: Orientation) {

    fun forward(): Position {
        val newCoordinate = when (orientation) {
            Orientation.N -> Coordinate(coordinate.x, coordinate.y + 1)
            Orientation.E -> Coordinate(coordinate.x + 1, coordinate.y)
            Orientation.S -> Coordinate(coordinate.x, coordinate.y -1)
            Orientation.W -> Coordinate(coordinate.x - 1, coordinate.y)
        }
        return Position(newCoordinate, orientation)
    }

    fun rotateAntiClockwise(): Position {
        val newOrientation = when (orientation) {
            Orientation.N -> Orientation.W
            Orientation.E -> Orientation.N
            Orientation.S -> Orientation.E
            Orientation.W -> Orientation.S
        }
        return Position(coordinate, newOrientation)
    }

    fun rotateClockwise(): Position {
        val newOrientation = when (orientation) {
            Orientation.N -> Orientation.E
            Orientation.E -> Orientation.S
            Orientation.S -> Orientation.W
            Orientation.W -> Orientation.N
        }
        return Position(coordinate, newOrientation)
    }
}