
                                    "account_email" to account.email,
                                    "account_id" to account.id,
                                    "date" to msg.date,
                                    "from" to msg.from,
                                    "preview" to msg.preview,
                                    "subject" to msg.subject,
                                    "uid" to msg.uid,
                                "date" to msg.date,
                                "from" to msg.from,
                                "is_read" to msg.isRead,
                                "preview" to msg.preview,
                                "subject" to msg.subject,
                                "uid" to msg.uid,
                                ),
                                mapOf(
                                put("saved_to_sent_folder", sentFolder)
                                put("warning", "Could not save a copy to the Sent folder")
                            (detected?.note?.let { " Note: $it" } ?: ""),
                            )
                            .filter { it > syncState.lastSeenUid }
                            .takeLast(20)
                            allEmails.add(
                            deliveredByAccount.getOrPut(account.id) { mutableListOf() }.add(msg.uid)
                            if (msg.bodyHtml.isNotEmpty()) put("body_html", msg.bodyHtml)
                            if (msg.listUnsubscribe.isNotEmpty()) put("list_unsubscribe", msg.listUnsubscribe)
                            if (msg.listUnsubscribePost.isNotEmpty()) put("list_unsubscribe_post", msg.listUnsubscribePost)
                            if (sentFolder != null) {
                            mapOf(
                            put("body", msg.body)
                            put("date", msg.date)
                            put("from", from)
                            put("from", msg.from)
                            put("message", "Email sent successfully to $to")
                            put("message", "Reply sent successfully to $to")
                            put("message_id", msg.messageId)
                            put("subject", msg.subject)
                            put("subject", subject)
                            put("success", true)
                            put("to", msg.to)
                            put("to", to)
                            put("uid", msg.uid)
                            }
                            } else {
                        "No new emails since the last delivery. To find a message Kai has already surfaced (or any older email), call search_email with the account_id from `accounts` and a `from` / `subject` / `since` filter.",
                        "count" to messages.size,
                        "emails" to messages.map { msg ->
                        "error" to "Login failed. Check your password." +
                        "hint",
                        "success" to false,
                        "success" to true,
                        (detected?.note?.let { " Note: $it" } ?: ""),
                        body = body,
                        buildMap {
                        buildMap<String, Any> {
                        else -> emptyList()
                        for (msg in messages) {
                        from = account.email,
                        fromQuery != null -> imap.searchByFrom(fromQuery)
                        if (newUids.isEmpty()) return@withImapSession
                        inReplyTo = inReplyTo,
                        inReplyTo = null,
                        mapOf("success" to false, "error" to "Email not found with UID $uid")
                        mapOf("success" to false, "error" to "SMTP server rejected the message")
                        sinceDate != null -> imap.searchSince(sinceDate)
                        subject = subject,
                        subjectQuery != null -> imap.searchBySubject(subjectQuery)
                        to = to,
                        val messages = imap.fetchHeaders(newUids, account.id)
                        val newUids = unseenUids
                        val sentFolder = saveCopyToSentFolder(account, emailStore, rawMessage)
                        val unseenUids = imap.searchUnseen()
                        }
                        },
                    "account_id" to accountId,
                    "email" to email,
                    "error" to "Connection failed: ${e.message}" +
                    "imap_host" to imapHost,
                    "message" to "Email account connected successfully. You can now use check_email, read_email, reply_email, and search_email.",
                    "smtp_host" to smtpHost,
                    "success" to false,
                    "success" to true,
                    )
                    .distinct()
                    .filter { it.accountId == accId && it.uid in deliveredUidSet }
                    .filter { it.isNotEmpty() }
                    // No folder accepted the copy (fresh mailboxes often have no
                    // Sent folder at all) — create the preferred one and retry.
                    displayName = displayName,
                    email = email,
                    emailStore.removePending(pendingToDrop)
                    emailStore.updateSyncState(current.copy(lastSeenUid = maxUid))
                    errors.add("${account.email}: ${e.message}")
                    id = accountId,
                    if (imap.createMailbox(fallback) && imap.appendToMailbox(fallback, rawMessage)) fallback else null
                    if (markRead) imap.markAsRead(uid)
                    if (msg != null) {
                    if (rawMessage != null) {
                    imap.findSentMailbox()
                    imapHost = imapHost,
                    imapPort = imapPort,
                    mapOf(
                    null
                    put(
                    return mapOf(
                    saved
                    sentFolder = args["sent_folder"]?.toString() ?: "",
                    smtpHost = smtpHost,
                    smtpPort = smtpPort,
                    useStartTls = detected?.useStartTls ?: true,
                    username = email,
                    val fallback = account.sentFolder.ifEmpty { "Sent" }
                    val messages = imap.fetchHeaders(uids.takeLast(20), account.id)
                    val msg = imap.fetchBody(uid, account.id)
                    val rawMessage = smtp.sendReply(
                    val syncState = emailStore.getSyncState(account.id)
                    val uids = when {
                    withImapSession(account, emailStore) { imap ->
                    }
                    } else {
                "account_id" to ParameterSchema(type = "string", description = "Account to search in — account ID or email address. May be omitted when only one account is connected.", required = false),
                "account_id" to ParameterSchema(type = "string", description = "Specific account ID to check (checks all if omitted)", required = false),
                "account_id" to ParameterSchema(type = "string", description = "The account that owns this email — account ID or email address. May be omitted when only one account is connected.", required = false),
                "account_id" to ParameterSchema(type = "string", description = "The account to send from — account ID or email address. May be omitted when only one account is connected.", required = false),
                "body" to ParameterSchema(type = "string", description = "Email body text", required = true),
                "body" to ParameterSchema(type = "string", description = "Reply body text", required = true),
                "display_name" to ParameterSchema(type = "string", description = "Display name for outgoing emails", required = false),
                "email" to ParameterSchema(type = "string", description = "The email address to connect", required = true),
                "from" to ParameterSchema(type = "string", description = "Search by sender email/name", required = false),
                "imap_host" to ParameterSchema(type = "string", description = "IMAP server hostname (auto-detected if omitted)", required = false),
                "imap_port" to ParameterSchema(type = "integer", description = "IMAP port (default 993)", required = false),
                "in_reply_to" to ParameterSchema(type = "string", description = "Message-ID of the email being replied to (for threading)", required = false),
                "mark_read" to ParameterSchema(type = "boolean", description = "Whether to mark the email as seen on the server (default false — reading is non-destructive). Set true only when the user has actually dealt with the email and wants it out of their unread list.", required = false),
                "password" to ParameterSchema(type = "string", description = "The password or app-specific password", required = true),
                "sent_folder" to ParameterSchema(type = "string", description = "IMAP folder for storing copies of sent emails (common Sent folder names are auto-detected if omitted)", required = false),
                "since" to ParameterSchema(type = "string", description = "Search emails since date (format: 01-Jan-2025)", required = false),
                "smtp_host" to ParameterSchema(type = "string", description = "SMTP server hostname (auto-detected if omitted)", required = false),
                "smtp_port" to ParameterSchema(type = "integer", description = "SMTP port (default 587)", required = false),
                "subject" to ParameterSchema(type = "string", description = "Email subject (typically 'Re: original subject')", required = true),
                "subject" to ParameterSchema(type = "string", description = "Email subject line", required = true),
                "subject" to ParameterSchema(type = "string", description = "Search by subject text", required = false),
                "to" to ParameterSchema(type = "string", description = "Recipient email address", required = true),
                "uid" to ParameterSchema(type = "integer", description = "The email UID from check_email results", required = true),
                )
                // Prefer the configured folder, then the server-advertised
                // SPECIAL-USE \Sent mailbox, then common folder names.
                ?: return accountNotFoundError(emailStore, accountId)
                ?: return mapOf("success" to false, "error" to "Cannot auto-detect SMTP server. Please provide smtp_host.")
                ?: return mapOf("success" to false, "error" to "Cannot auto-detect server for this email. Please provide imap_host and smtp_host.")
                ?: return mapOf("success" to false, "error" to "Missing body")
                ?: return mapOf("success" to false, "error" to "Missing email")
                ?: return mapOf("success" to false, "error" to "Missing password")
                ?: return mapOf("success" to false, "error" to "Missing subject")
                ?: return mapOf("success" to false, "error" to "Missing to")
                ?: return mapOf("success" to false, "error" to "Missing uid")
                emailStore.addAccount(account)
                emailStore.getAccounts()
                emailStore.setPassword(accountId, password)
                if (!loginOk) {
                if (allEmails.isEmpty()) {
                if (maxUid > current.lastSeenUid) {
                if (pendingToDrop.isNotEmpty()) {
                if (saved != null) {
                imap.connect()
                imap.login(account.username.ifEmpty { account.email }, emailStore.getPassword(account.id))
                imap.logout()
                listOfNotNull(resolveAccount(emailStore, accountId))
                mapOf(
                mapOf("success" to false, "error" to "Failed to read email: ${e.message}")
                mapOf("success" to false, "error" to "Failed to send email: ${e.message}")
                mapOf("success" to false, "error" to "Failed to send reply: ${e.message}")
                mapOf("success" to false, "error" to "Search failed: ${e.message}")
                put("accounts", accountsInfo)
                put("connected_accounts", accounts.map { mapOf("account_id" to it.id, "email" to it.email) })
                put("emails", allEmails)
                put("errors", errors)
                put("success", true)
                put("unread_count", allEmails.size)
                return mapOf("success" to false, "error" to "At least one search criteria required (from, subject, or since)")
                return mapOf("success" to false, "error" to "No email accounts configured. Use setup_email first.")
                try {
                val account = EmailAccount(
                val accountId = Uuid.random().toString()
                val candidates = (listOf(account.sentFolder, specialUse.orEmpty()) + sentFolderCandidates)
                val current = emailStore.getSyncState(accId)
                val deliveredUidSet = uids.toSet()
                val loginOk = imap.login(email, password)
                val maxUid = uids.max()
                val pendingToDrop = emailStore.getPending()
                val saved = candidates.firstOrNull { imap.appendToMailbox(it, rawMessage) }
                val specialUse = try {
                withImapSession(account, emailStore) { imap ->
                withSmtpSession(account, emailStore) { smtp, from ->
                }
                } catch (_: Exception) {
                } catch (e: Exception) {
                } else {
            "${account.displayName} <${account.email}>"
            ),
            // Advance per-account watermark and drop the just-surfaced UIDs from pending so
            // Auto-detect or use provided settings
            // Test IMAP connection
            // the next heartbeat doesn't repeat them.
            ?: accounts.find { it.email.equals(rawAccountId, ignoreCase = true) }
            account.email
            accounts.isEmpty() -> "No email accounts configured. Use setup_email first."
            description = "Compose and send a new email. Use this when the user wants to write a fresh email to someone (not a reply to an existing thread). A copy of the sent message is saved to the account's Sent folder automatically.",
            description = "Connect an email account for reading and sending. Auto-detects server settings for Gmail, Outlook, Yahoo, iCloud, etc. For Gmail, guide the user to create an App Password at myaccount.google.com > Security > 2-Step Verification > App passwords. For iCloud, guide them to appleid.apple.com > Sign-In and Security > App-Specific Passwords.",
            description = "List emails that have arrived since the last time Kai surfaced new mail to the user. Kai tracks delivery internally and ignores the provider's read flag, so an email shows up here at most once whether it was first seen via heartbeat or a previous check_email. To find an email that's already been surfaced (or any older message), use search_email with `from` / `subject` / `since`. If multiple accounts are connected, checks all of them.",
            description = "Read the full body of a specific email by its UID. Use check_email first to get the UID.",
            description = "Reply to an email. Uses SMTP with proper In-Reply-To threading. Use read_email first to get the message_id for threading. A copy of the sent message is saved to the account's Sent folder automatically.",
            description = "Search emails by sender, subject, or date across the whole inbox (read and unread). Prefer this over check_email whenever the user mentions a specific sender, subject, or time range — e.g. \"unsubscribe from X\", \"the email from Alice last week\". Returns matching email summaries with an `is_read` flag.",
            else -> "Account not found: $rawAccountId"
            for ((accId, uids) in deliveredByAccount) {
            for (account in accounts) {
            if (accounts.isEmpty()) {
            if (accounts.isNotEmpty()) {
            if (fromQuery == null && subjectQuery == null && sinceDate == null) {
            imap.connect()
            imap.login(account.username.ifEmpty { account.email }, password)
            imap.logout()
            imap.selectInbox()
            name = "check_email",
            name = "compose_email",
            name = "read_email",
            name = "reply_email",
            name = "search_email",
            name = "setup_email",
            null
            parameters = mapOf(
            put("error", error)
            put("success", false)
            rawAccountId.isNullOrBlank() -> "Multiple accounts are connected — specify which one via account_id or email address."
            return block(imap)
            return block(smtp, from)
            return buildMap {
            return try {
            smtp.quit()
            try {
            val account = resolveAccount(emailStore, accountId)
            val accountId = args["account_id"]?.toString()
            val accounts = if (accountId != null) {
            val accountsInfo = accounts.map { mapOf("account_id" to it.id, "email" to it.email) }
            val allEmails = mutableListOf<Map<String, Any?>>()
            val body = args["body"]?.toString()
            val deliveredByAccount = mutableMapOf<String, MutableList<Long>>()
            val detected = ServerAutoDetect.detect(email)
            val displayName = args["display_name"]?.toString() ?: ""
            val email = args["email"]?.toString()
            val errors = mutableListOf<String>()
            val fromQuery = args["from"]?.toString()
            val imap = ImapClient(account.imapHost, account.imapPort)
            val imap = ImapClient(imapHost, imapPort)
            val imapHost = args["imap_host"]?.toString() ?: detected?.imapHost
            val imapPort = (args["imap_port"] as? Number)?.toInt() ?: detected?.imapPort ?: 993
            val inReplyTo = args["in_reply_to"]?.toString()
            val markRead = (args["mark_read"] as? Boolean) ?: false
            val password = args["password"]?.toString()
            val password = emailStore.getPassword(account.id)
            val sinceDate = args["since"]?.toString()
            val smtpHost = args["smtp_host"]?.toString() ?: detected?.smtpHost
            val smtpPort = (args["smtp_port"] as? Number)?.toInt() ?: detected?.smtpPort ?: 587
            val subject = args["subject"]?.toString()
            val subjectQuery = args["subject"]?.toString()
            val to = args["to"]?.toString()
            val uid = (args["uid"] as? Number)?.toLong()
            }
            } catch (e: Exception) {
            } else {
            } finally {
        )
        // Gmail already stores SMTP-sent messages in its Sent folder; appending would duplicate them.
        account: EmailAccount,
        block: suspend (ImapClient) -> T,
        block: suspend (SmtpClient, String) -> Map<String, Any>,
        checkEmailTool(emailStore),
        checkEmailToolInfo,
        composeEmailTool(emailStore),
        composeEmailToolInfo,
        description = "Check for unread emails",
        description = "Compose and send a new email",
        description = "Connect an email account",
        description = "Read full email body",
        description = "Search emails by sender, subject, or date",
        description = "Send an email reply",
        descriptionRes = Res.string.tool_check_email_description,
        descriptionRes = Res.string.tool_compose_email_description,
        descriptionRes = Res.string.tool_read_email_description,
        descriptionRes = Res.string.tool_reply_email_description,
        descriptionRes = Res.string.tool_search_email_description,
        descriptionRes = Res.string.tool_setup_email_description,
        emailStore: EmailStore,
        id = "check_email",
        id = "compose_email",
        id = "read_email",
        id = "reply_email",
        id = "search_email",
        id = "setup_email",
        if (account.smtpHost.equals("smtp.gmail.com", ignoreCase = true)) return "[Gmail]/Sent Mail"
        if (account.useStartTls) smtp.startTls()
        if (rawAccountId.isNullOrBlank()) return accounts.singleOrNull()
        name = "Check Email",
        name = "Compose Email",
        name = "Read Email",
        name = "Reply Email",
        name = "Search Email",
        name = "Setup Email",
        nameRes = Res.string.tool_check_email_name,
        nameRes = Res.string.tool_compose_email_name,
        nameRes = Res.string.tool_read_email_name,
        nameRes = Res.string.tool_reply_email_name,
        nameRes = Res.string.tool_search_email_name,
        nameRes = Res.string.tool_setup_email_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        rawMessage: String,
        readEmailTool(emailStore),
        readEmailToolInfo,
        replyEmailTool(emailStore),
        replyEmailToolInfo,
        return accounts.find { it.id == rawAccountId }
        return buildMap {
        return try {
        searchEmailTool(emailStore),
        searchEmailToolInfo,
        setupEmailTool(emailStore),
        setupEmailToolInfo,
        smtp.authenticate(account.username.ifEmpty { account.email }, password)
        smtp.connect()
        smtp.ehlo()
        try {
        userToggleable = false,
        val accounts = emailStore.getAccounts()
        val error = when {
        val from = if (account.displayName.isNotEmpty()) {
        val imap = ImapClient(account.imapHost, account.imapPort)
        val password = emailStore.getPassword(account.id)
        val smtp = SmtpClient(account.smtpHost, account.smtpPort, account.useStartTls)
        }
        } catch (_: Exception) {
        } else {
        } finally {
     * Best-effort copy of an outgoing message to the account's Sent folder so
     * Error result that lists the connected accounts so the model can correct
     * Resolve the account referenced by a tool call. Accepts the account id or
     * a wrong or stale account reference in its next call.
     * copy landed in, or null when no folder accepted it.
     * sent mail stays auditable from any mail client. Returns the folder the
     * the account's email address; falls back to the only configured account
     * when the argument is missing.
     */
    )
    ): Map<String, Any> {
    ): String? {
    ): T {
    /**
    // Common Sent mailbox names across providers; tried in order when the
    // ToolInfo definitions for settings display
    // account has no explicit sent folder configured.
    @OptIn(ExperimentalUuidApi::class)
    fun checkEmailTool(emailStore: EmailStore) = object : Tool {
    fun composeEmailTool(emailStore: EmailStore) = object : Tool {
    fun getEmailTools(emailStore: EmailStore): List<Tool> = listOf(
    fun readEmailTool(emailStore: EmailStore) = object : Tool {
    fun replyEmailTool(emailStore: EmailStore) = object : Tool {
    fun searchEmailTool(emailStore: EmailStore) = object : Tool {
    fun setupEmailTool(emailStore: EmailStore) = object : Tool {
    private fun accountNotFoundError(emailStore: EmailStore, rawAccountId: String?): Map<String, Any> {
    private fun resolveAccount(emailStore: EmailStore, rawAccountId: String?): EmailAccount? {
    private suspend fun <T> withImapSession(
    private suspend fun saveCopyToSentFolder(
    private suspend fun withSmtpSession(
    private val sentFolderCandidates = listOf("Sent", "Sent Messages", "Sent Items", "INBOX.Sent")
    val checkEmailToolInfo = ToolInfo(
    val composeEmailToolInfo = ToolInfo(
    val emailToolDefinitions = listOf(
    val readEmailToolInfo = ToolInfo(
    val replyEmailToolInfo = ToolInfo(
    val searchEmailToolInfo = ToolInfo(
    val setupEmailToolInfo = ToolInfo(
    }
import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.EmailStore
import com.inspiredandroid.kai.email.ImapClient
import com.inspiredandroid.kai.email.ServerAutoDetect
import com.inspiredandroid.kai.email.SmtpClient
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_check_email_description
import kai.composeapp.generated.resources.tool_check_email_name
import kai.composeapp.generated.resources.tool_compose_email_description
import kai.composeapp.generated.resources.tool_compose_email_name
import kai.composeapp.generated.resources.tool_read_email_description
import kai.composeapp.generated.resources.tool_read_email_name
import kai.composeapp.generated.resources.tool_reply_email_description
import kai.composeapp.generated.resources.tool_reply_email_name
import kai.composeapp.generated.resources.tool_search_email_description
import kai.composeapp.generated.resources.tool_search_email_name
import kai.composeapp.generated.resources.tool_setup_email_description
import kai.composeapp.generated.resources.tool_setup_email_name
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
object EmailTools {
package com.inspiredandroid.kai.tools
}
