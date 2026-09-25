
                append(if (c == Char.MIN_VALUE) ' ' else c)
                val c = snap.cellAt(col, row).char
            .single { it.start == snap.cursorCol && it.end == snap.cursorCol + 1 }
            for (col in 0 until snap.columns) {
            if (row < snap.rows - 1) append('\n')
            }
        // A span per cell would be 1920 here. A blank screen changes style only at
        // the cursor, so every row should cost a single span (plus the cursor split).
        assertEquals(2, red.end)
        assertEquals(4, green.end)
        assertEquals(AnsiPalette[0], cursor.item.color)
        assertEquals(AnsiPalette[1], red.item.color)
        assertEquals(AnsiPalette[2], green.item.color)
        assertEquals(AnsiPalette[7], cursor.item.background)
        assertEquals(flattenPerCell(snap), buildTerminalText(snap).text)
        assertTrue(spans <= snap.rows + 2, "expected about one span per row, got $spans")
        for (row in 0 until snap.rows) {
        screen.writeText("\u001b[31mab\u001b[32mcd")
        screen.writeText("abcdef")
        screen.writeText("plain \u001b[31mred\u001b[0m \u001b[1mbold\u001b[22m\r\nsecond line")
        val cursor = buildTerminalText(snap).spanStyles
        val green = spans.single { it.start == 2 }
        val red = spans.single { it.start == 0 }
        val screen = TerminalScreen(columns = 10, rows = 1)
        val screen = TerminalScreen(columns = 20, rows = 4)
        val screen = TerminalScreen(columns = 6, rows = 1)
        val screen = TerminalScreen(columns = 80, rows = 24)
        val snap = screen.snapshot()
        val spans = buildTerminalText(snap).spanStyles
        val spans = buildTerminalText(snap).spanStyles.size
        }
    /** What the grid used to emit: one span, one character, no run merging. */
    @Test
    fun collapsesUniformRowsIntoOneSpanEach() {
    fun colorChangeSplitsTheRun() {
    fun cursorCellGetsItsOwnInvertedSpan() {
    fun textMatchesPerCellFlattening() {
    private fun flattenPerCell(snap: TerminalSnapshot): String = buildString {
    }
class BuildTerminalTextTest {
import com.inspiredandroid.kai.build.terminal.TerminalScreen
import com.inspiredandroid.kai.build.terminal.TerminalSnapshot
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.ui.build
}
