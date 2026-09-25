import android.content.Context
import android.content.pm.ApplicationInfo
import org.koin.java.KoinJavaComponent.inject

    (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
    val context: Context by inject(Context::class.java)
actual val isDebugBuild: Boolean by lazy {
package com.inspiredandroid.kai
}
