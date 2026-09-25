
                                put("custom_model_id", JsonPrimitive(customModelId))
                                put("use_custom_model", JsonPrimitive(true))
                            MemoryCategory.GENERAL
                            MemoryCategory.valueOf(name)
                            if (apiKey.isNotBlank()) put("api_key", JsonPrimitive(apiKey))
                            if (baseUrl.isNotBlank()) put("base_url", JsonPrimitive(baseUrl))
                            if (customModelId.isNotBlank()) {
                            if (getInstanceUseCustomModel(instance.instanceId)) {
                            if (modelId.isNotBlank()) put("model_id", JsonPrimitive(modelId))
                            put("instanceId", JsonPrimitive(instance.instanceId))
                            val apiKey = getInstanceApiKey(instance.instanceId)
                            val baseUrl = getInstanceBaseUrl(instance.instanceId)
                            val customModelId = getInstanceCustomModelId(instance.instanceId)
                            val modelId = getInstanceModelId(instance.instanceId)
                            }
                        ?.let { Service.fromId(it.serviceId) }
                        buildMap {
                        setInstanceBaseUrl(instanceId, baseUrl)
                        setInstanceBaseUrl(instanceId, ensureBaseUrlHasVersionPath(baseUrl))
                        try {
                        }
                        } catch (_: Exception) {
                        },
                    )
                    JsonObject(
                    category = obj["category"]?.jsonPrimitive?.content?.let { name ->
                    content = obj["content"]?.jsonPrimitive?.content ?: "",
                    createdAt = obj["createdAt"]?.jsonPrimitive?.content?.toLongOrNull() ?: now,
                    createdAtEpochMs = obj["createdAtEpochMs"]?.jsonPrimitive?.content?.toLongOrNull() ?: now,
                    cron = obj["cron"]?.jsonPrimitive?.content,
                    description = obj["description"]?.jsonPrimitive?.content ?: "",
                    hitCount = obj["hitCount"]?.jsonPrimitive?.content?.toIntOrNull() ?: 1,
                    id = obj["id"]?.jsonPrimitive?.content ?: Uuid.random().toString(),
                    if (password.isNotBlank()) passwords[id] = JsonPrimitive(password)
                    if (service == Service.OpenAICompatible && baseUrl.isNotBlank()) {
                    if (syncState.isNotBlank()) syncStates[id] = Json.parseToJsonElement(syncState)
                    key = obj["key"]?.jsonPrimitive?.content ?: Uuid.random().toString(),
                    lastResult = obj["lastResult"]?.jsonPrimitive?.content,
                    prompt = obj["prompt"]?.jsonPrimitive?.content ?: "",
                    scheduledAtEpochMs = obj["scheduledAtEpochMs"]?.jsonPrimitive?.content?.toLongOrNull() ?: now,
                    setInstanceCustomModelId(instanceId, it)
                    setInstanceUseCustomModel(instanceId, it)
                    source = obj["source"]?.jsonPrimitive?.content,
                    updatedAt = obj["updatedAt"]?.jsonPrimitive?.content?.toLongOrNull() ?: now,
                    val id = account.jsonObject["id"]?.jsonPrimitive?.content ?: continue
                    val password = getEmailPassword(id)
                    val service = importedInstances.find { it.instanceId == instanceId }
                    val syncState = getEmailSyncStateJson(id)
                    }
                    } ?: MemoryCategory.GENERAL,
                    } else {
                )
                MemoryEntry(
                ScheduledTask(
                for (account in accounts) {
                if (passwords.isNotEmpty()) map["email_passwords"] = JsonObject(passwords)
                if (syncStates.isNotEmpty()) map["email_sync_states"] = JsonObject(syncStates)
                instances.map { instance ->
                null
                obj["api_key"]?.jsonPrimitive?.content?.let { setInstanceApiKey(instanceId, it) }
                obj["base_url"]?.jsonPrimitive?.content?.let { baseUrl ->
                obj["custom_model_id"]?.jsonPrimitive?.content?.let {
                obj["model_id"]?.jsonPrimitive?.content?.let { setInstanceModelId(instanceId, it) }
                obj["use_custom_model"]?.jsonPrimitive?.content?.toBooleanStrictOrNull()?.let {
                setConversationsJson("")
                setConversationsJson(wrapped)
                setEmailPassword(accountId, pw.jsonPrimitive.content)
                setEmailSyncStateJson(accountId, sync.toString())
                setToolEnabled(toolId, enabled.jsonPrimitive.content.toBoolean())
                settings.remove("$KEY_TOOL_PREFIX$toolId")
                val accounts = Json.parseToJsonElement(emailAccountsJson).jsonArray
                val conversations = sanitizeConversations(element)
                val instanceId = obj["instanceId"]?.jsonPrimitive?.content ?: return@forEach
                val obj = element.jsonObject
                val obj = item.jsonObject
                val passwords = mutableMapOf<String, JsonElement>()
                val syncStates = mutableMapOf<String, JsonElement>()
                val wrapped = SharedJson.encodeToString(ConversationsData(conversations = conversations))
                }
                },
            )
            SharedJson.decodeFromString<Conversation>(item.toString())
            SharedJson.decodeFromString<MemoryEntry>(item.toString())
            SharedJson.decodeFromString<ScheduledTask>(item.toString())
            errors++
            for (toolId in toolIds) {
            if (element != null) {
            json["email_passwords"]?.jsonObject?.forEach { (accountId, pw) ->
            json["email_sync_states"]?.jsonObject?.forEach { (accountId, sync) ->
            json["instance_settings"]?.jsonArray?.forEach { element ->
            json["tool_overrides"]?.jsonObject?.forEach { (toolId, enabled) ->
            map["agent_memories"] = Json.parseToJsonElement(memoriesJson)
            map["configured_services"] = Json.parseToJsonElement(configuredJson)
            map["conversations"] = Json.parseToJsonElement(SharedJson.encodeToString(conversations))
            map["email_accounts"] = Json.parseToJsonElement(emailAccountsJson)
            map["heartbeat_config"] = Json.parseToJsonElement(heartbeatConfig)
            map["heartbeat_log"] = Json.parseToJsonElement(heartbeatLog)
            map["instance_settings"] = instanceSettings
            map["mcp_servers"] = Json.parseToJsonElement(mcpJson)
            map["scheduled_tasks"] = Json.parseToJsonElement(tasksJson)
            map["splinterlands_account"] = Json.parseToJsonElement(splinterlandsAccountJson)
            map["splinterlands_battle_log"] = Json.parseToJsonElement(splinterlandsBattleLogJson)
            map["splinterlands_instance_ids"] = Json.parseToJsonElement(splinterlandsInstanceIdsJson)
            null
            oldInstances.forEach { removeInstanceSettings(it.instanceId) }
            setEmailAccountsJson(json["email_accounts"]?.toString() ?: "")
            setEmailEnabled(json["email_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: true)
            setEmailPollIntervalMinutes(json["email_poll_interval"]?.jsonPrimitive?.content?.toInt() ?: 15)
            setHeartbeatConfigJson(json["heartbeat_config"]?.toString() ?: "")
            setHeartbeatLogJson(json["heartbeat_log"]?.toString() ?: "")
            setHeartbeatPrompt(json["heartbeat_prompt"]?.jsonPrimitive?.content ?: "")
            setMcpServersJson(json["mcp_servers"]?.toString() ?: "")
            setMemoriesJson(if (memoriesElement != null) sanitizeMemories(memoriesElement) else "")
            setMemoryEnabled(json["memory_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: true)
            setScheduledTasksJson(if (tasksElement != null) sanitizeScheduledTasks(tasksElement) else "")
            setSchedulingEnabled(json["scheduling_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: false)
            setSmsEnabled(json["sms_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: false)
            setSmsPollIntervalMinutes(json["sms_poll_interval"]?.jsonPrimitive?.content?.toInt() ?: 15)
            setSmsSendEnabled(json["sms_send_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: false)
            setSoulText(json["soul_text"]?.jsonPrimitive?.content ?: "")
            setSplinterlandsAccountJson(json["splinterlands_account"]?.toString() ?: "")
            setSplinterlandsBattleLogJson(json["splinterlands_battle_log"]?.toString() ?: "")
            setSplinterlandsEnabled(json["splinterlands_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: false)
            setSplinterlandsInstanceIdsJson(json["splinterlands_instance_ids"]?.toString() ?: "")
            settings.putBoolean(KEY_FREE_FALLBACK_ENABLED, json["free_fallback_enabled"]?.jsonPrimitive?.content?.toBoolean() ?: true)
            settings.putString(KEY_CONFIGURED_SERVICES, json["configured_services"]?.toString() ?: "")
            settings.putString(KEY_CURRENT_SERVICE_ID, json["current_service_id"]?.jsonPrimitive?.content ?: Service.Free.id)
            settings.remove("$KEY_TOOL_PREFIX$toolId")
            toolStates[toolId] = JsonPrimitive(isToolEnabled(toolId))
            try {
            val element = json["conversations"]
            val importedInstances = getConfiguredServiceInstances()
            val instanceSettings = JsonArray(
            val memoriesElement = json["agent_memories"]
            val tasksElement = json["scheduled_tasks"]
            }
            } catch (_: Exception) {
            } else {
        element.jsonArray
        emptyList()
        for (toolId in toolIds) {
        getConfiguredServiceInstances()
        if (configuredJson.isNotBlank()) {
        if (emailAccountsJson.isNotBlank()) {
        if (heartbeatConfig.isNotBlank()) {
        if (heartbeatLog.isNotBlank()) {
        if (heartbeatPrompt.isNotBlank()) map["heartbeat_prompt"] = JsonPrimitive(heartbeatPrompt)
        if (instances.isNotEmpty()) {
        if (mcpJson.isNotBlank()) {
        if (memoriesJson.isNotBlank() && memoriesJson != "[]") {
        if (soul.isNotBlank()) map["soul_text"] = JsonPrimitive(soul)
        if (splinterlandsAccountJson.isNotBlank()) {
        if (splinterlandsBattleLogJson.isNotBlank()) {
        if (splinterlandsInstanceIdsJson.isNotBlank()) {
        if (tasksJson.isNotBlank() && tasksJson != "[]") {
        if (toolStates.isNotEmpty()) map["tool_overrides"] = JsonObject(toolStates)
        map["current_service_id"] = JsonPrimitive(settings.getString(KEY_CURRENT_SERVICE_ID, Service.Free.id))
        map["email_enabled"] = JsonPrimitive(isEmailEnabled())
        map["email_poll_interval"] = JsonPrimitive(getEmailPollIntervalMinutes())
        map["free_fallback_enabled"] = JsonPrimitive(isFreeFallbackEnabled())
        map["memory_enabled"] = JsonPrimitive(isMemoryEnabled())
        map["scheduling_enabled"] = JsonPrimitive(isSchedulingEnabled())
        map["sms_enabled"] = JsonPrimitive(isSmsEnabled())
        map["sms_poll_interval"] = JsonPrimitive(getSmsPollIntervalMinutes())
        map["sms_send_enabled"] = JsonPrimitive(isSmsSendEnabled())
        map["splinterlands_enabled"] = JsonPrimitive(isSplinterlandsEnabled())
        oldInstances.forEach { removeInstanceSettings(it.instanceId) }
        return "[]"
        return emptyList()
        setConversationsJson("")
        setEmailAccountsJson("")
        setEmailEnabled(true)
        setEmailPollIntervalMinutes(15)
        setHeartbeatConfigJson("")
        setHeartbeatLogJson("")
        setHeartbeatPrompt("")
        setMcpServersJson("")
        setMemoriesJson("")
        setMemoryEnabled(true)
        setScheduledTasksJson("")
        setSchedulingEnabled(false)
        setSmsEnabled(false)
        setSmsPollIntervalMinutes(15)
        setSmsSendEnabled(false)
        setSoulText("")
        setSplinterlandsAccountJson("")
        setSplinterlandsBattleLogJson("")
        setSplinterlandsEnabled(false)
        setSplinterlandsInstanceIdsJson("")
        settings.putBoolean(KEY_FREE_FALLBACK_ENABLED, true)
        settings.putString(KEY_CONFIGURED_SERVICES, "")
        settings.putString(KEY_CURRENT_SERVICE_ID, Service.Free.id)
        try {
        val configuredJson = settings.getString(KEY_CONFIGURED_SERVICES, "")
        val emailAccountsJson = getEmailAccountsJson()
        val heartbeatConfig = getHeartbeatConfigJson()
        val heartbeatLog = getHeartbeatLogJson()
        val heartbeatPrompt = getHeartbeatPrompt()
        val instances = getConfiguredServiceInstances()
        val mcpJson = getMcpServersJson()
        val memoriesJson = getMemoriesJson()
        val soul = getSoulText()
        val splinterlandsAccountJson = getSplinterlandsAccountJson()
        val splinterlandsBattleLogJson = getSplinterlandsBattleLogJson()
        val splinterlandsInstanceIdsJson = getSplinterlandsInstanceIdsJson()
        val tasksJson = getScheduledTasksJson()
        val toolStates = mutableMapOf<String, JsonElement>()
        }
        } catch (_: Exception) {
    conversations: List<Conversation> = emptyList(),
    if (ImportSection.CONVERSATIONS in sections && conversations.isNotEmpty()) {
    if (ImportSection.CONVERSATIONS in sections) {
    if (ImportSection.EMAIL in sections) {
    if (ImportSection.HEARTBEAT in sections) {
    if (ImportSection.MCP in sections) {
    if (ImportSection.MEMORY in sections) {
    if (ImportSection.SCHEDULING in sections) {
    if (ImportSection.SERVICES in sections) {
    if (ImportSection.SMS in sections) {
    if (ImportSection.SOUL in sections) {
    if (ImportSection.SPLINTERLANDS in sections) {
    if (ImportSection.TOOLS in sections) {
    json: JsonObject,
    map["version"] = JsonPrimitive(1)
    replace: Boolean = true,
    return JsonObject(map)
    return SharedJson.encodeToString(memories)
    return SharedJson.encodeToString(tasks)
    return array.mapNotNull { item ->
    return errors
    sections: Set<ImportSection> = ImportSection.entries.toSet(),
    toolIds: List<String>,
    val array = try {
    val map = mutableMapOf<String, JsonElement>()
    val memories = array.mapNotNull { item ->
    val now = Clock.System.now().toEpochMilliseconds()
    val oldInstances = try {
    val tasks = array.mapNotNull { item ->
    var errors = 0
    }
    } catch (_: Exception) {
    } else if (replace) {
): Int {
): JsonObject {
@file:OptIn(kotlin.uuid.ExperimentalUuidApi::class, kotlin.time.ExperimentalTime::class)
fun AppSettings.exportToJson(
fun AppSettings.importFromJson(
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CONFIGURED_SERVICES
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CURRENT_SERVICE_ID
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_FREE_FALLBACK_ENABLED
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_TOOL_PREFIX
import kotlin.time.Clock
import kotlin.uuid.Uuid
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
package com.inspiredandroid.kai.data
private fun sanitizeConversations(element: JsonElement): List<Conversation> {
private fun sanitizeMemories(element: JsonElement): String {
private fun sanitizeScheduledTasks(element: JsonElement): String {
}
