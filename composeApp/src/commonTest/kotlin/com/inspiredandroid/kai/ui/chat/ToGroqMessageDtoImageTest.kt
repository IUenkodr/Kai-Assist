
            Attachment(data = "BASE64IMAGEDATA", mimeType = "image/png", fileName = "cat.png"),
        ),
        // text part + image part
        assertEquals(2, content.size)
        assertEquals(JsonPrimitive("hi"), plain.toGroqMessageDto(supportsImages = false).content)
        assertEquals(JsonPrimitive("hi"), plain.toGroqMessageDto(supportsImages = true).content)
        assertEquals(JsonPrimitive("what's in this picture?"), dto.content)
        assertTrue(content is JsonArray, "expected content-parts array, got ${content?.let { it::class.simpleName }}")
        attachments = persistentListOf(
        content = "what's in this picture?",
        role = History.Role.USER,
        val content = dto.content
        val dto = userWithImage().toGroqMessageDto(supportsImages = false)
        val dto = userWithImage().toGroqMessageDto(supportsImages = true)
        val plain = History(role = History.Role.USER, content = "hi")
    )
    @Test
    fun `plain-text user message is always a JsonPrimitive regardless of flag`() {
    fun `supportsImages=false flattens to plain JsonPrimitive and drops images`() {
    fun `supportsImages=true emits image_url content-parts array`() {
    private fun userWithImage() = History(
    }
 *
 * "messages[N].content must be a string".
 * (the kai9000 proxy fans out to text-only Groq fallbacks on rate-limit), image attachments
 * Guards the Bug A invariant: when the target service can't accept content-parts payloads
 * Sending a `JsonArray` content to gpt-oss-20b/120b triggers a 400:
 * must be dropped from the outgoing message and `content` must be a plain string.
 */
/**
class ToGroqMessageDtoImageTest {
import com.inspiredandroid.kai.data.Attachment
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
package com.inspiredandroid.kai.ui.chat
}
