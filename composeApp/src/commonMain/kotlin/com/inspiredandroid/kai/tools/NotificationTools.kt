import com.inspiredandroid.kai.data.NotificationRecord
import com.inspiredandroid.kai.data.NotificationStore
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.notifications.NotificationReader
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_check_notifications_description
import kai.composeapp.generated.resources.tool_check_notifications_name
import kai.composeapp.generated.resources.tool_read_notification_description
import kai.composeapp.generated.resources.tool_read_notification_name
import kai.composeapp.generated.resources.tool_search_notifications_description
import kai.composeapp.generated.resources.tool_search_notifications_name

                        "system Notification access settings.",
                    "error" to "Notification access not granted. Ask the user to enable Kai under " +
                    "success" to false,
                    description = "Optional package name filter (e.g. com.whatsapp)",
                    description = "Text to match against app name, title, or body",
                    description = "The notification id returned by check_notifications or search_notifications",
                    required = false,
                    required = true,
                    type = "string",
                "Returns app name, title, posted time, and a short preview. Use read_notification with " +
                "Use check_notifications or search_notifications first to find an id.",
                "app_label" to record.appLabel,
                "category" to record.category,
                "count" to matches.size,
                "count" to pending.size,
                "id" to ParameterSchema(
                "id" to record.id,
                "notifications" to matches.map(::summary),
                "notifications" to pending.map(::summary),
                "package_name" to ParameterSchema(
                "package_name" to record.packageName,
                "posted_at" to record.postedAtEpochMs,
                "query" to ParameterSchema(
                "subtext" to record.subtext,
                "success" to true,
                "text" to record.text,
                "the `id` to fetch the full body. If nothing is pending, call search_notifications " +
                "title" to record.title,
                "to find a known notification by app or text.",
                "up to 20 matches. Optionally filter by `package_name` to restrict to one app.",
                )
                ),
                ?: return mapOf("success" to false, "error" to "Missing id")
                ?: return mapOf("success" to false, "error" to "No notification found with id $id")
                return mapOf(
                return mapOf("success" to false, "error" to "Missing query")
                return mapOf("success" to false, "error" to "Notification access not granted")
                return mapOf("success" to false, "error" to "Notification reading is not available on this build")
            )
            ),
            description = "List recent notifications that the user hasn't been shown yet. " +
            description = "Read the full body of a specific notification by its id. " +
            description = "Search notifications by app name, title, or body text. Returns newest-first, " +
            if (!reader.hasAccess()) {
            if (!reader.isSupported()) {
            if (query.isNullOrBlank()) {
            name = "check_notifications",
            name = "read_notification",
            name = "search_notifications",
            parameters = emptyMap(),
            parameters = mapOf(
            return mapOf(
            val id = args["id"]?.toString()
            val matches = reader.search(query, SEARCH_LIMIT, packageName)
            val packageName = args["package_name"]?.toString()?.trim()?.takeIf { it.isNotEmpty() }
            val pending = store.getPending()
            val query = args["query"]?.toString()?.trim()
            val record = reader.getById(id)
            }
        "app_label" to record.appLabel,
        "id" to record.id,
        "package_name" to record.packageName,
        "posted_at" to record.postedAtEpochMs,
        "preview" to record.preview,
        "title" to record.title,
        )
        checkNotificationsTool(store, reader),
        checkNotificationsToolInfo,
        description = "List recent unread notifications",
        description = "Read the full body of a notification",
        description = "Search notifications by app or text",
        descriptionRes = Res.string.tool_check_notifications_description,
        descriptionRes = Res.string.tool_read_notification_description,
        descriptionRes = Res.string.tool_search_notifications_description,
        id = "check_notifications",
        id = "read_notification",
        id = "search_notifications",
        name = "Check Notifications",
        name = "Read Notification",
        name = "Search Notifications",
        nameRes = Res.string.tool_check_notifications_name,
        nameRes = Res.string.tool_read_notification_name,
        nameRes = Res.string.tool_search_notifications_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        readNotificationTool(reader),
        readNotificationToolInfo,
        searchNotificationsTool(reader),
        searchNotificationsToolInfo,
        userToggleable = false,
        }
    )
    fun checkNotificationsTool(store: NotificationStore, reader: NotificationReader) = object : Tool {
    fun getNotificationTools(store: NotificationStore, reader: NotificationReader): List<Tool> = listOf(
    fun readNotificationTool(reader: NotificationReader) = object : Tool {
    fun searchNotificationsTool(reader: NotificationReader) = object : Tool {
    private const val SEARCH_LIMIT = 20
    private fun summary(record: NotificationRecord): Map<String, Any?> = mapOf(
    val checkNotificationsToolInfo = ToolInfo(
    val notificationToolDefinitions = listOf(
    val readNotificationToolInfo = ToolInfo(
    val searchNotificationsToolInfo = ToolInfo(
    }
object NotificationTools {
package com.inspiredandroid.kai.tools
}
