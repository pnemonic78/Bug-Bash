package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.ExtraLife
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.toPx
import pnemonic.bug_bash.drawable.LifeHas as LifeImage

@Composable
fun LifeView(tool: ExtraLife, onUse: ToolCallback, boardSize: Size) {
    ImageTool(tool, LifeImage, 20f, boardSize)

    LaunchedEffect(tool) {
        tool.show()
        delay(1000)
        onUse(tool)
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
private fun Preview() {
    val boardSize = Size(previewWidthDp.dp.toPx(), previewHeightDp.dp.toPx())
    val tool = ExtraLife(Bonus.Life())

    Box(modifier = Modifier.fillMaxSize()) {
        LifeView(tool, onUse = {}, boardSize)
    }
}