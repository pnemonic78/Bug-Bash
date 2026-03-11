package pnemonic.bug_bash.view.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pnemonic.bug_bash.view.Left
import pnemonic.bug_bash.view.theme.panelScrollable

@Composable
fun ActionPanel(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    Row(modifier = modifier.panelScrollable(), horizontalArrangement = Arrangement.Left) {
        content()
    }
}