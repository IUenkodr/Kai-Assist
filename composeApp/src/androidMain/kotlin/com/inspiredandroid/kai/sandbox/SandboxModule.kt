package com.inspiredandroid.kai.sandbox
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

    single<LinuxSandboxManager> { LinuxSandboxManager(androidContext(), get(), get()) }
val sandboxModule = module {
}
