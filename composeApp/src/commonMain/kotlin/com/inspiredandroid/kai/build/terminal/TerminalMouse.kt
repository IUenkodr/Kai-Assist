
                press + release
                sgr(BUTTON_LEFT, col, row, press = true) + sgr(BUTTON_LEFT, col, row, press = false)
                val press = x10(BUTTON_LEFT, col, row) ?: return null
                val release = x10(BUTTON_RELEASE, col, row) ?: return null
            TerminalMouseEncoding.Sgr ->
            TerminalMouseEncoding.Sgr -> sgr(button, col, row, press = true)
            TerminalMouseEncoding.X10 -> x10(button, col, row)
            TerminalMouseEncoding.X10 -> {
            }
        "$ESC[<$button;${col + 1};${row + 1}${if (press) 'M' else 'm'}"
        if (!state.enabled) return null
        if (col > X10_MAX_COORDINATE || row > X10_MAX_COORDINATE) return null
        return "$ESC[M${(button + 32).toChar()}${(col + 33).toChar()}${(row + 33).toChar()}"
        return when (state.encoding) {
        val button = if (up) BUTTON_WHEEL_UP else BUTTON_WHEEL_DOWN
        }
    /** Highest cell an X10 coordinate byte can name while staying under 128. */
    /** Left button. */
    /** One wheel notch. The wheel has no release event in either encoding. */
    /** Press and release of the left button at one cell, as a single write. */
    /** X10 reports release as a button of its own rather than naming the button. */
    /** `ESC [ < button ; col ; row M` for a press, lowercase `m` for a release. */
    /** `ESC [ M` then button, column and row each offset by 32 (and 1-based). */
    AnyMotion,
    ButtonMotion,
    Click,
    None,
    Sgr,
    X10,
    fun click(col: Int, row: Int, state: TerminalMouseState): String? {
    fun wheel(up: Boolean, col: Int, row: Int, state: TerminalMouseState): String? {
    private const val BUTTON_LEFT = 0
    private const val BUTTON_RELEASE = 3
    private const val BUTTON_WHEEL_DOWN = 65
    private const val BUTTON_WHEEL_UP = 64
    private const val ESC = "\u001b"
    private const val X10_MAX_COORDINATE = 94
    private fun sgr(button: Int, col: Int, row: Int, press: Boolean): String =
    private fun x10(button: Int, col: Int, row: Int): String? {
    val enabled: Boolean get() = tracking != TerminalMouseTracking.None
    val encoding: TerminalMouseEncoding = TerminalMouseEncoding.X10,
    val tracking: TerminalMouseTracking = TerminalMouseTracking.None,
    }
 *
 * A TUI that wants clickable elements turns on [Click]; the motion modes also
 * Everything written to the PTY goes out as UTF-8, so an X10 byte of 128 or
 * How a report is spelled on the wire. [X10] is the original form and cannot
 * Rather than send a corrupted report these functions return null past the
 * Turns a touch on the cell grid into the bytes xterm defines for a mouse
 * Which mouse events an app asked to hear about (DECSET 1000/1002/1003).
 * express coordinates past column 95; [Sgr] (DECSET 1006) has no such limit and
 * is what modern TUIs ask for.
 * more would be widened to two bytes and desynchronise the app's 6-byte read.
 * no such limit.
 * point where X10 stays single-byte — SGR, which every agent TUI requests, has
 * report movement, which nothing sends yet.
 * report. Coordinates are 0-based cells; the wire form is 1-based.
 */
) {
/**
/** What the running app currently wants — read back from the screen snapshot. */
@Immutable
data class TerminalMouseState(
enum class TerminalMouseEncoding {
enum class TerminalMouseTracking {
import androidx.compose.runtime.Immutable
object TerminalMouseEncoder {
package com.inspiredandroid.kai.build.terminal
}
