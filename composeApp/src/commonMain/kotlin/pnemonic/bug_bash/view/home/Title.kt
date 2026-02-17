package pnemonic.bug_bash.view.home

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.title
import org.jetbrains.compose.resources.stringResource
import pnemonic.bug_bash.view.theme.Brown
import pnemonic.bug_bash.view.theme.DarkRed
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.LightBrown

private val sizeTitle = 70.sp

@Composable
fun Title(modifier: Modifier = Modifier) {
    val title = stringResource(Res.string.title)
    Title(modifier = modifier, title = title)
}

@Composable
fun Title(modifier: Modifier = Modifier, title: String) {
    var heightPx by remember { mutableFloatStateOf(200f) }

    val style = LocalTextStyle.current.copy(
        lineHeight = sizeTitle,
        brush = Brush.verticalGradient(
            colors = listOf(White, Yellow, Gold, LightBrown, Brown, DarkRed),
            endY = heightPx
        ),
        shadow = Shadow(blurRadius = 5f),
    )

    Text(
        modifier = modifier,
        text = title,
        fontSize = sizeTitle,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = style,
        onTextLayout = { tlr ->
            heightPx = tlr.size.height.toFloat()
        }
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 400)
private fun Preview() {
    MaterialTheme {
        Title()
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 300)
private fun Preview2() {
    MaterialTheme {
        Title(title = "Bug Bash 123")
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF, widthDp = 350, locale = "af")
private fun Preview3() {
    MaterialTheme {
        Title()
    }
}