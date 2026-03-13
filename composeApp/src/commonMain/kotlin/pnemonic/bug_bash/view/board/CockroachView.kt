package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.drawable.cockroach
import pnemonic.bug_bash.model.bug.Cockroach
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.compose.toPx

@Composable
fun CockroachView(
    bug: Cockroach,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    ImageBug(bug, boardSize, cockroach(bug), 3f, onSize, onTap)
}

@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
@Composable
private fun Preview() {
    val boardSize = Size(previewWidthDp.dp.toPx(), previewHeightDp.dp.toPx())
    val bug = Cockroach()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        CockroachView(bug, boardSize, onSize, onTap)
    }
}