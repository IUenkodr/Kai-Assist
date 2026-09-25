import com.inspiredandroid.kai.SandboxSessions
import com.inspiredandroid.kai.data.currentConversationIdOrNull
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import com.inspiredandroid.kai.sandbox.SandboxState
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_execute_shell_command_description
import kai.composeapp.generated.resources.tool_execute_shell_command_name
import org.koin.java.KoinJavaComponent.inject

                append("cd ").append(shellSingleQuote(workingDir)).append(" && ")
                append(shellSingleQuote(k)).append('=').append(shellSingleQuote(v)).append(' ')
                command,
                envMap,
                timeoutSeconds,
                workingDir ?: "/root",
            "background" to ParameterSchema("boolean", "Run detached as a background job. Returns a session_id; use manage_process to check status. Does not share the persistent shell.", false),
            "command" to ParameterSchema("string", "The shell command to execute", true),
            "env" to ParameterSchema("object", "Per-command environment variable overrides. Scoped to this call only; does not persist (use 'export' inside the command if you want persistence).", false),
            "fresh" to ParameterSchema("boolean", "If true, run in a one-shot isolated shell that does not share state with the persistent session. Default false.", false),
            "timeout" to ParameterSchema("integer", "Timeout in seconds (default 30, max 60)", false),
            "working_dir" to ParameterSchema("string", "If set, run the command starting in this directory (cd <dir> && <command>). The cd persists for subsequent calls — same as if the user had run cd themselves.", false),
            )
            .coerceIn(1, 60L)
            ?.mapValues { it.value.toString() }
            ?: emptyMap()
            ?: return mapOf("success" to false, "error" to "Command is required")
            command = wrapped,
            displayCommand = command,
            envMap.forEach { (k, v) ->
            if (workingDir != null) {
            return ProcessManagerTool.processManager.startBackground(
            return executor.execute(command, timeoutSeconds, workingDir ?: "/root", envMap)
            return mapOf("success" to false, "error" to "Linux sandbox is not installed. Set it up in Settings > Tools.")
            timeoutSeconds = timeoutSeconds,
            val executor = sandboxManager.createProotExecutor()
            }
        )
        ),
        // Apply env as a per-command prefix (FOO=bar BAR=baz user_command) so
        // Availability follows Settings → Agent → Linux sandbox plus the sandbox being
        // Pass the unwrapped command as displayCommand so the Terminal UI shows
        // Persistent shell path. Each conversation gets its own bash session so
        // Ready, so a per-tool switch here would read back a setting nothing consults.
        // a shared default session.
        // another. Tools invoked outside a conversation context fall through to
        // state from one chat (cwd, exports, ssh-agent, &-jobs) doesn't leak into
        // the LLM is told that's the case in the tool description.
        // the env doesn't bleed into the session. cd is intentionally persistent:
        // what the agent asked for, not the cd/env scaffolding we add.
        description = "Execute a shell command in the Linux sandbox",
        description = toolDescription(sandboxManager.distro),
        descriptionRes = Res.string.tool_execute_shell_command_description,
        id = "execute_shell_command",
        if (background) {
        if (fresh) {
        if (sandboxManager.state.value !is SandboxState.Ready) {
        isEnabled = false,
        name = "Execute Shell Command",
        name = "execute_shell_command",
        nameRes = Res.string.tool_execute_shell_command_name,
        parameters = mapOf(
        return sandboxManager.shellFor(sessionId).run(
        userToggleable = false,
        val background = args["background"] as? Boolean ?: false
        val command = args["command"] as? String
        val envMap = (args["env"] as? Map<String, Any>)
        val fresh = args["fresh"] as? Boolean ?: false
        val prefix = buildString {
        val sessionId = currentConversationIdOrNull() ?: SandboxSessions.DEFAULT
        val timeoutSeconds = ((args["timeout"] as? Number)?.toLong() ?: 30L)
        val workingDir = args["working_dir"] as? String
        val wrapped = if (prefix.isEmpty()) command else "$prefix$command"
        }
    )
    // A getter, not a stored value: the schema is read when tools are advertised,
    // by which point the installed distro is known (and can have changed since).
    @Suppress("UNCHECKED_CAST")
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema: ToolSchema get() = ToolSchema(
    private fun shellSingleQuote(value: String): String = "'" + value.replace("'", "'\\''") + "'"
    private val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    return """Execute a shell command in a ${distro.displayName} sandbox and return stdout, stderr, exit code, and current working directory. The environment is a full ${distro.displayName} system running via proot.
    val install = distro.packageManager.installCommand("<package>")
    val toolInfo = ToolInfo(
    }
 * Built per distro rather than patched afterwards: the package manager and the
 * distro's name appear in several places, and a model that is told "Alpine" and
 * then handed a Debian rootfs wastes turns on `apk` commands that do not exist.
 */
- Default timeout: 30s, max: 60s. Long-running interactive commands (e.g. ssh sessions held across messages) work because the shell is persistent — but a SINGLE call still hits the timeout if it doesn't return.
- Fullscreen TUIs (top, htop, vim, less, nano, anything ncurses) WILL NOT WORK — the sandbox has no PTY. Use non-interactive variants: "top -bn1" for a one-shot snapshot, "ps aux" for processes, redirect editor output, etc.
- Output is capped at 15000 characters per stream; for large output, pipe through head/tail.
- Set background=true to run a long-lived process detached from the shell (writes to its own session_id). Use manage_process to check on it.
- Set fresh=true to run in a one-shot isolated shell that doesn't share state with the persistent session. Useful when you specifically want isolation; rarely needed.
/**
For SSH workflows: prefer the ssh_configure_host tool once per remote — it writes ~/.ssh/config so subsequent calls don't have to repeat host/user/port/identity flags. After registering, invoke ssh BY THE ALIAS: `ssh myalias 'cmd'`, `scp file myalias:`, `sftp myalias`. The whole point of the config is to feed the alias; bypassing it with `user@host` discards every setting the tool just wrote.
Install extra packages with: $install
Limits and behavior:
Note: SSH multiplexing (ControlMaster) is intentionally NOT enabled — Android's kernel-level link() restriction prevents openssh from creating its control socket inside this sandbox. Each ssh call does a full TCP+auth handshake. That is the correct, expected behavior here; do not try to force it back on with -o ControlMaster=auto or by writing your own ControlPath — it will produce a muxserver_listen Permission denied error.
Password-only servers (no key auth): this shell can't answer interactive password prompts directly (no PTY, ssh reads from /dev/tty). Heredoc stdin will NOT deliver a password. Install sshpass once with `${distro.packageManager.installCommand("sshpass")}`, then drive the connection as `sshpass -p '<password>' ssh <alias> '<remote-cmd>'` — or `sshpass -f <password-file> ssh <alias>` to keep the password off the command line. sshpass fakes a PTY internally, which is the only path that actually works.
Pre-installed: ${distro.basePackages.joinToString(", ")}. Optional bundle (installed from Settings): ${distro.optionalPackages.joinToString(", ")} — that covers remote-server tools ssh, scp, sftp, lftp (FTP/FTPS) and rsync. Use them directly, e.g. "ssh user@host 'remote command'", "sftp user@host", "lftp -c 'open ftp://...; put file'". Authentication state (~/.ssh keys, known_hosts) persists.
Shell session is PERSISTENT across calls within THIS conversation: cwd, exported environment variables, and any in-shell state carry from one call to the next, just like a normal terminal. So "cd /tmp" in one call, then "pwd" in the next, returns "/tmp". You do NOT need to chain "cd dir && command" unless you want directory changes to be one-shot. Other conversations and the in-app Terminal tab each have their own isolated shells; the rootfs and /root are still shared on disk, so files persist across all of them.
To show a file you produced in /root to the user, call open_file with the path relative to /root (e.g. open_file path="page.html"). File needs to be self-contained."""
object ShellCommandTool : Tool {
package com.inspiredandroid.kai.tools
private fun toolDescription(distro: LinuxDistro): String {
}
