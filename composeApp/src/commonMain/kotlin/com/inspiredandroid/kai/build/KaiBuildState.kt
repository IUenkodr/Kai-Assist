package com.inspiredandroid.kai.build
import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.build.terminal.TerminalSnapshot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf

        val agentId: String? = null,
        val progress: Float? = null,
        val step: BuildStep,
    ) : BuildEnvironmentState
    /** Bytes taken by the Debian rootfs itself. */
    /** Bytes taken by the project folders (kept when Linux is uninstalled). */
    /** Folder names under the Linux home's `projects` directory. */
    /** Last install failure, in shell/English wording — cleared when work restarts. */
    /** Linux architecture name of the rootfs (arm64, amd64, …). */
    /** Live shells, oldest first. Sessions of every open project, not just the visible one. */
    /** Null until Debian is installed and its facts have been read. */
    /** [progress] is null while a step has no measurable progress. */
    /** e.g. "Debian GNU/Linux 12 (bookworm)". */
    Agent,
    BasePackages,
    Configure,
    Download,
    Extract,
    data class Installing(
    data object NotInstalled : BuildEnvironmentState
    data object Ready : BuildEnvironmentState
    val activeSession: BuildTerminalSession? get() = sessions.firstOrNull { it.id == activeSessionId }
    val activeSessionId: String? = null,
    val agentId: String?,
    val architecture: String,
    val busy: Boolean = false,
    val distribution: String,
    val environment: BuildEnvironmentState = BuildEnvironmentState.NotInstalled,
    val freeBytes: Long,
    val id: String,
    val installedAgents: ImmutableSet<String> = persistentSetOf(),
    val isInstalling: Boolean get() = environment is BuildEnvironmentState.Installing
    val isReady: Boolean get() = environment is BuildEnvironmentState.Ready
    val lastError: String? = null,
    val number: Int,
    val packageCount: Int,
    val project: String,
    val projects: ImmutableList<String> = persistentListOf(),
    val projectsBytes: Long,
    val sessions: ImmutableList<BuildTerminalSession> = persistentListOf(),
    val systemBytes: Long,
    val systemInfo: BuildSystemInfo? = null,
    val terminal: TerminalSnapshot = TerminalSnapshot.blank(),
 * One live shell inside a project — a tab in the terminal's session strip.
 * [agentId] is null for a plain shell; [number] disambiguates same-kind tabs.
 */
)
) {
/**
/** Everything the Kai Build screen renders, in one snapshot. */
/** Ordered steps of a Kai Build install, shown as progress on the setup screen. */
/** What the installed Debian actually is, shown on the project list. */
@Immutable
data class BuildSystemInfo(
data class BuildTerminalSession(
data class KaiBuildState(
enum class BuildStep {
sealed interface BuildEnvironmentState {
}
