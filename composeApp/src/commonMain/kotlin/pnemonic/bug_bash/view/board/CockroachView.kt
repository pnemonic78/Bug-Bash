package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Cockroach
import pnemonic.bug_bash.drawable.Cockroach as CockroachImage

@Composable
fun CockroachView(bug: Cockroach, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, CockroachImage, 3f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Cockroach()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        CockroachView(bug, onSize, onTap, onDead)
    }
}