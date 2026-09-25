
                    currentCoroutineContext().ensureActive()
                    if (read == -1L) break
                    sink.write(buffer, read)
                    val read = raw.readAtMostTo(buffer, COPY_BUFFER_BYTES)
                sink.flush()
                val buffer = Buffer()
                while (true) {
                }
            source.source().use { raw ->
            val sink = out.asSink().buffered()
            }
        .decode(ByteBuffer.wrap(bytes))
        .let { if (it.isBlank() || it == "." || it == "..") "imported" else it }
        .onMalformedInput(CodingErrorAction.REPORT)
        .onUnmappableCharacter(CodingErrorAction.REPORT)
        .requestedPermissions?.contains(Manifest.permission.REQUEST_INSTALL_PACKAGES) == true
        .toString()
        FileOpenResult(false, mime, error = "No app available to open $mime files")
        FileOpenResult(false, mime, error = e.message ?: "Failed to open file")
        FileOpenResult(true, mime, contentUri = uri.toString())
        FileProvider.getUriForFile(context, authority, file)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
        candidate = File(dir, if (ext.isEmpty()) "$base-$index" else "$base-$index.$ext")
        context.startActivity(intent)
        dest.outputStream().use { out ->
        file.readBytes()
        index++
        return FileOpenResult(false, mime, error = "FileProvider can't expose this path: ${e.message}")
        return FileOpenResult(false, mime, error = "This build cannot install apps")
        return TextFileResult.Unreadable
        setDataAndType(uri, mime)
        }
    "apk" to "application/vnd.android.package-archive",
    "bz2" to "application/x-bzip2",
    "ts" to "text/plain",
    "zst" to "application/zstd",
    // A NUL byte is legal UTF-8 but effectively never appears in real text, so it is the
    // Android's map covers media, documents and archives but almost no source or config
    // Forced: decode lossily so the user can at least look at it. Not editable — the
    // cheapest binary tell available before attempting a decode.
    // extension. text/plain at least offers a viewer where `*/*` offers nothing.
    // replacement characters would overwrite the original bytes on save.
    Charsets.UTF_8.newDecoder()
    android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext)?.let { return it }
    false
    if (!candidate.exists()) return candidate
    if (!dir.isDirectory) throw IOException("Not a directory: $dir")
    if (!file.isFile) return TextFileResult.Unreadable
    if (!force) return TextFileResult.Binary
    if (length > maxBytes) return TextFileResult.TooLarge(length)
    if (mime == APK_MIME && !context.declaresRequestInstallPackages()) {
    if (parts.any { it == ".." }) return null
    if (rel.isBlank() || rel.startsWith("/") || rel.startsWith("\\")) return null
    if (strict != null) return TextFileResult.Text(strict, editable = true)
    isDirectory = isDirectory,
    lastModifiedMs = lastModified(),
    mimeOverrides[ext]?.let { return it }
    name = name,
    null
    packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
    path = if (parent.isEmpty()) "/$name" else "$parent/$name",
    return TextFileResult.Text(bytes.toString(Charsets.UTF_8), editable = false)
    return candidate
    return dest
    return if (classifyFile(mimeType = null, fileName = filename) == FileCategory.TEXT) "text/plain" else "*/*"
    return safeChild(File(homeRoot), parts)
    return try {
    sizeBytes = if (isFile) length() else 0,
    source.withScopedAccess {
    val authority = "${context.packageName}.fileprovider"
    val base = safe.substringBeforeLast('.', safe)
    val bytes = try {
    val contentUri: String? = null,
    val dest = nonCollidingChild(dir, source.name)
    val error: String? = null,
    val ext = filename.substringAfterLast('.', "").lowercase()
    val ext = safe.substringAfterLast('.', "")
    val intent = Intent(Intent.ACTION_VIEW).apply {
    val length = file.length()
    val mime = guessMimeType(file.name)
    val mimeType: String,
    val parts = rel.split("/", "\\").filter { it.isNotEmpty() }
    val safe = rawName.substringAfterLast('/').substringAfterLast('\\')
    val strict = if (bytes.any { it == 0.toByte() }) null else decodeUtf8Strict(bytes)
    val success: Boolean,
    val uri = try {
    var candidate = File(dir, safe)
    var index = 1
    while (candidate.exists()) {
    }
    } catch (e: ActivityNotFoundException) {
    } catch (e: Exception) {
    } catch (e: IOException) {
    } catch (e: IllegalArgumentException) {
 * Shared by both Linux environments' browsers. Separates "too big" from "not text"
 * Streams [source] into [dir] under a name that does not already exist, and returns the
 * buffer that would not survive a round trip to disk.
 * file cannot OOM the process.
 * file created. Streamed rather than read into a ByteArray so importing a multi-gigabyte
 * from "unreadable" so the UI can say which, and refuses to hand back an editable
 */
)
/**
/** Null when [bytes] is not valid UTF-8, rather than silently substituting U+FFFD. */
/** One row of a directory listing, with the guest path built from [parent]. */
/** Strips any path from [rawName] and suffixes `-1`, `-2`, … until the name is free. */
// Extensions Android's own map either has no entry for, or resolves to something that is
// REQUEST_INSTALL_PACKAGES is declared by the `foss` flavor only — Play policy restricts
// and the package installer never appears in the chooser.
// it. Without it the installer opens and then refuses, so report that up front instead.
// transport stream. Without `apk` in particular the intent goes out as a wildcard type
// wrong for a Linux sandbox — `.ts` is TypeScript here far more often than an MPEG
import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.FileProvider
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.TextFileResult
import com.inspiredandroid.kai.data.FileCategory
import com.inspiredandroid.kai.data.classifyFile
import com.inspiredandroid.kai.linux.safeChild
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.name
import io.github.vinceglb.filekit.source
import io.github.vinceglb.filekit.withScopedAccess
import java.io.File
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.charset.CharacterCodingException
import java.nio.charset.CodingErrorAction
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.io.Buffer
import kotlinx.io.asSink
import kotlinx.io.buffered
internal data class FileOpenResult(
internal fun File.toFileEntry(parent: String): SandboxFileEntry = SandboxFileEntry(
internal fun guessMimeType(filename: String): String {
internal fun nonCollidingChild(dir: File, rawName: String): File {
internal fun openFileWithIntent(context: Context, file: File): FileOpenResult {
internal fun readFileAsText(file: File, maxBytes: Int, force: Boolean): TextFileResult {
internal fun resolveSandboxFile(homeRoot: String, rel: String): File? {
internal suspend fun importFileInto(dir: File, source: PlatformFile): File {
package com.inspiredandroid.kai.sandbox
private const val APK_MIME = "application/vnd.android.package-archive"
private const val COPY_BUFFER_BYTES = 64L * 1024
private fun Context.declaresRequestInstallPackages(): Boolean = try {
private fun decodeUtf8Strict(bytes: ByteArray): String? = try {
private val mimeOverrides = mapOf(
}
} catch (_: Exception) {
} catch (e: CharacterCodingException) {
