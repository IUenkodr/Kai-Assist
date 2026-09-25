package com.inspiredandroid.kai.data
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

                    createdAtEpochMs = 0L,
                    description = "Greeting",
                    email = "alice@example.com",
                    email = "bob@example.com",
                    id = "h1",
                    lastError = "AUTHENTICATIONFAILED",
                    lastSyncEpochMs = 0L,
                    lastSyncEpochMs = 1_700_000_000_000L,
                    prompt = "Greet the user warmly.",
                    prompt = "Hi!",
                    prompt = "Say hi",
                    scheduledAtEpochMs = 0L,
                    trigger = TaskTrigger.HEARTBEAT,
                    unreadCount = 0,
                    unreadCount = 1,
                    unreadCount = 3,
                ),
                EmailAccountSummary(
                EmailAccountSummary(email = "alice@example.com", unreadCount = 1, lastSyncEpochMs = 0L),
                ScheduledTask(
                category = MemoryCategory.GENERAL,
                content = "x".repeat(100),
                content = "x".repeat(80),
                key = "g_$i",
                key = "key_$i",
                memory("commit_style", "gerund verbs", category = MemoryCategory.LEARNING, hitCount = 5),
                task(id = "t1", description = "Morning check", cron = "0 9 * * *"),
            "## Automation",
            "## Context",
            "## Context\n" +
            "## Email Accounts",
            "## Heartbeat Additions",
            "## Known Issues & Resolutions",
            "## Learnings",
            "## Scheduled Tasks",
            "## Structured Learning",
            "## Tool Use",
            "## User Preferences",
            "## When to Act",
            "## Your Memories",
            "- Local time: 2026-04-11T02:00:00+02:00 (Europe/Berlin)\n" +
            "- Model: test-model\n" +
            "- Platform: Test\n" +
            "- Provider: Test Provider\n"
            "- UTC: 2026-04-11T00:00:00Z\n" +
            "Basic memory guidance.",
            "Save user preferences with memory_store.\n\n" +
            "You are Kai.",
            )
            ),
            // When-to-act is a general fundamental and still renders.
            DEFAULT_ACTING_SECTION + "\n\n" +
            DEFAULT_HONESTY_RULE + "\n\n" +
            DEFAULT_HONESTY_RULE,
            DEFAULT_TOOL_USE_SECTION + "\n\n" +
            SystemPromptVariant.CHAT_REMOTE,
            activeSkill = skill(bundledFilePaths = listOf("extract.py")),
            assertFalse("## Tool Use" in out)
            assertTrue("## Tool Use" in out)
            assertTrue("## When to Act" in out)
            assertTrue("at most one clarifying question" in out)
            assertTrue("capability is unavailable" in out)
            assertTrue(DEFAULT_HONESTY_RULE in out)
            assertTrue(idx > lastIdx, "Expected '$header' to come after previous section. Output:\n$out")
            assertTrue(idx >= 0, "Expected '$header' in output but was not found. Output:\n$out")
            emailAccounts = listOf(
            errorMemories = listOf(memory("err_key", "small content", category = MemoryCategory.ERROR)),
            errorMemories = listOf(memory("flaky_test", "retry twice", category = MemoryCategory.ERROR)),
            errorMemories = listOf(memory("flaky_test", "retry", category = MemoryCategory.ERROR)),
            errorMemories = listOf(memory("issue", "resolution", category = MemoryCategory.ERROR)),
            generalMemories = big,
            generalMemories = bigGeneral,
            generalMemories = listOf(memory("fact", "value")),
            generalMemories = listOf(memory("user_name", "Alice")),
            hasTools = false,
            heartbeatAdditions = listOf(
            lastIdx = idx
            learningMemories = listOf(
            learningMemories = listOf(memory("learn_key", "small content", category = MemoryCategory.LEARNING)),
            learningMemories = listOf(memory("lesson", "body", category = MemoryCategory.LEARNING, hitCount = 3)),
            learningMemories = listOf(memory("style", "gerunds", category = MemoryCategory.LEARNING, hitCount = 3)),
            memory(
            memoryEnabled = false,
            memoryInstructions = "Basic memory guidance.",
            memoryInstructions = "Save user preferences with memory_store.",
            memoryInstructions = "Use memory_store to save user info.",
            pendingTasks = listOf(
            pendingTasks = listOf(task(description = "Do the thing")),
            pendingTasks = listOf(task(description = "ignored task")),
            pendingTasks = listOf(task(id = "t1", description = "First task")),
            preferenceMemories = listOf(memory("pref", "val", category = MemoryCategory.PREFERENCE)),
            preferenceMemories = listOf(memory("pref_key", "small content", category = MemoryCategory.PREFERENCE)),
            preferenceMemories = listOf(memory("tone", "concise", category = MemoryCategory.PREFERENCE)),
            schedulingEnabled = false,
            soul = "You are Kai, a helpful assistant.",
            soul = "You are Kai.",
            soul = "You're a personal assistant.",
            uiMode = ChatPromptUiMode.DYNAMIC_UI,
            uiMode = ChatPromptUiMode.INTERACTIVE_UI,
            uiMode = ChatPromptUiMode.NONE,
            val idx = out.indexOf(header)
            variant = SystemPromptVariant.CHAT_LOCAL,
            variant = SystemPromptVariant.CHAT_REMOTE,
        )
        // A bloated memory set: 50 entries with long content. Combined size will far
        // Automation guidance but must not drop connected-account context.
        // Budget is 2000 chars; with ~100-char entries we'd fit ~18 entries max.
        // Email Accounts is independent of scheduling — disabling scheduling drops the
        // Fill the GENERAL category to ~1900 chars (close to budget); later categories
        // Guards observed regressions: models inventing tool outputs / file contents and
        // Heartbeat toggle/schedule remain user-only.
        // Just assert the section headers are present in order — the full kai-ui sections
        // Later categories may or may not render depending on exact byte count —
        // No memories or tasks — just the minimal CHAT_LOCAL shape. Memory inclusion
        // Sanity: the memory section portion shouldn't exceed the budget by more than one
        // The fully-deactivated config the user reported: no tools, no memory, no scheduling.
        // The prompt must collapse to the behavioral fundamentals plus runtime context —
        // The three triggers are named.
        // are verified by separate DYNAMIC_UI / INTERACTIVE_UI tests.
        // but the total combined memory section must still be within budget + one entry.
        // entry's worth (we cut at boundaries).
        // exceed LOCAL_MEMORY_BUDGET_CHARS (2000). Later entries should be silently dropped.
        // kai-ui buttons whose labels imply operations the callback can't perform.
        // no Tool Use, Structured Learning, or Automation guidance referencing absent tools.
        // sections are verified as omitted below.
        // should be dropped entirely because the budget is exhausted.
        // with a budget is covered by separate focused tests. Scheduled tasks and kai-ui
        activeSkill = activeSkill,
        activeSkill: com.inspiredandroid.kai.skills.SkillManifest? = null,
        assertEquals(expected, out)
        assertFalse("## Automation" in out)
        assertFalse("## Dynamic UI" in out)
        assertFalse("## Dynamic UI\n" in out)
        assertFalse("## Email Accounts" in out)
        assertFalse("## Heartbeat Additions" in out)
        assertFalse("## Interactive UI Mode" in out)
        assertFalse("## Scheduled Tasks" in out)
        assertFalse("## Structured Learning" in out)
        assertFalse("- **key_50**:" in out, "Last entry should be dropped (budget exhausted)")
        assertFalse("Do the thing" in out)
        assertFalse("alice@example.com" in out)
        assertFalse("kai-ui" in out)
        assertFalse("memory_learn" in out)
        assertFalse("schedule_task" in out)
        assertTrue("## Active skill" !in without)
        assertTrue("## Active skill: pdf-tools" in with)
        assertTrue("## Automation" in out)
        assertTrue("## Context" in out)
        assertTrue("## Dynamic UI" in out)
        assertTrue("## Email Accounts" in out)
        assertTrue("## Heartbeat Additions" in out)
        assertTrue("## Interactive UI Mode (ACTIVE)" in out)
        assertTrue("## Known Issues & Resolutions" in out)
        assertTrue("## Learnings" in out)
        assertTrue("## Scheduled Tasks" in out)
        assertTrue("## Structured Learning" in out)
        assertTrue("## User Preferences" in out)
        assertTrue("## Your Memories" in out)
        assertTrue("- **Greeting** (id: h1): Greet the user warmly." in out)
        assertTrue("- **Morning check** (id: t1" in out)
        assertTrue("- **alice@example.com**: 3 unread" in out)
        assertTrue("- **bob@example.com**: sync failing — AUTHENTICATIONFAILED" in out)
        assertTrue("- **commit_style** (reinforced 5x): gerund verbs" in out)
        assertTrue("- **flaky_test**: retry twice" in out)
        assertTrue("- **flaky_test**: retry" in out)
        assertTrue("- **key_1**:" in out, "First entry should be included")
        assertTrue("- **style** (reinforced 3x): gerunds" in out)
        assertTrue("- **tone**: concise" in out)
        assertTrue("- **user_name**: Alice" in out)
        assertTrue("- Local time: 2026-04-11T02:00:00+02:00 (Europe/Berlin)" in out)
        assertTrue("- Model: test-model" in out)
        assertTrue("- Platform: Test" in out)
        assertTrue("- Provider: Test Provider" in out)
        assertTrue("- UTC: 2026-04-11T00:00:00Z" in out)
        assertTrue("- extract.py" in out)
        assertTrue("Extract text from PDFs." in with)
        assertTrue("Use memory_store to save user info." in out)
        assertTrue("[cron: 0 9 * * *]" in out)
        assertTrue("alice@example.com" in out)
        assertTrue("cron" in out)
        assertTrue("do NOT suggest adding" in out)
        assertTrue("execute_at" in out)
        assertTrue("kai-ui" in out)
        assertTrue("on_heartbeat" in out)
        assertTrue("schedule_task" in out)
        assertTrue("user-controlled" in out)
        assertTrue("~/skills/pdf-tools/" in out)
        assertTrue(memLen <= 2200, "Combined memory sections should respect budget, was $memLen")
        assertTrue(memSectionLen <= 2100, "Memory section should be ~2000 chars, was $memSectionLen")
        assertTrue(out.startsWith("You are Kai."))
        body = body,
        body: String = "Extract text from PDFs.",
        bundledFilePaths = bundledFilePaths,
        bundledFilePaths: List<String> = emptyList(),
        category = category,
        category: MemoryCategory = MemoryCategory.GENERAL,
        content = content,
        content: String,
        createdAt = 0L,
        createdAtEpochMs = 0L,
        cron = cron,
        cron: String? = null,
        description = "desc",
        description = description,
        description: String = "Do the thing",
        displayName = id,
        emailAccounts = emailAccounts,
        emailAccounts: List<EmailAccountSummary> = emptyList(),
        errorMemories = errorMemories,
        errorMemories: List<MemoryEntry> = emptyList(),
        for (header in headerOrder) {
        for (out in listOf(remote, local)) {
        generalMemories = generalMemories,
        generalMemories: List<MemoryEntry> = emptyList(),
        hasTools = hasTools,
        hasTools: Boolean = true,
        heartbeatAdditions = heartbeatAdditions,
        heartbeatAdditions: List<ScheduledTask> = emptyList(),
        hitCount = hitCount,
        hitCount: Int = 1,
        id = id,
        id: String = "pdf-tools",
        id: String = "task-1",
        key = key,
        key: String,
        learningMemories = learningMemories,
        learningMemories: List<MemoryEntry> = emptyList(),
        memoryEnabled = memoryEnabled,
        memoryEnabled: Boolean = true,
        memoryInstructions = memoryInstructions,
        memoryInstructions: String? = null,
        modelId = "test-model",
        nowLocalIsoWithOffset = "2026-04-11T02:00:00+02:00",
        nowUtcIsoString = "2026-04-11T00:00:00Z",
        pendingTasks = pendingTasks,
        pendingTasks: List<ScheduledTask> = emptyList(),
        platform = "Test",
        preferenceMemories = preferenceMemories,
        preferenceMemories: List<MemoryEntry> = emptyList(),
        prompt = "",
        providerName = "Test Provider",
        runtime = runtime,
        scheduledAtEpochMs = scheduledAtEpochMs,
        scheduledAtEpochMs: Long = 0L,
        schedulingEnabled = schedulingEnabled,
        schedulingEnabled: Boolean = true,
        soul = soul,
        soul: String = "You are Kai.",
        timeZoneId = "Europe/Berlin",
        uiMode = uiMode,
        uiMode: ChatPromptUiMode = ChatPromptUiMode.NONE,
        updatedAt = 0L,
        val big = (1..50).map { i ->
        val bigGeneral = (1..19).map { i ->
        val expected = "You are Kai, a helpful assistant.\n\n" +
        val expected = "You're a personal assistant.\n\n" +
        val headerOrder = listOf(
        val local = build(SystemPromptVariant.CHAT_LOCAL)
        val local = build(SystemPromptVariant.CHAT_LOCAL, hasTools = false)
        val memEnd = out.indexOf("## Context")
        val memLen = memEnd - memStart
        val memSectionLen = memEnd - memStart
        val memStart = out.indexOf("## Your Memories")
        val out = build(
        val out = build(SystemPromptVariant.CHAT_LOCAL)
        val out = build(SystemPromptVariant.CHAT_REMOTE)
        val out = build(SystemPromptVariant.CHAT_REMOTE, memoryEnabled = false)
        val out = build(SystemPromptVariant.CHAT_REMOTE, schedulingEnabled = false)
        val out = build(variant = SystemPromptVariant.CHAT_LOCAL)
        val out = build(variant = SystemPromptVariant.CHAT_REMOTE)
        val remote = build(SystemPromptVariant.CHAT_REMOTE)
        val remote = build(SystemPromptVariant.CHAT_REMOTE, hasTools = false)
        val with = build(SystemPromptVariant.CHAT_REMOTE, activeSkill = skill(body = "Extract text from PDFs."))
        val without = build(SystemPromptVariant.CHAT_REMOTE)
        var lastIdx = -1
        variant = variant,
        variant: SystemPromptVariant,
        }
    )
    ) = MemoryEntry(
    ) = ScheduledTask(
    ) = buildChatSystemPrompt(
    ) = com.inspiredandroid.kai.skills.SkillManifest(
    // endregion
    // region CHAT_LOCAL — focused tests
    // region CHAT_REMOTE — focused tests
    // region Golden snapshots
    @Test
    fun `CHAT_LOCAL default emits only soul + context`() {
    fun `CHAT_LOCAL drops lower-priority categories when earlier ones exhaust budget`() {
    fun `CHAT_LOCAL includes memory category sections when within budget`() {
    fun `CHAT_LOCAL includes memory instructions when provided`() {
    fun `CHAT_LOCAL omits Automation section`() {
    fun `CHAT_LOCAL omits Dynamic UI even when uiMode is DYNAMIC_UI`() {
    fun `CHAT_LOCAL omits Email Accounts regardless of input`() {
    fun `CHAT_LOCAL omits Heartbeat Additions regardless of input`() {
    fun `CHAT_LOCAL omits Interactive UI Mode even when uiMode is INTERACTIVE_UI`() {
    fun `CHAT_LOCAL omits Scheduled Tasks regardless of input`() {
    fun `CHAT_LOCAL omits Structured Learning section even with memory instructions`() {
    fun `CHAT_LOCAL truncates memories at entry boundary when over budget`() {
    fun `CHAT_REMOTE Automation section names schedule_task as the future-execution mechanism`() {
    fun `CHAT_REMOTE Email Accounts still render when scheduling is disabled`() {
    fun `CHAT_REMOTE Email Accounts surfaces sync failures via lastError`() {
    fun `CHAT_REMOTE default emits soul + Structured Learning + Automation + context`() {
    fun `CHAT_REMOTE includes Dynamic UI section when uiMode is DYNAMIC_UI`() {
    fun `CHAT_REMOTE includes Email Accounts when list non-empty`() {
    fun `CHAT_REMOTE includes Heartbeat Additions when list non-empty`() {
    fun `CHAT_REMOTE includes Interactive UI Mode section when uiMode is INTERACTIVE_UI`() {
    fun `CHAT_REMOTE includes Known Issues section when error memories present`() {
    fun `CHAT_REMOTE includes Learnings with reinforcement counts`() {
    fun `CHAT_REMOTE includes Scheduled Tasks with cron annotation`() {
    fun `CHAT_REMOTE includes User Preferences when preference memories present`() {
    fun `CHAT_REMOTE includes Your Memories when general memories present`() {
    fun `CHAT_REMOTE includes memory instructions when provided`() {
    fun `CHAT_REMOTE omits Automation when scheduling is disabled`() {
    fun `CHAT_REMOTE omits Email Accounts when list is empty`() {
    fun `CHAT_REMOTE omits Heartbeat Additions when list is empty`() {
    fun `CHAT_REMOTE omits Scheduled Tasks when list is empty`() {
    fun `CHAT_REMOTE omits Structured Learning when memory is disabled`() {
    fun `CHAT_REMOTE omits UI sections when uiMode is NONE`() {
    fun `Tool Use section is composed into both variants`() {
    fun `Tool Use section is omitted when no tools are available`() {
    fun `When to Act section is composed into both variants`() {
    fun `active skill section is absent by default and present when activated`() {
    fun `active skill section lists bundled files with sandbox path`() {
    fun `golden CHAT_LOCAL with soul + memory instructions + context`() {
    fun `golden CHAT_REMOTE with every section enabled`() {
    fun `golden CHAT_REMOTE with everything deactivated is soul + honesty + when-to-act + context`() {
    fun `honesty rule is composed into both variants`() {
    private fun build(
    private fun memory(
    private fun skill(
    private fun task(
    private val runtime = ChatPromptRuntimeContext(
    }
 *
 * If you're adding a new section to the chat system prompt, add a focused test here for
 * Locks in the contract of [buildChatSystemPrompt] for every conditional section and
 * every variant. Golden tests catch ordering/whitespace drift; focused tests document
 * it AND extend the golden tests so the section lands in the right variant.
 * which section is gated by which input.
 */
/**
class ChatSystemPromptBuilderTest {
}
