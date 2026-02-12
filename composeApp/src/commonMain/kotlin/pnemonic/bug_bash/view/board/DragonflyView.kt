package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Dragonfly
import pnemonic.bug_bash.drawable.Dragonfly as DragonflyImage

@Composable
fun DragonflyView(
    bug: Dragonfly,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, DragonflyImage, 2f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Dragonfly()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        DragonflyView(bug, Size.Zero, onSize, onTap)
    }
}