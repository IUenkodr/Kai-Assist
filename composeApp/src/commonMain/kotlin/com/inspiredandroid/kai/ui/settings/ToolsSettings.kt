import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.mcp.PopularMcpServer
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.skills.RegistrySkillEntry
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.settings_tools_description
import kai.composeapp.generated.resources.settings_tools_none_available
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

                                    modifier = Modifier.weight(1f).fillMaxHeight(),
                                    onToggle = { enabled -> onToggleTool(tool.id, enabled) },
                                    tool = tool,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                ToolItem(
                            // Fill empty slots so last row items don't stretch
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                            repeat(columns - rowTools.size) {
                            rowTools.forEach { tool ->
                            }
                        ) {
                        Row(
                        }
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    else -> 1
                    maxWidth >= 500.dp -> 2
                    maxWidth >= 800.dp -> 3
                    rows.forEach { rowTools ->
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.titleSmall,
                    text = tool.descriptionRes?.let { stringResource(it) } ?: tool.description,
                    text = tool.nameRes?.let { stringResource(it) } ?: tool.name,
                    }
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                browsableSkills = browsableSkills,
                browseFailed = browseSkillsFailed,
                checked = tool.isEnabled,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                installError = skillInstallError,
                isBrowsing = isBrowsingSkills,
                isInstalling = isInstallingSkill,
                isSandboxInstalled = isSandboxInstalled,
                onCheckedChange = onToggle,
                onInstallBrowsed = onInstallBrowsedSkill,
                onInstallGitHub = onInstallGitHubSkill,
                onNavigateToSandbox = onNavigateToSandbox,
                onShowAddDialog = onShowAddSkillDialog,
                onUninstallSkill = onUninstallSkill,
                showAddDialog = showAddSkillDialog,
                skills = skills,
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(Res.string.settings_tools_none_available),
                val columns = when {
                val rows = tools.chunked(columns)
                }
            )
            .clickable { onToggle(!tool.isEnabled) }
            .clip(CardDefaults.shape)
            .handCursor(),
            BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
            SkillsSection(
            Spacer(Modifier.height(24.dp))
            Spacer(Modifier.width(16.dp))
            Switch(
            Text(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            mcpServers = mcpServers,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onAddMcpServer = onAddMcpServer,
            onAddPopularMcpServer = onAddPopularMcpServer,
            onRefreshMcpServer = onRefreshMcpServer,
            onRemoveMcpServer = onRemoveMcpServer,
            onShowAddDialog = onShowAddMcpServerDialog,
            onToggleMcpServer = onToggleMcpServer,
            onToggleTool = onToggleTool,
            showAddDialog = showAddMcpServerDialog,
            style = MaterialTheme.typography.bodySmall,
            text = stringResource(Res.string.settings_tools_description),
            verticalAlignment = Alignment.CenterVertically,
            }
        )
        ) {
        // MCP Servers section
        // Native tools section
        // Skills section — sandbox-backed, so Android only.
        McpServersSection(
        Row(
        Spacer(Modifier.height(16.dp))
        Spacer(Modifier.height(24.dp))
        Text(
        border = kaiAdaptiveCardBorder(),
        colors = kaiAdaptiveCardColors(),
        if (showSkills) {
        if (tools.isEmpty()) {
        modifier = modifier
        }
        } else {
    ) {
    Card(
    Column(modifier = Modifier.fillMaxWidth()) {
    browsableSkills: ImmutableList<RegistrySkillEntry>,
    browseSkillsFailed: Boolean,
    isBrowsingSkills: Boolean,
    isInstallingSkill: Boolean,
    isSandboxInstalled: Boolean,
    mcpServers: ImmutableList<McpServerUiState>,
    modifier: Modifier = Modifier,
    onAddMcpServer: (String, String, Map<String, String>) -> Unit,
    onAddPopularMcpServer: (PopularMcpServer) -> Unit,
    onInstallBrowsedSkill: (RegistrySkillEntry) -> Unit,
    onInstallGitHubSkill: (String) -> Unit,
    onNavigateToSandbox: () -> Unit,
    onRefreshMcpServer: (String) -> Unit,
    onRemoveMcpServer: (String) -> Unit,
    onShowAddMcpServerDialog: (Boolean) -> Unit,
    onShowAddSkillDialog: (Boolean) -> Unit,
    onToggle: (Boolean) -> Unit,
    onToggleMcpServer: (String, Boolean) -> Unit,
    onToggleTool: (String, Boolean) -> Unit,
    onUninstallSkill: (String) -> Unit,
    showAddMcpServerDialog: Boolean,
    showAddSkillDialog: Boolean,
    showSkills: Boolean,
    skillInstallError: String?,
    skills: ImmutableList<SkillManifest>,
    tool: ToolInfo,
    tools: ImmutableList<ToolInfo>,
    }
) {
@Composable
internal fun ToolsContent(
package com.inspiredandroid.kai.ui.settings
private fun ToolItem(
}
