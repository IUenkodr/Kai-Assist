package com.inspiredandroid.kai.build.terminal
import kotlin.test.Test
import kotlin.test.assertEquals

                TerminalKey.Up,
                TerminalModifiers(ctrl = true, alt = true, shift = true),
            "\u001bOA",
            "\u001bOD",
            "\u001b[1;5C",
            "\u001b[1;8A",
            ),
            TerminalKeyEncoder.encode(
            TerminalKeyEncoder.encode(TerminalKey.Left, applicationCursorKeys = true),
            TerminalKeyEncoder.encode(TerminalKey.Right, ctrl, applicationCursorKeys = true),
            TerminalKeyEncoder.encode(TerminalKey.Up, applicationCursorKeys = true),
            TerminalModifiers(ctrl = true) + TerminalModifiers(shift = true),
            TerminalModifiers(ctrl = true, shift = true),
        )
        // A latched modifier stands for one key press, not for the whole word.
        // Merging never clears a modifier that either side had set.
        // No control mapping exists for digits — send the character itself.
        // xterm emits the parameterized CSI form regardless of DECCKM.
        assertEquals(
        assertEquals("", TerminalKeyEncoder.encodeText(""))
        assertEquals("1", TerminalKeyEncoder.encodeChar('1', ctrl))
        assertEquals("\b", TerminalKeyEncoder.encode(TerminalKey.Backspace, ctrl))
        assertEquals("\r", TerminalKeyEncoder.encode(TerminalKey.Enter))
        assertEquals("\t", TerminalKeyEncoder.encode(TerminalKey.Tab))
        assertEquals("\u0000", TerminalKeyEncoder.encodeChar(' ', ctrl))
        assertEquals("\u0003", TerminalKeyEncoder.encodeChar('C', ctrl))
        assertEquals("\u0003", TerminalKeyEncoder.encodeChar('c', ctrl))
        assertEquals("\u0003at", TerminalKeyEncoder.encodeText("cat", ctrl))
        assertEquals("\u0004", TerminalKeyEncoder.encodeChar('d', ctrl))
        assertEquals("\u001a", TerminalKeyEncoder.encodeChar('z', ctrl))
        assertEquals("\u001b", TerminalKeyEncoder.encode(TerminalKey.Escape))
        assertEquals("\u001b[1;2A", TerminalKeyEncoder.encode(TerminalKey.Up, shift))
        assertEquals("\u001b[1;3A", TerminalKeyEncoder.encode(TerminalKey.Up, alt))
        assertEquals("\u001b[1;5A", TerminalKeyEncoder.encode(TerminalKey.Up, ctrl))
        assertEquals("\u001b[3~", TerminalKeyEncoder.encode(TerminalKey.Delete))
        assertEquals("\u001b[5~", TerminalKeyEncoder.encode(TerminalKey.PageUp))
        assertEquals("\u001b[6;5~", TerminalKeyEncoder.encode(TerminalKey.PageDown, ctrl))
        assertEquals("\u001b[A", TerminalKeyEncoder.encode(TerminalKey.Up))
        assertEquals("\u001b[B", TerminalKeyEncoder.encode(TerminalKey.Down))
        assertEquals("\u001b[C", TerminalKeyEncoder.encode(TerminalKey.Right))
        assertEquals("\u001b[D", TerminalKeyEncoder.encode(TerminalKey.Left))
        assertEquals("\u001b[F", TerminalKeyEncoder.encode(TerminalKey.End))
        assertEquals("\u001b[H", TerminalKeyEncoder.encode(TerminalKey.Home))
        assertEquals("\u001b[Z", TerminalKeyEncoder.encode(TerminalKey.Tab, shift))
        assertEquals("\u001b\r", TerminalKeyEncoder.encode(TerminalKey.Enter, alt))
        assertEquals("\u001b\u007f", TerminalKeyEncoder.encode(TerminalKey.Backspace, alt))
        assertEquals("\u001ba", TerminalKeyEncoder.encodeChar('a', alt))
        assertEquals("\u001bcat", TerminalKeyEncoder.encodeText("cat", alt))
        assertEquals("\u001c", TerminalKeyEncoder.encodeChar('\\', ctrl))
        assertEquals("\u007f", TerminalKeyEncoder.encode(TerminalKey.Backspace))
        assertEquals("a", TerminalKeyEncoder.encodeChar('a'))
        assertEquals("ls -la", TerminalKeyEncoder.encodeText("ls -la"))
        assertEquals(TerminalModifiers.None, TerminalModifiers.None + TerminalModifiers.None)
        assertEquals(ctrl, ctrl + TerminalModifiers.None)
    @Test
    fun altBackspaceDeletesWord() {
    fun altEnterPrefixesEscape() {
    fun arrowsUseCsiByDefault() {
    fun arrowsUseSs3InApplicationCursorMode() {
    fun backspaceIsDelNotBackspace() {
    fun ctrlCharsFoldIntoC0Range() {
    fun encodeTextAppliesLatchToFirstCharacterOnly() {
    fun encodeTextPassesPlainTextThrough() {
    fun enterIsCarriageReturn() {
    fun escapeIsEsc() {
    fun homeAndEndUseCsi() {
    fun modifiedArrowsStayCsiEvenInApplicationMode() {
    fun modifierParamFollowsXterm() {
    fun modifiersCombine() {
    fun plainAndAltCharsPassThrough() {
    fun shiftTabIsCbt() {
    fun tildeKeysCarryModifiers() {
    private val alt = TerminalModifiers(alt = true)
    private val ctrl = TerminalModifiers(ctrl = true)
    private val shift = TerminalModifiers(shift = true)
    }
class TerminalKeyEncoderTest {
}
