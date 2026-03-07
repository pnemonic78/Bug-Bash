package pnemonic.bug_bash.drawable

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
import pnemonic.bug_bash.model.bug.Spider
import pnemonic.stateOf

private const val durationCrawl = 1000

@Composable
fun spider(bug: Spider): ImageVector = spider(bug.isStopped)

@Composable
fun spider(stopped: Boolean = false): ImageVector {
    val crawlL1: State<Float>
    val crawlL2: State<Float>
    val crawlL3: State<Float>
    val crawlL4: State<Float>
    val crawlR1: State<Float>
    val crawlR2: State<Float>
    val crawlR3: State<Float>
    val crawlR4: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>

    if (stopped) {
        crawlL1 = stateOf(1f)
        crawlL2 = crawlL1
        crawlL3 = crawlL1
        crawlL4 = crawlL1
        crawlR1 = stateOf(1f)
        crawlR2 = crawlR1
        crawlR3 = crawlR1
        crawlR4 = crawlR1
        rotateL2 = stateOf(0f)
        rotateL3 = rotateL2
        rotateR2 = rotateL2
        rotateR3 = rotateL2
    } else {
        val transition = rememberInfiniteTransition()
        crawlL1 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlL2 = transition.animateFloat(
            initialValue = 0.7f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlL3 = transition.animateFloat(
            initialValue = 0.7f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlL4 = transition.animateFloat(
            initialValue = 0.5f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlR1 = transition.animateFloat(
            initialValue = 0.5f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlR2 = transition.animateFloat(
            initialValue = 0.7f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlR3 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.7f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlR4 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = 10f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = 45f,
            targetValue = -15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = 30f,
            targetValue = -10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR3 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationCrawl
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Spider",
        defaultWidth = 30.2.dp,
        defaultHeight = 34.dp,
        viewportWidth = 30.2f,
        viewportHeight = 34f
    ).apply {
        group("leg-l4", scaleY = crawlL4.value, pivotX = 14.699f, pivotY = 18.614f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(9.611f, 28.933f)
                curveToRelative(-0.156f, 1.578f, -0.303f, 3.158f, -0.465f, 4.735f)
                curveToRelative(-0.085f, 0.416f, -0.791f, 0.293f, -0.7f, -0.141f)
                curveToRelative(0.147f, -1.578f, 0.299f, -3.159f, 0.461f, -4.736f)
                curveToRelative(0.087f, -0.379f, 0.725f, -0.3f, 0.704f, 0.097f)
                lineToRelative(-0.001f, 0.045f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(14.699f, 18.614f)
                curveToRelative(-0.194f, 0.4f, -0.675f, 0.505f, -1.008f, 0.756f)
                curveToRelative(-0.634f, 0.377f, -1.267f, 0.757f, -1.902f, 1.132f)
                curveToRelative(-0.479f, 1.688f, -1.001f, 3.366f, -1.452f, 5.061f)
                curveToRelative(-0.169f, 0.987f, -0.298f, 1.983f, -0.493f, 2.964f)
                curveToRelative(-0.196f, 0.483f, -1.022f, 0.357f, -1.023f, -0.182f)
                curveToRelative(0.025f, -0.507f, 0.159f, -1.005f, 0.22f, -1.51f)
                curveToRelative(0.135f, -0.855f, 0.241f, -1.718f, 0.524f, -2.54f)
                curveToRelative(0.435f, -1.466f, 0.837f, -2.945f, 1.295f, -4.403f)
                curveToRelative(0.248f, -0.34f, 0.688f, -0.451f, 1.016f, -0.695f)
                curveToRelative(0.738f, -0.426f, 1.45f, -0.909f, 2.214f, -1.285f)
                curveToRelative(0.381f, -0.087f, 0.764f, 0.333f, 0.61f, 0.702f)
                close()
            }
        }
        group("leg-l3", rotate = rotateL3.value, scaleX = crawlL3.value, pivotX = 13.672f, pivotY = 17.631f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(6.445f, 23.035f)
                curveToRelative(-0.791f, 0.537f, -1.621f, 1.013f, -2.421f, 1.535f)
                curveToRelative(-0.286f, 0.18f, -0.574f, 0.357f, -0.866f, 0.528f)
                curveToRelative(-0.298f, 0.112f, -0.595f, -0.304f, -0.399f, -0.551f)
                curveToRelative(0.258f, -0.234f, 0.586f, -0.375f, 0.868f, -0.577f)
                curveToRelative(0.803f, -0.504f, 1.603f, -1.011f, 2.41f, -1.509f)
                curveToRelative(0.322f, -0.157f, 0.678f, 0.321f, 0.408f, 0.574f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(13.672f, 17.631f)
                curveToRelative(-1.189f, 0.589f, -2.382f, 1.169f, -3.572f, 1.754f)
                curveToRelative(-1.095f, 1.189f, -2.161f, 2.405f, -3.274f, 3.578f)
                curveToRelative(-0.508f, 0.375f, -1.178f, -0.517f, -0.629f, -0.88f)
                curveToRelative(1.058f, -1.19f, 2.14f, -2.358f, 3.212f, -3.536f)
                curveToRelative(1.285f, -0.681f, 2.604f, -1.295f, 3.911f, -1.931f)
                curveToRelative(0.571f, -0.155f, 0.946f, 0.789f, 0.352f, 1.015f)
                close()
            }
        }
        group("leg-l2", rotate = rotateL2.value, scaleX = crawlL2.value, pivotX = 13.954f, pivotY = 16.103f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(4.501f, 11.293f)
                curveToRelative(-0.109f, 0.185f, -0.379f, 0.22f, -0.541f, 0.084f)
                curveToRelative(-1.263f, -0.789f, -2.526f, -1.577f, -3.79f, -2.366f)
                curveToRelative(-0.228f, -0.13f, -0.225f, -0.502f, 0.013f, -0.621f)
                curveToRelative(0.157f, -0.099f, 0.337f, -0.024f, 0.472f, 0.075f)
                curveToRelative(1.244f, 0.777f, 2.489f, 1.554f, 3.733f, 2.331f)
                curveToRelative(0.165f, 0.1f, 0.216f, 0.336f, 0.113f, 0.497f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(13.954f, 16.103f)
                curveToRelative(-0.103f, 0.386f, -0.552f, 0.452f, -0.869f, 0.305f)
                curveToRelative(-1.578f, -0.471f, -3.161f, -0.926f, -4.735f, -1.406f)
                curveToRelative(-0.284f, -0.185f, -0.474f, -0.483f, -0.713f, -0.722f)
                curveToRelative(-0.371f, -0.403f, -0.729f, -0.821f, -1.107f, -1.215f)
                curveToRelative(-0.744f, -0.435f, -1.492f, -0.864f, -2.234f, -1.302f)
                curveToRelative(-0.385f, -0.252f, -0.224f, -0.932f, 0.241f, -0.971f)
                curveToRelative(0.339f, -0.028f, 0.595f, 0.24f, 0.883f, 0.377f)
                curveToRelative(0.604f, 0.356f, 1.217f, 0.697f, 1.815f, 1.063f)
                curveToRelative(0.554f, 0.592f, 1.088f, 1.205f, 1.635f, 1.805f)
                curveToRelative(1.59f, 0.472f, 3.184f, 0.936f, 4.772f, 1.413f)
                curveToRelative(0.25f, 0.098f, 0.395f, 0.395f, 0.312f, 0.652f)
                close()
            }
        }
        group("leg-l1", scaleY = crawlL1.value, pivotX = 13.768f, pivotY = 15.237f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(10.849f, 5.169f)
                curveToRelative(0.003f, 0.26f, -0.317f, 0.439f, -0.536f, 0.298f)
                curveToRelative(-0.2f, -0.11f, -0.183f, -0.357f, -0.228f, -0.55f)
                curveToRelative(-0.263f, -1.511f, -0.531f, -3.021f, -0.791f, -4.532f)
                curveToRelative(-0.033f, -0.274f, 0.302f, -0.485f, 0.536f, -0.339f)
                curveToRelative(0.203f, 0.105f, 0.187f, 0.351f, 0.231f, 0.543f)
                curveToRelative(0.261f, 1.502f, 0.523f, 3.003f, 0.784f, 4.505f)
                lineToRelative(0.004f, 0.037f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(13.768f, 15.237f)
                curveToRelative(-0.27f, 0.219f, -0.674f, 0.093f, -0.836f, -0.196f)
                curveToRelative(-0.668f, -0.867f, -1.343f, -1.729f, -2.007f, -2.599f)
                curveToRelative(-0.123f, -0.319f, -0.117f, -0.674f, -0.179f, -1.009f)
                curveToRelative(-0.264f, -1.95f, -0.538f, -3.9f, -0.795f, -5.851f)
                curveToRelative(-0.029f, -0.469f, 0.625f, -0.732f, 0.932f, -0.38f)
                curveToRelative(0.206f, 0.24f, 0.157f, 0.58f, 0.221f, 0.872f)
                curveToRelative(0.267f, 1.96f, 0.534f, 3.921f, 0.801f, 5.881f)
                curveToRelative(0.662f, 0.857f, 1.329f, 1.711f, 1.989f, 2.57f)
                curveToRelative(0.147f, 0.226f, 0.089f, 0.551f, -0.126f, 0.713f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(14.109f, 12.418f)
            curveToRelative(-0.159f, 0.184f, -0.476f, 0.12f, -0.598f, -0.075f)
            curveToRelative(-0.217f, -0.215f, -0.462f, -0.404f, -0.652f, -0.645f)
            curveToRelative(-0.083f, -0.186f, 0.023f, -0.381f, 0.089f, -0.554f)
            curveToRelative(0.075f, -0.127f, 0.12f, -0.287f, 0.03f, -0.418f)
            curveToRelative(-0.136f, -0.311f, -0.278f, -0.62f, -0.402f, -0.936f)
            curveToRelative(-0.075f, -0.286f, 0.311f, -0.558f, 0.549f, -0.371f)
            curveToRelative(0.188f, 0.14f, 0.214f, 0.392f, 0.322f, 0.586f)
            curveToRelative(0.118f, 0.266f, 0.241f, 0.531f, 0.342f, 0.804f)
            curveToRelative(0.027f, 0.21f, -0.11f, 0.388f, -0.168f, 0.58f)
            curveToRelative(0.007f, 0.167f, 0.189f, 0.231f, 0.283f, 0.344f)
            curveToRelative(0.136f, 0.122f, 0.315f, 0.257f, 0.303f, 0.46f)
            curveToRelative(-0.005f, 0.084f, -0.038f, 0.167f, -0.099f, 0.226f)
            close()
        }
        group("leg-r4", scaleY = crawlR4.value, pivotX = 16.036f, pivotY = 18.445f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(21.357f, 33.934f)
                curveToRelative(0.011f, 0f, 0.023f, -0.001f, 0.035f, -0.002f)
                curveToRelative(0.198f, -0.019f, 0.342f, -0.195f, 0.323f, -0.393f)
                lineToRelative(-0.453f, -4.676f)
                curveToRelative(-0.019f, -0.197f, -0.191f, -0.344f, -0.393f, -0.323f)
                curveToRelative(-0.198f, 0.019f, -0.342f, 0.195f, -0.323f, 0.394f)
                lineToRelative(0.453f, 4.676f)
                curveToRelative(0.019f, 0.186f, 0.174f, 0.325f, 0.358f, 0.325f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(20.804f, 28.838f)
                curveToRelative(0.381f, 0.014f, 0.634f, -0.404f, 0.514f, -0.748f)
                curveToRelative(-0.166f, -0.995f, -0.306f, -1.996f, -0.488f, -2.987f)
                curveToRelative(-0.501f, -1.719f, -0.996f, -3.439f, -1.502f, -5.157f)
                curveToRelative(-0.143f, -0.306f, -0.502f, -0.397f, -0.76f, -0.583f)
                curveToRelative(-0.809f, -0.474f, -1.605f, -0.973f, -2.423f, -1.43f)
                curveToRelative(-0.426f, -0.174f, -0.884f, 0.335f, -0.666f, 0.741f)
                curveToRelative(0.164f, 0.286f, 0.509f, 0.381f, 0.767f, 0.564f)
                curveToRelative(0.707f, 0.421f, 1.414f, 0.841f, 2.121f, 1.262f)
                curveToRelative(0.477f, 1.657f, 0.97f, 3.31f, 1.437f, 4.969f)
                curveToRelative(0.166f, 1.003f, 0.31f, 2.011f, 0.491f, 3.011f)
                curveToRelative(0.072f, 0.211f, 0.285f, 0.361f, 0.508f, 0.358f)
                close()
            }
        }
        group("leg-r3", rotate = rotateR3.value, scaleX = crawlR3.value, pivotX = 16.211f, pivotY = 17.323f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(27.099f, 25.11f)
                curveToRelative(0.12f, 0f, 0.237f, -0.06f, 0.305f, -0.169f)
                curveToRelative(0.105f, -0.169f, 0.054f, -0.391f, -0.114f, -0.496f)
                lineToRelative(-3.117f, -1.954f)
                curveToRelative(-0.168f, -0.106f, -0.39f, -0.055f, -0.496f, 0.113f)
                curveToRelative(-0.106f, 0.169f, -0.055f, 0.39f, 0.113f, 0.496f)
                lineToRelative(3.118f, 1.955f)
                curveToRelative(0.06f, 0.038f, 0.126f, 0.055f, 0.191f, 0.055f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(23.622f, 23.044f)
                curveToRelative(0.425f, 0.021f, 0.704f, -0.53f, 0.434f, -0.859f)
                curveToRelative(-1.099f, -1.215f, -2.203f, -2.427f, -3.308f, -3.637f)
                curveToRelative(-0.328f, -0.212f, -0.699f, -0.355f, -1.045f, -0.537f)
                curveToRelative(-0.932f, -0.455f, -1.861f, -0.917f, -2.795f, -1.368f)
                curveToRelative(-0.402f, -0.172f, -0.861f, 0.274f, -0.697f, 0.681f)
                curveToRelative(0.115f, 0.324f, 0.486f, 0.387f, 0.752f, 0.544f)
                curveToRelative(1.031f, 0.506f, 2.062f, 1.013f, 3.093f, 1.519f)
                curveToRelative(1.071f, 1.174f, 2.136f, 2.353f, 3.21f, 3.523f)
                curveToRelative(0.097f, 0.087f, 0.227f, 0.136f, 0.357f, 0.135f)
                close()
            }
        }
        group("leg-r2", rotate = rotateR2.value, scaleX = crawlR2.value, pivotX = 16.473f, pivotY = 16.428f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(25.961f, 11.46f)
                curveToRelative(0.065f, 0f, 0.131f, -0.018f, 0.19f, -0.055f)
                lineToRelative(3.836f, -2.396f)
                curveToRelative(0.169f, -0.105f, 0.22f, -0.327f, 0.115f, -0.496f)
                curveToRelative(-0.106f, -0.169f, -0.327f, -0.22f, -0.496f, -0.114f)
                lineToRelative(-3.836f, 2.396f)
                curveToRelative(-0.169f, 0.105f, -0.22f, 0.326f, -0.115f, 0.496f)
                curveToRelative(0.069f, 0.109f, 0.186f, 0.169f, 0.305f, 0.169f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(16.72f, 16.489f)
                curveToRelative(0.454f, -0.084f, 0.891f, -0.252f, 1.338f, -0.372f)
                curveToRelative(1.249f, -0.373f, 2.503f, -0.734f, 3.749f, -1.115f)
                curveToRelative(0.289f, -0.192f, 0.484f, -0.495f, 0.729f, -0.74f)
                curveToRelative(0.365f, -0.397f, 0.718f, -0.809f, 1.091f, -1.197f)
                curveToRelative(0.743f, -0.434f, 1.491f, -0.863f, 2.232f, -1.301f)
                curveToRelative(0.366f, -0.239f, 0.249f, -0.869f, -0.18f, -0.958f)
                curveToRelative(-0.346f, -0.085f, -0.613f, 0.205f, -0.903f, 0.342f)
                curveToRelative(-0.617f, 0.364f, -1.243f, 0.712f, -1.853f, 1.085f)
                curveToRelative(-0.555f, 0.592f, -1.09f, 1.204f, -1.637f, 1.804f)
                curveToRelative(-1.59f, 0.472f, -3.182f, 0.937f, -4.77f, 1.414f)
                curveToRelative(-0.415f, 0.147f, -0.45f, 0.796f, -0.042f, 0.978f)
                curveToRelative(0.076f, 0.039f, 0.161f, 0.061f, 0.247f, 0.061f)
                close()
            }
        }
        group("leg-r1", scaleY = crawlR1.value, pivotX = 16.72f, pivotY = 15.35f) {
            path(fill = SolidColor(Color.DarkGray)) {
                moveToRelative(19.666f, 5.518f)
                curveToRelative(0.172f, 0f, 0.324f, -0.124f, 0.355f, -0.298f)
                lineToRelative(0.839f, -4.797f)
                curveToRelative(0.034f, -0.196f, -0.096f, -0.382f, -0.293f, -0.416f)
                curveToRelative(-0.195f, -0.035f, -0.381f, 0.096f, -0.416f, 0.292f)
                lineToRelative(-0.839f, 4.797f)
                curveToRelative(-0.035f, 0.195f, 0.096f, 0.382f, 0.293f, 0.416f)
                curveToRelative(0.02f, 0.004f, 0.041f, 0.006f, 0.062f, 0.006f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(16.72f, 15.35f)
                curveToRelative(0.387f, -0f, 0.543f, -0.399f, 0.766f, -0.646f)
                curveToRelative(0.581f, -0.754f, 1.172f, -1.501f, 1.746f, -2.26f)
                curveToRelative(0.125f, -0.319f, 0.118f, -0.674f, 0.18f, -1.01f)
                curveToRelative(0.263f, -1.946f, 0.534f, -3.891f, 0.793f, -5.837f)
                curveToRelative(0.037f, -0.436f, -0.532f, -0.731f, -0.867f, -0.448f)
                curveToRelative(-0.275f, 0.217f, -0.214f, 0.598f, -0.282f, 0.905f)
                curveToRelative(-0.268f, 1.968f, -0.537f, 3.935f, -0.805f, 5.903f)
                curveToRelative(-0.662f, 0.857f, -1.33f, 1.709f, -1.989f, 2.569f)
                curveToRelative(-0.23f, 0.34f, 0.046f, 0.839f, 0.457f, 0.825f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(16.308f, 12.532f)
            curveToRelative(0.264f, -0.013f, 0.4f, -0.279f, 0.591f, -0.424f)
            curveToRelative(0.15f, -0.175f, 0.425f, -0.299f, 0.432f, -0.555f)
            curveToRelative(-0.011f, -0.246f, -0.198f, -0.466f, -0.207f, -0.699f)
            curveToRelative(0.151f, -0.371f, 0.345f, -0.729f, 0.464f, -1.111f)
            curveToRelative(0.03f, -0.316f, -0.418f, -0.521f, -0.623f, -0.265f)
            curveToRelative(-0.147f, 0.208f, -0.209f, 0.463f, -0.325f, 0.689f)
            curveToRelative(-0.095f, 0.23f, -0.223f, 0.454f, -0.277f, 0.697f)
            curveToRelative(-0.032f, 0.242f, 0.308f, 0.499f, 0.077f, 0.698f)
            curveToRelative(-0.164f, 0.145f, -0.344f, 0.286f, -0.463f, 0.471f)
            curveToRelative(-0.106f, 0.225f, 0.083f, 0.51f, 0.331f, 0.5f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(16.721f, 12.171f)
            curveToRelative(0.018f, 0.586f, -0.533f, 1.118f, -1.119f, 1.072f)
            curveToRelative(-0.413f, -0f, -0.827f, 0.011f, -1.24f, -0.008f)
            curveToRelative(-0.52f, -0.061f, -0.943f, -0.555f, -0.925f, -1.079f)
            curveToRelative(0.001f, -0.46f, 0.331f, -0.894f, 0.775f, -1.015f)
            curveToRelative(0.236f, -0.068f, 0.484f, -0.031f, 0.726f, -0.042f)
            curveToRelative(0.289f, 0.003f, 0.579f, -0.008f, 0.867f, 0.01f)
            curveToRelative(0.512f, 0.066f, 0.924f, 0.544f, 0.916f, 1.061f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(17.227f, 14.695f)
            curveToRelative(-0.005f, 0.63f, 0.011f, 1.261f, -0.009f, 1.891f)
            curveToRelative(-0.067f, 0.991f, -0.862f, 1.866f, -1.833f, 2.051f)
            curveToRelative(-0.218f, 0.056f, -0.365f, 0.065f, -0.579f, 0.006f)
            curveToRelative(-0.897f, -0.158f, -1.658f, -0.899f, -1.827f, -1.796f)
            curveToRelative(-0.08f, -0.448f, -0.035f, -0.906f, -0.047f, -1.359f)
            curveToRelative(0.014f, -0.54f, -0.062f, -1.102f, 0.153f, -1.615f)
            curveToRelative(0.297f, -0.793f, 1.063f, -1.375f, 1.904f, -1.46f)
            curveToRelative(0.144f, -0.047f, 0.356f, 0.036f, 0.548f, 0.071f)
            curveToRelative(0.972f, 0.258f, 1.705f, 1.2f, 1.691f, 2.21f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(18.566f, 21.884f)
            curveToRelative(-0.026f, 1.161f, 0.059f, 2.327f, -0.056f, 3.484f)
            curveToRelative(-0.311f, 1.828f, -2.252f, 3.271f, -4.097f, 2.846f)
            curveToRelative(-1.493f, -0.313f, -2.697f, -1.662f, -2.804f, -3.19f)
            curveToRelative(-0.046f, -0.926f, 0.012f, -1.854f, -0.018f, -2.78f)
            curveToRelative(-0.034f, -0.855f, 0.143f, -1.737f, 0.661f, -2.434f)
            curveToRelative(0.818f, -1.171f, 2.397f, -1.832f, 3.784f, -1.365f)
            curveToRelative(1.469f, 0.447f, 2.556f, 1.895f, 2.53f, 3.439f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9C3030))) {
            moveToRelative(15.169f, 18.295f)
            curveToRelative(-0.808f, -0.01f, -1.611f, 0.285f, -2.237f, 0.792f)
            curveToRelative(0.271f, 1.606f, 0.599f, 3.203f, 0.833f, 4.815f)
            curveToRelative(0.034f, 0.803f, 0.925f, 1.493f, 1.706f, 1.217f)
            curveToRelative(0.505f, -0.18f, 0.826f, -0.672f, 0.922f, -1.183f)
            curveToRelative(0.222f, -1.578f, 0.535f, -3.141f, 0.808f, -4.711f)
            curveToRelative(-0.193f, -0.639f, -1.585f, -0.903f, -2.032f, -0.931f)
            close()
        }
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(16.452f, 12.946f)
            curveToRelative(-0.176f, 1.008f, -0.359f, 2.015f, -0.537f, 3.023f)
            curveToRelative(0.016f, 0.474f, -0.403f, 0.917f, -0.878f, 0.919f)
            curveToRelative(-0.409f, -0.058f, -0.759f, -0.409f, -0.793f, -0.825f)
            curveToRelative(-0.164f, -1.042f, -0.361f, -2.078f, -0.542f, -3.117f)
            curveToRelative(0.424f, -0.341f, 0.973f, -0.535f, 1.517f, -0.507f)
            curveToRelative(0.538f, 0.069f, 0.913f, 0.254f, 1.233f, 0.507f)
            close()
        }
    }.build()
}