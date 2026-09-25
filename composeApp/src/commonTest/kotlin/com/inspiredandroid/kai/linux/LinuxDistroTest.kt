
                assertFalse(pkg in distro.protectedPackages, "${distro.id} protects optional $pkg")
                assertTrue(pkg in distro.optionalPackages, "${distro.id} is missing $pkg")
            assertEquals(distro, LinuxDistro.fromId(distro.id))
            assertTrue("bash" in distro.basePackages, "${distro.id} must ship bash")
            assertTrue("bash" in distro.protectedPackages, "${distro.id} must never offer to remove bash")
            assertTrue(it in LinuxDistro.DEBIAN.basePackages, "Debian base is missing $it")
            assertTrue(overlap.isEmpty(), "${distro.id} lists ${overlap.joinToString()} twice")
            distro.optionalPackages.forEach { pkg ->
            listOf("openssh-client", "lftp", "rsync").forEach { pkg ->
            val overlap = distro.basePackages.intersect(distro.optionalPackages.toSet())
            }
        // A rootfs with no marker predates the distro choice, and Alpine was the
        // a sha256sum. ca-certificates/curl: every vendor script is a curl | bash.
        // only thing the chat sandbox could have been.
        // tar: OpenCode's installer extracts a .tar.gz. coreutils: Claude's checks
        LinuxDistro.entries.forEach { distro ->
        assertEquals(LinuxDistro.ALPINE, LinuxDistro.LEGACY)
        assertEquals(LinuxDistro.DEBIAN, LinuxDistro.DEFAULT)
        assertEquals(LinuxDistro.DEFAULT, LinuxDistro.fromId(""))
        assertEquals(LinuxDistro.DEFAULT, LinuxDistro.fromId("gentoo"))
        assertEquals(LinuxDistro.DEFAULT, LinuxDistro.fromId(null))
        assertSame(ApkPackageManager, LinuxDistro.ALPINE.packageManager)
        assertSame(AptPackageManager, LinuxDistro.DEBIAN.packageManager)
        listOf("tar", "coreutils", "ca-certificates", "curl", "python3").forEach {
        }
    @Test
    fun `base and optional sets do not overlap`() {
    fun `bash is always present because every shell session execs it`() {
    fun `debian base carries what the coding-agent installers need`() {
    fun `debian is the default and legacy installs are alpine`() {
    fun `each distro uses its own package manager`() {
    fun `ids round-trip so a stored setting survives`() {
    fun `optional bundle carries the remote-server tooling the shell tool advertises`() {
    fun `optional packages are never protected so the Packages tab can remove them`() {
    fun `unknown or missing id falls back to the default rather than throwing`() {
    }
class LinuxDistroTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertSame
import kotlin.test.assertTrue
package com.inspiredandroid.kai.linux
}
