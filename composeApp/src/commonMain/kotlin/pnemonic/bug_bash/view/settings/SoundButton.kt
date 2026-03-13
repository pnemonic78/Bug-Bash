package pnemonic.bug_bash.view.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
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
import pnemonic.compose.toggle

@Composable
fun SoundButton(
    enabled: Boolean = true,
    size: Dp = sizeButton,
    onChange: BooleanCallback
) {
    val haptic = LocalHapticFeedback.current
    var enabledState by remember { mutableStateOf(enabled) }

    IconToggleButton(
        checked = enabledState,
        onCheckedChange = { checked ->
            haptic.toggle(checked)
            enabledState = checked
            onChange(checked)
        },
        modifier = Modifier.modifierButton(size = size)
    ) {
        val icon =
            if (enabledState) Icons.AutoMirrored.Filled.VolumeUp else Icons.AutoMirrored.Filled.VolumeOff
        Icon(
            imageVector = icon,
            contentDescription = "🔉",
            tint = colorButton,
            modifier = Modifier.modifierIcon(size = size)
        )
    }
}

@Composable
@Preview
private fun Preview0() {
    MaterialTheme {
        SoundButton(enabled = false) {}
    }
}

@Composable
@Preview
private fun Preview1() {
    MaterialTheme {
        SoundButton(enabled = true) {}
    }
}