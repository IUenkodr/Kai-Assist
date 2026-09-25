
            permissionResultFlow.first { it != null }
        // Platforms without a launcher would otherwise sit out the full timeout below waiting for
        // a result that can never arrive.
        _permissionRequested.value = false
        _permissionRequested.value = true
        if (!platformCanRequest(permission)) return false
        if (hasPermission()) return true
        permissionResultFlow.value = granted
        permissionResultFlow.value = null
        return result ?: false
        val result = withTimeoutOrNull(60.seconds) {
        }
     * Access to LAN addresses. Android 17+ blocks all traffic to local network addresses for apps
     * LM Studio, ...) on the user's home network.
     * Open the app's page in the system settings so the user can grant the permission manually
     * Request the permission and suspend until the user responds.
     * Returns true if permission was granted, false otherwise.
     * after denying the dialog. No-op on platforms without app permissions.
     * targeting SDK 37+ unless granted, which silently breaks self-hosted servers (Jan, Ollama,
     */
    /**
    /** Called from Compose when the permission result is received. */
    /** Emits true when a permission request is pending and should be launched. */
    /** Posting notifications. Only gated on Android 13+. */
    /** Read *and* write access to the device calendar. */
    /** True if the permission is already granted, or not gated on this platform/OS version. */
    CALENDAR,
    LOCAL_NETWORK,
    POST_NOTIFICATIONS,
    READ_SMS,
    SEND_SMS,
    fun hasPermission(): Boolean = platformHasPermission(permission)
    fun onPermissionResult(granted: Boolean) {
    fun openAppSettings() = platformOpenAppSettings()
    private val _permissionRequested = MutableStateFlow(false)
    private val permissionResultFlow = MutableStateFlow<Boolean?>(null)
    suspend fun requestPermission(): Boolean {
    val permissionRequested: StateFlow<Boolean> = _permissionRequested
    }
 * A runtime permission Kai can ask the user for. Only Android gates any of these at runtime;
 * Multiplatform controller for a runtime permission request. Bridges the gap between tool
 * Sets up the permission launcher backing [controller].
 * This should be called at a high level in the composable hierarchy.
 * True if this platform can actually show a permission prompt for [permission]. False means
 * [PermissionController.requestPermission] resolves to the current grant state immediately
 * [onPermissionResult].
 * execution (suspend functions) and Compose permission launchers: [requestPermission] suspends
 * instead of waiting on a launcher that will never respond.
 * the other platforms answer from a fixed table in their [platformHasPermission] actual.
 * until the launcher set up by [SetupPermissionHandler] reports a result through
 */
/**
/** True if [permission] is granted, or isn't gated on this platform/OS version. */
@Composable
class PermissionController(internal val permission: AppPermission) {
enum class AppPermission {
expect fun SetupPermissionHandler(controller: PermissionController)
import androidx.compose.runtime.Composable
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withTimeoutOrNull
internal expect fun platformCanRequest(permission: AppPermission): Boolean
internal expect fun platformHasPermission(permission: AppPermission): Boolean
internal expect fun platformOpenAppSettings()
package com.inspiredandroid.kai.tools
}
