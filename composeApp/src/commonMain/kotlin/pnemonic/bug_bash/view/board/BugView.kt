package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import pnemonic.bug_bash.model.Ant
import pnemonic.bug_bash.model.Bee
import pnemonic.bug_bash.model.Beetle
import pnemonic.bug_bash.model.Bug
import pnemonic.bug_bash.model.Butterfly
import pnemonic.bug_bash.model.Caterpillar
import pnemonic.bug_bash.model.Centipede
import pnemonic.bug_bash.model.Cockroach
import pnemonic.bug_bash.model.Cricket
import pnemonic.bug_bash.model.Dragonfly
import pnemonic.bug_bash.model.Fly
import pnemonic.bug_bash.model.Ladybug
import pnemonic.bug_bash.model.Mosquito
import pnemonic.bug_bash.model.Moth
import pnemonic.bug_bash.model.Scorpion
import pnemonic.bug_bash.model.Snail
import pnemonic.bug_bash.model.Spider
import pnemonic.bug_bash.model.Termite
import pnemonic.bug_bash.model.Wasp
import pnemonic.bug_bash.model.Worm
import kotlin.math.roundToInt

typealias BugCallback = (Bug) -> Unit

const val animationDuration = 1000

@Composable
fun BugView(bug: Bug, onSize: BugCallback, onTap: BugCallback, onDead: BugCallback) {
    when (bug) {
        is Ant -> AntView(bug, onSize, onTap, onDead)
        is Bee -> BeeView(bug, onSize, onTap, onDead)
        is Beetle -> BeetleView(bug, onSize, onTap, onDead)
        is Butterfly -> ButterflyView(bug, onSize, onTap, onDead)
        is Caterpillar -> CaterpillarView(bug, onSize, onTap, onDead)
        is Centipede -> CentipedeView(bug, onSize, onTap, onDead)
        is Cockroach -> CockroachView(bug, onSize, onTap, onDead)
        is Cricket -> CricketView(bug, onSize, onTap, onDead)
        is Dragonfly -> DragonflyView(bug, onSize, onTap, onDead)
        is Fly -> FlyView(bug, onSize, onTap, onDead)
        is Ladybug -> LadybugView(bug, onSize, onTap, onDead)
        is Mosquito -> MosquitoView(bug, onSize, onTap, onDead)
        is Moth -> MothView(bug, onSize, onTap, onDead)
        is Scorpion -> ScorpionView(bug, onSize, onTap, onDead)
        is Snail -> SnailView(bug, onSize, onTap, onDead)
        is Spider -> SpiderView(bug, onSize, onTap, onDead)
        is Termite -> TermiteView(bug, onSize, onTap, onDead)
        is Wasp -> WaspView(bug, onSize, onTap, onDead)
        is Worm -> WormView(bug, onSize, onTap, onDead)
    }
}

@Composable
fun ImageBug(
    bug: Bug,
    image: ImageVector,
    onSize: BugCallback,
    onTap: BugCallback,
    onDead: BugCallback,
    modifier: Modifier = Modifier
) {
    ImageBug(
        bug = bug,
        image = image,
        scale = 1f,
        onSize = onSize,
        onTap = onTap,
        onDead = onDead,
        modifier = modifier
    )
}

@Composable
fun ImageBug(
    bug: Bug,
    image: ImageVector,
    scale: Float,
    onSize: BugCallback,
    onTap: BugCallback,
    onDead: BugCallback,
    modifier: Modifier = Modifier
) {
    val width = image.defaultWidth * scale
    val height = image.defaultHeight * scale
    val animatedOpacity by animateFloatAsState(
        targetValue = bug.opacity,
        animationSpec = tween(durationMillis = animationDuration)
    ) {
        if (bug.isSquashed) {
            onDead(bug)
        }
    }

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
            Box(modifier = Modifier.fillMaxSize().background(Color.Red.copy(alpha = 0.5f)))
        }
    }
}