
                                                Res.string.kai_build_terminal_placeholder
                                                Res.string.kai_build_terminal_running
                                            cell = cell,
                                            detectTapGestures { showKeyboardRequest++ }
                                            if (busy) {
                                            onMouse = onMouse,
                                            snapshot = terminal,
                                            } else {
                                            },
                                        )
                                        ),
                                        Res.string.kai_build_terminal_run_content_description,
                                        Res.string.kai_build_terminal_show_keyboard_content_description,
                                        else -> Modifier
                                        keyboardActive -> Modifier.pointerInput(Unit) {
                                        mouseActive -> terminalMouseInput(
                                        style = monoStyle(14.sp, AnsiPalette[8]),
                                        text = stringResource(
                                        }
                                    )
                                    ),
                                    Text(
                                    contentDescription = stringResource(
                                    cursorColor = AnsiPalette[10],
                                    disabledContainerColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    focusedTextColor = AnsiPalette[7],
                                    imageVector = Icons.AutoMirrored.Filled.Send,
                                    imageVector = Icons.Default.Keyboard,
                                    tint = AnsiPalette[10],
                                    tint = AnsiPalette[7],
                                    unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    unfocusedTextColor = AnsiPalette[7],
                                    when {
                                    },
                                )
                                ),
                                .fillMaxSize()
                                .then(
                                Icon(
                                colors = TextFieldDefaults.colors(
                                enabled = busy,
                                if (focusInputRequest > 0 && !inspecting) inputFocus.requestFocus()
                                keyboardActions = KeyboardActions(onGo = { submit() }),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
                                maxLines = 1,
                                modifier = Modifier.handCursor(),
                                modifier = Modifier.size(1.dp),
                                modifier = Modifier.weight(1f),
                                modifier = Modifier.weight(1f).focusRequester(inputFocus),
                                onClick = { showKeyboardRequest++ },
                                onKey = { key, reported -> onKey(key, consumeLatch(reported)) },
                                onText = { text, reported -> onText(text, consumeLatch(reported)) },
                                onValueChange = { input = it },
                                overflow = TextOverflow.Ellipsis,
                                placeholder = {
                                showKeyboardRequest = showKeyboardRequest,
                                singleLine = true,
                                style = monoStyle(13.sp, AnsiPalette[8]),
                                text = stringResource(Res.string.kai_build_terminal_raw_hint),
                                textStyle = monoStyle(14.sp, AnsiPalette[7]),
                                value = input,
                                },
                            )
                            ) {
                            .background(Color(0xFF1A1A1A))
                            .fillMaxWidth()
                            .padding(horizontal = 6.dp, vertical = 4.dp),
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                            .weight(1f)
                            // Guarded: a focus request that raises the IME crashes
                            // the screenshot renderer, which has no IME to raise.
                            IconButton(
                            IconButton(onClick = submit, modifier = Modifier.handCursor()) {
                            LaunchedEffect(focusInputRequest) {
                            PlatformTerminalKeyboard(
                            Text(
                            TextField(
                            if (!rawInput && imeVisible) focusInputRequest++
                            if (settled.value) delay(RESIZE_SETTLE_MS)
                            modifier = Modifier
                            modifier = Modifier.padding(start = 8.dp),
                            onResize(cols, rows)
                            rawInput = !rawInput
                            runCatching { uriHandler.openUri(url) }
                            settled.value = true
                            snapshot = terminal,
                            style = monoStyle(14.sp, AnsiPalette[10]),
                            terminalCellMetrics(textMeasurer)
                            text = if (busy) "›" else "$",
                            val inspecting = LocalInspectionMode.current
                            }
                        )
                        .clickable {
                        .fillMaxWidth()
                        .handCursor()
                        // An app that asked for mouse reports owns the taps: a
                        // Keyed on the session too: a new tab starts at the default
                        // The first pass for a tab reports straight away — the shell is
                        // geometry and needs this pass even when the viewport didn't move.
                        // input bar stays the way to raise the IME.
                        // moment that the PTY and the agent are launched with. Later
                        // passes wait out the keyboard and rotation animations, which
                        // request for the keyboard. The keyboard button in the
                        // starting right then, and it is the geometry in hand at that
                        // tap is a click on the cell under the finger, not a
                        // walk through sizes nobody should be resized to.
                        ?.let { send.value(it) }
                        LaunchedEffect(cols, rows, session.id) {
                        Spacer(Modifier.width(8.dp))
                        TerminalGrid(
                        TerminalHyperlinkBar(urls = terminal.hyperlinks)
                        Text(
                        if (busy && !rawInput) {
                        if (keyboardActive) {
                        if (rawInput) {
                        modifier = Modifier
                        null
                        val cell = remember(textMeasurer, LocalDensity.current) {
                        val cols = (maxW / cell.advance).toInt().coerceAtLeast(MIN_COLUMNS)
                        val keyboardActive = rawInput && busy
                        val maxH = constraints.maxHeight
                        val maxW = constraints.maxWidth
                        val mouseActive = terminal.mouse.enabled && busy
                        val rows = cell.rowsIn(maxH).coerceAtLeast(MIN_ROWS)
                        val settled = remember(session.id) { mutableStateOf(false) }
                        val textMeasurer = rememberTextMeasurer()
                        verticalAlignment = Alignment.CenterVertically,
                        {
                        }
                        } else {
                        },
                    ) {
                    // OSC 8 hyperlinks (Grok login puts the URL here, not as visible cells).
                    ?.let { send.value(it) }
                    BoxWithConstraints(
                    Row(
                    TerminalMouseEncoder.wheel(up = false, col = col, row = row, state = state)
                    TerminalMouseEncoder.wheel(up = true, col = col, row = row, state = state)
                    enabled = busy,
                    if (terminal.hyperlinks.isNotEmpty()) {
                    latched = latched,
                    maxLines = 4,
                    modifier = Modifier
                    onKey = { key -> onKey(key, consumeLatch(TerminalModifiers.None)) },
                    onLatchChange = { latched = it },
                    onToggleInputMode = if (supportsRawTerminalInput) {
                    overflow = TextOverflow.Ellipsis,
                    pendingScroll += cell.lineStep
                    pendingScroll -= cell.lineStep
                    rawInput = rawInput,
                    scrolled = true
                    style = monoStyle(12.sp, AnsiPalette[14]),
                    text = url,
                    }
                    } else {
                    },
                )
                .coerceIn(0, (current.value.columns - 1).coerceAtLeast(0))
                .coerceIn(0, (current.value.rows - 1).coerceAtLeast(0))
                Column(modifier = Modifier.weight(1f).fillMaxWidth()) {
                HorizontalDivider(color = Color.White.copy(alpha = 0.12f))
                TerminalKeyRow(
                TerminalMouseEncoder.click(col = col, row = row, state = state)
                Text(
                col == snapshot.cursorCol &&
                flushRun()
                if (!change.pressed) break
                if (!hideInputBar) {
                pendingScroll += delta.y
                position = change.position
                row == snapshot.cursorRow
                travelled += delta.getDistance()
                val change = event.changes.firstOrNull { it.id == down.id } ?: break
                val delta = change.position - position
                val event = awaitPointerEvent()
                while (pendingScroll <= -cell.lineStep) {
                while (pendingScroll >= cell.lineStep) {
                }
            .background(Color(0xFF141414))
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
            // Carriage return, not line feed: apps in raw mode read the byte
            // Cells the shell never wrote hold NUL; they render as blanks.
            // The cursor inverts its own cell, so it always breaks the run.
            // directly and only CR counts as Enter.
            Color.Unspecified
            Column {
            SelectionContainer {
            bg
            color = AnsiPalette[7],
            color = bg,
            fg
            fontFamily = FontFamily.Monospace,
            fontSize = TerminalFontSize,
            if (!scrolled && travelled <= viewConfiguration.touchSlop) {
            if (fg != runFg || bg != runBg || cell.bold != runBold || isCursor != runCursor) {
            input = ""
            lineHeight = TerminalLineHeight,
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp).weight(1f),
            onSubmitLine(line + "\r")
            run.append(if (cell.char == Char.MIN_VALUE) ' ' else cell.char)
            runBg = bg
            runBold = cell.bold
            runCursor = isCursor
            runFg = fg
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 2.dp,
            val bg = cell.bg.coerceIn(0, 15)
            val cell = snapshot.cellAt(col, row)
            val col = cell.columnAt(down.position.x)
            val down = awaitFirstDown(requireUnconsumed = false)
            val fg = cell.fg.coerceIn(0, 15)
            val isCursor = snapshot.cursorVisible &&
            val row = cell.rowAt(down.position.y)
            val state = current.value.mouse
            var pendingScroll = 0f
            var position = down.position
            var scrolled = false
            var travelled = 0f
            while (true) {
            }
        ) {
        ),
        // Nothing to raise until the shell is live and keys go straight to it.
        Surface(
        advance = (run.size.width / ADVANCE_SAMPLE.toFloat()).coerceAtLeast(1f),
        awaitEachGesture {
        background = if (isCursor) {
        buildTerminalText(snapshot)
        color = if (isCursor) bg else fg,
        delay(HYPERLINK_DISPLAY_MS)
        dismissed = false
        dismissed = true
        firstLine = oneLine.size.height.coerceAtLeast(1),
        flushRun()
        fontFamily = FontFamily.Monospace,
        fontSize = TerminalFontSize,
        fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
        for (col in 0 until snapshot.columns) {
        if (busy && rawInput && keyboardRaisedFor.add(session.id)) showKeyboardRequest++
        if (line.isNotEmpty() || busy) {
        if (row < snapshot.rows - 1) append('\n')
        if (run.isEmpty()) return
        latched = TerminalModifiers.None
        letterSpacing = 0.sp,
        lineHeight = TerminalLineHeight,
        lineStep = (twoLines.size.height - oneLine.size.height).coerceAtLeast(1),
        maxLines = snapshot.rows.coerceAtLeast(1),
        merged
        modifier = Modifier
        modifier = modifier,
        run.setLength(0)
        softWrap = false,
        style = TextStyle(
        text = annotated,
        urls.forEach { url ->
        val line = input
        val merged = latched + reported
        verticalArrangement = Arrangement.spacedBy(6.dp),
        withStyle(cellSpanStyle(runFg, runBg, runBold, runCursor)) { append(run.toString()) }
        }
        } else if (bgIndex == 0) {
        } else {
        },
    )
    ) {
    /** Column under [x] pixels from the left edge of the grid. */
    /** Row under [y] pixels from the top of the grid. */
    /** Whole rows that fit in [height] pixels. */
    // A latch stands for one press, wherever that press came from.
    // A tab is opened to be typed into, so its first appearance raises the
    // Each tab keeps its own draft line.
    // Full-bleed sideways: the cell grid keeps its own inset, so an outer margin
    // IME bottom inset is multiplatform; WindowInsets.isImeVisible is Android-only.
    // Keyboard mode has nothing to type into here — the grid is the surface — so
    // Keys straight to the PTY is the default where the platform can do it —
    // Switching to line mode while the keyboard is up hands the caret to the
    // The snapshot changes on every repaint; reading it through these holders
    // field, so a half-typed thought carries on instead of needing a tap.
    // keeps a burst of output from restarting the gesture loop mid-touch.
    // keeps the mode toggle reachable either way.
    // keyboard is up to give the cell grid that extra row; the key row above
    // keyboard without waiting for a tap. Only the first: switching back to a
    // only cost columns.
    // tab later is often to read what an agent wrote, not to type at it.
    // that is the only way a TUI reacts while the user is still typing.
    // the bar is only chrome (hint, show-keyboard). Hide it while the soft
    BasicText(
    Color(0xFF0037DA),
    Color(0xFF0C0C0C),
    Color(0xFF13A10E),
    Color(0xFF16C60C),
    Color(0xFF3A96DD),
    Color(0xFF3B78FF),
    Color(0xFF61D6D6),
    Color(0xFF767676),
    Color(0xFF881798),
    Color(0xFFB4009E),
    Color(0xFFC19C00),
    Color(0xFFC50F1F),
    Color(0xFFCCCCCC),
    Color(0xFFE74856),
    Color(0xFFF2F2F2),
    Color(0xFFF9F1A5),
    Column(
    Column(modifier = modifier.fillMaxSize().imePadding()) {
    LaunchedEffect(session.id, busy, rawInput) {
    LaunchedEffect(urls) {
    cell: TerminalCellMetrics,
    for (row in 0 until snapshot.rows) {
    fun columnAt(x: Float): Int = (x / advance).toInt()
    fun flushRun() {
    fun rowAt(y: Float): Int = if (y < firstLine) 0 else 1 + ((y - firstLine) / lineStep).toInt()
    fun rowsIn(height: Int): Int = if (height < firstLine) 0 else 1 + (height - firstLine) / lineStep
    if (dismissed || urls.isEmpty()) return
    modifier: Modifier = Modifier,
    onKey: (TerminalKey, TerminalModifiers) -> Unit,
    onMouse: (String) -> Unit,
    onResize: (columns: Int, rows: Int) -> Unit,
    onSubmitLine: (String) -> Unit,
    onText: (String, TerminalModifiers) -> Unit,
    return Modifier.pointerInput(cell) {
    return SpanStyle(
    return TerminalCellMetrics(
    session: BuildTerminalSession,
    snapshot: TerminalSnapshot,
    val advance: Float,
    val annotated = remember(revision, snapshot.columns, snapshot.rows) {
    val bg = AnsiPalette.getOrElse(bgIndex) { AnsiPalette[0] }
    val bg = AnsiPalette[0]
    val busy = session.busy
    val consumeLatch: (TerminalModifiers) -> TerminalModifiers = { reported ->
    val current = rememberUpdatedState(snapshot)
    val fg = AnsiPalette.getOrElse(fgIndex) { AnsiPalette[7] }
    val firstLine: Int,
    val hideInputBar = rawInput && imeVisible
    val imeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    val inputFocus = remember { FocusRequester() }
    val keyboardRaisedFor = remember { mutableSetOf<String>() }
    val lineStep: Int,
    val oneLine = measurer.measure("M", style = style)
    val revision = snapshot.revision
    val run = StringBuilder(snapshot.columns.coerceAtLeast(1))
    val run = measurer.measure("M".repeat(ADVANCE_SAMPLE), style = style, softWrap = false)
    val send = rememberUpdatedState(onMouse)
    val style = TextStyle(
    val submit = {
    val terminal = session.terminal
    val twoLines = measurer.measure("M\nM", style = style)
    val uriHandler = LocalUriHandler.current
    var dismissed by remember { mutableStateOf(false) }
    var focusInputRequest by remember { mutableIntStateOf(0) }
    var input by remember(session.id) { mutableStateOf("") }
    var latched by remember { mutableStateOf(TerminalModifiers.None) }
    var rawInput by remember { mutableStateOf(supportsRawTerminalInput) }
    var runBg = -1
    var runBold = false
    var runCursor = false
    var runFg = -1
    var showKeyboardRequest by remember { mutableIntStateOf(0) }
    }
 *
 * (desktop-style resize) plus its input bar. Session switching and launching
 * A tap that stays put is a left click on the cell under the finger. A vertical
 * Auto-hides after [HYPERLINK_DISPLAY_MS] so login links do not stick around
 * Flattens the cell grid into the string the terminal draws.
 * Measured rather than derived from the style, because both roundings run the
 * One span per *run* of identically styled cells, not one per cell. A span per
 * One terminal cell in pixels, as the grid actually draws it.
 * Project workspace: the active session's VT cell grid sized to the viewport
 * Reports touches on the cell grid to an app that asked for mouse events.
 * Shows URLs that TUIs only embed as OSC 8 hyperlinks (invisible on the cell grid).
 * Style for one cell. [fgIndex]/[bgIndex] are already clamped palette indices;
 * Tap opens in the system browser; text is selectable for long-press copy.
 * The raw pointer loop is needed to measure that drag; the higher-level tap and
 * [firstLine] is the height of one line and [lineStep] what each further line
 * a zero background means "no background" so the surface shows through.
 * adds. The two differ on fonts whose natural height exceeds the requested line
 * agents live in the bar above, so the grid gets the whole screen.
 * cell puts a style transition on every character, so paragraph layout cost
 * device already behaves. Sideways movement is ignored: a TUI has nothing to
 * dividing the viewport by it drops a column the row could have held; a line
 * drag detectors cannot answer both questions from one gesture. Changes are
 * drag is the scroll wheel — one notch per cell row crossed, in the direction
 * forever once the user has signed in (or dismissed the flow). A new URL set
 * handful of times per row, so runs collapse that to roughly one span per row.
 * height, so rows are counted with both rather than by plain division.
 * many — the shell then paints a last line that hangs half outside the viewport.
 * never consumed, so the grid keeps its own semantics.
 * occupies a fractional number of pixels, and truncating that buys a row too
 * restarts the timer.
 * scales with the cell count — at a viewport-sized grid that is tens of
 * scroll sideways, and treating it as drag would only make taps harder to land.
 * that makes the content follow the finger, which is how every list on the
 * thousands of spans rebuilt on every PTY revision. Real screens change style a
 * wrong way. A single glyph reports a width rounded up to whole pixels, so
 */
)
) {
): Modifier {
/**
/** Characters measured in one run, to average out whole-pixel rounding. */
/** Classic 16-color ANSI palette (dark terminal). */
/** How long a viewport change has to hold still before the PTY hears about it. */
/** How long login / OSC 8 links stay under the grid before the bar goes away. */
@Composable
@OptIn(ExperimentalLayoutApi::class)
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inspiredandroid.kai.build.BuildTerminalSession
import com.inspiredandroid.kai.build.PlatformTerminalKeyboard
import com.inspiredandroid.kai.build.supportsRawTerminalInput
import com.inspiredandroid.kai.build.terminal.MIN_COLUMNS
import com.inspiredandroid.kai.build.terminal.MIN_ROWS
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
import com.inspiredandroid.kai.build.terminal.TerminalMouseEncoder
import com.inspiredandroid.kai.build.terminal.TerminalSnapshot
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.settings.monoStyle
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_terminal_placeholder
import kai.composeapp.generated.resources.kai_build_terminal_raw_hint
import kai.composeapp.generated.resources.kai_build_terminal_run_content_description
import kai.composeapp.generated.resources.kai_build_terminal_running
import kai.composeapp.generated.resources.kai_build_terminal_show_keyboard_content_description
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource
internal data class TerminalCellMetrics(
internal fun BuildTerminalContent(
internal fun buildTerminalText(snapshot: TerminalSnapshot): AnnotatedString = buildAnnotatedString {
internal val AnsiPalette = listOf(
package com.inspiredandroid.kai.ui.build
private const val ADVANCE_SAMPLE = 64
private const val HYPERLINK_DISPLAY_MS = 2 * 60 * 1000L
private const val RESIZE_SETTLE_MS = 80L
private fun TerminalGrid(
private fun TerminalHyperlinkBar(urls: ImmutableList<String>) {
private fun cellSpanStyle(fgIndex: Int, bgIndex: Int, bold: Boolean, isCursor: Boolean): SpanStyle {
private fun terminalCellMetrics(measurer: TextMeasurer): TerminalCellMetrics {
private fun terminalMouseInput(
private val TerminalFontSize = 11.sp
private val TerminalLineHeight = 13.sp
}
