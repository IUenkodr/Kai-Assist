import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

            listOf(ServiceInstance("compat1", "openai-compatible")),
            listOf(ServiceInstance("openai", "openai")),
        )
        // Don't set a base URL — it should remain blank
        // First run — migrates and adds the service
        // Reset to a plain URL — second run should NOT migrate
        // Second run is a no-op
        // Second run — flag prevents re-migration, deleted service stays deleted
        // Set up a legacy API key for OpenAI
        // Should not be modified
        // User deletes the service
        appSettings.migrateBaseUrlsToV1PathIfNeeded()
        appSettings.migrateConfiguredServicesIfNeeded()
        appSettings.migrateCustomModelSettingsIfNeeded()
        appSettings.removeInstanceSettings(Service.OpenAI.id)
        appSettings.removeInstanceSettings(id)
        appSettings.setApiKey(Service.Gemini, "gemini-key")
        appSettings.setApiKey(Service.OpenAI, "sk-test-key")
        appSettings.setBaseUrl(Service.OpenAICompatible, "http://localhost:11434")
        appSettings.setConfiguredServiceInstances(
        appSettings.setConfiguredServiceInstances(emptyList())
        appSettings.setInstanceApiKey(instanceId, "sk-ant-test-key")
        appSettings.setInstanceBaseUrl("compat1", "http://localhost:11434")
        appSettings.setInstanceBaseUrl("compat1", "http://localhost:11434/")
        appSettings.setInstanceBaseUrl("compat1", "http://localhost:11434/v1")
        appSettings.setInstanceBaseUrl("compat1", "http://other-host:8080")
        appSettings.setInstanceBaseUrl("compat1", "https://my-provider.com/api/v1")
        appSettings.setInstanceBaseUrl("openai", "https://api.openai.com")
        appSettings.setInstanceCustomModelId("compat1", "other")
        appSettings.setInstanceCustomModelId(id, "custom")
        appSettings.setInstanceCustomModelId(id, "glm-4.7-flash")
        appSettings.setInstanceModelId("compat1", "my-local-model")
        appSettings.setInstanceModelId(id, "listed")
        appSettings.setInstanceModelId(id, "listed-model")
        appSettings.setInstanceModelId(instanceId, "claude-sonnet-4-20250514")
        appSettings.setInstanceUseCustomModel(id, false)
        appSettings.setInstanceUseCustomModel(id, true)
        assertEquals("", appSettings.getInstanceBaseUrl("compat1"))
        assertEquals("", appSettings.getInstanceCustomModelId(id))
        assertEquals("", appSettings.getInstanceModelId(id))
        assertEquals("anthropic", instanceId)
        assertEquals("claude-sonnet-4-20250514", appSettings.getInstanceModelId(instanceId))
        assertEquals("glm-4.7-flash", appSettings.getInstanceEffectiveModelId(id))
        assertEquals("http://localhost:11434/v1", appSettings.getBaseUrl(Service.OpenAICompatible))
        assertEquals("http://localhost:11434/v1", appSettings.getInstanceBaseUrl("compat1"))
        assertEquals("http://other-host:8080", appSettings.getInstanceBaseUrl("compat1"))
        assertEquals("https://api.openai.com", appSettings.getInstanceBaseUrl("openai"))
        assertEquals("https://my-provider.com/api/v1", appSettings.getInstanceBaseUrl("compat1"))
        assertEquals("listed-model", appSettings.getInstanceEffectiveModelId(id))
        assertEquals("my-local-model", appSettings.getInstanceCustomModelId("compat1"))
        assertEquals("my-local-model", appSettings.getInstanceEffectiveModelId("compat1"))
        assertEquals("my-local-model", appSettings.getInstanceModelId("compat1"))
        assertEquals("other", appSettings.getInstanceCustomModelId("compat1"))
        assertEquals("sk-ant-test-key", appSettings.getInstanceApiKey(instanceId))
        assertEquals(1, appSettings.getConfiguredServiceInstances().size)
        assertEquals(2, instances.size)
        assertEquals(Service.OpenAI.id, appSettings.getConfiguredServiceInstances()[0].serviceId)
        assertFalse(appSettings.getInstanceUseCustomModel("compat1"))
        assertFalse(appSettings.getInstanceUseCustomModel(id))
        assertFalse(settings.getBoolean("base_url_v1_migration_complete", false))
        assertTrue(appSettings.getConfiguredServiceInstances().isEmpty())
        assertTrue(instances.any { it.serviceId == Service.Gemini.id })
        assertTrue(instances.any { it.serviceId == Service.OpenAI.id })
        assertTrue(settings.getBoolean("base_url_v1_migration_complete", false))
        val appSettings = AppSettings(MapSettings())
        val appSettings = AppSettings(settings)
        val id = "compat1"
        val instanceId = appSettings.generateInstanceId(Service.Anthropic.id)
        val instances = appSettings.getConfiguredServiceInstances()
        val settings = MapSettings()
    // endregion
    // region Base URL v1 migration
    // region Custom model
    @Test
    fun `Anthropic credential persistence via instance settings`() {
    fun `base URL migration also migrates legacy per-service key`() {
    fun `base URL migration appends v1 to plain host URL`() {
    fun `base URL migration does not double-append v1`() {
    fun `base URL migration handles trailing slash`() {
    fun `base URL migration only runs once`() {
    fun `base URL migration preserves custom version path`() {
    fun `base URL migration skips blank base URLs`() {
    fun `base URL migration skips non-OpenAI-compatible instances`() {
    fun `custom model migration prefills custom id from list model without enabling flag`() {
    fun `effective model id uses custom when flag is on`() {
    fun `migration adds services with legacy API keys`() {
    fun `migration only runs once so deleted services stay deleted`() {
    fun `removeInstanceSettings clears custom model keys`() {
    }
class AppSettingsTest {
package com.inspiredandroid.kai.data
}
