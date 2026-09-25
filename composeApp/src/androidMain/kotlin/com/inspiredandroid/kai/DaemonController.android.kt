package com.inspiredandroid.kai

import android.app.ForegroundServiceStartNotAllowedException
import android.content.Context
import android.content.Intent
import com.inspiredandroid.kai.data.AppSettings
import org.koin.java.KoinJavaComponent.inject

/** Android implementation of the DaemonController. */
private class AndroidDaemonController : DaemonController {
    private val context: Context by inject(Context::class.java)
    private val appSettings: AppSettings by inject(AppSettings::class.java)
    private val daemonIntent = Intent(context, DaemonService::class.java)

    override fun start() {
        try {
            context.startForegroundService(daemonIntent)
        } catch (_: ForegroundServiceStartNotAllowedException) {
            // Android 12+ fallback when starting a foreground service is not allowed
            context.startService(daemonIntent)
        }
    }

    override fun stop() {
        context.stopService(Intent(context, DaemonService::class.java))
    }

    /** Returns true when the user enabled the daemon in the settings UI. */
    fun shouldAutoStart(): Boolean = appSettings.isDaemonEnabled()
}

/** Platform‑specific factory used by the common code. */
actual fun createDaemonController(): DaemonController = AndroidDaemonController()
