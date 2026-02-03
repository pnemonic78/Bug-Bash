package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
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
import pnemonic.bug_bash.control.GameViewModel
import pnemonic.bug_bash.model.Ant
import pnemonic.bug_bash.model.Bee
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Butterfly
import pnemonic.bug_bash.model.Caterpillar
import pnemonic.bug_bash.model.Cockroach
import pnemonic.bug_bash.model.Fly
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.Ladybug
import pnemonic.bug_bash.model.Mosquito
import pnemonic.bug_bash.model.Moth
import pnemonic.bug_bash.model.Scorpion
import pnemonic.bug_bash.model.Snail
import pnemonic.bug_bash.model.Spider
import pnemonic.bug_bash.model.Swarm
import pnemonic.bug_bash.model.Termite
import pnemonic.bug_bash.model.Wasp
import pnemonic.bug_bash.model.Worm
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
        onTap = viewModel::onTap,
        onDead = viewModel::onDead,
        onHomeClick = { navController.navigateUp() },
        isSoundEnabled = viewModel.isSoundEnabled,
        onSoundChange = viewModel::onSoundChange,
        isMusicEnabled = viewModel.isMusicEnabled,
        onMusicChange = viewModel::onMusicChange,
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
    onTap: BugCallback,
    onDead: BugCallback,
    onHomeClick: VoidCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    SceneView(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged(onSize),
        scene = board.scene
    ) {
        SwarmView(board.swarm, onBugSize, onTap, onDead)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                LivesView(
                    modifier = Modifier.align(Alignment.TopStart),
                    lives = board.lives,
                    liveTotal = Board.LIVES
                )
                SettingsPanel(
                    modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
                    onHomeClick = onHomeClick,
                    isSoundEnabled = isSoundEnabled,
                    onSoundChange = onSoundChange,
                    isMusicEnabled = isMusicEnabled,
                    onMusicChange = onMusicChange
                )
            }
            ScoreView(board.score)
            LevelView(board.level)
        }
        StateView(state)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 400, heightDp = 600)
private fun Preview() {
    val bugs = listOf(
        Ant(),
        Bee(),
        Butterfly(),
        Caterpillar(),
        Cockroach(),
        Fly(),
        Ladybug(),
        Mosquito(),
        Moth(),
        Scorpion(),
        Snail(),
        Spider(),
        Termite(),
        Wasp(),
        Worm()
    )
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
    val board = Board(swarm = Swarm(bugs))
    val onSize: OnSizeCallback = {}
    val onBugSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    val onHomeClick: VoidCallback = {}
    val onSoundChange: BooleanCallback = {}
    val onMusicChange: BooleanCallback = {}

    MaterialTheme {
        BoardView(
            board,
            GameState.STARTED,
            onSize,
            onBugSize,
            onTap,
            onDead,
            onHomeClick,
            isSoundEnabled = true,
            onSoundChange,
            isMusicEnabled = true,
            onMusicChange
        )
    }
}