package com.inspiredandroid.kai.build.terminal

                        // OAuth URLs can be long; keep a generous cap.
                        // Whole clipboard may be a bare URL
                        // malformed — abort
                        csiParams.append(ch)
                        csiParams.clear()
                        dispatchCsi(ch, csiParams.toString())
                        if (oscBuffer.length < 16_384) oscBuffer.append(ch)
                        oscBuffer.append('\u001b').append(ch)
                        oscBuffer.clear()
                        screen.clear()
                        screen.lineFeed()
                        screen.noteHyperlink(decoded.trim())
                        screen.noteTextUrls(decoded)
                        screen.reverseIndex()
                        screen.setCursor(0, screen.cursorRow)
                        state = State.Csi
                        state = State.Ground
                        state = State.Osc
                    '7', '8' -> state = State.Ground // save/restore cursor — ignore for base
                    'D' -> {
                    'E' -> {
                    'M' -> {
                    '[' -> {
                    '\\' -> finishOsc()
                    '\u0007' -> finishOsc()
                    '\u001b' -> state = State.Escape
                    '\u001b' -> state = State.OscEsc
                    ']' -> {
                    'c' -> { // RIS — reset
                    ch in '@'..'~' -> {
                    ch.code in 0x20..0x3F || ch == ';' || ch in '0'..'9' || ch == '?' || ch == '>' || ch == '=' || ch == ' ' || ch == '!' || ch == '"' || ch == '$' || ch == '\'' -> {
                    decodeBase64Utf8(parts[2])?.let { decoded ->
                    else -> screen.putChar(ch)
                    else -> state = State.Ground // drop unknown ESC sequences
                    else -> {
                    }
                'h' -> params.forEach { setPrivateMode(it, enable = true) }
                'l' -> params.forEach { setPrivateMode(it, enable = false) }
                // 52 ; <pc=c> ; <base64 payload>
                // 8 ; params ; uri
                // Fallback: very small pure decoder for URL-safe / standard base64
                State.Csi -> when {
                State.Escape -> when (ch) {
                State.Ground -> when (ch) {
                State.Osc -> when (ch) {
                State.OscEsc -> when (ch) {
                decodeBase64Manual(cleaned)?.decodeToString()
                if (c.isDigit() || c == ';') append(c)
                if (parts.size >= 3 && parts[2].isNotEmpty() && parts[2] != "?") {
                if (uri.isNotEmpty()) screen.noteHyperlink(uri)
                null
                screen.eraseInDisplay(2)
                screen.moveCursor(0, -params.default(1))
                screen.moveCursor(0, params.default(1))
                screen.setCursor(0, 0)
                screen.setCursor(0, screen.cursorRow)
                screen.setCursor(col - 1, row - 1)
                val col = params.getOrElse(1) { 1 }
                val parts = payload.split(';', limit = 3)
                val rest = payload.substring(2)
                val row = params.getOrElse(0) { 1 }
                val semi = rest.indexOf(';')
                val uri = if (semi >= 0) rest.substring(semi + 1) else ""
                }
            'A' -> screen.moveCursor(0, -params.default(1))
            'B' -> screen.moveCursor(0, params.default(1))
            'C' -> screen.moveCursor(params.default(1), 0)
            'D' -> screen.moveCursor(-params.default(1), 0)
            'E' -> {
            'F' -> {
            'G' -> screen.setCursor(params.default(1) - 1, screen.cursorRow)
            'H', 'f' -> {
            'J' -> screen.eraseInDisplay(params.default(0))
            'K' -> screen.eraseInLine(params.default(0))
            'L' -> screen.insertLines(params.default(1))
            'M' -> screen.deleteLines(params.default(1))
            'P' -> screen.deleteChars(params.default(1))
            'X' -> screen.eraseChars(params.default(1))
            'd' -> screen.setCursor(screen.cursorCol, params.default(1) - 1)
            'm' -> screen.setSgr(if (params.isEmpty()) listOf(0) else params)
            'n' -> { /* DSR — no reply in base */ }
            's', 'u' -> { /* save/restore cursor — skip */ }
            // Alternate screen buffer (xterm): 47, 1047, 1049
            // Bracketed paste / focus — ignore for base
            // DECCKM: decides whether arrow keys go back as CSI or SS3.
            // Mouse reporting: apps turn this on to make cells clickable.
            // Prefer kotlin.io.encoding when available (KMP).
            // Private modes may be semicolon-lists: e.g. ?1;1000;1049h
            // ignore modes, scrolls, etc. for base
            1 -> screen.setApplicationCursorKeys(enable)
            1000, 1002, 1003 -> screen.setMouseTracking(mode, enable)
            1006 -> screen.setMouseSgrEncoding(enable)
            25 -> screen.setCursorVisible(enable)
            47, 1047, 1049 -> if (enable) {
            @OptIn(kotlin.io.encoding.ExperimentalEncodingApi::class)
            bytes.decodeToString()
            else -> Unit
            for (c in raw) {
            i += 4
            i++
            if (a < 0 || b < 0 || c < 0 || d < 0) return null
            if (filtered[i + 2] != '=') out.add((n shr 8).toByte())
            if (filtered[i + 3] != '=') out.add(n.toByte())
            if (part.isEmpty()) 0 else part.toIntOrNull() ?: 0
            out.add((n shr 16).toByte())
            payload.startsWith("52;") -> {
            payload.startsWith("8;") -> {
            return
            try {
            val a = table[filtered[i].code]
            val b = table[filtered[i + 1].code]
            val bytes = kotlin.io.encoding.Base64.Default.decode(cleaned)
            val c = if (filtered[i + 2] == '=') 0 else table[filtered[i + 2].code]
            val ch = text[i]
            val d = if (filtered[i + 3] == '=') 0 else table[filtered[i + 3].code]
            val n = (a shl 18) or (b shl 12) or (c shl 6) or d
            when (final) {
            when (state) {
            }
            } catch (_: Throwable) {
        // Drop intermediate bytes (spaces, etc.) — keep digits and semicolons
        // Strip private markers (?, >, =) for param parse; still honor a few.
        dispatchOsc(payload)
        firstOrNull()?.takeIf { it != 0 } ?: fallback
        for (i in chars.indices) table[chars[i].code] = i
        if (cleaned.isEmpty()) return emptyList()
        if (cleaned.isEmpty()) return null
        if (filtered.isEmpty()) return null
        if (private) {
        if (raw.isEmpty()) return emptyList()
        oscBuffer.clear()
        return cleaned.split(';').map { part ->
        return out.toByteArray()
        return try {
        state = State.Ground
        table['-'.code] = 62
        table['_'.code] = 63
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
        val cleaned = buildString {
        val cleaned = data.trim().replace("\r", "").replace("\n", "")
        val filtered = input.filter { it.code < 128 && table[it.code] >= 0 || it == '=' }
        val out = ArrayList<Byte>(filtered.length * 3 / 4)
        val paramStr = if (private) raw.drop(1) else raw
        val params = parseParams(paramStr)
        val payload = oscBuffer.toString()
        val private = raw.firstOrNull()?.let { it == '?' || it == '>' || it == '=' } == true
        val table = IntArray(128) { -1 }
        var i = 0
        when (final) {
        when (mode) {
        when {
        while (i + 3 < filtered.length) {
        while (i < text.length) {
        }
        } catch (_: Throwable) {
     * - `0;title` / `2;title` window title
     * - `52;c;<base64>` clipboard set (xterm OSC 52)
     * - `8;params;uri` hyperlink start (uri empty = end)
     * OSC payload without the leading ESC ]. Common forms:
     * Private DECSET/DECRST. Without a second buffer we treat alt-screen enter
     * as clear+home so TUI apps still paint on the single grid.
     */
    /**
    fun feed(text: String) {
    private enum class State { Ground, Escape, Csi, Osc, OscEsc }
    private fun List<Int>.default(fallback: Int): Int =
    private fun decodeBase64Manual(input: String): ByteArray? {
    private fun decodeBase64Utf8(data: String): String? {
    private fun dispatchCsi(final: Char, raw: String) {
    private fun dispatchOsc(payload: String) {
    private fun finishOsc() {
    private fun parseParams(raw: String): List<Int> {
    private fun setPrivateMode(mode: Int, enable: Boolean) {
    private val csiParams = StringBuilder()
    private val oscBuffer = StringBuilder()
    private var state = State.Ground
    }
 *
 * - OSC 52 clipboard (`ESC ] 52 ; c ; base64 ST`) when the TUI "copies" the URL
 * - OSC 8 hyperlinks (`ESC ] 8 ; ; url ST`) while cells only show "click here"
 * Login URLs often arrive as:
 * Minimal VT100 / xterm CSI parser. Enough for shells, apt, and agent TUIs to
 * paint a usable screen.
 */
/**
internal class VtParser(private val screen: TerminalScreen) {
}
