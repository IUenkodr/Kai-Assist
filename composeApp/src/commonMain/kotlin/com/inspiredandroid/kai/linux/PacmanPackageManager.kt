package com.inspiredandroid.kai.linux

import androidx.compose.runtime.Immutable

/**
 * Arch Linux's `pacman`.
 */
object PacmanPackageManager : PackageManagerSpec {

    override val listInstalledCommand = "pacman -Qq"

    override val updateCommand = "pacman -Sy"

    override val upgradeCommand = "pacman -Syu --noconfirm"

    override fun searchCommand(query: String, limit: Int): String = "pacman -Ss ${shellQuote(query)} | head -n $limit"

    override fun installCommand(names: List<String>): String = "pacman -S --noconfirm ${shellQuoteAll(names)}"

    override fun removeCommand(name: String): String = "pacman -Rs --noconfirm ${shellQuote(name)}"

    override fun parseInstalled(raw: String): List<PackageEntry> = raw.lineSequence()
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map { name -> 
            // pacman -Qq only gives names. We'll leave version empty 
            // unless we use -Qi which is too slow for a full list.
            PackageEntry(name, version = "") 
        }
        .sortedBy { it.name.lowercase() }
        .toList()

    override fun parseSearch(raw: String): List<PackageEntry> = raw.lineSequence()
        .filter { it.isNotEmpty() && !it.contains("No targets found") }
        .mapNotNull { line ->
            // pacman search format: "pkgname version"
            val parts = line.split(' ', limit = 2)
            if (parts.size < 1) return@mapNotNull null
            val name = parts[0].trim()
            val version = if (parts.size > 1) parts[1].trim() else ""
            PackageEntry(name, version)
        }
        .distinctBy { it.name }
        .toList()

    override fun hasErrors(stdout: String, stderr: String): Boolean = 
        stderr.contains("error:") || stdout.contains("error:")

    override fun countUpgraded(stdout: String): Int = 0 // Simplified for Arch
}
