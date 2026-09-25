
                description = "desc",
                files = mapOf("a.txt" to "x", "core/b.py" to "y"),
                id = "bar",
                rawSkillMd = skillMd("bar"),
            ),
            DownloadedSkill(
        )
        // Only top-level files are listed as bundled paths; nested dirs are not.
        // The built-in `create-skill` ships in compose resources and is always loaded too;
        // filter it out so this test asserts only on what landed from the sandbox.
        assertEquals("2", sandbox.files["/root/skills/bar/new.txt"])
        assertEquals("Body of foo.", sandboxSkills[0].body.trim())
        assertEquals("bar", result.id)
        assertEquals("foo", sandboxSkills[0].id)
        assertEquals("x", sandbox.files["/root/skills/bar/a.txt"])
        assertEquals("y", sandbox.files["/root/skills/bar/core/b.py"])
        assertEquals(1, sandboxSkills.size)
        assertEquals(listOf("a.txt"), mgr.getSkill("bar")?.bundledFilePaths)
        assertEquals(listOf("helper.py"), sandboxSkills[0].bundledFilePaths)
        assertEquals(listOf("new.txt"), mgr.getSkill("bar")?.bundledFilePaths)
        assertNull(sandbox.files["/root/skills/bar/old.txt"])
        assertTrue(mgr.getInstalled().none { !it.isBuiltIn })
        assertTrue(sandbox.files.keys.none { it.startsWith("/root/skills/bar/") })
        mgr.install(DownloadedSkill("bar", "desc", skillMd("bar"), mapOf("a.txt" to "x")))
        mgr.install(DownloadedSkill("bar", "desc", skillMd("bar"), mapOf("new.txt" to "2")))
        mgr.install(DownloadedSkill("bar", "desc", skillMd("bar"), mapOf("old.txt" to "1")))
        mgr.load()
        mgr.uninstall("bar")
        sandbox.files["/root/skills/foo/SKILL.md"] = skillMd("foo", body = "Body of foo.")
        sandbox.files["/root/skills/foo/helper.py"] = "print('hi')"
        sandbox.files["/root/skills/nope/readme.md"] = "no skill here"
        val mgr = manager(sandbox)
        val result = mgr.install(
        val sandbox = FakeSandboxController()
        val sandboxSkills = mgr.getInstalled().filterNot { it.isBuiltIn }
    @Test
    fun `install writes the folder and surfaces the skill`() = runTest {
    fun `load ignores folders without a SKILL_md`() = runTest {
    fun `load reads installed skill folders with their files`() = runTest {
    fun `reinstall replaces the previous folder contents`() = runTest {
    fun `uninstall deletes the folder`() = runTest {
    private fun manager(sandbox: FakeSandboxController) = SkillManager(sandbox, backgroundDispatcher = UnconfinedTestDispatcher())
    private fun skillMd(name: String, desc: String = "desc", body: String = "Do the thing.") = "---\nname: $name\ndescription: $desc\n---\n$body\n"
    }
@OptIn(ExperimentalCoroutinesApi::class)
class SkillManagerTest {
import com.inspiredandroid.kai.testutil.FakeSandboxController
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
package com.inspiredandroid.kai.skills
}
