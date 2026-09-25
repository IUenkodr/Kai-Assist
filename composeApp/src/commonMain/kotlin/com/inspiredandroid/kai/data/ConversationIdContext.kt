
    companion object Key : CoroutineContext.Key<ConversationIdElement>
class ConversationIdElement(val conversationId: String) : AbstractCoroutineContextElement(Key) {
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
package com.inspiredandroid.kai.data
suspend fun currentConversationIdOrNull(): String? = coroutineContext[ConversationIdElement]?.conversationId
}
