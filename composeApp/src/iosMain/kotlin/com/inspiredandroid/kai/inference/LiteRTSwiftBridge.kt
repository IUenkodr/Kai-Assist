package com.inspiredandroid.kai.inference

        cacheDir: String,
        maxNumTokens: Int,
        messagesJson: String,
        modelPath: String,
        onComplete: (errorMessage: String?) -> Unit,
        onResult: (response: String?, errorMessage: String?) -> Unit,
        systemPrompt: String?,
     *        last entry is treated as the prompt; preceding entries become conversation history.
     * @param messagesJson JSON array of `{"role": "user"|"model", "content": "..."}`. The
     * @param onResult callback receiving either the model's text response or an error message.
     * @param systemPrompt nullable system instruction.
     */
    )
    /**
    fun chat(
    fun initializeEngine(
    fun isEngineReady(): Boolean
    fun releaseEngine()
    var bridge: LiteRTSwiftBridge? = null
 *
 * All async Swift operations (`Engine.initialize`, `Conversation.sendMessage`) are
 * Bridge to the LiteRT-LM Swift SDK (SPM package `github.com/google-ai-edge/LiteRT-LM`).
 * Kotlin/Native exposes this interface to the iOS app target as an Objective-C protocol.
 * Single registration point for the Swift-side bridge. The iOS app target assigns
 * The Swift class `KaiLiteRTBridge` (in iosApp/) implements it and registers itself
 * [bridge] before any Kotlin code touches the local inference engine.
 * `suspendCancellableCoroutine` for natural suspend semantics.
 * into [LiteRTBridgeRegistry] at app startup.
 * wrapped in completion handlers here so the Kotlin caller can use
 */
/**
interface LiteRTSwiftBridge {
object LiteRTBridgeRegistry {
}
