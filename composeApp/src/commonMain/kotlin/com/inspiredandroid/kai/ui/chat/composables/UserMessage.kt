import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.data.Attachment
import com.inspiredandroid.kai.decodeToImageBitmap
import com.inspiredandroid.kai.ui.components.LocalShowFullScreenImage
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_file
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.resources.painterResource

                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp),
                                        painter = painterResource(Res.drawable.ic_file),
                                        tint = MaterialTheme.colorScheme.onBackground,
                                    )
                                    Icon(
                                .clickable { showFullScreen(imageBitmap) },
                                .clip(RoundedCornerShape(8.dp))
                                .handCursor()
                                .widthIn(max = 200.dp)
                                icon = {
                                label = { Text(truncateFileName(att.fileName ?: att.mimeType)) },
                                onClick = {},
                                },
                            )
                            SuggestionChip(
                            bitmap = imageBitmap,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            decodeToImageBitmap(Base64.decode(att.data))
                            modifier = Modifier
                            null
                        )
                        Image(
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.15f),
                        RoundedCornerShape(8.dp),
                        Spacer(Modifier.height(8.dp))
                        color = MaterialTheme.colorScheme.onBackground,
                        for (att in others) {
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        text = message,
                        try {
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        }
                        } catch (_: Exception) {
                    )
                    ) {
                    .background(
                    .padding(16.dp),
                    FlowRow(
                    Text(
                    if (imageBitmap != null) {
                    if (message.isNotEmpty()) {
                    val imageBitmap = remember(att.data) {
                    }
                for (att in images) {
                horizontalAlignment = Alignment.End,
                if (message.isNotEmpty()) {
                if (others.isNotEmpty()) {
                modifier = Modifier
                val images = attachments.filter { it.mimeType.startsWith("image/") }
                val others = attachments.filter { !it.mimeType.startsWith("image/") }
                }
            ) {
            Column(
            Spacer(Modifier.weight(1f))
            }
        Row(Modifier.padding(16.dp)) {
        }
    SelectionContainer {
    attachments: ImmutableList<Attachment> = persistentListOf(),
    message: String,
    val showFullScreen = LocalShowFullScreenImage.current
    }
) {
@Composable
@OptIn(ExperimentalEncodingApi::class, ExperimentalLayoutApi::class)
internal fun UserMessage(
package com.inspiredandroid.kai.ui.chat.composables
}
