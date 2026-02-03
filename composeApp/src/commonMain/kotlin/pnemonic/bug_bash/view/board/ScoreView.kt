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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.view.theme.Gold

private val colorText = Gold
private val sizeIcon = 30.dp
private val sizeText = 20.sp
private val shadow = Shadow(blurRadius = 2f, offset = Offset(2f, 2f))

@Composable
fun ScoreView(modifier: Modifier = Modifier, score: Long) {
    val locale = Locale.current
    val platform: Platform = getPlatform()

    val style = MaterialTheme.typography.bodyMedium.copy(
        color = colorText,
        fontSize = sizeText,
        shadow = shadow
    )

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(imageVector = Trophy, contentDescription = "🏆", modifier = Modifier.size(sizeIcon))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = platform.formatInteger(locale, score), style = style)
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