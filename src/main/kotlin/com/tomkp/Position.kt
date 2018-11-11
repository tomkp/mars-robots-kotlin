package com.tomkp

import com.tomkp.Orientation.*

enum class Orientation { N, E, S, W }

data class Coordinate(val x: Int, val y: Int) {
    override fun toString(): String = "$x $y"
}

data class Position(val coordinate: Coordinate, val orientation: Orientation) {

    fun forward(): Position {
        val newCoordinate = when (orientation) {
            N -> Coordinate(coordinate.x, coordinate.y + 1)
            E -> Coordinate(coordinate.x + 1, coordinate.y)
            S -> Coordinate(coordinate.x, coordinate.y -1)
            W -> Coordinate(coordinate.x - 1, coordinate.y)
        }
        return copy(coordinate = newCoordinate)
    }

    fun rotateAntiClockwise(): Position {
        val newOrientation = when (orientation) {
            N -> W
            E -> N
            S -> E
            W -> S
        }
        return copy(orientation = newOrientation)
    }

    fun rotateClockwise(): Position {
        val newOrientation = when (orientation) {
            N -> E
            E -> S
            S -> W
            W -> N
        }
        return copy(orientation = newOrientation)
    }

    override fun toString(): String {
        return "$coordinate $orientation"
    }

    companion object {
        fun create(position: String): Position {
            val tokens = position.split(" ")
            val coordinate = Coordinate(tokens[0].toInt(), tokens[1].toInt())
            val orientation = Orientation.valueOf(tokens[2])
            return Position(coordinate, orientation)
        }
    }
}