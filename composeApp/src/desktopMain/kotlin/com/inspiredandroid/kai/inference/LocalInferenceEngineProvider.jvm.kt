import java.io.File

                .any { it.split(Regex("\\s+")).contains("avx2") }
                .filter { it.startsWith("flags", ignoreCase = true) }
            lines
        File("/proc/cpuinfo").useLines { lines ->
        }
    if (!os.contains("linux")) return true
    if (arch != "x86_64" && arch != "amd64") return true
    return runCatching {
    val arch = System.getProperty("os.arch")?.lowercase().orEmpty()
    val os = System.getProperty("os.name")?.lowercase().orEmpty()
    }.getOrElse { true }
 * LiteRT's native binary is compiled with AVX2+ instructions and SIGILLs the JVM on
 * can surface. Gate engine creation on a CPU feature probe so unsupported machines
 * pre-AVX2 x86_64 hardware (e.g. Ivy Bridge / 3rd-gen Core) before any JNI exception
 * silently hide the on-device service instead of crashing on model load. See #188.
 */
/**
actual fun createLocalInferenceEngine(): LocalInferenceEngine? = if (isLiteRtSupported()) LiteRTInferenceEngine() else null
package com.inspiredandroid.kai.inference
private fun isLiteRtSupported(): Boolean {
}
