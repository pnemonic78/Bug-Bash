package pnemonic

import kotlin.math.PI

fun <T> List<T>.copy(): List<T> {
    return ArrayList(this)
}

const val RADIANS_TO_DEGREES = (180.0 / PI).toFloat()
