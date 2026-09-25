import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.SettingsJsonList
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json

                            // Individual server failures shouldn't block others
                            connectAndDiscoverTools(server.id)
                        add(McpTool(client, meta))
                        try {
                        }
                        } catch (_: Exception) {
                    async {
                    description = def.description ?: "",
                    if (appSettings.isToolEnabled(toolId)) {
                    inputSchema = def.inputSchema,
                    name = def.name,
                    serverId = serverId,
                    val toolId = McpTool.toolId(serverId, meta.name)
                    }
                )
                .awaitAll()
                .filter { !clients.containsKey(it.id) }
                .map { server ->
                McpToolMetadata(
                clients.remove(serverId)
                clients[serverId] = client
                description = meta.description,
                discoveredTools.remove(serverId)
                discoveredTools[serverId] = metadata
                for (meta in tools) {
                id = toolId,
                if (serverId !in enabledServers) continue
                isEnabled = appSettings.isToolEnabled(toolId),
                name = meta.name,
                val client = clients[serverId] ?: continue
                }
            )
            .firstOrNull { matchesPopularMcpUrl(url, it.url) }
            .orEmpty()
            ?.headers
            ?: return Result.failure(McpException("Server not found: $serverId"))
            Result.failure(e)
            Result.success(metadata)
            ToolInfo(
            client.close()
            client.initialize()
            clients.remove(serverId)
            clients[serverId]?.close()
            discoveredTools.remove(serverId)
            enabledServers
            for ((serverId, tools) in discoveredTools) {
            mutex.withLock {
            saveServers(servers)
            saveServers(updated)
            servers[index] = servers[index].copy(isEnabled = enabled)
            val metadata = toolDefs.map { def ->
            val toolDefs = client.listTools()
            val toolId = McpTool.toolId(serverId, meta.name)
            }
        // Close existing client if any
        // If the user adds a popular endpoint manually without headers, still apply defaults
        // One-shot: fill missing popular default headers (e.g. Jina Authorization) without
        // for missing keys only (never clobber explicit headers they typed).
        // overwriting headers the user already configured.
        clients.remove(serverId)
        clients[serverId]?.close()
        coroutineScope {
        discoveredTools.remove(serverId)
        encodeDefaults = true
        explicitNulls = false
        if (!enabled) {
        if (base !in existingIds) return base
        if (index >= 0) {
        if (updated !== current) {
        ignoreUnknownKeys = true
        itemSerializer = McpServerConfig.serializer(),
        json = json,
        label = "McpServerManager",
        migratePopularDefaultHeaders()
        mutex.withLock { clients[serverId] }?.close()
        read = appSettings::getMcpServersJson,
        return "${base}_$counter"
        return buildList {
        return config
        return tools.map { meta ->
        return try {
        saveServers(servers)
        servers.add(config)
        servers.removeAll { it.id == serverId }
        val base = name.lowercase().replace(serverIdRegex, "_").take(30)
        val client = McpClient(server.url, server.headers)
        val config = McpServerConfig(id = id, name = name, url = url, headers = mergedHeaders)
        val current = servers.get()
        val enabledServers = getServers().filter { it.isEnabled }
        val enabledServers = getServers().filter { it.isEnabled }.map { it.id }.toSet()
        val existingIds = existing.map { it.id }.toSet()
        val id = generateServerId(name, servers)
        val index = servers.indexOfFirst { it.id == serverId }
        val mergedHeaders = mergeMissingHeaders(headers, popularDefaults)
        val popularDefaults = popularMcpServers
        val server = getServers().find { it.id == serverId }
        val servers = getServers().toMutableList()
        val tools = discoveredTools[serverId] ?: return emptyList()
        val updated = applyPopularDefaultHeaders(current)
        var counter = 2
        while ("${base}_$counter" in existingIds) counter++
        write = appSettings::setMcpServersJson,
        }
        } catch (e: Exception) {
    )
    // NOTE: the mutators below are read-modify-write without a lock. Making them safe means making
    // them suspend, which ripples through DataRepository and the settings UI — tracked separately.
    fun addServer(name: String, url: String, headers: Map<String, String>): McpServerConfig {
    fun getEnabledMcpTools(): List<Tool> {
    fun getServers(): List<McpServerConfig> = servers.get()
    fun getToolsForServer(serverId: String): List<ToolInfo> {
    fun isConnected(serverId: String): Boolean = clients.containsKey(serverId)
    fun removeServer(serverId: String) {
    fun setServerEnabled(serverId: String, enabled: Boolean) {
    init {
    private fun generateServerId(name: String, existing: List<McpServerConfig>): String {
    private fun migratePopularDefaultHeaders() {
    private fun saveServers(servers: List<McpServerConfig>) = this.servers.set(servers)
    private val clients = mutableMapOf<String, McpClient>()
    private val discoveredTools = mutableMapOf<String, List<McpToolMetadata>>()
    private val json = Json {
    private val mutex = Mutex()
    private val servers = SettingsJsonList(
    suspend fun connectAndDiscoverTools(serverId: String): Result<List<McpToolMetadata>> {
    suspend fun connectEnabledServers() {
    }
class McpServerManager(private val appSettings: AppSettings) {
package com.inspiredandroid.kai.mcp
private val serverIdRegex = Regex("[^a-z0-9]")
}
