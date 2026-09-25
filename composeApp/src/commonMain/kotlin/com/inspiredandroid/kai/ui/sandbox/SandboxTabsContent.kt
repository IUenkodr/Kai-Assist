package com.inspiredandroid.kai.ui.sandbox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.settings.SandboxUiState
import com.inspiredandroid.kai.ui.settings.SettingsCard
import com.inspiredandroid.kai.ui.settings.TerminalContent
import com.inspiredandroid.kai.ui.settings.TerminalDarkBg
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_session_chip_session
import kai.composeapp.generated.resources.sandbox_session_chip_temporary
import kai.composeapp.generated.resources.settings_sandbox_cancel
import kai.composeapp.generated.resources.settings_sandbox_description
import kai.composeapp.generated.resources.settings_sandbox_install
import kai.composeapp.generated.resources.settings_sandbox_subtab_files
import kai.composeapp.generated.resources.settings_sandbox_subtab_packages
import kai.composeapp.generated.resources.settings_sandbox_subtab_terminal
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

                                .padding(bottom = 6.dp).weight(1f),
                                darkBackground = true,
                                initialLines = previewLines,
                                modifier = Modifier.fillMaxSize(),
                                sandboxController = sandboxController,
                                sessionViewModel = sessionViewModel,
                            )
                            Res.string.sandbox_session_chip_session
                            Res.string.sandbox_session_chip_temporary
                            SessionChipRow(viewModel = sessionViewModel)
                            TerminalContent(
                            color = TerminalDarkBg,
                            modifier = Modifier.fillMaxWidth()
                            shape = RoundedCornerShape(12.dp),
                            tonalElevation = 2.dp,
                        ) {
                        MaterialTheme.colorScheme.onSurfaceVariant
                        MaterialTheme.colorScheme.primary
                        SandboxSubTab.Files -> stringResource(Res.string.settings_sandbox_subtab_files)
                        SandboxSubTab.Packages -> stringResource(Res.string.settings_sandbox_subtab_packages)
                        SandboxSubTab.Terminal -> stringResource(Res.string.settings_sandbox_subtab_terminal)
                        Surface(
                        Text(stringResource(Res.string.settings_sandbox_install))
                        color = MaterialTheme.colorScheme.error,
                        if (sessionViewModel != null) {
                        if (tab.isTerminal) {
                        modifier = Modifier.fillMaxSize(),
                        style = MaterialTheme.typography.bodySmall,
                        text = statusText,
                        }
                        } else {
                        },
                    )
                    ),
                    .clickable { onSelectTab(tab) },
                    .clickable { viewModel.selectSession(tab.id) },
                    .clip(RoundedCornerShape(50))
                    .handCursor()
                    Button(onClick = onSetupSandbox, modifier = Modifier.handCursor()) {
                    Color.Transparent
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                    SandboxProgressRow(null, statusText, onCancelSandbox)
                    SandboxProgressRow(sandboxState.sandboxProgress, statusText, onCancelSandbox)
                    SandboxSubTab.Files -> SandboxFilesContent(
                    SandboxSubTab.Packages -> SandboxPackagesContent(
                    SandboxSubTab.Terminal -> Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(Modifier.height(8.dp))
                    Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    color = MaterialTheme.colorScheme.primary,
                    color = if (isSelected) {
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.labelLarge,
                    style = MaterialTheme.typography.labelMedium,
                    style = MaterialTheme.typography.titleMedium,
                    text = "Alpine Linux",
                    text = stringResource(
                    text = stringResource(Res.string.settings_sandbox_description),
                    text = when (tab) {
                    }
                    } else {
                    },
                )
                Spacer(Modifier.height(4.dp))
                Text(
                color = if (isSelected) {
                if (!sandboxState.isWorking) {
                if (sandboxState.sandboxProgress != null) {
                modifier = Modifier
                shape = RoundedCornerShape(50),
                when (subTab) {
                }
                } else if (sandboxState.hasError) {
                } else if (sandboxState.isWorking) {
                } else {
                },
            ) {
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 4.dp, vertical = 4.dp),
            Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
            SandboxSubTabSelector(currentTab = subTab, onSelectTab = onSelectTab)
            SettingsCard {
            Surface(
            Text(stringResource(Res.string.settings_sandbox_cancel))
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f),
            modifier = modifier,
            style = MaterialTheme.typography.bodySmall,
            text = statusText,
            val isSelected = currentTab == tab
            val isSelected = tab.id == selectedId
            verticalArrangement = Arrangement.spacedBy(8.dp),
            { vm.selectTab(it) }
            }
        )
        ) {
        Column(
        Column(modifier = modifier.fillMaxWidth()) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
        SandboxSubTab.entries.forEach { tab ->
        Text(
        TextButton(onClick = onCancel, modifier = Modifier.handCursor()) {
        horizontalArrangement = Arrangement.SpaceBetween,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier
        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()).padding(4.dp),
        tabs.forEach { tab ->
        val isPreview = LocalInspectionMode.current
        val onSelectTab: (SandboxSubTab) -> Unit = sessionViewModel?.let { vm ->
        val sandboxController: SandboxController? = if (!isPreview) koinInject() else null
        val sessionViewModel: SandboxSessionViewModel? = if (!isPreview) koinViewModel() else null
        val subTab = sessionViewModel?.selectedTab?.collectAsStateWithLifecycle()?.value ?: localSubTab
        var localSubTab by remember { mutableStateOf(SandboxSubTab.Terminal) }
        verticalAlignment = Alignment.CenterVertically,
        }
        } ?: { localSubTab = it }
    ) {
    Row(
    Spacer(Modifier.height(4.dp))
    Spacer(Modifier.height(8.dp))
    currentTab: SandboxSubTab,
    if (progress != null) {
    if (sandboxState.sandboxReady) {
    if (tabs.size <= 1) return // Nothing to switch between — keep the UI quiet.
    modifier: Modifier = Modifier,
    onCancelSandbox: () -> Unit = {},
    onSelectTab: (SandboxSubTab) -> Unit,
    onSetupSandbox: () -> Unit = {},
    previewLines: ImmutableList<TerminalLine> = persistentListOf(),
    sandboxState: SandboxUiState,
    val selectedId = viewModel.selectedSessionId.collectAsStateWithLifecycle().value
    val statusText = sandboxStatusText(sandboxState.sandboxStatusLabel)
    val tabs = viewModel.visibleSessions.collectAsStateWithLifecycle().value
    }
    } else {
) {
@Composable
internal enum class SandboxSubTab { Terminal, Files, Packages }
internal fun SandboxProgressRow(progress: Float?, statusText: String, onCancel: () -> Unit) {
internal fun SandboxTabsContent(
private fun SandboxSubTabSelector(
private fun SessionChipRow(viewModel: SandboxSessionViewModel) {
}
