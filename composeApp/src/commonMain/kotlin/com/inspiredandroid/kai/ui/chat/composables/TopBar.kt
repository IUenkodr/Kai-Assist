package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.chat.ChatActions
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.chat_history_content_description
import kai.composeapp.generated.resources.ic_add
import kai.composeapp.generated.resources.ic_history
import kai.composeapp.generated.resources.ic_settings
import kai.composeapp.generated.resources.ic_volume_off
import kai.composeapp.generated.resources.ic_volume_up
import kai.composeapp.generated.resources.new_chat_content_description
import kai.composeapp.generated.resources.sandbox_content_description
import kai.composeapp.generated.resources.settings_content_description
import kai.composeapp.generated.resources.toggle_speech_output_content_description
import nl.marc_apps.tts.TextToSpeechInstance
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

                    MaterialTheme.colorScheme.onBackground
                    MaterialTheme.colorScheme.primary
                    SpeechToggleButton(textToSpeech, isSpeechOutputEnabled, isSpeaking, actions)
                    actions.setIsSpeaking(false, "")
                    animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
                    contentDescription = stringResource(Res.string.settings_content_description),
                    imageVector = vectorResource(Res.drawable.ic_settings),
                    targetValue = 0f,
                    textToSpeech?.stop()
                    tint = MaterialTheme.colorScheme.onBackground,
                )
                Icon(
                LeadingButtons(textToSpeech, isSpeechOutputEnabled, isSpeaking, actions, isChatHistoryEmpty, hasSavedConversations, onShowHistory, isSandboxAvailable, isSandboxOpen, isShellExecuting, onToggleSandbox)
                SpeechToggleButton(textToSpeech, isSpeechOutputEnabled, isSpeaking, actions)
                actions.setIsSpeaking(false, "")
                actions.startNewChat()
                checkedContainerColor = if (flashAlpha.value > 0f) flashContainer else checkedContainer,
                checkedContentColor = MaterialTheme.colorScheme.primary,
                containerColor = flashContainer,
                contentDescription = stringResource(Res.string.chat_history_content_description),
                contentDescription = stringResource(Res.string.new_chat_content_description),
                contentDescription = stringResource(Res.string.sandbox_content_description),
                flashAlpha.animateTo(
                flashAlpha.snapTo(0.4f)
                if (isSpeechOutputEnabled && isSpeaking) {
                if (textToSpeech != null) {
                imageVector = Icons.Filled.Dns,
                imageVector = vectorResource(Res.drawable.ic_add),
                imageVector = vectorResource(Res.drawable.ic_history),
                modifier = Modifier.handCursor(),
                navigationTabBar()
                onClick = onNavigateToSettings,
                textToSpeech.stop()
                tint = MaterialTheme.colorScheme.onBackground,
                tint = if (isSandboxOpen) {
                vectorResource(Res.drawable.ic_volume_off)
                vectorResource(Res.drawable.ic_volume_up)
                }
                } else {
                },
            )
            ) {
            ),
            Box(modifier = Modifier.align(Alignment.Center)) {
            Icon(
            IconButton(
            LeadingButtons(textToSpeech, isSpeechOutputEnabled, isSpeaking, actions, isChatHistoryEmpty, hasSavedConversations, onShowHistory, isSandboxAvailable, isSandboxOpen, isShellExecuting, onToggleSandbox)
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Row(modifier = Modifier.align(Alignment.CenterStart)) {
            Spacer(Modifier.weight(1f))
            actions.toggleSpeechOutput()
            checked = isSandboxOpen,
            colors = IconButtonDefaults.iconToggleButtonColors(
            contentDescription = stringResource(Res.string.toggle_speech_output_content_description),
            if (isShellExecuting) {
            if (isSpeechOutputEnabled && isSpeaking) {
            if (textToSpeech != null) {
            imageVector = if (isSpeechOutputEnabled) {
            modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 64.dp),
            modifier = Modifier.handCursor(),
            onCheckedChange = { onToggleSandbox() },
            onClick = onShowHistory,
            onClick = {
            tint = MaterialTheme.colorScheme.onBackground,
            }
            } else {
            },
        )
        ) {
        Box(
        Icon(
        IconButton(
        IconToggleButton(
        LaunchedEffect(isShellExecuting) {
        Row {
        modifier = Modifier.handCursor(),
        onClick = {
        val checkedContainer = primary.copy(alpha = 0.2f)
        val flashAlpha = remember { Animatable(0f) }
        val flashContainer = primary.copy(alpha = flashAlpha.value)
        val primary = MaterialTheme.colorScheme.primary
        }
        },
    ) {
    IconButton(
    actions: ChatActions,
    hasSavedConversations: Boolean,
    if (!isChatHistoryEmpty) {
    if (hasSavedConversations) {
    if (isSandboxAvailable) {
    if (navigationTabBar != null) {
    isChatHistoryEmpty: Boolean,
    isSandboxAvailable: Boolean,
    isSandboxOpen: Boolean,
    isShellExecuting: Boolean,
    isSpeaking: Boolean,
    isSpeechOutputEnabled: Boolean,
    navigationTabBar: (@Composable () -> Unit)? = null,
    onNavigateToSettings: () -> Unit,
    onShowHistory: () -> Unit,
    onToggleSandbox: () -> Unit,
    textToSpeech: TextToSpeechInstance,
    textToSpeech: TextToSpeechInstance? = null,
    textToSpeech: TextToSpeechInstance?,
    }
    } else {
) {
@Composable
internal fun TopBar(
private fun LeadingButtons(
private fun SpeechToggleButton(
}
