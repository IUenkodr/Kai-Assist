import com.inspiredandroid.kai.CommandHandle
import com.inspiredandroid.kai.NoOpCommandHandle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.SandboxStatus
import com.inspiredandroid.kai.TextFileResult
import io.github.vinceglb.filekit.PlatformFile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

                children[rest] = false // direct file
                if (children[dir] != false) children[dir] = true
                val dir = rest.substring(0, slash)
            SandboxFileEntry(name = name, path = "$prefix$name", isDirectory = isDir, sizeBytes = 0, lastModifiedMs = 0)
            if (!p.startsWith(prefix)) continue
            if (slash < 0) {
            val rest = p.removePrefix(prefix)
            val slash = rest.indexOf('/')
            }
            } else {
        command: String,
        files[path] = content
        for (p in files.keys) {
        onStderr: (String) -> Unit,
        onStdout: (String) -> Unit,
        return children.map { (name, isDir) ->
        return toRemove.isNotEmpty()
        return true
        sessionId: String,
        toRemove.forEach { files.remove(it) }
        val children = linkedMapOf<String, Boolean>() // name -> isDirectory
        val prefix = "$path/"
        val prefix = if (path.endsWith("/")) path else "$path/"
        val toRemove = files.keys.filter { it == path || (recursive && it.startsWith(prefix)) }
        }
    ): CommandHandle = NoOpCommandHandle
    override fun cancel() {}
    override fun installPackages() {}
    override fun reset() {}
    override fun setup() {}
    override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean {
    override suspend fun executeCommand(command: String, sessionId: String): String = ""
    override suspend fun executeCommandStreaming(
    override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = Result.failure(UnsupportedOperationException("Not needed by tests"))
    override suspend fun listDirectory(path: String): List<SandboxFileEntry> {
    override suspend fun openFile(path: String): Result<Unit> = Result.success(Unit)
    override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = files[path]?.let { TextFileResult.Text(it) } ?: TextFileResult.Unreadable
    override suspend fun renameEntry(path: String, newName: String): Result<String> = Result.success(path)
    override suspend fun writeTextFile(path: String, content: String): Boolean {
    override val sessions: StateFlow<List<String>> = MutableStateFlow(emptyList())
    override val status: StateFlow<SandboxStatus> = _status
    private val _status = MutableStateFlow(SandboxStatus(installed = installed, ready = installed))
    val files = mutableMapOf<String, String>()
    }
 * In-memory [SandboxController] for tests. Backs the file ops with a flat
 * [com.inspiredandroid.kai.skills.SkillManager] needs to store and read skills.
 * path→content map (directories are implicit from path prefixes), which is all
 */
/**
class FakeSandboxController(installed: Boolean = true) : SandboxController {
package com.inspiredandroid.kai.testutil
}
