package pnemonic.bug_bash.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Trophy: ImageVector
    get() {
        if (_Trophy != null) {
            return _Trophy!!
        }
        _Trophy = ImageVector.Builder(
            name = "Trophy",
            defaultWidth = 193.5.dp,
            defaultHeight = 205.dp,
            viewportWidth = 193.5f,
            viewportHeight = 205f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(118.92f, 136.1f),
                    end = Offset(75.74f, 136.1f)
                )
            ) {
                moveToRelative(75.74f, 136.1f)
                curveToRelative(-0f, 3.39f, 2.75f, 6.14f, 6.14f, 6.14f)
                lineToRelative(30.9f, 0f)
                curveToRelative(3.39f, 0f, 6.14f, -2.75f, 6.14f, -6.14f)
                lineToRelative(-0f, 0f)
                curveToRelative(-0f, -3.39f, -2.75f, -6.14f, -6.14f, -6.14f)
                lineToRelative(-30.9f, 0f)
                curveToRelative(-3.39f, 0f, -6.14f, 2.75f, -6.14f, 6.14f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(111.93f, 155.36f),
                    end = Offset(82.72f, 155.36f)
                )
            ) {
                moveTo(111.93f, 123.4f)
                lineToRelative(-29.21f, 0f)
                lineToRelative(-0f, 63.92f)
                lineToRelative(29.21f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(141.35f, 184.78f),
                    end = Offset(53.3f, 184.78f)
                )
            ) {
                moveTo(111.93f, 172.08f)
                lineToRelative(-29.21f, 0f)
                lineToRelative(-29.42f, 25.4f)
                lineToRelative(88.05f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(141.35f, 201.07f),
                    end = Offset(53.3f, 201.07f)
                )
            ) {
                moveTo(141.35f, 197.48f)
                lineToRelative(-88.05f, 0f)
                lineToRelative(-0f, 7.2f)
                lineToRelative(88.05f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(47.34f, 55.01f),
                    end = Offset(0f, 55.01f)
                )
            ) {
                moveToRelative(30.82f, 109f)
                curveToRelative(1.14f, 0f, 2.31f, -0.14f, 3.49f, -0.43f)
                curveToRelative(2.95f, -0.71f, 5.42f, -2.62f, 6.95f, -5.35f)
                curveToRelative(1.85f, -3.3f, 2.11f, -7.46f, 0.73f, -11.74f)
                curveToRelative(-3.92f, -12.21f, -10.74f, -22.11f, -20.16f, -35.81f)
                curveToRelative(-1.75f, -2.54f, -3.59f, -5.21f, -5.51f, -8.05f)
                curveToRelative(-7.71f, -11.37f, -10.57f, -23f, -7.48f, -30.35f)
                curveToRelative(1.87f, -4.43f, 5.95f, -7.24f, 12.13f, -8.35f)
                curveToRelative(9.55f, -1.71f, 14.38f, 4.3f, 16.41f, 8.03f)
                curveToRelative(2.95f, 5.44f, 2.81f, 11.07f, 1.41f, 12.55f)
                curveToRelative(-1.64f, 1.74f, -3.42f, 2.53f, -5.01f, 2.22f)
                curveToRelative(-1.42f, -0.28f, -2.62f, -1.43f, -3.29f, -3.16f)
                curveToRelative(-0.71f, -1.84f, -0.6f, -2.79f, -0.42f, -3.06f)
                curveToRelative(0.31f, -0.46f, 1.51f, -0.74f, 1.87f, -0.75f)
                curveToRelative(2.1f, -0.06f, 3.76f, -1.82f, 3.69f, -3.92f)
                curveToRelative(-0.06f, -2.1f, -1.84f, -3.8f, -3.92f, -3.69f)
                curveToRelative(-0.55f, 0.02f, -5.42f, 0.28f, -7.99f, 4.15f)
                curveToRelative(-1.22f, 1.83f, -2.26f, 5.06f, -0.34f, 10.02f)
                curveToRelative(1.61f, 4.16f, 4.95f, 7.11f, 8.94f, 7.89f)
                curveToRelative(4.2f, 0.82f, 8.58f, -0.81f, 12.02f, -4.47f)
                curveToRelative(4.1f, -4.36f, 3.99f, -13.56f, -0.27f, -21.4f)
                curveToRelative(-5.04f, -9.3f, -14.18f, -13.76f, -24.45f, -11.9f)
                curveToRelative(-11.06f, 1.99f, -15.79f, 8.11f, -17.8f, 12.9f)
                curveToRelative(-4.15f, 9.85f, -1.08f, 23.9f, 8.2f, 37.58f)
                curveToRelative(1.94f, 2.86f, 3.78f, 5.54f, 5.54f, 8.1f)
                curveToRelative(9.06f, 13.17f, 15.61f, 22.68f, 19.19f, 33.82f)
                curveToRelative(0.72f, 2.24f, 0.67f, 4.26f, -0.13f, 5.68f)
                curveToRelative(-0.48f, 0.87f, -1.23f, 1.46f, -2.1f, 1.67f)
                curveToRelative(-1.76f, 0.43f, -3.41f, 0.19f, -4.63f, -0.68f)
                curveToRelative(-1.13f, -0.8f, -1.83f, -2.09f, -1.99f, -3.64f)
                curveToRelative(-0.04f, -0.4f, -0.04f, -0.67f, -0.02f, -0.86f)
                curveToRelative(0.35f, 0.01f, 0.75f, 0.06f, 0.92f, 0.11f)
                curveToRelative(2.01f, 0.62f, 4.14f, -0.5f, 4.77f, -2.51f)
                curveToRelative(0.62f, -2.01f, -0.5f, -4.14f, -2.51f, -4.77f)
                curveToRelative(-0.81f, -0.25f, -5f, -1.37f, -8.15f, 1.21f)
                curveToRelative(-1.41f, 1.15f, -3.01f, 3.41f, -2.59f, 7.59f)
                curveToRelative(0.38f, 3.77f, 2.21f, 7f, 5.16f, 9.09f)
                curveToRelative(2.14f, 1.51f, 4.67f, 2.29f, 7.35f, 2.29f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(151.17f, 66.98f),
                    end = Offset(42.09f, 66.98f)
                )
            ) {
                moveToRelative(42.09f, 0f)
                lineToRelative(54.43f, 0f)
                lineToRelative(0.22f, 0f)
                lineToRelative(54.44f, 0f)
                curveToRelative(-0f, 0f, -7.24f, 28.58f, -5.55f, 48.26f)
                curveToRelative(1.63f, 18.98f, 5.55f, 27.77f, 5.55f, 40f)
                curveToRelative(-0f, 12.17f, -0.02f, 45.37f, -54.44f, 45.7f)
                lineToRelative(-0f, 0f)
                curveToRelative(-0.04f, 0f, -0.07f, -0f, -0.11f, -0f)
                curveToRelative(-0.04f, 0f, -0.07f, 0f, -0.11f, 0f)
                lineToRelative(-0f, -0f)
                curveToRelative(-54.41f, -0.34f, -54.43f, -33.53f, -54.43f, -45.7f)
                curveToRelative(-0f, -12.23f, 3.91f, -21.02f, 5.55f, -40f)
                curveToRelative(1.69f, -19.68f, -5.55f, -48.26f, -5.55f, -48.26f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.12f to Color(0xFFF7941D),
                        0.78f to Color(0xFFFFCA3F)
                    ),
                    start = Offset(193.25f, 55.01f),
                    end = Offset(145.91f, 55.01f)
                )
            ) {
                moveToRelative(162.43f, 109f)
                curveToRelative(-1.14f, 0f, -2.31f, -0.14f, -3.49f, -0.43f)
                curveToRelative(-2.95f, -0.71f, -5.42f, -2.62f, -6.95f, -5.35f)
                curveToRelative(-1.85f, -3.3f, -2.11f, -7.46f, -0.73f, -11.74f)
                curveToRelative(3.92f, -12.21f, 10.73f, -22.11f, 20.17f, -35.81f)
                curveToRelative(1.75f, -2.54f, 3.58f, -5.21f, 5.51f, -8.05f)
                curveToRelative(7.71f, -11.37f, 10.57f, -23f, 7.48f, -30.35f)
                curveToRelative(-1.87f, -4.43f, -5.94f, -7.24f, -12.12f, -8.35f)
                curveToRelative(-9.56f, -1.71f, -14.39f, 4.3f, -16.41f, 8.03f)
                curveToRelative(-2.95f, 5.44f, -2.81f, 11.07f, -1.41f, 12.55f)
                curveToRelative(1.64f, 1.74f, 3.42f, 2.53f, 5.01f, 2.22f)
                curveToRelative(1.42f, -0.28f, 2.62f, -1.43f, 3.29f, -3.16f)
                curveToRelative(0.71f, -1.84f, 0.6f, -2.79f, 0.42f, -3.06f)
                curveToRelative(-0.31f, -0.46f, -1.51f, -0.74f, -1.88f, -0.75f)
                curveToRelative(-2.1f, -0.06f, -3.76f, -1.82f, -3.69f, -3.92f)
                curveToRelative(0.06f, -2.1f, 1.83f, -3.8f, 3.92f, -3.69f)
                curveToRelative(0.55f, 0.02f, 5.42f, 0.28f, 7.99f, 4.15f)
                curveToRelative(1.21f, 1.83f, 2.26f, 5.06f, 0.34f, 10.02f)
                curveToRelative(-1.61f, 4.16f, -4.95f, 7.11f, -8.94f, 7.89f)
                curveToRelative(-4.2f, 0.82f, -8.58f, -0.81f, -12.02f, -4.47f)
                curveToRelative(-4.1f, -4.36f, -3.99f, -13.56f, 0.26f, -21.4f)
                curveToRelative(5.04f, -9.3f, 14.18f, -13.76f, 24.46f, -11.9f)
                curveToRelative(11.06f, 1.99f, 15.79f, 8.11f, 17.8f, 12.9f)
                curveToRelative(4.15f, 9.85f, 1.08f, 23.9f, -8.2f, 37.58f)
                curveToRelative(-1.94f, 2.86f, -3.78f, 5.54f, -5.54f, 8.1f)
                curveToRelative(-9.06f, 13.17f, -15.61f, 22.68f, -19.19f, 33.82f)
                curveToRelative(-0.72f, 2.24f, -0.67f, 4.26f, 0.13f, 5.68f)
                curveToRelative(0.49f, 0.87f, 1.23f, 1.46f, 2.1f, 1.67f)
                curveToRelative(1.76f, 0.43f, 3.41f, 0.19f, 4.63f, -0.68f)
                curveToRelative(1.13f, -0.8f, 1.83f, -2.09f, 1.99f, -3.64f)
                curveToRelative(0.04f, -0.4f, 0.04f, -0.67f, 0.02f, -0.86f)
                curveToRelative(-0.35f, 0.01f, -0.76f, 0.06f, -0.92f, 0.11f)
                curveToRelative(-2.01f, 0.62f, -4.15f, -0.5f, -4.77f, -2.51f)
                curveToRelative(-0.62f, -2.01f, 0.5f, -4.14f, 2.51f, -4.77f)
                curveToRelative(0.81f, -0.25f, 4.99f, -1.37f, 8.14f, 1.21f)
                curveToRelative(1.41f, 1.15f, 3.01f, 3.41f, 2.59f, 7.59f)
                curveToRelative(-0.38f, 3.77f, -2.21f, 7f, -5.17f, 9.09f)
                curveToRelative(-2.14f, 1.51f, -4.67f, 2.29f, -7.35f, 2.29f)
                close()
            }
        }.build()

        return _Trophy!!
    }

@Suppress("ObjectPropertyName")
private var _Trophy: ImageVector? = null
