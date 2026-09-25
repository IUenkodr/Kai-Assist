
            mgr.appendKnownHostLine("a.example AAAA\nb.example AAAA")
            mgr.upsertHost(alias = " ", hostname = "1.2.3.4")
            mgr.upsertHost(alias = "my host", hostname = "1.2.3.4")
            mgr.upsertHost(alias = "prod", hostname = "")
            mgr.upsertHost(alias = "prod", hostname = "1.2.3.4", port = 0)
            mgr.upsertHost(alias = "prod", hostname = "1.2.3.4", port = 70000)
        // ControlMaster was intentionally removed — Android blocks the link()
        // New values present, old gone.
        // No run of 3+ consecutive newlines should remain.
        // Only one host block for the alias.
        // Second call is a no-op on content.
        // produces an error and zero benefit.
        // syscall openssh uses to create its mux socket, so multiplexing
        File(home, ".ssh").mkdirs()
        File(home, ".ssh/config").writeText(userPreamble)
        assertContains(configText(), "IdentitiesOnly yes")
        assertContains(configText(), "IdentityFile /etc/ssh/somekey")
        assertContains(configText(), "IdentityFile ~/.ssh/prod_id")
        assertContains(configText(), "IdentityFile ~/keys/prod_id")
        assertContains(first, "# kai:defaults:end")
        assertContains(first, "# kai:defaults:start")
        assertContains(first, "ServerAliveCountMax 3")
        assertContains(first, "ServerAliveInterval 30")
        assertContains(first, "StrictHostKeyChecking accept-new")
        assertContains(text, "# kai:defaults:start")
        assertContains(text, "# kai:host:prod:end")
        assertContains(text, "# kai:host:prod:start")
        assertContains(text, "# my hand-written notes")
        assertContains(text, "Host legacy")
        assertContains(text, "Host prod")
        assertContains(text, "HostName 1.2.3.4")
        assertContains(text, "HostName legacy.example")
        assertContains(text, "HostName new.example.com")
        assertContains(text, "Port 2222")
        assertContains(text, "User deploy")
        assertContains(text, "a.example")
        assertContains(text, "b.example")
        assertEquals(1, endCount)
        assertEquals(1, startCount)
        assertEquals(1, text.lines().count { it.trim() == line.trim() })
        assertEquals(first, configText())
        assertFailsWith<IllegalArgumentException> {
        assertFalse(changed, "second identical upsert should report no change")
        assertFalse(first.contains("ControlMaster"))
        assertFalse(first.contains("ControlPath"))
        assertFalse(mgr.appendKnownHostLine(line), "duplicate exact line should not be re-appended")
        assertFalse(text.contains("User root"))
        assertFalse(text.contains("\n\n\n"), "should not accumulate blank lines: <<<$text>>>")
        assertFalse(text.contains("old.example.com"))
        assertTrue(changed)
        assertTrue(mgr.appendKnownHostLine(line))
        assertTrue(text.endsWith("\n"))
        home = Files.createTempDirectory("ssh-cfg-test").toFile()
        home.deleteRecursively()
        mgr = SshConfigManager(home)
        mgr.appendKnownHostLine("a.example ssh-ed25519 AAAA1")
        mgr.appendKnownHostLine("b.example ssh-ed25519 AAAA2")
        mgr.ensureDefaults()
        mgr.upsertHost("prod", "1.2.3.4")
        mgr.upsertHost("prod", "1.2.3.4", identityFile = "/etc/ssh/somekey")
        mgr.upsertHost("prod", "1.2.3.4", identityFile = "prod_id")
        mgr.upsertHost("prod", "1.2.3.4", identityFile = "~/keys/prod_id")
        mgr.upsertHost("prod", "1.2.3.4", user = "deploy")
        mgr.upsertHost("prod", "1.2.3.4", user = "deploy", port = 2222)
        mgr.upsertHost("prod", "new.example.com", user = "deploy", port = 2222)
        mgr.upsertHost("prod", "old.example.com", user = "root")
        val changed = mgr.upsertHost("prod", "1.2.3.4", user = "deploy", port = 2222)
        val changed = mgr.upsertHost(alias = "prod", hostname = "1.2.3.4")
        val endCount = "# kai:host:prod:end".toRegex().findAll(text).count()
        val first = configText()
        val line = "example.com ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAITESTKEY"
        val startCount = "# kai:host:prod:start".toRegex().findAll(text).count()
        val text = configText()
        val text = knownHostsText()
        val userPreamble = "# my hand-written notes\nHost legacy\n    HostName legacy.example\n\n"
        }
    @AfterTest
    @BeforeTest
    @Test
    fun appendKnownHostLineAppendsDistinctLines() {
    fun appendKnownHostLineDedupes() {
    fun appendKnownHostLineRejectsMultiline() {
    fun blankAliasRejected() {
    fun blankHostnameRejected() {
    fun ensureDefaultsCreatesBlockOnce() {
    fun invalidPortRejected() {
    fun repeatedUpsertsDoNotGrowBlankLines() {
    fun setUp() {
    fun tearDown() {
    fun upsertHostAddsBlockAndSeedsDefaults() {
    fun upsertHostIsIdempotentForSameArgs() {
    fun upsertHostKeepsAbsoluteIdentity() {
    fun upsertHostKeepsNonKaiContent() {
    fun upsertHostKeepsTildeIdentity() {
    fun upsertHostReplacesPreviousBlock() {
    fun upsertHostResolvesRelativeIdentity() {
    fun whitespaceInAliasRejected() {
    private fun configText(): String = File(home, ".ssh/config").readText()
    private fun knownHostsText(): String = File(home, ".ssh/known_hosts").readText()
    private lateinit var home: File
    private lateinit var mgr: SshConfigManager
    }
class SshConfigManagerTest {
import java.io.File
import java.nio.file.Files
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
package com.inspiredandroid.kai.sandbox
}
