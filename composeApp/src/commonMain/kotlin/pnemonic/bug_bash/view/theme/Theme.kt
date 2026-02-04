package pnemonic.bug_bash.view.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.modifierButton(): Modifier = this.size(sizeButton)
    .padding(paddingButton)

fun Modifier.modifierIcon(): Modifier = this.size(sizeButton)

fun Modifier.buttonPanel(): Modifier =
    this.background(color = colorButtonBackground, shape = shapeButtonPanel)
        .padding(paddingButtonPanel)