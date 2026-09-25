
                taskScheduler.appInForeground = false
                taskScheduler.appInForeground = true
            androidContext(this@KaiApplication)
            modules(appModule, sandboxModule)
            override fun onStart(owner: LifecycleOwner) {
            override fun onStop(owner: LifecycleOwner) {
            }
        // Track app foreground state so the scheduler only pushes a heartbeat notification
        // it survives backgrounding and only clears on Activity destruction.
        // when the in-app banner isn't visible. ViewModel lifecycle is the wrong signal —
        ProcessLifecycleOwner.get().lifecycle.addObserver(object : DefaultLifecycleObserver {
        startKoin {
        super.onCreate()
        }
        })
    override fun onCreate() {
    private val taskScheduler: TaskScheduler by inject()
    }
class KaiApplication : Application() {
import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.sandbox.sandboxModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
package com.inspiredandroid.kai
}
