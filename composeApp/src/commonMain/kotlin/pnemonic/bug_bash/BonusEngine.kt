package pnemonic.bug_bash

import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.remove

class BonusEngine {
    private val touched = mutableListOf<Bonus>()

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

//        //TODO Add potential bonus.
//        var bonuses = board.bonuses
//        val score = board.score
//        val added = mutableListOf<Bonus>()
//        if (score >= 1) {
//            var bonus = bonuses.firstOrNull { it is Bonus.Life }
//            if (bonus == null) {
//                bonus = Bonus.Life()
//                added.add(bonus)
//            }
//            bonus.progress = score
//        }
//
//        return if (added.isNotEmpty()) {
//            bonuses = bonuses.addAll(added)
//            board.copy(bonuses = bonuses)
//        } else {
//            board
//        }

        return board
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
        val bonuses = board.bonuses.remove(bonus)
        return board.copy(bonuses = bonuses, score = score)
    }
}