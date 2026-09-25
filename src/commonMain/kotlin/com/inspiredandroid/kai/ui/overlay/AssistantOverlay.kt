package com.inspiredandroid.kai.ui.overlay
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import com.inspiredandroid.kai.ui.overlay.OverlayContent


@Composable
fun AssistantOverlay(viewModel: OverlayViewModel) {
    var state by remember { mutableStateOf(OverlayState.COLLAPSED) }
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(if(state == OverlayState.FULL) 1.f else 0.3f)
        ) {
            OverlayContent(viewModel)
        }
    }
}
enum class OverlayState { COLLAPSED, PARTIAL, FULL }
