package com.inspiredandroid.kai.data
import kotlin.time.Instant

                append(" (last sync: ")
                append(" [cron: ")
                append(" — ")
                append(")")
                append(": ")
                append("]")
                append(Instant.fromEpochMilliseconds(account.lastSyncEpochMs))
                append(msg.preview)
                append(notif.preview)
                append(notif.title)
                append(t.cron)
            append(" (id: ")
            append(" [")
            append(" unread")
            append(")")
            append("): ")
            append("** (hits: ")
            append("** (id: ")
            append("** — ")
            append("**")
            append("**: ")
            append(", category: ")
            append(", scheduled: ")
            append("- **")
            append(". ")
            append("]")
            append('\n')
            append(account.email)
            append(account.unreadCount)
            append(addition.description)
            append(addition.id)
            append(addition.prompt)
            append(entry.category)
            append(entry.content)
            append(entry.hitCount)
            append(entry.key)
            append(i + 1)
            append(msg.accountEmail)
            append(msg.from)
            append(msg.from.ifBlank { "(unknown sender)" })
            append(msg.id)
            append(msg.subject.ifBlank { "(no subject)" })
            append(notif.appLabel.ifBlank { "(unknown app)" })
            append(notif.id)
            append(response)
            append(t.description)
            append(t.id)
            append(t.scheduledAt)
            if (account.lastSyncEpochMs > 0) {
            if (msg.preview.isNotBlank()) {
            if (notif.preview.isNotBlank()) {
            if (notif.title.isNotBlank()) {
            if (t.cron != null) {
            }
        append("+ times. ")
        append("Consider using the promote_learning tool to add well-established patterns to your soul/system prompt:\n")
        append("Standing instructions the user asked to run on every heartbeat. Address each in your response alongside the main self-check — if all are satisfied and nothing else needs attention, respond with your acknowledgement rather than HEARTBEAT_OK (the additions are the attention).\n")
        append("These SMS arrived since the last heartbeat. Summarise briefly; only flag items that genuinely need attention.\n")
        append("These arrived since the last heartbeat. Summarise briefly; only flag items that genuinely need attention.\n")
        append("These memories have been reinforced ")
        append("These notifications arrived since the last heartbeat. Summarise briefly; only flag items that genuinely need attention.\n")
        append("\n## Email Status\n")
        append("\n## Heartbeat Additions\n")
        append("\n## New Emails\n")
        append("\n## New Notifications\n")
        append("\n## New SMS\n")
        append("\n## Pending Tasks\n")
        append("\n## Previous Heartbeat Results\n")
        append("\n## Promotion Candidates\n")
        append(promotionCandidates.first().hitCount)
        for ((i, response) in recentResponses.withIndex()) {
        for (account in emailAccounts) {
        for (addition in heartbeatAdditions) {
        for (entry in promotionCandidates) {
        for (msg in pendingEmails) {
        for (msg in pendingSms) {
        for (notif in pendingNotifications) {
        for (t in pendingTasks) {
        }
    append("\n")
    append(customOrDefaultPrompt)
    customOrDefaultPrompt: String,
    emailAccounts: List<EmailAccountSummary>,
    heartbeatAdditions: List<ScheduledTask>,
    if (emailAccounts.isNotEmpty()) {
    if (heartbeatAdditions.isNotEmpty()) {
    if (pendingEmails.isNotEmpty()) {
    if (pendingNotifications.isNotEmpty()) {
    if (pendingSms.isNotEmpty()) {
    if (pendingTasks.isNotEmpty()) {
    if (promotionCandidates.isNotEmpty()) {
    if (recentResponses.isNotEmpty()) {
    pendingEmails: List<HeartbeatPendingEmail>,
    pendingNotifications: List<HeartbeatPendingNotification>,
    pendingSms: List<HeartbeatPendingSms>,
    pendingTasks: List<ScheduledTask>,
    promotionCandidates: List<HeartbeatPromotionCandidate>,
    recentResponses: List<String>,
    val accountEmail: String,
    val appLabel: String,
    val category: MemoryCategory,
    val content: String,
    val from: String,
    val hitCount: Int,
    val id: Long,
    val id: String,
    val key: String,
    val preview: String,
    val subject: String,
    val title: String,
    }
 *
 * @param customOrDefaultPrompt leading free text — custom user prompt or [HeartbeatManager.DEFAULT_HEARTBEAT_PROMPT]
 * @param emailAccounts email account statuses; empty list = section omitted
 * @param heartbeatAdditions tasks with trigger=HEARTBEAT; rendered as `## Heartbeat Additions` so their prompts run on every heartbeat. Empty list = section omitted
 * @param pendingEmails new emails polled since the last heartbeat pickup; empty list = section omitted
 * @param pendingNotifications new notifications captured since the last heartbeat pickup; empty list = section omitted
 * @param pendingSms new SMS polled since the last heartbeat pickup; empty list = section omitted
 * @param pendingTasks time/cron tasks to include in the `## Pending Tasks` section (heartbeat tasks belong to [heartbeatAdditions] instead); empty list = section omitted
 * @param promotionCandidates memory promotion candidates; empty list = section omitted
 * @param recentResponses last heartbeat responses to include for continuity; empty list = section omitted
 * Composes the heartbeat prompt.
 */
)
): String = buildString {
/**
/** A pending (captured-but-not-yet-heartbeat-picked-up) notification rendered into the `## New Notifications` section. */
/** A pending (polled-but-not-yet-heartbeat-picked-up) SMS rendered into the `## New SMS` section. */
/** A pending (polled-but-not-yet-heartbeat-picked-up) email rendered into the `## New Emails` section. */
/** Memory promotion candidate rendered into the `## Promotion Candidates` section. */
// Pure builder for the heartbeat USER-message prompt. Like `buildChatSystemPrompt`,
// The heartbeat prompt is a single shape — always sent as a user message.
// every input is explicit so tests can call it directly with hand-crafted inputs.
@file:OptIn(kotlin.time.ExperimentalTime::class)
internal data class HeartbeatPendingEmail(
internal data class HeartbeatPendingNotification(
internal data class HeartbeatPendingSms(
internal data class HeartbeatPromotionCandidate(
internal fun buildHeartbeatPrompt(
}
