package com.tomkp

enum class Orientation(private val arrow: String) {

    N("￪"),
    E("￫"),
    S("￬"),
    W("￩");

    fun render(): String = arrow

}