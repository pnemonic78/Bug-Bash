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
import pnemonic.bug_bash.model.Difficulty
import pnemonic.bug_bash.model.Difficulty.Companion.times
import pnemonic.bug_bash.model.tool.Flower
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.compose.toPx
import pnemonic.bug_bash.drawable.Flower as FlowerImage

@Composable
fun FlowerSprite(tool: Flower, onUse: ToolCallback, boardSize: Size, difficulty: Difficulty = Difficulty.Easy) {
    ToolSprite(tool, FlowerImage, 5f, boardSize)

    LaunchedEffect(tool) {
        delay(5_000L * difficulty)
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
    val tool = Flower(Bonus.Flower())
    tool.show()

    Box(modifier = Modifier.fillMaxSize()) {
        FlowerSprite(tool, onUse = {}, boardSize)
    }
}