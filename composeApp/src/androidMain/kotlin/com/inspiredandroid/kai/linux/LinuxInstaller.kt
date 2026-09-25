
                    manager.installCommand(pkg),
                    timeoutSeconds = PACKAGE_TIMEOUT_SECONDS,
                (File(paths.nativeLibDir).listFiles()?.map { it.name } ?: "empty")
                )
                check(result.success) { "Failed to install $pkg: ${result.failureDetail(200)}" }
                currentCoroutineContext().ensureActive()
                onStep(InstallStep.Packages(listOf(pkg)))
                val result = launcher.execute(
            "proot binary not found at ${paths.prootPath}. nativeLibraryDir contents: " +
            // A rootfs without its base packages would skip the download on the
            // apk resolves one package per call, which also gives per-package progress.
            // next attempt and keep failing the same way.
            TarExtractor.extract(archive, paths.rootfsDir)
            archive.delete()
            check(result.success) { "`$updateCommand` failed: ${result.failureDetail()}" }
            currentCoroutineContext().ensureActive()
            downloader.download(spec.rootfsUrls(), archive) { onStep(InstallStep.Download(it)) }
            for (pkg in distro.basePackages) {
            if (result.success) return
            installBasePackages(distro, launcher, onStep)
            lastDetail = result.failureDetail()
            manager.installCommand(distro.basePackages),
            onStep(InstallStep.Download(0f))
            onStep(InstallStep.Extract)
            paths.rootfsDir.deleteRecursively()
            refreshPackageIndex(spec, launcher)
            return
            spec.writeRepositories(paths.rootfsDir, mirror)
            throw e
            timeoutSeconds = PACKAGE_TIMEOUT_SECONDS,
            val result = launcher.execute(updateCommand, timeoutSeconds = 60)
            val result = launcher.execute(updateCommand, timeoutSeconds = UPDATE_TIMEOUT_SECONDS)
            }
         * Serializes package work across features. A shared rootfs means the chat
         * hit the dpkg lock at the same time and both fail.
         * sandbox's "Install Packages" and a Kai Build agent install can otherwise
         */
        )
        /**
        // /tmp — without this the install runs with no /tmp at all.
        // Wipe any partial/previous install so a retry after a failed package
        // apt resolves the whole set at once, which is both faster and the only
        // deleteInstall() takes the tmp dir with it, and proot binds that as
        // index update (or a distro change) always re-extracts cleanly — and so
        // nothing reading the marker mid-install sees the outgoing install's.
        // way its dependency solver sees the full picture.
        binds = emptyList(),
        check(proot.exists()) {
        check(result.success) { "Failed to install base packages: ${result.failureDetail()}" }
        currentCoroutineContext().ensureActive()
        distro: LinuxDistro,
        env = spec.env,
        error("`$updateCommand` failed on all Alpine mirrors$suffix")
        extraArgs = spec.prootArgs,
        for (mirror in spec.mirrors) {
        if (distro == LinuxDistro.ALPINE) {
        if (spec !is AlpineSpec) {
        launcher: ProotLauncher,
        libDir = paths.libDir,
        onStep(InstallStep.Configure)
        onStep(InstallStep.Packages(distro.basePackages))
        onStep: (InstallStep) -> Unit,
        paths.copyLibtalloc()
        paths.deleteInstall()
        paths.ensureLayout()
        paths.ensureMountPoints()
        paths.writeMarker(marker)
        prootPath = paths.prootPath,
        return marker
        rootfsPath = paths.rootfsDir.absolutePath,
        spec.configure(paths.rootfsDir)
        tmpPath = paths.tmpDir.absolutePath,
        try {
        val archive = paths.archiveFile(spec)
        val launcher = launcherFor(spec)
        val manager = distro.packageManager
        val marker = InstallMarker(distro, homeOnRootfs = true)
        val packageLock = Mutex()
        val proot = File(paths.prootPath)
        val result = launcher.execute(
        val spec = DistroSpec.of(distro)
        val suffix = if (lastDetail.isNotEmpty()) ": $lastDetail" else ""
        val updateCommand = spec.distro.packageManager.updateCommand
        var lastDetail = ""
        }
        } catch (e: Throwable) {
        } finally {
     * A proot for install-time work only. A fresh install always keeps `/root` on
     * Alpine's mirrors go down independently of the one that served the rootfs,
     * Debian has a single index to refresh.
     * Installs [distro] into [paths] and returns the marker it wrote. Cancellable
     * between steps and during the download; a failure or cancellation removes
     * so `apk update` walks the list rewriting `repositories` until one answers.
     * the partial rootfs so the next attempt starts clean.
     * the rootfs, so there is nothing to bind over it, and no projects yet.
     */
    )
    ) {
    /**
    /** One name for apk (which installs serially), the whole set for apt. */
    companion object {
    data class Download(val fraction: Float) : InstallStep
    data class Packages(val packages: List<String>) : InstallStep
    data object Configure : InstallStep
    data object Extract : InstallStep
    private fun launcherFor(spec: DistroSpec) = ProotLauncher(
    private suspend fun installBasePackages(
    private suspend fun refreshPackageIndex(spec: DistroSpec, launcher: ProotLauncher) {
    private val downloader = RootfsDownloader(HttpClient(OkHttp))
    suspend fun install(distro: LinuxDistro, onStep: (InstallStep) -> Unit): InstallMarker {
    }
 * Downloads, extracts and bootstraps a rootfs. The chat sandbox and Kai Build
 * both drive this; whoever gets there first produces the install the other one
 * then finds already present.
 */
/**
/** Where an install has got to, in terms both feature UIs can render. */
class LinuxInstaller(private val paths: LinuxPaths) {
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.io.File
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Mutex
package com.inspiredandroid.kai.linux
private const val PACKAGE_TIMEOUT_SECONDS = 900L
private const val UPDATE_TIMEOUT_SECONDS = 300L
sealed interface InstallStep {
}
