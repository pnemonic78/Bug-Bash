package pnemonic.bug_bash.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Spider

private val width = 80.dp
private val height = 80.dp

@Composable
fun SpiderView(bug: Spider, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    GenericBug(bug, width, height, Color.LightGray, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Spider()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        SpiderView(bug, onSize, onTap, onDead)
    }
}