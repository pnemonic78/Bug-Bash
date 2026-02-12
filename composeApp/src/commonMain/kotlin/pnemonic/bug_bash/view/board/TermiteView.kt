package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Termite
import pnemonic.bug_bash.drawable.Termite as TermiteImage

@Composable
fun TermiteView(
    bug: Termite,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, TermiteImage, 1.5f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Termite()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        TermiteView(bug, Size.Zero, onSize, onTap)
    }
}