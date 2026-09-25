package com.inspiredandroid.kai
import android.app.ForegroundServiceStartNotAllowedException
import android.content.Context
import android.content.Intent
import com.inspiredandroid.kai.data.AppSettings
import org.koin.java.KoinJavaComponent.inject

            // App is not in a foreground state — cannot start foreground service (Android 12+)
            context.startForegroundService(intent)
            val intent = Intent(context, DaemonService::class.java)
        context.stopService(intent)
        try {
        val intent = Intent(context, DaemonService::class.java)
        }
        } catch (_: ForegroundServiceStartNotAllowedException) {
    fun shouldAutoStart(): Boolean = appSettings.isDaemonEnabled()
    override fun start() {
    override fun stop() {
    private val appSettings: AppSettings by inject(AppSettings::class.java)
    private val context: Context by inject(Context::class.java)
    }
actual fun createDaemonController(): DaemonController = AndroidDaemonController()
class AndroidDaemonController : DaemonController {
}
