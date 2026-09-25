import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

        // 100 char long
        // 1700000000 = 2023-11-14T22:13:20Z
        // Providers that return 0 instead of omitting `created` must not
        // expected length = 5 + "\n[... 90 characters truncated ...]\n".length + 5 = 5 + 36 + 5 = 46
        // keep = (90 - 80) / 2 = 5
        // maxLength = 90
        // surface as "Jan 1970".
        assertEquals("0 B", formatFileSize(0))
        assertEquals("1 KB", formatFileSize(1000))
        assertEquals("1 MB", formatFileSize(1_000_000))
        assertEquals("1.0 GB", formatFileSize(1_000_000_000))
        assertEquals("1.5 GB", formatFileSize(1_500_000_000))
        assertEquals("128K", formatContextWindow(128_000))
        assertEquals("1M", formatContextWindow(1_000_000))
        assertEquals("200K", formatContextWindow(200_000))
        assertEquals("2023-11-14", 1_700_000_000L.toIsoDate())
        assertEquals("2025-13", formatReleaseDate("2025-13"))
        assertEquals("2M", formatContextWindow(2_000_000))
        assertEquals("512", formatContextWindow(512))
        assertEquals("999 B", formatFileSize(999))
        assertEquals("999 KB", formatFileSize(999_999))
        assertEquals("999 MB", formatFileSize(999_999_999))
        assertEquals("A".repeat(5) + "\n[... 90 characters truncated ...]\n" + "B".repeat(5), truncated)
        assertEquals("Mar 2025", formatReleaseDate("2025-03"))
        assertEquals("Sep 2025", formatReleaseDate("2025-09-29"))
        assertEquals("Short", "Short".smartTruncate(10))
        assertEquals("not-a-date", formatReleaseDate("not-a-date"))
        assertNull((-1L).toIsoDate())
        assertNull(0L.toIsoDate())
        val longString = "A".repeat(50) + "B".repeat(50)
        val truncated = longString.smartTruncate(90)
    @Test
    fun `formatContextWindow renders millions`() {
    fun `formatContextWindow renders small counts verbatim`() {
    fun `formatContextWindow renders thousands`() {
    fun `formatFileSize handles bytes correctly`() {
    fun `formatFileSize handles gigabytes correctly`() {
    fun `formatFileSize handles kilobytes correctly`() {
    fun `formatFileSize handles megabytes correctly`() {
    fun `formatReleaseDate accepts full iso date`() {
    fun `formatReleaseDate accepts year-month`() {
    fun `formatReleaseDate falls back on invalid input`() {
    fun `smartTruncate does not truncate short strings`() {
    fun `smartTruncate truncates long strings with ellipsis`() {
    fun `toIsoDate converts epoch seconds to iso date`() {
    fun `toIsoDate returns null for zero or negative epoch`() {
    }
class ExtensionFunctionsTest {
package com.inspiredandroid.kai
}
