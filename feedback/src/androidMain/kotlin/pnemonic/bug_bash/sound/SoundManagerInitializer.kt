package pnemonic.bug_bash.sound

import android.content.Context
import androidx.startup.Initializer

class SoundManagerInitializer: Initializer<SoundManager> {
    override fun create(context: Context): SoundManager {
        return SoundManager.initialize(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}