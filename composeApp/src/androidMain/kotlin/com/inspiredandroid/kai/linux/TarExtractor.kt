import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.GZIPInputStream
import org.tukaani.xz.XZInputStream

                            java.nio.file.Paths.get(linkName),
                            outFile.toPath(),
                        )
                        if (bytesRead <= 0) break
                        if (outFile.exists()) outFile.delete()
                        java.nio.file.Files.createSymbolicLink(
                        linkTarget.copyTo(outFile, overwrite = true)
                        output.write(dataBuffer, 0, bytesRead)
                        remaining -= bytesRead
                        val bytesRead = inputStream.read(dataBuffer, 0, toRead)
                        val toRead = minOf(remaining, dataBuffer.size.toLong()).toInt()
                    if (linkTarget.exists()) {
                    outFile.parentFile?.mkdirs()
                    outFile.setExecutable(true, false)
                    try {
                    val linkTarget = File(targetDir, linkName)
                    var remaining = size
                    while (remaining > 0) {
                    }
                    } catch (_: Exception) {
                "127.0.0.1\tlocalhost\n::1\tlocalhost ip6-localhost ip6-loopback\n",
                '1' -> {
                '2' -> {
                '5', 'D' -> outFile.mkdirs()
                FileOutputStream(outFile).use { output ->
                continue
                else -> {}
                file.setWritable(true, true)
                hosts,
                if (inputStream.read() < 0) break
                if (mode and 0b001_001_001 != 0) {
                if (padding > 0) skipBytes(inputStream, padding)
                java.nio.file.Files.deleteIfExists(path)
                java.nio.file.Files.exists(path, java.nio.file.LinkOption.NOFOLLOW_LINKS)
                outFile.parentFile?.mkdirs()
                remaining -= 1
                remaining -= skipped
                skipBytes(inputStream, alignToBlock(size))
                val padding = alignToBlock(size) - size
                }
            "nameserver 8.8.8.8\nnameserver 8.8.4.4\n",
            )
            ) {
            // Fall through to File.delete
            // NOFOLLOW: broken symlinks still "exist" as links
            // Non-file entries (long-name headers, pax records) still carry a body.
            File(etcDir, "resolv.conf"),
            file.delete()
            if (!outFile.canonicalPath.startsWith(targetCanonical)) {
            if (bytesRead <= 0) break
            if (file.isDirectory && !file.canWrite()) {
            if (headerBytesRead < TAR_BLOCK_SIZE) break
            if (java.nio.file.Files.isSymbolicLink(path) ||
            if (name.isEmpty()) break
            if (size > 0) skipBytes(inputStream, alignToBlock(size))
            if (skipped <= 0) {
            if (typeFlag == TAR_TYPE_REGULAR_LEGACY || type == TAR_TYPE_REGULAR) {
            replaceWithRegularFile(
            totalRead += bytesRead
            val bytesRead = inputStream.read(buffer, totalRead, buffer.size - totalRead)
            val fullName = if (prefix.isNotEmpty()) "$prefix/$name" else name
            val headerBytesRead = readFully(inputStream, headerBuffer)
            val linkName = readTarString(headerBuffer, TAR_LINK_OFFSET, 100)
            val mode = if (modeStr.isNotEmpty()) modeStr.toInt(8) else 0
            val modeStr = readTarString(headerBuffer, TAR_MODE_OFFSET, 8)
            val name = readTarString(headerBuffer, TAR_NAME_OFFSET, 100)
            val outFile = File(targetDir, fullName)
            val prefix = readTarString(headerBuffer, TAR_PREFIX_OFFSET, 155)
            val size = if (sizeStr.isNotEmpty()) sizeStr.toLong(8) else 0L
            val sizeStr = readTarString(headerBuffer, TAR_SIZE_OFFSET, 12)
            val skipped = inputStream.skip(remaining)
            val type = typeFlag.toInt().toChar()
            val typeFlag = headerBuffer[TAR_TYPE_OFFSET]
            when (type) {
            }
            } else {
        )
        // Quiet hostname resolution noise inside the sandbox
        // systemd-resolved stub target (and similar) need a /run tree for some tools
        File(rootfsDir, "run").mkdirs()
        File(rootfsDir, "run/systemd/resolve").mkdirs()
        etcDir.mkdirs()
        file.parentFile?.mkdirs()
        file.writeText(content)
        if (!hosts.exists() || java.nio.file.Files.isSymbolicLink(hosts.toPath())) {
        if (file.exists() || file.isFile || java.nio.file.Files.isSymbolicLink(path)) {
        replaceWithRegularFile(
        return String(buffer, offset, nullIndex - offset, Charsets.US_ASCII).trim()
        return if (remainder == 0L) size else size + (TAR_BLOCK_SIZE - remainder)
        return totalRead
        rootfsDir.walkTopDown().forEach { file ->
        stream.use { extractTar(it, targetDir) }
        targetDir.mkdirs()
        try {
        val dataBuffer = ByteArray(BUFFER_SIZE)
        val end = minOf(offset + length, buffer.size)
        val etcDir = File(rootfsDir, "etc")
        val headerBuffer = ByteArray(TAR_BLOCK_SIZE)
        val hosts = File(etcDir, "hosts")
        val nullIndex = (offset until end).firstOrNull { buffer[it] == 0.toByte() } ?: end
        val path = file.toPath()
        val raw = BufferedInputStream(FileInputStream(archive))
        val remainder = size % TAR_BLOCK_SIZE
        val stream = if (archive.name.endsWith(".xz")) XZInputStream(raw) else GZIPInputStream(raw)
        val targetCanonical = targetDir.canonicalPath
        var remaining = count
        var totalRead = 0
        while (remaining > 0) {
        while (totalRead < buffer.size) {
        while (true) {
        }
        } catch (_: Exception) {
     * LXC Debian images ship `etc/resolv.conf` as a symlink into
     * `/run/systemd/resolve/...`, which does not exist under proot. Writing
     * plain file with public resolvers.
     * through that symlink throws ENOENT — delete the link first, then write a
     */
    /**
    /** Delete file or symlink (including broken links), then write [content]. */
    /** Picks the decompressor from [archive]'s extension. */
    fun extract(archive: File, targetDir: File) {
    fun makeWritable(rootfsDir: File) {
    fun writeResolvConf(rootfsDir: File) {
    private fun alignToBlock(size: Long): Long {
    private fun extractTar(inputStream: InputStream, targetDir: File) {
    private fun readFully(inputStream: InputStream, buffer: ByteArray): Int {
    private fun readTarString(buffer: ByteArray, offset: Int, length: Int): String {
    private fun replaceWithRegularFile(file: File, content: String) {
    private fun skipBytes(inputStream: InputStream, count: Long) {
    }
 * Extracts rootfs tarballs into a target directory. Alpine ships `.tar.gz`,
 * the Linux Containers Debian images ship `.tar.xz`.
 */
/**
/** ustar marks a regular file with '0'; pre-ustar archives leave the flag NUL. */
object TarExtractor {
package com.inspiredandroid.kai.linux
private const val BUFFER_SIZE = 8192
private const val TAR_BLOCK_SIZE = 512
private const val TAR_LINK_OFFSET = 157
private const val TAR_MODE_OFFSET = 100
private const val TAR_NAME_OFFSET = 0
private const val TAR_PREFIX_OFFSET = 345
private const val TAR_SIZE_OFFSET = 124
private const val TAR_TYPE_OFFSET = 156
private const val TAR_TYPE_REGULAR = '0'
private const val TAR_TYPE_REGULAR_LEGACY: Byte = 0
}
