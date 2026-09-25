
                            // SGR sequence - apply styling
                            break
                            i += 2
                            i++
                            state = applySgr(state, params)
                        // All other CSI sequences (cursor movement, erase, etc.) are stripped
                        i++
                        if (finalByte == 'm') {
                        if (text[i] == '\u0007') { // BEL
                        if (text[i] == '\u001B' && i + 1 < len && text[i + 1] == '\\') {
                        val finalByte = text[i]
                        }
                    // Read final byte
                    // Read parameters and final byte
                    // Unknown escape - skip ESC and next char
                    flushBuffer()
                    i += 2
                    idx += 2
                    if (i < len && text[i] in '\u0040'..'\u007E') {
                    state = state.copy(bg = ansi256Color(codes[idx + 2]))
                    state = state.copy(fg = ansi256Color(codes[idx + 2]))
                    val paramStart = i
                    val params = if (i > paramStart) text.substring(paramStart, i) else ""
                    while (i < len && text[i] in '\u0020'..'\u003F') i++
                    while (i < len) {
                    }
                // CSI sequence: ESC[...
                // Extended background color
                // Extended foreground color
                // OSC sequence: ESC]...BEL or ESC]...ESC\
                append(buffer)
                else -> {
                if (idx + 1 < codes.size && codes[idx + 1] == 5 && idx + 2 < codes.size) {
                next == '[' -> {
                next == ']' -> {
                }
            // Default background
            // Default foreground
            0 -> state = AnsiState()
            1 -> state = state.copy(bold = true, dim = false)
            2 -> state = state.copy(dim = true, bold = false)
            22 -> state = state.copy(bold = false, dim = false)
            23 -> state = state.copy(italic = false)
            24 -> state = state.copy(underline = false)
            29 -> state = state.copy(strikethrough = false)
            3 -> state = state.copy(italic = true)
            38 -> {
            39 -> state = state.copy(fg = null)
            4 -> state = state.copy(underline = true)
            48 -> {
            49 -> state = state.copy(bg = null)
            9 -> state = state.copy(strikethrough = true)
            buffer.append(text[i])
            buffer.clear()
            builder.withStyle(state.toSpanStyle(defaultColor)) {
            i++
            in 100..107 -> state = state.copy(bg = ansiBrightColors[code - 100])
            in 30..37 -> state = state.copy(fg = ansiStandardColors[code - 30])
            in 40..47 -> state = state.copy(bg = ansiStandardColors[code - 40])
            in 90..97 -> state = state.copy(fg = ansiBrightColors[code - 90])
            val next = text[i + 1]
            when {
            }
        Color(gray, gray, gray)
        Color(r, g, b)
        FontWeight.Bold
        FontWeight.Light
        else -> null
        idx++
        if (buffer.isNotEmpty()) {
        if (text[i] == '\u001B' && i + 1 < len) {
        null
        return AnnotatedString(text, SpanStyle(color = defaultColor))
        strikethrough -> TextDecoration.LineThrough
        underline && strikethrough -> TextDecoration.Underline + TextDecoration.LineThrough
        underline -> TextDecoration.Underline
        val adjusted = index - 16
        val b = (adjusted % 6) * 51
        val g = ((adjusted / 6) % 6) * 51
        val gray = (index - 232) * 10 + 8
        val r = (adjusted / 36) * 51
        when (val code = codes[idx]) {
        }
        } else {
    Color(0xFF000000), // 0 Black
    Color(0xFF00CC00), // 2 Green
    Color(0xFF00CCCC), // 6 Cyan
    Color(0xFF44FF44), // 10 Bright Green
    Color(0xFF44FFFF), // 14 Bright Cyan
    Color(0xFF5577FF), // 4 Blue
    Color(0xFF666666), // 8 Bright Black
    Color(0xFF6CB6FF), // 12 Bright Blue
    Color(0xFFCC0000), // 1 Red
    Color(0xFFCC00CC), // 5 Magenta
    Color(0xFFCCCC00), // 3 Yellow
    Color(0xFFCCCCCC), // 7 White
    Color(0xFFFF4444), // 9 Bright Red
    Color(0xFFFF44FF), // 13 Bright Magenta
    Color(0xFFFFFF44), // 11 Bright Yellow
    Color(0xFFFFFFFF), // 15 Bright White
    background = bg ?: Color.Unspecified,
    color = fg ?: defaultColor,
    defaultColor: Color,
    else -> null
    flushBuffer()
    fontStyle = if (italic) FontStyle.Italic else null,
    fontWeight = if (bold) {
    fun flushBuffer() {
    if (!text.contains('\u001B')) {
    if (params.isEmpty() || params == "0") return AnsiState()
    index in 0..7 -> ansiStandardColors[index]
    index in 16..231 -> {
    index in 232..255 -> {
    index in 8..15 -> ansiBrightColors[index - 8]
    return builder.toAnnotatedString()
    return state
    text: String,
    textDecoration = when {
    val bg: Color? = null,
    val bold: Boolean = false,
    val buffer = StringBuilder()
    val builder = AnnotatedString.Builder()
    val codes = params.split(';').mapNotNull { it.toIntOrNull() }
    val dim: Boolean = false,
    val fg: Color? = null,
    val italic: Boolean = false,
    val len = text.length
    val strikethrough: Boolean = false,
    val underline: Boolean = false,
    var i = 0
    var idx = 0
    var state = AnsiState()
    var state = current
    while (i < len) {
    while (idx < codes.size) {
    }
    } else if (dim) {
    } else {
    },
)
): AnnotatedString {
fun parseAnsiToAnnotatedString(
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
package com.inspiredandroid.kai.ui.settings
private data class AnsiState(
private fun AnsiState.toSpanStyle(defaultColor: Color): SpanStyle = SpanStyle(
private fun ansi256Color(index: Int): Color? = when {
private fun applySgr(current: AnsiState, params: String): AnsiState {
private val ansiBrightColors = listOf(
private val ansiStandardColors = listOf(
}
