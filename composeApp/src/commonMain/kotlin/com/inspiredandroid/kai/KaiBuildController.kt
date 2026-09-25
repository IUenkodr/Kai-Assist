import com.inspiredandroid.kai.build.KaiBuildState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

     * (rows/cols). Call when the terminal viewport is measured or resized.
     * (terminated with `\r`), or an encoded key sequence.
     * A non-null [agentId] launches that agent's CLI first, leaving a shell behind
     * Android implementation.
     * Re-enters [project]: activates the session it was left on and stops its
     * Renames `projects/<name>`, returning the sanitized new folder name — or null
     * Sends raw bytes to the active session — typed text, a submitted line
     * Starts an interactive PTY session in [project] and makes it the active one.
     * Steps out of [project] with its shells still running — a command keeps going
     * Updates the active session's VT geometry and its live PTY winsize
     * ended for them if the project is never reopened; see the idle window in the
     * shells from being reaped. False when the project has none running, which is
     * the caller's cue to start one.
     * their working directory is the folder that just moved.
     * when it exits.
     * when the name is unusable or already taken. The project's sessions are closed:
     * while the user is elsewhere, and only the user closes a session. They are
     */
    /**
    /** Brings an existing session to the front; the terminal renders the active one. */
    /** Creates `projects/<name>` and returns the sanitized folder name, or null if invalid. */
    /** Deletes `projects/<name>` and everything in it. The project's sessions are closed with it. */
    /** Ends one session and activates its neighbour, if any. */
    /** Installs Debian if needed, then the given agents. Safe to call when already installed. */
    /** Re-scans projects, installed agents, and system facts. */
    /** The Debian file tree, for the Files tab. Empty on platforms without Kai Build. */
    fun cancel()
    fun closeSession(id: String)
    fun createProject(name: String): String?
    fun deleteProject(name: String)
    fun install(agentIds: Set<String>)
    fun leaveProject(project: String)
    fun refresh()
    fun renameProject(name: String, newName: String): String?
    fun resizeTerminal(columns: Int, rows: Int)
    fun resumeProject(project: String): Boolean
    fun selectSession(id: String)
    fun startSession(project: String, agentId: String?)
    fun uninstall()
    fun writeToTerminal(text: String)
    override fun cancel() {}
    override fun closeSession(id: String) {}
    override fun createProject(name: String): String? = null
    override fun deleteProject(name: String) {}
    override fun install(agentIds: Set<String>) {}
    override fun leaveProject(project: String) {}
    override fun refresh() {}
    override fun renameProject(name: String, newName: String): String? = null
    override fun resizeTerminal(columns: Int, rows: Int) {}
    override fun resumeProject(project: String): Boolean = false
    override fun selectSession(id: String) {}
    override fun startSession(project: String, agentId: String?) {}
    override fun uninstall() {}
    override fun writeToTerminal(text: String) {}
    override val files: FileBrowserSource = NoOpFileBrowserSource
    override val state = MutableStateFlow(KaiBuildState())
    val files: FileBrowserSource
    val state: StateFlow<KaiBuildState>
 * Kai Build's Debian-under-proot environment. Separate from [SandboxController]
 * on purpose: different rootfs, different home, and resetting one must never
 * touch the other.
 */
/**
/** Kai Build is Android-only; every other target gets this. */
class NoOpKaiBuildController : KaiBuildController {
expect fun createKaiBuildController(): KaiBuildController
interface KaiBuildController {
package com.inspiredandroid.kai
}
