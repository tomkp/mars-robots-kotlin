package com.tomkp

data class Mars(val width: Int, val height: Int) {

    private val scents = HashSet<Coordinate>()

    fun contains(coordinate: Coordinate): Boolean = coordinate.x in 0..width && coordinate.y in 0..height

    fun addScent(coordinate: Coordinate) {
        println("add scent at $coordinate")
        scents.add(coordinate)
    }

    fun hasScent(coordinate: Coordinate): Boolean = scents.contains(coordinate)

}