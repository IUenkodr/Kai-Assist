package com.inspiredandroid.kai.skills
import com.inspiredandroid.kai.data.SharedJson
import com.inspiredandroid.kai.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                        .distinct()
                        .filter { it.removePrefix(prefix).none { ch -> ch == '/' } }
                        .filter { it.startsWith(prefix) && it.endsWith("/SKILL.md") }
                        .map { it.removeSuffix("/SKILL.md") }
                        // Only one level under root (root/<name>/SKILL.md), not nested.
                        description = parsed.description,
                        id = parsed.id,
                        if (content != null && content.length <= MAX_BUNDLED_FILE_CHARS) file to content else null
                        it.startsWith("$dir/") && it.substringAfterLast('.', "").lowercase() in sandboxExtensions
                        owner = owner,
                        ref = ref,
                        repo = repo,
                        requiresSandbox = requiresSandbox,
                        skillPath = dir,
                        sourceName = marketplace.name,
                        val content = fetchRawFile(owner, repo, ref, "$path/$file")
                    )
                    RegistrySkillEntry(
                    async {
                    if (normalized.isNotEmpty()) out.add(normalized)
                    if (parsed !is SkillFrontmatterParser.Result.Ok) return@async null
                    treePaths
                    val md = fetchRawFile(owner, repo, ref, "$dir/SKILL.md") ?: return@async null
                    val normalized = raw.trim().removePrefix("./").trim('/')
                    val parsed = SkillFrontmatterParser.parse(md)
                    val prefix = "$root/"
                    val raw = s.jsonPrimitive.contentOrNull ?: continue
                    val requiresSandbox = treePaths.any {
                    }
                !manifestPaths.isNullOrEmpty() -> manifestPaths.filter(hasSkillMd)
                .awaitAll()
                .distinctBy { "${it.owner}/${it.repo}/${it.skillPath}" }
                .filter { it.substringAfterLast('.', "").lowercase() !in BINARY_EXTENSIONS }
                .filterNotNull()
                .flatten()
                .map { async { browseMarketplace(it).getOrNull().orEmpty() } }
                .map { file ->
                .toMap()
                // Same skill can appear in multiple sources; keep the first (curated order).
                // Skip plugins that point at a different repo — we only browse this one.
                ?.let { runCatching { parseMarketplaceManifest(it) }.getOrNull() }
                allowlist != null -> allowlist.map { it.trim('/') }.filter(hasSkillMd)
                async {
                else -> {
                for (s in skills) {
                if (source != null && source != "./" && source != ".") continue
                val obj = plugin.jsonObject
                val skills = obj["skills"] as? JsonArray ?: continue
                val source = obj["source"]?.jsonPrimitive?.contentOrNull
                }
            "exe", "dll", "so", "dylib", "bin",
            "mp3", "mp4", "wav", "ogg", "flac", "mov", "avi", "webm",
            "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx",
            "png", "jpg", "jpeg", "gif", "webp", "bmp", "ico", "svg",
            "ttf", "otf", "woff", "woff2",
            "zip", "tar", "gz", "bz2", "7z", "rar",
            .filter { it.startsWith("$path/") && it != "$path/SKILL.md" }
            .map { it.removePrefix("$path/") } // relative subpath, may contain '/'
            ?: error("SKILL.md not found at $owner/$repo:$ref:$path/SKILL.md")
            allowlist: List<String>?,
            description = parsed.description,
            exclude: Set<String> = emptySet(),
            fetchRawFile(owner, repo, ref, MARKETPLACE_MANIFEST_PATH)
            files = files,
            for (plugin in plugins) {
            header("Accept", "application/vnd.github+json")
            header("X-GitHub-Api-Version", "2022-11-28")
            id = parsed.id,
            if (type == "blob" && path != null) path else null
            is SkillFrontmatterParser.Result.Err -> error("Invalid SKILL.md frontmatter: ${r.reason}")
            is SkillFrontmatterParser.Result.Ok -> r
            is SkillSource.GitHub -> Quad(source.owner, source.repo, source.ref, source.path)
            manifestPaths: List<String>?,
            marketplaces
            null
            rawSkillMd = skillMd,
            return if (exclude.isEmpty()) selected else selected.filter { it.substringAfterLast('/') !in exclude }
            return out.distinct()
            root: String,
            siblings
            skillDirs.map { dir ->
            treePaths: Set<String>,
            val hasSkillMd = { dir: String -> "$dir/SKILL.md" in treePaths }
            val obj = entry.jsonObject
            val out = mutableListOf<String>()
            val path = obj["path"]?.jsonPrimitive?.contentOrNull
            val plugins = root["plugins"] as? JsonArray ?: return emptyList()
            val root = runCatching { SharedJson.parseToJsonElement(jsonText).jsonObject }.getOrNull() ?: return emptyList()
            val selected = when {
            val type = obj["type"]?.jsonPrimitive?.contentOrNull
            }
            }.awaitAll().filterNotNull().sortedBy { it.id }
         * (`source` of `"./"` or absent) and normalizing `./skills/x` → `skills/x`.
         * Decides which skill folders to surface for a marketplace, given the repo's
         * Extracts skill folder paths from a `.claude-plugin/marketplace.json`.
         * Flattens every plugin's `skills` array, keeping only same-repo entries
         * Pure and side-effect-free so it can be unit-tested directly.
         * [manifestPaths] from marketplace.json, else every `<root>/<name>/SKILL.md`
         * and any whose folder name is in [exclude] is dropped. Pure so the selection
         * file [treePaths]. Precedence: an explicit [allowlist] wins, else the
         * folder. In all cases only folders that actually carry a `SKILL.md` are kept,
         * logic can be unit-tested without the network.
         */
        )
        ): List<String> {
        /**
        // An explicit allowlist skips the manifest fetch entirely.
        // Download the bundled files in parallel — sequential round-trips here were
        // One recursive tree call enumerates every file under the skill folder —
        // including nested ones — without a Contents API call per folder.
        // the main source of the install delay. Binaries and oversized files are dropped.
        DownloadedSkill(
        coroutineScope {
        fun parseMarketplaceManifest(jsonText: String): List<String> {
        fun selectSkillDirs(
        if (!response.status.isSuccess()) return emptySet()
        if (!response.status.isSuccess()) return null
        if (response.status == HttpStatusCode.NotFound) return null
        private const val MARKETPLACE_MANIFEST_PATH = ".claude-plugin/marketplace.json"
        private const val MAX_BUNDLED_FILE_CHARS = 256_000
        private val BINARY_EXTENSIONS = setOf(
        return response.bodyAsText()
        return treeArray.mapNotNull { entry ->
        val (owner, repo, ref) = Triple(marketplace.owner, marketplace.repo, marketplace.ref)
        val (owner, repo, ref, path) = when (source) {
        val body = response.bodyAsText()
        val files = coroutineScope {
        val manifest = if (marketplace.skills != null) {
        val parsed = when (val r = SkillFrontmatterParser.parse(skillMd)) {
        val response = client.get(url)
        val response = client.get(url) {
        val root = runCatching { json.parseToJsonElement(body).jsonObject }.getOrNull() ?: return emptySet()
        val siblings = tree
        val skillDirs = selectSkillDirs(treePaths, marketplace.skills, manifest, marketplace.root, marketplace.exclude)
        val skillMd = fetchRawFile(owner, repo, ref, "$path/SKILL.md")
        val tree = runCatching { fetchRepoTree(owner, repo, ref) }.getOrDefault(emptySet())
        val treeArray = root["tree"] as? JsonArray ?: return emptySet()
        val treePaths = fetchRepoTree(owner, repo, ref)
        val url = "https://api.github.com/repos/$owner/$repo/git/trees/$ref?recursive=1"
        val url = "https://raw.githubusercontent.com/$owner/$repo/$ref/$path"
        }
        } else {
        }.toSet()
     * (network, rate limit) drops only that source — the rest still return.
     * Browses every curated marketplace in parallel and returns the combined,
     * Downloads a skill's files from a GitHub repo/folder, ready to be written into
     * Lists the installable skills in one marketplace. Skill folders come from
     * Recursively lists every blob path in a repo via the git trees API — one
     * `.claude-plugin/marketplace.json` when present, otherwise from any folder
     * call instead of a Contents call per folder. Returns an empty set on failure.
     * de-duplicated list of installable skills. A single marketplace failing
     * downloaded with their relative paths. Binaries and oversized files are skipped.
     * text files (including nested ones, e.g. a skill's `core` scripts) are
     * the sandbox by [SkillManager]. The raw `SKILL.md` is kept verbatim; sibling
     * under [SkillMarketplace.root] that contains a `SKILL.md`.
     */
    /**
    /** File extensions that, if present in a skill folder, mark it sandbox-required. */
    companion object {
    private data class Quad(val a: String, val b: String, val c: String, val d: String)
    private suspend fun fetchRawFile(owner: String, repo: String, ref: String, path: String): String? {
    private suspend fun fetchRepoTree(owner: String, repo: String, ref: String): Set<String> {
    private val client: HttpClient = httpClient(),
    private val json: Json = SharedJson,
    private val sandboxExtensions = setOf("py", "sh", "js", "ts", "rb", "pl", "lua")
    suspend fun browseMarketplace(marketplace: SkillMarketplace): Result<List<RegistrySkillEntry>> = runCatching {
    suspend fun browseMarketplaces(marketplaces: List<SkillMarketplace>): Result<List<RegistrySkillEntry>> = runCatching {
    suspend fun fetchSkillFiles(source: SkillSource): Result<DownloadedSkill> = runCatching {
    }
 *
 * Browsing a marketplace is done with as few rate-limited GitHub *API* calls as
 * Fetches SKILL.md skills from public GitHub repositories.
 * `raw.githubusercontent.com`, which isn't subject to the 60-req/hour API cap.
 * find skill folders and to flag which ones bundle scripts), and everything else
 * possible: one recursive git-tree call per repo enumerates every path (used to
 * — `.claude-plugin/marketplace.json`, each `SKILL.md` — is fetched from
 */
) {
/**
class SkillRegistry(
}
