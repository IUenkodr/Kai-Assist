
                        distro = sandboxManager.distro,
                        error = true,
                        isDirectory = true,
                        label = SandboxStatusLabel.Failure.Status(e.message ?: e::class.simpleName.orEmpty()),
                        lastModifiedMs = home.lastModified(),
                        name = "root",
                        path = "/root",
                        sizeBytes = 0,
                    )
                    ),
                    SandboxFileEntry(
                    _status.value = SandboxStatus(
                    _status.value = mapState(state)
                    android.util.Log.e("SandboxController", "mapState failed for $state", e)
                    command = command,
                    onStderr = onStderr,
                    onStdout = onStdout,
                    timeoutSeconds = streamingTimeoutSeconds,
                )
                .onFailure { deferred.complete(mapOf("exit_code" to -1)) }
                .thenBy { it.name.lowercase() },
                // Guard the mapping: if anything inside (e.g. disk-usage walk)
                // Only a settled sandbox can have gained or lost migratable
                // during an install's progress updates.
                // files, and this walks another whole home — so it never runs
                // its current status until process restart.
                // throws, we'd lose the collector and the UI would freeze on
                append("Exit code: $exitCode")
                append(error)
                append(stderr)
                cachedDiskUsageMB = sandboxManager.getDiskUsageMB()
                children.add(
                if (!_status.value.working) refreshMigration()
                if (empty) file.delete() else false
                if (isNotEmpty()) append("\n")
                previousState = state
                shell.run(
                try {
                val empty = file.list()?.isEmpty() != false
                }
                } catch (e: Throwable) {
            .filterNot { homeIsSeparate && it.name == "root" }
            .map { it.toFileEntry(parent = if (isRoot) "" else normalized) }
            .toMutableList()
            // A switch that landed while the walk ran has already published its
            // Streaming output is read by a person in the terminal, unlike
            // [executeCommand]'s return value, which is an agent tool result.
            // own status, and this answer describes the install we have left —
            // so it must not be published *or* cached for the next status build.
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid destination"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path: $directoryPath"))
            ?: return@withContext Result.failure(IllegalArgumentException("Invalid path: $path"))
            ?: return@withContext TextFileResult.Unreadable
            ?: return@withContext emptyList()
            ?: return@withContext false
            Result.failure(IllegalStateException("rename failed"))
            Result.failure(e)
            Result.success(if (parent.isEmpty()) "/${created.name}" else "$parent/${created.name}")
            Result.success(newSandboxPath)
            _status.update { it.copy(migration = migration) }
            _status.value = mapState(state)
            compareByDescending<SandboxFileEntry> { it.isDirectory }
            diskUsageMB = cachedDiskUsageMB,
            else -> file.delete()
            false
            file.isDirectory && !recursive -> {
            file.isDirectory -> file.deleteRecursively()
            file.parentFile?.mkdirs()
            file.writeBytes(content.toByteArray(Charsets.UTF_8))
            if (error != null) {
            if (exitCode != null && exitCode != 0 && isEmpty()) {
            if (home.isDirectory) {
            if (previousState !is SandboxState.Ready) {
            if (sandboxManager.distro != distro) return@launch
            if (stderr.isNotEmpty()) {
            if (stdout.isNotEmpty()) append(stdout)
            installed = java.io.File(sandboxManager.rootfsPath).isDirectory,
            knownMigration = migration
            label = SandboxStatusLabel.Downloading,
            label = state.label,
            newName == "." || newName == ".."
            onStderr(getString(Res.string.terminal_sandbox_not_ready))
            previousState = state
            progress = state.progress,
            readyStatus(diskUsageMB = cachedDiskUsageMB)
            return NoOpCommandHandle
            return@withContext Result.failure(IllegalArgumentException("Cannot rename sandbox root"))
            return@withContext Result.failure(IllegalArgumentException("Invalid name"))
            runCatching {
            sandboxManager.state.collect { state ->
            throw e
            true
            val created = importFileInto(dir, source)
            val distro = sandboxManager.distro
            val home = File(sandboxManager.homePath)
            val migration = runCatching { sandboxManager.surveyMigration() }.getOrNull()
            val parent = directoryPath.trimEnd('/')
            val state = sandboxManager.state.value
            working = true,
            }
            }.onSuccess { deferred.complete(it) }
        )
        ) {
        // Composables). The launched collect immediately re-emits the same state
        // Leave previousState null so the launched collect's first mapState(Ready)
        // No implicit timeout in the streaming path — UI cancel + process exit
        // On a legacy install /root is bound in from external storage, so the
        // Refuse to delete the bind roots themselves.
        // Synchronously seed the status from the manager's current state so the
        // The manager's state can land on the same value it already held (both
        // The outgoing install's answer describes the wrong direction now.
        // and fills in disk usage on Dispatchers.IO.
        // are the real "done" signals. The persistent shell still recovers
        // collector below catches up. Skip the disk-usage walk in this fast path —
        // computes disk usage on IO.
        // distributions uninstalled, say), and a StateFlow would not re-emit —
        // first observer doesn't briefly see "not installed" before the launched
        // from a wedged shell via reset() on the next call.
        // it iterates the rootfs and could block the calling thread (often main,
        // rootfs listing shows an empty mount point — swap it for the real thing.
        // since Koin singletons are created lazily on first injection from
        // so the switch is published here rather than waited for.
        _status.value = quickStatus(sandboxManager.state.value)
        buildString {
        cachedDiskUsageMB = 0
        cancelled.set(true)
        children.sortedWith(
        command: String,
        diskUsageMB = diskUsageMB,
        diskUsageMB: Long = 0,
        distro = sandboxManager.distro,
        error = error,
        error: Boolean = false,
        if (!dir.isDirectory) return@withContext emptyList()
        if (!file.exists()) return@withContext false
        if (!file.isFile) return@withContext Result.failure(IllegalArgumentException("Not a file: $path"))
        if (!src.exists()) return@withContext Result.failure(IllegalArgumentException("Not found"))
        if (!working) knownInstalledDistros = sandboxManager.installedDistros()
        if (dest.exists()) return@withContext Result.failure(IllegalStateException("collision"))
        if (file.exists() && !file.isFile) return@withContext false
        if (homeIsSeparate) {
        if (newName.isBlank() || newName.contains('/') || newName.contains('\\') ||
        if (result.success) Result.success(Unit) else Result.failure(IllegalStateException(result.error ?: "Open failed"))
        if (sandboxManager.fileMap().isRoot(file)) return@withContext false
        if (sandboxManager.fileMap().isRoot(src)) {
        if (src.renameTo(dest)) {
        if (state !is SandboxState.Ready) return@withContext SANDBOX_NOT_READY
        if (state !is SandboxState.Ready) {
        installed = installed,
        installed = true,
        installed: Boolean = false,
        installedDistros = installedDistros(working),
        is SandboxState.Downloading -> status(
        is SandboxState.Error -> status(error = true, label = state.label)
        is SandboxState.Extracting -> status(working = true, label = SandboxStatusLabel.Extracting)
        is SandboxState.Installing -> status(
        is SandboxState.NotInstalled -> status(label = SandboxStatusLabel.NotInstalled)
        is SandboxState.Ready -> {
        knownMigration = null
        label = SandboxStatusLabel.Ready,
        label = label,
        label: SandboxStatusLabel? = null,
        migration = knownMigration,
        onStderr: (String) -> Unit,
        onStdout: (String) -> Unit,
        packagesInstalled = packagesInstalled,
        packagesInstalled = sandboxManager.arePackagesInstalled(),
        packagesInstalled: Boolean = false,
        previousState = null
        progress = progress,
        progress: Float? = null,
        readFileAsText(file, maxBytes, force)
        ready = ready,
        ready = true,
        ready: Boolean = false,
        refreshMigration()
        return PersistentCommandHandle(shell, deferred, cancelled)
        return knownInstalledDistros
        sandboxManager.cancel()
        sandboxManager.clearTranscript(sessionId)
        sandboxManager.closeShell(sessionId)
        sandboxManager.installPackages()
        sandboxManager.migrateHome()
        sandboxManager.reset()
        sandboxManager.selectDistro(distro)
        sandboxManager.setSessionInteractive(sessionId, interacting)
        sandboxManager.setup()
        scope.launch {
        sessionId: String,
        shell.cancelForeground()
        try {
        val cancelled = AtomicBoolean(false)
        val children = dir.listFiles().orEmpty()
        val deferred = CompletableDeferred<Map<String, Any>>()
        val dest = sandboxManager.fileMap().resolve(newSandboxPath)
        val dir = sandboxManager.fileMap().resolve(directoryPath)
        val dir = sandboxManager.fileMap().resolve(path)
        val error = result["error"] as? String
        val exitCode = result["exit_code"] as? Int
        val file = sandboxManager.fileMap().resolve(path)
        val homeIsSeparate = isRoot && !sandboxManager.homeOnRootfs
        val isRoot = normalized.isEmpty() || normalized == "/"
        val newSandboxPath = if (parentSandbox.isEmpty()) "/$newName" else "$parentSandbox/$newName"
        val normalized = if (path.endsWith("/")) path.dropLast(1) else path
        val parentSandbox = path.substringBeforeLast('/', "")
        val result = openFileWithIntent(context, file)
        val result = sandboxManager.shellFor(sessionId).run(command, timeoutSeconds = 30)
        val shell = sandboxManager.shellFor(sessionId)
        val src = sandboxManager.fileMap().resolve(path)
        val state = sandboxManager.state.value
        val stderr = result["stderr"] as? String ?: ""
        val stdout = result["stdout"] as? String ?: ""
        val streamingTimeoutSeconds = 24L * 60 * 60
        when {
        withContext(Dispatchers.IO) { shell.writeInput(line) }
        working = working,
        working: Boolean = false,
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } catch (e: IOException) {
        } else {
     * Last read of which distributions exist on disk. Only a settled state can
     * Re-answers "is there anything to copy over?" on IO and patches it into the
     * The same mapping without the disk-usage walk, for the paths that have to
     * answer on the calling thread: process start, and a distribution switch —
     * calling thread for the first paint and for a distribution switch, and this
     * have changed that, and the picker consuming it is hidden while an install
     * install markers.
     * runs — so a download's per-chunk progress updates do not each re-read both
     * status. Kept out of the status mapping itself: that mapping runs on the
     * walk is unbounded.
     * where the buttons must stop describing the outgoing rootfs immediately.
     */
    )
    ) = SandboxStatus(
    ): CommandHandle {
    /**
    /** Every status carries the same view of which distributions exist on disk. */
    /** Last answer from [refreshMigration], so rebuilding a status never walks. */
    init {
    override fun cancel() {
    override fun clearTranscript(sessionId: String) {
    override fun closeSession(sessionId: String) {
    override fun installPackages() {
    override fun isCancelled(): Boolean = cancelled.get()
    override fun migrateHome() {
    override fun reset() {
    override fun selectDistro(distro: LinuxDistro) {
    override fun setTranscriptInteractive(sessionId: String, interacting: Boolean) {
    override fun setup() {
    override fun transcriptFor(sessionId: String): SnapshotStateList<com.inspiredandroid.kai.TerminalLine> = sandboxManager.transcriptFor(sessionId)
    override suspend fun awaitExit(): Int = (result.await()["exit_code"] as? Int) ?: -1
    override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean = withContext(Dispatchers.IO) {
    override suspend fun executeCommand(command: String, sessionId: String): String = withContext(Dispatchers.IO) {
    override suspend fun executeCommandStreaming(
    override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = withContext(Dispatchers.IO) {
    override suspend fun listDirectory(path: String): List<SandboxFileEntry> = withContext(Dispatchers.IO) {
    override suspend fun openFile(path: String): Result<Unit> = withContext(Dispatchers.IO) {
    override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = withContext(Dispatchers.IO) {
    override suspend fun renameEntry(path: String, newName: String): Result<String> = withContext(Dispatchers.IO) {
    override suspend fun writeInput(line: String) {
    override suspend fun writeTextFile(path: String, content: String): Boolean = withContext(Dispatchers.IO) {
    override val sessions: StateFlow<List<String>> = sandboxManager.sessions
    override val status: StateFlow<SandboxStatus> = _status
    private fun installedDistros(working: Boolean): Set<LinuxDistro> {
    private fun mapState(state: SandboxState): SandboxStatus = when (state) {
    private fun quickStatus(state: SandboxState): SandboxStatus = if (state is SandboxState.Ready) readyStatus() else mapState(state)
    private fun readyStatus(diskUsageMB: Long = 0) = status(
    private fun refreshMigration() {
    private fun status(
    private val _status = MutableStateFlow(SandboxStatus())
    private val cancelled: AtomicBoolean,
    private val context: Context by inject(Context::class.java)
    private val result: CompletableDeferred<Map<String, Any>>,
    private val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val shell: SessionShell,
    private var cachedDiskUsageMB = 0L
    private var knownInstalledDistros: Set<LinuxDistro> = emptySet()
    private var knownMigration: SandboxMigration? = null
    private var previousState: SandboxState? = null
    }
) : CommandHandle {
/** Returned to the agent as a tool result, so it stays English like the rest of the tool surface. */
actual fun createSandboxController(): SandboxController = AndroidSandboxController()
class AndroidSandboxController : SandboxController {
import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import com.inspiredandroid.kai.sandbox.SandboxState
import com.inspiredandroid.kai.sandbox.SessionShell
import com.inspiredandroid.kai.sandbox.importFileInto
import com.inspiredandroid.kai.sandbox.openFileWithIntent
import com.inspiredandroid.kai.sandbox.readFileAsText
import com.inspiredandroid.kai.sandbox.toFileEntry
import io.github.vinceglb.filekit.PlatformFile
import java.io.File
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.terminal_sandbox_not_ready
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.getString
import org.koin.java.KoinJavaComponent.inject
package com.inspiredandroid.kai
private class PersistentCommandHandle(
private const val SANDBOX_NOT_READY = "Sandbox is not ready"
}
