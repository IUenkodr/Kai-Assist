
                                lastProgressTs = now
                                onProgress((copied.toFloat() / totalBytes).coerceIn(0f, 1f))
                            if (now - lastProgressTs > 0.2) {
                            val now = NSDate().timeIntervalSince1970
                            }
                        NSFileManager.defaultManager.removeItemAtPath(tempPath, null)
                        _downloadError.value = DownloadError.CHECKSUM_MISMATCH
                        _downloadError.value = DownloadError.DOWNLOAD_INCOMPLETE
                        copied += bytesRead
                        coroutineContext.ensureActive()
                        fileManager.removeItemAtPath("$importsDir/$name", null)
                        fwrite(pinned.addressOf(0), 1.convert(), n.convert(), fp)
                        if (bytesRead == -1L) break
                        if (hashing) CC_SHA256_Update(context.ptr, pinned.addressOf(0), n.convert())
                        if (totalBytes > 0) {
                        lastPercent = percent
                        messagesJson = messagesJson,
                        onProgress(percent)
                        onResult = { resp, err -> if (cont.isActive) cont.resume(resp to err) },
                        rawSink.write(buffer, bytesRead)
                        return@launch
                        systemPrompt = sanitizeForLiteRt(systemPrompt),
                        val bytesRead = rawSource.readAtMostTo(buffer, COPY_BUFFER_SIZE_BYTES)
                        }
                    )
                    // Catalog model with a pinned digest: the size is known exactly, so
                    // Record the verified digest before the file becomes visible under its
                    // anything short is a truncated transfer rather than a swapped file.
                    // real name, so a model is never present without its marker.
                    CC_SHA256_Update(context.ptr, pinned.addressOf(0), read.convert())
                    NSFileManager.defaultManager.removeItemAtPath(tempPath, null)
                    _downloadError.value = DownloadError.DOWNLOAD_INCOMPLETE
                    _downloadError.value = DownloadError.NOT_ENOUGH_DISK_SPACE
                    _importError.value = ModelImportError.INVALID_EXTENSION
                    bridge.chat(
                    buffer.usePinned { pinned ->
                    cacheDir = getModelCacheDirectory(),
                    expectedSha256 = model.sha256,
                    fallbackSize = model.sizeBytes,
                    fileManager.removeItemAtPath(targetPath, null)
                    fread(pinned.addressOf(0), 1.convert(), buffer.size.convert(), fp).toLong()
                    if (!digestMatches(model.sha256, outcome.sha256)) {
                    if ((CUSTOM_MODEL_ID_PREFIX + name.substringBeforeLast('.')) == modelId) {
                    if (n <= 0) break
                    if (outcome.bytesWritten != model.sizeBytes) {
                    if (percent != lastPercent) {
                    maxNumTokens = contextTokens,
                    modelPath = model.filePath,
                    onComplete = { msg -> if (cont.isActive) cont.resume(msg) },
                    onProgress = { percent -> _downloadProgress.value = percent / 100f },
                    rawSink.flush()
                    return@launch
                    return@withContext ModelImportResult.Failure(ModelImportError.INVALID_EXTENSION)
                    tempPath = tempPath,
                    throw IllegalStateException("HTTP ${response.status.value}")
                    totalBytes += n
                    url = model.downloadUrl,
                    val buffer = Buffer()
                    val n = channel.readAvailable(buffer, 0, buffer.size)
                    val percent = (totalBytes * 100 / expectedBytes).toInt().coerceIn(1, 100)
                    var copied = 0L
                    var lastProgressTs = 0.0
                    while (true) {
                    writeDigestMarker("$modelDir/${digestMarkerFileName(model.fileName)}", model.sha256)
                    }
                )
                .orEmpty()
                // This import takes over a catalog slot. Record that the bytes are the
                // pinned digest.
                // user's own so the load-time check does not hold them to that entry's
                ?.mapNotNull { it as? String }
                ?.toSet()
                ?: run {
                NSFileManager.defaultManager.removeItemAtPath(tempPath, null)
                _downloadError.value = DownloadError.NETWORK_ERROR
                _downloadProgress.value = null
                _downloadingModelId.value = null
                _importError.value = ModelImportError.COPY_FAILED
                _importError.value = ModelImportError.FILE_TOO_SMALL
                _importError.value = ModelImportError.INVALID_EXTENSION
                _importError.value = ModelImportError.NOT_ENOUGH_DISK_SPACE
                _importProgress.value = progress
                bridge.initializeEngine(
                buffer.usePinned { pinned ->
                contents?.mapNotNull { it as? String }?.forEach { name ->
                coroutineContext.ensureActive()
                dest.sink().use { rawSink ->
                displayName = catalogModel.displayName,
                displayName = scanned.model.displayName,
                expectedBytes = response.contentLength()?.takeIf { it > 0 } ?: fallbackSize
                fileManager.moveItemAtPath(tempPath, targetPath, null)
                fileManager.removeItemAtPath("$modelsDir/$modelId", null)
                fileManager.removeItemAtPath(destPath, null)
                fileManager.removeItemAtPath(tmp, null)
                filePath = modelPath,
                filePath = scanned.path,
                id = catalogModel.id,
                id = scanned.model.id,
                if (!response.status.isSuccess()) {
                if (fileManager.fileExistsAtPath(targetPath)) {
                if (getFreeSpaceBytes() < model.sizeBytes + DOWNLOAD_SPACE_BUFFER_BYTES) {
                if (outcome.sha256 != null) {
                if (read <= 0L) break
                importJob = null
                model = customLocalModel(name, size, modelId).copy(isImported = true),
                path = path,
                release()
                return@mapNotNull null
                return@withContext ModelImportResult.Failure(ModelImportError.COPY_FAILED, "Incomplete copy")
                return@withContext ModelImportResult.Failure(ModelImportError.FILE_TOO_SMALL)
                return@withContext ModelImportResult.Failure(ModelImportError.INVALID_EXTENSION)
                return@withContext ModelImportResult.Failure(ModelImportError.NOT_ENOUGH_DISK_SPACE)
                sizeBytes = scanned.sizeBytes,
                sizeBytes = size,
                suspendCancellableCoroutine<Pair<String?, String?>> { cont ->
                throw e
                val buffer = ByteArray(HASH_BUFFER_SIZE_BYTES)
                val channel = response.bodyAsChannel()
                val contents = fileManager.contentsOfDirectoryAtPath(importsDir, null) as? List<*>
                val fileManager = NSFileManager.defaultManager
                val importsDir = "$modelsDir/$IMPORTS_DIR"
                val outcome = downloadToFile(
                val read = buffer.usePinned { pinned ->
                var lastPercent = -1
                while (!channel.isClosedForRead) {
                writeDigestMarker("$destDir/${digestMarkerFileName(target.fileName)}", USER_SUPPLIED_MARKER)
                }
                } else if (outcome.bytesWritten < outcome.expectedBytes * 0.95) {
            )
            // Hash as the bytes stream past, so verification costs no extra read of a
            // Release any existing engine before loading the next one. The Swift actor holds
            // User stop, not an engine failure — the old engine was already released
            // above, so UNINITIALIZED reflects reality and the next ask re-inits cleanly.
            // file that can be several GB.
            // the native handle until its retain count drops; give Metal a beat to reclaim.
            CC_SHA256_Init(context.ptr)
            DownloadedModel(
            ImportedScan(
            ModelImportResult.Failure(ModelImportError.COPY_FAILED, e.message)
            ModelImportResult.Success(modelId = target.modelId, matchedCatalog = target.matchedCatalog)
            NSFileManager.defaultManager.createDirectoryAtPath(modelDir, true, null, null)
            _downloadError.value = null
            _downloadProgress.value = 0f
            _downloadingModelId.value = model.id
            _engineState.value = EngineState.ERROR
            _engineState.value = EngineState.READY
            _engineState.value = EngineState.UNINITIALIZED
            _importError.value = ModelImportError.CANCELLED
            _importError.value = ModelImportError.COPY_FAILED
            _importProgress.value = 1f
            _importProgress.value = null
            _importingFileName.value = null
            bridge.releaseEngine()
            client.prepareGet(url).execute { response ->
            currentContextTokens = contextTokens
            currentModelId = model.id
            delay(GPU_DRAIN_DELAY_MS.milliseconds)
            delay(IDLE_RELEASE_MS.milliseconds)
            fileManager.createDirectoryAtPath(destDir, true, null, null)
            fileManager.moveItemAtPath(tmp, destPath, null)
            finalizeSha256(context)
            fwrite(pinned.addressOf(0), 1.convert(), bytes.size.convert(), fp)
            idleReleaseJob = null
            idleReleaseJob?.cancelAndJoin()
            if (!fileManager.fileExistsAtPath(path)) return@mapNotNull null
            if (!isLitertlmExtension(fileName)) {
            if (!isLitertlmExtension(name) || name.endsWith(".tmp") || name.endsWith(".importing")) {
            if (copiedSize < MIN_MODEL_FILE_BYTES) {
            if (currentModelId == modelId) {
            if (errorMessage != null) throw IllegalStateException(errorMessage)
            if (fileManager.fileExistsAtPath(destPath)) {
            if (fileManager.fileExistsAtPath(tmp)) {
            if (getFreeSpaceBytes() < sizeForSpace + DOWNLOAD_SPACE_BUFFER_BYTES) {
            if (hashing) CC_SHA256_Init(context.ptr)
            if (hashing) digestHex = finalizeSha256(context)
            if (importJob === currentCoroutineContext().job) {
            if (isCustomModelId(modelId)) {
            if (sourceSize > 0 && copiedSize < sourceSize * 0.95) {
            if (sourceSize in 0 until MIN_MODEL_FILE_BYTES) {
            if (target.matchedCatalog) {
            mapOf("role" to it.role, "content" to (sanitizeForLiteRt(it.content) ?: ""))
            release()
            return stripThinkBlocks(response ?: "")
            return@withContext ModelImportResult.Failure(ModelImportError.COPY_FAILED, "Download in progress")
            scheduleIdleRelease()
            source.source().use { rawSource ->
            streamCopyWithProgress(source, tmp, sourceSize) { progress ->
            tempPath = null
            tempPath = tmp
            tempPath?.let { fileManager.removeItemAtPath(it, null) }
            throw InferenceTimeoutException()
            throw e
            try {
            val (response, errorMessage) = withTimeout(INFERENCE_TIMEOUT_MS.milliseconds) {
            val attrs = fileManager.attributesOfItemAtPath(modelPath, null) ?: return@mapNotNull null
            val attrs = fileManager.attributesOfItemAtPath(path, null)
            val attrs = fileManager.attributesOfItemAtPath(tmp, null)
            val buffer = ByteArray(HASH_BUFFER_SIZE_BYTES)
            val context = alloc<CC_SHA256_CTX>()
            val copiedSize = (attrs?.get(NSFileSize) as? NSNumber)?.longLongValue ?: 0L
            val destDir = "$modelsDir/${target.relativeDir}"
            val destPath = "$destDir/${target.fileName}"
            val errorMessage = suspendCancellableCoroutine<String?> { cont ->
            val existing = (fileManager.contentsOfDirectoryAtPath(importsDir, null) as? List<*>)
            val fileManager = NSFileManager.defaultManager
            val hashing = expectedSha256.isNotBlank()
            val importsDir = "$modelsDir/$IMPORTS_DIR"
            val modelDir = "${getModelStorageDirectory()}/${model.id}"
            val modelId = CUSTOM_MODEL_ID_PREFIX + name.substringBeforeLast('.')
            val modelPath = "$modelsDir/${catalogModel.id}/${catalogModel.fileName}"
            val modelsDir = getModelStorageDirectory()
            val name = nameObj as? String ?: return@mapNotNull null
            val path = "$importsDir/$name"
            val size = (attrs?.get(NSFileSize) as? NSNumber)?.longLongValue ?: 0L
            val size = (attrs[NSFileSize] as? NSNumber)?.longLongValue ?: catalogModel.sizeBytes
            val sizeForSpace = if (sourceSize > 0) sourceSize else 0L
            val sourceSize = runCatching { source.size() }.getOrDefault(-1L)
            val target = resolveImportTarget(fileName, existing)
            val targetPath = "$modelDir/${model.fileName}"
            val tempPath = "$modelDir/${model.fileName}.tmp"
            val tmp = "$destDir/${target.fileName}.importing"
            verifyModelIntegrity(model.id, model.filePath)
            while (true) {
            }
            } catch (e: CancellationException) {
            } catch (e: Throwable) {
            } else {
            } finally {
        // A marker that records some other digest means this file has already been hashed
        // and is known not to be the pinned build; re-reading gigabytes to learn that again
        // on every attempt helps nobody.
        ?: throw IllegalStateException("LiteRTSwiftBridge not installed. iosApp must call KaiLiteRTBridgeInstaller.install().")
        _engineState.value = EngineState.INITIALIZING
        _engineState.value = EngineState.UNINITIALIZED
        _importError.value = null
        _importProgress.value = 0f
        _importingFileName.value = fileName
        bridge.releaseEngine()
        bytes.usePinned { pinned ->
        cancelDownload()
        cancelImport()
        client.close()
        currentModelId = null
        destPath: String,
        downloadJob = null
        downloadJob = scope.launch {
        downloadJob?.cancel()
        fclose(fp)
        fileManager.removeItemAtPath(tempPath, null)
        idleReleaseJob = scope.launch {
        idleReleaseJob = scope.launch { release() }
        idleReleaseJob?.cancel()
        if (!bridge.isEngineReady()) throw IllegalStateException("Engine not initialized")
        if (!digestMatches(catalogModel.sha256, actual)) throw ModelIntegrityException()
        if (!marker.isNullOrBlank()) throw ModelIntegrityException()
        if (_downloadingModelId.value != null) {
        if (_importingFileName.value != null) return
        if (actual != null) writeDigestMarker(markerPath, actual)
        if (catalogModel.sha256.isBlank()) return
        if (currentModelId == model.id && currentContextTokens == contextTokens && _engineState.value == EngineState.READY) return
        if (digestMatches(catalogModel.sha256, marker)) return
        if (marker == USER_SUPPLIED_MARKER) return
        importJob = currentCoroutineContext().job
        importJob = null
        importJob?.cancel()
        initMutex.withLock { initializeLocked(model, contextTokens) }
        memScoped {
        memcpy(pinned.addressOf(0), data.bytes, data.length)
        messages: List<InferenceMessage>,
        onProgress(1f)
        onProgress: (Float) -> Unit,
        private const val COPY_BUFFER_SIZE_BYTES = 64L * 1024
        private const val DOWNLOAD_SPACE_BUFFER_BYTES = 500L * 1024 * 1024
        private const val GPU_DRAIN_DELAY_MS = 750L
        private const val IDLE_RELEASE_MS = 5L * 60 * 1000
        private const val INFERENCE_TIMEOUT_MS = 120_000L
        private set
        return catalog + imported
        return contents.mapNotNull { nameObj ->
        return memScoped {
        source.withScopedAccess {
        source: PlatformFile,
        systemPrompt: String?,
        tools: List<LocalTool>,
        totalBytes: Long,
        try {
        val actual = sha256OfFile(filePath)
        val bridge = LiteRTBridgeRegistry.bridge ?: return
        val bridge = requireBridge()
        val bytes = digest.encodeToByteArray()
        val catalog = MODEL_CATALOG.mapNotNull { catalogModel ->
        val catalogModel = findCatalogModelById(modelId) ?: return
        val contents = fileManager.contentsOfDirectoryAtPath(importsDir, null) as? List<*> ?: return emptyList()
        val dest = PlatformFile(destPath)
        val fileManager = NSFileManager.defaultManager
        val fileName = source.name
        val imported = scanImportedModels().map { scanned ->
        val importsDir = "${getModelStorageDirectory()}/$IMPORTS_DIR"
        val marker = readDigestMarker(markerPath)?.trim()
        val markerPath = "${filePath.substringBeforeLast('/')}/${digestMarkerFileName(filePath.substringAfterLast('/'))}"
        val messagesJson = Json.encodeToString(sanitizedMessages)
        val modelsDir = getModelStorageDirectory()
        val sanitizedMessages = messages.map {
        var tempPath: String? = null
        withContext(Dispatchers.Default) {
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } catch (e: Throwable) {
        } catch (e: TimeoutCancellationException) {
        } finally {
        }.sortedBy { it.model.fileName.lowercase() }
     *
     * Files the user supplied are exempt. An import whose name matches a catalog model
     * Refuses to load a catalog model whose bytes do not match the digest pinned in
     * [MODEL_CATALOG]. Files downloaded by earlier app versions predate download-time
     * disk for the user to keep, replace, or remove from Settings.
     * result recorded in a marker file, making every later load a string comparison.
     * takes over that catalog slot, so it would otherwise be measured against a digest it
     * verification, so their provenance is unknown; they are hashed once here and the
     * was never meant to match. Nothing here deletes a model — a rejected file is left on
     */
    ) {
    ): String {
    /**
    /** Lowercase hex SHA-256 of the written bytes, or null when no digest was requested. */
    // Serializes initialization. The Swift-side load is not interruptible, so a cancelled
    // init keeps running; without the lock, a follow-up ask would see state != READY and
    // start a second concurrent load.
    CC_SHA256_Final(digest, context.ptr)
    bytes.usePinned { pinned ->
    companion object {
    expectedSha256: String,
    fallbackSize: Long,
    if (fileManager.fileExistsAtPath(tempPath)) {
    if (size == 0) return null
    onProgress: (Int) -> Unit,
    override fun cancelDownload() {
    override fun cancelImport() {
    override fun getAvailableModels(): List<LocalModel> = MODEL_CATALOG
    override fun getDownloadedModels(): List<DownloadedModel> {
    override fun getFreeSpaceBytes(): Long = getAvailableDiskSpaceBytes(getModelStorageDirectory())
    override fun getImportedLocalModels(): List<LocalModel> = scanImportedModels().map { it.model }
    override fun releaseInBackground() {
    override fun startDownload(model: LocalModel) {
    override suspend fun chat(
    override suspend fun deleteModel(modelId: String) {
    override suspend fun importModel(source: PlatformFile): ModelImportResult = withContext(Dispatchers.Default) {
    override suspend fun initialize(model: DownloadedModel, contextTokens: Int) {
    override suspend fun release() {
    override val downloadError: StateFlow<DownloadError?> = _downloadError
    override val downloadProgress: StateFlow<Float?> = _downloadProgress
    override val downloadingModelId: StateFlow<String?> = _downloadingModelId
    override val engineState: StateFlow<EngineState> = _engineState
    override val importError: StateFlow<ModelImportError?> = _importError
    override val importProgress: StateFlow<Float?> = _importProgress
    override val importingFileName: StateFlow<String?> = _importingFileName
    override var currentModelId: String? = null
    private data class ImportedScan(val model: LocalModel, val path: String, val sizeBytes: Long)
    private fun requireBridge(): LiteRTSwiftBridge = LiteRTBridgeRegistry.bridge
    private fun scanImportedModels(): List<ImportedScan> {
    private fun scheduleIdleRelease() {
    private suspend fun initializeLocked(model: DownloadedModel, contextTokens: Int) {
    private suspend fun streamCopyWithProgress(
    private suspend fun verifyModelIntegrity(modelId: String, filePath: String) {
    private val _downloadError = MutableStateFlow<DownloadError?>(null)
    private val _downloadProgress = MutableStateFlow<Float?>(null)
    private val _downloadingModelId = MutableStateFlow<String?>(null)
    private val _engineState = MutableStateFlow(EngineState.UNINITIALIZED)
    private val _importError = MutableStateFlow<ModelImportError?>(null)
    private val _importProgress = MutableStateFlow<Float?>(null)
    private val _importingFileName = MutableStateFlow<String?>(null)
    private val initMutex = Mutex()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var currentContextTokens: Int = 0
    private var downloadJob: Job? = null
    private var idleReleaseJob: Job? = null
    private var importJob: Job? = null
    return ByteArray(CC_SHA256_DIGEST_LENGTH) { digest[it].toByte() }.toDigestHex()
    return DownloadOutcome(totalBytes, expectedBytes, digestHex)
    return bytes.decodeToString()
    tempPath: String,
    try {
    url: String,
    val bytes = ByteArray(size)
    val bytesWritten: Long,
    val client = httpClient()
    val data = NSData.dataWithContentsOfFile(path) ?: return null
    val digest = allocArray<UByteVar>(CC_SHA256_DIGEST_LENGTH)
    val expectedBytes: Long,
    val fileManager = NSFileManager.defaultManager
    val fp = fopen(path, "rb") ?: return null
    val fp = fopen(path, "wb") ?: return
    val fp = fopen(tempPath, "wb") ?: throw IllegalStateException("Cannot open $tempPath for writing")
    val sha256: String?,
    val size = data.length.toInt()
    var digestHex: String? = null
    var expectedBytes = fallbackSize
    var totalBytes = 0L
    }
    } finally {
)
): DownloadOutcome {
/** Streams an on-disk file through SHA-256. Null when the file cannot be opened. */
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class, kotlinx.cinterop.BetaInteropApi::class)
class IosLiteRTInferenceEngine : LocalInferenceEngine {
import com.inspiredandroid.kai.httpClient
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.name
import io.github.vinceglb.filekit.sink
import io.github.vinceglb.filekit.size
import io.github.vinceglb.filekit.source
import io.github.vinceglb.filekit.withScopedAccess
import io.ktor.client.request.prepareGet
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.contentLength
import io.ktor.http.isSuccess
import io.ktor.utils.io.readAvailable
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.resume
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.UByteVar
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.convert
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.usePinned
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
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.io.Buffer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import platform.CoreCrypto.CC_SHA256_CTX
import platform.CoreCrypto.CC_SHA256_DIGEST_LENGTH
import platform.CoreCrypto.CC_SHA256_Final
import platform.CoreCrypto.CC_SHA256_Init
import platform.CoreCrypto.CC_SHA256_Update
import platform.Foundation.NSData
import platform.Foundation.NSDate
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileSize
import platform.Foundation.NSNumber
import platform.Foundation.dataWithContentsOfFile
import platform.Foundation.timeIntervalSince1970
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fread
import platform.posix.fwrite
import platform.posix.memcpy
package com.inspiredandroid.kai.inference
private class DownloadOutcome(
private const val HASH_BUFFER_SIZE_BYTES = 64 * 1024
private fun MemScope.finalizeSha256(context: CC_SHA256_CTX): String {
private fun readDigestMarker(path: String): String? {
private fun writeDigestMarker(path: String, digest: String) {
private suspend fun downloadToFile(
private suspend fun sha256OfFile(path: String): String? {
}
