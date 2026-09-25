
                            Text(stringResource(Res.string.sms_draft_banner_send))
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(14.dp),
                            strokeWidth = 2.dp,
                            style = MaterialTheme.typography.labelSmall,
                            text = stringResource(Res.string.sms_draft_banner_sending),
                        )
                        CircularProgressIndicator(
                        Res.string.sms_draft_banner_discard
                        Res.string.sms_draft_banner_dismiss
                        Spacer(Modifier.size(8.dp))
                        Text(
                        TextButton(onClick = onSend) {
                        contentDescription = dismissLabel,
                        draft = draft,
                        horizontalArrangement = Arrangement.End,
                        imageVector = vectorResource(Res.drawable.ic_close),
                        modifier = Modifier.fillMaxWidth(),
                        modifier = Modifier.size(16.dp),
                        onDiscard = { onDiscard(draft.id) },
                        onSend = { onSend(draft.id) },
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        verticalAlignment = Alignment.CenterVertically,
                        }
                    )
                    ) {
                    Icon(
                    PendingSmsBanner(
                    Row(
                    Row(verticalAlignment = Alignment.CenterVertically) {
                    color = MaterialTheme.colorScheme.error,
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                    if (draft.status == SmsDraftStatus.SENT) {
                    maxLines = 1,
                    modifier = Modifier.size(24.dp).handCursor(),
                    modifier = Modifier.weight(1f),
                    onClick = onDiscard,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium,
                    style = MaterialTheme.typography.labelSmall,
                    text = stringResource(Res.string.sms_draft_banner_failed, draft.lastError ?: "unknown error"),
                    text = stringResource(Res.string.sms_draft_banner_sent),
                    text = stringResource(Res.string.sms_draft_banner_to, draft.address),
                    }
                    } else {
                    },
                )
                ) {
                // Stable key so a status change on one draft doesn't recompose siblings.
                IconButton(
                SmsDraftStatus.FAILED -> Text(
                SmsDraftStatus.PENDING -> {
                SmsDraftStatus.SENDING -> {
                SmsDraftStatus.SENT -> Text(
                Text(
                color = MaterialTheme.colorScheme.onBackground,
                key(draft.id) {
                maxLines = 3,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall,
                text = draft.body,
                val dismissLabel = stringResource(
                verticalAlignment = Alignment.CenterVertically,
                }
            )
            ) {
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp),
            Row(
            Spacer(Modifier.height(4.dp))
            Text(
            for (draft in drafts) {
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            when (draft.status) {
            }
        ) {
        Column(
        border = kaiAdaptiveCardBorder(),
        colors = kaiAdaptiveCardColors(),
        enter = slideInVertically { -it },
        exit = slideOutVertically { -it },
        modifier = Modifier
        visible = drafts.isNotEmpty(),
        }
    ) {
    AnimatedVisibility(
    Card(
    draft: SmsDraft,
    drafts: ImmutableList<SmsDraft>,
    onDiscard: () -> Unit,
    onDiscard: (String) -> Unit,
    onSend: () -> Unit,
    onSend: (String) -> Unit,
    }
 * Stack of cards, one per pending/sending/sent/failed SMS draft. Explicit
 * confirmation gate — the AI stages drafts via `send_sms` / `reply_sms` but
 * nothing leaves the device until the user taps Send here.
 */
) {
/**
@Composable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.SmsDraft
import com.inspiredandroid.kai.data.SmsDraftStatus
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_close
import kai.composeapp.generated.resources.sms_draft_banner_discard
import kai.composeapp.generated.resources.sms_draft_banner_dismiss
import kai.composeapp.generated.resources.sms_draft_banner_failed
import kai.composeapp.generated.resources.sms_draft_banner_send
import kai.composeapp.generated.resources.sms_draft_banner_sending
import kai.composeapp.generated.resources.sms_draft_banner_sent
import kai.composeapp.generated.resources.sms_draft_banner_to
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun PendingSmsBanners(
package com.inspiredandroid.kai.ui.chat.composables
private fun PendingSmsBanner(
}
