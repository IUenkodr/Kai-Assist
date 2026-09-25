package com.inspiredandroid.kai
import com.inspiredandroid.kai.daemon.DaemonClient
import com.inspiredandroid.kai.daemon.DaemonViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

    factoryOf(::DaemonViewModel)
    singleOf(::DaemonClient)
val appModule = module {
}
