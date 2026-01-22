package pnemonic.bug_bash

import android.os.Build
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
}

actual fun getPlatform(): Platform = AndroidPlatform()