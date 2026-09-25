import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

                losses = losses,
                modelName = "Auto Picker",
                modelName = name,
                total = entries.size,
                total = fallbackEntries.size,
                winRate = if (entries.isNotEmpty()) wins.toDouble() / entries.size else 0.0,
                winRate = wins.toDouble() / fallbackEntries.size,
                wins = wins,
            )
            ),
            ModelStats(
            val losses = entries.size - wins
            val wins = entries.count { it.won }
        )
        .filter { it.llmPicked == true && it.modelName.isNotBlank() }
        .groupBy { it.modelName }
        .map { (name, entries) ->
        emptyList()
        listOf(
        val losses = fallbackEntries.size - wins
        val wins = fallbackEntries.count { it.won }
        }
    "Death" to "Black",
    "Dragon" to "Gold",
    "Earth" to "Green",
    "Fire" to "Red",
    "Life" to "White",
    "Neutral" to "Gray",
    "Water" to "Blue",
    CheckingEnergy,
    Error,
    Failed,
    FetchingCollection,
    FindingMatch,
    Finished,
    Idle,
    InvalidResponse,
    LoggingIn,
    PickingTeam,
    Querying,
    Selected,
    SubmittingTeam,
    ValidResponse,
    WaitingForOpponent,
    WaitingForResult,
    return (llmStats + fallbackStats).sortedByDescending { it.winRate }
    val abilities: List<String> = emptyList(),
    val abilities: List<String>,
    val account: String = "",
    val activity: List<String> = emptyList(),
    val allyColor: String?,
    val armor: Int = 0,
    val armor: Int,
    val attack: Int = 0,
    val attackPower: Int,
    val attackType: String,
    val battleId: String = "",
    val battleStartedAtMs: Long = 0L,
    val buffs: SummonerBuffs,
    val color: String,
    val currentMana: Int = 0,
    val currentOpponent: String = "",
    val currentRulesets: String = "",
    val detailId: Int,
    val energy: Int = -1,
    val errorMessage: String = "",
    val errors: Int = 0,
    val fallbackEntries = battleLog.filter { it.llmPicked == false }
    val fallbackStats = if (fallbackEntries.isNotEmpty()) {
    val health: Int = 0,
    val health: Int,
    val id: String = "",
    val isGladiator: Boolean,
    val isRunning: Boolean = false,
    val isStopping: Boolean = false,
    val llmPicked: Boolean? = null,
    val llmPickedTeam: Boolean? = null,
    val llmStats = battleLog
    val losses: Int = 0,
    val losses: Int,
    val magic: Int = 0,
    val mana: Int = 0,
    val mana: Int,
    val modelName: String = "",
    val modelName: String,
    val monsterUids: List<String>,
    val name: String,
    val opponent: String,
    val phase: BattlePhase = BattlePhase.Idle,
    val ranged: Int = 0,
    val rarity: String,
    val rulesets: String = "",
    val serviceStatuses: Map<String, LlmServiceStatus> = emptyMap(),
    val skips: Int = 0,
    val speed: Int = 0,
    val speed: Int,
    val splinter: String,
    val summonerUid: String,
    val teamDeadlineMs: Long = 0L,
    val timestampMs: Long = 0L,
    val total: Int,
    val uid: String,
    val username: String,
    val winRate: Double,
    val winningServiceName: String = "",
    val wins: Int = 0,
    val wins: Int,
    val won: Boolean,
    }
    } else {
)
// Card data structures matching the Splinterlands API
@Immutable
@Serializable
data class BattleLogEntry(
data class BattleStatus(
data class CardEntry(
data class ModelStats(
data class SplinterlandsAccount(
data class SummonerBuffs(
data class SummonerEntry(
data class TeamSelection(
enum class BattlePhase {
enum class LlmServiceStatus {
fun computeModelStats(battleLog: List<BattleLogEntry>): List<ModelStats> {
package com.inspiredandroid.kai.splinterlands
val COLOR_TO_SPLINTER = SPLINTER_COLORS.entries.associate { (k, v) -> v to k }
val RARITY_INT_TO_NAME = mapOf(1 to "Common", 2 to "Rare", 3 to "Epic", 4 to "Legendary")
val SPLINTER_COLORS = mapOf(
}
