package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.bug.Ant
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.drawable.Ant as AntImage

@Composable
fun AntView(bug: Ant, boardSize: Size, onSize: BugCallback, onTap: BugCallback) {
    ImageBug(bug, boardSize, AntImage, 2f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Ant()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        AntView(bug, Size.Zero, onSize, onTap)
    }
}