import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.build.BuildAgent
import com.inspiredandroid.kai.build.BuildAgents
import com.inspiredandroid.kai.build.BuildTerminalSession
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_back_content_description
import kai.composeapp.generated.resources.kai_build_files_tab
import kai.composeapp.generated.resources.kai_build_session_close_content_description
import kai.composeapp.generated.resources.kai_build_session_new_content_description
import kai.composeapp.generated.resources.kai_build_session_shell
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

                            onNewSession(agent.id)
                            showNewMenu = false
                        modifier = Modifier.handCursor(),
                        onClick = {
                        onNewSession(null)
                        showNewMenu = false
                        text = { Text(agent.title) },
                        },
                    )
                    DropdownMenuItem(
                    Res.string.kai_build_session_close_content_description,
                    contentDescription = stringResource(Res.string.kai_build_session_new_content_description),
                    imageVector = Icons.Default.Add,
                    modifier = Modifier.handCursor(),
                    numbered = sessions.size > 1,
                    onClick = {
                    onClose = { onCloseSession(session.id) },
                    onSelect = { onSelectSession(session.id) },
                    selected = !filesSelected && session.id == activeSessionId,
                    session = session,
                    text = { Text(stringResource(Res.string.kai_build_session_shell)) },
                    },
                )
                ),
                DropdownMenuItem(
                Icon(
                SessionTab(
                color = contentColor,
                contentDescription = stringResource(
                contentDescription = stringResource(Res.string.kai_build_back_content_description),
                end = if (selected && trailing != null) 2.dp else 12.dp,
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                imageVector = Icons.Default.Close,
                installedAgents.forEach { agent ->
                label = stringResource(Res.string.kai_build_files_tab),
                maxLines = 1,
                modifier = Modifier.padding(vertical = 8.dp),
                modifier = Modifier.size(14.dp),
                modifier = Modifier.size(40.dp).handCursor(),
                onClick = { showNewMenu = true },
                onSelect = onSelectFiles,
                overflow = TextOverflow.Ellipsis,
                selected = filesSelected,
                start = 12.dp,
                style = MaterialTheme.typography.labelMedium,
                text = label,
                tint = contentColor,
                }
            )
            ) {
            ),
            // Pinned: the project's files are always there, unlike a session.
            DropdownMenu(expanded = showNewMenu, onDismissRequest = { showNewMenu = false }) {
            Icon(
            IconButton(
            TabPill(
            Text(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            if (selected && trailing != null) trailing()
            modifier = Modifier.padding(
            modifier = Modifier.weight(1f).horizontalScroll(rememberScrollState()),
            sessions.forEach { session ->
            verticalAlignment = Alignment.CenterVertically,
            }
        !session.busy -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
        ) {
        // A finished shell keeps its output readable but reads as inactive.
        Box {
        IconButton(onClick = onBack, modifier = Modifier.size(40.dp).handCursor()) {
        IconButton(onClick = onClose, modifier = Modifier.size(28.dp).handCursor()) {
        MaterialTheme.colorScheme.onSurfaceVariant
        MaterialTheme.colorScheme.primary
        Row(
        color = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) else Color.Transparent,
        contentColor = contentColor,
        else -> MaterialTheme.colorScheme.onSurfaceVariant
        label = label,
        modifier = Modifier.clip(shape).clickable(onClick = onSelect).handCursor(),
        modifier = modifier.fillMaxWidth().padding(horizontal = 4.dp),
        onSelect = onSelect,
        selected -> MaterialTheme.colorScheme.primary
        selected = selected,
        shape = shape,
        verticalAlignment = Alignment.CenterVertically,
        }
    ) {
    Row(
    Surface(
    TabPill(
    activeSessionId: String?,
    contentColor: Color = if (selected) {
    filesSelected: Boolean,
    installedAgents: ImmutableList<BuildAgent>,
    label: String,
    modifier: Modifier = Modifier,
    numbered: Boolean,
    onBack: () -> Unit,
    onClose: () -> Unit,
    onCloseSession: (String) -> Unit,
    onNewSession: (String?) -> Unit,
    onSelect: () -> Unit,
    onSelectFiles: () -> Unit,
    onSelectSession: (String) -> Unit,
    selected: Boolean,
    session: BuildTerminalSession,
    sessions: ImmutableList<BuildTerminalSession>,
    trailing: @Composable (() -> Unit)? = null,
    val base = BuildAgents.get(session.agentId)?.title ?: stringResource(Res.string.kai_build_session_shell)
    val contentColor = when {
    val label = if (numbered) "$base ${session.number}" else base
    val shape = RoundedCornerShape(50)
    var showNewMenu by remember { mutableStateOf(false) }
    }
    } else {
    },
 * The terminal screen's only chrome: back out of the project, switch between the
 * project's live shells, and start another one. Replaces a separate title bar so
 * the cell grid keeps the vertical space.
 */
) {
/**
/** The strip's pill shape. [trailing] is shown only while selected — that is where a tab's close button goes. */
@Composable
internal fun BuildSessionBar(
package com.inspiredandroid.kai.ui.build
private fun SessionTab(
private fun TabPill(
}
