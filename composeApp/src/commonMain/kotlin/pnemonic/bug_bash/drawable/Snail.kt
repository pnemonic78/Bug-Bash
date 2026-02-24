package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.bug.Snail
import pnemonic.stateOf

private const val durationCrawl = 1000

@Composable
fun snail(bug: Snail): ImageVector = snail(bug.isSquashed)

@Composable
fun snail(squashed: Boolean = false): ImageVector {
    val crawl1: State<Float>
    val crawl2: State<Float>

    if (squashed) {
        crawl1 = stateOf(1f)
        crawl2 = crawl1
    } else {
        val transition = rememberInfiniteTransition()
        crawl1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -5f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
        crawl2 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.85f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    return ImageVector.Builder(
        name = "Snail",
        defaultWidth = 49.dp,
        defaultHeight = 106.dp,
        viewportWidth = 49f,
        viewportHeight = 106f
    ).apply {
        group("body-1", scaleY = crawl2.value) {
            path(fill = SolidColor(Color(0xFFE9CEA9))) {
                moveToRelative(38.02f, 28.32f)
                curveToRelative(-1.36f, -1.74f, -2.96f, -3.26f, -4.32f, -5f)
                curveToRelative(-1.27f, -1.62f, -2.37f, -3.38f, -3.11f, -5.31f)
                curveToRelative(-0.9f, -2.37f, -2.56f, -4.91f, -5.01f, -5.89f)
                curveToRelative(-1.15f, -0.46f, -2.46f, -0.65f, -3.66f, -0.28f)
                curveToRelative(-1.01f, 0.31f, -1.91f, 0.89f, -2.69f, 1.59f)
                curveToRelative(-1.76f, 1.56f, -3.11f, 3.53f, -4.39f, 5.48f)
                curveToRelative(-0.36f, 0.55f, -5.86f, 13.26f, -8.08f, 19.12f)
                curveToRelative(-2.38f, 6.29f, -3.91f, 13.05f, -3.82f, 19.81f)
                curveToRelative(0.09f, 6.41f, 1.16f, 12.86f, 3.89f, 18.7f)
                curveToRelative(2.78f, 5.96f, 8.08f, 10.11f, 12.05f, 15.2f)
                curveToRelative(2.11f, 2.7f, 4.11f, 5.48f, 6.14f, 8.23f)
                curveToRelative(1.57f, 2.13f, 3.55f, 4.92f, 6.11f, 5.9f)
                curveToRelative(2.25f, 0.86f, 3.87f, -1.7f, 4.57f, -3.44f)
                curveToRelative(1.13f, -2.82f, 1.79f, -5.85f, 2.37f, -8.82f)
                curveToRelative(0.69f, -3.52f, 1.23f, -7.07f, 2.03f, -10.57f)
                curveToRelative(0.76f, -3.32f, 1.39f, -6.66f, 1.92f, -10.02f)
                curveToRelative(1.1f, -6.99f, 1.49f, -14.1f, 1.29f, -21.17f)
                curveToRelative(-0.19f, -6.58f, -0.85f, -13.29f, -2.74f, -19.6f)
                curveToRelative(-0.74f, -1.37f, -1.59f, -2.68f, -2.56f, -3.92f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFC4A172)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f
            ) {
                moveToRelative(38.63f, 37.95f)
                curveToRelative(-1.67f, -1.87f, -3.9f, -3.24f, -4.99f, -5.59f)
                curveToRelative(-1.24f, -2.67f, -1.35f, -5.73f, -1.98f, -8.57f)
                curveToRelative(-0.44f, -1.96f, -0.81f, -3.94f, -1.12f, -5.92f)
                curveToRelative(-0.92f, -2.33f, -2.56f, -4.79f, -4.96f, -5.75f)
                curveToRelative(-1.15f, -0.46f, -2.46f, -0.65f, -3.66f, -0.28f)
                curveToRelative(-1.01f, 0.31f, -1.91f, 0.89f, -2.69f, 1.59f)
                curveToRelative(-1.76f, 1.56f, -3.11f, 3.53f, -4.39f, 5.48f)
                curveToRelative(-0.03f, 0.05f, -0.11f, 0.21f, -0.23f, 0.46f)
                curveToRelative(0.03f, 0.04f, 0.04f, 0.08f, 0.05f, 0.13f)
                curveToRelative(0.19f, 2.57f, -0.58f, 5.14f, -0.89f, 7.67f)
                curveToRelative(-0.28f, 2.33f, -0.68f, 4.57f, -1.84f, 6.64f)
                curveToRelative(-1.95f, 3.49f, -4.95f, 6.25f, -6.97f, 9.68f)
                curveToRelative(-1.31f, 4.66f, -2.08f, 9.5f, -2.01f, 14.33f)
                curveToRelative(0.09f, 6.41f, 1.16f, 12.86f, 3.89f, 18.7f)
                curveToRelative(2.78f, 5.96f, 8.08f, 10.11f, 12.05f, 15.2f)
                curveToRelative(2.11f, 2.7f, 4.11f, 5.48f, 6.14f, 8.23f)
                curveToRelative(1.57f, 2.13f, 3.55f, 4.92f, 6.11f, 5.9f)
                curveToRelative(2.25f, 0.86f, 3.87f, -1.7f, 4.57f, -3.44f)
                curveToRelative(1.13f, -2.82f, 1.79f, -5.85f, 2.37f, -8.82f)
                curveToRelative(0.69f, -3.52f, 1.23f, -7.07f, 2.03f, -10.57f)
                curveToRelative(0.76f, -3.32f, 1.39f, -6.66f, 1.92f, -10.02f)
                curveToRelative(1.1f, -6.99f, 1.49f, -14.1f, 1.29f, -21.17f)
                curveToRelative(-0.07f, -2.34f, -0.19f, -4.7f, -0.42f, -7.05f)
                curveToRelative(-1.39f, -2.28f, -2.47f, -4.83f, -4.27f, -6.83f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC4A172))) {
                moveToRelative(37.16f, 95.98f)
                curveToRelative(0.41f, -3.29f, 1f, -6.7f, 0.59f, -10.01f)
                curveToRelative(-0.43f, -3.53f, -1.22f, -6.99f, -1.91f, -10.47f)
                curveToRelative(-0.43f, -2.19f, -0.9f, -4.39f, -1.63f, -6.51f)
                curveToRelative(-0.78f, -2.26f, -1.83f, -4.55f, -3.53f, -6.27f)
                curveToRelative(-1.78f, -1.8f, -4.24f, -2.89f, -6.8f, -2.67f)
                curveToRelative(-6.05f, 0.53f, -7.79f, 7.52f, -8.07f, 12.53f)
                curveToRelative(-0.58f, 10.5f, 4.71f, 19.81f, 10.09f, 28.57f)
                curveToRelative(1.42f, 1.88f, 3.13f, 3.91f, 5.23f, 4.71f)
                curveToRelative(2.25f, 0.86f, 3.87f, -1.7f, 4.57f, -3.44f)
                curveToRelative(0.44f, -1.1f, 0.81f, -2.23f, 1.13f, -3.37f)
                curveToRelative(0.08f, -1.03f, 0.2f, -2.05f, 0.33f, -3.07f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC4A172))) {
                moveToRelative(15.12f, 46.84f)
                curveToRelative(4.54f, 0.88f, 9.31f, -0.24f, 13.52f, -1.97f)
                curveToRelative(1.55f, -0.64f, 3.08f, -1.37f, 4.56f, -2.2f)
                curveToRelative(-0.38f, -3.56f, -0.74f, -7.54f, -1.16f, -10.65f)
                curveToRelative(-0.86f, -6.39f, 0.35f, -22.34f, -9.25f, -23.03f)
                curveToRelative(-5.42f, -0.39f, -7.04f, 5.42f, -7.53f, 9.7f)
                curveToRelative(-0.27f, 2.34f, -0.65f, 4.85f, -0.64f, 7.2f)
                curveToRelative(0f, 1.81f, -0.09f, 3.61f, -0.26f, 5.41f)
                curveToRelative(-0.33f, 3.56f, -0.93f, 7.08f, -1.38f, 10.62f)
                curveToRelative(-0.17f, 1.36f, -0.33f, 2.72f, -0.48f, 4.08f)
                curveToRelative(0.84f, 0.36f, 1.71f, 0.64f, 2.63f, 0.81f)
                close()
            }
        }
        // right antenna
        path(fill = SolidColor(Color(0xFFE9CEA9))) {
            moveToRelative(27.09f, 11.34f)
            curveToRelative(0f, 0f, 9.95f, -7.65f, 12f, -10.11f)
            curveToRelative(0f, 0f, 0.16f, -0.24f, 0.37f, -0.85f)
            curveToRelative(0.21f, -0.62f, 1.88f, -0.54f, 1.25f, 0.81f)
            curveToRelative(0f, 0f, -0.44f, 0.28f, -1.1f, 0.52f)
            curveToRelative(-0.66f, 0.24f, -11.1f, 11.91f, -11.1f, 11.91f)
            curveToRelative(0f, 0f, -2.36f, -0.55f, -1.41f, -2.28f)
            close()
        }
        // left antenna
        path(fill = SolidColor(Color(0xFFE9CEA9))) {
            moveToRelative(18.43f, 11.58f)
            curveToRelative(0f, 0f, -10.36f, -7.08f, -12.55f, -9.42f)
            curveToRelative(0f, 0f, -0.17f, -0.23f, -0.41f, -0.83f)
            curveToRelative(-0.24f, -0.61f, -1.91f, -0.43f, -1.2f, 0.88f)
            curveToRelative(0f, 0f, 0.45f, 0.26f, 1.13f, 0.46f)
            curveToRelative(0.68f, 0.2f, 11.75f, 11.27f, 11.75f, 11.27f)
            curveToRelative(0f, 0f, 2.32f, -0.68f, 1.28f, -2.36f)
            close()
        }
        group("shell", translationY = crawl1.value) {
            path(fill = SolidColor(Color(0xFFA25D1C))) {
                moveToRelative(43.26f, 44.84f)
                curveToRelative(0f, 0f, -5.22f, -13.21f, -21.75f, -11.21f)
                curveToRelative(-16.52f, 2.01f, -23.66f, 16.33f, -20.95f, 33.39f)
                curveToRelative(2.71f, 17.06f, 26.23f, 32.01f, 40.03f, 13.65f)
                curveToRelative(12.08f, -16.06f, 2.67f, -35.83f, 2.67f, -35.83f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB58C7A)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f
            ) {
                moveToRelative(43.26f, 44.84f)
                curveToRelative(0f, 0f, -5.22f, -13.21f, -21.75f, -11.21f)
                curveToRelative(-0.41f, 0.05f, -0.82f, 0.11f, -1.22f, 0.18f)
                curveToRelative(2.06f, -0.14f, 4.13f, -0.06f, 6.14f, 0.24f)
                curveToRelative(4.22f, 0.63f, 8.58f, 2.29f, 11.36f, 5.66f)
                curveToRelative(0.68f, 0.82f, 1.25f, 1.72f, 1.71f, 2.68f)
                curveToRelative(0.32f, 0.67f, 0.68f, 1.5f, 0.51f, 2.27f)
                curveToRelative(-0.3f, 1.32f, -1.94f, 1.49f, -3.05f, 1.56f)
                curveToRelative(-1.68f, 0.1f, -3.4f, -0.09f, -5.06f, 0.29f)
                curveToRelative(-2.57f, 0.58f, -5.04f, 1.59f, -7.23f, 3.07f)
                curveToRelative(-4.56f, 3.06f, -7.63f, 7.82f, -8.54f, 13.24f)
                curveToRelative(-0.59f, 3.51f, -0.16f, 7.02f, 0.07f, 10.53f)
                curveToRelative(0.17f, 2.5f, 0.45f, 5.64f, -1.02f, 7.86f)
                curveToRelative(-1.07f, 1.62f, -3.08f, 2.34f, -4.96f, 1.9f)
                curveToRelative(-0.08f, -0.02f, -0.15f, -0.04f, -0.23f, -0.06f)
                curveToRelative(8.8f, 7.47f, 21.71f, 9.45f, 30.6f, -2.37f)
                curveToRelative(12.08f, -16.06f, 2.67f, -35.83f, 2.67f, -35.83f)
                close()
            }
            path(fill = SolidColor(Color(0xFFBB6C21))) {
                moveToRelative(47.89f, 69.47f)
                curveToRelative(1.31f, -5.79f, 0.8f, -11.96f, -2.18f, -16.94f)
                curveToRelative(-1.24f, -2.07f, -3.81f, -4.37f, -6.22f, -4.97f)
                curveToRelative(-10.45f, -2.61f, -21.52f, 8.3f, -21.39f, 20.9f)
                curveToRelative(0.13f, 12.6f, 13.15f, 22.71f, 21.94f, 14.84f)
                curveToRelative(3.84f, -3.44f, 6.63f, -8.47f, 7.85f, -13.83f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB58C7A)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f
            ) {
                moveToRelative(45.72f, 52.53f)
                curveToRelative(-1.24f, -2.07f, -3.81f, -4.37f, -6.22f, -4.97f)
                curveToRelative(-7.8f, -1.95f, -15.95f, 3.64f, -19.52f, 11.84f)
                curveToRelative(0.4f, -0.72f, 0.83f, -1.43f, 1.29f, -2.11f)
                curveToRelative(1.43f, -2.1f, 3.15f, -4.07f, 5.24f, -5.54f)
                curveToRelative(1.82f, -1.28f, 4.07f, -2.35f, 6.35f, -2.24f)
                curveToRelative(1.91f, 0.09f, 4.09f, 0.74f, 5.42f, 2.19f)
                curveToRelative(0.59f, 0.64f, 1.12f, 1.54f, 1.07f, 2.45f)
                curveToRelative(-0.06f, 1.08f, -0.73f, 2f, -1.45f, 2.77f)
                curveToRelative(-0.84f, 0.9f, -1.8f, 1.69f, -2.67f, 2.56f)
                curveToRelative(-1.1f, 1.09f, -2.17f, 2.23f, -3.03f, 3.52f)
                curveToRelative(-1.91f, 2.86f, -2.75f, 6.24f, -2.7f, 9.66f)
                curveToRelative(0.02f, 1.46f, 0.47f, 3.07f, -0.12f, 4.47f)
                curveToRelative(-0.43f, 1.03f, -1.2f, 1.93f, -2.21f, 2.43f)
                curveToRelative(-0.93f, 0.45f, -2f, 0.64f, -3.02f, 0.38f)
                curveToRelative(-1.08f, -0.28f, -2.02f, -0.98f, -2.82f, -1.73f)
                curveToRelative(-0.37f, -0.35f, -0.71f, -0.72f, -1.03f, -1.11f)
                curveToRelative(4.1f, 7.86f, 13.13f, 12.14f, 19.75f, 6.21f)
                curveToRelative(3.84f, -3.44f, 6.63f, -8.47f, 7.85f, -13.83f)
                curveToRelative(1.32f, -5.79f, 0.8f, -11.96f, -2.18f, -16.94f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA25D1C))) {
                moveToRelative(48.4f, 67f)
                curveToRelative(0.01f, -0.02f, 0.02f, -0.04f, 0.02f, -0.06f)
                curveToRelative(0f, 0f, -0.04f, -0.1f, -0.07f, -0.07f)
                curveToRelative(-0.01f, -0.03f, -0.03f, -0.06f, -0.04f, -0.1f)
                curveToRelative(-0.02f, -0.16f, -0.08f, -0.32f, -0.17f, -0.47f)
                curveToRelative(-0.13f, -3.55f, -1.12f, -10.49f, -6.88f, -9f)
                curveToRelative(-6.21f, 1.6f, -9.16f, 8.16f, -9.36f, 13.75f)
                curveToRelative(-0.13f, 3.83f, 1.19f, 11.13f, 6.44f, 11.13f)
                curveToRelative(3.05f, 0.48f, 6.11f, -1.13f, 7.97f, -3.49f)
                curveToRelative(1.93f, -2.45f, 2.75f, -5.57f, 2.69f, -8.66f)
                curveToRelative(-0.02f, -0.93f, -0.21f, -2.02f, -0.6f, -3.02f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB58C7A)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f
            ) {
                moveToRelative(48.83f, 68.51f)
                curveToRelative(-0.04f, 0.4f, -0.15f, 0.77f, -0.34f, 1.04f)
                curveToRelative(-0.25f, 0.36f, -0.6f, 0.55f, -1.04f, 0.44f)
                curveToRelative(-0.47f, -0.11f, -0.74f, -0.53f, -1.26f, -0.52f)
                curveToRelative(-0.43f, 0.01f, -0.86f, 0.08f, -1.26f, 0.23f)
                curveToRelative(-2.74f, 1.06f, -2.49f, 4.79f, -1.43f, 6.98f)
                curveToRelative(0.03f, 0.07f, 0f, 0.18f, -0.09f, 0.17f)
                curveToRelative(-1.56f, -0.08f, -2.24f, -1.75f, -2.53f, -3.06f)
                curveToRelative(-0.36f, -1.62f, -0.39f, -3.32f, 0.2f, -4.9f)
                curveToRelative(0.66f, -1.76f, 2.04f, -3.36f, 4.05f, -3.43f)
                curveToRelative(0.94f, -0.03f, 2.22f, 0.34f, 3.1f, 1.04f)
                curveToRelative(-0.03f, -0.07f, -0.06f, -0.13f, -0.09f, -0.2f)
                curveToRelative(-0.13f, -3.55f, -1.12f, -10.49f, -6.88f, -9f)
                curveToRelative(-0.8f, 0.21f, -1.54f, 0.49f, -2.23f, 0.85f)
                curveToRelative(0.74f, -0.18f, 1.54f, -0.14f, 2.2f, 0.28f)
                curveToRelative(0.77f, 0.48f, 0.65f, 1.46f, 0.35f, 2.19f)
                curveToRelative(-0.38f, 0.94f, -0.97f, 1.76f, -1.56f, 2.58f)
                curveToRelative(-0.78f, 1.08f, -1.54f, 2.18f, -2.14f, 3.37f)
                curveToRelative(-1.28f, 2.51f, -1.67f, 5.17f, -1.36f, 7.95f)
                curveToRelative(0.09f, 0.82f, 0.27f, 2.16f, -0.52f, 2.73f)
                curveToRelative(-0.88f, 0.63f, -1.72f, 0.02f, -2.32f, -0.7f)
                curveToRelative(-1.12f, -1.36f, -1.65f, -3.1f, -1.79f, -4.87f)
                curveToRelative(0.02f, 3.95f, 1.47f, 10.51f, 6.45f, 10.5f)
                curveToRelative(3.05f, 0.48f, 6.11f, -1.13f, 7.97f, -3.49f)
                curveToRelative(1.93f, -2.45f, 2.75f, -5.57f, 2.69f, -8.66f)
                curveToRelative(-0.01f, -0.47f, -0.06f, -0.99f, -0.17f, -1.51f)
                close()
                moveTo(46.44f, 71.24f)
                curveToRelative(-0.06f, 0.57f, -0.31f, 1.06f, -0.77f, 1.42f)
                curveToRelative(-0.36f, 0.28f, -0.8f, 0.54f, -0.9f, 1.03f)
                curveToRelative(-0.13f, 0.6f, 0.08f, 1.13f, 0.33f, 1.66f)
                curveToRelative(0.04f, 0.09f, -0.02f, 0.18f, -0.12f, 0.17f)
                curveToRelative(-2.2f, -0.34f, -1.61f, -3.87f, -0.24f, -4.93f)
                curveToRelative(0.23f, -0.23f, 0.52f, -0.36f, 0.89f, -0.34f)
                curveToRelative(0.18f, 0.01f, 0.35f, 0.09f, 0.49f, 0.2f)
                curveToRelative(0.04f, 0.02f, 0.08f, 0.04f, 0.11f, 0.07f)
                curveToRelative(0.04f, 0.03f, 0.06f, 0.08f, 0.05f, 0.12f)
                curveToRelative(0.12f, 0.17f, 0.19f, 0.39f, 0.17f, 0.6f)
                close()
            }
        }
    }.build()
}