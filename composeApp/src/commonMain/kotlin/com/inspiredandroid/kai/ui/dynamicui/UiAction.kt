package com.inspiredandroid.kai.ui.dynamicui
import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

        get() = data?.mapValues { it.value.content }
    /** Returns data values coerced to strings (handles booleans/numbers from LLMs). */
    val collectFrom: List<String>? = null,
    val data: Map<String, JsonPrimitive>? = null,
    val dataAsStrings: Map<String, String>?
    val event: String = "",
    val targetId: String = "",
    val text: String = "",
    val url: String = "",
) : UiAction
) : UiAction {
@Immutable
@SerialName("callback")
@SerialName("copy_to_clipboard")
@SerialName("open_url")
@SerialName("toggle")
@Serializable
data class CallbackAction(
data class CopyToClipboardAction(
data class OpenUrlAction(
data class ToggleAction(
sealed interface UiAction
}
