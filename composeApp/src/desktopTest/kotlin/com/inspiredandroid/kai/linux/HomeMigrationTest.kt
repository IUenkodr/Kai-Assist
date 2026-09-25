package com.inspiredandroid.kai.linux
import java.io.File
import java.nio.file.Files
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

            Files.getPosixFilePermissions(File(target, ".ssh/id_rsa").toPath()),
            setOf(java.nio.file.attribute.PosixFilePermission.OWNER_READ),
        )
        // A loop is what makes following links unsafe on a real rootfs.
        // The source is a fallback until the user removes it, so it stays whole.
        Files.createSymbolicLink(File(source, "link.txt").toPath(), File("real.txt").toPath())
        Files.createSymbolicLink(File(source, "loop").toPath(), File(source, "loop").toPath())
        Files.setPosixFilePermissions(key.toPath(), setOf(java.nio.file.attribute.PosixFilePermission.OWNER_READ))
        HomeMigration.copy(source, target)
        assertEquals(
        assertEquals("content", File(target, "link.txt").readText())
        assertEquals("from source", File(source, "notes.txt").readText())
        assertEquals("from target", File(target, "notes.txt").readText())
        assertEquals("hello", File(target, "skills/greet/SKILL.md").readText())
        assertEquals("kept", File(target, ".ssh/config").readText())
        assertEquals("key", File(target, ".ssh/id_rsa").readText())
        assertEquals(0, HomeMigration.copy(File(root, "nope"), target))
        assertEquals(1, HomeMigration.copy(source, target))
        assertEquals(1, HomeMigration.survey(source, target).fileCount)
        assertEquals(1, survey.fileCount)
        assertEquals(2, copied)
        assertEquals(3, copied)
        assertEquals(3, survey.bytes)
        assertFalse(File(target, ".bashrc").exists())
        assertFalse(File(target, ".cache").exists())
        assertFalse(File(target, ".claude").exists())
        assertFalse(File(target, ".local/share/claude").exists())
        assertFalse(File(target, ".opencode").exists())
        assertFalse(File(target, "projects").exists())
        assertFalse(survey.isEmpty)
        assertTrue(File(target, ".local/bin/myscript").isFile)
        assertTrue(Files.isSymbolicLink(File(target, "link.txt").toPath()))
        assertTrue(Files.isSymbolicLink(File(target, "loop").toPath()))
        assertTrue(HomeMigration.survey(File(root, "nope"), target).isEmpty)
        assertTrue(HomeMigration.survey(source, target).isEmpty)
        file.parentFile?.mkdirs()
        file.writeText(content)
        return file
        root = Files.createTempDirectory("home-migration").toFile()
        root.deleteRecursively()
        source = File(root, "source").apply { mkdirs() }
        target = File(root, "target").apply { mkdirs() }
        val copied = HomeMigration.copy(source, target)
        val file = File(dir, path)
        val key = write(source, ".ssh/id_rsa", "key")
        val survey = HomeMigration.survey(source, target)
        write(source, ".bashrc", "alias ll='ls -l'")
        write(source, ".cache/pip/wheel", "junk")
        write(source, ".claude/settings.json", "{}")
        write(source, ".local/bin/myscript", "#!/bin/sh")
        write(source, ".local/share/claude/versions/1.0", "binary")
        write(source, ".opencode/bin/opencode", "binary")
        write(source, ".ssh/config", "Host x")
        write(source, ".ssh/id_rsa", "key")
        write(source, "notes.txt", "abc")
        write(source, "notes.txt", "abcde")
        write(source, "notes.txt", "from source")
        write(source, "projects/app/main.kt", "fun main() {}")
        write(source, "real.txt", "content")
        write(source, "skills/greet/SKILL.md", "hello")
        write(target, ".ssh/config", "kept")
        write(target, "notes.txt", "already here")
        write(target, "notes.txt", "from target")
    @AfterTest
    @BeforeTest
    @Test
    fun `a migrated home has nothing left to migrate`() {
    fun `an empty or missing source is nothing to offer`() {
    fun `copy merges into a directory the target already has`() {
    fun `copy merges without touching what the target already has`() {
    fun `excluded entries are neither surveyed nor copied`() {
    fun `private key permissions survive the copy`() {
    fun `survey counts only what the target is missing`() {
    fun `symlinks come across as links and are never followed`() {
    fun setUp() {
    fun tearDown() {
    private fun write(dir: File, path: String, content: String): File {
    private lateinit var root: File
    private lateinit var source: File
    private lateinit var target: File
    }
class HomeMigrationTest {
}
