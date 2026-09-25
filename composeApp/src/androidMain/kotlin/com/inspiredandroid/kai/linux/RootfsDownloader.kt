package com.inspiredandroid.kai.linux
import io.ktor.client.HttpClient
import io.ktor.client.request.prepareGet
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.contentLength
import io.ktor.http.isSuccess
import io.ktor.utils.io.readAvailable
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive

                        onProgress((downloadedBytes.toFloat() / totalBytes).coerceIn(0f, 1f))
                    currentCoroutineContext().ensureActive()
                    downloadedBytes += bytesRead
                    if (bytesRead <= 0) break
                    if (totalBytes > 0) {
                    output.write(buffer, 0, bytesRead)
                    val bytesRead = channel.readAvailable(buffer)
                    }
                downloadFrom(url, targetFile, onProgress)
                if (index < urls.lastIndex) onProgress(0f)
                lastError = e
                return
                targetFile.delete()
                throw IOException("HTTP ${response.status.value} from $url")
                throw e
                while (!channel.isClosedForRead) {
                }
            FileOutputStream(targetFile).use { output ->
            if (!response.status.isSuccess()) {
            onProgress(1f)
            try {
            val buffer = ByteArray(BUFFER_SIZE)
            val channel = response.bodyAsChannel()
            val totalBytes = response.contentLength() ?: -1L
            var downloadedBytes = 0L
            }
            } catch (e: CancellationException) {
            } catch (e: Exception) {
        for ((index, url) in urls.withIndex()) {
        httpClient.prepareGet(url).execute { response ->
        onProgress: (Float) -> Unit,
        require(urls.isNotEmpty()) { "No download URL for this rootfs" }
        targetFile.parentFile?.mkdirs()
        targetFile: File,
        throw IOException("All rootfs download mirrors failed", lastError)
        url: String,
        urls: List<String>,
        var lastError: Exception? = null
        }
     * Cancellable through the calling coroutine. A failed URL deletes its partial
     * file and resets progress so the UI does not show a bar walking backwards.
     */
    ) {
    /**
    private suspend fun downloadFrom(
    suspend fun download(
    }
 *
 * Alpine publishes the same minirootfs on several mirrors, so a mirror that is
 * Streams a rootfs tarball to disk, trying each candidate URL in turn.
 * down or rate-limiting costs a retry rather than the install. Debian resolves
 * to a single Linux Containers URL, which simply means a one-element list.
 */
/**
class RootfsDownloader(private val httpClient: HttpClient) {
private const val BUFFER_SIZE = 64 * 1024
}
