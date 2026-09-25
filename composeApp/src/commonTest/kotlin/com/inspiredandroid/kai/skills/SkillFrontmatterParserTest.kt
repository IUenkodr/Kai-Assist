import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

            ---
            Use the bundled script to extract text.
            description: Extract and manipulate PDF files.
            name: pdf-tools
        """.trimIndent()
        assertEquals("A thing", result.description)
        assertEquals("Body line", result.body)
        assertEquals("Extract and manipulate PDF files.", result.description)
        assertEquals("Pdf Tools", SkillFrontmatterParser.displayName("pdf-tools"))
        assertEquals("Single", SkillFrontmatterParser.displayName("single"))
        assertEquals("Use the bundled script to extract text.", result.body)
        assertEquals("my-skill", result.id)
        assertEquals("pdf-tools", result.id)
        assertIs<SkillFrontmatterParser.Result.Err>(result)
        assertIs<SkillFrontmatterParser.Result.Ok>(result)
        assertTrue(result.id == "ok-name")
        val longName = "a".repeat(65)
        val result = SkillFrontmatterParser.parse("---\nname: $longName\ndescription: ok\n---\nbody")
        val result = SkillFrontmatterParser.parse("---\nname: x\ndescription: y\n")
        val result = SkillFrontmatterParser.parse("just some text without frontmatter")
        val result = SkillFrontmatterParser.parse(source)
        val source = """
        val source = "---\nname: Bad_Name\ndescription: ok\n---\nbody"
        val source = "---\nname: ok-name\n---\nbody"
        val source = "---\nname: ok-name\nlicense: MIT\ndescription: ok\nversion: 1.0\n---\nbody"
        val source = "---\r\nname: \"my-skill\"\r\ndescription: 'A thing'\r\n---\r\nBody line"
    @Test
    fun `displayName titlecases hyphenated id`() {
    fun `ignores unknown frontmatter keys`() {
    fun `parses name description and body`() {
    fun `rejects invalid id characters`() {
    fun `rejects missing description`() {
    fun `rejects missing frontmatter`() {
    fun `rejects overlong id`() {
    fun `rejects unclosed frontmatter`() {
    fun `tolerates CRLF and quoted values`() {
    }
class SkillFrontmatterParserTest {
package com.inspiredandroid.kai.skills
}
