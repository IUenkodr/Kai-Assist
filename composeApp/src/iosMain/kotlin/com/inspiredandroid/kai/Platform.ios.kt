
                    .triggerWithTimeInterval(timeInterval = 0.1, repeats = false)
                    content = content,
                    identifier = platform.Foundation.NSUUID().UUIDString,
                    origin.x = 0.0
                    origin.y = 0.0
                    setBody(body)
                    setSound(platform.UserNotifications.UNNotificationSound.defaultSound())
                    setTitle(title)
                    size.height = newHeight
                    size.width = newWidth
                    trigger = trigger,
                )
                // iOS rejects nil triggers for non-scheduled notifications and 0 for time-interval
                // triggers, so use a tiny delay to fire effectively immediately.
                center.addNotificationRequest(request, null)
                height = newHeight
                kotlinx.cinterop.cValue<platform.CoreGraphics.CGRect> {
                val content = platform.UserNotifications.UNMutableNotificationContent().apply {
                val request = platform.UserNotifications.UNNotificationRequest.requestWithIdentifier(
                val trigger = platform.UserNotifications.UNTimeIntervalNotificationTrigger
                width = newWidth
                }
                },
            )
            NSData.dataWithBytes(pinned.addressOf(0), bytes.size.toULong())
            if (!granted) return@requestAuthorizationWithOptions
            image
            image.drawInRect(
            platform.UIKit.UIGraphicsBeginImageContextWithOptions(newSize, false, 1.0)
            platform.UIKit.UIGraphicsEndImageContext()
            platform.UserNotifications.UNAuthorizationOptionBadge
            platform.UserNotifications.UNAuthorizationOptionSound or
            resized ?: image
            try {
            val newHeight = imgHeight * scale
            val newSize = kotlinx.cinterop.cValue<platform.CoreGraphics.CGSize> {
            val newWidth = imgWidth * scale
            val resized = platform.UIKit.UIGraphicsGetImageFromCurrentImageContext()
            val scale = maxDim / maxOf(imgWidth, imgHeight)
            }
            } catch (_: Throwable) {
        bytes
        center.requestAuthorizationWithOptions(options) { granted, _ ->
        false
        jpegData.toByteArray()
        platform.Foundation.NSDocumentDirectory,
        platform.Foundation.NSUserDomainMask,
        platform.UIKit.UIApplication.sharedApplication.openURL(nsUrl)
        platform.posix.memcpy(pinned.addressOf(0), bytes, length)
        true,
        val center = platform.UserNotifications.UNUserNotificationCenter.currentNotificationCenter()
        val image = platform.UIKit.UIImage(data = nsData)
        val imgHeight = image.size.useContents { height }
        val imgWidth = image.size.useContents { width }
        val jpegData = platform.UIKit.UIImageJPEGRepresentation(scaled, 0.8) ?: return bytes
        val maxDim = 1024.0
        val nsData = bytes.usePinned { pinned ->
        val options = platform.UserNotifications.UNAuthorizationOptionAlert or
        val scaled = if (imgWidth > maxDim || imgHeight > maxDim) {
        }
        } else {
    )
    // The authorization completion runs asynchronously on a system queue, so it's outside the
    // iOS swipe-back is handled by the navigation controller
    // outer try/catch's scope and needs its own guard. Heartbeat delivery must never throw.
    appSettings = IosKoinHelper.appSettings,
    config(this)
    emailStore = IosKoinHelper.emailStore,
    false
    file?.write(bytes)
    if (!mimeType.startsWith("image/")) return bytes
    if (nsUrl != null) {
    if (size == 0) return ByteArray(0)
    mcpServerManager = IosKoinHelper.mcpServerManager,
    memoryStore = IosKoinHelper.memoryStore,
    null
    org.jetbrains.skia.Image.makeFromEncoded(bytes).toComposeImageBitmap()
    result.usePinned { pinned ->
    return paths.first() as String
    return result
    return try {
    taskStore = IosKoinHelper.taskStore,
    try {
    val appSettings: AppSettings by inject()
    val emailStore: EmailStore by inject()
    val file = FileKit.openFileSaver(suggestedName = baseName, defaultExtension = extension)
    val mcpServerManager: McpServerManager by inject()
    val memoryStore: MemoryStore by inject()
    val nsUrl = platform.Foundation.NSURL.URLWithString(url)
    val paths = platform.Foundation.NSSearchPathForDirectoriesInDomains(
    val result = ByteArray(size)
    val size = length.toInt()
    val taskStore: TaskStore by inject()
    }
    } catch (_: Exception) {
    } catch (_: Throwable) {
    } else {
)
@OptIn(ExperimentalSettingsImplementation::class)
@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class, kotlinx.cinterop.BetaInteropApi::class)
@Suppress("CAST_NEVER_SUCCEEDS")
@androidx.compose.runtime.Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
actual fun createLegacySettings(): Settings? = NSUserDefaultsSettings(platform.Foundation.NSUserDefaults.standardUserDefaults)
actual fun createSecureSettings(): Settings = KeychainSettings(service = "com.inspiredandroid.kai")
actual fun decodeToImageBitmap(bytes: ByteArray): ImageBitmap? = try {
actual fun getAppFilesDirectory(): String {
actual fun getAvailableTools(): List<Tool> = buildAgentToolSet(
actual fun getBackgroundDispatcher(): CoroutineContext = Dispatchers.IO
actual fun getPlatformToolDefinitions(): List<ToolInfo> = CommonTools.commonToolDefinitions
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(Darwin) {
actual fun onDragAndDropEventDropped(event: DragAndDropEvent): PlatformFile? = null
actual fun openUrl(url: String): Boolean = try {
actual fun sendHeartbeatNotification(title: String, body: String) {
actual suspend fun compressImageBytes(bytes: ByteArray, mimeType: String): ByteArray {
actual suspend fun saveFileToDevice(bytes: ByteArray, baseName: String, extension: String) {
actual val BackIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBackIos
actual val currentPlatform: Platform = Platform.Mobile.Ios
actual val defaultUiScale: Float = 1.0f
actual val isEmailSupported: Boolean = true
actual val isNotificationsSupported: Boolean = false
actual val isSmsSupported: Boolean = false
actual val isSplinterlandsSupported: Boolean = false
import androidx.compose.material.icons.Icons
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.EmailStore
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.tools.CommonTools
import com.inspiredandroid.kai.tools.buildAgentToolSet
import com.inspiredandroid.kai.ui.icons.ArrowBackIos
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.dialogs.openFileSaver
import io.github.vinceglb.filekit.write
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin
import kotlin.coroutines.CoroutineContext
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.useContents
import kotlinx.cinterop.usePinned
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import platform.Foundation.NSData
import platform.Foundation.dataWithBytes
package com.inspiredandroid.kai
private fun NSData.toByteArray(): ByteArray {
private object IosKoinHelper : KoinComponent {
}
} catch (_: Exception) {
