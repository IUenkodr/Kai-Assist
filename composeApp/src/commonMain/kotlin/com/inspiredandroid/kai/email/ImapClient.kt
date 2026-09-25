package com.inspiredandroid.kai.email
import com.inspiredandroid.kai.data.EmailMessage
import com.inspiredandroid.kai.tools.decodeHtmlEntities
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

                    .dropWhile { it.contains(":") || it.startsWith(" ") || it.startsWith("\t") }
                    .dropWhile { it.isBlank() }
                    .joinToString("\n")
                    .trim()
                    bytes += byte.toByte()
                    continue
                    i += 3
                !line.matches(imapTaggedResponseRegex) && line.trimEnd() != ")"
                // First part with no explicit content-type is conventionally text/plain.
                // If there's a Content-Type header but no blank line, try after first header block
                // Reading greeting - stop at first line starting with *
                // Reading tagged response - stop when we see our tag
                bytes += c.code.toByte()
                for (b in c.toString().encodeToByteArray()) bytes += b
                if (byte != null) {
                if (line.startsWith("$tag ")) break
                if (line.startsWith("* OK") || line.startsWith("* NO") || line.startsWith("* BAD")) break
                lower.startsWith("date:") -> date = line.substringAfter(":").trim()
                lower.startsWith("from:") -> from = line.substringAfter(":").trim()
                lower.startsWith("list-unsubscribe-post:") -> listUnsubscribePost = line.substringAfter(":").trim()
                lower.startsWith("list-unsubscribe:") -> listUnsubscribe = line.substringAfter(":").trim()
                lower.startsWith("message-id:") -> messageId = line.substringAfter(":").trim()
                lower.startsWith("subject:") -> subject = line.substringAfter(":").trim()
                lower.startsWith("to:") -> to = line.substringAfter(":").trim()
                lowerPart.contains("content-type: text/html") && html.isEmpty() -> html = body
                lowerPart.contains("content-type: text/plain") && plain.isEmpty() -> plain = body
                minIdx = idx
                plain.isEmpty() && !lowerPart.contains("content-type:") && index == 1 -> plain = body
                return parseListMailboxName(match.groupValues[2])
                trimmed.lines()
                trimmed.substring(blankLineIdx + 2).trim()
                unfolded += line
                unfolded[unfolded.lastIndex] = unfolded.last() + " " + line.trim()
                val byte = hex.toIntOrNull(16)
                val hex = joined.substring(i + 1, i + 3)
                }
            "base64" -> decodeBase64OrOriginal(raw)
            "quoted-printable" -> decodeQuotedPrintable(raw)
            .filter { it.isNotBlank() }
            .joinToString("\n")
            .lines()
            .mapNotNull { it.toLongOrNull() }
            .takeWhile { line ->
            .trim()
            // Best-effort logout
            // Fallback: try to find body after double newline
            accountId = accountId,
            body = body,
            bodyHtml = bodyHtml,
            conn.close()
            conn.writeLine("$tag FETCH $uid (BODY.PEEK[HEADER.FIELDS (FROM SUBJECT DATE MESSAGE-ID)] BODY.PEEK[TEXT]<0.200> FLAGS)")
            conn.writeLine("$tag LOGOUT")
            conn.writeLine(messageLine)
            connection = null
            date = date,
            else -> raw
            from = from,
            i++
            if (attributes.any { it.equals("\\Sent", ignoreCase = true) }) {
            if (blankLineIdx != -1) {
            if (bodyIdx == -1) raw else raw.substring(0, bodyIdx)
            if (c == '=' && i + 2 < joined.length) {
            if (c.code < 0x80) {
            if (firstBody.isEmpty() && body.isNotEmpty()) firstBody = body
            if (idx != -1 && (minIdx == -1 || idx < minIdx)) {
            if (msg != null) messages.add(msg)
            if (tag == null) {
            if (trimmed.isEmpty() || trimmed == "--") continue
            if (unfolded.isNotEmpty() && (line.startsWith(" ") || line.startsWith("\t"))) {
            isRead = isRead,
            line = conn.readLine()
            lineCount++
            listUnsubscribe = listUnsubscribe,
            listUnsubscribePost = listUnsubscribePost,
            messageId = messageId,
            name
            name.removeSurrounding("\"").replace("\\\"", "\"").replace("\\\\", "\\")
            preview = preview,
            readUntilTaggedOrGreeting(tag)
            result.appendLine(line)
            return extractFallbackBody(raw) to ""
            return extractPartsFromMultipart(cleaned, boundary)
            return firstBody to ""
            subject = subject,
            to = to,
            trimmed.drop(1).substringAfter("\" ", "").trim()
            trimmed.substringAfter(" ", "").trim()
            uid = uid,
            val attributes = match.groupValues[1].split(" ")
            val blankLineIdx = trimmed.indexOf("\n\n")
            val body = extractPartBody(trimmed)
            val bodyIdx = raw.indexOfAny("BODY[TEXT]", "BODY.PEEK[TEXT]")
            val c = joined[i]
            val conn = connection ?: return
            val idx = indexOf(s)
            val line = conn.readLine()
            val line = headerLine.trim()
            val lower = line.lowercase()
            val lowerPart = trimmed.lowercase()
            val match = imapListResponseRegex.find(line) ?: continue
            val msg = parseEmailFromFetch(uid, accountId, response)
            val response = readUntilTaggedOrGreeting(tag)
            val tag = nextTag()
            val trimmed = part.trim()
            when {
            }
            } else {
        )
        .decodeHtmlEntities()
        .replace(htmlTagRegex, " ")
        .replace(scriptRegex, "")
        .replace(styleRegex, "")
        .replace(whitespaceRegex, " ")
        .trim()
        // Check flags for \Seen
        // Check if it's multipart MIME content
        // Drop soft line breaks (= at end of line) then decode =HH escapes as UTF-8 bytes.
        // Find BODY[TEXT] or BODY.PEEK[TEXT] section
        // Limit header parsing to the section before BODY[TEXT] — the body may
        // Literal size counts CRLF line endings but no trailing CRLF — the final
        // Parse EXISTS count from response like "* 42 EXISTS"
        // Read server greeting
        // Remove trailing IMAP response lines (tagged response, closing paren)
        // Skip past the literal indicator: BODY[TEXT] {nnn}\n or BODY[TEXT]<0.200> {nnn}\n
        // Skip the hierarchy delimiter token (quoted single char or NIL).
        // Try \n\n (appendLine uses \n)
        // Unfold RFC 5322 header continuation lines (start with SP/HTAB) so
        // Wait for the "+" continuation before sending the literal; a tagged
        // When the email has no text/plain part, derive a readable plain body
        // contain lines that look like headers (e.g. "From:" quoted replies).
        // from the HTML so the agent always has something to work with.
        // long headers like List-Unsubscribe aren't truncated.
        // response instead means the mailbox was rejected (e.g. doesn't exist).
        // writeLine's CRLF terminates the APPEND command itself.
        Base64.Mime.decode(input.encodeToByteArray()).decodeToString()
        conn.writeLine("$tag $command")
        conn.writeLine("$tag APPEND \"${escapeQuoted(mailbox)}\" (\\Seen) {$literalSize}")
        conn.writeLine("$tag CREATE \"${escapeQuoted(mailbox)}\"")
        conn.writeLine("$tag FETCH $uid (BODY.PEEK[HEADER.FIELDS (FROM TO SUBJECT DATE MESSAGE-ID LIST-UNSUBSCRIBE LIST-UNSUBSCRIBE-POST)] BODY[TEXT])")
        conn.writeLine("$tag LIST \"\" \"*\"")
        conn.writeLine("$tag LOGIN \"${escapeQuoted(username)}\" \"${escapeQuoted(password)}\"")
        conn.writeLine("$tag SELECT INBOX")
        conn.writeLine("$tag STORE $uid +FLAGS (\\Seen)")
        connection = createEmailConnection(host, port, tls)
        for ((index, part) in parts.withIndex()) {
        for (headerLine in unfolded) {
        for (line in headerSection.lines()) {
        for (line in response.lines()) {
        for (messageLine in lines) {
        for (s in strings) {
        for (uid in uids.take(50)) { // Limit to 50 emails per fetch
        if (!line.startsWith("+")) return false
        if (bodyIdx == -1) {
        if (bodyStart == -1) return ""
        if (boundary != null) {
        if (firstNewline == -1) return "" to ""
        if (name.isEmpty()) return null
        if (plain.isEmpty() && html.isEmpty()) {
        if (raw.contains("\\Seen")) isRead = true
        if (uids.isEmpty()) return emptyList()
        input
        readUntilTaggedOrGreeting(null)
        readUntilTaggedOrGreeting(tag)
        return EmailMessage(
        return bytes.toByteArray().decodeToString()
        return cleaned.trim() to ""
        return existsMatch?.groupValues?.get(1)?.toIntOrNull() ?: 0
        return if (name.startsWith("\"")) {
        return match?.groupValues?.get(1)
        return messages
        return minIdx
        return null
        return parseEmailFromFetch(uid, accountId, response)
        return plain to html
        return raw.substring(bodyStart + 2)
        return response.contains("OK")
        return response.lines().any { it.startsWith("$tag OK") }
        return result.toString()
        return searchLine.removePrefix("* SEARCH").trim().split(" ")
        return when (encoding) {
        try {
        val (plainBody, bodyHtml) = extractBodyFromResponse(raw)
        val afterMarker = raw.substring(bodyIdx)
        val body = if (plainBody.isEmpty() && bodyHtml.isNotEmpty()) stripHtml(bodyHtml) else plainBody
        val bodyContent = afterMarker.substring(firstNewline + 1)
        val bodyIdx = raw.indexOfAny("BODY[TEXT]", "BODY.PEEK[TEXT]")
        val bodyStart = raw.indexOf("\n\n")
        val boundary = detectMimeBoundary(cleaned)
        val bytes = ArrayList<Byte>(joined.length)
        val cleaned = bodyContent.lines()
        val conn = connection ?: throw IllegalStateException("Not connected")
        val encoding = transferEncodingRegex.find(trimmed)?.groupValues?.get(1)?.lowercase()?.trim()
        val existsMatch = imapExistsRegex.find(response)
        val firstNewline = afterMarker.indexOf('\n')
        val headerSection = run {
        val joined = input.replace("=\r\n", "").replace("=\n", "")
        val lines = message.replace("\r\n", "\n").trimEnd('\n').lines()
        val literalSize = lines.sumOf { it.encodeToByteArray().size + 2 } - 2
        val match = mimeBoundaryRegex.find(content)
        val maxLines = 500 // Safety limit
        val messages = mutableListOf<EmailMessage>()
        val name = if (trimmed.startsWith("\"")) {
        val parts = content.split("--$boundary")
        val preview = body.take(200).replace("\n", " ").trim()
        val raw = run {
        val response = readUntilTaggedOrGreeting(tag)
        val result = StringBuilder()
        val searchLine = response.lines().find { it.startsWith("* SEARCH") } ?: return emptyList()
        val tag = nextTag()
        val trimmed = afterAttributes.trim()
        val unfolded = mutableListOf<String>()
        var date = ""
        var firstBody = ""
        var from = ""
        var guard = 0
        var html = ""
        var i = 0
        var isRead = false
        var line = conn.readLine()
        var lineCount = 0
        var listUnsubscribe = ""
        var listUnsubscribePost = ""
        var messageId = ""
        var minIdx = -1
        var plain = ""
        var subject = ""
        var to = ""
        while (!line.startsWith("+") && !line.startsWith("$tag ") && guard++ < 100) {
        while (i < joined.length) {
        while (lineCount < maxLines) {
        }
        } catch (_: Exception) {
        } else {
        } finally {
     * (plainText, htmlText) — htmlText is empty when the message has no HTML part.
     * Append a raw RFC 5322 message to a mailbox (e.g. the Sent folder) via IMAP APPEND.
     * Detect MIME boundary from content. Looks for lines like "--boundary_string".
     * Extract both the text/plain and text/html parts from multipart MIME content.
     * Extract readable body text from the IMAP FETCH response. Returns
     * Extract the mailbox name from the remainder of a LIST response after the
     * Fetch email headers (From, Subject, Date, Message-ID) and a text preview.
     * Fetch full email body for a specific UID.
     * Find first occurrence of any of the given strings.
     * Find the server's designated Sent mailbox via the SPECIAL-USE \Sent
     * Returns (plainText, htmlText); either may be empty if absent. Decodes the parts
     * Returns false when the server rejects the mailbox or the message.
     * according to their Content-Transfer-Encoding (quoted-printable, base64).
     * attribute (RFC 6154). Returns null when the server doesn't advertise one.
     * attribute list, e.g. `"/" "Sent Messages"` or `NIL Sent`.
     */
    /**
    private fun String.indexOfAny(vararg strings: String): Int {
    private fun decodeBase64OrOriginal(input: String): String = try {
    private fun decodeQuotedPrintable(input: String): String {
    private fun detectMimeBoundary(content: String): String? {
    private fun escapeQuoted(s: String): String = s.replace("\\", "\\\\").replace("\"", "\\\"")
    private fun extractBodyFromResponse(raw: String): Pair<String, String> {
    private fun extractFallbackBody(raw: String): String {
    private fun extractPartBody(trimmed: String): String {
    private fun extractPartsFromMultipart(content: String, boundary: String): Pair<String, String> {
    private fun nextTag(): String = "A${++tagCounter}"
    private fun parseEmailFromFetch(uid: Long, accountId: String, raw: String): EmailMessage? {
    private fun parseListMailboxName(afterAttributes: String): String? {
    private fun stripHtml(html: String): String = html
    private suspend fun readUntilTaggedOrGreeting(tag: String?): String {
    private suspend fun search(command: String): List<Long> {
    private val host: String,
    private val port: Int = 993,
    private val tls: Boolean = true,
    private var connection: EmailConnection? = null
    private var tagCounter = 0
    suspend fun appendToMailbox(mailbox: String, message: String): Boolean {
    suspend fun connect() {
    suspend fun createMailbox(mailbox: String): Boolean {
    suspend fun fetchBody(uid: Long, accountId: String): EmailMessage? {
    suspend fun fetchHeaders(uids: List<Long>, accountId: String): List<EmailMessage> {
    suspend fun findSentMailbox(): String? {
    suspend fun login(username: String, password: String): Boolean {
    suspend fun logout() {
    suspend fun markAsRead(uid: Long) {
    suspend fun searchByFrom(sender: String): List<Long> = search("SEARCH FROM \"${escapeQuoted(sender)}\"")
    suspend fun searchBySubject(subject: String): List<Long> = search("SEARCH SUBJECT \"${escapeQuoted(subject)}\"")
    suspend fun searchSince(date: String): List<Long> = search("SEARCH SINCE $date")
    suspend fun searchUnseen(): List<Long> = search("SEARCH UNSEEN")
    suspend fun selectInbox(): Int {
    }
    } catch (_: Exception) {
 * Minimal IMAP client supporting the subset of commands needed for email reading.
 * Uses tagged commands (e.g., "A001 LOGIN ...") per IMAP spec.
 */
) {
/**
@file:OptIn(ExperimentalEncodingApi::class)
class ImapClient(
private val htmlTagRegex = Regex("<[^>]+>")
private val imapExistsRegex = Regex("\\* (\\d+) EXISTS")
private val imapListResponseRegex = Regex("^\\* LIST \\(([^)]*)\\) (.*)$")
private val imapTaggedResponseRegex = Regex("^A\\d+ (OK|NO|BAD) .*")
private val mimeBoundaryRegex = Regex("^--([\\w'()+,-./:=? ]+)\\s*$", RegexOption.MULTILINE)
private val scriptRegex = Regex("(?is)<script[^>]*>.*?</script>")
private val styleRegex = Regex("(?is)<style[^>]*>.*?</style>")
private val transferEncodingRegex = Regex("content-transfer-encoding:\\s*([\\w-]+)", RegexOption.IGNORE_CASE)
private val whitespaceRegex = Regex("\\s+")
}
