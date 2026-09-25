import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor

                color = MaterialTheme.colorScheme.onSurfaceVariant,
                contentDescription = contentDescription,
                imageVector = Icons.Default.Refresh,
                modifier = Modifier.size(18.dp),
                strokeWidth = 2.dp,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            CircularProgressIndicator(
            Icon(
        enabled = !isRefreshing,
        if (isRefreshing) {
        modifier = modifier.handCursor(),
        onClick = onClick,
        }
        } else {
    ) {
    IconButton(
    contentDescription: String,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    }
) {
@Composable
fun RefreshIconButton(
package com.inspiredandroid.kai.ui.components
}
