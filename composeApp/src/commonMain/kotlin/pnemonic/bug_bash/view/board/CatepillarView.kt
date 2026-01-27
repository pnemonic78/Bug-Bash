package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Caterpillar

private val width = 35.dp
private val height = 40.dp

@Composable
fun CaterpillarView(
    bug: Caterpillar,
    onSize: BugCallback,
    onTap: BugCallback,
    onDead: BugCallback
) {
    GenericBug(bug, width, height, Color.Green, onSize, onTap, onDead)
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Caterpillar()
    val onSize: BugCallback = {}
    val onTap: BugCallback = {}
    val onDead: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        CaterpillarView(bug, onSize, onTap, onDead)
    }
}