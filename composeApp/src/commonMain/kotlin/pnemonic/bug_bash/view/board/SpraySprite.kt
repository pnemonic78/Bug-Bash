package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.drawable.insecticide
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Spray
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.compose.toPx

@Composable
fun SpraySprite(tool: Spray, onUse: ToolCallback, boardSize: Size) {
    ToolSprite(tool, insecticide(tool.bonus), 12f, boardSize)
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
    val tool = Spray(Bonus.Spray(Long.MAX_VALUE))
    tool.show()

    Box(modifier = Modifier.fillMaxSize()) {
        SpraySprite(tool, onUse = {}, boardSize)
    }
}