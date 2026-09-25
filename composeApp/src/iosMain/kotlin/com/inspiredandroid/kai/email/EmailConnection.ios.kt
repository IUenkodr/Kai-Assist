
            closeable.close()
            selectorManager.close()
            serverName = host
        // For STARTTLS: upgrade existing connection to TLS
        builder
        builder.tls(Dispatchers.IO) {
        closeable = socket,
        closeable = tlsSocket
        host = host,
        readChannel = socket.openReadChannel(),
        readChannel = tlsSocket.openReadChannel()
        selectorManager = selectorManager,
        try {
        val tlsSocket = closeable.tls(Dispatchers.IO) {
        writeChannel = socket.openWriteChannel(autoFlush = false),
        writeChannel = tlsSocket.openWriteChannel(autoFlush = false)
        writeChannel.flush()
        writeChannel.writeStringUtf8("$line\r\n")
        }
        } catch (_: Exception) {
    )
    override suspend fun close() {
    override suspend fun readLine(): String = readChannel.readUTF8Line() ?: throw Exception("Connection closed")
    override suspend fun upgradeToTls(host: String) {
    override suspend fun writeLine(line: String) {
    private val host: String,
    private val selectorManager: SelectorManager,
    private var closeable: io.ktor.network.sockets.Socket,
    private var readChannel: ByteReadChannel,
    private var writeChannel: ByteWriteChannel,
    return KtorEmailConnection(
    val builder = aSocket(selectorManager).tcp().connect(host, port)
    val selectorManager = SelectorManager(Dispatchers.IO)
    val socket = if (tls) {
    }
    } else {
) : EmailConnection {
@file:Suppress("DEPRECATION")
actual suspend fun createEmailConnection(host: String, port: Int, tls: Boolean): EmailConnection {
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.network.tls.tls
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
package com.inspiredandroid.kai.email
private class KtorEmailConnection(
}
