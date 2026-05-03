package pnemonic.bug_bash.view.board

import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.BonusCallback
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.bug.BugCallback
import pnemonic.bug_bash.model.tool.ToolCallback
import pnemonic.compose.OnSizeCallback
import pnemonic.compose.OnTapCallback

interface BoardState {
    val board: Board
    val gameState: GameState
    val onSize: OnSizeCallback
    val onTap: OnTapCallback
    val onBugSize: BugCallback
    val onBugTap: BugCallback
    val onHomeClick: VoidCallback
    val isPaused: Boolean
    val onPauseChange: BooleanCallback
    val isSoundEnabled: Boolean
    val onSoundChange: BooleanCallback
    val isMusicEnabled: Boolean
    val onMusicChange: BooleanCallback
    val onBonusClick: BonusCallback
    val onToolUse: ToolCallback
}