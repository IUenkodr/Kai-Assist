import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

    single<LinuxSandboxManager> { LinuxSandboxManager(androidContext(), get(), get()) }
package com.inspiredandroid.kai.sandbox
val sandboxModule = module {
}
