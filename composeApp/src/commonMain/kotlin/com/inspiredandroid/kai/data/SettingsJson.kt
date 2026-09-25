package com.inspiredandroid.kai.data
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

                    emptyList()
                    println("$label: failed to decode persisted JSON: ${e.message}")
                json.decodeFromString(serializer, raw)
                recover?.invoke(raw) ?: run {
                }
            emptyList()
            return migrated
            set(migrated)
            try {
            }
            } catch (e: Exception) {
        default()
        if (migrated != null) {
        json.decodeFromString(serializer, raw)
        memo = raw to decoded
        memo = raw to list
        memo?.let { (memoRaw, memoValue) -> if (raw == memoRaw) return memoValue }
        onWrite?.invoke(list)
        println("$label: failed to decode persisted JSON: ${e.message}")
        return decoded
        set(updated)
        updated
        val decoded = if (raw.isBlank()) {
        val migrated = migrate?.invoke(decoded)
        val raw = json.encodeToString(serializer, list)
        val raw = read()
        val updated = transform(get())
        write(raw)
        }
        } else {
    /** Last chance to read a legacy shape that no longer decodes. Null means "give up, return empty". */
    /** Notified after every write, e.g. to mirror the list into a [kotlinx.coroutines.flow.StateFlow]. */
    /** Post-decode upgrade of legacy rows. A non-null result is persisted so later loads are no-ops. */
    /** Reads, applies [transform] and persists the result under a lock. Returns the stored list. */
    /** Reads, applies [transform] and persists the result under a lock. Returns the stored value. */
    // Decoding runs on hot paths (system prompt assembly re-reads these lists per turn), so keep
    // process's — changes the string and invalidates the memo on its own. Held as one reference
    // so a concurrent reader can never pair a raw string with someone else's decoded list.
    // the last result keyed on the exact raw string it came from. Any write — ours or another
    default: () -> T,
    fun get(): List<T> {
    fun get(): T = decodeJsonOr(read(), serializer, label, json, default)
    fun set(list: List<T>) {
    fun set(value: T) = write(json.encodeToString(serializer, value))
    if (raw.isBlank()) return default()
    itemSerializer: KSerializer<T>,
    json: Json = SharedJson,
    label: String,
    private val default: () -> T,
    private val json: Json = SharedJson,
    private val label: String,
    private val migrate: ((List<T>) -> List<T>?)? = null,
    private val mutex = Mutex()
    private val onWrite: ((List<T>) -> Unit)? = null,
    private val read: () -> String,
    private val recover: ((raw: String) -> List<T>?)? = null,
    private val serializer = ListSerializer(itemSerializer)
    private val serializer: KSerializer<T>,
    private val write: (String) -> Unit,
    private var memo: Pair<String, List<T>>? = null
    raw: String,
    return try {
    serializer: KSerializer<T>,
    suspend fun update(transform: (List<T>) -> List<T>): List<T> = mutex.withLock {
    suspend fun update(transform: (T) -> T): T = mutex.withLock {
    }
    } catch (e: Exception) {
 *
 * A list of [T] persisted as JSON in a single app-settings string.
 * A single [T] persisted as JSON in one app-settings string, with a [default] for the
 * Callers keep their own retention policy — caps, ordering, prepend vs append — inside the
 * Decodes [raw] into [T], falling back to [default] when the string is blank or unparseable.
 * The single decode implementation behind every settings-backed JSON store — a corrupt or
 * [update] lambda; this class only owns the read/decode/encode/write mechanics and the lock that
 * makes read-modify-write safe against concurrent mutators.
 * not-yet-written and corrupt cases.
 * partially written blob costs the user that one collection, never a crash.
 */
) {
): T {
/**
class SettingsJsonList<T>(
class SettingsJsonValue<T>(
internal fun <T> decodeJsonOr(
}
