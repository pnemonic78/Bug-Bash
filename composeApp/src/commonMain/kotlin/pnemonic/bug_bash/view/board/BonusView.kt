package pnemonic.bug_bash.view.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.VoidCallback
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.view.theme.panel
import pnemonic.bug_bash.drawable.Bonus as BonusImage

private val sizeIcon = 30.dp
private val sizeBonus = 32.dp

typealias BonusCallback = (Bonus) -> Unit

@Composable
fun BonusesView(modifier: Modifier = Modifier, bonuses: List<Bonus>, onClick: BonusCallback) {
    if (bonuses.isEmpty()) return

    Row(modifier = modifier.panel(), verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            imageVector = BonusImage,
            contentDescription = "🎁",
            modifier = Modifier.size(sizeIcon)
        )
        for (bonus in bonuses) {
            Spacer(modifier = Modifier.width(8.dp))
            BonusView(bonus, onClick)
        }
    }
}

@Composable
fun BonusView(bonus: Bonus, onBonusClick: BonusCallback) {
    val onClick = { onBonusClick(bonus) }

    when (bonus) {
        Bonus.None -> Unit
        Bonus.Flower -> BonusFlower(onClick)
        Bonus.Insecticide -> BonusInsecticide(onClick)
        Bonus.Life -> BonusLife(onClick)
        Bonus.RainbowSprinkles -> BonusRainbowSprinkles(onClick)
        Bonus.Shoe -> BonusShoe(onClick)
        Bonus.Swatter -> BonusSwatter(onClick)
        Bonus.Zapper -> BonusZapper(onClick)
    }
}

@Composable
private fun BonusFlower(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "🌼", fontSize = size)
}

@Composable
private fun BonusInsecticide(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "☠", fontSize = size)
}

@Composable
private fun BonusLife(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "💝", fontSize = size)
}

@Composable
private fun BonusRainbowSprinkles(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "🌈", fontSize = size)
}

@Composable
private fun BonusShoe(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "👞", fontSize = size)
}

@Composable
private fun BonusSwatter(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "🏸", fontSize = size)
}

@Composable
private fun BonusZapper(onClick: VoidCallback) {
    val size = with(LocalDensity.current) { sizeBonus.toSp() }
    Text(modifier = Modifier.clickable { onClick() }, text = "⚡", fontSize = size)
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        BonusesView(bonuses = Bonus.entries, onClick = {})
    }
}
