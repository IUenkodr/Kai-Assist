package com.inspiredandroid.kai.build.terminal
import kotlinx.collections.immutable.toImmutableList

                        currentBg = map256(params[i + 2])
                        currentBg = rgbTo16(params[i + 2], params[i + 3], params[i + 4])
                        currentFg = map256(params[i + 2])
                        currentFg = rgbTo16(params[i + 2], params[i + 3], params[i + 4])
                        i += 2
                        i += 4
                    bg = bg[i].toInt() and 0xFF,
                    bold = bold[i],
                    char = chars[i],
                    fg = fg[i].toInt() and 0xFF,
                    if (i + 1 < params.size && params[i + 1] == 5 && i + 2 < params.size) {
                    }
                    } else if (i + 1 < params.size && params[i + 1] == 2 && i + 4 < params.size) {
                ),
                0 -> resetSgr()
                1 -> currentBold = true
                22 -> currentBold = false
                38 -> {
                39 -> currentFg = 7
                48 -> {
                49 -> currentBg = 0
                TerminalCell(
                cursorCol = 0
                cursorCol = next.coerceAtMost(columns - 1)
                else -> TerminalMouseTracking.None
                if (cursorCol > 0) cursorCol--
                in 100..107 -> currentBg = p - 100 + 8
                in 30..37 -> currentFg = p - 30
                in 40..47 -> currentBg = p - 40
                in 90..97 -> currentFg = p - 90 + 8
                lineFeed()
                mouseAnyMotion -> TerminalMouseTracking.AnyMotion
                mouseButtonMotion -> TerminalMouseTracking.ButtonMotion
                mouseClick -> TerminalMouseTracking.Click
                newBg[ni] = bg[oi]
                newBold[ni] = bold[oi]
                newChars[ni] = chars[oi]
                newFg[ni] = fg[oi]
                return
                val next = ((cursorCol / 8) + 1) * 8
                val ni = row * nc + col
                val oi = row * columns + col
                }
            '\b' -> {
            '\n' -> {
            '\r' -> {
            '\t' -> {
            '\u0007' -> return
            )
            // Encounter order; only the best URL per path is kept.
            0 -> clearRange(index(cursorCol, cursorRow), columns * rows)
            0 -> clearRange(rowStart + cursorCol, rowStart + columns)
            1 -> clearRange(0, index(cursorCol, cursorRow) + 1)
            1 -> clearRange(rowStart, rowStart + cursorCol + 1)
            1000 -> mouseClick = enable
            1002 -> mouseButtonMotion = enable
            1003 -> mouseAnyMotion = enable
            2 -> clearRange(rowStart, rowStart + columns)
            2, 3 -> clearRange(0, columns * rows)
            applicationCursorKeys = applicationCursorKeys,
            bg[dest] = bg[src]
            bg[i] = 0
            bg[to + c] = bg[from + c]
            bold[dest] = bold[src]
            bold[i] = false
            bold[to + c] = bold[from + c]
            cells = cells,
            cells.add(
            chars[dest] = chars[src]
            chars[i] = ' '
            chars[to + c] = chars[from + c]
            clearRow(row)
            columns = columns,
            copyRow(row + 1, row)
            copyRow(row + n, row)
            copyRow(row - 1, row)
            copyRow(row - n, row)
            cursorCol = 0
            cursorCol = cursorCol.coerceIn(0, (columns - 1).coerceAtLeast(0)),
            cursorRow = cursorRow.coerceIn(0, (rows - 1).coerceAtLeast(0)),
            cursorRow++
            cursorRow--
            cursorVisible = cursorVisible,
            dest++
            else -> return
            encoding = if (mouseSgr) TerminalMouseEncoding.Sgr else TerminalMouseEncoding.X10,
            fg[dest] = fg[src]
            fg[i] = 7
            fg[to + c] = fg[from + c]
            for (col in 0 until copyCols) {
            hyperlinks = hyperlinks.values.toImmutableList(),
            hyperlinks.remove(oldest)
            i++
            lineFeed()
            mouse = mouseState,
            parser.feed(text)
            resetSgr()
            return
            return base.trimEnd('/')
            return rgbTo16(r * 51, g * 51, b * 51)
            revision = revision,
            revision++
            rows = rows,
            scrollDown()
            scrollUp()
            src++
            tracking = when {
            val b = v % 6
            val base = noFrag.substringBefore('?')
            val g = (v / 6) % 6
            val noFrag = url.substringBefore('#')
            val oldest = hyperlinks.keys.first()
            val r = v / 36
            val v = n - 16
            when (val p = params[i]) {
            }
            },
        )
        /** Enough for one auth URL + a docs link; keeps Claude setup from flooding. */
        /** scheme://host/path — query and fragment ignored so OAuth variants collapse. */
        // Clipboard may include surrounding text; pull out first URL if needed.
        // Closest thing we have to a full reset: a fresh shell has DECCKM off,
        // Drop trailing punctuation TUIs sometimes leave attached.
        // Prefer the longer form: full OAuth query beats a line-wrapped stump.
        // Re-insert so the path stays "most recently improved" in encounter order.
        // Same reasoning for mouse reporting: whatever asked for it is gone, and
        // Stop at whitespace, quotes, ANSI ESC, or common terminal delimiters.
        // and stale application-mode arrows would break the plain prompt.
        // reports sent to a plain shell would print as junk.
        // xterm default: LF does not imply CR; many apps send CRLF. Keep col.
        URL_REGEX.findAll(text).forEach { if (noteHyperlink(it.value)) added = true }
        applicationCursorKeys = enable
        applicationCursorKeys = false
        bg = newBg
        bg[i] = currentBg.toByte()
        bold = newBold
        bold[i] = currentBold
        chars = newChars
        chars[i] = ch
        clearRange(dest, rowEnd)
        clearRange(row * columns, (row + 1) * columns)
        clearRange(start, end)
        clearRow(0)
        clearRow(rows - 1)
        columns = nc
        const val MAX_HYPERLINKS = 3
        currentBg = 0
        currentBold = false
        currentFg = 7
        cursorCol = 0
        cursorCol = col.coerceIn(0, columns - 1)
        cursorCol = cursorCol.coerceIn(0, columns - 1)
        cursorCol++
        cursorRow = 0
        cursorRow = cursorRow.coerceIn(0, rows - 1)
        cursorRow = row.coerceIn(0, rows - 1)
        cursorVisible = true
        cursorVisible = visible
        fg = newFg
        fg[i] = currentFg.toByte()
        for (c in 0 until columns) {
        for (i in chars.indices) {
        for (i in s until e) {
        for (row in (rows - 1) downTo cursorRow + n) {
        for (row in 0 until copyRows) {
        for (row in 0 until rows - 1) {
        for (row in cursorRow until cursorRow + n) {
        for (row in cursorRow until rows - n) {
        for (row in rows - 1 downTo 1) {
        for (row in rows - n until rows) {
        fun hyperlinkKey(url: String): String {
        get() = TerminalMouseState(
        hyperlinks.clear()
        hyperlinks[key] = url
        if (!url.startsWith("http://") && !url.startsWith("https://")) return false
        if (ch.code < 32 && ch != '\u001b') return
        if (cursorCol >= columns) {
        if (cursorRow < rows - 1) {
        if (cursorRow > 0) {
        if (existing != null && existing.length >= url.length) return false
        if (existing != null) hyperlinks.remove(key)
        if (hyperlinks.isEmpty()) return
        if (key.isEmpty()) return false
        if (length <= 0) return
        if (n < 0) return 7
        if (n < 16) return n
        if (n < 232) {
        if (nc == columns && nr == rows) return
        if (params.isEmpty()) {
        if (text.isEmpty()) return
        if (text.isNotEmpty()) {
        if (trimmed.isEmpty()) return false
        mouseAnyMotion = false
        mouseButtonMotion = false
        mouseClick = false
        mouseSgr = enable
        mouseSgr = false
        parser.feed(text)
        private set
        return TerminalSnapshot(
        return added
        return bright + ri + gi * 2 + bi * 4
        return rgbTo16(gray, gray, gray)
        return true
        revision++
        rows = nr
        setCursor(cursorCol + dCol, cursorRow + dRow)
        url = url.trimEnd('.', ',', ';', ':', ')', ']', '"', '\'')
        val URL_REGEX = Regex("""https?://[^\s\u001b"'<>)\]]+""")
        val bi = if (b > 80) 1 else 0
        val bright = if (r + g + b > 320) 8 else 0
        val cells = ArrayList<TerminalCell>(columns * rows)
        val copyCols = minOf(columns, nc)
        val copyRows = minOf(rows, nr)
        val e = end.coerceIn(0, chars.size)
        val end = (start + n).coerceAtMost((cursorRow + 1) * columns)
        val existing = hyperlinks[key]
        val from = fromRow * columns
        val from = rowStart + cursorCol
        val gi = if (g > 80) 1 else 0
        val gray = (n - 232) * 10 + 8
        val i = index(cursorCol, cursorRow)
        val key = hyperlinkKey(url)
        val n = count.coerceAtLeast(1)
        val n = count.coerceAtLeast(1).coerceAtMost(rows - cursorRow)
        val nc = newColumns.coerceIn(MIN_COLUMNS, MAX_COLUMNS)
        val newBg = ByteArray(nc * nr) { 0 }
        val newBold = BooleanArray(nc * nr)
        val newChars = CharArray(nc * nr) { ' ' }
        val newFg = ByteArray(nc * nr) { 7 }
        val nr = newRows.coerceIn(MIN_ROWS, MAX_ROWS)
        val ri = if (r > 80) 1 else 0
        val rowEnd = rowStart + columns
        val rowStart = cursorRow * columns
        val s = start.coerceIn(0, chars.size)
        val shiftEnd = (from + n).coerceAtMost(rowEnd)
        val start = index(cursorCol, cursorRow)
        val text = bytes.decodeToString(offset, offset + length, throwOnInvalidSequence = false)
        val to = toRow * columns
        val trimmed = uri.trim().trimEnd('\u0000', '\r', '\n', ' ')
        var added = false
        var dest = from
        var i = 0
        var src = shiftEnd
        var url = URL_REGEX.find(trimmed)?.value ?: trimmed
        when (ch) {
        when (mode) {
        while (hyperlinks.size > MAX_HYPERLINKS) {
        while (i < params.size) {
        while (src < rowEnd) {
        }
        } else {
     *
     * Change geometry. Overlapping cells are copied; the rest is blank.
     * Cursor is clamped. TUI apps typically repaint entirely after SIGWINCH.
     * DECCKM (private mode 1). While set, apps expect arrow keys as `ESC O A`
     * Mouse reporting (private modes 1000/1002/1003 and 1005/1006/1015). xterm
     * OSC 8 / stream / open-url URIs. Keyed by scheme+host+path so Claude’s
     * Private mode 1006. The UTF-8 (1005) and urxvt (1015) forms are not
     * Private modes 1000, 1002, 1003. Mode 9 (X10 compatibility) is deliberately
     * Record a hyperlink from OSC 8 / OSC 52 / raw stream. Empty or non-http
     * Returns true when at least one new link was recorded.
     * Returns true when the displayed set changed.
     * Scan arbitrary text (raw PTY chunk, OSC 52 payload, etc.) for http(s) URLs.
     * different query params do not flood the bar.
     * entry; value is the best (usually longest) full URL for that path.
     * longest wins) so OAuth flows that re-print the authorize URL with
     * many OAuth authorize variants (different redirect_uri) collapse to one
     * not honored: it wants presses without releases, and the release we would
     * others; the tracking level the app actually gets is the widest one set.
     * produced, so an app asking for those keeps the X10 form it would have got
     * rather than `ESC [ A`; sending the wrong form prints junk instead of moving.
     * send reads as a second press to an app expecting that dialect.
     * treats each as an independent flag, so turning one off must not clear the
     * values are ignored. Same origin+path collapses to one entry (latest /
     * without asking at all.
     */
    /**
    /** Drop captured hyperlinks without wiping the cell grid (used after display TTL). */
    // --- called from VtParser ------------------------------------------------
    columns: Int = DEFAULT_COLUMNS,
    fun clear() {
    fun clearHyperlinks() {
    fun resize(newColumns: Int, newRows: Int) {
    fun snapshot(): TerminalSnapshot {
    fun write(bytes: ByteArray, offset: Int = 0, length: Int = bytes.size - offset) {
    fun writeText(text: String) {
    internal fun deleteChars(count: Int) {
    internal fun deleteLines(count: Int) {
    internal fun eraseChars(count: Int) {
    internal fun eraseInDisplay(mode: Int) {
    internal fun eraseInLine(mode: Int) {
    internal fun insertLines(count: Int) {
    internal fun lineFeed() {
    internal fun moveCursor(dCol: Int, dRow: Int) {
    internal fun noteHyperlink(uri: String): Boolean {
    internal fun noteTextUrls(text: String): Boolean {
    internal fun putChar(ch: Char) {
    internal fun reverseIndex() {
    internal fun setApplicationCursorKeys(enable: Boolean) {
    internal fun setCursor(col: Int, row: Int) {
    internal fun setCursorVisible(visible: Boolean) {
    internal fun setMouseSgrEncoding(enable: Boolean) {
    internal fun setMouseTracking(mode: Int, enable: Boolean) {
    internal fun setSgr(params: List<Int>) {
    internal val mouseState: TerminalMouseState
    private companion object {
    private fun clearRange(start: Int, end: Int) {
    private fun clearRow(row: Int) {
    private fun copyRow(fromRow: Int, toRow: Int) {
    private fun index(col: Int, row: Int) = row * columns + col
    private fun map256(n: Int): Int {
    private fun resetSgr() {
    private fun rgbTo16(r: Int, g: Int, b: Int): Int {
    private fun scrollDown() {
    private fun scrollUp() {
    private val hyperlinks = LinkedHashMap<String, String>()
    private val parser = VtParser(this)
    private var bg = ByteArray(this.columns * this.rows) { 0 }
    private var bold = BooleanArray(this.columns * this.rows)
    private var chars = CharArray(this.columns * this.rows) { ' ' }
    private var fg = ByteArray(this.columns * this.rows) { 7 }
    private var mouseAnyMotion: Boolean = false
    private var mouseButtonMotion: Boolean = false
    private var mouseClick: Boolean = false
    private var mouseSgr: Boolean = false
    private var revision: Long = 0L
    rows: Int = DEFAULT_ROWS,
    var applicationCursorKeys: Boolean = false
    var columns: Int = columns.coerceAtLeast(1)
    var currentBg: Int = 0
    var currentBold: Boolean = false
    var currentFg: Int = 7
    var cursorCol: Int = 0
    var cursorRow: Int = 0
    var cursorVisible: Boolean = true
    var rows: Int = rows.coerceAtLeast(1)
    }
 *
 * Call [resize] when the host viewport changes; TUI apps react via SIGWINCH after
 * Mutable character-cell screen buffer + cursor. Fed by [VtParser]; snapshotted
 * for Compose.
 * the PTY winsize is updated separately.
 */
) {
/**
class TerminalScreen(
}
