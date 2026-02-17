package pnemonic.bug_bash.view.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import pnemonic.BooleanCallback
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.theme.modifierButton
import pnemonic.bug_bash.view.theme.modifierIcon
import pnemonic.bug_bash.view.theme.sizeButton
import pnemonic.bug_bash.view.toggle

@Composable
fun PauseButton(
    paused: Boolean = false,
    size: Dp = sizeButton,
    onChange: BooleanCallback
) {
    val haptic = LocalHapticFeedback.current
    var pausedState by remember { mutableStateOf(paused) }

    IconToggleButton(
        checked = pausedState,
        onCheckedChange = { checked ->
            haptic.toggle(checked)
            pausedState = checked
            onChange(pausedState)
        },
        modifier = Modifier.modifierButton(size = size)
    ) {
        val icon =
            if (pausedState) Icons.Default.PlayArrow else Icons.Default.Pause
        Icon(
            imageVector = icon,
            contentDescription = "⏯",
            tint = colorButton,
            modifier = Modifier.modifierIcon(size = size)
        )
    }
}

@Composable
@Preview
private fun Preview0() {
    MaterialTheme {
        PauseButton(paused = false) {}
    }
}

@Composable
@Preview
private fun Preview1() {
    MaterialTheme {
        PauseButton(paused = true) {}
    }
}