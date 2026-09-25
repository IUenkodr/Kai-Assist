package com.inspiredandroid.kai.data
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

    companion object Key : CoroutineContext.Key<ConversationIdElement>
class ConversationIdElement(val conversationId: String) : AbstractCoroutineContextElement(Key) {
suspend fun currentConversationIdOrNull(): String? = coroutineContext[ConversationIdElement]?.conversationId
}
