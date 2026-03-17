package pnemonic.bug_bash.view.board

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
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
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
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
    val state = viewModel.state.collectAsState()

    BoardView(
        board = board.value,
        state = state.value,
        onSize = viewModel::onBoardSize,
        onTap = viewModel::onTap,
        onBugSize = viewModel::onBugSize,
        onBugTap = viewModel::onBugTap,
        onHomeClick = { navController.navigateUp() },
        isPaused = viewModel.isPaused,
        onPauseChange = viewModel::onPauseChange,
        isSoundEnabled = viewModel.isSoundEnabled,
        onSoundChange = viewModel::onSoundChange,
        isMusicEnabled = viewModel.isMusicEnabled,
        onMusicChange = viewModel::onMusicChange,
        onBonusClick = viewModel::onBonusClick,
        onToolUse = viewModel::onToolUse,
    )

    DisposableEffect(lifecycleOwner) {
        viewModel.observe(lifecycleOwner)

        onDispose {
            viewModel.onDispose(lifecycleOwner)
        }
    }
}

@Composable
fun BoardView(
    board: Board,
    state: GameState,
    onSize: OnSizeCallback,
    onTap: OnTapCallback,
    onBugSize: BugCallback,
    onBugTap: BugCallback,
    onHomeClick: VoidCallback,
    isPaused: Boolean = false,
    onPauseChange: BooleanCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback,
    onBonusClick: BonusCallback,
    onToolUse: ToolCallback,
) {
    SceneView(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged(onSize)
            .pointerInput(board) {
                detectTapGestures(onTap = onTap)
            },
        scene = board.scene
    ) {
        ToolsBelow(board, onToolUse)
        SwarmView(board, onBugSize, onBugTap)
        ToolsAbove(board, onToolUse)
        BugScores(board)
        Column(
            modifier = Modifier.fillMaxWidth()
                .safeContentPadding()
                .padding(8.dp),
            horizontalAlignment = AbsoluteAlignment.Left
        ) {
            if (state !== GameState.FINISHED) {
                ActionsPanel(
                    modifier = Modifier.align(AbsoluteAlignment.Right),
                    onHomeClick = onHomeClick,
                    isPaused = isPaused,
                    onPauseChange = onPauseChange,
                    isSoundEnabled = isSoundEnabled,
                    onSoundChange = onSoundChange,
                    isMusicEnabled = isMusicEnabled,
                    onMusicChange = onMusicChange
                )
                Spacer(modifier = Modifier.height(spacingV))
            }
            LivesView(lives = board.lives)
            Spacer(modifier = Modifier.height(spacingV))
            LevelView(level = board.level, count = board.swarm.size)
            Spacer(modifier = Modifier.height(spacingV))
            ScoreView(score = board.score)
            Spacer(modifier = Modifier.height(spacingV))
            BonusesView(bonuses = board.bonuses, onClick = onBonusClick)
        }
        StateScreen(state, onHomeClick)
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

    MaterialTheme {
        BoardView(
            board,
            GameState.STARTED,
            onSize = {},
            onTap = {},
            onBugSize = {},
            onBugTap = {},
            onHomeClick = {},
            isPaused = false,
            onPauseChange = {},
            isSoundEnabled = true,
            onSoundChange = {},
            isMusicEnabled = true,
            onMusicChange = {},
            onBonusClick = {},
            onToolUse = {},
        )
    }
}