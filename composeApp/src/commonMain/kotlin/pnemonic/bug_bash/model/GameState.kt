package pnemonic.bug_bash.model

enum class GameState {
    NOT_STARTED,
    STARTED,
    STOPPED,
    PAUSED,
    RESUMED,
    FINISHED;

    val isRunning get() = (this === STARTED) || (this === RESUMED)
    val isPaused get() = (this === PAUSED) || (this === STOPPED)
}