import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardSurface

                color = MaterialTheme.colorScheme.onBackground,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                contentDescription = deleteContentDescription,
                contentDescription = refreshContentDescription.orEmpty(),
                imageVector = Icons.Default.Delete,
                isRefreshing = isRefreshing,
                maxLines = subtitleMaxLines,
                onClick = onRefresh,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                style = MaterialTheme.typography.bodySmall,
                text = subtitle,
                text = title,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            .fillMaxWidth()
            .kaiAdaptiveCardSurface(RoundedCornerShape(8.dp))
            .padding(12.dp),
            .then(if (onClick != null) Modifier.clickable(onClick = onClick).handCursor() else Modifier)
            Icon(
            RefreshIconButton(
            Text(
            modifier = Modifier.handCursor(),
            onClick = onDelete,
        ) {
        Column(modifier = Modifier.weight(1f)) {
        IconButton(
        if (onRefresh != null) {
        modifier = modifier
        verticalAlignment = Alignment.CenterVertically,
        }
    ) {
    Row(
    deleteContentDescription: String?,
    isRefreshing: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    onDelete: () -> Unit,
    onRefresh: (() -> Unit)? = null,
    refreshContentDescription: String? = null,
    subtitle: String,
    subtitleMaxLines: Int = 1,
    title: String,
    }
) {
@Composable
fun SettingsListItem(
package com.inspiredandroid.kai.ui.components
}
