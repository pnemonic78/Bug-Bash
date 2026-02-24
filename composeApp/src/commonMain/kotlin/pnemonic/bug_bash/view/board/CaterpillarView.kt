package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.caterpillar
import pnemonic.bug_bash.model.bug.Caterpillar
import pnemonic.bug_bash.view.previewColor

@Composable
fun CaterpillarView(bug: Caterpillar, boardSize: Size, onSize: BugCallback, onTap: BugCallback) {
    ImageBug(bug, boardSize, caterpillar(bug), 3f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Caterpillar()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        CaterpillarView(bug, Size.Zero, onSize, onTap)
    }
}