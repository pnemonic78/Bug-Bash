package pnemonic.bug_bash.view.difficulty

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import pnemonic.BooleanCallback
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.theme.modifierButton
import pnemonic.bug_bash.view.theme.modifierIcon
import pnemonic.bug_bash.view.theme.sizeButton
import pnemonic.compose.toggle

private val colorButtonSelected = Color.Green

@Composable
fun EasyButton(
    enabled: Boolean = false,
    size: Dp = sizeButton,
    onChange: BooleanCallback
) {
    val haptic = LocalHapticFeedback.current

    IconToggleButton(
        checked = enabled,
        onCheckedChange = { checked ->
            haptic.toggle(checked)
            onChange(checked)
        },
        modifier = Modifier.modifierButton(size = size)
    ) {
        val tint = if (enabled) colorButtonSelected else colorButton
        Icon(
            imageVector = Icons.Default.SentimentVerySatisfied,
            contentDescription = "😁",
            tint = tint,
            modifier = Modifier.modifierIcon(size = size)
        )
    }
}

@Composable
@Preview
private fun Preview0() {
    MaterialTheme {
        EasyButton(false) {}
    }
}

@Composable
@Preview
private fun Preview1() {
    MaterialTheme {
        EasyButton(true) {}
    }
}