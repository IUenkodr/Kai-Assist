import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import com.inspiredandroid.kai.sandbox.SandboxState
import com.inspiredandroid.kai.sandbox.SshConfigManager
import java.io.File
import org.koin.java.KoinJavaComponent.inject

                "DNS name or IP of the remote machine.",
                "Optional single line appended to ~/.ssh/known_hosts. Typically the output of `ssh-keyscan -t ed25519 <host>`. Deduplicated by exact-line match.",
                "Path to the private key inside the sandbox. Relative names resolve under ~/.ssh (e.g. 'my-vps_id' → ~/.ssh/my-vps_id); absolute paths and ~-paths pass through. The file is not created by this tool.",
                "SSH port. Omit for 22.",
                "SSH user. Omit to fall back to the openssh default (current user inside the sandbox).",
                "Short name used to invoke this host (e.g. 'prod', 'my-vps'). Must contain no whitespace.",
                "alias" to alias,
                "config_changed" to configChanged,
                "error" to "Linux sandbox is not installed. Set it up in Settings > Tools.",
                "example" to "ssh $alias",
                "integer",
                "known_hosts_changed" to knownHostsChanged,
                "string",
                "success" to false,
                "success" to true,
                false,
                true,
            "alias" to ParameterSchema(
            "hostname" to ParameterSchema(
            "identity_file" to ParameterSchema(
            "known_host_line" to ParameterSchema(
            "port" to ParameterSchema(
            "user" to ParameterSchema(
            )
            ),
            ?: return mapOf("success" to false, "error" to "alias is required")
            ?: return mapOf("success" to false, "error" to "hostname is required")
            mapOf(
            mapOf("success" to false, "error" to "Failed to write ssh config: ${e.message}")
            mapOf("success" to false, "error" to (e.message ?: "Invalid argument"))
            return mapOf(
            val configChanged = manager.upsertHost(alias, hostname, user, port, identityFile)
            val knownHostsChanged = knownHostLine?.let { manager.appendKnownHostLine(it) } ?: false
        ),
        // Availability follows Settings → Agent → Linux sandbox plus the sandbox being
        // Ready, so a per-tool switch here would read back a setting nothing consults.
        description = "Register a named SSH host for the Linux sandbox",
        description = toolDescription(sandboxManager.distro),
        descriptionRes = null,
        id = "ssh_configure_host",
        if (sandboxManager.state.value !is SandboxState.Ready) {
        isEnabled = false,
        name = "Configure SSH Host",
        name = "ssh_configure_host",
        nameRes = null,
        parameters = mapOf(
        return try {
        userToggleable = false,
        val alias = (args["alias"] as? String)?.trim()?.takeIf { it.isNotEmpty() }
        val hostname = (args["hostname"] as? String)?.trim()?.takeIf { it.isNotEmpty() }
        val identityFile = (args["identity_file"] as? String)?.trim()?.takeIf { it.isNotEmpty() }
        val knownHostLine = (args["known_host_line"] as? String)?.trim()?.takeIf { it.isNotEmpty() }
        val manager = SshConfigManager(File(sandboxManager.homePath))
        val port = (args["port"] as? Number)?.toInt()
        val user = (args["user"] as? String)?.trim()?.takeIf { it.isNotEmpty() }
        }
        } catch (e: Exception) {
        } catch (e: IllegalArgumentException) {
    )
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema: ToolSchema get() = ToolSchema(
    private val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    return """Register a named SSH host alias in the Linux sandbox so subsequent execute_shell_command calls can run `ssh <alias>` instead of repeating user/host/port/identity flags every time.
    val installSshpass = distro.packageManager.installCommand("sshpass")
    val toolInfo = ToolInfo(
    }
- Defaults block at the top of the config on first use: ServerAliveInterval + ServerAliveCountMax (keep idle TCP connections alive through NAT) and StrictHostKeyChecking=accept-new (auto-accept new host keys into ~/.ssh/known_hosts on first connect, but still reject changed keys — sane TOFU without an interactive prompt this shell can't answer).
- Optionally appends a line to ~/.ssh/known_hosts to skip the first-connect TOFU step entirely.
- `scp file myalias:`
- `sftp myalias`
- `ssh myalias 'remote cmd'`
- ~/.ssh/config: a Host block for the alias. Calling again with the same alias replaces the previous block (idempotent).
After configuring, drive ssh from execute_shell_command:
Auth, port, identity all come from the config block — no flags needed. ALWAYS invoke by the alias, never `user@hostname`; bypassing the alias bypasses every setting this tool just wrote."""
Connection persistence ("held connections") is NOT available — openssh's ControlMaster multiplexing requires the link() syscall to create its control socket, and Android blocks link() for app processes regardless of file ownership. Each ssh call does a full handshake. Don't fight this; don't try to seed your own ControlPath.
Password-only remotes: openssh inside this sandbox can't field interactive password prompts on its own (no PTY; ssh reads from /dev/tty, not stdin, so heredoc fallback does not work). Install sshpass once (`$installSshpass` via execute_shell_command) and invoke as `sshpass -p '<password>' ssh <alias> '<remote-cmd>'`, or `sshpass -f <file> ssh <alias>` to keep the password out of the command line. sshpass fakes a PTY internally, which is the only path that actually delivers a password.
This tool does NOT create or upload private keys. To make a key usable, the user must place it under ~/.ssh in the sandbox separately. Be aware that any key text passed through chat (including via execute_shell_command's `cat > ~/.ssh/id_x <<EOF ...`) goes to the model provider in cleartext — ask the user before doing that.
What this writes inside the sandbox:
object SshConfigureHostTool : Tool {
package com.inspiredandroid.kai.tools
private fun toolDescription(distro: LinuxDistro): String {
}
