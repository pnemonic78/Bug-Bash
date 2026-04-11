package pnemonic.bug_bash

import androidx.compose.ui.graphics.Color
import pnemonic.compose.lighten
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun lighten() {
        val dark = Color(0xFF6897D3)

        val same = dark.lighten(0.0f)
        assertEquals(dark, same)

        //val light = Color(0xFFBAE3F6)
        val light = Color(0xFFC4D7EE)
        val lighter = dark.lighten(0.234f)
        assertEquals(light, lighter)
    }
}