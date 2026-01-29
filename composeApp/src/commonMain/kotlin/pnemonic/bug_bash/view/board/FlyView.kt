package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Fly
import pnemonic.bug_bash.drawable.Fly as FlyImage

@Composable
fun FlyView(bug: Fly, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, FlyImage, 1.5f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Fly()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        FlyView(bug, onSize, onTap, onDead)
    }
}