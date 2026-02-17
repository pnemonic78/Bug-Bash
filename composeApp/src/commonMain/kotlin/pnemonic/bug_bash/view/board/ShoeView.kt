package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Shoe
import pnemonic.bug_bash.drawable.Shoe as ShoeImage

@Composable
fun ShoeView(tool: Shoe, onSize: ToolCallback, onTap: ToolCallback, boardSize: Size) {
    ImageTool(tool, ShoeImage, 2f, onSize, onTap, boardSize)
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 300, heightDp = 500)
private fun Preview() {
    val tool = Shoe(Bonus.Shoe())

    Box(modifier = Modifier.fillMaxSize()) {
        ShoeView(tool, onSize = {}, onTap = {}, Size.Zero)
    }
}