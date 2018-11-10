package com.tomkp

import com.tomkp.Instruction.*

data class Instructions(val instructions: List<Instruction>) {
    constructor(vararg instructions: Instruction) : this(instructions.toList())
    constructor(instructions: String) : this(instructions.replace(" ", "").toCharArray().map { valueOf(it.toString()) })
}
