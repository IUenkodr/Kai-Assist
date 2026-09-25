
            """[{"id":"t1","description":"Morning","prompt":"Do thing","scheduledAtEpochMs":0,"createdAtEpochMs":0,"cron":"0 9 * * *","status":"PENDING","lastResult":null,"consecutiveFailures":0}]""",
            """[{"id":"t1","description":"Old","prompt":"Do thing","scheduledAtEpochMs":1700000000000,"createdAtEpochMs":0,"cron":null,"trigger":"TIME","status":"PENDING","lastResult":null,"consecutiveFailures":0}]""",
            """[{"id":"t1","description":"One shot","prompt":"Do thing","scheduledAtEpochMs":1700000000000,"createdAtEpochMs":0,"cron":null,"status":"PENDING","lastResult":null,"consecutiveFailures":0}]""",
            description = "Greeting",
            description = "One shot",
            prompt = "Do it",
            prompt = "Say hi",
            scheduledAtEpochMs = 0L,
            scheduledAtEpochMs = 1L,
            trigger = TaskTrigger.HEARTBEAT,
            trigger = TaskTrigger.TIME,
        )
        // Due tasks: only the TIME task (due because scheduledAt <= now).
        // First load triggers the upgrade.
        // Heartbeat additions: only the HEARTBEAT task.
        // Pending tasks (chat-visible scheduled): only the TIME task.
        // Simulate pre-migration JSON: no `trigger` field, `cron` is set.
        // Stored JSON should now contain the upgraded trigger field.
        assertEquals("0 9 * * *", tasks[0].cron)
        assertEquals(1, tasks.size)
        assertEquals(TaskTrigger.CRON, tasks[0].trigger)
        assertEquals(TaskTrigger.TIME, tasks[0].trigger)
        assertEquals(emptyList(), tasks[0].recentExecutions)
        assertEquals(listOf("Greeting"), partition.heartbeatAdditions.map { it.description })
        assertEquals(listOf("One shot"), partition.scheduled.map { it.description })
        assertEquals(listOf("One shot"), store.getDueTasks().map { it.description })
        assertEquals(true, storedJson.contains("\"trigger\":\"CRON\""))
        settings.setScheduledTasksJson(
        store.addTask(
        store.getAllTasks()
        val partition = store.getPendingTasksPartitioned()
        val settings = freshSettings()
        val store = TaskStore(settings)
        val storedJson = settings.getScheduledTasksJson()
        val tasks = store.getAllTasks()
    @Test
    fun `addTask with on_heartbeat trigger excludes from getDueTasks and scheduled tasks`() = runTest {
    fun `legacy cron migration persists so later loads don't rewrite`() = runTest {
    fun `legacy cron task without trigger field upgrades to CRON`() = runTest {
    fun `legacy one-shot task without trigger field stays TIME`() = runTest {
    fun `legacy task without recentExecutions field decodes to empty list`() = runTest {
    private fun freshSettings(): AppSettings = AppSettings(MapSettings())
    }
 * Locks in the legacy → `TaskTrigger` migration path in [TaskStore.loadTasks]. Users on
 * be upgraded to `CRON` on first load so the scheduler routes them correctly.
 * field; decoding lands them on the default (`TIME`). Rows that carry a `cron` need to
 * older versions of the app have `ScheduledTask` JSON in settings without a `trigger`
 */
/**
class TaskStoreMigrationTest {
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
package com.inspiredandroid.kai.data
}
