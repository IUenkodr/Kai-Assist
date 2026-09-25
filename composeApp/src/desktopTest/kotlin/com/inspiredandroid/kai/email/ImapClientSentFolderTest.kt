package com.inspiredandroid.kai.email
import java.io.InputStream
import java.io.OutputStream
import java.net.ServerSocket
import kotlin.concurrent.thread
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

                clientBlock(imap)
                imap.connect()
                serverScript(socket.getInputStream(), socket.getOutputStream())
                val imap = ImapClient("127.0.0.1", serverSocket.localPort, tls = false)
            actualSize = literal.size
            declaredSize = Regex("\\{(\\d+)\\}").find(appendCommand)!!.groupValues[1].toInt()
            if (b != '\r'.code) sb.append(b.toChar())
            if (b == -1 || b == '\n'.code) break
            imap.appendToMailbox("Sent", "From: a@b\n\nhi")
            imap.appendToMailbox("Sent", message)
            imap.createMailbox("Sent")
            imap.findSentMailbox()
            input.readLineRaw()
            input.readLineRaw() // trailing CRLF terminating the command
            output.writeLine("* LIST (\\HasNoChildren \\Sent) \"/\" \"Sent Messages\"")
            output.writeLine("* LIST (\\HasNoChildren) \"/\" INBOX")
            output.writeLine("* OK ready")
            output.writeLine("+ Ready for literal data")
            output.writeLine("A1 NO [TRYCREATE] Mailbox doesn't exist: Sent")
            output.writeLine("A1 OK APPEND completed")
            output.writeLine("A1 OK CREATE completed")
            output.writeLine("A1 OK LIST completed")
            receivedLiteral = literal.decodeToString()
            return runBlocking {
            serverSocket.accept().use { socket ->
            serverSocket.close()
            serverThread.join(5_000)
            val appendCommand = input.readLineRaw()
            val b = read()
            val literal = input.readNBytes(declaredSize)
            }
        assertEquals("From: a@example.com\r\nTo: b@example.com\r\n\r\nhello äöü", receivedLiteral)
        assertEquals("Sent Messages", folder)
        assertEquals(declaredSize, actualSize)
        assertFalse(ok)
        assertNull(folder)
        assertTrue(ok)
        clientBlock: suspend (ImapClient) -> T,
        flush()
        return sb.toString()
        serverScript: (InputStream, OutputStream) -> Unit,
        try {
        val folder = withFakeImapServer(serverScript = { input, output ->
        val message = "From: a@example.com\nTo: b@example.com\n\nhello äöü"
        val ok = withFakeImapServer(serverScript = { input, output ->
        val sb = StringBuilder()
        val serverSocket = ServerSocket(0)
        val serverThread = thread {
        var actualSize = -1
        var declaredSize = -1
        var receivedLiteral = ""
        while (true) {
        write("$line\r\n".encodeToByteArray())
        }
        } finally {
        }) { imap ->
    ): T {
    @Test
    fun `append returns false when server rejects the mailbox`() {
    fun `append sends literal with exact CRLF byte count`() {
    fun `createMailbox succeeds on OK response`() {
    fun `findSentMailbox returns null without special-use attribute`() {
    fun `findSentMailbox returns special-use mailbox with quoted name`() {
    private fun <T> withFakeImapServer(
    private fun InputStream.readLineRaw(): String {
    private fun OutputStream.writeLine(line: String) {
    }
 * Exercises ImapClient's APPEND / LIST / CREATE support against a scripted
 * fake IMAP server on a local socket, verifying protocol details like the
 * literal byte count that can't be checked without a real peer.
 */
/**
class ImapClientSentFolderTest {
}
