package pnemonic.bug_bash.model

import pnemonic.bug_bash.Feedback
import pnemonic.bug_bash.sound.SoundType

enum class Scene(val music: Feedback.Sound) {
    Kitchen(SoundType.Kitchen),
    Table(SoundType.Table),
    Garden(SoundType.Garden);

    constructor(soundType: SoundType) : this(Feedback.Sound(soundType))

    operator fun plus(other: Int): Scene {
        val values = values()
        val index = (ordinal + other) % values.size
        return values[index]
    }

    fun next(): Scene {
        return this + 1
    }
}