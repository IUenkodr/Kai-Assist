package com.inspiredandroid.kai.daemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DaemonViewModel(
    private val client: DaemonClient
) : ViewModel() {

    private val _skills = MutableStateFlow<SkillManifest?>(null)
    private val _tasks = MutableStateFlow<Map<String, KaiTask>>(emptyMap())

    val skills: StateFlow<SkillManifest?> = _skills.asStateFlow()
    val tasks: StateFlow<Map<String, KaiTask>> = _tasks.asStateFlow()

    init {
        startSyncLoop()
    }

    private fun startSyncLoop() {
        viewModelScope.launch {
            while (true) {
                try {
                    syncSkills()
                    syncTasks()
                } catch (_: Exception) {
                    // Keep the polling loop alive if the daemon is unavailable.
                }
                delay(2000)
            }
        }
    }

    private fun syncSkills() {
        val response = client.sendRequest(
            DaemonRequest(command = "get_skills")
        )

        if (response.status == "ok") {
            _skills.value = response.manifest
        }
    }

    private fun syncTasks() {
        val response = client.sendRequest(
            DaemonRequest(command = "list_tasks")
        )

        if (response.status == "ok") {
            _tasks.value = response.tasks ?: emptyMap()
        }
    }

    fun killTask(taskId: String) {
        viewModelScope.launch {
            try {
                client.sendRequest(
                    DaemonRequest(
                        command = "kill_task",
                        params = mapOf("task_id" to taskId)
                    )
                )
                syncTasks()
            } catch (_: Exception) {
                // Ignore transport errors; the next polling cycle retries.
            }
        }
    }
}
