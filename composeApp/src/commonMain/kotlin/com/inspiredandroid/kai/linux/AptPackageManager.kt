
            PackageEntry(name, parts[2].trim())
            PackageEntry(name, version = "", description = description?.takeIf { it.isNotEmpty() })
            if (name.isEmpty() || name.contains(' ')) return@mapNotNull null
            if (name.isEmpty()) return@mapNotNull null
            if (parts.size < 3) return@mapNotNull null
            if (parts[0].trim() != STATUS_INSTALLED) return@mapNotNull null
            val description = if (sepIdx >= 0) line.substring(sepIdx + 3).trim() else null
            val name = (if (sepIdx >= 0) line.substring(0, sepIdx) else line).trim()
            val name = parts[1].trim()
            val parts = line.split('\t')
            val sepIdx = line.indexOf(" - ")
        .distinctBy { "${it.name}@${it.version}" }
        .distinctBy { it.name }
        .filter { it.isNotEmpty() && !it.startsWith("E:") && !it.startsWith("W:") }
        .firstNotNullOfOrNull { line -> UPGRADE_SUMMARY.find(line)?.groupValues?.get(1)?.toIntOrNull() }
        .map { it.trim() }
        .mapNotNull { line ->
        .sortedBy { it.name.lowercase() }
        .toList()
        ?: 0
        stderr.lineSequence().any { it.startsWith("E:") }
        }
    """${'$'}{db:Status-Abbrev}\t${'$'}{Package}\t${'$'}{Version}\n"""
    // --no-install-recommends keeps a phone-sized rootfs from pulling in docs,
    // Packages list renders a blank version as no version at all, and the install
    // X11 and systemd dependencies it can never use.
    // `apt-cache search` prints `name - short description` and no version. The
    // action only needs the name.
    // apt marks real failures with an `E:` prefix. `W:` warnings (unsigned repo,
    // missing translation index) are routine inside a proot rootfs.
    override fun countUpgraded(stdout: String): Int = stdout.lineSequence()
    override fun hasErrors(stdout: String, stderr: String): Boolean = stdout.lineSequence().any { it.startsWith("E:") } ||
    override fun installCommand(names: List<String>): String = "apt-get install -y --no-install-recommends ${shellQuoteAll(names)}"
    override fun parseInstalled(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun parseSearch(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun removeCommand(name: String): String = "apt-get remove -y ${shellQuote(name)}"
    override fun searchCommand(query: String, limit: Int): String = "apt-cache search ${shellQuote(query)} | head -n $limit"
    override val listInstalledCommand = "dpkg-query -W -f='$DPKG_FORMAT' 2>/dev/null"
    override val updateCommand = "apt-get update -y"
    override val upgradeCommand = "apt-get upgrade -y"
 * `${db:Status-Abbrev}` is dpkg's two-letter want/state pair (plus a padding
 * character), which is the only way to tell a really-installed package from one
 * that was removed with its config files left behind — `dpkg-query -W` lists both.
 */
/**
/** Installed and configured. Anything else (`rc`, `iU`, …) is not usable. */
/** `N upgraded, M newly installed, K to remove and L not upgraded.` */
object AptPackageManager : PackageManagerSpec {
package com.inspiredandroid.kai.linux
private const val DPKG_FORMAT =
private const val STATUS_INSTALLED = "ii"
private val UPGRADE_SUMMARY = Regex("""(\d+)\s+upgraded""")
}
