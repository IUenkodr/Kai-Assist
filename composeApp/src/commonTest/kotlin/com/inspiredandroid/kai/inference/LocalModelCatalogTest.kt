
                "${model.id} default context ${model.defaultContextTokens} must fit in ${model.maxContextTokens}",
                "${model.id} must not pin a moving branch",
                "/resolve/main/" !in model.downloadUrl,
                model.defaultContextTokens in 1..model.maxContextTokens,
            """^https://huggingface\.co/litert-community/([^/]+)/resolve/([0-9a-f]{40})/(.+)$""",
            )
            LocalSamplerDefaults(temperature = 1.0f, topK = 64, topP = 0.95f),
            assertEquals(model.fileName, match?.groupValues?.get(3), model.id)
            assertTrue(
            assertTrue(hex64.matches(model.sha256), "${model.id} sha256 must be 64 lowercase hex")
            assertTrue(match != null, "${model.id} URL must be litert-community resolve/<commit>/<file>")
            assertTrue(model.downloadUrl.isNotBlank(), model.id)
            assertTrue(model.sizeBytes > 0L, model.id)
            localSamplerDefaultsOrNull(temperature = 1.0f, topK = 64, topP = 0.95f),
            val match = hfResolve.matchEntire(model.downloadUrl)
        )
        // A model whose export tops out at its own default (LFM2.5) has no headroom for a
        // Two entries sharing a file name would collide in the imports/catalog path
        // resolution and each would take over the other's digest marker.
        // typo to hide in: the settings slider would offer a size the engine refuses.
        Regex(
        assertEquals(
        assertEquals(fileNames.distinct(), fileNames)
        assertEquals(ids.distinct(), ids)
        assertEquals(null, localSamplerDefaultsOrNull(temperature = 0.8f, topK = 0, topP = 0.95f))
        assertEquals(null, localSamplerDefaultsOrNull(temperature = 0f, topK = 0, topP = 0f))
        assertEquals(null, localSamplerDefaultsOrNull(temperature = 0f, topK = 40, topP = 0.95f))
        assertNotEquals(0, MODEL_CATALOG.count { it.isRecommended })
        assertTrue(MODEL_CATALOG.isNotEmpty())
        for (model in MODEL_CATALOG) {
        val fileNames = MODEL_CATALOG.map { it.fileName }
        val ids = MODEL_CATALOG.map { it.id }
        }
    @Test
    fun catalogContextDefaultsFitInsideTheirMaximum() {
    fun catalogFileNamesAreDistinct() {
    fun catalogPinsImmutableHuggingFaceCommits() {
    fun recommendedModelIsInCatalog() {
    fun samplerDefaultsTreatUndeclaredValuesAsNoOpinion() {
    private val hex64 = Regex("^[0-9a-f]{64}$")
    private val hfResolve =
    }
class LocalModelCatalogTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue
package com.inspiredandroid.kai.inference
}
