
            .filterNot { it in definitionIds }
            .map { it.id }
            .map { it.schema.name }
            CommonTools.ipLocationTool,
            CommonTools.localTimeTool,
            CommonTools.openUrlTool,
            EmailTools.emailToolDefinitions +
            FetchUrlTool,
            HeartbeatTools.heartbeatToolDefinitions +
            NotificationTools.notificationToolDefinitions
            SmsTools.smsToolDefinitions +
            WebSearchTool,
        )
        // These are gated by a single switch in Settings → Agent, so the Tools tab must not
        // Tools with no collaborators, gated by per-tool switches.
        // offer per-tool switches for them — nothing would read the value back.
        assertEquals(emptySet(), duplicates, "Duplicate tool definition ids")
        assertTrue(leaked.isEmpty(), "Master-toggle-controlled tools exposed as per-tool switches: $leaked")
        assertTrue(missing.isEmpty(), "Executable tools with no ToolInfo (chat shows the raw id): $missing")
        assertTrue(missing.isEmpty(), "Memory tools with no ToolInfo: $missing")
        assertTrue(missing.isEmpty(), "Notification tools missing from commonToolDefinitions: $missing")
        val duplicates = definitionIds.groupingBy { it }.eachCount().filterValues { it > 1 }.keys
        val leaked = masterToggled.filter { it.userToggleable }.map { it.id }
        val masterToggled = SchedulingTools.schedulingToolDefinitions +
        val missing = CommonTools.getMemoryTools(MemoryStore(AppSettings(MapSettings())))
        val missing = NotificationTools.notificationToolDefinitions
        val missing = stateless.map { it.schema.name }.filterNot { it in definitionIds }
        val stateless: List<Tool> = listOf(
    @Test
    fun definitionIdsAreUnique() {
    fun everyCommonToolHasADefinition() {
    fun everyMemoryToolHasADefinition() {
    fun masterToggleControlledToolsAreNotUserToggleable() {
    fun notificationToolDefinitionsAreRegistered() {
    private val definitionIds = CommonTools.commonToolDefinitions.map { it.id }
    }
 *
 * A tool that runs but has no definition falls back to showing its raw id in chat, which is how
 * Guards the pairing between a tool's executable schema and the [com.inspiredandroid.kai.network.tools.ToolInfo]
 * the UI resolves its display name from.
 * the notification tools regressed: `notificationToolDefinitions` existed but nothing referenced it.
 */
/**
class ToolDefinitionsTest {
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.network.tools.Tool
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.tools
}
