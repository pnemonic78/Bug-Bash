package pnemonic.bug_bash

import androidx.compose.ui.text.intl.Locale
import kotlin.test.Test
import kotlin.test.assertEquals

class SharedCommonTest {

    @Test
    fun `format number`() {
        val locale = Locale("en_US")
        val platform: Platform = getPlatform()

        assertEquals("0", platform.formatInteger(locale, 0))
        assertEquals("1", platform.formatInteger(locale, 1))
        assertEquals("10", platform.formatInteger(locale, 10))
        assertEquals("100", platform.formatInteger(locale, 100))
        assertEquals("1,000", platform.formatInteger(locale, 1_000))
        assertEquals("10,000", platform.formatInteger(locale, 10_000))
    }
}