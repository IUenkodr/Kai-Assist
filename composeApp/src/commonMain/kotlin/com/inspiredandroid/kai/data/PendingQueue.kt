
        if (items.isEmpty()) return
        itemSerializer = serializer,
        label = label,
        persisted.update { (it + items).takeLast(maxSize) }
        persisted.update { current -> current.filterNot { keyOf(it) in keys } }
        persisted.update { emptyList() }
        read = readJson,
        val keys = items.map(keyOf).toSet()
        write = writeJson,
    )
    fun get(): List<T> = persisted.get()
    label: String,
    private val keyOf: (T) -> K,
    private val maxSize: Int = 100,
    private val persisted = SettingsJsonList(
    readJson: () -> String,
    serializer: KSerializer<T>,
    suspend fun add(items: List<T>) {
    suspend fun clear() {
    suspend fun remove(items: List<T>) {
    writeJson: (String) -> Unit,
    }
 * Capped FIFO queue persisted as JSON via [SettingsJsonList]. Generic over the item type [T]
 * `SmsStore`, and `NotificationStore` to enforce a uniform pending-buffer discipline.
 * and a stable key type [K] used to identify items for removal. Shared by `EmailStore`,
 */
) {
/**
class PendingQueue<T, K>(
import kotlinx.serialization.KSerializer
package com.inspiredandroid.kai.data
}
