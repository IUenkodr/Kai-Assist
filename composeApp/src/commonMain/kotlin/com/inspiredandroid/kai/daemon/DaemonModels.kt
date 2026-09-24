package com.inspiredandroid.kai.daemon

import kotlinx.serialization.Serializable

@Serializable
data class KaiTask(
    val pid: Int,
    val command: String,
    val startTime: String,
    val status: String,
    val metrics: TaskMetrics? = null
)

@Serializable
data class TaskMetrics(
    val mem_kb: Int,
    val cpu_ticks: Long
)

@Serializable
data class SkillManifest(
    val last_updated: String,
    val skills: List<String>
)

@Serializable
data class DaemonRequest(
    val command: String,
    val params: Map<String, String> = emptyMap()
)

@Serializable
data class DaemonResponse(
    val status: String,
    val message: String? = null,
    val task_id: String? = null,
    val pid: Int? = null,
    val tasks: Map<String, KaiTask>? = null,
    val manifest: SkillManifest? = null,
    val logs: String? = null
)
