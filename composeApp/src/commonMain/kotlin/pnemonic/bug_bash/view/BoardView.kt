package pnemonic.bug_bash.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
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

@Composable
fun BoardView(
    board: Board,
    state: GameState,
    onSize: OnSizeCallback,
    onBugSize: BugCallback,
    onTap: BugCallback,
    onDead: BugCallback
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
            LivesView(board.lives, Board.LIVES)
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
    val dt = 30.dp.toPx()
    val h = 700.dp.toPx()
    var t = 0f
    for (bug in bugs) {
        bug.moveTo(t, t)
        bug.setDestination(t, h)
        t += dt
    }
    val board = Board(swarm = Swarm(bugs))
    val onSize: OnSizeCallback = {}
    val onBugSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}

    MaterialTheme {
        BoardView(board, GameState.STARTED, onSize, onBugSize, onTap, onDead)
    }
}