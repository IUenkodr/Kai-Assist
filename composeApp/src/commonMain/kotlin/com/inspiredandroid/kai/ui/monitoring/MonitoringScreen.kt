import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.daemon.DaemonViewModel
import com.inspiredandroid.kai.ui.glassSurface

            
                            modifier = Modifier.fillMaxWidth()
                            onAttach = { selectedTaskId = id },
                            onKill = { viewModel.killTask(id) },
                            task = task,
                        "No background tasks active",
                        )
                        TaskCard(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    .background(Color.Black.copy(alpha = 0.8f))
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .padding(12.dp)
                    .weight(1f)
                    Text(
                    color = Color(0xFF00FF00), // Classic Terminal Green
                    contentAlignment = Alignment.Center
                    contentPadding = PaddingValues(bottom = 80.dp)
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                    fontSize = 12.sp
                    items(tasks.toList()) { (id, task) ->
                    modifier = Modifier.fillMaxSize(),
                    text = logs,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    }
                "Terminal Output: $taskId",
                )
                ) {
                .fillMaxWidth()
                .padding(top = 40.dp),
                .weight(1f)
                Box(
                LazyColumn(
                Text(
                Text("Close")
                color = MaterialTheme.colorScheme.primary
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                modifier = Modifier.align(Alignment.End).padding(top = 16.dp),
                modifier = Modifier.padding(bottom = 8.dp)
                onClick = onClose,
                onClose = { selectedTaskId = null }
                shape = RoundedCornerShape(12.dp)
                style = MaterialTheme.typography.headlineMedium,
                style = MaterialTheme.typography.titleSmall,
                taskId = selectedTaskId!!,
                text = "Command Center",
                viewModel = viewModel,
                }
            )
            ) {
            .fillMaxSize()
            .glassSurface(alpha = 0.8f)
            .padding(16.dp),
            .padding(24.dp),
            // For now we'll simulate the flow
            // Logic to call viewModel.getLogs(taskId)
            Box(
            Button(
            LogViewerOverlay(
            Text(
            horizontalAlignment = Alignment.CenterHorizontally,
            if (tasks.isEmpty()) {
            kotlinx.coroutines.delay(1000)
            logs = "Streaming logs for $taskId...\n[System] PTY attached\n[Daemon] Reading output..."
            modifier = Modifier
            verticalArrangement = Arrangement.Bottom
            verticalArrangement = Arrangement.spacedBy(20.dp)
            }
            } else {
        ) {
        // Log Viewer Overlay
        Column(
        contentAlignment = Alignment.BottomCenter
        contentAlignment = Alignment.TopCenter
        if (selectedTaskId != null) {
        modifier = Modifier
        while (true) {
        }
    ) {
    // In a real app, we would use a separate flow for logs to avoid 
    // polling the entire task list.
    Box(
    LaunchedEffect(taskId) {
    onBack: () -> Unit
    onClose: () -> Unit
    taskId: String,
    val tasks by viewModel.tasks.collectAsState()
    var logs by remember { mutableStateOf("Loading logs...") }
    var selectedTaskId by remember { mutableStateOf<String?>(null) }
    viewModel: DaemonViewModel,
    }
) {
@Composable
fun LogViewerOverlay(
fun MonitoringScreen(
package com.inspiredandroid.kai.ui.monitoring
}
