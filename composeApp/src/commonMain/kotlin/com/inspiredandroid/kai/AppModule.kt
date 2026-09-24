package com.inspiredandroid.kai

import com.inspiredandroid.kai.daemon.DaemonClient
import com.inspiredandroid.kai.daemon.DaemonViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf

val appModule = module {
    singleOf(::DaemonClient)
    factoryOf(::DaemonViewModel)
}
