package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.centipede
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.bug_bash.view.previewColor

@Composable
fun CentipedeSprite(
    bug: Centipede,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    BugSprite(bug, boardSize, centipede(bug), 7f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Centipede()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        CentipedeSprite(bug, Size.Zero, onSize, onTap)
    }
}