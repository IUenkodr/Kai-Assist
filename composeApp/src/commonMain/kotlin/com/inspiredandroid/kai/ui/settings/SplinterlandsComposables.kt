
                                    Text(service.modelId, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    style = MaterialTheme.typography.bodySmall,
                                    text = entry.modelId,
                                )
                                Text(
                                Text(service.serviceName, style = MaterialTheme.typography.bodyMedium)
                                color = MaterialTheme.colorScheme.onBackground,
                                color = MaterialTheme.colorScheme.primary,
                                contentDescription = "Remove",
                                contentDescription = "Reorder",
                                contentDescription = entry.serviceName,
                                contentDescription = service.serviceName,
                                if (service.modelId.isNotBlank()) {
                                imageVector = Icons.Default.Delete,
                                imageVector = Icons.Rounded.DragIndicator,
                                imageVector = org.jetbrains.compose.resources.vectorResource(entry.icon),
                                imageVector = org.jetbrains.compose.resources.vectorResource(service.icon),
                                maxLines = 1,
                                modifier = Modifier.draggableHandle().handCursor(),
                                modifier = Modifier.size(12.dp),
                                modifier = Modifier.size(20.dp),
                                onRemove()
                                overflow = TextOverflow.Ellipsis,
                                showConfirm = false
                                strokeWidth = 1.5.dp,
                                style = MaterialTheme.typography.bodySmall,
                                text = entry?.serviceName ?: id,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                }
                            )
                            Column {
                            Icon(
                            LlmServiceStatus.Failed -> Text("\u2718", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.error)
                            LlmServiceStatus.InvalidResponse -> Text("\u2718", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.error)
                            LlmServiceStatus.Querying -> CircularProgressIndicator(
                            LlmServiceStatus.Selected -> Text("\u2605", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.tertiary)
                            LlmServiceStatus.ValidResponse -> Text("\u2714", style = MaterialTheme.typography.labelSmall, color = Color(0xFF4CAF50))
                            Text(
                            Text("Remove", color = MaterialTheme.colorScheme.error)
                            color = MaterialTheme.colorScheme.onBackground,
                            color = MaterialTheme.colorScheme.onSurface,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            color = if (entry.llmPicked) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant,
                            if (entry != null && entry.modelId.isNotBlank()) {
                            maxLines = 1,
                            modifier = Modifier.handCursor(),
                            modifier = Modifier.padding(vertical = 1.dp),
                            modifier = Modifier.weight(1f),
                            modifier = Modifier.width(20.dp),
                            onAddService(service.instanceId)
                            onClick = {
                            onClick = { onRemoveService(id) },
                            onClick = { showConfirm = false },
                            overflow = TextOverflow.Ellipsis,
                            showDropdown = false
                            style = MaterialTheme.typography.bodySmall,
                            style = MaterialTheme.typography.labelMedium,
                            style = MaterialTheme.typography.labelSmall,
                            text = "${bs.currentMana} mana",
                            text = "${index + 1}.",
                            text = "vs ${bs.currentOpponent}",
                            text = bs.currentRulesets,
                            text = infoItems.joinToString(" · "),
                            text = label,
                            text = line,
                            text = serviceId,
                            }
                            },
                        )
                        ) {
                        ) { Text("Cancel") }
                        .background(MaterialTheme.colorScheme.primaryContainer),
                        .clip(CircleShape)
                        .clip(CircleShape),
                        .size(32.dp)
                        // Drag handle
                        // Name + model
                        // Priority number
                        // Remove button
                        // Service icon
                        // Status indicator
                        Column(modifier = Modifier.weight(1f)) {
                        IconButton(
                        Spacer(Modifier.weight(1f))
                        Text(
                        Text("Clear", style = MaterialTheme.typography.labelSmall)
                        Text("Show more (${battleLog.size - 5})")
                        TextButton(
                        account = account,
                        addAll(details)
                        color = MaterialTheme.colorScheme.onBackground,
                        color = MaterialTheme.colorScheme.onPrimary,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        color = MaterialTheme.colorScheme.primary,
                        color = if (bs.llmPickedTeam == true) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant,
                        contentDescription = if (showKey) "Hide" else "Show",
                        formatRelativeTime(entry.timestampMs, nowMs)
                        hasServices = instanceIds.isNotEmpty(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        if (entry != null) {
                        if (entry.account.isNotBlank()) add(entry.account)
                        if (instanceIds.size >= 2) {
                        imageVector = if (showKey) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        leadingIcon = {
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth(),
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.padding(start = 48.dp, top = 1.dp),
                        modifier = Modifier.size(16.dp),
                        modifier = Modifier.weight(1f),
                        onClick = onClearBattleLog,
                        onClick = {
                        onClick = { showAll = true },
                        onRemove = { onRemoveAccount(account.accountId) },
                        onStartBattle = { onStartBattle(account.accountId) },
                        onStopBattle = { onStopBattle(account.accountId) },
                        overflow = TextOverflow.Ellipsis,
                        strokeWidth = 2.dp,
                        style = MaterialTheme.typography.bodySmall,
                        style = MaterialTheme.typography.labelMedium,
                        style = MaterialTheme.typography.labelSmall,
                        text = "Recent Battles",
                        text = "\u26A1 ${account.energy}",
                        text = account.username.take(1).uppercase(),
                        text = label,
                        text = phaseText,
                        text = relTime,
                        text = {
                        uriHandler.openUri("https://splinterlands.com/battle/${entry.battleId}")
                        val label = if (entry.llmPicked) entry.modelName.ifBlank { "LLM" } else "none"
                        val nowMs = kotlin.time.Clock.System.now().toEpochMilliseconds()
                        verticalAlignment = Alignment.CenterVertically,
                        when (status) {
                        }
                        },
                    )
                    ) {
                    BattlePhase.FetchingCollection,
                    BattlePhase.PickingTeam,
                    BattlePhase.SubmittingTeam,
                    BattlePhase.WaitingForResult,
                    CircularProgressIndicator(
                    Icon(
                    Modifier
                    Modifier.clickable { showActivity = true }.handCursor()
                    Row(
                    Spacer(Modifier.width(8.dp))
                    SplinterlandsAccountRow(
                    SplinterlandsBattleLogRow(entry)
                    SplinterlandsCountdown(bs.teamDeadlineMs)
                    Text(
                    Text("Start", style = MaterialTheme.typography.bodySmall)
                    Text("Test & Add")
                    Text("Testing...")
                    Text(if (bs.isStopping) "Stopping..." else "Stop", style = MaterialTheme.typography.bodySmall)
                    TextButton(
                    androidx.compose.material3.DropdownMenuItem(
                    color = MaterialTheme.colorScheme.error,
                    color = MaterialTheme.colorScheme.onBackground,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    color = if (entry.won) Color(0xFF4CAF50) else MaterialTheme.colorScheme.error,
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                    confirmButton = {
                    contentAlignment = Alignment.Center,
                    contentDescription = "Remove",
                    contentDescription = account.username,
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    contentScale = ContentScale.Crop,
                    dismissButton = {
                    enabled = !bs.isStopping,
                    enabled = hasServices,
                    expanded = false
                    for (line in entry.activity) {
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    if (bs.currentMana > 0) {
                    if (bs.currentOpponent.isNotBlank()) {
                    if (bs.currentRulesets.isNotBlank()) {
                    if (entry.llmPicked != null) {
                    if (infoItems.isNotEmpty()) {
                    imageVector = Icons.Default.Delete,
                    maxLines = 1,
                    model = account.avatarUrl,
                    modifier = Modifier
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    modifier = Modifier.fillMaxWidth(),
                    modifier = Modifier.handCursor(),
                    modifier = Modifier.padding(start = 40.dp, top = 2.dp),
                    modifier = Modifier.weight(1f),
                    onClick = onStartBattle,
                    onClick = onStopBattle,
                    onClick = {
                    onClick = { showKey = !showKey },
                    onDismissRequest = { showConfirm = false },
                    onTestAndAdd(username, postingKey)
                    overflow = TextOverflow.Ellipsis,
                    postingKey = ""
                    scrollState = activityScrollState,
                    style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.labelMedium,
                    text = "${bs.wins}W ${bs.losses}L",
                    text = "Error",
                    text = "vs ${entry.opponent}",
                    text = account.username,
                    text = if (entry.won) "Victory" else "Defeat",
                    text = { Text("Remove ${account.username} from Splinterlands?") },
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    title = { Text("Remove Account") },
                    username = ""
                    val entry = serviceMap[id]
                    val infoItems = buildList {
                    val label = if (bs.llmPickedTeam == true) bs.winningServiceName.ifBlank { "LLM" } else "Auto"
                    val relTime = remember(entry.timestampMs) {
                    verticalAlignment = Alignment.CenterVertically,
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    }
                    } else {
                    },
                )
                ) {
                ) { Text("View Battle") }
                // FlowRow: three unweighted facts in a Row run off the right edge once
                // W/L badge
                // the text grows, taking the rulesets with them.
                AlertDialog(
                BattlePhase.CheckingEnergy -> "Checking energy..."
                BattlePhase.FetchingCollection -> "Fetching cards..."
                BattlePhase.FindingMatch -> "Finding match..."
                BattlePhase.Finished -> "Done"
                BattlePhase.LoggingIn -> "Logging in..."
                BattlePhase.PickingTeam -> "Picking team..."
                BattlePhase.SubmittingTeam -> "Submitting team..."
                BattlePhase.WaitingForOpponent -> "Waiting for opponent..."
                BattlePhase.WaitingForResult -> "Waiting for result..."
                Box(
                Button(
                Column(modifier = Modifier.verticalScroll(activityScrollState)) {
                FlowRow(
                HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
                Icon(
                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                IconButton(
                OutlinedButton(
                ReorderableItem {
                Row(
                Spacer(Modifier.height(12.dp))
                Spacer(Modifier.height(2.dp))
                Spacer(Modifier.height(8.dp))
                Spacer(Modifier.width(4.dp))
                Spacer(Modifier.width(8.dp))
                SplinterlandsModelRankings(modelStats)
                SplinterlandsModelRow(index + 1, stats)
                Text(
                Text("Cancel")
                Text(if (instanceIds.isEmpty()) "Add Service" else "Add Another Service")
                TextButton(
                VerticalScrollbarForScroll(
                addStatus = addStatus,
                availableServices = availableServices,
                coil3.compose.AsyncImage(
                color = MaterialTheme.colorScheme.error,
                color = MaterialTheme.colorScheme.onBackground,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                color = barColor,
                else -> ""
                enabled = !isTesting,
                enabled = username.isNotBlank() && postingKey.isNotBlank() && !isTesting,
                expanded = false
                expanded = showDropdown,
                for ((serviceId, status) in bs.serviceStatuses) {
                for (account in accounts) {
                for (entry in visibleEntries) {
                for (service in notYetAdded) {
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                if (account.energy >= 0) {
                if (battleLog.size > 5 && !showAll) {
                if (entry.activity.isNotEmpty()) {
                if (entry.mana > 0) add("${entry.mana} mana")
                if (entry.rulesets.isNotBlank()) add(entry.rulesets)
                if (entry.timestampMs > 0) {
                if (index > 0) Spacer(Modifier.height(6.dp))
                if (isTesting) {
                if (phaseText.isNotBlank()) {
                if (showLlmIndicator) {
                if (showTimer) {
                instanceIds = instanceIds,
                kotlinx.coroutines.delay(1.seconds)
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.handCursor(),
                modifier = Modifier.padding(start = 40.dp),
                modifier = Modifier.padding(start = 40.dp, top = 2.dp),
                modifier = Modifier.weight(1f),
                onAddService = onAddService,
                onClick = onDismiss,
                onClick = {
                onClick = { showConfirm = true },
                onClick = { showDropdown = true },
                onDismissRequest = { showDropdown = false },
                onRemoveService = onRemoveService,
                onReorderServices = onReorderServices,
                onReorderServices(reordered)
                onTestAndAdd = onTestAndAddAccount,
                overflow = TextOverflow.Ellipsis,
                remaining = ((deadlineMs - kotlin.time.Clock.System.now().toEpochMilliseconds()) / 1000).coerceAtLeast(0L)
                reordered.add(toIndex, reordered.removeAt(fromIndex))
                style = MaterialTheme.typography.bodySmall,
                style = MaterialTheme.typography.labelMedium,
                style = MaterialTheme.typography.labelSmall,
                text = "#$rank",
                text = "$winPct%",
                text = "${stats.wins}W ${stats.losses}L",
                text = addStatus.message,
                text = bs.errorMessage,
                text = stats.modelName,
                val reordered = instanceIds.toMutableList()
                val showLlmIndicator = bs.llmPickedTeam != null && bs.phase in setOf(
                val showTimer = bs.teamDeadlineMs > 0L && bs.phase in setOf(
                val visibleEntries = if (showAll) battleLog else battleLog.take(5)
                var showAll by remember { mutableStateOf(false) }
                verticalAlignment = Alignment.CenterVertically,
                }
                } else {
                },
            )
            ) {
            ) { Text("Close") }
            ),
            .fillMaxWidth()
            .padding(vertical = 3.dp)
            .then(
            // Account list
            // Add account form
            // Avatar
            // Battle log
            // Details row
            // Error indicator
            // Match info row: opponent, mana, rulesets
            // Model Rankings (below services)
            // Multi-service list
            // Per-service status rows during PickingTeam
            // Remove button with confirmation
            // Start/Stop button
            // Stats if any
            // Status row: phase + LLM indicator + timer
            // Username + energy
            Box {
            Button(
            Column(modifier = Modifier.weight(1f)) {
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
            Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
            IconButton(
            OutlinedButton(
            Row(
            Spacer(Modifier.height(12.dp))
            Spacer(Modifier.height(4.dp))
            Spacer(Modifier.width(4.dp))
            SplinterlandsAddAccountForm(
            SplinterlandsServiceList(
            Text(
            Text("Add Account")
            TextButton(
            androidx.compose.material3.DropdownMenu(
            checked = isEnabled,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
            description = "Splinterlands is a blockchain-based trading card game. This experimental feature auto-battles Wild Ranked matches using an LLM to pick teams. Battle outcome heavily depends on the chosen model and its response speed (must respond within 180 seconds). Falls back to a simple greedy picker if the LLM fails.",
            enabled = !isTesting,
            for ((index, stats) in modelStats.withIndex()) {
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            if (account.avatarUrl.isNotBlank()) {
            if (accounts.isNotEmpty()) {
            if (battleLog.isNotEmpty()) {
            if (bs.currentOpponent.isNotBlank() || bs.currentMana > 0) {
            if (bs.isRunning) {
            if (bs.phase == BattlePhase.Error) {
            if (bs.phase == BattlePhase.PickingTeam && bs.serviceStatuses.isNotEmpty()) {
            if (bs.wins > 0 || bs.losses > 0) {
            if (details.isNotEmpty() || entry.llmPicked != null || entry.account.isNotBlank()) {
            if (entry.battleId.isNotBlank()) {
            if (expanded && username.isEmpty() && postingKey.isEmpty()) {
            if (modelStats.isNotEmpty()) {
            if (showConfirm) {
            key(id) {
            label = { Text("Hive Username") },
            label = { Text("Posting Key") },
            list = instanceIds,
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.handCursor(),
            onCheckedChange = onToggle,
            onClick = { expanded = true },
            onSettle = { fromIndex, toIndex ->
            onValueChange = { postingKey = it },
            onValueChange = { username = it },
            singleLine = true,
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.labelMedium,
            text = "LLM Services (priority order)",
            text = "Your posting key is stored securely on this device and is never sent to the LLM. It is only used to sign battle transactions on the Hive blockchain.",
            title = "Splinterlands",
            trailingIcon = {
            val activityScrollState = rememberScrollState()
            val details = buildList {
            val modelStats = remember(battleLog) { computeModelStats(battleLog).toImmutableList() }
            val phaseText = when (bs.phase) {
            value = postingKey,
            value = username,
            var showConfirm by remember { mutableStateOf(false) }
            verticalAlignment = Alignment.CenterVertically,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            visualTransformation = if (showKey) VisualTransformation.None else PasswordVisualTransformation(),
            while (true) {
            }
            } else {
            },
        )
        ) {
        ) { index, id, _ ->
        ),
        // Battle details (below player row)
        // Error message
        Box {
        Column(modifier = Modifier.padding(10.dp)) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
        KaiOutlinedTextField(
        MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.35f)
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
        OutlinedButton(
        ReorderableColumn(
        Row(
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Spacer(Modifier.height(4.dp))
        Spacer(Modifier.height(8.dp))
        SplinterlandsActivityDialog(entry) { showActivity = false }
        Text(
        ToggleableHeadline(
        availableServices.filter { it.instanceId !in instanceIds }
        color = MaterialTheme.colorScheme.onBackground,
        color = bgColor,
        color = if (remaining <= 30) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
        colors = CardDefaults.outlinedCardColors(
        confirmButton = {
        days == 1L -> "1 day"
        else -> "$days days"
        else -> MaterialTheme.colorScheme.error
        hours < 24 -> "$hours hours"
        hours == 1L -> "1 hour"
        if (addStatus is SplinterlandsAddStatus.Error) {
        if (addStatus is SplinterlandsAddStatus.Idle) {
        if (bs.errorMessage.isNotBlank() && bs.phase == BattlePhase.Error) {
        if (bs.isRunning) {
        if (deadlineMs > 0L) {
        if (isEnabled) {
        minutes < 1 -> "just now"
        minutes < 60 -> "$minutes min"
        minutes == 1L -> "1 min"
        modifier = Modifier
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(10.dp),
        shape = RoundedCornerShape(8.dp),
        style = MaterialTheme.typography.labelMedium,
        text = "$mins:${secs.toString().padStart(2, '0')}",
        text = "Model Rankings",
        text = {
        title = { Text("Battle Activity") },
        var showDropdown by remember { mutableStateOf(false) }
        winPct >= 40 -> MaterialTheme.colorScheme.primary
        winPct >= 60 -> Color(0xFF4CAF50)
        }
        },
    )
    ) {
    // Add service dropdown
    // Collapse form after successful add
    AlertDialog(
    Column {
    Column(modifier = Modifier.fillMaxWidth()) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
    LaunchedEffect(addStatus) {
    LaunchedEffect(deadlineMs) {
    OutlinedCard(
    Spacer(Modifier.height(6.dp))
    Surface(
    Text(
    account: SplinterlandsAccountUiState,
    accounts: ImmutableList<SplinterlandsAccountUiState>,
    addStatus: SplinterlandsAddStatus,
    availableServices: ImmutableList<com.inspiredandroid.kai.data.ServiceEntry>,
    battleLog: ImmutableList<BattleLogEntry>,
    entry: BattleLogEntry,
    hasServices: Boolean,
    if (!expanded) {
    if (instanceIds.isNotEmpty()) {
    if (notYetAdded.isNotEmpty()) {
    if (showActivity) {
    instanceIds: ImmutableList<String>,
    isEnabled: Boolean,
    onAddService: (String) -> Unit,
    onClearBattleLog: () -> Unit,
    onDismiss: () -> Unit,
    onRemove: () -> Unit,
    onRemoveAccount: (String) -> Unit,
    onRemoveService: (String) -> Unit,
    onReorderServices: (List<String>) -> Unit,
    onStartBattle: () -> Unit,
    onStartBattle: (String) -> Unit,
    onStopBattle: () -> Unit,
    onStopBattle: (String) -> Unit,
    onTestAndAdd: (String, String) -> Unit,
    onTestAndAddAccount: (String, String) -> Unit,
    onToggle: (Boolean) -> Unit,
    return when {
    val barColor = when {
    val bgColor = if (entry.won) {
    val bs = account.battleStatus
    val days = hours / 24
    val diffMs = nowMs - timestampMs
    val hours = minutes / 60
    val isTesting = addStatus is SplinterlandsAddStatus.Testing
    val mins = remaining / 60
    val minutes = diffMs / 60_000
    val notYetAdded = remember(availableServices, instanceIds) {
    val secs = remaining % 60
    val serviceMap = remember(availableServices) { availableServices.associateBy { it.instanceId } }
    val uriHandler = LocalUriHandler.current
    val winPct = (stats.winRate * 100).toInt()
    var expanded by remember { mutableStateOf(false) }
    var postingKey by remember { mutableStateOf("") }
    var remaining by remember { mutableStateOf(0L) }
    var showActivity by remember { mutableStateOf(false) }
    var showKey by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    }
    } else {
) {
@Composable
@OptIn(kotlin.time.ExperimentalTime::class)
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.splinterlands.BattleLogEntry
import com.inspiredandroid.kai.splinterlands.BattlePhase
import com.inspiredandroid.kai.splinterlands.LlmServiceStatus
import com.inspiredandroid.kai.splinterlands.ModelStats
import com.inspiredandroid.kai.splinterlands.computeModelStats
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.icons.DragIndicator
import com.inspiredandroid.kai.ui.icons.Visibility
import com.inspiredandroid.kai.ui.icons.VisibilityOff
import kotlin.time.Duration.Companion.seconds
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import sh.calvin.reorderable.ReorderableColumn
internal fun SplinterlandsSection(
package com.inspiredandroid.kai.ui.settings
private fun SplinterlandsAccountRow(
private fun SplinterlandsActivityDialog(
private fun SplinterlandsAddAccountForm(
private fun SplinterlandsBattleLogRow(entry: BattleLogEntry) {
private fun SplinterlandsCountdown(deadlineMs: Long) {
private fun SplinterlandsModelRankings(modelStats: ImmutableList<ModelStats>) {
private fun SplinterlandsModelRow(rank: Int, stats: ModelStats) {
private fun SplinterlandsServiceList(
private fun formatRelativeTime(timestampMs: Long, nowMs: Long): String {
}
