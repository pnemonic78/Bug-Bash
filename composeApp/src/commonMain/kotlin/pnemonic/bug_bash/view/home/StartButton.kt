package pnemonic.bug_bash.view.home

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.elevatedButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.ic_hammer
import bug_bash.composeapp.generated.resources.play
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.theme.Gold

private val colorContainer = Gold
private val colorContent = White
private val colorShadow = Yellow
private val sizeShadow = 20.dp

@Composable
fun StartButton(modifier: Modifier = Modifier, onClick: VoidCallback) {
    val density = LocalDensity.current
    val sizeShadowPx = with(density) { sizeShadow.toPx() }
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

    Button(
        modifier = modifier.dropShadow(
            shape = ButtonDefaults.shape,
            shadow = Shadow(
                color = colorShadow,
                radius = radius
            )
        ),
        onClick = onClick,
        elevation = elevatedButtonElevation(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = colorContainer,
            contentColor = colorContent
        )
    ) {
        Text(text = stringResource(Res.string.play), fontSize = 40.sp)
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Icon(
            imageVector = vectorResource(Res.drawable.ic_hammer),
            contentDescription = "\uD83D\uDD28",
            modifier = Modifier.size(40.dp),
            tint = colorContent.copy(alpha = 0.8f)
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor)
private fun Preview() {
    MaterialTheme {
        StartButton(modifier = Modifier.padding(20.dp)) {}
    }
}