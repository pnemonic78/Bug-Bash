package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Moth
import pnemonic.bug_bash.drawable.Moth as MothImage

@Composable
fun MothView(bug: Moth, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, MothImage, 2f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Moth()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        MothView(bug, onSize, onTap, onDead)
    }
}