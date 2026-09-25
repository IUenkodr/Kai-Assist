import androidx.compose.runtime.Immutable

            // pacman -Qq only gives names. We'll leave version empty 
            // pacman search format: "pkgname version"
            // unless we use -Qi which is too slow for a full list.
            PackageEntry(name, version = "") 
            PackageEntry(name, version)
            if (parts.size < 1) return@mapNotNull null
            val name = parts[0].trim()
            val parts = line.split(' ', limit = 2)
            val version = if (parts.size > 1) parts[1].trim() else ""
        .distinctBy { it.name }
        .filter { it.isNotEmpty() && !it.contains("No targets found") }
        .filter { it.isNotEmpty() }
        .map { it.trim() }
        .map { name -> 
        .mapNotNull { line ->
        .sortedBy { it.name.lowercase() }
        .toList()
        stderr.contains("error:") || stdout.contains("error:")
        }
    override fun countUpgraded(stdout: String): Int = 0 // Simplified for Arch
    override fun hasErrors(stdout: String, stderr: String): Boolean = 
    override fun installCommand(names: List<String>): String = "pacman -S --noconfirm ${shellQuoteAll(names)}"
    override fun parseInstalled(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun parseSearch(raw: String): List<PackageEntry> = raw.lineSequence()
    override fun removeCommand(name: String): String = "pacman -Rs --noconfirm ${shellQuote(name)}"
    override fun searchCommand(query: String, limit: Int): String = "pacman -Ss ${shellQuote(query)} | head -n $limit"
    override val listInstalledCommand = "pacman -Qq"
    override val updateCommand = "pacman -Sy"
    override val upgradeCommand = "pacman -Syu --noconfirm"
 * Arch Linux's `pacman`.
 */
/**
object PacmanPackageManager : PackageManagerSpec {
package com.inspiredandroid.kai.linux
}
