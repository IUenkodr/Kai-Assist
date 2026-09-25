
                                if (event.changes.none { it.pressed }) break
                                style = monoStyle(13.sp),
                                style = monoStyle(13.sp, colors.prompt),
                                text = "$ ${line.text}",
                                text = parseAnsiToAnnotatedString(line.text, colors.error),
                                text = parseAnsiToAnnotatedString(line.text, colors.text),
                                val event = awaitPointerEvent()
                            )
                            // Can't use waitForUpOrCancellation(): it treats
                            // consumption as cancellation, and SelectionContainer's
                            // flip the flag back to false mid-drag. Loop on raw
                            // long-press drag observer consumes move events — we'd
                            // pointer events until no pointer is pressed.
                            Res.string.terminal_run_content_description
                            Res.string.terminal_stop_content_description
                            Spacer(Modifier.height(4.dp))
                            Text(
                            color = colors.prompt,
                            command = line.trim(),
                            isInteractingWithOutput.value = false
                            modifier = Modifier.size(14.dp),
                            outputLines = outputLines,
                            sandboxController = controller,
                            setHandle = { localActiveHandle = it },
                            setRunning = { localIsRunning = it },
                            shouldPrune = { !isInteractingWithOutput.value },
                            strokeWidth = 2.dp,
                            style = monoStyle(13.sp, colors.dimText),
                            text = stringResource(Res.string.terminal_help_text),
                            while (true) {
                            }
                        )
                        // own long-press detector. We never consume the change so
                        // requireUnconsumed=false: don't fight SelectionContainer's
                        // the inner gesture detectors still receive everything.
                        CircularProgressIndicator(
                        Spacer(Modifier.height(4.dp))
                        Text(
                        awaitFirstDown(requireUnconsumed = false)
                        canCancel -> cancelRunning()
                        canSubmit -> submitInput()
                        if (canCancel) {
                        is TerminalLine.Command -> {
                        is TerminalLine.Error -> {
                        is TerminalLine.Output -> {
                        isInteractingWithOutput.value = true
                        runCommand(
                        style = monoStyle(14.sp, colors.dimText),
                        text = stringResource(Res.string.terminal_input_placeholder),
                        try {
                        }
                        } else {
                        } finally {
                        },
                    )
                    ),
                    .background(colors.inputBg)
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                    .statusBarsPadding()
                    // The transcript is committed from a background thread (proot
                    // list's item count with the data. It also doesn't suspend,
                    // measure time — clamping alone can't close that window.
                    // requestScrollToItem (unlike scrollToItem) doesn't force a
                    // so heavy bursts no longer queue blocking scrolls.
                    // stdio reader), so any index computed here can be stale by
                    // synchronous remeasure with the raw index pinned; it defers
                    // to the next frame, after composition has re-synced the
                    Text(
                    awaitEachGesture {
                    contentDescription = stringResource(
                    contentType = { it::class },
                    cursorColor = colors.prompt,
                    disabledContainerColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    if (sandboxController != null) Modifier.focusRequester(focusRequester) else Modifier,
                    imageVector = if (canCancel) Icons.Filled.Stop else Icons.AutoMirrored.Filled.Send,
                    item {
                    items = outputLines,
                    listState.requestScrollToItem(minOf(size, total) - 1)
                    modifier = Modifier.size(20.dp),
                    onGo = { submitInput() },
                    outputLines.add(TerminalLine.Output(line))
                    scope.launch {
                    scope.launch { handle.writeInput(line) }
                    style = monoStyle(12.sp, colors.text.copy(alpha = 0.5f)),
                    style = monoStyle(16.sp, colors.prompt),
                    text = distroName,
                    text = stringResource(Res.string.terminal_title),
                    tint = if (canSubmit || canCancel) colors.prompt else colors.dimText,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    when (line) {
                    when {
                    }
                )
                ) { line ->
                ),
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
                .pointerInput(Unit) {
                .weight(1f)
                // Don't yank the user back if they've scrolled up to read older output.
                // While the user is dragging to select, scrolling to the tail
                // crashing SelectionManager mid-drag.
                // disposes off-screen Texts and unregisters their selectables,
                Icon(
                Spacer(Modifier.weight(1f))
                Text(
                batch.add(result.getOrThrow())
                break
                channel.close()
                colors = TextFieldDefaults.colors(
                command = command,
                drainJob.join()
                enabled = canSubmit || canCancel,
                enabled = isInputEnabled,
                h.awaitExit()
                if (isInteractingWithOutput.value) return@collect
                if (isRunning) {
                if (lastVisible >= total - 2) {
                if (outputLines.isEmpty()) {
                if (result.isClosed) closed = true
                if (running && handle != null) {
                if (size == 0) return@collect
                if (total == 0) return@collect
                items(
                keyboardActions = KeyboardActions(
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
                localInputText = ""
                modifier = Modifier
                modifier = Modifier.handCursor(),
                modifier = Modifier.padding(start = 8.dp),
                modifier = Modifier.weight(1f).then(
                onClick = {
                onStderr = { line -> channel.trySend(TerminalLine.Error(line)) },
                onStdout = { line -> channel.trySend(TerminalLine.Output(line)) },
                onValueChange = setInputText,
                placeholder = {
                sessionId = SandboxSessions.TERMINAL,
                singleLine = true,
                state = listState,
                style = monoStyle(14.sp, colors.prompt),
                text = "$",
                textStyle = monoStyle(14.sp, colors.text),
                val lastVisible = layout.visibleItemsInfo.lastOrNull()?.index ?: -1
                val layout = listState.layoutInfo
                val line = localInputText
                val total = layout.totalItemsCount
                value = inputText,
                verticalAlignment = Alignment.CenterVertically,
                }
                } else if (!running) {
                },
            )
            ) {
            .imePadding(),
            .then(if (showHeader) Modifier.background(colors.bg) else Modifier)
            IconButton(
            LazyColumn(
            Row(
            Spacer(Modifier.width(8.dp))
            Text(
            TextField(
            bg = TerminalDarkBg,
            color = colors.dimText.copy(alpha = 0.2f),
            dimText = Color(0xFF666666),
            error = Color(0xFFF48771),
            focusRequester.requestFocus()
            handle = h
            if (controller != null && localInputText.isNotBlank()) {
            if (excess > 0) outputLines.subList(0, excess).clear()
            if (result.isSuccess) {
            if (shouldPrune()) pruneOutput(outputLines)
            inputBg = Color(0xFF252525),
            localActiveHandle?.cancel()
            modifier = Modifier
            outputLines.add(TerminalLine.Output("^C"))
            outputLines.addAll(batch)
            prompt = Color(0xFF6CB6FF),
            sandboxController.setTranscriptInteractive(sid, isInteractingWithOutput.value)
            sessionViewModel.cancelRunning()
            sessionViewModel.submit()
            setHandle(h)
            snapshotFlow { outputLines.size }.conflate().collect { size ->
            text = Color(0xFFD4D4D4),
            try {
            val controller = sandboxController
            val drainJob = launch { drainStreamedLines(channel, outputLines, shouldPrune) }
            val excess = outputLines.size - MAX_OUTPUT_LINES
            val h = sandboxController.executeCommandStreaming(
            val handle = localActiveHandle
            val result = channel.tryReceive()
            val running = localIsRunning
            verticalAlignment = Alignment.CenterVertically,
            }
            } else {
            } finally {
        )
        ) {
        // Re-key the auto-scroll on outputLines so switching sessions detaches
        // from the previous session's list and starts following the new one.
        ?: LinuxDistro.DEFAULT.displayName
        @Suppress("UNUSED_EXPRESSION")
        LaunchedEffect(listState, isRunning, outputLines) {
        Row(
        SelectionContainer(
        androidx.compose.material3.HorizontalDivider(
        bg = colorScheme.background,
        capacity = STREAM_BUFFER_CAPACITY,
        coroutineScope {
        delay(STREAM_FLUSH_INTERVAL_MS.milliseconds)
        dimText = colorScheme.onBackground.copy(alpha = 0.4f),
        error = colorScheme.error,
        if (!isInteractingWithOutput.value && sessionViewModel == null) {
        if (batch.isNotEmpty()) {
        if (closed) break
        if (handle?.isCancelled() == true) {
        if (sandboxController != null && sid != null) {
        if (sandboxController != null) {
        if (sessionViewModel != null) {
        if (shouldPrune()) pruneOutput(outputLines)
        if (showHeader) {
        if (size > 0) listState.requestScrollToItem(size - 1)
        inputBg = colorScheme.surfaceContainer,
        modifier = modifier
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        outputLines.add(TerminalLine.Error(e.message ?: getString(Res.string.terminal_command_failed)))
        outputLines.clear()
        outputLines.subList(0, excess).clear()
        prompt = colorScheme.primary,
        remember { mutableStateListOf<TerminalLine>().apply { addAll(initialLines) } }
        return
        return TerminalColors(
        selectedSessionId
        sessionViewModel.outputLines
        setHandle(null)
        setRunning(false)
        text = colorScheme.onBackground,
        throw e
        val batch = ArrayList<TerminalLine>(STREAM_FLUSH_BATCH_MAX)
        val sid = selectedSessionId
        val size = outputLines.size
        var closed = false
        while (batch.size < STREAM_FLUSH_BATCH_MAX) {
        { vm.setInputText(it) }
        }
        } else {
    )
    ) {
    // "Alpine Linux" unconditionally.
    // ("NoSuchElementException: Cannot find value for key …" inside
    // Appends to the end are safe because they don't invalidate existing ids.
    // Buffered channel with DROP_OLDEST so a runaway producer (e.g. `yes`)
    // Jump to the tail whenever the session changes. The size-based auto-scroll
    // Mirror the touch flag onto the session shell so streaming-side
    // Reading selectedSessionId here — even though we don't use the value
    // Which Linux the user is actually typing into — the header used to say
    // While the user is touching the output area we pause two things that
    // below covers per-append scrolling — keying this effect on outputLines too
    // bounded-trim pauses too (the rendered list IS the shell's transcript in
    // can't starve the UI or grow memory without bound. The drain loop
    // change inputText/isRunning/activeHandle, so Compose wouldn't re-evaluate
    // different chip. Without it, switching between two idle sessions doesn't
    // directly — forces this composable to recompose when the user picks a
    // flushes on a fixed cadence and prunes to MAX_OUTPUT_LINES each tick.
    // getSelectionLayout's LongIntMap): bounded-trim pruning and the
    // non-session list since drainStreamedLines's prune was suppressed.
    // scroll-to-tail effect (off-screen items get disposed by LazyColumn).
    // session mode). On release, run a catch-up prune for the local
    // session's transcript.
    // the outputLines property getter and we'd keep rendering the previous
    // would otherwise unregister selectables mid-drag and crash SelectionManager
    // would re-fire on every line and thrash listState during heavy bursts.
    Column(
    LaunchedEffect(Unit) {
    LaunchedEffect(isInteractingWithOutput.value, selectedSessionId, sandboxController) {
    LaunchedEffect(scrollPulse) {
    channel: Channel<TerminalLine>,
    color = color,
    command: String,
    darkBackground: Boolean = false,
    fontFamily = FontFamily.Monospace,
    fontSize = size,
    if (command == "clear") {
    if (darkBackground) {
    if (excess > 0) {
    initialLines: ImmutableList<TerminalLine> = persistentListOf(),
    modifier: Modifier = Modifier,
    outputLines.add(TerminalLine.Command(command))
    outputLines: MutableList<TerminalLine>,
    return TerminalColors(
    sandboxController: SandboxController,
    sandboxController: SandboxController?,
    sessionViewModel: SandboxSessionViewModel? = null,
    setHandle: (CommandHandle?) -> Unit,
    setRunning(true)
    setRunning: (Boolean) -> Unit,
    shouldPrune: () -> Boolean = { true },
    showHeader: Boolean = false,
    try {
    val activeHandle: CommandHandle? = sessionActiveHandle ?: localActiveHandle
    val bg: Color,
    val canCancel = isRunning && activeHandle != null && inputText.isBlank()
    val canSubmit = sandboxController != null && inputText.isNotBlank()
    val cancelRunning: () -> Unit = {
    val channel = Channel<TerminalLine>(
    val colorScheme = MaterialTheme.colorScheme
    val colors = terminalColors(darkBackground)
    val dimText: Color,
    val distroName = sandboxController?.status?.collectAsStateWithLifecycle()?.value?.distro?.displayName
    val error: Color,
    val excess = outputLines.size - MAX_OUTPUT_LINES
    val focusRequester = remember { FocusRequester() }
    val inputBg: Color,
    val inputText: String = sessionInputText ?: localInputText
    val isInputEnabled = sandboxController != null
    val isInteractingWithOutput = remember { mutableStateOf(false) }
    val isRunning: Boolean = sessionIsRunning ?: localIsRunning
    val listState = rememberLazyListState()
    val outputLines = if (sessionViewModel != null) {
    val prompt: Color,
    val scope = rememberCoroutineScope()
    val scrollPulse = sessionViewModel?.scrollToEndPulse?.collectAsStateWithLifecycle()?.value
    val selectedSessionId = sessionViewModel?.selectedSessionId?.collectAsStateWithLifecycle()?.value
    val sessionActiveHandle = sessionViewModel?.activeHandle?.collectAsStateWithLifecycle()?.value
    val sessionInputText = sessionViewModel?.inputText?.collectAsStateWithLifecycle()?.value
    val sessionIsRunning = sessionViewModel?.isRunning?.collectAsStateWithLifecycle()?.value
    val setInputText: (String) -> Unit = sessionViewModel?.let { vm ->
    val submitInput = {
    val text: Color,
    var handle: CommandHandle? = null
    var localActiveHandle by remember { mutableStateOf<CommandHandle?>(null) }
    var localInputText by remember { mutableStateOf("") }
    var localIsRunning by remember { mutableStateOf(false) }
    while (true) {
    }
    } ?: { localInputText = it }
    } catch (e: CancellationException) {
    } catch (e: Exception) {
    } else {
    } finally {
)
) {
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
fun TerminalContent(
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.CommandHandle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxSessions
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.sandbox.SandboxSessionViewModel
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.terminal_command_failed
import kai.composeapp.generated.resources.terminal_help_text
import kai.composeapp.generated.resources.terminal_input_placeholder
import kai.composeapp.generated.resources.terminal_run_content_description
import kai.composeapp.generated.resources.terminal_stop_content_description
import kai.composeapp.generated.resources.terminal_title
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
internal data class TerminalColors(
internal fun monoStyle(size: TextUnit, color: Color = Color.Unspecified) = TextStyle(
internal fun terminalColors(darkBackground: Boolean = false): TerminalColors {
internal val TerminalDarkBg = Color(0xFF1E1E1E)
package com.inspiredandroid.kai.ui.settings
private const val MAX_OUTPUT_LINES = 500
private const val STREAM_BUFFER_CAPACITY = 256
private const val STREAM_FLUSH_BATCH_MAX = 200
private const val STREAM_FLUSH_INTERVAL_MS = 32L
private fun pruneOutput(outputLines: MutableList<TerminalLine>) {
private suspend fun drainStreamedLines(
private suspend fun runCommand(
}
