package pnemonic

import kotlin.math.PI
import androidx.compose.runtime.State

fun <T> List<T>.copy(): List<T> {
    return ArrayList(this)
}

const val DEGREES_TO_RADIANS = (PI / 180.0).toFloat()
const val RADIANS_TO_DEGREES = (180.0 / PI).toFloat()

fun Float.toRadians(): Float = this * DEGREES_TO_RADIANS

typealias BooleanCallback = (Boolean) -> Unit
typealias VoidCallback = () -> Unit

fun <T> List<T>.remove(item: T): List<T> {
    val list = toMutableList()
    list.remove(item)
    return list
}

fun <T> List<T>.removeAll(items: Collection<T>): List<T> {
    val list = toMutableList()
    list.removeAll(items)
    return list
}

fun <T> List<T>.addAll(items: Collection<T>): List<T> {
    val list = toMutableList()
    list.addAll(items)
    return list
}

fun <T> List<T>.add(item: T): List<T> {
    val list = toMutableList()
    list.add(item)
    return list
}

val Int.half: Int get() = this / 2

val Float.half: Float get() = this * 0.5f

fun <T> stateOf(value: T): State<T> {
    return SingleState(value)
}

private class SingleState<T>(override val value: T): State<T>