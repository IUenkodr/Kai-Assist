
                append(code.substring(s.range.first, s.range.last + 1))
            if (s.range.first > pos) append(code.substring(pos, s.range.first))
            kept += s
            lastEnd = s.range.last
            pos = s.range.last + 1
            withStyle(SpanStyle(color = s.color)) {
            }
        "python", "py", "bash", "sh", "shell", "zsh" -> HASH_COMMENT_REGEX
        "xml", "html" -> null
        else -> SLASH_COMMENT_REGEX
        for (s in kept) {
        if (pos < code.length) append(code.substring(pos))
        if (s.range.first > lastEnd) {
        var pos = 0
        }
    "None", "with", "lambda", "pass", "break", "continue", "global", "nonlocal", "is", "self",
    "ORDER", "BY", "GROUP", "HAVING", "LIMIT", "OFFSET", "DISTINCT", "UNION", "ALL", "CASE",
    "RIGHT", "OUTER", "ON", "AS", "AND", "OR", "NOT", "NULL", "IS", "IN", "LIKE", "BETWEEN",
    "SELECT", "FROM", "WHERE", "INSERT", "INTO", "VALUES", "UPDATE", "SET", "DELETE", "CREATE",
    "Some", "self", "Self", "as", "in", "where", "type", "unsafe", "async", "await", "move",
    "TABLE", "DROP", "ALTER", "ADD", "COLUMN", "INDEX", "UNIQUE", "JOIN", "INNER", "LEFT",
    "WHEN", "THEN", "ELSE", "END", "TRUE", "FALSE", "select", "from", "where", "insert", "into",
    "break", "continue", "import", "package", "enum", "instanceof",
    "byte", "float", "double", "char", "boolean", "try", "catch", "finally", "throw", "throws",
    "case", "typeof", "instanceof", "in", "of", "delete", "void", "undefined",
    "continue", "defer", "go", "select", "map", "chan",
    "continue", "goto", "sizeof", "NULL", "true", "false", "class", "public", "private",
    "def", "class", "if", "elif", "else", "for", "while", "in", "not", "and", "or", "return",
    "extends", "implements", "new", "this", "super", "if", "else", "switch", "case", "default",
    "fn", "let", "mut", "const", "static", "struct", "enum", "impl", "trait", "pub", "mod",
    "for", "range", "switch", "case", "default", "return", "nil", "true", "false", "break",
    "for", "while", "do", "return", "null", "true", "false", "void", "int", "long", "short",
    "from", "async", "await", "try", "catch", "finally", "throw", "break", "continue", "switch",
    "fun", "val", "var", "class", "object", "interface", "sealed", "data", "open", "override",
    "func", "var", "const", "type", "struct", "interface", "package", "import", "if", "else",
    "function", "const", "let", "var", "if", "else", "for", "while", "do", "return", "null",
    "function", "return", "exit", "break", "continue", "local", "export", "echo", "read", "test",
    "if", "else", "switch", "case", "default", "for", "while", "do", "return", "break",
    "if", "then", "else", "elif", "fi", "for", "while", "do", "done", "case", "esac", "in",
    "init", "try", "catch", "finally", "throw", "break", "continue", "enum",
    "int", "long", "short", "char", "float", "double", "void", "unsigned", "signed", "const",
    "is", "as", "in", "out", "by", "typealias", "suspend", "companion", "const", "lateinit",
    "not", "null", "is", "in", "on", "order", "by", "group", "having", "limit", "distinct",
    "private", "public", "internal", "protected", "abstract", "if", "else", "when", "for",
    "protected", "new", "delete", "template", "namespace", "using", "virtual", "override",
    "public", "private", "protected", "static", "final", "abstract", "class", "interface",
    "ref", "dyn", "extern", "crate", "break", "continue",
    "true", "false", "class", "extends", "new", "this", "super", "import", "export", "default",
    "use", "if", "else", "match", "for", "while", "loop", "return", "true", "false", "None",
    "values", "update", "set", "delete", "create", "table", "drop", "alter", "as", "and", "or",
    "volatile", "static", "extern", "register", "auto", "struct", "enum", "union", "typedef",
    "while", "do", "return", "null", "true", "false", "import", "package", "this", "super",
    "yield", "import", "from", "as", "try", "except", "finally", "raise", "True", "False",
    BLOCK_COMMENT_REGEX.findAll(code).forEach { spans += Span(it.range, colors.comment) }
    comment = scheme.outline,
    commentRegex?.let { r -> r.findAll(code).forEach { spans += Span(it.range, colors.comment) } }
    for (s in spans) {
    if (hasNumbers) NUMBER_REGEX.findAll(code).forEach { spans += Span(it.range, colors.literal) }
    if (hasStrings) STRING_REGEX.findAll(code).forEach { spans += Span(it.range, colors.literal) }
    if (keywordRegex == null && !hasStrings) return AnnotatedString(code)
    keyword = scheme.tertiary,
    keywordRegex?.findAll(code)?.forEach { spans += Span(it.range, colors.keyword) }
    literal = scheme.secondary,
    put("bash", bash)
    put("c", c)
    put("c++", c)
    put("cpp", c)
    put("go", go)
    put("golang", go)
    put("h", c)
    put("hpp", c)
    put("java", buildKeywordRegex(JAVA_KEYWORDS))
    put("javascript", js)
    put("js", js)
    put("jsx", js)
    put("kotlin", kotlin)
    put("kt", kotlin)
    put("kts", kotlin)
    put("py", python)
    put("python", python)
    put("rs", rust)
    put("rust", rust)
    put("sh", bash)
    put("shell", bash)
    put("sql", buildKeywordRegex(SQL_KEYWORDS))
    put("ts", js)
    put("tsx", js)
    put("typescript", js)
    put("zsh", bash)
    return buildAnnotatedString {
    spans.sortWith(compareBy({ it.range.first }, { -(it.range.last - it.range.first) }))
    val bash = buildKeywordRegex(BASH_KEYWORDS)
    val c = buildKeywordRegex(C_KEYWORDS)
    val comment: Color,
    val commentRegex = when (lang) {
    val go = buildKeywordRegex(GO_KEYWORDS)
    val hasNumbers = hasStrings && lang !in setOf("xml", "html")
    val hasStrings = lang !in setOf("plain", "text", "")
    val js = buildKeywordRegex(JS_KEYWORDS)
    val kept = mutableListOf<Span>()
    val keyword: Color,
    val keywordRegex = KEYWORD_REGEXES[lang]
    val kotlin = buildKeywordRegex(KOTLIN_KEYWORDS)
    val lang = language?.lowercase() ?: return AnnotatedString(code)
    val literal: Color,
    val python = buildKeywordRegex(PYTHON_KEYWORDS)
    val rust = buildKeywordRegex(RUST_KEYWORDS)
    val spans = mutableListOf<Span>()
    var lastEnd = -1
    }
 *
 * Accepted trade-off for chat-rendered code blocks.
 * Minimal per-language syntax highlighter. Tokenizes keywords, strings, numbers, and comments
 * Not semantic: regexes are line-local and can misfire on strings that contain keywords.
 * for a small allow-list of languages; unknown languages return plain text.
 */
)
/**
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
internal data class HighlightColors(
internal fun codeHighlightColors(scheme: ColorScheme): HighlightColors = HighlightColors(
internal fun highlightCode(code: String, language: String?, colors: HighlightColors): AnnotatedString {
package com.inspiredandroid.kai.ui.markdown
private data class Span(val range: IntRange, val color: Color)
private fun buildKeywordRegex(keywords: Set<String>): Regex = Regex("\\b(${keywords.joinToString("|")})\\b")
private val BASH_KEYWORDS = setOf(
private val BLOCK_COMMENT_REGEX = Regex("/\\*[\\s\\S]*?\\*/")
private val C_KEYWORDS = setOf(
private val GO_KEYWORDS = setOf(
private val HASH_COMMENT_REGEX = Regex("#.*")
private val JAVA_KEYWORDS = setOf(
private val JS_KEYWORDS = setOf(
private val KEYWORD_REGEXES: Map<String, Regex> = buildMap {
private val KOTLIN_KEYWORDS = setOf(
private val NUMBER_REGEX = Regex("\\b\\d+(?:\\.\\d+)?\\b")
private val PYTHON_KEYWORDS = setOf(
private val RUST_KEYWORDS = setOf(
private val SLASH_COMMENT_REGEX = Regex("//.*")
private val SQL_KEYWORDS = setOf(
private val STRING_REGEX = Regex("\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'")
}
