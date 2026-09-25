package com.inspiredandroid.kai.data
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

        // "* * * * *" should match every minute
        // 0, 15, 30, 45 of every hour
        // 14:30 daily
        // 2026-01-01 is Thursday → next Sunday is 2026-01-04
        // 2026-01-03 is Saturday → next is Mon 2026-01-05 9:00
        // 2026-01-04 is Sunday → next is Mon 2026-01-05 9:00
        // 2028 is a leap year
        // 7:00 every Monday (cron 1 = Monday)
        // 9-17 hours, daily 0:00
        // After 9am → 9am next day
        // Before 9am same day → 9am same day
        // Daily midnight
        // Every 5 minutes
        // Exactly at 9am → next day's 9am (strictly after)
        // Feb 30 doesn't exist; the parser accepts day 30 but it can never match in February.
        // From 10:01 → 10:30
        // From 10:30 → 11:00
        // From 17:30, next is 9:00 next day
        // From 23:59 → 00:00 next day
        // From 8:30, next is 9:00
        // From Jan 1 → Jan 15
        // From Jan 16 → Feb 15
        // From Jan 2027 → Feb 29 2028
        // From Sunday 2026-01-04 noon → Monday 2026-01-05 7:00
        // From mid-year → next Jan 1
        // Midnight Jan 1 — annual
        // Midnight every Sunday (cron 0 = Sunday)
        // Midnight on 15th of every month
        // Multiple spaces between fields are fine
        // Next minute is 12:01
        // Restricting to month=2 day=30 means no match in any year → null after exhausting search.
        // Top of 9am Mon-Fri (cron 1-5)
        // Top of every hour
        assertEquals(instant(2026, 1, 1, 10, 30), cron.nextAfter(instant(2026, 1, 1, 10, 1), utc))
        assertEquals(instant(2026, 1, 1, 11, 0), cron.nextAfter(instant(2026, 1, 1, 10, 30), utc))
        assertEquals(instant(2026, 1, 1, 12, 0), cron.nextAfter(instant(2026, 1, 1, 11, 0), utc))
        assertEquals(instant(2026, 1, 1, 12, 1), next)
        assertEquals(instant(2026, 1, 1, 12, 15), cron.nextAfter(instant(2026, 1, 1, 12, 7), utc))
        assertEquals(instant(2026, 1, 1, 12, 45), cron.nextAfter(instant(2026, 1, 1, 12, 31), utc))
        assertEquals(instant(2026, 1, 1, 12, 5), next)
        assertEquals(instant(2026, 1, 1, 13, 0), cron.nextAfter(instant(2026, 1, 1, 12, 46), utc))
        assertEquals(instant(2026, 1, 1, 14, 30), cron.nextAfter(instant(2026, 1, 1, 0, 0), utc))
        assertEquals(instant(2026, 1, 1, 9, 0), cron.nextAfter(instant(2026, 1, 1, 8, 0), utc))
        assertEquals(instant(2026, 1, 1, 9, 0), cron.nextAfter(instant(2026, 1, 1, 8, 30), utc))
        assertEquals(instant(2026, 1, 15, 0, 0), cron.nextAfter(instant(2026, 1, 1, 0, 0), utc))
        assertEquals(instant(2026, 1, 2, 0, 0), cron.nextAfter(instant(2026, 1, 1, 23, 59), utc))
        assertEquals(instant(2026, 1, 2, 9, 0), cron.nextAfter(instant(2026, 1, 1, 17, 30), utc))
        assertEquals(instant(2026, 1, 4, 0, 0), cron.nextAfter(instant(2026, 1, 1, 0, 0), utc))
        assertEquals(instant(2026, 1, 5, 7, 0), cron.nextAfter(instant(2026, 1, 4, 12, 0), utc))
        assertEquals(instant(2026, 1, 5, 9, 0), cron.nextAfter(instant(2026, 1, 3, 0, 0), utc))
        assertEquals(instant(2026, 1, 5, 9, 0), cron.nextAfter(instant(2026, 1, 4, 12, 0), utc))
        assertEquals(instant(2026, 2, 1, 0, 0), cron.nextAfter(instant(2026, 1, 31, 23, 30), utc))
        assertEquals(instant(2026, 2, 15, 0, 0), cron.nextAfter(instant(2026, 1, 16, 0, 0), utc))
        assertEquals(instant(2026, 3, 15, 9, 0), cron.nextAfter(instant(2026, 3, 15, 8, 30), utc))
        assertEquals(instant(2026, 3, 16, 9, 0), cron.nextAfter(instant(2026, 3, 15, 10, 0), utc))
        assertEquals(instant(2026, 3, 16, 9, 0), cron.nextAfter(instant(2026, 3, 15, 9, 0), utc))
        assertEquals(instant(2027, 1, 1, 0, 0), cron.nextAfter(instant(2026, 12, 31, 23, 0), utc))
        assertEquals(instant(2027, 1, 1, 0, 0), cron.nextAfter(instant(2026, 7, 15, 12, 0), utc))
        assertEquals(instant(2028, 2, 29, 0, 0), cron.nextAfter(instant(2027, 1, 1, 0, 0), utc))
        assertFailsWith<IllegalArgumentException> { CronExpression("") }
        assertFailsWith<IllegalArgumentException> { CronExpression("* * * * * *") }
        assertFailsWith<IllegalArgumentException> { CronExpression("* * *") }
        assertFailsWith<IllegalArgumentException> { CronExpression("*/abc * * * *") }
        assertFailsWith<IllegalArgumentException> { CronExpression("foo * * * *") }
        assertNotNull(next)
        assertNull(cron.nextAfter(instant(2026, 1, 1, 0, 0), utc))
        return Instant.fromEpochMilliseconds(kxInstant.toEpochMilliseconds())
        val cron = CronExpression("* * * * *")
        val cron = CronExpression("*/30 * * * *")
        val cron = CronExpression("*/5 * * * *")
        val cron = CronExpression("0   9   *   *   *")
        val cron = CronExpression("0 * * * *")
        val cron = CronExpression("0 0 * * *")
        val cron = CronExpression("0 0 * * 0")
        val cron = CronExpression("0 0 1 1 *")
        val cron = CronExpression("0 0 15 * *")
        val cron = CronExpression("0 0 29 2 *")
        val cron = CronExpression("0 0 30 2 *")
        val cron = CronExpression("0 7 * * 1")
        val cron = CronExpression("0 9 * * *")
        val cron = CronExpression("0 9 * * 1-5")
        val cron = CronExpression("0 9-17 * * *")
        val cron = CronExpression("0,15,30,45 * * * *")
        val cron = CronExpression("30 14 * * *")
        val dt = LocalDateTime(LocalDate(year, month, day), LocalTime(hour, minute, 0, 0))
        val from = instant(2026, 1, 1, 12, 0)
        val kxInstant = dt.toInstant(utc)
        val next = cron.nextAfter(from, utc)
        val next = cron.nextAfter(instant(2026, 1, 1, 12, 1), utc)
    // ---- Parsing ----
    // ---- nextAfter ----
    @Test
    fun `accepts whitespace variations`() {
    fun `nextAfter Monday morning`() {
    fun `nextAfter crosses month boundary`() {
    fun `nextAfter crosses year boundary`() {
    fun `nextAfter daily 9am`() {
    fun `nextAfter every 30 minutes`() {
    fun `nextAfter handles leap year February 29`() {
    fun `nextAfter returns null when no match within search horizon`() {
    fun `nextAfter specific day of month`() {
    fun `nextAfter specific day of week`() {
    fun `nextAfter specific month and day`() {
    fun `nextAfter top of every hour`() {
    fun `nextAfter weekday range`() {
    fun `nextAfter with star fields fires next minute`() {
    fun `parses comma list expression`() {
    fun `parses range expression`() {
    fun `parses specific value expression`() {
    fun `parses star expression`() {
    fun `parses step expression`() {
    fun `rejects expression with wrong field count`() {
    fun `rejects malformed step`() {
    fun `rejects non-numeric values`() {
    private fun instant(year: Int, month: Int, day: Int, hour: Int = 0, minute: Int = 0): Instant {
    private val utc = TimeZone.UTC
    }
@OptIn(ExperimentalTime::class)
class CronExpressionTest {
}
