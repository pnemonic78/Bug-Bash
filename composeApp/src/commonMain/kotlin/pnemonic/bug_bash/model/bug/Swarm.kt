package pnemonic.bug_bash.model.bug

import pnemonic.remove

data class Swarm(
    val bugs: List<Bug> = emptyList()
) : Iterable<Bug> {

    val size: Int get() = bugs.size

    fun isEmpty(): Boolean = bugs.isEmpty()

    override fun iterator(): Iterator<Bug> {
        return bugs.iterator()
    }

    fun remove(bug: Bug): Swarm {
        return copy(bugs = bugs.remove(bug))
    }
}