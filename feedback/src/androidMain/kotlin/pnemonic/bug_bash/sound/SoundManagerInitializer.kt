package pnemonic.bug_bash.sound

import android.content.Context
import androidx.startup.Initializer

class SoundManagerInitializer : Initializer<SoundManager> {
    override fun create(context: Context): SoundManager {
        AudioPlayerFactory.initialize(context)
        return SoundManager
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}