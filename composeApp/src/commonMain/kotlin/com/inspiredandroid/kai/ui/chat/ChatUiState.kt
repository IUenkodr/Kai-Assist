package com.inspiredandroid.kai.ui.chat
import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.data.Attachment
import com.inspiredandroid.kai.data.FallbackStatus
import com.inspiredandroid.kai.data.ReasoningRequestMode
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.SharedJson
import com.inspiredandroid.kai.data.SmsDraft
import com.inspiredandroid.kai.data.UiSubmission
import com.inspiredandroid.kai.network.UiError
import com.inspiredandroid.kai.network.dtos.gemini.GeminiChatRequestDto
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import io.github.vinceglb.filekit.PlatformFile
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import org.jetbrains.compose.resources.StringResource

                                            put("data", att.data)
                                            put("media_type", "application/pdf")
                                            put("media_type", att.mimeType)
                                            put("type", "base64")
                                        "source",
                                        args = args,
                                        buildJsonObject {
                                        name = tc.name,
                                        put("url", "data:${att.mimeType};base64,${att.data}")
                                        },
                                    "image_url",
                                    )
                                    ),
                                    buildJsonObject {
                                    data = att.data,
                                    functionCall = GeminiChatRequestDto.FunctionCall(
                                    mime_type = att.mimeType,
                                    put(
                                    put("type", "document")
                                    put("type", "image")
                                    thoughtSignature = tc.thoughtSignature,
                                    },
                                )
                                ),
                                GeminiChatRequestDto.Part(
                                buildJsonObject {
                                if (parsed is JsonObject) LinkedHashMap(parsed) else null
                                inline_data = GeminiChatRequestDto.InlineData(
                                name = toolName ?: "unknown",
                                null
                                put(
                                put("id", tc.id)
                                put("input", SharedJson.parseToJsonElement(tc.arguments))
                                put("name", tc.name)
                                put("text", content)
                                put("type", "image_url")
                                put("type", "text")
                                put("type", "tool_use")
                                response = responseContent,
                                val parsed = geminiJsonParser.parseToJsonElement(tc.arguments)
                                },
                            )
                            ),
                            // Explicitly convert to LinkedHashMap to avoid serialization issues with JsonObject
                            GeminiChatRequestDto.Part(
                            LinkedHashMap(parsed)
                            add(
                            arguments = tc.arguments,
                            buildJsonObject {
                            functionResponse = GeminiChatRequestDto.FunctionResponse(
                            mapOf("result" to JsonPrimitive(content))
                            name = tc.name,
                            put("text", fullText)
                            put("type", "text")
                            val args: Map<String, JsonElement>? = try {
                            }
                            } catch (e: Exception) {
                            },
                        )
                        ),
                        GeminiChatRequestDto.Part(
                        add(
                        add(GeminiChatRequestDto.Part(text = content))
                        buildJsonObject {
                        for (tc in toolCalls) {
                        function = OpenAICompatibleChatRequestDto.FunctionCall(
                        id = tc.id,
                        if (att.mimeType == "application/pdf") {
                        if (parsed is JsonObject) {
                        mapOf("result" to JsonPrimitive(content))
                        val parsed = geminiJsonParser.parseToJsonElement(content)
                        }
                        } else {
                        },
                    )
                    // Explicitly convert to LinkedHashMap to avoid serialization issues with JsonObject
                    // Handle assistant messages with tool calls
                    // Regular user message with potential inline data (images / PDFs)
                    // Send tool result as functionResponse
                    OpenAICompatibleChatRequestDto.ToolCall(
                    add(
                    add(GeminiChatRequestDto.Part(text = "${split.textPrefix}$content"))
                    for (att in imageAttachments) {
                    for (att in split.binaries) {
                    for (tc in toolCalls) {
                    if (content.isNotEmpty()) {
                    if (toolCalls != null) {
                    put("content", content)
                    put("tool_use_id", toolCallId ?: "")
                    put("type", "tool_result")
                    val responseContent: Map<String, JsonElement> = try {
                    val split = attachments.splitForMessage()
                    }
                    } catch (e: Exception) {
                History.Role.ASSISTANT -> {
                History.Role.TOOL -> {
                ReasoningRequestMode.NONE -> null
                ReasoningRequestMode.REASONING_CONTENT -> reasoningContent
                buildJsonObject {
                buildList {
                content = realContent,
                else -> {
                reasoningContent = emittedReasoning,
                role = "assistant",
                tool_calls = toolCalls.map { tc ->
                }
                },
            )
            ),
            // (the provider returned no real content). Don't send it as `content`; it will
            // When isThinking is true, History.content actually holds the reasoning text
            // be carried by reasoning_content instead.
            JsonArray(
            JsonPrimitive(content)
            JsonPrimitive(fullText)
            OpenAICompatibleChatRequestDto.Message(
            OpenAICompatibleChatRequestDto.Message(role = "assistant", content = JsonPrimitive(content))
            binaries.add(att)
            emptyList()
            if (att.fileName != null) prefix.append("--- ${att.fileName} ---\n")
            listOf(
            prefix.append(decoded).append("\n\n")
            split.binaries.filter { it.mimeType.startsWith("image/") }
            val decoded = Base64.decode(att.data).decodeToString()
            val emittedReasoning = when (reasoningMode) {
            val realContent = if (isThinking || content.isEmpty()) null else JsonPrimitive(content)
            when (role) {
            }
        )
        // Groq fallback uses text-only models), drop images and emit a plain string.
        // Images become image_url parts; PDFs are dropped (OpenAI-compatible has no native PDF
        // Tool results are sent as user role with functionResponse
        // When the target service can't accept content-parts (e.g. the kai9000 proxy whose
        // support, matching the prior behavior). Text files get merged into the text prefix.
        ASSISTANT,
        History.Role.ASSISTANT, History.Role.TOOL_EXECUTING -> "model"
        History.Role.TOOL -> "user"
        History.Role.USER -> "user"
        JsonArray(
        OpenAICompatibleChatRequestDto.Message(role = "user", content = messageContent)
        TOOL,
        TOOL_EXECUTING,
        USER,
        content = JsonPrimitive(content),
        get() = savedConversations.firstOrNull { it.isHeartbeat }?.id
        if (att.mimeType.isTextMimeType()) {
        if (split.binaries.isEmpty()) {
        if (toolCalls != null) {
        parts = buildList {
        role = "tool",
        role = geminiRole,
        tool_call_id = toolCallId,
        val fullText = "${split.textPrefix}$content"
        val imageAttachments = if (supportsImages) {
        val messageContent: JsonElement = if (imageAttachments.isEmpty()) {
        val split = attachments.splitForMessage()
        }
        } else {
        },
    )
    // Gemini uses "user" for tool responses (functionResponse), not "tool"
    // Preserved from a tool-call assistant turn so it can be round-tripped
    // back to providers (e.g. DeepSeek) that require it on the next request.
    History.Role.ASSISTANT -> {
    History.Role.TOOL -> OpenAICompatibleChatRequestDto.Message(
    History.Role.TOOL -> {
    History.Role.TOOL_EXECUTING -> JsonPrimitive(content)
    History.Role.TOOL_EXECUTING -> OpenAICompatibleChatRequestDto.Message(role = "assistant", content = JsonPrimitive(content))
    History.Role.USER -> {
    enum class Role {
    for (att in this) {
    if (isEmpty()) return AttachmentSplit("", emptyList())
    reasoningMode: ReasoningRequestMode = ReasoningRequestMode.NONE,
    return AttachmentSplit(prefix.toString(), binaries)
    return GeminiChatRequestDto.Content(
    supportsImages: Boolean = true,
    this == "application/javascript" || this == "application/x-yaml" || this == "application/yaml"
    val actions: ChatActions,
    val arguments: String,
    val attachments: ImmutableList<Attachment> = persistentListOf(),
    val availableServices: ImmutableList<ServiceEntry> = persistentListOf(),
    val binaries = mutableListOf<Attachment>()
    val binaries: List<Attachment>,
    val composerPrefill: String? = null,
    val content: String,
    val currentConversationId: String? = null,
    val error: UiError? = null,
    val fallbackServiceName: String? = null,
    val fallbackStatus: FallbackStatus? = null,
    val files: ImmutableList<PlatformFile> = persistentListOf(),
    val geminiRole = when (role) {
    val hasUnreadHeartbeat: Boolean = false,
    val heartbeatConversationId: String?
    val history: ImmutableList<History> = persistentListOf(),
    val id: String = Uuid.random().toString(),
    val id: String,
    val installedSkills: ImmutableList<com.inspiredandroid.kai.skills.SkillManifest> = persistentListOf(),
    val isHeartbeat: Boolean = false,
    val isInteractive: Boolean = false,
    val isInteractiveMode: Boolean = false,
    val isLoading: Boolean = false,
    val isRestoring: Boolean = true,
    val isSpeaking: Boolean = false,
    val isSpeakingContentId: String = "",
    val isSpeechOutputEnabled: Boolean = false,
    val isStatusMessage: Boolean = false,
    val isThinking: Boolean = false,
    val name: String,
    val pendingConversationDeletion: String? = null,
    val prefix = StringBuilder()
    val reasoningContent: String? = null,
    val role: Role,
    val savedConversations: ImmutableList<ConversationSummary> = persistentListOf(),
    val showFreeProviderSuggestions: Boolean = false,
    val showPrivacyInfo: Boolean = false,
    val smsDrafts: ImmutableList<SmsDraft> = persistentListOf(),
    val snackbarMessage: StringResource? = null,
    val supportedFileExtensions: ImmutableList<String> = persistentListOf(),
    val textPrefix: String,
    val thoughtSignature: String? = null,
    val title: String,
    val toolCallId: String? = null,
    val toolCalls: ImmutableList<ToolCallInfo>? = null,
    val toolName: String? = null,
    val uiSubmission: UiSubmission? = null,
    val updatedAt: Long,
    val warning: StringResource? = null,
    }
 * (decoded text files with filename headers) and the remaining binary attachments
 * (images, PDFs) that become standalone content blocks in provider-specific formats.
 * Splits attachments into the text that should be prepended to the user's message
 */
)
) {
): OpenAICompatibleChatRequestDto.Message = when (role) {
/**
/** Latest assistant message that should render in the UI (non-empty content, not a thinking-only entry). */
@Immutable
@file:OptIn(ExperimentalUuidApi::class, ExperimentalEncodingApi::class)
data class ChatUiState(
data class ConversationSummary(
data class History(
data class ToolCallInfo(
fun History.toAnthropicContentBlocks(): JsonElement = when (role) {
fun History.toGeminiMessageDto(): GeminiChatRequestDto.Content {
fun History.toGroqMessageDto(
fun List<History>.lastRenderedAssistant(): History? = lastOrNull { it.role == History.Role.ASSISTANT && it.content.isNotEmpty() && !it.isThinking }
private data class AttachmentSplit(
private fun List<Attachment>.splitForMessage(): AttachmentSplit {
private fun String.isTextMimeType(): Boolean = startsWith("text/") || this == "application/json" || this == "application/xml" ||
private val geminiJsonParser = SharedJson
}
