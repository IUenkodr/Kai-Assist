import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.KAI_BUILD_FILES
import com.inspiredandroid.kai.PlatformBackHandler
import com.inspiredandroid.kai.build.BuildAgents
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.sandbox.SandboxFilesContent
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_exit_content_description
import kai.composeapp.generated.resources.kai_build_new_project_content_description
import kai.composeapp.generated.resources.kai_build_title
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

                                        Res.string.kai_build_new_project_content_description,
                                    ),
                                    contentDescription = stringResource(
                                    imageVector = Icons.Default.Add,
                                )
                                Icon(
                                key = KAI_BUILD_FILES_KEY,
                                modifier = Modifier.handCursor(),
                                onClick = { showCreateProject = true },
                                qualifier = KAI_BUILD_FILES,
                            ) {
                            ),
                            // Opens on the project, but browses the whole Debian tree
                            // This surface is full-screen, so nothing else keeps the
                            // a breadcrumb away rather than shell-only.
                            // soft keyboard off the editor's text field.
                            // the way the chat sandbox does — agent config and /etc are
                            IconButton(
                            initialPath = "$PROJECTS_GUEST_DIR/$project",
                            modifier = Modifier.fillMaxSize().imePadding(),
                            viewModel = koinViewModel(
                            }
                        )
                        SandboxFilesContent(
                        actions.selectSession(id)
                        actions.startSession(agentId)
                        filesOpen = false
                        if (state.build.isReady) {
                        installedAgents = installedAgents,
                        launchAgentId = state.launchAgentId,
                        onCancel = actions.cancel,
                        onDeleteProject = actions.deleteProject,
                        onInstall = actions.install,
                        onInstallAgent = actions.installAgent,
                        onKey = actions.sendKey,
                        onMouse = actions.sendMouse,
                        onOpenProject = actions.openProject,
                        onRenameProject = actions.renameProject,
                        onResize = actions.resizeTerminal,
                        onSelectLaunchAgent = actions.setLaunchAgent,
                        onSubmitLine = actions.submitLine,
                        onText = actions.sendText,
                        onToggleAgent = actions.toggleAgent,
                        onUninstall = actions.uninstall,
                        selectedAgents = state.selectedAgents,
                        session = session,
                        state = state.build,
                        }
                    )
                    ?: sessions.firstOrNull()
                    BuildProjectsContent(
                    BuildSetupContent(
                    actions = {
                    activeSessionId = state.build.activeSessionId,
                    filesOpen -> {
                    filesSelected = filesOpen,
                    installedAgents = installedAgents,
                    onBack = actions.closeProject,
                    onCloseSession = actions.closeSession,
                    onExit = onExit,
                    onNewSession = { agentId ->
                    onSelectFiles = { filesOpen = true },
                    onSelectSession = { id ->
                    session != null -> BuildTerminalContent(
                    sessions = sessions,
                    state.build.sessions.filter { it.project == project }.toImmutableList()
                    title = stringResource(Res.string.kai_build_title),
                    }
                    },
                )
                .fillMaxSize()
                .navigationBarsPadding(),
                .statusBarsPadding()
                // Fall back to the project's first tab: the active id can briefly point
                // elsewhere while a session is being closed.
                BuildSessionBar(
                KaiBuildTopBar(
                actions.createProject(name)
                contentDescription = stringResource(Res.string.kai_build_exit_content_description),
                if (state.build.isReady) {
                imageVector = Icons.Default.Close,
                showCreateProject = false
                val session = sessions.firstOrNull { it.id == state.build.activeSessionId }
                val sessions = remember(state.build.sessions, project) {
                when {
                }
                } else {
            )
            Icon(
            cancel = viewModel::cancel,
            closeProject = viewModel::closeProject,
            closeSession = viewModel::closeSession,
            color = MaterialTheme.colorScheme.onBackground,
            createProject = viewModel::createProject,
            deleteProject = viewModel::deleteProject,
            else -> onExit()
            filesOpen -> filesOpen = false
            if (project != null) {
            install = viewModel::install,
            installAgent = viewModel::installAgent,
            maxLines = 1,
            modifier = Modifier
            modifier = Modifier.weight(1f).padding(end = 8.dp),
            onCreate = { name ->
            onDismiss = { showCreateProject = false },
            openProject = viewModel::openProject,
            overflow = TextOverflow.Ellipsis,
            project != null -> actions.closeProject()
            renameProject = viewModel::renameProject,
            resizeTerminal = viewModel::resizeTerminal,
            selectSession = viewModel::selectSession,
            sendKey = viewModel::sendKey,
            sendMouse = viewModel::sendMouse,
            sendText = viewModel::sendText,
            setLaunchAgent = viewModel::setLaunchAgent,
            startSession = viewModel::startSession,
            style = MaterialTheme.typography.titleMedium,
            submitLine = viewModel::submitLine,
            text = title,
            toggleAgent = viewModel::toggleAgent,
            uninstall = viewModel::uninstall,
            }
            } else {
            },
        )
        ) {
        BuildAgents.all.filter { it.id in state.build.installedAgents }.toImmutableList()
        Column(
        CreateProjectDialog(
        IconButton(onClick = onExit, modifier = Modifier.handCursor()) {
        KaiBuildActions(
        Text(
        actions()
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxWidth(),
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        when {
        }
    ) {
    // Files is a view of the project, not a session — it resets when the project does.
    // Surface, not just a background modifier: it also provides the matching
    // content color, which is what keeps the bare icons legible in dark mode.
    KaiBuildScreenContent(state = state, actions = actions, onExit = onExit, modifier = modifier)
    PlatformBackHandler(enabled = true) {
    Row(
    Surface(
    actions: @Composable RowScope.() -> Unit = {},
    actions: KaiBuildActions,
    if (showCreateProject) {
    modifier: Modifier = Modifier,
    onExit: () -> Unit,
    state: KaiBuildUiState,
    title: String,
    val actions = remember(viewModel) {
    val cancel: () -> Unit,
    val closeProject: () -> Unit,
    val closeSession: (String) -> Unit,
    val createProject: (String) -> Unit,
    val deleteProject: (String) -> Unit,
    val install: () -> Unit,
    val installAgent: (String) -> Unit,
    val installedAgents = remember(state.build.installedAgents) {
    val openProject: (String) -> Unit,
    val project = state.openProject
    val renameProject: (name: String, newName: String) -> Unit,
    val resizeTerminal: (columns: Int, rows: Int) -> Unit,
    val selectSession: (String) -> Unit,
    val sendKey: (TerminalKey, TerminalModifiers) -> Unit,
    val sendMouse: (String) -> Unit,
    val sendText: (String, TerminalModifiers) -> Unit,
    val setLaunchAgent: (String?) -> Unit,
    val startSession: (String?) -> Unit,
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val submitLine: (String) -> Unit,
    val toggleAgent: (String) -> Unit,
    val uninstall: () -> Unit,
    var filesOpen by rememberSaveable(project) { mutableStateOf(false) }
    var showCreateProject by rememberSaveable { mutableStateOf(false) }
    viewModel: KaiBuildViewModel = koinViewModel(),
    }
 *
 * Full-screen Kai Build surface. Entered from the empty chat state and left via
 * Keeps Kai Build's browser out of the chat sandbox's ViewModel slot: same class,
 * One screen, three states: set up Linux, pick a project, work in its terminal.
 * same store owner, so without a distinct key they would share one instance.
 * so it never becomes a navigation destination of its own.
 * the top-bar close button or system back — same shape as Interactive UI mode,
 */
)
) {
/**
/** Where Debian mounts the project folders — the browser's root inside a project. */
@Composable
@Immutable
data class KaiBuildActions(
fun KaiBuildScreen(
internal fun KaiBuildScreenContent(
package com.inspiredandroid.kai.ui.build
private const val KAI_BUILD_FILES_KEY = "kaiBuildFiles"
private const val PROJECTS_GUEST_DIR = "/root/projects"
private fun KaiBuildTopBar(
}
