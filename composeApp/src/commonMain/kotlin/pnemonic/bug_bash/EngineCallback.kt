package pnemonic.bug_bash

import pnemonic.bug_bash.model.bug.Bug

interface EngineCallback {
    fun touch(bug: Bug)
    suspend fun bash(bug: Bug)
    suspend fun notifyFeedback(feedback: Feedback)
}