package pnemonic.bug_bash

import androidx.compose.ui.text.intl.Locale
import com.russhwolf.settings.Settings
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
    override val settings: Settings by lazy { Settings() }

    private val formatters = mutableMapOf<String, Intl.NumberFormat>()

    @OptIn(ExperimentalWasmJsInterop::class)
    override fun formatInteger(locale: Locale, number: Long): String {
        val languageTag = locale.platformLocale.toString()
        val formatter = formatters.getOrPut(languageTag) { Intl.NumberFormat(languageTag) }
        return formatter.format(number.toJsBigInt())
    }
}

actual fun getPlatform(): Platform = WasmPlatform()