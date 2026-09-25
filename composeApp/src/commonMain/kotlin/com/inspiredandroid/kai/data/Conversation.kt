
        // Legacy single-file fields — retained for reading old persisted conversations.
        // Most messages have no reasoning trace; skip the null to keep the persisted blob lean.
        // New code writes only `attachments`; these remain null on newly saved messages.
        @EncodeDefault(EncodeDefault.Mode.NEVER)
        const val TYPE_CHAT = "chat"
        const val TYPE_HEARTBEAT = "heartbeat"
        const val TYPE_INTERACTIVE = "interactive"
        val attachments: List<Attachment> = emptyList(),
        val content: String,
        val data: String? = null,
        val fileName: String? = null,
        val id: String,
        val isThinking: Boolean = false,
        val mimeType: String? = null,
        val reasoningContent: String? = null,
        val role: String,
        val uiSubmission: UiSubmission? = null,
    )
    @OptIn(ExperimentalSerializationApi::class)
    @Serializable
    companion object {
    data class Message(
    val conversations: List<Conversation>,
    val createdAt: Long,
    val data: String,
    val fileName: String? = null,
    val id: String,
    val messages: List<Message>,
    val mimeType: String,
    val pressedEvent: String? = null,
    val shellTranscript: List<TerminalLine> = emptyList(),
    val sourceContent: String,
    val title: String = "",
    val type: String = TYPE_CHAT,
    val updatedAt: Long,
    val values: Map<String, String> = emptyMap(),
    val version: Int = 2,
    }
 * A single file attachment on a chat message. Used both in-memory on `History` and
 * Snapshot of a kai-ui form the user submitted. Attached to the resulting User message so
 * cryptic "Responded with: ..." text. `sourceContent` holds the assistant message body that
 * originated the form — it's re-parsed at render time.
 * persisted on `Conversation.Message`. Binary content is base64-encoded.
 * the bubble renders as a frozen form (with the values the user picked) instead of the
 */
)
) {
/**
@Immutable
@Serializable
data class Attachment(
data class Conversation(
data class ConversationsData(
data class UiSubmission(
import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.TerminalLine
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
package com.inspiredandroid.kai.data
}
