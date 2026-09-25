
            applicationCursorKeys = false,
            cells = List(columns * rows) { TerminalCell() },
            columns = columns,
            cursorCol = 0,
            cursorRow = 0,
            cursorVisible = true,
            hyperlinks = persistentListOf(),
            mouse = TerminalMouseState(),
            revision = 0L,
            rows = rows,
        )
        fun blank(columns: Int = DEFAULT_COLUMNS, rows: Int = DEFAULT_ROWS) = TerminalSnapshot(
        if (col !in 0 until columns || row !in 0 until rows) return TerminalCell()
        return cells[row * columns + col]
    /** DECCKM state — decides how the key row encodes arrows. */
    /** Row-major cells, size = columns * rows. */
    /** What the running app asked to hear about touches, if anything. */
    companion object {
    fun cellAt(col: Int, row: Int): TerminalCell {
    val applicationCursorKeys: Boolean = false,
    val bg: Int = 0,
    val bold: Boolean = false,
    val cells: List<TerminalCell>,
    val char: Char = ' ',
    val columns: Int,
    val cursorCol: Int,
    val cursorRow: Int,
    val cursorVisible: Boolean,
    val fg: Int = 7,
    val hyperlinks: ImmutableList<String> = persistentListOf(),
    val mouse: TerminalMouseState = TerminalMouseState(),
    val revision: Long,
    val rows: Int,
    }
 *
 * Immutable view of the screen for Compose. [revision] bumps on every change so
 * [hyperlinks] are URIs extracted from OSC 8 sequences (xterm hyperlinks). TUIs
 * collectors recompose even when dimensions stay the same.
 * like Grok put login URLs there while showing only "click here" on the grid.
 */
)
) {
/**
/** One cell in the terminal grid. [fg]/[bg] are 0–15 ANSI palette indices. */
@Immutable
const val DEFAULT_COLUMNS = 80
const val DEFAULT_ROWS = 24
const val MAX_COLUMNS = 300
const val MAX_ROWS = 120
const val MIN_COLUMNS = 20
const val MIN_ROWS = 8
data class TerminalCell(
data class TerminalSnapshot(
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
package com.inspiredandroid.kai.build.terminal
}
