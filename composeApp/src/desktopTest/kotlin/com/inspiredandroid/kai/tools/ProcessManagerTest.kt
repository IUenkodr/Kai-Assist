
        // After removal, list should be empty
        Thread.sleep(200)
        Thread.sleep(2000) // wait for 1s timeout + buffer
        Thread.sleep(500)
        Thread.sleep(500) // let it finish
        assertEquals("6", lines[0]) // seq 1 20, offset 5 means line index 5 = "6"
        assertEquals("finished", log["status"])
        assertEquals("running", result["status"])
        assertEquals(0, list["total"])
        assertEquals(1, list["total"])
        assertEquals(3, lines.size)
        assertEquals(5, log["offset"])
        assertEquals(false, kill["success"])
        assertEquals(false, log["success"])
        assertEquals(false, remove["success"])
        assertEquals(true, killResult["success"])
        assertEquals(true, log["success"])
        assertEquals(true, log["timed_out"])
        assertEquals(true, removeResult["success"])
        assertEquals(true, result["success"])
        assertTrue((killResult["message"] as String).contains("already finished"))
        assertTrue((log["stdout"] as String).contains("hello_world"))
        assertTrue((log["stdout"] as String).contains("test_value_123"))
        assertTrue((result["session_id"] as String).startsWith("bg-"))
        pm.startBackground("echo fast", 10, null, emptyMap())
        val kill = pm.kill("nonexistent")
        val killResult = pm.kill(sessionId)
        val lines = (log["stdout"] as String).trim().lines()
        val list = pm.list()
        val log = pm.log("nonexistent", 0, 200)
        val log = pm.log(sessionId, 0, 200)
        val log = pm.log(sessionId, 5, 3)
        val pm = ProcessManager()
        val remove = pm.remove("nonexistent")
        val removeResult = pm.remove(sessionId)
        val result = pm.startBackground("echo \$MY_TEST_VAR", 10, null, mapOf("MY_TEST_VAR" to "test_value_123"))
        val result = pm.startBackground("echo bye", 10, null, emptyMap())
        val result = pm.startBackground("echo done", 10, null, emptyMap())
        val result = pm.startBackground("echo hello", 10, null, emptyMap())
        val result = pm.startBackground("echo hello_world", 10, null, emptyMap())
        val result = pm.startBackground("seq 1 20", 10, null, emptyMap())
        val result = pm.startBackground("sleep 60", 1, null, emptyMap())
        val result = pm.startBackground("sleep 60", 120, null, emptyMap())
        val sessionId = result["session_id"] as String
    @Test
    fun backgroundProcessTimesOut() {
    fun envVariablesArePassedThrough() {
    fun killAlreadyFinishedProcess() {
    fun killTerminatesRunningProcess() {
    fun listShowsRunningAndFinished() {
    fun logReturnsOutput() {
    fun logWithOffsetAndLimit() {
    fun removeSession() {
    fun startBackgroundReturnsSessionId() {
    fun unknownSessionReturnsError() {
    }
class ProcessManagerTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.tools
}
