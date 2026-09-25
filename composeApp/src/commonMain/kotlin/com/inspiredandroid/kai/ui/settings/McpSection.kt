import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.mcp.PopularMcpServer
import com.inspiredandroid.kai.mcp.authorizationHeaderValue
import com.inspiredandroid.kai.mcp.popularMcpServers
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_arrow_drop_down
import kai.composeapp.generated.resources.settings_mcp_add
import kai.composeapp.generated.resources.settings_mcp_add_header
import kai.composeapp.generated.resources.settings_mcp_add_server
import kai.composeapp.generated.resources.settings_mcp_api_key
import kai.composeapp.generated.resources.settings_mcp_api_key_help
import kai.composeapp.generated.resources.settings_mcp_header_key
import kai.composeapp.generated.resources.settings_mcp_header_value
import kai.composeapp.generated.resources.settings_mcp_no_tools
import kai.composeapp.generated.resources.settings_mcp_popular_servers
import kai.composeapp.generated.resources.settings_mcp_refresh
import kai.composeapp.generated.resources.settings_mcp_remove
import kai.composeapp.generated.resources.settings_mcp_server_name
import kai.composeapp.generated.resources.settings_mcp_server_url
import kai.composeapp.generated.resources.settings_mcp_servers
import kai.composeapp.generated.resources.settings_mcp_servers_description
import kai.composeapp.generated.resources.settings_mcp_status_connected
import kai.composeapp.generated.resources.settings_mcp_status_connecting
import kai.composeapp.generated.resources.settings_mcp_status_error
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

                                        .forEach { remove(it) }
                                        .toList()
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1,
                                        onAddPopular(server)
                                        overflow = TextOverflow.Ellipsis,
                                        prefillPopularWithAuth(server)
                                        style = MaterialTheme.typography.bodySmall,
                                        text = stringResource(Res.string.settings_mcp_header_key),
                                        text = stringResource(Res.string.settings_mcp_header_value),
                                        text = tool.description,
                                    )
                                    .filter { it.key.isNotBlank() && it.value.isNotBlank() }
                                    .forEach { put(it.key.trim(), it.value.trim()) }
                                    // Replace any Authorization row with the dedicated API key field.
                                    Text(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    contentDescription = stringResource(Res.string.settings_mcp_remove),
                                    if (server.requiresAuth) {
                                    imageVector = Icons.Default.Clear,
                                    keys.filter { it.equals("Authorization", ignoreCase = true) }
                                    put("Authorization", authorizationHeaderValue(apiKey))
                                    style = MaterialTheme.typography.bodyMedium,
                                    style = MaterialTheme.typography.bodySmall,
                                    text = server.description,
                                    text = server.name,
                                    text = tool.name,
                                    }
                                    } else {
                                )
                                .clickable {
                                .clip(CardDefaults.shape)
                                .fillMaxWidth()
                                .handCursor(),
                                Icon(
                                Text(
                                checked = tool.isEnabled,
                                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                                headers
                                if (requiresAuth && apiKey.isNotBlank()) {
                                if (tool.description.isNotEmpty()) {
                                label = {
                                modifier = Modifier.handCursor(),
                                modifier = Modifier.weight(0.5f),
                                onCheckedChange = { enabled -> onToggleTool(tool.id, enabled) },
                                onClick = { headers.removeAt(index) },
                                onValueChange = { headers[index] = entry.copy(key = it) },
                                onValueChange = { headers[index] = entry.copy(value = it) },
                                singleLine = true,
                                value = entry.key,
                                value = entry.value,
                                }
                                },
                            )
                            ) {
                            ),
                            // The floating labels must stay on one line: at large font
                            // lands on top of the URL field above it.
                            // scales a wrapped label grows upward out of the field and
                            Column(modifier = Modifier.padding(12.dp)) {
                            Column(modifier = Modifier.weight(1f)) {
                            IconButton(
                            KaiOutlinedTextField(
                            McpConnectionStatus.Error -> MaterialTheme.colorScheme.error
                            Spacer(Modifier.width(8.dp))
                            Switch(
                            color = MaterialTheme.colorScheme.error,
                            colors = CardDefaults.cardColors(
                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                            modifier = Modifier
                            modifier = Modifier.fillMaxWidth(),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            onAdd(name, url, headerMap)
                            text = stringResource(Res.string.settings_mcp_remove),
                            val headerMap = buildMap {
                            verticalAlignment = Alignment.CenterVertically,
                            }
                        )
                        ) {
                        .background(statusColor),
                        .clip(CircleShape)
                        .size(10.dp)
                        // Auth-required popular servers (e.g. Jina) can still be added without a
                        // key — some tools work unauthenticated; search needs a key later.
                        Card(
                        Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                        Row(
                        Spacer(Modifier.height(4.dp))
                        Spacer(Modifier.width(4.dp))
                        Text(
                        Text(stringResource(Res.string.settings_mcp_add))
                        Text(stringResource(Res.string.settings_mcp_add_header))
                        Text(stringResource(Res.string.settings_mcp_refresh))
                        color = MaterialTheme.colorScheme.onBackground,
                        color = MaterialTheme.colorScheme.onSurface,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        color = when (server.connectionStatus) {
                        enabled = name.isNotBlank() && url.isNotBlank(),
                        label = { Text(stringResource(Res.string.settings_mcp_api_key)) },
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth(),
                        modifier = Modifier.handCursor(),
                        onClick = {
                        onClick = { headers.add(HeaderEntry(key = "", value = "")) },
                        onValueChange = { apiKey = it },
                        overflow = TextOverflow.Ellipsis,
                        singleLine = true,
                        style = MaterialTheme.typography.bodySmall,
                        style = MaterialTheme.typography.titleMedium,
                        style = MaterialTheme.typography.titleSmall,
                        text = server.name,
                        text = server.url,
                        text = statusText,
                        text = stringResource(Res.string.settings_mcp_api_key_help),
                        text = stringResource(Res.string.settings_mcp_no_tools),
                        text = stringResource(Res.string.settings_mcp_popular_servers),
                        value = apiKey,
                        }
                        },
                    )
                    ) {
                    .padding(16.dp),
                    .verticalScroll(mcpScrollState)
                    KaiOutlinedTextField(
                    McpConnectionStatus.Connected -> StatusColorConnected
                    McpConnectionStatus.Connected -> stringResource(Res.string.settings_mcp_status_connected)
                    McpConnectionStatus.Connecting -> StatusColorChecking
                    McpConnectionStatus.Connecting -> stringResource(Res.string.settings_mcp_status_connecting)
                    McpConnectionStatus.Error -> StatusColorError
                    McpConnectionStatus.Error -> stringResource(Res.string.settings_mcp_status_error)
                    McpConnectionStatus.Unknown -> ""
                    McpConnectionStatus.Unknown -> StatusColorUnknown
                    Spacer(Modifier.height(12.dp))
                    Spacer(Modifier.height(16.dp))
                    Spacer(Modifier.height(4.dp))
                    Spacer(Modifier.height(8.dp))
                    Text(
                    TextButton(
                    TextButton(onClick = onRefresh, modifier = Modifier.handCursor()) {
                    TextButton(onClick = onRemove, modifier = Modifier.handCursor()) {
                    checked = server.isEnabled,
                    color = MaterialTheme.colorScheme.onSurface,
                    contentDescription = null,
                    for (server in popularMcpServers) {
                    for (tool in server.tools) {
                    headers.forEachIndexed { index, entry ->
                    horizontalArrangement = Arrangement.End,
                    imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                    label = { Text(stringResource(Res.string.settings_mcp_server_name)) },
                    label = { Text(stringResource(Res.string.settings_mcp_server_url)) },
                    modifier = Modifier
                    modifier = Modifier.fillMaxWidth(),
                    onCheckedChange = onToggle,
                    onValueChange = { name = it },
                    onValueChange = { url = it },
                    singleLine = true,
                    style = MaterialTheme.typography.headlineSmall,
                    text = stringResource(Res.string.settings_mcp_add_server),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    value = name,
                    value = url,
                    }
                )
                ) {
                // Status dot
                // Status text
                // Tools list
                Box(
                Column(modifier = Modifier.weight(1f)) {
                Icon(
                KaiOutlinedTextField(
                Row(
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Spacer(Modifier.height(12.dp))
                Spacer(Modifier.height(16.dp))
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.width(12.dp))
                Spacer(Modifier.width(8.dp))
                Switch(
                Text(
                if (popularMcpServers.isNotEmpty()) {
                if (requiresAuth) {
                if (server.tools.isNotEmpty()) {
                if (statusText.isNotEmpty()) {
                modifier = Modifier
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                modifier = Modifier.fillMaxWidth(),
                onRefresh = { onRefreshMcpServer(server.id) },
                onRemove = { onRemoveMcpServer(server.id) },
                onToggle = { enabled -> onToggleMcpServer(server.id, enabled) },
                onToggleTool = onToggleTool,
                scrollState = mcpScrollState,
                server = server,
                val statusColor = when (server.connectionStatus) {
                val statusText = when (server.connectionStatus) {
                verticalAlignment = Alignment.CenterVertically,
                }
                } else if (server.connectionStatus == McpConnectionStatus.Connected) {
                } else {
            )
            ) {
            Column(
            McpServerCard(
            Row(
            Spacer(Modifier.height(8.dp))
            Text(stringResource(Res.string.settings_mcp_add_server))
            VerticalScrollbarForScroll(
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            if (expanded) {
            modifier = Modifier.align(Alignment.CenterHorizontally).handCursor(),
            onAdd = onAddMcpServer,
            onAddPopular = onAddPopularMcpServer,
            onClick = { onShowAddDialog(true) },
            onDismiss = { onShowAddDialog(false) },
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(Res.string.settings_mcp_servers),
            text = stringResource(Res.string.settings_mcp_servers_description),
            }
        )
        ) {
        AddMcpServerDialog(
        Box {
        Column(modifier = Modifier.padding(16.dp)) {
        OutlinedButton(
        Spacer(Modifier.height(12.dp))
        Spacer(Modifier.height(4.dp))
        Text(
        apiKey = ""
        border = kaiAdaptiveCardBorder(),
        colors = kaiAdaptiveCardColors(),
        for (server in mcpServers) {
        headers.add(HeaderEntry(key = "Authorization", value = ""))
        headers.clear()
        modifier = Modifier.fillMaxWidth().handCursor(),
        name = server.name
        onClick = { expanded = !expanded },
        onDismissRequest = onDismiss,
        requiresAuth = true
        scope.launch { mcpScrollState.animateScrollTo(0) }
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        url = server.url
        }
    ) {
    // When a popular server needs auth (e.g. Jina), prefill the form and show an API key field.
    Card(
    Column(modifier = Modifier.fillMaxWidth()) {
    ModalBottomSheet(
    fun prefillPopularWithAuth(server: PopularMcpServer) {
    if (showAddDialog) {
    mcpServers: ImmutableList<McpServerUiState>,
    onAdd: (String, String, Map<String, String>) -> Unit,
    onAddMcpServer: (String, String, Map<String, String>) -> Unit,
    onAddPopular: (PopularMcpServer) -> Unit,
    onAddPopularMcpServer: (PopularMcpServer) -> Unit,
    onDismiss: () -> Unit,
    onRefresh: () -> Unit,
    onRefreshMcpServer: (String) -> Unit,
    onRemove: () -> Unit,
    onRemoveMcpServer: (String) -> Unit,
    onShowAddDialog: (Boolean) -> Unit,
    onToggle: (Boolean) -> Unit,
    onToggleMcpServer: (String, Boolean) -> Unit,
    onToggleTool: (String, Boolean) -> Unit,
    server: McpServerUiState,
    showAddDialog: Boolean,
    val headers = remember { mutableStateListOf(HeaderEntry()) }
    val mcpScrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    var apiKey by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var requiresAuth by remember { mutableStateOf(false) }
    var url by remember { mutableStateOf("") }
    }
) {
@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun McpServersSection(
package com.inspiredandroid.kai.ui.settings
private data class HeaderEntry(val key: String = "Authorization", val value: String = "")
private fun AddMcpServerDialog(
private fun McpServerCard(
}
