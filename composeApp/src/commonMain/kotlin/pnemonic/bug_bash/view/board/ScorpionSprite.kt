package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.scorpion
import pnemonic.bug_bash.model.bug.Scorpion
import pnemonic.bug_bash.view.previewColor

@Composable
fun ScorpionSprite(
    bug: Scorpion,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    BugSprite(bug, boardSize, scorpion(bug), 4f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Scorpion()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        ScorpionSprite(bug, Size.Zero, onSize, onTap)
    }
}