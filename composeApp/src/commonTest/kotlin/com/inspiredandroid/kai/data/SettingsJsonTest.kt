package com.inspiredandroid.kai.data
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

                default = { Config() },
                label = "test",
                read = slot::read,
                serializer = serializer<Config>(),
                write = slot::write,
            )
            assertEquals(0, slot.writes)
            assertEquals(Config(), value.get())
            decoded.map { if (it.value == 0) it.copy(value = 9) else it }.takeIf { it != decoded }
            default = { Config() },
            label = "test",
            listOf(SharedJson.decodeFromString<Item>(raw))
            private set
            raw = value
            read = slot::read,
            serializer = serializer<Config>(),
            val value = SettingsJsonValue(
            write = slot::write,
            writes++
        )
        // Re-reading through a fresh accessor proves the state lives in the string, not the memo.
        // Second load has nothing left to upgrade, so it must not write again.
        appSettings.setScheduledTasksJson("")
        assertEquals("", slot.raw)
        assertEquals("{not json at all", slot.raw)
        assertEquals(0, observed.size)
        assertEquals(0, slot.writes)
        assertEquals(1, slot.writes)
        assertEquals(Config(enabled = true, count = 4), value.get())
        assertEquals(emptyList(), TaskStore(appSettings).getAllTasks())
        assertEquals(emptyList(), list.get())
        assertEquals(keysBefore, settings.keys)
        assertEquals(listOf(Item("a", 1), Item("b", 2)), list.get())
        assertEquals(listOf(Item("a", 1), Item("b", 2)), slot.list().get())
        assertEquals(listOf(Item("a", 9), Item("b", 9)), list.get())
        assertEquals(listOf(Item("external", 1)), list.get())
        assertEquals(listOf(Item("legacy", 7)), list.get())
        assertEquals(listOf(listOf(Item("a"))), observed)
        assertTrue(slot.raw.contains("\"count\":4"))
        fun read(): String = raw
        fun write(value: String) {
        itemSerializer = serializer<Item>(),
        label = "test",
        list.get()
        list.update { it + Item("a") }
        list.update { it + Item("a", 1) }
        list.update { it + Item("b", 2) }
        listOf(unwritten, corrupt).forEach { slot ->
        migrate = migrate,
        migrate: ((List<Item>) -> List<Item>?)? = null,
        onWrite = onWrite,
        onWrite: ((List<Item>) -> Unit)? = null,
        read = ::read,
        recover = recover,
        recover: ((String) -> List<Item>?)? = null,
        slot.raw = """[{"id":"external","value":1}]"""
        val appSettings = AppSettings(MapSettings())
        val appSettings = AppSettings(settings)
        val corrupt = FakeSlot("]]not json[[")
        val keysBefore = settings.keys
        val list = slot.list()
        val list = slot.list(migrate = { decoded ->
        val list = slot.list(onWrite = { observed.add(it) })
        val list = slot.list(recover = { raw ->
        val observed = mutableListOf<List<Item>>()
        val settings = MapSettings()
        val slot = FakeSlot("""[{"id":"a","value":0},{"id":"b","value":0}]""")
        val slot = FakeSlot("""{"id":"legacy","value":7}""")
        val slot = FakeSlot("{not json at all")
        val slot = FakeSlot()
        val unwritten = FakeSlot()
        val value = SettingsJsonValue(
        value.update { it.copy(count = it.count + 1) }
        var writes = 0
        write = ::write,
        }
        })
     * A blank blob used to reach `TaskStore`'s decode and log an error before returning empty —
     * it was the one list store without a blank guard. The shared decoder gives every store the
     * same treatment.
     */
    )
    ) = SettingsJsonList(
    /**
    /** Stand-in for a pair of AppSettings accessors, with visibility into how often we wrote. */
    @Serializable
    @Test
    fun `a blank tasks blob reads as empty`() {
    fun `a fresh install reads an empty task list without touching settings`() {
    fun `a write behind the accessor's back is picked up on the next read`() {
    fun `corrupt list degrades to empty and leaves the raw value alone`() {
    fun `migrate hook upgrades rows and persists the upgrade once`() {
    fun `onWrite observes every write but not reads`() = runTest {
    fun `recover hook reads a legacy shape that no longer decodes`() {
    fun `unwritten list reads as empty without writing`() {
    fun `update round-trips through the persisted string`() = runTest {
    fun `value falls back to the default when unwritten or corrupt`() {
    fun `value update round-trips`() = runTest {
    private class FakeSlot(var raw: String = "") {
    private data class Config(val enabled: Boolean = true, val count: Int = 3)
    private data class Item(val id: String, val value: Int = 0)
    private fun FakeSlot.list(
    }
 * Contract for the shared settings-backed JSON persistence used by every store: an unwritten or
 * corrupt blob degrades to the default instead of throwing, reads never write, and
 * read-modify-write goes through one lock.
 */
/**
class SettingsJsonTest {
}
