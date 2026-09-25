
                                        selectedSections + section
                                        selectedSections - section
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    selectedSections = if (checked) selectedSections + section else selectedSections - section
                                    selectedSections = if (section in selectedSections) {
                                    style = MaterialTheme.typography.bodySmall,
                                    text = "($count)",
                                    text = stringResource(Res.string.settings_import_replace_all_description),
                                    }
                                    } else {
                                )
                                .clickable {
                                .fillMaxWidth()
                                .handCursor()
                                .padding(vertical = 4.dp),
                                Spacer(Modifier.width(4.dp))
                                Text(
                                checked = section in selectedSections,
                                onCheckedChange = { checked ->
                                style = MaterialTheme.typography.bodyMedium,
                                text = sectionDisplayName(section),
                                text = stringResource(Res.string.settings_import_replace_all),
                                }
                                },
                            )
                            .clickable { replace = !replace }
                            .fillMaxWidth()
                            .handCursor(),
                            Checkbox(
                            Spacer(Modifier.width(8.dp))
                            Text(
                            checked = replace,
                            if (count != null) {
                            if (replace) {
                            modifier = Modifier
                            modifier = Modifier.handCursor(),
                            onCheckedChange = { replace = it },
                            verticalAlignment = CenterVertically,
                            }
                        )
                        ) {
                        Column(modifier = Modifier.weight(1f)) {
                        Row(
                        Spacer(Modifier.width(8.dp))
                        Switch(
                        baseName = "kai-settings",
                        bytes = json.encodeToByteArray(),
                        extension = "json",
                        importPreview = jsonString to detectedSections
                        importResult = ImportResult.Failure
                        modifier = Modifier
                        val detectedSections = detectImportSections(jsonObject).toImmutableMap()
                        val jsonObject = SharedJson.parseToJsonElement(jsonString).jsonObject
                        val jsonString = bytes.decodeToString()
                        verticalAlignment = CenterVertically,
                        }
                    )
                    ) {
                    Row(
                    Spacer(Modifier.height(12.dp))
                    for ((section, count) in sortedEntries) {
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    saveFileToDevice(
                    scrollState = exportScrollState,
                    scrollState = importScrollState,
                    try {
                    val bytes = file.readBytes()
                    }
                    } catch (_: Exception) {
                )
                Column(modifier = Modifier.verticalScroll(exportScrollState)) {
                Column(modifier = Modifier.verticalScroll(importScrollState)) {
                Text(stringResource(Res.string.settings_export))
                Text(stringResource(Res.string.settings_import))
                Text(stringResource(Res.string.settings_mcp_cancel))
                VerticalScrollbarForScroll(
                enabled = selectedSections.isNotEmpty(),
                exportPreview = null
                exportPreview = onPrepareExport().toImmutableMap()
                filePickerLauncher?.launch()
                importPreview = null
                importResult = null
                importResult = onImportSettings(jsonString.encodeToByteArray(), selectedSections, replace)
                modifier = Modifier.handCursor(),
                onClick = onDismiss,
                onClick = { onConfirm(selectedSections) },
                onClick = { onConfirm(selectedSections, replace) },
                scope.launch {
                val json = onExportSettings(selectedSections)
                }
            ) {
            Box {
            Button(
            Text(stringResource(Res.string.settings_export))
            Text(stringResource(Res.string.settings_export_preview_title))
            Text(stringResource(Res.string.settings_import))
            Text(stringResource(Res.string.settings_import_preview_title))
            TextButton(
            color = color,
            if (file != null) {
            is ImportResult.Failure -> stringResource(Res.string.settings_import_error) to MaterialTheme.colorScheme.error
            is ImportResult.PartialSuccess -> stringResource(Res.string.settings_import_partial, result.errorCount) to MaterialTheme.colorScheme.primary
            is ImportResult.Success -> stringResource(Res.string.settings_import_success) to MaterialTheme.colorScheme.primary
            modifier = Modifier.handCursor(),
            onClick = {
            onConfirm = { selectedSections ->
            onConfirm = { selectedSections, replace ->
            onDismiss = { exportPreview = null },
            onDismiss = { importPreview = null },
            sectionDetails = sectionDetails,
            style = MaterialTheme.typography.bodySmall,
            text = text,
            type = FileKitType.File(extensions = listOf("json")),
            val exportScrollState = rememberScrollState()
            val importScrollState = rememberScrollState()
            }
            },
        )
        ) {
        ) { file ->
        ExportPreviewDialog(
        ImportPreviewDialog(
        OutlinedButton(
        Spacer(Modifier.height(8.dp))
        Text(
        color = MaterialTheme.colorScheme.onBackground,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        confirmButton = {
        dismissButton = {
        null
        onDismissRequest = onDismiss,
        rememberFilePickerLauncher(
        style = MaterialTheme.typography.bodySmall,
        style = MaterialTheme.typography.titleMedium,
        text = stringResource(Res.string.settings_export_import_description),
        text = stringResource(Res.string.settings_export_import_title),
        text = {
        title = {
        val (text, color) = when (val result = importResult!!) {
        }
        },
    )
    // FlowRow so the two buttons drop onto separate lines at large font scales
    // instead of squeezing the second one until its label breaks mid-word.
    AlertDialog(
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
    ImportSection.CONVERSATIONS -> stringResource(Res.string.settings_import_section_conversations)
    ImportSection.EMAIL -> stringResource(Res.string.settings_import_section_email)
    ImportSection.HEARTBEAT -> stringResource(Res.string.settings_import_section_heartbeat)
    ImportSection.MCP -> stringResource(Res.string.settings_import_section_mcp)
    ImportSection.MEMORY -> stringResource(Res.string.settings_import_section_memory)
    ImportSection.SCHEDULING -> stringResource(Res.string.settings_import_section_scheduling)
    ImportSection.SERVICES -> stringResource(Res.string.settings_import_section_services)
    ImportSection.SMS -> stringResource(Res.string.settings_sms)
    ImportSection.SOUL -> stringResource(Res.string.settings_import_section_soul)
    ImportSection.SPLINTERLANDS -> "Splinterlands"
    ImportSection.TOOLS -> stringResource(Res.string.settings_import_section_tools)
    Spacer(Modifier.height(12.dp))
    Spacer(Modifier.height(4.dp))
    Text(
    exportPreview?.let { sectionDetails ->
    if (importResult != null) {
    importPreview?.let { (jsonString, sectionDetails) ->
    onConfirm: (Set<ImportSection>) -> Unit,
    onConfirm: (Set<ImportSection>, Boolean) -> Unit,
    onDismiss: () -> Unit,
    onExportSettings: (Set<ImportSection>) -> String,
    onImportSettings: (ByteArray, Set<ImportSection>, Boolean) -> ImportResult,
    onPrepareExport: () -> Map<ImportSection, String?>,
    sectionDetails: ImmutableMap<ImportSection, String?>,
    val filePickerLauncher = if (!isPreview) {
    val isPreview = LocalInspectionMode.current
    val scope = rememberCoroutineScope()
    val sortedEntries = remember(sectionDetails) { sectionDetails.entries.sortedBy { it.key } }
    var exportPreview by remember { mutableStateOf<ImmutableMap<ImportSection, String?>?>(null) }
    var importPreview by remember { mutableStateOf<Pair<String, ImmutableMap<ImportSection, String?>>?>(null) }
    var importResult by remember { mutableStateOf<ImportResult?>(null) }
    var replace by remember { mutableStateOf(true) }
    var selectedSections by remember { mutableStateOf<Set<ImportSection>>(sectionDetails.keys) }
    }
    } else {
) {
@Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.ImportSection
import com.inspiredandroid.kai.data.SharedJson
import com.inspiredandroid.kai.data.detectImportSections
import com.inspiredandroid.kai.saveFileToDevice
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import io.github.vinceglb.filekit.dialogs.FileKitType
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher
import io.github.vinceglb.filekit.readBytes
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.settings_export
import kai.composeapp.generated.resources.settings_export_import_description
import kai.composeapp.generated.resources.settings_export_import_title
import kai.composeapp.generated.resources.settings_export_preview_title
import kai.composeapp.generated.resources.settings_import
import kai.composeapp.generated.resources.settings_import_error
import kai.composeapp.generated.resources.settings_import_partial
import kai.composeapp.generated.resources.settings_import_preview_title
import kai.composeapp.generated.resources.settings_import_replace_all
import kai.composeapp.generated.resources.settings_import_replace_all_description
import kai.composeapp.generated.resources.settings_import_section_conversations
import kai.composeapp.generated.resources.settings_import_section_email
import kai.composeapp.generated.resources.settings_import_section_heartbeat
import kai.composeapp.generated.resources.settings_import_section_mcp
import kai.composeapp.generated.resources.settings_import_section_memory
import kai.composeapp.generated.resources.settings_import_section_scheduling
import kai.composeapp.generated.resources.settings_import_section_services
import kai.composeapp.generated.resources.settings_import_section_soul
import kai.composeapp.generated.resources.settings_import_section_tools
import kai.composeapp.generated.resources.settings_import_success
import kai.composeapp.generated.resources.settings_mcp_cancel
import kai.composeapp.generated.resources.settings_sms
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.launch
import kotlinx.serialization.json.jsonObject
import org.jetbrains.compose.resources.stringResource
internal fun ExportImportSection(
package com.inspiredandroid.kai.ui.settings
private fun ExportPreviewDialog(
private fun ImportPreviewDialog(
private fun sectionDisplayName(section: ImportSection): String = when (section) {
}
