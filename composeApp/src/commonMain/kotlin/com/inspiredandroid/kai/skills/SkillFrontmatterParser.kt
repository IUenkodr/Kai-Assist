package com.inspiredandroid.kai.skills

                "description" -> description = value
                "name" -> name = value
            if (line.isBlank() || line.startsWith("#")) continue
            if (sepIdx <= 0) continue
            return Result.Err("Frontmatter not closed (expected a second '---').")
            return Result.Err("Missing frontmatter (must start with '---').")
            val key = line.substring(0, sepIdx).trim()
            val line = rawLine.trimEnd()
            val sepIdx = line.indexOf(':')
            val value = line.substring(sepIdx + 1).trim().trim('"', '\'')
            when (key) {
            }
        data class Err(val reason: String) : Result()
        data class Ok(val id: String, val description: String, val body: String) : Result()
        for (rawLine in frontmatter.split('\n')) {
        if (!idRegex.matches(id)) return Result.Err("'name' must be lowercase letters, digits, and hyphens only.")
        if (!normalized.startsWith("---\n")) {
        if (closeIdx < 0) {
        if (desc.isEmpty()) return Result.Err("'description' must be non-empty.")
        if (desc.length > 1024) return Result.Err("'description' must be ≤ 1024 characters.")
        if (id.length > 64) return Result.Err("'name' must be ≤ 64 characters.")
        part.replaceFirstChar { it.titlecase() }
        return Result.Ok(id, desc, body)
        val afterOpen = normalized.removePrefix("---\n")
        val body = afterOpen.substring(closeIdx + 4).trimStart('\n')
        val closeIdx = afterOpen.indexOf("\n---")
        val desc = description ?: return Result.Err("Missing 'description' in frontmatter.")
        val frontmatter = afterOpen.substring(0, closeIdx)
        val id = name ?: return Result.Err("Missing 'name' in frontmatter.")
        val normalized = source.replace("\r\n", "\n").trimStart()
        var description: String? = null
        var name: String? = null
        }
    fun displayName(id: String): String = id.split('-').joinToString(" ") { part ->
    fun parse(source: String): Result {
    private val idRegex = Regex("^[a-z0-9]+(?:-[a-z0-9]+)*$")
    sealed class Result {
    }
 * Anthropic's validation rules (id ≤ 64 chars, lowercase letters/digits/hyphens
 * Tiny YAML-subset parser for SKILL.md frontmatter. Only handles `name` and
 * `description` fields — anything else in the frontmatter is ignored. Mirrors
 * only; description ≤ 1024 chars, non-empty).
 */
/**
object SkillFrontmatterParser {
}
