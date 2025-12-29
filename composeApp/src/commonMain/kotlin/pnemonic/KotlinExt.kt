package pnemonic

fun <T> List<T>.copy(): List<T> {
    return ArrayList(this)
}
