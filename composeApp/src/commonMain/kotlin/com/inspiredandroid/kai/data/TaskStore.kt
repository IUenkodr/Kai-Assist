
                    CronExpression(cron!!).nextAfter(now)?.toEpochMilliseconds() ?: now.toEpochMilliseconds()
                    now.toEpochMilliseconds()
                if (task.trigger == TaskTrigger.TIME && task.cron != null) task.copy(trigger = TaskTrigger.CRON) else task
                it.scheduledAtEpochMs <= now &&
                it.status == TaskStatus.PENDING
                scheduledAtEpochMs
                try {
                }
                } catch (_: Exception) {
            .filter { it.status == TaskStatus.PENDING }
            .partition { it.trigger == TaskTrigger.HEARTBEAT }
            // heartbeat tasks are not time-gated
            TaskTrigger.CRON -> if (scheduledAtEpochMs == 0L) {
            TaskTrigger.HEARTBEAT -> 0L
            TaskTrigger.TIME -> scheduledAtEpochMs
            createdAtEpochMs = now.toEpochMilliseconds(),
            cron = cron,
            description = description,
            id = Uuid.random().toString(),
            if (current.none { it.id == task.id }) current else current.map { if (it.id == task.id) task else it }
            if (removed) current.filterNot { it.id == id } else current
            it.trigger != TaskTrigger.HEARTBEAT &&
            prompt = prompt,
            removed = current.any { it.id == id }
            scheduledAtEpochMs = effectiveScheduledAt,
            trigger = trigger,
            upgraded.takeIf { it != decoded }
            val upgraded = decoded.map { task ->
            }
            } else {
        )
        // Tasks persisted before the `trigger` field existed decode with the default (TIME).
        // Upgrade rows that carry a cron expression to CRON so the scheduler can distinguish
        // first time we see it, so every subsequent load is a no-op.
        // time/cron from heartbeat additions. Returning a non-null list persists the upgrade the
        cron: String? = null,
        description: String,
        itemSerializer = serializer<ScheduledTask>(),
        label = "TaskStore",
        migrate = { decoded ->
        prompt: String,
        read = appSettings::getScheduledTasksJson,
        return PendingTaskPartition(scheduled = scheduled, heartbeatAdditions = additions)
        return removed
        return task
        return tasks.get().filter {
        scheduledAtEpochMs: Long,
        tasks.update { current ->
        tasks.update { it + task }
        trigger: TaskTrigger = if (cron != null) TaskTrigger.CRON else TaskTrigger.TIME,
        val (additions, scheduled) = tasks.get()
        val effectiveScheduledAt = when (trigger) {
        val now = Clock.System.now()
        val now = Clock.System.now().toEpochMilliseconds()
        val task = ScheduledTask(
        var removed = false
        write = appSettings::setScheduledTasksJson,
        }
        },
     * Both pending scheduled tasks and heartbeat additions from a single load. Hot-path
     * callers (chat system prompt, heartbeat prompt) need both lists per invocation;
     * combining avoids re-parsing the tasks JSON twice.
     */
    )
    ): ScheduledTask {
    /**
    fun getAllTasks(): List<ScheduledTask> = tasks.get()
    fun getDueTasks(): List<ScheduledTask> {
    fun getPendingTasksPartitioned(): PendingTaskPartition {
    private val tasks = SettingsJsonList(
    suspend fun addTask(
    suspend fun removeTask(id: String): Boolean {
    suspend fun updateTask(task: ScheduledTask): ScheduledTask {
    val heartbeatAdditions: List<ScheduledTask>,
    val scheduled: List<ScheduledTask>,
    }
)
/** Both pending task lists produced by [TaskStore.getPendingTasksPartitioned]. */
@OptIn(ExperimentalTime::class, ExperimentalUuidApi::class)
class TaskStore(appSettings: AppSettings) {
data class PendingTaskPartition(
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import kotlinx.serialization.serializer
package com.inspiredandroid.kai.data
}
