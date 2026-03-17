package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.view.theme.DarkRed
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.panel
import pnemonic.compose.Left
import pnemonic.half
import kotlin.math.max
import kotlin.math.min

private val colorText = Yellow
private val sizeIcon = 30.dp
private val sizeText = 20.sp

@Composable
fun ScoreView(modifier: Modifier = Modifier, score: Long) {
    val locale = Locale.current
    val platform: Platform = getPlatform()

    Row(
        modifier = modifier.panel(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Left
    ) {
        Image(imageVector = Trophy, contentDescription = "🏆", modifier = Modifier.size(sizeIcon))
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = platform.formatInteger(locale, score),
            fontSize = sizeText,
            color = colorText,
            fontWeight = FontWeight.Bold
        )
    }
}

private val sizeScore = 30.sp
private val colorScoreGood = listOf(White, Yellow, Gold)
private val colorScoreBad = listOf(White, Red, DarkRed)
private val colorShadow = Yellow

@Composable
fun Score(bug: Bug, boardSize: Size) {
    Score(bug.score, boardSize, bug.left + bug.width.half, bug.top + bug.height.half)
}

@Composable
fun Score(score: Long, boardSize: Size, x: Float, y: Float, fontSize: TextUnit = sizeScore) {
    val locale = Locale.current
    val platform: Platform = getPlatform()
    val text = (if (score > 0) "+" else "") + platform.formatInteger(locale, score)
    var heightPx by remember { mutableFloatStateOf(100f) }

    val colors = if (score >= 0) colorScoreGood else colorScoreBad
    val style: TextStyle = LocalTextStyle.current.copy(
        brush = Brush.verticalGradient(
            colors = colors,
            endY = heightPx * 0.5f
        ),
        fontSize = fontSize,
        fontWeight = FontWeight.Medium,
        textMotion = TextMotion.Animated,
        shadow = Shadow(color = colorShadow, blurRadius = 5f)
    )

    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val textLayoutResult: TextLayoutResult = remember(text, style, density) {
        textMeasurer.measure(
            text = text,
            style = style,
            constraints = Constraints() // Use default or specific constraints
        )
    }
    val textSize = textLayoutResult.size.toSize()

    val textX = min(
        max(0f, x - textSize.width.half),
        max(0f, boardSize.width - textSize.width)
    )
    val textY = min(
        max(0f, y - textSize.height.half),
        max(0f, boardSize.height - textSize.height)
    )

    val scale = remember { Animatable(0.1f) }
    LaunchedEffect(score, x, y) {
        scale.animateTo(1f, animationSpec = tween(durationMillis = 1000, easing = EaseOutElastic))
    }

    Text(
        modifier = Modifier.graphicsLayer {
            translationX = textX
            translationY = textY
            scaleX = scale.value
            scaleY = scale.value
            transformOrigin = TransformOrigin.Center
        },
        text = text,
        style = style,
        onTextLayout = { tlr ->
            heightPx = tlr.size.height.toFloat()
        }
    )
}

@Composable
@Preview(locale = "de")
private fun Preview_DE() {
    MaterialTheme {
        ScoreView(score = 10000)
    }
}

@Composable
@Preview(locale = "en")
private fun Preview_EN() {
    MaterialTheme {
        ScoreView(score = 10_000)
    }
}

@Composable
@Preview(locale = "he")
private fun Preview_RTL() {
    MaterialTheme {
        ScoreView(score = 20_000)
    }
}

@Composable
@Preview
private fun Preview_num() {
    MaterialTheme {
        Score(score = 1000, Size.Zero, 0f, 0f)
    }
}

@Composable
@Preview
private fun Preview_neg() {
    MaterialTheme {
        Score(score = -1000, Size.Zero, 0f, 0f)
    }
}