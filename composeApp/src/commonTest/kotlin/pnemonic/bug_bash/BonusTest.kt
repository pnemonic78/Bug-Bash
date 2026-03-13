package pnemonic.bug_bash

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import kotlinx.coroutines.test.runTest
import pnemonic.bug_bash.engine.BonusEngine
import pnemonic.bug_bash.engine.EngineCallback
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.bug_bash.model.tool.ExtraLife
import pnemonic.bug_bash.model.tool.GluePaper
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class BonusTest {

    private val callback = object : EngineCallback {
        override fun touch(bug: Bug) = Unit
        override suspend fun bash(bug: Bug) = Unit
        override suspend fun notifyFeedback(feedback: Feedback) = Unit
    }

    @Test
    fun lives() = runTest {
        val engine = BonusEngine(callback, this)
        var board = Board(bonuses = listOf(Bonus.Life()))

        assertEquals(0L, board.score)
        assertFalse(board.bonuses.isEmpty())

        board = board.copy(score = board.score + 50L)
        board = engine.process(board)
        assertEquals(50L, board.score)
        var bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertEquals(50L, bonus.progress)
        assertTrue(bonus is Bonus.Life)
        // Bonus not ready to be clicked.
        engine.onClick(bonus)
        board = engine.process(board)
        bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertTrue(bonus is Bonus.Life)

        board = board.copy(score = board.score + 50L)
        board = engine.process(board)
        assertEquals(100L, board.score)
        bonus = board.bonuses.firstOrNull()
        assertNotNull(bonus)
        assertEquals(100L, bonus.progress)
        assertTrue(bonus is Bonus.Life)
        // Bonus is ready to be clicked.
        engine.onClick(bonus)
        board = engine.process(board)
        val tool = board.tool
        assertNotNull(tool)
        assertTrue(tool is ExtraLife)
        val livesBefore = board.lives
        engine.onUse(tool)
        board = engine.process(board)
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
    fun next() = runTest {
        val engine = BonusEngine(callback, this)
        var board = Board()

        assertEquals(0L, board.score)
        assertTrue(board.bonuses.isEmpty())

        board = board.copy(score = board.score + 1)
        board = engine.process(board)

        assertEquals(9, board.bonuses.size)
        assertTrue(board.bonuses[0] is Bonus.GluePaper)
        assertTrue(board.bonuses[1] is Bonus.Shoe)
        assertTrue(board.bonuses[2] is Bonus.Spray)
        assertTrue(board.bonuses[3] is Bonus.Swatter)
        assertTrue(board.bonuses[4] is Bonus.Zapper)
        assertTrue(board.bonuses[5] is Bonus.Life)
        assertTrue(board.bonuses[6] is Bonus.Cupcake)
        assertTrue(board.bonuses[7] is Bonus.Flower)
        assertTrue(board.bonuses[8] is Bonus.Score)

        var bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.GluePaper)
        assertEquals(1L, bonus.progress)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Shoe)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        assertTrue(bonus is Bonus.Spray)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Swatter)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Zapper)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Life)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Cupcake)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Flower)

        board = board.copy(score = board.score + bonus.score)
        board = engine.process(board)
        assertEquals(bonus.score, bonus.progress)
        bonus = board.bonuses.first { !it.isActive }
        println("bonus=$bonus")
        assertTrue(bonus is Bonus.Score)
    }

    @Test
    fun hit() = runTest {
        val boardSize = Size(1080.0f, 2400.0f)
        val bonus = Bonus.GluePaper()
        val tool = GluePaper(bonus)
        val bounds = Rect(498.0f, 1310.4f, 808.0f, 1463.5f)
        tool.setSize(bounds.width, bounds.height, boardSize)
        tool.moveTo(bounds.left, bounds.top, boardSize)

        val bug = Centipede()
        bug.setSize(147.0f, 538.0f)
        bug.moveTo(806.8679f, 1114.5066f)

        assertTrue(tool.isHit(bug))
    }
}