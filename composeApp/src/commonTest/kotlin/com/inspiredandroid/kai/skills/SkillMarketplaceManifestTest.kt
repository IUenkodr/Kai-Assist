
                { "name": "document-skills", "source": "./", "skills": ["./skills/xlsx", "./skills/pdf"] },
                { "name": "example-skills", "source": "./", "skills": ["./skills/canvas-design"] }
                { "name": "local", "source": "./", "skills": ["./skills/a"] },
                { "name": "remote", "source": "https://github.com/other/repo", "skills": ["./skills/b"] }
                { "source": "./", "skills": ["./skills/a", "./skills/a"] },
                { "source": "./", "skills": ["skills/a"] }
              "name": "anthropic-agent-skills",
              "plugins": [
              ]
            ] }
            allowlist = listOf("skills/pdf", "skills/missing"),
            allowlist = null,
            exclude = setOf("docx"),
            manifestPaths = listOf("skills/docx"),
            manifestPaths = listOf("skills/pdf", "skills/docx"),
            root = "skills",
            treePaths = tree,
            {
            { "plugins": [
            }
        """.trimIndent()
        "README.md",
        "skills/docx/SKILL.md",
        "skills/nested/sub/SKILL.md",
        "skills/pdf/SKILL.md",
        "skills/pdf/reference.md",
        )
        assertEquals(listOf("skills/a"), SkillRegistry.parseMarketplaceManifest(manifest))
        assertEquals(listOf("skills/a"), paths)
        assertEquals(listOf("skills/docx", "skills/pdf"), dirs)
        assertEquals(listOf("skills/pdf"), dirs)
        assertEquals(listOf("skills/pdf", "skills/docx"), dirs)
        assertEquals(listOf("skills/xlsx", "skills/pdf", "skills/canvas-design"), paths)
        assertTrue(SkillRegistry.parseMarketplaceManifest("""{ "plugins": [ { "name": "x" } ] }""").isEmpty())
        assertTrue(SkillRegistry.parseMarketplaceManifest("not json").isEmpty())
        assertTrue(SkillRegistry.parseMarketplaceManifest("{}").isEmpty())
        val dirs = SkillRegistry.selectSkillDirs(
        val dirs = SkillRegistry.selectSkillDirs(tree, null, listOf("skills/pdf", "skills/docx"), "skills")
        val dirs = SkillRegistry.selectSkillDirs(tree, null, null, "skills").sorted()
        val manifest = """
        val manifest = """{ "plugins": [ { "name": "x", "skills": ["skills/a"] } ] }"""
        val paths = SkillRegistry.parseMarketplaceManifest(manifest)
    )
    @Test
    fun `allowlist takes precedence and keeps only folders with a SKILL_md`() {
    fun `de-duplicates repeated paths`() {
    fun `exclude drops skills by folder name`() {
    fun `flattens and normalizes skill paths across plugins`() {
    fun `folder scrape finds direct children under root only`() {
    fun `manifest used when no allowlist`() {
    fun `returns empty on missing plugins or malformed json`() {
    fun `skips plugins sourced from a different repo`() {
    fun `tolerates absent source as same-repo`() {
    private val tree = setOf(
    }
class SkillMarketplaceManifestTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.skills
}
