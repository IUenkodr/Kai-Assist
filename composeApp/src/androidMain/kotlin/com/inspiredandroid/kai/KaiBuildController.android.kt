package com.inspiredandroid.kai
import android.content.Context
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.build.runtime.BuildEnvironmentManager
import com.inspiredandroid.kai.build.runtime.BuildFileBrowser
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.linux.LinuxInstalls
import com.inspiredandroid.kai.linux.LinuxPaths
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import kotlinx.coroutines.flow.StateFlow
import org.koin.java.KoinJavaComponent.inject

                // A sandbox reset deletes the rootfs; sessions holding file
                // descriptors into it have to go first.
                if (sandboxManager.rootDir == paths.root) built.onEnvironmentRemoved()
            // And the other direction: installing Debian from Kai Build's setup
            // Both directions are checked at fire time, not wired once: the chat
            // app runs.
            // sandbox can be pointed at this install and away from it while the
            // screen is what gives a Debian-pointed chat sandbox its Linux.
            built.onEnvironmentChanged = { sandboxManager.refreshInstallState() }
            sandboxManager.onBeforeReset = {
            }
        BuildEnvironmentManager(paths).also { built ->
        }
     * Kai Build is always Debian: its coding agents are vendor scripts that
     * expect glibc and apt. Debian has one directory on the device, so this is
     * leaves this install alone; the two simply coexist.
     * pointed at Debian — a Linux set up from either surface is immediately
     * the same install the chat sandbox uses whenever the shell integration is
     * there for the other. Pointing the shell integration at Alpine instead
     */
    /**
    override fun cancel() = manager.cancel()
    override fun closeSession(id: String) = manager.closeSession(id)
    override fun createProject(name: String): String? = manager.createProject(name)
    override fun deleteProject(name: String) = manager.deleteProject(name)
    override fun install(agentIds: Set<String>) = manager.install(agentIds)
    override fun leaveProject(project: String) = manager.leaveProject(project)
    override fun refresh() = manager.refresh()
    override fun renameProject(name: String, newName: String): String? = manager.renameProject(name, newName)
    override fun resizeTerminal(columns: Int, rows: Int) = manager.resizeTerminal(columns, rows)
    override fun resumeProject(project: String): Boolean = manager.resumeProject(project)
    override fun selectSession(id: String) = manager.selectSession(id)
    override fun startSession(project: String, agentId: String?) = manager.startSession(project, agentId)
    override fun uninstall() = manager.uninstall()
    override fun writeToTerminal(text: String) = manager.writeToTerminal(text)
    override val files: FileBrowserSource by lazy { BuildFileBrowser(context, paths) }
    override val state: StateFlow<KaiBuildState> get() = manager.state
    private val context: Context by inject(Context::class.java)
    private val installs by lazy { LinuxInstalls(context) }
    private val manager: BuildEnvironmentManager by lazy {
    private val paths: LinuxPaths by lazy { installs.pathsFor(LinuxDistro.DEBIAN) }
    private val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    }
actual fun createKaiBuildController(): KaiBuildController = AndroidKaiBuildController()
class AndroidKaiBuildController : KaiBuildController {
}
