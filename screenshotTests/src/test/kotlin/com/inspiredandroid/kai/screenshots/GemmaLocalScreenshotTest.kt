import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.MODEL_CATALOG
import com.inspiredandroid.kai.ui.DarkColorScheme
import com.inspiredandroid.kai.ui.Theme
import com.inspiredandroid.kai.ui.chat.ChatScreenContent
import com.inspiredandroid.kai.ui.chat.ChatUiState
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.settings.ConfiguredServiceEntry
import com.inspiredandroid.kai.ui.settings.ConnectionStatus
import com.inspiredandroid.kai.ui.settings.SettingsModel
import com.inspiredandroid.kai.ui.settings.SettingsScreenContent
import com.inspiredandroid.kai.ui.settings.SettingsTab
import com.inspiredandroid.kai.ui.settings.SettingsUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.setResourceReaderAndroidContext
import org.jetbrains.compose.resources.vectorResource
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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
                                else -> 2
                                it is Service.AtlasCloud -> 1
                                it is Service.OpenAICompatible || it.isOnDevice -> 0
                                modifier = Modifier
                                style = MaterialTheme.typography.bodyLarge,
                                text = service.displayName,
                            )
                            ) {
                            Box(
                            Spacer(Modifier.width(12.dp))
                            Text(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            when {
                            }
                        ) {
                        .align(Alignment.CenterHorizontally)
                        .background(MaterialTheme.colorScheme.onSurfaceVariant),
                        .clip(RoundedCornerShape(2.dp))
                        .padding(bottom = 16.dp)
                        .size(width = 32.dp, height = 4.dp)
                        MODEL_E2B.id to 16_384,
                        MODEL_E4B.id to 8_192,
                        Row(
                        bottomEnd = if (index == services.lastIndex) 12.dp else 0.dp,
                        bottomStart = if (index == services.lastIndex) 12.dp else 0.dp,
                        compareBy<Service> {
                        modifier = Modifier.fillMaxWidth(),
                        shape = itemShape,
                        topEnd = if (index == 0) 12.dp else 0.dp,
                        topStart = if (index == 0) 12.dp else 0.dp,
                        }
                        }.thenBy { it.displayName },
                    )
                    ) {
                    ),
                    .filter { it != Service.Free }
                    .sortedWith(
                    .toImmutableList(),
                    Surface(
                    connectionStatus = ConnectionStatus.Connected,
                    content()
                    downloadProgress = 0.42f,
                    downloadedIds = listOf(MODEL_E2B.id),
                    downloadingModelId = MODEL_E2B.id,
                    instanceId = LITERT_INSTANCE_ID,
                    modelContextTokens = mapOf(
                    models = downloadedModels.toImmutableList(),
                    modifier = Modifier
                    selectedId = MODEL_E2B.id,
                    selectedModel = selectedModel,
                    service = Service.LiteRT,
                    val isSpecial = service.isOnDevice || service is Service.OpenAICompatible || service is Service.AtlasCloud
                    val itemShape = RoundedCornerShape(
                    }
                )
                ),
                .align(Alignment.BottomCenter),
                .fillMaxWidth()
                Box(
                ConfiguredServiceEntry(
                FakeTextToSpeechInstance(),
                Spacer(Modifier.height(16.dp))
                Theme(colorScheme = colorScheme) {
                content = "",
                content = "Summarize the last book I read in one paragraph.",
                displayName = source.displayName,
                id = "t1",
                id = "u1",
                id = source.id,
                isSelected = selectedId == id,
                isStatusMessage = true,
                role = History.Role.TOOL_EXECUTING,
                role = History.Role.USER,
                services = Service.all
                services.forEachIndexed { index, service ->
                subtitle = source.displayName,
                toolName = "Initializing ${MODEL_E2B.displayName}",
                uiState = GemmaLocalTestData.chatInitializing,
                uiState = GemmaLocalTestData.services(
                }
            "android:Theme.Material.Light.NoActionBar"
            "android:Theme.Material.NoActionBar"
            )
            ),
            .background(Color(0xFF1D1B20)),
            .fillMaxSize()
            // 8 GB keeps the Good/OK/Poor indicator in its middle bands across both models.
            AddServiceSheetPreview(
            ChatScreenContent(
            Column(modifier = Modifier.padding(16.dp)) {
            CompositionLocalProvider(LocalInspectionMode provides true) {
            History(
            SettingsModel(
            SettingsScreenContent(
            SettingsScreenContent(uiState = GemmaLocalTestData.services())
            SettingsScreenContent(uiState = GemmaLocalTestData.services(availableModels = listOf(MODEL_LFM25)))
            color = MaterialTheme.colorScheme.surfaceContainerLow,
            configuredServices = persistentListOf(
            currentTab = SettingsTab.Services,
            expandedServiceId = LITERT_INSTANCE_ID,
            localAvailableModels = availableModels.toImmutableList(),
            localDownloadProgress = downloadProgress,
            localDownloadingModelId = downloadingModelId,
            localFreeSpaceBytes = 24L * 1024L * 1024L * 1024L,
            modelContextTokens = modelContextTokens.toImmutableMap(),
            modifier = Modifier
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
            totalDeviceMemoryBytes = 8L * 1024L * 1024L * 1024L,
            val source = MODEL_CATALOG.first { it.id == id }
            }
        )
        ) {
        ),
        // LFM2.5's export tops out at its own default, so its card carries the context
        // size as a label with no slider under it.
        Surface(
        actions = ScreenshotTestData.noOpChatActions,
        availableModels: List<LocalModel> = listOf(MODEL_E2B, MODEL_E4B, MODEL_QWEN3),
        colorScheme: ColorScheme,
        content: @Composable () -> Unit,
        deviceConfig = DeviceConfig.PIXEL_9A.copy(softButtons = false),
        downloadProgress: Float? = null,
        downloadedIds: List<String> = emptyList(),
        downloadingModelId: String? = null,
        history = persistentListOf(
        isLoading = true,
        maxPercentDifference = 0.1,
        modelContextTokens: Map<String, Int> = emptyMap(),
        modifier = Modifier
        paparazzi.snap(DarkColorScheme) {
        return SettingsUiState(
        selectedId: String? = null,
        setResourceReaderAndroidContext(paparazzi.context)
        showSystemUi = true,
        snapshot {
        unsafeUpdateConfig(theme = theme)
        val downloadedModels = downloadedIds.map { id ->
        val selectedModel = selectedId?.let { id -> downloadedModels.firstOrNull { it.id == id } }
        val theme = if (colorScheme == DarkColorScheme) {
        }
        } else {
    )
    ) {
    ): SettingsUiState {
    @Before
    @Test
    @get:Rule
    Box(
    fun gemmaLocal_chat_dark() {
    fun gemmaLocal_contextSlider_dark() {
    fun gemmaLocal_download_dark() {
    fun gemmaLocal_fixedContextModel_dark() {
    fun gemmaLocal_modelCard_dark() {
    fun gemmaLocal_select_dark() {
    fun gemmaLocal_settings_dark() {
    fun services(
    fun setup() {
    private const val LITERT_INSTANCE_ID = "litert"
    private fun Paparazzi.snap(
    val chatInitializing = ChatUiState(
    val paparazzi = Paparazzi(
    }
 * Each test renders a specific state of the LiteRT settings card or the chat "Initializing" state.
 * Mirrors the "Add service" ModalBottomSheet content in SettingsScreen. Production uses
 * Screenshots for the /run-gemma-locally/ SEO landing page on kai9000.com.
 * Snapshots are copied to site/img/gemma-local-*.png by the updateScreenshots Gradle task.
 * `ModalBottomSheet`, which relies on runtime positioning and doesn't render in layoutlib.
 */
/**
@Composable
@OptIn(ExperimentalResourceApi::class)
@file:OptIn(ExperimentalVoiceApi::class)
class GemmaLocalScreenshotTest {
package com.inspiredandroid.kai.screenshots
private fun AddServiceSheetPreview(services: ImmutableList<Service>) {
private object GemmaLocalTestData {
private val MODEL_E2B = MODEL_CATALOG.first { it.id == "gemma-4-e2b-it" }
private val MODEL_E4B = MODEL_CATALOG.first { it.id == "gemma-4-e4b-it" }
private val MODEL_LFM25 = MODEL_CATALOG.first { it.id == "lfm2.5-1.2b-instruct" }
private val MODEL_QWEN3 = MODEL_CATALOG.first { it.id == "qwen3-0.6b" }
}
