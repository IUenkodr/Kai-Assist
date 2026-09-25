import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_service_aihorde
import kai.composeapp.generated.resources.ic_service_aihubmix
import kai.composeapp.generated.resources.ic_service_anthropic
import kai.composeapp.generated.resources.ic_service_atlascloud
import kai.composeapp.generated.resources.ic_service_cerebras
import kai.composeapp.generated.resources.ic_service_deepinfra
import kai.composeapp.generated.resources.ic_service_deepseek
import kai.composeapp.generated.resources.ic_service_fireworksai
import kai.composeapp.generated.resources.ic_service_free_expert
import kai.composeapp.generated.resources.ic_service_free_fast
import kai.composeapp.generated.resources.ic_service_gemini
import kai.composeapp.generated.resources.ic_service_groqcloud
import kai.composeapp.generated.resources.ic_service_huggingface
import kai.composeapp.generated.resources.ic_service_litert
import kai.composeapp.generated.resources.ic_service_longcat
import kai.composeapp.generated.resources.ic_service_minimax
import kai.composeapp.generated.resources.ic_service_mistral
import kai.composeapp.generated.resources.ic_service_moonshot
import kai.composeapp.generated.resources.ic_service_nvidia
import kai.composeapp.generated.resources.ic_service_ollamacloud
import kai.composeapp.generated.resources.ic_service_openai
import kai.composeapp.generated.resources.ic_service_openai_compatible
import kai.composeapp.generated.resources.ic_service_opencode
import kai.composeapp.generated.resources.ic_service_openrouter
import kai.composeapp.generated.resources.ic_service_perplexity
import kai.composeapp.generated.resources.ic_service_publicai
import kai.composeapp.generated.resources.ic_service_together
import kai.composeapp.generated.resources.ic_service_venice
import kai.composeapp.generated.resources.ic_service_xai
import kai.composeapp.generated.resources.ic_service_zai
import kai.composeapp.generated.resources.service_free_expert
import kai.composeapp.generated.resources.service_free_fast
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

            ModelDefinition(id = "LongCat-Flash-Chat", subtitle = "LongCat"),
            ModelDefinition(id = "LongCat-Flash-Lite", subtitle = "LongCat"),
            ModelDefinition(id = "LongCat-Flash-Omni-2603", subtitle = "LongCat"),
            ModelDefinition(id = "LongCat-Flash-Thinking", subtitle = "LongCat"),
            ModelDefinition(id = "LongCat-Flash-Thinking-2601", subtitle = "LongCat"),
            ModelDefinition(id = "sonar", subtitle = "Perplexity"),
            ModelDefinition(id = "sonar-deep-research", subtitle = "Perplexity"),
            ModelDefinition(id = "sonar-pro", subtitle = "Perplexity"),
            ModelDefinition(id = "sonar-reasoning-pro", subtitle = "Perplexity"),
        ),
        // The kai9000 proxy fans out to a Mistral → Groq → OpenRouter chain. The Groq
        // fallback uses text-only models (gpt-oss-20b/120b) that reject content-parts
        // payloads, so images can't be promised reliably on this path.
        apiKeyUrl = "https://aihorde.net/register",
        apiKeyUrl = "https://aihubmix.com/token",
        apiKeyUrl = "https://aistudio.google.com/apikey",
        apiKeyUrl = "https://api.together.ai/settings/api-keys",
        apiKeyUrl = "https://app.fireworks.ai/settings/users/api-keys",
        apiKeyUrl = "https://build.nvidia.com/settings/api-keys",
        apiKeyUrl = "https://cloud.cerebras.ai/",
        apiKeyUrl = "https://console.anthropic.com/settings/keys",
        apiKeyUrl = "https://console.groq.com/keys",
        apiKeyUrl = "https://console.mistral.ai/api-keys",
        apiKeyUrl = "https://console.perplexity.ai",
        apiKeyUrl = "https://console.x.ai",
        apiKeyUrl = "https://deepinfra.com/dash/api_keys",
        apiKeyUrl = "https://huggingface.co/settings/tokens",
        apiKeyUrl = "https://longcat.chat/platform",
        apiKeyUrl = "https://ollama.com/settings/keys",
        apiKeyUrl = "https://opencode.ai/docs/zen/",
        apiKeyUrl = "https://openrouter.ai/settings/keys",
        apiKeyUrl = "https://platform.deepseek.com/api_keys",
        apiKeyUrl = "https://platform.minimax.io",
        apiKeyUrl = "https://platform.moonshot.cn/console/api-keys",
        apiKeyUrl = "https://platform.openai.com/api-keys",
        apiKeyUrl = "https://platform.publicai.co",
        apiKeyUrl = "https://venice.ai/settings/api?ref=DsZFKZ",
        apiKeyUrl = "https://www.atlascloud.ai/console/api-keys?utm_source=github&utm_medium=link&utm_campaign=Kai",
        apiKeyUrl = "https://z.ai/manage-apikey/apikey-list",
        apiKeyUrlDisplay = "aihorde.net/register",
        apiKeyUrlDisplay = "aihubmix.com/token",
        apiKeyUrlDisplay = "aistudio.google.com/apikey",
        apiKeyUrlDisplay = "api.together.ai/settings/api-keys",
        apiKeyUrlDisplay = "app.fireworks.ai/settings/users/api-keys",
        apiKeyUrlDisplay = "atlascloud.ai/console/api-keys",
        apiKeyUrlDisplay = "build.nvidia.com/settings/api-keys",
        apiKeyUrlDisplay = "cloud.cerebras.ai",
        apiKeyUrlDisplay = "console.anthropic.com/settings/keys",
        apiKeyUrlDisplay = "console.groq.com/keys",
        apiKeyUrlDisplay = "console.mistral.ai/api-keys",
        apiKeyUrlDisplay = "console.perplexity.ai",
        apiKeyUrlDisplay = "console.x.ai",
        apiKeyUrlDisplay = "deepinfra.com/dash/api_keys",
        apiKeyUrlDisplay = "huggingface.co/settings/tokens",
        apiKeyUrlDisplay = "longcat.chat/platform",
        apiKeyUrlDisplay = "ollama.com/settings/keys",
        apiKeyUrlDisplay = "opencode.ai/docs/zen",
        apiKeyUrlDisplay = "openrouter.ai/settings/keys",
        apiKeyUrlDisplay = "platform.deepseek.com/api_keys",
        apiKeyUrlDisplay = "platform.minimax.io",
        apiKeyUrlDisplay = "platform.moonshot.cn/console/api-keys",
        apiKeyUrlDisplay = "platform.openai.com/api-keys",
        apiKeyUrlDisplay = "platform.publicai.co",
        apiKeyUrlDisplay = "venice.ai/settings/api",
        apiKeyUrlDisplay = "z.ai/manage-apikey/apikey-list",
        chatUrl = "/chat/completions",
        chatUrl = "https://aihubmix.com/v1/chat/completions",
        chatUrl = "https://api.anthropic.com/v1/messages",
        chatUrl = "https://api.atlascloud.ai/v1/chat/completions",
        chatUrl = "https://api.cerebras.ai/v1/chat/completions",
        chatUrl = "https://api.deepinfra.com/v1/openai/chat/completions",
        chatUrl = "https://api.deepseek.com/chat/completions",
        chatUrl = "https://api.fireworks.ai/inference/v1/chat/completions",
        chatUrl = "https://api.groq.com/openai/v1/chat/completions",
        chatUrl = "https://api.kai9000.com/chat/completions",
        chatUrl = "https://api.longcat.chat/openai/v1/chat/completions",
        chatUrl = "https://api.minimax.io/v1/chat/completions",
        chatUrl = "https://api.mistral.ai/v1/chat/completions",
        chatUrl = "https://api.moonshot.cn/v1/chat/completions",
        chatUrl = "https://api.openai.com/v1/chat/completions",
        chatUrl = "https://api.perplexity.ai/chat/completions",
        chatUrl = "https://api.publicai.co/v1/chat/completions",
        chatUrl = "https://api.together.xyz/v1/chat/completions",
        chatUrl = "https://api.venice.ai/api/v1/chat/completions",
        chatUrl = "https://api.x.ai/v1/chat/completions",
        chatUrl = "https://api.z.ai/api/coding/paas/v4/chat/completions",
        chatUrl = "https://api.z.ai/api/paas/v4/chat/completions",
        chatUrl = "https://generativelanguage.googleapis.com/v1beta/models/",
        chatUrl = "https://integrate.api.nvidia.com/v1/chat/completions",
        chatUrl = "https://oai.aihorde.net/v1/chat/completions",
        chatUrl = "https://ollama.com/v1/chat/completions",
        chatUrl = "https://opencode.ai/zen/v1/chat/completions",
        chatUrl = "https://openrouter.ai/api/v1/chat/completions",
        chatUrl = "https://router.huggingface.co/v1/chat/completions",
        const val DEFAULT_OPENAI_COMPATIBLE_BASE_URL = "http://localhost:11434/v1"
        defaultModel = "LongCat-Flash-Lite",
        defaultModel = "sonar-pro",
        defaultModel = null,
        defaultModels = emptyList(),
        defaultModels = listOf(
        displayName = "AI Horde",
        displayName = "AIHubMix",
        displayName = "Anthropic",
        displayName = "Atlas Cloud",
        displayName = "Cerebras",
        displayName = "Deep Infra",
        displayName = "DeepSeek",
        displayName = "Fireworks AI",
        displayName = "Free",
        displayName = "Gemini",
        displayName = "GroqCloud",
        displayName = "Hugging Face",
        displayName = "Local Model",
        displayName = "LongCat",
        displayName = "MiniMax",
        displayName = "Mistral",
        displayName = "Moonshot AI",
        displayName = "NVIDIA",
        displayName = "Ollama Cloud",
        displayName = "OpenAI",
        displayName = "OpenAI-Compatible API",
        displayName = "OpenCode",
        displayName = "OpenRouter",
        displayName = "Perplexity",
        displayName = "Public AI",
        displayName = "Together AI",
        displayName = "Venice AI",
        displayName = "Z.AI Coding Plan",
        displayName = "Z.AI",
        displayName = "xAI",
        filterActiveStrictly = true,
        filterByModelType = true,
        fun fromId(id: String): Service = all.find { it.id == id } ?: Free
        icon = Res.drawable.ic_service_aihorde,
        icon = Res.drawable.ic_service_aihubmix,
        icon = Res.drawable.ic_service_anthropic,
        icon = Res.drawable.ic_service_atlascloud,
        icon = Res.drawable.ic_service_cerebras,
        icon = Res.drawable.ic_service_deepinfra,
        icon = Res.drawable.ic_service_deepseek,
        icon = Res.drawable.ic_service_fireworksai,
        icon = Res.drawable.ic_service_free_fast,
        icon = Res.drawable.ic_service_gemini,
        icon = Res.drawable.ic_service_groqcloud,
        icon = Res.drawable.ic_service_huggingface,
        icon = Res.drawable.ic_service_litert,
        icon = Res.drawable.ic_service_longcat,
        icon = Res.drawable.ic_service_minimax,
        icon = Res.drawable.ic_service_mistral,
        icon = Res.drawable.ic_service_moonshot,
        icon = Res.drawable.ic_service_nvidia,
        icon = Res.drawable.ic_service_ollamacloud,
        icon = Res.drawable.ic_service_openai,
        icon = Res.drawable.ic_service_openai_compatible,
        icon = Res.drawable.ic_service_opencode,
        icon = Res.drawable.ic_service_openrouter,
        icon = Res.drawable.ic_service_perplexity,
        icon = Res.drawable.ic_service_publicai,
        icon = Res.drawable.ic_service_together,
        icon = Res.drawable.ic_service_venice,
        icon = Res.drawable.ic_service_xai,
        icon = Res.drawable.ic_service_zai,
        id = "aihorde",
        id = "aihubmix",
        id = "anthropic",
        id = "atlascloud",
        id = "cerebras",
        id = "deepinfra",
        id = "deepseek",
        id = "fireworksai",
        id = "free",
        id = "gemini",
        id = "groqcloud",
        id = "huggingface",
        id = "litert",
        id = "longcat",
        id = "minimax",
        id = "mistral",
        id = "moonshot",
        id = "nvidia",
        id = "ollamacloud",
        id = "openai",
        id = "openai-compatible",
        id = "opencode",
        id = "openrouter",
        id = "perplexity",
        id = "publicai",
        id = "together",
        id = "venice",
        id = "xai",
        id = "zai",
        id = "zai-coding-plan",
        isOnDevice = true,
        modelsResponseIsArray = true,
        modelsUrl = "/models",
        modelsUrl = "https://aihubmix.com/v1/models",
        modelsUrl = "https://api.anthropic.com/v1/models",
        modelsUrl = "https://api.atlascloud.ai/v1/models",
        modelsUrl = "https://api.cerebras.ai/v1/models",
        modelsUrl = "https://api.deepinfra.com/v1/openai/models",
        modelsUrl = "https://api.deepseek.com/models",
        modelsUrl = "https://api.fireworks.ai/inference/v1/models",
        modelsUrl = "https://api.groq.com/openai/v1/models",
        modelsUrl = "https://api.longcat.chat/openai/v1/models",
        modelsUrl = "https://api.minimax.io/v1/models",
        modelsUrl = "https://api.mistral.ai/v1/models",
        modelsUrl = "https://api.moonshot.cn/v1/models",
        modelsUrl = "https://api.openai.com/v1/models",
        modelsUrl = "https://api.publicai.co/v1/models",
        modelsUrl = "https://api.together.xyz/v1/models",
        modelsUrl = "https://api.venice.ai/api/v1/models",
        modelsUrl = "https://api.x.ai/v1/models",
        modelsUrl = "https://api.z.ai/api/coding/paas/v4/models",
        modelsUrl = "https://api.z.ai/api/paas/v4/models",
        modelsUrl = "https://integrate.api.nvidia.com/v1/models",
        modelsUrl = "https://oai.aihorde.net/v1/models",
        modelsUrl = "https://ollama.com/v1/models",
        modelsUrl = "https://opencode.ai/zen/v1/models",
        modelsUrl = "https://openrouter.ai/api/v1/models",
        modelsUrl = "https://router.huggingface.co/v1/models",
        modelsUrl = null,
        reasoningRequestMode = ReasoningRequestMode.REASONING_CONTENT,
        requiresApiKey = false,
        requiresApiKey = true,
        responsesUrl = "/responses",
        responsesUrl = "https://api.openai.com/v1/responses",
        settingsKeyPrefix = "",
        settingsKeyPrefix = "aihorde",
        settingsKeyPrefix = "aihubmix",
        settingsKeyPrefix = "anthropic",
        settingsKeyPrefix = "atlascloud",
        settingsKeyPrefix = "cerebras",
        settingsKeyPrefix = "deepinfra",
        settingsKeyPrefix = "deepseek",
        settingsKeyPrefix = "fireworksai",
        settingsKeyPrefix = "gemini",
        settingsKeyPrefix = "groq",
        settingsKeyPrefix = "huggingface",
        settingsKeyPrefix = "litert",
        settingsKeyPrefix = "longcat",
        settingsKeyPrefix = "minimax",
        settingsKeyPrefix = "mistral",
        settingsKeyPrefix = "moonshot",
        settingsKeyPrefix = "nvidia",
        settingsKeyPrefix = "ollamacloud",
        settingsKeyPrefix = "openai",
        settingsKeyPrefix = "openai-compatible",
        settingsKeyPrefix = "opencode",
        settingsKeyPrefix = "openrouter",
        settingsKeyPrefix = "perplexity",
        settingsKeyPrefix = "publicai",
        settingsKeyPrefix = "together",
        settingsKeyPrefix = "venice",
        settingsKeyPrefix = "xai",
        settingsKeyPrefix = "zai",
        settingsKeyPrefix = "zai-coding-plan",
        sortModelsById = true,
        supportsImages = false,
        supportsOptionalApiKey = true,
        supportsPdf = true,
        val all: List<Service> get() = listOf(Free, AtlasCloud, Gemini, Anthropic, OpenAI, DeepSeek, Mistral, XAI, OpenRouter, Groq, Nvidia, Cerebras, OllamaCloud, LongCat, Together, HuggingFace, Venice, Moonshot, Zai, ZaiCodingPlan, Minimax, AiHubMix, DeepInfra, FireworksAI, OpenCode, PublicAI, AIHorde, Perplexity, OpenAICompatible, LiteRT)
     *
     * Crowdsourced LLM compute via the [AI Horde OpenAI proxy](https://oai.aihorde.net/).
     * Echo `reasoning_content` back on assistant turns that previously produced
     * Model availability depends on online volunteer workers. Anonymous key `0000000000`
     * OpenAI Responses API endpoint (`/v1/responses`), for the services that expose one. Only
     * See `docs/features/reasoning.md` for the authoritative per-provider matrix
     * [chatUrl].
     * `tool_calls`. Truly required by Z.AI Coding Plan, OpenCode Zen (DeepSeek
     * and known fidelity gaps (`reasoning_details`, `<think>`-in-content, paired
     * documented field by Fireworks, Z.AI standard, and OpenRouter (as an alias
     * flags like `clear_thinking` and `reasoning_history`).
     * for `reasoning`). Tolerated as an unknown field by LongCat, Venice, MiniMax.
     * reached for models that [requiresResponsesApi] selects; every other model stays on
     * route), and Moonshot kimi-k2.6 with `thinking.keep="all"`. Accepted as a
     * works at lowest priority; register for a personal key at [aihorde.net/register](https://aihorde.net/register).
     */
    )
    /**
    /** Strip the field before sending. Safe default. */
    // Sonar chat-completions path. No authenticated /models list for Sonar (public /v1/models
    // is Agent API only), so the picker uses defaultModels; key validation is special-cased.
    ;
    EXPERT("expert", Res.string.service_free_expert, Res.drawable.ic_service_free_expert),
    FAST("fast", Res.string.service_free_fast, Res.drawable.ic_service_free_fast),
    NONE,
    REASONING_CONTENT,
    companion object {
    data object AIHorde : Service(
    data object AiHubMix : Service(
    data object Anthropic : Service(
    data object AtlasCloud : Service(
    data object Cerebras : Service(
    data object DeepInfra : Service(
    data object DeepSeek : Service(
    data object FireworksAI : Service(
    data object Free : Service(
    data object Gemini : Service(
    data object Groq : Service(
    data object HuggingFace : Service(
    data object LiteRT : Service(
    data object LongCat : Service(
    data object Minimax : Service(
    data object Mistral : Service(
    data object Moonshot : Service(
    data object Nvidia : Service(
    data object OllamaCloud : Service(
    data object OpenAI : Service(
    data object OpenAICompatible : Service(
    data object OpenCode : Service(
    data object OpenRouter : Service(
    data object Perplexity : Service(
    data object PublicAI : Service(
    data object Together : Service(
    data object Venice : Service(
    data object XAI : Service(
    data object Zai : Service(
    data object ZaiCodingPlan : Service(
    val apiKeyKey: String get() = "service_${settingsKeyPrefix}_api_key"
    val apiKeyUrl: String? = null,
    val apiKeyUrlDisplay: String? = null,
    val baseUrlKey: String get() = "service_${settingsKeyPrefix}_base_url"
    val chatUrl: String = "",
    val defaultModel: String?,
    val defaultModels: List<ModelDefinition> = emptyList(),
    val descriptionRes: StringResource? = null,
    val displayName: String,
    val filterActiveStrictly: Boolean = false,
    val filterByModelType: Boolean = false,
    val icon: DrawableResource,
    val id: String,
    val instanceId: String get() = "free-$modelId"
    val isOnDevice: Boolean = false,
    val modelIdKey: String get() = "service_${settingsKeyPrefix}_model_id"
    val modelsResponseIsArray: Boolean = false,
    val modelsUrl: String? = null,
    val reasoningRequestMode: ReasoningRequestMode = ReasoningRequestMode.NONE,
    val requiresApiKey: Boolean,
    val responsesUrl: String? = null,
    val settingsKeyPrefix: String,
    val sortModelsById: Boolean = false,
    val subtitle: String,
    val supportsImages: Boolean = true,
    val supportsOptionalApiKey: Boolean = false,
    val supportsPdf: Boolean = false,
    }
 *
 * Default is [NONE] so any new provider is safe by default — Groq and Cerebras
 * How a service handles a `reasoning_content` field on outgoing assistant messages.
 * See `docs/features/reasoning.md` for the authoritative per-provider matrix.
 * return HTTP 400 when they see this field, so opt-in is the correct posture.
 */
)
) {
/**
data class ModelDefinition(
enum class FreeMode(val modelId: String, val nameRes: StringResource, val icon: DrawableResource) {
enum class ReasoningRequestMode {
package com.inspiredandroid.kai.data
sealed class Service(
}
