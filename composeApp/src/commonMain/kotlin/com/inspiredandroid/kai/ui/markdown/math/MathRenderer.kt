package com.inspiredandroid.kai.ui.markdown.math
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

                        MatrixAlign.ALIGN_RL -> if (c % 2 == 0) colW - p.width else 0
                        MatrixAlign.CENTERED -> (colW - p.width) / 2
                        MatrixAlign.LEFT -> 0
                        color = color,
                        end = Offset(size.width, 0f),
                        start = Offset(0f, 0f),
                        strokeWidth = strokePx.toPx(),
                    )
                    // Box wrapper guarantees one measurable per cell — an empty Group alone
                    // emits zero composables, which would break the grid indexing below.
                    Box { AtomRenderer(cell, display, baseSize, color) }
                    MathStyle.CALLIGRAPHIC -> MathSymbols.mapCalligraphic(ch)
                    MathStyle.DOUBLE_STRUCK -> MathSymbols.mapDoubleStruck(ch)
                    color = color,
                    drawLine(
                    else -> ch.toString()
                    end = Offset(size.width, size.height / 2),
                    for (inner in atom.atoms) appendAtomInline(inner, color)
                    for (inner in atom.atoms) appendMapped(inner, atom.style)
                    p.placeRelative(x + xOffset, y + yOffset)
                    start = Offset(0f, size.height / 2),
                    strokeWidth = size.height,
                    val cell = row.getOrNull(colIndex) ?: EMPTY_MATRIX_CELL
                    val colW = colWidths[c]
                    val p = cellGrid[r][c]
                    val rowH = rowHeights[r]
                    val xOffset = when (matrix.alignMode) {
                    val yOffset = (rowH - p.height) / 2
                    x += colW + colGapPx
                    }
                )
                .drawBehind {
                .padding(top = 2.dp, start = 2.dp, end = 2.dp),
                .padding(top = topPad)
                AtomRenderer(radical.index, display = false, baseSize = indexSize, color = color)
                AtomRenderer(script.sub, display = false, baseSize = scriptSize, color = color)
                AtomRenderer(script.sup, display = false, baseSize = scriptSize, color = color)
                HorizontalBar(color, lineThicknessDp)
                Spacer(Modifier.height(1.dp))
                Text(glyph, style = glyphStyle)
                drawLine(
                else -> append('\u2003').also { append('\u2003') }
                for (c in 0 until colCount) {
                for (colIndex in 0 until colCount) {
                if (atom.style == MathStyle.DOUBLE_STRUCK || atom.style == MathStyle.CALLIGRAPHIC) {
                is ComplexSegment -> AtomRenderer(seg.atom, display, baseSize, color)
                is RunSegment -> InlineRun(seg.atoms, baseSize, color)
                out += RunSegment(run.toImmutableList())
                raw < 0.3f -> append('\u2009')
                raw < 0.8f -> append('\u2002')
                raw < 1.5f -> append('\u2003')
                raw <= 0f -> Unit
                run.clear()
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = delimSize, color = color),
                text = delim.left,
                text = delim.right,
                var x = 0
                when (style) {
                y += rowHeights[r] + rowGapPx
                }
                } else {
            (0 until rowCount).map { r -> placeables.subList(r * colCount, (r + 1) * colCount) }
            )
            .drawBehind {
            .height(thickness)
            // Approximation — the AnnotatedString.Builder has no Density access, so we pick the
            // Shouldn't reach here — [isInlineRenderable] keeps these off the AnnotatedString path.
            // nearest Unicode space width (thin / en / em / 2×em) instead of a pixel-exact width.
            AtomRenderer(accent.base, display, baseSize, color)
            AtomRenderer(frac.den, display, baseSize, color)
            AtomRenderer(frac.num, display, baseSize, color)
            AtomRenderer(op.sub, display = false, baseSize = limitSize, color = color)
            AtomRenderer(op.sup, display = false, baseSize = limitSize, color = color)
            AtomRenderer(radical.radicand, display, baseSize, color)
            Box(Modifier.padding(bottom = 6.dp)) {
            HorizontalBar(barColor, thickness = 1.dp)
            MatrixDelimiter(matrix.delim.left, baseSize, color, rowCount = matrix.rows.size)
            MatrixDelimiter(matrix.delim.right, baseSize, color, rowCount = matrix.rows.size)
            Modifier
            Script(base, op.sub, op.sup)
            Text(
            accentP.placeRelative((totalWidth - accentP.width) / 2, 0)
            append('\u25A1')
            append(atom.symbol)
            append(mapped)
            append(sym.text)
            appendAtomInline(atom.base, color)
            appendAtomInline(it, color)
            appendScripts(atom.sub, atom.sup, color)
            barP.placeRelative(0, numP.height + barPaddingPx)
            base
            baseP.placeRelative((totalWidth - baseP.width) / 2, accentP.height + gapPx)
            color = color,
            denP.placeRelative((width - denP.width) / 2, numP.height + barPaddingPx + barHeightPx + barPaddingPx)
            fontSize = (baseSize.value * scale).sp,
            for (r in 0 until rowCount) {
            for (row in matrix.rows) {
            if (glyph != null) {
            if (run.isNotEmpty()) {
            if (script.sub != null) {
            if (script.sup != null) {
            measurables[0].measure(Constraints.fixed(baseP.width, lineThicknessDp.roundToPx()))
            measurables[0].measure(childConstraints)
            numP.placeRelative((width - numP.width) / 2, 0)
            out += ComplexSegment(a)
            run += a
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = (baseSize.value * RADICAL_SYMBOL_SCALE).sp, color = color),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = baseSize, color = color),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = opSize, color = color),
            text = "√",
            text = opText,
            text = text,
            val glyph = ACCENT_GLYPHS[accent.kind]
            val indexSize = (baseSize.value * SCRIPT_SCALE).sp
            val mapped = atom.text.map { ch ->
            val raw = atom.emWidth
            val span = styleSpan(atom.style)
            var y = 0
            when (seg) {
            when {
            withStyle(span) {
            }
            } else {
            },
            }.joinToString("")
        (atom.sub?.let(::isScriptContentInlineRenderable) ?: true) &&
        (atom.sup?.let(::isScriptContentInlineRenderable) ?: true)
        )
        ) {
        ),
        .coerceAtMost(MATRIX_DELIM_MAX_SCALE)
        // Inline big op renders as op + scripts — reuse the script path.
        // Join raw text from the children verbatim — `\text{hello world}` preserves the space.
        // Strip min-width so numerator/denominator measure at their intrinsic content size.
        AtomRenderer(atom, display = display, baseSize = baseSize, color = color)
        AtomRenderer(atoms[0], display, baseSize, color)
        AtomRenderer(delim.content, display, baseSize, color)
        AtomRenderer(script.base, display, baseSize, color)
        AtomRenderer(wrapped, display, baseSize, color)
        Box(
        Column {
        InlineRun((segments[0] as RunSegment).atoms, baseSize, color)
        MatrixGrid(matrix, display, baseSize, color)
        Modifier
        Text(
        accent.kind == AccentKind.BAR ||
        accent.kind == AccentKind.WIDEHAT ||
        accent.kind == AccentKind.WIDETILDE
        appendAtomInline(styled, color)
        content = {
        else -> appendAtomInline(atom, Color.Unspecified)
        for (a in atoms) appendAtomInline(a, color)
        for (seg in segments) {
        if (delim.left.isNotEmpty()) {
        if (delim.right.isNotEmpty()) {
        if (isInlineRenderable(a, display)) {
        if (matrix.delim.left.isNotEmpty()) {
        if (matrix.delim.right.isNotEmpty()) {
        if (op.sub != null) {
        if (op.sup != null) {
        if (radical.index != null) {
        if (spacing.first > 0) append('\u2009')
        if (spacing.second > 0) append('\u2009')
        is Accent -> AccentRenderer(atom, display, baseSize, color)
        is Delim -> DelimRenderer(atom, display, baseSize, color)
        is Frac -> FractionRenderer(atom, display, baseSize, color)
        is Frac, is Radical, is Delim, is Accent, is Matrix -> {
        is Group -> GroupRenderer(atom.atoms, display, baseSize, color)
        is Group -> for (inner in atom.atoms) appendAtomInline(inner, color)
        is Group -> for (inner in atom.atoms) appendMapped(inner, style)
        is LargeOp -> LargeOpRenderer(atom, display, baseSize, color)
        is LargeOp -> {
        is Matrix -> MatrixRenderer(atom, display, baseSize, color)
        is Radical -> RadicalRenderer(atom, display, baseSize, color)
        is Script -> ScriptRenderer(atom, display, baseSize, color)
        is Script -> {
        is Space -> Spacer(Modifier.width(emsToDp(atom.emWidth, baseSize)))
        is Space -> {
        is Styled -> StyledRenderer(atom, display, baseSize, color)
        is Styled -> {
        is Sym -> SymText(atom, baseSize, color)
        is Sym -> append(symSpan(atom))
        is Sym -> {
        layout(totalWidth, totalHeight) {
        layout(width, height) {
        modifier = Modifier.padding(horizontal = 4.dp),
        modifier = Modifier.padding(horizontal = horizontalPadding),
        return
        style = MaterialTheme.typography.bodyLarge.copy(
        style = MaterialTheme.typography.bodyLarge.copy(fontSize = baseSize, color = color),
        text = annotated,
        text = text,
        val accentP = if (widening) {
        val barHeightPx = 1.dp.roundToPx()
        val barP = measurables[1].measure(Constraints.fixed(width, barHeightPx))
        val barPaddingPx = verticalBarPadding.roundToPx()
        val base = Sym(op.symbol, SymKind.ORDINARY)
        val baseP = measurables[1].measure(childConstraints)
        val cellGrid: List<List<androidx.compose.ui.layout.Placeable>> =
        val childConstraints = constraints.copy(minWidth = 0)
        val colGapPx = MATRIX_COL_GAP.roundToPx()
        val colWidths = IntArray(colCount) { c -> cellGrid.maxOf { it[c].width } }
        val denP = measurables[2].measure(childConstraints)
        val gapPx = accentGapDp.roundToPx()
        val height = numP.height + barPaddingPx + barHeightPx + barPaddingPx + denP.height
        val numP = measurables[0].measure(childConstraints)
        val placeables = measurables.map { it.measure(childConstraints) }
        val rowGapPx = MATRIX_ROW_GAP.roundToPx()
        val rowHeights = IntArray(rowCount) { r -> cellGrid[r].maxOf { it.height } }
        val scriptSize = (baseSize.value * SCRIPT_SCALE).sp
        val spacing = kindSpacing(sym.kind)
        val text = styled.atoms.joinToString("") { (it as? Sym)?.text ?: "" }
        val totalHeight = accentP.height + gapPx + baseP.height
        val totalHeight = rowHeights.sum() + rowGapPx * (rowCount - 1).coerceAtLeast(0)
        val totalWidth = colWidths.sum() + colGapPx * (colCount - 1).coerceAtLeast(0)
        val totalWidth = maxOf(baseP.width, accentP.width)
        val width = maxOf(numP.width, denP.width)
        val wrapped: MathAtom = if (op.sub != null || op.sup != null) {
        withStyle(SpanStyle(fontSize = SCRIPT_FONT_SIZE, baselineShift = BaselineShift.Subscript)) {
        withStyle(SpanStyle(fontSize = SCRIPT_FONT_SIZE, baselineShift = BaselineShift.Superscript)) {
        withStyle(SpanStyle(fontStyle = if (italic) FontStyle.Italic else FontStyle.Normal)) {
        }
        } else {
        },
    )
    ) { measurables, constraints ->
    // 1em ≈ baseSize. Convert through Density rather than reading the sp magnitude as
    // A narrower traditional \bar glyph would also work but requires a font with that metric.
    // BAR visually matches OVERLINE — both draw a horizontal line and need explicit width.
    // If the base is inline-renderable we defer to the AnnotatedString path for better
    // Inline-renderable styled group: build annotated string.
    // Narrow visual gap: glyph-based accents (hat, tilde, dot, vec) have built-in whitespace
    // Rough delim stretching: scale the delimiter's font size with the base size. Works well
    // Scale delim height to match grid row count; clamped so very tall matrices don't explode.
    // Wrap the grid in delimiters scaled to the grid's height — similar approach to DelimRenderer.
    // above their ink, so we don't need additional padding. Widening accents (bar/overline)
    // and letting fractions and radicals drift out of alignment.
    // are 1dp strokes and benefit from a small gap instead.
    // baseline handling. This branch is hit only when the base itself is structural.
    // dp, so the spacing between atoms grows with the glyphs instead of staying put
    // for fractions (which are ~2x base tall) but isn't perfect for deep nesting.
    // handled via mapping
    AccentKind.DDOT to "··",
    AccentKind.DOT to "·",
    AccentKind.HAT to "^",
    AccentKind.TILDE to "~",
    AccentKind.VEC to "→",
    AccentKind.WIDEHAT to "^",
    AccentKind.WIDETILDE to "~",
    Box(
    Box(modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Layout(
    MathStyle.BOLD -> SpanStyle(fontWeight = FontWeight.Bold)
    MathStyle.BOLD_ITALIC -> SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
    MathStyle.CALLIGRAPHIC -> SpanStyle() // handled via mapping
    MathStyle.DOUBLE_STRUCK -> SpanStyle()
    MathStyle.ITALIC -> SpanStyle(fontStyle = FontStyle.Italic)
    MathStyle.ROMAN -> SpanStyle(fontStyle = FontStyle.Normal)
    MathStyle.TEXT -> SpanStyle(fontFamily = FontFamily.Default, fontStyle = FontStyle.Normal)
    Row(verticalAlignment = Alignment.CenterVertically) {
    SymKind.BIN_OP, SymKind.REL_OP -> 1 to 1
    SymKind.PUNCT -> 0 to 1
    Text(
    Text(text = annotated, style = style.copy(fontSize = baseSize, color = color))
    Text(text = text, style = MaterialTheme.typography.bodyLarge.copy(fontSize = baseSize, color = color))
    accent: Accent,
    atom: MathAtom,
    atoms: ImmutableList<MathAtom>,
    baseSize: TextUnit = if (display) 20.sp else 16.sp,
    baseSize: TextUnit,
    color: Color,
    delim: Delim,
    display: Boolean = false,
    display: Boolean,
    else -> 0 to 0
    else -> false
    for (a in atoms) {
    frac: Frac,
    if (!stacked) {
    if (atoms.isEmpty()) return
    if (atoms.size == 1) {
    if (rowCount == 0) return
    if (run.isNotEmpty()) out += RunSegment(run.toImmutableList())
    if (segments.size == 1 && segments[0] is RunSegment) {
    if (styled.style == MathStyle.TEXT) {
    is Frac, is Radical, is Delim, is Accent, is Matrix -> false
    is Group -> atom.atoms.all { isInlineRenderable(it, display) }
    is Group -> atom.atoms.all(::isScriptContentInlineRenderable)
    is LargeOp -> !display && !atom.alwaysLimits
    is Script -> isInlineRenderable(atom.base, display) &&
    is Styled -> atom.style != MathStyle.TEXT && atom.atoms.all { isInlineRenderable(it, display) }
    is Styled -> atom.style != MathStyle.TEXT && atom.atoms.all(::isScriptContentInlineRenderable)
    is Sym, is Space -> true
    latex: String,
    matrix: Matrix,
    modifier: Modifier = Modifier,
    op: LargeOp,
    radical: Radical,
    return buildAnnotatedString {
    return out
    return with(LocalDensity.current) { baseSize.toDp() * em }
    script: Script,
    styled: Styled,
    sub?.let {
    sup?.let {
    val accentGapDp = if (widening) 2.dp else (-4).dp
    val annotated = buildAnnotatedString {
    val atom = remember(latex) { MathParser.parse(latex) }
    val barColor = if (frac.drawBar) color else Color.Transparent
    val colCount = matrix.rows.maxOf { it.size }
    val color = LocalContentColor.current
    val delimSize = (baseSize.value * DELIMITER_SCALE).sp
    val glyphSize = (baseSize.value * ACCENT_GLYPH_SCALE).sp
    val glyphStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = glyphSize, color = color)
    val horizontalPadding = 2.dp
    val italic = sym.kind == SymKind.VARIABLE && sym.text.length == 1 && sym.text[0].isLetter() && !isGreek(sym.text[0])
    val limitSize = (baseSize.value * SCRIPT_SCALE).sp
    val lineThicknessDp = 1.dp
    val opSize = (baseSize.value * if (display) BIG_OP_SCALE_DISPLAY else BIG_OP_SCALE_INLINE).sp
    val opText = op.symbol
    val out = mutableListOf<Segment>()
    val rowCount = matrix.rows.size
    val run = mutableListOf<MathAtom>()
    val scale = (DELIMITER_SCALE + MATRIX_DELIM_SCALE_PER_ROW * (rowCount - 1))
    val segments = splitIntoSegments(atoms, display)
    val stacked = display || op.alwaysLimits
    val strokePx = 1.dp
    val style = MaterialTheme.typography.bodyLarge
    val text = symSpan(sym)
    val topPad = 3.dp
    val verticalBarPadding = 2.dp
    val widening = accent.kind == AccentKind.OVERLINE ||
    when (atom) {
    }
 *
 *   given display-math sizing. Inline formulas keep limits as sub/superscripts.
 * @param display if true, big operators typeset limits above/below and the root layout is
 * Renders a LaTeX math fragment. The parser tolerates malformed input; unknown commands
 * Runs of inline-renderable atoms (letters, symbols, scripts, styled text) collapse into a
 * Thin horizontal line that stretches to its parent's width. Shared by fraction bars and
 * `\bar` / `\overline` accents. The center-aligned draw means the line is drawn at y = height/2
 * render as literal `\name` text so nothing crashes.
 * single [Text] so selection and copy work. Structural atoms (fractions, radicals, delimiters,
 * stacked big ops) each render as their own composable and are stitched via [Row].
 * with `strokeWidth = height`, giving the full height as ink.
 */
)
) {
/**
/** Glyphs for narrow accents. Widening accents (BAR, OVERLINE, WIDEHAT, WIDETILDE) render as a drawn line. */
/** Reused sentinel for absent matrix cells — avoids allocating a new empty Group per recomposition. */
// Typographic ratios relative to the current base font size. Picked visually; not TeX-exact.
@Composable
fun MathFormula(
private const val ACCENT_GLYPH_SCALE = 0.85f
private const val BIG_OP_SCALE_DISPLAY = 1.6f
private const val BIG_OP_SCALE_INLINE = 1.3f
private const val DELIMITER_SCALE = 1.5f
private const val MATRIX_DELIM_MAX_SCALE = 4.0f
private const val MATRIX_DELIM_SCALE_PER_ROW = 0.6f
private const val RADICAL_SYMBOL_SCALE = 1.2f
private const val SCRIPT_SCALE = 0.7f
private data class ComplexSegment(val atom: MathAtom) : Segment
private data class RunSegment(val atoms: ImmutableList<MathAtom>) : Segment
private fun AccentRenderer(
private fun AnnotatedString.Builder.appendAtomInline(atom: MathAtom, color: Color) {
private fun AnnotatedString.Builder.appendMapped(atom: MathAtom, style: MathStyle) {
private fun AnnotatedString.Builder.appendScripts(sub: MathAtom?, sup: MathAtom?, color: Color) {
private fun AtomRenderer(
private fun DelimRenderer(
private fun FractionRenderer(
private fun GroupRenderer(
private fun HorizontalBar(color: Color, thickness: androidx.compose.ui.unit.Dp) {
private fun InlineRun(atoms: ImmutableList<MathAtom>, baseSize: TextUnit, color: Color) {
private fun LargeOpRenderer(
private fun MatrixDelimiter(text: String, baseSize: TextUnit, color: Color, rowCount: Int) {
private fun MatrixGrid(
private fun MatrixRenderer(
private fun RadicalRenderer(
private fun ScriptRenderer(
private fun StyledRenderer(
private fun SymText(sym: Sym, baseSize: TextUnit, color: Color) {
private fun emsToDp(em: Float, baseSize: TextUnit): Dp {
private fun isGreek(ch: Char): Boolean = ch.code in 0x0370..0x03FF
private fun isInlineRenderable(atom: MathAtom, display: Boolean): Boolean = when (atom) {
private fun isScriptContentInlineRenderable(atom: MathAtom): Boolean = when (atom) {
private fun kindSpacing(kind: SymKind): Pair<Int, Int> = when (kind) {
private fun splitIntoSegments(atoms: List<MathAtom>, display: Boolean): List<Segment> {
private fun styleSpan(style: MathStyle): SpanStyle = when (style) {
private fun symSpan(sym: Sym): AnnotatedString {
private sealed interface Segment
private val ACCENT_GLYPHS = mapOf(
private val EMPTY_MATRIX_CELL: MathAtom = Group(persistentListOf())
private val MATRIX_COL_GAP = 12.dp
private val MATRIX_ROW_GAP = 4.dp
private val SCRIPT_FONT_SIZE = 12.sp
}
