import androidx.compose.runtime.Immutable
import io.github.vinceglb.filekit.PlatformFile

    val addFile: (PlatformFile) -> Unit,
    val ask: (String) -> Unit,
    val cancel: () -> Unit,
    val clearHistory: () -> Unit,
    val clearSnackbar: () -> Unit,
    val clearUnreadHeartbeat: () -> Unit,
    val consumeComposerPrefill: () -> Unit,
    val deleteConversation: (String) -> Unit,
    val discardSmsDraft: (String) -> Unit,
    val enterInteractiveMode: () -> Unit,
    val exitInteractiveMode: () -> Unit,
    val goBackInteractiveMode: () -> Unit,
    val loadConversation: (String) -> Unit,
    val regenerate: () -> Unit,
    val removeFile: (PlatformFile) -> Unit,
    val resubmit: (messageId: String, event: String, data: Map<String, String>) -> Unit,
    val retry: () -> Unit,
    val selectService: (String) -> Unit,
    val sendSmsDraft: (String) -> Unit,
    val setIsSpeaking: (Boolean, String) -> Unit,
    val startNewChat: () -> Unit,
    val submitUiCallback: (event: String, data: Map<String, String>) -> Unit,
    val toggleSpeechOutput: () -> Unit,
    val undoDeleteConversation: () -> Unit,
)
@Immutable
data class ChatActions(
package com.inspiredandroid.kai.ui.chat
