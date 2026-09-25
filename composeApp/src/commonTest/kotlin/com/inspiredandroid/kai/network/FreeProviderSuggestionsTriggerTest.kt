
                .isFreeCapacityError(),
                Service.Cerebras.id,
                Service.Gemini.id,
                Service.Groq.id,
                Service.OllamaCloud.id,
                Service.OpenRouter.id,
                exception = OpenAICompatibleInvalidApiKeyException(),
                exception = OpenAICompatibleQuotaExhaustedException(),
                exception = OpenAICompatibleRateLimitExceededException(),
                exception = exception,
                noConfiguredServices = false,
                noConfiguredServices = true,
            ),
            OpenAICompatibleProviderErrorException("Internal server error in model runtime")
            assertNotNull(suggestion.service.apiKeyUrl)
            assertTrue(suggestion.signupUrl.startsWith("http"))
            freeProviderSuggestions.map { it.service.id },
            listOf(
            shouldShowFreeProviderSuggestions(
        )
        assertEquals(
        assertFalse(
        assertFalse(AllServicesFailedException().isFreeCapacityError())
        assertFalse(OpenAICompatibleEmptyResponseException().isFreeCapacityError())
        assertFalse(OpenAICompatibleInvalidApiKeyException().isFreeCapacityError())
        assertTrue(
        assertTrue(OpenAICompatibleQuotaExhaustedException().isFreeCapacityError())
        assertTrue(OpenAICompatibleRateLimitExceededException().isFreeCapacityError())
        assertTrue(exception.isFreeCapacityError())
        freeProviderSuggestions.forEach { suggestion: FreeProviderSuggestion ->
        val exception = OpenAICompatibleProviderErrorException("All free providers failed")
        }
    @Test
    fun `free provider catalog lists top free-usage services with signup urls`() {
    fun `invalid api key with no services does not show suggestions`() {
    fun `isFreeCapacityError only matches capacity failures`() {
    fun `kai9000 all free providers failed message shows suggestions`() {
    fun `quota exhausted with no services shows free provider suggestions`() {
    fun `rate limit with configured services does not show suggestions`() {
    fun `rate limit with no services shows free provider suggestions`() {
    fun `unrelated provider error does not show suggestions`() {
    }
class FreeProviderSuggestionsTriggerTest {
import com.inspiredandroid.kai.data.FreeProviderSuggestion
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.freeProviderSuggestions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
package com.inspiredandroid.kai.network
}
