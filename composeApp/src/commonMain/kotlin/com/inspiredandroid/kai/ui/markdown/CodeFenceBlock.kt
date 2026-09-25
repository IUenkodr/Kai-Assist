
                        contentDescription = stringResource(Res.string.bot_message_copy_content_description),
                        imageVector = Icons.Filled.ContentCopy,
                        modifier = Modifier.size(16.dp),
                    )
                    Icon(
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.size(32.dp),
                    onClick = { copyToClipboard(code) },
                    style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.labelSmall,
                    text = highlighted,
                    text = language?.takeIf { it.isNotBlank() } ?: "",
                )
                ) {
                IconButton(
                Text(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                }
            ) {
            Box(Modifier.horizontalScroll(scroll).padding(12.dp)) {
            HorizontalDivider(color = colorScheme.outline.copy(alpha = 0.2f))
            Row(
            val scroll = rememberScrollState()
            }
        Column {
        color = colorScheme.surfaceVariant,
        contentColor = colorScheme.onSurfaceVariant,
        highlightCode(code, language, highlightColors)
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        }
    ) {
    Surface(
    code: String,
    language: String?,
    modifier: Modifier = Modifier,
    val colorScheme = MaterialTheme.colorScheme
    val copyToClipboard = rememberCopyToClipboard()
    val highlightColors = remember(colorScheme) { codeHighlightColors(colorScheme) }
    val highlighted = remember(code, language, highlightColors) {
    }
) {
@Composable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.rememberCopyToClipboard
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.bot_message_copy_content_description
import org.jetbrains.compose.resources.stringResource
internal fun CodeFenceBlock(
package com.inspiredandroid.kai.ui.markdown
}
