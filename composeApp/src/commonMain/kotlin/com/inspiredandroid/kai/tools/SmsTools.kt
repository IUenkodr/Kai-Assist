
                    "error" to "SMS permission not granted. Ask the user to enable SMS in Settings.",
                    "error" to "SMS send permission not granted. Ask the user to enable 'Send SMS' in Settings.",
                    "success" to false,
                "Returns sender, date, and a short preview. Use read_sms with the `id` to fetch the " +
                "body" to ParameterSchema(type = "string", description = "Message text", required = true),
                "body" to ParameterSchema(type = "string", description = "Reply text", required = true),
                "body" to body,
                "body" to msg.body,
                "count" to matches.size,
                "count" to pending.size,
                "date" to msg.date,
                "draft_id" to draft.id,
                "from" to msg.address,
                "full body. If nothing is pending, call search_sms to find a known message by sender or text.",
                "id" to ParameterSchema(type = "integer", description = "The SMS id returned by check_sms or search_sms", required = true),
                "id" to msg.id,
                "in the review banner — the user must tap Send to actually send.",
                "in_reply_to" to smsId,
                "is_read" to msg.read,
                "message" to "Draft created. Waiting for the user to tap Send in the review banner — nothing has been sent yet.",
                "message" to "Reply draft created. Waiting for the user to tap Send in the review banner — nothing has been sent yet.",
                "messages" to matches.map(::summary),
                "messages" to pending.map(::summary),
                "query" to ParameterSchema(type = "string", description = "Text to match against sender or body", required = true),
                "sms_id" to ParameterSchema(type = "integer", description = "Id of the SMS being replied to (from check_sms / search_sms)", required = true),
                "so the user must explicitly tap Send before anything is actually sent. You cannot bypass this — " +
                "success" to true,
                "the tool only creates the draft. After calling, tell the user what you drafted and ask them to review.",
                "to" to ParameterSchema(type = "string", description = "Recipient phone number", required = true),
                "to" to original.address,
                "to" to to,
                )
                ?: return mapOf("success" to false, "error" to "Missing id")
                ?: return mapOf("success" to false, "error" to "Missing sms_id")
                ?: return mapOf("success" to false, "error" to "No SMS found with id $id")
                ?: return mapOf("success" to false, "error" to "No SMS found with id $smsId")
                address = original.address,
                address = to,
                body = body,
                createdAtEpochMs = Clock.System.now().toEpochMilliseconds(),
                id = Uuid.random().toString(),
                inReplyToSmsId = smsId,
                return mapOf(
                return mapOf("success" to false, "error" to "Missing query")
                return mapOf("success" to false, "error" to "Original SMS has no sender address to reply to")
                return mapOf("success" to false, "error" to "SMS is not available on this build")
                return mapOf("success" to false, "error" to "SMS permission not granted")
            )
            ),
            description = "Draft a reply to a received SMS. Looks up the original by id to pick the sender, then stages a draft " +
            description = "Draft an outgoing SMS. The draft is staged in a banner at the top of the chat " +
            description = "List recently received SMS messages that the user hasn't been shown yet. " +
            description = "Read the full body of a specific SMS by its id. Use check_sms or search_sms first to find an id.",
            description = "Search SMS messages by sender (phone number) or body text. Returns newest-first, up to 20 matches.",
            if (!smsReader.hasPermission()) {
            if (!smsReader.isSupported()) {
            if (!smsSender.hasPermission()) {
            if (body.isNullOrEmpty()) return mapOf("success" to false, "error" to "Missing body")
            if (original.address.isBlank()) {
            if (query.isNullOrBlank()) {
            if (to.isNullOrBlank()) return mapOf("success" to false, "error" to "Missing to")
            name = "check_sms",
            name = "read_sms",
            name = "reply_sms",
            name = "search_sms",
            name = "send_sms",
            parameters = emptyMap(),
            parameters = mapOf(
            return mapOf(
            smsDraftStore.addDraft(draft)
            val body = args["body"]?.toString()
            val draft = SmsDraft(
            val id = (args["id"] as? Number)?.toLong()
            val matches = smsReader.search(query, SEARCH_LIMIT)
            val msg = smsReader.readById(id)
            val original = smsReader.readById(smsId)
            val pending = smsStore.getPending()
            val query = args["query"]?.toString()?.trim()
            val smsId = (args["sms_id"] as? Number)?.toLong()
            val to = args["to"]?.toString()?.trim()
            }
        "date" to msg.date,
        "from" to msg.address,
        "id" to msg.id,
        "is_read" to msg.read,
        "preview" to msg.preview,
        )
        checkSmsTool(smsStore, smsReader),
        description = "Draft a reply to an SMS for the user to review and send",
        description = "Draft an SMS for the user to review and send",
        description = "List recent unread SMS messages",
        description = "Read the full body of an SMS message",
        description = "Search SMS messages by sender or text",
        descriptionRes = Res.string.tool_check_sms_description,
        descriptionRes = Res.string.tool_read_sms_description,
        descriptionRes = Res.string.tool_reply_sms_description,
        descriptionRes = Res.string.tool_search_sms_description,
        descriptionRes = Res.string.tool_send_sms_description,
        id = "check_sms",
        id = "read_sms",
        id = "reply_sms",
        id = "search_sms",
        id = "send_sms",
        name = "Check SMS",
        name = "Read SMS",
        name = "Reply SMS",
        name = "Search SMS",
        name = "Send SMS",
        nameRes = Res.string.tool_check_sms_name,
        nameRes = Res.string.tool_read_sms_name,
        nameRes = Res.string.tool_reply_sms_name,
        nameRes = Res.string.tool_search_sms_name,
        nameRes = Res.string.tool_send_sms_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        readSmsTool(smsReader),
        replySmsTool(smsDraftStore, smsReader, smsSender),
        searchSmsTool(smsReader),
        sendSmsTool(smsDraftStore, smsSender),
        smsDraftStore: SmsDraftStore,
        smsReader: SmsReader,
        smsSender: SmsSender,
        userToggleable = false,
        }
    )
    ): List<Tool> = listOf(
    @OptIn(ExperimentalUuidApi::class, ExperimentalTime::class)
    fun checkSmsTool(smsStore: SmsStore, smsReader: SmsReader) = object : Tool {
    fun getSmsReadTools(smsStore: SmsStore, smsReader: SmsReader): List<Tool> = listOf(
    fun getSmsSendTools(
    fun readSmsTool(smsReader: SmsReader) = object : Tool {
    fun replySmsTool(smsDraftStore: SmsDraftStore, smsReader: SmsReader, smsSender: SmsSender) = object : Tool {
    fun searchSmsTool(smsReader: SmsReader) = object : Tool {
    fun sendSmsTool(smsDraftStore: SmsDraftStore, smsSender: SmsSender) = object : Tool {
    private const val SEARCH_LIMIT = 20
    private fun summary(msg: SmsMessage): Map<String, Any?> = mapOf(
    val checkSmsToolInfo = ToolInfo(
    val readSmsToolInfo = ToolInfo(
    val replySmsToolInfo = ToolInfo(
    val searchSmsToolInfo = ToolInfo(
    val sendSmsToolInfo = ToolInfo(
    val smsReadToolDefinitions = listOf(checkSmsToolInfo, readSmsToolInfo, searchSmsToolInfo)
    val smsSendToolDefinitions = listOf(sendSmsToolInfo, replySmsToolInfo)
    val smsToolDefinitions = smsReadToolDefinitions + smsSendToolDefinitions
    }
import com.inspiredandroid.kai.data.SmsDraft
import com.inspiredandroid.kai.data.SmsDraftStore
import com.inspiredandroid.kai.data.SmsMessage
import com.inspiredandroid.kai.data.SmsStore
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.sms.SmsReader
import com.inspiredandroid.kai.sms.SmsSender
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_check_sms_description
import kai.composeapp.generated.resources.tool_check_sms_name
import kai.composeapp.generated.resources.tool_read_sms_description
import kai.composeapp.generated.resources.tool_read_sms_name
import kai.composeapp.generated.resources.tool_reply_sms_description
import kai.composeapp.generated.resources.tool_reply_sms_name
import kai.composeapp.generated.resources.tool_search_sms_description
import kai.composeapp.generated.resources.tool_search_sms_name
import kai.composeapp.generated.resources.tool_send_sms_description
import kai.composeapp.generated.resources.tool_send_sms_name
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
object SmsTools {
package com.inspiredandroid.kai.tools
}
