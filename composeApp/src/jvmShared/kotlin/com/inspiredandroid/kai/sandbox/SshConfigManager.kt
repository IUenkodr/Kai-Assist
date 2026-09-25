package com.inspiredandroid.kai.sandbox

import java.io.File

/**
 * Manages the sandbox user's ~/.ssh directory.
 *
 * All generated blocks are delimited by Kai markers so they can be
 * updated without modifying user-owned configuration.
 */
class SshConfigManager(
    private val homeDir: File,
) {
    private val sshDir: File
        get() = File(homeDir, ".ssh")

    private val configFile: File
        get() = File(sshDir, "config")

    private val knownHostsFile: File
        get() = File(sshDir, "known_hosts")

    fun ensureDefaults() {
        ensureSshDir()

        val updated = upsertBlock(
            text = readConfig(),
            marker = DEFAULTS_MARKER,
            body = defaultsBody(),
        )

        if (updated != readConfig()) {
            writeConfig(updated)
        }
    }

    fun upsertHost(
        alias: String,
        hostname: String,
        user: String? = null,
        port: Int? = null,
        identityFile: String? = null,
    ): Boolean {
        require(alias.isNotBlank()) { "alias must not be blank" }
        require(alias.none(Char::isWhitespace)) {
            "alias must not contain whitespace"
        }
        require(hostname.isNotBlank()) { "hostname must not be blank" }
        require(hostname.none(Char::isWhitespace)) {
            "hostname must not contain whitespace"
        }
        if (port != null) {
            require(port in 1..65535) {
                "port must be in 1..65535"
            }
        }

        ensureSshDir()

        val body = buildString {
            appendLine("HostName $hostname")
            user?.let { appendLine("User $it") }
            port?.let { appendLine("Port $it") }
            identityFile?.let {
                appendLine("IdentitiesOnly yes")
                appendLine("IdentityFile ${resolveIdentity(it)}")
            }
        }.trimEnd()

        val current = readConfig()
        val withDefaults = upsertBlock(
            text = current,
            marker = DEFAULTS_MARKER,
            body = defaultsBody(),
        )
        val updated = upsertBlock(
            text = withDefaults,
            marker = "host:$alias",
            body = body,
            header = "Host $alias",
        )

        if (updated == current) return false

        writeConfig(updated)
        return true
    }

    fun appendKnownHostLine(line: String): Boolean {
        val trimmed = line.trim()
        require(trimmed.isNotBlank()) {
            "known_host line must not be blank"
        }
        require('\n' !in trimmed) {
            "known_host line must be a single line"
        }

        ensureSshDir()

        val existing = if (knownHostsFile.isFile) {
            knownHostsFile.readText()
        } else {
            ""
        }

        if (existing.lineSequence().any { it.trim() == trimmed }) {
            return false
        }

        val updated = buildString {
            append(existing.trimEnd())
            if (isNotEmpty()) append('\n')
            appendLine(trimmed)
        }

        knownHostsFile.writeText(updated)
        lockDown(knownHostsFile)
        return true
    }

    private fun defaultsBody(): String = """
        ServerAliveInterval 30
        ServerAliveCountMax 3
        StrictHostKeyChecking accept-new
    """.trimIndent()

    private fun upsertBlock(
        text: String,
        marker: String,
        body: String,
        header: String? = null,
    ): String {
        val startTag = "# kai:$marker:start"
        val endTag = "# kai:$marker:end"
        val newBlock = buildString {
            appendLine(startTag)
            header?.let { appendLine(it) }
            appendLine(body)
            append(endTag)
        }

        val pattern = Regex(
            """(?ms)^[ \t]*${Regex.escape(startTag)}.*?^[ \t]*${Regex.escape(endTag)}[ \t]*\n?"""
        )

        val result = if (pattern.containsMatchIn(text)) {
            pattern.replace(text, "$newBlock\n")
        } else {
            val base = text.trimEnd()
            if (base.isEmpty()) newBlock else "$base\n\n$newBlock\n"
        }

        return result
            .replace(Regex("""\n{3,}"""), "\n\n")
            .trimEnd() + "\n"
    }

    private fun readConfig(): String =
        if (configFile.isFile) configFile.readText() else ""

    private fun writeConfig(content: String) {
        ensureSshDir()
        configFile.writeText(content)
        lockDown(configFile)
        lockDown(sshDir, executable = true)
    }

    private fun resolveIdentity(path: String): String =
        when {
            path.startsWith("/") || path.startsWith("~") -> path
            else -> "~/.ssh/$path"
        }

    private fun ensureSshDir() {
        if (!sshDir.isDirectory) {
            sshDir.mkdirs()
        }
        lockDown(sshDir, executable = true)
    }

    private fun lockDown(
        file: File,
        executable: Boolean = false,
    ) {
        file.setReadable(false, false)
        file.setWritable(false, false)
        file.setExecutable(false, false)

        file.setReadable(true, true)
        file.setWritable(true, true)
        if (executable) file.setExecutable(true, true)
    }

    private companion object {
        const val DEFAULTS_MARKER = "defaults"
    }
}
