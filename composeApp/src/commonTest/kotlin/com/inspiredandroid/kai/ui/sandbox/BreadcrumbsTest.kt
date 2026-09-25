
            breadcrumbs(currentPath = "/etc", rootPath = "/root/projects/demo"),
            breadcrumbs(currentPath = "/root/notes", rootPath = "/"),
            breadcrumbs(currentPath = "/root/projects/demo", rootPath = "/root/projects/demo"),
            breadcrumbs(currentPath = "/root/projects/demo/src", rootPath = "/root/projects/demo"),
            breadcrumbs(currentPath = "/root/projects/demo/src", rootPath = "/root/projects/demo/"),
            listOf("/" to "/", "root" to "/root", "notes" to "/root/notes"),
            listOf("demo" to "/root/projects/demo"),
            listOf("demo" to "/root/projects/demo", "src" to "/root/projects/demo/src"),
        )
        assertEquals(
    @Test
    fun `a path outside the root collapses to the root`() {
    fun `a trailing slash on the root does not add an empty crumb`() {
    fun `filesystem root keeps the sandbox trail`() {
    fun `project root is the first crumb`() {
    fun `sitting on the root offers nothing above it`() {
    }
class BreadcrumbsTest {
import kotlin.test.Test
import kotlin.test.assertEquals
package com.inspiredandroid.kai.ui.sandbox
}
