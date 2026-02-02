package pnemonic.bug_bash.view.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback

@Composable
fun SettingsButton(onClick: VoidCallback) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        SettingsButton {}
    }
}