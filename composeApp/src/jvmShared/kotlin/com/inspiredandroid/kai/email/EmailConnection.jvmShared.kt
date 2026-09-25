import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.Socket
import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

            host,
            socket,
            socket.close()
            socket.port,
            true,
        ) as SSLSocket
        SSLSocketFactory.getDefault().createSocket(host, port) as SSLSocket
        Socket(host, port)
        reader = BufferedReader(InputStreamReader(sslSocket.getInputStream(), Charsets.UTF_8))
        reader.readLine() ?: throw Exception("Connection closed")
        socket = sslSocket
        sslSocket.startHandshake()
        try {
        val sslFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
        val sslSocket = sslFactory.createSocket(
        writer = PrintWriter(OutputStreamWriter(sslSocket.getOutputStream(), Charsets.UTF_8), true)
        writer.flush()
        writer.print("$line\r\n")
        }
        } catch (_: Exception) {
    JvmEmailConnection(socket, host)
    override suspend fun close() = withContext(Dispatchers.IO) {
    override suspend fun readLine(): String = withContext(Dispatchers.IO) {
    override suspend fun upgradeToTls(host: String) = withContext(Dispatchers.IO) {
    override suspend fun writeLine(line: String) = withContext(Dispatchers.IO) {
    private val host: String,
    private var reader = BufferedReader(InputStreamReader(socket.getInputStream(), Charsets.UTF_8))
    private var socket: Socket,
    private var writer = PrintWriter(OutputStreamWriter(socket.getOutputStream(), Charsets.UTF_8), true)
    socket.soTimeout = 30_000
    val socket = if (tls) {
    }
    } else {
 * Socket-backed [EmailConnection] for both JVM targets. Android and desktop speak IMAP/SMTP
 * copies that have to be kept in step.
 * over the same `javax.net.ssl` stack, so the connection lives here once rather than as two
 */
) : EmailConnection {
/**
actual suspend fun createEmailConnection(host: String, port: Int, tls: Boolean): EmailConnection = withContext(Dispatchers.IO) {
package com.inspiredandroid.kai.email
private class JvmEmailConnection(
}
