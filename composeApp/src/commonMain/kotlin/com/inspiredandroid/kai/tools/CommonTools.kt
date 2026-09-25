
                    "city" to response.city,
                    "country" to response.country,
                    "country_code" to response.countryCode,
                    "error" to (response.message ?: "Failed to get location"),
                    "ip" to response.ip,
                    "isp" to response.connection?.isp,
                    "latitude" to response.latitude,
                    "longitude" to response.longitude,
                    "region" to response.region,
                    "success" to false,
                    "success" to true,
                    "timezone" to response.timezone?.id,
                    "zip" to response.postal,
                    mapOf("success" to false, "error" to "Failed to open URL")
                    mapOf("success" to true, "url" to url, "message" to "URL opened successfully")
                "category" to ParameterSchema(type = "string", description = "Category: LEARNING, ERROR, or PREFERENCE", required = true),
                "content" to ParameterSchema(type = "string", description = "The content to store", required = true),
                "content" to ParameterSchema(type = "string", description = "What was learned", required = true),
                "day_of_week" to localDateTime.dayOfWeek.name,
                "display_datetime" to "$dayOfWeek, $month $day, $year at $hour12:$minute $amPm",
                "error" to "Failed to get location: ${e.message}",
                "iso_datetime" to "${localDateTime.date}T${localDateTime.hour.toString().padStart(2, '0')}:$minute:${localDateTime.second.toString().padStart(2, '0')}",
                "key" to ParameterSchema(type = "string", description = "Descriptive key for the learning", required = true),
                "key" to ParameterSchema(type = "string", description = "Descriptive key for the memory (e.g. user_name, preferred_language, project_details)", required = true),
                "key" to ParameterSchema(type = "string", description = "The exact key of the memory to delete", required = true),
                "key" to ParameterSchema(type = "string", description = "The exact key of the memory to reinforce", required = true),
                "source" to ParameterSchema(type = "string", description = "How this was learned: user_correction, observation, or error_resolution", required = false),
                "success" to false,
                "timezone" to timeZone.id,
                "url" to ParameterSchema(type = "string", description = "The URL to open", required = true),
                )
                .replaceFirstChar { it.uppercase() }
                ?: return mapOf("success" to false, "error" to "Memory not found: $key")
                ?: return mapOf("success" to false, "error" to "URL is required")
                MemoryCategory.valueOf(categoryStr)
                else -> hour
                hour == 0 -> 12
                hour > 12 -> hour - 12
                if (opened) {
                mapOf(
                mapOf("success" to false, "error" to "Failed to open URL: ${e.message}")
                return mapOf("success" to false, "error" to "Invalid category: $categoryStr. Use LEARNING, ERROR, or PREFERENCE")
                return mapOf("success" to false, "error" to "Use memory_store for GENERAL memories. memory_learn is for LEARNING, ERROR, or PREFERENCE")
                val opened = openUrl(url)
                }
                } else {
            )
            ),
            // Format display string manually since kotlinx-datetime doesn't have formatters
            add(FetchUrlTool)
            add(WebSearchTool)
            add(ipLocationTool)
            add(localTimeTool)
            add(openUrlTool)
            description = "Delete a stored memory by its exact key.",
            description = "Get the current local date and time. Call this first when the user mentions relative dates like 'tomorrow', 'next week', 'in 2 hours', etc.",
            description = "Get the user's estimated location based on their IP address. Returns city, region, country, coordinates, and timezone.",
            description = "Open a URL in the user's browser or default app. This ONLY opens the link for the user to view — you will NOT receive the page content back. Do not use this to fetch or read information from URLs. Use this when the user asks to open or visit a link.",
            description = "Reinforce a stored memory by incrementing its hit count. Use this when a stored learning or preference produced a good outcome.",
            description = "Store a structured learning with a category. Use LEARNING for things that worked, ERROR for error resolutions, PREFERENCE for user corrections/preferences.",
            description = "Store or update a memory with a descriptive key. Use this proactively to remember user preferences, facts, and important information across conversations.",
            if (category == MemoryCategory.GENERAL) {
            if (response.success) {
            json(Json { ignoreUnknownKeys = true })
            mapOf(
            name = "get_local_time",
            name = "get_location_from_ip",
            name = "memory_forget",
            name = "memory_learn",
            name = "memory_reinforce",
            name = "memory_store",
            name = "open_url",
            parameters = emptyMap(),
            parameters = mapOf(
            requestTimeoutMillis = 10_000
            return mapOf(
            return mapOf("success" to removed, "key" to key)
            return mapOf("success" to true, "key" to entry.key, "category" to entry.category.name, "content" to entry.content)
            return mapOf("success" to true, "key" to entry.key, "content" to entry.content)
            return mapOf("success" to true, "key" to entry.key, "hit_count" to entry.hitCount)
            return try {
            val amPm = if (hour < 12) "AM" else "PM"
            val category = try {
            val categoryStr = args["category"]?.toString()?.uppercase() ?: return mapOf("success" to false, "error" to "Missing category")
            val content = args["content"]?.toString() ?: return mapOf("success" to false, "error" to "Missing content")
            val day = localDateTime.date.day
            val dayOfWeek = localDateTime.dayOfWeek.name.lowercase()
            val entry = memoryStore.reinforceMemory(key)
            val entry = memoryStore.store(key, content)
            val entry = memoryStore.store(key, content, category, source)
            val hour = localDateTime.hour
            val hour12 = when {
            val key = args["key"]?.toString() ?: return mapOf("success" to false, "error" to "Missing key")
            val localDateTime = now.toLocalDateTime(timeZone)
            val minute = localDateTime.minute.toString().padStart(2, '0')
            val month = localDateTime.month.name.lowercase()
            val now = Clock.System.now()
            val removed = memoryStore.forget(key)
            val response: IpLocationResponse = locationClient.get("https://ipwho.is/").body()
            val source = args["source"]?.toString()
            val timeZone = TimeZone.currentSystemDefault()
            val url = args["url"]?.toString()
            val year = localDateTime.year
            }
            } catch (_: Exception) {
            } catch (e: Exception) {
            } else {
        )
        EmailTools.emailToolDefinitions +
        FetchUrlTool.toolInfo,
        HeartbeatTools.heartbeatToolDefinitions +
        NotificationTools.notificationToolDefinitions
        SchedulingTools.schedulingToolDefinitions +
        SmsTools.smsToolDefinitions +
        WebSearchTool.toolInfo,
        description = "Delete a stored memory by its key",
        description = "Get estimated location from IP address",
        description = "Get the current local date and time for interpreting relative dates",
        description = "Open a URL or link on the device",
        description = "Reinforce a memory that produced a good outcome",
        description = "Store a categorized learning, error resolution, or preference",
        description = "Store or update a memory with a descriptive key",
        descriptionRes = Res.string.tool_get_local_time_description,
        descriptionRes = Res.string.tool_get_location_description,
        descriptionRes = Res.string.tool_memory_forget_description,
        descriptionRes = Res.string.tool_memory_learn_description,
        descriptionRes = Res.string.tool_memory_reinforce_description,
        descriptionRes = Res.string.tool_memory_store_description,
        descriptionRes = Res.string.tool_open_url_description,
        id = "get_local_time",
        id = "get_location_from_ip",
        id = "memory_forget",
        id = "memory_learn",
        id = "memory_reinforce",
        id = "memory_store",
        id = "open_url",
        if (appSettings.isToolEnabled(FetchUrlTool.schema.name)) {
        if (appSettings.isToolEnabled(WebSearchTool.schema.name)) {
        if (appSettings.isToolEnabled(ipLocationTool.schema.name)) {
        if (appSettings.isToolEnabled(localTimeTool.schema.name)) {
        if (appSettings.isToolEnabled(openUrlTool.schema.name)) {
        install(ContentNegotiation) {
        install(HttpTimeout) {
        ipLocationToolInfo,
        listOf(memoryStoreToolInfo, memoryForgetToolInfo, memoryLearnToolInfo, memoryReinforceToolInfo) +
        localTimeToolInfo,
        memoryForgetTool(memoryStore),
        memoryLearnTool(memoryStore),
        memoryReinforceTool(memoryStore),
        memoryStoreTool(memoryStore),
        name = "Forget Memory",
        name = "Get Local Time",
        name = "Get Location",
        name = "Learn Memory",
        name = "Open URL",
        name = "Reinforce Memory",
        name = "Store Memory",
        nameRes = Res.string.tool_get_local_time_name,
        nameRes = Res.string.tool_get_location_name,
        nameRes = Res.string.tool_memory_forget_name,
        nameRes = Res.string.tool_memory_learn_name,
        nameRes = Res.string.tool_memory_reinforce_name,
        nameRes = Res.string.tool_memory_store_name,
        nameRes = Res.string.tool_open_url_name,
        openUrlToolInfo,
        override suspend fun execute(args: Map<String, Any>): Any = try {
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        userToggleable = false,
        }
        } catch (e: Exception) {
    )
    ) +
    // Every tool the chat UI may have to name, on every platform. Entries whose availability is
    // Memory tools - always enabled, core agent functionality
    // They still belong here: without a definition, chat falls back to showing the raw tool id.
    // decided by a master toggle in Settings → Agent (memory / scheduling / email / SMS /
    // declaration, so the Tools tab skips them instead of drawing a switch nothing reads.
    // notifications) or by a platform capability are marked `userToggleable = false` at their
    @SerialName("country_code") val countryCode: String? = null,
    fun getCommonTools(appSettings: AppSettings): List<Tool> = buildList {
    fun getMemoryTools(memoryStore: MemoryStore): List<Tool> = listOf(
    fun memoryForgetTool(memoryStore: MemoryStore) = object : Tool {
    fun memoryLearnTool(memoryStore: MemoryStore) = object : Tool {
    fun memoryReinforceTool(memoryStore: MemoryStore) = object : Tool {
    fun memoryStoreTool(memoryStore: MemoryStore) = object : Tool {
    private val locationClient = httpClient {
    val city: String? = null,
    val commonToolDefinitions = listOf(
    val connection: IpConnectionInfo? = null,
    val country: String? = null,
    val id: String? = null,
    val ip: String? = null,
    val ipLocationTool = object : Tool {
    val ipLocationToolInfo = ToolInfo(
    val isp: String? = null,
    val latitude: Double? = null,
    val localTimeTool = object : Tool {
    val localTimeToolInfo = ToolInfo(
    val longitude: Double? = null,
    val memoryForgetToolInfo = ToolInfo(
    val memoryLearnToolInfo = ToolInfo(
    val memoryReinforceToolInfo = ToolInfo(
    val memoryStoreToolInfo = ToolInfo(
    val message: String? = null,
    val openUrlTool = object : Tool {
    val openUrlToolInfo = ToolInfo(
    val org: String? = null,
    val postal: String? = null,
    val region: String? = null,
    val success: Boolean = false,
    val timezone: IpTimezoneInfo? = null,
    }
 * Common tool definitions that work across all platforms.
 */
)
/**
@Serializable
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.MemoryCategory
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.httpClient
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.openUrl
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_get_local_time_description
import kai.composeapp.generated.resources.tool_get_local_time_name
import kai.composeapp.generated.resources.tool_get_location_description
import kai.composeapp.generated.resources.tool_get_location_name
import kai.composeapp.generated.resources.tool_memory_forget_description
import kai.composeapp.generated.resources.tool_memory_forget_name
import kai.composeapp.generated.resources.tool_memory_learn_description
import kai.composeapp.generated.resources.tool_memory_learn_name
import kai.composeapp.generated.resources.tool_memory_reinforce_description
import kai.composeapp.generated.resources.tool_memory_reinforce_name
import kai.composeapp.generated.resources.tool_memory_store_description
import kai.composeapp.generated.resources.tool_memory_store_name
import kai.composeapp.generated.resources.tool_open_url_description
import kai.composeapp.generated.resources.tool_open_url_name
import kotlin.time.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
object CommonTools {
package com.inspiredandroid.kai.tools
private data class IpConnectionInfo(
private data class IpLocationResponse(
private data class IpTimezoneInfo(
}
