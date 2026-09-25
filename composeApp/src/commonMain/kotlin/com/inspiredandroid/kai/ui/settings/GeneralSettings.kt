
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(12.dp),
                                        )
                                        .background(
                                        .padding(horizontal = 4.dp)
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                    MaterialTheme.colorScheme.onSurface
                                    Modifier
                                color = if (isSelected) {
                                if (isSelected) {
                                style = MaterialTheme.typography.bodyMedium,
                                text = label,
                                } else {
                                },
                            )
                            ),
                            .handCursor()
                            .then(
                            Text(
                            expanded = false
                            onChangeThemeMode(mode)
                        contentDescription = null,
                        imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                        isDaemonEnabled = uiState.isDaemonEnabled,
                        modifier = Modifier
                        modifier = Modifier.handCursor(),
                        onChangeUiScale = actions.onChangeUiScale,
                        onClick = {
                        onToggleDaemon = actions.onToggleDaemon,
                        text = {
                        tint = MaterialTheme.colorScheme.onBackground,
                        uiScale = uiState.uiScale,
                        },
                    )
                    .clickable { expanded = true },
                    .handCursor()
                    .matchParentSize()
                    DaemonModeToggle(
                    DropdownMenuItem(
                    Icon(
                    UiScaleSection(
                    isDynamicUiEnabled = uiState.isDynamicUiEnabled,
                    onChangeThemeMode = actions.onChangeThemeMode,
                    onExportSettings = actions.onExportSettings,
                    onImportSettings = actions.onImportSettings,
                    onPrepareExport = actions.onPrepareExport,
                    onToggleDynamicUi = actions.onToggleDynamicUi,
                    themeMode = uiState.themeMode,
                    val isSelected = mode == themeMode
                )
                DynamicUiToggle(
                ExportImportSection(
                SettingsCard {
                ThemeModePicker(
                color = MaterialTheme.colorScheme.onBackground,
                expanded = expanded,
                modifier = Modifier
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = { expanded = false },
                onValueChange = {},
                options.forEach { (mode, label) ->
                readOnly = true,
                shape = RoundedCornerShape(16.dp),
                style = MaterialTheme.typography.labelLarge,
                style = MaterialTheme.typography.titleMedium,
                text = "${(sliderValue * 100).roundToInt()}%",
                text = stringResource(Res.string.settings_ui_scale),
                trailingIcon = {
                value = selectedLabel,
                }
                },
            )
            ) {
            // Transparent overlay to capture clicks reliably on all platforms
            Box(
            DropdownMenu(
            KaiOutlinedTextField(
            SettingsCard {
            Text(
            checked = isDaemonEnabled,
            checked = isDynamicUiEnabled,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            description = stringResource(Res.string.settings_daemon_mode_description),
            description = stringResource(Res.string.settings_dynamic_ui_description),
            horizontalArrangement = Arrangement.SpaceBetween,
            if (uiState.showDaemonToggle) {
            if (uiState.showUiScale) {
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp),
            onCheckedChange = onToggleDaemon,
            onCheckedChange = onToggleDynamicUi,
            onValueChange = { sliderValue = it },
            onValueChangeFinished = { onChangeUiScale(sliderValue) },
            steps = steps,
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.settings_theme),
            text = stringResource(Res.string.settings_theme_description),
            title = stringResource(Res.string.settings_daemon_mode),
            title = stringResource(Res.string.settings_dynamic_ui),
            value = sliderValue,
            valueRange = 0.5f..2.0f,
            verticalAlignment = Alignment.CenterVertically,
            }
        )
        ) {
        Box(modifier = Modifier.fillMaxWidth()) {
        KaiSlider(
        Row(
        Text(
        ThemeMode.Dark to stringResource(Res.string.settings_theme_dark),
        ThemeMode.Light to stringResource(Res.string.settings_theme_light),
        ThemeMode.OledBlack to stringResource(Res.string.settings_theme_oled),
        ThemeMode.System to stringResource(Res.string.settings_theme_system),
        ToggleableHeadline(
        end = {
        start = {
        }
        },
    )
    Column(modifier = Modifier.fillMaxWidth()) {
    StaggeredSettingsColumns(
    isDaemonEnabled: Boolean,
    isDynamicUiEnabled: Boolean,
    onChangeThemeMode: (ThemeMode) -> Unit,
    onChangeUiScale: (Float) -> Unit,
    onToggleDaemon: (Boolean) -> Unit,
    onToggleDynamicUi: (Boolean) -> Unit,
    themeMode: ThemeMode,
    uiScale: Float,
    val options = listOf(
    val selectedLabel = options.first { it.first == themeMode }.second
    val steps = 14 // 16 snap points from 50% to 200% in 10% increments (14 intermediate)
    var expanded by remember { mutableStateOf(false) }
    var sliderValue by remember(uiScale) { mutableStateOf(uiScale) }
    }
) {
@Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.KaiSlider
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_arrow_drop_down
import kai.composeapp.generated.resources.settings_daemon_mode
import kai.composeapp.generated.resources.settings_daemon_mode_description
import kai.composeapp.generated.resources.settings_dynamic_ui
import kai.composeapp.generated.resources.settings_dynamic_ui_description
import kai.composeapp.generated.resources.settings_theme
import kai.composeapp.generated.resources.settings_theme_dark
import kai.composeapp.generated.resources.settings_theme_description
import kai.composeapp.generated.resources.settings_theme_light
import kai.composeapp.generated.resources.settings_theme_oled
import kai.composeapp.generated.resources.settings_theme_system
import kai.composeapp.generated.resources.settings_ui_scale
import kotlin.math.roundToInt
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun GeneralContent(uiState: SettingsUiState, actions: SettingsActions) {
package com.inspiredandroid.kai.ui.settings
private fun DaemonModeToggle(
private fun DynamicUiToggle(
private fun ThemeModePicker(
private fun UiScaleSection(
}
