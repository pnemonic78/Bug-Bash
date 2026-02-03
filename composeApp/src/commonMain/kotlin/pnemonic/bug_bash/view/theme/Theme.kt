package pnemonic.bug_bash.view.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier

fun Modifier.modifierButton(): Modifier = this.size(sizeButton)
    .background(color = colorButtonBackground, shape = shapeButton)
    .padding(paddingButton)

fun Modifier.modifierIcon(): Modifier = this.size(sizeButton)
