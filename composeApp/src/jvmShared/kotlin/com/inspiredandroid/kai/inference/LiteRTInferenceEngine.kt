package com.inspiredandroid.kai.inference
import com.google.ai.edge.litertlm.Backend
import com.google.ai.edge.litertlm.Capabilities
import com.google.ai.edge.litertlm.Contents
import com.google.ai.edge.litertlm.ConversationConfig
import com.google.ai.edge.litertlm.Engine
import com.google.ai.edge.litertlm.EngineConfig
import com.google.ai.edge.litertlm.Message
import com.google.ai.edge.litertlm.OpenApiTool
import com.google.ai.edge.litertlm.SamplerConfig
import com.google.ai.edge.litertlm.tool
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.name
import io.github.vinceglb.filekit.size
import io.github.vinceglb.filekit.source
import io.github.vinceglb.filekit.withScopedAccess
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.security.MessageDigest
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.io.Buffer
import kotlinx.io.asSink
import kotlinx.io.buffered

                                _downloadProgress.value = percent / 100f
                                lastNotifiedPercent = percent
                                lastProgressTs = now
                                onProgress((copied.toFloat() / totalBytes).coerceIn(0f, 1f))
                                updateDownloadNotificationProgress(percent)
                            digest?.update(buffer, 0, bytesRead)
                            ensureActive()
                            if (bytesRead <= 0) break
                            if (now - lastProgressTs > 200) {
                            if (percent != lastNotifiedPercent) {
                            initWithBackend(Backend.CPU(), null)
                            initWithBackend(Backend.GPU(), null)
                            output.write(buffer, 0, bytesRead)
                            totalBytesRead += bytesRead
                            val bytesRead = input.read(buffer)
                            val now = System.currentTimeMillis()
                            val percent = (totalBytesRead * 100 / contentLength).toInt().coerceIn(1, 100)
                            }
                        _downloadError.value = DownloadError.CHECKSUM_MISMATCH
                        _downloadError.value = DownloadError.DOWNLOAD_INCOMPLETE
                        backend = backend,
                        cacheDir = getModelCacheDirectory(),
                        copied += bytesRead
                        coroutineContext.ensureActive()
                        if (bytesRead == -1L) break
                        if (totalBytes > 0) {
                        initWithBackend(Backend.CPU(), requestedTokens)
                        initWithBackend(Backend.GPU(), requestedTokens)
                        maxNumTokens = maxTokens,
                        modelPath = model.filePath,
                        return@launch
                        sink.write(buffer, bytesRead)
                        tempFile.delete()
                        throw e
                        try {
                        val bytesRead = rawSource.readAtMostTo(buffer, COPY_BUFFER_SIZE_BYTES)
                        while (true) {
                        }
                        } catch (e2: Exception) {
                    "user" -> Message.user(sanitized)
                    )
                    // Catalog model with a pinned digest: the size is known exactly, so
                    // Context size not supported — retry with model default
                    // Record the verified digest before the file becomes visible under its
                    // anything short is a truncated transfer rather than a swapped file.
                    // beat to drain before allocating ~GB of new GPU buffers.
                    // briefly hold both resident and trip Android's LMK. Give the driver a
                    // engine.close() returns before the OpenCL driver actually reclaims the
                    // previous model's GPU buffers, so loading a second model on top would
                    // real name, so a model is never present without its marker.
                    ?.filter { it.isFile && (CUSTOM_MODEL_ID_PREFIX + it.nameWithoutExtension) == modelId }
                    ?.forEach { it.delete() }
                    File(modelDir, digestMarkerFileName(model.fileName)).writeText(model.sha256)
                    SamplerConfig(topK = it.topK, topP = it.topP.toDouble(), temperature = it.temperature.toDouble())
                    System.gc()
                    _downloadError.value = DownloadError.NOT_ENOUGH_DISK_SPACE
                    _importError.value = ModelImportError.INVALID_EXTENSION
                    connection.disconnect()
                    conv.sendMessage(lastMessage)
                    delay(GPU_DRAIN_DELAY_MS.milliseconds)
                    displayName = catalogModel.displayName,
                    e.initialize()
                    else -> Message.model(sanitized)
                    filePath = modelFile.absolutePath,
                    id = catalogModel.id,
                    if (!digestMatches(model.sha256, digest.digest().toDigestHex())) {
                    if (downloadedSize < contentLength * 0.95) {
                    if (requestedTokens != null) {
                    if (totalBytesRead != model.sizeBytes) {
                    println("LiteRT: init failed with maxNumTokens=$requestedTokens, falling back to default: ${e.message}")
                    return e
                    return@launch
                    return@withContext ModelImportResult.Failure(ModelImportError.INVALID_EXTENSION)
                    sink.flush()
                    sizeBytes = modelFile.length(),
                    tempFile.copyTo(targetFile, overwrite = true)
                    tempFile.delete()
                    tempFile.outputStream().use { output ->
                    temperature = sampler.temperature,
                    throw IOException("Download failed: HTTP $responseCode")
                    throw IllegalStateException("Model file missing or too small: ${model.filePath}")
                    throw InsufficientMemoryException()
                    topK = sampler.topK,
                    topP = sampler.topP,
                    try {
                    val buffer = Buffer()
                    val config = EngineConfig(
                    val downloadedSize = tempFile.length()
                    val e = Engine(config)
                    var copied = 0L
                    var lastProgressTs = 0L
                    while (true) {
                    }
                    } catch (e: Exception) {
                    } else {
                )
                ),
                .orEmpty()
                // Also remove any collision-suffixed match by id→filename from scan
                // ERROR. Cancellation lands at a suspension point (release/delay): READY
                // Hash as the bytes stream past, so verification costs no extra read of a
                // Only start the foreground service once we have a live connection.
                // Release any currently-loaded engine before measuring available memory,
                // Starting it earlier risks ForegroundServiceDidNotStartInTimeException if
                // This import takes over a catalog slot. Record that the bytes are the
                // User stop, not an engine failure — reflect the actual state instead of
                // actually have tools, otherwise plain-text responses get parsed as FCs.
                // automaticToolCalling = true drives the parser; only enable when we
                // file that can be several GB.
                // if an engine is still loaded, UNINITIALIZED after it was released. If
                // otherwise its GPU/CPU working set counts against the headroom check and
                // pinned digest.
                // switching between models spuriously fails (e.g. Qwen -> Gemma 4).
                // the connect() above fails fast (e.g. offline) before the service can run.
                // the native load itself finished, the success path above already ran.
                // user's own so the load-time check does not hold them to that entry's
                ?.filter { it.isFile }
                ?.map { it.name }
                ?.toSet()
                ?: run {
                @Suppress("DEPRECATION")
                DownloadedModel(
                File(destDir, digestMarkerFileName(target.fileName)).writeText(USER_SUPPLIED_MARKER)
                File(modelsDir, "$IMPORTS_DIR/$fileName").delete()
                File(modelsDir, modelId).deleteRecursively()
                _downloadError.value = DownloadError.NETWORK_ERROR
                _downloadProgress.value = null
                _downloadingModelId.value = null
                _engineState.value = EngineState.ERROR
                _engineState.value = EngineState.INITIALIZING
                _engineState.value = EngineState.READY
                _engineState.value = if (engine != null) EngineState.READY else EngineState.UNINITIALIZED
                _importError.value = ModelImportError.COPY_FAILED
                _importError.value = ModelImportError.FILE_TOO_SMALL
                _importError.value = ModelImportError.INVALID_EXTENSION
                _importError.value = ModelImportError.NOT_ENOUGH_DISK_SPACE
                _importProgress.value = progress
                automaticToolCalling = toolProviders.isNotEmpty(),
                capabilitiesMutex.withLock { capabilitiesByPath.remove(targetFile.absolutePath) }
                connection.connect()
                connection.connectTimeout = 30_000
                connection.disconnect()
                connection.inputStream.use { input ->
                connection.instanceFollowRedirects = true
                connection.readTimeout = 60_000
                conversation = newEngine.createConversation()
                coroutineContext.ensureActive()
                currentContextTokens = contextTokens
                currentModelCapabilities = cachedModelCapabilities(model.filePath)
                currentModelId = model.id
                customLocalModel(file.name, file.length(), modelId).copy(isImported = true) to file
                digest.update(buffer, 0, bytesRead)
                displayName = local.displayName,
                engine = newEngine
                filePath = file.absolutePath,
                fun initWithBackend(backend: Backend, maxTokens: Int?): Engine {
                id = local.id,
                if (!modelFile.exists() || modelFile.length() < MIN_MODEL_FILE_BYTES) {
                if (!tempFile.renameTo(targetFile)) {
                if (availMem < MIN_MEMORY_HEADROOM_BYTES) {
                if (bytesRead <= 0) break
                if (digest != null) {
                if (e is CancellationException) throw e
                if (freeSpace < model.sizeBytes + DOWNLOAD_SPACE_BUFFER_BYTES) {
                if (hadExistingEngine) {
                if (notificationStarted) stopDownloadNotificationService()
                if (responseCode !in 200..299) {
                if (tempFile?.exists() == true) tempFile.delete()
                importJob = null
                importsDir.listFiles()
                initialMessages = initialMessages,
                modelDir.mkdirs()
                notificationStarted = true
                null
                println("LiteRT: initializing model=${model.id} maxNumTokens=$requestedTokens")
                release()
                return@withContext ModelImportResult.Failure(ModelImportError.COPY_FAILED, "Incomplete copy")
                return@withContext ModelImportResult.Failure(ModelImportError.FILE_TOO_SMALL)
                return@withContext ModelImportResult.Failure(ModelImportError.INVALID_EXTENSION)
                return@withContext ModelImportResult.Failure(ModelImportError.NOT_ENOUGH_DISK_SPACE)
                sampler = localSamplerDefaultsOrNull(
                samplerConfig = currentModelCapabilities?.sampler?.let {
                sizeBytes = file.length(),
                source.source().use { rawSource ->
                startDownloadNotificationService()
                supportsAudio = modalities.audio,
                supportsFunctionCalling = caps.supportsFunctionCalling(),
                supportsThinking = caps.supportsThinking(),
                supportsVision = modalities.vision,
                systemInstruction = sanitizedSystemPrompt?.let { Contents.of(it) },
                tempFile = File(modelDir, "${model.fileName}.tmp")
                tempFile.copyTo(destFile, overwrite = true)
                tempFile.delete()
                throw InferenceTimeoutException()
                throw e
                tools = toolProviders,
                val availMem = getAvailableMemoryBytes()
                val buffer = ByteArray(COPY_BUFFER_SIZE_BYTES.toInt())
                val bytesRead = input.read(buffer)
                val connection = URL(model.downloadUrl).openConnection() as HttpURLConnection
                val contentLength = connection.contentLengthLong.takeIf { it > 0 } ?: model.sizeBytes
                val digest = model.sha256.takeIf { it.isNotBlank() }?.let { MessageDigest.getInstance("SHA-256") }
                val fileName = modelId.removePrefix(CUSTOM_MODEL_ID_PREFIX) + ".litertlm"
                val freeSpace = getFreeSpaceBytes()
                val hadExistingEngine = engine != null
                val importsDir = File(modelsDir, IMPORTS_DIR)
                val modelDir = File(modelsDir, model.id)
                val modelFile = File(model.filePath)
                val modelId = CUSTOM_MODEL_ID_PREFIX + file.nameWithoutExtension
                val modelsDir = getModelStorageDirectory()
                val newEngine = try {
                val requestedTokens = if (contextTokens > 0) contextTokens else null
                val responseCode = connection.responseCode
                val sanitized = sanitizeForLiteRt(msg.content) ?: ""
                val sink = fileOut.asSink().buffered()
                val targetFile = File(modelDir, model.fileName)
                var lastNotifiedPercent = -1
                var totalBytesRead = 0L
                verifyModelIntegrity(model.id, modelFile)
                when (msg.role) {
                withTimeout(INFERENCE_TIMEOUT_MS.milliseconds) {
                }
                } ?: SamplerConfig(topK = 40, topP = 0.95, temperature = 0.8),
                } catch (e: Exception) {
                } else {
            )
            .orEmpty()
            // An import can land different bytes at a path we have already read.
            // Conversation.close() / Engine.close() throw IllegalStateException on double-close.
            // Null before close so a concurrent release() sees null and skips —
            // Wait for any in-flight idle release so its native teardown doesn't race with deleteRecursively().
            // Whatever we learned about those bytes no longer describes anything on disk,
            // and a re-download or import can land different bytes at the same path.
            ?.filter { it.isFile && isLitertlmExtension(it.name) && !it.name.endsWith(".tmp") && !it.name.endsWith(".importing") }
            ?.map { file ->
            ?.sortedBy { it.name.lowercase() }
            DownloadedModel(
            LocalModelCapabilities(
            ModelImportResult.Failure(ModelImportError.COPY_FAILED, e.message)
            ModelImportResult.Success(modelId = target.modelId, matchedCatalog = target.matchedCatalog)
            _downloadError.value = null
            _downloadProgress.value = 0f
            _downloadingModelId.value = model.id
            _engineState.value = EngineState.INITIALIZING
            _engineState.value = EngineState.UNINITIALIZED
            _importError.value = ModelImportError.CANCELLED
            _importError.value = ModelImportError.COPY_FAILED
            _importProgress.value = 1f
            _importProgress.value = null
            _importingFileName.value = null
            capabilitiesMutex.withLock { capabilitiesByPath.clear() }
            capabilitiesMutex.withLock { capabilitiesByPath.remove(destFile.absolutePath) }
            caps.close()
            conversation = conv
            conversation = null
            currentModelCapabilities = null
            currentModelId = null
            delay(IDLE_RELEASE_MS.milliseconds)
            dest.outputStream().use { fileOut ->
            destDir.mkdirs()
            engine = null
            idleReleaseJob = null
            idleReleaseJob?.cancel()
            idleReleaseJob?.cancelAndJoin()
            if (!isLitertlmExtension(fileName)) {
            if (!tempFile.renameTo(destFile)) {
            if (copiedSize < MIN_MODEL_FILE_BYTES) {
            if (currentModelId == model.id && currentContextTokens == contextTokens && _engineState.value == EngineState.READY) return@withContext
            if (currentModelId == modelId) {
            if (destFile.exists()) destFile.delete()
            if (getFreeSpaceBytes() < sizeForSpace + DOWNLOAD_SPACE_BUFFER_BYTES) {
            if (importJob === currentCoroutineContext().job) {
            if (isCustomModelId(modelId)) {
            if (lastUserIndex < 0) throw IllegalStateException("No user message found")
            if (modelFile.exists()) {
            if (sourceSize > 0 && copiedSize < sourceSize * 0.95) {
            if (sourceSize in 0 until MIN_MODEL_FILE_BYTES) {
            if (target.matchedCatalog) {
            if (tempFile.exists()) tempFile.delete()
            release()
            return@withContext ModelImportResult.Failure(ModelImportError.COPY_FAILED, "Download in progress")
            runCatching { convToClose?.close() }
            runCatching { engineToClose?.close() }
            runCatching { prev?.close() }
            scheduleIdleRelease()
            streamCopyWithProgress(source, tempFile, sourceSize) { progress ->
            stripThinkBlocks(response.toString())
            tempFile = File(destDir, "${target.fileName}.importing")
            tempFile = null
            tempFile?.delete()
            throw e
            try {
            val config = ConversationConfig(
            val conv = currentEngine.createConversation(config)
            val convToClose = conversation
            val copiedSize = tempFile.length()
            val currentEngine = engine ?: throw IllegalStateException("Engine not initialized")
            val destDir = File(modelsDir, target.relativeDir)
            val destFile = File(destDir, target.fileName)
            val engineToClose = engine
            val existingImports = importsDir.listFiles()
            val importsDir = File(modelsDir, IMPORTS_DIR)
            val initialMessages = messages.subList(0, lastUserIndex).map { msg ->
            val lastMessage = sanitizeForLiteRt(messages[lastUserIndex].content) ?: ""
            val lastUserIndex = messages.indexOfLast { it.role == "user" }
            val modalities = caps.inputModalities()
            val modelDir = File(modelsDir, catalogModel.id)
            val modelFile = File(modelDir, catalogModel.fileName)
            val modelsDir = File(getModelStorageDirectory())
            val prev = conversation
            val response = try {
            val sampler = caps.defaultSamplerParams()
            val sanitizedSystemPrompt = sanitizeForLiteRt(systemPrompt)
            val sizeForSpace = if (sourceSize > 0) sourceSize else 0L
            val sourceSize = runCatching { source.size() }.getOrDefault(-1L)
            val target = resolveImportTarget(fileName, existingImports)
            val toolProviders = tools.map { tool(LocalToolOpenApiAdapter(it)) }
            var notificationStarted = false
            var tempFile: File? = null
            while (true) {
            }
            } catch (e: CancellationException) {
            } catch (e: Exception) {
            } catch (e: Throwable) {
            } catch (e: TimeoutCancellationException) {
            } else {
            } finally {
        // A marker that records some other digest means this file has already been hashed
        // and is known not to be the pinned build; re-reading gigabytes to learn that again
        // on every attempt helps nobody.
        _importError.value = null
        _importProgress.value = 0f
        _importingFileName.value = fileName
        cachedModelCapabilities(path)
        cancelDownload()
        cancelImport()
        dest: File,
        downloadJob = null
        downloadJob = scope.launch {
        downloadJob?.cancel()
        idleReleaseJob = scope.launch {
        idleReleaseJob = scope.launch { release() }
        idleReleaseJob?.cancel()
        if (!digestMatches(catalogModel.sha256, actual)) throw ModelIntegrityException()
        if (!importsDir.isDirectory) return emptyList()
        if (!marker.isNullOrBlank()) throw ModelIntegrityException()
        if (!modelsDir.exists()) return emptyList()
        if (_downloadingModelId.value != null) {
        if (_importingFileName.value != null) return
        if (capabilitiesByPath.containsKey(modelPath)) return@withLock capabilitiesByPath[modelPath]
        if (catalogModel.sha256.isBlank()) return
        if (digestMatches(catalogModel.sha256, marker)) return
        if (marker == USER_SUPPLIED_MARKER) return
        importJob = currentCoroutineContext().job
        importJob = null
        importJob?.cancel()
        initMutex.withLock { initializeLocked(model, contextTokens) }
        markerFile.writeText(actual)
        messages: List<InferenceMessage>,
        modelFile.inputStream().use { input ->
        null
        onProgress(1f)
        onProgress: (Float) -> Unit,
        override fun execute(paramsJsonString: String): String = runBlocking { localTool.execute(paramsJsonString) }
        override fun getToolDescriptionJsonString(): String = localTool.descriptionJsonString
        println("LiteRT: could not read capabilities for $modelPath: ${it.message}")
        private const val COPY_BUFFER_SIZE_BYTES = 64L * 1024
        private const val DOWNLOAD_SPACE_BUFFER_BYTES = 500L * 1024 * 1024 // 500 MB
        private const val GPU_DRAIN_DELAY_MS = 750L
        private const val IDLE_RELEASE_MS = 5L * 60 * 1000 // 5 minutes
        private const val INFERENCE_TIMEOUT_MS = 120_000L // 2 minutes
        private const val MIN_MEMORY_HEADROOM_BYTES = 512L * 1024 * 1024 // 512 MB
        private set
        readModelCapabilities(modelPath).also { capabilitiesByPath[modelPath] = it }
        return catalog + imported
        return importsDir.listFiles()
        return scanImportedModels(modelsDir).map { it.first }
        source.withScopedAccess {
        source: PlatformFile,
        systemPrompt: String?,
        tools: List<LocalTool>,
        totalBytes: Long,
        try {
        val actual = digest.digest().toDigestHex()
        val buffer = ByteArray(COPY_BUFFER_SIZE_BYTES.toInt())
        val caps = Capabilities(modelPath)
        val catalog = MODEL_CATALOG.mapNotNull { catalogModel ->
        val catalogModel = findCatalogModelById(modelId) ?: return
        val digest = MessageDigest.getInstance("SHA-256")
        val fileName = source.name
        val imported = scanImportedModels(modelsDir).map { (local, file) ->
        val importsDir = File(modelsDir, IMPORTS_DIR)
        val marker = runCatching { markerFile.readText().trim() }.getOrNull()
        val markerFile = File(modelFile.parentFile, digestMarkerFileName(modelFile.name))
        val modelsDir = File(getModelStorageDirectory())
        val path = getDownloadedModels().find { it.id == modelId }?.filePath ?: return@withContext null
        var tempFile: File? = null
        withContext(Dispatchers.IO) {
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } finally {
     *
     * (synchronous execute). The bridge uses [runBlocking] because the engine calls
     * Adapter that exposes a Kai [LocalTool] (suspend execute) to litert-lm's [OpenApiTool]
     * Every field is best-effort: a bundle whose metadata predates the declaration, or a
     * Files the user supplied are exempt. An import whose name matches a catalog model
     * Reads what the `.litertlm` bundle at [modelPath] declares about itself. Cheap — the
     * Refuses to load a catalog model whose bytes do not match the digest pinned in
     * Reports progress when [totalBytes] is known (> 0).
     * Streams [source] into [dest] without loading the whole file into memory.
     * [MODEL_CATALOG]. Files downloaded by earlier app versions predate download-time
     * [chat]) and waits for the result before continuing the tool loop.
     * [execute] on its own worker thread (we're already inside `Dispatchers.IO` from
     * capability handle parses the file's metadata section and never loads weights — but
     * disk for the user to keep, replace, or remove from Settings.
     * it is still a native open of a multi-gigabyte file, so callers go through the cache.
     * result recorded in a marker file, making every later load a string comparison.
     * runtime that throws reading it, yields null so callers keep their own assumptions.
     * takes over that catalog slot, so it would otherwise be measured against a digest it
     * verification, so their provenance is unknown; they are hashed once here and the
     * was never meant to match. Nothing here deletes a model — a rejected file is left on
     */
    ) {
    ): String = withContext(Dispatchers.IO) {
    /**
    // Capabilities of the model chat() is about to run against. Read on the init path and
    // Capability reads keyed by model file path. A `null` value is a cached "asked, and
    // Serializes initialization. The native load is not interruptible, so a cancelled
    // held for the engine's lifetime so the send path stays non-suspend.
    // init keeps running on its IO thread; without the lock, a follow-up ask would see
    // model whose metadata predates the declaration is not re-read on every message.
    // state != READY and start a second concurrent load of a multi-GB model.
    // the bundle would not say" — distinguished from "never asked" by key presence, so a
    @Volatile
    companion object {
    override fun cancelDownload() {
    override fun cancelImport() {
    override fun getAvailableModels(): List<LocalModel> = MODEL_CATALOG
    override fun getDownloadedModels(): List<DownloadedModel> {
    override fun getFreeSpaceBytes(): Long = getAvailableDiskSpaceBytes(getModelStorageDirectory())
    override fun getImportedLocalModels(): List<LocalModel> {
    override fun releaseInBackground() {
    override fun startDownload(model: LocalModel) {
    override suspend fun chat(
    override suspend fun deleteModel(modelId: String) {
    override suspend fun importModel(source: PlatformFile): ModelImportResult = withContext(Dispatchers.IO) {
    override suspend fun initialize(model: DownloadedModel, contextTokens: Int) {
    override suspend fun modelCapabilities(modelId: String): LocalModelCapabilities? = withContext(Dispatchers.IO) {
    override suspend fun release() {
    override val downloadError: StateFlow<DownloadError?> = _downloadError
    override val downloadProgress: StateFlow<Float?> = _downloadProgress
    override val downloadingModelId: StateFlow<String?> = _downloadingModelId
    override val engineState: StateFlow<EngineState> = _engineState
    override val importError: StateFlow<ModelImportError?> = _importError
    override val importProgress: StateFlow<Float?> = _importProgress
    override val importingFileName: StateFlow<String?> = _importingFileName
    override var currentModelId: String? = null
    private class LocalToolOpenApiAdapter(private val localTool: LocalTool) : OpenApiTool {
    private fun readModelCapabilities(modelPath: String): LocalModelCapabilities? = runCatching {
    private fun scanImportedModels(modelsDir: File): List<Pair<LocalModel, File>> {
    private fun scheduleIdleRelease() {
    private suspend fun cachedModelCapabilities(modelPath: String): LocalModelCapabilities? = capabilitiesMutex.withLock {
    private suspend fun initializeLocked(model: DownloadedModel, contextTokens: Int) {
    private suspend fun streamCopyWithProgress(
    private suspend fun verifyModelIntegrity(modelId: String, modelFile: File) {
    private val _downloadError = MutableStateFlow<DownloadError?>(null)
    private val _downloadProgress = MutableStateFlow<Float?>(null)
    private val _downloadingModelId = MutableStateFlow<String?>(null)
    private val _engineState = MutableStateFlow(EngineState.UNINITIALIZED)
    private val _importError = MutableStateFlow<ModelImportError?>(null)
    private val _importProgress = MutableStateFlow<Float?>(null)
    private val _importingFileName = MutableStateFlow<String?>(null)
    private val capabilitiesByPath = mutableMapOf<String, LocalModelCapabilities?>()
    private val capabilitiesMutex = Mutex()
    private val initMutex = Mutex()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var conversation: com.google.ai.edge.litertlm.Conversation? = null
    private var currentContextTokens: Int = 0
    private var currentModelCapabilities: LocalModelCapabilities? = null
    private var downloadJob: Job? = null
    private var engine: Engine? = null
    private var idleReleaseJob: Job? = null
    private var importJob: Job? = null
    }
    }.getOrElse {
class LiteRTInferenceEngine : LocalInferenceEngine {
}
