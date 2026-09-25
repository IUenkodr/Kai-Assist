import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

                _skills.value = resp.manifest
                _tasks.value = resp.tasks ?: emptyMap()
                command = "kill_task", 
                delay(2000) // Sync every 2 seconds
                params = mapOf("task_id" to taskId)
                syncSkills()
                syncTasks()
            ))
            // Log error
            client.sendRequest(DaemonRequest(
            if (resp.status == "ok") {
            syncTasks()
            val resp = client.sendRequest(DaemonRequest(command = "get_skills"))
            val resp = client.sendRequest(DaemonRequest(command = "list_tasks"))
            while (true) {
            }
        startSyncLoop()
        try {
        viewModelScope.launch {
        }
        } catch (e: Exception) {
    fun killTask(taskId: String) {
    init {
    private fun startSyncLoop() {
    private fun syncSkills() {
    private fun syncTasks() {
    private val _skills = MutableStateFlow<SkillManifest?>(null)
    private val _tasks = MutableStateFlow<Map<String, KaiTask>>(emptyMap())
    val skills: StateFlow<SkillManifest?> = _skills.asStateFlow()
    val tasks: StateFlow<Map<String, KaiTask>> = _tasks.asStateFlow()
    }
class DaemonViewModel(private val client: DaemonClient) : ViewModel() {
package com.inspiredandroid.kai.daemon
}
