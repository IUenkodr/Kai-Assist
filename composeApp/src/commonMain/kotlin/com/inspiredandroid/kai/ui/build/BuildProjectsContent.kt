package com.inspiredandroid.kai.ui.build
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.build.BuildAgent
import com.inspiredandroid.kai.build.BuildAgents
import com.inspiredandroid.kai.build.BuildSystemInfo
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.formatFileSize
import com.inspiredandroid.kai.ui.components.KaiChip
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.settings.SettingsCard
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_new_project_title
import kai.composeapp.generated.resources.kai_build_open_with
import kai.composeapp.generated.resources.kai_build_projects_add_agent
import kai.composeapp.generated.resources.kai_build_projects_create
import kai.composeapp.generated.resources.kai_build_projects_empty
import kai.composeapp.generated.resources.kai_build_projects_new_placeholder
import kai.composeapp.generated.resources.kai_build_projects_session_open
import kai.composeapp.generated.resources.kai_build_projects_sessions_open
import kai.composeapp.generated.resources.kai_build_session_shell
import kai.composeapp.generated.resources.kai_build_system_disk_free
import kai.composeapp.generated.resources.kai_build_system_disk_projects
import kai.composeapp.generated.resources.kai_build_system_disk_system
import kai.composeapp.generated.resources.kai_build_system_packages
import kai.composeapp.generated.resources.kai_build_system_title
import kai.composeapp.generated.resources.kai_build_uninstall
import kai.composeapp.generated.resources.kai_build_uninstall_message
import kai.composeapp.generated.resources.kai_build_uninstall_title
import kai.composeapp.generated.resources.sandbox_files_action_delete
import kai.composeapp.generated.resources.sandbox_files_action_more
import kai.composeapp.generated.resources.sandbox_files_action_rename
import kai.composeapp.generated.resources.sandbox_files_delete_confirm
import kai.composeapp.generated.resources.sandbox_files_delete_message_directory
import kai.composeapp.generated.resources.sandbox_files_delete_title
import kai.composeapp.generated.resources.sandbox_files_rename_confirm
import kai.composeapp.generated.resources.sandbox_files_rename_error_collision
import kai.composeapp.generated.resources.sandbox_files_rename_error_invalid
import kai.composeapp.generated.resources.sandbox_files_rename_label
import kai.composeapp.generated.resources.sandbox_files_rename_title
import kai.composeapp.generated.resources.settings_sandbox_cancel
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

                            Text(text = agent.title, style = MaterialTheme.typography.labelMedium)
                            color = MaterialTheme.colorScheme.primary,
                            onClick = { onSelectLaunchAgent(agent.id) },
                            selected = launchAgentId == agent.id,
                            style = MaterialTheme.typography.labelMedium,
                            text = openSessionsLabel(open),
                            text = stringResource(Res.string.kai_build_session_shell),
                        )
                        ) {
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 4.dp, top = 4.dp, bottom = 4.dp),
                        KaiChip(
                        Text(
                        Text(text = agent.title, style = MaterialTheme.typography.labelMedium)
                        color = MaterialTheme.colorScheme.error,
                        color = MaterialTheme.colorScheme.onSurface,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        contentDescription = null,
                        imageVector = Icons.Default.Folder,
                        modifier = Modifier.weight(1f),
                        onClick = { onSelectLaunchAgent(null) },
                        onDelete = { deleting = project },
                        onRename = { renaming = project },
                        onUninstall()
                        selected = launchAgentId == null,
                        showUninstall = false
                        style = MaterialTheme.typography.bodySmall,
                        style = MaterialTheme.typography.titleMedium,
                        text = openSessionsLabel(openSessions),
                        text = project,
                        text = stringResource(Res.string.kai_build_open_with),
                        tint = MaterialTheme.colorScheme.primary,
                        }
                    )
                    ) {
                    // Shells left behind here: the list is the only place they can be
                    // found from, now that stepping out of a project keeps them.
                    Icon(
                    KaiChip(
                    KaiChip(onClick = { onInstallAgent(agent.id) }) {
                    ProjectRowMenu(
                    Text(
                    color = MaterialTheme.colorScheme.error,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    expanded = false
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    if (open > 0) {
                    installedAgents.forEach { agent ->
                    modifier = Modifier
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    modifier = Modifier.handCursor(),
                    onClick = {
                    onClick = { showUninstall = false },
                    onDelete()
                    onRename()
                    style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodySmall,
                    text = error,
                    text = stringResource(Res.string.kai_build_projects_empty),
                    text = stringResource(Res.string.kai_build_system_packages, info.packageCount),
                    text = stringResource(Res.string.sandbox_files_delete_confirm),
                    val open = sessionCounts[project] ?: 0
                    verticalAlignment = Alignment.CenterVertically,
                    }
                    },
                )
                ) {
                ) { Text(stringResource(Res.string.kai_build_uninstall)) }
                ) { Text(stringResource(Res.string.settings_sandbox_cancel)) }
                // The row pads itself: the menu button brings its own touch target,
                // and a card's full padding around that makes every project tall.
                Row(
                Text(
                Text(stringResource(Res.string.sandbox_files_delete_message_directory))
                Text(stringResource(Res.string.settings_sandbox_cancel))
                TextButton(
                color = MaterialTheme.colorScheme.error,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                contentDescription = stringResource(Res.string.sandbox_files_action_more),
                deleting = null
                enabled = error == null,
                enabled = name.isNotBlank(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                if (openSessions > 0) {
                imageVector = Icons.Default.MoreVert,
                info = state.systemInfo,
                innerPadding = false,
                isError = error != null,
                keyboardActions = KeyboardActions(onDone = { create() }),
                keyboardActions = KeyboardActions(onDone = { rename() }),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                label = stringResource(Res.string.kai_build_system_disk_free),
                label = stringResource(Res.string.kai_build_system_disk_projects),
                label = stringResource(Res.string.kai_build_system_disk_system),
                label = { Text(stringResource(Res.string.sandbox_files_rename_label)) },
                missingAgents = missingAgents,
                missingAgents.forEach { agent ->
                modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                modifier = Modifier.handCursor(),
                onClick = create,
                onClick = rename,
                onClick = {
                onClick = { onOpenProject(project) },
                onDeleteProject(project)
                onInstallAgent = onInstallAgent,
                onRenameProject(project, newName)
                onUninstall = { showUninstall = true },
                onValueChange = { name = it },
                placeholder = { Text(stringResource(Res.string.kai_build_projects_new_placeholder)) },
                renaming = null
                singleLine = true,
                style = MaterialTheme.typography.bodySmall,
                supportingText = error?.let { res -> { Text(stringResource(res)) } },
                text = "${info.distribution} · ${info.architecture}",
                text = stringResource(Res.string.kai_build_projects_add_agent),
                text = stringResource(Res.string.kai_build_uninstall),
                text = { Text(stringResource(Res.string.sandbox_files_action_delete)) },
                text = { Text(stringResource(Res.string.sandbox_files_action_rename)) },
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                value = formatFileSize(info.freeBytes),
                value = formatFileSize(info.projectsBytes),
                value = formatFileSize(info.systemBytes),
                value = name,
                verticalAlignment = Alignment.CenterVertically,
                }
                },
            )
            ) {
            ) { Text(stringResource(Res.string.kai_build_projects_create)) }
            ) { Text(stringResource(Res.string.sandbox_files_rename_confirm)) }
            BuildSystemCard(
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            DropdownMenuItem(
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Icon(
            OutlinedTextField(
            Row(
            SettingsCard(
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(8.dp))
            SystemInfoRow(
            Text(
            TextButton(
            TextButton(onClick = onDelete, modifier = Modifier.handCursor()) {
            TextButton(onClick = onDismiss, modifier = Modifier.handCursor()) {
            color = MaterialTheme.colorScheme.onSurface,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            confirmButton = {
            dismissButton = {
            expanded = expanded,
            if (info.packageCount > 0) {
            item {
            modifier = Modifier.handCursor(),
            modifier = Modifier.weight(1f),
            onClick = onUninstall,
            onClick = { expanded = true },
            onDelete = {
            onDismiss = { deleting = null },
            onDismiss = { renaming = null },
            onDismissRequest = { expanded = false },
            onDismissRequest = { showUninstall = false },
            onRename = { newName ->
            openSessions = sessionCounts[project] ?: 0,
            project = project,
            projects = state.projects,
            shape = RoundedCornerShape(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.titleMedium,
            text = label,
            text = stringResource(Res.string.kai_build_system_title),
            text = value,
            text = { Text(stringResource(Res.string.kai_build_uninstall_message)) },
            textAlign = TextAlign.End,
            title = { Text(stringResource(Res.string.kai_build_uninstall_title)) },
            }
            },
        )
        ) {
        AlertDialog(
        BuildAgents.all.filterNot { it.id in state.installedAgents }
        DeleteProjectDialog(
        DropdownMenu(
        IconButton(
        RenameProjectDialog(
        Spacer(Modifier.height(4.dp))
        Spacer(Modifier.width(8.dp))
        Text(
        TextButton(
        confirmButton = {
        contentPadding = PaddingValues(16.dp),
        dismissButton = {
        else -> null
        horizontalArrangement = Arrangement.SpaceBetween,
        if (info != null) {
        if (installedAgents.isNotEmpty()) {
        if (missingAgents.isNotEmpty()) {
        if (state.projects.isEmpty()) {
        item {
        items(state.projects, key = { it }) { project ->
        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        modifier = modifier.fillMaxSize(),
        onDismissRequest = onDismiss,
        state.lastError?.let { error ->
        state.sessions.groupingBy { it.project }.eachCount()
        text = {
        title = { Text(stringResource(Res.string.kai_build_new_project_title)) },
        title = { Text(stringResource(Res.string.sandbox_files_delete_title, project)) },
        title = { Text(stringResource(Res.string.sandbox_files_rename_title)) },
        trimmed != project && trimmed in projects -> Res.string.sandbox_files_rename_error_collision
        trimmed.isEmpty() || trimmed.contains('/') -> Res.string.sandbox_files_rename_error_invalid
        verticalAlignment = Alignment.CenterVertically,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        }
        },
    )
    ) {
    // The project each dialog is about; null while it is closed.
    AlertDialog(
    Box {
    LazyColumn(
    Row(
    SettingsCard(modifier = Modifier.fillMaxWidth()) {
    deleting?.let { project ->
    if (showUninstall) {
    info: BuildSystemInfo?,
    installedAgents: ImmutableList<BuildAgent>,
    launchAgentId: String?,
    missingAgents: List<BuildAgent>,
    modifier: Modifier = Modifier,
    onCreate: (String) -> Unit,
    onDelete: () -> Unit,
    onDeleteProject: (String) -> Unit,
    onDismiss: () -> Unit,
    onInstallAgent: (String) -> Unit,
    onOpenProject: (String) -> Unit,
    onRename: () -> Unit,
    onRename: (String) -> Unit,
    onRenameProject: (name: String, newName: String) -> Unit,
    onSelectLaunchAgent: (String?) -> Unit,
    onUninstall: () -> Unit,
    openSessions: Int,
    project: String,
    projects: ImmutableList<String>,
    renaming?.let { project ->
    state: KaiBuildState,
    stringResource(Res.string.kai_build_projects_session_open)
    stringResource(Res.string.kai_build_projects_sessions_open, open)
    val create = { if (name.isNotBlank()) onCreate(name) }
    val error = when {
    val missingAgents = remember(state.installedAgents) {
    val rename = { if (error == null) onRename(trimmed) }
    val sessionCounts = remember(state.sessions) {
    val trimmed = name.trim()
    var deleting by rememberSaveable { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }
    var name by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable(project) { mutableStateOf(project) }
    var renaming by rememberSaveable { mutableStateOf<String?>(null) }
    var showUninstall by remember { mutableStateOf(false) }
    }
 * Landing surface once Debian is ready: pick what a project opens with, open one
 * New name for an existing project folder. The list is right here, so a name that
 * Rename and delete for one project. Kept behind an overflow so the row's own tap
 * as a silent no-op.
 * is already taken is caught before the rename is attempted rather than reported
 * itself (size, facts, extra agents, uninstall) sits in one card below.
 * stays the thing it looks like — opening the project.
 * — new projects come from the plus button in the top bar. The Linux system
 */
) {
/**
/** Deleting takes the folder's contents with it, and any shell still open in it. */
/** How many shells the project has running, said in words. */
/** Reached from the plus button in the top bar; creating opens the project right away. */
/** What the Linux install is and what it costs, plus the two things you can do to it. */
@Composable
internal fun BuildProjectsContent(
internal fun CreateProjectDialog(
private fun BuildSystemCard(
private fun DeleteProjectDialog(
private fun ProjectRowMenu(
private fun RenameProjectDialog(
private fun SystemInfoRow(label: String, value: String) {
private fun openSessionsLabel(open: Int): String = if (open == 1) {
}
} else {
