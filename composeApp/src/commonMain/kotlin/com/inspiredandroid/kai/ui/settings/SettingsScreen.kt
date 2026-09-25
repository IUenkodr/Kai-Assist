package com.inspiredandroid.kai.ui.settings
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.BackIcon
import com.inspiredandroid.kai.Version
import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForScroll
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.github_mark
import kai.composeapp.generated.resources.settings_ai_mistakes_warning
import kai.composeapp.generated.resources.settings_documentation
import kai.composeapp.generated.resources.settings_tab_agent
import kai.composeapp.generated.resources.settings_tab_general
import kai.composeapp.generated.resources.settings_tab_integrations
import kai.composeapp.generated.resources.settings_tab_sandbox
import kai.composeapp.generated.resources.settings_tab_services
import kai.composeapp.generated.resources.settings_tab_tools
import kai.composeapp.generated.resources.settings_version
import kai.composeapp.generated.resources.snackbar_email_removed
import kai.composeapp.generated.resources.snackbar_mcp_server_removed
import kai.composeapp.generated.resources.snackbar_memory_deleted
import kai.composeapp.generated.resources.snackbar_service_removed
import kai.composeapp.generated.resources.snackbar_skill_removed
import kai.composeapp.generated.resources.snackbar_task_cancelled
import kai.composeapp.generated.resources.snackbar_undo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

                                    browsableSkills = filteredUiState.browsableSkills,
                                    browseSkillsFailed = filteredUiState.browseSkillsFailed,
                                    isBrowsingSkills = filteredUiState.isBrowsingSkills,
                                    isInstallingSkill = filteredUiState.isInstallingSkill,
                                    isSandboxInstalled = sandboxState.sandboxInstalled,
                                    mcpServers = filteredUiState.mcpServers,
                                    onAddMcpServer = actions.onAddMcpServer,
                                    onAddPopularMcpServer = actions.onAddPopularMcpServer,
                                    onCancelSandbox = onCancelSandbox,
                                    onInstallBrowsedSkill = actions.onInstallBrowsedSkill,
                                    onInstallGitHubSkill = actions.onInstallGitHubSkill,
                                    onInstallPackages = onInstallPackages,
                                    onMigrateHome = onMigrateHome,
                                    onNavigateToSandbox = { actions.onSelectTab(SettingsTab.Sandbox) },
                                    onRefreshMcpServer = actions.onRefreshMcpServer,
                                    onRemoveMcpServer = actions.onRemoveMcpServer,
                                    onResetSandbox = onResetSandbox,
                                    onSelectDistro = onSelectDistro,
                                    onSetupSandbox = onSetupSandbox,
                                    onShowAddMcpServerDialog = actions.onShowAddMcpServerDialog,
                                    onShowAddSkillDialog = actions.onShowAddSkillDialog,
                                    onToggleMcpServer = actions.onToggleMcpServer,
                                    onToggleSandbox = onToggleSandbox,
                                    onToggleTool = actions.onToggleTool,
                                    onUninstallSkill = actions.onUninstallSkill,
                                    sandboxState = sandboxState,
                                    showAddMcpServerDialog = filteredUiState.showAddMcpServerDialog,
                                    showAddSkillDialog = filteredUiState.showAddSkillDialog,
                                    showSkills = sandboxState.showSandbox,
                                    skillInstallError = filteredUiState.skillInstallError,
                                    skills = filteredUiState.skills,
                                    tools = filteredUiState.tools,
                                )
                                AgentContent(uiState = filteredUiState, actions = actions)
                                GeneralContent(uiState = filteredUiState, actions = actions)
                                IntegrationsContent()
                                SandboxSettingsCard(
                                ServicesContent(uiState = filteredUiState, actions = actions)
                                ToolsContent(
                            SettingsTab.Agent -> stringResource(Res.string.settings_tab_agent)
                            SettingsTab.Agent -> {
                            SettingsTab.General -> stringResource(Res.string.settings_tab_general)
                            SettingsTab.General -> {
                            SettingsTab.Integrations -> stringResource(Res.string.settings_tab_integrations)
                            SettingsTab.Integrations -> {
                            SettingsTab.Sandbox -> stringResource(Res.string.settings_tab_sandbox)
                            SettingsTab.Sandbox -> {
                            SettingsTab.Services -> stringResource(Res.string.settings_tab_services)
                            SettingsTab.Services -> {
                            SettingsTab.Tools -> stringResource(Res.string.settings_tab_tools)
                            SettingsTab.Tools -> {
                            tabBounds[tab] = start..(start + coordinates.size.width)
                            val start = coordinates.positionInParent().x.toInt()
                            }
                        .clickable { onSelectTab(tab) },
                        .clip(RoundedCornerShape(50))
                        .handCursor()
                        .onGloballyPositioned { coordinates ->
                        Color.Transparent
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        Modifier.widthIn(max = maxContentWidth).fillMaxWidth().padding(horizontal = 16.dp),
                        SettingsTab.Services -> 500.dp
                        Spacer(Modifier.height(16.dp))
                        color = MaterialTheme.colorScheme.primary,
                        else -> 900.dp
                        horizontalAlignment = CenterHorizontally,
                        maxLines = 1,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.labelLarge,
                        text = when (tab) {
                        when (filteredUiState.currentTab) {
                        }
                        },
                    )
                    ) {
                    BottomInfo()
                    Column(
                    Modifier.fillMaxWidth().verticalScroll(settingsScrollState),
                    Spacer(Modifier.height(16.dp))
                    Spacer(Modifier.weight(1f))
                    Text(
                    color = if (isSelected) {
                    content = end,
                    content = start,
                    horizontalAlignment = CenterHorizontally,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 64.dp),
                    modifier = Modifier.weight(1f),
                    navigationTabBar()
                    scrollState = settingsScrollState,
                    shape = RoundedCornerShape(50),
                    uriHandler.openUri("https://github.com/SimonSchubert/Kai")
                    val maxContentWidth = when (filteredUiState.currentTab) {
                    verticalAlignment = CenterVertically,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    }
                    } else {
                    },
                )
                ) {
                .align(Alignment.CenterVertically)
                .clickable { uriHandler.openUri("https://kai9000.com/docs/") }
                .clickable(onClick = {
                .clip(CircleShape)
                .fillMaxWidth()
                .handCursor(),
                .horizontalScroll(scrollState),
                .onSizeChanged { viewportWidth = it.width }
                .padding(4.dp)
                .size(24.dp)
                .then(if (innerPadding) Modifier.padding(16.dp) else Modifier),
                .then(if (onClick != null) Modifier.clickable(onClick = onClick).handCursor() else Modifier)
                Column(
                Row(
                SettingsTab.entries.filter { it != SettingsTab.Sandbox || sandboxState.showSandbox }.toImmutableList()
                Surface(
                TopBar(onNavigateBack = onNavigateBack)
                VerticalScrollbarForScroll(
                contentDescription = null,
                currentTab = filteredUiState.currentTab,
                end()
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                imageVector = BackIcon,
                indication = null,
                interactionSource = switchInteractionSource,
                modifier = Modifier.fillMaxWidth(),
                onSelectTab = actions.onSelectTab,
                start()
                tabs = visibleTabs,
                tint = MaterialTheme.colorScheme.onBackground,
                val isSelected = currentTab == tab
                viewModel.onScreenVisible()
                }
                })
            )
            ) {
            ) { onCheckedChange(!checked) }
            .clickable(
            .fillMaxWidth()
            .handCursor(),
            Box(Modifier.weight(1f).fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Icon(
            Row(
            SettingsTabSelector(
            Snackbar(snackbarData = data)
            actionLabel = undoLabel,
            actions.onUndoDelete()
            bounds.first < scrollState.value -> bounds.first
            bounds.last > scrollState.value + viewportWidth -> bounds.last - viewportWidth
            checked = checked,
            color = MaterialTheme.colorScheme.onBackground,
            color = MaterialTheme.colorScheme.primary,
            configuredServices = filteredServices,
            content()
            contentDescription = null,
            duration = SnackbarDuration.Short,
            else -> return@LaunchedEffect
            emailAccounts = filteredEmailAccounts,
            hostState = snackbarHostState,
            if (event == androidx.lifecycle.Lifecycle.Event.ON_RESUME) {
            if (navigationTabBar != null) {
            interactionSource = switchInteractionSource,
            is PendingDeletion.EmailAccount -> emailRemovedMsg
            is PendingDeletion.McpServer -> mcpServerRemovedMsg
            is PendingDeletion.Memory -> memoryDeletedMsg
            is PendingDeletion.Service -> serviceRemovedMsg
            is PendingDeletion.Skill -> skillRemovedMsg
            is PendingDeletion.Task -> taskCancelledMsg
            mcpServers = filteredMcpServers,
            memories = filteredMemories,
            message = message,
            modifier = Modifier
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp),
            modifier = Modifier.align(Alignment.CenterVertically),
            modifier = Modifier.handCursor(),
            modifier = Modifier.weight(1f),
            onCheckedChange = null,
            onClick = onNavigateBack,
            painter = painterResource(Res.drawable.github_mark),
            scheduledTasks = filteredTasks,
            skills = filteredSkills,
            stringResource(Res.string.settings_version, Version.appVersion),
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.titleMedium,
            tabs.forEach { tab ->
            text = stringResource(Res.string.settings_documentation),
            text = title,
            tint = MaterialTheme.colorScheme.onBackground,
            val settingsScrollState = rememberScrollState()
            val visibleTabs = remember(sandboxState.showSandbox) {
            }
            } else {
        )
        ) {
        ) { data ->
        Column(
        Column(Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        Icon(
        IconButton(
        Row(
        SnackbarHost(
        Spacer(Modifier.weight(1f))
        Switch(
        Text(
        actions = viewModel.actions,
        actions()
        border = kaiAdaptiveCardBorder(),
        color = Color.Transparent,
        color = MaterialTheme.colorScheme.onBackground,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        colors = kaiAdaptiveCardColors(),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        if (maxWidth >= 600.dp) {
        if (pendingDeletion is PendingDeletion.EmailAccount) uiState.emailAccounts.filter { it.id != pendingDeletion.id }.toImmutableList() else uiState.emailAccounts
        if (pendingDeletion is PendingDeletion.McpServer) uiState.mcpServers.filter { it.id != pendingDeletion.serverId }.toImmutableList() else uiState.mcpServers
        if (pendingDeletion is PendingDeletion.Memory) uiState.memories.filter { it.key != pendingDeletion.key }.toImmutableList() else uiState.memories
        if (pendingDeletion is PendingDeletion.Service) uiState.configuredServices.filter { it.instanceId != pendingDeletion.instanceId }.toImmutableList() else uiState.configuredServices
        if (pendingDeletion is PendingDeletion.Skill) uiState.skills.filter { it.id != pendingDeletion.id }.toImmutableList() else uiState.skills
        if (pendingDeletion is PendingDeletion.Task) uiState.scheduledTasks.filter { it.id != pendingDeletion.id }.toImmutableList() else uiState.scheduledTasks
        if (result == SnackbarResult.ActionPerformed) {
        if (viewportWidth == 0) return@LaunchedEffect
        lifecycleOwner.lifecycle.addObserver(observer)
        modifier = Modifier
        modifier = Modifier.padding(horizontal = 16.dp),
        modifier = Modifier.widthIn(max = 900.dp).fillMaxWidth().padding(vertical = 8.dp),
        modifier = modifier,
        navigationTabBar = navigationTabBar,
        onCancelSandbox = sandboxViewModel::onCancelSandbox,
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
        onInstallPackages = sandboxViewModel::onInstallPackages,
        onMigrateHome = sandboxViewModel::onMigrateHome,
        onNavigateBack = onNavigateBack,
        onResetSandbox = sandboxViewModel::onResetSandbox,
        onSelectDistro = sandboxViewModel::onSelectDistro,
        onSetupSandbox = sandboxViewModel::onSetupSandbox,
        onToggleSandbox = sandboxViewModel::onToggleSandbox,
        sandboxState = sandboxState,
        scrollState.animateScrollTo(target.coerceIn(0, scrollState.maxValue))
        snackbarHostState.currentSnackbarData?.dismiss()
        style = MaterialTheme.typography.bodySmall,
        text = description,
        text = stringResource(Res.string.settings_ai_mistakes_warning),
        textAlign = TextAlign.Center,
        uiState = uiState,
        uiState.copy(
        val bounds = tabBounds[currentTab] ?: return@LaunchedEffect
        val deletion = uiState.pendingDeletion ?: return@LaunchedEffect
        val message = when (deletion) {
        val observer = androidx.lifecycle.LifecycleEventObserver { _, event ->
        val result = snackbarHostState.showSnackbar(
        val target = when {
        verticalAlignment = Alignment.CenterVertically,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        }
        } else {
    )
    ) {
    // (Services) sits far enough along that it opens half off the right edge. Track
    // FlowRow, not Row: at large font scales the three items no longer fit on one
    // The strip is wider than the screen at large font scales, and the default tab
    // each pill's bounds so the selected one can be scrolled into view.
    // line, and a Row would squeeze the documentation link into a column of single
    // words that runs off the bottom of the screen.
    Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).navigationBarsPadding().statusBarsPadding().imePadding()) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
    Card(
    FlowRow(
    LaunchedEffect(currentTab, viewportWidth, tabBounds[currentTab]) {
    LaunchedEffect(uiState.pendingDeletion) {
    Row {
    Row(
    SettingsScreenContent(
    Spacer(Modifier.height(8.dp))
    Spacer(Modifier.size(4.dp))
    Surface(
    Text(
    actions: @Composable RowScope.() -> Unit = {},
    actions: SettingsActions = SettingsActions.NoOp,
    androidx.compose.runtime.DisposableEffect(lifecycleOwner) {
    checked: Boolean,
    content: @Composable () -> Unit,
    currentTab: SettingsTab,
    description: String,
    end: @Composable ColumnScope.() -> Unit,
    innerPadding: Boolean = true,
    modifier: Modifier = Modifier,
    navigationTabBar: (@Composable () -> Unit)? = null,
    onCancelSandbox: () -> Unit = {},
    onCheckedChange: (Boolean) -> Unit,
    onClick: (() -> Unit)? = null,
    onInstallPackages: () -> Unit = {},
    onMigrateHome: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    onNavigateBack: () -> Unit,
    onResetSandbox: () -> Unit = {},
    onSelectDistro: (LinuxDistro) -> Unit = {},
    onSelectTab: (SettingsTab) -> Unit,
    onSetupSandbox: () -> Unit = {},
    onToggleSandbox: (Boolean) -> Unit = {},
    sandboxState: SandboxUiState = SandboxUiState(),
    sandboxViewModel: SandboxViewModel = koinViewModel(),
    start: @Composable ColumnScope.() -> Unit,
    tabs: ImmutableList<SettingsTab>,
    title: String,
    uiState: SettingsUiState,
    val emailRemovedMsg = stringResource(Res.string.snackbar_email_removed)
    val filteredEmailAccounts = remember(uiState.emailAccounts, pendingDeletion) {
    val filteredMcpServers = remember(uiState.mcpServers, pendingDeletion) {
    val filteredMemories = remember(uiState.memories, pendingDeletion) {
    val filteredServices = remember(uiState.configuredServices, pendingDeletion) {
    val filteredSkills = remember(uiState.skills, pendingDeletion) {
    val filteredTasks = remember(uiState.scheduledTasks, pendingDeletion) {
    val filteredUiState = remember(uiState, filteredMemories, filteredTasks, filteredEmailAccounts, filteredServices, filteredMcpServers, filteredSkills) {
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val mcpServerRemovedMsg = stringResource(Res.string.snackbar_mcp_server_removed)
    val memoryDeletedMsg = stringResource(Res.string.snackbar_memory_deleted)
    val pendingDeletion = uiState.pendingDeletion
    val sandboxState by sandboxViewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    val serviceRemovedMsg = stringResource(Res.string.snackbar_service_removed)
    val skillRemovedMsg = stringResource(Res.string.snackbar_skill_removed)
    val snackbarHostState = remember { SnackbarHostState() }
    val switchInteractionSource = remember { MutableInteractionSource() }
    val tabBounds = remember { mutableStateMapOf<SettingsTab, IntRange>() }
    val taskCancelledMsg = stringResource(Res.string.snackbar_task_cancelled)
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val undoLabel = stringResource(Res.string.snackbar_undo)
    val uriHandler = LocalUriHandler.current
    var viewportWidth by remember { mutableStateOf(0) }
    viewModel: SettingsViewModel = koinViewModel(),
    }
 *
 * Each section is declared exactly once. [start] and [end] are the two columns a window of at
 * The two-column-on-wide, one-column-on-narrow arrangement the settings tabs share.
 * argument lists, so the branch lives here and the tabs only say what goes in which column.
 * least 600.dp gets; below that they run into a single column, [start] first. Writing a tab as
 * two independent branches instead is what let the same section drift into two different
 */
) {
/**
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
fun SettingsScreen(
fun SettingsScreenContent(
internal fun SettingsCard(
internal fun StaggeredSettingsColumns(
internal fun ToggleableHeadline(
internal val StatusColorChecking = Color(0xFFFF9800)
internal val StatusColorConnected = Color(0xFF4CAF50)
internal val StatusColorError = Color(0xFFF44336)
internal val StatusColorUnknown = Color(0xFF9E9E9E)
private fun BottomInfo() {
private fun SettingsTabSelector(
private fun TopBar(onNavigateBack: () -> Unit) {
}
