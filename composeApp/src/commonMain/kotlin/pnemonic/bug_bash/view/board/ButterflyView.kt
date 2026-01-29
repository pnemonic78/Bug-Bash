package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Butterfly
import pnemonic.bug_bash.drawable.Butterfly as ButterflyImage

@Composable
fun ButterflyView(bug: Butterfly, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, ButterflyImage, 2f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Butterfly()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        ButterflyView(bug, onSize, onTap, onDead)
    }
}