
        assertEquals("Connection timed out", error.message)
        assertEquals("Engine not initialized", error.message)
        assertEquals("flagged for 'illicit, violent'", error.detail)
        assertEquals("invalid model parameter", error.detail)
        assertEquals("upstream model failed", error.detail)
        assertIs<UiError.Resource>(GeminiInvalidApiKeyException().toUiError())
        assertIs<UiError.Resource>(GeminiRateLimitExceededException().toUiError())
        assertIs<UiError.Resource>(OpenAICompatibleEmptyResponseException().toUiError())
        assertIs<UiError.Resource>(OpenAICompatibleInvalidApiKeyException().toUiError())
        assertIs<UiError.Resource>(error)
        assertIs<UiError.ResourceWithDetail>(error)
        assertIs<UiError.Text>(error)
        val error = GenericNetworkException("Connection timed out").toUiError()
        val error = IllegalStateException("Engine not initialized").toUiError()
        val error = InferenceTimeoutException().toUiError()
        val error = InsufficientMemoryException().toUiError()
        val error = NoModelDownloadedException().toUiError()
        val error = OpenAICompatibleBadRequestException("invalid model parameter").toUiError()
        val error = OpenAICompatibleContentModerationException("flagged for 'illicit, violent'").toUiError()
        val error = OpenAICompatibleContentModerationException().toUiError()
        val error = OpenAICompatibleProviderErrorException("upstream model failed").toUiError()
        val error = OpenAICompatibleServiceUnavailableException().toUiError()
        val error = OpenAICompatibleTimeoutException().toUiError()
        val error = RuntimeException("  ").toUiError()
        val error = RuntimeException().toUiError()
    @Test
    fun `BadRequest with detail maps to ResourceWithDetail`() {
    fun `ContentModeration with detail maps to ResourceWithDetail`() {
    fun `ContentModeration without detail maps to Resource`() {
    fun `GenericNetworkException surfaces message as Text`() {
    fun `IllegalStateException with message surfaces as UiError Text`() {
    fun `InferenceTimeoutException maps to resource`() {
    fun `InsufficientMemoryException maps to resource`() {
    fun `NoModelDownloadedException maps to resource`() {
    fun `ProviderError with detail maps to ResourceWithDetail`() {
    fun `ServiceUnavailable maps to Resource`() {
    fun `Timeout maps to Resource`() {
    fun `exception with blank message falls back to error_unknown resource`() {
    fun `exception with null message falls back to error_unknown resource`() {
    fun `known API exceptions still map to their specific resources`() {
    }
class UiErrorTest {
import com.inspiredandroid.kai.inference.InferenceTimeoutException
import com.inspiredandroid.kai.inference.InsufficientMemoryException
import com.inspiredandroid.kai.inference.NoModelDownloadedException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
package com.inspiredandroid.kai.network
}
