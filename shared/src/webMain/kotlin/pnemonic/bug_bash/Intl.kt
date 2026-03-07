package pnemonic.bug_bash

import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.JsAny
import kotlin.js.JsName
import kotlin.js.definedExternally

@JsName("Intl")
external object Intl {
    @JsName("NumberFormat")
    @OptIn(ExperimentalWasmJsInterop::class)
    class NumberFormat(locale: String, options: JsAny? = definedExternally) {
        // A Number, BigInt, or string, to format.
        @JsName("format")
        fun format(number: JsAny): String
    }
}