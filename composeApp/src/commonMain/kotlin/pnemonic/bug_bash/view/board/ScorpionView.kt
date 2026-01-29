package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Scorpion
import pnemonic.bug_bash.drawable.Scorpion as ScorpionImage

@Composable
fun ScorpionView(bug: Scorpion, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    ImageBug(bug, ScorpionImage, 3f, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Scorpion()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        ScorpionView(bug, onSize, onTap, onDead)
    }
}