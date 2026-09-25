
                    c.isLetterOrDigit() || c == '.' || c == '_' || c == '-' -> c
                    else -> '_'
                when {
                },
            )
            append(
            displayName = catalog.displayName,
            fileName = catalog.fileName,
            matchedCatalog = true,
            modelId = catalog.id,
            relativeDir = catalog.id,
        !sanitized.contains('.') -> "$sanitized.litertlm"
        )
        candidate = "${baseNoExt}_$counter.$ext"
        counter++
        defaultContextTokens = CUSTOM_DEFAULT_CONTEXT_TOKENS,
        displayName = fileName.substringBeforeLast('.').ifEmpty { fileName },
        displayName = idBase,
        downloadUrl = "",
        else -> sanitized
        fileName = "$fileName.litertlm"
        fileName = candidate,
        fileName = fileName,
        for (c in base) {
        gpuMemoryMb = maxOf(300, sizeMb / 4),
        id = modelId,
        isRecommended = false,
        kvPerTokenBytes = CUSTOM_KV_PER_TOKEN_BYTES,
        matchedCatalog = false,
        maxContextTokens = CUSTOM_MAX_CONTEXT_TOKENS,
        modelId = CUSTOM_MODEL_ID_PREFIX + idBase,
        relativeDir = IMPORTS_DIR,
        return ImportTarget(
        sanitized.isEmpty() -> "model.litertlm"
        sizeBytes = sizeBytes,
        }
    )
    CANCELLED,
    COPY_FAILED,
    FILE_TOO_SMALL,
    INVALID_EXTENSION,
    NOT_ENOUGH_DISK_SPACE,
    data class Failure(val error: ModelImportError, val message: String? = null) : ModelImportResult()
    data class Success(val modelId: String, val matchedCatalog: Boolean) : ModelImportResult()
    existingImportFileNames: Set<String> = emptySet(),
    if (!isLitertlmExtension(fileName)) {
    if (!isLitertlmExtension(sourceFileName)) return null
    if (base.isEmpty() || base == "." || base == "..") return "model.litertlm"
    if (catalog != null) {
    return ImportTarget(
    return LocalModel(
    return when {
    sourceFileName: String,
    val base = raw.substringAfterLast('/').substringAfterLast('\\').trim()
    val baseNoExt = fileName.substringBeforeLast('.')
    val catalog = findCatalogModelByFileName(sourceFileName)
    val displayName: String,
    val existingLower = existingImportFileNames.map { it.lowercase() }.toSet()
    val ext = fileName.substringAfterLast('.', "litertlm")
    val fileName: String,
    val idBase = candidate.substringBeforeLast('.')
    val matchedCatalog: Boolean,
    val modelId: String,
    val relativeDir: String,
    val sanitized = buildString(base.length) {
    val sizeMb = (sizeBytes / (1024 * 1024)).toInt().coerceAtLeast(1)
    var candidate = fileName
    var counter = 2
    var fileName = sanitizeImportFileName(sourceFileName)
    while (candidate.lowercase() in existingLower) {
    }
    }.trim('_', '.')
 *
 * (used only for collision avoidance of custom imports).
 * @param displayName human-readable label for the settings UI
 * @param fileName final file name inside [relativeDir]
 * @param matchedCatalog true when [fileName] matched a [MODEL_CATALOG] entry
 * @param modelId stable id used for selection / context tokens / delete
 * @param relativeDir directory under the model storage root (catalog id, or [IMPORTS_DIR])
 * Collapses path separators and rejects empty / traversal-only results.
 * Keeps alphanumerics, dots, underscores, and hyphens; replaces other chars with `_`.
 * Resolves the destination for [sourceFileName] given files already present under imports.
 * Sanitizes a file name for safe storage under the imports directory.
 * Synthetic [LocalModel] for an imported custom file so the settings UI can show
 * Where an imported file should land on disk and which model id it maps to.
 * [existingImportFileNames] should be the basenames currently in the imports directory
 * a context slider and performance estimate without a catalog entry.
 */
)
): ImportTarget? {
/**
/** Prefix for synthetic ids of models not in [MODEL_CATALOG]. */
/** Subdirectory under the model storage root for user-imported `.litertlm` files. */
const val CUSTOM_DEFAULT_CONTEXT_TOKENS = 4_096
const val CUSTOM_KV_PER_TOKEN_BYTES = 50_000
const val CUSTOM_MAX_CONTEXT_TOKENS = 32_768
const val CUSTOM_MODEL_ID_PREFIX = "custom-"
const val IMPORTS_DIR = "imports"
const val MIN_MODEL_FILE_BYTES = 1_000_000L
data class ImportTarget(
enum class ModelImportError {
fun customLocalModel(fileName: String, sizeBytes: Long, modelId: String = CUSTOM_MODEL_ID_PREFIX + fileName.substringBeforeLast('.')): LocalModel {
fun findCatalogModelByFileName(fileName: String): LocalModel? = MODEL_CATALOG.find { it.fileName.equals(fileName, ignoreCase = true) }
fun isCustomModelId(modelId: String): Boolean = modelId.startsWith(CUSTOM_MODEL_ID_PREFIX)
fun isLitertlmExtension(fileName: String): Boolean = fileName.substringAfterLast('.', missingDelimiterValue = "").equals("litertlm", ignoreCase = true)
fun resolveImportTarget(
fun sanitizeImportFileName(raw: String): String {
package com.inspiredandroid.kai.inference
sealed class ModelImportResult {
}
