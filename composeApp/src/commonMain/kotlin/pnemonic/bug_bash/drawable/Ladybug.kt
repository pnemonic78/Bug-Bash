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
import pnemonic.bug_bash.model.bug.Ladybug
import pnemonic.stateOf

private const val durationLeg = 500

@Composable
fun ladybug(bug: Ladybug): ImageVector = ladybug(bug.isStopped)

@Composable
fun ladybug(stopped: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>

    if (stopped) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateL3 = rotateL2
        rotateR1 = stateOf(0f)
        rotateR2 = rotateR1
        rotateR3 = rotateR1
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
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = 40f,
            targetValue = -5f,
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
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR3 = transition.animateFloat(
            initialValue = 5f,
            targetValue = -40f,
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
        name = "Ladybug",
        defaultWidth = 29.21.dp,
        defaultHeight = 32.65.dp,
        viewportWidth = 29.21f,
        viewportHeight = 32.65f
    ).apply {
        group("leg-r3", rotate = rotateR3.value, pivotX = 22.571f, 22.748f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(24.273f, 32.642f)
                curveToRelative(0.131f, 0f, 0.264f, -0.057f, 0.354f, -0.167f)
                curveToRelative(0.16f, -0.196f, 0.131f, -0.484f, -0.066f, -0.644f)
                lineToRelative(-2.666f, -2.174f)
                curveToRelative(-0.195f, -0.159f, -0.482f, -0.13f, -0.643f, 0.066f)
                curveToRelative(-0.159f, 0.195f, -0.13f, 0.483f, 0.066f, 0.642f)
                lineToRelative(2.666f, 2.174f)
                curveToRelative(0.084f, 0.068f, 0.187f, 0.103f, 0.289f, 0.103f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(21.836f, 30.126f)
                curveToRelative(0.243f, 0f, 0.477f, -0.128f, 0.601f, -0.356f)
                lineToRelative(2.546f, -4.643f)
                curveToRelative(0.139f, -0.254f, 0.104f, -0.567f, -0.088f, -0.783f)
                lineToRelative(-1.356f, -1.535f)
                curveToRelative(-0.251f, -0.284f, -0.682f, -0.312f, -0.968f, -0.06f)
                curveToRelative(-0.283f, 0.25f, -0.31f, 0.684f, -0.06f, 0.967f)
                lineToRelative(1.039f, 1.175f)
                lineToRelative(-2.313f, 4.223f)
                curveToRelative(-0.183f, 0.33f, -0.06f, 0.747f, 0.27f, 0.93f)
                curveToRelative(0.106f, 0.056f, 0.22f, 0.083f, 0.33f, 0.083f)
                close()
            }
        }
        group("leg-r2", rotate = rotateR2.value, pivotX = 22.250f, 14.054f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(25.923f, 19.392f)
                curveToRelative(0.043f, 0f, 0.086f, -0.006f, 0.129f, -0.018f)
                lineToRelative(2.741f, -0.799f)
                curveToRelative(0.241f, -0.071f, 0.381f, -0.325f, 0.31f, -0.567f)
                curveToRelative(-0.07f, -0.242f, -0.323f, -0.381f, -0.566f, -0.31f)
                lineToRelative(-2.741f, 0.799f)
                curveToRelative(-0.243f, 0.071f, -0.38f, 0.325f, -0.31f, 0.567f)
                curveToRelative(0.058f, 0.201f, 0.24f, 0.329f, 0.438f, 0.329f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(25.532f, 19.62f)
                curveToRelative(0.04f, 0f, 0.081f, -0.004f, 0.122f, -0.012f)
                curveToRelative(0.373f, -0.066f, 0.62f, -0.423f, 0.554f, -0.795f)
                lineToRelative(-0.744f, -4.111f)
                curveToRelative(-0.044f, -0.252f, -0.229f, -0.459f, -0.475f, -0.534f)
                lineToRelative(-1.883f, -0.571f)
                curveToRelative(-0.364f, -0.11f, -0.746f, 0.095f, -0.856f, 0.458f)
                curveToRelative(-0.108f, 0.362f, 0.095f, 0.744f, 0.458f, 0.854f)
                lineToRelative(1.483f, 0.45f)
                lineToRelative(0.668f, 3.699f)
                curveToRelative(0.06f, 0.332f, 0.348f, 0.564f, 0.673f, 0.564f)
                close()
            }
        }
        group("leg-l3", rotate = rotateL3.value, pivotX = 6.550f, 22.748f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(4.848f, 32.642f)
                curveToRelative(-0.131f, 0f, -0.263f, -0.057f, -0.354f, -0.167f)
                curveToRelative(-0.16f, -0.196f, -0.131f, -0.484f, 0.066f, -0.644f)
                lineToRelative(2.666f, -2.174f)
                curveToRelative(0.195f, -0.159f, 0.482f, -0.13f, 0.642f, 0.066f)
                curveToRelative(0.16f, 0.195f, 0.13f, 0.483f, -0.066f, 0.642f)
                lineToRelative(-2.666f, 2.174f)
                curveToRelative(-0.084f, 0.068f, -0.187f, 0.103f, -0.289f, 0.103f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(7.285f, 30.126f)
                curveToRelative(-0.243f, 0f, -0.477f, -0.128f, -0.601f, -0.356f)
                lineToRelative(-2.545f, -4.643f)
                curveToRelative(-0.139f, -0.254f, -0.105f, -0.567f, 0.087f, -0.783f)
                lineToRelative(1.356f, -1.535f)
                curveToRelative(0.25f, -0.284f, 0.683f, -0.312f, 0.968f, -0.06f)
                curveToRelative(0.284f, 0.25f, 0.31f, 0.684f, 0.06f, 0.967f)
                lineToRelative(-1.038f, 1.175f)
                lineToRelative(2.313f, 4.223f)
                curveToRelative(0.182f, 0.33f, 0.06f, 0.747f, -0.272f, 0.93f)
                curveToRelative(-0.105f, 0.056f, -0.218f, 0.083f, -0.329f, 0.083f)
                close()
            }
        }
        group("leg-l2", rotate = rotateL2.value, pivotX = 6.871f, 14.054f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(3.198f, 19.392f)
                curveToRelative(-0.042f, 0f, -0.086f, -0.006f, -0.128f, -0.018f)
                lineToRelative(-2.741f, -0.799f)
                curveToRelative(-0.243f, -0.071f, -0.382f, -0.325f, -0.311f, -0.567f)
                curveToRelative(0.071f, -0.242f, 0.325f, -0.381f, 0.566f, -0.31f)
                lineToRelative(2.741f, 0.799f)
                curveToRelative(0.242f, 0.071f, 0.381f, 0.325f, 0.31f, 0.567f)
                curveToRelative(-0.057f, 0.201f, -0.24f, 0.329f, -0.438f, 0.329f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(3.59f, 19.62f)
                curveToRelative(-0.041f, 0f, -0.082f, -0.004f, -0.123f, -0.012f)
                curveToRelative(-0.372f, -0.066f, -0.619f, -0.423f, -0.553f, -0.795f)
                lineToRelative(0.743f, -4.111f)
                curveToRelative(0.045f, -0.252f, 0.229f, -0.459f, 0.475f, -0.534f)
                lineToRelative(1.885f, -0.571f)
                curveToRelative(0.363f, -0.11f, 0.745f, 0.095f, 0.855f, 0.458f)
                curveToRelative(0.108f, 0.362f, -0.095f, 0.744f, -0.457f, 0.854f)
                lineToRelative(-1.484f, 0.45f)
                lineToRelative(-0.669f, 3.699f)
                curveToRelative(-0.059f, 0.332f, -0.348f, 0.564f, -0.673f, 0.564f)
                close()
            }
        }
        group("leg-r1", rotate = rotateR1.value, pivotX = 19.294f, 8.799f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(19.872f, 9.114f)
                curveToRelative(0.126f, 0f, 0.253f, -0.034f, 0.368f, -0.108f)
                lineToRelative(1.966f, -1.256f)
                curveToRelative(0.168f, -0.107f, 0.28f, -0.283f, 0.308f, -0.479f)
                lineToRelative(0.661f, -4.568f)
                curveToRelative(0.054f, -0.375f, -0.206f, -0.722f, -0.58f, -0.776f)
                curveToRelative(-0.373f, -0.056f, -0.722f, 0.205f, -0.777f, 0.58f)
                lineToRelative(-0.617f, 4.257f)
                lineToRelative(-1.701f, 1.088f)
                curveToRelative(-0.319f, 0.204f, -0.412f, 0.628f, -0.208f, 0.947f)
                curveToRelative(0.13f, 0.203f, 0.351f, 0.315f, 0.579f, 0.315f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(22.497f, 3.061f)
                curveToRelative(0.046f, 0f, 0.091f, -0.007f, 0.137f, -0.02f)
                lineToRelative(3.427f, -1.075f)
                curveToRelative(0.239f, -0.076f, 0.373f, -0.331f, 0.298f, -0.572f)
                curveToRelative(-0.074f, -0.241f, -0.331f, -0.375f, -0.572f, -0.3f)
                lineToRelative(-3.426f, 1.074f)
                curveToRelative(-0.24f, 0.076f, -0.374f, 0.331f, -0.299f, 0.573f)
                curveToRelative(0.06f, 0.195f, 0.241f, 0.32f, 0.435f, 0.32f)
                close()
            }
        }
        group("leg-l1", rotate = rotateL1.value, pivotX = 9.828f, 8.799f) {
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(9.249f, 9.114f)
                curveToRelative(-0.126f, 0f, -0.254f, -0.034f, -0.368f, -0.108f)
                lineToRelative(-1.966f, -1.256f)
                curveToRelative(-0.168f, -0.107f, -0.281f, -0.283f, -0.309f, -0.479f)
                lineToRelative(-0.661f, -4.568f)
                curveToRelative(-0.054f, -0.375f, 0.206f, -0.722f, 0.58f, -0.776f)
                curveToRelative(0.373f, -0.056f, 0.722f, 0.205f, 0.777f, 0.58f)
                lineToRelative(0.616f, 4.257f)
                lineToRelative(1.702f, 1.088f)
                curveToRelative(0.319f, 0.204f, 0.412f, 0.628f, 0.208f, 0.947f)
                curveToRelative(-0.13f, 0.203f, -0.352f, 0.315f, -0.579f, 0.315f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveToRelative(6.624f, 3.061f)
                curveToRelative(-0.045f, 0f, -0.091f, -0.007f, -0.137f, -0.02f)
                lineToRelative(-3.426f, -1.075f)
                curveToRelative(-0.241f, -0.076f, -0.375f, -0.331f, -0.3f, -0.572f)
                curveToRelative(0.076f, -0.241f, 0.331f, -0.375f, 0.573f, -0.3f)
                lineToRelative(3.426f, 1.074f)
                curveToRelative(0.241f, 0.076f, 0.375f, 0.331f, 0.299f, 0.573f)
                curveToRelative(-0.06f, 0.195f, -0.241f, 0.32f, -0.435f, 0.32f)
                close()
            }
        }
        // shell
        path(fill = SolidColor(Color.Red)) {
            moveToRelative(14.561f, 8.889f)
            curveToRelative(-5.159f, 0.07f, -9.288f, 1.822f, -9.288f, 9.358f)
            curveToRelative(0f, 7.477f, 3.407f, 13.836f, 9.288f, 13.274f)
            curveToRelative(5.88f, 0.561f, 9.288f, -5.797f, 9.288f, -13.274f)
            curveToRelative(-0.001f, -7.535f, -4.128f, -9.288f, -9.288f, -9.358f)
            close()
        }
        path(fill = SolidColor(Color.DarkGray)) {
            moveToRelative(13.162f, 4.135f)
            curveToRelative(-0.21f, 0f, -2.605f, -3.041f, -2.605f, -3.041f)
            curveToRelative(-0.227f, -0.304f, -0.162f, -0.733f, 0.142f, -0.958f)
            curveToRelative(0.304f, -0.226f, 0.732f, -0.163f, 0.958f, 0.141f)
            curveToRelative(0f, 0f, 1.645f, 3.859f, 1.505f, 3.859f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(11.388f, 19.62f)
            curveToRelative(0f, 1.039f, -0.964f, 1.881f, -2.154f, 1.881f)
            curveToRelative(-1.189f, 0f, -2.154f, -0.843f, -2.154f, -1.881f)
            curveToRelative(0f, -1.039f, 0.965f, -1.881f, 2.154f, -1.881f)
            curveToRelative(1.19f, 0f, 2.154f, 0.842f, 2.154f, 1.881f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(13.95f, 26.351f)
            curveToRelative(0f, 1.039f, -0.964f, 1.88f, -2.154f, 1.88f)
            curveToRelative(-1.19f, 0f, -2.154f, -0.841f, -2.154f, -1.88f)
            curveToRelative(0f, -1.039f, 0.964f, -1.881f, 2.154f, -1.881f)
            curveToRelative(1.189f, -0.001f, 2.154f, 0.842f, 2.154f, 1.881f)
            close()
        }
        path(fill = SolidColor(Color.LightGray)) {
            moveToRelative(17.93f, 5.916f)
            lineToRelative(-3.369f, 0f)
            lineToRelative(-3.369f, 0f)
            curveToRelative(-1.387f, 0f, -2.511f, 1.125f, -2.511f, 2.513f)
            curveToRelative(0f, 1.388f, 1.124f, 2.513f, 2.511f, 2.513f)
            lineToRelative(3.369f, 0f)
            lineToRelative(3.369f, 0f)
            curveToRelative(1.386f, 0f, 2.511f, -1.125f, 2.511f, -2.513f)
            curveToRelative(0f, -1.388f, -1.125f, -2.513f, -2.511f, -2.513f)
            close()
        }
        path(fill = SolidColor(Color.Gray)) {
            moveToRelative(15.98f, 3.404f)
            lineToRelative(-1.419f, 0f)
            lineToRelative(-1.419f, 0f)
            curveToRelative(-0.946f, 0f, -1.713f, 0.767f, -1.713f, 1.714f)
            curveToRelative(0f, 0.945f, 0.766f, 1.713f, 1.713f, 1.713f)
            lineToRelative(1.419f, 0f)
            lineToRelative(1.419f, 0f)
            curveToRelative(0.946f, 0f, 1.713f, -0.767f, 1.713f, -1.713f)
            curveToRelative(-0.001f, -0.947f, -0.767f, -1.714f, -1.713f, -1.714f)
            close()
        }
        path(fill = SolidColor(Color.DarkGray)) {
            moveToRelative(15.959f, 4.135f)
            curveToRelative(0.21f, 0f, 2.604f, -3.041f, 2.604f, -3.041f)
            curveToRelative(0.227f, -0.304f, 0.163f, -0.733f, -0.141f, -0.958f)
            curveToRelative(-0.304f, -0.226f, -0.732f, -0.163f, -0.958f, 0.141f)
            curveToRelative(0.001f, 0f, -1.645f, 3.859f, -1.505f, 3.859f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(15.705f, 4.135f)
            curveToRelative(0f, 0.536f, 0.433f, 0.972f, 0.971f, 0.972f)
            curveToRelative(0.535f, 0f, 0.972f, -0.436f, 0.972f, -0.972f)
            curveToRelative(0f, -0.536f, -0.436f, -0.971f, -0.972f, -0.971f)
            curveToRelative(-0.538f, 0.001f, -0.971f, 0.435f, -0.971f, 0.971f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(14.618f, 11.854f)
            curveToRelative(-0.019f, 0f, -0.038f, 0.003f, -0.057f, 0.004f)
            curveToRelative(-0.019f, -0.001f, -0.038f, -0.004f, -0.057f, -0.004f)
            curveToRelative(-1.697f, 0f, -3.072f, 1.202f, -3.072f, 2.684f)
            curveToRelative(0f, 1.482f, 1.375f, 2.684f, 3.072f, 2.684f)
            curveToRelative(0.019f, 0f, 0.038f, -0.002f, 0.057f, -0.002f)
            curveToRelative(0.019f, 0f, 0.038f, 0.002f, 0.057f, 0.002f)
            curveToRelative(1.698f, 0f, 3.072f, -1.202f, 3.072f, -2.684f)
            curveToRelative(0f, -1.482f, -1.373f, -2.684f, -3.072f, -2.684f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(17.734f, 19.62f)
            curveToRelative(0f, 1.039f, 0.964f, 1.881f, 2.152f, 1.881f)
            curveToRelative(1.19f, 0f, 2.155f, -0.843f, 2.155f, -1.881f)
            curveToRelative(0f, -1.039f, -0.966f, -1.881f, -2.155f, -1.881f)
            curveToRelative(-1.188f, 0f, -2.152f, 0.842f, -2.152f, 1.881f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(15.172f, 26.351f)
            curveToRelative(0f, 1.039f, 0.964f, 1.88f, 2.154f, 1.88f)
            curveToRelative(1.189f, 0f, 2.154f, -0.841f, 2.154f, -1.88f)
            curveToRelative(0f, -1.039f, -0.966f, -1.881f, -2.154f, -1.881f)
            curveToRelative(-1.189f, -0.001f, -2.154f, 0.842f, -2.154f, 1.881f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(13.416f, 4.135f)
            curveToRelative(0f, 0.536f, -0.433f, 0.972f, -0.971f, 0.972f)
            curveToRelative(-0.535f, 0f, -0.97f, -0.436f, -0.97f, -0.972f)
            curveToRelative(0f, -0.536f, 0.435f, -0.971f, 0.97f, -0.971f)
            curveToRelative(0.538f, 0.001f, 0.971f, 0.435f, 0.971f, 0.971f)
            close()
        }
    }.build()
}