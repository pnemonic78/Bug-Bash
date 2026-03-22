package pnemonic.bug_bash.view

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal const val previewWidthDp = 300
internal const val previewHeightDp = 500
internal const val previewColor = 0xFF0000FF

@Preview(
    name = "portrait",
    group = "orientation",
    widthDp = previewWidthDp,
    heightDp = previewHeightDp
)
@Preview(
    name = "landscape",
    group = "orientation",
    widthDp = previewHeightDp,
    heightDp = previewWidthDp
)
annotation class OrientationPreviews