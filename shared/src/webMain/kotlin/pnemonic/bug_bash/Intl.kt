package pnemonic.bug_bash

import kotlin.js.JsName
import kotlin.js.definedExternally

@JsName("Intl")
external object Intl {
    @JsName("NumberFormat")
    class NumberFormat(locale: String, options: dynamic = definedExternally) {
        fun format(number: Number): String
    }
}