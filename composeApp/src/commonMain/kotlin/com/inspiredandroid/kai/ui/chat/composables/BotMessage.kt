
                                // Expected interruption - no action needed
                                // Handle TTS errors gracefully (service failure, audio issues, etc.)
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodySmall,
                                text = segment,
                                textToSpeech.say(text = message.toSpeakableText())
                            )
                            .padding(start = 16.dp, top = answerTopPadding, end = 16.dp, bottom = 8.dp),
                            Text(
                            color = MaterialTheme.colorScheme.outlineVariant,
                            modifier = Modifier.fillMaxHeight(),
                            setIsSpeaking(false)
                            setIsSpeaking(true)
                            thickness = 2.dp,
                            try {
                            }
                            } catch (e: Exception) {
                            } catch (ignore: TextToSpeechSynthesisInterruptedError) {
                        )
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp),
                        SelectionContainer(modifier = Modifier.padding(start = 10.dp)) {
                        VerticalDivider(
                        document = document,
                        frozen = effectiveFrozen,
                        if (isEditing) Res.string.chat_cancel_edit_content_description else Res.string.chat_edit_submission_content_description,
                        if (isSpeaking) {
                        isInteractive = effectiveInteractive,
                        modifier = Modifier.fillMaxWidth()
                        onUiCallback = kaiUiCallback,
                        textToSpeech.stop()
                        }
                        } else {
                    )
                    ),
                    .align(Alignment.TopEnd)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .clickable { isEditing = !isEditing },
                    .clip(CircleShape)
                    .handCursor()
                    .padding(8.dp)
                    .size(28.dp)
                    MarkdownContent(
                    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    componentScope.launch(getBackgroundDispatcher()) {
                    contentDescription = stringResource(
                    imageVector = if (isEditing) Icons.Default.Close else Icons.Default.Edit,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                    modifier = Modifier.size(16.dp),
                    modifier = Modifier.weight(1f).padding(start = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    segments = nonBlankSegments,
                    style = MaterialTheme.typography.bodySmall,
                    text = " · $preview",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    uriHandler.openUri("https://form.jotform.com/250014908169355")
                    }
                )
                .clickable { expanded = !expanded }
                .handCursor(),
                // When reasoning is shown above, the Thinking row already provides
                // the visual gap to the answer — drop the duplicated top inset.
                Icon(
                ReasoningBlockquote(
                SelectionContainer {
                Text(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                contentAlignment = Alignment.Center,
                contentDescription = stringResource(Res.string.bot_message_flag_content_description),
                contentDescription = stringResource(Res.string.bot_message_regenerate_content_description),
                contentDescription = stringResource(Res.string.bot_message_speech_content_description),
                contentDescription = stringResource(Res.string.bot_message_thinking_expand_content_description),
                for (segment in segments) {
                iconResource = Res.drawable.ic_flag,
                iconResource = Res.drawable.ic_refresh,
                iconResource = if (isSpeaking) Res.drawable.ic_stop else Res.drawable.ic_volume_up,
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                modifier = Modifier.padding(top = 6.dp),
                modifier = Modifier.size(16.dp),
                onClick = onRegenerate,
                onClick = {
                reasoningSegments.filter { it.isNotBlank() }.toImmutableList()
                style = MaterialTheme.typography.labelMedium,
                text = stringResource(Res.string.bot_message_thinking_label),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                val answerTopPadding = if (nonBlankSegments.isNotEmpty()) 6.dp else 16.dp
                verticalArrangement = Arrangement.spacedBy(6.dp),
                }
                },
            )
            ) {
            .orEmpty()
            ?.firstOrNull { it.isNotEmpty() }
            ?.lineSequence()
            ?.map { it.trim() }
            Box(
            Column(
            Icon(
            SmallIconButton(
            Spacer(Modifier.size(6.dp))
            Text(
            contentDescription = stringResource(Res.string.bot_message_copy_content_description),
            enter = expandVertically(),
            exit = shrinkVertically(),
            iconResource = Res.drawable.ic_copy,
            if (!expanded && preview.isNotEmpty()) {
            if (message.isNotEmpty()) {
            if (nonBlankSegments.isNotEmpty()) {
            isEditing = false
            modifier = Modifier.fillMaxWidth()
            onClick = { copyToClipboard(message) },
            onResubmit(event, data)
            val componentScope = rememberCoroutineScope()
            val nonBlankSegments = remember(reasoningSegments) {
            val uriHandler = LocalUriHandler.current
            verticalAlignment = Alignment.CenterVertically,
            visible = expanded,
            }
        )
        ) {
        AnimatedVisibility(
        Column(modifier = Modifier.fillMaxWidth()) {
        Row(
        SmallIconButton(
        Spacer(Modifier.weight(1f))
        if (frozen != null && onResubmit != null) {
        if (onRegenerate != null) {
        if (textToSpeech != null) {
        onUiCallback ?: { _, _ -> }
        run {
        segments.lastOrNull()
        val copyToClipboard = rememberCopyToClipboard()
        { event, data ->
        }
    // Preview always reflects the MOST RECENT thinking segment so the user gets a
    // visual update each time a new reasoning phase starts, without expanding.
    Box(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = modifier) {
    Row(Modifier.padding(horizontal = 8.dp)) {
    frozen: FrozenSubmission? = null,
    if (message.isEmpty()) return
    isInteractive: Boolean = false,
    isSpeaking: Boolean,
    message: String,
    modifier: Modifier = Modifier,
    onRegenerate: (() -> Unit)? = null,
    onResubmit: ((event: String, data: Map<String, String>) -> Unit)? = null,
    onUiCallback: ((event: String, data: Map<String, String>) -> Unit)? = null,
    reasoningSegments: ImmutableList<String> = persistentListOf(),
    segments: ImmutableList<String>,
    setIsSpeaking: (Boolean) -> Unit,
    textToSpeech: TextToSpeechInstance?,
    val document = remember(message) { parseMarkdown(message) }
    val effectiveFrozen = if (isEditing && frozen != null) frozen.copy(pressedEvent = null) else frozen
    val effectiveInteractive = if (frozen != null) (onResubmit != null && isEditing) else isInteractive
    val kaiUiCallback: (String, Map<String, String>) -> Unit = if (onResubmit != null) {
    val preview = remember(segments) {
    var expanded by remember { mutableStateOf(false) }
    var isEditing by remember(frozen) { mutableStateOf(false) }
    }
    } else {
) {
@Composable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.ui.dynamicui.FrozenSubmission
import com.inspiredandroid.kai.ui.dynamicui.toSpeakableText
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.markdown.MarkdownContent
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import com.inspiredandroid.kai.ui.rememberCopyToClipboard
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.bot_message_copy_content_description
import kai.composeapp.generated.resources.bot_message_flag_content_description
import kai.composeapp.generated.resources.bot_message_regenerate_content_description
import kai.composeapp.generated.resources.bot_message_speech_content_description
import kai.composeapp.generated.resources.bot_message_thinking_expand_content_description
import kai.composeapp.generated.resources.bot_message_thinking_label
import kai.composeapp.generated.resources.chat_cancel_edit_content_description
import kai.composeapp.generated.resources.chat_edit_submission_content_description
import kai.composeapp.generated.resources.ic_copy
import kai.composeapp.generated.resources.ic_flag
import kai.composeapp.generated.resources.ic_refresh
import kai.composeapp.generated.resources.ic_stop
import kai.composeapp.generated.resources.ic_volume_up
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.errors.TextToSpeechSynthesisInterruptedError
import org.jetbrains.compose.resources.stringResource
internal fun BotMessage(
package com.inspiredandroid.kai.ui.chat.composables
private fun ReasoningBlockquote(
}
