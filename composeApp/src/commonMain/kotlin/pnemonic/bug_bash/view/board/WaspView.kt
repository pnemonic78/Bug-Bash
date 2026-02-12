package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Wasp
import pnemonic.bug_bash.drawable.Wasp as WaspImage

@Composable
fun WaspView(
    bug: Wasp,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, WaspImage, 3f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Wasp()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        WaspView(bug, Size.Zero, onSize, onTap)
    }
}