package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Bee

private val width = 60.dp
private val height = 60.dp

@Composable
fun BeeView(bug: Bee, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    GenericBug(bug, width, height, Color.White, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Bee()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        BeeView(bug, onSize, onTap, onDead)
    }
}