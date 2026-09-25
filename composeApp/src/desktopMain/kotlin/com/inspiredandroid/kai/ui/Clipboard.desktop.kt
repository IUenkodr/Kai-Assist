
@OptIn(ExperimentalComposeUiApi::class)
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ClipEntry
import java.awt.datatransfer.StringSelection
internal actual fun clipEntryOfPlainText(text: String): ClipEntry = ClipEntry(StringSelection(text))
package com.inspiredandroid.kai.ui
