package com.inspiredandroid.kai.ui.overlay
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier


@Composable
fun OverlayContent(viewModel: OverlayViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Kai-OS Command Hub", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Quick-Invoke Actions ready.")
    }
}
