package com.inspiredandroid.kai.linux
import java.io.File
import java.nio.file.Files
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

        // /root/projects is a mount point inside the rootfs; resolving it there
        // would list an empty directory instead of the user's project folders.
        File(outside, "secret").writeText("nope")
        File(rootfs, "root").mkdirs()
        Files.createSymbolicLink(File(rootfs, "escape").toPath(), outside.toPath())
        assertEquals(File(externalHome, ".ssh/config"), legacyMap().resolve("/root/.ssh/config"))
        assertEquals(File(externalHome, "projects/demo"), legacyMap().resolve("/root/projects/demo"))
        assertEquals(File(projects, "demo/main.py"), sharedMap().resolve("/root/projects/demo/main.py"))
        assertEquals(File(rootfs, "etc/hosts"), sharedMap().resolve("/etc/hosts"))
        assertEquals(File(rootfs, "root/.ssh/config"), sharedMap().resolve("/root/.ssh/config"))
        assertEquals(File(tmp, "kai-pid"), sharedMap().resolve("/tmp/kai-pid"))
        assertEquals(projects, sharedMap().resolve("/root/projects"))
        assertEquals(rootfs, sharedMap().resolve("   "))
        assertEquals(rootfs, sharedMap().resolve(""))
        assertEquals(rootfs, sharedMap().resolve("/"))
        assertFalse(map.isRoot(File(projects, "demo")))
        assertFalse(map.isRoot(File(rootfs, "etc")))
        assertNull(map.resolve("../etc"))
        assertNull(map.resolve("/etc/../../escape"))
        assertNull(map.resolve("/root/../../etc/passwd"))
        assertNull(map.resolve("etc/hosts"))
        assertNull(sharedMap().resolve("/escape/secret"))
        assertTrue(map.isRoot(File(rootfs, "root")))
        assertTrue(map.isRoot(projects))
        assertTrue(map.isRoot(rootfs))
        assertTrue(map.isRoot(tmp))
        base = Files.createTempDirectory("guest-map").toFile()
        base.deleteRecursively()
        externalHome = File(base, "sandbox-home").apply { mkdirs() }
        homeDir = File(rootfs, "root"),
        homeDir = externalHome,
        projects = File(base, "projects").apply { mkdirs() }
        projectsDir = null,
        projectsDir = projects,
        rootfs = File(base, "rootfs").apply { mkdirs() }
        rootfsDir = rootfs,
        tmp = File(base, "tmp").apply { mkdirs() }
        tmpDir = tmp,
        val map = sharedMap()
        val outside = File(base, "outside").apply { mkdirs() }
    )
    /** Pre-unification chat sandbox: /root bound from external storage, no projects. */
    /** The current layout: /root on the rootfs, projects bound in beneath it. */
    @AfterTest
    @BeforeTest
    @Test
    fun `a symlink pointing out of its root does not resolve`() {
    fun `an empty path is the filesystem root`() {
    fun `bind roots are protected from rename and delete`() {
    fun `paths outside the binds resolve into the rootfs`() {
    fun `projects wins over root because it is the more specific bind`() {
    fun `root maps to the home directory of the layout`() {
    fun `tmp maps to the bound tmp directory`() {
    fun `traversal and relative paths are rejected`() {
    fun `without a projects bind the path stays under home`() {
    fun setUp() {
    fun tearDown() {
    private fun legacyMap() = GuestFileMap(
    private fun sharedMap() = GuestFileMap(
    private lateinit var base: File
    private lateinit var externalHome: File
    private lateinit var projects: File
    private lateinit var rootfs: File
    private lateinit var tmp: File
    }
class GuestFileMapTest {
}
