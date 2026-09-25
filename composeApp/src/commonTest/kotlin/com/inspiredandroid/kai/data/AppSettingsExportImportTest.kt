package com.inspiredandroid.kai.data
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                        "scheduledAtEpochMs": 1000, "createdAtEpochMs": 1000}]""",
                        Conversation.Message(id = "msg1", role = "user", content = "Hello"),
                        Conversation.Message(id = "msg2", role = "assistant", content = "Hi there!"),
                        {"bad": "entry"},
                        {"id": "conv1", "messages": [{"id": "m1", "role": "user", "content": "Hi"}], "createdAt": 1000, "updatedAt": 2000, "title": "Good"},
                        {"id": "conv3", "messages": [], "createdAt": 3000, "updatedAt": 4000}
                        {"prompt": "Another task"}
                        {"prompt": "Remind me", "description": "test"},
                    """[
                    """[{"id": "c1", "messages": [], "createdAt": 1000, "updatedAt": 2000}]""",
                    """[{"id": "t1", "prompt": "test", "description": "d", "status": "INVALID_STATUS",
                    """[{"instanceId":"compat1","api_key":"","base_url":"http://localhost:11434"}]""",
                    """[{"instanceId":"compat1","base_url":"http://localhost:11434/v1"}]""",
                    """[{"instanceId":"compat1","serviceId":"openai-compatible"}]""",
                    """[{"key": "m1", "content": "User likes cats"}]""",
                    """[{"key": "m1", "content": "prefers dark mode", "createdAt": "not-a-number", "updatedAt": "also-not", "category": "PREFERENCE", "hitCount": "3", "source": "chat"}]""",
                    """[{"key": "m2", "content": "test", "createdAt": "bad", "updatedAt": "bad", "category": "NONEXISTENT"}]""",
                    ),
                    ]""",
                    createdAt = 1000L,
                    createdAt = 3000L,
                    id = "conv1",
                    id = "conv2",
                    messages = listOf(
                    messages = listOf(Conversation.Message(id = "msg3", role = "user", content = "Heartbeat")),
                    title = "HB",
                    title = "Test chat",
                    type = Conversation.TYPE_CHAT,
                    type = Conversation.TYPE_HEARTBEAT,
                    updatedAt = 2000L,
                    updatedAt = 4000L,
                "agent_memories" to Json.parseToJsonElement(
                "agent_memories" to Json.parseToJsonElement("""[{"key":"m1"},{"key":"m2"},{"key":"m3"}]"""),
                "agent_memories" to Json.parseToJsonElement("""[{"key":"m1"}]"""),
                "configured_services" to Json.parseToJsonElement(
                "configured_services" to Json.parseToJsonElement("""[{"instanceId":"new_instance","serviceId":"openai"}]"""),
                "conversations" to Json.parseToJsonElement(
                "daemon_enabled" to JsonPrimitive(true),
                "instance_settings" to Json.parseToJsonElement(
                "instance_settings" to Json.parseToJsonElement("""[{"instanceId":"new_instance","api_key":"new-key"}]"""),
                "mcp_servers" to Json.parseToJsonElement("""[{"id":"srv1"},{"id":"srv2"}]"""),
                "mcp_servers" to Json.parseToJsonElement("""[{"id":"srv1"}]"""),
                "memory_enabled" to JsonPrimitive(false),
                "memory_enabled" to JsonPrimitive(true),
                "scheduled_tasks" to Json.parseToJsonElement(
                "scheduling_enabled" to JsonPrimitive(true),
                "soul_text" to Json.parseToJsonElement("[1,2,3]"), // malformed: array instead of string
                "soul_text" to JsonPrimitive("New soul"),
                "soul_text" to JsonPrimitive("hello"),
                "tool_overrides" to Json.parseToJsonElement("""{"tool_a": false}"""),
                "unknown_future_key" to JsonPrimitive("should be ignored"),
                "version" to JsonPrimitive(1),
                ),
                Conversation(
                Conversation(id = "conv1", messages = emptyList(), createdAt = 1000L, updatedAt = 2000L),
                ServiceInstance("gemini", "gemini"),
                ServiceInstance("openai", "openai"),
                createdAt = 1000L,
                id = "conv1",
                messages = listOf(Conversation.Message(id = "msg1", role = "user", content = "Hello")),
                title = "Test chat",
                updatedAt = 2000L,
                {"instanceId": "gemini", "api_key": "gem-key"}
                {"instanceId": "gemini", "serviceId": "gemini"}
                {"instanceId": "openai", "api_key": "sk-abc", "model_id": "gpt-4o"},
                {"instanceId": "openai", "serviceId": "openai"},
            """[{"id":"t1","description":"desc","prompt":"p","scheduledAtEpochMs":1000,"createdAtEpochMs":2000,"cron":null,"status":"COMPLETED","lastResult":"done"}]""",
            "agent_memories": [{"key": "m1", "content": "User likes cats", "category": "PREFERENCE"}],
            "configured_services": [
            "current_service_id": "openai",
            "email_accounts": [{"id": "em1", "email": "user@example.com"}],
            "email_enabled": true,
            "email_passwords": {"em1": "p4ss"},
            "email_poll_interval": 10,
            "email_sync_states": {"em1": {"lastUid": 100}},
            "free_fallback_enabled": false,
            "heartbeat_config": {"enabled": true, "intervalMinutes": 45, "activeHoursStart": 9, "activeHoursEnd": 21},
            "heartbeat_log": [{"timestamp": "2025-06-01T12:00:00Z"}],
            "heartbeat_prompt": "Check on things",
            "instance_settings": [
            "mcp_servers": [{"id": "mcp1", "name": "Local", "url": "http://localhost:3000"}]
            "memory_enabled": true,
            "scheduled_tasks": [{"id": "task1", "prompt": "Remind me"}],
            "scheduling_enabled": false,
            "soul_text": "Be helpful.",
            "tool_overrides": {"tool_a": false, "tool_b": true},
            "version": 1,
            ),
            Conversation(
            ],
            conversations = listOf(
            listOf(
            listOf(ServiceInstance("old_instance", "openai")),
            listOf(ServiceInstance("openai-compatible", "openai-compatible")),
            mapOf(
        """.trimIndent()
        )
        // Check counts
        // Email
        // Heartbeat
        // Import JSON that only has version — missing keys should reset to defaults
        // Import with only tool_a override — tool_b should be reset
        // MCP
        // Memory
        // Memory and MCP should be preserved
        // Memory and MCP should be reset to defaults
        // Memory and MCP should be unchanged (merge mode)
        // New instance keys should be set
        // Old instance keys should be cleared
        // Only import SOUL section, merge mode (leave others unchanged)
        // Only import SOUL, merge mode — unselected sections stay unchanged
        // Only import SOUL, replace mode — unselected sections reset to defaults
        // Parse back and import into a fresh instance
        // Per-instance
        // SMS defaults: all flags false. exportToJson still writes them, but detection should ignore.
        // Scheduling
        // Services
        // Soul
        // Tools
        // Tools is the only section that always has data on a fresh install (default tool states).
        // Use the export from a settings instance with proper tasks
        // createdAt as non-numeric string forces the primary decode to fail,
        // exercising the manual-extraction fallback in sanitizeMemories()
        // tool_c has no explicit override, but is exported with its default (true)
        appSettings.importFromJson(json, toolIds, sections = setOf(ImportSection.SOUL), replace = true)
        appSettings.selectService(Service.OpenAI)
        appSettings.setConfiguredServiceInstances(
        appSettings.setConversationsJson(SharedJson.encodeToString(convData))
        appSettings.setDaemonEnabled(true)
        appSettings.setEmailAccountsJson("""[{"id":"acc1","email":"test@test.com"}]""")
        appSettings.setEmailEnabled(false)
        appSettings.setEmailPassword("acc1", "secret123")
        appSettings.setEmailPollIntervalMinutes(30)
        appSettings.setEmailSyncStateJson("acc1", """{"lastUid":42}""")
        appSettings.setFreeFallbackEnabled(false)
        appSettings.setHeartbeatConfigJson("""{"enabled":true,"intervalMinutes":60}""")
        appSettings.setHeartbeatLogJson("""[{"timestamp":"2025-01-01"}]""")
        appSettings.setHeartbeatPrompt("Check tasks")
        appSettings.setInstanceApiKey("openai", "sk-key")
        appSettings.setInstanceBaseUrl("gemini", "https://custom.url")
        appSettings.setInstanceBaseUrl("openai-compatible", "https://api.example.com/v1")
        appSettings.setInstanceCustomModelId("openai-compatible", "glm-4.7-flash")
        appSettings.setInstanceModelId("openai", "gpt-4")
        appSettings.setInstanceModelId("openai-compatible", "listed")
        appSettings.setInstanceUseCustomModel("openai-compatible", true)
        appSettings.setMcpServersJson("""[{"id":"a","name":"A","url":"http://x"},{"id":"b","name":"B","url":"http://y"}]""")
        appSettings.setMcpServersJson("""[{"id":"srv1","name":"Test","url":"http://localhost"}]""")
        appSettings.setMcpServersJson("""[{"id":"srv1"}]""")
        appSettings.setMcpServersJson("[]")
        appSettings.setMemoriesJson("""[{"key":"k1","value":"v1","category":"GENERAL"}]""")
        appSettings.setMemoryEnabled(false)
        appSettings.setMemoryEnabled(true)
        appSettings.setScheduledTasksJson(
        appSettings.setScheduledTasksJson("""[{"id":"t1","prompt":"test"}]""")
        appSettings.setSchedulingEnabled(false)
        appSettings.setSchedulingEnabled(true)
        appSettings.setSmsEnabled(true)
        appSettings.setSoulText("New soul")
        appSettings.setSoulText("Test soul")
        appSettings.setSoulText("Test")
        appSettings.setSoulText("You are a helpful pirate.")
        appSettings.setSplinterlandsAccountJson("""{"username":"alice"}""")
        appSettings.setSplinterlandsEnabled(true)
        appSettings.setToolEnabled("tool_a", false)
        appSettings.setToolEnabled("tool_b", true)
        appSettings.setUiScale(1.5f)
        appSettings.trackAppOpen()
        assertContains(sections.keys, ImportSection.MCP)
        assertContains(sections.keys, ImportSection.MEMORY)
        assertContains(sections.keys, ImportSection.SOUL)
        assertEquals("", appSettings.getConversationsJson())
        assertEquals("", target.getInstanceApiKey("old_instance"))
        assertEquals("", target.getInstanceModelId("old_instance"))
        assertEquals("", target.getMcpServersJson())
        assertEquals("", target.getMcpServersJson()) // default is empty
        assertEquals("", target.getMemoriesJson())
        assertEquals("", target.getSoulText())
        assertEquals("1", sections[ImportSection.CONVERSATIONS])
        assertEquals("1", sections[ImportSection.MEMORY])
        assertEquals("2", sections[ImportSection.MCP])
        assertEquals("3", sections[ImportSection.MEMORY])
        assertEquals("Be helpful.", target.getSoulText())
        assertEquals("Check on things", target.getHeartbeatPrompt())
        assertEquals("Check tasks", target.getHeartbeatPrompt())
        assertEquals("New soul", target.getSoulText())
        assertEquals("Remind me", tasks[0].prompt)
        assertEquals("Test chat", imported.conversations[0].title)
        assertEquals("Test soul", target.getSoulText())
        assertEquals("User likes cats", memories[0].content)
        assertEquals("You are a helpful pirate.", target.getSoulText())
        assertEquals("chat", memories[0].source)
        assertEquals("conv1", conversations[0].jsonObject["id"]?.jsonPrimitive?.content)
        assertEquals("conv1", imported.conversations[0].id)
        assertEquals("conv2", imported.conversations[1].id)
        assertEquals("conv3", imported.conversations[1].id)
        assertEquals("desc", tasks[0].description)
        assertEquals("done", tasks[0].lastResult)
        assertEquals("gem-key", target.getInstanceApiKey("gemini"))
        assertEquals("gemini", instances[1].instanceId)
        assertEquals("gemini", instances[1].serviceId)
        assertEquals("glm-4.7-flash", target.getInstanceCustomModelId("openai-compatible"))
        assertEquals("glm-4.7-flash", target.getInstanceEffectiveModelId("openai-compatible"))
        assertEquals("gpt-4", target.getInstanceModelId("openai"))
        assertEquals("gpt-4o", target.getInstanceModelId("openai"))
        assertEquals("hello", target.getSoulText())
        assertEquals("http://localhost:11434/v1", target.getInstanceBaseUrl("compat1"))
        assertEquals("https://custom.url", target.getInstanceBaseUrl("gemini"))
        assertEquals("listed", target.getInstanceModelId("openai-compatible"))
        assertEquals("m1", memories[0].key)
        assertEquals("new-key", target.getInstanceApiKey("new_instance"))
        assertEquals("openai", instances[0].instanceId)
        assertEquals("openai", instances[0].serviceId)
        assertEquals("p", tasks[0].prompt)
        assertEquals("p4ss", target.getEmailPassword("em1"))
        assertEquals("prefers dark mode", memories[0].content)
        assertEquals("secret123", target.getEmailPassword("acc1"))
        assertEquals("sk-abc", target.getInstanceApiKey("openai"))
        assertEquals("sk-key", target.getInstanceApiKey("openai"))
        assertEquals("t1", tasks[0].id)
        assertEquals(0, errors)
        assertEquals(1, conversations.size)
        assertEquals(1, errors) // soul_text section fails
        assertEquals(1, json["version"]?.jsonPrimitive?.int)
        assertEquals(1, memories.size)
        assertEquals(1, tasks.size)
        assertEquals(10, target.getEmailPollIntervalMinutes())
        assertEquals(1000L, tasks[0].scheduledAtEpochMs)
        assertEquals(2, imported.conversations.size)
        assertEquals(2, imported.conversations[0].messages.size)
        assertEquals(2, instances.size)
        assertEquals(2, tasks.size)
        assertEquals(2000L, tasks[0].createdAtEpochMs)
        assertEquals(3, memories[0].hitCount)
        assertEquals(30, target.getEmailPollIntervalMinutes())
        assertEquals(Conversation.TYPE_HEARTBEAT, imported.conversations[1].type)
        assertEquals(MemoryCategory.GENERAL, memories[0].category)
        assertEquals(MemoryCategory.PREFERENCE, memories[0].category)
        assertEquals(Service.OpenAI, target.currentService())
        assertEquals(TaskStatus.COMPLETED, tasks[0].status)
        assertEquals(TaskStatus.PENDING, tasks[0].status)
        assertEquals(false, json["tool_overrides"]?.jsonObject?.get("tool_a")?.jsonPrimitive?.boolean)
        assertEquals(setOf(ImportSection.TOOLS), sections.keys)
        assertEquals(true, json["tool_overrides"]?.jsonObject?.get("tool_b")?.jsonPrimitive?.boolean)
        assertEquals(true, json["tool_overrides"]?.jsonObject?.get("tool_c")?.jsonPrimitive?.boolean)
        assertFalse(ImportSection.EMAIL in sections)
        assertFalse(ImportSection.HEARTBEAT in sections)
        assertFalse(ImportSection.MCP in sections)
        assertFalse(ImportSection.MEMORY in sections)
        assertFalse(ImportSection.SCHEDULING in sections)
        assertFalse(ImportSection.SERVICES in sections)
        assertFalse(ImportSection.SMS in sections)
        assertFalse(ImportSection.SPLINTERLANDS in sections)
        assertFalse(ImportSection.TOOLS in sections)
        assertFalse(json.containsKey("conversations"))
        assertFalse(target.isDaemonEnabled())
        assertFalse(target.isEmailEnabled())
        assertFalse(target.isFreeFallbackEnabled())
        assertFalse(target.isMemoryEnabled())
        assertFalse(target.isMemoryEnabled()) // memory section still imported
        assertFalse(target.isSchedulingEnabled())
        assertFalse(target.isToolEnabled("tool_a"))
        assertNull(json["app_opens"])
        assertNull(json["daemon_enabled"])
        assertNull(json["encryption_key"])
        assertNull(json["ui_scale"])
        assertNull(sections[ImportSection.SOUL]) // soul has no count
        assertTrue(ImportSection.CONVERSATIONS in sections)
        assertTrue(ImportSection.SMS in sections)
        assertTrue(ImportSection.SPLINTERLANDS in sections)
        assertTrue(json.containsKey("conversations"))
        assertTrue(target.getEmailAccountsJson().contains("acc1"))
        assertTrue(target.getEmailAccountsJson().contains("em1"))
        assertTrue(target.getEmailSyncStateJson("acc1").contains("42"))
        assertTrue(target.getEmailSyncStateJson("em1").contains("100"))
        assertTrue(target.getHeartbeatConfigJson().contains("45"))
        assertTrue(target.getHeartbeatConfigJson().contains("60"))
        assertTrue(target.getHeartbeatLogJson().contains("2025-01-01"))
        assertTrue(target.getHeartbeatLogJson().contains("2025-06-01"))
        assertTrue(target.getInstanceUseCustomModel("openai-compatible"))
        assertTrue(target.getMcpServersJson().contains("mcp1"))
        assertTrue(target.getMcpServersJson().contains("original"))
        assertTrue(target.getMcpServersJson().contains("srv1"))
        assertTrue(target.getMemoriesJson().contains("User likes cats"))
        assertTrue(target.getMemoriesJson().contains("k1"))
        assertTrue(target.getMemoriesJson().contains("m1"))
        assertTrue(target.getScheduledTasksJson().contains("t1"))
        assertTrue(target.getScheduledTasksJson().contains("task1"))
        assertTrue(target.isEmailEnabled())
        assertTrue(target.isMemoryEnabled())
        assertTrue(target.isMemoryEnabled()) // default is true
        assertTrue(target.isToolEnabled("tool_b"))
        assertTrue(target.isToolEnabled("tool_b")) // reset to default (true)
        assertTrue(tasks[0].id != tasks[1].id)
        assertTrue(tasks[0].id.isNotBlank())
        assertTrue(tasks[1].id.isNotBlank())
        target.importFromJson(exported, toolIds)
        target.importFromJson(json, toolIds)
        target.importFromJson(json, toolIds, sections = setOf(ImportSection.SOUL), replace = false)
        target.importFromJson(json, toolIds, sections = setOf(ImportSection.SOUL), replace = true)
        target.importFromJson(parsed, toolIds)
        target.setConfiguredServiceInstances(
        target.setInstanceApiKey("old_instance", "old-key")
        target.setInstanceModelId("old_instance", "old-model")
        target.setMcpServersJson("""[{"id":"original"}]""")
        target.setMcpServersJson("""[{"id":"srv1"}]""")
        target.setMemoriesJson("""[{"key":"k1","value":"v1","category":"GENERAL"}]""")
        target.setMemoryEnabled(false)
        target.setMemoryEnabled(true)
        target.setSoulText("Original soul")
        target.setSoulText("original")
        target.setToolEnabled("tool_a", false)
        target.setToolEnabled("tool_b", false)
        val appSettings = AppSettings(settings)
        val appSettings = createAppSettings()
        val convData = ConversationsData(
        val conversations = json["conversations"]!!.jsonArray
        val errors = target.importFromJson(json, toolIds)
        val errors = target.importFromJson(parsed, toolIds)
        val exported = appSettings.exportToJson(toolIds)
        val exported = appSettings.exportToJson(toolIds, conversations = convData.conversations)
        val imported = SharedJson.decodeFromString<ConversationsData>(target.getConversationsJson()!!)
        val instances = target.getConfiguredServiceInstances()
        val json = JsonObject(
        val json = JsonObject(mapOf("version" to JsonPrimitive(1)))
        val json = JsonObject(mapOf("version" to JsonPrimitive(1), "soul_text" to JsonPrimitive("test")))
        val json = appSettings.exportToJson(toolIds)
        val json = appSettings.exportToJson(toolIds, conversations = storedConversations)
        val jsonObject = appSettings.exportToJson(toolIds)
        val jsonString = prettyJson.encodeToString(JsonObject.serializer(), jsonObject)
        val memories = SharedJson.decodeFromString<List<MemoryEntry>>(target.getMemoriesJson())
        val parsed = Json.parseToJsonElement(jsonString).jsonObject
        val parsed = Json.parseToJsonElement(v1Json).jsonObject
        val sections = detectExportableSections(json)
        val sections = detectImportSections(json)
        val settings = MapSettings()
        val storedConversations = listOf(
        val target = createAppSettings()
        val tasks = SharedJson.decodeFromString<List<ScheduledTask>>(target.getScheduledTasksJson())
        val tasks = SharedJson.decodeFromString<List<ScheduledTask>>(tasksJson)
        val tasksJson = target.getScheduledTasksJson()
        val v1Json = """
        {
        }
     * Snapshot test: this JSON represents a v1 export. If the export format changes,
     * this test ensures we can still import old exports correctly.
     */
    /**
    @Test
    fun `detect import sections finds conversations`() {
    fun `detectExportableSections hides MCP when server list is empty`() {
    fun `detectExportableSections hides Memory and Scheduling when arrays are empty`() {
    fun `detectExportableSections hides SMS when toggles are off`() {
    fun `detectExportableSections hides Splinterlands without account`() {
    fun `detectExportableSections is empty for fresh settings`() {
    fun `detectExportableSections shows MCP with count when servers exist`() {
    fun `detectExportableSections shows Memory with count when memories exist`() {
    fun `detectExportableSections shows SMS when receive is enabled`() {
    fun `detectExportableSections shows Splinterlands when account is configured`() {
    fun `detectImportSections returns correct sections with counts`() {
    fun `export and import round-trips MCP servers`() {
    fun `export and import round-trips OpenAI-compatible custom model settings`() {
    fun `export and import round-trips configured services and per-instance settings`() {
    fun `export and import round-trips email settings`() {
    fun `export and import round-trips heartbeat settings`() {
    fun `export and import round-trips memory settings`() {
    fun `export and import round-trips scheduling settings`() {
    fun `export and import round-trips soul text`() {
    fun `export and import round-trips tool overrides`() {
    fun `export does not include ui_scale`() {
    fun `export excludes daemon_enabled app_opens and encryption_key`() {
    fun `export includes conversations when present`() {
    fun `export includes version field`() {
    fun `export omits conversations when empty`() {
    fun `exported JSON can be serialized and deserialized as string`() {
    fun `import clears old instance settings before applying new`() {
    fun `import conversations round-trips correctly`() {
    fun `import conversations with malformed entries skips invalid ones`() {
    fun `import does not double-append v1 to already-versioned base URL`() {
    fun `import does not restore daemon_enabled even if present in JSON`() {
    fun `import ignores unknown keys gracefully`() {
    fun `import memories fallback path preserves category`() {
    fun `import memories fallback path with invalid category defaults to GENERAL`() {
    fun `import memories with missing category defaults to GENERAL`() {
    fun `import normalizes old-format OpenAI-compatible base URL by appending v1`() {
    fun `import resets missing settings to defaults`() {
    fun `import resets tool overrides before applying new`() {
    fun `import tasks with invalid status defaults to PENDING`() {
    fun `import tasks with missing id field auto-generates ids`() {
    fun `import valid tasks round-trips unchanged`() {
    fun `import with all valid fields returns zero errors`() {
    fun `import with malformed field does not block other sections`() {
    fun `import with merge mode preserves unselected sections`() {
    fun `import with replace clears conversations when section not selected`() {
    fun `import with replace mode resets unselected sections`() {
    fun `import with sections filter only imports selected sections`() {
    fun `v1 snapshot JSON imports correctly`() {
    private fun createAppSettings(settings: MapSettings = MapSettings()) = AppSettings(settings)
    private val prettyJson = Json { prettyPrint = true }
    private val toolIds = listOf("tool_a", "tool_b", "tool_c")
    }
class AppSettingsExportImportTest {
}
