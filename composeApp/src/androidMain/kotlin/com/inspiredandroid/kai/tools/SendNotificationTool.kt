
                    "error" to result.message,
                    "message" to "Notification sent successfully",
                    "notification_id" to result.notificationId,
                    "success" to false,
                    "success" to true,
                "message" to ParameterSchema("string", "Notification content/body", true),
                "title" to ParameterSchema("string", "Notification title", false),
                )
                ?: return mapOf("success" to false, "error" to "Message is required")
                is NotificationResult.Error -> mapOf(
                is NotificationResult.Success -> mapOf(
            ),
            description = "Send a push notification to the device",
            name = ID,
            parameters = mapOf(
            return when (val result = notificationHelper.sendNotification(title, message)) {
            val message = args["message"] as? String
            val title = args["title"] as? String ?: "Kai 9000"
            }
        )
        description = "Send a push notification to the device",
        descriptionRes = Res.string.tool_send_notification_description,
        id = ID,
        name = "Send Notification",
        nameRes = Res.string.tool_send_notification_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        }
    )
    const val ID = "send_notification"
    fun create(notificationHelper: NotificationHelper): Tool = object : Tool {
    val toolInfo = ToolInfo(
    }
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_send_notification_description
import kai.composeapp.generated.resources.tool_send_notification_name
object SendNotificationTool {
package com.inspiredandroid.kai.tools
}
