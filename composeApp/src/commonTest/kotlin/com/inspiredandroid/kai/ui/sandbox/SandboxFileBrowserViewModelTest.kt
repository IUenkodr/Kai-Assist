import app.cash.turbine.test
import com.inspiredandroid.kai.CommandHandle
import com.inspiredandroid.kai.NoOpCommandHandle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.SandboxStatus
import com.inspiredandroid.kai.TextFileResult
import io.github.vinceglb.filekit.PlatformFile
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_files_delete_failed
import kai.composeapp.generated.resources.sandbox_files_delete_success
import kai.composeapp.generated.resources.sandbox_files_editor_closed_after_delete
import kai.composeapp.generated.resources.sandbox_files_rename_error_collision
import kai.composeapp.generated.resources.sandbox_files_rename_error_invalid
import kai.composeapp.generated.resources.sandbox_files_rename_success
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                    if (entry.path == path) entry.copy(name = newName, path = newPath) else entry
                entriesByPath.values.forEach { it.removeAll { entry -> entry.path == path } }
                files.remove(path)
                files[newPath] = content
                list.replaceAll { entry ->
                return if (force) TextFileResult.Text(content, editable = false) else TextFileResult.Binary
                }
            // No state change means no recomposition, so the list keeps its scroll.
            // Stand-in for "not valid UTF-8": forcing decodes it read-only, as on device.
            // initial state with seeded entry
            // multiple updates may emit; consume until we see the snackbar
            assertEquals(entry, awaitItem().pendingDelete)
            assertTrue(current.entries.any { it.path == entry.path })
            awaitItem()
            cancelAndIgnoreRemainingEvents()
            command: String,
            entriesByPath.values.forEach { list ->
            expectNoEvents()
            files[path] = content
            files[path]?.let { content ->
            if (content.length > maxBytes) return TextFileResult.TooLarge(content.length.toLong())
            if (deleteResult) {
            if (override != null) return override
            if (path in binaryPaths) {
            lastDeleteCall = path to recursive
            lastRenameCall = path to newName
            listDelays[path]?.let { delay(it) }
            onStderr: (String) -> Unit,
            onStdout: (String) -> Unit,
            return Result.success(newPath)
            return TextFileResult.Text(content)
            return deleteResult
            return entriesByPath[path]?.toList().orEmpty()
            return true
            sessionId: String,
            testDispatcher.scheduler.advanceUntilIdle()
            val content = files[path] ?: return TextFileResult.Unreadable
            val current = awaitItem()
            val newPath = if (parent.isEmpty()) "/$newName" else "$parent/$newName"
            val override = renameResult
            val parent = path.substringBeforeLast('/', "")
            vm.confirmDelete()
            vm.requestDelete(entry)
            vm.start("/root")
            }
        ): CommandHandle = NoOpCommandHandle
        // Agent writes a file while the Files tab is off screen.
        // PlatformFile is an expect class with no common constructor, so the import path
        // The escape hatch has to actually change state — it used to re-run the same
        // is not reachable from commonTest.
        // read and land back on Binary.
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        assertEquals("/root/b.txt", editor.path)
        assertEquals("/root/sub", vm.state.value.currentPath)
        assertEquals("after", editor.current)
        assertEquals("after", editor.original)
        assertEquals("before", editor.current)
        assertEquals("before", editor.original)
        assertEquals("hello dirty", editor.current) // dirty edits preserved
        assertEquals("my unsaved work", editor.current)
        assertEquals("notes.md", rename.input)
        assertEquals("original", controller.files[entry.path])
        assertEquals(600_000L, editor.sizeBytes)
        assertEquals(Res.string.sandbox_files_delete_failed, vm.state.value.snackbarMessage)
        assertEquals(Res.string.sandbox_files_delete_success, vm.state.value.snackbarMessage)
        assertEquals(Res.string.sandbox_files_editor_closed_after_delete, vm.state.value.snackbarMessage)
        assertEquals(Res.string.sandbox_files_rename_error_collision, rename.error)
        assertEquals(Res.string.sandbox_files_rename_error_invalid, rename.error)
        assertEquals(Res.string.sandbox_files_rename_success, vm.state.value.snackbarMessage)
        assertEquals(entry, rename.originalEntry)
        assertEquals(entry, vm.state.value.pendingDelete)
        assertEquals(entry.path to "b.txt", controller.lastRenameCall)
        assertEquals(entry.path to false, controller.lastDeleteCall)
        assertEquals(entry.path to true, controller.lastDeleteCall)
        assertEquals(listOf("a.txt"), vm.state.value.entries.map { it.name })
        assertEquals(listOf("a.txt", "agent.log"), vm.state.value.entries.map { it.name })
        assertEquals(listOf("inner.txt"), vm.state.value.entries.map { it.name })
        assertEquals(listOf("old.txt", "new.txt"), vm.state.value.entries.map { it.name })
        assertFalse(editor.dirty)
        assertFalse(vm.state.value.loading)
        assertNotNull(rename)
        assertNull(controller.lastRenameCall)
        assertNull(vm.state.value.editor)
        assertNull(vm.state.value.pendingDelete)
        assertNull(vm.state.value.renaming)
        assertTrue((vm.state.value.editor as EditorState.Loaded).dirty)
        assertTrue(editor is EditorState.Loaded)
        assertTrue(editor is EditorState.TooLarge)
        assertTrue(editor.readOnly)
        assertTrue(vm.state.value.editor is EditorState.Binary)
        assertTrue(vm.state.value.editor is EditorState.Loaded)
        assertTrue(vm.state.value.editor is EditorState.Unreadable)
        assertTrue(vm.state.value.entries.any { it.name == "b.txt" })
        assertTrue(vm.state.value.entries.any { it.path == entry.path })
        assertTrue(vm.state.value.entries.none { it.path == entry.path })
        controller = FakeFileBrowserController()
        controller.binaryPaths += entry.path
        controller.deleteResult = false
        controller.entriesByPath.getValue("/root").add(fileEntry("agent.log"))
        controller.entriesByPath.getValue("/root/sub").add(fileEntry("new.txt", parent = "/root/sub"))
        controller.entriesByPath[path] = entries.toMutableList()
        controller.files.remove(entry.path) // readTextFile now reports Unreadable
        controller.files[entry.path] = "\uFFFDbytes"
        controller.files[entry.path] = "after"
        controller.files[entry.path] = "before"
        controller.files[entry.path] = "hello"
        controller.files[entry.path] = "original"
        controller.files[entry.path] = "x".repeat(600_000)
        controller.listDelays["/root"] = 100
        controller.listDelays["/root"] = 50
        controller.renameResult = Result.failure(IllegalStateException("collision"))
        override fun cancel() {}
        override fun installPackages() {}
        override fun reset() {}
        override fun setup() {}
        override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean {
        override suspend fun executeCommand(command: String, sessionId: String): String = ""
        override suspend fun executeCommandStreaming(
        override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = Result.failure(UnsupportedOperationException("Not reachable from commonTest"))
        override suspend fun listDirectory(path: String): List<SandboxFileEntry> {
        override suspend fun openFile(path: String): Result<Unit> = Result.success(Unit)
        override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult {
        override suspend fun renameEntry(path: String, newName: String): Result<String> {
        override suspend fun writeTextFile(path: String, content: String): Boolean {
        override val sessions = MutableStateFlow<List<String>>(emptyList())
        override val status = MutableStateFlow(SandboxStatus())
        return SandboxFileEntry(name = name, path = path, isDirectory = false, sizeBytes = 0, lastModifiedMs = 0)
        return SandboxFileEntry(name = name, path = path, isDirectory = true, sizeBytes = 0, lastModifiedMs = 0)
        seedDir("/root", entry)
        seedDir("/root", fileEntry("a.txt"))
        seedDir("/root", sub)
        seedDir("/root/sub", fileEntry("inner.txt", parent = "/root/sub"))
        seedDir("/root/sub", fileEntry("old.txt", parent = "/root/sub"))
        testDispatcher.scheduler.advanceTimeBy(10)
        testDispatcher.scheduler.advanceUntilIdle()
        val binaryPaths = mutableSetOf<String>()
        val editor = vm.state.value.editor
        val entriesByPath = mutableMapOf<String, MutableList<SandboxFileEntry>>()
        val entry = dirEntry("subdir")
        val entry = fileEntry("a.txt")
        val entry = fileEntry("gone.txt")
        val entry = fileEntry("huge.log")
        val entry = fileEntry("latin1.txt")
        val entry = fileEntry("notes.md")
        val files = mutableMapOf<String, String>() // path -> text content
        val listDelays = mutableMapOf<String, Long>() // path -> virtual ms listDirectory takes
        val path = if (parent == "/") "/$name" else "$parent/$name"
        val rename = vm.state.value.renaming
        val sub = dirEntry("sub")
        val vm = SandboxFileBrowserViewModel(controller)
        var deleteResult: Boolean = true
        var lastDeleteCall: Pair<String, Boolean>? = null
        var lastRenameCall: Pair<String, String>? = null
        var renameResult: Result<String>? = null
        vm.cancelDelete()
        vm.confirmDelete()
        vm.confirmRename()
        vm.loadAsText(entry.path)
        vm.navigateTo("/root")
        vm.navigateTo("/root/sub")
        vm.navigateTo("/root/sub") // user steps into the subdirectory meanwhile
        vm.openEntry(entry)
        vm.requestDelete(entry)
        vm.requestRename(entry)
        vm.save()
        vm.start("/root")
        vm.start("/root") // slow silent refresh of /root
        vm.state.test {
        vm.updateEditorContent("clobbered")
        vm.updateEditorContent("hello dirty")
        vm.updateEditorContent("my unsaved work")
        vm.updateRenameInput("b.txt")
        vm.updateRenameInput("with/slash")
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `a missing file reports Unreadable`() = runTest {
    fun `a non-UTF-8 file opens as Binary and force opens it read-only`() = runTest {
    fun `a read-only buffer cannot be edited or saved`() = runTest {
    fun `an oversized file reports TooLarge rather than Binary`() = runTest {
    fun `confirmDelete clears editor and shows dedicated snackbar when deleted file is open`() = runTest {
    fun `confirmDelete failure surfaces failed snackbar and keeps list`() = runTest {
    fun `confirmDelete on directory calls controller with recursive true`() = runTest {
    fun `confirmDelete on file calls controller with recursive false and refreshes`() = runTest {
    fun `confirmRename collision sets error on renaming state and keeps dialog open`() = runTest {
    fun `confirmRename invalid name short-circuits without controller call`() = runTest {
    fun `confirmRename of currently-open file updates editor path without reload`() = runTest {
    fun `confirmRename success refreshes list and shows success snackbar`() = runTest {
    fun `navigateTo back to a previously visited directory re-lists it`() = runTest {
    fun `refresh that resolves after navigating away does not overwrite the new directory`() = runTest {
    fun `requestDelete sets pendingDelete and cancelDelete clears it`() = runTest {
    fun `requestRename seeds input with entry name`() = runTest {
    fun `start does not emit when the listing is unchanged`() = runTest {
    fun `start keeps unsaved editor edits instead of reloading`() = runTest {
    fun `start leaves the editor loaded when the file becomes unreadable`() = runTest {
    fun `start on an already-loaded directory never flips loading on`() = runTest {
    fun `start re-lists a directory that changed while the browser was hidden`() = runTest {
    fun `start reloads the open editor when the buffer is clean`() = runTest {
    fun `state stream emits expected snackbar transitions on delete`() = runTest {
    fun setup() {
    fun tearDown() {
    private class FakeFileBrowserController : SandboxController {
    private fun dirEntry(name: String, parent: String = "/root"): SandboxFileEntry {
    private fun fileEntry(name: String, parent: String = "/root"): SandboxFileEntry {
    private fun seedDir(path: String, vararg entries: SandboxFileEntry) {
    private lateinit var controller: FakeFileBrowserController
    private val testDispatcher = StandardTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class SandboxFileBrowserViewModelTest {
package com.inspiredandroid.kai.ui.sandbox
}
