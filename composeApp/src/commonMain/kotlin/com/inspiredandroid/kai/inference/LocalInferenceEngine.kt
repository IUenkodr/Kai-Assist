package com.inspiredandroid.kai.inference
import io.github.vinceglb.filekit.PlatformFile
import kotlinx.coroutines.flow.StateFlow

        else -> DevicePerformance.POOR
        messages: List<InferenceMessage>,
        ratio >= 1.85 -> DevicePerformance.OK
        ratio >= 2.5 -> DevicePerformance.GOOD
        systemPrompt: String?,
        tools: List<LocalTool> = emptyList(),
     *
     * Copy a user-picked `.litertlm` into app storage. Streams bytes — never loads the
     * Expected SHA-256 of the downloaded file, lowercase hex. Blank for imported models,
     * Fire-and-forget release, run on the engine's own coroutine scope. Called from
     * Null means *unknown*, not *incapable* — the id may not be downloaded, the bundle's
     * Synthetic [LocalModel] entries for user-imported files under `imports/`, so the
     * What the model file for [modelId] declares it can do. Reads the bundle's own
     * all (the iOS bridge predates it). Callers that get null must fall back to their own
     * assumptions rather than treat the model as supporting nothing.
     * everything else goes under `imports/`.
     * for as long as the file stays put.
     * full file into memory. Catalog file names land in the matching catalog path;
     * metadata may predate the declaration, or the platform may not implement the probe at
     * metadata, so it answers before the model is ever loaded, and the answer is cached
     * non-suspend contexts (e.g. Settings UI when the user picks a different model) so
     * settings UI can show context sliders and performance labels.
     * the GPU driver has time to reclaim memory before the next inference.
     * whose bytes the user supplies directly and for which no digest is known.
     */
    ): String
    /**
    /** Non-null file name while a local import copy is in progress. */
    /** Null when the bundle declares no usable defaults; callers keep their own values. */
    /** True for user-imported models that are not in [MODEL_CATALOG]. */
    CHECKSUM_MISMATCH,
    DOWNLOAD_INCOMPLETE,
    ERROR,
    GOOD,
    INITIALIZING,
    NETWORK_ERROR,
    NOT_ENOUGH_DISK_SPACE,
    OK,
    POOR,
    READY,
    UNINITIALIZED,
    fun cancelDownload()
    fun cancelImport()
    fun getAvailableModels(): List<LocalModel>
    fun getDownloadedModels(): List<DownloadedModel>
    fun getFreeSpaceBytes(): Long
    fun getImportedLocalModels(): List<LocalModel>
    fun releaseInBackground()
    fun startDownload(model: LocalModel)
    return modelFileMb + model.gpuMemoryMb + extraMemoryMb.toInt()
    return when {
    suspend fun chat(
    suspend fun deleteModel(modelId: String)
    suspend fun importModel(source: PlatformFile): ModelImportResult
    suspend fun initialize(model: DownloadedModel, contextTokens: Int = 0)
    suspend fun modelCapabilities(modelId: String): LocalModelCapabilities? = null
    suspend fun release()
    val content: String,
    val currentModelId: String?
    val defaultContextTokens: Int,
    val descriptionJsonString: String,
    val displayName: String,
    val downloadError: StateFlow<DownloadError?>
    val downloadProgress: StateFlow<Float?>
    val downloadUrl: String,
    val downloadingModelId: StateFlow<String?>
    val engineState: StateFlow<EngineState>
    val execute: suspend (jsonArgs: String) -> String,
    val extraMemoryMb = (extraTokens.toLong() * model.kvPerTokenBytes) / (1024 * 1024)
    val extraTokens = contextTokens - model.defaultContextTokens
    val fileName: String,
    val filePath: String,
    val gpuMemoryBytes = estimatedGpuMemoryMb.toLong() * 1024 * 1024
    val gpuMemoryMb: Int,
    val id: String,
    val importError: StateFlow<ModelImportError?>
    val importProgress: StateFlow<Float?>
    val importingFileName: StateFlow<String?>
    val isImported: Boolean = false,
    val isRecommended: Boolean = false,
    val kvPerTokenBytes: Int,
    val maxContextTokens: Int,
    val modelFileMb = (model.sizeBytes / (1024 * 1024)).toInt()
    val name: String,
    val ratio = totalMemoryBytes.toDouble() / gpuMemoryBytes
    val role: String,
    val sampler: LocalSamplerDefaults?,
    val sha256: String = "",
    val sizeBytes: Long,
    val supportsAudio: Boolean,
    val supportsFunctionCalling: Boolean,
    val supportsThinking: Boolean,
    val supportsVision: Boolean,
    val temperature: Float,
    val topK: Int,
    val topP: Float,
    }
 *
 *        JSON-encoded result string
 *        tool, e.g. `{"name":"get_time","description":"...","parameters":{"type":"object",...}}`
 * @param descriptionJsonString a complete OpenAPI/OpenAI-style JSON object describing the
 * @param execute receives the JSON arguments object as a string and returns the
 * @param name the tool's identifier as the model will see it
 * A model that does not declare function calling carries no tool section in its chat
 * A tool definition handed to the on-device inference engine.
 * Sampling defaults a `.litertlm` bundle ships for itself. Models converted from different
 * The bundle's declared sampling defaults, or null when it declares none. A bundle with
 * What a model file declares about itself, read from the `.litertlm` bundle's own metadata.
 * answer a tool would have produced, which is exactly how Qwen3 0.6B reports a fictional
 * greedy decoding — so zero (or negative) means "no opinion", not "sample greedily".
 * nothing to say reports zeroes, and passing those straight through would pin the model to
 * template. Handing it tools anyway does not make it ignore them — it makes it invent the
 * time instead of calling `get_local_time`.
 * upstream families want different values — one hardcoded triple is right for none of them.
 */
)
/**
/** A model file on disk did not match the digest pinned in the catalog and was removed. */
class InferenceTimeoutException : Exception()
class InsufficientMemoryException : Exception()
class ModelIntegrityException : Exception()
class NoModelDownloadedException : Exception()
data class DownloadedModel(
data class InferenceMessage(
data class LocalModel(
data class LocalModelCapabilities(
data class LocalSamplerDefaults(
data class LocalTool(
enum class DevicePerformance {
enum class DownloadError {
enum class EngineState {
fun calculateDevicePerformance(totalMemoryBytes: Long, estimatedGpuMemoryMb: Int): DevicePerformance {
fun estimateGpuMemoryMb(model: LocalModel, contextTokens: Int): Int {
fun localSamplerDefaultsOrNull(temperature: Float, topK: Int, topP: Float): LocalSamplerDefaults? = if (topK > 0 && temperature > 0f) LocalSamplerDefaults(temperature, topK, topP) else null
interface LocalInferenceEngine {
}
