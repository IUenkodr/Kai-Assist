package com.inspiredandroid.kai.linux

object PacmanPackageManager : PackageManagerSpec {
    override val listInstalledCommand: String = "pacman -Qq"
    override val updateCommand: String = "pacman -Sy"
    override val upgradeCommand: String = "pacman -Syu --noconfirm"

    override fun installCommand(names: List<String>): String =
        "pacman -S --noconfirm ${shellQuoteAll(names)}"

    override fun removeCommand(name: String): String =
        "pacman -Rs --noconfirm ${shellQuote(name)}"

    override fun searchCommand(query: String, limit: Int): String =
        "pacman -Ss ${shellQuote(query)} | head -n $limit"

    override fun countUpgraded(stdout: String): Int = 0

    override fun hasErrors(stdout: String, stderr: String): Boolean =
        stderr.contains("error:", ignoreCase = true) ||
            stdout.contains("error:", ignoreCase = true)

    override fun parseInstalled(raw: String): List<PackageEntry> =
        raw.lineSequence()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { PackageEntry(name = it, version = "") }
            .distinctBy { it.name }
            .sortedBy { it.name.lowercase() }
            .toList()

    override fun parseSearch(raw: String): List<PackageEntry> =
        raw.lineSequence()
            .mapNotNull { line ->
                val parts = line.trim().split(' ', limit = 2)
                if (parts.isEmpty() || parts[0].isEmpty()) {
                    null
                } else {
                    PackageEntry(
                        name = parts[0],
                        version = parts.getOrNull(1)?.trim().orEmpty()
                    )
                }
            }
            .filter { it.name != "No targets found" }
            .distinctBy { it.name }
            .sortedBy { it.name.lowercase() }
            .toList()
}
