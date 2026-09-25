import com.inspiredandroid.kai.inference.InferenceTimeoutException
import com.inspiredandroid.kai.inference.InsufficientMemoryException
import com.inspiredandroid.kai.inference.ModelIntegrityException
import com.inspiredandroid.kai.inference.NoModelDownloadedException
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.error_all_services_failed
import kai.composeapp.generated.resources.error_bad_request
import kai.composeapp.generated.resources.error_content_moderation
import kai.composeapp.generated.resources.error_context_window_exceeded
import kai.composeapp.generated.resources.error_empty_response
import kai.composeapp.generated.resources.error_file_too_large
import kai.composeapp.generated.resources.error_image_too_large
import kai.composeapp.generated.resources.error_insufficient_credits
import kai.composeapp.generated.resources.error_invalid_api_key
import kai.composeapp.generated.resources.error_openai_compatible_connection
import kai.composeapp.generated.resources.error_openai_compatible_model_not_found
import kai.composeapp.generated.resources.error_provider_error
import kai.composeapp.generated.resources.error_quota_exhausted
import kai.composeapp.generated.resources.error_rate_limit_exceeded
import kai.composeapp.generated.resources.error_service_unavailable
import kai.composeapp.generated.resources.error_unknown
import kai.composeapp.generated.resources.error_unsupported_file_type
import kai.composeapp.generated.resources.litert_error_inference_timeout
import kai.composeapp.generated.resources.litert_error_insufficient_memory
import kai.composeapp.generated.resources.litert_error_model_integrity
import kai.composeapp.generated.resources.litert_error_no_model
import org.jetbrains.compose.resources.StringResource

        ?.let { UiError.ResourceWithDetail(Res.string.error_bad_request, it) }
        ?.let { UiError.ResourceWithDetail(Res.string.error_content_moderation, it) }
        ?.let { UiError.ResourceWithDetail(Res.string.error_provider_error, it) }
        ?: UiError.Resource(Res.string.error_bad_request)
        ?: UiError.Resource(Res.string.error_content_moderation)
        ?: UiError.Resource(Res.string.error_provider_error)
        if (!message.isNullOrBlank()) UiError.Text(message!!) else UiError.Resource(Res.string.error_unknown)
        m.contains("all free providers") ||
        m.contains("capacity") ||
        m.contains("free providers failed") ||
        m.contains("overloaded")
        m.contains("quota") ||
        m.contains("rate limit") ||
        m.contains("rate_limit") ||
        m.contains("too many requests") ||
    -> messageLooksLikeFreeCapacity(message)
    -> true
    data class Resource(val resource: StringResource) : UiError
    data class ResourceWithDetail(val resource: StringResource, val detail: String) : UiError
    data class Text(val message: String) : UiError
    else -> if (!message.isNullOrBlank()) UiError.Text(message!!) else UiError.Resource(Res.string.error_unknown)
    else -> messageLooksLikeFreeCapacity(message)
    exception: Exception,
    is AllServicesFailedException -> UiError.Resource(Res.string.error_all_services_failed)
    is AnthropicInsufficientCreditsException -> UiError.Resource(Res.string.error_insufficient_credits)
    is AnthropicOverloadedException -> UiError.Resource(Res.string.error_rate_limit_exceeded)
    is AnthropicOverloadedException,
    is AnthropicRateLimitExceededException,
    is ContextWindowExceededException -> UiError.Resource(Res.string.error_context_window_exceeded)
    is FileTooLargeException -> UiError.Resource(Res.string.error_file_too_large)
    is GeminiGenericException, is OpenAICompatibleGenericException, is AnthropicGenericException, is GenericNetworkException ->
    is GeminiInvalidApiKeyException, is OpenAICompatibleInvalidApiKeyException, is AnthropicInvalidApiKeyException -> UiError.Resource(Res.string.error_invalid_api_key)
    is GeminiRateLimitExceededException,
    is GeminiRateLimitExceededException, is OpenAICompatibleRateLimitExceededException, is AnthropicRateLimitExceededException -> UiError.Resource(Res.string.error_rate_limit_exceeded)
    is InferenceTimeoutException -> UiError.Resource(Res.string.litert_error_inference_timeout)
    is InsufficientMemoryException -> UiError.Resource(Res.string.litert_error_insufficient_memory)
    is ModelIntegrityException -> UiError.Resource(Res.string.litert_error_model_integrity)
    is NoModelDownloadedException -> UiError.Resource(Res.string.litert_error_no_model)
    is OpenAICompatibleBadRequestException -> message?.takeIf { it.isNotBlank() }
    is OpenAICompatibleBadRequestException,
    is OpenAICompatibleConnectionException -> UiError.Resource(Res.string.error_openai_compatible_connection)
    is OpenAICompatibleContentModerationException -> message?.takeIf { it.isNotBlank() }
    is OpenAICompatibleEmptyResponseException -> UiError.Resource(Res.string.error_empty_response)
    is OpenAICompatibleGenericException,
    is OpenAICompatibleModelNotFoundException -> UiError.Resource(Res.string.error_openai_compatible_model_not_found)
    is OpenAICompatibleProviderErrorException -> message?.takeIf { it.isNotBlank() }
    is OpenAICompatibleProviderErrorException,
    is OpenAICompatibleQuotaExhaustedException -> UiError.Resource(Res.string.error_quota_exhausted)
    is OpenAICompatibleQuotaExhaustedException,
    is OpenAICompatibleRateLimitExceededException,
    is OpenAICompatibleRequestTooLargeException -> UiError.Resource(Res.string.error_image_too_large)
    is OpenAICompatibleServiceUnavailableException -> UiError.Resource(Res.string.error_service_unavailable)
    is OpenAICompatibleServiceUnavailableException,
    is OpenAICompatibleTimeoutException -> UiError.Resource(Res.string.error_openai_compatible_connection)
    is UnsupportedFileTypeException -> UiError.Resource(Res.string.error_unsupported_file_type)
    noConfiguredServices: Boolean,
    return m.contains("all free providers failed") ||
    val m = message?.lowercase() ?: return false
 *
 * "All free providers failed" rather than a pure 429, so message matching
 * Errors that mean the built-in Free path (or another free-capacity quota)
 * Show the free-provider upsell only when Free is the sole path (no user
 * The kai9000 Free proxy often returns HTTP 500 with a body like
 * is exhausted — used to decide whether to show free-provider signup suggestions.
 * is required in addition to typed rate-limit exceptions.
 * services configured) and the failure is a free-capacity rate/quota limit.
 */
): Boolean = noConfiguredServices && exception.isFreeCapacityError()
/**
/** Message patterns used by Free / capacity exhaustion across providers. */
class AllServicesFailedException : ApiException(null)
class AnthropicGenericException(message: String, cause: Throwable? = null) : AnthropicApiException(message, cause)
class AnthropicInsufficientCreditsException : AnthropicApiException()
class AnthropicInvalidApiKeyException : AnthropicApiException()
class AnthropicOverloadedException : AnthropicApiException()
class AnthropicRateLimitExceededException : AnthropicApiException()
class ContextWindowExceededException : ApiException(null)
class FileTooLargeException : ApiException(null)
class GeminiGenericException(message: String, cause: Throwable? = null) : GeminiApiException(message, cause)
class GeminiInvalidApiKeyException : GeminiApiException()
class GeminiRateLimitExceededException : GeminiApiException()
class GenericNetworkException(message: String, cause: Throwable? = null) : ApiException(message, cause)
class OpenAICompatibleBadRequestException(detail: String? = null) : OpenAICompatibleApiException(detail)
class OpenAICompatibleConnectionException : OpenAICompatibleApiException()
class OpenAICompatibleContentModerationException(detail: String? = null) : OpenAICompatibleApiException(detail)
class OpenAICompatibleEmptyResponseException : OpenAICompatibleApiException()
class OpenAICompatibleGenericException(message: String, cause: Throwable? = null) : OpenAICompatibleApiException(message, cause)
class OpenAICompatibleInvalidApiKeyException : OpenAICompatibleApiException()
class OpenAICompatibleModelNotFoundException : OpenAICompatibleApiException()
class OpenAICompatibleProviderErrorException(detail: String? = null) : OpenAICompatibleApiException(detail)
class OpenAICompatibleQuotaExhaustedException : OpenAICompatibleApiException()
class OpenAICompatibleRateLimitExceededException : OpenAICompatibleApiException()
class OpenAICompatibleRequestTooLargeException : OpenAICompatibleApiException()
class OpenAICompatibleServiceUnavailableException : OpenAICompatibleApiException()
class OpenAICompatibleTimeoutException : OpenAICompatibleApiException()
class UnsupportedFileTypeException : ApiException(null)
fun Exception.isFreeCapacityError(): Boolean = when (this) {
fun Exception.toUiError(): UiError = when (this) {
fun shouldShowFreeProviderSuggestions(
internal fun messageLooksLikeFreeCapacity(message: String?): Boolean {
package com.inspiredandroid.kai.network
sealed class AnthropicApiException(message: String? = null, cause: Throwable? = null) : ApiException(message, cause)
sealed class ApiException(message: String?, cause: Throwable? = null) : Exception(message, cause)
sealed class GeminiApiException(message: String? = null, cause: Throwable? = null) : ApiException(message, cause)
sealed class OpenAICompatibleApiException(message: String? = null, cause: Throwable? = null) : ApiException(message, cause)
sealed interface UiError {
}
