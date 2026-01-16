package pnemonic.bug_squash.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import pnemonic.bug_squash.model.Ant
import pnemonic.bug_squash.model.Bee
import pnemonic.bug_squash.model.Board
import pnemonic.bug_squash.model.Bug
import pnemonic.bug_squash.model.Butterfly
import pnemonic.bug_squash.model.Caterpillar
import pnemonic.bug_squash.model.Cockroach
import pnemonic.bug_squash.model.Fly
import pnemonic.bug_squash.model.Ladybug
import pnemonic.bug_squash.model.Mosquito
import pnemonic.bug_squash.model.Moth
import pnemonic.bug_squash.model.Scorpion
import pnemonic.bug_squash.model.Snail
import pnemonic.bug_squash.model.Spider
import pnemonic.bug_squash.model.Swarm
import pnemonic.bug_squash.model.Termite
import pnemonic.bug_squash.model.Wasp
import pnemonic.bug_squash.model.Worm

@Composable
fun BoardView(
    board: Board,
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
        Column {
            LivesView(board.lives)
            ScoreView(board.score)
            LevelView(board.level)
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 400, heightDp = 600)
private fun Preview() {
    val bugs = listOf<Bug>(
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
    val dt = 25.dp.toPx()
    var t = 0f
    for (bug in bugs) {
        bug.moveTo(t, 200 + t)
        t += dt
    }
    val board = Board(swarm = Swarm(bugs))
    val onSize: OnSizeCallback = {}
    val onBugSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}

    MaterialTheme {
        BoardView(board, onSize, onBugSize, onTap, onDead)
    }
}