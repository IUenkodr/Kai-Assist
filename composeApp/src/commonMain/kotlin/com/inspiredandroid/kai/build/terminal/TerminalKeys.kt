
            else -> withAlt("\u007f", modifiers)
            modifiers.ctrl -> "\b"
        "$ESC[$number;${modifierParam(modifiers)}~"
        "$ESC[$number~"
        '?' -> '\u007f'
        '@', ' ' -> '\u0000'
        '[' -> '\u001b'
        '\\' -> '\u001c'
        ']' -> '\u001d'
        '^' -> '\u001e'
        '_' -> '\u001f'
        // DEL, not BS — the terminal convention readline expects.
        // Shift+Tab is its own sequence (CBT), not a modified Tab.
        TerminalKey.Backspace -> when {
        TerminalKey.Delete -> tilde(3, modifiers)
        TerminalKey.Down -> cursor('B', modifiers, applicationCursorKeys)
        TerminalKey.End -> cursor('F', modifiers, applicationCursorKeys)
        TerminalKey.Enter -> withAlt("\r", modifiers)
        TerminalKey.Escape -> ESC
        TerminalKey.Home -> cursor('H', modifiers, applicationCursorKeys)
        TerminalKey.Left -> cursor('D', modifiers, applicationCursorKeys)
        TerminalKey.PageDown -> tilde(6, modifiers)
        TerminalKey.PageUp -> tilde(5, modifiers)
        TerminalKey.Right -> cursor('C', modifiers, applicationCursorKeys)
        TerminalKey.Tab -> if (modifiers.shift) "$ESC[Z" else withAlt("\t", modifiers)
        TerminalKey.Up -> cursor('A', modifiers, applicationCursorKeys)
        alt = alt || other.alt,
        applicationCursorKeys -> "${ESC}O$final"
        applicationCursorKeys: Boolean = false,
        ctrl = ctrl || other.ctrl,
        else -> "$ESC[$final"
        else -> null
        if (!modifiers.any || text.isEmpty()) return text
        if (modifiers.alt) "$ESC$sequence" else sequence
        if (modifiers.alt) param += 2
        if (modifiers.ctrl) param += 4
        if (modifiers.shift) param += 1
        in 'A'..'Z' -> (char.code and 0x1F).toChar()
        in 'a'..'z' -> (char.code and 0x1F).toChar()
        key: TerminalKey,
        modifiers.any -> "$ESC[1;${modifierParam(modifiers)}$final"
        modifiers: TerminalModifiers = TerminalModifiers.None,
        return encodeChar(text[0], modifiers) + text.substring(1)
        return param
        return withAlt(base, modifiers)
        shift = shift || other.shift,
        val None = TerminalModifiers()
        val base = if (modifiers.ctrl) controlChar(char)?.toString() ?: char.toString() else char.toString()
        var param = 1
        }
     * Alt prefixes it with ESC — the "meta sends escape" convention.
     * Cursor and Home/End keys. Modified presses always use the CSI form with a
     * Encodes a typed character. Ctrl folds it into the C0 range (Ctrl+C → 0x03),
     * Encodes typed text. Keyboards that ignore the null input type hand over
     * a latch stands for one key press, not for the rest of the word.
     * parameter, even in application mode — that is what xterm emits.
     * whole words at once, so a modifier latch applies to the first character —
     */
    )
    ): String = when (key) {
    /**
    /** Combines a latch with whatever the hardware reported for the same press. */
    /** xterm's modifier encoding: 1 + shift(1) + alt(2) + ctrl(4). */
    Backspace,
    Delete,
    Down,
    End,
    Enter,
    Escape,
    Home,
    Left,
    PageDown,
    PageUp,
    Right,
    Tab,
    Up,
    companion object {
    fun encode(
    fun encodeChar(char: Char, modifiers: TerminalModifiers = TerminalModifiers.None): String {
    fun encodeText(text: String, modifiers: TerminalModifiers = TerminalModifiers.None): String {
    operator fun plus(other: TerminalModifiers) = TerminalModifiers(
    private const val ESC = "\u001b"
    private fun controlChar(char: Char): Char? = when (char) {
    private fun cursor(final: Char, modifiers: TerminalModifiers, applicationCursorKeys: Boolean): String = when {
    private fun modifierParam(modifiers: TerminalModifiers): Int {
    private fun tilde(number: Int, modifiers: TerminalModifiers): String = if (modifiers.any) {
    private fun withAlt(sequence: String, modifiers: TerminalModifiers): String =
    val alt: Boolean = false,
    val any: Boolean get() = ctrl || alt || shift
    val ctrl: Boolean = false,
    val shift: Boolean = false,
    }
    } else {
 *
 * (Enter, Backspace).
 * (Esc, Ctrl, arrows) or delivers as an editing command instead of bytes
 * Keys a terminal needs but a phone's soft keyboard either has no cap for
 * Turns key presses into the bytes a PTY expects — the encoding readline and
 * Two things routinely go wrong without this: Enter is carriage return (`\r`),
 * app turns on DECCKM.
 * every TUI decode.
 * not line feed, because apps in raw mode see the byte the tty driver would
 * otherwise have translated; and arrow keys switch from CSI to SS3 form once an
 */
) {
/**
/** Modifier latches: set by tapping Ctrl/Alt/Shift, consumed by the next key. */
@Immutable
data class TerminalModifiers(
enum class TerminalKey {
import androidx.compose.runtime.Immutable
object TerminalKeyEncoder {
package com.inspiredandroid.kai.build.terminal
}
