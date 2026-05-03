package pnemonic.bug_bash.view

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.view.theme.AppTheme

@Composable
fun GlowBox(
    modifier: Modifier = Modifier,
    sizeGlow: Dp,
    colorGlow: Color,
    shape: Shape = ButtonDefaults.shape,
    content: @Composable BoxScope.() -> Unit
) {
    val density = LocalDensity.current
    val sizeShadowPx = with(density) { sizeGlow.toPx() }
    val infiniteTransition = rememberInfiniteTransition()
    val radiusPx = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = sizeShadowPx,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ),
    )
    val radius = with(density) { radiusPx.value.toDp() }

    Box(
        modifier = modifier.padding(sizeGlow / 2)
            .dropShadow(
                shape = shape,
                shadow = Shadow(
                    radius = radius,
                    color = colorGlow
                )
            )
            .clip(shape)
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor)
private fun Preview() {
    val shape: Shape = ButtonDefaults.shape

    AppTheme {
        GlowBox(
            sizeGlow = 20.dp,
            colorGlow = Color.Red,
            shape = shape
        ) {
            Text(
                "Hello",
                modifier = Modifier.border(1.dp, Color.Green, shape)
                    .padding(10.dp)
            )
        }
    }
}