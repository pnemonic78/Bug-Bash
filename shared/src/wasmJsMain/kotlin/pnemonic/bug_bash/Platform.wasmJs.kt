package pnemonic.bug_bash

import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
}

actual fun getPlatform(): Platform = WasmPlatform()