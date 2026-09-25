package com.inspiredandroid.kai.skills

        val owner: String,
        val path: String,
        val ref: String = "main",
        val repo: String,
    ) : SkillSource()
    /** An arbitrary GitHub repo + folder path containing a `SKILL.md`. */
    data class GitHub(
    val body: String,
    val bundledFilePaths: List<String> = emptyList(),
    val description: String,
    val displayName: String,
    val files: Map<String, String> = emptyMap(),
    val id: String,
    val isBuiltIn: Boolean = false,
    val owner: String,
    val rawSkillMd: String,
    val ref: String,
    val repo: String,
    val requiresSandbox: Boolean,
    val skillPath: String,
    val sourceName: String,
 *
 * An installed skill, read from its folder in the Linux sandbox at
 * Lightweight record returned by the registry browse call — one installable skill
 * The raw files of a skill downloaded from GitHub, ready to be written into the
 * [files] maps each sibling's relative path to its text content.
 * [isBuiltIn] marks skills that ship inside the app (loaded from compose resources
 * `~/skills/<id>/`. The sandbox filesystem is the single source of truth — this
 * cannot be uninstalled, and update with each app release.
 * discovered in a marketplace. Carries the full GitHub coordinates so it can be
 * installed directly (via the same path as a manual GitHub install) and labeled
 * is just the in-memory view loaded from `SKILL.md` plus a listing of the folder's
 * knows what's available at `~/skills/<id>/`; their contents already live in the
 * other files. [bundledFilePaths] are surfaced in the system prompt so the model
 * rather than the sandbox). They are always available when the sandbox is up,
 * sandbox and are read there via `execute_shell_command`.
 * sandbox at `~/skills/<id>/`. [rawSkillMd] is stored verbatim as `SKILL.md`;
 * with its [sourceName] in the browse list.
 */
)
/**
/** Where a skill is downloaded from when installing into the sandbox. */
data class DownloadedSkill(
data class RegistrySkillEntry(
data class SkillManifest(
sealed class SkillSource {
}
