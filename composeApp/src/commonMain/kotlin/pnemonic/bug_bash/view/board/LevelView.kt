package pnemonic.bug_bash.view.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pnemonic.bug_bash.drawable.Level
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.panel
import pnemonic.compose.Left

private val colorText = Gold
private val sizeIcon = 30.dp
private val sizeText = 20.sp

@Composable
fun LevelView(modifier: Modifier = Modifier, level: Int) {
    Row(
        modifier = modifier.panel(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Left
    ) {
        Image(imageVector = Level, contentDescription = "🏁", modifier = Modifier.size(sizeIcon))
        Spacer(modifier = Modifier.width(4.dp))
        Text("$level", color = colorText, fontSize = sizeText)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        LevelView(level = 123)
    }
}

@Composable
@Preview(locale = "he")
private fun Preview_RTL() {
    MaterialTheme {
        LevelView(level = 123)
    }
}