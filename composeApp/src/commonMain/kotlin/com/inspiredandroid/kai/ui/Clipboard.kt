import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import kotlinx.coroutines.launch

                clipboard.setClipEntry(clipEntryOfPlainText(text))
            scope.launch {
            }
        { text ->
        }
    return remember(clipboard, scope) {
    val clipboard = LocalClipboard.current
    val scope = rememberCoroutineScope()
    }
@Composable
internal expect fun clipEntryOfPlainText(text: String): ClipEntry
internal fun rememberCopyToClipboard(): (String) -> Unit {
package com.inspiredandroid.kai.ui
}
