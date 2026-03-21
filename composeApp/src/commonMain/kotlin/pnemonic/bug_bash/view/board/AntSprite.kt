package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.ant
import pnemonic.bug_bash.model.bug.Ant
import pnemonic.bug_bash.view.previewColor

@Composable
fun AntSprite(bug: Ant, boardSize: Size, onSize: BugCallback, onTap: BugCallback) {
    BugSprite(bug, boardSize, ant(bug), 2f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Ant()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        AntSprite(bug, Size.Zero, onSize, onTap)
    }
}