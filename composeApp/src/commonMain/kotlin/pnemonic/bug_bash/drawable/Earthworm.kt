package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.bug.Worm
import pnemonic.stateOf
import pnemonic.toRadians
import kotlin.math.PI
import kotlin.math.sin

private const val durationCrawl = 2000
private const val angleSegment = ((2.0 * PI) / 22).toFloat()
private const val widthCrawl = 20f * 0.25f

@Composable
fun earthworm(bug: Worm): ImageVector = earthworm(bug.isSquashed)

@Composable
fun earthworm(squashed: Boolean = false): ImageVector {
    val crawl: State<Float>

    if (squashed) {
        crawl = stateOf(0f)
    } else {
        val transition = rememberInfiniteTransition()
        crawl = transition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }
    val angle = crawl.value.toRadians()
    val tx0 = sin(angle) * widthCrawl
    val tx1 = sin(angle + angleSegment) * widthCrawl
    val tx2 = sin(angle + angleSegment * 2) * widthCrawl
    val tx3 = sin(angle + angleSegment * 3) * widthCrawl
    val tx4 = sin(angle + angleSegment * 4) * widthCrawl
    val tx5 = sin(angle + angleSegment * 5) * widthCrawl
    val tx6 = sin(angle + angleSegment * 6) * widthCrawl
    val tx7 = sin(angle + angleSegment * 7) * widthCrawl
    val tx8 = sin(angle + angleSegment * 8) * widthCrawl
    val tx9 = sin(angle + angleSegment * 9) * widthCrawl
    val tx10 = sin(angle + angleSegment * 10) * widthCrawl
    val tx11 = sin(angle + angleSegment * 11) * widthCrawl
    val tx12 = sin(angle + angleSegment * 12) * widthCrawl
    val tx13 = sin(angle + angleSegment * 13) * widthCrawl
    val tx14 = sin(angle + angleSegment * 14) * widthCrawl
    val tx15 = sin(angle + angleSegment * 15) * widthCrawl
    val tx16 = sin(angle + angleSegment * 16) * widthCrawl
    val tx17 = sin(angle + angleSegment * 17) * widthCrawl
    val tx18 = sin(angle + angleSegment * 18) * widthCrawl
    val tx19 = sin(angle + angleSegment * 19) * widthCrawl
    val tx20 = sin(angle + angleSegment * 20) * widthCrawl
    val tx21 = sin(angle + angleSegment * 21) * widthCrawl

    return ImageVector.Builder(
        name = "Earthworm",
        defaultWidth = 20.dp,
        defaultHeight = 115.71.dp,
        viewportWidth = 20f,
        viewportHeight = 115.71f
    ).apply {
        path(
            fill = Brush.linearGradient(
                colorStops = arrayOf(
                    0f to Color(0xFFFFA8AC),
                    1f to Color(0xFFD98F93)
                ),
                start = Offset(6.63f, 57.86f),
                end = Offset(13.36f, 57.86f)
            ),
            stroke = SolidColor(Color(0xCC70181C)),
            strokeLineWidth = 0.2f
        ) {
            moveTo(8.11f + tx21, 110.44f)
            curveTo(7.73f + tx20, 108.78f, 7.58f + tx20, 105.35f, 7.58f + tx20, 105.35f)
            lineTo(7.21f + tx19, 100.07f)
            lineTo(7.1f + tx18, 94.88f)
            lineTo(7.04f + tx17, 89.76f)
            lineTo(6.96f + tx16, 84.57f)
            lineTo(6.9f + tx15, 79.51f)
            lineTo(6.82f + tx14, 74.16f)
            lineTo(6.75f + tx13, 69.08f)
            lineTo(6.69f + tx12, 64.04f)
            lineTo(6.69f + tx11, 58.81f)
            lineTo(6.69f + tx10, 53.73f)
            lineTo(6.7f + tx9, 48.58f)
            lineTo(6.7f + tx8, 43.46f)
            lineTo(6.71f + tx7, 38.72f)
            lineTo(6.71f + tx6, 34.21f)
            lineTo(6.71f + tx5, 28.72f)
            curveTo(6.68f + tx4, 24.79f, 6.66f + tx3, 20.85f, 6.74f + tx3, 16.91f)
            lineTo(7.04f + tx2, 11.77f)
            lineTo(7.71f + tx1, 5.69f)
            curveTo(8.15f + tx1, 2.95f, 8.62f + tx0, 0.29f, 9.89f + tx0, 0.23f)
            curveTo(10.78f + tx0, 0.21f, 11.53f + tx1, 2.34f, 12.11f + tx1, 5.71f)
            lineTo(12.71f + tx2, 11.73f)
            lineTo(13.01f + tx3, 17.01f)
            curveTo(13.13f + tx4, 20.89f, 13.22f + tx5, 24.76f, 13.31f + tx5, 28.64f)
            lineTo(13.29f + tx6, 34.23f)
            lineTo(13.28f + tx7, 38.72f)
            lineTo(13.26f + tx8, 43.55f)
            lineTo(13.24f + tx9, 48.61f)
            lineTo(13.22f + tx10, 53.82f)
            lineTo(13.2f + tx11, 58.88f)
            lineTo(13.18f + tx12, 64.07f)
            lineTo(13.15f + tx13, 69.1f)
            lineTo(13.11f + tx14, 74.39f)
            lineTo(13.08f + tx15, 79.51f)
            lineTo(13.05f + tx16, 84.73f)
            lineTo(13.01f + tx17, 89.79f)
            lineTo(12.91f + tx18, 95.05f)
            lineTo(12.7f + tx19, 100.06f)
            lineTo(12.36f + tx20, 105.34f)
            curveTo(12.36f + tx20, 105.34f, 12.16f + tx20, 108.77f, 11.76f + tx21, 110.43f)
            curveTo(11.34f + tx21, 112.17f, 11.69f + tx0, 115.49f, 9.89f + tx0, 115.48f)
            curveTo(8.11f + tx0, 115.47f, 8.5f + tx21, 112.18f, 8.11f + tx21, 110.44f)
            close()
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(8.23f + tx21, 110.35f)
            curveTo(9.4f + tx21, 110.41f, 10.71f + tx21, 110.35f, 11.81f + tx21, 110.36f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.67f + tx20, 105.25f)
            curveTo(9.22f + tx20, 105.31f, 10.95f + tx20, 105.25f, 12.41f + tx20, 105.25f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.29f + tx19, 99.96f)
            curveTo(9.07f + tx19, 100.01f, 11.07f + tx19, 99.96f, 12.74f + tx19, 99.96f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.19f + tx18, 94.96f)
            curveTo(9.08f + tx18, 95.02f, 11.19f + tx18, 94.96f, 12.97f + tx18, 94.96f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.12f + tx17, 89.69f)
            curveTo(9.07f + tx17, 89.75f, 11.24f + tx17, 89.69f, 13.07f + tx17, 89.7f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.06f + tx16, 84.56f)
            curveTo(9.03f + tx16, 84.62f, 11.24f + tx16, 84.56f, 13.1f + tx16, 84.57f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.99f + tx15, 79.42f)
            curveTo(9f + tx15, 79.47f, 11.25f + tx15, 79.42f, 13.14f + tx15, 79.42f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.92f + tx14, 74.14f)
            curveTo(8.96f + tx14, 74.19f, 11.24f + tx14, 74.14f, 13.16f + tx14, 74.14f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.82f + tx13, 69.13f)
            curveTo(8.9f + tx13, 69.18f, 11.24f + tx13, 69.13f, 13.2f + tx13, 69.13f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.76f + tx12, 64.02f)
            curveTo(8.88f + tx12, 64.07f, 11.25f + tx12, 64.02f, 13.24f + tx12, 64.02f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.78f + tx11, 58.72f)
            curveTo(8.89f + tx11, 58.77f, 11.26f + tx11, 58.71f, 13.25f + tx11, 58.72f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.78f + tx10, 53.66f)
            curveTo(8.9f + tx10, 53.72f, 11.28f + tx10, 53.66f, 13.28f + tx10, 53.66f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.78f + tx9, 48.51f)
            curveTo(8.91f + tx9, 48.57f, 11.29f + tx9, 48.51f, 13.29f + tx9, 48.52f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.81f + tx8, 43.39f)
            curveTo(8.97f + tx8, 43.45f, 11.14f + tx8, 43.39f, 13.31f + tx8, 43.4f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.81f + tx7, 38.67f)
            curveTo(8.94f + tx7, 38.72f, 11.33f + tx7, 38.67f, 13.34f + tx7, 38.67f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.78f + tx6, 34.19f)
            curveTo(8.93f + tx6, 34.24f, 11.34f + tx6, 34.19f, 13.37f + tx6, 34.19f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.78f + tx5, 28.51f)
            curveTo(8.93f + tx5, 28.56f, 11.34f + tx5, 28.51f, 13.37f + tx5, 28.51f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(6.84f + tx3, 16.79f)
            curveTo(8.87f + tx3, 16.84f, 11.14f + tx3, 16.79f, 13.04f + tx3, 16.79f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.11f + tx2, 11.68f)
            curveTo(8.92f + tx2, 11.73f, 11.07f + tx2, 11.66f, 12.77f + tx2, 11.66f)
        }
        path(
            stroke = SolidColor(Color.Black),
            strokeAlpha = 0.175377f,
            strokeLineWidth = 0.25f
        ) {
            moveTo(7.8f + tx1, 5.61f)
            curveTo(9.22f + tx1, 5.67f, 10.82f + tx1, 5.61f, 12.16f + tx1, 5.62f)
        }
        path(
            fill = SolidColor(Color(0xFFD78781)),
            strokeLineWidth = 0.107805f
        ) {
            moveTo(7.01f + tx4, 19.95f)
            lineTo(12.99f + tx4, 19.95f)
            curveTo(13.83f + tx4, 19.95f, 14.5f + tx4, 20.53f, 14.5f + tx4, 21.25f)
            lineTo(14.5f + tx4, 24.16f)
            curveTo(14.5f + tx4, 24.88f, 13.83f + tx4, 25.46f, 12.99f + tx4, 25.46f)
            lineTo(7.01f + tx4, 25.46f)
            curveTo(6.17f + tx4, 25.46f, 5.5f + tx4, 24.88f, 5.5f + tx4, 24.16f)
            lineTo(5.5f + tx4, 21.25f)
            curveTo(5.5f + tx4, 20.53f, 6.17f + tx4, 19.95f, 7.01f + tx4, 19.95f)
            close()
        }
    }.build()
}