import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.SettingsJsonList
import com.inspiredandroid.kai.data.SharedJson
import com.inspiredandroid.kai.data.getInstanceEffectiveModelId
import kotlinx.serialization.serializer

                current + account
                current.map { if (it.id == account.id) account else it }
                listOf(if (single.id.isEmpty()) single.copy(id = generateAccountId()) else single)
                val single = json.decodeFromString<SplinterlandsAccount>(raw)
            if (current.any { it.id == account.id }) {
            runCatching {
            }
            } else {
            }.getOrNull()
        // Clear per-account posting key
        // Keep legacy single field in sync for backwards compat
        // Migrate from single instance if set
        // Pre-multi-account installs persisted a single account object rather than a list.
        accounts.update { current ->
        accounts.update { current -> current.filterNot { it.id == accountId } }
        appSettings.setSplinterlandsEnabled(enabled)
        appSettings.setSplinterlandsInstanceId(ids.firstOrNull() ?: "")
        appSettings.setSplinterlandsPostingKey(accountId, "")
        appSettings.setSplinterlandsPostingKey(accountId, key)
        battleLog.update { (listOf(entry) + it).take(MAX_BATTLE_LOG_ENTRIES) }
        battleLog.update { emptyList() }
        if (instanceId.isBlank()) return ""
        if (stored.isNotEmpty()) return stored
        instanceIds.set(ids)
        itemSerializer = serializer<BattleLogEntry>(),
        itemSerializer = serializer<SplinterlandsAccount>(),
        itemSerializer = serializer<String>(),
        label = "SplinterlandsStore.accounts",
        label = "SplinterlandsStore.battleLog",
        label = "SplinterlandsStore.instanceIds",
        private const val MAX_BATTLE_LOG_ENTRIES = 500
        read = appSettings::getSplinterlandsAccountJson,
        read = appSettings::getSplinterlandsBattleLogJson,
        read = appSettings::getSplinterlandsInstanceIdsJson,
        recover = { raw ->
        return appSettings.getInstanceEffectiveModelId(instanceId)
        return buildString { repeat(8) { append(chars.random()) } }
        return if (single.isNotBlank()) listOf(single) else emptyList()
        val chars = "abcdefghijklmnopqrstuvwxyz0123456789"
        val instanceId = getInstanceId()
        val single = getInstanceId()
        val stored = instanceIds.get()
        write = appSettings::setSplinterlandsAccountJson,
        write = appSettings::setSplinterlandsBattleLogJson,
        write = appSettings::setSplinterlandsInstanceIdsJson,
        }
        },
    )
    // ── Global LLM instance for all accounts ──
    // ── Multi-account support ──
    // ── Multi-service LLM instances (priority order) ──
    companion object {
    fun getAccountById(id: String): SplinterlandsAccount? = getAccounts().find { it.id == id }
    fun getAccounts(): List<SplinterlandsAccount> = accounts.get()
    fun getBattleLog(): List<BattleLogEntry> = battleLog.get()
    fun getInstanceId(): String = appSettings.getSplinterlandsInstanceId()
    fun getInstanceIds(): List<String> {
    fun getModelName(): String {
    fun getModelName(instanceId: String): String {
    fun getPostingKey(accountId: String): String = appSettings.getSplinterlandsPostingKey(accountId)
    fun isEnabled(): Boolean = appSettings.isSplinterlandsEnabled()
    fun setEnabled(enabled: Boolean) {
    fun setInstanceIds(ids: List<String>) {
    internal fun generateAccountId(): String {
    private val accounts = SettingsJsonList(
    private val battleLog = SettingsJsonList(
    private val instanceIds = SettingsJsonList(
    private val json = SharedJson
    suspend fun addBattleLogEntry(entry: BattleLogEntry) {
    suspend fun clearBattleLog() {
    suspend fun removeAccount(accountId: String) {
    suspend fun saveAccount(account: SplinterlandsAccount) {
    suspend fun setPostingKey(accountId: String, key: String) {
    }
class SplinterlandsStore(private val appSettings: AppSettings) {
package com.inspiredandroid.kai.splinterlands
}
