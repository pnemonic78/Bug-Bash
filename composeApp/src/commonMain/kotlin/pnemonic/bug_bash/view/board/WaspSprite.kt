package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.wasp
import pnemonic.bug_bash.model.bug.Wasp
import pnemonic.bug_bash.view.previewColor

@Composable
fun WaspSprite(
    bug: Wasp,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    BugSprite(bug, boardSize, wasp(bug), 3f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Wasp()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        WaspSprite(bug, Size.Zero, onSize, onTap)
    }
}