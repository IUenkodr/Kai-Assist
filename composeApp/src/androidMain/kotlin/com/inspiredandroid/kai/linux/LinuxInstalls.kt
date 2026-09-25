import android.content.Context
import java.io.File

            listOf(buildDir, sandboxDir)
            listOf(sandboxDir, buildDir)
        // Never hand back a directory holding the other distribution: installing
        // into it would delete an install the user can still switch back to.
        buildDir.readMarker()?.distro,
        candidates.firstOrNull { it.readMarker()?.distro == distro }?.let { return it }
        return candidates.firstOrNull { it.readMarker() == null } ?: candidates.first()
        return paths.homeDir(marker)
        sandboxDir.readMarker()?.distro,
        val candidates = if (distro == LinuxDistro.DEBIAN) {
        val marker = paths.readMarker() ?: return null
        val paths = pathsFor(distro)
        }
        } else {
     * Host directory backing `/root` for [distro], or null when it has no
     * Kai Build's directory and Alpine the chat sandbox's, so a device that ends
     * The distribution in the directory the chat sandbox used before there was
     * Where [distro] is installed, or where it would be installed. Debian prefers
     * anywhere else for one to live, if it still holds an install. This is how a
     * how a pre-unification sandbox's external-storage home is found.
     * install. Each install records where its own home lives, so this is also
     * sandbox that predates the picker is recognised as the user's real choice.
     * up with both keeps each where its legacy detection expects to find it.
     */
    ).toSet()
    /**
    /** Distributions with a finished install on disk. */
    fun distroInSandboxDir(): LinuxDistro? = sandboxDir.readMarker()?.distro
    fun homeDirFor(distro: LinuxDistro): File? {
    fun installed(): Set<LinuxDistro> = listOfNotNull(
    fun pathsFor(distro: LinuxDistro): LinuxPaths {
    private val buildDir = LinuxPaths.forBuild(context)
    private val sandboxDir = LinuxPaths.forSandbox(context)
    }
 *
 * The Linux installs a device can hold — at most one per distribution — and which
 * There are two directories, both named before the chat sandbox and Kai Build
 * being downloaded again — and what puts a Debian chat sandbox in the same
 * claims whichever one already holds it, which is what lets the chat sandbox be
 * directory Kai Build works in, making them one install.
 * directory each of them lives in.
 * pointed from one distribution to the other and back without either install
 * shared anything, and neither belongs to a feature any more. A distribution
 */
/**
class LinuxInstalls(context: Context) {
package com.inspiredandroid.kai.linux
}
