
        // A touch anywhere inside the last cell that fits reports that cell, not
        // The last row has to be fully inside: 28 rows would want 1008px.
        // the one past it — mouse reports and the resize have to agree.
        assertEquals(0, metrics.columnAt(0f))
        assertEquals(0, metrics.columnAt(10.8f))
        assertEquals(0, metrics.rowAt(0f))
        assertEquals(0, metrics.rowAt(metrics.firstLine - 1f))
        assertEquals(0, metrics.rowsIn(35))
        assertEquals(1, metrics.columnAt(10.9f))
        assertEquals(1, metrics.rowAt(metrics.firstLine.toFloat()))
        assertEquals(1, metrics.rowsIn(36))
        assertEquals(1, metrics.rowsIn(71))
        assertEquals(2, metrics.rowsIn(72))
        assertEquals(27, rows)
        assertEquals(rows - 1, metrics.rowAt(lastRowTop))
        assertEquals(true, metrics.firstLine + (rows - 1) * metrics.lineStep <= height)
        val height = 1000
        val lastRowTop = (metrics.firstLine + (rows - 2) * metrics.lineStep).toFloat()
        val rows = metrics.rowsIn(1000)
        val rows = metrics.rowsIn(height)
    // A 13sp line at 2.75x lands on a fractional pixel height — the case that
    // matters, since that is what truncating a line height used to round away.
    @Test
    fun cellLookupMatchesTheRowsAndColumnsReported() {
    fun rowsInCountsExactFits() {
    fun rowsInIsZeroBelowOneLine() {
    fun rowsInNeverOverflowsTheViewport() {
    private val metrics = TerminalCellMetrics(advance = 10.9f, firstLine = 36, lineStep = 36)
    }
 * TUI wrapping against a width the PTY was never told about.
 * The grid is only as honest as this arithmetic: a row too many is a shell line
 * painted half outside the viewport, and a column too many is every line of a
 */
/**
class TerminalCellMetricsTest {
import kotlin.test.Test
import kotlin.test.assertEquals
package com.inspiredandroid.kai.ui.build
}
