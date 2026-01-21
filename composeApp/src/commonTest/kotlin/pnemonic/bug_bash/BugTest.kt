package pnemonic.bug_bash

import androidx.compose.ui.geometry.Rect
import pnemonic.bug_bash.model.Ant
import pnemonic.bug_bash.model.contains
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BugTest {

    @Test
    fun `rect contains`() {
        val board = Rect(0f, 0f, 1000f, 1000f)

        val bug = Ant()
        bug.setSize(100f, 100f)

        // top-left in board
        bug.moveTo(0f, 0f)
        assertTrue(board.contains(bug))

        // bottom-right out of board
        bug.moveTo(1000f, 1000f)
        assertFalse(board.contains(bug))

        // top-left corner of board
        bug.moveTo(-50f, -50f)
        assertTrue(board.contains(bug))

        // top-middle side of board
        bug.moveTo(500f, -50f)
        assertTrue(board.contains(bug))

        // top=right corner of board
        bug.moveTo(950f, -50f)
        assertTrue(board.contains(bug))

        // middle-left side of board
        bug.moveTo(-50f, 500f)
        assertTrue(board.contains(bug))

        // middle of board
        bug.moveTo(500f, 500f)
        assertTrue(board.contains(bug))

        // middle-right side of board
        bug.moveTo(950f, 500f)
        assertTrue(board.contains(bug))

        // bottom-left corner of board
        bug.moveTo(-50f, 950f)
        assertTrue(board.contains(bug))

        // bottom-middle of board
        bug.moveTo(500f, 950f)
        assertTrue(board.contains(bug))

        // bottom-right corner of board
        bug.moveTo(950f, 950f)
        assertTrue(board.contains(bug))
    }
}