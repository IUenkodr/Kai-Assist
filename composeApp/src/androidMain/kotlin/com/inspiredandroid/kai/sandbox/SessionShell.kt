import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.inspiredandroid.kai.TerminalLine

                    appendBounded(TerminalLine.Error(line))
                    appendBounded(TerminalLine.Output(line))
                    onStderr?.invoke(line)
                    onStdout?.invoke(line)
                command = command,
                if (excess > 0) transcript.subList(0, excess).clear()
                onStderr = { line ->
                onStdout = { line ->
                timeoutSeconds = timeoutSeconds,
                val excess = transcript.size - MAX_TRANSCRIPT_LINES
                },
            )
            Snapshot.withMutableSnapshot {
            if (!prunePaused) {
            onChange?.invoke(transcript.toList())
            return inner.run(
            transcript.add(line)
            }
        // Add+trim must commit as a single snapshot. Otherwise a LazyColumn
        // measure pass can capture size=N+1 then read index N after the trim
        // shrunk the list — IndexOutOfBoundsException under heavy bursts.
        Snapshot.withMutableSnapshot {
        addAll(initialLines)
        appendBounded(TerminalLine.Command(displayCommand))
        command: String,
        displayCommand: String = command,
        if (wasPaused && !value) {
        onStderr: ((String) -> Unit)? = null,
        onStdout: ((String) -> Unit)? = null,
        prunePaused = value
        timeoutSeconds: Long,
        try {
        val wasPaused = prunePaused
        }
        } finally {
     *
     *   actually asked for, not the plumbing.
     *   callers that wrap a user command (e.g. with `cd /workdir && env=foo`)
     *   should pass the original unwrapped form so the user sees what they
     * @param displayCommand what to show in the transcript. Defaults to [command];
     * Run a single command in the persistent shell.
     * SelectionManager from crashing on a selectable id whose Text was
     * While paused, [appendBounded] still adds new lines but skips the
     * bounded once the gesture ends.
     * bounded-trim. Pausing during a drag-select prevents
     * pruned mid-drag. Unpause runs a catch-up trim so memory stays
     */
    ): Map<String, Any> {
    /**
    @Volatile
    fun cancelForeground() = inner.cancelForeground()
    fun reset() = inner.reset()
    fun setPrunePaused(value: Boolean) {
    fun writeInput(line: String) = inner.writeInput(line)
    initialLines: List<TerminalLine> = emptyList(),
    private fun appendBounded(line: TerminalLine) {
    private val inner: PersistentSandboxShell,
    private val onChange: ((List<TerminalLine>) -> Unit)? = null,
    private var prunePaused: Boolean = false
    suspend fun run(
    val sessionId: String,
    val transcript: SnapshotStateList<TerminalLine> = mutableStateListOf<TerminalLine>().apply {
    }
 * Per-session facade over [PersistentSandboxShell]. Same surface as the inner
 * command runs — populated regardless of *which* path called the shell (chat
 * directly so the agent's commands are visible alongside the user's.
 * shell, plus a [transcript] that captures the command and its output as the
 * tool, terminal UI, package manager UI). The Terminal tab observes this list
 */
) {
/**
class SessionShell(
package com.inspiredandroid.kai.sandbox
private const val MAX_TRANSCRIPT_LINES = 500
}
