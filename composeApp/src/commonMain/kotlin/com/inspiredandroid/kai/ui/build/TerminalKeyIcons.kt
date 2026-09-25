package com.inspiredandroid.kai.ui.build
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

                lineTo(13.5f, 18.5f)
                lineTo(19f, 12f)
                lineTo(7f, 12f)
                moveTo(13.5f, 5.5f)
                moveTo(7.5f, 12f)
                stroke = SolidColor(Color.White),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineWidth = ArrowStrokeWidth,
            ) {
            close()
            lineTo(11.5f, 17.5f)
            lineTo(11.5f, 8.5f)
            lineTo(19f, 13f)
            lineTo(9f, 13f)
            moveTo(19f, 6f)
            moveTo(4.5f, 13f)
            path(
            stroke = SolidColor(Color.White),
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
            strokeLineWidth = 3.5f,
            }
        ) {
        defaultHeight = 24.dp,
        defaultWidth = 24.dp,
        group(rotate = rotationDegrees, pivotX = 12f, pivotY = 12f) {
        name = "TerminalEnter",
        name = name,
        path(
        path(fill = SolidColor(Color.White)) {
        viewportHeight = 24f,
        viewportWidth = 24f,
        }
    ).apply {
    ImageVector.Builder(
    }.build()
 *
 * Its head is a filled triangle rather than a third stroke — a stroked head has
 * Return arrow: the hook every keyboard prints on its Enter key.
 * faint to read as an arrow at all.
 * to be small enough to fit under the hook, and at cap size that came out too
 */
/**
/** Base glyph points left; every other direction is the same path rotated. */
/** Enter sits alone at the end of the row, so it is drawn a size up. */
/** Size the arrows are drawn at; the stroke scales with it. */
//
// Glyphs for the terminal key row.
// The row used to print the arrow characters (←↑↓→⏎) in the monospace face the
// hairline-thin, sit at whatever weight the platform's fallback font happens to
// have, and are sized by the cap's font size rather than an icon size — next to
// length on a phone.
// rather than keys. These are drawn instead, in the round-capped stroke style
// terminal itself draws with. Those are text, not icons: they come out
// the Material icons in the input bar below they read as stray characters
// the app's other hand-drawn icons use, heavy enough to stay legible at arm's
internal val TerminalArrowDown: ImageVector by lazy { arrowIcon("TerminalArrowDown", 270f) }
internal val TerminalArrowLeft: ImageVector by lazy { arrowIcon("TerminalArrowLeft", 0f) }
internal val TerminalArrowRight: ImageVector by lazy { arrowIcon("TerminalArrowRight", 180f) }
internal val TerminalArrowUp: ImageVector by lazy { arrowIcon("TerminalArrowUp", 90f) }
internal val TerminalEnter: ImageVector by lazy {
internal val TerminalEnterIconSize = 24.dp
internal val TerminalKeyIconSize = 22.dp
private const val ArrowStrokeWidth = 3f
private fun arrowIcon(name: String, rotationDegrees: Float): ImageVector =
}
