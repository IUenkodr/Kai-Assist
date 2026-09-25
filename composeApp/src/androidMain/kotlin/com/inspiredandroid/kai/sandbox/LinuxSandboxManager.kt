package com.inspiredandroid.kai.sandbox
import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.inspiredandroid.kai.SandboxMigration
import com.inspiredandroid.kai.SandboxSessions
import com.inspiredandroid.kai.SandboxStatusLabel
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.ConversationStorage
import com.inspiredandroid.kai.linux.DistroSpec
import com.inspiredandroid.kai.linux.GuestFileMap
import com.inspiredandroid.kai.linux.HomeMigration
import com.inspiredandroid.kai.linux.InstallMarker
import com.inspiredandroid.kai.linux.InstallStep
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.linux.LinuxInstaller
import com.inspiredandroid.kai.linux.LinuxInstalls
import com.inspiredandroid.kai.linux.LinuxPaths
import com.inspiredandroid.kai.linux.ProotLauncher
import java.io.File
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.withLock

                        .firstNotNullOfOrNull { (result[it] as? String)?.takeIf(String::isNotBlank) }
                        .orEmpty()
                        // skip sockets, FIFOs, broken symlinks
                        _state.value = SandboxState.Installing(SandboxStatusLabel.CopyingFiles(done, total))
                        child.isDirectory -> stack.addLast(child)
                        child.isFile -> total += child.length()
                    // One status per file would be thousands of recompositions on
                    // a real home; a step every so often is what a progress line
                    // is for.
                    // skip transient/inaccessible entry, keep iterating
                    _state.value = SandboxState.Error(SandboxStatusLabel.Failure.Package(pkg, detail.take(200)))
                    android.util.Log.e("LinuxSandbox", "Failed to install $pkg: $detail")
                    conversationStorage.updateShellTranscript(sessionId, lines)
                    delay(TRANSCRIPT_SAVE_DEBOUNCE)
                    if (done % MIGRATION_PROGRESS_STEP == 0) {
                    manager.installCommand(pkg),
                    return
                    synchronized(pendingSaves) { pendingSaves.remove(sessionId) }
                    timeoutSeconds = PACKAGE_TIMEOUT_SECONDS,
                    val detail = listOf("stderr", "error", "stdout")
                    when {
                    }
                )
                .firstOrNull { it.id == sessionId }?.shellTranscript.orEmpty()
                ?.let { SandboxStatusLabel.InstallingPackage(it) }
                ?: SandboxStatusLabel.BasePackages,
                HomeMigration.copy(sourceHome, paths.homeDir(current)) { done ->
                _state.value = SandboxState.Error(SandboxStatusLabel.Failure.Copy(e.message.orEmpty()))
                _state.value = SandboxState.Error(SandboxStatusLabel.Failure.Install(e.message.orEmpty()))
                _state.value = SandboxState.Error(SandboxStatusLabel.Failure.Setup(e.message.orEmpty()))
                _state.value = SandboxState.Installing(SandboxStatusLabel.CopyingFiles())
                _state.value = SandboxState.Installing(SandboxStatusLabel.InstallingPackage(pkg))
                _state.value = SandboxState.Ready
                add(paths.homeDir(current).absolutePath to "/root")
                add(paths.projectsDir.absolutePath to "/root/projects")
                android.util.Log.e("LinuxSandbox", "Home migration failed", e)
                android.util.Log.e("LinuxSandbox", "Package install exception", e)
                android.util.Log.e("LinuxSandbox", "Setup failed", e)
                checkExistingInstallation()
                currentCoroutineContext().ensureActive()
                dir.listFiles()
                if (result["success"] as? Boolean != true) {
                installOptionalPackages()
                marker = installed
                marker = paths.readMarker()
                null
                paths.ensureMountPoints()
                try {
                val installed = installer.install(target) { step -> _state.value = step.toSandboxState() }
                val pending = surveyMigration() ?: return@launch
                val result = executor.execute(
                val sourceHome = installs.homeDirFor(pending.from) ?: return@launch
                val total = pending.fileCount
                }
                } catch (_: Throwable) {
                } finally {
            .onFailure { android.util.Log.w("LinuxSandbox", "ssh defaults seed failed: ${it.message}") }
            // Nothing to bind when /root is already part of the rootfs; only the
            // Only a shared Debian has projects to expose; an Alpine sandbox has
            // The directory just freed is not necessarily the one this
            // Wipes the rootfs, the marker and the libtalloc copy. Project folders
            // distribution claims next — the other one can be empty and preferred.
            // live in external files and survive, as they do for a Kai Build uninstall.
            // no Kai Build behind it and the mount point would be a stray folder.
            // pre-unification layout keeps it on external storage.
            File(rootfsPath, "usr/bin/ssh").exists()
            SandboxState.NotInstalled
            SandboxState.Ready
            _sessions.value = shells.keys.toList()
            _state.value = SandboxState.NotInstalled
            binds = binds,
            closeAllShells()
            conversationStorage.conversations.value
            emptyList()
            env = spec.env,
            extraArgs = spec.prootArgs,
            for (child in children) {
            for (pkg in current.distro.optionalPackages) {
            homeDir = paths.homeDir(current),
            if (!current.homeOnRootfs) {
            if (current.distro == LinuxDistro.DEBIAN) {
            installers.getOrPut(current.root.path) { LinuxInstaller(current) }
            libDir = paths.libDir,
            marker = null
            null
            onBeforeReset?.invoke()
            packages.singleOrNull()
            paths = installs.pathsFor(selected)
            paths.root.deleteRecursively()
            pendingSaves[sessionId] = scope.launch {
            pendingSaves[sessionId]?.cancel()
            projectsDir = if (current.distro == LinuxDistro.DEBIAN) paths.projectsDir else null,
            prootPath = paths.prootPath,
            rootfsDir = paths.rootfsDir,
            rootfsPath = paths.rootfsDir.absolutePath,
            s
            tmpDir = paths.tmpDir,
            tmpPath = paths.tmpDir.absolutePath,
            try {
            val children = try {
            val dir = stack.removeLast()
            val s = shells.remove(sessionId)
            { lines -> scheduleTranscriptSave(sessionId, lines) }
            }
            } ?: continue
            } catch (_: Throwable) {
            } catch (_: kotlinx.coroutines.CancellationException) {
            } catch (e: Exception) {
            } catch (e: kotlinx.coroutines.CancellationException) {
        )
        // A shared rootfs means Kai Build could be installing an agent right now.
        // AssertionError if a child entry transitions from directory→non-directory
        // Detach synchronously so a command arriving right after the switch
        // Manual stack walk instead of walkTopDown(): the latter throws an
        // Seed ~/.ssh/config with keepalive + accept-new defaults so any manual
        // The rootfs can contain unix sockets / FIFOs / broken symlinks (e.g. from
        // `ssh user@host` from now on works without a prompt this shell cannot
        // answer. Idempotent; failures here are non-fatal.
        // between the iterator's isDirectory check and DirectoryState construction.
        // creates its shell against the new install rather than being torn down
        // the walk. We skip bad entries and keep going.
        // user-run programs like node), and concurrent install activity also races
        // with the old ones.
        ?: LinuxDistro.DEFAULT
        ?: installs.distroInSandboxDir()
        LinuxInstaller.packageLock.withLock {
        _sessions.value = emptyList()
        _sessions.value = shells.keys.toList()
        _state.value = SandboxState.Ready
        _state.value = if (marker != null && proot.exists() && proot.canExecute()) {
        checkExistingInstallation()
        currentJob = null
        currentJob = scope.launch {
        currentJob?.cancel()
        detachShells().forEach { it.reset() }
        if (!paths.root.isDirectory) return 0
        if (_state.value !is SandboxState.Ready) return false
        if (currentJob?.isActive == true) return
        if (distro == selected || currentJob?.isActive == true) return
        if (survey.isEmpty) return null
        is InstallStep.Configure -> SandboxState.Installing(SandboxStatusLabel.Configuring)
        is InstallStep.Download -> SandboxState.Downloading(fraction)
        is InstallStep.Extract -> SandboxState.Extracting
        is InstallStep.Packages -> SandboxState.Installing(
        marker = paths.readMarker()
        paths = installs.pathsFor(distro)
        paths.copyLibtalloc()
        paths.ensureLayout()
        removed?.reset()
        return File(rootfsPath, "usr/bin/python3").exists() &&
        return GuestFileMap(
        return ProotLauncher(
        return SandboxMigration(from = source, fileCount = survey.fileCount, bytes = survey.bytes)
        return synchronized(installers) {
        return total / (1024 * 1024)
        runCatching { SshConfigManager(File(homePath)).ensureDefaults() }
        scope.launch {
        scope.launch { stale.forEach { it.reset() } }
        selected = distro
        shell.setPrunePaused(interacting)
        shells.clear()
        shells[sessionId] = wrapper
        shells[sessionId]?.let { return it }
        snapshot
        stack.addLast(paths.root)
        synchronized(pendingSaves) {
        synchronized(shells) { shells[sessionId] }?.transcript?.clear()
        val binds = buildList {
        val current = marker ?: legacyMarker()
        val current = marker ?: return
        val current = marker ?: return null
        val current = paths
        val executor = createProotExecutor()
        val initialLines = if (persistable) {
        val inner = PersistentSandboxShell(createProotExecutor(), tmpPath)
        val installer = installer()
        val manager = current.distro.packageManager
        val onChange: ((List<TerminalLine>) -> Unit)? = if (persistable) {
        val persistable = SandboxSessions.isPersistable(sessionId)
        val proot = File(prootPath)
        val removed = synchronized(shells) {
        val shell = synchronized(shells) { shells[sessionId] } ?: return
        val snapshot = shells.values.toList()
        val source = LinuxDistro.entries.firstOrNull { it != current.distro } ?: return null
        val sourceHome = installs.homeDirFor(source) ?: return null
        val spec = DistroSpec.of(current.distro)
        val stack = ArrayDeque<File>()
        val stale = detachShells()
        val survey = HomeMigration.survey(sourceHome, paths.homeDir(current))
        val target = selected
        val wrapper = SessionShell(sessionId, inner, initialLines, onChange)
        var total = 0L
        while (stack.isNotEmpty()) {
        wrapper
        }
        } else {
     *
     * (both package managers skip already-installed ones).
     * Both markers must be present: installs predating the SSH bundle report
     * Copies that home across. Nothing is overwritten and the source install is
     * False only for installs made before the two Linux stacks merged. Those
     * Files sitting in another distribution's `/root` that the selected install
     * Host directory behind `/root`. New installs keep it on the rootfs so
     * Linux stacks merged keep their external-storage bind.
     * Live shells are the one thing that cannot come along — each is a proot
     * One installer per directory. Each holds an HTTP client, and switching back
     * Only runs when the user taps "Install Packages" in Settings — the base
     * Points the shell integration at [distro]'s install. Nothing is downloaded
     * Re-reads what is on disk. Kai Build calls this after it installs or removes
     * Storage for [selected]'s install. Re-pointed by [selectDistro] rather than
     * Toggle prune-pause on an existing session shell. Does NOT create a shell
     * Walks the other home, so call it off the main thread.
     * What is on disk. Null until something is installed, at which point every
     * Where to start pointed. A sandbox installed before the picker existed never
     * `/root` intact, so switching back finds it exactly as it was. When the
     * a shared Debian — that is the same rootfs this manager reports on, and
     * against the new one.
     * and forth must not accumulate them; there are only ever two directories.
     * and nothing is deleted: the outgoing distribution stays on disk with its
     * binaries under `~/.local/bin` are executable; installs made before the two
     * bound to the outgoing rootfs — so they are dropped and lazily recreated
     * counts as the choice until the user makes a different one.
     * distro-dependent decision — package commands, proot flags, where `/root`
     * does not have — SSH keys, skills, whatever the agent wrote. Null when there
     * fixed for the process: each distribution keeps its own directory, so
     * has never had — so an install sitting in the chat sandbox's own directory
     * home this one already has in full.
     * is nothing to offer: no other install, no install here to copy into, or a
     * left whole, so this is safe to repeat and the distribution being left is
     * listing and the file browser has to add it.
     * lives — follows it rather than the user's current setting.
     * not-installed and re-prompt, picking up the new packages on the next run
     * nothing else would tell it the answer changed.
     * packages are already guaranteed present by [setup].
     * recorded a choice, and the setting's default would send it to a Debian it
     * still bind `/root` from external storage, so it is not part of the rootfs
     * still there to fall back on until the user removes it.
     * switching is a change of address and never a download.
     * target has no install yet the card simply offers to install it.
     * — if there's no shell for [sessionId] yet there's no transcript to gate.
     */
    /**
    /** Called on reset so Kai Build can drop sessions holding a deleted rootfs. */
    /** Directory holding the install the sandbox is currently pointed at. */
    /** Distributions with an install on disk, not only the one selected. */
    /** Empties the session table and hands back the shells that were in it. */
    /** Guest-path translation matching [createLauncher]'s binds. */
    /** The distribution the user has the shell integration pointed at. */
    /** The distro an install would become, or the one already installed. */
    /** proot for the installed rootfs, with the binds and flags its distro needs. */
    // 1000-iteration loop) would otherwise re-serialize the entire conversations
    // Debounce per-session transcript writes. A burst of commands (e.g. a
    // JSON and rewrite SharedPreferences once per command.
    // One bash session per logical caller (chat conversation, terminal scratch,
    // down. Live during the app process only — not persisted.
    // package-manager UI, etc.). Lazily created on first access; tracked here so
    // the sandbox-level `reset()` and per-conversation deletion can tear them
    @Volatile
    fun arePackagesInstalled(): Boolean {
    fun cancel() {
    fun clearTranscript(sessionId: String) {
    fun closeShell(sessionId: String) {
    fun createProotExecutor(): ProotExecutor = ProotExecutor(createLauncher())
    fun fileMap(): GuestFileMap {
    fun getDiskUsageMB(): Long {
    fun installPackages() {
    fun installedDistros(): Set<LinuxDistro> = installs.installed()
    fun migrateHome() {
    fun refreshInstallState() {
    fun reset() {
    fun selectDistro(distro: LinuxDistro) {
    fun setSessionInteractive(sessionId: String, interacting: Boolean) {
    fun setup() {
    fun shellFor(sessionId: String): SessionShell = synchronized(shells) {
    fun surveyMigration(): SandboxMigration? {
    fun transcriptFor(sessionId: String): SnapshotStateList<TerminalLine> = shellFor(sessionId).transcript
    init {
    private fun InstallStep.toSandboxState(): SandboxState = when (this) {
    private fun checkExistingInstallation() {
    private fun closeAllShells() {
    private fun createLauncher(): ProotLauncher {
    private fun detachShells(): List<SessionShell> = synchronized(shells) {
    private fun initialSelection(): LinuxDistro = appSettings.getSandboxDistroOrNull()
    private fun installer(): LinuxInstaller {
    private fun legacyMarker() = InstallMarker(LinuxDistro.LEGACY, homeOnRootfs = false)
    private fun scheduleTranscriptSave(sessionId: String, lines: List<TerminalLine>) {
    private suspend fun installOptionalPackages() {
    private val _sessions = MutableStateFlow<List<String>>(emptyList())
    private val _state = MutableStateFlow<SandboxState>(SandboxState.NotInstalled)
    private val appSettings: AppSettings,
    private val context: Context,
    private val conversationStorage: ConversationStorage,
    private val installers = mutableMapOf<String, LinuxInstaller>()
    private val installs = LinuxInstalls(context)
    private val pendingSaves = mutableMapOf<String, Job>()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val shells = mutableMapOf<String, SessionShell>()
    private var currentJob: Job? = null
    private var marker: InstallMarker? = null
    private var paths: LinuxPaths = installs.pathsFor(selected)
    private var selected: LinuxDistro = initialSelection()
    val distro: LinuxDistro get() = marker?.distro ?: selected
    val homeOnRootfs: Boolean get() = (marker ?: legacyMarker()).homeOnRootfs
    val homePath: String get() = paths.homeDir(marker ?: legacyMarker()).absolutePath
    val prootPath: String get() = paths.prootPath
    val rootDir: File get() = paths.root
    val rootfsPath: String get() = paths.rootfsDir.absolutePath
    val sessions: StateFlow<List<String>> = _sessions
    val state: StateFlow<SandboxState> = _state
    val tmpPath: String get() = paths.tmpDir.absolutePath
    var onBeforeReset: (() -> Unit)? = null
    }
) {
/** How many copied files pass before the migration updates its progress line. */
class LinuxSandboxManager(
private const val MIGRATION_PROGRESS_STEP = 25
private const val PACKAGE_TIMEOUT_SECONDS = 900L
private val TRANSCRIPT_SAVE_DEBOUNCE = 500.milliseconds
}
