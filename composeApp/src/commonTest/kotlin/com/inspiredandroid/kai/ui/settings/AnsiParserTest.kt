package com.inspiredandroid.kai.ui.settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

                deco.toString().contains("Underline") && deco.toString().contains("LineThrough")
            deco != null && deco != TextDecoration.None &&
            it.item.fontWeight == FontWeight.Bold && it.item.color == Color(0xFFCC0000)
            val deco = it.item.textDecoration
        // "AB" should be bold (no color)
        // "CD" should be bold AND red
        // 255 is not a defined SGR code, should pass through without crashing
        // After ESC[39m, the "Default" segment should have the default fallback color
        // After code 22 the weight should not be bold
        // Background = ansiStandardColors[2] = 0xFF00CC00
        // Bold across two pieces of text separated by another bold-no-op SGR
        // Bold red
        // Color should fall back to default
        // Cursor up (ESC[A), erase line (ESC[2K) — should be removed but text preserved
        // ESC followed by neither [ nor ] — both bytes are skipped
        // ESC[ with no params or final byte
        // ESC[m is equivalent to ESC[0m
        // Fast path wraps everything in a default-color span
        // Set red, then reset fg
        // Three colored runs at 0..3, 3..8, 8..12
        // adjusted=180, r=(180/36)*51=255, g=(180/6%6)*51=0, b=0
        // ansiBrightColors[1] = 0xFFFF4444
        // ansiBrightColors[1] = 0xFFFF4444 (background)
        // ansiStandardColors[1] = 0xFFCC0000
        // index 0..7 should map to ansiStandardColors
        // index 196 is the bright red corner of the 6x6x6 cube: r=5, g=0, b=0 → (255, 0, 0)
        // index 232 → gray = (232-232)*10 + 8 = 8
        assertContains(result.spanStyles.map { it.start to it.end }, 0 to 3)
        assertContains(result.spanStyles.map { it.start to it.end }, 3 to 8)
        assertContains(result.spanStyles.map { it.start to it.end }, 8 to 12)
        assertEquals("", result.text)
        assertEquals("AB", result.text)
        assertEquals("ABCD", result.text)
        assertEquals("AllPlain", result.text)
        assertEquals("BeforeAfter", result.text)
        assertEquals("Bold", result.text)
        assertEquals("BoldNormal", result.text)
        assertEquals("BoldRed", result.text)
        assertEquals("BrightRed", result.text)
        assertEquals("Green", result.text)
        assertEquals("Hello, world!", result.text)
        assertEquals("ItalicNormal", result.text)
        assertEquals("PrePost", result.text)
        assertEquals("Red", result.text)
        assertEquals("RedDefault", result.text)
        assertEquals("RedGreenBlue", result.text)
        assertEquals("Text", result.text)
        assertEquals("X", result.text)
        assertEquals("XY", result.text)
        assertEquals("both", result.text)
        assertEquals("dim", result.text)
        assertEquals("italic", result.text)
        assertEquals("strike", result.text)
        assertEquals("txt", result.text)
        assertEquals("under", result.text)
        assertEquals(0, boldSpan.start)
        assertEquals(4, boldSpan.end)
        assertEquals(Color(0xFFCC0000), cdSpan.item.color)
        assertEquals(FontWeight.Bold, abSpan.item.fontWeight)
        assertEquals(FontWeight.Bold, cdSpan.item.fontWeight)
        assertEquals(defaultColor, plainSpan.item.color)
        assertEquals(defaultColor, style.item.color)
        assertNotNull(abSpan)
        assertNotNull(boldSpan)
        assertNotNull(cdSpan)
        assertNotNull(defaultSpan)
        assertNotNull(dimSpan)
        assertNotNull(greenBg)
        assertNotNull(italicSpan)
        assertNotNull(normalSpan)
        assertNotNull(plainSpan)
        assertNotNull(redSpan)
        assertNotNull(span)
        assertNotNull(style)
        assertTrue(normalSpan.item.fontStyle != FontStyle.Italic)
        assertTrue(normalSpan.item.fontWeight != FontWeight.Bold)
        assertTrue(plainSpan.item.fontWeight != FontWeight.Bold)
        assertTrue(plainSpan.item.textDecoration == null || plainSpan.item.textDecoration == TextDecoration.None)
        val abSpan = result.spanStyles.firstOrNull { it.start == 0 && it.end == 2 }
        val boldSpan = result.spanStyles.firstOrNull { it.item.fontWeight == FontWeight.Bold }
        val cdSpan = result.spanStyles.firstOrNull { it.start == 2 && it.end == 4 }
        val defaultSpan = result.spanStyles.firstOrNull { it.start >= 3 && it.item.color == defaultColor }
        val dimSpan = result.spanStyles.firstOrNull { it.item.fontWeight == FontWeight.Light }
        val greenBg = result.spanStyles.firstOrNull { it.item.background == Color(0xFF00CC00) }
        val input = "$esc[101mtxt$esc[0m"
        val input = "$esc[1;31;4mAll$esc[0mPlain"
        val input = "$esc[1;31mBoldRed$esc[0m"
        val input = "$esc[1mAB$esc[31mCD$esc[0m"
        val input = "$esc[1mBold$esc[0m"
        val input = "$esc[1mBold$esc[22mNormal$esc[0m"
        val input = "$esc[1mBold$esc[mNormal"
        val input = "$esc[255mText$esc[0m"
        val input = "$esc[2mdim$esc[0m"
        val input = "$esc[31mRed$esc[0m"
        val input = "$esc[31mRed$esc[32mGreen$esc[34mBlue$esc[0m"
        val input = "$esc[31mRed$esc[39mDefault$esc[0m"
        val input = "$esc[38;5;196mX$esc[0m"
        val input = "$esc[38;5;1mX$esc[0m"
        val input = "$esc[38;5;232mX$esc[0m"
        val input = "$esc[3mItalic$esc[23mNormal$esc[0m"
        val input = "$esc[3mitalic$esc[0m"
        val input = "$esc[42mGreen$esc[0m"
        val input = "$esc[48;5;196mX$esc[0m"
        val input = "$esc[4;9mboth$esc[0m"
        val input = "$esc[4munder$esc[0m"
        val input = "$esc[91mBrightRed$esc[0m"
        val input = "$esc[9mstrike$esc[0m"
        val input = "A${esc}xB"
        val input = "Before$esc[2KAfter"
        val input = "Pre$esc]0;Title${esc}\\" + "Post"
        val input = "Pre$esc]0;Window Title$bel" + "Post"
        val input = "Text$esc["
        val input = "X$esc[10;20HY"
        val italicSpan = result.spanStyles.firstOrNull { it.item.fontStyle == FontStyle.Italic }
        val normalSpan = result.spanStyles.firstOrNull { it.start == 4 && it.end == 10 }
        val normalSpan = result.spanStyles.firstOrNull { it.start == 6 && it.end == 12 }
        val plainSpan = result.spanStyles.firstOrNull { it.start == 3 && it.end == 8 }
        val redSpan = result.spanStyles.firstOrNull { it.item.color == Color(0xFFCC0000) }
        val result = parseAnsiToAnnotatedString("", defaultColor)
        val result = parseAnsiToAnnotatedString("Hello", defaultColor)
        val result = parseAnsiToAnnotatedString("Hello, world!", defaultColor)
        val result = parseAnsiToAnnotatedString(input, defaultColor)
        val span = result.spanStyles.firstOrNull {
        val span = result.spanStyles.firstOrNull { it.item.background == Color(0xFFFF4444) }
        val span = result.spanStyles.firstOrNull { it.item.background == Color(255, 0, 0) }
        val span = result.spanStyles.firstOrNull { it.item.color == Color(0xFFCC0000) }
        val span = result.spanStyles.firstOrNull { it.item.color == Color(0xFFFF4444) }
        val span = result.spanStyles.firstOrNull { it.item.color == Color(255, 0, 0) }
        val span = result.spanStyles.firstOrNull { it.item.color == Color(8, 8, 8) }
        val span = result.spanStyles.firstOrNull { it.item.textDecoration == TextDecoration.LineThrough }
        val span = result.spanStyles.firstOrNull { it.item.textDecoration == TextDecoration.Underline }
        val style = result.spanStyles.firstOrNull()
        }
    // ---- 256-color mode ----
    // ---- Basic SGR codes ----
    // ---- Chained codes and state persistence ----
    // ---- Malformed / edge cases ----
    // ---- Non-SGR sequences ----
    // ---- Plain text passthrough ----
    // ---- Standard colors ----
    @Test
    fun `256 color background via 48 5 sets background`() {
    fun `256 color foreground in standard range maps to standard palette`() {
    fun `256 color foreground via 38 5 sets exact color`() {
    fun `256 color grayscale range maps to gray colors`() {
    fun `OSC sequence terminated with BEL is stripped`() {
    fun `OSC sequence terminated with ESC backslash is stripped`() {
    fun `bold style is applied`() {
    fun `bright background colors use bright palette`() {
    fun `bright foreground colors use bright palette`() {
    fun `chained codes apply both styles`() {
    fun `code 22 turns off bold`() {
    fun `code 23 turns off italic`() {
    fun `cursor movement CSI is stripped`() {
    fun `default foreground reset clears fg color`() {
    fun `dim style applies light weight`() {
    fun `empty SGR resets state`() {
    fun `empty string returns empty AnnotatedString`() {
    fun `incomplete CSI at end of string does not crash`() {
    fun `italic style is applied`() {
    fun `multiple text runs include each segment`() {
    fun `non-SGR CSI sequences are stripped`() {
    fun `plain text gets default color span`() {
    fun `plain text without escapes is returned unchanged`() {
    fun `reset clears all styles`() {
    fun `standard background green is applied`() {
    fun `standard foreground red is applied`() {
    fun `strikethrough applies linethrough decoration`() {
    fun `style persists across multiple text runs until reset`() {
    fun `underline and strikethrough combine into a single decoration`() {
    fun `underline applies underline decoration`() {
    fun `unknown SGR codes are ignored`() {
    fun `unknown escape after ESC is consumed`() {
    private val bel = '\u0007'
    private val defaultColor = Color(0xFF112233)
    private val esc = '\u001B'
    }
class AnsiParserTest {
}
