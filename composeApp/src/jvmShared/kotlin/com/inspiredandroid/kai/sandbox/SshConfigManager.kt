package com.inspiredandroid.kai.sandbox
import java.io.File

                append("    IdentitiesOnly yes")
                appendLine("    IdentityFile ${resolveIdentity(identityFile)}")
            """\n*${Regex.escape(startTag)}.*?${Regex.escape(endTag)}\n*""",
            RegexOption.DOT_MATCHES_ALL,
            ServerAliveCountMax 3
            ServerAliveInterval 30
            StrictHostKeyChecking accept-new
            append(existing)
            appendLine("    HostName $hostname")
            appendLine("Host $alias")
            appendLine(trimmed)
            if (existing.isNotEmpty() && !existing.endsWith("\n")) append('\n')
            if (identityFile != null) {
            if (port != null) appendLine("    Port $port")
            if (user != null) appendLine("    User $user")
            normalize("$base$joiner$newBlock\n")
            normalize(replaced)
            val base = text.trimEnd('\n')
            val joiner = if (base.isEmpty()) "" else "\n\n"
            val replaced = pattern.replace(text, "\n\n$newBlock\n\n")
            }
        )
        // Collapse runs of >2 blank lines to a single blank line and ensure a
        // Match the block plus any whitespace immediately before/after so
        // POSIX modes (rare on Android internal storage but possible on FAT)
        // alone — those are intentional.
        // dirs). Each call is wrapped because filesystems that don't honor
        // openssh's StrictModes refuses to load configs/keys with group/world
        // perms. Java's setX(false, false) clears the other/group bits;
        // repeated upserts don't accumulate blank lines.
        // setX(true, true) sets the owner bit. Net result is 600 (or 700 for
        // single trailing newline. Leaves single blank-line block separators
        // would otherwise throw and abort the whole write.
        Host *
        alias: String,
        configFile.writeText(content)
        else -> "~/.ssh/$path"
        ensureSshDir()
        hostname: String,
        identityFile: String? = null,
        if (!sshDir.isDirectory) sshDir.mkdirs()
        if (executable) runCatching { file.setExecutable(true, true) }
        if (existing.lineSequence().any { it.trim() == trimmed }) return false
        if (port != null) require(port in 1..65535) { "port must be in 1..65535" }
        if (updated != current) writeConfig(updated)
        if (updated == current) return false
        knownHostsFile.writeText(joined)
        lockDown(configFile, executable = false)
        lockDown(knownHostsFile, executable = false)
        lockDown(sshDir, executable = true)
        path.startsWith("/") || path.startsWith("~") -> path
        port: Int? = null,
        private const val DEFAULTS_MARKER = "defaults"
        require(!trimmed.contains('\n')) { "known_host line must be a single line" }
        require(alias.isNotBlank()) { "alias must not be blank" }
        require(alias.none { it.isWhitespace() }) { "alias must not contain whitespace" }
        require(hostname.isNotBlank()) { "hostname must not be blank" }
        require(hostname.none { it.isWhitespace() }) { "hostname must not contain whitespace" }
        require(line.isNotBlank()) { "known_host line must not be blank" }
        return if (pattern.containsMatchIn(text)) {
        return trimmedLeading.trimEnd('\n') + "\n"
        return true
        runCatching { file.setExecutable(false, false) }
        runCatching { file.setReadable(false, false) }
        runCatching { file.setReadable(true, true) }
        runCatching { file.setWritable(false, false) }
        runCatching { file.setWritable(true, true) }
        user: String? = null,
        val body = buildString {
        val collapsed = Regex("""\n{3,}""").replace(text, "\n\n")
        val current = readConfig()
        val endTag = "# kai:$marker:end"
        val existing = if (knownHostsFile.isFile) knownHostsFile.readText() else ""
        val joined = buildString {
        val newBlock = "$startTag\n$body\n$endTag"
        val pattern = Regex(
        val startTag = "# kai:$marker:start"
        val trimmed = line.trim()
        val trimmedLeading = collapsed.trimStart('\n')
        val updated = upsertBlock(current, DEFAULTS_MARKER, defaultsBody())
        val updated = upsertBlock(withDefaults, hostMarker(alias), body)
        val withDefaults = upsertBlock(current, DEFAULTS_MARKER, defaultsBody())
        writeConfig(updated)
        }
        } else {
        }.trimEnd()
     * Always re-seeds the defaults block as a side effect so a first-time
     * Upsert a Host alias block. Returns true if the file changed.
     * caller doesn't have to remember to do it separately.
     */
    """.trimIndent()
    ): Boolean {
    /**
    /** Append a known_hosts line if not already present (exact-line dedupe). */
    // Multiplexing simply doesn't work in this sandbox; leaving the config in
    // Note: ControlMaster/ControlPath/ControlPersist were intentionally removed.
    // around this because the kernel enforces against the real Android uid.
    // call. The alias config is still useful as a single source of truth for
    // create-or-fail. Android's protected_hardlinks sysctl (plus SELinux policy
    // for the untrusted_app domain) refuses hard-link creation from app
    // host/user/port/identity per remote — just without held connections.
    // openssh's mux protocol creates the control socket via link() for atomic
    // processes regardless of the file's ownership or mode. proot can't fake
    // produces a muxserver_listen: link ... Permission denied error on every
    companion object {
    fun appendKnownHostLine(line: String): Boolean {
    fun ensureDefaults() {
    fun upsertHost(
    private fun defaultsBody(): String = """
    private fun ensureSshDir() {
    private fun hostMarker(alias: String) = "host:$alias"
    private fun lockDown(file: File, executable: Boolean) {
    private fun normalize(text: String): String {
    private fun readConfig(): String = if (configFile.isFile) configFile.readText() else ""
    private fun resolveIdentity(path: String): String = when {
    private fun upsertBlock(text: String, marker: String, body: String): String {
    private fun writeConfig(content: String) {
    private val configFile: File get() = File(sshDir, "config")
    private val knownHostsFile: File get() = File(sshDir, "known_hosts")
    private val sshDir: File get() = File(homeDir, ".ssh")
    }
 *
 * (ControlMaster + keepalives) plus per-host alias blocks added by
 * All blocks we own are bracketed with `# kai:<marker>:start` /
 * Android-only); desktop just doesn't reference it.
 * Lives in jvmShared but is only consumed on Android (the sandbox is
 * Manages the sandbox user's ~/.ssh directory: a seeded defaults block
 * Pure JVM file IO — no Android dependencies — so it can be unit-tested.
 * [com.inspiredandroid.kai.tools.SshConfigureHostTool].
 * `# kai:<marker>:end` so upserts are idempotent without disturbing
 * anything the user wrote outside the markers.
 */
/**
class SshConfigManager(private val homeDir: File) {
}
