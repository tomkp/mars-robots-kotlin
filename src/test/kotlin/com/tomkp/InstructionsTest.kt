package com.tomkp

import com.tomkp.Instruction.*
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class InstructionsTest {

    @Test
    fun constructFromValidString() {
        assertEquals(listOf(L), Instructions("L").instructions)
        assertEquals(listOf(R), Instructions("R").instructions)
        assertEquals(listOf(F), Instructions("F").instructions)
        assertEquals(listOf(F, F), Instructions("FF").instructions)
        assertEquals(listOf(F, F), Instructions("F F").instructions)
        assertEquals(listOf(L, R, F), Instructions("LRF").instructions)
        assertEquals(listOf(L, R, F, L), Instructions("LRFL").instructions)
        assertEquals(listOf(L, R, F, F, L), Instructions("L R F F L").instructions)
    }

    @Test
    fun throwExceptionOnInvalidInstructions() {
        assertFailsWith(IllegalArgumentException::class) {
            Instructions("X")
        }
        assertFailsWith(IllegalArgumentException::class) {
            Instructions("LX")
        }
    }
}