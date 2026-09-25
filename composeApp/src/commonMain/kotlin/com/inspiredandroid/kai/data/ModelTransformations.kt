package com.inspiredandroid.kai.data
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicModelsResponseDto
import com.inspiredandroid.kai.network.dtos.gemini.GeminiModelsResponseDto
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleModelResponseDto
import com.inspiredandroid.kai.toIsoDate
import com.inspiredandroid.kai.ui.settings.SettingsModel

                id = selectedModelId,
                isManualEntry = true,
                isSelected = true,
                subtitle = "",
            ),
            SettingsModel(
            apiContextWindow = dto.inputTokenLimit,
            apiContextWindow = it.context_window ?: it.context_length,
            apiDisplayName = dto.displayName,
            apiDisplayName = it.display_name,
            apiDisplayName = it.name,
            apiReleaseDate = it.created?.toIsoDate(),
            id = it.id,
            id = modelId,
            if (cmp != 0) return@Comparator cmp
            selectedModelId = selectedModelId,
            service = Service.Anthropic,
            service = Service.Gemini,
            service = service,
            val cmp = ctxB.compareTo(ctxA)
            val cmp = dateB.compareTo(dateA)
        )
        ) + providerModels.map { it.copy(isSelected = false) }
        // If [models] already had this id as a manual entry, rebuild it cleanly.
        // Keep a manual row only when the id is not already a real list entry.
        activeFiltered
        activeFiltered.filter { it.type == "chat" }
        arenaScore = curated?.arenaScore,
        buildSettingsModel(
        contextWindow = curated?.contextWindow ?: apiContextWindow,
        ctxA != null && ctxB != null -> {
        ctxA != null && ctxB == null -> return@Comparator -1
        ctxA == null && ctxB != null -> return@Comparator 1
        dateA != null && dateB != null -> {
        dateA != null && dateB == null -> return@Comparator -1
        dateA == null && dateB != null -> return@Comparator 1
        displayName = curated?.displayName ?: apiDisplayName,
        id = id,
        isFreeTier = FreeTierModels.isFreeTier(service, id),
        isSelected = id == selectedModelId,
        listOf(
        mapped.sortedBy { it.id }
        mapped.sortedWith(newestFirstComparator)
        models.filter { it.isActive != false }
        models.filter { it.isActive == true }
        parameterCount = curated?.parameterCount,
        providerModels.map { it.copy(isSelected = it.id == selectedModelId) }
        releaseDate = curated?.releaseDate ?: apiReleaseDate,
        return providerModels.map { it.copy(isSelected = false) }
        subtitle = "",
        typeFiltered
        typeFiltered.filter { model -> chatPrefixes.any { model.id.startsWith(it) } }
        val chatPrefixes = listOf("gpt-", "o1", "o3", "o4", "chatgpt-")
        }
    "aqa",
    "bge-",
    "deplot",
    "embed",
    "gliner",
    "guard",
    "image",
    "imagen",
    "kosmos",
    "leanstral",
    "live-",
    "lyria",
    "moderation",
    "nano-banana",
    "native-audio",
    "nemoretriever",
    "nemotron-parse",
    "nvclip",
    "ocr",
    "orpheus",
    "paligemma",
    "realtime",
    "reward",
    "riva-translate",
    "safety",
    "shieldgemma",
    "streampetr",
    "transcribe",
    "tts",
    "veo",
    "vibe-cli",
    "voxtral",
    "whisper",
    )
    .filter { (_, modelId) -> isChatModel(modelId) }
    .filter { it.supportedGenerationMethods?.contains("generateContent") == true }
    .map {
    .map { (dto, modelId) ->
    .map { it to it.name.removePrefix("models/") }
    .sortedWith(newestFirstComparator)
    a.id.compareTo(b.id)
    apiContextWindow: Long? = null,
    apiDisplayName: String? = null,
    apiReleaseDate: String? = null,
    id: String,
    if (selectedModelId.isEmpty()) {
    models: List<AnthropicModelsResponseDto.ModelInfo>,
    models: List<GeminiModelsResponseDto.Model>,
    models: List<OpenAICompatibleModelResponseDto.Model>,
    models: List<SettingsModel>,
    return SettingsModel(
    return if (matchInProvider) {
    return if (service.sortModelsById) {
    return nonChatPatterns.none { lower.contains(it) }
    selectedModelId: String,
    service: Service,
    val activeFiltered = if (service.filterActiveStrictly) {
    val chatOnly = filtered.filter { isChatModel(it.id) }
    val ctxA = a.contextWindow
    val ctxB = b.contextWindow
    val curated = ModelCatalog.lookup(id)
    val dateA = a.releaseDate
    val dateB = b.releaseDate
    val filtered = if (service is Service.OpenAI) {
    val lower = modelId.lowercase()
    val mapped = unique.map {
    val matchInProvider = providerModels.any { it.id == selectedModelId }
    val providerModels = models.filter { !it.isManualEntry }
    val typeFiltered = if (service.filterByModelType && activeFiltered.any { it.type != null }) {
    val unique = chatOnly.distinctBy { it.id }
    when {
    }
    } else {
 *
 *  1. Release date descending (nulls last)
 *  2. Context window descending (nulls last)
 *  3. Model id ascending (stable tiebreaker)
 * Builds the [SettingsModel] every provider's mapper produces: the curated [ModelCatalog] entry
 * Covers: voice/TTS, embeddings, moderation, OCR, safety, image gen,
 * Ensures [selectedModelId] appears in [models] and is marked selected.
 * Model id substrings that mark a model as non-chat. Any model whose
 * Previous [SettingsModel.isManualEntry] rows are dropped first so retyping a custom id
 * The `api*` parameters default to null because the providers genuinely differ in what they
 * Unified "newest first" sort applied to every provider's model list.
 * When the id is blank, only provider-sourced models remain (all deselected) so the caller
 * expose — Anthropic has no context window or release date on its models endpoint, and Gemini
 * has no release date — so each mapper passes only the fields its API actually carries.
 * lowercased id contains one of these is filtered out of the picker.
 * manual entry is prepended so the choice is not overwritten on refresh.
 * may auto-select a default. When the id is missing from the list, a single synthetic
 * replaces the prior draft instead of accumulating every intermediate string in the picker.
 * video gen, retrieval, reward, translation, and other non-chat APIs.
 * wins on each field, falling back to whatever the provider's API supplied.
 */
)
): List<SettingsModel> = models
): List<SettingsModel> {
): SettingsModel {
/**
internal fun ensureSelectedModelPresent(
internal fun isChatModel(modelId: String): Boolean {
internal fun mapAnthropicModels(
internal fun mapGeminiModels(
internal fun mapOpenAICompatibleModels(
internal val newestFirstComparator: Comparator<SettingsModel> = Comparator { a, b ->
private fun buildSettingsModel(
private val nonChatPatterns = listOf(
}
