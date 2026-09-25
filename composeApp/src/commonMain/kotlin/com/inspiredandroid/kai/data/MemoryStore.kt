package com.inspiredandroid.kai.data
import androidx.compose.runtime.Immutable
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

                ?: MemoryEntry(key = key, content = content, createdAt = now, updatedAt = now, category = category, source = source)
            current.map { if (it.key == key) next else it }
            entry = existing?.copy(content = content, updatedAt = now, category = category, source = source ?: existing.source)
            if (existing != null) current.map { if (it.key == key) stored else it } else current + stored
            if (removed) current.filterNot { it.key == key } else current
            removed = current.any { it.key == key }
            updated = next
            val existing = current.find { it.key == key }
            val existing = current.find { it.key == key } ?: return@update current
            val next = transform(existing)
            val stored = entry
        category: MemoryCategory = MemoryCategory.GENERAL,
        content: String,
        itemSerializer = serializer<MemoryEntry>(),
        key: String,
        label = "MemoryStore",
        lateinit var entry: MemoryEntry
        memories.update { current ->
        read = appSettings::getMemoriesJson,
        return entry
        return removed
        return updated
        source: String? = null,
        val now = Clock.System.now().toEpochMilliseconds()
        var removed = false
        var updated: MemoryEntry? = null
        write = appSettings::setMemoriesJson,
        }
    )
    ): MemoryEntry {
    /** Applies [transform] to the entry under [key], persisting only when it exists. */
    ERROR,
    GENERAL,
    LEARNING,
    PREFERENCE,
    fun getAllMemories(): List<MemoryEntry> = memories.get()
    fun getPromotionCandidates(minHits: Int = 5): List<MemoryEntry> = memories.get().filter { it.hitCount >= minHits }
    private suspend fun mutateEntry(key: String, transform: (MemoryEntry) -> MemoryEntry): MemoryEntry? {
    private val memories = SettingsJsonList(
    suspend fun forget(key: String): Boolean {
    suspend fun reinforceMemory(key: String): MemoryEntry? = mutateEntry(key) { it.copy(hitCount = it.hitCount + 1, updatedAt = Clock.System.now().toEpochMilliseconds()) }
    suspend fun store(
    suspend fun updateContent(key: String, content: String): MemoryEntry? = mutateEntry(key) { it.copy(content = content, updatedAt = Clock.System.now().toEpochMilliseconds()) }
    val category: MemoryCategory = MemoryCategory.GENERAL,
    val content: String,
    val createdAt: Long,
    val hitCount: Int = 1,
    val key: String,
    val source: String? = null,
    val updatedAt: Long,
    }
)
@Immutable
@OptIn(ExperimentalTime::class)
@Serializable
class MemoryStore(appSettings: AppSettings) {
data class MemoryEntry(
enum class MemoryCategory {
}
