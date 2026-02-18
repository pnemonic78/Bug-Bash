package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun BugView(
    bug: Bug,
    boardSize: Size,
    onSize: BugCallback,
    onTap: BugCallback
) {
    when (bug) {
        is Ant -> AntView(bug, boardSize, onSize, onTap)
        is Bee -> BeeView(bug, boardSize, onSize, onTap)
        is Beetle -> BeetleView(bug, boardSize, onSize, onTap)
        is Butterfly -> ButterflyView(bug, boardSize, onSize, onTap)
        is Caterpillar -> CaterpillarView(bug, boardSize, onSize, onTap)
        is Centipede -> CentipedeView(bug, boardSize, onSize, onTap)
        is Cockroach -> CockroachView(bug, boardSize, onSize, onTap)
        is Cricket -> CricketView(bug, boardSize, onSize, onTap)
        is Dragonfly -> DragonflyView(bug, boardSize, onSize, onTap)
        is Fly -> FlyView(bug, boardSize, onSize, onTap)
        is Ladybug -> LadybugView(bug, boardSize, onSize, onTap)
        is Mosquito -> MosquitoView(bug, boardSize, onSize, onTap)
        is Moth -> MothView(bug, boardSize, onSize, onTap)
        is Scorpion -> ScorpionView(bug, boardSize, onSize, onTap)
        is Snail -> SnailView(bug, boardSize, onSize, onTap)
        is Spider -> SpiderView(bug, boardSize, onSize, onTap)
        is Termite -> TermiteView(bug, boardSize, onSize, onTap)
        is Wasp -> WaspView(bug, boardSize, onSize, onTap)
        is Worm -> WormView(bug, boardSize, onSize, onTap)
    }
}

@Composable
fun ImageBug(
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
                alpha = animatedOpacity
            }
            .clickable { onTap(bug) }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = image,
            contentDescription = bug.description,
            contentScale = ContentScale.Fit
        )
        if (bug.isSquashed) {
            //TODO Animate squish
        }
    }
    BugScore(bug, boardSize)
}
