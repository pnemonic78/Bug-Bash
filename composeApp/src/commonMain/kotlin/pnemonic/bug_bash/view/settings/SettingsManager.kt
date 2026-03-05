package pnemonic.bug_bash.view.settings

import com.russhwolf.settings.Settings
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.Difficulty

object SettingsManager {
    private const val KEY_MUSIC = "settings.music"
    private const val KEY_SOUND = "settings.sound"
    private const val KEY_DIFFICULTY = "settings.difficulty"

    private val platform: Platform = getPlatform()
    private val settings: Settings get() = platform.settings

    var isMusicEnabled: Boolean
        get() = settings.getBoolean(KEY_MUSIC, true)
        set(value) {
            settings.putBoolean(KEY_MUSIC, value)
        }

    var isSoundEnabled: Boolean
        get() = settings.getBoolean(KEY_SOUND, true)
        set(value) {
            settings.putBoolean(KEY_SOUND, value)
        }

    var difficulty: Difficulty
        get() {
            val ordinal = settings.getInt(KEY_DIFFICULTY, 0)
            return Difficulty.values()[ordinal]
        }
        set(value) {
            settings.putInt(KEY_DIFFICULTY, value.ordinal)
        }
}