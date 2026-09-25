import com.inspiredandroid.kai.email.EmailPoller
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.isEmailSupported
import com.inspiredandroid.kai.isSmsSupported
import com.inspiredandroid.kai.sendHeartbeatNotification
import com.inspiredandroid.kai.sms.SmsPoller
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import com.inspiredandroid.kai.ui.markdown.toSpeakableText
import kotlin.concurrent.Volatile
import kotlin.coroutines.CoroutineContext
import kotlin.math.min
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

                            body = preview,
                            dataRepository.addAssistantMessage("**$header**\n\n$response")
                            store.updateSyncState(current.copy(lastSeenUid = maxUid))
                            title = "Kai heartbeat",
                            val header = task.description.ifBlank { "Scheduled task" }
                        )
                        .groupBy { it.accountId }
                        .mapValues { (_, msgs) -> msgs.maxOf { it.uid } }
                        // (see `addAssistantMessage`), so routing its shell commands
                        // Bind tool calls to the heartbeat conversation's sandbox session
                        // there too keeps shell state coherent with the visible output.
                        // — the scheduled-task result also lands in that conversation
                        consecutiveFailures = 0,
                        consecutiveFailures = failures,
                        handleTaskCompletion(task)
                        handleTaskFailure(task, formatException(e))
                        if (maxUid > current.lastSeenUid) {
                        if (response.isNotBlank()) {
                        lastResult = "Executed at $now (next schedule computation failed, will retry)",
                        lastResult = "Executed at $now (no next schedule)",
                        lastResult = "Executed at $now",
                        lastResult = "Failed at $now: $reason (next retry at $nextExecution)",
                        lastResult = "Failed at $now: $reason (no next schedule)",
                        parseMarkdown(response).toSpeakableText(),
                        recentExecutions = log,
                        scheduledAtEpochMs = nextExecution.toEpochMilliseconds(),
                        sendHeartbeatNotification(
                        status = TaskStatus.COMPLETED,
                        status = TaskStatus.PENDING,
                        val current = store.getSyncState(accId)
                        val response = dataRepository.askWithTools(task.prompt, conversationIdOverride = taskConversationId)
                        val taskConversationId = dataRepository.getOrCreateHeartbeatConversationId()
                        }
                    )
                    ),
                    // Advance the per-account delivery watermark so the user's
                    // next `check_email` call won't re-surface the same UIDs
                    // the heartbeat just summarised.
                    checkNewEmails { isLoadingCheck() }
                    checkNewSms()
                    consecutiveFailures = 0,
                    consecutiveFailures = failures,
                    for ((accId, maxUid) in maxUidByAccount) {
                    if (isLoadingCheck()) break
                    if (preview.isNotBlank()) {
                    lastResult = "Executed at $now",
                    lastResult = "Failed at $now: $reason (retry after ${backoffMs / 1000}s backoff)",
                    recentExecutions = log,
                    runHeartbeat()
                    scheduledAtEpochMs = now.toEpochMilliseconds() + backoffMs,
                    status = TaskStatus.COMPLETED,
                    store.removePending(pendingEmails)
                    task.copy(
                    try {
                    val maxUidByAccount = pendingEmails
                    val preview = truncateForNotification(
                    }
                    } catch (e: Exception) {
                )
                ),
                .find { it.type == Conversation.TYPE_HEARTBEAT }
                // Cron computation failed — leave pending for retry
                // Email polling
                // No valid future time — mark completed
                // Push-notify only when the user won't see the in-app banner.
                // SMS polling — FOSS-only (gated on `isSmsSupported`, which is true only
                // Strip markdown + kai-ui fences before sending to the tray —
                // Tapping the notification deep-links into the heartbeat
                // conversation via `EXTRA_OPEN_HEARTBEAT` (Android actual).
                // text (```kai-ui {...}```) is unreadable.
                // the notification surface can't render them and raw fence
                // when READ_SMS is declared in the merged manifest).
                ?.map { it.content }
                ?.messages?.takeLast(HEARTBEAT_CONTEXT_COUNT)
                ?: emptyList()
                CronExpression(task.cron).nextAfter(now)
                conversationIdOverride = heartbeatConversationId,
                dataRepository.addAssistantMessage(response)
                delay(POLL_INTERVAL_MS.milliseconds)
                emailStore?.let { store ->
                for (task in dueTasks) {
                if (!appInForeground) {
                if (!appSettings.isSchedulingEnabled()) continue
                if (!isLoadingCheck() && heartbeatManager?.isHeartbeatDue() == true) {
                if (!isLoadingCheck() && isEmailSupported && appSettings.isEmailEnabled() && emailStore != null) {
                if (!isLoadingCheck() && isSmsSupported && appSettings.isSmsEnabled() && smsStore != null && smsPoller != null) {
                instanceId = manager.getConfig().heartbeatInstanceId,
                notificationStore?.removePending(pendingNotifications)
                null
                println("TaskScheduler: failed to compute next cron time for task ${task.id}: ${e.message}")
                prompt = heartbeatPrompt,
                return
                smsStore?.removePending(pendingSms)
                task.copy(
                taskStore!!.updateTask(
                val dueTasks = taskStore.getDueTasks()
                }
            )
            // Cron task failed — advance to the next scheduled time instead of retrying every cycle
            // One-time task — apply exponential backoff
            // One-time task — mark completed
            // Only clear the snapshot we actually showed to the AI — messages
            // Rate-limit by last attempt (success or failure) so repeated failures back off
            // Recurring task — compute next execution time
            // Resolve the heartbeat conversation id BEFORE the AI starts emitting
            // Sweep retention bounds opportunistically after each heartbeat run.
            // at the configured poll interval instead of retrying every scheduler tick.
            // be viewing right now.
            // own persistent bash session rather than the chat the user happens to
            // that arrived during the call stay pending for the next heartbeat.
            // tool calls, so any execute_shell_command call binds to the heartbeat's
            emailPoller.poll(account)
            if (isLoading()) break
            if (nextExecution != null) {
            if (now - lastActivityMs < pollIntervalMs) continue
            if (pendingEmails.isNotEmpty()) {
            if (pendingNotifications.isNotEmpty()) {
            if (pendingSms.isNotEmpty()) {
            if (response.isNotBlank() && "HEARTBEAT_OK" !in response) {
            manager.markHeartbeatExecuted()
            manager.recordHeartbeat(success = false, error = e.message ?: e.toString())
            manager.recordHeartbeat(success = true)
            message = message,
            notificationStore?.sweep()
            success = success,
            taskStore!!.updateTask(
            timestampEpochMs = Clock.System.now().toEpochMilliseconds(),
            val backoffMs = min(POLL_INTERVAL_MS * (1L shl min(failures, 10)), MAX_BACKOFF_MS)
            val heartbeatConversationId = dataRepository.getOrCreateHeartbeatConversationId()
            val heartbeatPrompt = manager.buildHeartbeatPrompt(recentResponses, pendingEmails, pendingSms, pendingNotifications)
            val lastActivityMs = maxOf(syncState.lastSyncEpochMs, syncState.lastAttemptEpochMs)
            val nextExecution = try {
            val recentResponses = dataRepository.savedConversations.value
            val response = dataRepository.askWithTools(
            val syncState = emailStore.getSyncState(account.id)
            while (isActive) {
            }
            } catch (_: Exception) {
            } catch (e: Exception) {
            } else {
         * Cap the notification body — Android's collapsed text cuts off around ~60
         * chars anyway, and the expanded BigTextStyle view is capped to keep the
         * conversation, which opens when the user taps the notification.
         * notification panel tidy. The full response remains in the heartbeat
         */
        )
        /**
        /** Per-task execution log size — surfaced in the task details sheet. */
        // Only prefer the word boundary if it's close to the cap; otherwise hard-cut —
        // a word boundary 100 chars back would throw away half the preview.
        SupervisorJob() + backgroundDispatcher + CoroutineName("TaskScheduler"),
        activeJob = schedulerScope.launch {
        const val HEARTBEAT_CONTEXT_COUNT = 3
        const val HEARTBEAT_NOTIFICATION_PREVIEW_CHARS = 240
        const val MAX_BACKOFF_MS = 3_600_000L // 1 hour
        const val MAX_TASK_LOG_ENTRIES = 10
        const val POLL_INTERVAL_MS = 60_000L
        for (account in emailStore.getAccounts()) {
        if (!enabled || taskStore == null || appSettings == null) return
        if (!manager.getConfig().enabled) return
        if (activeJob?.isActive == true) return
        if (appSettings?.isSchedulingEnabled() != true) return
        if (emailStore == null || appSettings == null || emailPoller == null) return
        if (now - lastActivityMs < pollIntervalMs) return
        if (pollMinutes <= 0) return
        if (pollMinutes <= 0) return // 0 = never poll automatically
        if (smsStore == null || appSettings == null || smsPoller == null) return
        if (task.cron != null) {
        if (trimmed.length <= HEARTBEAT_NOTIFICATION_PREVIEW_CHARS) return trimmed
        return "$type: $msg"
        return (listOf(entry) + task.recentExecutions).take(MAX_TASK_LOG_ENTRIES)
        return window.substring(0, cut).trimEnd().trimEnd(',', ';', ':') + "…"
        runHeartbeat()
        smsPoller.poll()
        try {
        val cut = if (lastSpace >= HEARTBEAT_NOTIFICATION_PREVIEW_CHARS - 40) lastSpace else window.length
        val entry = TaskExecutionLogEntry(
        val failures = task.consecutiveFailures + 1
        val lastActivityMs = maxOf(syncState.lastSyncEpochMs, syncState.lastAttemptEpochMs)
        val lastSpace = window.lastIndexOf(' ')
        val log = appendExecution(task, success = false, message = reason)
        val log = appendExecution(task, success = true, message = null)
        val manager = heartbeatManager ?: return
        val msg = e.message?.takeIf { it.isNotBlank() } ?: return type
        val now = Clock.System.now()
        val now = Clock.System.now().toEpochMilliseconds()
        val pendingEmails = emailStore?.getPending().orEmpty()
        val pendingNotifications = notificationStore?.getPending().orEmpty()
        val pendingSms = smsStore?.getPending().orEmpty()
        val pollIntervalMs = pollMinutes * 60_000L
        val pollMinutes = appSettings.getEmailPollIntervalMinutes()
        val pollMinutes = appSettings.getSmsPollIntervalMinutes()
        val reason = error ?: "unknown error"
        val syncState = smsStore.getSyncState()
        val trimmed = text.trim()
        val type = e::class.simpleName ?: "Exception"
        val window = trimmed.substring(0, HEARTBEAT_NOTIFICATION_PREVIEW_CHARS)
        }
        } catch (e: Exception) {
        } else {
     *
     * Format an exception for the task log. Plain `e.message` collapses too much detail —
     * On Android this mirrors `ProcessLifecycleOwner` — set true on the first Activity
     * Predicate the loop consults before executing a task, to avoid racing with an
     * Process-lifetime scope. Decoupled from any caller's scope so scheduled tasks and
     * Run one heartbeat cycle: build the prompt, call the AI, record the result, and
     * Starts the scheduler loop on the internal long-lived scope. Idempotent — repeated
     * Trims a heartbeat preview to fit a notification body: respects word boundaries
     * Used by the scheduler loop's due-check and by [triggerHeartbeatNow] for user-pressed refresh.
     * User-pressed manual heartbeat (Settings → Agent → Heartbeat refresh icon). Bypasses
     * When a heartbeat produces a non-OK report and this is `false`, the scheduler
     * Whether the app is currently in the foreground (the user can see the in-app banner).
     * `DaemonService` holding a foreground notification).
     * be enabled and scheduling overall to be on. No-ops if either is off.
     * calls (e.g. from both `DaemonService.onCreate` and `ChatViewModel.init`) return
     * conversation. Short inputs pass through unchanged.
     * escalates to a push notification instead of relying on the (invisible) banner.
     * false since their actuals for [sendHeartbeatNotification] are no-ops anyway.
     * heartbeats keep firing when a short-lived caller (e.g. `ChatViewModel.viewModelScope`)
     * immediately if the loop is already running.
     * in-flight foreground API call. Assigned by the UI layer (`ChatViewModel`) while it
     * is alive and reset to `{ false }` when it's cleared. Default = "nothing loading",
     * is cancelled — as long as the OS keeps the process alive (which on Android means
     * it's often null (NPE, IllegalStateException-no-arg) or terse ("401"), leaving the
     * start, false when all activities stop. Other platforms leave it at the default
     * surface any non-OK response (in-app message + push notification when backgrounded).
     * the active-hours window and the interval-due check, but still requires heartbeat to
     * useful for filing an issue.
     * user with "unknown error" or a number. Prepending the type name keeps the failure
     * when cutting and appends an ellipsis so the user knows more text exists in the
     * which is the right answer for the daemon-only path.
     */
    )
    /**
    @Volatile
    fun start() {
    private companion object {
    private fun appendExecution(task: ScheduledTask, success: Boolean, message: String?): List<TaskExecutionLogEntry> {
    private fun formatException(e: Exception): String {
    private fun truncateForNotification(text: String): String {
    private suspend fun checkNewEmails(isLoading: () -> Boolean) {
    private suspend fun checkNewSms() {
    private suspend fun handleTaskCompletion(task: ScheduledTask) {
    private suspend fun handleTaskFailure(task: ScheduledTask, error: String? = null) {
    private suspend fun runHeartbeat() {
    private val appSettings: AppSettings? = null,
    private val backgroundDispatcher: CoroutineContext = getBackgroundDispatcher(),
    private val dataRepository: DataRepository,
    private val emailPoller: EmailPoller? = null,
    private val emailStore: EmailStore? = null,
    private val enabled: Boolean = true,
    private val heartbeatManager: HeartbeatManager? = null,
    private val notificationStore: NotificationStore? = null,
    private val schedulerScope = CoroutineScope(
    private val smsPoller: SmsPoller? = null,
    private val smsStore: SmsStore? = null,
    private val taskStore: TaskStore? = null,
    private var activeJob: Job? = null
    suspend fun triggerHeartbeatNow() {
    var appInForeground: Boolean = false
    var isLoadingCheck: () -> Boolean = { false }
    }
) {
@OptIn(ExperimentalTime::class)
class TaskScheduler(
package com.inspiredandroid.kai.data
}
