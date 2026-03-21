package pnemonic.bug_bash.model

enum class Difficulty(val numerator: Int, val denominator: Int = 1) {
    Easy(1),
    Medium(3, 2),
    Hard(2);

    companion object {
        operator fun Int.times(other: Difficulty): Int {
            return (this * other.numerator) / other.denominator
        }

        operator fun Long.times(other: Difficulty): Long {
            return (this * other.numerator) / other.denominator
        }
    }
}