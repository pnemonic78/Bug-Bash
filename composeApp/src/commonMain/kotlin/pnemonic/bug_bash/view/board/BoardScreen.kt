package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.view.OnSizeCallback
import pnemonic.bug_bash.view.toPx

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
        onSize = viewModel::onSize,
        onBugSize = viewModel::onBugSize,
        onBugTap = viewModel::onTap,
        onHomeClick = { navController.navigateUp() },
        isPaused = viewModel.isPaused,
        onPauseChange = viewModel::onPauseChange,
        isSoundEnabled = viewModel.isSoundEnabled,
        onSoundChange = viewModel::onSoundChange,
        isMusicEnabled = viewModel.isMusicEnabled,
        onMusicChange = viewModel::onMusicChange,
        onBonusClick = viewModel::onBonusClick,
        onToolSize = viewModel::onToolSize,
        onToolTap = viewModel::onToolTap,
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
    onToolSize: ToolCallback,
    onToolTap: ToolCallback,
) {
    SceneView(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged(onSize),
        scene = board.scene
    ) {
        SwarmView(board, onBugSize, onBugTap)
        ToolsView(board, onToolSize, onToolTap)
        Box(modifier = Modifier.fillMaxWidth().systemBarsPadding()) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(8.dp)) {
                LivesView(lives = board.lives)
                Spacer(modifier = Modifier.height(8.dp))
                ScoreView(score = board.score)
                Spacer(modifier = Modifier.height(8.dp))
                LevelView(level = board.level)
                Spacer(modifier = Modifier.height(8.dp))
                BonusesView(bonuses = board.bonuses, onClick = onBonusClick)
            }
            SettingsPanel(
                modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
                onHomeClick = onHomeClick,
                isPaused = isPaused,
                onPauseChange = onPauseChange,
                isSoundEnabled = isSoundEnabled,
                onSoundChange = onSoundChange,
                isMusicEnabled = isMusicEnabled,
                onMusicChange = onMusicChange
            )
        }
        StateView(state)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 400, heightDp = 600)
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
            onToolSize = {},
            onToolTap = {},
        )
    }
}