package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.game_state_finished
import org.jetbrains.compose.resources.stringResource
import pnemonic.VoidCallback
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.view.home.HomeButton
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.settings.ActionPanel
import pnemonic.bug_bash.view.theme.AppTheme
import pnemonic.bug_bash.view.theme.DarkRed
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.paddingScreen

private val colorMask = Color.Black.copy(alpha = 0.7f)
private val colorText = Color(0xFFCC0088)
private val colorShadow = Color.Magenta
private val sizeText = 60.sp

@Composable
fun StateScreen(state: GameState, score: Long, onHomeClick: VoidCallback) {
    if (state === GameState.FINISHED) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = colorMask)
                .padding(paddingScreen)
        ) {
            ActionPanel(modifier = Modifier.align(BiasAlignment(1f, -1f))) {
                HomeButton(onClick = onHomeClick)
            }

            GameOver(
                modifier = Modifier.align(BiasAlignment(0f, 0f)),
                score = score
            )
        }
    }
}

@Composable
private fun GameOver(modifier: Modifier = Modifier, score: Long) {
    val text = stringResource(Res.string.game_state_finished)
    GameOver(modifier = modifier, text = text, score = score)
}

@Composable
private fun GameOver(modifier: Modifier = Modifier, text: String, score: Long) {
    val style = LocalTextStyle.current.copy(
        lineHeight = sizeText,
        shadow = Shadow(color = colorShadow, blurRadius = 5f)
    )

    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Serif,
            fontSize = sizeText,
            fontWeight = FontWeight.Bold,
            color = colorText,
            textAlign = TextAlign.Center,
            style = style,
        )
        Spacer(modifier = Modifier.height(20.dp))
        FinalScore(score)
    }
}

private val colorScoreGood = listOf(Yellow, Gold)
private val colorScoreBad = listOf(Red, DarkRed)
private val sizeScore = 50.sp

@Suppress("AssignedValueIsNeverRead")
@Composable
private fun FinalScore(score: Long) {
    val locale = Locale.current
    val platform: Platform = getPlatform()
    val text = platform.formatInteger(locale, score)
    var heightPx by remember { mutableFloatStateOf(100f) }

    val colors = if (score >= 0) colorScoreGood else colorScoreBad
    val style: TextStyle = LocalTextStyle.current.copy(
        brush = Brush.verticalGradient(colors = colors, endY = heightPx * 0.5f),
        fontSize = sizeScore,
        fontWeight = FontWeight.Bold,
        textMotion = TextMotion.Animated,
    )

    val scale = remember { Animatable(0.1f) }
    LaunchedEffect(score) {
        scale.animateTo(1f, animationSpec = tween(durationMillis = 2500, easing = EaseOutBounce))
    }

    Text(
        modifier = Modifier
            .border(2.dp, Yellow.copy(alpha = 0.6f), CircleShape)
            .padding(20.dp)
            .scale(scale.value),
        text = text,
        style = style,
        onTextLayout = { tlr ->
            heightPx = tlr.size.height.toFloat()
        }
    )
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
private fun Preview() {
    AppTheme {
        StateScreen(state = GameState.FINISHED, score = 100, onHomeClick = {})
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp * 2,
    heightDp = previewHeightDp
)
private fun PreviewWide() {
    AppTheme {
        StateScreen(state = GameState.FINISHED, score = 200, onHomeClick = {})
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = previewColor,
    widthDp = previewWidthDp,
    heightDp = previewHeightDp,
    locale = "ru"
)
private fun Preview_AF() {
    AppTheme {
        StateScreen(state = GameState.FINISHED, score = 300, onHomeClick = {})
    }
}