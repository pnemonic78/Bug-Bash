package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Cupcake
import pnemonic.bug_bash.drawable.Cupcake as CupcakeImage

@Composable
fun CupcakeView(tool: Cupcake, onSize: ToolCallback, onTap: ToolCallback, boardSize: Size) {
    ImageTool(tool, CupcakeImage, 3f, onSize, onTap, boardSize)
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 300, heightDp = 500)
private fun Preview() {
    val tool = Cupcake(Bonus.Cupcake())

    Box(modifier = Modifier.fillMaxSize()) {
        CupcakeView(tool, onSize = {}, onTap = {}, Size.Zero)
    }
}