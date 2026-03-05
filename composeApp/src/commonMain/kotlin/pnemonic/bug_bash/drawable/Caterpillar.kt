package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
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
import pnemonic.bug_bash.model.bug.Caterpillar
import pnemonic.stateOf

private const val durationCrawl = 1000
private const val offsetCrawl = 200

@Composable
fun caterpillar(bug: Caterpillar): ImageVector = caterpillar(bug.isSquashed)

@Composable
fun caterpillar(squashed: Boolean = false): ImageVector {
    val crawl1: State<Float>
    val crawl2: State<Float>
    val crawl3: State<Float>
    val crawl4: State<Float>
    val crawl5: State<Float>
    val crawl6: State<Float>
    val crawl7: State<Float>
    val crawl8: State<Float>
    val crawl9: State<Float>
    val crawl10: State<Float>

    if (squashed) {
        crawl1 = stateOf(0f)
        crawl2 = crawl1
        crawl3 = crawl1
        crawl4 = crawl1
        crawl5 = crawl1
        crawl6 = crawl1
        crawl7 = crawl1
        crawl8 = crawl1
        crawl9 = crawl1
        crawl10 = stateOf(1f)
    } else {
        val transition = rememberInfiniteTransition()
        crawl1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(offsetCrawl * 4)
            )
        )
        crawl2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(offsetCrawl * 3)
            )
        )
        crawl3 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(offsetCrawl * 2)
            )
        )
        crawl4 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(offsetCrawl * 1)
            )
        )
        crawl5 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(offsetCrawl * 0)
            )
        )
        crawl6 = crawl1
        crawl7 = crawl2
        crawl8 = crawl3
        crawl9 = crawl4
        crawl10 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.95f,
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
        name = "Caterpillar",
        defaultWidth = 23.5.dp,
        defaultHeight = 60.dp,
        viewportWidth = 23.5f,
        viewportHeight = 60f
    ).apply {
        group(name = "leg-r1", translationY = crawl1.value) {
            legR1()
        }
        group(name = "leg-r2", translationY = crawl2.value) {
            legR2()
        }
        group(name = "leg-r3", translationY = crawl3.value) {
            legR3()
        }
        group(name = "leg-r4", translationY = crawl4.value) {
            legR4()
        }
        group(name = "leg-r5", translationY = crawl5.value) {
            legR5()
        }
        group(name = "leg-r6", translationY = crawl6.value) {
            legR6()
        }
        group(name = "leg-r7", translationY = crawl7.value) {
            legR7()
        }
        group(name = "leg-r8", translationY = crawl8.value) {
            legR8()
        }
        group(name = "leg-l1", translationY = crawl1.value) {
            legL1()
        }
        group(name = "leg-l2", translationY = crawl2.value) {
            legL2()
        }
        group(name = "leg-l3", translationY = crawl3.value) {
            legL3()
        }
        group(name = "leg-l4", translationY = crawl4.value) {
            legL4()
        }
        group(name = "leg-l5", translationY = crawl5.value) {
            legL5()
        }
        group(name = "leg-l6", translationY = crawl6.value) {
            legL6()
        }
        group(name = "leg-l7", translationY = crawl7.value) {
            legL7()
        }
        group(name = "leg-l8", translationY = crawl8.value) {
            legL8()
        }
        group(name = "face") {
            path(fill = SolidColor(Color(0xFF352826))) {
                moveTo(14.364f, 2.442f)
                lineToRelative(-0.368f, 0.904f)
                lineToRelative(-1.653f, 0.362f)
                lineToRelative(-3.676f, 0.181f)
                lineToRelative(-0.459f, -1.176f)
                lineToRelative(0.183f, -1.447f)
                lineToRelative(1.103f, -0.633f)
                lineToRelative(1.745f, -0.633f)
                lineToRelative(1.746f, 0.452f)
                lineToRelative(1.01f, 0.995f)
                close()
            }
            path(fill = SolidColor(Color(0xFF050303))) {
                moveToRelative(8.391f, 1.266f)
                lineToRelative(-0.027f, 0.21f)
                lineToRelative(0.946f, 0.332f)
                curveToRelative(0f, 0f, 0.734f, -0.091f, 0.919f, -0.452f)
                curveToRelative(0.183f, -0.362f, 0.367f, -0.814f, 0.367f, -0.814f)
                lineToRelative(-0.181f, -0.243f)
                lineToRelative(-0.922f, 0.335f)
                close()
            }
            path(fill = SolidColor(Color(0xFF050303))) {
                moveToRelative(12.985f, 0.452f)
                lineToRelative(-1.316f, -0.34f)
                curveToRelative(-0.008f, 0.215f, 0.017f, 0.419f, 0.121f, 0.521f)
                curveToRelative(0.276f, 0.271f, 0.736f, 0.723f, 0.736f, 0.723f)
                lineToRelative(0.735f, 0.181f)
                curveToRelative(0f, 0f, 0.366f, -0.09f, 0.734f, -0.09f)
                close()
            }
        }
        group(name = "body", scaleY = crawl10.value) {
            body()
        }
        group(name = "yellow-stripe", scaleY = crawl10.value) {
            path(fill = SolidColor(Color(0xFFDCAF22))) {
                moveToRelative(13.813f, 10.851f)
                lineToRelative(-0.728f, -8.519f)
                lineToRelative(-1.661f, -0.523f)
                lineToRelative(-1.649f, 0.837f)
                lineToRelative(-0.189f, 0.096f)
                lineToRelative(0f, 2.141f)
                curveToRelative(0f, 0f, 0.275f, 3.979f, 0.367f, 4.25f)
                curveToRelative(0.092f, 0.271f, 0.276f, 3.797f, 0.276f, 3.797f)
                curveToRelative(0f, 0f, 0.459f, 7.595f, 0.459f, 8.048f)
                curveToRelative(0f, 0.452f, 0.092f, 5.063f, 0.092f, 5.063f)
                lineToRelative(-0.367f, 8.5f)
                lineToRelative(-0.093f, 5.244f)
                lineToRelative(0.46f, 7.957f)
                lineToRelative(0.092f, 6.781f)
                lineToRelative(0.643f, 3.075f)
                lineToRelative(0.241f, 2.082f)
                curveToRelative(0.225f, 0.104f, 0.402f, 0.178f, 0.402f, 0.178f)
                lineToRelative(1.287f, -0.271f)
                lineToRelative(0.405f, -0.504f)
                lineToRelative(-0.313f, -1.757f)
                curveToRelative(0f, 0f, 0.367f, -6.691f, 0.367f, -6.962f)
                curveToRelative(0f, -0.271f, 0f, -10.037f, 0f, -10.037f)
                lineToRelative(0.828f, -9.495f)
                lineToRelative(-0.093f, -9.223f)
                close()
            }
        }
        group(name = "thorax1", translationY = crawl1.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveToRelative(12.157f, 8.952f)
                lineToRelative(2.207f, -0.271f)
                lineToRelative(0.916f, -0.343f)
                curveToRelative(0.129f, -0.256f, 0.278f, -0.587f, 0.278f, -0.742f)
                curveToRelative(0f, -0.141f, 0.075f, -0.503f, 0.146f, -0.868f)
                lineToRelative(-1.432f, 0.597f)
                lineToRelative(-2.757f, 0.091f)
                lineToRelative(-2.94f, -0.362f)
                lineToRelative(-1.719f, -1.619f)
                lineToRelative(0.158f, 1.709f)
                lineToRelative(0.828f, 1.356f)
                lineToRelative(0f, 0.066f)
                lineToRelative(1.561f, 0.205f)
                close()
            }
        }
        group(name = "thorax2", translationY = crawl2.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveTo(15.999f, 13.943f)
                lineToRelative(-2.278f, 0.796f)
                lineToRelative(-2.297f, 0.181f)
                lineToRelative(-3.124f, -0.09f)
                lineToRelative(-1.442f, -0.887f)
                lineToRelative(0.064f, 1.067f)
                lineToRelative(0.592f, 0.841f)
                lineToRelative(1.245f, 0.335f)
                lineToRelative(2.297f, 0.453f)
                lineToRelative(2.206f, -0.362f)
                lineToRelative(1.929f, -0.542f)
                lineToRelative(0.442f, -0.27f)
                lineToRelative(-0.074f, -0.363f)
                close()
            }
        }
        group(name = "abdomen3", translationY = crawl3.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveToRelative(14.18f, 21.882f)
                lineToRelative(1.297f, -0.153f)
                lineToRelative(-0.01f, -0.028f)
                lineToRelative(0.551f, -0.723f)
                curveToRelative(0f, 0f, 0.573f, -1.19f, 0.764f, -1.745f)
                lineToRelative(-2.235f, 0.841f)
                lineToRelative(-2.939f, 0.09f)
                lineToRelative(-2.941f, -0.09f)
                lineToRelative(-1.909f, -0.671f)
                lineToRelative(-0.02f, 0.309f)
                lineToRelative(0.368f, 1.266f)
                lineToRelative(0.809f, 0.619f)
                lineToRelative(2.223f, 0.375f)
                close()
            }
        }
        group(name = "abdomen4", translationY = crawl4.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveTo(12.068f, 26.313f)
                lineToRelative(-3.217f, -0.271f)
                lineToRelative(-1.841f, -0.873f)
                lineToRelative(-0.087f, 0.782f)
                lineToRelative(0.459f, 1.085f)
                lineToRelative(0.389f, 0.469f)
                lineToRelative(3.286f, 0.526f)
                lineToRelative(3.308f, -0.181f)
                lineToRelative(1.806f, -0.474f)
                lineToRelative(0.675f, -1.244f)
                lineToRelative(0f, -1.189f)
                lineToRelative(-2.298f, 0.918f)
                close()
            }
        }
        group(name = "abdomen5", translationY = crawl5.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveTo(7.105f, 31.793f)
                lineToRelative(0f, 0.488f)
                lineToRelative(0.367f, 0.995f)
                lineToRelative(0.528f, 0.445f)
                lineToRelative(1.218f, 0.369f)
                lineToRelative(2.113f, 0.362f)
                lineToRelative(3.307f, -0.362f)
                lineToRelative(1.287f, -0.533f)
                lineToRelative(0f, -0.281f)
                lineToRelative(0.735f, -1.266f)
                lineToRelative(0.077f, -0.588f)
                lineToRelative(-2.374f, 1.131f)
                lineToRelative(-3.401f, 0.723f)
                lineToRelative(-2.572f, -0.723f)
                close()
            }
        }
        group(name = "abdomen6", translationY = crawl6.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveToRelative(11.332f, 37.706f)
                lineToRelative(-3.124f, -0.09f)
                lineToRelative(-1.275f, -0.816f)
                lineToRelative(-0.103f, 0.544f)
                lineToRelative(0.459f, 1.266f)
                lineToRelative(0.305f, 0.385f)
                lineToRelative(0.981f, 0.338f)
                lineToRelative(1.745f, 0.091f)
                lineToRelative(2.298f, 0f)
                lineToRelative(2.48f, -0.181f)
                lineToRelative(1.355f, -0.555f)
                curveToRelative(0.187f, -0.262f, 0.354f, -0.512f, 0.391f, -0.62f)
                curveToRelative(0.092f, -0.272f, 0.367f, -1.809f, 0.367f, -1.809f)
                lineToRelative(-0.054f, -0.146f)
                lineToRelative(-2.702f, 1.14f)
                close()
            }
        }
        group(name = "abdomen7", translationY = crawl7.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveTo(11.332f, 44.488f)
                lineToRelative(-3.124f, -0.633f)
                lineToRelative(-1.563f, -0.984f)
                lineToRelative(0f, 0.441f)
                lineToRelative(0.46f, 1.266f)
                lineToRelative(0.589f, 0.709f)
                lineToRelative(1.065f, 0.285f)
                lineToRelative(2.022f, 0.452f)
                lineToRelative(2.389f, 0.271f)
                lineToRelative(2.572f, -0.181f)
                lineToRelative(0.848f, -0.493f)
                lineToRelative(0.255f, -1.587f)
                lineToRelative(0f, -0.712f)
                lineToRelative(-0.552f, 0.351f)
                lineToRelative(-2.02f, 0.452f)
                close()
            }
        }
        group(name = "abdomen8", translationY = crawl8.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveTo(7.472f, 51.541f)
                lineToRelative(0.711f, 0.873f)
                lineToRelative(1.495f, 0.393f)
                lineToRelative(2.204f, 0.091f)
                lineToRelative(2.664f, -0.271f)
                lineToRelative(1.48f, -0.38f)
                lineToRelative(0.726f, -1.429f)
                lineToRelative(-0.105f, -0.93f)
                lineToRelative(-2.284f, 0.75f)
                lineToRelative(-3.216f, 0.271f)
                lineToRelative(-2.573f, -0.362f)
                lineToRelative(-1.828f, -1.116f)
                lineToRelative(-0.01f, 0.031f)
                close()
            }
        }
        group(name = "abdomen9", translationY = crawl9.value) {
            path(fill = SolidColor(Color(0x80664400))) {
                moveToRelative(13.078f, 55.791f)
                curveToRelative(-0.276f, 0f, -2.481f, 0.361f, -2.481f, 0.361f)
                lineToRelative(-2.163f, -0.731f)
                lineToRelative(-0.043f, 0.46f)
                curveToRelative(0f, 0f, 0.827f, 0.905f, 1.102f, 0.995f)
                curveToRelative(0.191f, 0.063f, 0.554f, 0.467f, 0.762f, 0.714f)
                lineToRelative(0.984f, 0.1f)
                lineToRelative(2.757f, -0.452f)
                lineToRelative(0.888f, -0.38f)
                lineToRelative(0.031f, -0.525f)
                lineToRelative(0.827f, -0.633f)
                lineToRelative(0.091f, -0.27f)
                curveToRelative(-0.929f, 0.133f, -2.559f, 0.36f, -2.755f, 0.36f)
                close()
            }
        }
        group(name = "spiracle1", translationY = crawl1.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(9.126f, 6.149f)
                lineToRelative(-0.275f, -0.633f)
                lineToRelative(-0.184f, 0.542f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(14.18f, 5.335f)
                lineToRelative(-0.276f, 0.995f)
                lineToRelative(0.552f, 0f)
                curveToRelative(0f, 0f, 0.46f, 0.091f, 0.46f, -0.181f)
                curveToRelative(-0.001f, -0.271f, -0.736f, -0.814f, -0.736f, -0.814f)
                close()
            }
        }
        group(name = "spiracle2", translationY = crawl2.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(8.85f, 14.106f)
                lineToRelative(-0.827f, -0.633f)
                lineToRelative(0.368f, -0.904f)
                lineToRelative(0.919f, 0f)
                lineToRelative(0.275f, 0.994f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(15.098f, 13.654f)
                lineToRelative(0.552f, -0.543f)
                lineToRelative(0f, -0.723f)
                lineToRelative(-0.735f, -0.091f)
                lineToRelative(-0.46f, 0.905f)
                close()
            }
        }
        group(name = "spiracle3", translationY = crawl3.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(9.218f, 19.17f)
                lineToRelative(0.643f, -0.182f)
                lineToRelative(-0.092f, -1.265f)
                lineToRelative(-0.734f, 0.271f)
                lineToRelative(-0.552f, 0.723f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(15.007f, 17.361f)
                lineToRelative(-0.092f, 1.356f)
                lineToRelative(0.552f, 0.362f)
                curveToRelative(0f, 0f, 0.459f, -0.181f, 0.459f, -0.452f)
                curveToRelative(0f, -0.271f, -0.184f, -1.356f, -0.184f, -1.356f)
                close()
            }
        }
        group(name = "spiracle4", translationY = crawl4.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(9.218f, 23.148f)
                lineToRelative(-0.919f, 1.085f)
                lineToRelative(0.459f, 0.723f)
                curveToRelative(0f, 0f, 0.46f, 0.362f, 0.735f, 0.272f)
                curveToRelative(0.275f, -0.091f, 0.551f, -1.447f, 0.551f, -1.447f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(15.282f, 23.691f)
                lineToRelative(0f, 0.905f)
                lineToRelative(0.46f, 0.09f)
                curveToRelative(0.368f, -0.452f, -0.46f, -0.995f, -0.46f, -0.995f)
                close()
            }
        }
        group(name = "spiracle5", translationY = crawl5.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(9.953f, 30.201f)
                lineToRelative(-0.643f, -0.181f)
                lineToRelative(-0.736f, 0.814f)
                lineToRelative(0.275f, 0.724f)
                lineToRelative(0.644f, 0.091f)
                lineToRelative(0.459f, -0.543f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(15.467f, 31.015f)
                lineToRelative(0.459f, -0.271f)
                lineToRelative(0.092f, -0.995f)
                lineToRelative(-0.736f, -0.09f)
                lineToRelative(-0.184f, 1.085f)
                close()
            }
        }
        group(name = "spiracle6", translationY = crawl6.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(9.586f, 35.084f)
                lineToRelative(-0.643f, -0.091f)
                lineToRelative(-0.643f, 0.995f)
                lineToRelative(0.367f, 0.542f)
                lineToRelative(0.736f, 0f)
                lineToRelative(0.368f, -0.452f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(15.19f, 36.26f)
                lineToRelative(0.46f, -0.181f)
                lineToRelative(0.276f, -1.085f)
                lineToRelative(-0.919f, 0f)
                lineToRelative(-0.184f, 0.995f)
                close()
            }
        }
        group(name = "spiracle7", translationY = crawl7.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(9.035f, 41.323f)
                lineToRelative(-0.735f, 0.995f)
                lineToRelative(0.275f, 0.723f)
                lineToRelative(0.643f, 0.09f)
                curveToRelative(0f, 0f, 0.551f, -0.542f, 0.551f, -0.814f)
                curveToRelative(0f, -0.272f, -0.091f, -0.905f, -0.091f, -0.905f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(14.639f, 41.775f)
                lineToRelative(-0.093f, 0.995f)
                lineToRelative(0.552f, 0.181f)
                curveToRelative(0f, 0f, 0.46f, 0f, 0.552f, -0.272f)
                curveToRelative(0.092f, -0.271f, -0.276f, -1.175f, -0.276f, -1.175f)
                close()
            }
        }
        group(name = "spiracle8", translationY = crawl8.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(9.77f, 47.472f)
                lineToRelative(-0.551f, 0.09f)
                lineToRelative(-0.643f, 1.085f)
                lineToRelative(0.368f, 0.633f)
                lineToRelative(0.643f, 0f)
                lineToRelative(0.459f, -0.633f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveTo(15.007f, 49.642f)
                lineToRelative(0.46f, -0.362f)
                lineToRelative(-0.093f, -1.086f)
                lineToRelative(-0.735f, 0.182f)
                lineToRelative(-0.184f, 0.994f)
                close()
            }
        }
        group(name = "spiracle9", translationY = crawl9.value) {
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(9.679f, 53.711f)
                lineToRelative(-0.368f, 0.814f)
                curveToRelative(0.368f, 0.452f, 0.643f, 0.362f, 0.643f, 0.362f)
                lineToRelative(0.184f, -0.995f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8122))) {
                moveToRelative(14.272f, 53.801f)
                lineToRelative(0.092f, 0.814f)
                lineToRelative(0.551f, 0.091f)
                curveToRelative(0.367f, -0.633f, 0.183f, -1.447f, 0.183f, -1.447f)
                close()
            }
        }
    }.build()
}

private fun ImageVector.Builder.legR1() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(16.753f, 6.104f)
        lineToRelative(-0.276f, 0.361f)
        lineToRelative(-1.055f, 0.271f)
        lineToRelative(0.046f, -1.22f)
        lineToRelative(1.009f, 0f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.292f, 5.832f)
        curveToRelative(0f, 0f, 1.563f, -1.583f, 1.655f, -1.718f)
        curveToRelative(0.092f, -0.136f, 2.251f, -1.221f, 2.389f, -1.311f)
        curveToRelative(0.138f, -0.091f, 1.057f, -0.226f, 1.057f, -0.226f)
        lineToRelative(0f, 0.362f)
        lineToRelative(-1.7f, 0.632f)
        lineToRelative(-1.975f, 1.221f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.246f, 6.239f)
        lineToRelative(1.424f, 0.723f)
        curveToRelative(0f, 0f, 1.379f, 0.181f, 1.609f, 0.226f)
        curveToRelative(0.229f, 0.045f, 2.297f, 0.362f, 2.297f, 0.362f)
        lineToRelative(0.275f, -0.362f)
        lineToRelative(-1.102f, -0.226f)
        lineToRelative(-2.986f, -0.362f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.476f, 6.058f)
        lineToRelative(2.067f, -0.046f)
        curveToRelative(0f, 0f, 2.114f, 0f, 2.298f, -0.044f)
        curveToRelative(0.184f, -0.045f, 0.918f, -0.317f, 0.918f, -0.317f)
        lineToRelative(-0.092f, -0.542f)
        curveToRelative(0f, 0f, -0.689f, 0.226f, -0.919f, 0.272f)
        curveToRelative(-0.23f, 0.044f, -2.48f, 0.226f, -2.48f, 0.226f)
        lineToRelative(-1.424f, 0.226f)
        close()
    }
}

private fun ImageVector.Builder.legR2() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(16.89f, 13.157f)
        lineToRelative(0.138f, -0.452f)
        lineToRelative(-0.873f, -0.452f)
        lineToRelative(-0.046f, 1.085f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.522f, 12.795f)
        curveToRelative(0f, 0f, 1.976f, -1.22f, 2.113f, -1.266f)
        curveToRelative(0.138f, -0.046f, 3.032f, -0.316f, 3.032f, -0.316f)
        lineToRelative(0.047f, 0.588f)
        lineToRelative(-1.379f, -0.091f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.707f, 12.976f)
        lineToRelative(3.4f, 0.542f)
        lineToRelative(2.16f, 0.181f)
        lineToRelative(0.183f, -0.271f)
        curveToRelative(0f, 0f, -1.011f, -0.046f, -1.149f, -0.091f)
        curveToRelative(-0.138f, -0.045f, -2.389f, -0.407f, -2.389f, -0.407f)
        lineToRelative(-1.424f, -0.181f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.385f, 12.931f)
        lineToRelative(0.689f, 1.085f)
        curveToRelative(0f, 0f, 1.699f, 1.356f, 1.837f, 1.401f)
        curveToRelative(0.138f, 0.046f, 1.655f, 0.814f, 1.655f, 0.814f)
        lineToRelative(0.32f, -0.226f)
        lineToRelative(-0.965f, -0.497f)
        lineToRelative(-2.159f, -1.401f)
        close()
    }
}

private fun ImageVector.Builder.legR3() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.717f, 19.26f)
        lineToRelative(-0.736f, 0.181f)
        lineToRelative(-0.459f, -0.542f)
        lineToRelative(0.276f, -0.814f)
        lineToRelative(1.102f, 0.452f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(18.819f, 17.723f)
        lineToRelative(-1.47f, 0.904f)
        lineToRelative(1.562f, -1.899f)
        lineToRelative(2.481f, -0.271f)
        lineToRelative(0.459f, 0.362f)
        lineToRelative(-1.194f, 0.181f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.487f, 19.034f)
        lineToRelative(2.068f, 0.497f)
        lineToRelative(1.7f, 0.272f)
        lineToRelative(1.057f, 0.091f)
        curveToRelative(0.184f, 0.09f, 0.23f, -0.316f, 0.23f, -0.316f)
        lineToRelative(-0.506f, -0.091f)
        lineToRelative(-2.71f, -0.542f)
        lineToRelative(-1.655f, -0.181f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.212f, 18.988f)
        lineToRelative(1.241f, 0.678f)
        curveToRelative(0f, 0f, 1.562f, 0.588f, 1.7f, 0.633f)
        curveToRelative(0.138f, 0.045f, 1.195f, 0.452f, 1.195f, 0.452f)
        lineToRelative(0.367f, 0.316f)
        lineToRelative(-1.195f, -0.272f)
        lineToRelative(-2.113f, -0.769f)
        close()
    }
}

private fun ImageVector.Builder.legR4() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.625f, 25.228f)
        lineToRelative(-0.644f, 0.181f)
        lineToRelative(-0.55f, -0.181f)
        lineToRelative(0.138f, -0.814f)
        lineToRelative(1.011f, 0.317f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.166f, 24.866f)
        lineToRelative(1.838f, -1.221f)
        curveToRelative(0f, 0f, 2.526f, -0.859f, 2.664f, -0.904f)
        curveToRelative(0.138f, -0.045f, 1.241f, 0f, 1.241f, 0f)
        lineToRelative(0.047f, 0.317f)
        lineToRelative(-1.563f, 0.271f)
        lineToRelative(-2.113f, 0.543f)
        lineToRelative(-1.103f, 0.588f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.074f, 25.183f)
        lineToRelative(1.056f, 0.814f)
        curveToRelative(0f, 0f, 1.057f, 0.678f, 1.287f, 0.814f)
        curveToRelative(0.23f, 0.136f, 1.745f, 0.588f, 1.884f, 0.633f)
        curveToRelative(0.138f, 0.046f, 1.056f, 0.226f, 1.056f, 0.226f)
        lineToRelative(0.093f, -0.226f)
        lineToRelative(-1.654f, -0.497f)
        lineToRelative(-2.113f, -1.13f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.304f, 25.002f)
        curveToRelative(0f, 0f, 1.562f, -0.452f, 1.745f, -0.452f)
        curveToRelative(0.184f, 0f, 2.159f, 0.046f, 2.159f, 0.046f)
        lineToRelative(1.517f, 0.09f)
        lineToRelative(0f, 0.362f)
        lineToRelative(-1.103f, 0f)
        lineToRelative(-2.802f, -0.136f)
        close()
    }
}

private fun ImageVector.Builder.legR5() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.522f, 30.925f)
        lineToRelative(0.965f, 0.316f)
        lineToRelative(0.184f, 0.407f)
        curveToRelative(0f, 0f, -0.091f, 0.272f, -0.275f, 0.407f)
        curveToRelative(-0.184f, 0.136f, -0.551f, 0.272f, -0.551f, 0.272f)
        lineToRelative(-0.919f, -0.136f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.304f, 31.693f)
        lineToRelative(-0.138f, -0.271f)
        lineToRelative(2.204f, -1.583f)
        lineToRelative(2.481f, -0.362f)
        lineToRelative(1.471f, -0.135f)
        lineToRelative(0.046f, 0.316f)
        lineToRelative(-1.837f, 0.271f)
        lineToRelative(-2.251f, 0.497f)
        lineToRelative(-1.149f, 0.723f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.304f, 31.693f)
        lineToRelative(-0.276f, 0.271f)
        lineToRelative(1.424f, 0.995f)
        lineToRelative(1.654f, 0.678f)
        lineToRelative(2.572f, 0.678f)
        lineToRelative(0.506f, -0.226f)
        lineToRelative(-0.689f, -0.452f)
        lineToRelative(-2.528f, -0.588f)
        lineToRelative(-2.342f, -0.95f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(22.403f, 31.693f)
        lineToRelative(-1.608f, 0f)
        lineToRelative(-2.067f, 0f)
        lineToRelative(-1.792f, 0.136f)
        lineToRelative(0.092f, -0.271f)
        lineToRelative(2.298f, -0.091f)
        lineToRelative(2.756f, -0.226f)
        close()
    }
}

private fun ImageVector.Builder.legR6() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(18.177f, 36.802f)
        lineToRelative(-0.229f, 0.452f)
        lineToRelative(-1.425f, 0.091f)
        lineToRelative(0.23f, -1.447f)
        lineToRelative(1.24f, 0.226f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(17.671f, 36.35f)
        lineToRelative(1.7f, -0.859f)
        lineToRelative(2.895f, -0.407f)
        lineToRelative(0.826f, 0.181f)
        curveToRelative(-0.092f, 0.226f, -1.241f, 0.181f, -1.241f, 0.181f)
        lineToRelative(-1.975f, 0.271f)
        lineToRelative(-1.102f, 0.407f)
        lineToRelative(-0.918f, 0.452f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.671f, 36.848f)
        lineToRelative(-0.138f, 0.226f)
        lineToRelative(2.894f, 1.673f)
        lineToRelative(1.608f, 0.362f)
        lineToRelative(1.01f, 0.045f)
        lineToRelative(0f, -0.317f)
        lineToRelative(-1.286f, -0.181f)
        lineToRelative(-1.607f, -0.497f)
        lineToRelative(-1.379f, -0.905f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(21.99f, 36.757f)
        lineToRelative(-1.516f, -0.136f)
        lineToRelative(-1.562f, -0.226f)
        lineToRelative(-1.378f, 0.091f)
        curveToRelative(-0.046f, 0.181f, 1.93f, 0.407f, 1.93f, 0.407f)
        lineToRelative(2.481f, 0.497f)
        close()
    }
}

private fun ImageVector.Builder.legR7() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.978f, 42.604f)
        lineToRelative(-0.276f, 0.452f)
        lineToRelative(-1.333f, 0.091f)
        lineToRelative(0.046f, -1.221f)
        lineToRelative(1.15f, 0.091f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(22.618f, 41.112f)
        lineToRelative(-1.195f, 0.271f)
        lineToRelative(-2.526f, 0.407f)
        lineToRelative(-1.517f, 0.678f)
        lineToRelative(-0.229f, -0.316f)
        lineToRelative(2.941f, -1.086f)
        lineToRelative(2.435f, -0.316f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(19.632f, 44.91f)
        lineToRelative(2.94f, 1.401f)
        lineToRelative(0.827f, 0.091f)
        lineToRelative(0.047f, -0.271f)
        lineToRelative(-1.241f, -0.542f)
        lineToRelative(-2.526f, -1.311f)
        lineToRelative(-2.298f, -1.492f)
        lineToRelative(-0.414f, 0.091f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(16.967f, 42.378f)
        lineToRelative(2.389f, 0.181f)
        curveToRelative(0f, 0f, 2.159f, 0.091f, 2.297f, 0.136f)
        curveToRelative(0.138f, 0.045f, 1.7f, 0.316f, 1.7f, 0.316f)
        lineToRelative(0.046f, 0.407f)
        lineToRelative(-1.148f, -0.046f)
        lineToRelative(-3.078f, -0.588f)
        lineToRelative(-2.297f, -0.136f)
        close()
    }
}

private fun ImageVector.Builder.legR8() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(17.503f, 49.868f)
        lineToRelative(-0.735f, 0.316f)
        lineToRelative(-0.827f, -0.226f)
        lineToRelative(0.092f, -1.22f)
        lineToRelative(1.378f, 0.406f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(19.317f, 48.602f)
        lineToRelative(1.777f, -0.408f)
        lineToRelative(1.033f, 0.091f)
        lineToRelative(-0.082f, 0.317f)
        lineToRelative(-0.827f, 0.045f)
        lineToRelative(-2.108f, 0.362f)
        lineToRelative(-2.026f, 0.587f)
        lineToRelative(-0.083f, -0.272f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(16.879f, 49.778f)
        lineToRelative(-0.207f, 0.181f)
        lineToRelative(1.653f, 1.493f)
        lineToRelative(1.653f, 0.814f)
        lineToRelative(1.488f, 0.814f)
        lineToRelative(0.537f, -0.136f)
        lineToRelative(-0.744f, -0.407f)
        lineToRelative(-2.645f, -1.266f)
        lineToRelative(-0.951f, -0.678f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(21.301f, 50.32f)
        lineToRelative(-1.323f, 0f)
        lineToRelative(-1.942f, -0.18f)
        lineToRelative(-1.406f, -0.362f)
        lineToRelative(0.124f, -0.271f)
        lineToRelative(2.481f, 0.362f)
        lineToRelative(1.859f, 0.045f)
        close()
    }
}

private fun ImageVector.Builder.legL1() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.278f, 6.691f)
        lineToRelative(0.735f, 0.181f)
        lineToRelative(0.459f, -0.542f)
        lineToRelative(-0.275f, -0.814f)
        lineToRelative(-1.103f, 0.452f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(5.175f, 5.154f)
        lineToRelative(1.47f, 0.904f)
        lineToRelative(-1.562f, -1.899f)
        lineToRelative(-2.48f, -0.271f)
        lineToRelative(-0.46f, 0.362f)
        lineToRelative(1.194f, 0.181f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.508f, 6.465f)
        lineToRelative(-2.068f, 0.497f)
        lineToRelative(-1.7f, 0.271f)
        lineToRelative(-1.056f, 0.091f)
        curveToRelative(-0.184f, 0.091f, -0.229f, -0.316f, -0.229f, -0.316f)
        lineToRelative(0.505f, -0.091f)
        lineToRelative(2.711f, -0.543f)
        lineToRelative(1.653f, -0.18f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.783f, 6.42f)
        lineToRelative(-1.239f, 0.678f)
        curveToRelative(0f, 0f, -1.563f, 0.588f, -1.7f, 0.632f)
        curveToRelative(-0.139f, 0.045f, -1.195f, 0.452f, -1.195f, 0.452f)
        lineToRelative(-0.368f, 0.316f)
        lineToRelative(1.195f, -0.271f)
        lineToRelative(2.113f, -0.769f)
        close()
    }
}

private fun ImageVector.Builder.legL2() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.14f, 14.468f)
        lineToRelative(0.643f, 0.181f)
        lineToRelative(0.552f, -0.181f)
        lineToRelative(-0.138f, -0.814f)
        lineToRelative(-1.011f, 0.316f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.6f, 14.106f)
        lineToRelative(-1.837f, -1.221f)
        curveToRelative(0f, 0f, -2.527f, -0.859f, -2.665f, -0.904f)
        curveToRelative(-0.138f, -0.046f, -1.24f, 0f, -1.24f, 0f)
        lineToRelative(-0.047f, 0.316f)
        lineToRelative(1.563f, 0.272f)
        lineToRelative(2.112f, 0.542f)
        lineToRelative(1.103f, 0.588f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.692f, 14.422f)
        lineToRelative(-1.057f, 0.814f)
        curveToRelative(0f, 0f, -1.056f, 0.678f, -1.285f, 0.814f)
        curveToRelative(-0.23f, 0.136f, -1.746f, 0.588f, -1.885f, 0.633f)
        curveToRelative(-0.137f, 0.044f, -1.056f, 0.226f, -1.056f, 0.226f)
        lineToRelative(-0.093f, -0.226f)
        lineToRelative(1.654f, -0.497f)
        lineToRelative(2.113f, -1.13f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.463f, 14.242f)
        curveToRelative(0f, 0f, -1.563f, -0.452f, -1.746f, -0.452f)
        curveToRelative(-0.184f, 0f, -2.159f, 0.046f, -2.159f, 0.046f)
        lineToRelative(-1.516f, 0.091f)
        lineToRelative(0f, 0.361f)
        lineToRelative(1.102f, 0f)
        lineToRelative(2.802f, -0.136f)
        close()
    }
}

private fun ImageVector.Builder.legL3() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.011f, 20.089f)
        lineToRelative(0.364f, 0.276f)
        lineToRelative(1.091f, -0.016f)
        lineToRelative(-0.376f, -1.165f)
        lineToRelative(-0.974f, 0.266f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.38f, 19.707f)
        curveToRelative(0f, 0f, -1.936f, -1.113f, -2.061f, -1.22f)
        curveToRelative(-0.125f, -0.106f, -2.501f, -0.583f, -2.659f, -0.634f)
        curveToRelative(-0.157f, -0.051f, -1.079f, 0.06f, -1.079f, 0.06f)
        lineToRelative(0.098f, 0.349f)
        lineToRelative(1.809f, 0.163f)
        lineToRelative(2.235f, 0.656f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.535f, 20.087f)
        lineToRelative(-1.176f, 1.072f)
        curveToRelative(0f, 0f, -1.279f, 0.537f, -1.487f, 0.641f)
        curveToRelative(-0.209f, 0.104f, -2.115f, 0.953f, -2.115f, 0.953f)
        lineToRelative(-0.364f, -0.275f)
        lineToRelative(1.001f, -0.508f)
        lineToRelative(2.779f, -1.134f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.265f, 19.974f)
        lineToRelative(-2.004f, 0.5f)
        curveToRelative(0f, 0f, -2.036f, 0.556f, -2.225f, 0.562f)
        curveToRelative(-0.189f, 0.004f, -0.971f, -0.063f, -0.971f, -0.063f)
        lineToRelative(-0.059f, -0.547f)
        curveToRelative(0f, 0f, 0.726f, 0.037f, 0.959f, 0.019f)
        curveToRelative(0.233f, -0.017f, 2.453f, -0.436f, 2.453f, -0.436f)
        lineToRelative(1.432f, -0.157f)
        close()
    }
}

private fun ImageVector.Builder.legL4() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.416f, 26.177f)
        lineToRelative(-0.138f, -0.452f)
        lineToRelative(0.874f, -0.452f)
        lineToRelative(0.046f, 1.085f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.783f, 25.816f)
        curveToRelative(0f, 0f, -1.974f, -1.22f, -2.113f, -1.266f)
        curveToRelative(-0.138f, -0.045f, -3.032f, -0.316f, -3.032f, -0.316f)
        lineToRelative(-0.047f, 0.588f)
        lineToRelative(1.378f, -0.091f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.6f, 25.997f)
        lineToRelative(-3.4f, 0.542f)
        lineToRelative(-2.159f, 0.181f)
        lineToRelative(-0.184f, -0.271f)
        curveToRelative(0f, 0f, 1.011f, -0.045f, 1.148f, -0.091f)
        curveToRelative(0.138f, -0.045f, 2.389f, -0.407f, 2.389f, -0.407f)
        lineToRelative(1.424f, -0.181f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.922f, 25.952f)
        lineToRelative(-0.689f, 1.085f)
        curveToRelative(0f, 0f, -1.7f, 1.356f, -1.838f, 1.402f)
        curveToRelative(-0.138f, 0.045f, -1.654f, 0.814f, -1.654f, 0.814f)
        lineToRelative(-0.32f, -0.226f)
        lineToRelative(0.965f, -0.497f)
        lineToRelative(2.159f, -1.401f)
        close()
    }
}

private fun ImageVector.Builder.legL5() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(5.727f, 31.693f)
        lineToRelative(0.277f, 0.452f)
        lineToRelative(1.331f, 0.09f)
        lineToRelative(-0.046f, -1.22f)
        lineToRelative(-1.149f, 0.09f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(1.087f, 30.201f)
        lineToRelative(1.194f, 0.271f)
        lineToRelative(2.527f, 0.407f)
        lineToRelative(1.515f, 0.678f)
        lineToRelative(0.23f, -0.317f)
        lineToRelative(-2.939f, -1.085f)
        lineToRelative(-2.435f, -0.316f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(4.073f, 33.999f)
        lineToRelative(-2.941f, 1.401f)
        lineToRelative(-0.827f, 0.091f)
        lineToRelative(-0.046f, -0.271f)
        lineToRelative(1.24f, -0.542f)
        lineToRelative(2.526f, -1.311f)
        lineToRelative(2.297f, -1.491f)
        lineToRelative(0.414f, 0.09f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.737f, 31.467f)
        lineToRelative(-2.388f, 0.181f)
        curveToRelative(0f, 0f, -2.159f, 0.09f, -2.298f, 0.136f)
        curveToRelative(-0.137f, 0.046f, -1.699f, 0.317f, -1.699f, 0.317f)
        lineToRelative(-0.046f, 0.407f)
        lineToRelative(1.149f, -0.045f)
        lineToRelative(3.078f, -0.587f)
        lineToRelative(2.297f, -0.136f)
        close()
    }
}

private fun ImageVector.Builder.legL6() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(5.864f, 37.751f)
        lineToRelative(0.736f, 0.317f)
        lineToRelative(0.826f, -0.226f)
        lineToRelative(-0.091f, -1.221f)
        lineToRelative(-1.378f, 0.407f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(3.751f, 36.486f)
        lineToRelative(-1.976f, -0.407f)
        lineToRelative(-1.149f, 0.091f)
        lineToRelative(0.093f, 0.317f)
        lineToRelative(0.919f, 0.045f)
        lineToRelative(2.342f, 0.362f)
        lineToRelative(2.252f, 0.587f)
        lineToRelative(0.091f, -0.271f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.463f, 37.661f)
        lineToRelative(0.229f, 0.181f)
        lineToRelative(-1.837f, 1.492f)
        lineToRelative(-1.838f, 0.814f)
        lineToRelative(-1.654f, 0.814f)
        lineToRelative(-0.596f, -0.136f)
        lineToRelative(0.826f, -0.407f)
        lineToRelative(2.94f, -1.266f)
        lineToRelative(1.056f, -0.678f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(1.546f, 38.204f)
        lineToRelative(1.471f, 0f)
        lineToRelative(2.159f, -0.181f)
        lineToRelative(1.562f, -0.362f)
        lineToRelative(-0.137f, -0.271f)
        lineToRelative(-2.756f, 0.361f)
        lineToRelative(-2.068f, 0.046f)
        close()
    }
}

private fun ImageVector.Builder.legL7() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.845f, 42.981f)
        lineToRelative(-0.964f, 0.316f)
        lineToRelative(-0.185f, 0.407f)
        curveToRelative(0f, 0f, 0.092f, 0.271f, 0.276f, 0.407f)
        curveToRelative(0.184f, 0.135f, 0.551f, 0.271f, 0.551f, 0.271f)
        lineToRelative(0.918f, -0.136f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.064f, 43.75f)
        lineToRelative(0.137f, -0.271f)
        lineToRelative(-2.205f, -1.583f)
        lineToRelative(-2.48f, -0.361f)
        lineToRelative(-1.469f, -0.136f)
        lineToRelative(-0.047f, 0.316f)
        lineToRelative(1.837f, 0.272f)
        lineToRelative(2.252f, 0.497f)
        lineToRelative(1.149f, 0.723f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.064f, 43.75f)
        lineToRelative(0.275f, 0.271f)
        lineToRelative(-1.424f, 0.995f)
        lineToRelative(-1.654f, 0.678f)
        lineToRelative(-2.572f, 0.678f)
        lineToRelative(-0.505f, -0.226f)
        lineToRelative(0.689f, -0.452f)
        lineToRelative(2.527f, -0.588f)
        lineToRelative(2.343f, -0.95f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(0.965f, 43.75f)
        lineToRelative(1.608f, 0f)
        lineToRelative(2.067f, 0f)
        lineToRelative(1.791f, 0.136f)
        lineToRelative(-0.092f, -0.272f)
        lineToRelative(-2.297f, -0.09f)
        lineToRelative(-2.758f, -0.226f)
        close()
    }
}

private fun ImageVector.Builder.legL8() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.247f, 50.426f)
        lineToRelative(0.231f, 0.451f)
        lineToRelative(1.424f, 0.091f)
        lineToRelative(-0.23f, -1.446f)
        lineToRelative(-1.24f, 0.226f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(6.753f, 49.974f)
        lineToRelative(-1.7f, -0.859f)
        lineToRelative(-2.894f, -0.407f)
        lineToRelative(-0.827f, 0.181f)
        curveToRelative(0.092f, 0.226f, 1.241f, 0.18f, 1.241f, 0.18f)
        lineToRelative(1.975f, 0.272f)
        lineToRelative(1.102f, 0.407f)
        lineToRelative(0.919f, 0.452f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveTo(6.753f, 50.471f)
        lineToRelative(0.138f, 0.226f)
        lineToRelative(-2.894f, 1.673f)
        lineToRelative(-1.608f, 0.362f)
        lineToRelative(-1.011f, 0.044f)
        lineToRelative(0f, -0.316f)
        lineToRelative(1.287f, -0.181f)
        lineToRelative(1.608f, -0.497f)
        lineToRelative(1.378f, -0.905f)
        close()
    }
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(2.435f, 50.381f)
        lineToRelative(1.516f, -0.136f)
        lineToRelative(1.562f, -0.226f)
        lineToRelative(1.378f, 0.091f)
        curveToRelative(0.046f, 0.181f, -1.93f, 0.406f, -1.93f, 0.406f)
        lineToRelative(-2.48f, 0.497f)
        close()
    }
}

private fun ImageVector.Builder.body() {
    path(fill = SolidColor(Color(0xFF352826))) {
        moveToRelative(13.721f, 2.532f)
        lineToRelative(-2.297f, -0.723f)
        lineToRelative(-1.649f, 0.837f)
        lineToRelative(-1.2f, 0.609f)
        lineToRelative(-1.745f, 1.899f)
        lineToRelative(0.184f, 1.989f)
        lineToRelative(0.828f, 1.356f)
        lineToRelative(0f, 2.17f)
        lineToRelative(-0.276f, 1.809f)
        lineToRelative(-0.734f, 0.995f)
        lineToRelative(0.092f, 1.538f)
        lineToRelative(0.827f, 1.175f)
        lineToRelative(-0.184f, 0.995f)
        lineToRelative(-0.734f, 1.085f)
        lineToRelative(-0.093f, 1.447f)
        lineToRelative(0.368f, 1.266f)
        lineToRelative(0.826f, 0.632f)
        lineToRelative(0f, 0.904f)
        lineToRelative(-0.826f, 1.809f)
        lineToRelative(-0.183f, 1.628f)
        lineToRelative(0.46f, 1.085f)
        lineToRelative(0.827f, 0.995f)
        lineToRelative(0f, 0.814f)
        lineToRelative(-1.103f, 1.899f)
        lineToRelative(0f, 1.537f)
        lineToRelative(0.367f, 0.995f)
        lineToRelative(0.644f, 0.542f)
        lineToRelative(-0.185f, 0.723f)
        lineToRelative(-0.826f, 1.356f)
        lineToRelative(-0.275f, 1.447f)
        lineToRelative(0.459f, 1.266f)
        lineToRelative(0.643f, 0.814f)
        lineToRelative(-0.091f, 0.994f)
        lineToRelative(-1.195f, 1.538f)
        lineToRelative(0f, 1.356f)
        lineToRelative(0.46f, 1.266f)
        lineToRelative(0.826f, 0.995f)
        lineToRelative(-0.091f, 0.814f)
        lineToRelative(-0.369f, 0.905f)
        lineToRelative(-0.735f, 2.17f)
        lineToRelative(0.735f, 2.079f)
        lineToRelative(1.103f, 1.356f)
        lineToRelative(0f, 0.995f)
        lineToRelative(-0.184f, 1.989f)
        curveToRelative(0f, 0f, 0.827f, 0.905f, 1.102f, 0.995f)
        curveToRelative(0.275f, 0.091f, 0.919f, 0.904f, 0.919f, 0.904f)
        curveToRelative(0f, 0f, 0.276f, 1.085f, 0.459f, 1.356f)
        curveToRelative(0.184f, 0.272f, 1.286f, 0.724f, 1.286f, 0.724f)
        lineToRelative(1.287f, -0.271f)
        lineToRelative(1.378f, -1.718f)
        lineToRelative(0.092f, -1.538f)
        lineToRelative(0.827f, -0.633f)
        lineToRelative(0.643f, -1.899f)
        lineToRelative(-0.459f, -1.356f)
        lineToRelative(0.827f, -1.628f)
        lineToRelative(-0.184f, -1.627f)
        lineToRelative(-0.919f, -2.08f)
        lineToRelative(0.919f, -1.356f)
        lineToRelative(0.275f, -1.719f)
        lineTo(16.845f, 41.775f)
        lineToRelative(-0.827f, -1.175f)
        lineToRelative(-0.184f, -1.086f)
        curveToRelative(0f, 0f, 0.919f, -1.176f, 1.011f, -1.446f)
        curveToRelative(0.092f, -0.272f, 0.367f, -1.809f, 0.367f, -1.809f)
        lineToRelative(-0.643f, -1.718f)
        lineToRelative(-0.643f, -0.723f)
        lineToRelative(0f, -0.542f)
        lineToRelative(0.735f, -1.266f)
        lineToRelative(0.275f, -2.08f)
        lineToRelative(-0.919f, -1.718f)
        lineToRelative(0.093f, -0.723f)
        lineToRelative(0.734f, -1.356f)
        lineToRelative(0f, -1.809f)
        lineToRelative(-1.011f, -1.718f)
        lineToRelative(-0.366f, -0.905f)
        lineToRelative(0.551f, -0.723f)
        curveToRelative(0f, 0f, 0.827f, -1.718f, 0.827f, -1.99f)
        curveToRelative(0f, -0.271f, -0.368f, -2.26f, -0.368f, -2.26f)
        lineToRelative(-0.734f, -0.723f)
        lineToRelative(-0.184f, -0.904f)
        lineToRelative(0.827f, -2.17f)
        curveToRelative(0f, 0f, -0.093f, -1.447f, -0.275f, -1.718f)
        curveToRelative(-0.184f, -0.271f, -0.919f, -1.538f, -0.919f, -1.538f)
        lineToRelative(-0.093f, -0.995f)
        curveToRelative(0f, 0f, 0.46f, -0.814f, 0.46f, -1.085f)
        curveToRelative(0f, -0.271f, 0.275f, -1.356f, 0.275f, -1.718f)
        curveToRelative(0f, -0.362f, -0.459f, -1.989f, -0.459f, -1.989f)
        lineToRelative(-1.01f, -0.723f)
        close()
    }
}
