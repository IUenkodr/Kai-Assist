
                    accountEmail = "me@example.com",
                    category = MemoryCategory.LEARNING,
                    category = MemoryCategory.PREFERENCE,
                    content = "concise",
                    content = "gerund verbs",
                    from = "+1234567890",
                    from = "boss@example.com",
                    from = "sender@example.com",
                    hitCount = 5,
                    hitCount = 7,
                    id = 42L,
                    key = "commit_style",
                    key = "style",
                    preview = "",
                    preview = "Please review the doc.",
                    preview = "Your verification code is 123456",
                    preview = "hello",
                    prompt = "Say hi warmly.",
                    subject = "",
                    subject = "Hi",
                    subject = "Urgent",
                    trigger = TaskTrigger.HEARTBEAT,
                ),
                EmailAccountSummary(email = "me@example.com", unreadCount = 0, lastSyncEpochMs = 0L),
                EmailAccountSummary(email = "me@example.com", unreadCount = 2, lastSyncEpochMs = 0L),
                EmailAccountSummary(email = "me@example.com", unreadCount = 3, lastSyncEpochMs = 1000L),
                EmailAccountSummary(email = "work@example.com", unreadCount = 0, lastSyncEpochMs = 0L),
                HeartbeatPendingEmail(
                HeartbeatPendingSms(
                HeartbeatPendingSms(id = 99L, from = "+15551234", preview = "code 4242"),
                HeartbeatPromotionCandidate(
                task(id = "h1", description = "Greeting").copy(
                task(id = "t1", description = "Morning check", cron = "0 9 * * *"),
            "## Email Status",
            "## New Emails",
            "## New SMS",
            "## Pending Tasks",
            "## Previous Heartbeat Results",
            "## Promotion Candidates",
            "- **+15551234** (id: 99): code 4242",
            "- **First** (id: t1",
            "- **Hi** — sender@example.com [me@example.com]: hello",
            "- **me@example.com**: 2 unread",
            "- **style** (hits: 5, category: PREFERENCE): concise",
            "1. HEARTBEAT_OK",
            "[HEARTBEAT] check",
            "reinforced 5+ times",
            ),
            assertTrue(idx > lastIdx, "Expected '$header' to come after previous section. Output:\n$out")
            assertTrue(idx >= 0, "Expected '$header' in output but was not found. Output:\n$out")
            customOrDefaultPrompt = "[HEARTBEAT] check",
            emailAccounts = listOf(
            heartbeatAdditions = listOf(
            lastIdx = idx
            pendingEmails = listOf(
            pendingSms = listOf(
            pendingSms = listOf(HeartbeatPendingSms(id = 7L, from = "", preview = "")),
            pendingTasks = listOf(
            pendingTasks = listOf(task(id = "t1", description = "First")),
            pendingTasks = listOf(task(id = "t1", description = "One shot")),
            promotionCandidates = listOf(
            recentResponses = listOf("HEARTBEAT_OK"),
            val idx = out.indexOf(header)
        )
        // First account has a positive lastSync → include timestamp suffix
        // Section headers in the exact order they must appear.
        assertEquals("[HEARTBEAT] check yourself\n", out)
        assertFalse("## Email Status" in out)
        assertFalse("## Heartbeat Additions" in out)
        assertFalse("## New Emails" in out)
        assertFalse("## New SMS" in out)
        assertFalse("## Pending Tasks" in out)
        assertFalse("## Previous Heartbeat Results" in out)
        assertFalse("## Promotion Candidates" in out)
        assertFalse("[cron:" in out)
        assertFalse("last sync:" in out)
        assertTrue("## Email Status" in out)
        assertTrue("## Heartbeat Additions" in out)
        assertTrue("## New Emails" in out)
        assertTrue("## New SMS" in out)
        assertTrue("## Pending Tasks" in out)
        assertTrue("## Previous Heartbeat Results" in out)
        assertTrue("## Promotion Candidates" in out)
        assertTrue("- **(no subject)** — sender@example.com [me@example.com]\n" in out)
        assertTrue("- **(unknown sender)** (id: 7)\n" in out)
        assertTrue("- **+1234567890** (id: 42): Your verification code is 123456" in out)
        assertTrue("- **Greeting** (id: h1): Say hi warmly." in out)
        assertTrue("- **Morning check** (id: t1" in out)
        assertTrue("- **One shot** (id: t1" in out)
        assertTrue("- **Urgent** — boss@example.com [me@example.com]: Please review the doc." in out)
        assertTrue("- **commit_style** (hits: 7, category: LEARNING): gerund verbs" in out)
        assertTrue("- **me@example.com**: 0 unread\n" in out)
        assertTrue("- **me@example.com**: 3 unread" in out)
        assertTrue("- **work@example.com**: 0 unread" in out)
        assertTrue("1. HEARTBEAT_OK" in out)
        assertTrue("2. All fine" in out)
        assertTrue("[cron: 0 9 * * *]" in out)
        assertTrue("last sync:" in out)
        assertTrue("promote_learning" in out)
        assertTrue("reinforced 7+ times" in out)
        createdAtEpochMs = 0L,
        cron = cron,
        cron: String? = null,
        customOrDefaultPrompt = customOrDefaultPrompt,
        customOrDefaultPrompt: String = "[TEST HEARTBEAT]",
        description = description,
        description: String = "Do the thing",
        emailAccounts = emailAccounts,
        emailAccounts: List<EmailAccountSummary> = emptyList(),
        for (header in order) {
        heartbeatAdditions = heartbeatAdditions,
        heartbeatAdditions: List<ScheduledTask> = emptyList(),
        id = id,
        id: String = "task-1",
        pendingEmails = pendingEmails,
        pendingEmails: List<HeartbeatPendingEmail> = emptyList(),
        pendingNotifications = pendingNotifications,
        pendingNotifications: List<HeartbeatPendingNotification> = emptyList(),
        pendingSms = pendingSms,
        pendingSms: List<HeartbeatPendingSms> = emptyList(),
        pendingTasks = pendingTasks,
        pendingTasks: List<ScheduledTask> = emptyList(),
        promotionCandidates = promotionCandidates,
        promotionCandidates: List<HeartbeatPromotionCandidate> = emptyList(),
        prompt = "",
        recentResponses = recentResponses,
        recentResponses: List<String> = emptyList(),
        scheduledAtEpochMs = scheduledAtEpochMs,
        scheduledAtEpochMs: Long = 0L,
        val order = listOf(
        val out = build(
        val out = build()
        val out = build(customOrDefaultPrompt = "[HEARTBEAT] check yourself")
        val out = build(recentResponses = listOf("HEARTBEAT_OK", "All fine"))
        var lastIdx = -1
        }
    )
    ) = ScheduledTask(
    ) = buildHeartbeatPrompt(
    @Test
    fun `Email Status omits last sync suffix when lastSync is zero`() {
    fun `New Emails renders placeholder for blank subject and omits empty preview`() {
    fun `New SMS renders placeholder for blank sender and omits empty preview`() {
    fun `default emits only the opening prompt and a trailing newline`() {
    fun `golden full heartbeat prompt with every section`() {
    fun `includes Email Status line per account with unread count`() {
    fun `includes Heartbeat Additions when list non-empty`() {
    fun `includes New Emails with subject from account and preview`() {
    fun `includes New SMS with sender and preview`() {
    fun `includes Pending Tasks with cron annotation when task has cron`() {
    fun `includes Pending Tasks without cron annotation for one-shot tasks`() {
    fun `includes Previous Heartbeat Results when recentResponses non-empty`() {
    fun `includes Promotion Candidates with hit count and category`() {
    fun `omits Email Status when no accounts`() {
    fun `omits Heartbeat Additions when list is empty`() {
    fun `omits New Emails when empty`() {
    fun `omits New SMS when empty`() {
    fun `omits Pending Tasks when empty`() {
    fun `omits Previous Heartbeat Results when empty`() {
    fun `omits Promotion Candidates when empty`() {
    private fun build(
    private fun task(
    }
 *
 * If you're adding a new section to the heartbeat prompt, add a focused test here for it.
 * Locks in the contract of [buildHeartbeatPrompt]. Each conditional section has its own
 * focused test; the golden test catches ordering/whitespace drift.
 */
/**
class HeartbeatPromptBuilderTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
package com.inspiredandroid.kai.data
}
