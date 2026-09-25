package com.inspiredandroid.kai.ui.sandbox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.InsertDriveFile
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.formatFileSize
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import io.github.vinceglb.filekit.dialogs.FileKitType
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_files_action_delete
import kai.composeapp.generated.resources.sandbox_files_action_import
import kai.composeapp.generated.resources.sandbox_files_action_more
import kai.composeapp.generated.resources.sandbox_files_action_open_as_text
import kai.composeapp.generated.resources.sandbox_files_action_open_external
import kai.composeapp.generated.resources.sandbox_files_action_rename
import kai.composeapp.generated.resources.sandbox_files_delete_confirm
import kai.composeapp.generated.resources.sandbox_files_delete_message_directory
import kai.composeapp.generated.resources.sandbox_files_delete_message_file
import kai.composeapp.generated.resources.sandbox_files_delete_title
import kai.composeapp.generated.resources.sandbox_files_dialog_cancel
import kai.composeapp.generated.resources.sandbox_files_editor_binary_warning
import kai.composeapp.generated.resources.sandbox_files_editor_force_open_as_text
import kai.composeapp.generated.resources.sandbox_files_editor_open_externally
import kai.composeapp.generated.resources.sandbox_files_editor_read_only
import kai.composeapp.generated.resources.sandbox_files_editor_save
import kai.composeapp.generated.resources.sandbox_files_editor_too_large
import kai.composeapp.generated.resources.sandbox_files_editor_unreadable
import kai.composeapp.generated.resources.sandbox_files_empty_directory
import kai.composeapp.generated.resources.sandbox_files_rename_confirm
import kai.composeapp.generated.resources.sandbox_files_rename_label
import kai.composeapp.generated.resources.sandbox_files_rename_title
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

                            .clickable { onNavigateTo(target) }
                            .clip(RoundedCornerShape(4.dp))
                            .handCursor()
                            .padding(horizontal = 8.dp, vertical = 6.dp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            contentDescription = stringResource(Res.string.sandbox_files_action_import),
                            imageVector = Icons.Filled.FileUpload,
                            style = MaterialTheme.typography.bodySmall,
                            text = formatFileSize(entry.sizeBytes),
                        )
                        Icon(
                        Text(
                        Text(stringResource(Res.string.sandbox_files_editor_save))
                        color = MaterialTheme.colorScheme.onSurface,
                        color = MaterialTheme.colorScheme.primary,
                        enabled = editor.dirty,
                        expanded = false
                        maxLines = 1,
                        modifier = Modifier
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.padding(horizontal = 12.dp).size(20.dp),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                        onClick = onSave,
                        onOpenAsText()
                        onOpenExternal()
                        overflow = TextOverflow.Ellipsis,
                        strokeWidth = 2.dp,
                        style = MaterialTheme.typography.bodyLarge,
                        style = MaterialTheme.typography.bodyMedium,
                        text = editorFileName,
                        text = entry.name,
                        text = label,
                    )
                    ) {
                    .clickable(onClick = onClick)
                    .handCursor()
                    .padding(start = 12.dp, top = 10.dp, bottom = 10.dp, end = 4.dp),
                    .weight(1f)
                    CircularProgressIndicator(
                    IconButton(onClick = onImport, modifier = Modifier.handCursor()) {
                    Separator()
                    Text(
                    Text(stringResource(Res.string.sandbox_files_editor_force_open_as_text))
                    Text(stringResource(Res.string.sandbox_files_editor_open_externally))
                    TextButton(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = null,
                    editor = editor,
                    expanded = false
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    if (!entry.isDirectory) {
                    if (index > 0) Separator()
                    imageVector = if (entry.isDirectory) Icons.Filled.Folder else Icons.AutoMirrored.Filled.InsertDriveFile,
                    isDirectory = entry.isDirectory,
                    modifier = Modifier.handCursor(),
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                    null
                    onChange = viewModel::updateEditorContent,
                    onClick = {
                    onClick = { onOpenExternal(editor.path) },
                    onDelete = onDelete,
                    onDelete = viewModel::requestDelete,
                    onDelete()
                    onLoadAsText = viewModel::loadAsText,
                    onOpen = viewModel::openEntry,
                    onOpenAsText = onOpenAsText,
                    onOpenAsText = viewModel::openInEditor,
                    onOpenExternal = onOpenExternal,
                    onOpenExternal = viewModel::openInExternalApp,
                    onRename = onRename,
                    onRename = viewModel::requestRename,
                    onRename()
                    onSave = viewModel::save,
                    rootPath = rootPath,
                    state = state,
                    stringResource(Res.string.sandbox_files_editor_read_only),
                    style = MaterialTheme.typography.bodySmall,
                    text = { Text(stringResource(Res.string.sandbox_files_action_open_as_text)) },
                    text = { Text(stringResource(Res.string.sandbox_files_action_open_external)) },
                    tint = if (entry.isDirectory) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    { importLauncher.launch() }
                    }
                    },
                )
                ) {
                ),
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 2.dp),
                // Import targets the directory on screen, so it is offered only while
                // The counterpart: whatever the name says, read it here. Offered on
                // every file, since only the bytes can settle whether it is text.
                // the listing is what's visible.
                Column(modifier = Modifier.weight(1f)) {
                DropdownMenuItem(
                EditorBody(
                FileList(
                FileRowMenu(
                Icon(
                Res.string.sandbox_files_delete_message_directory
                Res.string.sandbox_files_delete_message_file
                Res.string.sandbox_files_editor_too_large,
                Spacer(Modifier.width(12.dp))
                Text(
                Text(stringResource(Res.string.sandbox_files_delete_confirm))
                Text(stringResource(Res.string.sandbox_files_dialog_cancel))
                Text(stringResource(Res.string.sandbox_files_editor_open_externally))
                Text(stringResource(Res.string.sandbox_files_rename_confirm))
                TextButton(
                TextButton(onClick = { onLoadAsText(path) }, modifier = Modifier.handCursor()) {
                color = MaterialTheme.colorScheme.error,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                colors = TextFieldDefaults.colors(
                contentDescription = stringResource(Res.string.sandbox_files_action_more),
                currentPath = state.currentPath,
                editor = state.editor,
                entry = entry,
                formatFileSize(editor.sizeBytes),
                horizontalArrangement = Arrangement.End,
                if (!editor.readOnly) {
                if (editorFileName != null) {
                if (importing) {
                imageVector = Icons.Filled.MoreVert,
                importing = state.importing,
                isError = state.error != null,
                label = { Text(stringResource(Res.string.sandbox_files_rename_label)) },
                modifier = Modifier
                modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                modifier = Modifier.fillMaxWidth().weight(1f),
                modifier = Modifier.handCursor(),
                modifier = Modifier.weight(1f).horizontalScroll(rememberScrollState()),
                onClick = {
                onClick = { onOpen(entry) },
                onDelete = { onDelete(entry) },
                onImport = if (state.editor == null && importLauncher != null) {
                onNavigateTo = viewModel::navigateTo,
                onOpenAsText = { onOpenAsText(entry.path) },
                onOpenExternal = { onOpenExternal(entry.path) },
                onRename = { onRename(entry) },
                onValueChange = onChange,
                onValueChange = onValueChange,
                readOnly = editor.readOnly,
                rootPath = rootPath,
                segments.forEachIndexed { index, (label, target) ->
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                stringResource(Res.string.sandbox_files_editor_unreadable),
                stringResource(Res.string.sandbox_files_empty_directory),
                style = MaterialTheme.typography.bodyMedium,
                supportingText = state.error?.let { res -> { Text(stringResource(res)) } },
                text = { Text(stringResource(Res.string.sandbox_files_action_delete)) },
                text = { Text(stringResource(Res.string.sandbox_files_action_rename)) },
                textStyle = TextStyle(fontFamily = FontFamily.Monospace),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                value = editor.current,
                value = state.input,
                verticalAlignment = Alignment.CenterVertically,
                }
                } else {
                },
            )
            ) {
            ),
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
            // A root is structure, not content — no rename/delete for the tree's own top.
            CircularProgressIndicator()
            DropdownMenuItem(
            FileRow(
            Icon(
            OutlinedTextField(
            PathBar(
            Row(
            Text(
            Text(state.error, color = MaterialTheme.colorScheme.error)
            Text(stringResource(messageRes))
            TextButton(onClick = onConfirm, modifier = Modifier.handCursor()) {
            TextButton(onClick = onDismiss, modifier = Modifier.handCursor()) {
            TextButton(onClick = { onOpenExternal(path) }, modifier = Modifier.handCursor()) {
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            entry = entry,
            expanded = expanded,
            hostState = snackbarHostState,
            if (!isDirectory) {
            if (editor == null) {
            if (editor.readOnly) {
            if (entry.path != rootPath && entry.path != SANDBOX_HOME_PATH) {
            if (file != null) viewModel.importFile(file)
            if (onImport != null) {
            if (onLoadAsText != null) {
            message = stringResource(
            message = stringResource(Res.string.sandbox_files_editor_binary_warning),
            message,
            modifier = Modifier
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp, vertical = 8.dp),
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.handCursor().padding(end = 4.dp),
            onClick = { expanded = true },
            onConfirm = viewModel::confirmDelete,
            onConfirm = viewModel::confirmRename,
            onDismiss = viewModel::cancelDelete,
            onDismiss = viewModel::cancelRename,
            onDismissRequest = { expanded = false },
            onLoadAsText = null,
            onLoadAsText = onLoadAsText,
            onOpenExternal = onOpenExternal,
            onValueChange = viewModel::updateRenameInput,
            path = editor.path,
            shape = RoundedCornerShape(16.dp),
            state = rename,
            style = MaterialTheme.typography.bodyMedium,
            val editor = state.editor
            val messageRes = if (entry.isDirectory) {
            verticalAlignment = Alignment.CenterVertically,
            }
            } else {
        )
        ) {
        ) { Snackbar(snackbarData = it) }
        // Only a non-UTF-8 file can be forced open: the decode is what failed, and a
        // a truncated buffer could not be edited without destroying the tail.
        // read-only lossy view is still useful. A too-large file has no such escape —
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        Column(Modifier.fillMaxSize()) {
        DeleteConfirmDialog(
        DropdownMenu(
        EditorState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        IconButton(
        RenameDialog(
        Row(
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        SnackbarHost(
        Spacer(Modifier.weight(1f))
        Text(
        border = kaiAdaptiveCardBorder(),
        built = "$built/$part"
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        color = MaterialTheme.colorScheme.surfaceVariant,
        colors = kaiAdaptiveCardColors(),
        confirmButton = {
        contentPadding = PaddingValues(vertical = 8.dp),
        crumbs += part to built
        dismissButton = {
        else -> null
        horizontalAlignment = Alignment.CenterHorizontally,
        is EditorState.Binary -> UnopenableFile(
        is EditorState.Binary -> editor.path
        is EditorState.Loaded -> Column(
        is EditorState.Loaded -> editor.path
        is EditorState.TooLarge -> UnopenableFile(
        is EditorState.TooLarge -> editor.path
        is EditorState.Unreadable -> Box(Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        is EditorState.Unreadable -> editor.path
        items(state.entries, key = { it.path }) { entry ->
        modifier = Modifier
        modifier = Modifier.fillMaxSize().padding(16.dp),
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier.padding(horizontal = 4.dp),
        null
        onDismissRequest = onDismiss,
        onPauseOrDispose { }
        rememberFilePickerLauncher(type = FileKitType.File()) { file ->
        return
        shape = RoundedCornerShape(8.dp),
        snackbarHostState.showSnackbar(getString(resource))
        style = MaterialTheme.typography.bodyMedium,
        text = "›",
        text = {
        title = { Text(stringResource(Res.string.sandbox_files_delete_title, entry.name)) },
        title = { Text(stringResource(Res.string.sandbox_files_rename_title)) },
        val resource = state.snackbarMessage ?: return@LaunchedEffect
        verticalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        viewModel.consumeSnackbar()
        viewModel.start(initialPath)
        }
        },
    )
    ) {
    // Paparazzi renders this without an Activity behind it, so the launcher — which
    // Re-list whenever the browser becomes visible — on sub-tab entry and when the
    // app returns to the foreground — so files the agent touched meanwhile show up.
    // registers an activity-result contract — can only be created for the real app.
    AlertDialog(
    Box {
    Box(modifier = modifier) {
    Card(
    Column(
    LaunchedEffect(state.snackbarMessage) {
    LazyColumn(
    LifecycleResumeEffect(initialPath) {
    Surface(
    Text(
    currentPath: String,
    editor: EditorState,
    editor: EditorState?,
    entry: SandboxFileEntry,
    for (part in currentPath.removePrefix(root).split("/").filter { it.isNotEmpty() }) {
    if (!currentPath.startsWith(root)) return crumbs
    if (state.entries.isEmpty()) {
    if (state.error != null) {
    if (state.loading && state.entries.isEmpty()) {
    importing: Boolean,
    initialPath: String = DEFAULT_INITIAL_PATH,
    isDirectory: Boolean,
    message: String,
    modifier: Modifier = Modifier,
    onChange: (String) -> Unit,
    onClick: () -> Unit,
    onConfirm: () -> Unit,
    onDelete: () -> Unit,
    onDelete: (SandboxFileEntry) -> Unit,
    onDismiss: () -> Unit,
    onImport: (() -> Unit)?,
    onLoadAsText: ((String) -> Unit)?,
    onLoadAsText: (String) -> Unit,
    onNavigateTo: (String) -> Unit,
    onOpen: (SandboxFileEntry) -> Unit,
    onOpenAsText: () -> Unit,
    onOpenAsText: (String) -> Unit,
    onOpenExternal: () -> Unit,
    onOpenExternal: (String) -> Unit,
    onRename: () -> Unit,
    onRename: (SandboxFileEntry) -> Unit,
    onSave: () -> Unit,
    onValueChange: (String) -> Unit,
    path: String,
    return crumbs
    rootPath: String = DEFAULT_ROOT_PATH,
    rootPath: String,
    state.pendingDelete?.let { entry ->
    state.renaming?.let { rename ->
    state: FileBrowserUiState,
    state: RenameState,
    val crumbs = mutableListOf(rootLabel to root.ifEmpty { "/" })
    val editorFileName = remember(editorPath) { editorPath?.substringAfterLast('/') }
    val editorPath = when (editor) {
    val importLauncher = if (!LocalInspectionMode.current) {
    val root = rootPath.trimEnd('/')
    val rootLabel = root.substringAfterLast('/').ifEmpty { "/" }
    val segments = remember(currentPath, rootPath) { breadcrumbs(currentPath, rootPath) }
    val snackbarHostState = remember { SnackbarHostState() }
    val state by viewModel.state.collectAsStateWithLifecycle()
    var built = root
    var expanded by remember { mutableStateOf(false) }
    viewModel: SandboxFileBrowserViewModel = koinViewModel(),
    when (editor) {
    }
    } else {
 *
 * File browser over any [FileBrowserSource]-backed environment.
 * Label/target pairs from [rootPath] down to [currentPath]. The root is always the
 * The editor's fallback surface. [onLoadAsText] is null when there is no safe way to
 * [initialPath] is where it opens; [rootPath] is the highest directory the user
 * can reach from there — breadcrumbs stop at it, and it cannot be renamed or
 * deleted from its own row. Both surfaces browse the whole tree today and only
 * differ in where they start.
 * first crumb and nothing above it is offered — the breadcrumbs are the only way
 * show the bytes, which drops the button rather than offering one that cannot work.
 * up, so this is what keeps a project-scoped browser inside its project.
 */
) {
/**
/** The chat sandbox's home: listed as an entry at "/", and protected there like a root. */
@Composable
fun SandboxFilesContent(
internal fun breadcrumbs(currentPath: String, rootPath: String): List<Pair<String, String>> {
private const val DEFAULT_INITIAL_PATH = "/root"
private const val DEFAULT_ROOT_PATH = "/"
private const val SANDBOX_HOME_PATH = "/root"
private fun DeleteConfirmDialog(
private fun EditorBody(
private fun FileList(
private fun FileRow(
private fun FileRowMenu(
private fun PathBar(
private fun RenameDialog(
private fun Separator() {
private fun UnopenableFile(
}
