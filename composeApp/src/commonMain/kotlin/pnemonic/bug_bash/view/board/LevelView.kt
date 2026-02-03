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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pnemonic.bug_bash.drawable.Level

private val colorText = Color.Yellow
private val sizeIcon = 30.dp
private val sizeText = 20.sp
private val shadow = Shadow(blurRadius = 2f, offset = Offset(2f, 2f))

@Composable
fun LevelView(modifier: Modifier = Modifier, level: Int) {
    val style = MaterialTheme.typography.bodyMedium.copy(
        color = colorText,
        fontSize = sizeText,
        shadow = shadow
    )

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(imageVector = Level, contentDescription = "🏁", modifier = Modifier.size(sizeIcon))
        Spacer(modifier = Modifier.width(4.dp))
        Text("$level", style = style)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        LevelView(level = 123)
    }
}