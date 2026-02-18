package pnemonic.bug_bash.view.board

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Swarm

@Composable
fun BugScores(board: Board) {
    BugScores(board.swarm, board.size)
}

@Composable
fun BugScores(swarm: Swarm, boardSize: Size) {
    BugScores(swarm.bugs, boardSize)
}

@Composable
fun BugScores(bugs: List<Bug>, boardSize: Size) {
    for (bug in bugs) {
        BugScore(bug, boardSize)
    }
}

@Composable
fun BugScore(bug: Bug, boardSize: Size) {
    if (bug.isSquashed) {
        Score(bug, boardSize)
    }
}
