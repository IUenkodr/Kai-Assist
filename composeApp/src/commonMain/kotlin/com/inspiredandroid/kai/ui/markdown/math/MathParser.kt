import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

                                depth++
                                depth--
                                sub = if (sub == null) arg else Group(persistentListOf(sub, arg))
                                sup = if (sup == null) arg else Group(persistentListOf(sup, arg))
                            Space(0.3f),
                            Space(0.5f),
                            Sym("(", SymKind.OPEN),
                            Sym(")", SymKind.CLOSE),
                            Sym("mod", SymKind.FUNCTION),
                            arg,
                            i++
                            if (isSup) {
                            if (src[i] == '{') {
                            skipWhitespace()
                            sup = if (sup == null) primeAtom else Group(persistentListOf(sup, primeAtom))
                            val arg = parseAtom() ?: Group(persistentListOf())
                            val isSup = ch == '^'
                            val primeAtom = Sym(primes, SymKind.ORDINARY)
                            val primes = "′".repeat(i - start)
                            val start = i
                            while (i < len && src[i] == '\'') i++
                            }
                            } else if (src[i] == '}') {
                            } else {
                        ""
                        '\'' -> {
                        '_', '^' -> {
                        '{' -> "{"
                        '|' -> "‖"
                        '}' -> "}"
                        ),
                        else -> break
                        else -> first.toString()
                        i += "\\right".length
                        i++
                        if (i < len && src[i] == ']') i++
                        null
                        parse(indexLatex)
                        persistentListOf(
                        readDelimiter()
                        skipWhitespace()
                        sub = mergeOptional(base.sub, sub),
                        sup = mergeOptional(base.sup, sup),
                        val indexLatex = src.substring(indexStart, i)
                        val indexStart = i
                        var depth = 0
                        while (i < len && !(depth == 0 && src[i] == ']')) {
                        }
                    "Vert" -> "‖"
                    "langle" -> "⟨"
                    "lbrace" -> "{"
                    "lceil" -> "⌈"
                    "lfloor" -> "⌊"
                    "rangle" -> "⟩"
                    "rbrace" -> "}"
                    "rceil" -> "⌉"
                    "rfloor" -> "⌋"
                    "vert" -> "|"
                    )
                    // Emit digits/numbers as a single ORDINARY atom so that "123" stays tight.
                    // LaTeX comment to end of line.
                    // Orphan \right (outside a \left context) — emit a bare delim.
                    // Orphan `\end{…}` — eat the arg, emit nothing.
                    // Prime: treat the whole run `'''` as a single superscript glyph.
                    // \pmod{n} renders as " (mod n)".
                    // parseSequence stops at `\right` without consuming it; consume it now.
                    ?: Sym(src.substring(escapeStart, i), SymKind.ORDINARY)
                    Delim("(", ")", Frac(top, bottom, drawBar = false))
                    Delim(leftDelim, rightDelim, Group(inner.toImmutableList()))
                    Frac(num, den)
                    Group(
                    Group(inner.toImmutableList())
                    Group(persistentListOf())
                    Radical(index, radicand)
                    Styled(MathStyle.TEXT, persistentListOf(Sym(content, SymKind.ORDINARY)))
                    Sym("|", SymKind.ORDINARY)
                    Sym(c.toString(), SymKind.CLOSE)
                    Sym(c.toString(), SymKind.OPEN)
                    Sym(c.toString(), SymKind.ORDINARY)
                    Sym(c.toString(), SymKind.PUNCT)
                    Sym(c.toString(), SymKind.REL_OP)
                    Sym(c.toString(), SymKind.VARIABLE)
                    Sym(d, SymKind.CLOSE)
                    Sym(if (c == '*') "∗" else c.toString(), SymKind.BIN_OP)
                    Sym(primes, SymKind.ORDINARY)
                    Sym(src.substring(start, i), SymKind.ORDINARY)
                    break
                    continue
                    depth++
                    depth--
                    else -> ""
                    else -> Script(base, sub, sup)
                    finishCell()
                    finishRow()
                    i += "\\end".length
                    i += 2
                    i++
                    if (depth == 0) break
                    if (ended == envName) return
                    if (i < len && src[i] == '}') i++
                    is LargeOp -> base.copy(
                    parseEnvironment(envName)
                    readVerbatimGroup()
                    readVerbatimGroup() // consume {envname}; tolerate mismatched names
                    return when (first) {
                    skipWhitespace()
                    val arg = parseRequiredGroup()
                    val bottom = parseRequiredGroup()
                    val ch = src[i]
                    val content = readVerbatimGroup()
                    val d = readDelimiter()
                    val den = parseRequiredGroup()
                    val ended = readVerbatimGroup()
                    val envName = readVerbatimGroup()
                    val index = if (i < len && src[i] == '[') {
                    val inner = parseSequence(stopAtBrace = false)
                    val inner = parseSequence(stopAtBrace = true)
                    val leftDelim = readDelimiter()
                    val num = parseRequiredGroup()
                    val primes = "′".repeat(i - start)
                    val radicand = parseRequiredGroup()
                    val rightDelim = if (i < len && src[i] == '\\' && peekCommandName() == "right") {
                    val start = i
                    val top = parseRequiredGroup()
                    when (ch) {
                    while (i < len && (src[i].isDigit() || src[i] == '.' || src[i] == ',')) i++
                    while (i < len && src[i] != '\n') i++
                    while (i < len && src[i] == '\'') i++
                    }
                    } else {
                "bar" -> Accent(parseRequiredGroup(), AccentKind.BAR)
                "begin" -> {
                "binom", "dbinom", "tbinom" -> {
                "bmod" -> Sym("mod", SymKind.FUNCTION)
                "boldsymbol", "bm" -> Styled(MathStyle.BOLD_ITALIC, groupAsList(parseRequiredGroup()))
                "ddot" -> Accent(parseRequiredGroup(), AccentKind.DDOT)
                "dot" -> Accent(parseRequiredGroup(), AccentKind.DOT)
                "end" -> {
                "frac", "dfrac", "tfrac" -> {
                "hat" -> Accent(parseRequiredGroup(), AccentKind.HAT)
                "left" -> {
                "mathbb" -> Styled(MathStyle.DOUBLE_STRUCK, groupAsList(parseRequiredGroup()))
                "mathbf" -> Styled(MathStyle.BOLD, groupAsList(parseRequiredGroup()))
                "mathcal" -> Styled(MathStyle.CALLIGRAPHIC, groupAsList(parseRequiredGroup()))
                "mathit" -> Styled(MathStyle.ITALIC, groupAsList(parseRequiredGroup()))
                "mathrm", "operatorname" -> Styled(MathStyle.ROMAN, groupAsList(parseRequiredGroup()))
                "overline" -> Accent(parseRequiredGroup(), AccentKind.OVERLINE)
                "pmod" -> {
                "right" -> {
                "sqrt" -> {
                "text", "textrm", "textbf", "textit" -> {
                "tilde" -> Accent(parseRequiredGroup(), AccentKind.TILDE)
                "vec" -> Accent(parseRequiredGroup(), AccentKind.VEC)
                "widehat" -> Accent(parseRequiredGroup(), AccentKind.WIDEHAT)
                "widetilde" -> Accent(parseRequiredGroup(), AccentKind.WIDETILDE)
                // Unknown environment — swallow body up to the matching \end{envName}.
                base = when (base) {
                break // one script group per base atom is enough; the outer loop has already done its job
                c == '(' || c == '[' -> {
                c == ')' || c == ']' -> {
                c == '+' || c == '-' || c == '*' || c == '/' -> {
                c == ';' || c == ':' -> {
                c == '=' || c == '<' || c == '>' -> {
                c == '\'' -> {
                c == '\\' -> parseCommand()
                c == '{' -> {
                c == '|' -> {
                c == '}' -> null
                c.isDigit() || c == '.' || c == ',' -> {
                c.isLetter() -> {
                cell += attachScripts(atom)
                cell = mutableListOf()
                else -> MathSymbols.lookup(name)
                else -> {
                finishCell()
                i++
                if (!first.isLetter()) {
                if (c != '_' && c != '^' && c != '\'') break
                if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                if (c == '&') {
                if (c == '\\' && peekCommandName() == "\\") {
                if (c == '\\' && peekCommandName() == "end") {
                if (c == '\\' && peekCommandName() == "right") break
                if (c == '{') {
                if (i < len && src[i] == '}') i++
                if (i >= len) break
                if (i >= len) return "\\"
                if (src[i] == '\\' && peekCommandName() == "end") {
                if (stopAtBrace && c == '}') break
                result += withScripts
                return Group(persistentListOf())
                return MathSymbols.lookup(name) ?: Sym("\\$name", SymKind.ORDINARY)
                return if (inner.size == 1) inner[0] else Group(inner.toImmutableList())
                return when (name) {
                row += if (cell.size == 1) cell[0] else Group(cell.toImmutableList())
                row = mutableListOf()
                rows += row.toImmutableList()
                rows.removeAt(rows.lastIndex)
                skipToEnd(envName)
                skipWhitespace()
                skipWhitespaceAndComments()
                val atom = parseAtom() ?: continue
                val c = src[i]
                val first = src[i]
                val inner = parseSequence(stopAtBrace = true)
                val name = first.toString()
                val name = src.substring(nameStart, i)
                val nameStart = i
                val withScripts = attachScripts(atom)
                var sub: MathAtom? = null
                var sup: MathAtom? = null
                while (i < len && src[i].isLetter()) i++
                while (i < len) {
                }
                } else if (c == '%') {
                } else if (c == '}') {
                } else {
            // Absolute-last-resort fallback: raw text. Should be rare.
            // Drop a trailing blank row produced by `\\ ` right before `\end{…}`.
            // Entered pointing at '\'. Handle single-char escapes and environment markers first.
            // Single non-letter escape like `\{`, `\$`, `\,`, `\;`, `\!`, `\|`, `\\`
            // Single token (e.g. `\frac 1 2`)
            Sym(latex, SymKind.ORDINARY)
            a == null -> b
            b == null -> a
            else -> Group(persistentListOf(a, b))
            else -> persistentListOf(atom)
            fun finishCell() {
            fun finishRow() {
            i++
            if (!c.isLetter()) return c.toString()
            if (!first.isLetter()) {
            if (atoms.size == 1) atoms[0] else Group(atoms.toImmutableList())
            if (c == '\\') {
            if (cell.isNotEmpty() || row.isNotEmpty()) finishRow()
            if (i + 1 >= len) return "\\"
            if (i < len && src[i] == '}') i++
            if (i >= len || src[i] != '\\') return ""
            if (i >= len || src[i] != '{') return ""
            if (i >= len) return ""
            if (i >= len) return Group(persistentListOf())
            if (i >= len) return Sym("\\", SymKind.ORDINARY)
            if (i >= len) return null
            if (rows.isNotEmpty() && rows.last().all { it is Group && it.atoms.isEmpty() }) {
            if (src[i] == '{') {
            is Group -> atom.atoms
            return Matrix(rows.toImmutableList(), delim, align)
            return base
            return if (c == '.') "" else c.toString()
            return parseAtom() ?: Group(persistentListOf())
            return parseMatrixBody(envName, spec.delim, spec.align)
            return result
            return src.substring(i + 1, j)
            return src.substring(start, end)
            return when (name) {
            return when {
            skipWhitespace()
            skipWhitespaceAndComments()
            val atoms = parser.parseSequence(stopAtBrace = false)
            val c = src[i + 1]
            val c = src[i]
            val end = i
            val escapeStart = i
            val first = src[i]
            val name = src.substring(nameStart, i)
            val nameStart = i
            val parser = ParserState(latex)
            val result = mutableListOf<MathAtom>()
            val rows = mutableListOf<ImmutableList<MathAtom>>()
            val spec = MATRIX_ENVIRONMENTS[envName] ?: run {
            val start = i
            var base = initial
            var cell = mutableListOf<MathAtom>()
            var depth = 1
            var j = i + 1
            var row = mutableListOf<MathAtom>()
            while (i < len && (src[i] == ' ' || src[i] == '\t' || src[i] == '\n' || src[i] == '\r')) {
            while (i < len && depth > 0) {
            while (i < len && src[i].isLetter()) i++
            while (i < len) {
            while (j < len && src[j].isLetter()) j++
            }
         *  - EOF
         *  - `\right` (always — the caller handles whether that was expected)
         *  - `}` if [stopAtBrace]
         * Parse a flat sequence of atoms until we hit:
         */
        "Bmatrix" to EnvSpec(MatrixDelim.BRACE, MatrixAlign.CENTERED),
        "Vmatrix" to EnvSpec(MatrixDelim.DBLVBAR, MatrixAlign.CENTERED),
        "align" to EnvSpec(MatrixDelim.NONE, MatrixAlign.ALIGN_RL),
        "align*" to EnvSpec(MatrixDelim.NONE, MatrixAlign.ALIGN_RL),
        "aligned" to EnvSpec(MatrixDelim.NONE, MatrixAlign.ALIGN_RL),
        "aligned*" to EnvSpec(MatrixDelim.NONE, MatrixAlign.ALIGN_RL),
        "bmatrix" to EnvSpec(MatrixDelim.BRACKET, MatrixAlign.CENTERED),
        "cases" to EnvSpec(MatrixDelim.CASES, MatrixAlign.LEFT),
        "matrix" to EnvSpec(MatrixDelim.NONE, MatrixAlign.CENTERED),
        "pmatrix" to EnvSpec(MatrixDelim.PAREN, MatrixAlign.CENTERED),
        "vmatrix" to EnvSpec(MatrixDelim.VBAR, MatrixAlign.CENTERED),
        /**
        fun parseSequence(stopAtBrace: Boolean): List<MathAtom> {
        if (latex.isBlank()) return Group(persistentListOf())
        private fun attachScripts(initial: MathAtom): MathAtom {
        private fun groupAsList(atom: MathAtom): ImmutableList<MathAtom> = when (atom) {
        private fun mergeOptional(a: MathAtom?, b: MathAtom?): MathAtom? = when {
        private fun parseAtom(): MathAtom? {
        private fun parseCommand(): MathAtom {
        private fun parseEnvironment(envName: String): MathAtom {
        private fun parseMatrixBody(envName: String, delim: MatrixDelim, align: MatrixAlign): Matrix {
        private fun parseRequiredGroup(): MathAtom {
        private fun peekCommandName(): String {
        private fun readDelimiter(): String {
        private fun readVerbatimGroup(): String {
        private fun skipToEnd(envName: String) {
        private fun skipWhitespace() {
        private fun skipWhitespaceAndComments() {
        return try {
        val len = src.length
        var i = 0
        }
        } catch (_: Throwable) {
    )
    fun parse(latex: String): MathAtom {
    private class ParserState(val src: String) {
    private data class EnvSpec(val delim: MatrixDelim, val align: MatrixAlign)
    private val MATRIX_ENVIRONMENTS = mapOf(
    }
 *
 *              | '\<name>' (looked up via [MathSymbols])
 *              | '\frac' group group
 *              | '\left' delim expr '\right' delim
 *              | '\mathbb' group | '\mathbf' group | ...
 *              | '\sqrt' ('[' expr ']')? group
 *              | single-char
 *   atom      := '{' expr '}'
 *   expr      := atom* (handled by parseSequence)
 *   script-suffix := ('_' atom | '^' atom)+   (attached to preceding atom)
 * - Unknown commands render as literal `\name` text.
 * - Unmatched `\left`/`\right` close with a blank delimiter.
 * - Unmatched braces close at end-of-input.
 * Parses a LaTeX math fragment into a [MathAtom] tree. Robust to malformed input:
 * The grammar covered, roughly:
 */
/**
internal object MathParser {
package com.inspiredandroid.kai.ui.markdown.math
}
