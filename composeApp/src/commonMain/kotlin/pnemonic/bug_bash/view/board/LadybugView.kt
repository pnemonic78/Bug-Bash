package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Ladybug
import pnemonic.bug_bash.drawable.Ladybug as LadybugImage

@Composable
fun LadybugView(bug: Ladybug, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, LadybugImage, 1.5f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Ladybug()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        LadybugView(bug, onSize, onTap, onDead)
    }
}