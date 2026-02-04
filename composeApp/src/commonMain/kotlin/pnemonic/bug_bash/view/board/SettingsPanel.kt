package pnemonic.bug_bash.view.board

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.home.HomeButton
import pnemonic.bug_bash.view.settings.ActionPanel
import pnemonic.bug_bash.view.settings.MusicButton
import pnemonic.bug_bash.view.settings.SettingsButton
import pnemonic.bug_bash.view.settings.SoundButton

@Composable
fun SettingsPanel(
    modifier: Modifier = Modifier,
    onHomeClick: VoidCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    var expanded by remember { mutableStateOf(false) }

    ActionPanel(modifier = modifier) {
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
                Spacer(modifier = Modifier.width(8.dp))
                MusicButton(isMusicEnabled, onMusicChange)
            }
        }
        SettingsButton(onClick = { expanded = !expanded })
        Spacer(modifier = Modifier.width(8.dp))
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
