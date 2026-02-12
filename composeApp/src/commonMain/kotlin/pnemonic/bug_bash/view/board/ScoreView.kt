package pnemonic.bug_bash.view.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.panel

private val colorText = Gold
private val sizeIcon = 30.dp
private val sizeText = 20.sp

@Composable
fun ScoreView(modifier: Modifier = Modifier, score: Long) {
    val locale = Locale.current
    val platform: Platform = getPlatform()

    Row(modifier = modifier.panel(), verticalAlignment = Alignment.CenterVertically) {
        Image(imageVector = Trophy, contentDescription = "🏆", modifier = Modifier.size(sizeIcon))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = platform.formatInteger(locale, score), fontSize = sizeText, color = colorText)
    }
}

@Composable
@Preview(locale = "de")
private fun Preview_DE() {
    MaterialTheme {
        ScoreView(score = 10000)
    }
}

@Composable
@Preview(locale = "en")
private fun Preview_EN() {
    MaterialTheme {
        ScoreView(score = 10000)
    }
}