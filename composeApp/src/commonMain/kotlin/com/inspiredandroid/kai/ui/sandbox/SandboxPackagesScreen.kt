import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.linux.PackageEntry
import com.inspiredandroid.kai.ui.components.KaiSearchField
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_files_dialog_cancel
import kai.composeapp.generated.resources.sandbox_packages_action_clear_search
import kai.composeapp.generated.resources.sandbox_packages_action_install
import kai.composeapp.generated.resources.sandbox_packages_action_uninstall
import kai.composeapp.generated.resources.sandbox_packages_action_upgrade
import kai.composeapp.generated.resources.sandbox_packages_empty_installed
import kai.composeapp.generated.resources.sandbox_packages_empty_results
import kai.composeapp.generated.resources.sandbox_packages_search_hint
import kai.composeapp.generated.resources.sandbox_packages_uninstall_confirm
import kai.composeapp.generated.resources.sandbox_packages_uninstall_message
import kai.composeapp.generated.resources.sandbox_packages_uninstall_title
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableSet
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

                            Text(stringResource(Res.string.sandbox_packages_action_uninstall))
                        Text(stringResource(Res.string.sandbox_packages_action_install))
                        TextButton(onClick = { onUninstall(entry) }, modifier = Modifier.handCursor()) {
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        modifier = Modifier.size(20.dp),
                        overflow = TextOverflow.Ellipsis,
                        strokeWidth = 2.dp,
                        style = MaterialTheme.typography.bodySmall,
                        text = entry.version,
                        }
                    )
                    CircularProgressIndicator(
                    Spacer(Modifier.width(8.dp))
                    Text(
                    TextButton(onClick = { onInstall(entry) }, modifier = Modifier.handCursor()) {
                    height = ActionSlotHeight * fontScale,
                    if (!protected) {
                    maxLines = 1,
                    maxLines = 2,
                    modifier = Modifier.size(16.dp),
                    modifier = Modifier.weight(1f, fill = false),
                    overflow = TextOverflow.Ellipsis,
                    strokeWidth = 2.dp,
                    text = entry.name,
                    text = it,
                    width = ActionSlotWidth * fontScale,
                    }
                )
                ),
                CircularProgressIndicator(
                Res.string.sandbox_packages_empty_installed
                Res.string.sandbox_packages_empty_results
                Spacer(Modifier.width(8.dp))
                Text(
                Text(stringResource(Res.string.sandbox_files_dialog_cancel))
                Text(stringResource(Res.string.sandbox_packages_uninstall_confirm))
                clearContentDescription = stringResource(Res.string.sandbox_packages_action_clear_search),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                contentAlignment = Alignment.Center,
                contentDescription = null,
                entries = if (isSearching) state.searchResults else state.installed,
                entry = entry,
                if (entry.version.isNotEmpty()) {
                if (mutating) {
                imageVector = Icons.Filled.Inventory2,
                installed = entry.name in installedNames,
                installedNames = state.installedNames,
                isLoading = if (isSearching) state.searching else state.loadingInstalled,
                isSearching = isSearching,
                modifier = Modifier.size(
                mutating = entry.name in mutating,
                mutating = state.mutating,
                onInstall = onInstall,
                onInstall = { viewModel.install(it) },
                onQueryChange = viewModel::updateSearchQuery,
                onUninstall = onUninstall,
                onUninstall = { viewModel.requestUninstall(it) },
                onUpgrade = viewModel::upgradePackages,
                placeholder = stringResource(Res.string.sandbox_packages_search_hint),
                protected = entry.name in protectedPackages,
                protectedPackages = state.protectedPackages,
                query = state.searchQuery,
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(emptyRes),
                tint = if (installed) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                upgrading = state.upgrading,
                }
                } else if (installed) {
                } else {
            )
            ) {
            Box(
            CircularProgressIndicator()
            Icon(
            KaiSearchField(
            PackageRow(
            PackagesList(
            Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
            Text(stringResource(Res.string.sandbox_packages_action_upgrade))
            TextButton(onClick = onConfirm, modifier = Modifier.handCursor()) {
            TextButton(onClick = onDismiss, modifier = Modifier.handCursor()) {
            UpgradeRow(
            enabled = !upgrading,
            hostState = snackbarHostState,
            if (upgrading) {
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
            modifier = Modifier.handCursor(),
            name = pkg.name,
            onClick = onUpgrade,
            onConfirm = viewModel::confirmUninstall,
            onDismiss = viewModel::cancelUninstall,
            val emptyRes = if (isSearching) {
            val fontScale = LocalDensity.current.fontScale
            val isSearching = state.searchQuery.isNotBlank()
            {
            }
            } else {
        )
        ) {
        ) { Snackbar(snackbarData = it) }
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        Column(Modifier.fillMaxSize()) {
        SnackbarHost(
        TextButton(
        UninstallConfirmDialog(
        confirmButton = {
        dismissButton = {
        headlineContent = {
        horizontalArrangement = Arrangement.End,
        items(entries, key = { "${it.name}@${it.version}" }) { entry ->
        leadingContent = {
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        onDismissRequest = onDismiss,
        return
        snackbarHostState.showSnackbar(text)
        supportingContent = entry.description?.takeIf { it.isNotEmpty() }?.let {
        text = { Text(stringResource(Res.string.sandbox_packages_uninstall_message)) },
        title = { Text(stringResource(Res.string.sandbox_packages_uninstall_title, name)) },
        trailingContent = {
        val msg = state.snackbarMessage ?: return@LaunchedEffect
        val text = msg.arg?.let { getString(msg.resource, it) } ?: getString(msg.resource)
        verticalAlignment = Alignment.CenterVertically,
        viewModel.consumeSnackbar()
        viewModel.start()
        }
        },
    )
    ) {
    AlertDialog(
    Box(modifier = modifier) {
    LaunchedEffect(Unit) {
    LaunchedEffect(state.snackbarMessage) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
    ListItem(
    Row(
    entries: ImmutableList<PackageEntry>,
    entry: PackageEntry,
    if (entries.isEmpty()) {
    if (isLoading && entries.isEmpty()) {
    installed: Boolean,
    installedNames: ImmutableSet<String>,
    isLoading: Boolean,
    isSearching: Boolean,
    modifier: Modifier = Modifier,
    mutating: Boolean,
    mutating: ImmutableSet<String>,
    name: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    onInstall: (PackageEntry) -> Unit,
    onUninstall: (PackageEntry) -> Unit,
    onUpgrade: () -> Unit,
    protected: Boolean,
    protectedPackages: ImmutableSet<String>,
    state.pendingUninstall?.let { pkg ->
    upgrading: Boolean,
    val snackbarHostState = remember { SnackbarHostState() }
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel: SandboxPackagesViewModel = koinViewModel(),
    }
) {
// "Uninstall" is clipped on both axes at the largest accessibility font size.
// A fixed slot prevents the row reflowing when the action label toggles between
// Install and Uninstall during a mutation. Both dimensions are sized for the label
// at the default font scale, so they are scaled by fontScale at use time — otherwise
@Composable
fun SandboxPackagesContent(
package com.inspiredandroid.kai.ui.sandbox
private fun PackageRow(
private fun PackagesList(
private fun UninstallConfirmDialog(
private fun UpgradeRow(
private val ActionSlotHeight = 36.dp
private val ActionSlotWidth = 96.dp
}
