package pnemonic.bug_bash.view.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pnemonic.bug_bash.view.theme.buttonPanel

@Composable
fun ActionPanel(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    Row(modifier = modifier.buttonPanel()) {
        content()
    }
}