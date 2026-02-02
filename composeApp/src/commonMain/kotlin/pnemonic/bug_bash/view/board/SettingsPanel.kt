package pnemonic.bug_bash.view.board

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.home.HomeButton
import pnemonic.bug_bash.view.settings.MusicButton
import pnemonic.bug_bash.view.settings.SettingsButton
import pnemonic.bug_bash.view.settings.SoundButton

@Composable
fun SettingsPanel(
    onHomeClick: VoidCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    var expanded by remember { mutableStateOf(false) }

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
                SoundButton(isSoundEnabled, onSoundChange)
                MusicButton(isMusicEnabled, onMusicChange)
            }
        }
        SettingsButton(onClick = { expanded = !expanded })
        HomeButton(onClick = onHomeClick)
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        SettingsPanel(
            onHomeClick = {},
            isSoundEnabled = true,
            onSoundChange = {},
            isMusicEnabled = false,
            onMusicChange = {}
        )
    }
}
