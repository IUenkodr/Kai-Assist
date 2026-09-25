import androidx.compose.runtime.Composable

    -> false
    // No app permission settings screen on web.
    // Not implemented on web.
    // The browser doesn't gate local network access as an app permission.
    AppPermission.CALENDAR,
    AppPermission.LOCAL_NETWORK -> true
    AppPermission.POST_NOTIFICATIONS,
    AppPermission.READ_SMS,
    AppPermission.SEND_SMS,
@Composable
actual fun SetupPermissionHandler(controller: PermissionController) = Unit
internal actual fun platformCanRequest(permission: AppPermission): Boolean = false
internal actual fun platformHasPermission(permission: AppPermission): Boolean = when (permission) {
internal actual fun platformOpenAppSettings() {
package com.inspiredandroid.kai.tools
}
