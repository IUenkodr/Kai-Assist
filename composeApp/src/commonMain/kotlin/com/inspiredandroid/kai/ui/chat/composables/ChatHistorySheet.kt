
                                                        color = MaterialTheme.colorScheme.tertiaryContainer,
                                                        shape = RoundedCornerShape(4.dp),
                                                    )
                                                    .background(
                                                    .padding(bottom = 4.dp)
                                                    .padding(horizontal = 6.dp, vertical = 2.dp),
                                                    MaterialTheme.colorScheme.onBackground
                                                    MaterialTheme.colorScheme.primary
                                                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                                                    contentDescription = null,
                                                    imageVector = vectorResource(Res.drawable.ic_history),
                                                    modifier = Modifier.size(12.dp),
                                                    style = MaterialTheme.typography.labelSmall,
                                                    text = stringResource(Res.string.chat_history_heartbeat_label),
                                                    tint = MaterialTheme.colorScheme.onTertiaryContainer,
                                                )
                                                Icon(
                                                Spacer(Modifier.width(4.dp))
                                                Text(
                                                color = if (isActive) {
                                                maxLines = 1,
                                                modifier = Modifier
                                                overflow = TextOverflow.Ellipsis,
                                                style = MaterialTheme.typography.bodyLarge,
                                                text = conversation.title,
                                                verticalAlignment = Alignment.CenterVertically,
                                                } else {
                                                },
                                            )
                                            ) {
                                            1.dp,
                                            MaterialTheme.colorScheme.primary,
                                            RoundedCornerShape(12.dp),
                                            Row(
                                            Text(
                                            actions.loadConversation(conversation.id)
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            contentDescription = stringResource(Res.string.chat_history_delete_content_description),
                                            imageVector = Icons.Default.Delete,
                                            onConversationSelected()
                                            onDismiss()
                                            style = MaterialTheme.typography.bodySmall,
                                            text = formatDate(conversation.updatedAt),
                                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                            }
                                        )
                                        .border(
                                        .clickable {
                                        .clip(RoundedCornerShape(12.dp))
                                        .fillMaxWidth()
                                        .handCursor()
                                        .padding(vertical = 8.dp, horizontal = 8.dp),
                                        Icon(
                                        Text(
                                        backgroundColor = MaterialTheme.colorScheme.surfaceContainerLow,
                                        cornerRadius = 12.dp,
                                        if (conversation.isHeartbeat) {
                                        if (conversation.title.isNotEmpty()) {
                                        modifier = Modifier.handCursor(),
                                        onClick = { actions.deleteConversation(conversation.id) },
                                        }
                                    )
                                    ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                    IconButton(
                                    Modifier
                                    Modifier.animatedGradientBorder(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = borderModifier
                                    verticalAlignment = Alignment.CenterVertically,
                                    }
                                ) {
                                Row(
                                Spacer(Modifier.height(16.dp))
                                val borderModifier = if (conversation.isInteractive) {
                                val isActive = conversation.id == currentConversationId
                                }
                                } else {
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            item {
                            items(conversations, key = { it.id }) { conversation ->
                            listState = historyListState,
                            modifier = Modifier.align(CenterEnd).fillMaxHeight(),
                            state = historyListState,
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            }
                        )
                        ) {
                        LazyColumn(
                        VerticalScrollbarForList(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        text = stringResource(Res.string.chat_history_empty),
                        }
                    )
                    Box {
                    Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(Res.string.chat_history_title),
                    val historyListState = rememberLazyListState()
                    }
                )
                Snackbar(snackbarData = data)
                Spacer(Modifier.height(12.dp))
                Text(
                actionLabel = undoLabel,
                actions.undoDeleteConversation()
                duration = SnackbarDuration.Short,
                hostState = snackbarHostState,
                if (conversations.isEmpty()) {
                message = deletedMessage,
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
                }
                } else {
            )
            ) { data ->
            Column {
            SnackbarHost(
            if (pendingConversationDeletion == null) return@LaunchedEffect
            if (result == SnackbarResult.ActionPerformed) {
            snackbarHostState.currentSnackbarData?.dismiss()
            val result = snackbarHostState.showSnackbar(
            }
        Box(modifier = Modifier.fillMaxWidth()) {
        LaunchedEffect(pendingConversationDeletion) {
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        val deletedMessage = stringResource(Res.string.snackbar_conversation_deleted)
        val snackbarHostState = remember { SnackbarHostState() }
        val undoLabel = stringResource(Res.string.snackbar_undo)
        }
    ""
    ) {
    ModalBottomSheet(
    actions: ChatActions,
    char(' ')
    conversations: ImmutableList<ConversationSummary>,
    currentConversationId: String?,
    day()
    kotlin.time.Instant.fromEpochMilliseconds(epochMillis).format(dateFormat)
    monthName(MonthNames.ENGLISH_ABBREVIATED)
    onConversationSelected: () -> Unit = {},
    onDismiss: () -> Unit,
    pendingConversationDeletion: String?,
    year()
    }
) {
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.chat.ChatActions
import com.inspiredandroid.kai.ui.chat.ConversationSummary
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForList
import com.inspiredandroid.kai.ui.components.animatedGradientBorder
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.chat_history_delete_content_description
import kai.composeapp.generated.resources.chat_history_empty
import kai.composeapp.generated.resources.chat_history_heartbeat_label
import kai.composeapp.generated.resources.chat_history_title
import kai.composeapp.generated.resources.ic_history
import kai.composeapp.generated.resources.snackbar_conversation_deleted
import kai.composeapp.generated.resources.snackbar_undo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents.Companion.Format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun ChatHistorySheet(
package com.inspiredandroid.kai.ui.chat.composables
private fun formatDate(epochMillis: Long): String = try {
private val dateFormat = Format {
}
} catch (_: Exception) {
