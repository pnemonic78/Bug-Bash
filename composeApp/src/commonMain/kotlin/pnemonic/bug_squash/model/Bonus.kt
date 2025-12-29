package pnemonic.bug_squash.model

enum class Bonus(val hits: Int) {
    None(0),
    Flower(1),
    Insecticide(2),
    Shoe(5),
    RainbowSprinkles(-1),
    Swatter(5),
    Zapper(4)
}