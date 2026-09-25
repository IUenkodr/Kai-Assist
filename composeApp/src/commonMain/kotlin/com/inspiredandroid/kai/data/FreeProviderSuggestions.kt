package com.inspiredandroid.kai.data

            "FreeProviderSuggestion requires apiKeyUrl on ${service.id}"
        get() = requireNotNull(service.apiKeyUrl) {
        }
    FreeProviderSuggestion(Service.Cerebras),
    FreeProviderSuggestion(Service.Gemini),
    FreeProviderSuggestion(Service.Groq),
    FreeProviderSuggestion(Service.OllamaCloud),
    FreeProviderSuggestion(Service.OpenRouter),
    val service: Service,
    val signupUrl: String
 * Providers with meaningful free-tier usage that we recommend when the
 * built-in Free FAST/EXPERT path is rate-limited and the user has no
 * configured services yet.
 */
)
) {
/**
data class FreeProviderSuggestion(
val freeProviderSuggestions: List<FreeProviderSuggestion> = listOf(
}
