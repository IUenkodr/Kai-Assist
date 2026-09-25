
            "\u001b]8;;https://example.com/login?x=1\u0007click here\u001b]8;;\u0007",
            "https://claude.com/cai/oauth/authorize?code=true&redirect_uri=http://localhost:1234",
            "https://claude.com/cai/oauth/authorize?code=true&redirect_uri=https://platform.claude.com/cb",
        )
        // "https://auth.example/x" in standard base64
        // Dropping motion tracking must leave click tracking and SGR alone.
        // ESC [ 3 ; 5 H  -> row 3, col 5 (1-based)
        // ESC [ ? 1000 ; 1006 h — what agent TUIs send to make cells clickable.
        // ESC [ ? 1049 h  — enter alt screen (we clear + home)
        // ESC c — RIS, the app is gone.
        // OSC 8 ; ; https://example.com/login BEL + visible label + OSC 8 end
        // Shorter stump must not replace the full URL.
        // Visible cells still show the label text
        // resize() clamps to MIN/MAX; stay within that range.
        assertEquals("https://a.example/four", snap.hyperlinks[2])
        assertEquals("https://a.example/two", snap.hyperlinks[0])
        assertEquals("https://auth.example/x", snap.hyperlinks[0])
        assertEquals("https://example.com/login?x=1", snap.hyperlinks[0])
        assertEquals("https://x.ai/device?code=ABC", screen.snapshot().hyperlinks[0])
        assertEquals(' ', snap.cellAt(0, 0).char)
        assertEquals(' ', snap.cellAt(1, 0).char)
        assertEquals('*', snap.cellAt(4, 2).char)
        assertEquals('X', snap.cellAt(0, 0).char)
        assertEquals('a', snap.cellAt(0, 0).char)
        assertEquals('b', snap.cellAt(1, 0).char)
        assertEquals('c', snap.cellAt(0, 0).char)
        assertEquals('c', snap.cellAt(0, 1).char)
        assertEquals('d', snap.cellAt(1, 1).char)
        assertEquals('e', snap.cellAt(1, 0).char)
        assertEquals('h', snap.cellAt(0, 0).char)
        assertEquals('i', snap.cellAt(1, 0).char)
        assertEquals('o', snap.cellAt(4, 0).char)
        assertEquals(0, snap.cursorCol)
        assertEquals(0, snap.cursorRow)
        assertEquals(1, screen.snapshot().hyperlinks.size)
        assertEquals(1, snap.cellAt(0, 0).fg) // red
        assertEquals(1, snap.hyperlinks.size)
        assertEquals(16, snap.rows)
        assertEquals(2, snap.cursorCol)
        assertEquals(2, snap.cursorRow)
        assertEquals(3, snap.hyperlinks.size)
        assertEquals(30, snap.columns)
        assertEquals(5, snap.cursorCol)
        assertEquals(TerminalMouseEncoding.Sgr, off.encoding)
        assertEquals(TerminalMouseEncoding.Sgr, on.encoding)
        assertEquals(TerminalMouseEncoding.X10, after.encoding)
        assertEquals(TerminalMouseTracking.AnyMotion, screen.snapshot().mouse.tracking)
        assertEquals(TerminalMouseTracking.Click, on.tracking)
        assertEquals(TerminalMouseTracking.Click, screen.snapshot().mouse.tracking)
        assertEquals(TerminalMouseTracking.None, after.tracking)
        assertEquals(TerminalMouseTracking.None, off.tracking)
        assertTrue(snap.cellAt(0, 0).bold)
        assertTrue(snap.hyperlinks.isEmpty())
        assertTrue(snap.hyperlinks[0].contains("platform.claude.com"))
        screen.clearHyperlinks()
        screen.noteHyperlink(
        screen.noteHyperlink("https://a.example/four")
        screen.noteHyperlink("https://a.example/one")
        screen.noteHyperlink("https://a.example/three")
        screen.noteHyperlink("https://a.example/two")
        screen.noteHyperlink("https://claude.com/cai/oauth/authorize?code=true")
        screen.noteHyperlink("https://example.com/a")
        screen.noteTextUrls("go to https://x.ai/device?code=ABC and finish")
        screen.resize(30, 16)
        screen.writeText(
        screen.writeText("\u001b[1;31mX\u001b[0m")
        screen.writeText("\u001b[2J\u001b[H")
        screen.writeText("\u001b[3;5H*")
        screen.writeText("\u001b[?1000;1006h")
        screen.writeText("\u001b[?1000l")
        screen.writeText("\u001b[?1002l")
        screen.writeText("\u001b[?1003;1006h")
        screen.writeText("\u001b[?1049hX")
        screen.writeText("\u001b]52;c;$b64\u0007")
        screen.writeText("\u001bc")
        screen.writeText("ab\r\ncd")
        screen.writeText("abc")
        screen.writeText("hello")
        screen.writeText("hi")
        screen.writeText("keep")
        val after = screen.snapshot().mouse
        val b64 = "aHR0cHM6Ly9hdXRoLmV4YW1wbGUveA=="
        val off = screen.snapshot().mouse
        val on = screen.snapshot().mouse
        val screen = TerminalScreen(columns = 10, rows = 3)
        val screen = TerminalScreen(columns = 10, rows = 4)
        val screen = TerminalScreen(columns = 20, rows = 5)
        val screen = TerminalScreen(columns = 40, rows = 10)
        val screen = TerminalScreen(columns = 40, rows = 20)
        val screen = TerminalScreen(columns = 40, rows = 5)
        val snap = screen.snapshot()
    @Test
    fun altScreenEnterClears() {
    fun clearHyperlinksLeavesCellsIntact() {
    fun crAndLf() {
    fun cupMovesCursor() {
    fun eraseInDisplayClears() {
    fun hyperlinkCapKeepsMostRecentPaths() {
    fun mouseModesAreTracked() {
    fun mouseModesResetOnFullReset() {
    fun oauthVariantsCollapseToOnePath() {
    fun osc52ClipboardUrlIsCaptured() {
    fun osc8HyperlinkIsCaptured() {
    fun rawStreamUrlScan() {
    fun resizePreservesOverlap() {
    fun sgrSetsBoldAndColor() {
    fun writesPlainText() {
    }
class TerminalScreenTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.build.terminal
}
