package com.tomkp

data class Mars(val width: Int, val height: Int) {

    private val scents = HashSet<Coordinate>()

    fun isOnPlanet(coordinate: Coordinate): Boolean = coordinate.x in 0..width && coordinate.y in 0..height

    fun addScent(coordinate: Coordinate) = scents.add(coordinate)

    fun hasNoScent(coordinate: Coordinate): Boolean = !scents.contains(coordinate)

    companion object {
        fun create(dimensions: String): Mars {
            val tokens = dimensions.split(" ")
            return Mars(tokens[0].toInt(), tokens[1].toInt())
        }
    }
}