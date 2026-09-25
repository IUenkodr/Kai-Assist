
@OptIn(ExperimentalComposeUiApi::class)
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ClipEntry
internal actual fun clipEntryOfPlainText(text: String): ClipEntry = ClipEntry.withPlainText(text)
package com.inspiredandroid.kai.ui
