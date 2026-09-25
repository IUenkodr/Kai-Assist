package com.inspiredandroid.kai.data

    "chatglm3-6b",
    "codellama",
    "deepseek-coder:1.3b",
    "deepseek-coder:6.7b",
    "gemma-3",
    "gemma-4-e2b",
    "gemma-4-e4b",
    "gemma2",
    "gemma3",
    "gemma:2b",
    "gemma:7b",
    "glm-4-32b",
    "glm-4-air",
    "glm-4-airx",
    "glm-4-flash",
    "glm-4-long",
    "glm-4-plus",
    "glm-4-plus-0111",
    "glm-4.5",
    "glm-4.5-air",
    "glm-4.5-air:free",
    "glm-4.5-x",
    "glm-4.6",
    "glm-4.6-air",
    "glm-4.7",
    "glm-4.7-flash",
    "glm-5",
    "glm-5-turbo",
    "glm-5.1",
    "glm-5.2",
    "glm-5.2-max",
    "glm-z1-air",
    "glm-z1-airx",
    "glm-z1-flash",
    "glm4.7",
    "glm5",
    "glm5.2",
    "gpt-5.6",
    "llama3.1:8b",
    "llama3.2:1b",
    "llama3.2:3b",
    "phi3:mini",
    "sonar",
    "stablelm",
    "tinyllama",
    "zai-glm-4.7",
    // DeepSeek's chat models are all text-only; the lone vision family is DeepSeek-VL, which
    // GLM / Zhipu text models. The -v / v-plus variants are multimodal and are
    // Perplexity Sonar models use built-in web search, not OpenAI tool/function calling.
    // Sending a tools[] array is rejected (or silently ignored), so treat them as text-only.
    // aggregators and future ids, while leaving DeepSeek-VL recognised as multimodal.
    // carries "vl" in the id. Match the text family by prefix so this also covers DeepSeek via
    // deliberately left out so images still reach them.
    if (!isOpenAiEndpoint) return false
    if (key.startsWith("deepseek") && !key.contains("vl")) return false
    if (service.responsesUrl == null) return false
    return LIMITED_MODELS.none { lower.startsWith(it) }
    return RESPONSES_API_MODELS.any { id.startsWith(it) }
    return key !in TEXT_ONLY_IMAGE_MODELS
    val id = modelId.substringAfterLast('/').lowercase()
    val isOpenAiEndpoint = service == Service.OpenAI || baseUrl.contains("api.openai.com", ignoreCase = true)
    val key = modelId.substringAfterLast('/').lowercase()
    val lower = modelId.lowercase()
 *
 *    (see [LIMITED_MODELS]).
 *    agentic loops reliably.
 *  - **Model** must support tools: some small open-weight models don't
 *  - **Service** must be remote: on-device inference (LiteRT) can't run long
 * "none"`) would trade away the reasoning these models are chosen for.
 * 'none'.`
 * (`/v1/responses`). Chat completions answers these with
 * /v1/chat/completions. To use function tools, use /v1/responses or set reasoning_effort to
 * DON'T accept image input even though Z.AI's service does — Z.AI serves these text models next
 * DeepSeek is matched by family prefix: its chat API has no vision models at all, so this also
 * Exact match only: the vision variants (glm-4.6v, glm-4v-plus, …) share a prefix with the text
 * GLM / Zhipu text model ids (normalized: any `provider/` prefix stripped, lower-cased) that
 * Gated on reaching OpenAI directly: aggregators that resell the same models (OpenRouter, AI
 * HubMix, …) translate to the Responses API themselves and only accept chat completions, so
 * If you're filtering a service/model picker for a background feature,
 * Model IDs (by prefix, lower-cased) that can't drive tool/function-calling loops
 * OpenAI model id prefixes whose function calling only works on the Responses API
 * Prefix matching covers the tier ids (`-sol`, `-terra`, `-luna`), the bare `gpt-5.6` alias, and
 * The family reasons by default, so the rejection lands even though Kai never sends
 * True if a service+model combo is suitable for autonomous/agentic flows —
 * True if the model accepts image input. Defaults to `true` for unknown models — most modern
 * True when this service+model must talk to OpenAI's Responses API instead of chat completions.
 * Two gates, both must hold:
 * `400 Function tools with reasoning_effort are not supported for gpt-5.6-terra in
 * `reasoning_effort` — and the documented chat-completions escape hatch (`reasoning_effort:
 * covers DeepSeek reached through an aggregator and any future DeepSeek id. GLM is matched
 * effort-suffixed variants (`gpt-5.6-luna-xhigh`). Add a prefix here when a new OpenAI family
 * exactly via [TEXT_ONLY_IMAGE_MODELS] because its vision variants share a prefix with the text ones.
 * flagship models are multimodal, and stripping images from a model that supports them is a
 * has no vision models at all, is matched by family prefix in [modelSupportsImages] instead.
 * heartbeat, interactive mode, and any future background feature that runs a
 * its base URL points at OpenAI, which is what a user reaching for that service as a workaround
 * ones (glm-4.6, glm-4), so prefix matching would wrongly flag them as text-only. DeepSeek, which
 * prefer this over checking either gate in isolation.
 * reliably. Add new small/weak models here when they prove unable to emit well-formed
 * routing their ids to `/responses` would break them. The OpenAI-Compatible service qualifies when
 * shows the same 400.
 * then poisons every later turn in the chat (the image stays in history), so we strip images.
 * to the multimodal GLM-V variants. Sending image content-parts to them returns a hard 400 that
 * tool-calling loop without the user present to course-correct.
 * tool_use JSON or to parse tool schemas.
 * worse failure than leaving the rare unknown text-only model to reject them.
 * would configure.
 */
)
/**
/** True if the model can handle tool_use / tool_result round-trips. */
internal fun modelSupportsImages(modelId: String): Boolean {
internal fun requiresResponsesApi(service: Service, modelId: String, baseUrl: String = ""): Boolean {
internal fun supportsAgenticFlows(serviceId: String, modelId: String): Boolean = !Service.fromId(serviceId).isOnDevice && supportsTools(modelId)
internal fun supportsTools(modelId: String): Boolean {
internal val LIMITED_MODELS = listOf(
internal val RESPONSES_API_MODELS = listOf(
internal val TEXT_ONLY_IMAGE_MODELS: Set<String> = setOf(
}
