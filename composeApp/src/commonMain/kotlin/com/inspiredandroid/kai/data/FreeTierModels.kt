package com.inspiredandroid.kai.data

                // e.g. gpt-oss:20b-cloud → gpt-oss:20b
                stripped
                val stripped = lower.removeSuffix("-cloud")
            else -> lower
            lower.endsWith("-cloud") -> {
            lower.endsWith(":cloud") -> lower.removeSuffix(":cloud").ifEmpty { lower }
            return normalizeOllamaId(lower) in set
            }
        "cohere/north-mini-code:free",
        "gemma4:31b",
        "google/gemma-4-26b-a4b-it:free",
        "google/gemma-4-31b-it:free",
        "gpt-oss:20b",
        "inclusionai/ling-3.0-tiny:free",
        "nemotron-3-nano:30b",
        "nvidia/nemotron-3-nano-30b-a3b:free",
        "nvidia/nemotron-3-nano-omni-30b-a3b-reasoning:free",
        "nvidia/nemotron-3-super-120b-a12b:free",
        "nvidia/nemotron-3-ultra-550b-a55b:free",
        "nvidia/nemotron-3.5-lightning:free",
        "nvidia/nemotron-nano-12b-v2-vl:free",
        "nvidia/nemotron-nano-9b-v2:free",
        "openai/gpt-oss-20b:free",
        "openrouter/free",
        "poolside/laguna-s-2.1:free",
        "poolside/laguna-xs-2.1:free",
        Service.OllamaCloud.id to ollamaCloudFree,
        Service.OpenRouter.id to openRouterFree,
        if (lower in set) return true
        if (service == Service.OllamaCloud) {
        return false
        return when {
        val lower = modelId.lowercase()
        val set = byService[service.id] ?: return false
        }
     * (often without a `-cloud` suffix). Aliases with `:cloud` / `-cloud` are
     * Ollama Cloud free-plan models. Free includes light cloud usage; usage
     * OpenRouter models with $0 prompt + completion pricing (chat-oriented).
     * Snapshot maintained by hand / skill; ids usually end in `:free`.
     * Strip cloud tag suffixes so library-style ids (`gpt-oss:20b-cloud`,
     * `gemma4:cloud`) match API-style free-list entries (`gpt-oss:20b`,
     * `gemma4`).
     * level Low models fit free quotas best. Ids match `ollama.com/v1/models`
     * normalized in [normalizeOllamaId].
     */
    )
    /**
    fun isFreeTier(service: Service, modelId: String): Boolean {
    internal fun normalizeOllamaId(modelId: String): String {
    private val byService: Map<String, Set<String>> = mapOf(
    private val ollamaCloudFree: Set<String> = setOf(
    private val openRouterFree: Set<String> = setOf(
    }
 *
 * Curated per-service sets of model ids that are usable on that provider's
 * Keys and set members are lowercase.
 * This object is the **runtime** source of truth for Free badges — not live
 * `update-free-tier-models` skill.
 * free tier (with free-tier rate/usage limits). Free-ness is service-scoped:
 * pricing APIs. Curation policy, provenance, and the mirrored snapshot live in
 * the OKF bundle `docs/knowledge/free-tier/`. Refresh both via the
 * the same weights may be free on OpenRouter but paid elsewhere.
 */
/**
internal object FreeTierModels {
}
