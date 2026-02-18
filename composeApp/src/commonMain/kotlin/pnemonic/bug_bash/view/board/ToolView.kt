package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.Cupcake
import pnemonic.bug_bash.model.tool.ExtraLife
import pnemonic.bug_bash.model.tool.Flower
import pnemonic.bug_bash.model.tool.GluePaper
import pnemonic.bug_bash.model.tool.Score
import pnemonic.bug_bash.model.tool.Shoe
import pnemonic.bug_bash.model.tool.Spray
import pnemonic.bug_bash.model.tool.Swatter
import pnemonic.bug_bash.model.tool.Tool
import pnemonic.bug_bash.model.tool.Zapper
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.toPx
import kotlin.math.roundToInt

typealias ToolCallback = (Tool) -> Unit

@Composable
fun ToolAbove(
    tool: Tool,
    onToolUse: ToolCallback,
    boardSize: Size
) {
    when (tool) {
        is ExtraLife -> LifeView(tool, onToolUse, boardSize)
        is Score -> ScoreView(tool, onToolUse, boardSize)
        is Shoe -> ShoeView(tool, onToolUse, boardSize)
        is Spray -> SprayView(tool, onToolUse, boardSize)
        is Swatter -> SwatterView(tool, onToolUse, boardSize)
        is Zapper -> ZapperView(tool, onToolUse, boardSize)
    }
}

@Composable
fun ToolBelow(
    tool: Tool,
    onToolUse: ToolCallback,
    boardSize: Size
) {
    when (tool) {
        is Cupcake -> CupcakeView(tool, onToolUse, boardSize)
        is Flower -> FlowerView(tool, onToolUse, boardSize)
        is GluePaper -> GluePaperView(tool, onToolUse, boardSize)
    }
}

@Composable
fun ImageTool(
    tool: Tool,
    image: ImageVector,
    scale: Float,
    opacity: Float = 1f,
    tint: Color? = null,
    boardSize: Size,
    modifier: Modifier = Modifier,
    overlay: @Composable BoxScope.() -> Unit = {}
) {
    val width = image.defaultWidth * scale
    val height = image.defaultHeight * scale
    val animatedOpacity by animateFloatAsState(targetValue = tool.opacity)

    Box(
        modifier = modifier
            .size(width, height)
            .onSizeChanged { size ->
                val oldWidth = tool.width.roundToInt()
                val oldHeight = tool.height.roundToInt()
                if ((oldWidth != size.width) || (oldHeight != size.height)) {
                    tool.setSize(size.toSize(), boardSize)
                }
            }
            .graphicsLayer {
                translationX = tool.left
                translationY = tool.top
                alpha = animatedOpacity
            },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = image,
            contentDescription = tool.description,
            contentScale = ContentScale.Fit,
            colorFilter = if (tint == null) null else ColorFilter.tint(tint),
            alpha = opacity,
        )
        overlay()
    }
}

@Composable
fun ImageTool(
    tool: Tool,
    image: ImageVector,
    scale: Float,
    boardSize: Size,
    modifier: Modifier = Modifier,
    overlay: @Composable BoxScope.() -> Unit = {}
) = ImageTool(
    tool = tool,
    image = image,
    scale = scale,
    opacity = 1f,
    tint = null,
    boardSize = boardSize,
    modifier = modifier,
    overlay = overlay
)

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
private fun Preview() {
    val boardSize = Size(previewWidthDp.dp.toPx(), previewHeightDp.dp.toPx())
    val toolBelow = GluePaper(Bonus.GluePaper())
    val toolAbove = ExtraLife(Bonus.Life())

    toolBelow.show()
    toolAbove.show()

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            ToolBelow(toolBelow, onToolUse = {}, boardSize)
            ToolAbove(toolAbove, onToolUse = {}, boardSize)
        }
    }
}
