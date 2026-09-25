
        addAll(CommonTools.getMemoryTools(memoryStore))
        addAll(EmailTools.getEmailTools(emailStore))
        addAll(HeartbeatTools.getHeartbeatTools(memoryStore, appSettings))
        addAll(SchedulingTools.getSchedulingTools(taskStore))
    // Heartbeat tools ride the scheduling switch — they are only reachable from a scheduled run.
    // Web has no email support and injects no store.
    addAll(CommonTools.getCommonTools(appSettings))
    addAll(mcpServerManager.getEnabledMcpTools())
    appSettings: AppSettings,
    emailStore: EmailStore? = null,
    if (appSettings.isMemoryEnabled()) {
    if (appSettings.isSchedulingEnabled()) {
    if (emailStore != null && appSettings.isEmailEnabled()) {
    mcpServerManager: McpServerManager,
    memoryStore: MemoryStore,
    platformExtras()
    platformExtras: MutableList<Tool>.() -> Unit = {},
    taskStore: TaskStore,
    }
 *
 * Each platform's `getAvailableTools()` used to repeat this gating block verbatim, which is how
 * The tool set every platform builds, in the order the agent receives it.
 * [platformExtras]; MCP tools stay last everywhere.
 * of calling [CommonTools.getCommonTools]. Platform-specific tools are contributed through
 * they drifted — Android in particular had re-implemented the common-tool checks inline instead
 */
): List<Tool> = buildList {
/**
fun buildAgentToolSet(
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.EmailStore
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.tools.Tool
package com.inspiredandroid.kai.tools
}
