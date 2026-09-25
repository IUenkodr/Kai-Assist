
                        "content": "Hello there"
                        "content": "Hello 世界 🌍"
                        "content": "Hello",
                        "content": "Line1\nLine2\tTabbed"
                        "content": "legacy attach",
                        "createdAt": 1000,
                        "createdAt": 3000,
                        "data": "base64data"
                        "data": "legacybase64",
                        "fileName": "old.jpg"
                        "futureField": "ignored"
                        "id": "conv-1",
                        "id": "conv-2",
                        "id": "msg-1",
                        "messages": [],
                        "mimeType": "image/jpeg",
                        "mimeType": "text/plain",
                        "role": "assistant",
                        "role": "user",
                        "updatedAt": 2000
                        "updatedAt": 4000
                        Attachment(data = "imgdata1", mimeType = "image/jpeg", fileName = null),
                        Attachment(data = "imgdata2", mimeType = "image/png", fileName = null),
                        Attachment(data = "textdata", mimeType = "text/plain", fileName = "notes.txt"),
                    ),
                    attachments = listOf(
                    content = "2+2 equals 4.",
                    content = "Hi",
                    content = "Response",
                    content = "Thanks!",
                    content = "What is 2+2?",
                    content = "look at these",
                    createdAt = 1000L,
                    data = "imagedata",
                    data = null,
                    id = "conv-1",
                    id = "msg-1",
                    id = "msg-2",
                    id = "msg-3",
                    messages = emptyList(),
                    mimeType = "image/png",
                    mimeType = null,
                    role = "assistant",
                    role = "user",
                    updatedAt = 2000L,
                    {
                    }
                    },
                "anotherUnknown": 42
                "conversations": [
                "conversations": []
                "createdAt": 1000,
                "id": "conv-123",
                "id": "conv-empty",
                "id": "conv-legacy",
                "id": "conv-old",
                "id": "conv-special",
                "id": "conv-unicode",
                "messages": [
                "messages": [],
                "serviceId": "gemini"
                "title": "Old Title",
                "unknownField": "should be ignored",
                "updatedAt": 1000
                "updatedAt": 2000
                "updatedAt": 2000,
                "version": 1,
                ),
                Conversation(
                Conversation.Message(
                TerminalLine.Command("ls -la"),
                TerminalLine.Error("ls: cannot access /missing: No such file or directory"),
                TerminalLine.Output("drwxr-xr-x 2 root root 40 Jan 1 00:00 ."),
                TerminalLine.Output("total 0"),
                ]
                ],
            ),
            conversations = listOf(
            createdAt = 1000L,
            createdAt = 1L,
            createdAt = 5000L,
            id = "conv-456",
            id = "conv-789",
            id = "conv-full",
            id = "conv-multi",
            id = "conv-shell",
            messages = emptyList(),
            messages = listOf(
            shellTranscript = listOf(
            updatedAt = 2000L,
            updatedAt = 2L,
            updatedAt = 3000L,
            updatedAt = 6000L,
            version = 2,
            {
            }
        """.trimIndent()
        )
        // Conversations saved by earlier versions have data/mimeType/fileName on the message
        // and no `attachments` field. The schema must still accept this shape; the conversion
        // to an `attachments` list happens in RemoteDataRepository.loadConversation.
        assertEquals("Hello there", message.content)
        assertEquals("Hello 世界 🌍", conversation.messages[0].content)
        assertEquals("Hello", conversation.messages[0].content)
        assertEquals("Line1\nLine2\tTabbed", conversation.messages[0].content)
        assertEquals("assistant", message.role)
        assertEquals("base64data", conversation.messages[0].data)
        assertEquals("conv-1", data.conversations[0].id)
        assertEquals("conv-123", conversation.id)
        assertEquals("conv-2", data.conversations[1].id)
        assertEquals("conv-empty", conversation.id)
        assertEquals("image/jpeg", decoded.messages[0].attachments[0].mimeType)
        assertEquals("image/jpeg", m.mimeType)
        assertEquals("legacybase64", m.data)
        assertEquals("msg-1", conversation.messages[0].id)
        assertEquals("msg-1", message.id)
        assertEquals("notes.txt", decoded.messages[0].attachments[2].fileName)
        assertEquals("old.jpg", m.fileName)
        assertEquals("text/plain", conversation.messages[0].mimeType)
        assertEquals("user", conversation.messages[0].role)
        assertEquals(0, conversation.messages.size)
        assertEquals(0, conversation.shellTranscript.size)
        assertEquals(0, data.conversations.size)
        assertEquals(0, m.attachments.size)
        assertEquals(1, conversation.messages.size)
        assertEquals(1, data.version)
        assertEquals(1000L, conversation.createdAt)
        assertEquals(2, data.conversations.size)
        assertEquals(2, data.version)
        assertEquals(2000L, conversation.updatedAt)
        assertEquals(3, decoded.messages.size)
        assertEquals(3, decoded.messages[0].attachments.size)
        assertEquals(4, decoded.shellTranscript.size)
        assertEquals(conversation, decoded)
        assertEquals(data, decoded)
        assertEquals(original, decoded)
        assertNull(decoded.messages[0].data)
        assertNull(decoded.messages[0].mimeType)
        assertNull(message.data)
        assertNull(message.mimeType)
        assertTrue(decoded.shellTranscript[0] is TerminalLine.Command)
        assertTrue(decoded.shellTranscript[1] is TerminalLine.Output)
        assertTrue(decoded.shellTranscript[3] is TerminalLine.Error)
        encodeDefaults = true
        ignoreUnknownKeys = true
        val conversation = Conversation(
        val conversation = json.decodeFromString<Conversation>(jsonString)
        val data = ConversationsData(
        val data = json.decodeFromString<ConversationsData>(jsonString)
        val decoded = json.decodeFromString<Conversation>(jsonString)
        val decoded = json.decodeFromString<ConversationsData>(jsonString)
        val jsonString = """
        val jsonString = json.encodeToString(conversation)
        val jsonString = json.encodeToString(data)
        val jsonString = json.encodeToString(original)
        val m = conversation.messages.single()
        val message = conversation.messages[0]
        val original = Conversation(
    @Test
    fun `deserialize ConversationsData with default version`() {
    fun `deserialize ConversationsData with version`() {
    fun `deserialize conversation ignores legacy fields`() {
    fun `deserialize conversation ignores unknown keys`() {
    fun `deserialize conversation message with optional fields missing`() {
    fun `deserialize conversation with all fields`() {
    fun `deserialize conversation with empty messages list`() {
    fun `deserialize conversation with special characters in content`() {
    fun `deserialize conversation with unicode content`() {
    fun `deserialize empty conversations list`() {
    fun `deserialize legacy single-file message keeps old fields readable`() {
    fun `deserialize message ignores unknown keys`() {
    fun `legacy conversation without shell transcript loads with empty list`() {
    fun `round trip conversation with multiple messages`() {
    fun `round trip shell transcript with all line variants`() {
    fun `serialize ConversationsData includes version`() {
    fun `serialize and deserialize conversation with multi-attachment message`() {
    fun `serialize conversation includes all fields`() {
    fun `serialize conversation with null optional fields`() {
    private val json = Json {
    }
class ConversationSerializationTest {
import com.inspiredandroid.kai.TerminalLine
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
package com.inspiredandroid.kai.data
}
