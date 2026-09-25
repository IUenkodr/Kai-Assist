import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

        is Command -> Command(newText)
        is Error -> Error(newText)
        is Output -> Output(newText)
    @SerialName("command")
    @SerialName("error")
    @SerialName("output")
    @Serializable
    data class Command(override val text: String) : TerminalLine
    data class Error(override val text: String) : TerminalLine
    data class Output(override val text: String) : TerminalLine
    fun withText(newText: String): TerminalLine = when (this) {
    val text: String
    }
@Immutable
@Serializable
package com.inspiredandroid.kai
sealed interface TerminalLine {
}
