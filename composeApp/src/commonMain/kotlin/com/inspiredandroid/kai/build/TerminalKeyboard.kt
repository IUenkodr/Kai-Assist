import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers

    modifier: Modifier,
    onKey: (TerminalKey, TerminalModifiers) -> Unit,
    onText: (String, TerminalModifiers) -> Unit,
    showKeyboardRequest: Int,
 *
 * Invisible input sink for the terminal. It holds keyboard focus and reports
 * It is deliberately tiny rather than laid over the grid: anything covering the
 * Where it cannot, the screen stays on the line composer.
 * Whether this platform can deliver individual key presses to the terminal.
 * grid would hide the terminal contents from accessibility services. Taps are
 * handled by the grid itself and arrive here as [showKeyboardRequest], which
 * hardware reported — leaving the byte encoding to common code.
 * summons the soft keyboard whenever the value changes.
 * what the user pressed — a named key or committed text, plus any modifiers the
 */
)
/**
@Composable
expect fun PlatformTerminalKeyboard(
expect val supportsRawTerminalInput: Boolean
package com.inspiredandroid.kai.build
