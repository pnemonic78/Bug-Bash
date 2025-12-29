package pnemonic.bug_squash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import pnemonic.bug_squash.model.Ladybug

private val width = 40.dp
private val height = 40.dp

@Composable
fun LadyBugView(bug: Ladybug, onTap: BugCallback) {
    Box(
        modifier = Modifier
            .size(width, height)
            .onSizeChanged(bug::setSize)
            .graphicsLayer {
                translationX = bug.left
                translationY = bug.top
                rotationZ = bug.rotation
            }
            .background(Color.Red)
            .clickable {
                onTap(bug)
            }
    ) {
        Text(text = "🐞", fontSize = 30.sp)
        if (bug.isSquashed) {
            Box(modifier = Modifier.fillMaxSize().background(Color.Red.copy(alpha = 0.5f)))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
@Composable
private fun Preview() {
    val bug = Ladybug()
    val onTap: BugCallback = {}
    Box(modifier = Modifier.fillMaxSize()) {
        LadyBugView(bug, onTap)
    }
}