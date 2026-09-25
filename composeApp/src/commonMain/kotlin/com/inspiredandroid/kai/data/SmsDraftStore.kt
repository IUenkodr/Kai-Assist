package com.inspiredandroid.kai.data
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.serializer

            current.map { draft -> if (draft.id == id) draft.copy(status = status, lastError = error) else draft }
            if (existing.status == status && existing.lastError == error) return@update current
            val existing = current.find { it.id == id } ?: return@update current
        // Cap at MAX_DRAFTS — oldest dropped, protecting against runaway AI.
        // Every write mirrors into the flow the review banner observes, so reads below can stay
        // in memory.
        _drafts.value = persisted.get()
        itemSerializer = serializer<SmsDraft>(),
        label = "SmsDraftStore",
        onWrite = { _drafts.value = it },
        persisted.update { (it + draft).takeLast(MAX_DRAFTS) }
        persisted.update { current ->
        persisted.update { current -> current.filterNot { it.id == id } }
        private const val MAX_DRAFTS = 20
        read = appSettings::getSmsDraftsJson,
        write = appSettings::setSmsDraftsJson,
        }
    )
    companion object {
    fun getDraft(id: String): SmsDraft? = _drafts.value.find { it.id == id }
    fun getPending(): List<SmsDraft> = _drafts.value.filter { it.status == SmsDraftStatus.PENDING }
    init {
    private val _drafts = MutableStateFlow<List<SmsDraft>>(emptyList())
    private val persisted = SettingsJsonList(
    suspend fun addDraft(draft: SmsDraft) {
    suspend fun removeDraft(id: String) {
    suspend fun updateStatus(id: String, status: SmsDraftStatus, error: String? = null) {
    val drafts: StateFlow<List<SmsDraft>> = _drafts.asStateFlow()
    }
class SmsDraftStore(appSettings: AppSettings) {
}
