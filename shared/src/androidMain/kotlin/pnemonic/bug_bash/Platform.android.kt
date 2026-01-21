package pnemonic.bug_bash

import android.os.Build
import pnemonic.haptic.HapticManager

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val haptic: HapticManager = HapticManager
}

actual fun getPlatform(): Platform = AndroidPlatform()