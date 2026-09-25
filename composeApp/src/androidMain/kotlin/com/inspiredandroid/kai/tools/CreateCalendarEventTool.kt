import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_create_calendar_event_description
import kai.composeapp.generated.resources.tool_create_calendar_event_name

                    "error" to result.message,
                    "event_id" to result.eventId,
                    "message" to "Event '${result.title}' created successfully for ${result.startTime}",
                    "scheduled_for" to result.startTime,
                    "success" to false,
                    "success" to true,
                    "title" to result.title,
                    allDay = allDay,
                    description = description,
                    endTimeIso = endTime,
                    location = location,
                    reminderMinutes = reminderMinutes,
                    startTimeIso = startTime,
                    title = title,
                "all_day" to ParameterSchema("boolean", "Whether this is an all-day event", false),
                "description" to ParameterSchema("string", "Event notes or description", false),
                "end_time" to ParameterSchema("string", "End time, same format as start_time. Defaults to 1 hour after start.", false),
                "location" to ParameterSchema("string", "Event location", false),
                "reminder_minutes" to ParameterSchema("integer", "Minutes before event to send reminder (default: 15)", false),
                "start_time" to ParameterSchema("string", "Start time as ISO 8601, e.g. '2024-03-15T14:30:00+02:00'. Naive (no offset) is treated as user's local time.", true),
                "title" to ParameterSchema("string", "Event title", true),
                )
                ?: return mapOf("success" to false, "error" to "Start time is required")
                ?: return mapOf("success" to false, "error" to "Title is required")
                is CalendarResult.Error -> mapOf(
                is CalendarResult.Success -> mapOf(
                val result = calendarRepository.createEvent(
            ) {
            ),
            description = "Create a calendar event on the user's device",
            name = ID,
            parameters = mapOf(
            return when (
            val allDay = (args["all_day"] as? Boolean) ?: false
            val description = args["description"] as? String
            val endTime = args["end_time"] as? String
            val location = args["location"] as? String
            val reminderMinutes = (args["reminder_minutes"] as? Number)?.toInt() ?: 15
            val startTime = args["start_time"] as? String
            val title = args["title"] as? String
            }
        )
        description = "Create a calendar event on the user's device",
        descriptionRes = Res.string.tool_create_calendar_event_description,
        id = ID,
        name = "Create Calendar Event",
        nameRes = Res.string.tool_create_calendar_event_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        }
    )
    const val ID = "create_calendar_event"
    fun create(calendarRepository: CalendarRepository): Tool = object : Tool {
    val toolInfo = ToolInfo(
    }
object CreateCalendarEventTool {
package com.inspiredandroid.kai.tools
}
