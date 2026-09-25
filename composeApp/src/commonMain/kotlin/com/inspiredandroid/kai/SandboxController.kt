package com.inspiredandroid.kai
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.inspiredandroid.kai.linux.LinuxDistro
import io.github.vinceglb.filekit.PlatformFile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

        command: String,
        data class Copy(override val detail: String = "") : Failure
        data class Install(override val detail: String = "") : Failure
        data class Package(val packageName: String, override val detail: String = "") : Failure
        data class Setup(override val detail: String = "") : Failure
        data class Status(override val detail: String = "") : Failure
        onStderr: (String) -> Unit,
        onStdout: (String) -> Unit,
        sessionId: String = SandboxSessions.DEFAULT,
        sessionId: String,
        val detail: String
     * A failure the card reports. [detail] is the underlying error text, which
     * Copy [SandboxStatus.migration]'s files into the selected install. Merges
     * Distributions with an install on disk — not just the one [distro] names.
     * Each keeps its own directory, so the picker can say which choice is a
     * Files the other installed distribution has in `/root` and this one does
     * Live transcript of commands and output for [sessionId]. The list is
     * Pause/resume bounded-trim on [sessionId]'s transcript. Set to true while
     * Point the shell integration at [distro]'s install. Non-destructive: each
     * Terminal UI), so the user can see the agent's activity. Returns an
     * What is on disk once [installed], and what a fresh install would become
     * an install is running.
     * before that. Package commands, tool descriptions and the Settings card all
     * comes from the OS or a download mirror and so stays as it arrived — only
     * crashes SelectionManager on its next lookup. Resuming runs a catch-up
     * distribution keeps its own directory, so the one being left stays on disk
     * empty, non-mutated list on platforms without a sandbox.
     * follow it.
     * install untouched, so it stays a fallback until the user removes it.
     * not, or null when there is nothing to carry over. Non-null is the whole
     * populated regardless of which path drove the command (chat tool or
     * rather than replaces — anything already here wins — and leaves the source
     * reason the card offers to copy.
     * switch and which is a download.
     * the sentence around it is translated.
     * the user is dragging to select text in the LazyColumn rendering this
     * transcript — pruning lines mid-drag unregisters their selectables and
     * trim so the transcript settles back to its cap.
     * with its `/root` intact and switching back to it is instant. Ignored while
     */
    ): CommandHandle
    ): CommandHandle = NoOpCommandHandle
    ): String
    /**
    /** Active shell-session ids (in-memory only, not persisted). */
    /** Background system maintenance (package manager UI, settings refreshes). */
    /** Default scratch session — used when no caller-specific id is available. */
    /** Drop the shell for [sessionId] if any. Idempotent. */
    /** True for chat-bound session ids (anything that isn't a sentinel). Such sessions get their transcript persisted. */
    /** User-facing Terminal tab in Settings. */
    /** Wipe the transcript for [sessionId]. Idempotent. */
    /** [total] is 0 until the copy has counted the files it has to move. */
    const val DEFAULT = "__default__"
    const val SYSTEM = "__system__"
    const val TERMINAL = "__terminal__"
    data class CopyingFiles(val done: Int = 0, val total: Int = 0) : SandboxStatusLabel
    data class InstallingPackage(val packageName: String) : SandboxStatusLabel
    data object BasePackages : SandboxStatusLabel
    data object Configuring : SandboxStatusLabel
    data object Downloading : SandboxStatusLabel
    data object Extracting : SandboxStatusLabel
    data object Installing : SandboxStatusLabel
    data object NotInstalled : SandboxStatusLabel
    data object Ready : SandboxStatusLabel
    fun cancel()
    fun clearTranscript(sessionId: String) {}
    fun closeSession(sessionId: String) {}
    fun installPackages()
    fun isCancelled(): Boolean
    fun isPersistable(sessionId: String): Boolean = sessionId != TERMINAL && sessionId != SYSTEM && sessionId != DEFAULT
    fun migrateHome() {}
    fun reset()
    fun selectDistro(distro: LinuxDistro) {}
    fun setTranscriptInteractive(sessionId: String, interacting: Boolean) {}
    fun setup()
    fun transcriptFor(sessionId: String): SnapshotStateList<TerminalLine> = mutableStateListOf()
    override fun cancel() {}
    override fun installPackages() {}
    override fun isCancelled(): Boolean = false
    override fun reset() {}
    override fun setup() {}
    override suspend fun awaitExit(): Int = -1
    override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean = false
    override suspend fun executeCommand(command: String, sessionId: String): String = ""
    override suspend fun executeCommandStreaming(
    override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = Result.failure(UnsupportedOperationException("Sandbox file browser is Android-only"))
    override suspend fun listDirectory(path: String): List<SandboxFileEntry> = emptyList()
    override suspend fun openFile(path: String): Result<Unit> = Result.failure(UnsupportedOperationException("Sandbox file browser is Android-only"))
    override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = TextFileResult.Unreadable
    override suspend fun renameEntry(path: String, newName: String): Result<String> = Result.failure(UnsupportedOperationException("Sandbox file browser is Android-only"))
    override suspend fun writeInput(line: String) {}
    override suspend fun writeTextFile(path: String, content: String): Boolean = false
    override val sessions: StateFlow<List<String>> = MutableStateFlow(emptyList())
    override val status: StateFlow<SandboxStatus> = MutableStateFlow(SandboxStatus())
    sealed interface Failure : SandboxStatusLabel {
    suspend fun awaitExit(): Int
    suspend fun executeCommand(
    suspend fun executeCommandStreaming(
    suspend fun writeInput(line: String)
    val bytes: Long,
    val diskUsageMB: Long = 0,
    val distro: LinuxDistro = LinuxDistro.DEFAULT,
    val error: Boolean = false,
    val fileCount: Int,
    val from: LinuxDistro,
    val installed: Boolean = false,
    val installedDistros: Set<LinuxDistro> = emptySet(),
    val isDirectory: Boolean,
    val label: SandboxStatusLabel? = null,
    val lastModifiedMs: Long,
    val migration: SandboxMigration? = null,
    val name: String,
    val packagesInstalled: Boolean = false,
    val path: String,
    val progress: Float? = null,
    val ready: Boolean = false,
    val sessions: StateFlow<List<String>>
    val sizeBytes: Long,
    val status: StateFlow<SandboxStatus>
    val working: Boolean = false,
    }
 *
 * The install runs on Android, where there is no composition to read resources
 * What the sandbox card's status line says, as a value rather than a sentence.
 * from — so the platform reports which step it is on and the UI is what turns
 * that into words. Nothing below the UI layer owns user-facing English.
 */
)
/**
/** Sentinel ids for shell sessions that aren't tied to a specific chat. */
/** The sandbox is Android-only; every other target gets this. */
/** What switching distribution would leave behind, and how much of it there is. */
@Immutable
class NoOpSandboxController : SandboxController {
data class SandboxFileEntry(
data class SandboxMigration(
data class SandboxStatus(
expect fun createSandboxController(): SandboxController
interface CommandHandle {
interface SandboxController : FileBrowserSource {
internal object NoOpCommandHandle : CommandHandle {
object SandboxSessions {
sealed interface SandboxStatusLabel {
}
