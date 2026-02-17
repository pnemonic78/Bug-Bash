package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.GluePaper
import pnemonic.bug_bash.drawable.GluePaper as GluePaperImage

@Composable
fun GluePaperView(tool: GluePaper, onSize: ToolCallback, onTap: ToolCallback, boardSize: Size) {
    ImageTool(tool, GluePaperImage, 10f, onSize, onTap, boardSize)
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 300, heightDp = 500)
private fun Preview() {
    val tool = GluePaper(Bonus.GluePaper())

    Box(modifier = Modifier.fillMaxSize()) {
        GluePaperView(tool, onSize = {}, onTap = {}, Size.Zero)
    }
}