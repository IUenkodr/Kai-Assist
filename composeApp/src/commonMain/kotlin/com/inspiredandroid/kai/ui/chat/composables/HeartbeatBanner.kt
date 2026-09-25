
                        contentDescription = stringResource(Res.string.heartbeat_banner_dismiss),
                        imageVector = vectorResource(Res.drawable.ic_close),
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Icon(
                    color = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null,
                    imageVector = vectorResource(Res.drawable.ic_history),
                    maxLines = 1,
                    modifier = Modifier.size(18.dp),
                    modifier = Modifier.size(24.dp).handCursor(),
                    modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                    onClick = onDismiss,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                    text = stringResource(Res.string.heartbeat_banner_message),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                ) {
                .clickable { onTap() },
                .fillMaxWidth()
                .handCursor()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                Icon(
                IconButton(
                Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                }
            ) {
            Row(
            border = kaiAdaptiveCardBorder(),
            colors = kaiAdaptiveCardColors(),
            modifier = Modifier
            }
        ) {
        Card(
        enter = slideInVertically { -it },
        exit = slideOutVertically { -it },
        visible = visible,
        }
    ) {
    AnimatedVisibility(
    onDismiss: () -> Unit,
    onTap: () -> Unit,
    visible: Boolean,
    }
) {
@Composable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.heartbeat_banner_dismiss
import kai.composeapp.generated.resources.heartbeat_banner_message
import kai.composeapp.generated.resources.ic_close
import kai.composeapp.generated.resources.ic_history
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun HeartbeatBanner(
package com.inspiredandroid.kai.ui.chat.composables
}
