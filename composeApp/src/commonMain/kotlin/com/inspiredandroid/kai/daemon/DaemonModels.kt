package com.inspiredandroid.kai.daemon

import kotlinx.serialization.Serializable

@Serializable
data class KaiTask(
    val pid: Int,
    val command: String,
    val status: String,
    val startTime: String,
    val last_updated: String,
    val mem_kb: Int,
    val cpu_ticks: Long,
    val metrics: TaskMetrics? = null,
    val logs: String? = null,
    val message: String? = null,
    val manifest: SkillManifest? = null,
    val params: Map<String, String> = emptyMap(),
    val skills: List<String> = emptyList(),
    val task_id: String? = null
)

@Serializable
data class TaskMetrics(
    val cpu_usage: Double,
    val mem_usage: Double,
    val threads: Int
)

@Serializable
data class SkillManifest(
    val name: String,
    val version: String,
    val description: String
)

@Serializable
data class DaemonRequest(
    val action: String,
    val params: Map<String, String> = emptyMap()
)

@Serializable
data class DaemonResponse(
    val success: Boolean,
    val data: String? = null,
    val error: String? = null,
    val tasks: Map<String, KaiTask>? = null
)
