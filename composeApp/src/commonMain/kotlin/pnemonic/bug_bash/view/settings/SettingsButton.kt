package pnemonic.bug_bash.view.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.theme.colorButton

@Composable
fun SettingsButton(onClick: VoidCallback) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = colorButton)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        SettingsButton {}
    }
}