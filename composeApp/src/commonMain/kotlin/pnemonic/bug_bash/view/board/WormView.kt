package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.Earthworm
import pnemonic.bug_bash.model.bug.Worm
import pnemonic.bug_bash.view.previewColor

@Composable
fun WormView(
    bug: Worm,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, Earthworm, 3f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Worm()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        WormView(bug, Size.Zero, onSize, onTap)
    }
}