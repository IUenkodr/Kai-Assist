
        TODO("Not yet implemented")
        callback: (Result<Unit>) -> Unit,
        clearQueue: Boolean,
        clearQueueOnCancellation: Boolean,
        get() = TODO("Not yet implemented")
        get() = null
        set(value) {}
        text: String,
    ) {
    @ExperimentalVoiceApi
    override fun close() {
    override fun enqueue(text: String, clearQueue: Boolean) {
    override fun plusAssign(text: String) {
    override fun say(
    override fun stop() {
    override suspend fun say(
    override val isSynthesizing: StateFlow<Boolean>
    override val isWarmingUp: StateFlow<Boolean>
    override val language: String = "en-US"
    override val voices: Sequence<Voice> = emptySequence()
    override var currentVoice: Voice?
    override var isMuted: Boolean
    override var pitch: Float
    override var rate: Float
    override var volume: Int
    }
@file:OptIn(ExperimentalVoiceApi::class)
class FakeTextToSpeechInstance : TextToSpeechInstance {
import kotlinx.coroutines.flow.StateFlow
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.Voice
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
package com.inspiredandroid.kai.screenshots
}
