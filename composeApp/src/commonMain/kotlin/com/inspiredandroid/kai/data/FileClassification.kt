
        if (mimeType == "application/pdf") return FileCategory.PDF
        if (mimeType.startsWith("image/")) return FileCategory.IMAGE
        if (mimeType.startsWith("text/") || mimeType in textMimeTypes) return FileCategory.TEXT
    "application/graphql",
    "application/javascript",
    "application/json",
    "application/sql",
    "application/toml",
    "application/x-sh",
    "application/x-yaml",
    "application/xml",
    "application/yaml",
    "bmp",
    "gif",
    "gradle", "tsx", "jsx", "gsc",
    "html", "css", "js", "ts", "kt", "kts", "java",
    "jpeg",
    "jpg",
    "png",
    "py", "rb", "rs", "go", "c", "h", "cpp", "hpp",
    "svg",
    "swift", "sh", "bash", "zsh", "sql", "graphql",
    "toml", "ini", "cfg", "conf", "log", "properties",
    "txt", "md", "json", "csv", "xml", "yaml", "yml",
    "webp",
    // Fall back to extension
    // If mimeType is null and no recognized extension, unsupported
    IMAGE,
    PDF,
    TEXT,
    UNSUPPORTED,
    if (ext != null && ext in imageExtensions) return FileCategory.IMAGE
    if (ext != null && ext in textExtensions) return FileCategory.TEXT
    if (ext == "pdf") return FileCategory.PDF
    if (mimeType != null) {
    if (mimeType == null) return FileCategory.UNSUPPORTED
    return FileCategory.UNSUPPORTED
    val ext = fileName?.substringAfterLast('.', "")?.lowercase()
    }
)
// Raw image input cap before compression — images typically shrink after compression,
// from reading a multi-gigabyte file into memory.
// so we allow larger raw files than MAX_IMAGE_BYTES while still preventing an OOM
const val MAX_IMAGE_BYTES = 15_000_000
const val MAX_PDF_BYTES = 20_000_000
const val MAX_RAW_IMAGE_BYTES = 50_000_000
const val MAX_TEXT_FILE_BYTES = 200_000
enum class FileCategory {
fun classifyFile(mimeType: String?, fileName: String?): FileCategory {
internal val imageExtensions = setOf(
package com.inspiredandroid.kai.data
private val textExtensions = setOf(
private val textMimeTypes = setOf(
val supportedFileExtensions = (imageExtensions + textExtensions).toList()
}
