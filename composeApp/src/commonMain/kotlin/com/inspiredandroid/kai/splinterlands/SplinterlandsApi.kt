package com.inspiredandroid.kai.splinterlands
import com.inspiredandroid.kai.data.SharedJson
import com.inspiredandroid.kai.httpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.http.parameters
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.delay
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                            return (balance + elapsedSec / 3600.0).toInt().coerceAtMost(50)
                            val elapsedSec = (nowMs - lastMs) / 1000.0
                            val lastMs = kotlin.time.Instant.parse(lastRewardTime).toEpochMilliseconds()
                            val nowMs = Clock.System.now().toEpochMilliseconds()
                        try {
                        } catch (_: Exception) { /* fall through */ }
                    if (lastRewardTime.isNotBlank()) {
                    return balance.toInt().coerceAtMost(50)
                    val balance = obj["balance"]?.jsonPrimitive?.content?.toDoubleOrNull() ?: 0.0
                    val lastRewardTime = obj["last_reward_time"]?.jsonPrimitive?.contentOrNull ?: ""
                    }
                append("signed_tx", signedTx)
                applyAuth(jwt)
                continue
                delay(intervalMs.milliseconds)
                if (obj["token"]?.jsonPrimitive?.content == "ECR") {
                parameter("id", battleId)
                parameter("key", "1")
                return data.jsonObject
                return match
                val obj = item.jsonObject
                }
            ?: throw RuntimeException("Login failed: ${resp.bodyAsText()}")
            applyAuth(jwt)
            delay(intervalMs.milliseconds)
            element.jsonObject
            for (item in data.jsonArray) {
            formParameters = parameters {
            header("Authorization", "Bearer $jwt")
            header("Origin", "https://splinterlands.com")
            header("Referer", "https://splinterlands.com/")
            if (data is JsonObject && data["winner"]?.jsonPrimitive?.content?.isNotBlank() == true) {
            if (match != null && match["opponent"]?.jsonPrimitive?.contentOrNull?.isNotBlank() == true) {
            if (trimmed.isEmpty() || !trimmed.startsWith("{")) {
            json.parseToJsonElement("""{"success":true}""").jsonObject
            parameter("name", username)
            parameter("sig", sig)
            parameter("ts", ts)
            parameter("username", username)
            return json.parseToJsonElement("""{"success":true}""").jsonObject
            url = "$battleBase/battle/battle_tx",
            val data = json.parseToJsonElement(trimmed)
            val match = getOutstandingMatch(username, jwt)
            val resp = client.get("$apiBase/battle/result") {
            val text = resp.bodyAsText()
            val trimmed = text.trim()
            }
            },
        ) {
        header("Authorization", "Bearer $jwt")
        header("Origin", "https://splinterlands.com")
        header("Referer", "https://splinterlands.com/")
        if (data is JsonArray) {
        if (trimmed.isEmpty() || !trimmed.startsWith("{")) return null
        if (trimmedBody.isEmpty() || !trimmedBody.startsWith("{")) {
        return 0
        return data["avatar_id"]?.jsonPrimitive?.int ?: 0
        return data["cards"]?.jsonArray ?: JsonArray(emptyList())
        return data["jwt_token"]?.jsonPrimitive?.content
        return if (data is JsonObject && data.isNotEmpty()) data.jsonObject else null
        return if (element is JsonObject) {
        return json.parseToJsonElement(resp.bodyAsText()).jsonArray
        throw RuntimeException("Battle result not available within ${timeoutMs / 1000}s")
        throw RuntimeException("No match found within ${timeoutMs / 1000}s")
        val body = resp.bodyAsText()
        val data = json.parseToJsonElement(resp.bodyAsText())
        val data = json.parseToJsonElement(resp.bodyAsText()).jsonObject
        val data = json.parseToJsonElement(trimmed)
        val deadline = currentTimeMs() + timeoutMs
        val element = json.parseToJsonElement(trimmedBody)
        val message = username + ts
        val resp = client.get("$api2Base/cards/collection/$username") {
        val resp = client.get("$api2Base/cards/get_details")
        val resp = client.get("$api2Base/players/balances") {
        val resp = client.get("$api2Base/players/details") {
        val resp = client.get("$api2Base/players/login") {
        val resp = client.get("$apiBase/players/outstanding_match") {
        val resp = client.submitForm(
        val sig = signMessage(message, postingKeyWif)
        val text = resp.bodyAsText()
        val trimmed = text.trim()
        val trimmedBody = body.trim()
        val ts = Clock.System.now().toEpochMilliseconds()
        while (currentTimeMs() < deadline) {
        }
        } else {
    @OptIn(ExperimentalTime::class)
    private fun currentTimeMs(): Long = Clock.System.now().toEpochMilliseconds()
    private fun io.ktor.client.request.HttpRequestBuilder.applyAuth(jwt: String) {
    private val api2Base = "https://api2.splinterlands.com"
    private val apiBase = "https://api.splinterlands.com"
    private val battleBase = "https://battle.splinterlands.com"
    private val client = httpClient()
    private val json = SharedJson
    suspend fun getAvatarId(username: String): Int {
    suspend fun getBattleResult(battleId: String, jwt: String, timeoutMs: Long = 120_000, intervalMs: Long = 5_000): JsonObject {
    suspend fun getCardDetails(): JsonArray {
    suspend fun getCollection(username: String, jwt: String): JsonArray {
    suspend fun getEnergyPublic(username: String): Int {
    suspend fun getOutstandingMatch(username: String, jwt: String): JsonObject? {
    suspend fun login(username: String, postingKeyWif: String): String {
    suspend fun pollForMatch(username: String, jwt: String, timeoutMs: Long = 180_000, intervalMs: Long = 3_000): JsonObject {
    suspend fun postBattleTx(signedTx: String, jwt: String): JsonObject {
    }
class SplinterlandsApi {
}
