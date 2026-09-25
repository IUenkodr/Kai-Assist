import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.FileBrowserSource
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.TextFileResult
import io.github.vinceglb.filekit.PlatformFile
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_files_delete_failed
import kai.composeapp.generated.resources.sandbox_files_delete_success
import kai.composeapp.generated.resources.sandbox_files_editor_closed_after_delete
import kai.composeapp.generated.resources.sandbox_files_import_failed
import kai.composeapp.generated.resources.sandbox_files_import_success
import kai.composeapp.generated.resources.sandbox_files_open_failed
import kai.composeapp.generated.resources.sandbox_files_rename_error_collision
import kai.composeapp.generated.resources.sandbox_files_rename_error_invalid
import kai.composeapp.generated.resources.sandbox_files_rename_failed
import kai.composeapp.generated.resources.sandbox_files_rename_success
import kai.composeapp.generated.resources.sandbox_files_save_failed
import kai.composeapp.generated.resources.sandbox_files_save_success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource

                                renaming = null,
                                snackbarMessage = Res.string.sandbox_files_rename_failed,
                            )
                            editor = updatedEditor,
                            it.copy(
                            it.copy(renaming = rename.copy(error = errorRes))
                            renaming = null,
                            snackbarMessage = Res.string.sandbox_files_rename_success,
                        )
                        EditorState.Binary(newPath)
                        Res.string.sandbox_files_import_failed
                        Res.string.sandbox_files_import_success
                        _state.update {
                        e is IllegalArgumentException -> Res.string.sandbox_files_rename_error_invalid
                        editor
                        editor = editor.copy(original = editor.current),
                        editor = if (editorClosed) null else it.editor,
                        editor.copy(path = newPath)
                        else -> null
                        it.copy(
                        message == "collision" -> Res.string.sandbox_files_rename_error_collision
                        snackbarMessage = Res.string.sandbox_files_save_success,
                        snackbarMessage = snackbar,
                        }
                    )
                    Res.string.sandbox_files_delete_success
                    Res.string.sandbox_files_editor_closed_after_delete
                    _state.update {
                    if (errorRes != null) {
                    importing = false,
                    it.copy(
                    it.copy(renaming = rename.copy(error = Res.string.sandbox_files_rename_error_invalid))
                    refreshCurrent()
                    snackbarMessage = if (result.isSuccess) {
                    val editor = _state.value.editor
                    val errorRes = when {
                    val message = e.message
                    val updatedEditor = if (editor is EditorState.Loaded && editor.path == entry.path) {
                    }
                    } else if (editor is EditorState.Binary && editor.path == entry.path) {
                    } else {
                    },
                )
                // Navigated away while listing — the newer load owns the state.
                // No app took it: the editor still says something useful about why.
                _state.update {
                _state.update { it.copy(renaming = null) }
                _state.update { it.copy(snackbarMessage = Res.string.sandbox_files_delete_failed) }
                _state.update { it.copy(snackbarMessage = Res.string.sandbox_files_open_failed) }
                _state.update { it.copy(snackbarMessage = Res.string.sandbox_files_save_failed) }
                current = result.content,
                else -> it.copy(entries = entries, loading = false)
                if (result.isSuccess) return@launch
                it
                it.copy(
                it.copy(editor = latest.copy(original = text, current = text))
                it.currentPath != path -> it
                onFailure = { e ->
                onSuccess = { newPath ->
                original = result.content,
                path = path,
                readOnly = !result.editable,
                refreshCurrent()
                silent && it.entries == entries -> it
                state
                state.copy(editor = editor.copy(current = content))
                val editor = _state.value.editor
                val editorClosed = editorPath != null && editorPath == entry.path
                val editorPath = editorPathOf(editor)
                val result = files.openFile(entry.path)
                val snackbar = if (editorClosed) {
                }
                } else {
                },
            )
            // The listing only gains a row when the import landed in the directory the
            // user is still looking at; refreshCurrent is a no-op otherwise.
            TextFileResult.Binary -> EditorState.Binary(path)
            TextFileResult.Unreadable -> EditorState.Unreadable(path)
            _state.update {
            if (editor is EditorState.Loaded && !editor.readOnly) {
            if (ext in EXTERNAL_EXTENSIONS) {
            if (latest is EditorState.Loaded && latest.path == editor.path && !latest.dirty) {
            if (newName == entry.name) {
            if (ok) {
            if (result.isFailure) {
            if (result.isSuccess) refreshCurrent()
            is TextFileResult.Text -> EditorState.Loaded(
            is TextFileResult.TooLarge -> EditorState.TooLarge(path, result.sizeBytes)
            loadInEditor(entry.path)
            loadInEditor(path, force = true)
            navigateTo(entry.path)
            navigateTo(normalized)
            newName == "." || newName == ".."
            newName.contains('/') || newName.contains('\\') ||
            refreshCurrent(silent = true)
            reloadEditorIfClean()
            result.fold(
            return
            state.copy(renaming = rename.copy(input = value, error = null))
            val editor = state.editor
            val ext = entry.name.substringAfterLast('.', "").lowercase()
            val latest = it.editor
            val ok = files.deleteEntry(entry.path, recursive = entry.isDirectory)
            val ok = files.writeTextFile(editor.path, editor.current)
            val rename = state.renaming ?: return@update state
            val result = files.importFile(directory, source)
            val result = files.openFile(path)
            val result = files.renameEntry(entry.path, newName)
            when {
            }
            } else {
        ) {
        // Already showing this directory: keep the entries on screen and re-list
        // underneath, so re-tapping a breadcrumb doesn't flash a spinner.
        _state.update {
        _state.update { it.copy(currentPath = normalized, loading = !samePath, error = null, editor = null) }
        _state.update { it.copy(editor = EditorState.Loading) }
        _state.update { it.copy(editor = editor) }
        _state.update { it.copy(importing = true) }
        _state.update { it.copy(pendingDelete = entry) }
        _state.update { it.copy(pendingDelete = null) }
        _state.update { it.copy(renaming = RenameState(originalEntry = entry, input = entry.name)) }
        _state.update { it.copy(renaming = null) }
        _state.update { it.copy(snackbarMessage = null) }
        _state.update { state ->
        else -> null
        if (!path.startsWith("/")) return "/$path"
        if (_state.value.importing) return
        if (editor.dirty || editor.readOnly) return
        if (editor.readOnly) return
        if (entry.isDirectory) {
        if (moved) {
        if (newName.isEmpty() || newName == entry.name ||
        if (path.isEmpty()) return "/"
        if (path.length > 1 && path.endsWith("/")) return path.dropLast(1)
        if (text == editor.original) return
        is EditorState.Binary -> editor.path
        is EditorState.Loaded -> editor.path
        is EditorState.TooLarge -> editor.path
        is EditorState.Unreadable -> editor.path
        return path
        startPath = normalized
        val current = _state.value
        val current: String,
        val directory = _state.value.currentPath
        val dirty: Boolean get() = !readOnly && original != current
        val editor = _state.value.editor as? EditorState.Loaded ?: return
        val editor = when (val result = files.readTextFile(path, force = force)) {
        val entries = files.listDirectory(path)
        val entry = _state.value.pendingDelete ?: return
        val entry = rename.originalEntry
        val moved = startPath != normalized
        val newName = rename.input.trim()
        val normalized = normalize(initialPath)
        val normalized = normalize(path)
        val original: String,
        val path = _state.value.currentPath
        val path: String,
        val readOnly: Boolean = false,
        val rename = _state.value.renaming ?: return
        val samePath = current.currentPath == normalized && current.entries.isNotEmpty()
        val text = (files.readTextFile(editor.path) as? TextFileResult.Text)?.content ?: return
        viewModelScope.launch {
        viewModelScope.launch { loadInEditor(path) }
        viewModelScope.launch { refreshCurrent(silent = samePath) }
        }
     *
     * A [silent] refresh leaves the state instance untouched when the listing is
     * Called every time the browser becomes visible. The agent mutates the sandbox
     * Copies a file picked from device storage into the directory on screen. Until this
     * Opens [path] in the editor whatever its name says — the row menu's way past
     * Picks up agent edits to the file currently open in the editor. Unsaved user
     * Where the user browsed to is kept across that: only the first open, or a
     * [readOnly] marks a buffer that was decoded lossily on the user's request. It can be
     * behind our back, so re-entering an already-loaded directory re-lists it
     * browser would not stay.
     * buffer afterwards would clobber what the agent wrote.
     * caller that moved its starting point (Kai Build opening another project),
     * edits always win — reloading over them would lose work, and saving a stale
     * existed the only way into the sandbox was the agent's shell.
     * instead of serving the cache.
     * jumps to [initialPath]. Coming back from a terminal tab used to land on the
     * list never recomposes and its scroll position cannot shift.
     * looked at but never saved — writing it back would replace the file's real bytes
     * starting directory again, which made anywhere else in the tree a place the
     * the extension rule, for the file this app would otherwise hand to another one.
     * unchanged. That matters: an equal state is conflated by the StateFlow, so the
     * with the replacement characters the decoder substituted.
     */
    "db", "sqlite", "sqlite3", "ttf", "otf", "woff", "woff2",
    "deb", "rpm", "iso", "dmg",
    "jpg", "jpeg", "png", "gif", "webp", "bmp", "ico", "tif", "tiff", "heic", "heif",
    "mp3", "wav", "ogg", "flac", "m4a", "aac", "opus", "mid", "midi",
    "mp4", "mkv", "webm", "avi", "mov", "m4v", "3gp",
    "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "odt", "ods", "odp", "epub",
    "so", "o", "a", "class", "dex", "bin", "exe", "dll", "dylib", "wasm", "pyc",
    "zip", "tar", "gz", "tgz", "bz2", "xz", "zst", "7z", "rar", "jar", "apk", "aab",
    ) : EditorState {
    /**
    /** Last starting point [start] was given; null until the browser has opened once. */
    /** Not valid UTF-8. Offers a forced, read-only decode. */
    /** Past the editor's cap — no forced read, since a truncated buffer can't be edited safely. */
    /** The escape hatch from [EditorState.Binary]: decode the bytes anyway, read-only. */
    // Archives and packages.
    // Audio.
    // Compiled output, databases, fonts.
    // Documents another app renders far better than a text field.
    // Images and video.
    data class Binary(val path: String) : EditorState
    data class Loaded(
    data class TooLarge(val path: String, val sizeBytes: Long) : EditorState
    data class Unreadable(val path: String) : EditorState
    data object Loading : EditorState
    fun cancelDelete() {
    fun cancelRename() {
    fun confirmDelete() {
    fun confirmRename() {
    fun consumeSnackbar() {
    fun importFile(source: PlatformFile) {
    fun loadAsText(path: String) {
    fun navigateTo(path: String) {
    fun openEntry(entry: SandboxFileEntry) {
    fun openInEditor(path: String) {
    fun openInExternalApp(path: String) {
    fun requestDelete(entry: SandboxFileEntry) {
    fun requestRename(entry: SandboxFileEntry) {
    fun save() {
    fun start(initialPath: String) {
    fun updateEditorContent(content: String) {
    fun updateRenameInput(value: String) {
    private fun editorPathOf(editor: EditorState?): String? = when (editor) {
    private fun normalize(path: String): String {
    private suspend fun loadInEditor(path: String, force: Boolean = false) {
    private suspend fun refreshCurrent(silent: Boolean = false) {
    private suspend fun reloadEditorIfClean() {
    private val _state = MutableStateFlow(FileBrowserUiState())
    private val files: FileBrowserSource,
    private var startPath: String? = null
    val currentPath: String = "/",
    val editor: EditorState? = null,
    val entries: List<SandboxFileEntry> = emptyList(),
    val error: String? = null,
    val error: StringResource? = null,
    val importing: Boolean = false,
    val input: String,
    val loading: Boolean = false,
    val originalEntry: SandboxFileEntry,
    val pendingDelete: SandboxFileEntry? = null,
    val renaming: RenameState? = null,
    val snackbarMessage: StringResource? = null,
    val state = _state.asStateFlow()
    }
 *
 * "text" wrong costs one tap and a message saying so; guessing "binary" wrong
 * Extensions a tap hands straight to another app. Everything else — including
 * Listing what is *not* text is the way round that works here: a Linux tree is
 * every file with no extension at all — goes to the in-app editor, which decides
 * extension no list will ever have (`.pub`, `.service`, `.rules`). Guessing
 * from the bytes whether it is text and offers a way out when it is not.
 * full of text with no extension (`id_rsa`, `Makefile`, `known_hosts`) or an
 * meant the file could not be read in the app at all.
 */
)
) : ViewModel() {
/**
@Immutable
class SandboxFileBrowserViewModel(
data class FileBrowserUiState(
data class RenameState(
package com.inspiredandroid.kai.ui.sandbox
private val EXTERNAL_EXTENSIONS = setOf(
sealed interface EditorState {
}
