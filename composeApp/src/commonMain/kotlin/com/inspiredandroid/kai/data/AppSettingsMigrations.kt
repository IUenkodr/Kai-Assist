
                setInstanceBaseUrl(instance.instanceId, legacyBaseUrl)
            if (legacyBaseUrl.isNotBlank() && getInstanceBaseUrl(instance.instanceId).isBlank()) {
            instances.add(ServiceInstance(instanceId = service.id, serviceId = service.id))
            migrateString(legacySettings, service.apiKeyKey)
            migrateString(legacySettings, service.modelIdKey)
            setInstanceApiKey(instance.instanceId, legacyApiKey)
            setInstanceBaseUrl(instance.instanceId, ensureBaseUrlHasVersionPath(baseUrl))
            setInstanceCustomModelId(instance.instanceId, listModelId)
            setInstanceModelId(instance.instanceId, legacyModel)
            val legacyBaseUrl = getBaseUrl(service)
            }
        // use_custom_model defaults to false when the key is absent — no write needed.
        if (Service.fromId(instance.serviceId) != Service.OpenAICompatible) continue
        if (apiKey.isNotBlank()) {
        if (baseUrl.isNotBlank()) {
        if (instances.any { it.serviceId == service.id }) continue
        if (legacyApiKey.isNotBlank() && getInstanceApiKey(instance.instanceId).isBlank()) {
        if (legacyModel.isNotBlank() && getInstanceModelId(instance.instanceId).isBlank()) {
        if (listModelId.isNotBlank() && getInstanceCustomModelId(instance.instanceId).isBlank()) {
        if (service != Service.OpenAICompatible) continue
        if (service == Service.Free) continue
        if (service == Service.OpenAICompatible) {
        if (service.id in existingServiceIds) continue
        if (service.settingsKeyPrefix.isNotEmpty()) {
        instances.add(ServiceInstance(instanceId = currentService.id, serviceId = currentService.id))
        setConfiguredServiceInstances(instances)
        settings.putInt(key, legacy.getInt(key, 0))
        settings.putString(Service.OpenAICompatible.baseUrlKey, ensureBaseUrlHasVersionPath(legacyBaseUrl))
        settings.putString(key, value)
        val apiKey = getApiKey(service)
        val baseUrl = getInstanceBaseUrl(instance.instanceId)
        val legacyApiKey = getApiKey(service)
        val legacyModel = getSelectedModelId(service)
        val listModelId = getInstanceModelId(instance.instanceId)
        val service = Service.fromId(instance.serviceId)
        }
    for (instance in instances) {
    for (service in Service.all) {
    if (currentService != Service.Free && currentService.id !in existingServiceIds) {
    if (instances.size > existing.size) {
    if (legacy.hasKey(key) && !settings.hasKey(key)) {
    if (legacyBaseUrl.isNotBlank()) {
    if (legacySettings == null) return
    if (settings.getBoolean(KEY_BASE_URL_V1_MIGRATION_COMPLETE, false)) return
    if (settings.getBoolean(KEY_CUSTOM_MODEL_MIGRATION_COMPLETE, false)) return
    if (settings.getBoolean(KEY_INSTANCE_MIGRATION_COMPLETE, false)) return
    if (settings.getBoolean(KEY_MIGRATION_COMPLETE, false)) return
    if (settings.getBoolean(KEY_SERVICES_MIGRATION_COMPLETE, false)) return
    if (trimmed.contains(versionPathRegex)) return trimmed
    if (value != null && settings.getStringOrNull(key) == null) {
    migrateBaseUrlsToV1PathIfNeeded()
    migrateConfiguredServicesIfNeeded()
    migrateCustomModelSettingsIfNeeded()
    migrateFromLegacyIfNeeded(legacySettings)
    migrateInstanceSettingsIfNeeded()
    migrateInt(legacySettings, KEY_APP_OPENS)
    migrateString(legacySettings, KEY_CURRENT_SERVICE_ID)
    migrateString(legacySettings, Service.OpenAICompatible.baseUrlKey)
    return "$trimmed/v1"
    settings.putBoolean(KEY_BASE_URL_V1_MIGRATION_COMPLETE, true)
    settings.putBoolean(KEY_CUSTOM_MODEL_MIGRATION_COMPLETE, true)
    settings.putBoolean(KEY_INSTANCE_MIGRATION_COMPLETE, true)
    settings.putBoolean(KEY_MIGRATION_COMPLETE, true)
    settings.putBoolean(KEY_SERVICES_MIGRATION_COMPLETE, true)
    val currentService = Service.fromId(currentServiceId)
    val currentServiceId = settings.getString(KEY_CURRENT_SERVICE_ID, Service.Free.id)
    val existing = getConfiguredServiceInstances()
    val existingServiceIds = existing.map { it.serviceId }.toSet()
    val instances = existing.toMutableList()
    val instances = getConfiguredServiceInstances()
    val legacyBaseUrl = settings.getString(Service.OpenAICompatible.baseUrlKey, "")
    val trimmed = url.trimEnd('/')
    val value = legacy.getStringOrNull(key)
    }
 *
 * "Custom model" checkbox. List selection stays in `model_id`.
 * Existing installs only had `instance_*_model_id` (list selection or free-typed id).
 * For existing users, the first instance of each service type uses the service's
 * Migrate existing OpenAI-compatible base URLs to include `/v1` path segment.
 * Migrate per-service settings to per-instance settings.
 * Previously `/v1` was hardcoded in the endpoint paths; now the base URL should
 * Seeds OpenAI-Compatible custom-model fields introduced for free-text model entry.
 * This copies that value into `custom_model_id` as a prefill backup and leaves
 * `use_custom_model` off so chat behavior is unchanged until the user enables the
 * include it (following the OpenAI SDK convention).
 * legacy key prefix. This copies those values to the new instance_ keys.
 */
/**
fun AppSettings.migrateBaseUrlsToV1PathIfNeeded() {
fun AppSettings.migrateConfiguredServicesIfNeeded() {
fun AppSettings.migrateCustomModelSettingsIfNeeded() {
fun AppSettings.migrateFromLegacyIfNeeded(legacySettings: Settings?) {
fun AppSettings.migrateInstanceSettingsIfNeeded() {
fun AppSettings.runMigrations(legacySettings: Settings?) {
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_APP_OPENS
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_BASE_URL_V1_MIGRATION_COMPLETE
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CURRENT_SERVICE_ID
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CUSTOM_MODEL_MIGRATION_COMPLETE
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_INSTANCE_MIGRATION_COMPLETE
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_MIGRATION_COMPLETE
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_SERVICES_MIGRATION_COMPLETE
import com.russhwolf.settings.Settings
internal fun ensureBaseUrlHasVersionPath(url: String): String {
internal val versionPathRegex = Regex("/v\\d+$")
package com.inspiredandroid.kai.data
private fun AppSettings.migrateInt(legacy: Settings, key: String) {
private fun AppSettings.migrateString(legacy: Settings, key: String) {
}
