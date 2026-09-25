
                        .clickable(enabled = installing == null) { onToggleAgent(agent.id) }
                        .fillMaxWidth()
                        .handCursor(),
                        checked = agent.id in selectedAgents || agent.id in state.installedAgents,
                        color = MaterialTheme.colorScheme.onSurface,
                        enabled = installing == null && agent.id !in state.installedAgents,
                        onCheckedChange = { onToggleAgent(agent.id) },
                        style = MaterialTheme.typography.bodyLarge,
                        text = agent.title,
                    )
                    Checkbox(
                    Text(
                    modifier = Modifier
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                Row(
                Text(stringResource(Res.string.kai_build_setup_install))
                color = MaterialTheme.colorScheme.error,
                color = MaterialTheme.colorScheme.onSurface,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp),
                onCancel = onCancel,
                progress = installing.progress,
                statusText = stepLabel(installing),
                style = MaterialTheme.typography.bodySmall,
                style = MaterialTheme.typography.titleMedium,
                text = error,
                text = stringResource(Res.string.kai_build_setup_agents_description),
                text = stringResource(Res.string.kai_build_setup_agents_title),
                }
            )
            .fillMaxSize()
            .padding(16.dp),
            .verticalScroll(rememberScrollState())
            BuildAgents.all.forEach { agent ->
            Button(onClick = onInstall, modifier = Modifier.handCursor()) {
            SandboxProgressRow(
            Text(
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.headlineSmall,
            text = stringResource(Res.string.kai_build_setup_description),
            text = stringResource(Res.string.kai_build_setup_title),
            }
        ((state.progress ?: 0f) * 100).toInt(),
        )
        BuildAgents.get(state.agentId)?.title.orEmpty(),
        Res.string.kai_build_step_download,
        Res.string.kai_build_step_install_agent,
        SettingsCard(modifier = Modifier.fillMaxWidth()) {
        Text(
        if (installing != null) {
        modifier = modifier
        state.lastError?.let { error ->
        verticalArrangement = Arrangement.spacedBy(12.dp),
        }
        } else {
    )
    ) {
    BuildStep.Agent -> stringResource(
    BuildStep.BasePackages -> stringResource(Res.string.kai_build_step_base_packages)
    BuildStep.Configure -> stringResource(Res.string.kai_build_step_configure)
    BuildStep.Download -> stringResource(
    BuildStep.Extract -> stringResource(Res.string.kai_build_step_extract)
    Column(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit,
    onInstall: () -> Unit,
    onToggleAgent: (String) -> Unit,
    selectedAgents: ImmutableSet<String>,
    state: KaiBuildState,
    val installing = state.environment as? BuildEnvironmentState.Installing
    }
 * Doubles as the progress surface for later agent installs.
 * First screen a user lands on: install Debian, optionally with coding agents.
 */
) {
/**
@Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.build.BuildAgents
import com.inspiredandroid.kai.build.BuildEnvironmentState
import com.inspiredandroid.kai.build.BuildStep
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.sandbox.SandboxProgressRow
import com.inspiredandroid.kai.ui.settings.SettingsCard
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_setup_agents_description
import kai.composeapp.generated.resources.kai_build_setup_agents_title
import kai.composeapp.generated.resources.kai_build_setup_description
import kai.composeapp.generated.resources.kai_build_setup_install
import kai.composeapp.generated.resources.kai_build_setup_title
import kai.composeapp.generated.resources.kai_build_step_base_packages
import kai.composeapp.generated.resources.kai_build_step_configure
import kai.composeapp.generated.resources.kai_build_step_download
import kai.composeapp.generated.resources.kai_build_step_extract
import kai.composeapp.generated.resources.kai_build_step_install_agent
import kotlinx.collections.immutable.ImmutableSet
import org.jetbrains.compose.resources.stringResource
internal fun BuildSetupContent(
package com.inspiredandroid.kai.ui.build
private fun stepLabel(state: BuildEnvironmentState.Installing): String = when (state.step) {
}
