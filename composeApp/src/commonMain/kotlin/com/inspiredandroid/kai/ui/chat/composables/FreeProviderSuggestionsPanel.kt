package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.freeProviderSuggestions
import com.inspiredandroid.kai.network.UiError
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.error_free_limit_body
import kai.composeapp.generated.resources.error_free_limit_title
import kai.composeapp.generated.resources.ic_refresh
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

                            color = MaterialTheme.colorScheme.onSurface,
                            contentDescription = null,
                            imageVector = vectorResource(suggestion.service.icon),
                            maxLines = 1,
                            modifier = Modifier.size(16.dp),
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.labelMedium,
                            text = suggestion.service.displayName,
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                        .clickable { uriHandler.openUri(suggestion.signupUrl) },
                        .clip(RoundedCornerShape(50))
                        .handCursor()
                        Icon(
                        Spacer(Modifier.width(6.dp))
                        Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                    Row(
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier
                    shape = RoundedCornerShape(50),
                    }
                ) {
                Surface(
                contentDescription = null,
                imageVector = vectorResource(Res.drawable.ic_refresh),
                tint = MaterialTheme.colorScheme.onBackground,
                }
            )
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
            Icon(
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            freeProviderSuggestions.forEach { suggestion ->
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.handCursor(),
            onClick = retry,
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.error_free_limit_body),
            text = stringResource(Res.string.error_free_limit_title),
            text = uiErrorText(error),
            textAlign = TextAlign.Center,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            }
        )
        ) {
        FlowRow(
        IconButton(
        Spacer(Modifier.height(12.dp))
        Spacer(Modifier.height(6.dp))
        Spacer(Modifier.height(8.dp))
        Text(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
        }
    ) {
    // No verticalScroll — this panel is often a LazyColumn item.
    Column(
    error: UiError,
    modifier: Modifier = Modifier,
    retry: () -> Unit,
    val uriHandler = LocalUriHandler.current
    }
) {
@Composable
@OptIn(ExperimentalLayoutApi::class)
internal fun FreeProviderSuggestionsPanel(
}
