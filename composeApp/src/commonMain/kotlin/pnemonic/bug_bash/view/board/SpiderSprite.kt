package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.drawable.spider
import pnemonic.bug_bash.model.bug.Spider
import pnemonic.bug_bash.view.previewColor

@Composable
fun SpiderSprite(
    bug: Spider,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    BugSprite(bug, boardSize, spider(bug), 5f, onSize, onTap)
}

@Preview(showBackground = true, backgroundColor = previewColor)
@Composable
private fun Preview() {
    val bug = Spider()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}

    Box(modifier = Modifier.fillMaxSize()) {
        SpiderSprite(bug, Size.Zero, onSize, onTap)
    }
}