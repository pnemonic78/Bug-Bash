package pnemonic.bug_bash

import pnemonic.add
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.remove
import kotlin.math.max
import kotlin.math.min

class BonusEngine {
    private val touched = mutableListOf<Bonus>()
    private var boardScore = 0L
    private var bonusNext: Bonus? = null

    fun onClick(bonus: Bonus) {
        if (bonus.isActive) {
            touched.add(bonus)
        }
    }


    fun apply(board: Board): Board {
        var board = board
        // Apply bonuses to the board that were clicked by player.
        for (bonus in touched) {
            // remove the bonus from the list
            // apply the bonus to the board
            board = apply(board, bonus)
        }
        touched.clear()

        // Add potential bonus.
        val scoreBefore = boardScore
        val score = board.score
        val scoreDelta = score - scoreBefore
        if (scoreDelta == 0L) return board
        boardScore = score

        var bonuses = board.bonuses
        var modified = false
        var bonus = bonusNext
        if (bonus == null) {
            bonus = bonuses.firstOrNull { b -> b.progress < b.score }
                ?: next(bonuses, bonus) ?: return board
            bonusNext = bonus
            bonuses = bonuses.add(bonus)
            modified = true
        }
        val progressDelta = min(scoreDelta, max(0, bonus.score - bonus.progress))
        bonus.progress += progressDelta
        val progressNext = scoreDelta - progressDelta
        if (bonus.progress >= bonus.score) {
            bonus = bonuses.firstOrNull { b -> b.progress < b.score } ?: next(bonuses, bonus)
            if (bonus != null) {
                bonus.progress += progressNext
                bonusNext = bonus
                bonuses = bonuses.add(bonus)
                modified = true
            }
        }

        return if (modified) {
            board.copy(bonuses = bonuses)
        } else {
            board
        }
    }

    private fun apply(board: Board, bonus: Bonus): Board {
        return when (bonus) {
            Bonus.None -> board
            is Bonus.Life -> apply(board, bonus)
            is Bonus.Score -> apply(board, bonus)
            else -> board
        }
    }

    private fun apply(board: Board, bonus: Bonus.Life): Board {
        val lives = board.lives + 1
        if (lives >= Board.MAX_LIVES) return board

        val bonuses = board.bonuses.remove(bonus)
        return board.copy(bonuses = bonuses, lives = lives)
    }

    private fun apply(board: Board, bonus: Bonus.Score): Board {
        val score = board.score + bonus.hits
        boardScore = score

        val bonuses = board.bonuses.remove(bonus)
        return board.copy(bonuses = bonuses, score = score)
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
    private fun next(bonuses: List<Bonus>, bonus: Bonus?): Bonus? {
        return when (bonus) {
            null -> {
                val first = bonuses.firstOrNull { it is Bonus.GluePaper }
                if (first != null) return null
                Bonus.GluePaper()
            }

            is Bonus.Cupcake -> {
                val first = bonuses.firstOrNull { it is Bonus.Flower }
                if (first != null) return null
                Bonus.Flower()
            }

            is Bonus.Flower -> {
                val first = bonuses.firstOrNull { it is Bonus.Life }
                if (first != null) return null
                Bonus.Life()
            }

            is Bonus.GluePaper -> {
                val first = bonuses.firstOrNull { it is Bonus.Shoe }
                if (first != null) return null
                Bonus.Shoe()
            }

            is Bonus.Insecticide -> {
                val first = bonuses.firstOrNull { it is Bonus.Score }
                if (first != null) return null
                Bonus.Score()
            }

            is Bonus.Life -> {
                val first = bonuses.firstOrNull { it is Bonus.Insecticide }
                if (first != null) return null
                Bonus.Insecticide()
            }

            is Bonus.Score -> {
                val first = bonuses.firstOrNull { it is Bonus.Swatter }
                if (first != null) return null
                Bonus.Swatter()
            }

            is Bonus.Shoe -> {
                val first = bonuses.firstOrNull { it is Bonus.Cupcake }
                if (first != null) return null
                Bonus.Cupcake()
            }

            is Bonus.Swatter -> {
                val first = bonuses.firstOrNull { it is Bonus.Zapper }
                if (first != null) return null
                Bonus.Zapper()
            }

            is Bonus.Zapper -> {
                val first = bonuses.firstOrNull { it is Bonus.Life }
                if (first != null) return null
                Bonus.Life()
            }

            else -> null
        }
    }
}