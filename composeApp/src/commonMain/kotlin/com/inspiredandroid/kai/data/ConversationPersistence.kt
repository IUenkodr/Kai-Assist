package com.inspiredandroid.kai.data
import app.cash.sqldelight.db.SqlDriver
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.db.KaiDatabase
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

                conversationId = conversation.id,
                createdAt = row.createdAt,
                id = row.id,
                messageJson = encodeMessage(message),
                messages = messagesByConversation[row.id].orEmpty().filterNotNull(),
                orderIndex = index.toLong(),
                shellTranscript = decodeTranscript(row.shellTranscriptJson),
                title = row.title,
                type = row.type,
                updatedAt = row.updatedAt,
            )
            .groupBy({ it.conversationId }) { decodeMessage(it.messageJson) }
            Conversation(
            ConversationJson.decodeFromString<ConversationsData>(data).conversations
            ConversationJson.decodeFromString<ConversationsData>(pending).conversations
            ConversationJson.encodeToString(ConversationsData(conversations = conversations)),
            attachments = emptyList(),
            content = withoutFiles.content.take(MAX_MESSAGE_TEXT_CHARS),
            conversations.forEach { insert(it) }
            createdAt = conversation.createdAt,
            data = null,
            emptyList()
            fileName = null,
            id = conversation.id,
            insert(conversation)
            mimeType = null,
            queries.deleteAllConversations()
            queries.deleteAllMessages()
            queries.deleteConversation(id)
            queries.deleteMessages(conversation.id)
            queries.deleteMessages(id)
            queries.insertMessage(
            reasoningContent = null,
            shellTranscriptJson = ConversationJson.encodeToString(conversation.shellTranscript),
            title = conversation.title,
            type = conversation.type,
            uiSubmission = null,
            updatedAt = conversation.updatedAt,
        )
        // Everything that can still be large goes: the reasoning trace, and the copy
        // by MAX_MESSAGE_TEXT_CHARS, so the row is guaranteed to fit.
        // of the source message a kai-ui submission carries. What is left is bounded
        ConversationJson.decodeFromString<Conversation.Message>(json)
        ConversationJson.decodeFromString<List<TerminalLine>>(json)
        SettingsConversationPersistence(appSettings)
        SqlConversationPersistence(KaiDatabase(driver), appSettings)
        appSettings.removeConversationsJson()
        appSettings.setConversationsJson(
        conversation.messages.forEachIndexed { index, message ->
        database.transaction {
        emptyList()
        if (!encoded.exceedsUtf8Budget(MAX_MESSAGE_JSON_BYTES)) return encoded
        if (!withoutFilesJson.exceedsUtf8Budget(MAX_MESSAGE_JSON_BYTES)) return withoutFilesJson
        importPendingJson()
        null
        queries.updateShellTranscript(
        queries.upsertConversation(
        replaceAll(conversations)
        return ConversationJson.encodeToString(trimmed)
        return queries.selectAllConversations().executeAsList().map { row ->
        return try {
        val conversations = try {
        val data = appSettings.getConversationsJson() ?: return emptyList()
        val encoded = ConversationJson.encodeToString(message)
        val messagesByConversation = queries.selectAllMessages(MAX_MESSAGE_JSON_BYTES).executeAsList()
        val pending = appSettings.getConversationsJson() ?: return
        val trimmed = withoutFiles.copy(
        val withoutFiles = message.copy(
        val withoutFilesJson = ConversationJson.encodeToString(withoutFiles)
        }
        } catch (_: Exception) {
     * A present key always replaces the database content — including an unparseable
     * Encodes a message, shrinking it when the JSON would exceed
     * The settings key doubles as an import inbox: settings import (and the one-time
     * [MAX_MESSAGE_JSON_BYTES]. Base64 file payloads go first — they are the part
     * attachment loses the attachment instead of the whole conversation history.
     * migration from the pre-database format) writes the full conversation set there.
     * or blank value, which import writes to mean "clear conversations".
     * that can be megabytes — and only then is the text cut, so a chat with a huge
     */
    /**
    else -> encodeToByteArray().size > budget
    encodeDefaults = true
    fun delete(id: String, snapshot: List<Conversation>)
    fun loadAll(): List<Conversation>
    fun replaceAll(conversations: List<Conversation>)
    fun save(conversation: Conversation, snapshot: List<Conversation>)
    fun saveShellTranscript(conversation: Conversation, snapshot: List<Conversation>)
    ignoreUnknownKeys = true
    length.toLong() * 3 <= budget -> false
    length.toLong() > budget -> true
    override fun delete(id: String, snapshot: List<Conversation>) = writeAll(snapshot)
    override fun delete(id: String, snapshot: List<Conversation>) {
    override fun loadAll(): List<Conversation> {
    override fun replaceAll(conversations: List<Conversation>) = writeAll(conversations)
    override fun replaceAll(conversations: List<Conversation>) {
    override fun save(conversation: Conversation, snapshot: List<Conversation>) = writeAll(snapshot)
    override fun save(conversation: Conversation, snapshot: List<Conversation>) {
    override fun saveShellTranscript(conversation: Conversation, snapshot: List<Conversation>) = writeAll(snapshot)
    override fun saveShellTranscript(conversation: Conversation, snapshot: List<Conversation>) {
    private fun decodeMessage(json: String): Conversation.Message? = try {
    private fun decodeTranscript(json: String): List<TerminalLine> = try {
    private fun encodeMessage(message: Conversation.Message): String {
    private fun importPendingJson() {
    private fun insert(conversation: Conversation) {
    private fun writeAll(conversations: List<Conversation>) {
    private val appSettings: AppSettings,
    private val database: KaiDatabase,
    private val queries get() = database.conversationQueries
    return if (driver != null) {
    val driver = createConversationSqlDriver()
    }
    } catch (_: Exception) {
    } else {
 * Per-message byte budget for the database. Android hands query results back
 * Persistence backend for [ConversationStorage]. SQL-capable platforms store one
 * True when the UTF-8 encoding of this string is larger than [budget]. UTF-8 uses
 * cases without encoding megabytes of text on every save.
 * conversation list for backends that can only write wholesale.
 * file attachments (a PDF may be 20 MB) are the usual way a message gets there.
 * not the whole history. Platforms without a SQL driver (wasm) fall back to the
 * one to three bytes per char, so the two length comparisons decide the common
 * row per conversation and one row per message, so a save costs one conversation,
 * settings-key JSON blob. The `snapshot` parameter carries the full up-to-date
 * the window aborts the whole read with SQLiteBlobTooBigException — which used
 * through a CursorWindow that holds roughly 2 MB, and a single row larger than
 * to crash the app on every launch once one oversized message was stored. Base64
 */
) : ConversationPersistence {
/**
/** Head of the text kept when a message is still oversized after its files are dropped. */
/** Returns null on platforms without a bundled SQLite (wasm). */
class SettingsConversationPersistence(private val appSettings: AppSettings) : ConversationPersistence {
class SqlConversationPersistence(
expect fun createConversationSqlDriver(): SqlDriver?
fun createConversationPersistence(appSettings: AppSettings): ConversationPersistence {
interface ConversationPersistence {
internal val ConversationJson = Json {
private const val MAX_MESSAGE_JSON_BYTES = 1_000_000L
private const val MAX_MESSAGE_TEXT_CHARS = 200_000
private fun String.exceedsUtf8Budget(budget: Long): Boolean = when {
}
