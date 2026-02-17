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
import pnemonic.bug_bash.view.settings.MenuButton
import pnemonic.bug_bash.view.settings.MusicButton
import pnemonic.bug_bash.view.settings.PauseButton
import pnemonic.bug_bash.view.settings.SoundButton

private val spacing = 8.dp

@Composable
fun SettingsPanel(
    modifier: Modifier = Modifier,
    onHomeClick: VoidCallback,
    isPaused: Boolean = false,
    onPauseChange: BooleanCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback
) {
    var expanded by remember { mutableStateOf(false) }

    ActionPanel(modifier = modifier) {
        PauseButton(isPaused, onChange = onPauseChange)
        Spacer(modifier = Modifier.width(spacing))
        AnimatedVisibility(
            visible = expanded,
            // Combines sliding and expanding horizontally
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth } // Start from the right
            ) + expandHorizontally(
                expandFrom = Alignment.End // Expand from the end
            ) + fadeIn(),
            // Defines how it disappears
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth } // Exit to the right
            ) + shrinkHorizontally(
                shrinkTowards = Alignment.End // Shrink towards the end
            ) + fadeOut()
        ) {
            Row {
                SoundButton(isSoundEnabled, onChange = onSoundChange)
                Spacer(modifier = Modifier.width(spacing))
                MusicButton(isMusicEnabled, onChange = onMusicChange)
                Spacer(modifier = Modifier.width(spacing))
                HomeButton(onClick = onHomeClick)
                Spacer(modifier = Modifier.width(spacing))
            }
        }
        MenuButton(onClick = { expanded = !expanded })
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        SettingsPanel(
            onHomeClick = {},
            isPaused = false,
            onPauseChange = {},
            isSoundEnabled = true,
            onSoundChange = {},
            isMusicEnabled = false,
            onMusicChange = {}
        )
    }
}
