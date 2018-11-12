package com.tomkp

import com.tomkp.Orientation.*

enum class Orientation {

    N, E, S, W;

    fun rotateAntiClockwise(): Orientation = when (this) {
        N -> W
        E -> N
        S -> E
        W -> S
    }

    fun rotateClockwise(): Orientation = when (this) {
        N -> E
        E -> S
        S -> W
        W -> N
    }
}

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
        return copy(orientation = orientation.rotateAntiClockwise())
    }

    fun rotateClockwise(): Position {
        return copy(orientation = orientation.rotateClockwise())
    }

    override fun toString(): String {
        return "$coordinate $orientation"
    }
}