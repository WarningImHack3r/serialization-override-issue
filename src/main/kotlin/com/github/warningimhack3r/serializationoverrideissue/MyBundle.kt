package com.github.warningimhack3r.serializationoverrideissue

import com.intellij.DynamicBundle
import kotlinx.serialization.json.Json
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey

@NonNls
private const val BUNDLE = "messages.MyBundle"

object MyBundle : DynamicBundle(BUNDLE) {

    fun test() {
        Json {
            // Lax parsing (unquoted keys, formatting, etc.)
            isLenient = true
            // Allow trailing commas (1.6.1+)
            allowTrailingComma = true
            // Allow comments (1.7.0+)
            allowComments = true
        }
    }

    @JvmStatic
    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
        getMessage(key, *params)

    @Suppress("unused")
    @JvmStatic
    fun messagePointer(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
        getLazyMessage(key, *params)
}
