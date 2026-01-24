package pnemonic.bug_bash.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MusicOff
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.BooleanCallback

@Composable
fun SettingsPanel(
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    var expanded by remember { mutableStateOf(false) }
    var soundEnabled by remember { mutableStateOf(isSoundEnabled) }
    var musicEnabled by remember { mutableStateOf(isMusicEnabled) }

    Row {
        AnimatedVisibility(
            visible = expanded,
            // Combines sliding and expanding horizontally
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth } // Start from the right
            ) + expandHorizontally(
                expandFrom = Alignment.End // Expand from the start (left)
            ) + fadeIn(),
            // Defines how it disappears
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth } // Exit to the right
            ) + shrinkHorizontally(
                shrinkTowards = Alignment.End // Shrink towards the start (left)
            ) + fadeOut()
        ) {
            Row {
                IconToggleButton(
                    checked = soundEnabled,
                    onCheckedChange = {
                        soundEnabled = !soundEnabled
                        onSoundChange(soundEnabled)
                    }
                ) {
                    val icon = if (soundEnabled) Icons.Default.VolumeUp else Icons.Default.VolumeOff
                    Icon(imageVector = icon, contentDescription = "Toggle Sound")
                }

                IconToggleButton(
                    checked = musicEnabled,
                    onCheckedChange = {
                        musicEnabled = !musicEnabled
                        onMusicChange(musicEnabled)
                    }
                ) {
                    val icon = if (musicEnabled) Icons.Default.MusicNote else Icons.Default.MusicOff
                    Icon(imageVector = icon, contentDescription = "Toggle Music")
                }
            }
        }
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        SettingsPanel(
            isSoundEnabled = true,
            onSoundChange = {},
            isMusicEnabled = false,
            onMusicChange = {}
        )
    }
}
