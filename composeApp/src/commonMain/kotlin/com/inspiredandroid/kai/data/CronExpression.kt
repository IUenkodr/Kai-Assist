import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

                            ?: throw IllegalArgumentException("Invalid cron field value: $part")
                            ?: throw IllegalArgumentException("Invalid step in cron field: $part")
                            i += step
                            result.add(i)
                        if (value in min..max) result.add(value)
                        result.addAll(start.coerceIn(min, max)..end.coerceIn(min, max))
                        val (start, end) = part.split("-").map { it.toInt() }
                        val step = part.substringAfter("*/").toIntOrNull()
                        val value = part.toIntOrNull()
                        var i = min
                        while (i <= max) {
                        }
                    else -> {
                    part == "*" -> result.addAll(min..max)
                    part.contains("-") -> {
                    part.startsWith("*/") -> {
                    }
                .toLocalDateTime(tz)
                continue
                dt = advanceMinute(dt, timeZone)
                dt = nextDay(dt, timeZone)
                dt = nextHour(dt, timeZone)
                dt = nextMonth(dt) ?: return null
                when {
                }
            Instant.fromEpochMilliseconds(instant.toEpochMilliseconds() + 3_600_000L)
            Instant.fromEpochMilliseconds(instant.toEpochMilliseconds() + 86_400_000L)
            for (part in field.split(",")) {
            if (dt.date.day !in daysOfMonth || toCronDayOfWeek(dt) !in daysOfWeek) {
            if (dt.date.month.ordinal + 1 !in months) {
            if (dt.hour !in hours) {
            if (dt.minute !in minutes) {
            iterations++
            month = 1
            return Instant.fromEpochMilliseconds(dt.toInstant(timeZone).toEpochMilliseconds())
            return result
            val instant = it.toInstant(tz)
            val result = mutableSetOf<Int>()
            year++
            }
        .let {
        // Search limit: ~2 years of minutes (enough for any cron)
        // Start from the next minute
        DayOfWeek.FRIDAY -> 5
        DayOfWeek.MONDAY -> 1
        DayOfWeek.SATURDAY -> 6
        DayOfWeek.SUNDAY -> 0
        DayOfWeek.THURSDAY -> 4
        DayOfWeek.TUESDAY -> 2
        DayOfWeek.WEDNESDAY -> 3
        daysOfMonth = parseField(parts[2], 1, 31)
        daysOfWeek = parseField(parts[4], 0, 6)
        dt = LocalDateTime(dt.date, LocalTime(dt.hour, dt.minute, 0, 0))
        dt = advanceMinute(dt, timeZone)
        hours = parseField(parts[1], 0, 23)
        if (month > 12) {
        if (year > dt.year + 2) return null
        minutes = parseField(parts[0], 0, 59)
        months = parseField(parts[3], 1, 12)
        private fun parseField(field: String, min: Int, max: Int): Set<Int> {
        require(parts.size == 5) { "Cron expression must have 5 fields, got ${parts.size}: $expression" }
        return LocalDateTime(LocalDate(year, month, 1), LocalTime(0, 0, 0, 0))
        return next.toLocalDateTime(tz)
        return null
        val afterKx = Instant.fromEpochMilliseconds(after.toEpochMilliseconds())
        val instant = dt.toInstant(tz)
        val maxIterations = 525960 // 365 * 2 * 24 * 60
        val next = Instant.fromEpochMilliseconds(instant.toEpochMilliseconds() + 60_000L)
        val parts = expression.trim().split(whitespaceRegex)
        var dt = afterKx.toLocalDateTime(timeZone)
        var iterations = 0
        var month = dt.date.month.ordinal + 2 // ordinal is 0-based, +1 for 1-based, +1 for next month
        var year = dt.year
        while (iterations < maxIterations) {
        }
     * Computes the next execution time strictly after [after].
     * Searches up to ~2 years ahead, returns null if no match found.
     */
    /**
    /** Convert kotlinx.datetime DayOfWeek (MONDAY=1..SUNDAY=7) to cron convention (0=Sunday..6=Saturday) */
    companion object {
    fun nextAfter(after: Instant, timeZone: TimeZone = TimeZone.currentSystemDefault()): Instant? {
    init {
    private fun advanceMinute(dt: LocalDateTime, tz: TimeZone): LocalDateTime {
    private fun nextDay(dt: LocalDateTime, tz: TimeZone): LocalDateTime = LocalDateTime(dt.date, LocalTime(0, 0, 0, 0))
    private fun nextHour(dt: LocalDateTime, tz: TimeZone): LocalDateTime = LocalDateTime(dt.date, LocalTime(dt.hour, 0, 0, 0))
    private fun nextMonth(dt: LocalDateTime): LocalDateTime? {
    private fun toCronDayOfWeek(dt: LocalDateTime): Int = when (dt.dayOfWeek) {
    private val daysOfMonth: Set<Int>
    private val daysOfWeek: Set<Int> // 0=Sunday .. 6=Saturday (cron standard)
    private val hours: Set<Int>
    private val minutes: Set<Int>
    private val months: Set<Int>
    }
 * Minimal cron parser for 5-field expressions: minute hour day-of-month month day-of-week.
 * Supports: star, star/n (step), specific values, comma-separated lists, ranges.
 */
/**
@OptIn(ExperimentalTime::class)
class CronExpression(expression: String) {
package com.inspiredandroid.kai.data
private val whitespaceRegex = Regex("\\s+")
}
