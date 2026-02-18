package pnemonic.bug_bash.view.board

import androidx.compose.runtime.Composable
import pnemonic.bug_bash.model.Board

@Composable
fun ToolsAbove(board: Board, onToolUse: ToolCallback) {
    // Only use 1 tool.
    val tool = board.tool ?: return
    ToolAbove(tool, onToolUse, board.size)
}

@Composable
fun ToolsBelow(board: Board, onToolUse: ToolCallback) {
    // Only use 1 tool.
    val tool = board.tool ?: return
    ToolBelow(tool, onToolUse, board.size)
}
