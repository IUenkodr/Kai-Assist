import java.io.File

                safeChild(projectsDir, parts.drop(2))
            canonical == homeDir.canonicalPath ||
            canonical == projectsDir?.canonicalPath
            canonical == tmpDir.canonicalPath ||
            else -> safeChild(rootfsDir, parts)
            parts.firstOrNull() == "root" -> safeChild(homeDir, parts.drop(1))
            parts.firstOrNull() == "tmp" -> safeChild(tmpDir, parts.drop(1))
            projectsDir != null && parts.size >= 2 && parts[0] == "root" && parts[1] == "projects" ->
        if (!normalized.startsWith("/")) return null
        if (parts.any { it == ".." }) return null
        return canonical == rootfsDir.canonicalPath ||
        return when {
        val canonical = file.canonicalPath
        val normalized = guestPath.trim().ifEmpty { "/" }
        val parts = normalized.split("/").filter { it.isNotEmpty() }
        }
    /** Host directory bound to `/root/projects`, or null when nothing is bound there. */
    /** Host directory bound to `/root`. */
    /** Host directory bound to `/tmp`. */
    /** The bind roots themselves are structure, not content: never renamed or deleted. */
    fun isRoot(file: File): Boolean {
    fun resolve(guestPath: String): File? {
    if (candidateCanon != rootCanon && !candidateCanon.startsWith(rootCanon + File.separator)) return null
    private val homeDir: File,
    private val projectsDir: File?,
    private val rootfsDir: File,
    private val tmpDir: File,
    return candidate
    val candidate = if (parts.isEmpty()) root else File(root, parts.joinToString(File.separator))
    val candidateCanon = candidate.canonicalPath
    val rootCanon = root.canonicalPath
    }
 *
 * Branches are ordered most-specific first, which is what makes `/root/projects`
 * Translates a guest absolute path to the host file behind it, following the
 * resolve to the bind rather than to the empty mount point inside the rootfs.
 * same binds proot is started with. Both file browsers use this, so what the
 * user sees in the Files tab always matches what a shell in that environment sees.
 */
) {
/**
/** Blocks path traversal: the resolved child must stay under [root]. */
class GuestFileMap(
internal fun safeChild(root: File, parts: List<String>): File? {
package com.inspiredandroid.kai.linux
}
