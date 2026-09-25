import android.content.Context
import java.io.File

                    if (idx <= 0) null else line.substring(0, idx).trim() to line.substring(idx + 1).trim()
                    val idx = line.indexOf('=')
                .mapNotNull { line ->
                .toMap()
                }
            context = context,
            dirName = BUILD_DIR_NAME,
            dirName = SANDBOX_DIR_NAME,
            distro = LinuxDistro.fromId(distroId),
            homeOnRootfs = values[KEY_HOME] != HOME_EXTERNAL,
            legacyEvidence = ALPINE_RELEASE_FILE,
            legacyEvidence = LEGACY_READY_FILE,
            legacyMarker = InstallMarker(LinuxDistro.DEBIAN, homeOnRootfs = true),
            legacyMarker = InstallMarker(LinuxDistro.LEGACY, homeOnRootfs = false),
            markerFile.readLines()
         * The chat sandbox's install. It never wrote a completion file, so a
         * by Alpine's own release file.
         * marker-less rootfs is recognised as a finished pre-unification Alpine
         */
        )
        /**
        /** Kai Build's own install, used only when the chat sandbox is not Debian. */
        File(external, "kai-build-home/projects")
        File(root, LEGACY_READY_FILE).delete()
        File(rootfsDir, "root/.local/bin").mkdirs()
        File(rootfsDir, "root/projects").mkdirs()
        LinuxDistro.entries.forEach { File(root, DistroSpec.of(it).archiveName).delete() }
        fun forBuild(context: Context) = LinuxPaths(
        fun forSandbox(context: Context) = LinuxPaths(
        if (!File(root, legacyEvidence).exists()) return null
        if (!markerFile.isFile) return null
        if (!rootfsDir.isDirectory) return null
        if (source.exists()) source.copyTo(tallocTarget, overwrite = true)
        if (tallocTarget.exists()) return
        listOf(root, tmpDir, projectsDir).forEach { it.mkdirs() }
        markerFile.delete()
        markerFile.writeText("$KEY_DISTRO=${marker.distro.id}\n$KEY_HOME=$home\n")
        parseMarker()?.let { return it }
        return InstallMarker(
        return legacyMarker
        root.mkdirs()
        rootfsDir.deleteRecursively()
        target
        target.mkdirs()
        tmpDir.deleteRecursively()
        val distroId = values[KEY_DISTRO] ?: return null
        val external = appContext.getExternalFilesDir(null)
        val external = appContext.getExternalFilesDir(null) ?: root
        val home = if (marker.homeOnRootfs) HOME_ROOTFS else HOME_EXTERNAL
        val source = File(nativeLibDir, "libtalloc.so")
        val target = if (external != null) File(external, "sandbox-home") else File(root, "home")
        val values = runCatching {
        writeMarker(legacyMarker)
        }.getOrNull() ?: return null
     * "A rootfs directory exists" is not enough: an install in progress has one
     * Android strips the `.so.2` suffix from jniLibs, so proot cannot find the
     * Bound to `/root/projects`. Lives in external app files so project code stays
     * Path under [root] whose presence proves a marker-less install *finished*.
     * The install on disk, or null when there is none. Adopts and persists the
     * The pre-unification chat home. Still bound to `/root` for installs that
     * True when `/root` lives on the rootfs (executable, which agent binaries
     * USB/MTP reachable, and is shared by whichever Debian exists so switching the
     * chat sandbox's distro never strands a project.
     * downstream sees one shape.
     * legacy marker for installs made before markers existed, so every caller
     * need). False is the pre-unification chat layout, where `/root` was bound
     * on its library path.
     * record it as a complete Alpine.
     * recorded [InstallMarker.homeOnRootfs] as false.
     * soname it was linked against until we put a correctly named copy somewhere
     * to external app storage — kept as-is for installs that already have it.
     * too, and adopting a legacy marker over a half-extracted Debian would
     */
    /**
    /** Adopted when a rootfs predates markers. */
    /** Host directory backing `/root` for this install. */
    /** Mount points must exist inside the rootfs before proot binds over them. */
    /** Wipes the install, leaving project folders (they live outside [root]) alone. */
    /** proot resolves `libtalloc.so.2` relative to this. */
    /** proot runs straight out of nativeLibraryDir — the one place Android grants exec. */
    companion object {
    context: Context,
    dirName: String,
    fun archiveFile(spec: DistroSpec): File = File(root, spec.archiveName)
    fun copyLibtalloc() {
    fun deleteInstall() {
    fun ensureLayout() {
    fun ensureMountPoints() {
    fun homeDir(marker: InstallMarker): File = if (marker.homeOnRootfs) File(rootfsDir, "root") else legacyExternalHome
    fun readMarker(): InstallMarker? {
    fun writeMarker(marker: InstallMarker) {
    private fun parseMarker(): InstallMarker? {
    private val appContext = context.applicationContext
    private val legacyEvidence: String,
    private val legacyExternalHome: File by lazy {
    private val legacyMarker: InstallMarker,
    private val markerFile: File get() = File(root, MARKER_FILE)
    private val tallocTarget: File get() = File(root, "libtalloc.so.2")
    val distro: LinuxDistro,
    val homeOnRootfs: Boolean,
    val libDir: String get() = root.absolutePath
    val nativeLibDir: String get() = appContext.applicationInfo.nativeLibraryDir
    val projectsDir: File by lazy {
    val prootPath: String get() = File(nativeLibDir, "libproot.so").absolutePath
    val root: File = File(appContext.filesDir, dirName)
    val rootfsDir: File get() = File(root, "rootfs")
    val tmpDir: File get() = File(root, "tmp")
    }
 *
 * Directory names are deliberately unchanged from before the two stacks merged,
 * Every Alpine rootfs ships this and no Debian one does, which makes it proof
 * Storage layout for one Linux install. The chat sandbox and Kai Build each
 * What an install recorded about itself. Written only once the install fully
 * is how a Debian chat sandbox and Kai Build end up sharing a single rootfs.
 * point one of these at their own directory — or at the *same* directory, which
 * so existing installs are found rather than orphaned and `file_paths.xml` keeps
 * succeeds, so a partial rootfs can never present itself as ready.
 * than a Debian that is still being extracted.
 * that a marker-less chat sandbox is a finished pre-unification install rather
 * working.
 */
)
) {
/**
/** Directory under `filesDir` holding Kai Build's own Linux, when it needs one. */
/** Directory under `filesDir` holding the chat sandbox's Linux. */
/** Pre-marker Kai Build installs recorded completion in this file. */
class LinuxPaths(
const val ALPINE_RELEASE_FILE = "rootfs/etc/alpine-release"
const val BUILD_DIR_NAME = "kai-build"
const val LEGACY_READY_FILE = "ready"
const val SANDBOX_DIR_NAME = "linux-sandbox"
data class InstallMarker(
package com.inspiredandroid.kai.linux
private const val HOME_EXTERNAL = "external"
private const val HOME_ROOTFS = "rootfs"
private const val KEY_DISTRO = "distro"
private const val KEY_HOME = "home"
private const val MARKER_FILE = "install"
}
