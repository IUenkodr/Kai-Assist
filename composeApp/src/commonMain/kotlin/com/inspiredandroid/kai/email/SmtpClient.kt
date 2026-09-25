package com.inspiredandroid.kai.email
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.math.abs
import kotlin.time.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.offsetAt
import kotlinx.datetime.toLocalDateTime

                appendLine("In-Reply-To: $inReplyTo")
                appendLine("References: $inReplyTo")
            "${pad2(dateTime.hour)}:${pad2(dateTime.minute)}:${pad2(dateTime.second)} $offset"
            // Best-effort quit
            // Final line has space after status code, continuation lines have dash
            appendLine("Content-Type: text/plain; charset=UTF-8")
            appendLine("Date: ${rfc5322Date()}")
            appendLine("From: $from")
            appendLine("MIME-Version: 1.0")
            appendLine("Subject: $subject")
            appendLine("To: $to")
            appendLine()
            connection = null
            connection?.close()
            if (inReplyTo != null) {
            if (line.length < 4) break
            if (line.length >= 4 && line[3] == ' ') break
            readResponse()
            result.appendLine(line)
            throw Exception("AUTH LOGIN not supported: $authResponse")
            throw Exception("Auth username rejected: $userResponse")
            throw Exception("Authentication failed: $passResponse")
            throw Exception("STARTTLS failed: $response")
            val escaped = if (line.startsWith(".")) ".$line" else line
            val line = conn.readLine()
            writeLine("QUIT")
            writeLine(escaped)
            }
        // Build email headers + body
        // End with <CRLF>.<CRLF>
        // Re-issue EHLO after TLS
        // Read server greeting
        // SMTP responses can be multiline (e.g., "250-PIPELINING\r\n250 SIZE...")
        // Send base64-encoded password
        // Send base64-encoded username
        // Send message content line by line, escaping leading dots
        body: String,
        conn.writeLine(line)
        connection = createEmailConnection(host, port, tls = !useStartTls)
        connection?.upgradeToTls(host)
        ehlo()
        for (line in fullMessage.lines()) {
        from: String,
        if (!authResponse.startsWith("334")) {
        if (!passResponse.startsWith("235")) {
        if (!response.startsWith("220")) {
        if (!response.startsWith("250")) throw Exception("MAIL FROM failed: $response")
        if (!response.startsWith("250")) throw Exception("RCPT TO failed: $response")
        if (!response.startsWith("354")) throw Exception("DATA failed: $response")
        if (!useStartTls) return
        if (!userResponse.startsWith("334")) {
        inReplyTo: String? = null,
        readResponse()
        response = readResponse()
        return "$dayName, ${dateTime.day} $monthName ${dateTime.year} " +
        return if (response.startsWith("250")) fullMessage else null
        return result.toString().trim()
        subject: String,
        to: String,
        try {
        val authResponse = readResponse()
        val conn = connection ?: throw IllegalStateException("Not connected")
        val dateTime = now.toLocalDateTime(timeZone)
        val dayName = dateTime.dayOfWeek.name.take(3).lowercase().replaceFirstChar { it.uppercase() }
        val fullMessage = headers + body
        val headers = buildString {
        val monthName = dateTime.month.name.take(3).lowercase().replaceFirstChar { it.uppercase() }
        val now = Clock.System.now()
        val offset = "$offsetSign${pad2(offsetMinutes / 60)}${pad2(offsetMinutes % 60)}"
        val offsetMinutes = abs(offsetSeconds) / 60
        val offsetSeconds = timeZone.offsetAt(now).totalSeconds
        val offsetSign = if (offsetSeconds < 0) "-" else "+"
        val passResponse = readResponse()
        val response = readResponse()
        val result = StringBuilder()
        val timeZone = TimeZone.currentSystemDefault()
        val userResponse = readResponse()
        var response = readResponse()
        while (true) {
        writeLine(".")
        writeLine("AUTH LOGIN")
        writeLine("DATA")
        writeLine("EHLO $domain")
        writeLine("MAIL FROM:<$from>")
        writeLine("RCPT TO:<$to>")
        writeLine("STARTTLS")
        writeLine(Base64.encode(password.encodeToByteArray()))
        writeLine(Base64.encode(username.encodeToByteArray()))
        }
        } catch (_: Exception) {
        } finally {
     * Sends the message and returns its raw RFC 5322 form on success (so callers
     * can store a copy in the Sent folder), or null if the server rejected it.
     */
    ): String? {
    /**
    @OptIn(ExperimentalEncodingApi::class)
    private fun pad2(value: Int): String = value.toString().padStart(2, '0')
    private fun rfc5322Date(): String {
    private suspend fun readResponse(): String {
    private suspend fun writeLine(line: String) {
    private val host: String,
    private val port: Int = 587,
    private val useStartTls: Boolean = true,
    private var connection: EmailConnection? = null
    suspend fun authenticate(username: String, password: String) {
    suspend fun connect() {
    suspend fun ehlo(domain: String = "localhost") {
    suspend fun quit() {
    suspend fun sendReply(
    suspend fun startTls() {
    }
 * Minimal SMTP client for sending email replies.
 * Supports EHLO, AUTH LOGIN, STARTTLS, MAIL FROM, RCPT TO, DATA.
 */
) {
/**
class SmtpClient(
}
