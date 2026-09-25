
                .defaultMinSize(minWidth = 48.dp)
                .padding(horizontal = 16.dp, vertical = 4.dp),
                content()
            CompositionLocalProvider(LocalContentColor provides contentColor) {
            border = border,
            color = containerColor,
            content = chipContent,
            contentAlignment = Alignment.Center,
            contentColor = contentColor,
            enabled = enabled,
            modifier = Modifier
            modifier = sizeModifier,
            modifier = sizeModifier.handCursor(),
            onClick = onClick,
            shape = shape,
            }
        !enabled -> colorScheme.onSurface.copy(alpha = 0.38f)
        !enabled -> colorScheme.outline.copy(alpha = 0.38f)
        )
        ) {
        Box(
        Surface(
        else -> colorScheme.onSurfaceVariant
        else -> colorScheme.outline
        selected -> colorScheme.onSecondaryContainer
        selected -> colorScheme.secondaryContainer
        }
    content: @Composable () -> Unit,
    enabled: Boolean = true,
    if (onClick != null) {
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    selected: Boolean = false,
    val border = BorderStroke(1.dp, borderColor)
    val borderColor = when {
    val chipContent: @Composable () -> Unit = {
    val colorScheme = MaterialTheme.colorScheme
    val containerColor = if (selected) colorScheme.secondaryContainer else colorScheme.surfaceContainer
    val contentColor = when {
    val shape = RoundedCornerShape(8.dp)
    val sizeModifier = modifier.defaultMinSize(minHeight = 38.dp)
    }
    } else {
 * Chip with full control over appearance — no hidden minimum-interactive-size
 * padding from Material's FilterChip. 38.dp tall at the default font scale, and
 * taller when the label needs the room.
 */
) {
/**
@Composable
fun KaiChip(
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
package com.inspiredandroid.kai.ui.components
}
