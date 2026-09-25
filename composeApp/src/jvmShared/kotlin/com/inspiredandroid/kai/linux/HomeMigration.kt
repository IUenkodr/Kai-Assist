
                // COPY_ATTRIBUTES carries the mode on a Unix filesystem, but this
                // Whatever is already there wins — including a destination that is
                // a plain file where the source has a directory, or the reverse.
                // is not the place to depend on best-effort: a migrated `~/.ssh`
                // or private key that lands world-readable is one openssh refuses
                // to use.
                Files.copy(entry.file.toPath(), destination.toPath(), *options.toTypedArray())
                copied++
                destination.parentFile?.mkdirs()
                if (!entry.isSymlink) copyPermissions(entry.file, destination)
                if (!present) visit(Entry(child, isDirectory, isSymlink), destination)
                if (entry.isSymlink) options += LinkOption.NOFOLLOW_LINKS
                if (isDirectory && (!present || destination.isDirectory)) stack.addLast(relative)
                if (relative in EXCLUDED) continue
                onProgress(copied)
                val destination = File(target, relative)
                val isDirectory = !isSymlink && child.isDirectory
                val isSymlink = Files.isSymbolicLink(child.toPath())
                val options = mutableListOf<CopyOption>(StandardCopyOption.COPY_ATTRIBUTES)
                val present = Files.exists(destination.toPath(), LinkOption.NOFOLLOW_LINKS)
                val relative = if (prefix.isEmpty()) child.name else "$prefix/${child.name}"
            // A symlink's own size is meaningless — it is whatever it points at
            // Directories are scaffolding, not content — leaving them out keeps
            // that has one, and that is either copied separately or already there.
            // this count the same one [survey] reported.
            Files.setPosixFilePermissions(to.toPath(), Files.getPosixFilePermissions(from.toPath()))
            files++
            for (child in children) {
            if (!entry.isSymlink) bytes += entry.file.length()
            if (entry.isDirectory) return@walk
            if (written && !entry.isDirectory) {
            val children = runCatching { File(source, prefix).listFiles() }.getOrNull() ?: continue
            val prefix = stack.removeLast()
            val written = runCatching {
            }
            }.isSuccess
        ".bash_logout",
        ".bash_profile",
        ".bashrc",
        ".cache",
        ".claude",
        ".grok",
        ".local/share/claude",
        ".opencode",
        ".profile",
        "projects",
        if (!source.isDirectory) return
        return HomeSurvey(files, bytes)
        return copied
        runCatching {
        stack.addLast("")
        val stack = ArrayDeque<String>()
        var bytes = 0L
        var copied = 0
        var files = 0
        walk(source, target) { entry, _ ->
        walk(source, target) { entry, destination ->
        while (stack.isNotEmpty()) {
        }
     *
     *   binaries keep. Kai Build only ever runs in Debian and installs them per
     *   distribution's libc, which cannot run on the target, and the state those
     *   distribution's own layout; Debian's would send an Alpine shell looking
     *   environment, so there is nothing here another distribution can use.
     *   for tools that are not there.
     *   would duplicate Kai Build's project folders into themselves.
     * - Shell startup files ship with every rootfs and are written for that
     * - The coding-agent dirs hold binaries compiled against the source
     * - `.cache` is regenerable and can be larger than everything that matters.
     * - `projects` is a bind mount both installs already share, so copying it
     * A single unreadable entry — a socket, a FIFO, a file whose mode the app
     * Counts what [copy] would write — the entries the destination does not
     * Directories are not counted: they carry no data of their own, and a home
     * Home entries that are never worth carrying across, matched against the
     * Merges [source] into [target] and returns how many entries were written.
     * Symlinks are reported as entries and never followed: a rootfs contains link
     * Visits every source entry the target is missing, paired with where it would
     * [onProgress] reports the running count so a long copy can say where it is.
     * already have. Walks the source tree, so call it off the main thread.
     * cannot open — is skipped rather than abandoning the rest of someone's home.
     * creates it has somewhere to put them; a directory the target already has is
     * go. A missing directory is reported before its children, so a consumer that
     * loops, and a symlink's value is the link itself.
     * path relative to the home directory:
     * recursed into instead, so it still receives the files it lacks.
     * that only needs empty folders is one with nothing to migrate.
     */
    )
    /**
    fun copy(source: File, target: File, onProgress: (Int) -> Unit = {}): Int {
    fun survey(source: File, target: File): HomeSurvey {
    private class Entry(val file: File, val isDirectory: Boolean, val isSymlink: Boolean)
    private fun copyPermissions(from: File, to: File) {
    private fun walk(source: File, target: File, visit: (Entry, File) -> Unit) {
    val EXCLUDED = setOf(
    val isEmpty: Boolean get() = fileCount == 0
    }
 *
 * Copies a user's home directory from one Linux install into another, so
 * The copy **merges**: anything already at the destination wins and is never
 * and makes "nothing left to copy" the natural end state — a second survey of a
 * migrated home comes back empty, which is how the offer stops being made.
 * removed without losing them.
 * skills and files behind — and so the distribution being left can then be
 * switching the shell integration's distribution does not mean leaving SSH keys,
 * touched, and the source is never modified. That makes it safe to run twice,
 */
/**
/** What moving one install's `/root` into another's would actually carry over. */
data class HomeSurvey(val fileCount: Int, val bytes: Long) {
import java.io.File
import java.nio.file.CopyOption
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.StandardCopyOption
object HomeMigration {
package com.inspiredandroid.kai.linux
}
