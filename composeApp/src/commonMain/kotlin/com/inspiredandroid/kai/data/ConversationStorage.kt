package com.inspiredandroid.kai.data
import com.inspiredandroid.kai.TerminalLine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

                    conversation
                    conversation.copy(shellTranscript = existing.shellTranscript)
                // Chat-layer save paths rebuild Conversation without the shell
                // transcript; preserve the stored tail rather than wiping it.
                break
                changed = updated
                current
                current + conversation
                current.toMutableList().apply { set(idx, updated) }
                current.toMutableList().apply { set(index, merged) }
                running += line.text.length
                saved = merged
                tail.addFirst(line)
                val existing = current[index]
                val merged = if (conversation.shellTranscript.isEmpty() && existing.shellTranscript.isNotEmpty()) {
                val updated = current[idx].copy(shellTranscript = trimmed)
                }
                } else {
            ConversationJson.decodeFromString<ConversationsData>(decrypted.decodeToString()).conversations
            current.filter { it.id != id }
            decrypted[i] = (legacyData[i].toInt() xor key[i % key.size].toInt()).toByte()
            emptyList()
            if (idx < 0) {
            if (index >= 0) {
            if (running + line.text.length <= limit) {
            migrateLegacy()
            val idx = current.indexOfFirst { it.id == conversationId }
            val index = current.indexOfFirst { it.id == conversation.id }
            val line = lines[i]
            }
            } else if (current[idx].shellTranscript == trimmed) {
            } else {
        // Single most-recent line is itself larger than the budget — keep its
        // tail so the user still sees something on next launch.
        changed?.let { persistence.saveShellTranscript(it, mutableConversations.value) }
        deleteLegacyConversationFile()
        for (i in legacyData.indices) {
        for (i in lines.indices.reversed()) {
        if (lines.isEmpty()) return lines
        if (loaded.isEmpty()) {
        if (tail.isNotEmpty()) return tail.toList()
        if (totalChars <= limit) return lines
        mutableConversations.update { current ->
        mutableConversations.value = conversations
        mutableConversations.value = loaded
        persistence.delete(id, mutableConversations.value)
        persistence.replaceAll(conversations)
        persistence.save(saved, mutableConversations.value)
        return listOf(last.withText(last.text.takeLast(limit)))
        val conversations = try {
        val decrypted = ByteArray(legacyData.size)
        val key = appSettings.getEncryptionKey() ?: return
        val last = lines.last()
        val legacyData = readLegacyConversationFile() ?: return
        val loaded = persistence.loadAll()
        val tail = ArrayDeque<TerminalLine>()
        val totalChars = lines.sumOf { it.text.length }
        val trimmed = trimToCharLimit(lines, MAX_SHELL_TRANSCRIPT_CHARS)
        var changed: Conversation? = null
        var running = 0
        var saved = conversation
        }
        } catch (_: Exception) {
     * Persist a shell transcript snapshot for [conversationId]. No-op when the
     * conversation isn't in the saved set yet (chat hasn't been saved). The
     * stored transcript is trimmed from the head until the joined text is
     * tail (most recent activity) survives a restart.
     * within the per-conversation char budget — older lines drop first so the
     */
    /**
    fun deleteConversation(id: String) {
    fun loadConversations() {
    fun saveConversation(conversation: Conversation) {
    fun updateShellTranscript(conversationId: String, lines: List<TerminalLine>) {
    private fun migrateLegacy() {
    private fun trimToCharLimit(lines: List<TerminalLine>, limit: Int): List<TerminalLine> {
    private val appSettings: AppSettings,
    private val mutableConversations = MutableStateFlow<List<Conversation>>(emptyList())
    private val persistence: ConversationPersistence,
    val conversations: StateFlow<List<Conversation>> = mutableConversations.asStateFlow()
    }
) {
class ConversationStorage(
expect fun deleteLegacyConversationFile()
expect fun readLegacyConversationFile(): ByteArray?
private const val MAX_SHELL_TRANSCRIPT_CHARS = 10_000
}
