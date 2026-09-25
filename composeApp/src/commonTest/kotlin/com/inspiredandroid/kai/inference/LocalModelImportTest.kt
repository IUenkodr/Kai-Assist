
        assertEquals("${CUSTOM_MODEL_ID_PREFIX}MyCoolModel", target.modelId)
        assertEquals("${CUSTOM_MODEL_ID_PREFIX}MyCoolModel_3", target.modelId)
        assertEquals("${CUSTOM_MODEL_ID_PREFIX}foo", model.id)
        assertEquals("MyCoolModel", target.displayName)
        assertEquals("MyCoolModel.litertlm", target.fileName)
        assertEquals("MyCoolModel_3.litertlm", target.fileName)
        assertEquals("foo", model.displayName)
        assertEquals("foo.litertlm", model.fileName)
        assertEquals("foo.litertlm", sanitizeImportFileName("/path/to/foo.litertlm"))
        assertEquals("foo.litertlm", sanitizeImportFileName("C:\\Users\\x\\foo.litertlm"))
        assertEquals("gemma-4-E2B-it.litertlm", sanitizeImportFileName("gemma-4-E2B-it.litertlm"))
        assertEquals("model.litertlm", sanitizeImportFileName(""))
        assertEquals("model.litertlm", sanitizeImportFileName(".."))
        assertEquals("model_name.litertlm", sanitizeImportFileName("model name.litertlm"))
        assertEquals("noext.litertlm", sanitizeImportFileName("noext"))
        assertEquals(CUSTOM_DEFAULT_CONTEXT_TOKENS, model.defaultContextTokens)
        assertEquals(CUSTOM_MAX_CONTEXT_TOKENS, model.maxContextTokens)
        assertEquals(IMPORTS_DIR, target.relativeDir)
        assertEquals(MODEL_CATALOG.first().fileName, target.fileName)
        assertEquals(MODEL_CATALOG.first().id, target.modelId)
        assertEquals(MODEL_CATALOG.first().id, target.relativeDir)
        assertEquals(expected.id, found?.id)
        assertFalse(isCustomModelId("gemma-4-e2b-it"))
        assertFalse(isLitertlmExtension("litertlm"))
        assertFalse(isLitertlmExtension("model"))
        assertFalse(isLitertlmExtension("model.gguf"))
        assertFalse(target.matchedCatalog)
        assertNotNull(target)
        assertNull(resolveImportTarget("model.gguf"))
        assertNull(resolveImportTarget("model.task"))
        assertTrue(isCustomModelId("custom-foo"))
        assertTrue(isLitertlmExtension("model.LITERTLM"))
        assertTrue(isLitertlmExtension("model.LiteRtLm"))
        assertTrue(isLitertlmExtension("model.litertlm"))
        assertTrue(model.downloadUrl.isEmpty())
        assertTrue(model.gpuMemoryMb >= 300)
        assertTrue(target.matchedCatalog)
        val catalogFile = MODEL_CATALOG.first().fileName
        val existing = setOf("MyCoolModel.litertlm", "MyCoolModel_2.litertlm")
        val expected = MODEL_CATALOG.first()
        val found = findCatalogModelByFileName(expected.fileName.uppercase())
        val model = customLocalModel("foo.litertlm", sizeBytes = 2L * 1024 * 1024 * 1024)
        val target = resolveImportTarget("MyCoolModel.litertlm")
        val target = resolveImportTarget("MyCoolModel.litertlm", existing)
        val target = resolveImportTarget(catalogFile)
    @Test
    fun customLocalModel_synthesizesMetadata() {
    fun findCatalogModelByFileName_isCaseInsensitive() {
    fun isCustomModelId_detectsPrefix() {
    fun isLitertlmExtension_acceptsCaseInsensitive() {
    fun resolveImportTarget_avoidsNameCollisions() {
    fun resolveImportTarget_customGoesToImports() {
    fun resolveImportTarget_matchesCatalogByFileName() {
    fun resolveImportTarget_rejectsNonLitertlm() {
    fun sanitizeImportFileName_stripsPathAndUnsafeChars() {
    }
class LocalModelImportTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
package com.inspiredandroid.kai.inference
}
