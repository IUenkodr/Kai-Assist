import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.TextFileResult
import com.inspiredandroid.kai.getBackgroundDispatcher
import kai.composeapp.generated.resources.Res
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

                        .filter { !it.isDirectory && it.name != "SKILL.md" }
                        .map { it.name }
                        .sorted()
                        ?.content ?: return@mapNotNull null
                        ?: return@mapNotNull null
                        body = parsed.body,
                        bundledFilePaths = files,
                        description = parsed.description,
                        displayName = SkillFrontmatterParser.displayName(parsed.id),
                        id = parsed.id,
                    )
                    SkillManifest(
                    val base = "$SKILLS_DIR/${dir.name}"
                    val files = sandboxController.listDirectory(base)
                    val md = (sandboxController.readTextFile("$base/SKILL.md") as? TextFileResult.Text)
                    val parsed = SkillFrontmatterParser.parse(md) as? SkillFrontmatterParser.Result.Ok
                .filter { it.isDirectory }
                .mapNotNull { dir ->
                if (status.installed && !wasInstalled) load()
                wasInstalled = status.installed
                }
            (builtIns + sandboxSkills).sortedBy { it.id }
            // Sandbox-installed skills win on id collision so power users can override a built-in.
            ?: return@mapNotNull null
            body = parsed.body,
            description = parsed.description,
            displayName = SkillFrontmatterParser.displayName(parsed.id),
            id = parsed.id,
            if (safe.isEmpty()) continue
            isBuiltIn = true,
            sandboxController.status.collect { status ->
            sandboxController.writeTextFile("$base/${safe.joinToString("/")}", content)
            val builtIns = loadBuiltInSkills().filter { it.id !in sandboxIds }
            val safe = relPath.split('/', '\\').filterNot { it.isEmpty() || it == ".." }
            val sandboxIds = sandboxSkills.mapTo(mutableSetOf()) { it.id }
            val sandboxSkills = sandboxController.listDirectory(SKILLS_DIR)
            var wasInstalled = false
            }
         * Ids of skills bundled in compose resources at
         * `composeResources/files/skills/<id>/SKILL.md`. Hardcoded so the asset path is
         * explicit at compile time and we don't need a resource directory listing.
         */
        )
        /**
        /** Absolute sandbox path of the skills folder (`~/skills`, home = `/root`). */
        // Load once the sandbox is installed (the file ops resolve real paths only
        // then); the StateFlow re-emits when it flips, so reset/install refresh too.
        SkillManifest(
        SkillSource.GitHub(owner = owner, repo = repo, ref = "main", path = path)
        SkillSource.GitHub(owner = owner, repo = repo, ref = ref, path = path)
        _skills.value = skills
        const val SKILLS_DIR = "/root/skills"
        for ((relPath, content) in downloaded.files) {
        load()
        private val BUILT_IN_SKILL_IDS = listOf("create-skill")
        return SkillSource.GitHub(owner = owner, repo = repo, ref = "main", path = "")
        return getSkill(downloaded.id) ?: error("Skill '${downloaded.id}' not found after install")
        sandboxController.deleteEntry("$SKILLS_DIR/$id", recursive = true)
        sandboxController.deleteEntry(base, recursive = true) // replace if present
        sandboxController.writeTextFile("$base/SKILL.md", downloaded.rawSkillMd)
        scope.launch {
        val base = "$SKILLS_DIR/${downloaded.id}"
        val bytes = runCatching { Res.readBytes("files/skills/$id/SKILL.md") }.getOrNull()
        val parsed = SkillFrontmatterParser.parse(bytes.decodeToString()) as? SkillFrontmatterParser.Result.Ok
        val path = parts.drop(2).joinToString("/")
        val path = parts.drop(4).joinToString("/")
        val ref = parts[3]
        val skills = mutex.withLock {
        }
     * Reads bundled SKILL.md files shipped in compose resources. They appear alongside
     * dropped (no user-facing failure for a missing/broken bundled asset).
     * sandbox-installed skills, can be invoked as `/<id>` from chat, and cannot be
     * sandbox. A built-in whose resource read or frontmatter parse fails is silently
     * uninstalled. Updates flow with each app release — nothing is persisted to the
     */
    /**
    /** Browses the curated marketplaces and returns the combined, searchable list. */
    /** Installs a skill the user picked from the browse list, using its repo coordinates. */
    /** Reads every `~/skills/<id>/` folder back into the in-memory cache. */
    /** Writes a downloaded skill into `~/skills/<id>/`, replacing any existing copy, then reloads. */
    // owner/repo/tree/<ref>/<path…> or owner/repo/<path…> (assume main)
    backgroundDispatcher: CoroutineContext = getBackgroundDispatcher(),
    companion object {
    fun getInstalled(): List<SkillManifest> = _skills.value
    fun getSkill(id: String): SkillManifest? = _skills.value.firstOrNull { it.id == id }
    if (parts.size < 2) return null
    if (parts.size == 2) {
    if (trimmed.isEmpty()) return null
    init {
    internal suspend fun install(downloaded: DownloadedSkill): SkillManifest {
    private suspend fun loadBuiltInSkills(): List<SkillManifest> = BUILT_IN_SKILL_IDS.mapNotNull { id ->
    private val _skills = MutableStateFlow<List<SkillManifest>>(emptyList())
    private val mutex = Mutex()
    private val registry: SkillRegistry = SkillRegistry(),
    private val sandboxController: SandboxController,
    private val scope = CoroutineScope(SupervisorJob() + backgroundDispatcher)
    return if (parts[2] == "tree" && parts.size >= 5) {
    suspend fun browseMarketplaces(): Result<List<RegistrySkillEntry>> = registry.browseMarketplaces(curatedSkillMarketplaces)
    suspend fun installFromGitHub(owner: String, repo: String, ref: String, path: String): Result<SkillManifest> = registry.fetchSkillFiles(SkillSource.GitHub(owner, repo, ref, path)).mapCatching { install(it) }
    suspend fun installFromRegistryEntry(entry: RegistrySkillEntry): Result<SkillManifest> = installFromGitHub(entry.owner, entry.repo, entry.ref, entry.skillPath)
    suspend fun load() {
    suspend fun uninstall(id: String) {
    val owner = parts[0]
    val parts = trimmed.trim('/').split('/').filter { it.isNotEmpty() }
    val repo = parts[1]
    val skills: StateFlow<List<SkillManifest>> = _skills
    val trimmed = input.trim().removePrefix("https://").removePrefix("http://").removePrefix("github.com/")
    }
    } else {
 *
 * "built-in" skills ships inside the app as compose resources and is merged into the
 * (each is a folder containing `SKILL.md` plus any bundled files); a small set of
 * - `https://github.com/owner/repo/tree/<ref>/path/to/skill`
 * - `https://github.com/owner/repo`
 * - `owner/repo/path/to/skill`
 * - `owner/repo`
 * Manages the user's skills. Most skills live in the Linux sandbox at `~/skills/<id>/`
 * On id collision the sandbox copy wins, so users can override a built-in.
 * On platforms without a sandbox the file ops are no-ops and `load()` never runs, so
 * Parses several common forms users might paste to add a GitHub skill:
 * Returns null on a shape we don't recognize so the dialog can surface a hint.
 * The cache is (re)loaded after every install/uninstall and whenever the sandbox
 * because they only make sense when their `execute_shell_command` writes can land.
 * becomes installed — built-ins are loaded then too, gated on sandbox availability
 * no skills (built-in or otherwise) appear off-Android.
 * same in-memory cache so synchronous callers ([getInstalled], [getSkill]) stay cheap.
 */
) {
/**
class SkillManager(
fun parseGitHubSkillUrl(input: String): SkillSource.GitHub? {
package com.inspiredandroid.kai.skills
}
