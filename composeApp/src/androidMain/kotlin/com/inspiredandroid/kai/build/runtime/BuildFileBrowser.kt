
                    .thenBy { it.name.lowercase() },
                compareByDescending<SandboxFileEntry> { it.isDirectory }
                if (empty) file.delete() else false
                val empty = file.list()?.isEmpty() != false
            )
            .map { it.toFileEntry(parent = if (parent == "/") "" else parent) }
            .sortedWith(
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid destination"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path: $directoryPath"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path: $path"))
            Result.failure(IllegalStateException("rename failed"))
            Result.failure(IllegalStateException(result.error ?: "Open failed"))
            Result.failure(e)
            Result.success(Unit)
            Result.success(if (parent.isEmpty()) "/${created.name}" else "$parent/${created.name}")
            Result.success(newPath)
            else -> file.delete()
            false
            file.isDirectory && !recursive -> {
            file.isDirectory -> file.deleteRecursively()
            file.parentFile?.mkdirs()
            file.writeBytes(content.toByteArray(Charsets.UTF_8))
            newName == "." || newName == ".."
            return@withContext Result.failure(IllegalArgumentException("Invalid name"))
            throw e
            true
            val created = importFileInto(dir, source)
            val parent = directoryPath.trimEnd('/')
            }
        ) {
        // The browser's rename dialog shows a dedicated message for this exact text.
        dir.listFiles().orEmpty()
        homeDir = File(paths.rootfsDir, "root"),
        if (!dir.isDirectory) return@withContext emptyList()
        if (!file.exists() || isRoot(file)) return@withContext false
        if (!file.isFile) return@withContext Result.failure(IllegalArgumentException("Not a file: $path"))
        if (!source.exists()) return@withContext Result.failure(IllegalArgumentException("Not found"))
        if (destination.exists()) return@withContext Result.failure(IllegalStateException("collision"))
        if (file.exists() && !file.isFile) return@withContext false
        if (isRoot(source)) return@withContext Result.failure(IllegalArgumentException("Cannot rename this folder"))
        if (newName.isBlank() || newName.contains('/') || newName.contains('\\') ||
        if (result.success) {
        if (source.renameTo(destination)) {
        projectsDir = paths.projectsDir,
        readFileAsText(file, maxBytes, force)
        rootfsDir = paths.rootfsDir,
        tmpDir = paths.tmpDir,
        try {
        val destination = resolve(newPath)
        val dir = resolve(directoryPath)
        val dir = resolve(path) ?: return@withContext emptyList()
        val file = resolve(path)
        val file = resolve(path) ?: return@withContext TextFileResult.Unreadable
        val file = resolve(path) ?: return@withContext false
        val newPath = if (parent.isEmpty()) "/$newName" else "$parent/$newName"
        val parent = if (path.endsWith("/")) path.dropLast(1) else path
        val parent = path.substringBeforeLast('/', "")
        val result = openFileWithIntent(context, file)
        val source = resolve(path)
        when {
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } catch (e: IOException) {
        } else {
     * Guest path to host file, following the same binds proot is started with:
     * `/root/projects` and `/tmp` are bind-mounted, everything else — including
     * `/root` itself — is the rootfs.
     */
    )
    /**
    override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean = withContext(Dispatchers.IO) {
    override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = withContext(Dispatchers.IO) {
    override suspend fun listDirectory(path: String): List<SandboxFileEntry> = withContext(Dispatchers.IO) {
    override suspend fun openFile(path: String): Result<Unit> = withContext(Dispatchers.IO) {
    override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = withContext(Dispatchers.IO) {
    override suspend fun renameEntry(path: String, newName: String): Result<String> = withContext(Dispatchers.IO) {
    override suspend fun writeTextFile(path: String, content: String): Boolean = withContext(Dispatchers.IO) {
    private fun isRoot(file: File): Boolean = files.isRoot(file)
    private fun resolve(guestPath: String): File? = files.resolve(guestPath)
    private val context: Context,
    private val files = GuestFileMap(
    private val paths: LinuxPaths,
    }
 * Kai Build's Debian seen as a file tree. Everything the user can browse is an
 * an external-files directory — so this needs no proot round-trip.
 * ordinary host file — the rootfs is app-private storage and project folders are
 */
) : FileBrowserSource {
/**
class BuildFileBrowser(
import android.content.Context
import com.inspiredandroid.kai.FileBrowserSource
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.TextFileResult
import com.inspiredandroid.kai.linux.GuestFileMap
import com.inspiredandroid.kai.linux.LinuxPaths
import com.inspiredandroid.kai.sandbox.importFileInto
import com.inspiredandroid.kai.sandbox.openFileWithIntent
import com.inspiredandroid.kai.sandbox.readFileAsText
import com.inspiredandroid.kai.sandbox.toFileEntry
import io.github.vinceglb.filekit.PlatformFile
import java.io.File
import java.io.IOException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
package com.inspiredandroid.kai.build.runtime
}
