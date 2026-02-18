package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.drawable.Centipede as CentipedeImage

@Composable
fun CentipedeView(
    bug: Centipede,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, CentipedeImage, 7f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Centipede()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        CentipedeView(bug, Size.Zero, onSize, onTap)
    }
}