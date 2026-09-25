package com.inspiredandroid.kai.tools
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.TaskStore
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.Clock
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

            "description" to "t",
            "execute_at" to executeAt,
            "prompt" to "p",
            .minus(2.hours)
            .plus(10.minutes)
            .toLocalDateTime(zone)
            .toString()
            .toString() // no offset suffix
        ),
        // 2 hours in the past, in local time — the typical sign-flip symptom.
        // A naive string 10 minutes in the future in local time — mirrors what the
        // model produces after `get_local_time` + relative arithmetic.
        assertEquals(0, store.getAllTasks().size)
        assertEquals(false, result["success"])
        assertEquals(true, result["success"])
        assertEquals(true, result["success"], "expected success but got: $result")
        assertTrue("Invalid execute_at format" in result["error"].toString())
        assertTrue("Local time" in error, "error should point at Local time: $error")
        assertTrue("Local time" in schema.description, "top-level description should reference Local time: ${schema.description}")
        assertTrue("in the past" in error, "error should mention past: $error")
        assertTrue("local timezone" in executeAtDesc, "execute_at should explain local-vs-offset: $executeAtDesc")
        executeAt: String,
        mapOf(
        schedule(past, store)
        store: TaskStore = freshStore(),
        val error = result["error"]?.toString().orEmpty()
        val executeAtDesc = schema.parameters["execute_at"]?.description.orEmpty()
        val iso = nowPlus1h.toString() // e.g. "2026-04-22T21:29:39.123Z"
        val naive = Clock.System.now()
        val nowPlus1h = Clock.System.now().plus(1.hours)
        val past = Clock.System.now()
        val past = Clock.System.now().minus(1.hours).toString()
        val past = Clock.System.now().minus(2.hours).toString()
        val result = schedule("not-a-datetime")
        val result = schedule(iso)
        val result = schedule(naive)
        val result = schedule(past)
        val schema = SchedulingTools.scheduleTaskTool(freshStore()).schema
        val store = freshStore()
        val zone = TimeZone.currentSystemDefault()
    ) as Map<*, *>
    ): Map<*, *> = SchedulingTools.scheduleTaskTool(store).execute(
    @Test
    fun `malformed execute_at returns Invalid execute_at format error`() = runTest {
    fun `naive future local datetime succeeds`() = runTest {
    fun `offset-qualified future instant succeeds`() = runTest {
    fun `past naive datetime is rejected with guidance message`() = runTest {
    fun `past offset-qualified instant is rejected`() = runTest {
    fun `past-instant rejection does not persist the task`() = runTest {
    fun `tool description mentions local timezone handling`() {
    private fun freshStore(): TaskStore = TaskStore(AppSettings(MapSettings()))
    private suspend fun schedule(
    }
 * Contract tests for `schedule_task`'s `execute_at` parsing and the past-instant guard.
 * The tool rejects past-dated values so a UTC/local sign flip fails loudly on the same
 * turn instead of either firing instantly or (after backoff) silently sitting PENDING.
 */
/**
@file:OptIn(kotlin.time.ExperimentalTime::class)
class SchedulingToolsTest {
}
