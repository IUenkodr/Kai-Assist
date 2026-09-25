
        assertEquals(SkillSource.GitHub("anthropics", "skills", "main", ""), source)
        assertEquals(SkillSource.GitHub("anthropics", "skills", "main", "skills/pdf"), source)
        assertEquals(SkillSource.GitHub("owner", "repo", "dev", "path/to/skill"), source)
        assertEquals(SkillSource.GitHub("owner", "repo", "main", ""), source)
        assertNull(parseGitHubSkillUrl("   "))
        assertNull(parseGitHubSkillUrl(""))
        assertNull(parseGitHubSkillUrl("onlyowner"))
        val source = parseGitHubSkillUrl("anthropics/skills")
        val source = parseGitHubSkillUrl("anthropics/skills/skills/pdf")
        val source = parseGitHubSkillUrl("https://github.com/anthropics/skills")
        val source = parseGitHubSkillUrl("https://github.com/owner/repo/")
        val source = parseGitHubSkillUrl("https://github.com/owner/repo/tree/dev/path/to/skill")
    @Test
    fun `parses full https url`() {
    fun `parses owner repo path assuming main`() {
    fun `parses owner slash repo`() {
    fun `parses tree ref and path`() {
    fun `returns null for too few segments`() {
    fun `strips trailing slash`() {
    }
class GitHubSkillUrlTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
package com.inspiredandroid.kai.skills
}
