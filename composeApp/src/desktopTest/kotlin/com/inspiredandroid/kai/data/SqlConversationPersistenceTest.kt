import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.db.KaiDatabase
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.encodeToString

                Conversation.Message(id = "huge", role = "user", content = "x".repeat(3_000_000)),
                attachments = if (index == 0) listOf(Attachment(data = "aGk=", mimeType = "text/plain", fileName = "a.txt")) else emptyList(),
                content = content,
                id = "$id-msg$index",
                role = if (index % 2 == 0) "user" else "assistant",
            )
            ),
            Conversation.Message(
            attachments = listOf(Attachment(data = "A".repeat(3_000_000), mimeType = "application/pdf", fileName = "big.pdf")),
            content = "What does this PDF say?",
            conversationId = "c1",
            id = "m0",
            messageJson = ConversationJson.encodeToString(
            orderIndex = 99L,
            role = "user",
        )
        .map { it.messageJson.encodeToByteArray().size }
        /** Android's per-row CursorWindow limit — the size the crash in issue #475 hit. */
        // What an older build stored: a row far past Android's CursorWindow, which
        // aborted the whole load with SQLiteBlobTooBigException.
        appSettings.setConversationsJson("")
        appSettings.setConversationsJson(ConversationJson.encodeToString(ConversationsData(conversations = fromKey)))
        assertEquals("Untouched", loaded.single { it.id == "other" }.messages.single().content)
        assertEquals("What does this PDF say?", loaded.content)
        assertEquals(1, loaded.single { it.id == "c1" }.messages.size)
        assertEquals(2, loaded.messages.size)
        assertEquals(2, loaded.single().messages.size)
        assertEquals(listOf("Hello"), loaded.messages.map { it.content })
        assertEquals(listOf("c2"), persistence.loadAll().map { it.id })
        assertEquals(listOf("imported"), loaded.map { it.id })
        assertEquals(listOf("new1", "new2"), persistence.loadAll().map { it.id })
        assertEquals(listOf("older", "newer"), persistence.loadAll().map { it.id })
        assertEquals(listOf(c1, c2), loaded)
        assertEquals(listOf<TerminalLine>(TerminalLine.Output("new output")), loaded.shellTranscript)
        assertNull(appSettings.getConversationsJson())
        assertTrue(loaded.attachments.isEmpty())
        assertTrue(loaded.content.length < huge.content.length)
        assertTrue(persistence.loadAll().isEmpty())
        assertTrue(storedMessageBytes(database).single() < CURSOR_WINDOW_BYTES)
        const val CURSOR_WINDOW_BYTES = 2_000_000
        createdAt = createdAt,
        database.conversationQueries.insertMessage(
        database: KaiDatabase = createDatabase(),
        id = id,
        messages = messages.mapIndexed { index, content ->
        persistence.delete("c1", emptyList())
        persistence.replaceAll(listOf(conversation("new1", 1000L), conversation("new2", 2000L)))
        persistence.save(c1, emptyList())
        persistence.save(c2, emptyList())
        persistence.save(conversation("c1").copy(messages = listOf(huge)), emptyList())
        persistence.save(conversation("c1", 1000L, "Hello"), emptyList())
        persistence.save(conversation("c1", 2000L, "One"), emptyList())
        persistence.save(conversation("c1", 2000L, "One", "Two", "Three"), emptyList())
        persistence.save(conversation("c2", 2000L, "Other"), emptyList())
        persistence.save(conversation("newer", 5000L), emptyList())
        persistence.save(conversation("old", 1000L, "Hello"), emptyList())
        persistence.save(conversation("older", 1000L), emptyList())
        persistence.save(conversation("preexisting", 500L), emptyList())
        persistence.save(original, emptyList())
        persistence.save(other, emptyList())
        persistence.saveShellTranscript(updated, emptyList())
        settings: MapSettings = MapSettings(),
        shellTranscript = listOf(TerminalLine.Command("echo $id")),
        title = "Title $id",
        type = Conversation.TYPE_CHAT,
        updatedAt = createdAt + 1000L,
        val appSettings = AppSettings(settings)
        val c1 = conversation("c1", 1000L, "Hello", "Hi!")
        val c2 = conversation("c2", 2000L, "Ping")
        val database = createDatabase()
        val fromKey = listOf(conversation("imported", 1000L, "Hello", "Hi!"))
        val huge = Conversation.Message(
        val huge = Conversation.Message(id = "m0", role = "assistant", content = "x".repeat(3_000_000))
        val loaded = persistence.loadAll()
        val loaded = persistence.loadAll().single()
        val loaded = persistence.loadAll().single().messages.single()
        val original = conversation("c1", 1000L, "Hello", "Hi!")
        val other = conversation("other", 1000L, "Untouched")
        val persistence = createPersistence()
        val persistence = createPersistence(database = database)
        val persistence = createPersistence(settings)
        val settings = MapSettings()
        val updated = original.copy(shellTranscript = listOf(TerminalLine.Output("new output")))
        },
    )
    ): SqlConversationPersistence = SqlConversationPersistence(database, AppSettings(settings))
    /** Byte size of every stored message row, read back without the persistence-side filter. */
    @Test
    fun `attachment too large for a database row is dropped, keeping the message`() {
    fun `blank pending key clears the database`() {
    fun `conversations load ordered by createdAt regardless of save order`() {
    fun `delete removes conversation and its messages`() {
    fun `message text beyond the row budget is truncated instead of stored whole`() {
    fun `oversized rows written by older versions are skipped, not crashed on`() {
    fun `pending settings key is imported into the database and removed`() {
    fun `re-saving a conversation replaces its messages without touching others`() {
    fun `replaceAll swaps the full content`() {
    fun `save and loadAll round-trips conversations with messages and transcript`() {
    fun `saveShellTranscript updates only the transcript`() {
    private companion object {
    private fun conversation(id: String, createdAt: Long = 1000L, vararg messages: String) = Conversation(
    private fun createDatabase(): KaiDatabase = KaiDatabase(JdbcSqliteDriver(url = JdbcSqliteDriver.IN_MEMORY, schema = KaiDatabase.Schema))
    private fun createPersistence(
    private fun storedMessageBytes(database: KaiDatabase): List<Int> = database.conversationQueries.selectAllMessages(Long.MAX_VALUE).executeAsList()
    }
class SqlConversationPersistenceTest {
package com.inspiredandroid.kai.data
}
