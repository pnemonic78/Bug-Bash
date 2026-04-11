package pnemonic.bug_bash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.play
import org.jetbrains.compose.resources.stringResource
import pnemonic.VoidCallback
import pnemonic.compose.lighten
import pnemonic.compose.toDp

private val reflectionBrush = Brush.verticalGradient(
    colors = listOf(White.copy(alpha = 0.5f), Transparent)
)
private val borderWidth = 1.dp
private val borderColor = Color(0x60000000)

/// Vintage Mac OS X button.
@Composable
@Suppress("AssignedValueIsNeverRead")
fun GlossyButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF6897D3),
    shape: Shape = ButtonDefaults.shape,
    padding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: VoidCallback,
    content: @Composable RowScope.() -> Unit
) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(color, color.lighten(0.2f))
    )
    val paddingTop = padding.calculateTopPadding()
    var buttonSize by remember { mutableStateOf(IntSize.Zero) }
    val buttonSizeDp = buttonSize.toDp()

    Box(
        modifier = modifier
            .background(gradientBrush, shape)
            .border(borderWidth, borderColor, shape)
            .clip(shape)
            .onSizeChanged { buttonSize = it }
            .clickable { onClick() },
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(
            modifier = Modifier
                .width(buttonSizeDp.width)
                .height(paddingTop + buttonSizeDp.height * 0.48f)
                .padding(horizontal = 10.dp)
                .padding(top = borderWidth)
                .background(reflectionBrush, shape)
        )
        Row(
            modifier = Modifier.align(Alignment.Center)
                .padding(padding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor)
private fun Preview() {
    MaterialTheme {
        GlossyButton(
            modifier = Modifier.size(120.dp, 40.dp),
            onClick = {},
        ) {
            Text(text = stringResource(Res.string.play))
        }
    }
}