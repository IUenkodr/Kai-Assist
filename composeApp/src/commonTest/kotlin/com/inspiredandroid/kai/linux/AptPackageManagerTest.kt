
                PackageEntry("bash", "5.2.15-2+b7"),
                PackageEntry("coreutils", "9.1-1"),
                PackageEntry("fastfetch", "", "Fast system information tool"),
                PackageEntry("fastjar", "", "Jar creation utility"),
                PackageEntry("python3", "3.11.2-1+b1"),
              indented continuation text
            "apt-get install -y --no-install-recommends 'bash' 'ca-certificates' 'curl'",
            "apt-get install -y --no-install-recommends 'python3-pip'",
            "iU \thalf-configured\t1.0",
            "ii \tbash\t5.2.15-2+b7",
            "ii \tcoreutils\t9.1-1",
            "ii \tgit\t1:2.39.5-0+deb12u2",
            "ii \tpython3\t3.11.2-1+b1",
            "rc \tnano\t7.2-1",
            ),
            0,
            4 upgraded, 0 newly installed, 0 to remove and 0 not upgraded.
            AptPackageManager.countUpgraded("0 upgraded, 0 newly installed, 0 to remove and 0 not upgraded."),
            AptPackageManager.installCommand("python3-pip"),
            AptPackageManager.installCommand(listOf("bash", "ca-certificates", "curl")),
            AptPackageManager.parseInstalled(raw),
            AptPackageManager.parseSearch(raw),
            E: Unable to locate package nope
            Reading package lists...
            Setting up libc6:arm64 (2.36-9+deb12u10) ...
            W: Target Packages is configured multiple times
            fastfetch - Fast system information tool
            fastjar - Jar creation utility
            listOf(
        """.trimIndent()
        )
        ).joinToString("\n")
        // `rc` = removed, config files remain. dpkg-query -W lists these, but they
        // are not usable and offering to uninstall them again is nonsense.
        assertEquals(
        assertEquals("apt-get remove -y 'python3-pip'", AptPackageManager.removeCommand("python3-pip"))
        assertEquals(0, AptPackageManager.countUpgraded("Reading package lists..."))
        assertEquals(4, AptPackageManager.countUpgraded(stdout))
        assertEquals(listOf("bash", "zlib1g"), AptPackageManager.parseInstalled(raw).map { it.name })
        assertEquals(listOf("fastfetch"), AptPackageManager.parseSearch(raw).map { it.name })
        assertEquals(listOf(PackageEntry("git", "1:2.39.5-0+deb12u2")), AptPackageManager.parseInstalled(raw))
        assertFalse(AptPackageManager.hasErrors("Reading package lists...", "W: unsigned repository"))
        assertTrue(AptPackageManager.hasErrors("", "E: Unable to locate package sshpazz"))
        assertTrue(AptPackageManager.listInstalledCommand.contains("\${Package}"))
        assertTrue(AptPackageManager.listInstalledCommand.contains("\${Version}"))
        assertTrue(AptPackageManager.listInstalledCommand.contains("\${db:Status-Abbrev}"))
        val raw = """
        val raw = "ii \tzlib1g\t1:1.2.13\nii \tbash\t5.2.15"
        val raw = listOf(
        val stdout = """
    @Test
    fun `a whole set installs as one package name per argument`() {
    fun `dpkg format asks for the status field parseInstalled filters on`() {
    fun `install avoids recommends so a phone rootfs stays small`() {
    fun `installed list is sorted by name regardless of dpkg order`() {
    fun `only the E prefix counts as a failure`() {
    fun `parses apt-cache search into name and description with no version`() {
    fun `parses dpkg-query output into name and version`() {
    fun `reads the upgraded count off apt's summary line`() {
    fun `search skips apt diagnostics and continuation lines`() {
    fun `skips packages that are removed but keep their config`() {
    }
class AptPackageManagerTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
package com.inspiredandroid.kai.linux
}
