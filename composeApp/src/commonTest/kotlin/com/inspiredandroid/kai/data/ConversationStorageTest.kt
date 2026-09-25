import com.inspiredandroid.kai.TerminalLine
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

                TerminalLine.Output("tail"),
                TerminalLine.Output(longLine),
            "c1",
            ),
            Conversation.Message(id = "$id-msg$index", role = if (index % 2 == 0) "user" else "assistant", content = content)
            listOf(
            shellTranscript = listOf(TerminalLine.Command("ls"), TerminalLine.Output("file.txt")),
        )
        assertEquals("Title c2", conversations[1].title)
        assertEquals("tail", transcript[1].text)
        assertEquals(1, transcript.size)
        assertEquals(10_000, transcript.single().text.length)
        assertEquals(2, reloaded.conversations.value.single().shellTranscript.size)
        assertEquals(2, saved.messages.size)
        assertEquals(2, saved.shellTranscript.size)
        assertEquals(2, transcript.size)
        assertEquals(3, conversations[0].messages.size)
        assertEquals(listOf("Hello", "Hi!"), conversations[0].messages.map { it.content })
        assertEquals(listOf("c1", "c2"), conversations.map { it.id })
        assertEquals(listOf("c2"), reloaded.conversations.value.map { it.id })
        assertEquals(listOf("c2"), storage.conversations.value.map { it.id })
        assertEquals(longLine, transcript[0].text)
        assertTrue(storage.conversations.value.isEmpty())
        assertTrue(transcript.single().text.endsWith("b"))
        createdAt = 1000L,
        id = id,
        messages = messages.mapIndexed { index, content ->
        reloaded.loadConversations()
        return ConversationStorage(appSettings, SettingsConversationPersistence(appSettings))
        storage.deleteConversation("c1")
        storage.saveConversation(conversation("c1", "Hello"))
        storage.saveConversation(conversation("c1", "Hello", "Hi!"))
        storage.saveConversation(conversation("c1", "Hello", "Hi!", "More"))
        storage.saveConversation(conversation("c2", "Other"))
        storage.saveConversation(conversation("c2", "Ping"))
        storage.saveConversation(withTranscript)
        storage.updateShellTranscript(
        storage.updateShellTranscript("c1", listOf(TerminalLine.Output("a".repeat(9_000) + "b".repeat(6_000))))
        storage.updateShellTranscript("missing", listOf(TerminalLine.Output("hello")))
        title = "Title $id",
        updatedAt = 2000L,
        val appSettings = AppSettings(settings)
        val conversations = reloaded.conversations.value
        val conversations = storage.conversations.value
        val longLine = "x".repeat(6_000)
        val reloaded = createStorage(settings)
        val saved = storage.conversations.value.single()
        val settings = MapSettings()
        val storage = createStorage()
        val storage = createStorage(settings)
        val transcript = storage.conversations.value.single().shellTranscript
        val withTranscript = conversation("c1", "Hello").copy(
        },
    )
    @Test
    fun `chat-layer save without transcript preserves the stored transcript`() {
    fun `deleteConversation removes it from flow and persistence`() {
    fun `saved conversations survive a reload through a fresh storage`() {
    fun `saving an existing conversation replaces it in place`() {
    fun `single oversized line keeps its tail`() {
    fun `updateShellTranscript is a no-op for unsaved conversations`() {
    fun `updateShellTranscript trims older lines beyond the char budget`() {
    private fun conversation(id: String, vararg messages: String) = Conversation(
    private fun createStorage(settings: MapSettings = MapSettings()): ConversationStorage {
    }
class ConversationStorageTest {
package com.inspiredandroid.kai.data
}
