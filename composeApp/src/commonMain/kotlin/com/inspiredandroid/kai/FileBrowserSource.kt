import io.github.vinceglb.filekit.PlatformFile

        force: Boolean = false,
        maxBytes: Int = MAX_BROWSER_TEXT_BYTES,
        path: String,
     * Decoded content. [editable] is false when the bytes are not valid UTF-8 and were
     * Reads [path] as text. [force] decodes non-UTF-8 bytes lossily instead of
     * Streams a file picked from device storage into [directoryPath]. Returns the new
     * decoded lossily on request: the buffer contains replacement characters, so writing
     * guest path; the name is suffixed rather than overwriting an existing file.
     * it back would destroy the original bytes.
     * reporting [TextFileResult.Binary]; it does not lift [maxBytes].
     */
    ): TextFileResult
    /**
    /** Beyond the editor's cap; [sizeBytes] is the real size, for the message. */
    /** Directories first, then case-insensitive by name. Empty when [path] is not a readable directory. */
    /** Hands the file to another app on the device. */
    /** Missing, not a regular file, or the read failed. */
    /** Not valid UTF-8 text. A forced read still decodes it, read-only. */
    /** Renames within the same directory; returns the new path. Fails with `"collision"` if taken. */
    data class Text(val content: String, val editable: Boolean = true) : TextFileResult
    data class TooLarge(val sizeBytes: Long) : TextFileResult
    data object Binary : TextFileResult
    data object Unreadable : TextFileResult
    override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean = false
    override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = Result.failure(UnsupportedOperationException("File browsing is Android-only"))
    override suspend fun listDirectory(path: String): List<SandboxFileEntry> = emptyList()
    override suspend fun openFile(path: String): Result<Unit> = Result.failure(UnsupportedOperationException("File browsing is Android-only"))
    override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = TextFileResult.Unreadable
    override suspend fun renameEntry(path: String, newName: String): Result<String> = Result.failure(UnsupportedOperationException("File browsing is Android-only"))
    override suspend fun writeTextFile(path: String, content: String): Boolean = false
    suspend fun deleteEntry(path: String, recursive: Boolean): Boolean
    suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String>
    suspend fun listDirectory(path: String): List<SandboxFileEntry>
    suspend fun openFile(path: String): Result<Unit>
    suspend fun readTextFile(
    suspend fun renameEntry(path: String, newName: String): Result<String>
    suspend fun writeTextFile(path: String, content: String): Boolean
 *
 * "too big", "not text" and "gone" into one indistinguishable outcome, which is
 * A browsable file tree behind an absolute-path API. Both Linux environments
 * Paths are the ones the user sees in that environment (guest paths); the
 * Why a file could — or could not — be shown as text. A bare null would collapse
 * browser UI can be pointed at either without knowing whose files it shows.
 * expose one — the chat Alpine sandbox and Kai Build's Debian — so the file
 * implementation maps them to wherever the files actually live on the host.
 * what the browser used to report to the user.
 */
/**
/** Largest file the built-in editor will pull into memory. */
/** Used by platforms that have no Linux environment at all. */
const val MAX_BROWSER_TEXT_BYTES: Int = 512_000
interface FileBrowserSource {
object NoOpFileBrowserSource : FileBrowserSource {
package com.inspiredandroid.kai
sealed interface TextFileResult {
}
