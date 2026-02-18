package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Swatter
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.toPx
import pnemonic.bug_bash.drawable.Swatter as SwatterImage

@Composable
fun SwatterView(tool: Swatter, onUse: ToolCallback, boardSize: Size) {
    ImageTool(tool, SwatterImage, 1.1f, boardSize)
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
    val tool = Swatter(Bonus.Swatter())
    tool.show()

    Box(modifier = Modifier.fillMaxSize()) {
        SwatterView(tool, onUse = {}, boardSize)
    }
}