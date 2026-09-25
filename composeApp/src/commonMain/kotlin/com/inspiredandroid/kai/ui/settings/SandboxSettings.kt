import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.formatFileSize
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.sandbox.SandboxProgressRow
import com.inspiredandroid.kai.ui.sandbox.sandboxStatusText
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.settings_sandbox_cancel
import kai.composeapp.generated.resources.settings_sandbox_description
import kai.composeapp.generated.resources.settings_sandbox_disk_usage
import kai.composeapp.generated.resources.settings_sandbox_distro_alpine
import kai.composeapp.generated.resources.settings_sandbox_distro_alpine_detail
import kai.composeapp.generated.resources.settings_sandbox_distro_alpine_installed
import kai.composeapp.generated.resources.settings_sandbox_distro_debian
import kai.composeapp.generated.resources.settings_sandbox_distro_debian_detail
import kai.composeapp.generated.resources.settings_sandbox_distro_debian_installed
import kai.composeapp.generated.resources.settings_sandbox_distro_title
import kai.composeapp.generated.resources.settings_sandbox_install
import kai.composeapp.generated.resources.settings_sandbox_install_packages
import kai.composeapp.generated.resources.settings_sandbox_migrate_action
import kai.composeapp.generated.resources.settings_sandbox_migrate_detail
import kai.composeapp.generated.resources.settings_sandbox_migrate_title
import kai.composeapp.generated.resources.settings_sandbox_uninstall
import kai.composeapp.generated.resources.settings_sandbox_uninstall_confirm
import kai.composeapp.generated.resources.settings_sandbox_uninstall_confirm_shared
import org.jetbrains.compose.resources.stringResource

                            Text(stringResource(Res.string.settings_sandbox_install_packages))
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall,
                            text = stringResource(Res.string.settings_sandbox_disk_usage, sandboxState.sandboxDiskUsageMB),
                        )
                        OutlinedButton(onClick = onInstallPackages, modifier = Modifier.handCursor()) {
                        Text(
                        Text(stringResource(Res.string.settings_sandbox_install))
                        Text(stringResource(Res.string.settings_sandbox_uninstall))
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        onResetSandbox()
                        showResetDialog = false
                        style = MaterialTheme.typography.bodySmall,
                        text = stringResource(Res.string.settings_sandbox_description),
                        }
                    )
                    // Before install this names what would be installed; after, what is.
                    Button(onClick = onSetupSandbox, modifier = Modifier.handCursor()) {
                    OutlinedButton(onClick = { showResetDialog = true }, modifier = Modifier.handCursor()) {
                    Res.string.settings_sandbox_migrate_detail,
                    Res.string.settings_sandbox_migrate_title,
                    Res.string.settings_sandbox_uninstall_confirm
                    Res.string.settings_sandbox_uninstall_confirm_shared
                    Spacer(Modifier.height(4.dp))
                    Text(
                    Text(stringResource(Res.string.settings_sandbox_cancel))
                    Text(stringResource(Res.string.settings_sandbox_uninstall))
                    checked = sandboxState.isSandboxEnabled,
                    color = MaterialTheme.colorScheme.onBackground,
                    formatFileSize(migration.bytes),
                    if (!sandboxState.sandboxPackagesInstalled) {
                    if (sandboxState.sandboxDiskUsageMB > 0) {
                    migration.fileCount,
                    migration.from.displayName,
                    modifier = Modifier.handCursor(),
                    onCheckedChange = onToggleSandbox,
                    onClick = {
                    onClick = { showResetDialog = false },
                    style = MaterialTheme.typography.titleMedium,
                    text = sandboxState.distro.displayName,
                    }
                    },
                )
                ) {
                ),
                // A Debian sandbox is the same install Kai Build works in, so
                // uninstalling here takes Kai Build's Linux with it.
                Switch(
                Text(
                Text(stringResource(Res.string.settings_sandbox_migrate_action))
                Text(stringResource(confirm))
                TextButton(
                color = MaterialTheme.colorScheme.error,
                color = MaterialTheme.colorScheme.onBackground,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                if (!sandboxState.sandboxReady) {
                if (sandboxState.sandboxReady) {
                installed = sandboxState.installedDistros,
                onClick = { onSelect(distro) },
                onSelect = onSelectDistro,
                role = Role.RadioButton,
                selected = sandboxState.distro,
                selected = selected,
                stringResource(Res.string.settings_sandbox_distro_alpine_detail)
                stringResource(Res.string.settings_sandbox_distro_alpine_installed)
                stringResource(Res.string.settings_sandbox_distro_debian_detail)
                stringResource(Res.string.settings_sandbox_distro_debian_installed)
                style = MaterialTheme.typography.bodyMedium,
                style = MaterialTheme.typography.bodySmall,
                text = detail,
                text = statusText,
                text = stringResource(
                text = title,
                val confirm = if (sandboxState.distro == LinuxDistro.DEBIAN) {
                }
                } else {
            )
            .fillMaxWidth()
            .handCursor(),
            .selectable(
            // An install already on disk is a switch, not a download — the size
            // Its own button rather than a third one in the action row below:
            // estimate would be the wrong thing to lead with.
            // sentence above it.
            // that row is already two wide on a phone, and this belongs to the
            Column(modifier = Modifier.weight(1f)) {
            DistroPicker(
            OutlinedButton(onClick = onMigrateHome, modifier = Modifier.handCursor()) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SandboxProgressRow(null, statusText, onCancelSandbox)
            SandboxProgressRow(sandboxState.sandboxProgress, statusText, onCancelSandbox)
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(8.dp))
            Text(
            confirmButton = {
            detail = if (LinuxDistro.ALPINE in installed) {
            detail = if (LinuxDistro.DEBIAN in installed) {
            dismissButton = {
            distro = LinuxDistro.ALPINE,
            distro = LinuxDistro.DEBIAN,
            horizontalArrangement = Arrangement.SpaceBetween,
            if (sandboxState.sandboxReady) {
            modifier = Modifier.fillMaxWidth(),
            onDismissRequest = { showResetDialog = false },
            onSelect = onSelect,
            selected = selected == LinuxDistro.ALPINE,
            selected = selected == LinuxDistro.DEBIAN,
            text = {
            title = stringResource(Res.string.settings_sandbox_distro_alpine),
            title = stringResource(Res.string.settings_sandbox_distro_debian),
            title = { Text(stringResource(Res.string.settings_sandbox_uninstall)) },
            verticalAlignment = CenterVertically,
            }
            } else {
            },
        )
        ) {
        // Offered at any time: each distribution keeps its own install, so this
        // Offered whenever the distribution being left still holds files this one
        // being shown once the copy is done, because then there is nothing left.
        // does not, so switching never has to mean abandoning them. It stops
        // picks which one the shell integration runs in rather than replacing it.
        AlertDialog(
        Column(Modifier.weight(1f)) {
        DistroOption(
        RadioButton(selected = selected, onClick = null)
        Row(
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        if (!sandboxState.isWorking) {
        if (migration != null && sandboxState.sandboxReady && !sandboxState.isWorking) {
        if (sandboxState.sandboxProgress != null) {
        modifier = Modifier
        style = MaterialTheme.typography.labelLarge,
        text = stringResource(Res.string.settings_sandbox_distro_title),
        val migration = sandboxState.migration
        verticalAlignment = CenterVertically,
        }
        } else if (sandboxState.hasError) {
        } else if (sandboxState.isWorking) {
    )
    ) {
    Column(Modifier.selectableGroup()) {
    Row(
    SettingsCard {
    Spacer(Modifier.height(12.dp))
    Text(
    detail: String,
    distro: LinuxDistro,
    if (showResetDialog) {
    installed: Set<LinuxDistro>,
    onCancelSandbox: () -> Unit,
    onInstallPackages: () -> Unit,
    onMigrateHome: () -> Unit,
    onResetSandbox: () -> Unit,
    onSelect: (LinuxDistro) -> Unit,
    onSelectDistro: (LinuxDistro) -> Unit,
    onSetupSandbox: () -> Unit,
    onToggleSandbox: (Boolean) -> Unit,
    sandboxState: SandboxUiState,
    selected: Boolean,
    selected: LinuxDistro,
    title: String,
    val statusText = sandboxStatusText(sandboxState.sandboxStatusLabel)
    var showResetDialog by remember { mutableStateOf(false) }
    }
) {
@Composable
internal fun SandboxSettingsCard(
package com.inspiredandroid.kai.ui.settings
private fun DistroOption(
private fun DistroPicker(
}
