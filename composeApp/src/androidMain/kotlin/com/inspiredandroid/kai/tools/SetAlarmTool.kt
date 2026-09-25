import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_set_alarm_description
import kai.composeapp.generated.resources.tool_set_alarm_name

                        "duration_seconds" to durationSeconds,
                        "hour" to hour!!,
                        "message" to "Alarm set for %02d:%02d".format(hour, minutes),
                        "message" to "Timer set for $durationSeconds seconds",
                        "minutes" to minutes!!,
                        "success" to true,
                        "type" to "alarm",
                        "type" to "timer",
                    "error" to "Provide either hour+minutes for an alarm or duration_seconds for a timer",
                    "error" to (e.message ?: "Failed to set alarm"),
                    "success" to false,
                    )
                    if (label != null) putExtra(AlarmClock.EXTRA_MESSAGE, label)
                    mapOf(
                    putExtra(AlarmClock.EXTRA_HOUR, hour)
                    putExtra(AlarmClock.EXTRA_LENGTH, durationSeconds)
                    putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                    putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                "duration_seconds" to ParameterSchema("integer", "Duration in seconds for a countdown timer", false),
                "hour" to ParameterSchema("integer", "Hour of the alarm in 24-hour format (0-23)", false),
                "label" to ParameterSchema("string", "Label for the alarm or timer", false),
                "minutes" to ParameterSchema("integer", "Minutes of the alarm (0-59)", false),
                )
                Intent(AlarmClock.ACTION_SET_ALARM).apply {
                Intent(AlarmClock.ACTION_SET_TIMER).apply {
                context.startActivity(intent)
                if (durationSeconds != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                mapOf(
                return mapOf(
                }
                } else {
            ),
            description = "Set an alarm or countdown timer on the device. For alarms provide hour and minutes. For countdown timers provide duration_seconds.",
            name = ID,
            parameters = mapOf(
            return try {
            val durationSeconds = (args["duration_seconds"] as? Number)?.toInt()
            val hour = (args["hour"] as? Number)?.toInt()
            val intent = if (durationSeconds != null) {
            val label = args["label"] as? String
            val minutes = (args["minutes"] as? Number)?.toInt()
            }
            } catch (e: Exception) {
            } else if (hour != null && minutes != null) {
            } else {
        )
        description = "Set an alarm or countdown timer on the device",
        descriptionRes = Res.string.tool_set_alarm_description,
        id = ID,
        name = "Set Alarm",
        nameRes = Res.string.tool_set_alarm_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        }
    )
    const val ID = "set_alarm"
    fun create(context: Context): Tool = object : Tool {
    val toolInfo = ToolInfo(
    }
object SetAlarmTool {
package com.inspiredandroid.kai.tools
}
