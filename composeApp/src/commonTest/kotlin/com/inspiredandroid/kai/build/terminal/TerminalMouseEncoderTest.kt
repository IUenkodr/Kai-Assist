import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

            "\u001b[<0;12;5M\u001b[<0;12;5m",
            "\u001b[<0;201;101M\u001b[<0;201;101m",
            "\u001b[M !!\u001b[M#!!",
            TerminalMouseEncoder.click(col = 0, row = 0, state = x10),
            TerminalMouseEncoder.click(col = 11, row = 4, state = sgr),
            TerminalMouseEncoder.click(col = 200, row = 100, state = sgr),
        )
        // 94 is the last column whose coordinate byte still fits in one byte.
        // Cell (11, 4) is column 12, row 5 on the wire.
        // Column 95 would need byte 128, which UTF-8 would widen to two bytes.
        // button 0 -> ' ', col 0 -> '!', row 0 -> '!'; release is button 3 -> '#'.
        assertEquals(
        assertEquals("\u001b[<64;1;1M", TerminalMouseEncoder.wheel(up = true, col = 0, row = 0, state = sgr))
        assertEquals("\u001b[<65;1;1M", TerminalMouseEncoder.wheel(up = false, col = 0, row = 0, state = sgr))
        assertNotNull(TerminalMouseEncoder.click(col = 94, row = 94, state = x10))
        assertNull(TerminalMouseEncoder.click(col = 0, row = 95, state = x10))
        assertNull(TerminalMouseEncoder.click(col = 1, row = 1, state = off))
        assertNull(TerminalMouseEncoder.click(col = 95, row = 0, state = x10))
        assertNull(TerminalMouseEncoder.wheel(up = true, col = 1, row = 1, state = off))
        encoding = TerminalMouseEncoding.Sgr,
        encoding = TerminalMouseEncoding.X10,
        tracking = TerminalMouseTracking.Click,
        val off = TerminalMouseState()
    )
    @Test
    fun reportsNothingWhileTrackingIsOff() {
    fun sgrClickSendsPressThenRelease() {
    fun sgrHandlesCoordinatesBeyondX10Range() {
    fun sgrWheelHasNoRelease() {
    fun x10ClickOffsetsBy32() {
    fun x10RefusesCoordinatesItCannotSpell() {
    private val sgr = TerminalMouseState(
    private val x10 = TerminalMouseState(
    }
class TerminalMouseEncoderTest {
package com.inspiredandroid.kai.build.terminal
}
