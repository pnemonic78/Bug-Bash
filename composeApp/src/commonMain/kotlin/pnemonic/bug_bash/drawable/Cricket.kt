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
import pnemonic.bug_bash.model.bug.Cricket
import pnemonic.stateOf

private const val durationLeg = 500

@Composable
fun cricket(bug: Cricket): ImageVector = cricket(bug.isStopped)

@Composable
fun cricket(stopped: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val crawlL3: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val crawlR3: State<Float>

    if (stopped) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateR1 = stateOf(0f)
        rotateR2 = rotateR1
        crawlL3 = stateOf(1f)
        crawlR3 = crawlL3
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
            initialValue = -10f,
            targetValue = 30f,
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
            initialValue = -30f,
            targetValue = 10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        crawlL3 = transition.animateFloat(
            initialValue = 1f,
            targetValue = 0.75f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
        crawlR3 = crawlL3
    }

    return ImageVector.Builder(
        name = "Cricket",
        defaultWidth = 30.dp,
        defaultHeight = 34.15.dp,
        viewportWidth = 30f,
        viewportHeight = 34.15f
    ).apply {
        group("leg-l1", rotate = rotateL1.value, pivotX = 13.627f, 13.134f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(13.627f, 13.134f)
                curveToRelative(-0.365f, -0.01f, -0.58f, -0.347f, -0.856f, -0.535f)
                curveToRelative(-1.108f, -0.925f, -2.227f, -1.838f, -3.328f, -2.771f)
                curveToRelative(-0.302f, -0.324f, -0.071f, -0.945f, 0.379f, -0.971f)
                curveToRelative(0.359f, -0.038f, 0.602f, 0.276f, 0.856f, 0.475f)
                curveToRelative(1.133f, 0.944f, 2.275f, 1.878f, 3.4f, 2.831f)
                curveToRelative(0.299f, 0.323f, 0.073f, 0.942f, -0.377f, 0.966f)
                lineToRelative(-0.037f, 0.003f)
                curveToRelative(-0.017f, 0f, -0.037f, 0.002f, -0.037f, 0.001f)
                close()
            }
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(9.579f, 9.387f)
                curveToRelative(-0.095f, 0f, -0.189f, -0.046f, -0.245f, -0.13f)
                lineToRelative(-2.637f, -3.927f)
                lineToRelative(-1.733f, 0f)
                curveToRelative(-0.162f, 0f, -0.294f, -0.132f, -0.294f, -0.294f)
                curveToRelative(0f, -0.163f, 0.131f, -0.294f, 0.294f, -0.294f)
                lineToRelative(1.89f, 0f)
                curveToRelative(0.098f, 0f, 0.19f, 0.049f, 0.244f, 0.13f)
                lineToRelative(2.724f, 4.057f)
                curveToRelative(0.091f, 0.135f, 0.054f, 0.317f, -0.08f, 0.409f)
                curveToRelative(-0.05f, 0.034f, -0.107f, 0.05f, -0.163f, 0.05f)
                close()
            }
        }
        group("leg-l2", rotate = rotateL2.value, pivotX = 13.674f, 15.739f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(8.708f, 20.59f)
                curveToRelative(-0.095f, -0f, -0.189f, 0.046f, -0.245f, 0.13f)
                lineToRelative(-2.637f, 3.927f)
                lineToRelative(-1.733f, -0f)
                curveToRelative(-0.162f, -0f, -0.294f, 0.132f, -0.294f, 0.294f)
                curveToRelative(0f, 0.163f, 0.131f, 0.294f, 0.294f, 0.294f)
                lineToRelative(1.89f, -0f)
                curveToRelative(0.098f, -0f, 0.19f, -0.049f, 0.244f, -0.13f)
                lineToRelative(2.724f, -4.057f)
                curveToRelative(0.091f, -0.135f, 0.054f, -0.317f, -0.08f, -0.409f)
                curveToRelative(-0.05f, -0.034f, -0.107f, -0.05f, -0.163f, -0.05f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5F9653))) {
                moveToRelative(8.829f, 21.333f)
                curveToRelative(-0.484f, 0.019f, -0.869f, -0.516f, -0.702f, -0.969f)
                curveToRelative(0.291f, -0.618f, 0.615f, -1.222f, 0.919f, -1.834f)
                curveToRelative(0.59f, -1.163f, 1.176f, -2.329f, 1.769f, -3.491f)
                curveToRelative(0.158f, -0.289f, 0.5f, -0.387f, 0.809f, -0.359f)
                curveToRelative(0.499f, 0.005f, 0.998f, -0.011f, 1.496f, 0.009f)
                curveToRelative(0.475f, 0.055f, 0.778f, 0.628f, 0.554f, 1.051f)
                curveToRelative(-0.138f, 0.306f, -0.485f, 0.453f, -0.806f, 0.418f)
                curveToRelative(-0.321f, 0f, -0.643f, 0f, -0.964f, 0f)
                curveToRelative(-0.814f, 1.605f, -1.624f, 3.213f, -2.44f, 4.816f)
                curveToRelative(-0.129f, 0.221f, -0.379f, 0.361f, -0.634f, 0.359f)
                close()
            }
        }
        group("leg-l3", scaleY = crawlL3.value, pivotX = 11.981f, pivotY = 20.310f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(13.015f, 30.431f)
                curveToRelative(0f, 0.571f, -0.463f, 1.035f, -1.035f, 1.035f)
                lineToRelative(0f, 0f)
                curveToRelative(-0.571f, 0f, -1.034f, -0.463f, -1.034f, -1.035f)
                lineToRelative(0f, -9.087f)
                curveToRelative(0f, -0.571f, 0.463f, -1.035f, 1.034f, -1.035f)
                lineToRelative(0f, 0f)
                curveToRelative(0.572f, 0f, 1.035f, 0.463f, 1.035f, 1.035f)
                close()
            }
        }
        group("leg-r3", scaleY = crawlR3.value, pivotX = 17.876f, pivotY = 20.310f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(16.841f, 30.431f)
                curveToRelative(0f, 0.571f, 0.463f, 1.035f, 1.035f, 1.035f)
                lineToRelative(0f, 0f)
                curveToRelative(0.571f, 0f, 1.034f, -0.463f, 1.034f, -1.035f)
                lineToRelative(0f, -9.087f)
                curveToRelative(0f, -0.571f, -0.463f, -1.035f, -1.034f, -1.035f)
                lineToRelative(0f, 0f)
                curveToRelative(-0.572f, 0f, -1.035f, 0.463f, -1.035f, 1.035f)
                close()
            }
        }
        group("leg-r1", rotate = rotateR1.value, pivotX = 16.229f, 13.134f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(16.229f, 13.134f)
                curveToRelative(0.436f, -0.04f, 0.681f, -0.451f, 1.021f, -0.672f)
                curveToRelative(1.054f, -0.878f, 2.116f, -1.746f, 3.162f, -2.633f)
                curveToRelative(0.342f, -0.352f, 0.001f, -1.048f, -0.491f, -0.973f)
                curveToRelative(-0.416f, 0.072f, -0.659f, 0.456f, -0.988f, 0.679f)
                curveToRelative(-1.053f, 0.875f, -2.112f, 1.744f, -3.156f, 2.628f)
                curveToRelative(-0.323f, 0.347f, -0.032f, 1.009f, 0.452f, 0.971f)
                close()
            }
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(20.278f, 9.387f)
                curveToRelative(0.095f, 0f, 0.188f, -0.046f, 0.245f, -0.13f)
                lineToRelative(2.637f, -3.927f)
                lineToRelative(1.732f, 0f)
                curveToRelative(0.163f, 0f, 0.294f, -0.132f, 0.294f, -0.294f)
                curveToRelative(0f, -0.163f, -0.131f, -0.294f, -0.294f, -0.294f)
                lineToRelative(-1.89f, 0f)
                curveToRelative(-0.098f, 0f, -0.19f, 0.049f, -0.244f, 0.13f)
                lineToRelative(-2.724f, 4.057f)
                curveToRelative(-0.091f, 0.135f, -0.054f, 0.317f, 0.08f, 0.409f)
                curveToRelative(0.05f, 0.034f, 0.107f, 0.05f, 0.163f, 0.05f)
                close()
            }
        }
        group("leg-r2", rotate = rotateR2.value, pivotX = 16.183f, 15.739f) {
            path(fill = SolidColor(Color(0xFF64A74A))) {
                moveToRelative(21.292f, 20.59f)
                curveToRelative(0.095f, 0f, 0.188f, 0.046f, 0.245f, 0.13f)
                lineToRelative(2.637f, 3.927f)
                lineToRelative(1.732f, 0f)
                curveToRelative(0.163f, 0f, 0.294f, 0.132f, 0.294f, 0.294f)
                curveToRelative(0f, 0.163f, -0.131f, 0.294f, -0.294f, 0.294f)
                lineToRelative(-1.89f, 0f)
                curveToRelative(-0.098f, 0f, -0.19f, -0.049f, -0.244f, -0.13f)
                lineToRelative(-2.724f, -4.057f)
                curveToRelative(-0.091f, -0.135f, -0.054f, -0.317f, 0.08f, -0.409f)
                curveToRelative(0.05f, -0.034f, 0.107f, -0.05f, 0.163f, -0.05f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5F9653))) {
                moveToRelative(21.028f, 21.333f)
                curveToRelative(0.484f, 0.019f, 0.869f, -0.516f, 0.702f, -0.969f)
                curveToRelative(-0.291f, -0.618f, -0.615f, -1.222f, -0.919f, -1.834f)
                curveToRelative(-0.59f, -1.163f, -1.176f, -2.329f, -1.769f, -3.491f)
                curveToRelative(-0.158f, -0.289f, -0.5f, -0.387f, -0.809f, -0.359f)
                curveToRelative(-0.499f, 0.005f, -0.998f, -0.011f, -1.496f, 0.009f)
                curveToRelative(-0.475f, 0.055f, -0.778f, 0.628f, -0.554f, 1.051f)
                curveToRelative(0.138f, 0.306f, 0.485f, 0.453f, 0.806f, 0.418f)
                curveToRelative(0.321f, 0f, 0.643f, 0f, 0.964f, 0f)
                curveToRelative(0.814f, 1.605f, 1.624f, 3.213f, 2.44f, 4.816f)
                curveToRelative(0.129f, 0.221f, 0.379f, 0.361f, 0.634f, 0.359f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF528248))) {
            moveToRelative(15.757f, 7.331f)
            curveToRelative(0.255f, 0.005f, 0.31f, -0.264f, 0.311f, -0.465f)
            curveToRelative(0.072f, -0.763f, 0.143f, -1.526f, 0.215f, -2.288f)
            curveToRelative(1.451f, -1.356f, 2.902f, -2.712f, 4.352f, -4.068f)
            curveToRelative(0.313f, -0.275f, -0.199f, -0.728f, -0.441f, -0.393f)
            curveToRelative(-1.465f, 1.369f, -2.93f, 2.738f, -4.395f, 4.107f)
            curveToRelative(-0.144f, 0.17f, -0.094f, 0.412f, -0.133f, 0.619f)
            curveToRelative(-0.066f, 0.742f, -0.148f, 1.483f, -0.203f, 2.225f)
            curveToRelative(0.013f, 0.146f, 0.147f, 0.265f, 0.293f, 0.262f)
            close()
        }
        path(fill = SolidColor(Color(0xFF528248))) {
            moveToRelative(14.1f, 7.331f)
            curveToRelative(-0.255f, 0.006f, -0.31f, -0.264f, -0.311f, -0.465f)
            curveToRelative(-0.072f, -0.763f, -0.143f, -1.526f, -0.215f, -2.288f)
            curveToRelative(-1.451f, -1.356f, -2.902f, -2.712f, -4.352f, -4.068f)
            curveToRelative(-0.313f, -0.275f, 0.199f, -0.728f, 0.441f, -0.393f)
            curveToRelative(1.465f, 1.369f, 2.93f, 2.738f, 4.395f, 4.107f)
            curveToRelative(0.144f, 0.17f, 0.094f, 0.412f, 0.133f, 0.619f)
            curveToRelative(0.066f, 0.742f, 0.148f, 1.483f, 0.203f, 2.225f)
            curveToRelative(-0.013f, 0.146f, -0.147f, 0.265f, -0.293f, 0.262f)
            close()
        }
        path(fill = SolidColor(Color(0xFF64A74A))) {
            moveToRelative(14.417f, 6.661f)
            curveToRelative(-0.52f, 0.007f, -1.048f, 0.085f, -1.42f, 0.48f)
            curveToRelative(-0.677f, 0.655f, -0.684f, 1.891f, 0.075f, 2.486f)
            curveToRelative(0.378f, 0.32f, 0.893f, 0.476f, 1.385f, 0.411f)
            curveToRelative(0.269f, 0.094f, 0.411f, -0.034f, 0.471f, -0.226f)
            curveToRelative(-0.072f, -0.833f, -0.117f, 0.307f, 0.471f, 0.226f)
            curveToRelative(0.492f, 0.065f, 1.007f, -0.09f, 1.385f, -0.411f)
            curveToRelative(0.759f, -0.595f, 0.753f, -1.832f, 0.076f, -2.486f)
            curveToRelative(-0.496f, -0.526f, -1.269f, -0.489f, -1.932f, -0.473f)
            curveToRelative(-0.166f, -0.004f, -0.338f, -0.01f, -0.512f, -0.007f)
            close()
        }
        path(fill = SolidColor(Color(0xFF8DC375))) {
            moveToRelative(14.929f, 5.928f)
            lineToRelative(-0.175f, 0f)
            curveToRelative(-0.409f, 0f, -0.74f, 0.331f, -0.74f, 0.74f)
            curveToRelative(0f, 0.409f, 0.331f, 0.74f, 0.74f, 0.74f)
            lineToRelative(0.175f, 0f)
            close()
            moveTo(14.929f, 5.928f)
            lineToRelative(0.175f, 0f)
            curveToRelative(0.409f, 0f, 0.74f, 0.331f, 0.74f, 0.74f)
            curveToRelative(0f, 0.409f, -0.331f, 0.74f, -0.74f, 0.74f)
            lineToRelative(-0.175f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFF455556))) {
            moveToRelative(15.6f, 6.528f)
            curveToRelative(-0.266f, 0.297f, -0.277f, 0.78f, -0.027f, 1.09f)
            curveToRelative(0.299f, 0.294f, 0.624f, 0.564f, 0.949f, 0.83f)
            curveToRelative(0.328f, 0.238f, 0.821f, 0.194f, 1.101f, -0.098f)
            curveToRelative(0.288f, -0.277f, 0.335f, -0.758f, 0.109f, -1.087f)
            curveToRelative(-0.294f, -0.326f, -0.646f, -0.603f, -0.986f, -0.882f)
            curveToRelative(-0.328f, -0.237f, -0.82f, -0.194f, -1.101f, 0.099f)
            curveToRelative(-0.016f, 0.016f, -0.031f, 0.032f, -0.045f, 0.049f)
            close()
        }
        path(fill = SolidColor(Color(0xFF455556))) {
            moveToRelative(14.257f, 6.528f)
            curveToRelative(0.266f, 0.297f, 0.277f, 0.78f, 0.027f, 1.09f)
            curveToRelative(-0.299f, 0.294f, -0.624f, 0.564f, -0.949f, 0.83f)
            curveToRelative(-0.328f, 0.238f, -0.821f, 0.194f, -1.101f, -0.098f)
            curveToRelative(-0.288f, -0.277f, -0.335f, -0.758f, -0.109f, -1.087f)
            curveToRelative(0.294f, -0.326f, 0.646f, -0.604f, 0.986f, -0.882f)
            curveToRelative(0.328f, -0.237f, 0.821f, -0.194f, 1.101f, 0.099f)
            curveToRelative(0.016f, 0.016f, 0.031f, 0.032f, 0.045f, 0.049f)
            close()
        }
        path(fill = SolidColor(Color(0xFF64B044))) {
            moveToRelative(14.929f, 9.097f)
            curveToRelative(0.932f, 0.044f, 1.676f, 0.811f, 1.676f, 1.754f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.943f, -0.744f, 1.711f, -1.676f, 1.754f)
            close()
            moveTo(14.929f, 9.097f)
            curveToRelative(-0.932f, 0.044f, -1.676f, 0.811f, -1.676f, 1.754f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.943f, 0.744f, 1.711f, 1.676f, 1.754f)
            close()
        }
        path(fill = SolidColor(Color(0xFF64A74A))) {
            moveToRelative(14.929f, 12.076f)
            curveToRelative(1.028f, 0.044f, 1.849f, 0.889f, 1.849f, 1.928f)
            lineToRelative(0f, 2.123f)
            curveToRelative(0f, 1.039f, -0.821f, 1.885f, -1.849f, 1.928f)
            close()
            moveTo(14.929f, 12.076f)
            curveToRelative(-1.028f, 0.044f, -1.849f, 0.889f, -1.849f, 1.928f)
            lineToRelative(0f, 2.123f)
            curveToRelative(0f, 1.039f, 0.821f, 1.885f, 1.849f, 1.928f)
            close()
        }
        path(fill = SolidColor(Color(0xFF528248))) {
            moveToRelative(14.929f, 13.513f)
            curveToRelative(-1.214f, 0.044f, -2.186f, 1.039f, -2.186f, 2.264f)
            lineToRelative(-0.762f, 2.804f)
            curveToRelative(0f, 1.225f, 1.701f, 14.988f, 2.948f, 15.586f)
            lineToRelative(0f, -20.654f)
            close()
            moveTo(14.929f, 13.513f)
            curveToRelative(1.214f, 0.044f, 2.186f, 1.039f, 2.186f, 2.264f)
            lineToRelative(0.762f, 2.804f)
            curveToRelative(0f, 1.225f, -1.701f, 14.988f, -2.948f, 15.586f)
            lineToRelative(0f, -20.654f)
            close()
        }
        path(fill = SolidColor(Color(0xFF64A74A))) {
            moveToRelative(14.929f, 15.831f)
            curveToRelative(0.932f, 0.044f, 1.676f, 0.811f, 1.676f, 1.754f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.943f, -0.677f, 8.405f, -1.61f, 8.828f)
            close()
        }
        path(fill = SolidColor(Color(0xFF64A74A))) {
            moveToRelative(14.929f, 15.831f)
            curveToRelative(-0.932f, 0.044f, -1.676f, 0.811f, -1.676f, 1.754f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.943f, 0.647f, 8.35f, 1.58f, 8.773f)
            close()
        }
        path(fill = SolidColor(Color(0xFF5F9653))) {
            moveToRelative(14.929f, 15.857f)
            curveToRelative(0.49f, 0.151f, 0.862f, 0.866f, 0.862f, 1.728f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.862f, -0.372f, 7.139f, -0.862f, 8.544f)
            close()
            moveTo(14.929f, 15.857f)
            curveToRelative(-0.49f, 0.151f, -0.862f, 0.866f, -0.862f, 1.728f)
            lineToRelative(0f, 5.449f)
            curveToRelative(0f, 0.862f, 0.372f, 7.139f, 0.862f, 8.544f)
            close()
        }
    }.build()
}