package pnemonic.bug_bash.view.board

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
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
import pnemonic.bug_bash.view.theme.Gold
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

typealias BugCallback = (Bug) -> Unit

private const val animationDuration = 300

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
    val animatedOpacity by animateFloatAsState(
        targetValue = bug.opacity,
        animationSpec = tween(durationMillis = animationDuration)
    )

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
            }
            .clickable { onTap(bug) }
    ) {
        Image(
            modifier = Modifier.fillMaxSize()
                .alpha(animatedOpacity),
            imageVector = image,
            contentDescription = bug.description,
            contentScale = ContentScale.Fit
        )
        if (bug.isSquashed) {
            //TODO Animate squish
        }
    }
    if (bug.isSquashed) {
        Score(bug, boardSize)
    }
}

private val sizeScore = 30.sp
private val colorScoreGood = Gold
private val colorScoreBad = Color.Red

@Composable
private fun Score(bug: Bug, boardSize: Size) {
    val score = bug.score
    val color = if (score >= 0) colorScoreGood else colorScoreBad
    val text = if (score >= 0) "+$score" else "-$score"
    val style: TextStyle = MaterialTheme.typography.bodyLarge.copy(
        color = color,
        fontSize = sizeScore,
        fontWeight = FontWeight.Medium,
        textMotion = TextMotion.Animated
    )

    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val textLayoutResult: TextLayoutResult = remember(text, style, density) {
        textMeasurer.measure(
            text = text,
            style = style,
            constraints = Constraints() // Use default or specific constraints
        )
    }
    val textSize = textLayoutResult.size.toSize()

    val textX = min(
        max(0f, bug.left + (bug.width / 2) - (textSize.width / 2)),
        boardSize.width - textSize.width
    )
    val textY = min(
        max(0f, bug.top + (bug.height / 2) - (textSize.height / 2)),
        boardSize.height - textSize.height
    )

    val scale = remember { Animatable(0.1f) }
    LaunchedEffect(bug) {
        scale.animateTo(1f, animationSpec = tween(durationMillis = 1000, easing = EaseOutElastic))
    }

    Text(
        modifier = Modifier.graphicsLayer {
            translationX = textX
            translationY = textY
            scaleX = scale.value
            scaleY = scale.value
            transformOrigin = TransformOrigin.Center
        },
        text = text,
        style = style
    )
}