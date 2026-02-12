package pnemonic.bug_bash.view.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.modifierButton(size: Dp = sizeButton): Modifier = this.size(size)
    .padding(paddingButton)

fun Modifier.modifierIcon(size: Dp = sizeButton): Modifier = this.size(size)

fun Modifier.panel(): Modifier =
    this.background(color = colorButtonBackground, shape = shapePanel)
        .padding(paddingPanel)
        .padding(horizontal = 4.dp)