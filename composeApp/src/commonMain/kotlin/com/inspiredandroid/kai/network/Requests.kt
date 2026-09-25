package com.inspiredandroid.kai.network
import com.inspiredandroid.kai.Version
import com.inspiredandroid.kai.currentPlatform
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.httpClient
import com.inspiredandroid.kai.isDebugBuild
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicChatRequestDto
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicChatResponseDto
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicModelsResponseDto
import com.inspiredandroid.kai.network.dtos.gemini.FunctionDeclaration
import com.inspiredandroid.kai.network.dtos.gemini.FunctionParameters
import com.inspiredandroid.kai.network.dtos.gemini.GeminiChatRequestDto
import com.inspiredandroid.kai.network.dtos.gemini.GeminiChatResponseDto
import com.inspiredandroid.kai.network.dtos.gemini.GeminiModelsResponseDto
import com.inspiredandroid.kai.network.dtos.gemini.GeminiTool
import com.inspiredandroid.kai.network.dtos.gemini.PropertySchema
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatResponseDto
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleModelResponseDto
import com.inspiredandroid.kai.network.dtos.openairesponses.OpenAIResponsesRequestDto
import com.inspiredandroid.kai.network.dtos.openairesponses.OpenAIResponsesResponseDto
import com.inspiredandroid.kai.network.tools.Tool
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.EMPTY
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlin.time.Duration.Companion.seconds
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                        contents = messages,
                        input = input,
                        max_tokens = 8192,
                        messages = messages,
                        model = credentials.modelId,
                        model = credentials.modelId.ifEmpty { null },
                        model = model,
                        system = systemInstruction,
                        systemInstruction = systemContent,
                        throw GeminiGenericException("Chat request failed: ${response.status}")
                        throw GeminiInvalidApiKeyException()
                        tools = tools.toRequestTools { it.toAnthropicTool() },
                        tools = tools.toRequestTools { it.toGeminiTool() },
                        tools = tools.toRequestTools { it.toRequestTool() },
                        tools = tools.toRequestTools { it.toResponsesTool() },
                    ),
                    .orEmpty()
                    ?.mapNotNull { (it as? JsonPrimitive)?.contentOrNull?.takeIf { s -> s.isNotBlank() } }
                    AnthropicChatRequestDto(
                    GeminiChatRequestDto(
                    OpenAICompatibleChatRequestDto(
                    OpenAIResponsesRequestDto(
                    encodeDefaults = true
                    explicitNulls = false
                    haystack.contains("exhausted", ignoreCase = true) ||
                    haystack.contains("quota", ignoreCase = true) ||
                    haystack.contains("spending limit", ignoreCase = true) ||
                    haystack.contains("subscription", ignoreCase = true) ||
                    haystack.contains("upgrade", ignoreCase = true)
                    if (responseBody.contains("API_KEY_INVALID", ignoreCase = true)) {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                    properties = propertySchemas(GeminiSchemaDialect),
                    required = requiredParameterNames(),
                    throw OpenAICompatibleContentModerationException(moderationDetail)
                    throw OpenAICompatibleQuotaExhaustedException()
                    val responseBody = response.bodyAsText()
                    }
                    } else {
                )
                ) {
                ),
                400, 403 -> throw GeminiInvalidApiKeyException()
                401, 403 -> throw OpenAICompatibleInvalidApiKeyException()
                403 -> throw GeminiInvalidApiKeyException()
                429 -> throw GeminiRateLimitExceededException()
                ?.joinToString(", ")
                ?.let { "flagged for '$it'" }
                Json {
                OpenAICompatibleErrorDetail(message, code, type, reasons)
                Result.success(OpenAICompatibleModelResponseDto(data = models))
                Result.success(response.body())
                apiKey?.let { bearerAuth(it) }
                applySessionHeader(service, sessionId)
                applyTimeout(requestTimeoutMs)
                code = null,
                contentType(ContentType.Application.Json)
                customHeaders.forEach { (k, v) -> header(k, v) }
                description = schema.description,
                e,
                e.message?.takeIf { it.isNotBlank() } ?: "Unexpected error: $name",
                else -> throw GeminiGenericException("Failed to fetch models: ${response.status}")
                else -> throw OpenAICompatibleGenericException("Failed to validate OpenRouter API key: ${response.status}")
                else -> {
                header("anthropic-version", "2023-06-01")
                header("x-api-key", apiKey)
                header("x-goog-api-key", apiKey)
                if (haystack.contains("credit", ignoreCase = true) ||
                if (parsed.looksLikeContentPolicyViolation()) {
                level = LogLevel.BODY
                level = LogLevel.NONE
                logger = DebugKtorLogger()
                logger = Logger.EMPTY
                message = error.content.takeIf { it.isNotBlank() },
                msg.contains("flagged", ignoreCase = true)
                msg.contains("moderation", ignoreCase = true) ||
                name = schema.name,
                parameters = FunctionParameters(
                parts = listOf(GeminiChatRequestDto.Part(text = it)),
                properties = propertySchemas(OpenAISchemaDialect),
                reasons = emptyList(),
                required = requiredParameterNames(),
                setBody(
                throw OpenAICompatibleBadRequestException(parsed.message)
                throw OpenAICompatibleGenericException("${service.displayName}: $detail")
                type = null,
                val code = (obj["code"] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
                val detail = parsed.message ?: "${response.status}"
                val haystack = parsed.message ?: responseBody
                val message = obj["message"]?.jsonPrimitive?.content?.takeIf { it.isNotBlank() }
                val models: List<OpenAICompatibleModelResponseDto.Model> = response.body()
                val obj = error.jsonObject
                val reasons = (obj["metadata"] as? JsonObject)?.get("reasons")?.let { it as? JsonArray }
                val type = (obj["type"] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
                }
                },
            )
            ),
            // TextContent avoids ContentNegotiation re-encoding a raw String as a JSON string.
            400 -> {
            401 -> throw OpenAICompatibleInvalidApiKeyException()
            401, 403 -> throw AnthropicInvalidApiKeyException()
            401, 403 -> throw OpenAICompatibleInvalidApiKeyException()
            402 -> throw OpenAICompatibleQuotaExhaustedException()
            403 -> throw OpenAICompatibleContentModerationException(moderationDetail)
            404 -> throw OpenAICompatibleModelNotFoundException()
            408, 504 -> throw OpenAICompatibleTimeoutException()
            413 -> throw OpenAICompatibleRequestTooLargeException()
            429 -> throw AnthropicRateLimitExceededException()
            429 -> throw OpenAICompatibleRateLimitExceededException()
            500, 502 -> throw OpenAICompatibleProviderErrorException(parsed.message)
            503 -> throw OpenAICompatibleServiceUnavailableException()
            529 -> throw AnthropicOverloadedException()
            ?: return Result.failure(OpenAICompatibleGenericException("Models URL not configured for ${service.displayName}"))
            ?: throw OpenAICompatibleGenericException("Responses URL not configured for ${service.displayName}")
            FunctionDeclaration(
            GeminiChatRequestDto.Content(
            OpenAICompatibleConnectionException()
            OpenAICompatibleGenericException(
            Result.success(Unit)
            Result.success(dto)
            Result.success(response.body())
            agent = "Kai/${Version.appVersion} (${currentPlatform.displayName})"
            apiKey?.let { bearerAuth(it) }
            applySessionHeader(service, sessionId = null)
            bearerAuth(apiKey)
            defaultClient.get("https://api.anthropic.com/v1/models") {
            defaultClient.get("https://generativelanguage.googleapis.com/v1beta/models") {
            defaultClient.post("${Service.Gemini.chatUrl}$selectedModelId:generateContent") {
            defaultClient.post(Service.Anthropic.chatUrl) {
            defaultClient.post(url) {
            description = schema.description,
            else -> throw OpenAICompatibleGenericException("Failed to validate Perplexity API key: ${response.status}")
            else -> {
            error == null -> OpenAICompatibleErrorDetail(null, null, null, emptyList())
            error is JsonPrimitive -> OpenAICompatibleErrorDetail(
            handleOpenAICompatibleError(service, credentials, response)
            if (code?.equals("content_policy_violation", ignoreCase = true) == true) return true
            if (isDebugBuild) {
            if (service.modelsResponseIsArray) {
            if (type?.contains("content_filter", ignoreCase = true) == true) return true
            if (type?.contains("content_policy", ignoreCase = true) == true) return true
            in 200..499 -> Result.success(Unit)
            json(
            name = schema.name,
            name.contains("ConnectException", ignoreCase = true) ||
            name.contains("NoRoute", ignoreCase = true) ||
            name.contains("SocketException", ignoreCase = true) ||
            name.contains("Timeout", ignoreCase = true) ||
            name.contains("UnknownHost", ignoreCase = true) ||
            name.contains("Unresolved", ignoreCase = true)
            parameters = OpenAICompatibleChatRequestDto.Parameters(
            println("[KTOR] $message")
            properties = propertySchemas(AnthropicSchemaDialect),
            properties = propertySchemas(OpenAISchemaDialect),
            requestTimeoutMillis = 180.seconds.inWholeMilliseconds
            required = requiredParameterNames(),
            return msg.contains("content policy", ignoreCase = true) ||
            return reasonText ?: message
            setBody(TextContent("""{"model":"sonar","messages":[]}""", ContentType.Application.Json))
            socketTimeoutMillis = 180.seconds.inWholeMilliseconds
            throw AnthropicInsufficientCreditsException()
            throwAnthropicError(response.status.value, responseBody)
            val dto = anthropicJson.decodeFromString(AnthropicChatResponseDto.serializer(), responseBody)
            val dto = anthropicJson.decodeFromString(AnthropicModelsResponseDto.serializer(), responseBody)
            val msg = message ?: return false
            val reasonText = reasons.takeIf { it.isNotEmpty() }
            when (response.status.value) {
            }
            } else {
        "${credentials.baseUrl.ifEmpty { Service.DEFAULT_OPENAI_COMPATIBLE_BASE_URL }.trimEnd('/')}$path"
        ),
        .firstOrNull { it != "null" }
        .mapNotNull { (it as? JsonPrimitive)?.contentOrNull }
        ?.contentOrNull?.toBooleanStrictOrNull()
        ?: "string"
        ?: dialect.property(type = param.type, description = param.description)
        OpenAICompatibleErrorDetail(null, null, null, emptyList())
        Result.failure(AnthropicGenericException("Anthropic: ${e.message}", e))
        Result.failure(GeminiGenericException("Connection failed", e))
        Result.failure(OpenAICompatibleConnectionException())
        Result.failure(e)
        Result.failure(mapOpenAICompatibleException(e))
        additionalProperties = additionalProperties,
        additionalProperties: Boolean? = null,
        additionalProperties: Boolean?,
        credentials: ServiceCredentials,
        customHeaders: Map<String, String> = emptyMap(),
        description = description,
        description = schema.description,
        description = schemaString("description"),
        description: String? = null,
        description: String?,
        enum = enum,
        enum = schemaStringList("enum"),
        enum: List<String>? = null,
        enum: List<String>?,
        errorObj?.get("message")?.jsonPrimitive?.content
        explicitNulls = false
        fun looksLikeContentPolicyViolation(): Boolean {
        fun moderationDetail(): String? {
        function = OpenAICompatibleChatRequestDto.Function(
        functionDeclarations = listOf(
        if (!service.requiresApiKey && !service.supportsOptionalApiKey) return null
        if (errorMessage != null && errorMessage.contains("credit balance", ignoreCase = true)) {
        if (response.status.isSuccess()) {
        if (service.requiresApiKey && key.isEmpty()) throw OpenAICompatibleInvalidApiKeyException()
        ignoreUnknownKeys = true
        input: List<JsonObject>,
        input_schema = AnthropicChatRequestDto.InputSchema(
        install(ContentNegotiation) {
        install(HttpTimeout) {
        install(Logging) {
        install(UserAgent) {
        items = items ?: if (type == "array") dialect.defaultStringItems else null,
        items = items,
        items: AnthropicChatRequestDto.PropertySchema?,
        items: OpenAICompatibleChatRequestDto.PropertySchema?,
        items: PropertySchema?,
        items: T? = null,
        messages: List<AnthropicChatRequestDto.Message>,
        messages: List<GeminiChatRequestDto.Content>,
        messages: List<OpenAICompatibleChatRequestDto.Message>,
        name = schema.name,
        null
        override fun log(message: String) {
        parameters = OpenAICompatibleChatRequestDto.Parameters(
        path
        properties = properties,
        properties: Map<String, AnthropicChatRequestDto.PropertySchema>?,
        properties: Map<String, OpenAICompatibleChatRequestDto.PropertySchema>?,
        properties: Map<String, PropertySchema>?,
        properties: Map<String, T>? = null,
        requestTimeoutMillis = requestTimeoutMs
        requestTimeoutMs: Long? = null,
        required = required,
        required = schemaStringList("required"),
        required: List<String>? = null,
        required: List<String>?,
        response: HttpResponse,
        return credentials.apiKey.ifEmpty { null }
        return if (looksLikeNetworkFailure) {
        return key.ifEmpty { null }
        service: Service,
        sessionId: String? = null,
        socketTimeoutMillis = requestTimeoutMs
        systemInstruction: String? = null,
        throw AnthropicGenericException(errorMessage ?: "Anthropic: $statusCode $responseBody")
        tools: List<Tool> = emptyList(),
        type = type,
        type: String,
        val apiKey = credentials.apiKey.ifEmpty { throw AnthropicInvalidApiKeyException() }
        val apiKey = credentials.apiKey.ifEmpty { throw GeminiInvalidApiKeyException() }
        val apiKey = credentials.apiKey.ifEmpty { throw OpenAICompatibleInvalidApiKeyException() }
        val apiKey = getApiKeyOrThrow(service, credentials)
        val apiKey = getOptionalApiKey(service, credentials)
        val code: String?,
        val error = anthropicJson.parseToJsonElement(responseBody).jsonObject["error"]
        val errorMessage = parseAnthropicErrorMessage(responseBody)
        val errorObj = json.jsonObject["error"]?.jsonObject
        val json = anthropicJson.parseToJsonElement(responseBody)
        val key = credentials.apiKey
        val looksLikeNetworkFailure = name.endsWith("IOException") ||
        val message: String?,
        val model = credentials.modelId.ifEmpty { null }
        val modelsUrl = service.modelsUrl
        val moderationDetail = parsed.moderationDetail()
        val name = e::class.simpleName.orEmpty()
        val parsed = parseOpenAICompatibleErrorDetail(responseBody)
        val reasons: List<String>,
        val response: HttpResponse =
        val response: HttpResponse = defaultClient.get("https://openrouter.ai/api/v1/auth/key") {
        val response: HttpResponse = defaultClient.get(url) {
        val response: HttpResponse = defaultClient.post(Service.Perplexity.chatUrl) {
        val responseBody = response.bodyAsText()
        val responsesUrl = service.responsesUrl
        val selectedModelId = credentials.modelId
        val systemContent = systemInstruction?.let {
        val type: String?,
        val url = resolveUrl(service, credentials, modelsUrl)
        val url = resolveUrl(service, credentials, responsesUrl)
        val url = resolveUrl(service, credentials, service.chatUrl)
        when (response.status.value) {
        when (statusCode) {
        when {
        }
        } else {
     * OpenAI Responses API (`POST /v1/responses`). Used for the model families whose function
     * Perplexity Sonar has no authenticated models endpoint, so key checks go through the
     * array — which we treat as connected without spending tokens on a real completion.
     * calling chat completions rejects — see `requiresResponsesApi`. Auth, URL resolution and
     * chat completions URL with an intentionally incomplete body. Auth is evaluated first:
     * error mapping are shared with [openAICompatibleChat]; only the body and result shape differ.
     * invalid keys return 401/403; a valid key typically yields 400/422 on the empty messages
     */
    )
    ) = AnthropicChatRequestDto.PropertySchema(
    ) = OpenAICompatibleChatRequestDto.PropertySchema(
    ) = PropertySchema(
    ) {
    ): Nothing {
    ): Result<AnthropicChatResponseDto> = try {
    ): Result<GeminiChatResponseDto> = try {
    ): Result<OpenAICompatibleChatResponseDto> = try {
    ): Result<OpenAICompatibleModelResponseDto> = openAICompatibleResult {
    ): Result<OpenAIResponsesResponseDto> = try {
    ): T
    /**
    /** Element type used when an `array` node declares no `items`. */
    /** Same schema as [toRequestTool], flattened — the Responses API tags function tools inline. */
    // Distinguish genuine network/I/O failures (preserve the "Cannot connect to
    // client-side exceptions (schema/serialization bugs, etc.) which would
    // endregion
    // otherwise be silently misclassified as connection failures.
    // region Anthropic
    // region Gemini
    // region Helpers
    // region OpenAI-compatible (unified)
    // server" UX and the settings-screen ErrorConnectionFailed status) from
    ?.takeIf { it.isNotEmpty() }
    ?.toMap()
    Result.failure(OpenAICompatibleConnectionException())
    Result.failure(e)
    block()
    class DebugKtorLogger : Logger {
    else -> "string"
    emptyMap()
    fun property(
    is JsonArray -> t.asSequence()
    is JsonPrimitive -> t.contentOrNull ?: "string"
    mapOf("x-opencode-session" to (sessionId?.takeIf { it.isNotBlank() } ?: processSessionId))
    override fun property(
    override val defaultStringItems = AnthropicChatRequestDto.PropertySchema(type = "string")
    override val defaultStringItems = OpenAICompatibleChatRequestDto.PropertySchema(type = "string")
    override val defaultStringItems = PropertySchema(type = "string")
    param.rawSchema?.toPropertySchema(dialect)
    private data class OpenAICompatibleErrorDetail(
    private fun Tool.toAnthropicTool(): AnthropicChatRequestDto.Tool = AnthropicChatRequestDto.Tool(
    private fun Tool.toGeminiTool(): GeminiTool = GeminiTool(
    private fun Tool.toRequestTool(): OpenAICompatibleChatRequestDto.Tool = OpenAICompatibleChatRequestDto.Tool(
    private fun Tool.toResponsesTool(): OpenAIResponsesRequestDto.Tool = OpenAIResponsesRequestDto.Tool(
    private fun getApiKeyOrThrow(service: Service, credentials: ServiceCredentials): String? {
    private fun getOptionalApiKey(service: Service, credentials: ServiceCredentials): String? {
    private fun mapOpenAICompatibleException(e: Exception): OpenAICompatibleApiException {
    private fun parseAnthropicErrorMessage(responseBody: String): String? = try {
    private fun parseOpenAICompatibleErrorDetail(responseBody: String): OpenAICompatibleErrorDetail = try {
    private fun resolveUrl(service: Service, credentials: ServiceCredentials, path: String): String = if (service == Service.OpenAICompatible) {
    private fun throwAnthropicError(statusCode: Int, responseBody: String): Nothing {
    private suspend fun handleOpenAICompatibleError(
    private val anthropicJson = Json {
    private val defaultClient = httpClient {
    requestTimeoutMs ?: return
    return dialect.property(
    sessionHeadersFor(service, sessionId).forEach { (k, v) -> header(k, v) }
    suspend fun anthropicChat(
    suspend fun geminiChat(
    suspend fun getAnthropicModels(credentials: ServiceCredentials): Result<AnthropicModelsResponseDto> = try {
    suspend fun getGeminiModels(credentials: ServiceCredentials): Result<GeminiModelsResponseDto> = try {
    suspend fun getOpenAICompatibleModels(
    suspend fun openAICompatibleChat(
    suspend fun openAIResponses(
    suspend fun validateOpenRouterApiKey(credentials: ServiceCredentials): Result<Unit> = openAICompatibleResult {
    suspend fun validatePerplexityApiKey(credentials: ServiceCredentials): Result<Unit> = openAICompatibleResult {
    timeout {
    val additionalProperties = (this["additionalProperties"] as? JsonPrimitive)
    val apiKey: String = "",
    val baseUrl: String = "",
    val defaultStringItems: T
    val items = (this["items"] as? JsonObject)?.toPropertySchema(dialect)
    val modelId: String = "",
    val properties = schemaObjectMap("properties")?.mapValues { it.value.toPropertySchema(dialect) }
    val type = schemaType()
    }
    } catch (_: Exception) {
    } catch (e: AnthropicApiException) {
    } catch (e: Exception) {
    } catch (e: GeminiApiException) {
    } catch (e: OpenAICompatibleApiException) {
    } catch (e: io.ktor.client.plugins.HttpRequestTimeoutException) {
    } else {
 * API exceptions propagate as-is, anything else (I/O, serialization) becomes a connection error.
 * Anthropic and Gemini have no `additionalProperties`) are dropped by its implementation.
 * Builds one provider's property-schema node. The three chat APIs accept the same JSON Schema
 * Converts declared tools into a provider's request shape, dropping any whose schema can't be
 * Kept separate from [Requests.openAICompatibleChat], which additionally distinguishes timeouts.
 * No other provider is sent a session header.
 * OpenCode Zen identifies the calling client by an `x-opencode-session` header and rejects
 * Session id for provider requests that belong to no conversation — the model list, and the
 * Shared failure mapping for the OpenAI-compatible endpoints that have no bespoke error handling:
 * field is omitted from the payload entirely.
 * represented rather than failing the whole request, and returning null for an empty list so the
 * requests that omit it. One id per conversation, so a whole chat reads as a single session
 * shape under three unrelated DTOs, so the traversal in [toPropertySchema] is written once and
 * silent asks that run before a chat exists. Stable for the lifetime of the process.
 * the dialect only decides which type each node becomes. Fields a provider doesn't model (e.g.
 * upstream; [sessionId] is the conversation id, or null for requests outside any conversation.
 */
)
/**
/** Applies a per-request override of the client-wide timeouts, when the caller supplied one. */
/** Declared parameters of this tool, converted to [dialect]'s node type. */
// JSON Schema dialects vary: `type` may be a string or an array (e.g.
// ["string","null"]); enum/required entries may be non-string primitives;
// falls back to safe defaults instead of throwing — a throw here would bubble
// litellm /toolset/<category>/mcp) emit any of these shapes, so the converter
// nested objects may be malformed. MCP tool servers (especially proxies like
// to setBody() and surface as a misleading "Cannot connect to server" error.
@file:OptIn(ExperimentalUuidApi::class)
class Requests {
data class ServiceCredentials(
internal fun sessionHeadersFor(service: Service, sessionId: String?): Map<String, String> = if (service == Service.OpenCode) {
private fun <T> JsonObject.toPropertySchema(dialect: SchemaDialect<T>): T {
private fun <T> List<Tool>.toRequestTools(convert: (Tool) -> T): List<T>? = mapNotNull { runCatching { convert(it) }.getOrNull() }.ifEmpty { null }
private fun <T> Tool.propertySchemas(dialect: SchemaDialect<T>): Map<String, T> = schema.parameters.mapValues { (_, param) ->
private fun HttpRequestBuilder.applySessionHeader(service: Service, sessionId: String?) {
private fun HttpRequestBuilder.applyTimeout(requestTimeoutMs: Long?) {
private fun JsonObject.schemaObjectMap(key: String): Map<String, JsonObject>? = (this[key] as? JsonObject)?.mapNotNull { (k, v) -> (v as? JsonObject)?.let { k to it } }
private fun JsonObject.schemaString(key: String): String? = (this[key] as? JsonPrimitive)?.contentOrNull
private fun JsonObject.schemaStringList(key: String): List<String>? = (this[key] as? JsonArray)?.mapNotNull { (it as? JsonPrimitive)?.contentOrNull }
private fun JsonObject.schemaType(): String = when (val t = this["type"]) {
private fun Tool.requiredParameterNames(): List<String> = schema.parameters.filter { it.value.required }.keys.toList()
private inline fun <T> openAICompatibleResult(block: () -> Result<T>): Result<T> = try {
private interface SchemaDialect<T> {
private object AnthropicSchemaDialect : SchemaDialect<AnthropicChatRequestDto.PropertySchema> {
private object GeminiSchemaDialect : SchemaDialect<PropertySchema> {
private object OpenAISchemaDialect : SchemaDialect<OpenAICompatibleChatRequestDto.PropertySchema> {
private val processSessionId: String by lazy { Uuid.random().toString() }
}
} catch (e: Exception) {
} catch (e: OpenAICompatibleApiException) {
} else {
