
                    "instanceId" to JsonPrimitive(instance.instanceId),
                    "serviceId" to JsonPrimitive(instance.serviceId),
                    instanceId = element["instanceId"]?.jsonPrimitive?.content ?: "",
                    serviceId = element["serviceId"]?.jsonPrimitive?.content ?: "",
                )
                ),
                ServiceInstance(
                ServiceInstance(instanceId = id, serviceId = id)
                mapOf(
                val id = element.jsonPrimitive.content
            )
            JsonObject(
            if (element is JsonObject) {
            }
            } else {
        array.map { element ->
        emptyList()
        instances.map { instance ->
        settings.putString(service.apiKeyKey, apiKey)
        settings.putString(service.baseUrlKey, baseUrl)
        val array = Json.parseToJsonElement(json).jsonArray
        },
        }.filter { it.instanceId.isNotBlank() && it.serviceId.isNotBlank() }
    ""
    )
    Service.OpenAICompatible -> settings.getString(service.baseUrlKey, Service.DEFAULT_OPENAI_COMPATIBLE_BASE_URL)
    else -> ""
    getInstanceCustomModelId(instanceId)
    getInstanceModelId(instanceId)
    if (json.isBlank()) return emptyList()
    if (service == Service.OpenAICompatible) {
    if (service.requiresApiKey || service.supportsOptionalApiKey) {
    if (serviceId !in existingIds) return serviceId
    return "${serviceId}_$counter"
    return Service.fromId(id)
    return try {
    settings.getString(service.apiKeyKey, "")
    settings.putBoolean("instance_${instanceId}_use_custom_model", useCustom)
    settings.putString("instance_${instanceId}_api_key", apiKey)
    settings.putString("instance_${instanceId}_base_url", baseUrl)
    settings.putString("instance_${instanceId}_custom_model_id", modelId)
    settings.putString("instance_${instanceId}_model_id", modelId)
    settings.putString(KEY_CONFIGURED_SERVICES, jsonArray.toString())
    settings.putString(KEY_CURRENT_SERVICE_ID, service.id)
    settings.remove("instance_${instanceId}_api_key")
    settings.remove("instance_${instanceId}_base_url")
    settings.remove("instance_${instanceId}_custom_model_id")
    settings.remove("instance_${instanceId}_model_id")
    settings.remove("instance_${instanceId}_use_custom_model")
    val existing = getConfiguredServiceInstances()
    val existingIds = existing.map { it.instanceId }.toSet()
    val id = settings.getString(KEY_CURRENT_SERVICE_ID, Service.Free.id)
    val json = settings.getString(KEY_CONFIGURED_SERVICES, "")
    val jsonArray = kotlinx.serialization.json.JsonArray(
    var counter = 2
    while ("${serviceId}_$counter" in existingIds) counter++
    }
    } catch (_: Exception) {
 * Falls back to empty string when neither is set (caller may apply service defaults).
 * Model id sent to the provider: custom free-text when enabled, otherwise the list selection.
 */
/**
/** When true, chat uses [getInstanceCustomModelId] instead of the list selection in [getInstanceModelId]. */
// API Keys
// Base URL (for self-hosted services like OpenAI-compatible APIs)
// Configured services (ordered list of service instances)
// Model selection
// Per-instance settings (API key, model, base URL)
// Service selection
fun AppSettings.currentService(): Service {
fun AppSettings.generateInstanceId(serviceId: String): String {
fun AppSettings.getApiKey(service: Service): String = if (service.requiresApiKey || service.supportsOptionalApiKey) {
fun AppSettings.getBaseUrl(service: Service): String = when (service) {
fun AppSettings.getConfiguredServiceInstances(): List<ServiceInstance> {
fun AppSettings.getInstanceApiKey(instanceId: String): String = settings.getString("instance_${instanceId}_api_key", "")
fun AppSettings.getInstanceBaseUrl(instanceId: String): String = settings.getString("instance_${instanceId}_base_url", "")
fun AppSettings.getInstanceCustomModelId(instanceId: String): String = settings.getString("instance_${instanceId}_custom_model_id", "")
fun AppSettings.getInstanceEffectiveModelId(instanceId: String): String = if (getInstanceUseCustomModel(instanceId)) {
fun AppSettings.getInstanceModelId(instanceId: String): String = settings.getString("instance_${instanceId}_model_id", "")
fun AppSettings.getInstanceUseCustomModel(instanceId: String): Boolean = settings.getBoolean("instance_${instanceId}_use_custom_model", false)
fun AppSettings.getSelectedModelId(service: Service): String = settings.getString(service.modelIdKey, service.defaultModel ?: "")
fun AppSettings.removeInstanceSettings(instanceId: String) {
fun AppSettings.selectService(service: Service) {
fun AppSettings.setApiKey(service: Service, apiKey: String) {
fun AppSettings.setBaseUrl(service: Service, baseUrl: String) {
fun AppSettings.setConfiguredServiceInstances(instances: List<ServiceInstance>) {
fun AppSettings.setInstanceApiKey(instanceId: String, apiKey: String) {
fun AppSettings.setInstanceBaseUrl(instanceId: String, baseUrl: String) {
fun AppSettings.setInstanceCustomModelId(instanceId: String, modelId: String) {
fun AppSettings.setInstanceModelId(instanceId: String, modelId: String) {
fun AppSettings.setInstanceUseCustomModel(instanceId: String, useCustom: Boolean) {
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CONFIGURED_SERVICES
import com.inspiredandroid.kai.data.AppSettings.Companion.KEY_CURRENT_SERVICE_ID
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
package com.inspiredandroid.kai.data
}
} else {
