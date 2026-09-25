import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf

        // From the GitHub issue's example.
        // Should degrade without crashing.
        // Structure: x, =, Frac
        assertEquals("", atom.left)
        assertEquals("(", atom.left)
        assertEquals(")", atom.right)
        assertEquals("hello world", inner.text)
        assertEquals("lim", lim.symbol)
        assertEquals("|", atom.right)
        assertEquals("′′", sup.text)
        assertEquals("∑", first.symbol)
        assertEquals("∫", op.symbol)
        assertEquals(1, atom.rows.size)
        assertEquals(1, atoms.size)
        assertEquals(2, atom.rows.size)
        assertEquals(2, atom.rows[0].size)
        assertEquals(2, sup.atoms.size)
        assertEquals(AccentKind.HAT, atom.kind)
        assertEquals(AccentKind.OVERLINE, atom.kind)
        assertEquals(AccentKind.VEC, atom.kind)
        assertEquals(Group(persistentListOf()), result)
        assertEquals(MathStyle.BOLD_ITALIC, atom.style)
        assertEquals(MathStyle.DOUBLE_STRUCK, atom.style)
        assertEquals(MathStyle.TEXT, atom.style)
        assertEquals(MatrixAlign.ALIGN_RL, atom.alignMode)
        assertEquals(MatrixAlign.LEFT, atom.alignMode)
        assertEquals(MatrixDelim.BRACKET, b.delim)
        assertEquals(MatrixDelim.CASES, atom.delim)
        assertEquals(MatrixDelim.NONE, atom.delim)
        assertEquals(MatrixDelim.PAREN, atom.delim)
        assertEquals(MatrixDelim.VBAR, v.delim)
        assertEquals(Sym("123", SymKind.ORDINARY), atoms[0])
        assertEquals(Sym("2", SymKind.ORDINARY), atom.sup)
        assertEquals(Sym("3", SymKind.ORDINARY), withIndex.index)
        assertEquals(Sym("=", SymKind.REL_OP), atoms[1])
        assertEquals(Sym("\\wibble", SymKind.ORDINARY), atom)
        assertEquals(Sym("a", SymKind.VARIABLE), atom.num)
        assertEquals(Sym("a", SymKind.VARIABLE), atom.rows[0][0])
        assertEquals(Sym("a", SymKind.VARIABLE), op.sub)
        assertEquals(Sym("b", SymKind.VARIABLE), atom.den)
        assertEquals(Sym("b", SymKind.VARIABLE), op.sup)
        assertEquals(Sym("d", SymKind.VARIABLE), atom.rows[1][1])
        assertEquals(Sym("i", SymKind.VARIABLE), atom.sub)
        assertEquals(Sym("i", SymKind.VARIABLE), sup.atoms[0])
        assertEquals(Sym("k", SymKind.VARIABLE), frac.den)
        assertEquals(Sym("mod", SymKind.FUNCTION), parse("\\bmod"))
        assertEquals(Sym("n", SymKind.VARIABLE), frac.num)
        assertEquals(Sym("sin", SymKind.FUNCTION), atom)
        assertEquals(Sym("x", SymKind.VARIABLE), atom.base)
        assertEquals(Sym("x", SymKind.VARIABLE), atoms[0])
        assertEquals(Sym("x", SymKind.VARIABLE), plain.radicand)
        assertEquals(Sym("x", SymKind.VARIABLE), result)
        assertEquals(Sym("Σ", SymKind.ORDINARY), parse("\\Sigma"))
        assertEquals(Sym("α", SymKind.VARIABLE), parse("\\alpha"))
        assertEquals(Sym("π", SymKind.VARIABLE), parse("\\pi"))
        assertEquals(Sym("π", SymKind.VARIABLE), sup.atoms[1])
        assertEquals(Sym("⟶", SymKind.REL_OP), atoms[1])
        assertEquals(Sym("⟹", SymKind.REL_OP), parse("\\implies"))
        assertEquals(Sym("⟺", SymKind.REL_OP), parse("\\iff"))
        assertEquals(SymKind.FUNCTION, op.kind)
        assertEquals(null, atom.sub)
        assertEquals(null, plain.index)
        assertNotNull(first.sub)
        assertNotNull(first.sup)
        assertNotNull(lim.sub)
        assertNotNull(op)
        assertTrue(!frac.drawBar)
        assertTrue(atom is Accent)
        assertTrue(atom is Delim)
        assertTrue(atom is Frac)
        assertTrue(atom is Group)
        assertTrue(atom is Matrix)
        assertTrue(atom is Script)
        assertTrue(atom is Styled)
        assertTrue(atom.atoms.isEmpty())
        assertTrue(atom.num is Frac)
        assertTrue(atoms[0] is LargeOp)
        assertTrue(atoms[2] is Frac)
        assertTrue(first is LargeOp)
        assertTrue(lim is LargeOp)
        assertTrue(op is LargeOp)
        assertTrue(plain is Radical)
        assertTrue(withIndex is Radical)
        else -> listOf(atom)
        is Group -> atom.atoms
        val atom = parse("\\begin{aligned} x &= 1 \\\\ y &= 2 \\end{aligned}")
        val atom = parse("\\begin{cases} x & x > 0 \\\\ 0 & \\text{else} \\end{cases}")
        val atom = parse("\\begin{pmatrix} a & b \\\\ c & d \\end{pmatrix}")
        val atom = parse("\\begin{pmatrix} a & b")
        val atom = parse("\\begin{unknown} x + y \\end{unknown}")
        val atom = parse("\\binom{n}{k}")
        val atom = parse("\\boldsymbol{\\alpha}")
        val atom = parse("\\frac{\\frac{1}{2}}{3}")
        val atom = parse("\\frac{a")
        val atom = parse("\\frac{a}{b}")
        val atom = parse("\\hat{x")
        val atom = parse("\\hat{x}")
        val atom = parse("\\int_a^b f(x) dx")
        val atom = parse("\\int_a^b x^2 \\arctan(x)\\,dx")
        val atom = parse("\\left( x + 1 \\right)")
        val atom = parse("\\left. x \\right|")
        val atom = parse("\\lim_{x \\to 0} f(x)")
        val atom = parse("\\mathbb{R}")
        val atom = parse("\\overline{AB}")
        val atom = parse("\\pmod{n}") as Group
        val atom = parse("\\sin")
        val atom = parse("\\sum_{i=0}^{n} i")
        val atom = parse("\\text{hello world}")
        val atom = parse("\\vec{v}")
        val atom = parse("\\wibble")
        val atom = parse("a \\to b")
        val atom = parse("e^{i\\pi}")
        val atom = parse("f''")
        val atom = parse("x = \\frac{-b \\pm \\sqrt{b^2 - 4ac}}{2a}")
        val atom = parse("x^2")
        val atom = parse("x_i")
        val atom = parse("x_i^2")
        val atoms = (atom as Group).atoms
        val atoms = group(parse("123"))
        val b = parse("\\begin{bmatrix} 1 \\end{bmatrix}") as Matrix
        val first = (atom as Group).atoms[0]
        val frac = atom.content as Frac
        val inner = atom.atoms.single() as Sym
        val lim = (atom as Group).atoms[0]
        val op = atom.atoms.filterIsInstance<Sym>().firstOrNull { it.text == "mod" }
        val op = atoms[0]
        val plain = parse("\\sqrt{x}")
        val result = parse("")
        val result = parse("x")
        val sup = atom.sup as Group
        val sup = atom.sup as Sym
        val v = parse("\\begin{vmatrix} 1 \\end{vmatrix}") as Matrix
        val withIndex = parse("\\sqrt[3]{x}")
    // ── New-construct coverage ──────────────────────────────────────────────────────────────
    @Test
    fun `aligned uses ALIGN_RL mode and no delimiters`() {
    fun `arrow relation`() {
    fun `binom parses as parenthesized borderless frac`() {
    fun `bmatrix and vmatrix pick correct delimiters`() {
    fun `bmod renders as bare mod function`() {
    fun `boldsymbol wraps in BOLD_ITALIC style`() {
    fun `cases environment produces left-aligned matrix with left brace`() {
    fun `digits collapse into a single ORDINARY sym`() {
    fun `empty input gives empty group`() {
    fun `fraction parses numerator and denominator`() {
    fun `function name sin is a FUNCTION sym`() {
    fun `greek letter command resolves to Unicode VARIABLE sym`() {
    fun `hat accent produces Accent HAT`() {
    fun `implies and iff map to long arrows`() {
    fun `integral with limits`() {
    fun `issue 150 integral reproducer parses without error`() {
    fun `left and right parens`() {
    fun `left and right with dot is empty delim`() {
    fun `lim is a LargeOp with subscript`() {
    fun `mathbb maps uppercase letters to double-struck via Styled`() {
    fun `nested fractions`() {
    fun `overline widens across content`() {
    fun `pmatrix 2x2 parses rows and cells`() {
    fun `pmod expands to parenthesized mod group`() {
    fun `primes collapse into single sym`() {
    fun `quadratic formula full parse does not throw`() {
    fun `single variable letter is a VARIABLE sym`() {
    fun `sqrt with and without index`() {
    fun `sub and sup attached to same base`() {
    fun `subscript single char`() {
    fun `sum with subscript and superscript produces LargeOp with limits`() {
    fun `superscript single char`() {
    fun `superscript with braces groups the whole expression`() {
    fun `text preserves spaces`() {
    fun `unclosed accent brace does not crash`() {
    fun `unclosed matrix still returns Matrix with collected rows`() {
    fun `unknown command renders as literal backslash-name`() {
    fun `unknown environment swallows body without crashing`() {
    fun `unmatched opening brace does not throw`() {
    fun `vec accent with multi-char base`() {
    private fun group(atom: MathAtom): List<MathAtom> = when (atom) {
    private fun parse(s: String) = MathParser.parse(s)
    }
/** Tests for [MathParser] — LaTeX fragments → [MathAtom] tree. */
class MathAtomParserTest {
package com.inspiredandroid.kai.ui.markdown.math
}
