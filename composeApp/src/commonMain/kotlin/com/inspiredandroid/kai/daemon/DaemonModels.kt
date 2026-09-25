package com.inspiredandroid.kai.daemon
import kotlinx.serialization.Serializable

    val command: String,
    val cpu_ticks: Long
    val last_updated: String,
    val logs: String? = null
    val manifest: SkillManifest? = null,
    val mem_kb: Int,
    val message: String? = null,
    val metrics: TaskMetrics? = null
    val params: Map<String, String> = emptyMap()
    val pid: Int,
    val pid: Int? = null,
    val skills: List<String>
    val startTime: String,
    val status: String,
    val task_id: String? = null,
    val tasks: Map<String, KaiTask>? = null,
)
@Serializable
data class DaemonRequest(
data class DaemonResponse(
data class KaiTask(
data class SkillManifest(
data class TaskMetrics(
