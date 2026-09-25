package com.inspiredandroid.kai.ui.settings
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.formatFileSize
import com.inspiredandroid.kai.inference.DevicePerformance
import com.inspiredandroid.kai.inference.DownloadError
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.ModelImportError
import com.inspiredandroid.kai.inference.calculateDevicePerformance
import com.inspiredandroid.kai.inference.estimateGpuMemoryMb
import com.inspiredandroid.kai.network.dtos.SponsorsResponseDto
import com.inspiredandroid.kai.ui.KaiClearableTextField
import com.inspiredandroid.kai.ui.components.KaiSlider
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.icons.DragIndicator
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import com.inspiredandroid.kai.ui.kaiAdaptiveCardSurface
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.dialogs.FileKitType
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_arrow_drop_down
import kai.composeapp.generated.resources.litert_cancel
import kai.composeapp.generated.resources.litert_context_size
import kai.composeapp.generated.resources.litert_download
import kai.composeapp.generated.resources.litert_error_checksum_mismatch
import kai.composeapp.generated.resources.litert_error_download_incomplete
import kai.composeapp.generated.resources.litert_error_import_failed
import kai.composeapp.generated.resources.litert_error_import_invalid
import kai.composeapp.generated.resources.litert_error_import_too_small
import kai.composeapp.generated.resources.litert_error_network
import kai.composeapp.generated.resources.litert_error_not_enough_disk_space
import kai.composeapp.generated.resources.litert_free_space
import kai.composeapp.generated.resources.litert_import
import kai.composeapp.generated.resources.litert_import_description
import kai.composeapp.generated.resources.litert_imported
import kai.composeapp.generated.resources.litert_importing
import kai.composeapp.generated.resources.litert_on_device_description
import kai.composeapp.generated.resources.litert_performance_good
import kai.composeapp.generated.resources.litert_performance_ok
import kai.composeapp.generated.resources.litert_performance_poor
import kai.composeapp.generated.resources.litert_recommended
import kai.composeapp.generated.resources.litert_tool_support
import kai.composeapp.generated.resources.settings_add_service
import kai.composeapp.generated.resources.settings_api_key_label
import kai.composeapp.generated.resources.settings_api_key_optional_label
import kai.composeapp.generated.resources.settings_base_url_label
import kai.composeapp.generated.resources.settings_become_sponsor
import kai.composeapp.generated.resources.settings_business_partnerships
import kai.composeapp.generated.resources.settings_business_partnerships_description
import kai.composeapp.generated.resources.settings_contact_sponsorship
import kai.composeapp.generated.resources.settings_custom_model_hint
import kai.composeapp.generated.resources.settings_custom_model_label
import kai.composeapp.generated.resources.settings_free_fallback
import kai.composeapp.generated.resources.settings_free_tier_description
import kai.composeapp.generated.resources.settings_free_tier_title
import kai.composeapp.generated.resources.settings_model_label
import kai.composeapp.generated.resources.settings_open_app_settings
import kai.composeapp.generated.resources.settings_openai_compatible_or_other_service
import kai.composeapp.generated.resources.settings_openai_compatible_providers
import kai.composeapp.generated.resources.settings_openai_compatible_setup_ollama
import kai.composeapp.generated.resources.settings_remove_service
import kai.composeapp.generated.resources.settings_reorder_content_description
import kai.composeapp.generated.resources.settings_sign_in_copy_api_key_from
import kai.composeapp.generated.resources.settings_sponsors
import kai.composeapp.generated.resources.settings_status_checking
import kai.composeapp.generated.resources.settings_status_connected
import kai.composeapp.generated.resources.settings_status_error
import kai.composeapp.generated.resources.settings_status_error_connection_failed
import kai.composeapp.generated.resources.settings_status_error_invalid_key
import kai.composeapp.generated.resources.settings_status_error_local_network
import kai.composeapp.generated.resources.settings_status_error_quota_exhausted
import kai.composeapp.generated.resources.settings_status_error_rate_limited
import kotlin.math.roundToInt
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import sh.calvin.reorderable.ReorderableColumn

                                                    color = MaterialTheme.colorScheme.surfaceContainerHighest,
                                                    shape = RoundedCornerShape(8.dp),
                                                )
                                                Modifier
                                                Modifier.background(
                                            if (isSpecial) {
                                            } else {
                                            },
                                        ),
                                        .size(36.dp)
                                        .then(
                                        contentDescription = null,
                                        imageVector = vectorResource(service.icon),
                                        modifier = Modifier.size(20.dp),
                                        tint = MaterialTheme.colorScheme.onBackground,
                                    )
                                    Icon(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                    style = MaterialTheme.typography.bodyLarge,
                                    text = service.displayName,
                                "${model.displayName} (${stringResource(Res.string.litert_imported)})"
                                "${model.displayName} (${stringResource(Res.string.litert_recommended)})"
                                )
                                ) {
                                Box(
                                Spacer(Modifier.width(12.dp))
                                Text(
                                actions.onAddService(service)
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                                showAddServiceSheet = false
                                verticalAlignment = Alignment.CenterVertically,
                                }
                            ) {
                            Row(
                            bottomEnd = if (isLast) 12.dp else 0.dp,
                            bottomStart = if (isLast) 12.dp else 0.dp,
                            color = MaterialTheme.colorScheme.error,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            color = MaterialTheme.colorScheme.surfaceContainer,
                            contentDescription = null,
                            else -> model.displayName
                            imageVector = Icons.Default.Delete,
                            maxLines = 1,
                            model.isRecommended ->
                            modifier = Modifier.fillMaxWidth().handCursor(),
                            onClick = {
                            overflow = TextOverflow.Ellipsis,
                            shape = itemShape,
                            showImportedBadge ->
                            style = MaterialTheme.typography.bodySmall,
                            style = MaterialTheme.typography.labelSmall,
                            text = displayModelId,
                            text = formatFileSize(model.sizeBytes),
                            text = stringResource(Res.string.litert_cancel),
                            text = stringResource(Res.string.settings_remove_service),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            topEnd = if (isFirst) 12.dp else 0.dp,
                            topStart = if (isFirst) 12.dp else 0.dp,
                            }
                            },
                        )
                        ) {
                        .background(dotColor),
                        .clickable { onToggleFreeFallback(!isFreeFallbackEnabled) }
                        .clip(CircleShape)
                        .clip(CircleShape),
                        .clip(RoundedCornerShape(8.dp))
                        .handCursor(),
                        .size(10.dp)
                        .size(40.dp)
                        DevicePerformanceLabel(performance)
                        Icon(
                        Spacer(Modifier.width(8.dp))
                        Surface(
                        Text(
                        Text(stringResource(Res.string.litert_download))
                        apiKey = entry.apiKey,
                        apiKeyUrl = entry.service.apiKeyUrl ?: "",
                        apiKeyUrlDisplay = entry.service.apiKeyUrlDisplay ?: "",
                        availableModels = localAvailableModels,
                        baseUrl = entry.baseUrl,
                        checked = isFreeFallbackEnabled,
                        color = MaterialTheme.colorScheme.onBackground,
                        color = MaterialTheme.colorScheme.onSurface,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        connectionStatus = entry.connectionStatus,
                        contentDescription = stringResource(Res.string.settings_reorder_content_description),
                        customModelId = entry.customModelId,
                        downloadError = localDownloadError,
                        downloadProgress = localDownloadProgress,
                        downloadedModels = entry.models,
                        downloadingModelId = localDownloadingModelId,
                        else -> null
                        enabled = !isBusy,
                        entry.selectedModel != null -> entry.selectedModel.id
                        entry.useCustomModel && entry.customModelId.isNotBlank() -> entry.customModelId
                        freeSpaceBytes = localFreeSpaceBytes,
                        imageVector = Icons.Rounded.DragIndicator,
                        importError = localImportError,
                        importProgress = localImportProgress,
                        importedModels = localImportedModels,
                        importingFileName = localImportingFileName,
                        modelContextTokens = modelContextTokens,
                        models = entry.models,
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.size(20.dp),
                        modifier = Modifier.weight(1f),
                        modifier = dragHandleModifier.handCursor(),
                        onCancelDownload = onCancelLocalModelDownload,
                        onCancelImport = onCancelLocalModelImport,
                        onChangeApiKey = onChangeApiKey,
                        onChangeBaseUrl = onChangeBaseUrl,
                        onChangeCustomModelId = onChangeCustomModelId,
                        onChangeModelContextTokens = onChangeModelContextTokens,
                        onChangeModelContextTokens(model.id, contextTokens)
                        onCheckedChange = onToggleFreeFallback,
                        onClick = onCancelDownload,
                        onClick = onRemove,
                        onClick = { onDeleteModel(model.id) },
                        onClick = { onDownloadModel(model) },
                        onClick = { onSelectModel(model.id) },
                        onDeleteModel = onDeleteLocalModel,
                        onDownloadModel = onDownloadLocalModel,
                        onImportModel = onImportLocalModel,
                        onOpenAppPermissionSettings = onOpenAppPermissionSettings,
                        onSelectModel = onSelectModel,
                        onToggleUseCustomModel = onToggleUseCustomModel,
                        selected = isSelected,
                        selectedModel = entry.selectedModel,
                        style = MaterialTheme.typography.bodyLarge,
                        style = MaterialTheme.typography.bodyMedium,
                        style = MaterialTheme.typography.labelSmall,
                        style = MaterialTheme.typography.titleMedium,
                        text = "${(downloadProgress * 100).toInt()}%",
                        text = entry.service.displayName,
                        text = stringResource(Res.string.litert_cancel),
                        text = stringResource(Res.string.settings_free_fallback),
                        text = when {
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        totalDeviceMemoryBytes = totalDeviceMemoryBytes,
                        useCustomModel = entry.useCustomModel,
                        val isFirst = index == 0
                        val isLast = index == services.lastIndex
                        val isSpecial = service.isOnDevice || service is Service.OpenAICompatible || service is Service.AtlasCloud
                        val itemShape = RoundedCornerShape(
                        verticalAlignment = Alignment.CenterVertically,
                        }
                        },
                    )
                    ) {
                    .align(CenterHorizontally)
                    .clickable { uriHandler.openUri("https://github.com/${sponsor.username}") }
                    .clip(RoundedCornerShape(8.dp))
                    .handCursor()
                    .handCursor(),
                    .padding(4.dp),
                    .toImmutableList()
                    .width(tileWidth)
                    ConnectionStatus.Checking -> StatusColorChecking
                    ConnectionStatus.Connected -> StatusColorConnected
                    ConnectionStatus.Unknown -> StatusColorUnknown
                    DownloadError.CHECKSUM_MISMATCH -> Res.string.litert_error_checksum_mismatch
                    DownloadError.DOWNLOAD_INCOMPLETE -> Res.string.litert_error_download_incomplete
                    DownloadError.NETWORK_ERROR -> Res.string.litert_error_network
                    DownloadError.NOT_ENOUGH_DISK_SPACE -> Res.string.litert_error_not_enough_disk_space
                    Icon(
                    IconButton(
                    LiteRTSettings(
                    ModelImportError.CANCELLED -> Res.string.litert_error_import_failed
                    ModelImportError.COPY_FAILED -> Res.string.litert_error_import_failed
                    ModelImportError.FILE_TOO_SMALL -> Res.string.litert_error_import_too_small
                    ModelImportError.INVALID_EXTENSION -> Res.string.litert_error_import_invalid
                    ModelImportError.NOT_ENOUGH_DISK_SPACE -> Res.string.litert_error_not_enough_disk_space
                    OpenAICompatibleSettings(
                    RadioButton(
                    Row(
                    ServiceSettings(
                    Spacer(Modifier.height(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Switch(
                    Text(
                    Text(stringResource(Res.string.settings_open_app_settings))
                    TextButton(
                    append("github.com/ollama/ollama")
                    append(apiKeyUrlDisplay)
                    append(providersText)
                    color = MaterialTheme.colorScheme.error,
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    color = MaterialTheme.colorScheme.primary,
                    color = warningColor,
                    contentDescription = null,
                    contentDescription = sponsor.username,
                    contentScale = ContentScale.Crop,
                    dragHandleModifier = if (entries.size >= 2) Modifier.draggableHandle() else null,
                    else -> StatusColorError
                    entry = entry,
                    horizontalArrangement = Arrangement.End,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    if (displayModelId != null) {
                    imageVector = Icons.Default.CheckCircle,
                    imageVector = Icons.Default.Warning,
                    imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                    isDragging = isDragging,
                    isExpanded = uiState.expandedServiceId == entry.instanceId,
                    localAvailableModels = uiState.localAvailableModels,
                    localDownloadError = uiState.localDownloadError,
                    localDownloadProgress = uiState.localDownloadProgress,
                    localDownloadingModelId = uiState.localDownloadingModelId,
                    localFreeSpaceBytes = uiState.localFreeSpaceBytes,
                    localImportError = uiState.localImportError,
                    localImportProgress = uiState.localImportProgress,
                    localImportedModels = uiState.localImportedModels,
                    localImportingFileName = uiState.localImportingFileName,
                    maxLines = 2,
                    model = sponsor.avatar,
                    modelContextTokens = uiState.modelContextTokens,
                    modifier = Modifier
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    modifier = Modifier.fillMaxWidth()
                    modifier = Modifier.fillMaxWidth(),
                    modifier = Modifier.handCursor(),
                    modifier = Modifier.size(16.dp),
                    onCancelLocalModelDownload = actions.onCancelLocalModelDownload,
                    onCancelLocalModelImport = actions.onCancelLocalModelImport,
                    onChangeApiKey = { apiKey -> actions.onChangeApiKey(entry.instanceId, apiKey) },
                    onChangeBaseUrl = { baseUrl -> actions.onChangeBaseUrl(entry.instanceId, baseUrl) },
                    onChangeCustomModelId = { id -> actions.onChangeCustomModelId(entry.instanceId, id) },
                    onChangeModelContextTokens = actions.onChangeModelContextTokens,
                    onClick = onCancelImport,
                    onClick = onOpenAppPermissionSettings,
                    onDeleteLocalModel = actions.onDeleteLocalModel,
                    onDownloadLocalModel = actions.onDownloadLocalModel,
                    onExpand = { actions.onExpandService(if (uiState.expandedServiceId == entry.instanceId) null else entry.instanceId) },
                    onImportLocalModel = actions.onImportLocalModel,
                    onOpenAppPermissionSettings = actions.onOpenAppPermissionSettings,
                    onRecheckLocalNetworkPermission = { actions.onRecheckLocalNetworkPermission(entry.instanceId) },
                    onRemove = { actions.onRemoveService(entry.instanceId) },
                    onSelectModel = { modelId -> actions.onSelectModel(entry.instanceId, modelId) },
                    onToggleUseCustomModel = { use -> actions.onToggleUseCustomModel(entry.instanceId, use) },
                    onValueChange = { contextSliderValue = it },
                    onValueChangeFinished = {
                    overflow = TextOverflow.Ellipsis,
                    progress = { downloadProgress },
                    scrollState = addServiceScrollState,
                    services.forEachIndexed { index, service ->
                    sponsors = allSponsors,
                    steps = (steps - 1).coerceAtLeast(0),
                    stringResource(Res.string.settings_model_label),
                    strokeWidth = 2.dp,
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.labelSmall,
                    text = "${(importProgress * 100).toInt()}%",
                    text = errorMessage,
                    text = sponsor.username,
                    text = stringResource(Res.string.settings_status_checking),
                    text = stringResource(Res.string.settings_status_connected),
                    text = stringResource(Res.string.settings_status_error_quota_exhausted),
                    textAlign = TextAlign.Center,
                    tint = MaterialTheme.colorScheme.error,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    tint = MaterialTheme.colorScheme.primary,
                    tint = warningColor,
                    title = stringResource(Res.string.settings_sponsors),
                    totalDeviceMemoryBytes = uiState.totalDeviceMemoryBytes,
                    uriHandler.openUri("https://github.com/sponsors/SimonSchubert")
                    uriHandler.openUri("https://schubert-simon.de")
                    val displayModelId = when {
                    val services = uiState.availableServicesToAdd
                    value = contextSliderValue,
                    valueRange = 0f..steps.toFloat(),
                    verticalAlignment = Alignment.CenterVertically,
                    }
                    },
                (currentSponsors + pastSponsors.filter { it.username !in activeUsernames })
                )
                ) {
                // Connection status dot
                // Drag handle
                // Expand/collapse chevron
                // Remove action
                // Service name and model
                Box(
                CircularProgressIndicator(
                Column(modifier = Modifier.verticalScroll(addServiceScrollState).padding(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                ConfiguredServiceCardContent(
                ConnectionStatus.ErrorConnectionFailed -> stringResource(Res.string.settings_status_error_connection_failed)
                ConnectionStatus.ErrorInvalidKey -> stringResource(Res.string.settings_status_error_invalid_key)
                ConnectionStatus.ErrorLocalNetworkDenied -> stringResource(Res.string.settings_status_error_local_network)
                ConnectionStatus.ErrorRateLimited -> stringResource(Res.string.settings_status_error_rate_limited)
                HorizontalDivider(thickness = 0.5.dp)
                Icon(
                Icon(Icons.Default.Favorite, contentDescription = null)
                KaiSlider(
                LinearProgressIndicator(
                Modifier
                Row(
                Spacer(Modifier.height(12.dp))
                Spacer(Modifier.height(16.dp))
                Spacer(Modifier.height(4.dp))
                Spacer(Modifier.height(6.dp))
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.width(12.dp))
                Spacer(Modifier.width(8.dp))
                SponsorList(
                Text(
                Text(stringResource(Res.string.settings_become_sponsor))
                Text(stringResource(Res.string.settings_contact_sponsorship))
                TextButton(
                VerticalScrollbarForScroll(
                coil3.compose.AsyncImage(
                color = MaterialTheme.colorScheme.onBackground,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                color = MaterialTheme.colorScheme.primary,
                downloadProgress = null,
                else -> stringResource(Res.string.settings_status_error)
                horizontalAlignment = CenterHorizontally,
                horizontalArrangement = Arrangement.SpaceBetween,
                if (dragHandleModifier != null) {
                if (entry.service.isOnDevice) {
                if (isDownloaded) {
                isBusy = isBusy,
                isDownloaded = true,
                isDownloading = false,
                isSelected = selectedModel?.id == model.id,
                labelText,
                model = model,
                modelContextTokens = modelContextTokens,
                modifier = Modifier
                modifier = Modifier.fillMaxWidth(),
                onCancelDownload = onCancelDownload,
                onChangeModelContextTokens = onChangeModelContextTokens,
                onClick = {
                onDeleteModel = onDeleteModel,
                onDownloadModel = onDownloadModel,
                onSelectModel = onSelectModel,
                progress = { importProgress },
                showImportedBadge = true,
                stringResource(Res.string.settings_base_url_label),
                style = MaterialTheme.typography.bodySmall,
                style = MaterialTheme.typography.labelLarge,
                style = MaterialTheme.typography.labelSmall,
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(Res.string.litert_context_size, "${contextTokens / 1024}K"),
                text = stringResource(Res.string.settings_business_partnerships),
                text = stringResource(Res.string.settings_business_partnerships_description),
                text = stringResource(Res.string.settings_free_tier_description),
                text = stringResource(Res.string.settings_free_tier_title),
                totalDeviceMemoryBytes = totalDeviceMemoryBytes,
                val activeUsernames = currentSponsors.map { it.username }.toSet()
                val dotColor = when (entry.connectionStatus) {
                verticalAlignment = Alignment.CenterVertically,
                when (downloadError) {
                when (importError) {
                withStyle(style = SpanStyle(color = linkColor)) {
                }
                } else if (!isDownloading) {
                } else if (entry.service is Service.OpenAICompatible) {
                } else {
                },
            )
            ) {
            ),
            .clickable { onExpand() }
            .clickable { onToggleUseCustomModel(!useCustomModel) }
            .fillMaxWidth()
            .handCursor(),
            .kaiAdaptiveCardSurface()
            // A model whose export tops out at its own default (LFM2.5) has nothing to
            // Header row
            // drag: a 0f..0f range divides by zero working out the thumb fraction. Show
            // the fixed size as a label and leave the slider out.
            Box {
            Button(
            Column(
            Column(modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 16.dp)) {
            HorizontalDivider(thickness = 0.5.dp)
            LinearProgressIndicator(
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            LocalModelCard(
            ReorderableItem {
            Row(
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(16.dp))
            Spacer(Modifier.height(4.dp))
            Spacer(Modifier.height(6.dp))
            Spacer(Modifier.height(8.dp))
            Text(
            Text(stringResource(Res.string.settings_add_service))
            TextButton(
            actions.onReorderServices(ids)
            append(" ")
            append(copyApiKeyPromptString)
            append(orOtherServiceText)
            append(setupOllamaText)
            checked = useCustomModel,
            color = MaterialTheme.colorScheme.error,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            color = StatusColorChecking,
            color = StatusColorConnected,
            color = StatusColorError,
            downloadProgress = downloadProgress,
            ids.add(toIndex, ids.removeAt(fromIndex))
            if (allSponsors.isNotEmpty()) {
            if (file != null) onImportModel(file)
            if (isDownloading && downloadProgress != null) {
            if (showFallbackToggle) {
            if (status == ConnectionStatus.ErrorLocalNetworkDenied) {
            if (steps > 0) {
            isBusy = isBusy,
            isDownloaded = model.id in downloadedIds,
            isDownloading = downloadingModelId == model.id,
            isSelected = selectedModel?.id == model.id,
            label = {
            model = model,
            modelContextTokens = modelContextTokens,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 4.dp),
            onCancelDownload = onCancelDownload,
            onChangeModelContextTokens = onChangeModelContextTokens,
            onCheckedChange = onToggleUseCustomModel,
            onDeleteModel = onDeleteModel,
            onDismissRequest = { showAddServiceSheet = false },
            onDownloadModel = onDownloadModel,
            onPauseOrDispose { }
            onRecheckLocalNetworkPermission()
            onSelectModel = onSelectModel,
            onValueChange = onChangeCustomModelId,
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
            showImportedBadge = false,
            singleLine = true,
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.labelSmall,
            style = MaterialTheme.typography.titleSmall,
            text = "${baseUrl.trimEnd('/')}${Service.OpenAICompatible.chatUrl}",
            text = stringResource(
            text = stringResource(Res.string.litert_imported),
            text = stringResource(Res.string.litert_importing) + " $importingFileName",
            text = stringResource(Res.string.litert_performance_good),
            text = stringResource(Res.string.litert_performance_ok),
            text = stringResource(Res.string.litert_performance_poor),
            text = stringResource(Res.string.settings_custom_model_hint),
            text = stringResource(Res.string.settings_custom_model_label),
            totalDeviceMemoryBytes = totalDeviceMemoryBytes,
            type = FileKitType.File(extensions = listOf("litertlm")),
            val addServiceScrollState = rememberScrollState()
            val allSponsors = remember(currentSponsors, pastSponsors) {
            val errorMessage = when (status) {
            val ids = entries.map { it.instanceId }.toMutableList()
            val uriHandler = LocalUriHandler.current
            val warningColor = Color(0xFFFF9800)
            value = customModelId,
            withLink(LinkAnnotation.Url(url = "https://docs.litellm.ai/docs/providers")) {
            withLink(LinkAnnotation.Url(url = "https://github.com/ollama/ollama")) {
            withLink(LinkAnnotation.Url(url = apiKeyUrl)) {
            }
            },
        )
        ) {
        ) { file ->
        -> {
        // Expanded content
        // The tile width is sized for the username at the default font scale; without
        // scaling it, names are cut to three characters at the largest one.
        Checkbox(
        Column(modifier = Modifier.padding(12.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
        ConnectionStatus.Checking -> {
        ConnectionStatus.Connected -> {
        ConnectionStatus.Error,
        ConnectionStatus.ErrorConnectionFailed,
        ConnectionStatus.ErrorInvalidKey,
        ConnectionStatus.ErrorLocalNetworkDenied,
        ConnectionStatus.ErrorQuotaExhausted -> {
        ConnectionStatus.ErrorRateLimited,
        ConnectionStatus.Unknown -> return
        DevicePerformance.GOOD -> Text(
        DevicePerformance.OK -> Text(
        DevicePerformance.POOR -> Text(
        KaiClearableTextField(
        LifecycleResumeEffect(entry.instanceId) {
        LocalModelCard(
        ModalBottomSheet(
        ModelSelection(selectedModel, models, onSelectModel)
        OutlinedButton(onClick = { showAddServiceSheet = true }, modifier = Modifier.handCursor()) {
        Spacer(Modifier.height(12.dp))
        Spacer(Modifier.height(4.dp))
        Spacer(Modifier.height(8.dp))
        Spacer(Modifier.width(8.dp))
        Text(
        Text(stringResource(Res.string.litert_import))
        annotatedString,
        apiKey = apiKey,
        border = kaiAdaptiveCardBorder(),
        buildAnnotatedString {
        color = MaterialTheme.colorScheme.onBackground,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        colors = kaiAdaptiveCardColors(),
        currentSponsors = uiState.currentSponsors,
        enabled = !isBusy && filePickerLauncher != null,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        if (importProgress != null) {
        if (isExpanded) {
        importedModels.forEach { model ->
        isFreeFallbackEnabled = uiState.isFreeFallbackEnabled,
        key(entry.instanceId) {
        label = {
        labelText = stringResource(Res.string.settings_api_key_label),
        labelText = stringResource(Res.string.settings_api_key_optional_label),
        list = entries,
        modifier = Modifier
        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        modifier = Modifier.handCursor(),
        modifier = if (testTag != null) Modifier.testTag(testTag) else Modifier,
        mutableStateOf(((storedContextTokens - model.defaultContextTokens) / 1024).toFloat())
        null
        onChangeApiKey = onChangeApiKey,
        onClick = { filePickerLauncher?.launch() },
        onSettle = { fromIndex, toIndex ->
        onToggleFreeFallback = actions.onToggleFreeFallback,
        onValueChange = onChangeApiKey,
        onValueChange = onChangeBaseUrl,
        pastSponsors = uiState.pastSponsors,
        rememberFilePickerLauncher(
        shape = RoundedCornerShape(8.dp),
        showFallbackToggle = entries.isNotEmpty(),
        singleLine = singleLine,
        singleLine = true,
        sponsors.forEach { sponsor ->
        style = MaterialTheme.typography.bodyMedium,
        style = MaterialTheme.typography.bodySmall,
        style = MaterialTheme.typography.labelLarge,
        testTag = testTag,
        text = stringResource(Res.string.litert_free_space, formatFileSize(freeSpaceBytes)),
        text = stringResource(Res.string.litert_import_description),
        text = stringResource(Res.string.litert_on_device_description),
        text = stringResource(Res.string.litert_tool_support),
        text = title,
        tonalElevation = if (isSelected) 3.dp else 1.dp,
        val tileWidth = 72.dp * LocalDensity.current.fontScale
        value = apiKey,
        value = baseUrl,
        verticalAlignment = Alignment.CenterVertically,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        }
        } else {
        },
    )
    ) {
    ) { _, entry, isDragging ->
    // Add service bottom sheet
    // Clear a stale denied status when the user returns from granting the permission in
    // Configured services list
    // Free tier card (always at bottom)
    // system settings; the recheck never re-prompts, so this is a no-op while still denied.
    ApiKeyField(
    Card(
    Column(
    ConnectionStatusIndicator(connectionStatus, onOpenAppPermissionSettings)
    FlowRow(
    FreeSettings(
    KaiClearableTextField(
    OutlinedButton(
    ReorderableColumn(
    Row(
    Spacer(Modifier.height(12.dp))
    Spacer(Modifier.height(16.dp))
    Spacer(Modifier.height(4.dp))
    Spacer(Modifier.height(8.dp))
    Surface(
    Text(
    apiKey: String,
    apiKeyUrl: String,
    apiKeyUrlDisplay: String,
    availableModels.forEach { model ->
    availableModels: ImmutableList<LocalModel>,
    baseUrl: String,
    connectionStatus: ConnectionStatus,
    currentSponsors: ImmutableList<SponsorsResponseDto.Sponsor> = persistentListOf(),
    customModelId: String,
    downloadError: DownloadError?,
    downloadProgress: Float?,
    downloadedModels: ImmutableList<SettingsModel>,
    downloadingModelId: String?,
    dragHandleModifier: Modifier? = null,
    entry: ConfiguredServiceEntry,
    freeSpaceBytes: Long,
    if (baseUrl.isNotBlank()) {
    if (connectionStatus == ConnectionStatus.Connected || models.isNotEmpty()) {
    if (downloadError != null) {
    if (entry.connectionStatus == ConnectionStatus.ErrorLocalNetworkDenied) {
    if (importError != null && importingFileName == null) {
    if (importedModels.isNotEmpty()) {
    if (importingFileName != null) {
    if (showAddServiceSheet) {
    if (uiState.availableServicesToAdd.isNotEmpty()) {
    if (useCustomModel) {
    importError: ModelImportError?,
    importProgress: Float?,
    importedModels: ImmutableList<LocalModel>,
    importingFileName: String?,
    isBusy: Boolean,
    isDownloaded: Boolean,
    isDownloading: Boolean,
    isDragging: Boolean = false,
    isExpanded: Boolean,
    isFreeFallbackEnabled: Boolean = true,
    isSelected: Boolean,
    labelText: String,
    localAvailableModels: ImmutableList<LocalModel> = persistentListOf(),
    localDownloadError: DownloadError? = null,
    localDownloadProgress: Float? = null,
    localDownloadingModelId: String? = null,
    localFreeSpaceBytes: Long = 0L,
    localImportError: ModelImportError? = null,
    localImportProgress: Float? = null,
    localImportedModels: ImmutableList<LocalModel> = persistentListOf(),
    localImportingFileName: String? = null,
    model: LocalModel,
    modelContextTokens: ImmutableMap<String, Int> = persistentMapOf(),
    modelContextTokens: ImmutableMap<String, Int>,
    models: ImmutableList<SettingsModel>,
    onCancelDownload: () -> Unit,
    onCancelImport: () -> Unit,
    onCancelLocalModelDownload: () -> Unit = {},
    onCancelLocalModelImport: () -> Unit = {},
    onChangeApiKey: (String) -> Unit,
    onChangeBaseUrl: (String) -> Unit,
    onChangeCustomModelId: (String) -> Unit = {},
    onChangeCustomModelId: (String) -> Unit,
    onChangeModelContextTokens: (String, Int) -> Unit = { _, _ -> },
    onChangeModelContextTokens: (String, Int) -> Unit,
    onDeleteLocalModel: (String) -> Unit = {},
    onDeleteModel: (String) -> Unit,
    onDownloadLocalModel: (LocalModel) -> Unit = {},
    onDownloadModel: (LocalModel) -> Unit,
    onExpand: () -> Unit,
    onImportLocalModel: (PlatformFile) -> Unit = {},
    onImportModel: (PlatformFile) -> Unit,
    onOpenAppPermissionSettings: () -> Unit = {},
    onRecheckLocalNetworkPermission: () -> Unit = {},
    onRemove: () -> Unit,
    onSelectModel: (String) -> Unit,
    onToggleFreeFallback: (Boolean) -> Unit = {},
    onToggleUseCustomModel: (Boolean) -> Unit = {},
    onToggleUseCustomModel: (Boolean) -> Unit,
    pastSponsors: ImmutableList<SponsorsResponseDto.Sponsor> = persistentListOf(),
    selectedModel: SettingsModel?,
    showFallbackToggle: Boolean = false,
    showImportedBadge: Boolean,
    singleLine: Boolean = false,
    sponsors: ImmutableList<SponsorsResponseDto.Sponsor>,
    testTag: String? = null,
    title: String,
    totalDeviceMemoryBytes: Long = Long.MAX_VALUE,
    totalDeviceMemoryBytes: Long,
    useCustomModel: Boolean,
    val annotatedString = remember(apiKeyUrl, apiKeyUrlDisplay) {
    val annotatedString = remember(setupOllamaText, orOtherServiceText, providersText, linkColor) {
    val contextTokens = model.defaultContextTokens + (contextSliderValue.roundToInt() * 1024)
    val copyApiKeyPromptString = stringResource(Res.string.settings_sign_in_copy_api_key_from)
    val downloadedIds = remember(downloadedModels) { downloadedModels.map { it.id }.toSet() }
    val entries = uiState.configuredServices
    val estimatedMemoryMb = estimateGpuMemoryMb(model, contextTokens)
    val filePickerLauncher = if (!isPreview) {
    val isBusy = downloadingModelId != null || importingFileName != null
    val isPreview = LocalInspectionMode.current
    val linkColor = MaterialTheme.colorScheme.primary
    val orOtherServiceText = stringResource(Res.string.settings_openai_compatible_or_other_service)
    val performance = calculateDevicePerformance(totalDeviceMemoryBytes, estimatedMemoryMb)
    val providersText = stringResource(Res.string.settings_openai_compatible_providers)
    val setupOllamaText = stringResource(Res.string.settings_openai_compatible_setup_ollama)
    val steps = (model.maxContextTokens - model.defaultContextTokens) / 1024
    val storedContextTokens = modelContextTokens[model.id] ?: model.defaultContextTokens
    val uriHandler = LocalUriHandler.current
    var contextSliderValue by remember(storedContextTokens) {
    var showAddServiceSheet by remember { mutableStateOf(false) }
    when (performance) {
    when (status) {
    }
    } else {
) {
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
internal fun FreeSettings(
internal fun ServicesContent(uiState: SettingsUiState, actions: SettingsActions) {
private fun ApiKeyField(
private fun ConfiguredServiceCardContent(
private fun ConnectionStatusIndicator(status: ConnectionStatus, onOpenAppPermissionSettings: () -> Unit = {}) {
private fun DevicePerformanceLabel(performance: DevicePerformance) {
private fun LiteRTSettings(
private fun LocalModelCard(
private fun OpenAICompatibleSettings(
private fun ServiceSettings(
private fun SponsorList(
}
