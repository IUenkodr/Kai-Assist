
                        splinterlandsAccounts = accounts.toImmutableList(),
                        splinterlandsAccounts = buildSplinterlandsAccountStates().toImmutableList(),
                        splinterlandsAddStatus = SplinterlandsAddStatus.Idle,
                        splinterlandsBattleLog = if (battleLogChanged) splinterlandsStore.getBattleLog().toImmutableList() else s.splinterlandsBattleLog,
                    "https://d36mxiodymuqjm.cloudfront.net/website/icons/avatars/avatar_$avatarId.png"
                    )
                    it.copy(
                    it.copy(splinterlandsAddStatus = SplinterlandsAddStatus.Error(e.message ?: "Login failed"))
                    s.copy(
                @Suppress("DEPRECATION")
                _state.update {
                _state.update { s ->
                accountId = account.id,
                async { fetchAccountAvatarAndEnergy(account.id, account.username.lowercase()) }
                avatarUrl = splinterlandsAvatarUrls[account.id] ?: "",
                battleStatus = bs,
                energy = energy,
                fetchAccountAvatarAndEnergy(id, uname)
                if (battleLogChanged) lastBattleCount = totalBattles
                isSplinterlandsEnabled = enabled,
                splinterlandsAccounts = buildSplinterlandsAccountStates().toImmutableList(),
                splinterlandsApi.login(uname, postingKey)
                splinterlandsAvatarUrls[accountId] =
                splinterlandsStore.saveAccount(SplinterlandsAccount(id = id, username = uname))
                splinterlandsStore.setPostingKey(id, postingKey)
                username = account.username,
                val accounts = buildSplinterlandsAccountStates()
                val battleLogChanged = totalBattles != lastBattleCount
                val id = splinterlandsStore.generateAccountId()
                val totalBattles = accounts.sumOf { a -> a.battleStatus.wins + a.battleStatus.losses }
                val uname = username.trim().lowercase()
                }
            )
            SplinterlandsAccountUiState(
            _state.update { it.copy(splinterlandsAccounts = buildSplinterlandsAccountStates().toImmutableList()) }
            _state.update { it.copy(splinterlandsBattleLog = persistentListOf()) }
            accounts.map { account ->
            current.add(instanceId)
            if (avatarId > 0) {
            it.copy(
            it.copy(splinterlandsAvailableServices = dataRepository.getServiceEntries().toImmutableList())
            splinterlandsBattleRunner.statuses.collect {
            splinterlandsBattleRunner.stop(accountId)
            splinterlandsEnergy[accountId] = energy
            splinterlandsStore.clearBattleLog()
            splinterlandsStore.removeAccount(accountId)
            splinterlandsStore.setInstanceIds(current)
            try {
            val avatarId = splinterlandsApi.getAvatarId(username)
            val bs = statuses[account.id] ?: BattleStatus()
            val energy = if (bs.energy >= 0) bs.energy else splinterlandsEnergy[account.id] ?: -1
            val energy = splinterlandsApi.getEnergyPublic(username)
            var lastBattleCount = _state.value.splinterlandsBattleLog.size
            }
            } catch (e: Exception) {
            }.awaitAll()
        _state.update {
        _state.update { it.copy(splinterlandsAccounts = buildSplinterlandsAccountStates().toImmutableList()) }
        _state.update { it.copy(splinterlandsAddStatus = SplinterlandsAddStatus.Testing) }
        _state.update { it.copy(splinterlandsInstanceIds = current.toImmutableList()) }
        _state.update { it.copy(splinterlandsInstanceIds = orderedIds.toImmutableList()) }
        battleStatusJobs.remove(accountId)
        battleStatusJobs[accountId] = viewModelScope.launch {
        battleStatusJobs[accountId]?.cancel()
        if (!enabled) splinterlandsBattleRunner.stop()
        if (accounts.isEmpty()) return
        if (enabled) fetchSplinterlandsAccountInfo()
        if (instanceId !in current) {
        if (splinterlandsStore.isEnabled()) fetchSplinterlandsAccountInfo()
        initialValue = _state.value,
        isSplinterlandsEnabled = splinterlandsStore.isEnabled(),
        onAddSplinterlandsService = ::onAddSplinterlandsService,
        onClearSplinterlandsBattleLog = ::onClearSplinterlandsBattleLog,
        onRemoveSplinterlandsAccount = ::onRemoveSplinterlandsAccount,
        onRemoveSplinterlandsService = ::onRemoveSplinterlandsService,
        onReorderSplinterlandsServices = ::onReorderSplinterlandsServices,
        onStartSplinterlandsBattle = ::onStartSplinterlandsBattle,
        onStopSplinterlandsBattle = ::onStopSplinterlandsBattle,
        onTestAndAddSplinterlandsAccount = ::onTestAndAddSplinterlandsAccount,
        onToggleSplinterlands = ::onToggleSplinterlands,
        return splinterlandsStore.getAccounts().map { account ->
        scope = viewModelScope,
        showSplinterlandsSection = isSplinterlandsSupported,
        splinterlandsAccounts = buildSplinterlandsAccountStates().toImmutableList(),
        splinterlandsAvailableServices = dataRepository.getServiceEntries().toImmutableList(),
        splinterlandsBattleLog = splinterlandsStore.getBattleLog().toImmutableList(),
        splinterlandsBattleRunner.start(accountId)
        splinterlandsBattleRunner.stop(accountId)
        splinterlandsInstanceIds = splinterlandsStore.getInstanceIds().toImmutableList(),
        splinterlandsStore.setEnabled(enabled)
        splinterlandsStore.setInstanceIds(current)
        splinterlandsStore.setInstanceIds(orderedIds)
        started = SharingStarted.WhileSubscribed(5_000),
        try {
        val accounts = splinterlandsStore.getAccounts().filter { it.username.isNotBlank() }
        val current = splinterlandsStore.getInstanceIds().filter { it != instanceId }
        val current = splinterlandsStore.getInstanceIds().toMutableList()
        val statuses = splinterlandsBattleRunner.statuses.value
        viewModelScope.launch(backgroundDispatcher) {
        }
        } catch (_: Exception) { }
    )
    fun onScreenVisible() {
    private fun buildFullState(): SplinterlandsUiState = SplinterlandsUiState(
    private fun buildSplinterlandsAccountStates(): List<SplinterlandsAccountUiState> {
    private fun fetchSplinterlandsAccountInfo() {
    private fun onAddSplinterlandsService(instanceId: String) {
    private fun onClearSplinterlandsBattleLog() {
    private fun onRemoveSplinterlandsAccount(accountId: String) {
    private fun onRemoveSplinterlandsService(instanceId: String) {
    private fun onReorderSplinterlandsServices(orderedIds: List<String>) {
    private fun onStartSplinterlandsBattle(accountId: String) {
    private fun onStopSplinterlandsBattle(accountId: String) {
    private fun onTestAndAddSplinterlandsAccount(username: String, postingKey: String) {
    private fun onToggleSplinterlands(enabled: Boolean) {
    private suspend fun fetchAccountAvatarAndEnergy(accountId: String, username: String) {
    private val _state = MutableStateFlow(buildFullState())
    private val backgroundDispatcher: CoroutineContext = getBackgroundDispatcher(),
    private val battleStatusJobs = mutableMapOf<String, Job>()
    private val dataRepository: DataRepository,
    private val splinterlandsApi: SplinterlandsApi,
    private val splinterlandsAvatarUrls = mutableMapOf<String, String>()
    private val splinterlandsBattleRunner: SplinterlandsBattleRunner,
    private val splinterlandsEnergy = mutableMapOf<String, Int>()
    private val splinterlandsStore: SplinterlandsStore,
    val state = _state.stateIn(
    }
) : ViewModel() {
class SplinterlandsViewModel(
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.isSplinterlandsSupported
import com.inspiredandroid.kai.splinterlands.BattleStatus
import com.inspiredandroid.kai.splinterlands.SplinterlandsAccount
import com.inspiredandroid.kai.splinterlands.SplinterlandsApi
import com.inspiredandroid.kai.splinterlands.SplinterlandsBattleRunner
import com.inspiredandroid.kai.splinterlands.SplinterlandsStore
import kotlin.coroutines.CoroutineContext
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
package com.inspiredandroid.kai.ui.settings
}
