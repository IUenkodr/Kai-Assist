import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import com.inspiredandroid.kai.notifications.declaresNotificationListener
import org.koin.java.KoinJavaComponent.inject

                    ComponentName(context, NOTIFICATION_LISTENER_FQN).flattenToString(),
                    Settings.EXTRA_NOTIFICATION_LISTENER_COMPONENT_NAME,
                )
                ComponentName(context, NOTIFICATION_LISTENER_FQN),
                context.startActivity(intent)
                continue
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(
                return
            )
            ?: return false
            Intent(Settings.ACTION_NOTIFICATION_LISTENER_DETAIL_SETTINGS).apply {
            Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS),
            false
            nm.isNotificationListenerAccessGranted(
            try {
            }
            } catch (_: Exception) {
            },
        )
        // Fall back to the global listener-settings list if that intent isn't resolvable.
        // Try the per-component variant on API 30+ first — drops the user directly on Kai's row.
        // isNotificationListenerAccessGranted(ComponentName) is API 27+; minSdk is 26.
        for (intent in intents) {
        if (!supported) return
        if (!supported) return false
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O_MR1) return false
        return try {
        val intents = listOf(
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        }
        } catch (_: Throwable) {
    "com.inspiredandroid.kai.notifications.KaiNotificationListenerService"
    actual fun isAccessGranted(): Boolean {
    actual fun isSupported(): Boolean = supported
    actual fun openAccessSettings() {
    private val context: Context by inject(Context::class.java)
    private val supported: Boolean by lazy { context.declaresNotificationListener() }
    }
actual class NotificationListenerController actual constructor() {
package com.inspiredandroid.kai.tools
private const val NOTIFICATION_LISTENER_FQN =
}
