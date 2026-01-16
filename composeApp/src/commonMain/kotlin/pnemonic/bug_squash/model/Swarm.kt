package pnemonic.bug_squash.model

data class Swarm(
    val bugs: List<Bug> = emptyList()
) : Iterable<Bug> {

    val size: Int get() = bugs.size

    fun isEmpty(): Boolean = bugs.isEmpty()

    override fun iterator(): Iterator<Bug> {
        return bugs.iterator()
    }

    fun remove(bug: Bug): Swarm {
        val bugs = bugs.toMutableList()
        bugs.remove(bug)
        return copy(bugs = bugs)
    }
}