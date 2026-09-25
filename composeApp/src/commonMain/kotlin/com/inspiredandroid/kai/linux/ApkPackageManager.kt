
                break
                splitAt = i - 1
            if (withoutRev[i - 1] == '-' && withoutRev[i].isDigit()) {
            parseNameVersion(nameVer)?.let { (n, v) -> PackageEntry(n, v, description?.takeIf { it.isNotEmpty() }) }
            return if (revision.isNotEmpty()) withoutRev to revision.trimStart('-') else s to ""
            val description = if (sepIdx >= 0) line.substring(sepIdx + 3).trim() else null
            val nameVer = if (sepIdx >= 0) line.substring(0, sepIdx) else line
            val sepIdx = line.indexOf(" - ")
            }
        .count { UPGRADE_PROGRESS_LINE.containsMatchIn(it) }
        .distinctBy { "${it.name}@${it.version}" }
        .filter { it.isNotEmpty() && !it.startsWith("WARNING:") && !it.startsWith("ERROR:") }
        .map { it.trim() }
        .mapNotNull { line ->
        .mapNotNull { line -> parseNameVersion(line)?.let { PackageEntry(it.first, it.second) } }
        .toList()
        for (i in withoutRev.length - 1 downTo 1) {
        if (name.isEmpty()) return null
        if (s.isEmpty()) return null
        if (splitAt < 0) {
        return name to version
        stderr.lineSequence().any { it.startsWith("ERROR:") }
        val name = withoutRev.substring(0, splitAt)
        val revision = ALPINE_REVISION_SUFFIX.find(s)?.value.orEmpty()
        val version = withoutRev.substring(splitAt + 1) + revision
        val withoutRev = if (revision.isNotEmpty()) s.dropLast(revision.length) else s
        var splitAt = -1
        }
    // *last* `-<digit>` boundary — that's the version, anything before it is name.
    // Alpine package idents are `<name>-<version>-r<rev>`, but names themselves
    // No matches → nothing was actually upgraded (e.g. system already up to date).
    // Strategy: peel off the trailing `-r<digits>` revision, then split at the
    // apk upgrade emits one progress line per package: `(N/M) Upgrading <pkg> (...)`.
    // apk's exit code is polluted by a cumulative DB error count under proot, and
    // can contain hyphen-digit segments (e.g. `webkit2gtk-4.1`, `glib-2.0`).
    // per-run failure. Only the "ERROR:" prefix marks a real one.
    // the lowercase "errors" in its summary line is that same count rather than a
    override fun countUpgraded(stdout: String): Int = stdout.lineSequence()
    override fun hasErrors(stdout: String, stderr: String): Boolean = stdout.lineSequence().any { it.startsWith("ERROR:") } ||
    override fun installCommand(names: List<String>): String = "apk add --no-cache ${shellQuoteAll(names)}"
    override fun parseInstalled(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun parseSearch(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun removeCommand(name: String): String = "apk del ${shellQuote(name)}"
    override fun searchCommand(query: String, limit: Int): String = "apk search -v ${shellQuote(query)} | head -n $limit"
    override val listInstalledCommand = "apk info -v | sort"
    override val updateCommand = "apk update"
    override val upgradeCommand = "apk upgrade"
    private fun parseNameVersion(s: String): Pair<String, String>? {
    }
/** Alpine's `apk`. */
object ApkPackageManager : PackageManagerSpec {
package com.inspiredandroid.kai.linux
private val ALPINE_REVISION_SUFFIX = Regex("-r\\d+$")
private val UPGRADE_PROGRESS_LINE = Regex("""^\(\d+/\d+\)\s+Upgrading\s""")
}
