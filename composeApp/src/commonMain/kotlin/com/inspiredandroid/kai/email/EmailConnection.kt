package com.inspiredandroid.kai.email

    suspend fun close()
    suspend fun readLine(): String
    suspend fun upgradeToTls(host: String)
    suspend fun writeLine(line: String)
 * Creates a TCP connection, optionally wrapped in TLS (for implicit TLS like IMAP port 993).
 * Platform-specific TCP/TLS connection for email protocols.
 */
/**
expect suspend fun createEmailConnection(host: String, port: Int, tls: Boolean): EmailConnection
interface EmailConnection {
}
