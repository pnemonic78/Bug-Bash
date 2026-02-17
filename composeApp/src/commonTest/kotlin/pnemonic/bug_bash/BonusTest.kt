package pnemonic.bug_bash

import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class BonusTest {
    @Test
    fun lives() {
        val engine = BonusEngine()
        var board = Board(bonuses = listOf(Bonus.Life()))

        assertEquals(0L, board.score)
        assertFalse(board.bonuses.isEmpty())

        board = board.copy(score = board.score + 50L)
        board = engine.apply(board)
        assertEquals(50L, board.score)
        var bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertEquals(50L, bonus.progress)
        assertTrue(bonus is Bonus.Life)
        // Bonus not ready to be clicked.
        engine.onClick(bonus)
        board = engine.apply(board)
        bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertTrue(bonus is Bonus.Life)

        board = board.copy(score = board.score + 50L)
        board = engine.apply(board)
        assertEquals(100L, board.score)
        bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertEquals(100L, bonus.progress)
        assertTrue(bonus is Bonus.Life)
        // Bonus is ready to be clicked.
        val livesBefore = board.lives
        engine.onClick(bonus)
        board = engine.apply(board)
        val livesAfter = board.lives
        assertEquals(livesBefore + 1, livesAfter)
    }

    /**
     * Get the next bonus.
     *
     * <ol>
     *   <li>GluePaper</li>
     *   <li>Shoe</li>
     *   <li>Cupcake</li>
     *   <li>Flower</li>
     *   <li>Life</li>
     *   <li>Insecticide</li>
     *   <li>Score</li>
     *   <li>Swatter</li>
     *   <li>Zapper</li>
     * </ol>
     */
    @Test
    fun next() {
        val engine = BonusEngine()
        var board = Board()

        assertEquals(0L, board.score)
        assertTrue(board.bonuses.isEmpty())

        board = board.copy(score = board.score + 1)
        board = engine.apply(board)
        var bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.GluePaper)
        assertEquals(1L, bonus.progress)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Shoe)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Cupcake)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Flower)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Life)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Insecticide)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Score)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Swatter)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Zapper)

        board = board.copy(score = board.score + bonus.score)
        board = engine.apply(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.lastOrNull()
        assertTrue(bonus is Bonus.Zapper)
    }
}