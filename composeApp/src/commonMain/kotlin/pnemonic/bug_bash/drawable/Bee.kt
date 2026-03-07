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
import pnemonic.bug_bash.model.bug.Bee
import pnemonic.stateOf

private const val durationWing = 300

@Composable
fun bee(bug: Bee): ImageVector = bee(bug.isStopped)

@Composable
fun bee(stopped: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateR1: State<Float>

    if (stopped) {
        rotateL1 = stateOf(0f)
        rotateR1 = stateOf(0f)
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 15f,
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
        name = "Bee",
        defaultWidth = 44.31.dp,
        defaultHeight = 29.dp,
        viewportWidth = 44.31f,
        viewportHeight = 29f
    ).apply {
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(21.892f, 5.103f)
            curveToRelative(0f, 0.124f, -0.051f, 0.248f, -0.158f, 0.333f)
            curveToRelative(-0.09f, 0.072f, -0.2f, 0.102f, -0.307f, 0.09f)
            curveToRelative(-0.106f, -0.009f, -0.213f, -0.06f, -0.29f, -0.154f)
            lineToRelative(-0.231f, -0.286f)
            lineToRelative(-2.261f, -2.786f)
            lineToRelative(-1.963f, -1.233f)
            curveToRelative(-0.201f, -0.128f, -0.261f, -0.388f, -0.137f, -0.589f)
            curveToRelative(0.129f, -0.2f, 0.388f, -0.26f, 0.589f, -0.136f)
            lineToRelative(2.027f, 1.276f)
            curveToRelative(0.038f, 0.026f, 0.073f, 0.055f, 0.102f, 0.094f)
            lineToRelative(2.535f, 3.124f)
            curveToRelative(0.013f, 0.017f, 0.026f, 0.034f, 0.038f, 0.051f)
            curveToRelative(0.039f, 0.067f, 0.055f, 0.143f, 0.055f, 0.216f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(18.795f, 17.443f)
            curveToRelative(-0.021f, 0.068f, -0.052f, 0.136f, -0.09f, 0.196f)
            curveToRelative(-0.213f, 0.367f, -0.656f, 0.55f, -1.083f, 0.423f)
            lineToRelative(-0.546f, -0.17f)
            lineToRelative(-0.798f, -0.248f)
            lineToRelative(-0.661f, 1.762f)
            lineToRelative(-0.951f, 2.543f)
            curveToRelative(-0.141f, 0.376f, -0.5f, 0.611f, -0.879f, 0.611f)
            curveToRelative(-0.026f, 0f, -0.047f, 0f, -0.072f, -0.009f)
            curveToRelative(-0.085f, 0f, -0.17f, -0.021f, -0.256f, -0.052f)
            curveToRelative(-0.213f, -0.077f, -0.38f, -0.226f, -0.477f, -0.41f)
            curveToRelative(-0.141f, -0.234f, -0.175f, -0.524f, -0.073f, -0.798f)
            lineToRelative(0.849f, -2.262f)
            lineToRelative(1.075f, -2.871f)
            curveToRelative(0.175f, -0.465f, 0.678f, -0.713f, 1.157f, -0.567f)
            lineToRelative(1.229f, 0.379f)
            lineToRelative(0.585f, 0.184f)
            lineToRelative(0.376f, 0.115f)
            curveToRelative(0.493f, 0.153f, 0.77f, 0.678f, 0.617f, 1.173f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(14.818f, 6.357f)
            curveToRelative(-0.034f, 0.222f, -0.158f, 0.427f, -0.354f, 0.567f)
            curveToRelative(-0.149f, 0.107f, -0.32f, 0.158f, -0.491f, 0.158f)
            curveToRelative(-0.106f, 0f, -0.213f, -0.021f, -0.311f, -0.059f)
            curveToRelative(-0.154f, -0.059f, -0.29f, -0.163f, -0.388f, -0.303f)
            lineToRelative(-1.911f, -2.701f)
            curveToRelative(-0.141f, -0.2f, -0.184f, -0.44f, -0.137f, -0.661f)
            curveToRelative(0.038f, -0.205f, 0.158f, -0.396f, 0.341f, -0.529f)
            curveToRelative(0.116f, -0.08f, 0.243f, -0.132f, 0.371f, -0.149f)
            curveToRelative(0.307f, -0.043f, 0.628f, 0.085f, 0.815f, 0.354f)
            lineToRelative(1.916f, 2.701f)
            curveToRelative(0.132f, 0.187f, 0.18f, 0.409f, 0.149f, 0.622f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(18.748f, 11.93f)
            curveToRelative(-0.12f, 0.486f, -0.555f, 0.815f, -1.036f, 0.815f)
            curveToRelative(-0.081f, 0f, -0.167f, -0.013f, -0.252f, -0.034f)
            lineToRelative(-1.076f, -0.261f)
            lineToRelative(-1.698f, -0.413f)
            curveToRelative(-0.448f, -0.107f, -0.773f, -0.491f, -0.81f, -0.952f)
            lineToRelative(-0.286f, -3.592f)
            curveToRelative(0f, -0.017f, 0f, -0.034f, -0.004f, -0.055f)
            curveToRelative(0f, -0.145f, 0.026f, -0.286f, 0.077f, -0.414f)
            curveToRelative(0.141f, -0.367f, 0.486f, -0.644f, 0.908f, -0.678f)
            curveToRelative(0.085f, -0.004f, 0.167f, 0f, 0.248f, 0.013f)
            curveToRelative(0.477f, 0.077f, 0.857f, 0.465f, 0.9f, 0.968f)
            lineToRelative(0.021f, 0.278f)
            lineToRelative(0.2f, 2.543f)
            lineToRelative(0.278f, 0.068f)
            lineToRelative(1.745f, 0.427f)
            curveToRelative(0.576f, 0.135f, 0.927f, 0.716f, 0.785f, 1.288f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(12.015f, 3.064f)
            curveToRelative(0.047f, 0.234f, -0.107f, 0.457f, -0.337f, 0.503f)
            curveToRelative(-0.026f, 0.004f, -0.055f, 0.009f, -0.081f, 0.009f)
            curveToRelative(-0.153f, 0f, -0.299f, -0.085f, -0.371f, -0.217f)
            curveToRelative(-0.021f, -0.038f, -0.038f, -0.077f, -0.047f, -0.124f)
            lineToRelative(-0.546f, -2.714f)
            curveToRelative(-0.043f, -0.234f, 0.107f, -0.457f, 0.337f, -0.503f)
            curveToRelative(0.231f, -0.047f, 0.456f, 0.102f, 0.503f, 0.332f)
            lineToRelative(0.465f, 2.33f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(17.677f, 5.141f)
            curveToRelative(-0.051f, 0.124f, -0.136f, 0.234f, -0.252f, 0.32f)
            curveToRelative(-0.144f, 0.107f, -0.315f, 0.158f, -0.477f, 0.158f)
            curveToRelative(-0.034f, 0f, -0.069f, 0f, -0.102f, -0.004f)
            curveToRelative(-0.209f, -0.03f, -0.41f, -0.136f, -0.546f, -0.32f)
            lineToRelative(-1.314f, -1.766f)
            curveToRelative(-0.209f, -0.281f, -0.205f, -0.657f, -0.017f, -0.93f)
            curveToRelative(0.047f, -0.073f, 0.111f, -0.136f, 0.184f, -0.192f)
            curveToRelative(0.106f, -0.076f, 0.226f, -0.128f, 0.35f, -0.149f)
            curveToRelative(0.286f, -0.047f, 0.589f, 0.064f, 0.776f, 0.316f)
            lineToRelative(1.31f, 1.762f)
            curveToRelative(0.178f, 0.242f, 0.204f, 0.55f, 0.089f, 0.806f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(19.068f, 9.037f)
            curveToRelative(-0.111f, 0.055f, -0.231f, 0.081f, -0.345f, 0.081f)
            curveToRelative(-0.303f, 0f, -0.589f, -0.17f, -0.726f, -0.456f)
            lineToRelative(-0.456f, -0.952f)
            lineToRelative(-0.043f, -0.09f)
            lineToRelative(-0.64f, -1.336f)
            curveToRelative(-0.107f, -0.217f, -0.103f, -0.46f, -0.013f, -0.67f)
            curveToRelative(0.072f, -0.17f, 0.209f, -0.316f, 0.388f, -0.401f)
            curveToRelative(0.144f, -0.068f, 0.299f, -0.09f, 0.443f, -0.072f)
            curveToRelative(0.264f, 0.03f, 0.508f, 0.188f, 0.631f, 0.448f)
            lineToRelative(0.58f, 1.212f)
            lineToRelative(0.465f, 0.972f)
            lineToRelative(0.09f, 0.192f)
            curveToRelative(0.191f, 0.402f, 0.025f, 0.88f, -0.376f, 1.071f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(15.501f, 2.257f)
            curveToRelative(-0.009f, 0.128f, -0.081f, 0.243f, -0.201f, 0.316f)
            curveToRelative(-0.059f, 0.035f, -0.128f, 0.052f, -0.196f, 0.052f)
            curveToRelative(-0.046f, 0f, -0.094f, -0.009f, -0.136f, -0.026f)
            curveToRelative(-0.09f, -0.035f, -0.167f, -0.094f, -0.213f, -0.183f)
            lineToRelative(-0.977f, -1.737f)
            curveToRelative(-0.107f, -0.197f, -0.039f, -0.44f, 0.153f, -0.55f)
            curveToRelative(0.192f, -0.107f, 0.439f, -0.038f, 0.546f, 0.154f)
            lineToRelative(0.977f, 1.741f)
            curveToRelative(0.043f, 0.076f, 0.06f, 0.157f, 0.047f, 0.234f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(14.046f, 28.306f)
            curveToRelative(-0.064f, 0.175f, -0.226f, 0.281f, -0.402f, 0.281f)
            curveToRelative(-0.046f, 0f, -0.098f, -0.009f, -0.144f, -0.026f)
            lineToRelative(-0.785f, -0.286f)
            curveToRelative(-0.137f, -0.047f, -0.239f, -0.163f, -0.269f, -0.303f)
            lineToRelative(-0.474f, -1.988f)
            curveToRelative(-0.017f, -0.068f, -0.017f, -0.141f, 0f, -0.209f)
            lineToRelative(0.947f, -3.554f)
            curveToRelative(0.013f, -0.047f, 0.034f, -0.094f, 0.06f, -0.133f)
            curveToRelative(0.098f, -0.145f, 0.281f, -0.222f, 0.461f, -0.17f)
            curveToRelative(0.23f, 0.059f, 0.362f, 0.294f, 0.303f, 0.521f)
            lineToRelative(-0.03f, 0.111f)
            lineToRelative(-0.888f, 3.341f)
            lineToRelative(0.396f, 1.664f)
            lineToRelative(0.567f, 0.205f)
            curveToRelative(0.223f, 0.081f, 0.338f, 0.324f, 0.258f, 0.546f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(21.892f, 5.103f)
            curveToRelative(0f, 0.124f, -0.051f, 0.248f, -0.158f, 0.333f)
            curveToRelative(-0.09f, 0.072f, -0.2f, 0.102f, -0.307f, 0.09f)
            curveToRelative(-0.106f, -0.009f, -0.213f, -0.06f, -0.29f, -0.154f)
            lineToRelative(-0.231f, -0.286f)
            lineToRelative(-2.261f, -2.786f)
            lineToRelative(-1.963f, -1.233f)
            curveToRelative(-0.201f, -0.128f, -0.261f, -0.388f, -0.137f, -0.589f)
            curveToRelative(0.129f, -0.2f, 0.388f, -0.26f, 0.589f, -0.136f)
            lineToRelative(2.027f, 1.276f)
            curveToRelative(0.038f, 0.026f, 0.073f, 0.055f, 0.102f, 0.094f)
            lineToRelative(2.535f, 3.124f)
            curveToRelative(0.013f, 0.017f, 0.026f, 0.034f, 0.038f, 0.051f)
            curveToRelative(0.039f, 0.067f, 0.055f, 0.143f, 0.055f, 0.216f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(30.492f, 22.55f)
            curveToRelative(0.11f, 0f, 0.221f, -0.019f, 0.329f, -0.06f)
            curveToRelative(0.485f, -0.182f, 0.732f, -0.722f, 0.549f, -1.208f)
            lineToRelative(-1.923f, -5.131f)
            curveToRelative(-0.174f, -0.465f, -0.679f, -0.714f, -1.155f, -0.567f)
            lineToRelative(-2.188f, 0.676f)
            curveToRelative(-0.494f, 0.153f, -0.772f, 0.678f, -0.619f, 1.173f)
            curveToRelative(0.153f, 0.496f, 0.678f, 0.77f, 1.174f, 0.619f)
            lineToRelative(1.343f, -0.415f)
            lineToRelative(1.612f, 4.303f)
            curveToRelative(0.141f, 0.377f, 0.499f, 0.61f, 0.878f, 0.61f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(30.306f, 7.073f)
            curveToRelative(0.267f, 0f, 0.531f, -0.125f, 0.697f, -0.361f)
            lineToRelative(1.913f, -2.701f)
            curveToRelative(0.273f, -0.385f, 0.182f, -0.917f, -0.203f, -1.189f)
            curveToRelative(-0.384f, -0.273f, -0.917f, -0.182f, -1.189f, 0.204f)
            lineToRelative(-1.913f, 2.702f)
            curveToRelative(-0.273f, 0.384f, -0.182f, 0.917f, 0.203f, 1.189f)
            curveToRelative(0.15f, 0.106f, 0.321f, 0.157f, 0.492f, 0.157f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(26.565f, 12.736f)
            curveToRelative(0.084f, 0f, 0.168f, -0.011f, 0.254f, -0.031f)
            lineToRelative(2.773f, -0.676f)
            curveToRelative(0.448f, -0.109f, 0.775f, -0.493f, 0.81f, -0.952f)
            lineToRelative(0.285f, -3.591f)
            curveToRelative(0.046f, -0.588f, -0.392f, -1.101f, -0.979f, -1.148f)
            curveToRelative(-0.586f, -0.042f, -1.101f, 0.392f, -1.147f, 0.979f)
            lineToRelative(-0.224f, 2.822f)
            lineToRelative(-2.024f, 0.493f)
            curveToRelative(-0.572f, 0.139f, -0.923f, 0.717f, -0.784f, 1.289f)
            curveToRelative(0.119f, 0.488f, 0.555f, 0.815f, 1.036f, 0.815f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(32.684f, 3.567f)
            curveToRelative(0.199f, 0f, 0.377f, -0.14f, 0.418f, -0.342f)
            lineToRelative(0.543f, -2.714f)
            curveToRelative(0.047f, -0.231f, -0.103f, -0.456f, -0.334f, -0.502f)
            curveToRelative(-0.233f, -0.048f, -0.457f, 0.103f, -0.502f, 0.335f)
            lineToRelative(-0.543f, 2.714f)
            curveToRelative(-0.046f, 0.231f, 0.103f, 0.456f, 0.335f, 0.501f)
            curveToRelative(0.028f, 0.006f, 0.056f, 0.008f, 0.084f, 0.008f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(27.333f, 5.612f)
            curveToRelative(0.245f, 0f, 0.488f, -0.112f, 0.646f, -0.323f)
            lineToRelative(1.313f, -1.767f)
            curveToRelative(0.264f, -0.356f, 0.19f, -0.859f, -0.166f, -1.124f)
            curveToRelative(-0.356f, -0.264f, -0.859f, -0.19f, -1.124f, 0.166f)
            lineToRelative(-1.313f, 1.766f)
            curveToRelative(-0.264f, 0.357f, -0.19f, 0.859f, 0.165f, 1.125f)
            curveToRelative(0.144f, 0.105f, 0.313f, 0.158f, 0.479f, 0.158f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(25.558f, 9.108f)
            curveToRelative(0.299f, 0f, 0.586f, -0.168f, 0.725f, -0.456f)
            lineToRelative(1.138f, -2.377f)
            curveToRelative(0.191f, -0.401f, 0.022f, -0.88f, -0.378f, -1.072f)
            curveToRelative(-0.4f, -0.192f, -0.879f, -0.022f, -1.072f, 0.378f)
            lineToRelative(-1.138f, 2.376f)
            curveToRelative(-0.192f, 0.401f, -0.023f, 0.88f, 0.377f, 1.072f)
            curveToRelative(0.112f, 0.053f, 0.23f, 0.078f, 0.347f, 0.078f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(29.173f, 2.614f)
            curveToRelative(0.141f, 0f, 0.277f, -0.074f, 0.351f, -0.206f)
            lineToRelative(0.977f, -1.74f)
            curveToRelative(0.108f, -0.193f, 0.04f, -0.438f, -0.153f, -0.547f)
            curveToRelative(-0.193f, -0.108f, -0.438f, -0.039f, -0.547f, 0.154f)
            lineToRelative(-0.978f, 1.741f)
            curveToRelative(-0.108f, 0.193f, -0.039f, 0.438f, 0.154f, 0.547f)
            curveToRelative(0.062f, 0.035f, 0.13f, 0.052f, 0.197f, 0.052f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(30.634f, 28.579f)
            curveToRelative(0.048f, 0f, 0.098f, -0.008f, 0.145f, -0.026f)
            lineToRelative(0.786f, -0.285f)
            curveToRelative(0.135f, -0.049f, 0.237f, -0.163f, 0.27f, -0.303f)
            lineToRelative(0.473f, -1.991f)
            curveToRelative(0.017f, -0.069f, 0.015f, -0.14f, -0.002f, -0.208f)
            lineToRelative(-0.946f, -3.555f)
            curveToRelative(-0.06f, -0.229f, -0.295f, -0.364f, -0.522f, -0.303f)
            curveToRelative(-0.228f, 0.061f, -0.363f, 0.295f, -0.303f, 0.522f)
            lineToRelative(0.918f, 3.451f)
            lineToRelative(-0.394f, 1.662f)
            lineToRelative(-0.569f, 0.207f)
            curveToRelative(-0.221f, 0.08f, -0.336f, 0.324f, -0.256f, 0.546f)
            curveToRelative(0.061f, 0.174f, 0.225f, 0.282f, 0.4f, 0.282f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(22.849f, 5.519f)
            curveToRelative(0.111f, -0.01f, 0.217f, -0.062f, 0.293f, -0.156f)
            lineToRelative(2.49f, -3.071f)
            lineToRelative(1.965f, -1.236f)
            curveToRelative(0.2f, -0.125f, 0.26f, -0.388f, 0.134f, -0.588f)
            curveToRelative(-0.125f, -0.199f, -0.388f, -0.259f, -0.588f, -0.134f)
            lineToRelative(-2.026f, 1.274f)
            curveToRelative(-0.039f, 0.025f, -0.075f, 0.056f, -0.104f, 0.093f)
            lineToRelative(-2.534f, 3.125f)
            curveToRelative(-0.149f, 0.183f, -0.121f, 0.452f, 0.062f, 0.6f)
            curveToRelative(0.09f, 0.072f, 0.2f, 0.102f, 0.307f, 0.092f)
            close()
        }
        path(fill = SolidColor(Color(0xFFFECE57))) {
            moveToRelative(27.311f, 18.932f)
            lineToRelative(0f, 1.681f)
            curveToRelative(0f, 0.661f, -0.127f, 1.289f, -0.359f, 1.864f)
            curveToRelative(-0.251f, 0.645f, -0.64f, 1.221f, -1.122f, 1.703f)
            curveToRelative(-0.914f, 0.917f, -2.176f, 1.48f, -3.571f, 1.48f)
            curveToRelative(-0.021f, 0f, -0.043f, 0f, -0.069f, -0.004f)
            lineToRelative(0f, 0.004f)
            curveToRelative(-0.017f, 0f, -0.034f, 0.005f, -0.051f, 0.005f)
            curveToRelative(-0.038f, 0f, -0.081f, 0.004f, -0.124f, 0.004f)
            curveToRelative(-0.043f, 0f, -0.081f, 0f, -0.124f, -0.004f)
            curveToRelative(-1.348f, -0.03f, -2.56f, -0.585f, -3.448f, -1.476f)
            curveToRelative(-0.482f, -0.483f, -0.871f, -1.059f, -1.122f, -1.703f)
            curveToRelative(-0.231f, -0.576f, -0.359f, -1.204f, -0.359f, -1.864f)
            lineToRelative(0f, -1.682f)
            curveToRelative(0f, -0.358f, 0.038f, -0.709f, 0.111f, -1.05f)
            curveToRelative(0.077f, -0.38f, 0.2f, -0.742f, 0.363f, -1.084f)
            curveToRelative(0.102f, -0.231f, 0.226f, -0.448f, 0.362f, -0.653f)
            curveToRelative(0.256f, -0.388f, 0.567f, -0.739f, 0.918f, -1.037f)
            curveToRelative(0.392f, -0.342f, 0.836f, -0.619f, 1.322f, -0.827f)
            curveToRelative(0.209f, -0.09f, 0.427f, -0.163f, 0.648f, -0.226f)
            curveToRelative(0.384f, -0.107f, 0.785f, -0.162f, 1.203f, -0.17f)
            curveToRelative(0.038f, -0.004f, 0.081f, -0.004f, 0.124f, -0.004f)
            curveToRelative(0.021f, 0f, 0.047f, 0f, 0.069f, 0.004f)
            lineToRelative(0f, -0.004f)
            curveToRelative(0.021f, 0f, 0.038f, 0f, 0.055f, -0.005f)
            curveToRelative(0.043f, 0f, 0.081f, -0.004f, 0.12f, -0.004f)
            curveToRelative(0.461f, 0f, 0.908f, 0.064f, 1.331f, 0.18f)
            curveToRelative(0.222f, 0.06f, 0.435f, 0.132f, 0.644f, 0.222f)
            curveToRelative(0.486f, 0.209f, 0.93f, 0.486f, 1.322f, 0.832f)
            curveToRelative(0.35f, 0.298f, 0.657f, 0.644f, 0.914f, 1.033f)
            curveToRelative(0.141f, 0.205f, 0.26f, 0.427f, 0.367f, 0.653f)
            curveToRelative(0f, 0.004f, 0f, 0.004f, 0f, 0.004f)
            curveToRelative(0.163f, 0.342f, 0.286f, 0.704f, 0.363f, 1.084f)
            curveToRelative(0.072f, 0.337f, 0.11f, 0.687f, 0.11f, 1.045f)
            close()
        }
        path(fill = SolidColor(Color.Black)) {
            moveToRelative(24.145f, 6.404f)
            curveToRelative(0f, 0.013f, 0f, 0.026f, -0.004f, 0.038f)
            curveToRelative(-0.017f, 0.828f, -0.691f, 1.493f, -1.523f, 1.493f)
            lineToRelative(-0.427f, 0f)
            lineToRelative(0f, 0.01f)
            lineToRelative(-0.533f, 0f)
            curveToRelative(-0.833f, 0f, -1.507f, -0.666f, -1.523f, -1.493f)
            curveToRelative(-0.004f, -0.013f, -0.004f, -0.026f, -0.004f, -0.038f)
            curveToRelative(0f, -0.572f, 0.311f, -1.067f, 0.776f, -1.327f)
            curveToRelative(0.222f, -0.128f, 0.478f, -0.2f, 0.751f, -0.2f)
            lineToRelative(0.427f, 0f)
            lineToRelative(0f, -0.009f)
            lineToRelative(0.533f, 0f)
            curveToRelative(0.273f, 0f, 0.534f, 0.072f, 0.756f, 0.201f)
            curveToRelative(0.461f, 0.259f, 0.772f, 0.755f, 0.772f, 1.327f)
            close()
        }
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(28.131f, 10.99f)
            curveToRelative(0f, 0.508f, -0.085f, 0.995f, -0.234f, 1.451f)
            curveToRelative(-0.286f, 0.862f, -0.828f, 1.613f, -1.528f, 2.159f)
            curveToRelative(-0.252f, 0.201f, -0.525f, 0.371f, -0.811f, 0.512f)
            curveToRelative(-0.49f, 0.239f, -1.024f, 0.393f, -1.591f, 0.444f)
            curveToRelative(-0.141f, 0.012f, -0.282f, 0.021f, -0.423f, 0.021f)
            lineToRelative(-1.353f, 0f)
            lineToRelative(0f, 0.009f)
            lineToRelative(-1.455f, 0f)
            curveToRelative(-0.141f, 0f, -0.282f, -0.005f, -0.418f, -0.021f)
            curveToRelative(-0.572f, -0.047f, -1.109f, -0.205f, -1.599f, -0.449f)
            curveToRelative(-0.29f, -0.136f, -0.559f, -0.307f, -0.807f, -0.507f)
            curveToRelative(-0.704f, -0.546f, -1.242f, -1.297f, -1.528f, -2.159f)
            curveToRelative(-0.153f, -0.457f, -0.234f, -0.944f, -0.234f, -1.45f)
            curveToRelative(0f, -0.269f, 0.021f, -0.53f, 0.069f, -0.786f)
            curveToRelative(0.166f, -0.977f, 0.644f, -1.843f, 1.322f, -2.505f)
            curveToRelative(0.03f, -0.03f, 0.064f, -0.059f, 0.094f, -0.09f)
            curveToRelative(0.367f, -0.337f, 0.79f, -0.614f, 1.254f, -0.819f)
            curveToRelative(0.388f, -0.17f, 0.806f, -0.29f, 1.246f, -0.35f)
            curveToRelative(0.196f, -0.026f, 0.397f, -0.038f, 0.602f, -0.038f)
            lineToRelative(1.349f, 0f)
            lineToRelative(0f, -0.009f)
            lineToRelative(1.459f, 0f)
            curveToRelative(0.2f, 0f, 0.401f, 0.013f, 0.597f, 0.038f)
            curveToRelative(0.439f, 0.06f, 0.857f, 0.18f, 1.246f, 0.354f)
            curveToRelative(0.46f, 0.201f, 0.883f, 0.478f, 1.25f, 0.815f)
            curveToRelative(0.034f, 0.03f, 0.068f, 0.059f, 0.098f, 0.094f)
            curveToRelative(0.683f, 0.657f, 1.161f, 1.528f, 1.327f, 2.5f)
            curveToRelative(0.046f, 0.256f, 0.068f, 0.517f, 0.068f, 0.785f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(25.383f, 14.281f)
            lineToRelative(-3.297f, 0f)
            lineToRelative(0f, 0.009f)
            lineToRelative(-3.189f, 0f)
            curveToRelative(-0.928f, 0f, -1.68f, 0.752f, -1.68f, 1.68f)
            curveToRelative(0f, 0.928f, 0.752f, 1.68f, 1.68f, 1.68f)
            lineToRelative(3.297f, 0f)
            lineToRelative(0f, -0.009f)
            lineToRelative(3.189f, 0f)
            curveToRelative(0.928f, 0f, 1.68f, -0.753f, 1.68f, -1.68f)
            curveToRelative(0f, -0.928f, -0.752f, -1.68f, -1.68f, -1.68f)
            close()
        }
        path(fill = SolidColor(Color(0xFF404040))) {
            moveToRelative(27.311f, 19.772f)
            lineToRelative(0f, 0.841f)
            curveToRelative(0f, 0.661f, -0.127f, 1.289f, -0.359f, 1.864f)
            lineToRelative(-4.762f, 0f)
            lineToRelative(0f, 0.009f)
            lineToRelative(-4.868f, 0f)
            curveToRelative(-0.231f, -0.576f, -0.359f, -1.204f, -0.359f, -1.864f)
            lineToRelative(0f, -0.841f)
            lineToRelative(5.12f, 0f)
            lineToRelative(0f, -0.009f)
            close()
        }
        group(name = "wing-r", rotate = rotateR1.value, pivotX = 23.417f, 9.353f) {
            path(
                fill = SolidColor(Color(0xFFC5D5D6)),
                fillAlpha = 0.8f
            ) {
                moveToRelative(23.417f, 9.353f)
                curveToRelative(0.732f, -2.947f, 3.903f, -0.904f, 9.426f, -2.34f)
                curveToRelative(5.688f, -1.481f, 10.911f, -3.762f, 11.415f, -1.828f)
                curveToRelative(0.502f, 1.935f, -8.626f, 12.531f, -14.315f, 14.011f)
                curveToRelative(-5.522f, 1.436f, -6.411f, -5.027f, -6.431f, -5.837f)
                curveToRelative(-0.019f, -0.809f, -0.184f, -0.71f, -0.095f, -4.006f)
                close()
            }
        }
        group(name = "wing-l", rotate = rotateL1.value, pivotX = 20.861f, 9.361f) {
            path(
                fill = SolidColor(Color(0xFFC5D5D6)),
                fillAlpha = 0.8f
            ) {
                moveToRelative(20.766f, 13.367f)
                curveToRelative(-0.193f, 2.007f, -0.918f, 4.166f, -2.628f, 5.376f)
                curveToRelative(-1.755f, 1.183f, -4.035f, 0.609f, -5.765f, -0.321f)
                curveToRelative(-3.407f, -1.857f, -6.242f, -4.598f, -8.81f, -7.47f)
                curveToRelative(-1.303f, -1.556f, -2.676f, -3.133f, -3.451f, -5.033f)
                curveToRelative(-0.529f, -1.056f, 0.75f, -1.672f, 1.634f, -1.457f)
                curveToRelative(2.517f, 0.297f, 4.898f, 1.23f, 7.329f, 1.902f)
                curveToRelative(2.202f, 0.68f, 4.466f, 1.235f, 6.785f, 1.242f)
                curveToRelative(1.338f, 0.082f, 2.75f, -0.176f, 4.018f, 0.358f)
                curveToRelative(0.873f, 0.429f, 1.074f, 1.477f, 1.003f, 2.361f)
                curveToRelative(0.033f, 1.017f, -0.021f, 2.03f, -0.115f, 3.042f)
                close()
            }
        }
    }.build()
}