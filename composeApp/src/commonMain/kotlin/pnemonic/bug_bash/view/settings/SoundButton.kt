package pnemonic.bug_bash.view.settings

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.BooleanCallback
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.toggle

@Composable
fun SoundButton(
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback
) {
    val haptic = LocalHapticFeedback.current
    var soundEnabled by remember { mutableStateOf(isSoundEnabled) }

    IconToggleButton(
        checked = soundEnabled,
        onCheckedChange = { checked ->
            haptic.toggle(checked)
            soundEnabled = checked
            onSoundChange(soundEnabled)
        }
    ) {
        val icon =
            if (soundEnabled) Icons.AutoMirrored.Filled.VolumeUp else Icons.AutoMirrored.Filled.VolumeOff
        Icon(imageVector = icon, contentDescription = "Toggle Sound", tint = colorButton)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        Column {
            SoundButton(true) {}
            SoundButton(false) {}
        }
    }
}