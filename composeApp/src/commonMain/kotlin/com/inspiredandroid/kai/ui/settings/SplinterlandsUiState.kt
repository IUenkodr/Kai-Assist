package com.inspiredandroid.kai.ui.settings
import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.splinterlands.BattleLogEntry
import com.inspiredandroid.kai.splinterlands.BattleStatus
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

    data class Error(val message: String) : SplinterlandsAddStatus
    data object Idle : SplinterlandsAddStatus
    data object Testing : SplinterlandsAddStatus
    val accountId: String,
    val avatarUrl: String = "",
    val battleStatus: BattleStatus = BattleStatus(),
    val energy: Int = -1,
    val isSplinterlandsEnabled: Boolean = false,
    val onAddSplinterlandsService: (String) -> Unit = {},
    val onClearSplinterlandsBattleLog: () -> Unit = {},
    val onRemoveSplinterlandsAccount: (String) -> Unit = {},
    val onRemoveSplinterlandsService: (String) -> Unit = {},
    val onReorderSplinterlandsServices: (List<String>) -> Unit = {},
    val onStartSplinterlandsBattle: (String) -> Unit = {},
    val onStopSplinterlandsBattle: (String) -> Unit = {},
    val onTestAndAddSplinterlandsAccount: (String, String) -> Unit = { _, _ -> },
    val onToggleSplinterlands: (Boolean) -> Unit = {},
    val showSplinterlandsSection: Boolean = false,
    val splinterlandsAccounts: ImmutableList<SplinterlandsAccountUiState> = persistentListOf(),
    val splinterlandsAddStatus: SplinterlandsAddStatus = SplinterlandsAddStatus.Idle,
    val splinterlandsAvailableServices: ImmutableList<ServiceEntry> = persistentListOf(),
    val splinterlandsBattleLog: ImmutableList<BattleLogEntry> = persistentListOf(),
    val splinterlandsInstanceIds: ImmutableList<String> = persistentListOf(),
    val username: String,
)
@Immutable
data class SplinterlandsAccountUiState(
data class SplinterlandsUiState(
sealed interface SplinterlandsAddStatus {
}
