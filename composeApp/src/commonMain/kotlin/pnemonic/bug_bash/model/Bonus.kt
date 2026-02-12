package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

enum class Bonus(val score: Int, val hits: Int, val sound: SoundType) {
    None(score = 0, hits = 0, sound = SoundType.None),
    Flower(score = 100, hits = 1, sound = SoundType.Pop),
    Insecticide(score = 1000, hits = 2, sound = SoundType.Spray),
    Life(score = 20, hits = 0, sound = SoundType.Kiss),
    RainbowSprinkles(score = 100, hits = -1, sound = SoundType.Chips),
    Shoe(score = 100, hits = 5, sound = SoundType.Drop),
    Swatter(score = 100, hits = 5, sound = SoundType.Swish),
    Zapper(score = 100, hits = 4, sound = SoundType.Laser)
}