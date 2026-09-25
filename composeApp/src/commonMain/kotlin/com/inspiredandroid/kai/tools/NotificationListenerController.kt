
    /** Open the system notification-access settings screen. No-op on unsupported platforms. */
    /** True when the build supports the listener at all (Android FOSS only). */
    /** True when the user has enabled Kai under system notification-access settings. */
    fun isAccessGranted(): Boolean
    fun isSupported(): Boolean
    fun openAccessSettings()
 * **Settings → Apps → Special access → Notification access**, so this controller
 * Controller for notification-listener access. Unlike [PermissionController],
 * `BIND_NOTIFICATION_LISTENER_SERVICE` is not a runtime permission — there is no
 * `requestPermission` dialog. The user must enable the listener manually under
 * just checks the granted state and offers a deep-link into that screen.
 */
/**
expect class NotificationListenerController() {
package com.inspiredandroid.kai.tools
}
