
                    Text(stringResource(Res.string.settings_open_github_issue))
                    accounts = splinterlandsState.splinterlandsAccounts,
                    addStatus = splinterlandsState.splinterlandsAddStatus,
                    availableServices = splinterlandsState.splinterlandsAvailableServices,
                    battleLog = splinterlandsState.splinterlandsBattleLog,
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    instanceIds = splinterlandsState.splinterlandsInstanceIds,
                    isEnabled = splinterlandsState.isSplinterlandsEnabled,
                    modifier = Modifier.handCursor(),
                    onAddService = splinterlandsState.onAddSplinterlandsService,
                    onClearBattleLog = splinterlandsState.onClearSplinterlandsBattleLog,
                    onClick = { uriHandler.openUri("https://github.com/SimonSchubert/Kai/issues/new?template=integration_request.yml") },
                    onRemoveAccount = splinterlandsState.onRemoveSplinterlandsAccount,
                    onRemoveService = splinterlandsState.onRemoveSplinterlandsService,
                    onReorderServices = splinterlandsState.onReorderSplinterlandsServices,
                    onStartBattle = splinterlandsState.onStartSplinterlandsBattle,
                    onStopBattle = splinterlandsState.onStopSplinterlandsBattle,
                    onTestAndAddAccount = splinterlandsState.onTestAndAddSplinterlandsAccount,
                    onToggle = splinterlandsState.onToggleSplinterlands,
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.titleMedium,
                    text = stringResource(Res.string.settings_request_integration_description),
                    text = stringResource(Res.string.settings_request_integration_title),
                )
                ) {
                OutlinedButton(
                Spacer(Modifier.height(4.dp))
                Spacer(Modifier.height(8.dp))
                SplinterlandsSection(
                Text(
                }
            Column(modifier = Modifier.fillMaxWidth()) {
            SettingsCard {
            }
        SettingsCard {
        if (splinterlandsState.showSplinterlandsSection) {
        }
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
    LaunchedEffect(Unit) { splinterlandsViewModel.onScreenVisible() }
    splinterlandsViewModel: SplinterlandsViewModel = koinViewModel(),
    val splinterlandsState by splinterlandsViewModel.state.collectAsStateWithLifecycle()
    val uriHandler = LocalUriHandler.current
    }
) {
@Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.settings_open_github_issue
import kai.composeapp.generated.resources.settings_request_integration_description
import kai.composeapp.generated.resources.settings_request_integration_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
internal fun IntegrationsContent(
package com.inspiredandroid.kai.ui.settings
}
