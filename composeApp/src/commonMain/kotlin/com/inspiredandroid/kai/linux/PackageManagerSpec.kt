package com.inspiredandroid.kai.linux
import androidx.compose.runtime.Immutable

     * Installs [names] in one call, each a separate shell argument. apt resolves
     * a whole set at once, which is both faster and the only way its dependency
     * solver sees the full picture.
     */
    /**
    /** How many packages [upgradeCommand] actually replaced. */
    /** Prints one installed package per line for [parseInstalled]. */
    /** Refreshes the package index. Safe to run repeatedly. */
    /** Searches names *and* descriptions, capped at [limit] lines, for [parseSearch]. */
    /** True when the streams carry a real failure rather than routine noise. */
    /** Upgrades every installed package. Assumes [updateCommand] ran first. */
    fun countUpgraded(stdout: String): Int
    fun hasErrors(stdout: String, stderr: String): Boolean
    fun installCommand(name: String): String = installCommand(listOf(name))
    fun installCommand(names: List<String>): String
    fun parseInstalled(raw: String): List<PackageEntry>
    fun parseSearch(raw: String): List<PackageEntry>
    fun removeCommand(name: String): String
    fun searchCommand(query: String, limit: Int): String
    val description: String? = null,
    val listInstalledCommand: String
    val name: String,
    val updateCommand: String
    val upgradeCommand: String
    val version: String,
 *
 * Everything that differs between `apk` and `apt` when the Packages tab, the
 * Exit codes are deliberately not part of this contract — under proot both
 * Quotes each of [names] separately. Quoting the joined string instead would
 * callers verify by re-reading the installed list or by [hasErrors].
 * can only fail to locate.
 * commands to run and how to read what they printed.
 * hand the package manager one argument whose name contains spaces, which it
 * package managers return codes that do not mean what they normally mean, so
 * sandbox installer and the Kai Build installer drive a package manager: the
 */
)
/**
/** Single-quotes [s] for `sh -c`, escaping any embedded quote. */
@Immutable
data class PackageEntry(
interface PackageManagerSpec {
internal fun shellQuote(s: String): String = "'" + s.replace("'", "'\\''") + "'"
internal fun shellQuoteAll(names: List<String>): String = names.joinToString(" ") { shellQuote(it) }
}
