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
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.stateOf

private const val durationLeg = 500
private const val offsetLeg = 100

@Composable
fun centipede(bug: Centipede): ImageVector = centipede(bug.isStopped)

@Composable
fun centipede(stopped: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateL4: State<Float>
    val rotateL5: State<Float>
    val rotateL6: State<Float>
    val rotateL7: State<Float>
    val rotateL8: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>
    val rotateR4: State<Float>
    val rotateR5: State<Float>
    val rotateR6: State<Float>
    val rotateR7: State<Float>
    val rotateR8: State<Float>

    if (stopped) {
        rotateL1 = stateOf(-45f)
        rotateL2 = stateOf(-15f)
        rotateL3 = stateOf(0f)
        rotateL4 = stateOf(-45f)
        rotateL5 = stateOf(-15f)
        rotateL6 = rotateL1
        rotateL7 = rotateL2
        rotateL8 = rotateL3
        rotateR1 = stateOf(45f)
        rotateR2 = stateOf(15f)
        rotateR3 = stateOf(0f)
        rotateR4 = stateOf(45f)
        rotateR5 = stateOf(15f)
        rotateR6 = rotateR1
        rotateR7 = rotateR2
        rotateR8 = rotateR3
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
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 0)
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 3)
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 1)
            )
        )
        rotateL4 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 4)
            )
        )
        rotateL5 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 2)
            )
        )
        rotateL6 = rotateL1
        rotateL7 = rotateL2
        rotateL8 = rotateL3
        rotateR1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 0)
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 3)
            )
        )
        rotateR3 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 1)
            )
        )
        rotateR4 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 4)
            )
        )
        rotateR5 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 2)
            )
        )
        rotateR6 = rotateR1
        rotateR7 = rotateR2
        rotateR8 = rotateR3
    }

    return ImageVector.Builder(
        name = "Centipede",
        defaultWidth = 7.999.dp,
        defaultHeight = 29.283.dp,
        viewportWidth = 7.999f,
        viewportHeight = 29.283f
    ).apply {
        group(name = "leg-l1", rotate = rotateL1.value, pivotX = 2.646f, pivotY = 9.681f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 9.681f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l2", rotate = rotateL2.value, pivotX = 2.646f, pivotY = 11.96f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 11.96f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l3", rotate = rotateL3.value, pivotX = 2.646f, pivotY = 13.967f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 13.967f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l4", rotate = rotateL4.value, pivotX = 2.646f, pivotY = 15.929f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 15.929f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l5", rotate = rotateL5.value, pivotX = 2.646f, pivotY = 18.067f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 18.067f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l6", rotate = rotateL6.value, pivotX = 2.646f, pivotY = 20.105f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 20.105f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l7", rotate = rotateL7.value, pivotX = 2.646f, pivotY = 22.176f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 22.176f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-l8", rotate = rotateL8.value, pivotX = 2.646f, pivotY = 24.283f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(2.646f, 24.283f)
                curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
                curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
                curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
                curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
                curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r1", rotate = rotateR1.value, pivotX = 5.33f, pivotY = 9.681f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 9.681f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r2", rotate = rotateR2.value, pivotX = 5.33f, pivotY = 11.96f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 11.96f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r3", rotate = rotateR3.value, pivotX = 5.33f, pivotY = 13.967f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 13.967f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r4", rotate = rotateR4.value, pivotX = 5.33f, pivotY = 15.929f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 15.929f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r5", rotate = rotateR5.value, pivotX = 5.33f, pivotY = 18.067f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 18.067f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r6", rotate = rotateR6.value, pivotX = 5.33f, pivotY = 20.104f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 20.104f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r7", rotate = rotateR7.value, pivotX = 5.33f, pivotY = 22.176f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 22.176f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        group(name = "leg-r8", rotate = rotateR8.value, pivotX = 5.33f, pivotY = 24.282f) {
            path(fill = SolidColor(Color(0xDDFBCC02))) {
                moveToRelative(5.33f, 24.282f)
                curveToRelative(0f, 0f, 0.232f, -0.495f, 0.974f, -0.656f)
                curveToRelative(0.742f, -0.161f, 1.672f, -0.189f, 1.672f, -0.189f)
                curveToRelative(0f, 0f, -0.056f, 0.253f, -0.62f, 0.423f)
                curveToRelative(-0.563f, 0.169f, -1.099f, 0.202f, -1.465f, 0.423f)
                curveToRelative(-0.366f, 0.221f, -0.561f, 0.407f, -0.561f, 0.407f)
                lineToRelative(0f, -0.407f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF424242))) {
            moveToRelative(3.169f, 26.316f)
            curveToRelative(0f, 0f, -0.515f, 0.418f, -1.19f, 1.254f)
            curveToRelative(-0.676f, 0.836f, -0.772f, 1.713f, -0.772f, 1.713f)
            curveToRelative(0f, 0f, 0.961f, -1.321f, 1.66f, -1.81f)
            curveToRelative(0.699f, -0.489f, 0.753f, -1.024f, 0.753f, -1.024f)
            close()
        }
        path(fill = SolidColor(Color(0xFF424242))) {
            moveToRelative(4.616f, 26.316f)
            curveToRelative(0f, 0f, 0.515f, 0.418f, 1.19f, 1.254f)
            curveToRelative(0.676f, 0.836f, 0.772f, 1.713f, 0.772f, 1.713f)
            curveToRelative(0f, 0f, -0.961f, -1.321f, -1.66f, -1.81f)
            curveToRelative(-0.699f, -0.489f, -0.753f, -1.024f, -0.753f, -1.024f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.455f, 5.288f)
            curveToRelative(0f, 0f, -0.774f, -0.682f, -1.447f, -1.807f)
            curveToRelative(-0.284f, -0.476f, -0.3f, -1.171f, -0.323f, -1.815f)
            curveToRelative(-0.031f, -0.88f, 0f, -1.665f, 0f, -1.665f)
            curveToRelative(0f, 0f, 0.223f, 0.39f, 0.323f, 1.115f)
            curveToRelative(0.099f, 0.725f, -0.069f, 1.433f, 0.386f, 2.349f)
            curveToRelative(0.365f, 0.735f, 1.225f, 1.527f, 1.225f, 1.527f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(4.408f, 5.288f)
            curveToRelative(0f, 0f, 0.774f, -0.682f, 1.447f, -1.807f)
            curveToRelative(0.284f, -0.476f, 0.3f, -1.171f, 0.323f, -1.815f)
            curveToRelative(0.031f, -0.88f, 0f, -1.665f, 0f, -1.665f)
            curveToRelative(0f, 0f, -0.223f, 0.39f, -0.323f, 1.115f)
            curveToRelative(-0.099f, 0.725f, 0.069f, 1.433f, -0.386f, 2.349f)
            curveToRelative(-0.365f, 0.735f, -1.225f, 1.527f, -1.225f, 1.527f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(4.692f, 25.193f)
            lineToRelative(-0.78f, 0.094f)
            lineToRelative(-0.738f, -0.094f)
            curveToRelative(0f, 0f, -0.328f, 0.397f, -0.305f, 1.002f)
            curveToRelative(0.019f, 0.497f, 0.459f, 0.833f, 1.043f, 0.833f)
            curveToRelative(0.584f, 0f, 1.067f, -0.336f, 1.085f, -0.833f)
            curveToRelative(0.022f, -0.605f, -0.305f, -1.002f, -0.305f, -1.002f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 22.96f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 23.441f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 20.936f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 21.417f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 18.97f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.227f, 1.536f, 1.227f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.227f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 19.366f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 16.756f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 17.237f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 14.731f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 15.212f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 12.766f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 13.235f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 10.75f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.89f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 11.231f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 8.726f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.198f, 9.188f)
            curveToRelative(0f, 0f, -0.503f, 0.967f, 0.026f, 1.44f)
            curveToRelative(0.493f, 0.441f, 1.162f, 0.357f, 1.508f, 0f)
            curveToRelative(0.529f, -0.545f, -0.053f, -1.44f, -0.053f, -1.44f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.081f, 6.761f)
            lineToRelative(-1.149f, 0.139f)
            lineToRelative(-1.087f, -0.139f)
            curveToRelative(0f, 0f, -0.482f, 0.584f, -0.449f, 1.475f)
            curveToRelative(0.027f, 0.732f, 0.676f, 1.226f, 1.536f, 1.226f)
            curveToRelative(0.86f, 0f, 1.57f, -0.495f, 1.598f, -1.226f)
            curveToRelative(0.033f, -0.891f, -0.449f, -1.475f, -0.449f, -1.475f)
            close()
        }
        path(fill = SolidColor(Color(0xFFC83812))) {
            moveToRelative(3.127f, 6.761f)
            curveToRelative(0f, 0f, -0.592f, 1.066f, 0f, 1.811f)
            curveToRelative(0.438f, 0.552f, 1.507f, 0.298f, 1.803f, -0.141f)
            curveToRelative(0.423f, -0.626f, -0.225f, -1.67f, -0.225f, -1.67f)
            close()
        }
        path(fill = SolidColor(Color(0xFF80300F))) {
            moveToRelative(5.16f, 6.278f)
            curveToRelative(-0.224f, -0.473f, -0.646f, -1.413f, -1.059f, -1.562f)
            curveToRelative(0.138f, 0.375f, 0.38f, 0.837f, 0.497f, 1.271f)
            curveToRelative(0.189f, 0.7f, -0.122f, 0.877f, -0.977f, 0.872f)
            curveToRelative(-0.548f, -0.003f, -0.793f, -0.36f, -0.899f, -0.616f)
            curveToRelative(-0.005f, 0.011f, -0.011f, 0.024f, -0.016f, 0.034f)
            curveToRelative(-0.243f, 0.515f, 0.309f, 1.254f, 1.046f, 1.319f)
            curveToRelative(0.073f, 0.006f, 0.289f, 0.006f, 0.362f, 0f)
            curveToRelative(0.737f, -0.064f, 1.289f, -0.804f, 1.046f, -1.318f)
            close()
        }
        path(fill = SolidColor(Color(0xEEC83812))) {
            moveToRelative(3.619f, 6.86f)
            curveToRelative(0.855f, 0.006f, 1.166f, -0.171f, 0.977f, -0.872f)
            curveToRelative(-0.117f, -0.435f, -0.359f, -0.896f, -0.497f, -1.271f)
            curveToRelative(-0.037f, -0.013f, -0.073f, -0.022f, -0.109f, -0.022f)
            lineToRelative(-0.118f, 0f)
            curveToRelative(-0.437f, 0f, -0.905f, 1.024f, -1.152f, 1.55f)
            curveToRelative(0.106f, 0.256f, 0.351f, 0.612f, 0.899f, 0.615f)
            close()
        }
        path(fill = SolidColor(Color(0xDDFBCC02))) {
            moveToRelative(-2.354f, 20.16f)
            curveToRelative(0f, 0f, -0.232f, -0.495f, -0.974f, -0.656f)
            curveToRelative(-0.742f, -0.161f, -1.672f, -0.189f, -1.672f, -0.189f)
            curveToRelative(0f, 0f, 0.056f, 0.253f, 0.62f, 0.423f)
            curveToRelative(0.563f, 0.169f, 1.099f, 0.202f, 1.465f, 0.423f)
            curveToRelative(0.366f, 0.221f, 0.561f, 0.407f, 0.561f, 0.407f)
            lineToRelative(0f, -0.407f)
            close()
        }
    }.build()
}