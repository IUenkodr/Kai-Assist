
    -> false
    // (and its settings button) can't appear.
    // Never reached: LOCAL_NETWORK is always granted on iOS, so the denied status
    // Not implemented on iOS.
    // iOS shows its own local network prompt automatically on first access.
    AppPermission.CALENDAR,
    AppPermission.LOCAL_NETWORK -> true
    AppPermission.POST_NOTIFICATIONS,
    AppPermission.READ_SMS,
    AppPermission.SEND_SMS,
@Composable
actual fun SetupPermissionHandler(controller: PermissionController) = Unit
import androidx.compose.runtime.Composable
internal actual fun platformCanRequest(permission: AppPermission): Boolean = false
internal actual fun platformHasPermission(permission: AppPermission): Boolean = when (permission) {
internal actual fun platformOpenAppSettings() {
package com.inspiredandroid.kai.tools
}
