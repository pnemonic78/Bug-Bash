package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Snail
import pnemonic.bug_bash.drawable.Snail as SnailImage

@Composable
fun SnailView(bug: Snail, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, SnailImage, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Snail()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        SnailView(bug, onSize, onTap, onDead)
    }
}