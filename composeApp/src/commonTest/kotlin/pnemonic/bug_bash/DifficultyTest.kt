package pnemonic.bug_bash

import pnemonic.bug_bash.model.Difficulty
import pnemonic.bug_bash.model.Difficulty.Companion.times
import kotlin.test.Test
import kotlin.test.assertEquals

class DifficultyTest {
    @Test
    fun multiply() {
        assertEquals(10, 10 * Difficulty.Easy)
        assertEquals(15, 10 * Difficulty.Medium)
        assertEquals(20, 10 * Difficulty.Hard)
    }
}