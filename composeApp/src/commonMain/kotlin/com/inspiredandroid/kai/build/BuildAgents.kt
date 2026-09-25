package com.inspiredandroid.kai.build
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

            binary = "claude",
            binary = "grok",
            binary = "opencode",
            id = "claude-code",
            id = "grok",
            id = "opencode",
            installCommand = "curl -fsSL https://claude.ai/install.sh | bash",
            installCommand = "curl -fsSL https://opencode.ai/install | bash",
            installCommand = "curl -fsSL https://x.ai/cli/install.sh | bash",
            title = "Claude Code",
            title = "Grok",
            title = "OpenCode",
        ),
        BuildAgent(
    )
    /** Product name — shown as-is, not translated. */
    fun get(id: String?): BuildAgent? = all.firstOrNull { it.id == id }
    val all: ImmutableList<BuildAgent> = persistentListOf(
    val binary: String,
    val id: String,
    val installCommand: String,
    val title: String,
 *
 * - Claude → `~/.local/bin/claude` (versioned under `~/.local/share/claude/versions/`)
 * - Grok → `~/.grok/bin/grok`
 * - OpenCode → `~/.opencode/bin/opencode`
 * Install locations (guest paths under `/root`):
 * Proot injects all three bin dirs into PATH for probes/installers. Login
 * The coding agents Kai Build can install on a fresh Debian. Each one ships a
 * profile.d snippet and launches agents by absolute path.
 * self-contained installer, so the base system plus curl is all they need.
 * shells rebuild PATH from profile files, so Kai Build also writes a
 */
)
/**
@Immutable
data class BuildAgent(
object BuildAgents {
}
