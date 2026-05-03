package pnemonic.bug_bash.view.board

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.engine.BugFactory
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.BonusCallback
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.bug.BugCallback
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.model.tool.ToolCallback
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.theme.AppTheme
import pnemonic.compose.OnSizeCallback
import pnemonic.compose.OnTapCallback
import pnemonic.compose.toPx

private val spacingV = 8.dp

@Composable
fun BoardScreen(navController: NavController) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    //FIXME for JVM val viewModel = viewModel<GameViewModel>()
    val viewModel = viewModel { GameViewModel() }
    val board = viewModel.board.collectAsState()
    val gameState = viewModel.state.collectAsState()
    val state = object : BoardState {
        override val board = board.value
        override val gameState = gameState.value
        override val onSize = viewModel::onBoardSize
        override val onTap = viewModel::onTap
        override val onBugSize = viewModel::onBugSize
        override val onBugTap = viewModel::onBugTap
        override val onHomeClick: VoidCallback = { navController.navigateUp() }
        override val isPaused = gameState.value.isPaused
        override val onPauseChange = viewModel::onPauseChange
        override val isSoundEnabled = viewModel.isSoundEnabled
        override val onSoundChange = viewModel::onSoundChange
        override val isMusicEnabled = viewModel.isMusicEnabled
        override val onMusicChange = viewModel::onMusicChange
        override val onBonusClick = viewModel::onBonusClick
        override val onToolUse = viewModel::onToolUse
    }

    BoardView(state)

    DisposableEffect(lifecycleOwner) {
        viewModel.observe(lifecycleOwner)

        onDispose {
            viewModel.onDispose(lifecycleOwner)
        }
    }
}

@Composable
fun BoardView(state: BoardState) {
    val board = state.board
    val gameState = state.gameState

    SceneView(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged(state.onSize)
            .pointerInput(board) {
                detectTapGestures(onTap = state.onTap)
            },
        scene = board.scene
    ) {
        ToolsBelow(board, state.onToolUse)
        SwarmView(board, state.onBugSize, state.onBugTap)
        ToolsAbove(board, state.onToolUse)
        Column(
            modifier = Modifier.fillMaxWidth()
                .safeContentPadding()
                .padding(8.dp),
            horizontalAlignment = AbsoluteAlignment.Left
        ) {
            if (gameState !== GameState.FINISHED) {
                ActionsPanel(
                    modifier = Modifier.align(AbsoluteAlignment.Right),
                    onHomeClick = state.onHomeClick,
                    isPaused = state.isPaused,
                    onPauseChange = state.onPauseChange,
                    isSoundEnabled = state.isSoundEnabled,
                    onSoundChange = state.onSoundChange,
                    isMusicEnabled = state.isMusicEnabled,
                    onMusicChange = state.onMusicChange
                )
                Spacer(modifier = Modifier.height(spacingV))
            }
            LivesView(lives = board.lives)
            Spacer(modifier = Modifier.height(spacingV))
            LevelView(level = board.level, count = board.swarm.size)
            Spacer(modifier = Modifier.height(spacingV))
            ScoreView(score = board.score)
            Spacer(modifier = Modifier.height(spacingV))
            BonusesView(bonuses = board.bonuses, onClick = state.onBonusClick)
        }
        StateScreen(gameState, board.score, state.onHomeClick)
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp,
    locale = "he"
)
private fun Preview() {
    val bugs = BugFactory.allBugs
    val bonuses = listOf(Bonus.None, Bonus.Flower(1), Bonus.Life(2), Bonus.Score(3), Bonus.Shoe(4))
    val dx = 20.dp.toPx()
    val dy = 40.dp.toPx()
    var x = dx
    var y = dy
    for (bug in bugs) {
        bug.moveTo(x, y)
        bug.setDestination(x, 0f)
        x += dx
        y += dy
    }
    val board = Board(swarm = Swarm(bugs), bonuses = bonuses)
    val state = object : BoardState {
        override val board = board
        override val gameState = GameState.STARTED
        override val onSize: OnSizeCallback = {}
        override val onTap: OnTapCallback = {}
        override val onBugSize: BugCallback = {}
        override val onBugTap: BugCallback = {}
        override val onHomeClick = {}
        override val isPaused = false
        override val onPauseChange: BooleanCallback = {}
        override val isSoundEnabled = true
        override val onSoundChange: BooleanCallback = {}
        override val isMusicEnabled = true
        override val onMusicChange: BooleanCallback = {}
        override val onBonusClick: BonusCallback = {}
        override val onToolUse: ToolCallback = {}
    }

    AppTheme {
        BoardView(state)
    }
}