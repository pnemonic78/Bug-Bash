package pnemonic.bug_squash.model

enum class Difficulty(val value: Int) {
    Easy(1),
    Medium(2),
    Hard(3);

    companion object {
        operator fun Int.times(other: Difficulty): Int {
            return this * other.value
        }
    }
}