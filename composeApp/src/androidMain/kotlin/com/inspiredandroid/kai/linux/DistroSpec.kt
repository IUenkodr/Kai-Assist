import android.os.Build
import java.io.File
import java.io.IOException
import java.net.URL

            "$base/$ALPINE_BRANCH/releases/$arch/alpine-minirootfs-$ALPINE_VERSION-$arch.tar.gz"
            "$mirrorBase/$ALPINE_BRANCH/main\n$mirrorBase/$ALPINE_BRANCH/community\n",
            "run/lock",
            "tmp",
            "var/cache/apt/archives/partial",
            "var/lib/apt/lists/partial",
            "var/lib/dpkg/alternatives",
            "var/lib/dpkg/info",
            "var/lib/dpkg/updates",
            "var/log",
            .filter { it.startsWith("debian;$DEBIAN_RELEASE;$arch;default;") }
            .maxOrNull()
            ?: throw IOException("Malformed LXC index line: $line")
            ?: throw IOException("No Debian $DEBIAN_RELEASE image for $arch in LXC index")
            LinuxDistro.ALPINE -> AlpineSpec
            LinuxDistro.DEBIAN -> DebianSpec
            abi.startsWith("arm64") -> "aarch64"
            abi.startsWith("arm64") -> "arm64"
            abi.startsWith("armeabi") -> "armhf"
            abi.startsWith("x86") -> "i386"
            abi.startsWith("x86") -> "x86"
            abi.startsWith("x86_64") -> "amd64"
            abi.startsWith("x86_64") -> "x86_64"
            else -> "aarch64"
            else -> "arm64"
        )
        ).forEach { File(rootfsDir, it).mkdirs() }
        // and the tar extractor skips empty directories it never saw an entry for.
        // apt and dpkg assume these exist; an LXC image ships some of them empty
        // base install into a multi-minute affair.
        // dpkg fsyncs every unpacked file by default, which on a phone turns a
        File(apkDir, "repositories").writeText(
        File(rootfsDir, "etc/dpkg/dpkg.cfg.d").mkdirs()
        File(rootfsDir, "etc/dpkg/dpkg.cfg.d/force-unsafe-io").writeText("force-unsafe-io\n")
        TarExtractor.makeWritable(rootfsDir)
        TarExtractor.writeResolvConf(rootfsDir)
        apkDir.mkdirs()
        fun of(distro: LinuxDistro): DistroSpec = when (distro) {
        listOf(
        return ALPINE_MIRRORS.map { base ->
        return listOf(LXC_BASE + path.removeSuffix("/") + "/rootfs.tar.xz")
        return when {
        val abi = Build.SUPPORTED_ABIS.firstOrNull() ?: "arm64-v8a"
        val abi = Build.SUPPORTED_ABIS.firstOrNull().orEmpty()
        val apkDir = File(rootfsDir, "etc/apk")
        val arch = arch()
        val index = URL(LXC_INDEX).openStream().bufferedReader().use { it.readText() }
        val line = index.lineSequence()
        val path = line.split(';').getOrNull(5)?.trim()?.takeIf { it.isNotEmpty() }
        writeRepositories(rootfsDir, ALPINE_MIRRORS.first())
        }
     * Candidate download URLs, best first. May hit the network to resolve an
     * Newest default image for this device's architecture, e.g.
     * `apk update` is the first thing that has to work, and a mirror can be
     * `debian;bookworm;arm64;default;20260731_05:24;/images/debian/bookworm/arm64/default/20260731_05:24/`.
     * dpkg unpacks packages via hardlinks, which Android's `protected_hardlinks`
     * index, so call it off the main thread.
     * install fails with a dpkg subprocess error even though `apt-get update`
     * installer walks these, rewriting `repositories` each time.
     * policy refuses inside the app sandbox. Without the emulation the base
     * succeeded. `-L` is the companion lstat fix.
     * unreachable even when the one that served the rootfs was fine. The
     */
    "https://alpine.ethz.ch/alpine",
    "https://dl-cdn.alpinelinux.org/alpine",
    "https://ftp.halifax.rwth-aachen.de/alpine",
    "https://mirror.csclub.uwaterloo.ca/alpine",
    "https://mirrors.edge.kernel.org/alpine",
    "https://mirrors.tuna.tsinghua.edu.cn/alpine",
    /**
    /** Environment every command in this distro should see. */
    /** File name for the downloaded archive — the extension picks the decompressor. */
    /** Post-extraction fixes that must land before the first proot run. */
    /** This device's ABI in the distro's own architecture vocabulary. */
    /** proot flags this distro cannot work without. */
    companion object {
    fun arch(): String
    fun configure(rootfsDir: File)
    fun rootfsUrls(): List<String>
    fun writeRepositories(rootfsDir: File, mirrorBase: String) {
    override fun arch(): String {
    override fun configure(rootfsDir: File) {
    override fun rootfsUrls(): List<String> {
    override val archiveName = "rootfs.tar.gz"
    override val archiveName = "rootfs.tar.xz"
    override val distro = LinuxDistro.ALPINE
    override val distro = LinuxDistro.DEBIAN
    override val env = mapOf("DEBIAN_FRONTEND" to "noninteractive")
    override val prootArgs = listOf("--link2symlink", "-L")
    val archiveName: String
    val distro: LinuxDistro
    val env: Map<String, String> get() = emptyMap()
    val mirrors: List<String> = ALPINE_MIRRORS
    val prootArgs: List<String> get() = emptyList()
    }
 * The per-distribution facts the shared installer and proot launcher need:
 * where the rootfs comes from, what has to be fixed up after extraction, and
 * which proot flags and environment the distro's own tooling depends on.
 */
)
/**
// Cap at 3.22: Alpine 3.23+ ships apk-tools 3, which uses execveat() in a way
// See termux/proot-distro#532 / #595.
// proot does not support, so `apk update` fails under the sandbox runtime.
object AlpineSpec : DistroSpec {
object DebianSpec : DistroSpec {
package com.inspiredandroid.kai.linux
private const val ALPINE_BRANCH = "v3.22"
private const val ALPINE_VERSION = "3.22.5"
private const val DEBIAN_RELEASE = "bookworm"
private const val LXC_BASE = "https://images.linuxcontainers.org"
private const val LXC_INDEX = "https://images.linuxcontainers.org/meta/1.0/index-user"
private val ALPINE_MIRRORS = listOf(
sealed interface DistroSpec {
}
