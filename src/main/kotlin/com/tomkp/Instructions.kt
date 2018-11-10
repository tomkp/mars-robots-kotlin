package com.tomkp

import com.tomkp.Instruction.*

enum class Instruction { L, R, F }

data class Instructions(val instructions: List<Instruction>) {

    constructor(vararg instructions: Instruction) : this(instructions.toList())

    constructor(instructions: String) : this(instructions.replace(" ", "").toCharArray().map { valueOf(it.toString()) })
}
