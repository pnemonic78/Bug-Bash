package pnemonic.bug_bash.view.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
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
fun MusicButton(
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    val haptic = LocalHapticFeedback.current
    var musicEnabled by remember { mutableStateOf(isMusicEnabled) }

    IconToggleButton(
        checked = musicEnabled,
        onCheckedChange = { checked ->
            haptic.toggle(checked)
            musicEnabled = checked
            onMusicChange(musicEnabled)
        }
    ) {
        val icon = if (musicEnabled) Icons.Default.MusicNote else Icons.Default.MusicOff
        Icon(imageVector = icon, contentDescription = "Toggle Music", tint = colorButton)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        Column {
            MusicButton(true) {}
            MusicButton(false) {}
        }
    }
}