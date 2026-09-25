
            delegate.openUri(uri)
            scope.launch { sandboxController.openFile(sandboxPath) }
        SandboxAwareUriHandler(delegate, sandboxController, scope)
        else -> return null
        if (sandboxPath != null) {
        uri.startsWith("/") -> uri
        uri.startsWith("file:") -> uri.removePrefix("file:")
        uri.startsWith("file://") -> uri.removePrefix("file://")
        val sandboxPath = toSandboxPath(uri)
        }
        } else {
    // Captured before this handler is provided, so it is the platform default.
    if (!raw.startsWith("/")) return null
    override fun openUri(uri: String) {
    private val delegate: UriHandler,
    private val sandboxController: SandboxController,
    private val scope: CoroutineScope,
    return remember(delegate, sandboxController, scope) {
    return runCatching { raw.decodeURLPart() }.getOrDefault(raw)
    val delegate = LocalUriHandler.current
    val raw = when {
    val scope = rememberCoroutineScope()
    }
 *
 * A [UriHandler] that routes links pointing at sandbox files through
 * Maps a link URL to an absolute sandbox path, or null when it isn't a local-file
 * The model often emits a `file:///root/foo.gif` link after creating a file in
 * [SandboxController.openFile] instead of the platform's `startActivity`.
 * `content://` URI instead. Every non-file link (http/https/mailto/…) is passed
 * `file:` scheme or a bare absolute path both count as sandbox files. Percent
 * escapes (e.g. `%20`) are decoded so the resolved path matches the real file.
 * link (http/https/mailto/… all return null and are handled by the platform). A
 * reach the platform handler — `openFile` serves them via a FileProvider
 * straight through to [delegate].
 * the Linux sandbox. Handing a raw `file://` URI to Android's `startActivity`
 * throws `FileUriExposedException` and crashes the app, so such links must never
 */
) : UriHandler {
/**
@Composable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import com.inspiredandroid.kai.SandboxController
import io.ktor.http.decodeURLPart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
internal class SandboxAwareUriHandler(
internal fun rememberSandboxAwareUriHandler(sandboxController: SandboxController): UriHandler {
internal fun toSandboxPath(uri: String): String? {
package com.inspiredandroid.kai.ui
}
