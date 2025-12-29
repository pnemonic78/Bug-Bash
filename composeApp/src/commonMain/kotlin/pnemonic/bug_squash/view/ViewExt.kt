package pnemonic.bug_squash.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize

typealias OnSizeCallback = (IntSize) -> Unit
typealias OnTapCallback = (Offset) -> Unit

//@ReadOnlyComposable
//@Composable
//fun <Density, R> withDensity(block: Density.() -> R): R = with(LocalDensity.current, block)

@ReadOnlyComposable
@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { this@toPx.toPx() }

@ReadOnlyComposable
@Composable
fun Float.toDp(): Dp = with(LocalDensity.current) { this@toDp.toDp() }
