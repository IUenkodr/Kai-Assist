import kotlin.time.Instant

        "\n[... ${length - 2 * keep} characters truncated ...]\n" +
        takeLast(keep)
    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
    bytes >= 1_000 -> "${bytes / 1_000} KB"
    bytes >= 1_000_000 -> "${bytes / 1_000_000} MB"
    bytes >= 1_000_000_000 -> "${(bytes / 100_000_000).toDouble() / 10} GB"
    else -> "$bytes B"
    else -> "$tokens"
    if (firstDash < 1) return iso
    if (length <= maxLength) return this
    if (month !in 1..12) return iso
    return "${shortMonthNames[month - 1]} $year"
    return take(keep) +
    tokens >= 1_000 -> "${tokens / 1_000}K"
    tokens >= 1_000_000 -> "${tokens / 1_000_000}M"
    val firstDash = iso.indexOf('-')
    val keep = (maxLength - 80) / 2
    val month = monthStr.toIntOrNull() ?: return iso
    val monthStr = if (secondDash > 0) iso.substring(firstDash + 1, secondDash) else iso.substring(firstDash + 1)
    val secondDash = iso.indexOf('-', firstDash + 1)
    val year = iso.substring(0, firstDash).toIntOrNull() ?: return iso
 * Convert a Unix epoch-seconds timestamp to an ISO-8601 date string (YYYY-MM-DD),
 * or null for zero/negative values. Some providers return `0` instead of omitting
 * the `created` field, which would otherwise surface as "Jan 1970".
 */
)
/**
fun Long.toIsoDate(): String? = if (this <= 0L) null else Instant.fromEpochSeconds(this).toString().take(10)
fun String.smartTruncate(maxLength: Int): String {
fun formatContextWindow(tokens: Long): String = when {
fun formatFileSize(bytes: Long): String = when {
fun formatReleaseDate(iso: String): String {
package com.inspiredandroid.kai
private val shortMonthNames = listOf(
}
