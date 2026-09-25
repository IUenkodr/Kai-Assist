package com.inspiredandroid.kai.ui.sandbox
import com.inspiredandroid.kai.linux.PackageEntry
import kotlin.test.Test
import kotlin.test.assertEquals

                "abseil-cpp-dev",
                "afl++",
                "android-tools",
                "fast_float",
                "fastbase64",
                "fastfetch",
                "libfastjson",
            ),
            listOf(
            listOf("fastfetch", "fastfetch-bash-completion", "py3-fastfetch"),
            listOf("lib_fastcgi", "py3-fastapi", "breakfast"),
            pkg("FastFetch"),
            pkg("abseil", "Very FAST helpers"),
            pkg("abseil-cpp-dev", "Common libraries with fast helpers"),
            pkg("afl++", "Fuzzer relying on genetic algorithms"),
            pkg("android-tools", "Android platform tools"),
            pkg("breakfast"), // contains "fast" mid-word
            pkg("fast_float", "Fast from_chars for floats"),
            pkg("fastbase64", "Unicode validation"),
            pkg("fastfetch"),
            pkg("fastfetch", "neofetch-like system info"),
            pkg("fastfetch-bash-completion"),
            pkg("lib_fastcgi"), // segment prefix after '_'
            pkg("libfastjson", "A fast JSON library"),
            pkg("py3-fastapi"), // segment prefix after '-'
            pkg("py3-fastfetch"),
            ranked,
        )
        assertEquals(
        assertEquals(input, rankSearchResults(input, "  "))
        assertEquals(listOf("FastFetch", "abseil"), ranked)
        val input = listOf(
        val input = listOf(pkg("z"), pkg("a"), pkg("m"))
        val ranked = rankSearchResults(input, "FAST").map { it.name }
        val ranked = rankSearchResults(input, "fast").map { it.name }
        val ranked = rankSearchResults(input, "fastfetch").map { it.name }
    @Test
    fun `blank query leaves order unchanged`() {
    fun `exact name match ranks first`() {
    fun `name prefix matches rank above description-only matches`() {
    fun `ranking is case insensitive`() {
    fun `segment prefix ranks above plain contains`() {
    private fun pkg(name: String, description: String? = null) = PackageEntry(name = name, version = "1.0.0-r0", description = description)
    }
class RankSearchResultsTest {
}
