package pnemonic.bug_bash.view.board

import androidx.compose.runtime.Composable
import pnemonic.bug_bash.model.Board

@Composable
fun ToolsView(board: Board, onToolSize: ToolCallback, onToolTap: ToolCallback) {
    val tool = board.tool ?: return
    ToolView(tool, onToolSize, onToolTap, board.size)
}
