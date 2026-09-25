package com.inspiredandroid.kai

/** Interface for controlling the background daemon. */
interface DaemonController {
    fun start()
    fun stop()
}

/** No‑op implementation used on platforms where a daemon is not applicable. */
class NoOpDaemonController : DaemonController {
    override fun start() {}
    override fun stop() {}
}

/** Platform‑specific factory – the actual implementation is provided by each target. */
expect fun createDaemonController(): DaemonController
