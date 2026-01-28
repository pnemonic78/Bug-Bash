package pnemonic.bug_bash.model

import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.bg_daisies
import bug_bash.composeapp.generated.resources.bg_grass_field_close
import bug_bash.composeapp.generated.resources.bg_marble
import bug_bash.composeapp.generated.resources.bg_sand
import bug_bash.composeapp.generated.resources.bg_wood_cloth
import bug_bash.composeapp.generated.resources.bg_wood_dark
import bug_bash.composeapp.generated.resources.bg_wood_rustic
import org.jetbrains.compose.resources.DrawableResource
import pnemonic.bug_bash.Feedback
import pnemonic.bug_bash.sound.SoundType

enum class Scene(val music: Feedback.Sound, val image: DrawableResource) {
    Grass(SoundType.Garden, Res.drawable.bg_grass_field_close),
    Garden(SoundType.Garden, Res.drawable.bg_daisies),
    Kitchen(SoundType.Kitchen, Res.drawable.bg_marble),
    TableCloth(SoundType.Table, Res.drawable.bg_wood_cloth),
    TableDark(SoundType.Table, Res.drawable.bg_wood_dark),
    TableRustic(SoundType.Table, Res.drawable.bg_wood_rustic),
    Beach(SoundType.Beach, Res.drawable.bg_sand);

    constructor(soundType: SoundType, image: DrawableResource) : this(
        Feedback.Sound(soundType),
        image
    )

    operator fun plus(other: Int): Scene {
        val values = values()
        val index = (ordinal + other) % values.size
        return values[index]
    }

    fun next(): Scene {
        return this + 1
    }
}