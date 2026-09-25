package com.inspiredandroid.kai.ui.settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.EmailSyncState
import com.inspiredandroid.kai.data.HeartbeatLogEntry
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.SmsSyncState
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.KaiRangeSlider
import com.inspiredandroid.kai.ui.components.KaiSlider
import com.inspiredandroid.kai.ui.components.RefreshIconButton
import com.inspiredandroid.kai.ui.components.SettingsListItem
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.execution_log_status_fail
import kai.composeapp.generated.resources.execution_log_status_ok
import kai.composeapp.generated.resources.settings_email
import kai.composeapp.generated.resources.settings_email_description
import kai.composeapp.generated.resources.settings_email_empty
import kai.composeapp.generated.resources.settings_email_last_poll
import kai.composeapp.generated.resources.settings_email_poll_failed
import kai.composeapp.generated.resources.settings_email_poll_interval
import kai.composeapp.generated.resources.settings_email_poll_never
import kai.composeapp.generated.resources.settings_email_queued
import kai.composeapp.generated.resources.settings_email_refresh
import kai.composeapp.generated.resources.settings_email_remove
import kai.composeapp.generated.resources.settings_heartbeat
import kai.composeapp.generated.resources.settings_heartbeat_active_hours
import kai.composeapp.generated.resources.settings_heartbeat_default_prompt
import kai.composeapp.generated.resources.settings_heartbeat_description
import kai.composeapp.generated.resources.settings_heartbeat_interval
import kai.composeapp.generated.resources.settings_heartbeat_model
import kai.composeapp.generated.resources.settings_heartbeat_model_default
import kai.composeapp.generated.resources.settings_heartbeat_prompt_label
import kai.composeapp.generated.resources.settings_heartbeat_recent
import kai.composeapp.generated.resources.settings_heartbeat_refresh
import kai.composeapp.generated.resources.settings_heartbeat_reset_confirm
import kai.composeapp.generated.resources.settings_notifications_access_button
import kai.composeapp.generated.resources.settings_notifications_access_required
import kai.composeapp.generated.resources.settings_notifications_clear_queue
import kai.composeapp.generated.resources.settings_notifications_description
import kai.composeapp.generated.resources.settings_notifications_label
import kai.composeapp.generated.resources.settings_notifications_listener_bound
import kai.composeapp.generated.resources.settings_notifications_listener_disconnected
import kai.composeapp.generated.resources.settings_notifications_manage_apps
import kai.composeapp.generated.resources.settings_notifications_queued
import kai.composeapp.generated.resources.settings_sms_description
import kai.composeapp.generated.resources.settings_sms_last_poll
import kai.composeapp.generated.resources.settings_sms_permission_button
import kai.composeapp.generated.resources.settings_sms_permission_required
import kai.composeapp.generated.resources.settings_sms_poll_failed
import kai.composeapp.generated.resources.settings_sms_poll_interval
import kai.composeapp.generated.resources.settings_sms_queued
import kai.composeapp.generated.resources.settings_sms_read_label
import kai.composeapp.generated.resources.settings_sms_refresh
import kai.composeapp.generated.resources.settings_sms_send_description
import kai.composeapp.generated.resources.settings_sms_send_label
import kai.composeapp.generated.resources.settings_sms_send_permission_required
import kai.composeapp.generated.resources.settings_soul_reset
import kai.composeapp.generated.resources.settings_soul_reset_cancel
import kai.composeapp.generated.resources.settings_soul_save
import kotlin.math.roundToInt
import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentListOf
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

                                                    color = MaterialTheme.colorScheme.primaryContainer,
                                                    shape = RoundedCornerShape(12.dp),
                                                )
                                                .background(
                                                .padding(horizontal = 4.dp)
                                                MaterialTheme.colorScheme.onPrimaryContainer
                                                MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                                                MaterialTheme.colorScheme.onSurface
                                                MaterialTheme.colorScheme.onSurfaceVariant
                                                color = MaterialTheme.colorScheme.primaryContainer,
                                                shape = RoundedCornerShape(12.dp),
                                            )
                                            .background(
                                            .padding(horizontal = 4.dp)
                                            MaterialTheme.colorScheme.onPrimaryContainer
                                            MaterialTheme.colorScheme.onSurface
                                            Modifier
                                            color = if (isSelected) {
                                            style = MaterialTheme.typography.bodyMedium,
                                            style = MaterialTheme.typography.bodySmall,
                                            text = entry.modelId,
                                            text = entry.serviceName,
                                            } else {
                                            },
                                        )
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                        MaterialTheme.colorScheme.onSurface
                                        Modifier
                                        Text(
                                        contentDescription = null,
                                        if (isSelected) {
                                        imageVector = vectorResource(entry.icon),
                                        modifier = Modifier.size(18.dp),
                                        tint = if (isSelected) {
                                        } else {
                                        },
                                    )
                                    ),
                                    .handCursor()
                                    .then(
                                    Column {
                                    Icon(
                                    color = MaterialTheme.colorScheme.error,
                                    color = if (heartbeatSelectedInstanceId == null) {
                                    if (heartbeatSelectedInstanceId == null) {
                                    maxLines = 3,
                                    modelExpanded = false
                                    onChangeHeartbeatService(entry.instanceId)
                                    overflow = TextOverflow.Ellipsis,
                                    style = MaterialTheme.typography.bodyMedium,
                                    style = MaterialTheme.typography.labelSmall,
                                    text = entry.error,
                                    text = stringResource(Res.string.settings_heartbeat_model_default),
                                    }
                                    } else {
                                    },
                                )
                                ),
                                .handCursor()
                                .then(
                                MaterialTheme.colorScheme.error
                                MaterialTheme.colorScheme.primary
                                Res.string.settings_notifications_listener_bound
                                Res.string.settings_notifications_listener_disconnected
                                Text(
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                color = if (failed) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                                contentDescription = null,
                                imageVector = vectorResource(selectedEntry.icon),
                                leadingIcon = {
                                maxLines = 1,
                                modelExpanded = false
                                modifier = Modifier
                                modifier = Modifier.padding(start = 12.dp, top = 4.dp),
                                modifier = Modifier.size(18.dp),
                                onChangeHeartbeatService(null)
                                onClick = {
                                overflow = TextOverflow.Ellipsis,
                                stringResource(Res.string.execution_log_status_fail)
                                stringResource(Res.string.execution_log_status_ok)
                                stringResource(Res.string.settings_email_last_poll, relative)
                                stringResource(Res.string.settings_email_poll_failed, relative)
                                style = MaterialTheme.typography.bodySmall,
                                style = MaterialTheme.typography.labelSmall,
                                text = "${selectedEntry.serviceName} · ${selectedEntry.modelId}",
                                text = formatHeartbeatTime(entry.timestampEpochMs),
                                text = text,
                                text = {
                                },
                            )
                            DropdownMenuItem(
                            Icon(
                            MaterialTheme.colorScheme.error
                            MaterialTheme.colorScheme.onSurfaceVariant
                            Spacer(Modifier.width(8.dp))
                            Text(
                            Text(stringResource(Res.string.settings_heartbeat_model_default))
                            Text(stringResource(Res.string.settings_notifications_clear_queue))
                            color = MaterialTheme.colorScheme.primary,
                            color = if (entry.success) {
                            color = if (failed) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                            contentDescription = stringResource(Res.string.settings_soul_reset),
                            if (!entry.success && entry.error != null) {
                            if (listenerBound) {
                            imageVector = Icons.Default.Replay,
                            modifier = Modifier
                            modifier = Modifier.widthIn(min = 36.dp * LocalDensity.current.fontScale),
                            onClick = {
                            stringResource(Res.string.settings_sms_last_poll, relative)
                            stringResource(Res.string.settings_sms_poll_failed, relative)
                            style = MaterialTheme.typography.labelMedium,
                            style = MaterialTheme.typography.labelSmall,
                            text = if (entry.success) {
                            text = stringResource(Res.string.settings_notifications_queued, pendingCount),
                            text = text,
                            text = {
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            val isSelected = entry.instanceId == heartbeatSelectedInstanceId
                            val relative = formatPollRelative(nowMs - timestampMs)
                            val text = if (failed) {
                            }
                            } else {
                            },
                        )
                        ),
                        Column {
                        DropdownMenuItem(
                        Icon(
                        Spacer(Modifier.width(1.dp))
                        Text(
                        Text(stringResource(Res.string.settings_notifications_manage_apps))
                        TextButton(onClick = onClearPending) {
                        color = MaterialTheme.colorScheme.onBackground,
                        color = MaterialTheme.colorScheme.primary,
                        color = if (listenerBound) {
                        contentDescription = stringResource(Res.string.settings_sms_refresh),
                        deleteContentDescription = stringResource(Res.string.settings_email_remove),
                        editedText = defaultPrompt
                        expanded = modelExpanded,
                        heartbeatServiceEntries.forEach { entry ->
                        horizontalArrangement = Arrangement.SpaceBetween,
                        if (selectedEntry != null) {
                        if (timestampMs > 0) {
                        isRefreshing = account.id in refreshingAccountIds,
                        isRefreshing = isRefreshing,
                        modifier = Modifier.fillMaxWidth(),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                        modifier = Modifier.handCursor(),
                        onClick = onRefresh,
                        onClick = { modelExpanded = true },
                        onClick = { showResetDialog = true },
                        onDelete = { onRemoveAccount(account.id) },
                        onDismissRequest = { modelExpanded = false },
                        onRefresh = { onRefreshAccount(account.id) },
                        onSaveHeartbeatPrompt("")
                        refreshContentDescription = stringResource(Res.string.settings_email_refresh),
                        shape = RoundedCornerShape(16.dp),
                        showResetDialog = false
                        stringResource(Res.string.settings_heartbeat_prompt_label),
                        style = MaterialTheme.typography.labelMedium,
                        style = MaterialTheme.typography.labelSmall,
                        subtitle = "${account.imapHost}:${account.imapPort}",
                        text = stringResource(
                        text = stringResource(Res.string.settings_email_queued, pendingCount),
                        text = stringResource(Res.string.settings_sms_queued, pendingCount),
                        title = account.email,
                        val failed = sync.lastError != null && sync.lastAttemptEpochMs > 0
                        val relative = formatPollRelative(nowMs - timestampMs)
                        val text = if (failed) {
                        val timestampMs = if (failed) sync.lastAttemptEpochMs else sync.lastSyncEpochMs
                        verticalAlignment = Alignment.CenterVertically,
                        }
                        } else {
                        },
                    )
                    ) {
                    DropdownMenu(
                    IconButton(
                    OutlinedButton(
                    OutlinedButton(onClick = onOpenAccessSettings) {
                    RefreshIconButton(
                    Row(
                    SettingsListItem(
                    Spacer(Modifier.height(8.dp))
                    Text(
                    Text(stringResource(Res.string.settings_soul_reset))
                    Text(stringResource(Res.string.settings_soul_reset_cancel))
                    Text(stringResource(Res.string.settings_soul_save))
                    activeEnd = range.endInclusive
                    activeStart = range.start
                    buttonLabel = stringResource(Res.string.settings_notifications_access_button),
                    buttonLabel = stringResource(Res.string.settings_sms_permission_button),
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = stringResource(Res.string.settings_heartbeat_refresh),
                    currentValue = pollIntervalMinutes,
                    fallbackIndex = 0,
                    formatValue = { minutes -> if (minutes == 0) neverLabel else "${minutes}m" },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    if (minutes < 60) "${minutes}m" else "${minutes / 60}h"
                    if (sync != null) {
                    if (timestampMs > 0) {
                    isRefreshing = isRefreshing,
                    label = { minutes -> stringResource(Res.string.settings_email_poll_interval, minutes) },
                    label = { minutes -> stringResource(Res.string.settings_sms_poll_interval, minutes) },
                    message = stringResource(Res.string.settings_notifications_access_required),
                    message = stringResource(Res.string.settings_sms_permission_required),
                    modifier = Modifier.align(CenterHorizontally).handCursor(),
                    modifier = Modifier.fillMaxWidth(),
                    modifier = Modifier.handCursor(),
                    modifier = Modifier.weight(1f),
                    onChangeActiveHours(activeStart.roundToInt(), activeEnd.roundToInt())
                    onClick = onRefresh,
                    onClick = {
                    onClick = { onSaveHeartbeatPrompt(editedText.trim()) },
                    onClick = { showResetDialog = false },
                    onGrant = onOpenAccessSettings,
                    onGrant = { onToggleSms(true) },
                    onValueChanged = onChangePollInterval,
                    presets = persistentListOf(0, 5, 15, 30, 60),
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.labelLarge,
                    style = MaterialTheme.typography.labelMedium,
                    text = "$startDisplay – $endDisplay",
                    text = stringResource(Res.string.settings_email_empty),
                    text = stringResource(Res.string.settings_heartbeat_active_hours),
                    text = stringResource(Res.string.settings_heartbeat_model),
                    text = stringResource(Res.string.settings_heartbeat_recent),
                    val sync = syncStates[account.id]
                    verticalAlignment = Alignment.CenterVertically,
                    }
                    } else {
                    },
                )
                ) {
                Box {
                Button(
                PermissionRequiredRow(
                PresetSlider(
                RefreshIconButton(
                Row(
                Spacer(Modifier.height(12.dp))
                Spacer(Modifier.height(4.dp))
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.width(8.dp))
                Text(
                TextButton(
                buttonLabel = stringResource(Res.string.settings_sms_permission_button),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                currentValue = heartbeatIntervalMinutes,
                fallbackIndex = 2,
                for (account in emailAccounts) {
                for (entry in heartbeatLog) {
                formatValue = { minutes ->
                horizontalArrangement = Arrangement.SpaceBetween,
                if (heartbeatPrompt.isNotEmpty()) {
                if (pendingCount > 0) {
                label = {
                label = { stringResource(Res.string.settings_heartbeat_interval) },
                maxLines = 8,
                message = stringResource(Res.string.settings_sms_send_permission_required),
                minLines = 8,
                modifier = Modifier.fillMaxWidth(),
                onGrant = { onToggleSmsSend(true) },
                onValueChange = { if (it.length <= maxChars) editedText = it },
                onValueChange = { range ->
                onValueChangeFinished = {
                onValueChanged = onChangeInterval,
                presets = persistentListOf(5, 10, 15, 30, 45, 60, 120, 240),
                steps = 23,
                style = MaterialTheme.typography.bodySmall,
                text = "${editedText.length}/$maxChars",
                textAlign = TextAlign.End,
                val failed = syncState.lastError != null && syncState.lastAttemptEpochMs > 0
                val neverLabel = stringResource(Res.string.settings_email_poll_never)
                val nowMs = remember(syncState) { Clock.System.now().toEpochMilliseconds() }
                val nowMs = remember(syncStates) { Clock.System.now().toEpochMilliseconds() }
                val selectedEntry = heartbeatServiceEntries.find { it.instanceId == heartbeatSelectedInstanceId }
                val timestampMs = if (failed) syncState.lastAttemptEpochMs else syncState.lastSyncEpochMs
                value = activeStart..activeEnd,
                value = editedText,
                valueRange = 0f..24f,
                var modelExpanded by remember { mutableStateOf(false) }
                verticalAlignment = Alignment.CenterVertically,
                }
                },
            )
            ) {
            KaiOutlinedTextField(
            KaiRangeSlider(
            PermissionRequiredRow(
            PresetSlider(
            Row(
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(4.dp))
            Spacer(Modifier.height(8.dp))
            Text(
            actions = {
            checked = isEmailEnabled,
            checked = isEnabled,
            checked = isHeartbeatEnabled,
            checked = isSmsEnabled,
            checked = isSmsSendEnabled,
            color = MaterialTheme.colorScheme.onBackground,
            confirmButton = {
            description = stringResource(Res.string.settings_email_description),
            description = stringResource(Res.string.settings_heartbeat_description, heartbeatIntervalMinutes),
            description = stringResource(Res.string.settings_notifications_description),
            description = stringResource(Res.string.settings_sms_description),
            description = stringResource(Res.string.settings_sms_send_description),
            dismissButton = {
            if (!accessGranted) {
            if (!permissionGranted) {
            if (days.isNotEmpty()) "Every ${days.joinToString(", ")} at $timeStr" else cron
            if (emailAccounts.isEmpty()) {
            if (hasChanges) {
            if (heartbeatLog.isNotEmpty()) {
            if (heartbeatServiceEntries.size > 1) {
            modifier = Modifier.weight(1f),
            onCheckedChange = onToggle,
            onCheckedChange = onToggleEmail,
            onCheckedChange = onToggleHeartbeat,
            onCheckedChange = onToggleSms,
            onCheckedChange = onToggleSmsSend,
            onDismissRequest = { showResetDialog = false },
            onValueChanged(presets[sliderValue.roundToInt()])
            style = MaterialTheme.typography.labelLarge,
            style = MaterialTheme.typography.labelMedium,
            text = formatValue(currentPreset),
            text = label(currentPreset),
            text = { Text(stringResource(Res.string.settings_heartbeat_reset_confirm)) },
            title = stringResource(Res.string.settings_email),
            title = stringResource(Res.string.settings_heartbeat),
            title = stringResource(Res.string.settings_notifications_label),
            title = stringResource(Res.string.settings_sms_read_label),
            title = stringResource(Res.string.settings_sms_send_label),
            title = { Text(stringResource(Res.string.settings_soul_reset)) },
            val days = dayOfWeek.split(",").mapNotNull { dayName(it.trim()) }
            val endDisplay = "${activeEnd.roundToInt() % 24}:00"
            val startDisplay = "${activeStart.roundToInt() % 24}:00"
            var activeEnd by remember(activeHoursEnd) { mutableStateOf(activeHoursEnd.toFloat()) }
            var activeStart by remember(activeHoursStart) { mutableStateOf(activeHoursStart.toFloat()) }
            }
            } else {
            },
        )
        AlertDialog(
        Spacer(Modifier.height(16.dp))
        Spacer(Modifier.width(8.dp))
        Text(
        Text(buttonLabel)
        ToggleableHeadline(
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        else -> "${days}d ago"
        else -> cron
        horizontalArrangement = Arrangement.SpaceBetween,
        hours < 24L -> "${hours}h ago"
        if (isEmailEnabled) {
        if (isEnabled) {
        if (isHeartbeatEnabled) {
        if (isSmsEnabled) {
        if (isSmsSendEnabled && !sendPermissionGranted) {
        isEveryDay -> "Daily at $timeStr"
        isEveryMonth -> "Monthly on day $dayOfMonth at $timeStr"
        isEveryWeekday -> {
        minutes < 1L -> "just now"
        minutes < 60L -> "${minutes}m ago"
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { sliderValue = it },
        onValueChangeFinished = {
        steps = presets.size - 2,
        style = MaterialTheme.typography.bodySmall,
        text = message,
        value = sliderValue,
        valueRange = 0f..(presets.size - 1).toFloat(),
        verticalAlignment = Alignment.CenterVertically,
        }
        },
    "0", "7" -> "Sun"
    "1" -> "Mon"
    "2" -> "Tue"
    "3" -> "Wed"
    "4" -> "Thu"
    "5" -> "Fri"
    "6" -> "Sat"
    "FRI" -> "Fri"
    "MON" -> "Mon"
    "SAT" -> "Sat"
    "SUN" -> "Sun"
    "THU" -> "Thu"
    "TUE" -> "Tue"
    "WED" -> "Wed"
    )
    ) {
    Column(modifier = Modifier.fillMaxWidth()) {
    KaiSlider(
    OutlinedButton(onClick = onGrant) {
    Row(
    Spacer(Modifier.height(8.dp))
    Text(
    accessGranted: Boolean,
    activeHoursEnd: Int,
    activeHoursStart: Int,
    buttonLabel: String,
    currentValue: Int,
    else -> null
    emailAccounts: ImmutableList<EmailAccount>,
    fallbackIndex: Int,
    formatValue: @Composable (Int) -> String,
    heartbeatIntervalMinutes: Int,
    heartbeatLog: ImmutableList<HeartbeatLogEntry>,
    heartbeatPrompt: String,
    heartbeatSelectedInstanceId: String?,
    heartbeatServiceEntries: ImmutableList<ServiceEntry>,
    if (parts.size != 5) return cron
    if (showResetDialog) {
    isEmailEnabled: Boolean,
    isEnabled: Boolean,
    isHeartbeatEnabled: Boolean,
    isRefreshing: Boolean,
    isSmsEnabled: Boolean,
    isSmsSendEnabled: Boolean,
    label: @Composable (Int) -> String,
    listenerBound: Boolean,
    message: String,
    onChangeActiveHours: (Int, Int) -> Unit,
    onChangeHeartbeatService: (String?) -> Unit,
    onChangeInterval: (Int) -> Unit,
    onChangePollInterval: (Int) -> Unit,
    onClearPending: () -> Unit,
    onGrant: () -> Unit,
    onOpenAccessSettings: () -> Unit,
    onRefresh: () -> Unit,
    onRefreshAccount: (String) -> Unit,
    onRemoveAccount: (String) -> Unit,
    onSaveHeartbeatPrompt: (String) -> Unit,
    onToggle: (Boolean) -> Unit,
    onToggleEmail: (Boolean) -> Unit,
    onToggleHeartbeat: (Boolean) -> Unit,
    onToggleSms: (Boolean) -> Unit,
    onToggleSmsSend: (Boolean) -> Unit,
    onValueChanged: (Int) -> Unit,
    pendingCount: Int,
    permissionGranted: Boolean,
    pollIntervalMinutes: Int,
    presets: ImmutableList<Int>,
    refreshingAccountIds: ImmutableSet<String>,
    return "$h:${m.toString().padStart(2, '0')}"
    return "${local.day} ${local.month.name.take(3).lowercase().replaceFirstChar { it.uppercase() }} ${local.hour}:${local.minute.toString().padStart(2, '0')}"
    return when {
    sendPermissionGranted: Boolean,
    syncState: SmsSyncState,
    syncStates: ImmutableMap<String, EmailSyncState>,
    val (minute, hour, dayOfMonth, month, dayOfWeek) = parts
    val clamped = diffMs.coerceAtLeast(0L)
    val currentPreset = presets[sliderValue.roundToInt()]
    val days = hours / 24L
    val defaultPrompt = stringResource(Res.string.settings_heartbeat_default_prompt)
    val displayText = heartbeatPrompt.ifEmpty { defaultPrompt }
    val h = hour.toIntOrNull() ?: return null
    val hasChanges = editedText != displayText
    val hours = minutes / 60L
    val initialPos = presets.indexOf(currentValue).takeIf { it >= 0 }?.toFloat() ?: fallbackIndex.toFloat()
    val instant = Instant.fromEpochMilliseconds(epochMs)
    val isEveryDay = dayOfMonth == "*" && month == "*" && dayOfWeek == "*"
    val isEveryMonth = dayOfMonth != "*" && month == "*" && dayOfWeek == "*"
    val isEveryWeekday = dayOfMonth == "*" && month == "*" && dayOfWeek != "*"
    val local = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    val m = minute.toIntOrNull() ?: return null
    val maxChars = 4000
    val minutes = clamped / 60_000L
    val parts = cron.trim().split("\\s+".toRegex())
    val timeStr = formatCronTime(hour, minute) ?: return cron
    var editedText by remember(displayText) { mutableStateOf(displayText) }
    var showResetDialog by remember { mutableStateOf(false) }
    var sliderValue by remember(currentValue) { mutableStateOf(initialPos) }
    }
) {
@Composable
@file:OptIn(kotlin.time.ExperimentalTime::class)
internal fun EmailSection(
internal fun HeartbeatSection(
internal fun NotificationsSection(
internal fun SmsSection(
internal fun describeCron(cron: String): String {
private fun PermissionRequiredRow(
private fun PresetSlider(
private fun dayName(day: String): String? = when (day) {
private fun formatCronTime(hour: String, minute: String): String? {
private fun formatHeartbeatTime(epochMs: Long): String {
private fun formatPollRelative(diffMs: Long): String {
}
