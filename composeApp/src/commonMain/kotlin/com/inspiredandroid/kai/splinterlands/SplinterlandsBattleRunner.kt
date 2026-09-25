package com.inspiredandroid.kai.splinterlands
import com.inspiredandroid.kai.DaemonController
import com.inspiredandroid.kai.data.DataRepository
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                            it.copy(phase = BattlePhase.Error, isRunning = false, errorMessage = result.errorMessage)
                            llmPickedTeam = true,
                            serviceStatuses = serviceStatusUpdates.toMap(),
                            winningServiceName = best.modelName.ifBlank { best.instanceId },
                        )
                        ServiceResult(index, instanceId, null, modelName, null, listOf("deadline"))
                        activity(accountId, "LLM $instanceId: querying (timeout ${llmTimeout / 1000}s)")
                        it.copy(
                        llmPickedTeam = true,
                        logBattle(accountId, username, false, result.opponent, result.mana, result.rulesets, result.battleId)
                        logBattle(accountId, username, true, result.opponent, result.mana, result.rulesets, result.battleId)
                        processServiceResponse(instanceId, index, modelName, accountId, response, prompt, dedupSummoners, dedupMonsters, manaCap, maxMonsters, rulesets)
                        return
                        serviceStatuses = serviceStatusUpdates.toMap(),
                        tryCancelMatch(username, postingKey, jwt)
                        updateStatus(accountId) {
                        updateStatus(accountId) { it.copy(losses = it.losses + 1) }
                        updateStatus(accountId) { it.copy(phase = BattlePhase.Finished, isRunning = false) }
                        updateStatus(accountId) { it.copy(skips = it.skips + 1) }
                        updateStatus(accountId) { it.copy(wins = it.wins + 1) }
                        val response = dataRepository.askSilentlyWithInstance(instanceId, fullPrompt, timeoutMs = llmTimeout.coerceAtLeast(10_000))
                        winningServiceName = best.modelName.ifBlank { best.instanceId },
                        }
                    )
                    BattleOutcome.Fatal -> {
                    BattleOutcome.Loss -> {
                    BattleOutcome.NoEnergy -> {
                    BattleOutcome.Skip -> {
                    BattleOutcome.Win -> {
                    ServiceResult(index, instanceId, null, modelName, null, listOf(e.message ?: "error"))
                    accountId, instanceIds, fullPrompt, prompt, dedupSummoners, dedupMonsters,
                    activity(accountId, "LLM $instanceId: error: ${e.message}")
                    activity(accountId, "LLM: deadline, using ${best.modelName.ifBlank { best.instanceId }}")
                    bestResult = result
                    if (llmTimeout < 10_000) {
                    it.copy(
                    kotlinx.coroutines.withContext(kotlinx.coroutines.NonCancellable) {
                    manaCap, maxMonsters, rulesets, teamDeadlineMs,
                    queryJob.cancel()
                    return
                    return best.team
                    serviceStatusUpdates[best.instanceId] = LlmServiceStatus.Selected
                    stopRequested.remove(accountId)
                    throw e
                    updateStatus(accountId) {
                    updateStatus(accountId) { it.copy(phase = BattlePhase.Error, isRunning = false, errorMessage = "Too many consecutive errors") }
                    updateStatus(accountId) { it.copy(phase = BattlePhase.Finished, isRunning = false, isStopping = false) }
                    val llmTimeout = teamDeadlineMs - Clock.System.now().toEpochMilliseconds() - 5_000
                    }
                    } else {
                "Monster" -> monsters.add(buildCardEntry(card, detail))
                "Summoner" -> summoners.add(buildSummonerEntry(card, detail))
                )
                // Check graceful stop after battle completes
                // Deadline approaching — use best available result
                // Normal stop
                Clock.System.now().toEpochMilliseconds() + TEAM_DEADLINE_MS
                LlmServiceStatus.Failed
                LlmServiceStatus.InvalidResponse
                LlmServiceStatus.ValidResponse
                account = account,
                activity = battleActivities[accountId]?.toList() ?: emptyList(),
                activity(accountId, "LLM error: ${e.message}")
                activity(accountId, "LLM: selected ${best.modelName.ifBlank { best.instanceId }}")
                battleId = battleId,
                battleStartedAtMs = Clock.System.now().toEpochMilliseconds(),
                battlesPlayed++
                break
                consecutiveErrors = 0
                consecutiveErrors++
                continue
                currentMana = 0,
                currentMana = matchMana,
                currentOpponent = "",
                currentOpponent = opponent,
                currentRulesets = "",
                currentRulesets = matchRulesets,
                delay(10.seconds)
                if ("energy" in error.lowercase()) return BattleResult(BattleOutcome.NoEnergy)
                if (accountId in stopRequested) {
                if (best != null) {
                if (bestResult == null || result.priority < bestResult.priority) {
                if (consecutiveErrors >= MAX_CONSECUTIVE_ERRORS) {
                if (phase in CANCELABLE_PHASES) {
                if (result != null) return result
                kotlin.time.Instant.parse(expirationStr).toEpochMilliseconds() - 10_000
                llmPicked = llmPicked,
                llmPickedTeam = null,
                mana = mana,
                modelName = if (llmPicked == true) status.winningServiceName.ifBlank { store.getModelName() } else "",
                opponent = opponent,
                queryJob.cancel()
                resultChannel.receive()
                resultChannel.send(result)
                return BattleResult(BattleOutcome.Fatal, errorMessage = error.ifBlank { "Failed to queue for match" })
                return BattleResult(BattleOutcome.Loss, opponent, matchMana, matchRulesets)
                return best.team
                rulesets = rulesets,
                runBattleLoop(accountId)
                serviceStatusUpdates[best.instanceId] = LlmServiceStatus.Selected
                serviceStatuses = emptyMap(),
                status.copy(serviceStatuses = instanceIds.associateWith { LlmServiceStatus.Querying })
                teamDeadlineMs = 0L,
                teamDeadlineMs = teamDeadlineMs,
                throw e
                timestampMs = Clock.System.now().toEpochMilliseconds(),
                updateStatus(accountId) {
                updateStatus(accountId) { it.copy(errors = it.errors + 1, errorMessage = e.message ?: "") }
                updateStatus(accountId) { it.copy(phase = BattlePhase.Error, errorMessage = e.message ?: "Unknown error", isRunning = false) }
                val best = bestResult
                val error = result["error"]?.jsonPrimitive?.content ?: ""
                val modelName = store.getModelName(instanceId)
                val phase = getStatus(accountId).phase
                val result = queryServicesInParallel(
                val result = runOneBattle(accountId, username, postingKey, jwt, cardDetails)
                val result = try {
                when (result.outcome) {
                winningServiceName = "",
                won = won,
                }
                } catch (e: CancellationException) {
                } catch (e: Exception) {
            )
            ),
            // If we have a valid result and all higher-priority services have finished, use it now.
            // Set all services to Querying
            // Stop waiting 10s before deadline if we already have a valid result
            ?: matchInfo["opponent"]?.jsonPrimitive?.contentOrNull ?: ""
            BattleLogEntry(
            Clock.System.now().toEpochMilliseconds() + TEAM_DEADLINE_MS
            activity(accountId, "LLM $instanceId: empty response")
            activity(accountId, "LLM $instanceId: fixed")
            activity(accountId, "LLM $instanceId: parse failed")
            activity(accountId, "LLM $instanceId: valid team")
            activity(accountId, "LLM: ${dedupSummoners.size} summoners, ${dedupMonsters.size} monsters")
            activity(accountId, "LLM: querying ${instanceIds.size} services")
            activity(accountId, "No valid team found")
            api.postBattleTx(signedTx, jwt)
            completedPriorities.add(result.priority)
            delay(SLEEP_BETWEEN_BATTLES_MS.milliseconds)
            detailById[id] = obj
            existing["team_hash"]?.jsonPrimitive?.contentOrNull?.isNotBlank() == true
            filteredMonsters = filteredMonsters.filter { !it.isGladiator }
            if ("already been submitted" !in error) {
            if (best != null && (0 until best.priority).all { it in completedPriorities }) {
            if (color in inactiveColors || splinter in inactiveColors) continue
            if (result == null) {
            if (result.team != null) {
            if (result["success"]?.jsonPrimitive?.content?.toBoolean() != true) {
            it.copy(
            jobs.remove(accountId)
            jobs[accountId]?.cancel()
            map + (accountId to transform(current))
            matchInfo = api.pollForMatch(username, jwt, timeoutMs = 180_000)
            matchInfo = existing
            monsters, rulesets, false,
            queryScope.launch {
            receivedCount++
            return BattleResult(BattleOutcome.Skip, opponent, matchMana, matchRulesets)
            return BattleResult(outcome, opponentName, mana, rules, trxId)
            return ServiceResult(index, instanceId, TeamSelection(pick.summonerUid, pick.monsterUids, allyColor), modelName, pick, emptyList())
            return ServiceResult(index, instanceId, fixed, modelName, pick, emptyList())
            return ServiceResult(index, instanceId, null, modelName, null, listOf("empty response"))
            return ServiceResult(index, instanceId, null, modelName, null, listOf("parse failed"))
            return if (player1.equals(username, ignoreCase = true)) player2 else player1
            serviceStatusUpdates[result.instanceId] = status
            stopGracefully(accountId)
            stopRequested.remove(accountId)
            summoners, rulesets, true,
            try {
            updatePhase(accountId, BattlePhase.FindingMatch)
            updatePhase(accountId, BattlePhase.Idle)
            updatePhase(accountId, BattlePhase.WaitingForOpponent)
            updatePhase(accountId, BattlePhase.WaitingForResult)
            updateStatus(accountId) { it.copy(currentMana = mana, currentRulesets = rules) }
            updateStatus(accountId) { it.copy(currentOpponent = opponentName) }
            updateStatus(accountId) { it.copy(isRunning = false, phase = BattlePhase.Idle) }
            updateStatus(accountId) { it.copy(serviceStatuses = serviceStatusUpdates.toMap()) }
            updateStatus(accountId) { status ->
            val allyColor = determineDragonAllyColor(summonerEntry?.color, pick.monsterUids, dedupMonsters.associateBy { it.uid })
            val battle = api.getBattleResult(trxId, jwt, timeoutMs = 120_000)
            val best = bestResult
            val cancelData = """{"match_type":"Ranked","app":"$APP_VERSION","n":"$nonce"}"""
            val card = cardEl.jsonObject
            val cardType = detail["type"]?.jsonPrimitive?.content ?: continue
            val color = detail["color"]?.jsonPrimitive?.content ?: continue
            val current = map[accountId] ?: BattleStatus()
            val detail = detailById[detailId] ?: continue
            val detailId = card["card_detail_id"]?.jsonPrimitive?.int ?: continue
            val error = submitResult["error"]?.jsonPrimitive?.content ?: ""
            val findData = """{"match_type":"Wild Ranked","app":"$APP_VERSION","n":"$nonce"}"""
            val fullPrompt = prompt.systemPrompt + "\n\n" + prompt.userMessage
            val id = obj["id"]?.jsonPrimitive?.int ?: continue
            val mana = existing["mana_cap"]?.jsonPrimitive?.intOrNull ?: 0
            val nonce = generateSecret()
            val obj = cd.jsonObject
            val opponentName = extractOpponentName(battle, username)
            val outcome = if (winner == username) BattleOutcome.Win else BattleOutcome.Loss
            val prompt = buildLlmPrompt(dedupSummoners, dedupMonsters, matchInfo, maxMonsters)
            val receiveTimeout = (timeUntilDeadline - 10_000).coerceAtLeast(100)
            val result = api.postBattleTx(signedTx, jwt)
            val result = withTimeoutOrNull(receiveTimeout) {
            val rules = existing["ruleset"]?.jsonPrimitive?.contentOrNull ?: ""
            val signedTx = buildSignedCustomJson(username, postingKey, "sm_cancel_match", cancelData)
            val signedTx = buildSignedCustomJson(username, postingKey, "sm_find_match", findData)
            val splinter = COLOR_TO_SPLINTER[color] ?: color
            val status = if (result.team != null) {
            val summonerEntry = dedupSummoners.find { it.uid == pick.summonerUid }
            val timeUntilDeadline = teamDeadlineMs - Clock.System.now().toEpochMilliseconds()
            val trxId = existing["id"]?.jsonPrimitive?.contentOrNull ?: existing["trx_id"]?.jsonPrimitive?.contentOrNull ?: ""
            val winner = battle["winner"]?.jsonPrimitive?.contentOrNull
            when (cardType) {
            { it.color }, { it.rarity }, { it.attackType }, { it.attackPower },
            { it.mana }, { it.speed }, { it.armor }, { it.health },
            }
            } catch (_: CancellationException) {
            } catch (_: Exception) {
            } catch (e: CancellationException) {
            } catch (e: Exception) {
            } else if (result.pick != null) {
            } else {
        )
        ) {
        // Build summoner/monster lists for LLM
        // Check energy
        // Check outstanding match
        // Collect results in completion order — return as soon as best possible result is known
        // Detached scope so we return immediately without waiting for slow services to cancel
        // Fallback to simple picker
        // Fetch card details
        // Fetch collection
        // If team already submitted, wait for result
        // Ignore non-ranked matches
        // Login
        // Pick team
        // Query all configured services in parallel
        // Reset battle state
        // Submit team
        // Try silent fixes
        // Wait for result
        Fatal,
        Loss,
        NoEnergy,
        Skip,
        Win,
        _statuses.update { map ->
        _statuses.value = emptyMap()
        accountId: String,
        activity(accountId, "Collection: ${cards.size} cards")
        activity(accountId, "Energy: $energy")
        activity(accountId, "Fallback to auto picker")
        activity(accountId, "LLM $instanceId: invalid - ${issues.joinToString("; ")}")
        activity(accountId, "LLM $instanceId: response (${response.length} chars)")
        activity(accountId, "Matched vs $opponent ($matchMana mana, $matchRulesets)")
        activity(accountId, "Result: ${if (outcome == BattleOutcome.Win) "Victory" else "Defeat"} vs $opponentName")
        activity(accountId, "Team deadline: ${deadlineSec}s${if (expirationStr != null) " (from server)" else " (fallback)"}")
        activity(accountId, "Team picked (${team.monsterUids.size} monsters)")
        activity(accountId, "Team submitted")
        battleActivities.getOrPut(accountId) { mutableListOf() }.add(message)
        battleActivities[accountId] = mutableListOf()
        cardDetails: JsonArray,
        cards: JsonArray,
        daemonController.start()
        dedupMonsters: List<CardEntry>,
        dedupSummoners: List<SummonerEntry>,
        for (cardEl in cards) {
        for (cd in cardDetails) {
        fullPrompt: String,
        if (!hasConscript) {
        if (energy <= 0) return BattleResult(BattleOutcome.NoEnergy)
        if (existing != null && existing["mana_cap"]?.jsonPrimitive?.contentOrNull == null) existing = null
        if (existing != null && existing["opponent"]?.jsonPrimitive?.contentOrNull?.isNotBlank() == true &&
        if (existing != null && existing["opponent"]?.jsonPrimitive?.contentOrNull?.isNotBlank() == true) {
        if (filteredSummoners.isEmpty()) return null
        if (fixed != null) {
        if (instanceIds.isNotEmpty()) {
        if (issues.isEmpty()) {
        if (jobs[accountId]?.isActive == true) return
        if (phase in MID_BATTLE_PHASES) {
        if (pick == null) {
        if (player1 != null && player2 != null) {
        if (postingKey.isBlank()) throw RuntimeException("No posting key configured")
        if (response.isBlank()) {
        if (submitResult["success"]?.jsonPrimitive?.content?.toBoolean() != true) {
        if (team == null) {
        index: Int,
        instanceId: String,
        instanceIds.forEachIndexed { index, instanceId ->
        instanceIds: List<String>,
        jobs.clear()
        jobs.values.forEach { it.cancel() }
        jobs[accountId] = scope.launch {
        jwt: String,
        manaCap: Int,
        matchInfo: JsonObject,
        maxMonsters: Int,
        modelName: String,
        postingKey: String,
        prompt: LlmPromptResult,
        queryJob.cancel()
        response: String,
        return BattleResult(outcome, opponentName, matchMana, matchRulesets, trxId)
        return ServiceResult(index, instanceId, null, modelName, pick, issues)
        return if (winner != null && !winner.equals(username, ignoreCase = true)) winner else ""
        return null
        return pickTeam(cards, matchInfo, cardDetails)
        rulesets: Set<String>,
        stopRequested.add(accountId)
        stopRequested.clear()
        store.addBattleLogEntry(
        teamDeadlineMs: Long = Clock.System.now().toEpochMilliseconds() + TEAM_DEADLINE_MS,
        teamDeadlineMs: Long,
        try {
        updatePhase(accountId, BattlePhase.CheckingEnergy)
        updatePhase(accountId, BattlePhase.FetchingCollection)
        updatePhase(accountId, BattlePhase.FindingMatch)
        updatePhase(accountId, BattlePhase.LoggingIn)
        updatePhase(accountId, BattlePhase.PickingTeam)
        updatePhase(accountId, BattlePhase.SubmittingTeam)
        updatePhase(accountId, BattlePhase.WaitingForResult)
        updateStatus(accountId) {
        updateStatus(accountId) { BattleStatus(isRunning = true, phase = BattlePhase.LoggingIn) }
        updateStatus(accountId) { it.copy(currentOpponent = opponentName) }
        updateStatus(accountId) { it.copy(energy = energy) }
        updateStatus(accountId) { it.copy(isStopping = true) }
        updateStatus(accountId) { it.copy(llmPickedTeam = false) }
        updateStatus(accountId) { it.copy(phase = phase) }
        username: String,
        val account = store.getAccountById(accountId) ?: throw RuntimeException("No Splinterlands account configured")
        val allyColorJson = if (team.allyColor != null) "\"${team.allyColor}\"" else "null"
        val battle = api.getBattleResult(trxId, jwt, timeoutMs = 120_000)
        val battleId: String = "",
        val cardDetails = api.getCardDetails()
        val cards = api.getCollection(username, jwt)
        val completedPriorities = mutableSetOf<Int>()
        val deadlineSec = (teamDeadlineMs - Clock.System.now().toEpochMilliseconds()) / 1000
        val dedupMonsters = filteredMonsters.distinctBy { it.detailId }
        val dedupSummoners = filteredSummoners.distinctBy { it.detailId }
        val detailById = mutableMapOf<Int, JsonObject>()
        val energy = api.getEnergyPublic(username)
        val errorMessage: String = "",
        val expirationStr = matchInfo["submit_expiration_date"]?.jsonPrimitive?.contentOrNull
        val filteredSummoners = applyRulesetFilters(
        val fixed = applyFixes(pick.summonerUid, pick.monsterUids, dedupSummoners, dedupMonsters, manaCap, maxMonsters, rulesets)
        val hasConscript = filteredSummoners.any { "Conscript" in it.buffs.abilities }
        val inactiveColors = buildInactiveColors(inactiveStr)
        val inactiveStr = matchInfo["inactive"]?.jsonPrimitive?.contentOrNull ?: ""
        val instanceId: String,
        val instanceIds = store.getInstanceIds()
        val issues = validateTeam(pick.summonerUid, pick.monsterUids, dedupSummoners, dedupMonsters, manaCap, maxMonsters, rulesets)
        val issues: List<String>,
        val jwt = api.login(username, postingKey)
        val llmPicked = status.llmPickedTeam
        val mana: Int = 0,
        val manaCap = matchInfo["mana_cap"]?.jsonPrimitive?.intOrNull ?: 20
        val matchInfo: JsonObject
        val matchMana = matchInfo["mana_cap"]?.jsonPrimitive?.intOrNull ?: 0
        val matchRulesets = matchInfo["ruleset"]?.jsonPrimitive?.contentOrNull ?: ""
        val maxMonsters = getMaxMonsters(rulesets)
        val modelName: String,
        val monsters = mutableListOf<CardEntry>()
        val monstersJson = team.monsterUids.joinToString(",") { "\"$it\"" }
        val nonce = generateSecret()
        val opponent = matchInfo["opponent_player"]?.jsonPrimitive?.contentOrNull
        val opponent: String = "",
        val opponentName = extractOpponentName(battle, username).ifBlank { opponent }
        val outcome = if (winner == username) BattleOutcome.Win else BattleOutcome.Loss
        val outcome: BattleOutcome,
        val phase = getStatus(accountId).phase
        val pick = parseLlmPick(response, prompt.idMap)
        val pick: LlmPick?,
        val player1 = battle["player_1"]?.jsonPrimitive?.contentOrNull
        val player2 = battle["player_2"]?.jsonPrimitive?.contentOrNull
        val postingKey = store.getPostingKey(accountId)
        val priority: Int,
        val queryJob = SupervisorJob(currentCoroutineContext()[Job])
        val queryScope = CoroutineScope(currentCoroutineContext() + queryJob)
        val resultChannel = Channel<ServiceResult>(instanceIds.size)
        val rulesets = parseRulesets(matchInfo["ruleset"]?.jsonPrimitive?.contentOrNull ?: "")
        val rulesets: String = "",
        val secret = generateSecret()
        val serviceStatusUpdates = instanceIds.associateWith { LlmServiceStatus.Querying }.toMutableMap()
        val signedTx = buildSignedCustomJson(username, postingKey, "sm_submit_team", submitData)
        val status = getStatus(accountId)
        val submitData = """{"trx_id":"$trxId","team_hash":"$teamHash","summoner":"${team.summonerUid}","monsters":[$monstersJson],"secret":"$secret","match_type":"Ranked Wild","allyColor":$allyColorJson,"app":"$APP_VERSION","n":"$nonce"}"""
        val submitResult = api.postBattleTx(signedTx, jwt)
        val summoners = mutableListOf<SummonerEntry>()
        val team = pickTeamWithLlm(accountId, cards, matchInfo, cardDetails, teamDeadlineMs)
        val team: TeamSelection?,
        val teamDeadlineMs = if (expirationStr != null) {
        val teamHash = generateTeamHash(team.summonerUid, team.monsterUids, secret)
        val trxId = matchInfo["id"]?.jsonPrimitive?.contentOrNull ?: matchInfo["trx_id"]?.jsonPrimitive?.contentOrNull ?: ""
        val username = account.username.lowercase()
        val winner = battle["winner"]?.jsonPrimitive?.contentOrNull
        var battlesPlayed = 0
        var bestResult: ServiceResult? = null
        var consecutiveErrors = 0
        var existing = api.getOutstandingMatch(username, jwt)
        var filteredMonsters = applyRulesetFilters(
        var receivedCount = 0
        while (receivedCount < instanceIds.size) {
        while (true) {
        }
        } catch (_: Exception) {
        } else if (existing != null) {
        } else {
    )
    ): BattleResult {
    ): ServiceResult {
    ): TeamSelection? {
    @OptIn(ExperimentalTime::class)
    BattlePhase.FetchingCollection,
    BattlePhase.PickingTeam,
    BattlePhase.SubmittingTeam,
    BattlePhase.WaitingForOpponent,
    BattlePhase.WaitingForResult,
    fun getStatus(accountId: String): BattleStatus = _statuses.value[accountId] ?: BattleStatus()
    fun start(accountId: String) {
    fun stop() {
    fun stop(accountId: String) {
    fun stopGracefully(accountId: String) {
    private data class BattleResult(
    private data class ServiceResult(
    private enum class BattleOutcome {
    private fun activity(accountId: String, message: String) {
    private fun extractOpponentName(battle: JsonObject, username: String): String {
    private fun processServiceResponse(
    private fun updatePhase(accountId: String, phase: BattlePhase) {
    private fun updateStatus(accountId: String, transform: (BattleStatus) -> BattleStatus) {
    private suspend fun logBattle(accountId: String, account: String, won: Boolean, opponent: String, mana: Int, rulesets: String, battleId: String = "") {
    private suspend fun pickTeamWithLlm(
    private suspend fun queryServicesInParallel(
    private suspend fun runBattleLoop(accountId: String) {
    private suspend fun runOneBattle(
    private suspend fun tryCancelMatch(username: String, postingKey: String, jwt: String) {
    private val _statuses = MutableStateFlow<Map<String, BattleStatus>>(emptyMap())
    private val api: SplinterlandsApi,
    private val battleActivities = mutableMapOf<String, MutableList<String>>()
    private val daemonController: DaemonController,
    private val dataRepository: DataRepository,
    private val jobs = mutableMapOf<String, Job>()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val stopRequested = mutableSetOf<String>()
    private val store: SplinterlandsStore,
    val statuses: StateFlow<Map<String, BattleStatus>> = _statuses
    }
)
) {
class SplinterlandsBattleRunner(
private const val APP_VERSION = "splinterlands/0.7.176"
private const val MAX_CONSECUTIVE_ERRORS = 5
private const val SLEEP_BETWEEN_BATTLES_MS = 30_000L
private const val TEAM_DEADLINE_MS = 180_000L
private val CANCELABLE_PHASES = setOf(
private val MID_BATTLE_PHASES = setOf(
}
