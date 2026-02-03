package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.model.Bug
import pnemonic.bug_bash.model.Swarm
import pnemonic.bug_bash.view.toPx

@Composable
fun SwarmView(swarm: Swarm, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    SwarmView(swarm.bugs, onSize, onTap, onDead)
}

@Composable
fun SwarmView(bugs: List<Bug>, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    for (bug in bugs) {
        BugView(bug, onSize, onTap, onDead)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 700, heightDp = 700)
private fun Preview() {
    val bugs = BugFactory.allBugs
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
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SwarmView(Swarm(bugs), onSize, onTap, onDead)
        }
    }
}