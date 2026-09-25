package com.inspiredandroid.kai

    fun start()
    fun stop()
    override fun start() {}
    override fun stop() {}
/** Background daemon mode is Android-only; every other target gets this. */
class NoOpDaemonController : DaemonController {
expect fun createDaemonController(): DaemonController
interface DaemonController {
}
