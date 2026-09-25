
                    addReminder(eventId, reminderMinutes)
                    return cursor.getLong(idIndex)
                // Add reminder if specified
                // Default to 1 hour after start
                CalendarResult.Error("Failed to create calendar event")
                CalendarResult.Success(eventId, title, formattedStart)
                if (idIndex >= 0) {
                if (reminderMinutes > 0) {
                parseIsoDateTimeToEpochMs(endTimeIso)
                return CalendarResult.Error("Calendar permission denied. Please enable calendar access in Settings to create events.")
                return ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                startMillis + 60 * 60 * 1000
                val formattedStart = formatForDisplay(startMillis)
                val idIndex = cursor.getColumnIndex(CalendarContract.Calendars._ID)
                val ldt = LocalDateTime.parse(trimmed, formatter)
                }
            "${CalendarContract.Calendars.IS_PRIMARY} DESC",
            ?: return CalendarResult.Error("No writable calendar found. Please set up a calendar account on your device.")
            CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,
            CalendarContract.Calendars.CONTENT_URI,
            CalendarContract.Calendars.IS_PRIMARY,
            CalendarContract.Calendars._ID,
            CalendarResult.Error("Error creating event: ${e.message}")
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
            Log.d(TAG, "Permission already granted")
            Log.d(TAG, "Permission not granted, requesting...")
            Log.d(TAG, "Permission request result: $granted")
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,
            context,
            description?.let { put(CalendarContract.Events.DESCRIPTION, it) }
            endMillis = if (endTimeIso != null) {
            if (!granted) {
            if (cursor.moveToFirst()) {
            if (eventId != null) {
            location?.let { put(CalendarContract.Events.EVENT_LOCATION, it) }
            projection,
            put(CalendarContract.Events.ALL_DAY, if (allDay) 1 else 0)
            put(CalendarContract.Events.CALENDAR_ID, calendarId)
            put(CalendarContract.Events.DTEND, endMillis)
            put(CalendarContract.Events.DTSTART, startMillis)
            put(CalendarContract.Events.EVENT_TIMEZONE, timeZone)
            put(CalendarContract.Events.TITLE, title)
            put(CalendarContract.Reminders.EVENT_ID, eventId)
            put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT)
            put(CalendarContract.Reminders.MINUTES, minutesBefore)
            return CalendarResult.Error("Invalid date format. Please use ISO 8601 format (e.g., 2024-03-15T14:30:00)")
            return Instant.parse(trimmed).toEpochMilli()
            return OffsetDateTime.parse(trimmed).toInstant().toEpochMilli()
            selection,
            selectionArgs,
            startMillis = parseIsoDateTimeToEpochMs(startTimeIso)
            try {
            val eventId = uri?.lastPathSegment?.toLongOrNull()
            val granted = permissionController.requestPermission()
            val uri = context.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
            }
            } catch (_: DateTimeParseException) {
            } else {
        )
        ) == PackageManager.PERMISSION_GRANTED
        )?.use { cursor ->
        // Naive inputs: interpret in the device's current zone.
        // Offset-qualified inputs (e.g. "2024-03-15T14:30:00+02:00" or "...Z") must
        // Request permission if not already granted
        // a relaxed formatter silently drops the offset and re-anchors to system zone,
        // be converted directly to an instant. Going through LocalDateTime.parse with
        // differs from the device's local offset.
        // which surfaces as an off-by-N-hours bug whenever the AI sends an offset that
        Log.d(TAG, "createEvent called: title=$title, startTime=$startTimeIso")
        allDay: Boolean,
        context.contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, reminderValues)
        context.contentResolver.query(
        description: String?,
        endTimeIso: String?,
        for (formatter in formatters) {
        if (!hasCalendarPermission()) {
        location: String?,
        reminderMinutes: Int,
        return dateTime.format(formatter)
        return hasRead && hasWrite
        return null
        return try {
        startTimeIso: String,
        throw DateTimeParseException("Unable to parse date: $isoString", isoString, 0)
        title: String,
        try {
        val calendarId = getPrimaryCalendarId()
        val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault())
        val endMillis: Long
        val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a")
        val formatters = listOf(
        val hasRead = ContextCompat.checkSelfPermission(
        val hasWrite = ContextCompat.checkSelfPermission(
        val projection = arrayOf(
        val reminderValues = ContentValues().apply {
        val selection = "${CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL} >= ?"
        val selectionArgs = arrayOf(CalendarContract.Calendars.CAL_ACCESS_CONTRIBUTOR.toString())
        val startMillis: Long
        val timeZone = TimeZone.getDefault().id
        val trimmed = isoString.trim()
        val values = ContentValues().apply {
        }
        } catch (_: DateTimeParseException) {
        } catch (e: DateTimeParseException) {
        } catch (e: Exception) {
        } else {
    ): CalendarResult {
    data class Error(val message: String) : CalendarResult()
    data class Success(val eventId: Long, val title: String, val startTime: String) : CalendarResult()
    fun getPrimaryCalendarId(): Long? {
    fun hasCalendarPermission(): Boolean {
    private fun addReminder(eventId: Long, minutesBefore: Int) {
    private fun formatForDisplay(millis: Long): String {
    private fun parseIsoDateTimeToEpochMs(isoString: String): Long {
    private val context: Context,
    private val permissionController: PermissionController,
    suspend fun createEvent(
    }
) {
class CalendarRepository(
import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.provider.CalendarContract
import android.util.Log
import androidx.core.content.ContextCompat
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.TimeZone
package com.inspiredandroid.kai.tools
private const val TAG = "CalendarRepository"
sealed class CalendarResult {
}
