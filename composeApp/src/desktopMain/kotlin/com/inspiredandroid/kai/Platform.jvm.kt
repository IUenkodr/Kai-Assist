import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragData
import androidx.compose.ui.draganddrop.dragData
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.EmailStore
import com.inspiredandroid.kai.data.EncryptedFileSettings
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.tools.CommonTools
import com.inspiredandroid.kai.tools.ProcessManagerTool
import com.inspiredandroid.kai.tools.ShellCommandTool
import com.inspiredandroid.kai.tools.buildAgentToolSet
import com.russhwolf.settings.Settings
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.dialogs.openFileSaver
import io.github.vinceglb.filekit.write
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIO
import java.io.File
import java.net.URI
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import org.koin.java.KoinJavaComponent.inject

                        override fun run() = tray.remove(trayIcon)
                    .start()
                    5_000,
                    object : java.util.TimerTask() {
                    return PlatformFile(file)
                    },
                )
                // 1×1 transparent placeholder — Windows auto-supplies a fallback icon for the toast.
                // AppleScript string literals: backslash and double-quote need escaping.
                // `--` terminator prevents a title or body starting with `-` from being parsed as a flag.
                ProcessBuilder("notify-send", "--", title, body).start()
                ProcessBuilder("osascript", "-e", "display notification \"$safeBody\" with title \"$safeTitle\"")
                if (!java.awt.SystemTray.isSupported()) return
                if (file.exists()) {
                java.util.Timer(true).schedule(
                tray.add(trayIcon)
                trayIcon.displayMessage(title, body, java.awt.TrayIcon.MessageType.INFO)
                trayIcon.isImageAutoSize = true
                val file = File(fileUri)
                val fileUri = URI(filePath)
                val image = java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB)
                val safeBody = body.replace("\\", "\\\\").replace("\"", "\\\"")
                val safeTitle = title.replace("\\", "\\\\").replace("\"", "\\\"")
                val tray = java.awt.SystemTray.getSystemTray()
                val trayIcon = java.awt.TrayIcon(image, "Kai")
                }
            // Still need to convert to RGB for JPEG encoding (original might have alpha)
            Platform.Desktop.Linux -> {
            Platform.Desktop.Mac -> {
            Platform.Desktop.Windows -> {
            add(ProcessManagerTool)
            add(ShellCommandTool)
            g2d.dispose()
            g2d.drawImage(image, 0, 0, newWidth, newHeight, null)
            g2d.drawImage(image, 0, 0, null)
            g2d.setRenderingHint(java.awt.RenderingHints.KEY_INTERPOLATION, java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR)
            resized
            rgb
            try {
            val g2d = resized.createGraphics()
            val g2d = rgb.createGraphics()
            val newHeight = (image.height * scale).toInt()
            val newWidth = (image.width * scale).toInt()
            val resized = java.awt.image.BufferedImage(newWidth, newHeight, java.awt.image.BufferedImage.TYPE_INT_RGB)
            val rgb = java.awt.image.BufferedImage(image.width, image.height, java.awt.image.BufferedImage.TYPE_INT_RGB)
            val scale = maxDim.toDouble() / maxOf(image.width, image.height)
            }
            } catch (_: Exception) {
        "mac" in osName || "darwin" in osName -> Platform.Desktop.Mac
        "win" in osName -> Platform.Desktop.Windows
        // manage_process rides the shell switch — it only inspects processes that tool started.
        // notify-send missing, AWT headless, sandboxed osascript, etc. — fall back silently.
        appSettings = appSettings,
        bytes
        else -> Platform.Desktop.Linux
        emailStore = emailStore,
        if (appSettings.isToolEnabled(ShellCommandTool.schema.name, defaultEnabled = false)) {
        if (filePath != null) {
        javax.imageio.ImageIO.write(scaled, "jpg", outputStream)
        kaiDir.mkdirs()
        mcpServerManager = mcpServerManager,
        memoryStore = memoryStore,
        outputStream.toByteArray()
        return null
        taskStore = taskStore,
        val dragData = event.dragData() as DragData.FilesList
        val filePath = dragData.readFiles().firstOrNull()
        val image = javax.imageio.ImageIO.read(inputStream) ?: return bytes
        val inputStream = java.io.ByteArrayInputStream(bytes)
        val maxDim = 1024
        val outputStream = java.io.ByteArrayOutputStream()
        val scaled = if (image.width > maxDim || image.height > maxDim) {
        when (currentPlatform as Platform.Desktop) {
        }
        } else {
    ) {
    // No system back gesture on desktop
    // On Wayland/X11 Java's HiDPI auto-detection often fails; fall back to GDK env vars
    // so HiDPI users get a reasonable default before they touch the slider.
    base * envFactor.coerceIn(0.5f, 4f)
    config(this)
    false
    file?.write(bytes)
    if (!kaiDir.exists()) {
    if (!mimeType.startsWith("image/")) return bytes
    if (currentPlatform !is Platform.Desktop.Linux) return@run base
    if (event.dragData() is DragData.FilesList) {
    java.awt.Desktop.getDesktop().browse(URI(url))
    null
    org.jetbrains.skia.Image.makeFromEncoded(bytes).toComposeImageBitmap()
    return buildAgentToolSet(
    return kaiDir.absolutePath
    return try {
    true
    try {
    val appSettings: AppSettings by inject(AppSettings::class.java)
    val base = if (currentPlatform is Platform.Desktop.Linux) 1.1f else 1.0f
    val emailStore: EmailStore by inject(EmailStore::class.java)
    val envFactor = (gdkScale ?: 1f) * (gdkDpiScale ?: 1f)
    val file = FileKit.openFileSaver(suggestedName = baseName, defaultExtension = extension)
    val gdkDpiScale = System.getenv("GDK_DPI_SCALE")?.toFloatOrNull()
    val gdkScale = System.getenv("GDK_SCALE")?.toFloatOrNull()
    val kaiDir = File("$userHome/.kai")
    val mcpServerManager: McpServerManager by inject(McpServerManager::class.java)
    val memoryStore: MemoryStore by inject(MemoryStore::class.java)
    val osName = System.getProperty("os.name", "").lowercase()
    val taskStore: TaskStore by inject(TaskStore::class.java)
    val userHome = System.getProperty("user.home")
    when {
    }
    } catch (_: Exception) {
    } else {
 *     toast, then removes it so we don't leave a persistent tray entry.
 *   - Linux: `notify-send` (libnotify) is the freedesktop standard and ships in most distros.
 *   - Windows: AWT [java.awt.SystemTray] briefly registers a tray icon to display a balloon
 *   - macOS: `osascript` invokes the user-facing Notification Center.
 * All paths swallow failures — if the OS hook is missing the in-app heartbeat banner still fires.
 * Posts a native OS notification. Each platform has its own surface:
 */
/**
@androidx.compose.runtime.Composable
@file:OptIn(ExperimentalComposeUiApi::class)
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
actual fun createLegacySettings(): Settings? = null // Same storage location, no migration needed
actual fun createSecureSettings(): Settings = EncryptedFileSettings()
actual fun decodeToImageBitmap(bytes: ByteArray): ImageBitmap? = try {
actual fun getAppFilesDirectory(): String {
actual fun getAvailableTools(): List<Tool> {
actual fun getBackgroundDispatcher(): CoroutineContext = Dispatchers.IO
actual fun getPlatformToolDefinitions(): List<ToolInfo> = listOf(ShellCommandTool.toolInfo, ProcessManagerTool.toolInfo) + CommonTools.commonToolDefinitions
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(CIO) {
actual fun onDragAndDropEventDropped(event: DragAndDropEvent): PlatformFile? {
actual fun openUrl(url: String): Boolean = try {
actual fun sendHeartbeatNotification(title: String, body: String) {
actual suspend fun compressImageBytes(bytes: ByteArray, mimeType: String): ByteArray {
actual suspend fun saveFileToDevice(bytes: ByteArray, baseName: String, extension: String) {
actual val BackIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack
actual val currentPlatform: Platform = run {
actual val defaultUiScale: Float = run {
actual val isEmailSupported: Boolean = true
actual val isNotificationsSupported: Boolean = false
actual val isSmsSupported: Boolean = false
actual val isSplinterlandsSupported: Boolean = true
package com.inspiredandroid.kai
}
} catch (_: Exception) {
