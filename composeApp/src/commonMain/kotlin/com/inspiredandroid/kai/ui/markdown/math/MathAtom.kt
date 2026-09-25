package com.inspiredandroid.kai.ui.markdown.math
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

    /** All cells horizontally centered — default for pmatrix / bmatrix / matrix / vmatrix. */
    /** All cells left-aligned — used by `cases`. */
    /** Binary operators (+, -, ·, ×) — upright with symmetric spacing. */
    /** Closing delimiter. */
    /** Digits, punctuation, unit-like glyphs — rendered upright. */
    /** Function names like sin, cos, log, lim — upright, not italic. */
    /** Odd columns right-aligned, even columns left-aligned — `aligned` / `align`. */
    /** Opening delimiter that doesn't stretch (e.g. a bare `(` without \left). */
    /** Punctuation — upright, no extra spacing. */
    /** Relation operators (=, <, >, ≤, ≈, →) — upright with symmetric spacing. */
    /** Variable letters — rendered italic. */
    /** `\boldsymbol{...}` — bold italic, used for bold greek letters and bold variables. */
    /** `\mathbb{...}` — double-struck (via Unicode mapping where available). */
    /** `\mathbf{...}` — bold upright. */
    /** `\mathcal{...}` — calligraphic (best-effort Unicode mapping). */
    /** `\mathit{...}` — italic (default for letters, but useful to force it). */
    /** `\mathrm{...}` — upright roman. */
    /** `\text{...}` — upright, rendered as ordinary text with spaces preserved. */
    ALIGN_RL,
    BAR,
    BIN_OP,
    BOLD,
    BOLD_ITALIC,
    BRACE("{", "}"),
    BRACKET("[", "]"),
    CALLIGRAPHIC,
    CASES("{", ""),
    CENTERED,
    CLOSE,
    DBLVBAR("‖", "‖"),
    DDOT,
    DOT,
    DOUBLE_STRUCK,
    FUNCTION,
    HAT,
    ITALIC,
    LEFT,
    NONE("", ""),
    OPEN,
    ORDINARY,
    OVERLINE,
    PAREN("(", ")"),
    PUNCT,
    REL_OP,
    ROMAN,
    TEXT,
    TILDE,
    VARIABLE,
    VBAR("|", "|"),
    VEC,
    WIDEHAT,
    WIDETILDE,
    val alignMode: MatrixAlign = MatrixAlign.CENTERED,
    val alwaysLimits: Boolean = false,
    val delim: MatrixDelim,
    val rows: ImmutableList<ImmutableList<MathAtom>>,
    val sub: MathAtom? = null,
    val sup: MathAtom? = null,
    val symbol: String,
 *
 * A 2D grid of cells from environments like `pmatrix`, `cases`, or `aligned`. Rows are
 * Big operator like ∑, ∫, ∏, ⋃. In display mode [sub]/[sup] are typeset above/below the
 * Minimal LaTeX math AST. Deliberately scoped to the subset of commands that show up in
 * Unknown commands degrade to a literal [Sym] carrying the raw `\name` text — nothing in
 * [alwaysLimits] is true (e.g. `\lim`), limits are used even inline.
 * `\hat{x}`, `\bar{x}`, `\vec{v}`, `\tilde{y}`, `\dot{x}`, `\ddot{x}` — single-glyph accent
 * a handful of font styles, and a symbol lookup for greek letters and operators.
 * centered above [base]. The widening variants (`\overline`, `\widehat`, `\widetilde`) stretch
 * operator (limits); in inline mode they fall through to [Script] positioning. When
 * real LLM output: fractions, scripts, radicals, big operators (with limits), delimiters,
 * separated by `\\` and cells by `&` in the source; cells may themselves be arbitrary math.
 * the renderer crashes on malformed input.
 * to match the base's width instead.
 */
) : MathAtom
/**
/** Horizontal spacing: \, \: \; \! \quad \qquad, measured in em. */
/** Single typeset glyph: a letter, digit, operator symbol, or mapped LaTeX command. */
/** Subscript/superscript attached to [base]. One or both of [sub]/[sup] may be present. */
/** `\left X ... \right Y` — brackets stretch to the height of [content]. */
@Immutable
data class Accent(val base: MathAtom, val kind: AccentKind) : MathAtom
data class Delim(val left: String, val right: String, val content: MathAtom) : MathAtom
data class Frac(val num: MathAtom, val den: MathAtom, val drawBar: Boolean = true) : MathAtom
data class Group(val atoms: ImmutableList<MathAtom>) : MathAtom
data class LargeOp(
data class Matrix(
data class Radical(val index: MathAtom?, val radicand: MathAtom) : MathAtom
data class Script(val base: MathAtom, val sub: MathAtom?, val sup: MathAtom?) : MathAtom
data class Space(val emWidth: Float) : MathAtom
data class Styled(val style: MathStyle, val atoms: ImmutableList<MathAtom>) : MathAtom
data class Sym(val text: String, val kind: SymKind = SymKind.ORDINARY) : MathAtom
enum class AccentKind {
enum class MathStyle {
enum class MatrixAlign {
enum class MatrixDelim(val left: String, val right: String) {
enum class SymKind {
sealed interface MathAtom
}
