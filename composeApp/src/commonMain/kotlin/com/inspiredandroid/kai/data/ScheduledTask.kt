
     * Empty for HEARTBEAT-trigger tasks — those share the heartbeat-wide log instead.
     * How this task is dispatched. Defaulted to [TaskTrigger.TIME] for backward
     * Most recent execution outcomes, newest first, capped to the last few runs. Surfaced
     * and [TaskStore.loadTasks] upgrades them to CRON when `cron != null`.
     * compatibility — legacy tasks decoded from storage without this field land on TIME,
     * in the task details sheet so users can see why a task isn't producing notifications.
     */
    /**
    val consecutiveFailures: Int = 0,
    val createdAtEpochMs: Long,
    val cron: String? = null,
    val description: String,
    val id: String,
    val lastResult: String? = null,
    val message: String? = null,
    val prompt: String,
    val recentExecutions: List<TaskExecutionLogEntry> = emptyList(),
    val scheduledAt: Instant get() = Instant.fromEpochMilliseconds(scheduledAtEpochMs)
    val scheduledAtEpochMs: Long,
    val status: TaskStatus = TaskStatus.PENDING,
    val success: Boolean,
    val timestampEpochMs: Long,
    val trigger: TaskTrigger = TaskTrigger.TIME,
 *
 *   and `cron` are ignored.
 *   next computed fire time. Stays PENDING; the scheduler advances it after each run.
 *   the time-based poll loop; instead its prompt is appended to the heartbeat message
 *   under `## Heartbeat Additions`. Stays PENDING until cancelled. `scheduledAtEpochMs`
 * - [CRON] — recurring; [ScheduledTask.cron] is the spec, [scheduledAtEpochMs] holds the
 * - [HEARTBEAT] — a standing addition to every heartbeat self-check. Not picked up by
 * - [TIME] — fires once at [ScheduledTask.scheduledAtEpochMs], transitions to COMPLETED.
 * How a scheduled task is dispatched.
 */
)
) {
/**
@Immutable
@Serializable
@file:OptIn(kotlin.time.ExperimentalTime::class)
data class ScheduledTask(
data class TaskExecutionLogEntry(
enum class TaskStatus { PENDING, COMPLETED }
enum class TaskTrigger { TIME, CRON, HEARTBEAT }
import androidx.compose.runtime.Immutable
import kotlin.time.Instant
import kotlinx.serialization.Serializable
package com.inspiredandroid.kai.data
}
