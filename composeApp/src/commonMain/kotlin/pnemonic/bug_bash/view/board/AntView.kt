package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Ant
import pnemonic.bug_bash.drawable.Ant as AntImage

@Composable
fun AntView(bug: Ant, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, AntImage, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Ant()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        AntView(bug, onSize, onTap, onDead)
    }
}