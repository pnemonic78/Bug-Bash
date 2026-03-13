package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.engine.EngineCallback
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import kotlin.math.max
import kotlin.math.min

open class BashTool(bonus: Bonus) : BonusTool(bonus) {
    suspend fun bash(board: Board, callback: EngineCallback): Board {
        var lives = board.lives
        var score = board.score

        for (bug in board.swarm) {
            if ((hits > 0) && !bug.isSquashed && isHit(bug)) {
                val bugHits = min(bug.hits.toLong(), hits)
                (1..bugHits).forEach { _ ->
                    bug.hit()
                }
                if (bug.isSquashed) {
                    score += bug.score
                    if (score < 0) {
                        lives--
                    }
                    score = max(0, score)
                    callback.bash(bug)
                }

                hits -= bugHits
            }
        }

        return board.copy(score = score, lives = lives)
    }
}