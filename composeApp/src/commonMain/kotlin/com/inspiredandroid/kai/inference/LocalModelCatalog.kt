package com.inspiredandroid.kai.inference

        // The export tops out at 4096; asking for more fails engine creation rather than
        // being clamped. The hybrid conv blocks carry constant-size state, so only the few
        // real attention layers grow with context — hence the small per-token figure.
        append(HEX_DIGITS[value and 0x0F])
        append(HEX_DIGITS[value ushr 4])
        defaultContextTokens = 4_096,
        defaultContextTokens = 8_192,
        displayName = "Gemma 4 12B IT",
        displayName = "Gemma 4 E2B IT",
        displayName = "Gemma 4 E4B IT",
        displayName = "LFM2.5 1.2B Instruct",
        displayName = "Qwen3 0.6B",
        downloadUrl = "https://huggingface.co/litert-community/LFM2.5-1.2B-Instruct/resolve/f45d8d8abe93bff4026efee20fa483150ce8e687/LFM2.5-1.2B-Instruct_int4_gpu.litertlm",
        downloadUrl = "https://huggingface.co/litert-community/Qwen3-0.6B/resolve/dd97997951bb15a2a71f539ba17f604707c0b11a/Qwen3-0.6B.litertlm",
        downloadUrl = "https://huggingface.co/litert-community/gemma-4-12B-it-litert-lm/resolve/7a0b1ce0ea821bcd01c5f72af84155e02191152f/gemma-4-12B-it.litertlm",
        downloadUrl = "https://huggingface.co/litert-community/gemma-4-E2B-it-litert-lm/resolve/9262660a1676eed6d0c477ab1a86344430854664/gemma-4-E2B-it.litertlm",
        downloadUrl = "https://huggingface.co/litert-community/gemma-4-E4B-it-litert-lm/resolve/f7ad3343bd6ebc9607f4dc3bc4f2398bd5749bc5/gemma-4-E4B-it.litertlm",
        fileName = "LFM2.5-1.2B-Instruct_int4_gpu.litertlm",
        fileName = "Qwen3-0.6B.litertlm",
        fileName = "gemma-4-12B-it.litertlm",
        fileName = "gemma-4-E2B-it.litertlm",
        fileName = "gemma-4-E4B-it.litertlm",
        gpuMemoryMb = 300,
        gpuMemoryMb = 4000,
        gpuMemoryMb = 676,
        gpuMemoryMb = 710,
        id = "gemma-4-12b-it",
        id = "gemma-4-e2b-it",
        id = "gemma-4-e4b-it",
        id = "lfm2.5-1.2b-instruct",
        id = "qwen3-0.6b",
        isRecommended = true,
        kvPerTokenBytes = 140_000,
        kvPerTokenBytes = 20_000,
        kvPerTokenBytes = 35_000,
        kvPerTokenBytes = 50_000,
        kvPerTokenBytes = 75_000,
        maxContextTokens = 32_768,
        maxContextTokens = 4_096,
        sha256 = "0b2a8980ce155fd97673d8e820b4d29d9c7d99b8fa6806f425d969b145bd52e0",
        sha256 = "181938105e0eefd105961417e8da75903eacda102c4fce9ce90f50b97139a63c",
        sha256 = "36f7f0221bcc42c75291da1d7e3422901024a5b06b9bfa3c02d7feface04f70a",
        sha256 = "555579ff2f4fd13379abe69c1c3ab5200f7338bc92471557f1d6614a6e5ab0b4",
        sha256 = "58fd31b778ca2c21c80d634fb34fc5a89d11d563a38dfd3cbf1b40dbf252a8b6",
        sizeBytes = 2_588_147_712L,
        sizeBytes = 3_659_530_240L,
        sizeBytes = 614_236_160L,
        sizeBytes = 6_883_278_368L,
        sizeBytes = 736_220_768L,
        val value = byte.toInt() and 0xFF
    (actual != null && actual.trim().equals(expected.trim(), ignoreCase = true))
    ),
    // The `_int4_gpu` build, not the plain `_int4`: only this one lowers fully for the GPU
    // Upstream replaced this file on 2026-09-03: the current build adds vision and audio
    // bridge is still on 0.15, where this entry will refuse to load — academic at 6.9 GB,
    // delegate (the other leaves GATHER_ND and some INT64 tensors behind and then fails
    // engine creation), and it runs on CPU as well — which matters because initialize()
    // modalities and Multi-Token Prediction for speculative decoding, and its model card
    // requires litert-lm >= 0.17 to load at all. Android/desktop ship 0.17.0; the iOS
    // tool-calling chat template, so the allowlisted tools are worth handing it.
    // tries GPU first and falls back. Unlike Qwen3 0.6B this bundle carries a real
    // which no iPhone was going to hold anyway.
    LocalModel(
    for (byte in this@toDigestHex) {
    if (s == null) return null
    if (s.none { it.isSurrogate() }) return s
    return s.filter { !it.isSurrogate() }
    }
 *
 *                                                                                 .lfs.size its size
 *                                                                                 file's SHA-256,
 *   curl -s "https://huggingface.co/api/models/<repo>"                        -> .sha is the commit
 *   curl -s "https://huggingface.co/api/models/<repo>/tree/main?recursive=true" -> .lfs.oid is the
 * (never silently move a pin to `main`).
 * Download URLs are pinned to an immutable HuggingFace commit, never to `main`. A `main`
 * Drops UTF-16 surrogate halves from the string. The litert-lm JNI layer passes
 * Filtering surrogates drops every supplementary character (both halves are surrogate
 * Hand-rolled rather than using the stdlib's `toHexString`, which still needs an opt-in.
 * Lowercase hex encoding of raw digest bytes, matching the form the catalog stores.
 * Marker contents recording that the user supplied this file themselves. An import whose
 * Name of the sibling file that records the verified digest of [fileName]. Written next to
 * No-op for strings that don't contain any supplementary character.
 * Pin policy, last check, and the bump playbook live in the OKF bundle
 * The digest is also echoed as the `x-linked-etag` header on the resolve redirect, so a
 * This list is the **runtime** source of truth for pins — not a live HuggingFace fetch.
 * To bump a model, refresh the commit and the digest together:
 * True when [actual] satisfies [expected]. A blank [expected] means the model carries no
 * URL is a moving target: whoever controls the repo — or anyone who can tamper with the
 * UTF-8 byte" the moment it hits one. The Swift bridge on iOS hits the same parser.
 * UTF-8, and the native runtime's `nlohmann::json` parser crashes with "ill-formed
 * `curl -sI -L <url>` cross-checks it. [sizeBytes] must be the exact byte count — it gates
 * `docs/knowledge/litert/`. Check or bump via the `update-litert-models` skill
 * a model once its bytes have been checked, so the check is not repeated on every load.
 * and before the model is ever handed to the inference engine.
 * both the pre-download free-space check and the post-download length check.
 * characters (U+10000–U+10FFFF — most emoji like 🗺️, 🎉, 🔥) as surrogate-pair
 * code units in UTF-16) while leaving BMP characters — including BMP-only emoji like
 * digest would be applied to bytes Kai never downloaded and had no business checking.
 * name matches a catalog model takes over that catalog slot, so without this the pinned
 * pinned digest — imported models, which the user supplies directly — and is accepted.
 * sequences where each half becomes a 3-byte block. That is invalid as *standard*
 * strings to the native runtime as *modified* UTF-8, which encodes supplementary-plane
 * transfer — could swap the file, and the app would load it with no version bump and no
 * warning. Every entry also carries the file's SHA-256, which is checked after download
 * ⚔️, ♻️, ❤️, and all CJK / extended Latin / accented characters — untouched.
 */
)
/**
// Qwen3 emits <think>…</think> blocks as part of its chat template; strip them before
// the user sees them. Safe for Gemma 4, which never emits these tags.
const val USER_SUPPLIED_MARKER = "user-supplied"
fun ByteArray.toDigestHex(): String = buildString(size * 2) {
fun digestMarkerFileName(fileName: String): String = "$fileName.sha256"
fun digestMatches(expected: String, actual: String?): Boolean = expected.isBlank() ||
fun findCatalogModelById(id: String): LocalModel? = MODEL_CATALOG.find { it.id == id }
fun sanitizeForLiteRt(s: String?): String? {
fun stripThinkBlocks(s: String): String = THINK_BLOCK_REGEX.replace(s, "").trim()
private const val HEX_DIGITS = "0123456789abcdef"
private val THINK_BLOCK_REGEX = Regex("(?s)<think>.*?</think>")
val MODEL_CATALOG = listOf(
}
