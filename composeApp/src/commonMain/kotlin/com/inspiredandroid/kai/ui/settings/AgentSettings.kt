import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.HeartbeatLogEntry
import com.inspiredandroid.kai.data.MemoryEntry
import com.inspiredandroid.kai.data.ScheduledTask
import com.inspiredandroid.kai.data.TaskTrigger
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.SettingsListItem
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.icons.Replay
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.default_soul
import kai.composeapp.generated.resources.execution_log_status_fail
import kai.composeapp.generated.resources.execution_log_status_ok
import kai.composeapp.generated.resources.settings_heartbeat_recent
import kai.composeapp.generated.resources.settings_memories
import kai.composeapp.generated.resources.settings_memories_all_title
import kai.composeapp.generated.resources.settings_memories_delete
import kai.composeapp.generated.resources.settings_memories_description
import kai.composeapp.generated.resources.settings_memories_edit_cancel
import kai.composeapp.generated.resources.settings_memories_edit_save
import kai.composeapp.generated.resources.settings_memories_edit_title
import kai.composeapp.generated.resources.settings_memories_show_all
import kai.composeapp.generated.resources.settings_scheduled_tasks
import kai.composeapp.generated.resources.settings_scheduled_tasks_cancel
import kai.composeapp.generated.resources.settings_scheduled_tasks_description
import kai.composeapp.generated.resources.settings_soul
import kai.composeapp.generated.resources.settings_soul_description
import kai.composeapp.generated.resources.settings_soul_reset
import kai.composeapp.generated.resources.settings_soul_reset_cancel
import kai.composeapp.generated.resources.settings_soul_reset_confirm
import kai.composeapp.generated.resources.settings_soul_save
import kai.composeapp.generated.resources.settings_task_details_consecutive_failures
import kai.composeapp.generated.resources.settings_task_details_created
import kai.composeapp.generated.resources.settings_task_details_last_result
import kai.composeapp.generated.resources.settings_task_details_next_run
import kai.composeapp.generated.resources.settings_task_details_no_heartbeat_runs
import kai.composeapp.generated.resources.settings_task_details_no_runs
import kai.composeapp.generated.resources.settings_task_details_on_every_heartbeat
import kai.composeapp.generated.resources.settings_task_details_schedule
import kai.composeapp.generated.resources.settings_task_details_scheduled_for
import kai.composeapp.generated.resources.settings_task_details_status
import kai.composeapp.generated.resources.settings_task_details_trigger
import kotlin.time.Instant
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.datetime.TimeZone
import kotlinx.datetime.offsetAt
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource

                            message = entry.error,
                            message = entry.message,
                            success = entry.success,
                            timestampEpochMs = entry.timestampEpochMs,
                        "${task.status} - $scheduledTime $offset"
                        )
                        ExecutionLogRow(
                        accessGranted = uiState.notificationListenerAccessGranted,
                        contentDescription = stringResource(Res.string.settings_soul_reset),
                        editedText = localizedDefault
                        emailAccounts = uiState.emailAccounts,
                        imageVector = Icons.Default.Replay,
                        isEmailEnabled = uiState.isEmailEnabled,
                        isEnabled = uiState.isNotificationsEnabled,
                        isRefreshing = uiState.isRefreshingSms,
                        isSmsEnabled = uiState.isSmsEnabled,
                        isSmsSendEnabled = uiState.isSmsSendEnabled,
                        label = stringResource(Res.string.settings_task_details_next_run),
                        label = stringResource(Res.string.settings_task_details_schedule),
                        listenerBound = uiState.notificationListenerBound,
                        onChangePollInterval = actions.onChangeEmailPollInterval,
                        onChangePollInterval = actions.onChangeSmsPollInterval,
                        onClearPending = actions.onClearPendingNotifications,
                        onOpenAccessSettings = actions.onOpenNotificationListenerSettings,
                        onRefresh = actions.onRefreshSms,
                        onRefreshAccount = actions.onRefreshEmailAccount,
                        onRemoveAccount = actions.onRemoveEmailAccount,
                        onSaveSoul("")
                        onToggle = actions.onToggleNotifications,
                        onToggleEmail = actions.onToggleEmail,
                        onToggleSms = actions.onToggleSms,
                        onToggleSmsSend = actions.onToggleSmsSend,
                        pendingCount = uiState.emailPendingCount,
                        pendingCount = uiState.notificationPendingCount,
                        pendingCount = uiState.smsPendingCount,
                        permissionGranted = uiState.smsPermissionGranted,
                        pollIntervalMinutes = uiState.emailPollIntervalMinutes,
                        pollIntervalMinutes = uiState.smsPollIntervalMinutes,
                        refreshingAccountIds = uiState.refreshingEmailAccountIds,
                        sendPermissionGranted = uiState.smsSendPermissionGranted,
                        showResetDialog = false
                        syncState = uiState.smsSyncState,
                        syncStates = uiState.emailSyncStates,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        val instant = Instant.fromEpochMilliseconds(task.scheduledAtEpochMs)
                        val offset = zone.offsetAt(instant)
                        val scheduledTime = instant.toLocalDateTime(zone)
                        val zone = TimeZone.currentSystemDefault()
                        value = formatTaskInstant(task.scheduledAtEpochMs),
                        value = task.cron?.let { describeCron(it) } ?: "cron",
                    )
                    EmailSection(
                    EmptyLogText(stringResource(Res.string.settings_task_details_no_heartbeat_runs))
                    EmptyLogText(stringResource(Res.string.settings_task_details_no_runs))
                    Icon(
                    NotificationsSection(
                    SmsSection(
                    TaskDetailRow(
                    TaskTrigger.CRON -> "${task.status} - ${task.cron?.let { describeCron(it) } ?: "cron"}"
                    TaskTrigger.HEARTBEAT -> "${task.status} - $onEveryHeartbeat"
                    TaskTrigger.TIME -> {
                    Text(stringResource(Res.string.settings_memories_edit_cancel))
                    Text(stringResource(Res.string.settings_memories_edit_save))
                    Text(stringResource(Res.string.settings_memories_show_all, sortedMemories.size))
                    Text(stringResource(Res.string.settings_soul_reset))
                    Text(stringResource(Res.string.settings_soul_reset_cancel))
                    activeHoursEnd = uiState.heartbeatActiveHoursEnd,
                    activeHoursStart = uiState.heartbeatActiveHoursStart,
                    color = MaterialTheme.colorScheme.onBackground,
                    color = if (success) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.error,
                    deleteContentDescription = deleteContentDescription,
                    deleteContentDescription = stringResource(Res.string.settings_memories_delete),
                    deleteContentDescription = stringResource(Res.string.settings_scheduled_tasks_cancel),
                    enabled = hasChanges,
                    heartbeatIntervalMinutes = uiState.heartbeatIntervalMinutes,
                    heartbeatLog = uiState.heartbeatLog,
                    heartbeatLog.forEach { entry ->
                    heartbeatPrompt = uiState.heartbeatPrompt,
                    heartbeatSelectedInstanceId = uiState.heartbeatSelectedInstanceId,
                    heartbeatServiceEntries = uiState.heartbeatServiceEntries,
                    isHeartbeatEnabled = uiState.isHeartbeatEnabled,
                    isMemoryEnabled = uiState.isMemoryEnabled,
                    isRefreshing = uiState.isRefreshingHeartbeat,
                    isSchedulingEnabled = uiState.isSchedulingEnabled,
                    label = stringResource(Res.string.settings_task_details_consecutive_failures),
                    label = stringResource(Res.string.settings_task_details_last_result),
                    label = stringResource(Res.string.settings_task_details_schedule),
                    label = stringResource(Res.string.settings_task_details_scheduled_for),
                    maxLines = 4,
                    memories = uiState.memories,
                    modifier = Modifier.align(CenterHorizontally).handCursor(),
                    modifier = Modifier.handCursor(),
                    onCancelTask = actions.onCancelTask,
                    onChangeActiveHours = actions.onChangeHeartbeatActiveHours,
                    onChangeHeartbeatService = actions.onChangeHeartbeatService,
                    onChangeInterval = actions.onChangeHeartbeatInterval,
                    onClick = onDismiss,
                    onClick = {
                    onClick = { editingMemory = memory },
                    onClick = { onEditMemory(memory) },
                    onClick = { onSave(content.trim()) },
                    onClick = { selectedTaskId = task.id },
                    onClick = { showAllDialog = true },
                    onClick = { showResetDialog = false },
                    onClick = { showResetDialog = true },
                    onDelete = { onCancelTask(task.id) },
                    onDelete = { onDeleteMemory(memory.key) },
                    onDeleteMemory = actions.onDeleteMemory,
                    onRefresh = actions.onRefreshHeartbeat,
                    onSaveHeartbeatPrompt = actions.onSaveHeartbeatPrompt,
                    onSaveSoul = actions.onSaveSoul,
                    onToggleHeartbeat = actions.onToggleHeartbeat,
                    onToggleMemory = actions.onToggleMemory,
                    onToggleScheduling = actions.onToggleScheduling,
                    onUpdateMemory = actions.onUpdateMemory,
                    overflow = TextOverflow.Ellipsis,
                    soulText = uiState.soulText,
                    stringResource(Res.string.settings_soul),
                    style = MaterialTheme.typography.labelSmall,
                    subtitle = memory.content,
                    subtitle = subtitle,
                    subtitleMaxLines = 3,
                    task.recentExecutions.forEach { entry ->
                    tasks = uiState.scheduledTasks,
                    text = message,
                    title = memory.key,
                    title = task.description,
                    value = formatTaskInstant(task.scheduledAtEpochMs),
                    value = result,
                    value = stringResource(Res.string.settings_task_details_on_every_heartbeat),
                    value = task.consecutiveFailures.toString(),
                    }
                    },
                )
                ) {
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
                .verticalScroll(rememberScrollState())
                // Heartbeat additions don't carry their own log — they fire as part of every
                // heartbeat run, so the heartbeat-wide log is the right surface.
                HeartbeatSection(
                IconButton(
                MemoryList(
                OutlinedButton(
                ScheduledTaskList(
                SettingsCard {
                SettingsListItem(
                SoulEditor(
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.width(8.dp))
                TaskDetailRow(
                TaskTrigger.CRON -> {
                TaskTrigger.HEARTBEAT -> TaskDetailRow(
                TaskTrigger.TIME -> TaskDetailRow(
                Text(
                Text(stringResource(Res.string.settings_soul_save))
                TextButton(
                color = MaterialTheme.colorScheme.onBackground,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                editingMemory = null
                horizontalArrangement = Arrangement.End,
                if (heartbeatLog.isEmpty()) {
                if (task.recentExecutions.isEmpty()) {
                label = stringResource(Res.string.settings_task_details_created),
                label = stringResource(Res.string.settings_task_details_status),
                label = stringResource(Res.string.settings_task_details_trigger),
                maxLines = 10,
                minLines = 4,
                modifier = Modifier.align(CenterHorizontally).handCursor(),
                modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.weight(1f),
                onClick = { onSaveSoul(editedText.trim()) },
                onUpdateMemory(memory.key, newContent)
                onValueChange = { content = it },
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                style = MaterialTheme.typography.bodySmall,
                style = MaterialTheme.typography.labelMedium,
                style = MaterialTheme.typography.titleMedium,
                text = formatTaskInstant(timestampEpochMs),
                text = memory.key,
                text = stringResource(Res.string.settings_heartbeat_recent),
                text = stringResource(Res.string.settings_memories_all_title),
                text = stringResource(Res.string.settings_memories_edit_title),
                text = stringResource(Res.string.settings_soul),
                text = task.description,
                val subtitle = when (task.trigger) {
                value = content,
                value = formatTaskInstant(task.createdAtEpochMs),
                value = task.status.name,
                value = task.trigger.name,
                }
                } else {
            )
            ) {
            // ... (retry after 120s backoff)"). Surface it so the user can see what the
            // The scheduler stores its retry/backoff phrasing in `lastResult` ("Failed at ...:
            // scheduler is going to do next, not just what already happened.
            Button(
            KaiOutlinedTextField(
            Row(
            SettingsCard {
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(16.dp))
            Spacer(Modifier.height(4.dp))
            Spacer(Modifier.height(8.dp))
            TaskDetailRow(
            Text(
            checked = isMemoryEnabled,
            checked = isSchedulingEnabled,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            color = if (success) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            confirmButton = {
            description = stringResource(Res.string.settings_memories_description),
            description = stringResource(Res.string.settings_scheduled_tasks_description),
            dismissButton = {
            heartbeatLog = heartbeatLog,
            if (!message.isNullOrBlank()) {
            if (sortedMemories.size > previewMemories.size) {
            if (soulText.isNotEmpty()) {
            if (task.consecutiveFailures > 0) {
            if (task.trigger == TaskTrigger.HEARTBEAT) {
            if (uiState.showEmailToggle) {
            if (uiState.showNotificationsSection) {
            if (uiState.showSmsSection) {
            label = {
            maxLines = 8,
            memories = sortedMemories,
            memories.forEach { memory ->
            memory = memory,
            minLines = 8,
            modifier = Modifier
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.weight(1f),
            modifier = Modifier.width(140.dp * LocalDensity.current.fontScale),
            modifier = Modifier.widthIn(min = 36.dp * LocalDensity.current.fontScale),
            onCheckedChange = onToggleMemory,
            onCheckedChange = onToggleScheduling,
            onDeleteMemory = onDeleteMemory,
            onDismiss = { editingMemory = null },
            onDismiss = { selectedTaskId = null },
            onDismiss = { showAllDialog = false },
            onDismissRequest = { showResetDialog = false },
            onEditMemory = { editingMemory = it },
            onSave = { newContent ->
            onValueChange = { if (it.length <= maxChars) editedText = it },
            previewMemories.forEach { memory ->
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.labelSmall,
            task = selectedTask,
            task.lastResult?.takeIf { it.isNotBlank() }?.let { result ->
            tasks.forEach { task ->
            text = "${editedText.length}/$maxChars",
            text = if (success) stringResource(Res.string.execution_log_status_ok) else stringResource(Res.string.execution_log_status_fail),
            text = label,
            text = stringResource(Res.string.settings_soul_description),
            text = value,
            text = { Text(stringResource(Res.string.settings_soul_reset_confirm)) },
            textAlign = TextAlign.End,
            title = stringResource(Res.string.settings_memories),
            title = stringResource(Res.string.settings_scheduled_tasks),
            title = { Text(stringResource(Res.string.settings_soul_reset)) },
            value = editedText,
            verticalAlignment = Alignment.CenterVertically,
            when (task.trigger) {
            }
            } else {
            },
        )
        ) {
        // The label column is sized in dp for a fixed amount of text, so it has to
        // track the font scale; the value needs a weight or it overflows the row.
        AlertDialog(
        AllMemoriesSheet(
        Column {
        Column(
        EditMemorySheet(
        KaiOutlinedTextField(
        Row(
        Spacer(Modifier.height(12.dp))
        TaskDetailsSheet(
        Text(
        ToggleableHeadline(
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        end = {
        if (hasChanges) {
        if (isMemoryEnabled) {
        if (isSchedulingEnabled && tasks.isNotEmpty()) {
        memories.sortedByDescending { it.updatedAt }.toImmutableList()
        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        start = {
        style = MaterialTheme.typography.bodySmall,
        text = text,
        val onEveryHeartbeat = stringResource(Res.string.settings_task_details_on_every_heartbeat)
        verticalAlignment = Alignment.Top,
        }
        },
    )
    ) {
    Column(modifier = Modifier.fillMaxWidth()) {
    ModalBottomSheet(
    Row(
    StaggeredSettingsColumns(
    Text(
    editingMemory?.let { memory ->
    heartbeatLog: ImmutableList<HeartbeatLogEntry>,
    if (epochMs <= 0L) return "—"
    if (selectedTask != null) {
    if (showAllDialog) {
    if (showResetDialog) {
    isMemoryEnabled: Boolean,
    isSchedulingEnabled: Boolean,
    memories: ImmutableList<MemoryEntry>,
    memory: MemoryEntry,
    onCancelTask: (String) -> Unit,
    onDeleteMemory: (String) -> Unit,
    onDismiss: () -> Unit,
    onEditMemory: (MemoryEntry) -> Unit,
    onSave: (String) -> Unit,
    onSaveSoul: (String) -> Unit,
    onToggleMemory: (Boolean) -> Unit,
    onToggleScheduling: (Boolean) -> Unit,
    onUpdateMemory: (String, String) -> Unit,
    return "${local.day} $month ${local.year} ${local.hour}:$minute"
    soulText: String,
    task: ScheduledTask,
    tasks: ImmutableList<ScheduledTask>,
    val deleteContentDescription = stringResource(Res.string.settings_memories_delete)
    val displayText = soulText.ifEmpty { localizedDefault }
    val hasChanges = content != memory.content && content.isNotBlank()
    val hasChanges = editedText != displayText
    val instant = Instant.fromEpochMilliseconds(epochMs)
    val local = instant.toLocalDateTime(zone)
    val localizedDefault = stringResource(Res.string.default_soul)
    val maxChars = 4000
    val minute = local.minute.toString().padStart(2, '0')
    val month = local.month.name.take(3).lowercase().replaceFirstChar { it.uppercase() }
    val previewMemories = remember(sortedMemories) { sortedMemories.take(5).toImmutableList() }
    val selectedTask = selectedTaskId?.let { id -> tasks.firstOrNull { it.id == id } }
    val sortedMemories = remember(memories) {
    val zone = TimeZone.currentSystemDefault()
    var content by remember(memory.key) { mutableStateOf(memory.content) }
    var editedText by remember(displayText) { mutableStateOf(displayText) }
    var editingMemory by remember { mutableStateOf<MemoryEntry?>(null) }
    var selectedTaskId by remember { mutableStateOf<String?>(null) }
    var showAllDialog by remember { mutableStateOf(false) }
    var showResetDialog by remember { mutableStateOf(false) }
    }
) {
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
internal fun AgentContent(uiState: SettingsUiState, actions: SettingsActions) {
package com.inspiredandroid.kai.ui.settings
private fun AllMemoriesSheet(
private fun EditMemorySheet(
private fun EmptyLogText(text: String) {
private fun ExecutionLogRow(success: Boolean, timestampEpochMs: Long, message: String?) {
private fun MemoryList(
private fun ScheduledTaskList(
private fun SoulEditor(
private fun TaskDetailRow(label: String, value: String) {
private fun TaskDetailsSheet(
private fun formatTaskInstant(epochMs: Long): String {
}
