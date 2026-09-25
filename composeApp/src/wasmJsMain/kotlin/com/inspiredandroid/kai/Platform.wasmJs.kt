import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.tools.CommonTools
import com.inspiredandroid.kai.tools.buildAgentToolSet
import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.download
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.js.Js
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

    // No system back gesture on web
    // Web has no secure storage - using localStorage
    // Web uses localStorage, return empty string as no file path is needed
    FileKit.download(bytes = bytes, fileName = "$baseName.$extension")
    appSettings = WebKoinHelper.appSettings,
    config(this)
    false
    kotlinx.browser.window.open(url, "_blank")
    mcpServerManager = WebKoinHelper.mcpServerManager,
    memoryStore = WebKoinHelper.memoryStore,
    null
    org.jetbrains.skia.Image.makeFromEncoded(bytes).toComposeImageBitmap()
    return ""
    return StorageSettings()
    taskStore = WebKoinHelper.taskStore,
    true
    val appSettings: AppSettings by inject()
    val mcpServerManager: McpServerManager by inject()
    val memoryStore: MemoryStore by inject()
    val taskStore: TaskStore by inject()
)
// Web notifications API isn't wired up; stub.
@androidx.compose.runtime.Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
actual fun createLegacySettings(): Settings? = null // Same storage location, no migration needed
actual fun createSecureSettings(): Settings {
actual fun decodeToImageBitmap(bytes: ByteArray): ImageBitmap? = try {
actual fun getAppFilesDirectory(): String {
actual fun getAvailableTools(): List<Tool> = buildAgentToolSet(
actual fun getBackgroundDispatcher(): CoroutineContext = EmptyCoroutineContext
actual fun getPlatformToolDefinitions(): List<ToolInfo> = CommonTools.commonToolDefinitions
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(Js) {
actual fun onDragAndDropEventDropped(event: DragAndDropEvent): PlatformFile? = null
actual fun openUrl(url: String): Boolean = try {
actual fun sendHeartbeatNotification(title: String, body: String) = Unit
actual suspend fun compressImageBytes(bytes: ByteArray, mimeType: String): ByteArray = bytes
actual suspend fun saveFileToDevice(bytes: ByteArray, baseName: String, extension: String) {
actual val BackIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack
actual val currentPlatform: Platform = Platform.Web
actual val defaultUiScale: Float = 1.0f
actual val isEmailSupported: Boolean = false
actual val isNotificationsSupported: Boolean = false
actual val isSmsSupported: Boolean = false
actual val isSplinterlandsSupported: Boolean = false
package com.inspiredandroid.kai
private object WebKoinHelper : KoinComponent {
}
} catch (_: Exception) {
