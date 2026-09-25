package com.inspiredandroid.kai
import android.content.Context
import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.graphics.scale
import androidx.core.net.toUri
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.EmailStore
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.data.NotificationStore
import com.inspiredandroid.kai.data.SmsDraftStore
import com.inspiredandroid.kai.data.SmsStore
import com.inspiredandroid.kai.data.TaskStore
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.notifications.NotificationReader
import com.inspiredandroid.kai.notifications.declaresNotificationListener
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import com.inspiredandroid.kai.sandbox.SandboxState
import com.inspiredandroid.kai.sms.SmsReader
import com.inspiredandroid.kai.sms.SmsSender
import com.inspiredandroid.kai.sms.declaresReadSms
import com.inspiredandroid.kai.tools.AppPermission
import com.inspiredandroid.kai.tools.CalendarRepository
import com.inspiredandroid.kai.tools.CommonTools
import com.inspiredandroid.kai.tools.CreateCalendarEventTool
import com.inspiredandroid.kai.tools.NotificationHelper
import com.inspiredandroid.kai.tools.NotificationTools
import com.inspiredandroid.kai.tools.OpenFileTool
import com.inspiredandroid.kai.tools.PermissionController
import com.inspiredandroid.kai.tools.ProcessManagerTool
import com.inspiredandroid.kai.tools.SendNotificationTool
import com.inspiredandroid.kai.tools.SetAlarmTool
import com.inspiredandroid.kai.tools.ShellCommandTool
import com.inspiredandroid.kai.tools.SmsTools
import com.inspiredandroid.kai.tools.SshConfigureHostTool
import com.inspiredandroid.kai.tools.buildAgentToolSet
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import dev.spght.encryptedprefs.EncryptedSharedPreferences
import dev.spght.encryptedprefs.MasterKey
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.dialogs.openFileSaver
import io.github.vinceglb.filekit.write
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

                KoinJavaComponent.get(PermissionController::class.java, permissionQualifier(AppPermission.CALENDAR))
                KoinJavaComponent.get(PermissionController::class.java, permissionQualifier(AppPermission.POST_NOTIFICATIONS))
                add(ProcessManagerTool)
                add(ShellCommandTool)
                add(SshConfigureHostTool)
                addAll(NotificationTools.getNotificationTools(notificationStore, notificationReader))
                addAll(SmsTools.getSmsSendTools(smsDraftStore, smsReaderForTools, smsSender))
                val notificationStore: NotificationStore by inject(NotificationStore::class.java)
                val smsDraftStore: SmsDraftStore by inject(SmsDraftStore::class.java)
            "${context.packageName}.fileprovider",
            .getMimeTypeFromExtension(file.extension) ?: "*/*"
            add(CreateCalendarEventTool.create(CalendarRepository(context, calendarPermissionController)))
            add(OpenFileTool)
            add(SendNotificationTool.create(NotificationHelper(context, notificationPermissionController)))
            add(SetAlarmTool.create(context))
            addAll(SmsTools.getSmsReadTools(smsStore, smsReaderForTools))
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            bitmap
            bitmap.scale(newWidth, newHeight)
            context,
            file,
            if (notificationReader.hasAccess()) {
            if (sandboxManager.state.value is SandboxState.Ready) {
            if (smsSender.hasPermission()) {
            null
            setDataAndType(contentUri, mimeType)
            smsReader
            val calendarPermissionController: PermissionController =
            val newHeight = (bitmap.height * scale).toInt()
            val newWidth = (bitmap.width * scale).toInt()
            val notificationPermissionController: PermissionController =
            val notificationReader: NotificationReader by inject(NotificationReader::class.java)
            val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
            val scale = maxDim.toFloat() / maxOf(bitmap.width, bitmap.height)
            val smsReader: SmsReader by inject(SmsReader::class.java)
            val smsSender: SmsSender by inject(SmsSender::class.java)
            val smsStore: SmsStore by inject(SmsStore::class.java)
            }
        "kai_secure_prefs",
        )
        .build()
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        // (READ_SMS declared in merged manifest). `isSmsEnabled()` is the user toggle.
        // (listener service declared in merged manifest). `isNotificationsEnabled()`
        // AEADBadTagException occurs when Android Auto Backup restores the encrypted
        // Delete the corrupted file and recreate fresh encrypted prefs.
        // Notification tools: triple-gated. `isNotificationsSupported` is FOSS-only
        // SMS read tools: triple-gated. `isSmsSupported` is only true on FOSS builds
        // SMS send tools: independently gated on the Send toggle + SEND_SMS permission.
        // These only *stage* drafts — actual sending is user-triggered via the review banner.
        // `hasPermission()` catches runtime revocation.
        // is the user toggle. `hasAccess()` catches system-level revocation.
        // prefs file but the Keystore key is hardware-bound and doesn't transfer.
        CreateCalendarEventTool.toolInfo,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        Intent(Intent.ACTION_VIEW, contentUri).apply {
        Intent(Intent.ACTION_VIEW, parsedUri).apply {
        OpenFileTool.toolInfo,
        ProcessManagerTool.toolInfo,
        SendNotificationTool.toolInfo,
        SetAlarmTool.toolInfo,
        SharedPreferencesSettings(createEncryptedPrefs(context))
        ShellCommandTool.toolInfo,
        SshConfigureHostTool.toolInfo,
        appSettings = appSettings,
        bitmap.recycle()
        bytes
        context,
        context.declaresNotificationListener()
        context.declaresReadSms()
        context.deleteSharedPreferences("kai_secure_prefs")
        emailStore = emailStore,
        false
        if (appSettings.isSandboxEnabled()) {
        if (appSettings.isToolEnabled(CreateCalendarEventTool.ID)) {
        if (appSettings.isToolEnabled(OpenFileTool.schema.name)) {
        if (appSettings.isToolEnabled(SendNotificationTool.ID)) {
        if (appSettings.isToolEnabled(SetAlarmTool.ID)) {
        if (isNotificationsSupported && appSettings.isNotificationsEnabled()) {
        if (scaled !== bitmap) scaled.recycle()
        if (smsReaderForTools != null && appSettings.isSmsEnabled() && smsReaderForTools.hasPermission()) {
        if (smsReaderForTools != null && appSettings.isSmsSendEnabled()) {
        masterKey,
        mcpServerManager = mcpServerManager,
        memoryStore = memoryStore,
        outputStream.toByteArray()
        scaled.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, outputStream)
        taskStore = taskStore,
        val bitmap = android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size) ?: return bytes
        val contentUri = androidx.core.content.FileProvider.getUriForFile(
        val context: Context by inject(Context::class.java)
        val file = java.io.File(parsedUri.path!!)
        val maxDim = 1024
        val mimeType = android.webkit.MimeTypeMap.getSingleton()
        val outputStream = java.io.ByteArrayOutputStream()
        val scaled = if (bitmap.width > maxDim || bitmap.height > maxDim) {
        val smsReaderForTools: SmsReader? = if (isSmsSupported) {
        }
        } else {
    )
    ) {
    android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)?.asImageBitmap()
    androidx.activity.compose.BackHandler(enabled = enabled, onBack = onBack)
    config(this)
    context.startActivity(intent)
    false
    file?.write(bytes)
    if (!mimeType.startsWith("image/")) return bytes
    listOf(
    null
    return EncryptedSharedPreferences.create(
    return SharedPreferencesSettings(prefs)
    return buildAgentToolSet(
    return context.filesDir.absolutePath
    return try {
    true
    try {
    val appSettings: AppSettings by inject(AppSettings::class.java)
    val context: Context by inject(Context::class.java)
    val emailStore: EmailStore by inject(EmailStore::class.java)
    val file = FileKit.openFileSaver(suggestedName = baseName, defaultExtension = extension)
    val intent = if (parsedUri.scheme == "file") {
    val masterKey = MasterKey.Builder(context)
    val mcpServerManager: McpServerManager by inject(McpServerManager::class.java)
    val memoryStore: MemoryStore by inject(MemoryStore::class.java)
    val parsedUri = url.toUri()
    val prefs = context.getSharedPreferences("com.inspiredandroid.kai_preferences", Context.MODE_PRIVATE)
    val taskStore: TaskStore by inject(TaskStore::class.java)
    }
    } catch (_: Exception) {
    } catch (_: Throwable) {
    } else {
// Evaluated lazily because we need the Koin-injected Context. Whether READ_SMS
// Same lazy pattern as `isSmsSupported`: probe the merged manifest for the listener
// Tool definitions for Android platform. Every tool Android can execute is listed, including the
// Uses dev.spght:encryptedprefs-ktx — a maintained community fork of the deprecated
// androidx.security:security-crypto. We keep application-level encryption because
// call `getPlatformToolDefinitions()` before Koin has been started.
// is declared in the merged manifest is a build-time property (foss flavor adds
// is what keeps them out of the Tools tab.
// it, playStore does not), so caching the first result is safe for the process
// lifetime. The try/catch guards screenshot / unit-test environments that may
// ones no per-tool switch controls — chat resolves display names from here, and an omission shows
// secure settings store API keys, email passwords, and conversation encryption keys.
// service. Foss flavor declares it, playStore does not.
// the raw tool id instead. Tools driven by a master toggle carry `userToggleable = false`, which
@androidx.compose.runtime.Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
actual fun createLegacySettings(): Settings? {
actual fun createSecureSettings(): Settings {
actual fun decodeToImageBitmap(bytes: ByteArray): ImageBitmap? = try {
actual fun getAppFilesDirectory(): String {
actual fun getAvailableTools(): List<Tool> {
actual fun getBackgroundDispatcher(): CoroutineContext = Dispatchers.IO
actual fun getPlatformToolDefinitions(): List<ToolInfo> = CommonTools.commonToolDefinitions +
actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(OkHttp) {
actual fun onDragAndDropEventDropped(event: DragAndDropEvent): PlatformFile? = null
actual fun openUrl(url: String): Boolean = try {
actual suspend fun compressImageBytes(bytes: ByteArray, mimeType: String): ByteArray {
actual suspend fun saveFileToDevice(bytes: ByteArray, baseName: String, extension: String) {
actual val BackIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack
actual val currentPlatform: Platform = Platform.Mobile.Android
actual val defaultUiScale: Float = 1.0f
actual val isEmailSupported: Boolean = true
actual val isNotificationsSupported: Boolean by lazy {
actual val isSmsSupported: Boolean by lazy {
actual val isSplinterlandsSupported: Boolean = true
private fun createEncryptedPrefs(context: Context): android.content.SharedPreferences {
}
} catch (_: Exception) {
