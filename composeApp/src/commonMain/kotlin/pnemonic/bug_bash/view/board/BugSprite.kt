package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import pnemonic.bug_bash.model.bug.Ant
import pnemonic.bug_bash.model.bug.Bee
import pnemonic.bug_bash.model.bug.Beetle
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Butterfly
import pnemonic.bug_bash.model.bug.Caterpillar
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.bug_bash.model.bug.Cockroach
import pnemonic.bug_bash.model.bug.Cricket
import pnemonic.bug_bash.model.bug.Dragonfly
import pnemonic.bug_bash.model.bug.Fly
import pnemonic.bug_bash.model.bug.Ladybug
import pnemonic.bug_bash.model.bug.Mosquito
import pnemonic.bug_bash.model.bug.Moth
import pnemonic.bug_bash.model.bug.Scorpion
import pnemonic.bug_bash.model.bug.Snail
import pnemonic.bug_bash.model.bug.Spider
import pnemonic.bug_bash.model.bug.Termite
import pnemonic.bug_bash.model.bug.Wasp
import pnemonic.bug_bash.model.bug.Worm
import kotlin.math.roundToInt

typealias BugCallback = (Bug) -> Unit

@Composable
fun BugSprite(
    bug: Bug,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    when (bug) {
        is Ant -> AntSprite(bug, boardSize, onSize, onTap)
        is Bee -> BeeSprite(bug, boardSize, onSize, onTap)
        is Beetle -> BeetleSprite(bug, boardSize, onSize, onTap)
        is Butterfly -> ButterflySprite(bug, boardSize, onSize, onTap)
        is Caterpillar -> CaterpillarSprite(bug, boardSize, onSize, onTap)
        is Centipede -> CentipedeSprite(bug, boardSize, onSize, onTap)
        is Cockroach -> CockroachSprite(bug, boardSize, onSize, onTap)
        is Cricket -> CricketSprite(bug, boardSize, onSize, onTap)
        is Dragonfly -> DragonflySprite(bug, boardSize, onSize, onTap)
        is Fly -> FlySprite(bug, boardSize, onSize, onTap)
        is Ladybug -> LadybugSprite(bug, boardSize, onSize, onTap)
        is Mosquito -> MosquitoSprite(bug, boardSize, onSize, onTap)
        is Moth -> MothSprite(bug, boardSize, onSize, onTap)
        is Scorpion -> ScorpionSprite(bug, boardSize, onSize, onTap)
        is Snail -> SnailSprite(bug, boardSize, onSize, onTap)
        is Spider -> SpiderSprite(bug, boardSize, onSize, onTap)
        is Termite -> TermiteSprite(bug, boardSize, onSize, onTap)
        is Wasp -> WaspSprite(bug, boardSize, onSize, onTap)
        is Worm -> WormSprite(bug, boardSize, onSize, onTap)
    }
}

@Composable
fun BugSprite(
    bug: Bug,
    boardSize: Size,
    image: ImageVector,
    scale: Float,
    onSize: BugCallback,
    onTap: BugCallback,
    modifier: Modifier = Modifier
) {
    val width = image.defaultWidth * scale
    val height = image.defaultHeight * scale
    val sx by animateFloatAsState(targetValue = if (bug.isSquashed) 1.25f else 1f)
    val sy by animateFloatAsState(targetValue = if (bug.isSquashed) 1.15f else 1f)
    val animatedOpacity by animateFloatAsState(targetValue = bug.opacity)

    Box(
        modifier = modifier
            .size(width, height)
            .onSizeChanged { size ->
                val oldWidth = bug.width.roundToInt()
                val oldHeight = bug.height.roundToInt()
                if ((oldWidth != size.width) || (oldHeight != size.height)) {
                    bug.setSize(size)
                    onSize(bug)
                }
            }
            .graphicsLayer {
                translationX = bug.left
                translationY = bug.top
                rotationZ = bug.rotation
                scaleX = sx
                scaleY = sy
                alpha = animatedOpacity
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onTap(bug)
            }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = image,
            contentDescription = bug.description,
            contentScale = ContentScale.Fit
        )
    }
    BugScore(bug, boardSize)
}
