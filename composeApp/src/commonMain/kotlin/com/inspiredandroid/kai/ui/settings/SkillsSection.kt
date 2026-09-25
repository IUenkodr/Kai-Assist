package com.inspiredandroid.kai.ui.settings
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.skills.RegistrySkillEntry
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.settings_skills
import kai.composeapp.generated.resources.settings_skills_add
import kai.composeapp.generated.resources.settings_skills_add_github
import kai.composeapp.generated.resources.settings_skills_browse
import kai.composeapp.generated.resources.settings_skills_browse_failed
import kai.composeapp.generated.resources.settings_skills_browse_loading
import kai.composeapp.generated.resources.settings_skills_builtin
import kai.composeapp.generated.resources.settings_skills_cancel
import kai.composeapp.generated.resources.settings_skills_description
import kai.composeapp.generated.resources.settings_skills_github_hint
import kai.composeapp.generated.resources.settings_skills_github_url
import kai.composeapp.generated.resources.settings_skills_install
import kai.composeapp.generated.resources.settings_skills_installing
import kai.composeapp.generated.resources.settings_skills_needs_sandbox
import kai.composeapp.generated.resources.settings_skills_none
import kai.composeapp.generated.resources.settings_skills_remove
import kai.composeapp.generated.resources.settings_skills_search
import kai.composeapp.generated.resources.settings_skills_search_empty
import kai.composeapp.generated.resources.settings_skills_setup_sandbox
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

                                        installingId = entry.id
                                        it.description.lowercase().contains(q) ||
                                        it.sourceName.lowercase().contains(q)
                                        onInstallBrowsed(entry)
                                    alreadyInstalled = entry.id in installedIds,
                                    enabled = !isInstalling,
                                    entry = entry,
                                    installing = isInstalling && installingId == entry.id,
                                    it.id.lowercase().contains(q) ||
                                    onInstall = {
                                    },
                                )
                                RegistrySkillRow(
                                Spacer(Modifier.height(4.dp))
                                browsableSkills
                                browsableSkills.filter {
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodySmall,
                                text = stringResource(Res.string.settings_skills_browse_loading),
                                text = stringResource(Res.string.settings_skills_search_empty),
                                }
                            )
                            CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                            Spacer(Modifier.width(8.dp))
                            Text(
                            color = MaterialTheme.colorScheme.error,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            for (entry in filtered) {
                            if (q.isEmpty()) {
                            label = { Text(stringResource(Res.string.settings_skills_search)) },
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { search = it },
                            singleLine = true,
                            style = MaterialTheme.typography.bodySmall,
                            style = MaterialTheme.typography.labelSmall,
                            text = stringResource(Res.string.settings_skills_browse_failed),
                            text = stringResource(Res.string.settings_skills_builtin),
                            text = stringResource(Res.string.settings_skills_installing),
                            val q = search.trim().lowercase()
                            value = search,
                            }
                            } else {
                        )
                        CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                        KaiOutlinedTextField(
                        Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(Modifier.height(8.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(
                        Text(stringResource(Res.string.settings_skills_cancel))
                        Text(stringResource(Res.string.settings_skills_install))
                        color = MaterialTheme.colorScheme.error,
                        color = MaterialTheme.colorScheme.onBackground,
                        enabled = url.isNotBlank() && !isInstalling,
                        if (filtered.isEmpty()) {
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.weight(1f, fill = false),
                        onClick = { onInstallGitHub(url) },
                        onRemove = { onUninstallSkill(skill.id) },
                        skill = skill,
                        style = MaterialTheme.typography.bodySmall,
                        style = MaterialTheme.typography.titleMedium,
                        text = "/${skill.id}",
                        text = installError,
                        text = stringResource(Res.string.settings_skills_remove),
                        val filtered = remember(browsableSkills, search) {
                        }
                        } else {
                    )
                    ) {
                    .padding(16.dp),
                    .verticalScroll(scrollState)
                    SkillCard(
                    Spacer(Modifier.height(8.dp))
                    Text(
                    TextButton(
                    TextButton(onClick = onDismiss, modifier = Modifier.handCursor()) {
                    browseFailed -> {
                    color = MaterialTheme.colorScheme.onSurface,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = null,
                    else -> {
                    enabled = !isInstalling,
                    fontWeight = FontWeight.Medium,
                    horizontalArrangement = Arrangement.End,
                    if (isInstalling) {
                    if (skill.isBuiltIn) {
                    imageVector = Icons.Default.Check,
                    isBrowsing -> {
                    label = { Text(stringResource(Res.string.settings_skills_github_url)) },
                    maxLines = 2,
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    modifier = Modifier.fillMaxWidth(),
                    modifier = Modifier.size(20.dp),
                    onValueChange = { url = it },
                    overflow = TextOverflow.Ellipsis,
                    singleLine = true,
                    style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.headlineSmall,
                    style = MaterialTheme.typography.labelSmall,
                    style = MaterialTheme.typography.titleSmall,
                    text = "/${entry.id}",
                    text = entry.description,
                    text = entry.sourceName,
                    text = skill.description,
                    text = stringResource(Res.string.settings_skills_add),
                    text = stringResource(Res.string.settings_skills_add_github),
                    text = stringResource(Res.string.settings_skills_browse),
                    text = stringResource(Res.string.settings_skills_github_hint),
                    text = stringResource(Res.string.settings_skills_none),
                    tint = MaterialTheme.colorScheme.primary,
                    value = url,
                    verticalAlignment = Alignment.CenterVertically,
                    }
                )
                ) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                Icon(
                KaiOutlinedTextField(
                Row(
                Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.height(16.dp))
                Spacer(Modifier.height(4.dp))
                Spacer(Modifier.height(8.dp))
                Text(
                Text(stringResource(Res.string.settings_skills_add))
                Text(stringResource(Res.string.settings_skills_setup_sandbox))
                TextButton(onClick = onRemove, modifier = Modifier.handCursor()) {
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                for (skill in skills) {
                if (installError != null) {
                modifier = Modifier
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                modifier = Modifier.align(Alignment.CenterHorizontally).handCursor(),
                onClick = onNavigateToSandbox,
                onClick = { onShowAddDialog(true) },
                scrollState = scrollState,
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(Res.string.settings_skills_needs_sandbox),
                when {
                }
            )
            ) {
            .clip(CardDefaults.shape)
            .fillMaxWidth()
            .then(if (enabled && !alreadyInstalled) Modifier.clickable { onInstall() }.handCursor() else Modifier),
            // Built-in skills ship in the app and cannot be uninstalled — hide the remove action for them.
            // Skills live in the Linux sandbox, so it must be installed first.
            Column(
            Column(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
            OutlinedButton(
            Spacer(Modifier.height(8.dp))
            Text(
            VerticalScrollbarForScroll(
            browsableSkills = browsableSkills,
            browseFailed = browseFailed,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
            if (expanded && !skill.isBuiltIn) {
            if (installing) {
            if (skills.isEmpty()) {
            installError = installError,
            installedIds = remember(skills) { skills.map { it.id }.toSet() },
            isBrowsing = isBrowsing,
            isInstalling = isInstalling,
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            onDismiss = { onShowAddDialog(false) },
            onInstallBrowsed = onInstallBrowsed,
            onInstallGitHub = onInstallGitHub,
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.settings_skills),
            text = stringResource(Res.string.settings_skills_description),
            verticalAlignment = Alignment.CenterVertically,
            }
            } else if (alreadyInstalled) {
            } else {
        )
        ) {
        ),
        AddSkillDialog(
        Box {
        Column(modifier = Modifier.padding(16.dp)) {
        Row(
        Spacer(Modifier.height(12.dp))
        Spacer(Modifier.height(4.dp))
        Text(
        border = kaiAdaptiveCardBorder(),
        colors = CardDefaults.cardColors(
        colors = kaiAdaptiveCardColors(),
        if (!isInstalling) installingId = null
        if (!isSandboxInstalled) {
        modifier = Modifier
        modifier = Modifier.fillMaxWidth().handCursor(),
        onClick = { expanded = !expanded },
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        val scrollState = rememberScrollState()
        }
        } else {
    ) {
    // Which browse row the user tapped, so we can show a spinner on just that row.
    Card(
    Column(modifier = Modifier.fillMaxWidth()) {
    LaunchedEffect(isInstalling) {
    ModalBottomSheet(
    alreadyInstalled: Boolean,
    browsableSkills: ImmutableList<RegistrySkillEntry>,
    browseFailed: Boolean,
    enabled: Boolean,
    entry: RegistrySkillEntry,
    if (showAddDialog && isSandboxInstalled) {
    installError: String?,
    installedIds: Set<String>,
    installing: Boolean,
    isBrowsing: Boolean,
    isInstalling: Boolean,
    isSandboxInstalled: Boolean,
    onDismiss: () -> Unit,
    onInstall: () -> Unit,
    onInstallBrowsed: (RegistrySkillEntry) -> Unit,
    onInstallGitHub: (String) -> Unit,
    onNavigateToSandbox: () -> Unit,
    onRemove: () -> Unit,
    onShowAddDialog: (Boolean) -> Unit,
    onUninstallSkill: (String) -> Unit,
    showAddDialog: Boolean,
    skill: SkillManifest,
    skills: ImmutableList<SkillManifest>,
    var expanded by remember { mutableStateOf(false) }
    var installingId by remember { mutableStateOf<String?>(null) }
    var search by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    }
) {
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun SkillsSection(
private fun AddSkillDialog(
private fun RegistrySkillRow(
private fun SkillCard(
}
