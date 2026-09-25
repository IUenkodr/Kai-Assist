package com.inspiredandroid.kai.daemon

import kotlinx.serialization.Serializable

@Serializable
data class DaemonRequest(
    val command: String,
    val params: Map<String, String> = emptyMap()
)

@Serializable
data class DaemonResponse(
    val status: String,
    val message: String? = null,
    val manifest: SkillManifest? = null,
    val tasks: Map<String, KaiTask>? = null
)

@Serializable
data class KaiTask(
    val task_id: String? = null,
    val pid: Int? = null,
    val command: String,
    val status: String,
    val metrics: TaskMetrics? = null,
    val logs: String? = null
)

@Serializable
data class SkillManifest(
    val skills: List<String> = emptyList()
)

@Serializable
data class TaskMetrics(
    val cpu_ticks: Long = 0,
    val mem_kb: Int = 0,
    val last_updated: String = ""
)
