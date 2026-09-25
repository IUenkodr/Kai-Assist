
            input.onKey = onKey
            input.onText = onText
        factory = { context -> TerminalInputView(context).also { view = it } },
        if (showKeyboardRequest > 0) view?.showKeyboard()
        modifier = modifier,
        onRelease = { view = null },
        update = { input ->
        },
    )
    AndroidView(
    LaunchedEffect(showKeyboardRequest, view) {
    modifier: Modifier,
    onKey: (TerminalKey, TerminalModifiers) -> Unit,
    onText: (String, TerminalModifiers) -> Unit,
    showKeyboardRequest: Int,
    var view by remember { mutableStateOf<TerminalInputView?>(null) }
    }
) {
@Composable
actual fun PlatformTerminalKeyboard(
actual val supportsRawTerminalInput: Boolean = true
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
package com.inspiredandroid.kai.build
}
