package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Score
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.compose.toPx
import pnemonic.bug_bash.drawable.Trophy as ScoreImage
import pnemonic.bug_bash.view.board.Score as ScoreView

private val sizeScore = 50.sp

@Composable
fun ScoreSprite(tool: Score, onUse: ToolCallback, boardSize: Size) {
    ToolSprite(tool, ScoreImage, 1f, 0.85f, null, boardSize) {
        ScoreView(score = tool.bonus.hits, boardSize, 0f, 0f, sizeScore)
    }

    LaunchedEffect(tool) {
        tool.show()
        delay(1500)
        onUse(tool)
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF008800,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
private fun Preview() {
    val boardSize = Size(previewWidthDp.dp.toPx(), previewHeightDp.dp.toPx())
    val tool = Score(Bonus.Score(hits = 5000))

    Box(modifier = Modifier.fillMaxSize()) {
        ScoreSprite(tool, onUse = {}, boardSize)
    }
}