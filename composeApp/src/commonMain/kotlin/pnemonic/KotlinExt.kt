package pnemonic

import kotlin.math.PI

fun <T> List<T>.copy(): List<T> {
    return ArrayList(this)
}

const val RADIANS_TO_DEGREES = (180.0 / PI).toFloat()

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