package pnemonic.haptic

import android.content.Context
import androidx.startup.Initializer

class HapticManagerInitializer: Initializer<HapticManager> {
    override fun create(context: Context): HapticManager {
        return HapticManager.initialize(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}