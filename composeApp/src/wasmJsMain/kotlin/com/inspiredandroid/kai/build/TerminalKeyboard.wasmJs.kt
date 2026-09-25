
    modifier: Modifier,
    onKey: (TerminalKey, TerminalModifiers) -> Unit,
    onText: (String, TerminalModifiers) -> Unit,
    showKeyboardRequest: Int,
) = Unit
/** Kai Build is Android-only; there is no environment to type into here. */
@Composable
actual fun PlatformTerminalKeyboard(
actual val supportsRawTerminalInput: Boolean = false
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
package com.inspiredandroid.kai.build
