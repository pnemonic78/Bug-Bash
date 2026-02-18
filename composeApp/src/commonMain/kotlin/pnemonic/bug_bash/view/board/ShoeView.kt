package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Shoe
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.toPx
import pnemonic.bug_bash.drawable.Shoe as ShoeImage

@Composable
fun ShoeView(tool: Shoe, onUse: ToolCallback, boardSize: Size) {
    ImageTool(tool, ShoeImage, 2f, boardSize)
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
    val tool = Shoe(Bonus.Shoe())
    tool.show()

    Box(modifier = Modifier.fillMaxSize()) {
        ShoeView(tool, onUse = {}, boardSize)
    }
}