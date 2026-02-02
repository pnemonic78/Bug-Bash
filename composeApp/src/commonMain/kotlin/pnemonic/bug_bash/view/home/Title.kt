package pnemonic.bug_bash.view.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.title
import org.jetbrains.compose.resources.stringResource
import pnemonic.bug_bash.view.theme.colorPrimary
import pnemonic.bug_bash.view.theme.colorSecondary

@Composable
fun Title(modifier: Modifier = Modifier) {
    val title = stringResource(Res.string.title)
    val style = MaterialTheme.typography.titleLarge.copy(
        brush = Brush.verticalGradient(colors = listOf(colorSecondary, colorPrimary), endY = 100f),
        fontWeight = FontWeight.Bold,
        fontSize = 70.sp,
        shadow = Shadow(blurRadius = 5f, offset = Offset(5f, 5f))
    )

    Text(text = title, style = style, modifier = modifier, textAlign = TextAlign.Center)
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
private fun Preview() {
    MaterialTheme {
        Title()
    }
}