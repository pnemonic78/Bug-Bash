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
import pnemonic.bug_bash.model.bug.Butterfly
import pnemonic.stateOf

private const val durationWing = 1000

@Composable
fun butterfly(bug: Butterfly): ImageVector = butterfly(bug.isSquashed)

@Composable
fun butterfly(squashed: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>

    if (squashed) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateR1 = rotateL1
        rotateR2 = rotateR1
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = -15f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Butterfly",
        defaultWidth = 71.dp,
        defaultHeight = 60.dp,
        viewportWidth = 71f,
        viewportHeight = 60f
    ).apply {
        // left antenna
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(35.264f, 27.251f)
            curveToRelative(-0.055f, 0.037f, -0.116f, 0.055f, -0.17f, 0.055f)
            curveToRelative(-0.097f, 0f, -0.195f, -0.048f, -0.255f, -0.134f)
            curveToRelative(-0.153f, -0.231f, -0.305f, -0.455f, -0.451f, -0.681f)
            curveToRelative(-2.739f, -4.237f, -3.78f, -7.766f, -3.097f, -10.505f)
            curveToRelative(0.56f, -2.222f, 2.07f, -3.038f, 2.13f, -3.068f)
            curveToRelative(0.153f, -0.079f, 0.335f, -0.025f, 0.414f, 0.122f)
            curveToRelative(0.079f, 0.152f, 0.018f, 0.334f, -0.128f, 0.413f)
            curveToRelative(-0.012f, 0.006f, -1.345f, 0.742f, -1.832f, 2.702f)
            curveToRelative(-0.444f, 1.808f, -0.237f, 5.021f, 3.153f, 10.194f)
            curveToRelative(0.097f, 0.159f, 0.207f, 0.316f, 0.316f, 0.481f)
            curveToRelative(0.097f, 0.141f, 0.061f, 0.33f, -0.079f, 0.42f)
            close()
        }
        // right antenna
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(35.907f, 27.305f)
            curveToRelative(0.097f, 0f, 0.193f, -0.047f, 0.252f, -0.133f)
            curveToRelative(3.076f, -4.538f, 4.27f, -8.3f, 3.549f, -11.184f)
            curveToRelative(-0.556f, -2.222f, -2.067f, -3.04f, -2.131f, -3.073f)
            curveToRelative(-0.149f, -0.077f, -0.332f, -0.021f, -0.41f, 0.127f)
            curveToRelative(-0.079f, 0.148f, -0.022f, 0.333f, 0.125f, 0.412f)
            curveToRelative(0.013f, 0.007f, 1.349f, 0.743f, 1.831f, 2.703f)
            curveToRelative(0.458f, 1.86f, 0.228f, 5.222f, -3.468f, 10.673f)
            curveToRelative(-0.094f, 0.139f, -0.058f, 0.328f, 0.081f, 0.422f)
            curveToRelative(0.052f, 0.037f, 0.112f, 0.053f, 0.171f, 0.053f)
            close()
        }
        // body
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(38.848f, 30.441f)
            lineToRelative(0f, 4.065f)
            curveToRelative(0f, 0.706f, -0.304f, 1.345f, -0.803f, 1.826f)
            curveToRelative(-0.267f, 0.261f, -0.596f, 0.475f, -0.968f, 0.62f)
            curveToRelative(-0.359f, 0.139f, -0.755f, 0.219f, -1.169f, 0.219f)
            lineToRelative(-0.006f, 0f)
            curveToRelative(-0.14f, 0f, -0.274f, -0.017f, -0.401f, -0.037f)
            curveToRelative(-0.134f, 0.019f, -0.267f, 0.037f, -0.407f, 0.037f)
            curveToRelative(-0.42f, 0f, -0.816f, -0.079f, -1.175f, -0.219f)
            curveToRelative(-0.365f, -0.145f, -0.694f, -0.36f, -0.961f, -0.615f)
            curveToRelative(-0.5f, -0.481f, -0.804f, -1.119f, -0.804f, -1.831f)
            lineToRelative(0f, -4.065f)
            curveToRelative(0f, -0.171f, 0.018f, -0.335f, 0.055f, -0.494f)
            curveToRelative(0f, -0.024f, 0.006f, -0.043f, 0.013f, -0.067f)
            curveToRelative(0f, -0.013f, 0.006f, -0.031f, 0.012f, -0.043f)
            curveToRelative(0.007f, -0.037f, 0.019f, -0.067f, 0.031f, -0.104f)
            curveToRelative(0.249f, -0.84f, 0.955f, -1.515f, 1.856f, -1.801f)
            curveToRelative(0.085f, -0.03f, 0.171f, -0.054f, 0.261f, -0.073f)
            curveToRelative(-0.219f, -0.147f, -0.359f, -0.396f, -0.359f, -0.682f)
            curveToRelative(0f, -0.147f, 0.036f, -0.287f, 0.109f, -0.408f)
            curveToRelative(0.061f, -0.109f, 0.153f, -0.207f, 0.255f, -0.279f)
            curveToRelative(0.134f, -0.085f, 0.292f, -0.141f, 0.463f, -0.141f)
            lineToRelative(1.297f, 0f)
            curveToRelative(0.171f, 0f, 0.328f, 0.048f, 0.463f, 0.141f)
            curveToRelative(0.103f, 0.067f, 0.195f, 0.163f, 0.255f, 0.273f)
            curveToRelative(0.073f, 0.122f, 0.115f, 0.261f, 0.115f, 0.414f)
            curveToRelative(0f, 0.285f, -0.146f, 0.535f, -0.366f, 0.682f)
            curveToRelative(0.091f, 0.018f, 0.177f, 0.043f, 0.262f, 0.073f)
            curveToRelative(0.901f, 0.286f, 1.607f, 0.962f, 1.863f, 1.801f)
            curveToRelative(0.011f, 0.037f, 0.024f, 0.067f, 0.03f, 0.104f)
            curveToRelative(0.006f, 0.011f, 0.013f, 0.03f, 0.013f, 0.043f)
            curveToRelative(0.006f, 0.024f, 0.012f, 0.043f, 0.018f, 0.067f)
            curveToRelative(0.028f, 0.158f, 0.046f, 0.322f, 0.046f, 0.494f)
            close()
        }
        // tail
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(36.93f, 33.35f)
            lineToRelative(-0.702f, 13.51f)
            curveToRelative(0f, 0.456f, -0.315f, 0.846f, -0.727f, 0.987f)
            curveToRelative(-0.423f, -0.142f, -0.727f, -0.531f, -0.727f, -0.987f)
            lineToRelative(-0.702f, -13.51f)
            curveToRelative(0f, -0.466f, 1.005f, -0.846f, 1.428f, -0.987f)
            curveToRelative(0.413f, 0.142f, 1.43f, 0.521f, 1.43f, 0.987f)
            close()
        }
        // tail
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(36.56f, 41.279f)
            lineToRelative(0f, 5.679f)
            curveToRelative(0f, 0.579f, -0.475f, 1.054f, -1.052f, 1.054f)
            curveToRelative(-0.006f, 0f, -0.006f, 0f, -0.006f, 0f)
            curveToRelative(-0.006f, 0f, -0.006f, 0f, -0.006f, 0f)
            curveToRelative(-0.584f, 0f, -1.059f, -0.475f, -1.059f, -1.054f)
            lineToRelative(0f, -5.679f)
            curveToRelative(0f, -0.437f, 0.274f, -0.815f, 0.657f, -0.973f)
            curveToRelative(0.128f, -0.049f, 0.262f, -0.079f, 0.402f, -0.079f)
            curveToRelative(0f, 0f, 0f, 0f, 0.006f, 0f)
            curveToRelative(0f, 0f, 0f, 0f, 0.006f, 0f)
            curveToRelative(0.14f, 0f, 0.28f, 0.03f, 0.401f, 0.085f)
            curveToRelative(0.384f, 0.152f, 0.651f, 0.53f, 0.651f, 0.967f)
            close()
        }
        group("wing-l2", rotate = rotateL2.value, pivotX = 34.406f, pivotY = 29.960f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(33.919f, 36.953f)
                curveToRelative(-0.651f, 3.585f, -2.076f, 7.888f, -5.161f, 11.272f)
                curveToRelative(-0.298f, 0.335f, -0.627f, 0.664f, -0.968f, 0.98f)
                curveToRelative(-7.571f, 7.041f, -8.126f, 1.655f, -12.039f, -1.99f)
                curveToRelative(-3.92f, -3.639f, -9.714f, -4.163f, -2.142f, -11.198f)
                curveToRelative(0.335f, -0.311f, 0.682f, -0.615f, 1.041f, -0.888f)
                curveToRelative(1.095f, -0.87f, 2.282f, -1.595f, 3.512f, -2.203f)
                curveToRelative(1.661f, -0.822f, 3.395f, -1.431f, 5.088f, -1.876f)
                curveToRelative(3.329f, -0.876f, 6.494f, -1.137f, 8.594f, -1.2f)
                lineToRelative(0.006f, 0f)
                curveToRelative(0.134f, -0.005f, 0.262f, -0.005f, 0.384f, -0.011f)
                lineToRelative(0.25f, 0f)
                curveToRelative(0.347f, -0.007f, 0.651f, -0.007f, 0.907f, 0f)
                curveToRelative(0.645f, 0.006f, 1.01f, 0.03f, 1.01f, 0.03f)
                curveToRelative(0f, 0f, 0f, 0.031f, 0.006f, 0.085f)
                curveToRelative(-0.006f, 0f, -0.006f, 0f, 0f, 0.006f)
                curveToRelative(0.03f, 0.542f, 0.164f, 3.408f, -0.488f, 6.993f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF3AA43))) {
                moveToRelative(33.919f, 36.953f)
                curveToRelative(-0.651f, 3.585f, -2.076f, 7.888f, -5.161f, 11.272f)
                curveToRelative(-6.208f, 5.046f, -6.938f, 0.135f, -10.584f, -3.262f)
                curveToRelative(-3.652f, -3.395f, -8.923f, -4.077f, -3.524f, -9.835f)
                curveToRelative(1.095f, -0.87f, 2.282f, -1.595f, 3.512f, -2.203f)
                curveToRelative(1.661f, -0.822f, 3.395f, -1.431f, 5.088f, -1.876f)
                curveToRelative(3.329f, -0.876f, 6.494f, -1.137f, 8.594f, -1.2f)
                lineToRelative(0.006f, 0f)
                curveToRelative(0.134f, -0.005f, 0.262f, -0.005f, 0.384f, -0.011f)
                lineToRelative(0.25f, 0f)
                curveToRelative(0.347f, -0.007f, 0.651f, -0.007f, 0.907f, 0f)
                curveToRelative(0.645f, 0.006f, 1.01f, 0.03f, 1.01f, 0.03f)
                curveToRelative(0f, 0f, 0f, 0.031f, 0.006f, 0.085f)
                curveToRelative(-0.006f, 0f, -0.006f, -0f, 0f, 0.005f)
                curveToRelative(0.031f, 0.542f, 0.165f, 3.409f, -0.487f, 6.994f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE47E30))) {
                moveToRelative(24.169f, 45.283f)
                curveToRelative(-2.514f, -1.115f, -3.63f, -9.353f, -0.651f, -12.529f)
                curveToRelative(4.235f, -3.35f, 10.899f, -2.903f, 10.899f, -2.903f)
                curveToRelative(0f, 0f, -2.707f, 18.779f, -10.248f, 15.433f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.085f, 38.409f)
                curveToRelative(0.365f, 0.497f, -0.482f, 1.739f, -1.891f, 2.772f)
                curveToRelative(-1.409f, 1.034f, -2.848f, 1.468f, -3.213f, 0.972f)
                curveToRelative(-0.364f, -0.497f, 0.483f, -1.738f, 1.892f, -2.772f)
                curveToRelative(1.409f, -1.033f, 2.848f, -1.469f, 3.212f, -0.972f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.458f, 34.718f)
                curveToRelative(0.259f, 0.354f, -0.342f, 1.234f, -1.342f, 1.968f)
                curveToRelative(-1f, 0.733f, -2.021f, 1.043f, -2.279f, 0.688f)
                curveToRelative(-0.258f, -0.352f, 0.342f, -1.233f, 1.342f, -1.965f)
                curveToRelative(1.001f, -0.734f, 2.021f, -1.043f, 2.279f, -0.691f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.813f, 32.461f)
                curveToRelative(0.175f, 0.239f, -0.232f, 0.837f, -0.909f, 1.334f)
                curveToRelative(-0.678f, 0.496f, -1.369f, 0.706f, -1.545f, 0.467f)
                curveToRelative(-0.175f, -0.239f, 0.231f, -0.836f, 0.909f, -1.333f)
                curveToRelative(0.678f, -0.497f, 1.369f, -0.706f, 1.545f, -0.468f)
                close()
            }
        }
        group("wing-l1", rotate = rotateL1.value, pivotX = 34.436f, pivotY = 27.776f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(34.436f, 27.776f)
                curveToRelative(0f, 0.894f, -0.718f, 1.533f, -1.954f, 2.063f)
                curveToRelative(-0.024f, 0.006f, -0.055f, 0.018f, -0.079f, 0.03f)
                curveToRelative(-0.061f, 0.024f, -0.128f, 0.048f, -0.195f, 0.079f)
                curveToRelative(-1.643f, 0.634f, -4.078f, 1.102f, -6.902f, 1.668f)
                curveToRelative(-1.381f, 0.273f, -2.855f, 0.573f, -4.37f, 0.925f)
                curveToRelative(-0.956f, 0.225f, -1.881f, 0.347f, -2.775f, 0.384f)
                curveToRelative(-2.434f, 0.097f, -4.607f, -0.44f, -6.372f, -1.279f)
                curveToRelative(-3.597f, -1.691f, -5.514f, -4.606f, -4.595f, -5.885f)
                curveToRelative(3.548f, -4.923f, -6.086f, -13.845f, -0.012f, -18.015f)
                curveToRelative(2.3f, -1.576f, 7.132f, 1.893f, 13.907f, 6.865f)
                curveToRelative(4.413f, 3.232f, 9.239f, 7.517f, 11.478f, 10.219f)
                curveToRelative(0.341f, 0.408f, 0.621f, 0.778f, 0.828f, 1.107f)
                curveToRelative(0.316f, 0.267f, 0.566f, 0.542f, 0.736f, 0.834f)
                curveToRelative(0.201f, 0.324f, 0.304f, 0.658f, 0.304f, 1.006f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF3AA43))) {
                moveToRelative(34.437f, 27.776f)
                curveToRelative(0f, 0.894f, -0.718f, 1.533f, -1.954f, 2.063f)
                curveToRelative(-0.024f, 0.006f, -0.055f, 0.018f, -0.079f, 0.03f)
                curveToRelative(-0.061f, 0.024f, -0.128f, 0.048f, -0.195f, 0.079f)
                curveToRelative(-1.643f, 0.634f, -4.078f, 1.102f, -6.902f, 1.668f)
                curveToRelative(-1.381f, 0.273f, -2.855f, 0.573f, -4.37f, 0.925f)
                curveToRelative(-0.956f, 0.225f, -1.881f, 0.347f, -2.775f, 0.384f)
                curveToRelative(-2.434f, 0.097f, -4.607f, -0.44f, -6.372f, -1.279f)
                curveToRelative(-0.073f, -0.431f, -0.012f, -0.803f, 0.201f, -1.095f)
                curveToRelative(3.548f, -4.917f, -6.086f, -13.841f, -0.012f, -18.009f)
                curveToRelative(2.3f, -1.576f, 7.127f, 1.893f, 13.907f, 6.866f)
                curveToRelative(2.252f, 1.649f, 4.613f, 3.572f, 6.682f, 5.422f)
                curveToRelative(0.341f, 0.408f, 0.621f, 0.778f, 0.828f, 1.107f)
                curveToRelative(0.316f, 0.267f, 0.566f, 0.542f, 0.736f, 0.834f)
                curveToRelative(0.201f, 0.324f, 0.304f, 0.658f, 0.304f, 1.006f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE47E30))) {
                moveToRelative(34.188f, 28.289f)
                curveToRelative(0f, 1.484f, -3.512f, 1.73f, -7.598f, 2.683f)
                curveToRelative(-2.007f, 0.468f, -3.792f, 0.139f, -5.148f, -0.504f)
                curveToRelative(-0.042f, -0.243f, -0.007f, -0.452f, 0.112f, -0.617f)
                curveToRelative(1.998f, -2.767f, -3.425f, -7.789f, -0.007f, -10.136f)
                curveToRelative(1.295f, -0.886f, 4.011f, 1.067f, 7.828f, 3.864f)
                curveToRelative(1.267f, 0.929f, 2.597f, 2.011f, 3.762f, 3.052f)
                curveToRelative(0.192f, 0.229f, 0.349f, 0.438f, 0.466f, 0.624f)
                curveToRelative(0.376f, 0.317f, 0.585f, 0.667f, 0.585f, 1.034f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(8.873f, 12.288f)
                curveToRelative(1.1f, 0.207f, 1.917f, 0.778f, 1.823f, 1.274f)
                curveToRelative(-0.094f, 0.495f, -1.062f, 0.727f, -2.163f, 0.518f)
                curveToRelative(-1.101f, -0.209f, -1.918f, -0.779f, -1.823f, -1.275f)
                curveToRelative(0.094f, -0.495f, 1.062f, -0.727f, 2.163f, -0.518f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(10.495f, 10.878f)
                curveToRelative(0.828f, 0.157f, 1.443f, 0.587f, 1.372f, 0.959f)
                curveToRelative(-0.07f, 0.373f, -0.799f, 0.548f, -1.628f, 0.39f)
                curveToRelative(-0.828f, -0.157f, -1.443f, -0.587f, -1.372f, -0.959f)
                curveToRelative(0.071f, -0.372f, 0.8f, -0.548f, 1.628f, -0.39f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(13.261f, 10.309f)
                curveToRelative(0.688f, 0.13f, 1.198f, 0.487f, 1.139f, 0.796f)
                curveToRelative(-0.059f, 0.309f, -0.664f, 0.455f, -1.352f, 0.325f)
                curveToRelative(-0.688f, -0.131f, -1.198f, -0.487f, -1.139f, -0.797f)
                curveToRelative(0.058f, -0.309f, 0.664f, -0.455f, 1.352f, -0.324f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(11.874f, 27.854f)
                curveToRelative(0f, 0.831f, -0.674f, 1.506f, -1.506f, 1.506f)
                curveToRelative(-0.831f, 0f, -1.506f, -0.674f, -1.506f, -1.506f)
                curveToRelative(0f, -0.831f, 0.674f, -1.506f, 1.506f, -1.506f)
                curveToRelative(0.831f, 0.001f, 1.506f, 0.674f, 1.506f, 1.506f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(11.49f, 24.154f)
                curveToRelative(0f, 0.434f, -0.353f, 0.787f, -0.786f, 0.787f)
                curveToRelative(-0.435f, 0f, -0.786f, -0.353f, -0.786f, -0.787f)
                curveToRelative(0f, -0.434f, 0.352f, -0.787f, 0.786f, -0.787f)
                curveToRelative(0.434f, 0f, 0.786f, 0.353f, 0.786f, 0.787f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(10.444f, 21.945f)
                curveToRelative(0f, 0.291f, -0.236f, 0.527f, -0.527f, 0.527f)
                curveToRelative(-0.291f, 0f, -0.527f, -0.236f, -0.527f, -0.527f)
                curveToRelative(0f, -0.291f, 0.236f, -0.527f, 0.527f, -0.527f)
                curveToRelative(0.292f, 0f, 0.527f, 0.235f, 0.527f, 0.527f)
                close()
            }
        }
        group("wing-r2", rotate = rotateR2.value, pivotX = 36.599f, pivotY = 29.867f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(42.241f, 48.222f)
                curveToRelative(0.298f, 0.339f, 0.627f, 0.667f, 0.968f, 0.985f)
                curveToRelative(7.571f, 7.037f, 8.126f, 1.653f, 12.039f, -1.992f)
                curveToRelative(3.92f, -3.64f, 9.714f, -4.162f, 2.142f, -11.2f)
                curveToRelative(-0.335f, -0.311f, -0.682f, -0.61f, -1.041f, -0.887f)
                curveToRelative(-7.675f, -6.07f, -19.75f, -5.261f, -19.75f, -5.261f)
                curveToRelative(0f, 0f, -0.87f, 11.215f, 5.643f, 18.355f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF3AA43))) {
                moveToRelative(42.241f, 48.222f)
                curveToRelative(6.208f, 5.049f, 6.938f, 0.136f, 10.584f, -3.261f)
                curveToRelative(3.652f, -3.39f, 8.923f, -4.076f, 3.524f, -9.833f)
                curveToRelative(-7.675f, -6.07f, -19.75f, -5.261f, -19.75f, -5.261f)
                curveToRelative(0f, 0f, -0.871f, 11.215f, 5.642f, 18.355f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE47E30))) {
                moveToRelative(46.829f, 45.283f)
                curveToRelative(2.514f, -1.115f, 3.63f, -9.353f, 0.651f, -12.529f)
                curveToRelative(-4.235f, -3.35f, -10.899f, -2.903f, -10.899f, -2.903f)
                curveToRelative(0f, 0f, 2.707f, 18.779f, 10.248f, 15.432f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(46.914f, 38.409f)
                curveToRelative(-0.365f, 0.497f, 0.482f, 1.739f, 1.891f, 2.772f)
                curveToRelative(1.409f, 1.034f, 2.848f, 1.468f, 3.213f, 0.972f)
                curveToRelative(0.364f, -0.497f, -0.483f, -1.738f, -1.892f, -2.772f)
                curveToRelative(-1.409f, -1.033f, -2.847f, -1.469f, -3.212f, -0.972f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(46.541f, 34.718f)
                curveToRelative(-0.259f, 0.354f, 0.342f, 1.234f, 1.342f, 1.968f)
                curveToRelative(1f, 0.733f, 2.021f, 1.043f, 2.279f, 0.688f)
                curveToRelative(0.258f, -0.352f, -0.342f, -1.233f, -1.342f, -1.965f)
                curveToRelative(-1.001f, -0.734f, -2.02f, -1.043f, -2.279f, -0.691f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(46.187f, 32.461f)
                curveToRelative(-0.175f, 0.239f, 0.231f, 0.837f, 0.909f, 1.334f)
                curveToRelative(0.678f, 0.496f, 1.369f, 0.706f, 1.545f, 0.467f)
                curveToRelative(0.175f, -0.239f, -0.231f, -0.836f, -0.909f, -1.333f)
                curveToRelative(-0.679f, -0.497f, -1.369f, -0.706f, -1.545f, -0.468f)
                close()
            }
        }
        group("wing-r1", rotate = rotateR1.value, pivotX = 36.563f, pivotY = 27.776f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(36.563f, 27.776f)
                curveToRelative(0f, 2.635f, 6.239f, 3.073f, 13.499f, 4.765f)
                curveToRelative(3.567f, 0.833f, 6.738f, 0.249f, 9.147f, -0.895f)
                curveToRelative(3.597f, -1.691f, 5.514f, -4.606f, 4.595f, -5.885f)
                curveToRelative(-3.548f, -4.923f, 6.086f, -13.845f, 0.012f, -18.015f)
                curveToRelative(-2.3f, -1.576f, -7.132f, 1.893f, -13.907f, 6.865f)
                curveToRelative(-4.413f, 3.232f, -9.239f, 7.517f, -11.478f, 10.219f)
                curveToRelative(-0.341f, 0.408f, -0.621f, 0.778f, -0.828f, 1.107f)
                curveToRelative(-0.67f, 0.567f, -1.041f, 1.188f, -1.041f, 1.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF3AA43))) {
                moveToRelative(36.563f, 27.776f)
                curveToRelative(0f, 2.635f, 6.239f, 3.073f, 13.499f, 4.765f)
                curveToRelative(3.567f, 0.833f, 6.738f, 0.249f, 9.147f, -0.895f)
                curveToRelative(0.073f, -0.431f, 0.012f, -0.803f, -0.201f, -1.095f)
                curveToRelative(-3.548f, -4.917f, 6.086f, -13.841f, 0.012f, -18.009f)
                curveToRelative(-2.3f, -1.576f, -7.127f, 1.893f, -13.907f, 6.866f)
                curveToRelative(-2.252f, 1.649f, -4.613f, 3.572f, -6.682f, 5.422f)
                curveToRelative(-0.341f, 0.408f, -0.621f, 0.778f, -0.828f, 1.107f)
                curveToRelative(-0.67f, 0.567f, -1.041f, 1.188f, -1.041f, 1.84f)
                close()
            }
            path(fill = SolidColor(Color(0xFFE47E30))) {
                moveToRelative(36.81f, 28.289f)
                curveToRelative(0f, 1.484f, 3.512f, 1.73f, 7.598f, 2.683f)
                curveToRelative(2.007f, 0.468f, 3.792f, 0.139f, 5.148f, -0.504f)
                curveToRelative(0.042f, -0.243f, 0.007f, -0.452f, -0.112f, -0.617f)
                curveToRelative(-1.997f, -2.767f, 3.425f, -7.789f, 0.007f, -10.136f)
                curveToRelative(-1.295f, -0.886f, -4.011f, 1.067f, -7.828f, 3.864f)
                curveToRelative(-1.267f, 0.929f, -2.597f, 2.011f, -3.761f, 3.052f)
                curveToRelative(-0.192f, 0.229f, -0.349f, 0.438f, -0.466f, 0.624f)
                curveToRelative(-0.377f, 0.317f, -0.586f, 0.667f, -0.586f, 1.034f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(62.126f, 12.288f)
                curveToRelative(-1.1f, 0.207f, -1.917f, 0.778f, -1.823f, 1.274f)
                curveToRelative(0.094f, 0.495f, 1.062f, 0.727f, 2.163f, 0.518f)
                curveToRelative(1.101f, -0.208f, 1.918f, -0.779f, 1.823f, -1.275f)
                curveToRelative(-0.094f, -0.495f, -1.063f, -0.727f, -2.163f, -0.518f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(60.503f, 10.878f)
                curveToRelative(-0.828f, 0.157f, -1.443f, 0.587f, -1.372f, 0.959f)
                curveToRelative(0.07f, 0.373f, 0.799f, 0.548f, 1.628f, 0.39f)
                curveToRelative(0.828f, -0.157f, 1.443f, -0.587f, 1.372f, -0.959f)
                curveToRelative(-0.07f, -0.372f, -0.798f, -0.548f, -1.627f, -0.39f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(57.738f, 10.309f)
                curveToRelative(-0.688f, 0.13f, -1.198f, 0.487f, -1.139f, 0.796f)
                curveToRelative(0.059f, 0.309f, 0.664f, 0.455f, 1.352f, 0.325f)
                curveToRelative(0.688f, -0.131f, 1.198f, -0.487f, 1.139f, -0.797f)
                curveToRelative(-0.058f, -0.309f, -0.664f, -0.455f, -1.352f, -0.324f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(59.125f, 27.854f)
                curveToRelative(0f, 0.831f, 0.674f, 1.506f, 1.506f, 1.506f)
                curveToRelative(0.831f, 0f, 1.506f, -0.674f, 1.506f, -1.506f)
                curveToRelative(0f, -0.831f, -0.674f, -1.506f, -1.506f, -1.506f)
                curveToRelative(-0.831f, 0.001f, -1.506f, 0.674f, -1.506f, 1.506f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(59.508f, 24.154f)
                curveToRelative(0f, 0.434f, 0.353f, 0.787f, 0.786f, 0.787f)
                curveToRelative(0.435f, 0f, 0.786f, -0.353f, 0.786f, -0.787f)
                curveToRelative(0f, -0.434f, -0.352f, -0.787f, -0.786f, -0.787f)
                curveToRelative(-0.434f, 0f, -0.786f, 0.353f, -0.786f, 0.787f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveToRelative(60.555f, 21.945f)
                curveToRelative(0f, 0.291f, 0.236f, 0.527f, 0.527f, 0.527f)
                curveToRelative(0.291f, 0f, 0.527f, -0.236f, 0.527f, -0.527f)
                curveToRelative(0f, -0.291f, -0.236f, -0.527f, -0.527f, -0.527f)
                curveToRelative(-0.291f, 0f, -0.527f, 0.235f, -0.527f, 0.527f)
                close()
            }
        }
    }.build()
}