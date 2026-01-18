package pnemonic.bug_squash.model

enum class Scene {
    Kitchen,
    Table,
    Garden;

    operator fun plus(other: Int): Scene {
        val values = values()
        val index = (ordinal + other) % values.size
        return values[index]
    }

    fun next(): Scene {
        return this + 1
    }
}