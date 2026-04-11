package pnemonic.bug_bash.view.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.ic_hammer
import bug_bash.composeapp.generated.resources.play
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.GlossyButton
import pnemonic.bug_bash.view.GlowBox
import pnemonic.bug_bash.view.previewColor
import pnemonic.bug_bash.view.theme.Gold
import pnemonic.bug_bash.view.theme.LargeIconSpacing
import pnemonic.compose.lighten

private val colorContainer = Gold
private val colorContent = Gold.lighten(-0.3f)
private val colorShadow = Yellow
private val sizeShadow = 25.dp
private val sizeIconSpacing = LargeIconSpacing

@Composable
fun StartButton(modifier: Modifier = Modifier, onClick: VoidCallback) {
    GlowBox(
        modifier = modifier,
        sizeGlow = sizeShadow,
        colorGlow = colorShadow
    ) {
        GlossyButton(
            color = colorContainer,
            onClick = onClick,
        ) {
            Text(text = stringResource(Res.string.play), fontSize = 40.sp, color = colorContent)
            Spacer(modifier = Modifier.width(sizeIconSpacing))
            Icon(
                imageVector = vectorResource(Res.drawable.ic_hammer),
                contentDescription = "\uD83D\uDD28",
                modifier = Modifier.size(40.dp),
                tint = colorContent.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor)
private fun Preview() {
    MaterialTheme {
        StartButton {}
    }
}