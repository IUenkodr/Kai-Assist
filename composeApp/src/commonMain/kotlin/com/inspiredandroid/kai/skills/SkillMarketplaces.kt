
            "brand-guidelines",
            "canvas-design",
            "claude-api",
            "doc-coauthoring",
            "frontend-design",
            "internal-comms",
            "mcp-builder",
            "skill-creator",
            "skills/brainstorming",
            "skills/writing-plans",
            "theme-factory",
            "web-artifacts-builder",
            "webapp-testing",
        ),
        exclude = setOf(
        name = "Anthropic",
        name = "Superpowers",
        owner = "anthropics",
        owner = "obra",
        ref = "main",
        repo = "skills",
        repo = "superpowers",
        root = "skills",
        skills = listOf(
     * Applied after the allowlist/manifest/folder-scan selection.
     * Optional allowlist of specific skill folder paths to surface from this repo.
     * Skill folder names to hide from this repo's listing — used to drop skills
     * When set, only these are browsed (the repo's marketplace.json / folder scan is
     * ignored) — used to cherry-pick the broadly-useful skills from a large repo
     * that don't work well on Kai while still surfacing the rest of the repo.
     * without flooding the list with ones that don't fit a mobile assistant.
     */
    ),
    /**
    /** Folder under which skill subfolders live, used only when no marketplace.json is present. */
    // The most popular Claude-skills repo (Anthropic-accepted). It's a software-dev
    // code review, subagent dispatch, debugging, verification).
    // methodology, so we surface only its general "how to work" skills — ideation and
    // planning — and skip the Claude-Code-internal or coding-flow ones (git worktrees,
    SkillMarketplace(
    val exclude: Set<String> = emptySet(),
    val name: String,
    val owner: String,
    val ref: String = "main",
    val repo: String,
    val root: String = "skills",
    val skills: List<String>? = null,
 *
 * (pdf/docx/xlsx/pptx, algorithmic-art, slack-gif-creator) and exclude the rest —
 * A skill marketplace: a public GitHub repo that hosts SKILL.md skills. The
 * The curated set ([curatedSkillMarketplaces]) is intentionally small and vetted:
 * Vetted marketplaces shown in the browse dialog. From Anthropic's official repo
 * an arbitrary repo via the "Install from GitHub" field.
 * assistant. Add further trusted repos here.
 * favors trustworthy sources over breadth. Users can still install any skill from
 * index when present, falling back to scraping skill folders under [root].
 * mostly Claude.ai/Claude-Code-oriented ones that don't translate to a mobile
 * registry browses each one — preferring its `.claude-plugin/marketplace.json`
 * skills bundle scripts that run in the Linux sandbox, so the suggested list
 * we keep the document/data and creative skills that work well in Kai
 */
)
/**
data class SkillMarketplace(
package com.inspiredandroid.kai.skills
val curatedSkillMarketplaces: List<SkillMarketplace> = listOf(
