package pnemonic.bug_bash.view.board

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import pnemonic.bug_bash.model.bug.Bug

@Composable
fun BugScore(bug: Bug, boardSize: Size) {
    if (bug.isSquashed) {
        Score(bug, boardSize)
    }
}
