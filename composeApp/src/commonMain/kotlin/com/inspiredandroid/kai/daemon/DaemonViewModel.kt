package com.inspiredandroid.kai.daemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class DaemonViewModel(private val client: DaemonClient) : ViewModel() {
    private val _tasks = MutableStateFlow<Map<String, KaiTask>>(emptyMap())
    val tasks: StateFlow<Map<String, KaiTask>> = _tasks.asStateFlow()

    private val _skills = MutableStateFlow<SkillManifest?>(null)
    val skills: StateFlow<SkillManifest?> = _skills.asStateFlow()

    init {
        startSyncLoop()
    }

    private fun startSyncLoop() {
        viewModelScope.launch {
            while (true) {
                syncTasks()
                syncSkills()
                delay(2000) // Sync every 2 seconds
            }
        }
    }

    private fun syncTasks() {
        try {
            val resp = client.sendRequest(DaemonRequest(command = "list_tasks"))
            if (resp.status == "ok") {
                _tasks.value = resp.tasks ?: emptyMap()
            }
        } catch (e: Exception) {
            // Log error
        }
    }

    private fun syncSkills() {
        try {
            val resp = client.sendRequest(DaemonRequest(command = "get_skills"))
            if (resp.status == "ok") {
                _skills.value = resp.manifest
            }
        } catch (e: Exception) {
            // Log error
        }
    }

    fun killTask(taskId: String) {
        viewModelScope.launch {
            client.sendRequest(DaemonRequest(
                command = "kill_task", 
                params = mapOf("task_id" to taskId)
            ))
            syncTasks()
        }
    }
}
