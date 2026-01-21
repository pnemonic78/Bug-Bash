package pnemonic.bug_bash.model

enum class Bonus(val hits: Int) {
    None(0),
    Flower(1),
    Insecticide(2),
    Life(0),
    Shoe(5),
    RainbowSprinkles(-1),
    Swatter(5),
    Zapper(4)
}