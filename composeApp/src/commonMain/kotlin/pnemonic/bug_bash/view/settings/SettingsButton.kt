package pnemonic.bug_bash.view.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.theme.modifierButton
import pnemonic.bug_bash.view.theme.modifierIcon

@Composable
fun SettingsButton(onClick: VoidCallback) {
    IconButton(onClick = onClick, modifier = Modifier.modifierButton()) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings",
            tint = colorButton,
            modifier = Modifier.modifierIcon()
        )
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        SettingsButton {}
    }
}