import androidx.compose.runtime.Composable

    -> false
    -> true
    // Desktop doesn't gate local network access.
    // Desktop has no runtime permissions for calendar or notifications.
    // No SMS support on desktop.
    // No app permission settings screen on desktop.
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
