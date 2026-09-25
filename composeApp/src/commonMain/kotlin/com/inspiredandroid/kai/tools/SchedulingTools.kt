package com.inspiredandroid.kai.tools
import com.inspiredandroid.kai.data.TaskStatus
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.data.TaskTrigger
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_cancel_task_description
import kai.composeapp.generated.resources.tool_cancel_task_name
import kai.composeapp.generated.resources.tool_list_tasks_description
import kai.composeapp.generated.resources.tool_list_tasks_name
import kai.composeapp.generated.resources.tool_schedule_task_description
import kai.composeapp.generated.resources.tool_schedule_task_name
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

                        "created_at_epoch_ms" to task.createdAtEpochMs,
                        "cron" to (task.cron ?: "none"),
                        "description" to task.description,
                        "error" to "execute_at ($executeAt) is in the past — check the Local time in Context and retry (use an offset-qualified value like 2025-03-15T09:00:00+02:00 to avoid UTC/local ambiguity)",
                        "id" to task.id,
                        "last_result" to (task.lastResult ?: "none"),
                        "prompt" to task.prompt,
                        "scheduled_at_epoch_ms" to task.scheduledAtEpochMs,
                        "status" to task.status.name,
                        "success" to false,
                        "trigger" to task.trigger.name,
                    )
                    TaskStatus.valueOf(statusFilter)
                    mapOf(
                    parseIso8601ToEpochMs(executeAt)
                    return mapOf(
                    return mapOf("success" to false, "error" to "Invalid execute_at format: ${e.message}")
                    return mapOf("success" to false, "error" to "Invalid status: $statusFilter. Use PENDING or COMPLETED")
                "count" to filtered.size,
                "cron" to (cron ?: "none"),
                "cron" to ParameterSchema(type = "string", description = "Cron expression for recurring tasks (e.g. '0 9 * * 1' for every Monday at 9am)", required = false),
                "description" to ParameterSchema(type = "string", description = "Human-readable description of the task", required = true),
                "description" to task.description,
                "execute_at" to ParameterSchema(type = "string", description = "ISO 8601 datetime for a one-off run. Either offset-qualified (e.g. '2025-03-15T09:00:00+02:00' or '2025-03-15T07:00:00Z') — interpreted as that exact instant — OR naive (e.g. '2025-03-15T09:00:00') — interpreted in the user's local timezone shown in `## Context`. Prefer offset-qualified to avoid ambiguity. Must be in the future.", required = false),
                "on_heartbeat" to ParameterSchema(type = "boolean", description = "Set to true to run this prompt on every heartbeat self-check. Use for standing additions to heartbeat behaviour.", required = false),
                "prompt" to ParameterSchema(type = "string", description = "For execute_at/cron: the full prompt sent to the AI when it fires. For on_heartbeat: the instruction appended to each heartbeat self-check (e.g. 'Greet the user warmly with a time-appropriate greeting.').", required = true),
                "scheduled_at" to (executeAt ?: "n/a"),
                "status" to ParameterSchema(type = "string", description = "Filter by status: PENDING or COMPLETED", required = false),
                "success" to true,
                "task_id" to ParameterSchema(type = "string", description = "The ID of the task to cancel", required = true),
                "task_id" to task.id,
                "tasks" to filtered.map { task ->
                "trigger" to trigger.name,
                0L // cron and heartbeat tasks don't use this field at creation time
                ?: return mapOf("success" to false, "error" to "Missing description")
                ?: return mapOf("success" to false, "error" to "Missing prompt")
                ?: return mapOf("success" to false, "error" to "Missing task_id")
                allTasks
                allTasks.filter { it.status == status }
                cron != null -> TaskTrigger.CRON
                cron = cron,
                description = description,
                else -> TaskTrigger.TIME
                if (parsed < nowMs - PAST_INSTANT_SLACK_MS) {
                mapOf("success" to false, "error" to "Task not found: $taskId")
                mapOf("success" to true, "task_id" to taskId, "status" to "REMOVED")
                onHeartbeat -> TaskTrigger.HEARTBEAT
                parsed
                prompt = prompt,
                return mapOf("success" to false, "error" to "Exactly one of execute_at, cron, or on_heartbeat must be provided")
                return mapOf("success" to false, "error" to "execute_at, cron, and on_heartbeat are mutually exclusive — pick one")
                scheduledAtEpochMs = scheduledAtEpochMs,
                trigger = trigger,
                val nowMs = Clock.System.now().toEpochMilliseconds()
                val parsed = try {
                val status = try {
                }
                } catch (e: Exception) {
                },
            )
            ),
            // Fall back to LocalDateTime (no timezone) and use system default
            Instant.parse(isoString).toEpochMilliseconds()
            description = "Cancel a scheduled task by its ID. When the user asks to stop, cancel, or remove any scheduled or recurring task, call this tool with the matching task ID from the Scheduled Tasks list. If unsure which task, call list_tasks first.",
            description = "List all scheduled tasks with their IDs, descriptions, and status. Call this before cancel_task if you need to find a task ID. Optionally filter by status.",
            description = "Schedule a prompt to run later, recurring, or on every heartbeat. This is the ONLY way to run something after this turn — reminders, follow-ups, periodic updates, check-ins, standing heartbeat additions (greetings, always-summarise-emails): all go through this tool. Each run starts a fresh conversation, so embed the context the prompt needs. Exactly one trigger must be provided: execute_at (one-off at a datetime), cron (recurring on a schedule), or on_heartbeat=true (appended to every heartbeat self-check). Schedule relative to the **Local time** shown in `## Context`, not UTC.",
            if (triggerCount == 0) {
            if (triggerCount > 1) {
            localDateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
            name = "cancel_task",
            name = "list_tasks",
            name = "schedule_task",
            parameters = mapOf(
            return if (removed) {
            return mapOf(
            val allTasks = taskStore.getAllTasks()
            val cron = args["cron"]?.toString()
            val description = args["description"]?.toString()
            val executeAt = args["execute_at"]?.toString()
            val filtered = if (statusFilter != null) {
            val localDateTime = LocalDateTime.parse(isoString)
            val onHeartbeat = args["on_heartbeat"] as? Boolean ?: false
            val prompt = args["prompt"]?.toString()
            val removed = taskStore.removeTask(taskId)
            val scheduledAtEpochMs = if (executeAt != null) {
            val statusFilter = args["status"]?.toString()?.uppercase()
            val task = taskStore.addTask(
            val taskId = args["task_id"]?.toString()
            val trigger = when {
            val triggerCount = listOf(executeAt != null, cron != null, onHeartbeat).count { it }
            }
            } else {
        )
        // Try parsing as Instant first (with timezone offset)
        cancelTaskTool(taskStore),
        description = "Cancel a scheduled task",
        description = "List all scheduled tasks",
        description = "Schedule a task for future execution",
        descriptionRes = Res.string.tool_cancel_task_description,
        descriptionRes = Res.string.tool_list_tasks_description,
        descriptionRes = Res.string.tool_schedule_task_description,
        id = "cancel_task",
        id = "list_tasks",
        id = "schedule_task",
        listTasksTool(taskStore),
        name = "Cancel Task",
        name = "List Tasks",
        name = "Schedule Task",
        nameRes = Res.string.tool_cancel_task_name,
        nameRes = Res.string.tool_list_tasks_name,
        nameRes = Res.string.tool_schedule_task_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        return try {
        scheduleTaskTool(taskStore),
        userToggleable = false,
        }
        } catch (e: Exception) {
     * Reject execute_at instants more than this far in the past. A small slack covers
     * immediately or (after backoff) silently sit PENDING.
     * larger gaps indicate a UTC/local sign flip that would otherwise either fire
     * round-trip latency between "now" on the AI side and "now" in the tool executor;
     */
    )
    /**
    fun cancelTaskTool(taskStore: TaskStore) = object : Tool {
    fun getSchedulingTools(taskStore: TaskStore): List<Tool> = listOf(
    fun listTasksTool(taskStore: TaskStore) = object : Tool {
    fun scheduleTaskTool(taskStore: TaskStore) = object : Tool {
    private const val PAST_INSTANT_SLACK_MS = 60_000L
    private fun parseIso8601ToEpochMs(isoString: String): Long {
    val cancelTaskToolInfo = ToolInfo(
    val listTasksToolInfo = ToolInfo(
    val scheduleTaskToolInfo = ToolInfo(
    val schedulingToolDefinitions = listOf(scheduleTaskToolInfo, cancelTaskToolInfo, listTasksToolInfo)
    }
@OptIn(ExperimentalTime::class)
object SchedulingTools {
}
