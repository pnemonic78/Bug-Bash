package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Score
import pnemonic.bug_bash.drawable.Trophy as ScoreImage
import pnemonic.bug_bash.view.board.Score as ScoreView

private val sizeScore = 50.sp

@Composable
fun ScoreView(tool: Score, onSize: ToolCallback, onTap: ToolCallback, boardSize: Size) {
    ImageTool(tool, ScoreImage, 1f, 0.7f, null, onSize, onTap, boardSize) {
        ScoreView(score = tool.bonus.hits, boardSize, 0f, 0f, sizeScore)
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF008800, widthDp = 300, heightDp = 500)
private fun Preview() {
    val tool = Score(Bonus.Score(hits = 5000))

    Box(modifier = Modifier.fillMaxSize()) {
        ScoreView(tool, onSize = {}, onTap = {}, Size.Zero)
    }
}