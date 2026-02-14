package pnemonic.bug_bash.view.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.settings.ActionPanel
import pnemonic.bug_bash.view.settings.HelpButton
import pnemonic.bug_bash.view.settings.MusicButton
import pnemonic.bug_bash.view.settings.SoundButton
import pnemonic.bug_bash.view.theme.sizeHomeButton

@Composable
fun SettingsPanel(
    modifier: Modifier = Modifier,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback,
    onHelpClick: VoidCallback,
) {
    ActionPanel(modifier = modifier) {
        HelpButton(size = sizeHomeButton, onHelpClick)
        Spacer(modifier = Modifier.width(8.dp))
        SoundButton(isSoundEnabled, size = sizeHomeButton, onSoundChange)
        Spacer(modifier = Modifier.width(8.dp))
        MusicButton(isMusicEnabled, size = sizeHomeButton, onMusicChange)
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
            onMusicChange = {},
            onHelpClick = {},
        )
    }
}
