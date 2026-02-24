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
import pnemonic.bug_bash.model.bug.Beetle
import pnemonic.stateOf

private const val durationLeg = 1000

@Composable
fun beetle(bug: Beetle): ImageVector = beetle(bug.isSquashed)

@Composable
fun beetle(squashed: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateL4: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>
    val rotateR4: State<Float>

    if (squashed) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateL3 = rotateL2
        rotateL4 = stateOf(0f)
        rotateR1 = stateOf(0f)
        rotateR2 = rotateR1
        rotateR3 = rotateR1
        rotateR4 = rotateL4
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = 45f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL4 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = 45f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = -45f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR3 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR4 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Beetle",
        defaultWidth = 30.dp,
        defaultHeight = 34.7.dp,
        viewportWidth = 30f,
        viewportHeight = 34.7f
    ).apply {
        path(fill = SolidColor(Color(0xFFFBB040))) {
            moveToRelative(19.305f, 6.787f)
            curveToRelative(0f, 0.914f, -1.927f, 1.654f, -4.305f, 1.654f)
            curveToRelative(-2.377f, -0f, -4.305f, -0.74f, -4.305f, -1.654f)
            curveToRelative(0f, -0.914f, 1.928f, -1.654f, 4.305f, -1.654f)
            curveToRelative(2.378f, -0f, 4.305f, 0.74f, 4.305f, 1.654f)
        }
        // collar
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(12.416f, 7.514f)
            curveToRelative(0.349f, -0f, 0.729f, -0.132f, 1.131f, -0.272f)
            curveToRelative(0.466f, -0.161f, 0.947f, -0.329f, 1.448f, -0.329f)
            curveToRelative(0.502f, -0f, 0.983f, 0.168f, 1.449f, 0.329f)
            curveToRelative(0.402f, 0.14f, 0.781f, 0.272f, 1.131f, 0.272f)
            curveToRelative(0.624f, -0f, 1.021f, -0.393f, 1.249f, -1.289f)
            lineToRelative(-0.001f, 0.008f)
            curveToRelative(-0.273f, 1.381f, -0.81f, 1.497f, -1.291f, 1.497f)
            curveToRelative(-0.305f, -0f, -0.66f, -0.067f, -1.036f, -0.14f)
            curveToRelative(-0.451f, -0.085f, -0.962f, -0.184f, -1.495f, -0.184f)
            curveToRelative(-0.533f, -0f, -1.045f, 0.099f, -1.497f, 0.185f)
            curveToRelative(-0.377f, 0.071f, -0.732f, 0.14f, -1.035f, 0.14f)
            curveToRelative(-0.481f, -0f, -1.019f, -0.116f, -1.291f, -1.497f)
            lineToRelative(-0.006f, -0.033f)
            curveToRelative(0.229f, 0.899f, 0.624f, 1.313f, 1.246f, 1.313f)
            close()
            moveTo(10.696f, 6.798f)
            curveToRelative(0.03f, -0.028f, 0.056f, -0.057f, 0.087f, -0.083f)
            curveToRelative(0.085f, 0.311f, 0.197f, 0.567f, 0.328f, 0.779f)
            curveToRelative(0.362f, 0.293f, 0.94f, 0.538f, 1.655f, 0.706f)
            curveToRelative(0.266f, -0.025f, 0.539f, -0.068f, 0.829f, -0.123f)
            curveToRelative(0.451f, -0.086f, 0.918f, -0.176f, 1.405f, -0.176f)
            curveToRelative(0.486f, -0f, 0.953f, 0.089f, 1.404f, 0.175f)
            curveToRelative(0.291f, 0.056f, 0.565f, 0.099f, 0.83f, 0.124f)
            curveToRelative(0.715f, -0.168f, 1.291f, -0.411f, 1.652f, -0.704f)
            curveToRelative(0.133f, -0.212f, 0.244f, -0.467f, 0.33f, -0.781f)
            curveToRelative(0.031f, 0.026f, 0.058f, 0.056f, 0.088f, 0.083f)
            curveToRelative(0f, -0.003f, 0.001f, -0.007f, 0.001f, -0.01f)
            curveToRelative(0f, -0.378f, -0.333f, -0.726f, -0.888f, -1.004f)
            curveToRelative(-0.193f, 1.061f, -0.525f, 1.238f, -0.842f, 1.238f)
            curveToRelative(-0.267f, -0f, -0.607f, -0.119f, -0.969f, -0.244f)
            curveToRelative(-0.48f, -0.166f, -1.026f, -0.356f, -1.611f, -0.356f)
            curveToRelative(-0.585f, -0f, -1.129f, 0.19f, -1.61f, 0.356f)
            curveToRelative(-0.361f, 0.126f, -0.702f, 0.244f, -0.969f, 0.244f)
            curveToRelative(-0.214f, -0f, -0.615f, -0.001f, -0.84f, -1.233f)
            curveToRelative(-0.551f, 0.277f, -0.881f, 0.623f, -0.881f, 1f)
            curveToRelative(0f, 0.003f, 0.001f, 0.006f, 0.001f, 0.011f)
        }
        group(name = "left-l1", rotate = rotateL1.value, pivotX = 8.810f, 10.214f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.355f, 5.695f)
                lineToRelative(0f, 3.065f)
                curveToRelative(0f, 0.803f, 0.651f, 1.455f, 1.455f, 1.455f)
                lineTo(8.81f, 4.239f)
                curveToRelative(-0.804f, -0f, -1.455f, 0.652f, -1.455f, 1.455f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(8.083f, 8.939f)
                lineToRelative(0f, 1.092f)
                curveToRelative(0f, 0.803f, 0.651f, 1.455f, 1.455f, 1.455f)
                lineToRelative(0f, -2.547f)
                lineToRelative(-1.455f, -0f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(8.309f, 4.957f)
                curveToRelative(-0.136f, -0f, -0.247f, -0.11f, -0.247f, -0.246f)
                lineToRelative(0f, -2.91f)
                curveToRelative(0f, -0.229f, -0.187f, -0.415f, -0.414f, -0.415f)
                curveToRelative(-0.229f, -0f, -0.416f, 0.186f, -0.416f, 0.415f)
                curveToRelative(0f, 0.137f, -0.11f, 0.247f, -0.247f, 0.247f)
                curveToRelative(-0.136f, -0f, -0.246f, -0.11f, -0.246f, -0.247f)
                curveToRelative(0f, -0.501f, 0.406f, -0.908f, 0.908f, -0.908f)
                curveToRelative(0.5f, -0f, 0.908f, 0.407f, 0.908f, 0.908f)
                lineToRelative(0f, 2.91f)
                curveToRelative(0f, 0.136f, -0.11f, 0.246f, -0.247f, 0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(8.309f, 4.957f)
                curveToRelative(-0.136f, -0f, -0.247f, -0.11f, -0.247f, -0.246f)
                lineToRelative(0f, -2.91f)
                curveToRelative(0f, -0.501f, 0.407f, -0.908f, 0.908f, -0.908f)
                curveToRelative(0.501f, -0f, 0.908f, 0.407f, 0.908f, 0.908f)
                curveToRelative(0f, 0.137f, -0.109f, 0.247f, -0.246f, 0.247f)
                curveToRelative(-0.137f, -0f, -0.247f, -0.11f, -0.247f, -0.247f)
                curveToRelative(0f, -0.229f, -0.187f, -0.415f, -0.415f, -0.415f)
                curveToRelative(-0.229f, -0f, -0.415f, 0.186f, -0.415f, 0.415f)
                lineToRelative(0f, 2.91f)
                curveToRelative(0f, 0.136f, -0.11f, 0.246f, -0.247f, 0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.747f, 5.703f)
                lineToRelative(-1.006f, -1.007f)
                lineToRelative(1.006f, -0f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.747f, 7.48f)
                lineToRelative(-1.006f, -1.007f)
                lineToRelative(1.006f, -0f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.747f, 9.258f)
                lineToRelative(-1.006f, -1.008f)
                lineToRelative(1.006f, -0f)
                close()
            }
        }
        group(name = "leg-r1", rotate = rotateR1.value, pivotX = 21.189f, 10.214f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.644f, 5.695f)
                lineToRelative(0f, 3.065f)
                curveToRelative(0f, 0.803f, -0.651f, 1.455f, -1.455f, 1.455f)
                lineTo(21.189f, 4.239f)
                curveToRelative(0.804f, -0f, 1.455f, 0.652f, 1.455f, 1.455f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(21.917f, 8.939f)
                lineToRelative(0f, 1.092f)
                curveToRelative(0f, 0.803f, -0.651f, 1.455f, -1.455f, 1.455f)
                lineToRelative(0f, -2.547f)
                lineToRelative(1.455f, -0f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(21.69f, 4.957f)
                curveToRelative(0.137f, -0f, 0.247f, -0.11f, 0.247f, -0.246f)
                lineToRelative(0f, -2.91f)
                curveToRelative(0f, -0.229f, 0.187f, -0.415f, 0.416f, -0.415f)
                curveToRelative(0.229f, -0f, 0.415f, 0.186f, 0.415f, 0.415f)
                curveToRelative(0f, 0.137f, 0.111f, 0.247f, 0.246f, 0.247f)
                curveToRelative(0.136f, -0f, 0.247f, -0.11f, 0.247f, -0.247f)
                curveToRelative(0f, -0.501f, -0.407f, -0.908f, -0.908f, -0.908f)
                curveToRelative(-0.5f, -0f, -0.908f, 0.407f, -0.908f, 0.908f)
                lineToRelative(0f, 2.91f)
                curveToRelative(0f, 0.136f, 0.11f, 0.246f, 0.246f, 0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(21.69f, 4.957f)
                curveToRelative(0.137f, -0f, 0.247f, -0.11f, 0.247f, -0.246f)
                lineToRelative(0f, -2.91f)
                curveToRelative(0f, -0.501f, -0.406f, -0.908f, -0.907f, -0.908f)
                curveToRelative(-0.501f, -0f, -0.909f, 0.407f, -0.909f, 0.908f)
                curveToRelative(0f, 0.137f, 0.11f, 0.247f, 0.247f, 0.247f)
                curveToRelative(0.136f, -0f, 0.247f, -0.11f, 0.247f, -0.247f)
                curveToRelative(0f, -0.229f, 0.187f, -0.415f, 0.416f, -0.415f)
                curveToRelative(0.229f, -0f, 0.415f, 0.186f, 0.415f, 0.415f)
                lineToRelative(0f, 2.91f)
                curveToRelative(0f, 0.136f, 0.11f, 0.246f, 0.246f, 0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.253f, 5.703f)
                lineToRelative(1.006f, -1.007f)
                lineToRelative(-1.006f, -0f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.253f, 7.48f)
                lineToRelative(1.006f, -1.007f)
                lineToRelative(-1.006f, -0f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.253f, 9.258f)
                lineToRelative(1.006f, -1.008f)
                lineToRelative(-1.006f, -0f)
                close()
            }
        }
        group(name = "leg-l2", rotate = rotateL2.value, pivotX = 9.707f, 13.756f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(5.79f, 17.602f)
                curveToRelative(0.136f, -0f, 0.247f, 0.11f, 0.247f, 0.247f)
                lineTo(6.037f, 22.237f)
                curveToRelative(0f, 0.229f, 0.186f, 0.415f, 0.414f, 0.415f)
                curveToRelative(0.23f, -0f, 0.415f, -0.186f, 0.415f, -0.415f)
                curveToRelative(0f, -0.136f, 0.111f, -0.247f, 0.247f, -0.247f)
                curveToRelative(0.136f, -0f, 0.247f, 0.111f, 0.247f, 0.247f)
                curveToRelative(0f, 0.501f, -0.408f, 0.908f, -0.909f, 0.908f)
                curveToRelative(-0.501f, -0f, -0.907f, -0.407f, -0.907f, -0.908f)
                lineToRelative(0f, -4.39f)
                curveToRelative(0f, -0.136f, 0.109f, -0.246f, 0.246f, -0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(5.79f, 17.602f)
                curveToRelative(0.136f, -0f, 0.247f, 0.11f, 0.247f, 0.247f)
                lineTo(6.037f, 22.237f)
                curveToRelative(0f, 0.501f, -0.408f, 0.908f, -0.908f, 0.908f)
                curveToRelative(-0.5f, -0f, -0.908f, -0.407f, -0.908f, -0.908f)
                curveToRelative(0f, -0.136f, 0.111f, -0.247f, 0.247f, -0.247f)
                curveToRelative(0.136f, -0f, 0.247f, 0.111f, 0.247f, 0.247f)
                curveToRelative(0f, 0.229f, 0.185f, 0.415f, 0.414f, 0.415f)
                curveToRelative(0.229f, -0f, 0.416f, -0.186f, 0.416f, -0.415f)
                lineToRelative(0f, -4.39f)
                curveToRelative(0f, -0.136f, 0.109f, -0.246f, 0.246f, -0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(6.065f, 18.173f)
                curveToRelative(-0.214f, 0.214f, -0.561f, 0.214f, -0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.214f, -0.214f, -0.214f, -0.561f, 0f, -0.775f)
                lineToRelative(3.642f, -3.641f)
                curveToRelative(0.213f, -0.213f, 0.561f, -0.213f, 0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(0.213f, 0.214f, 0.213f, 0.561f, 0f, 0.775f)
                lineTo(6.065f, 18.173f)
            }
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(9.371f, 14.63f)
            curveToRelative(-0.303f, -0f, -0.549f, -0.245f, -0.549f, -0.548f)
            lineToRelative(0f, -0f)
            curveToRelative(0f, -0.303f, 0.246f, -0.548f, 0.549f, -0.548f)
            lineToRelative(5.149f, 0.001f)
            curveToRelative(0.303f, -0f, 0.548f, 0.244f, 0.548f, 0.548f)
            lineToRelative(0f, -0f)
            curveToRelative(0f, 0.302f, -0.246f, 0.548f, -0.548f, 0.548f)
            lineToRelative(-5.149f, -0.001f)
        }
        group(name = "leg-r2", rotate = rotateR2.value, pivotX = 20.294f, 13.756f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.209f, 17.602f)
                curveToRelative(-0.136f, -0f, -0.247f, 0.11f, -0.247f, 0.247f)
                lineTo(23.962f, 22.237f)
                curveToRelative(0f, 0.229f, -0.185f, 0.415f, -0.414f, 0.415f)
                curveToRelative(-0.23f, -0f, -0.415f, -0.186f, -0.415f, -0.415f)
                curveToRelative(0f, -0.136f, -0.111f, -0.247f, -0.247f, -0.247f)
                curveToRelative(-0.136f, -0f, -0.247f, 0.111f, -0.247f, 0.247f)
                curveToRelative(0f, 0.501f, 0.407f, 0.908f, 0.909f, 0.908f)
                curveToRelative(0.5f, -0f, 0.908f, -0.407f, 0.908f, -0.908f)
                lineToRelative(0f, -4.39f)
                curveToRelative(0f, -0.136f, -0.111f, -0.246f, -0.247f, -0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.209f, 17.602f)
                curveToRelative(-0.136f, -0f, -0.247f, 0.11f, -0.247f, 0.247f)
                lineTo(23.962f, 22.237f)
                curveToRelative(0f, 0.501f, 0.407f, 0.908f, 0.909f, 0.908f)
                curveToRelative(0.5f, -0f, 0.907f, -0.407f, 0.908f, -0.908f)
                curveToRelative(0f, -0.136f, -0.111f, -0.247f, -0.247f, -0.247f)
                curveToRelative(-0.136f, -0f, -0.247f, 0.111f, -0.247f, 0.247f)
                curveToRelative(0f, 0.229f, -0.187f, 0.415f, -0.415f, 0.415f)
                curveToRelative(-0.23f, -0f, -0.415f, -0.186f, -0.415f, -0.415f)
                lineToRelative(0f, -4.39f)
                curveToRelative(0f, -0.136f, -0.111f, -0.246f, -0.247f, -0.246f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(23.934f, 18.173f)
                curveToRelative(0.216f, 0.214f, 0.562f, 0.214f, 0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(0.214f, -0.214f, 0.214f, -0.561f, 0f, -0.775f)
                lineToRelative(-3.64f, -3.641f)
                curveToRelative(-0.214f, -0.213f, -0.562f, -0.213f, -0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.214f, 0.214f, -0.213f, 0.561f, 0f, 0.775f)
                lineToRelative(3.64f, 3.641f)
            }
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(20.63f, 14.63f)
            curveToRelative(0.302f, -0f, 0.548f, -0.245f, 0.547f, -0.548f)
            lineToRelative(0f, -0f)
            curveToRelative(0.001f, -0.303f, -0.245f, -0.548f, -0.547f, -0.548f)
            lineToRelative(-5.151f, 0.001f)
            curveToRelative(-0.301f, -0f, -0.548f, 0.244f, -0.547f, 0.548f)
            lineToRelative(0f, -0f)
            curveToRelative(-0.001f, 0.302f, 0.246f, 0.548f, 0.547f, 0.548f)
            lineToRelative(5.151f, -0.001f)
        }
        group(name = "leg-l3", rotate = rotateL3.value, pivotX = 11.162f, 20.950f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.09f, 29.998f)
                curveToRelative(0.096f, -0.096f, 0.251f, -0.097f, 0.348f, -0f)
                lineToRelative(3.103f, 3.103f)
                curveToRelative(0.162f, 0.163f, 0.425f, 0.163f, 0.586f, 0.001f)
                curveToRelative(0.163f, -0.163f, 0.163f, -0.425f, 0.001f, -0.588f)
                curveToRelative(-0.096f, -0.096f, -0.097f, -0.251f, 0f, -0.348f)
                curveToRelative(0.096f, -0.095f, 0.253f, -0.095f, 0.349f, -0f)
                curveToRelative(0.354f, 0.353f, 0.354f, 0.93f, -0.001f, 1.284f)
                curveToRelative(-0.353f, 0.355f, -0.929f, 0.355f, -1.283f, -0f)
                lineToRelative(-3.105f, -3.104f)
                curveToRelative(-0.096f, -0.096f, -0.095f, -0.252f, 0.001f, -0.349f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.09f, 29.998f)
                curveToRelative(0.096f, -0.096f, 0.251f, -0.097f, 0.348f, -0f)
                lineToRelative(3.103f, 3.103f)
                curveToRelative(0.354f, 0.355f, 0.354f, 0.931f, 0f, 1.285f)
                curveToRelative(-0.354f, 0.354f, -0.93f, 0.354f, -1.284f, -0f)
                curveToRelative(-0.096f, -0.096f, -0.096f, -0.253f, 0f, -0.349f)
                curveToRelative(0.096f, -0.097f, 0.252f, -0.096f, 0.348f, -0f)
                curveToRelative(0.163f, 0.162f, 0.425f, 0.162f, 0.587f, -0f)
                curveToRelative(0.162f, -0.162f, 0.162f, -0.425f, 0f, -0.586f)
                lineToRelative(-3.105f, -3.104f)
                curveToRelative(-0.096f, -0.096f, -0.095f, -0.252f, 0.001f, -0.349f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.687f, 30.209f)
                curveToRelative(0f, 0.303f, -0.246f, 0.548f, -0.548f, 0.548f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.302f, 0.002f, -0.547f, -0.244f, -0.547f, -0.548f)
                lineToRelative(0f, -5.15f)
                curveToRelative(0f, -0.302f, 0.246f, -0.548f, 0.547f, -0.548f)
                lineToRelative(0f, -0f)
                curveToRelative(0.303f, -0f, 0.548f, 0.246f, 0.548f, 0.549f)
                lineTo(7.687f, 30.209f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.52f, 25.366f)
                curveToRelative(-0.215f, 0.214f, -0.561f, 0.215f, -0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.214f, -0.214f, -0.213f, -0.56f, 0f, -0.775f)
                lineToRelative(3.642f, -3.64f)
                curveToRelative(0.214f, -0.214f, 0.561f, -0.215f, 0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(0.214f, 0.213f, 0.214f, 0.561f, 0f, 0.774f)
                lineTo(7.52f, 25.366f)
            }
        }
        group(name = "leg-r3", rotate = rotateR3.value, pivotX = 18.838f, 20.950f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.91f, 29.998f)
                curveToRelative(-0.096f, -0.097f, -0.253f, -0.097f, -0.35f, -0f)
                lineToRelative(-3.102f, 3.103f)
                curveToRelative(-0.162f, 0.162f, -0.425f, 0.162f, -0.587f, 0.001f)
                curveToRelative(-0.162f, -0.162f, -0.162f, -0.426f, 0f, -0.587f)
                curveToRelative(0.096f, -0.096f, 0.097f, -0.252f, 0f, -0.349f)
                curveToRelative(-0.096f, -0.096f, -0.252f, -0.095f, -0.349f, -0f)
                curveToRelative(-0.354f, 0.354f, -0.354f, 0.931f, 0f, 1.285f)
                curveToRelative(0.354f, 0.353f, 0.93f, 0.353f, 1.284f, -0.001f)
                lineToRelative(3.103f, -3.104f)
                curveToRelative(0.096f, -0.097f, 0.096f, -0.252f, 0f, -0.349f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.91f, 29.998f)
                curveToRelative(-0.096f, -0.097f, -0.253f, -0.097f, -0.35f, -0f)
                lineToRelative(-3.102f, 3.103f)
                curveToRelative(-0.354f, 0.354f, -0.354f, 0.931f, 0f, 1.284f)
                curveToRelative(0.353f, 0.353f, 0.929f, 0.353f, 1.283f, -0f)
                curveToRelative(0.097f, -0.096f, 0.097f, -0.252f, 0f, -0.348f)
                curveToRelative(-0.096f, -0.097f, -0.253f, -0.097f, -0.348f, -0f)
                curveToRelative(-0.162f, 0.161f, -0.424f, 0.161f, -0.586f, -0f)
                curveToRelative(-0.162f, -0.162f, -0.162f, -0.425f, 0f, -0.587f)
                lineToRelative(3.103f, -3.104f)
                curveToRelative(0.096f, -0.097f, 0.096f, -0.252f, 0f, -0.349f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.313f, 30.208f)
                curveToRelative(0f, 0.303f, 0.246f, 0.548f, 0.547f, 0.548f)
                lineToRelative(0f, -0f)
                curveToRelative(0.303f, 0f, 0.549f, -0.244f, 0.549f, -0.548f)
                lineTo(23.408f, 25.059f)
                curveToRelative(0f, -0.302f, -0.246f, -0.549f, -0.549f, -0.549f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.301f, -0f, -0.547f, 0.247f, -0.547f, 0.549f)
                lineTo(22.313f, 30.208f)
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.48f, 25.366f)
                curveToRelative(0.214f, 0.213f, 0.561f, 0.214f, 0.775f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(0.213f, -0.215f, 0.213f, -0.561f, 0f, -0.776f)
                lineToRelative(-3.643f, -3.641f)
                curveToRelative(-0.213f, -0.214f, -0.561f, -0.214f, -0.774f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.214f, 0.214f, -0.214f, 0.561f, 0f, 0.774f)
                lineToRelative(3.642f, 3.642f)
            }
        }
        group(name = "mandible-l", rotate = rotateL4.value, pivotX = 13.373f, 3.866f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(12.128f, 0.05f)
                curveToRelative(0f, -0.017f, 0.002f, -0.032f, 0.002f, -0.05f)
                curveToRelative(-0.538f, 0.388f, -0.892f, 1.016f, -0.892f, 1.73f)
                curveToRelative(0f, 1.179f, 0.956f, 2.136f, 2.135f, 2.136f)
                curveToRelative(0.606f, -0f, 1.15f, -0.256f, 1.538f, -0.661f)
                curveToRelative(-1.569f, -0.196f, -2.784f, -1.531f, -2.784f, -3.155f)
            }
        }
        group(name = "mandible-r", rotate = rotateR4.value, pivotX = 16.627f, 3.866f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(17.872f, 0.05f)
                curveToRelative(0f, -0.017f, -0.002f, -0.032f, -0.002f, -0.05f)
                curveToRelative(0.538f, 0.388f, 0.892f, 1.016f, 0.892f, 1.73f)
                curveToRelative(0f, 1.179f, -0.956f, 2.136f, -2.135f, 2.136f)
                curveToRelative(-0.606f, -0f, -1.151f, -0.256f, -1.539f, -0.661f)
                curveToRelative(1.569f, -0.196f, 2.784f, -1.531f, 2.784f, -3.155f)
            }
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(18.636f, 9.973f)
            curveToRelative(-0.474f, 2.693f, -1.922f, 1.373f, -3.636f, 1.373f)
            curveToRelative(-1.715f, -0f, -3.163f, 1.321f, -3.637f, -1.371f)
            curveToRelative(-1.029f, 0.827f, -1.674f, 2.092f, -1.674f, 3.796f)
            curveToRelative(0f, 3.279f, 2.377f, 4.951f, 5.311f, 4.951f)
            curveToRelative(2.934f, -0f, 5.312f, -1.672f, 5.312f, -4.951f)
            curveToRelative(0f, -1.705f, -0.646f, -2.971f, -1.675f, -3.798f)
        }
        path(fill = SolidColor(Color(0xFF49374F))) {
            moveToRelative(21.927f, 21.852f)
            curveToRelative(0f, 5.888f, -3.102f, 10.661f, -6.927f, 10.661f)
            curveToRelative(-3.826f, -0f, -6.927f, -4.774f, -6.927f, -10.661f)
            curveToRelative(0f, -11.148f, 3.101f, -6.225f, 6.927f, -6.225f)
            curveToRelative(3.826f, -0f, 6.927f, -4.924f, 6.927f, 6.225f)
        }
        path(fill = SolidColor(Color(0xFF3C2D42))) {
            moveToRelative(21.927f, 21.852f)
            curveToRelative(0f, -11.148f, -3.101f, -6.225f, -6.927f, -6.225f)
            lineTo(15f, 32.513f)
            curveToRelative(3.825f, -0f, 6.927f, -4.774f, 6.927f, -10.661f)
        }
        path(fill = SolidColor(Color(0xFF514F64))) {
            moveToRelative(11.653f, 3.221f)
            curveToRelative(-0.402f, 0.403f, -0.478f, 1.062f, -0.451f, 1.488f)
            curveToRelative(0.277f, 4.205f, 1.87f, 1.958f, 3.792f, 1.958f)
            curveToRelative(1.953f, -0f, 3.566f, 2.32f, 3.805f, -2.162f)
            curveToRelative(0.02f, -0.377f, -0.124f, -0.944f, -0.462f, -1.284f)
            curveToRelative(-1.356f, -1.356f, -5.328f, -1.356f, -6.685f, -0f)
        }
        path(fill = SolidColor(Color(0xFFFBB040))) {
            moveToRelative(9.346f, 10.319f)
            curveToRelative(0f, 3.279f, 2.531f, 4.951f, 5.654f, 4.951f)
            curveToRelative(3.123f, -0f, 5.653f, -1.672f, 5.653f, -4.951f)
            lineToRelative(-11.307f, -0f)
        }
        path(fill = SolidColor(Color(0xFF514F64))) {
            moveToRelative(19.064f, 6.282f)
            curveToRelative(-0.529f, 2.692f, -2.148f, 1.371f, -4.064f, 1.371f)
            curveToRelative(-1.916f, -0f, -3.536f, 1.322f, -4.065f, -1.371f)
            curveToRelative(-1.15f, 0.827f, -1.871f, 2.093f, -1.871f, 3.797f)
            curveToRelative(0f, 3.279f, 2.658f, 4.951f, 5.936f, 4.951f)
            curveToRelative(3.279f, -0f, 5.937f, -1.672f, 5.937f, -4.951f)
            curveToRelative(0f, -1.705f, -0.723f, -2.97f, -1.873f, -3.797f)
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(15f, 17.848f)
            curveToRelative(-0.669f, -0f, -1.212f, -0.544f, -1.212f, -1.212f)
            lineToRelative(0f, -1.403f)
            lineToRelative(0.291f, 0.055f)
            curveToRelative(0.668f, 0.125f, 1.173f, 0.125f, 1.84f, -0f)
            lineToRelative(0.291f, -0.055f)
            lineTo(16.211f, 16.637f)
            curveToRelative(0f, 0.668f, -0.543f, 1.212f, -1.211f, 1.212f)
        }
        path(fill = SolidColor(Color.Black)) {
            moveTo(15.247f, 32.513f)
            lineTo(14.753f, 32.513f)
            lineTo(14.753f, 17.602f)
            lineToRelative(0.494f, -0f)
            lineTo(15.247f, 32.513f)
        }
        path(fill = SolidColor(Color(0xFF514F64))) {
            moveTo(14.281f, 15.821f)
            lineTo(14.281f, 16.637f)
            curveToRelative(0f, 0.396f, 0.323f, 0.719f, 0.719f, 0.719f)
            curveToRelative(0.397f, -0f, 0.719f, -0.322f, 0.719f, -0.719f)
            lineToRelative(0f, -0.816f)
            curveToRelative(-0.505f, 0.073f, -0.934f, 0.073f, -1.438f, -0f)
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(18.432f, 4.145f)
            curveToRelative(0f, 0.327f, -0.113f, 0.591f, -0.252f, 0.591f)
            curveToRelative(-0.139f, -0f, -0.251f, -0.264f, -0.251f, -0.591f)
            curveToRelative(0f, -0.326f, 0.113f, -0.591f, 0.251f, -0.591f)
            curveToRelative(0.139f, -0f, 0.252f, 0.265f, 0.252f, 0.591f)
        }
        path(fill = SolidColor(Color(0xFF3E3D51))) {
            moveToRelative(19.064f, 6.282f)
            curveToRelative(-0.529f, 2.692f, -2.148f, 1.371f, -4.064f, 1.371f)
            lineToRelative(0f, 7.377f)
            lineToRelative(0f, -0f)
            curveToRelative(3.279f, -0f, 5.937f, -1.672f, 5.937f, -4.951f)
            curveToRelative(0f, -1.705f, -0.723f, -2.97f, -1.873f, -3.797f)
        }
        path(fill = SolidColor(Color(0xFF3E3D51))) {
            moveToRelative(15f, 2.204f)
            lineToRelative(0f, 4.463f)
            curveToRelative(1.951f, 0.004f, 3.562f, 2.316f, 3.8f, -2.162f)
            curveToRelative(0.02f, -0.377f, -0.124f, -0.944f, -0.462f, -1.284f)
            curveToRelative(-0.678f, -0.677f, -2.008f, -1.016f, -3.338f, -1.017f)
        }
    }.build()
}
