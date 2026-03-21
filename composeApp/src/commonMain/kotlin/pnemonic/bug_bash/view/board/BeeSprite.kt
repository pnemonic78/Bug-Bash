package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.bee
import pnemonic.bug_bash.model.bug.Bee
import pnemonic.bug_bash.view.previewColor

@Composable
fun BeeSprite(bug: Bee, boardSize: Size, onSize: BugCallback, onTap: BugCallback) {
    BugSprite(bug, boardSize, bee(bug), 2f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Bee()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        BeeSprite(bug, Size.Zero, onSize, onTap)
    }
}