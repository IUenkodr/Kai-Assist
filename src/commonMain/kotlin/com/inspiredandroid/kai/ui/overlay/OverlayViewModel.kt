package com.inspiredandroid.kai.ui.overlay

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OverlayViewModel : ViewModel() {
    private val _state = MutableStateFlow(OverlayState.COLLAPSED)
    val state = _state.asStateFlow()
    fun updateState(newState: OverlayState) { _state.value = newState }
}
