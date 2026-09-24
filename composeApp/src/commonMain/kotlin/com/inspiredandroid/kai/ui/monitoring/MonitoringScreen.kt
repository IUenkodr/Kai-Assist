package com.inspiredandroid.kai.ui.monitoring

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

@Composable
fun MonitoringScreen(
    viewModel: DaemonViewModel,
    onBack: () -> Unit
) {
    val tasks by viewModel.tasks.collectAsState()
    var selectedTaskId by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Command Center",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            
            if (tasks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "No background tasks active",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(tasks.toList()) { (id, task) ->
                        TaskCard(
                            task = task,
                            onKill = { viewModel.killTask(id) },
                            onAttach = { selectedTaskId = id },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        // Log Viewer Overlay
        if (selectedTaskId != null) {
            LogViewerOverlay(
                taskId = selectedTaskId!!,
                viewModel = viewModel,
                onClose = { selectedTaskId = null }
            )
        }
    }
}

@Composable
fun LogViewerOverlay(
    taskId: String,
    viewModel: DaemonViewModel,
    onClose: () -> Unit
) {
    // In a real app, we would use a separate flow for logs to avoid 
    // polling the entire task list.
    var logs by remember { mutableStateOf("Loading logs...") }

    LaunchedEffect(taskId) {
        while (true) {
            // Logic to call viewModel.getLogs(taskId)
            // For now we'll simulate the flow
            logs = "Streaming logs for $taskId...\n[System] PTY attached\n[Daemon] Reading output..."
            kotlinx.coroutines.delay(1000)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .glassSurface(alpha = 0.8f)
            .padding(24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                "Terminal Output: $taskId",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black.copy(alpha = 0.8f))
                    .padding(12.dp)
            ) {
                Text(
                    text = logs,
                    color = Color(0xFF00FF00), // Classic Terminal Green
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                    fontSize = 12.sp
                )
            }
            
            Button(
                onClick = onClose,
                modifier = Modifier.align(Alignment.End).padding(top = 16.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Close")
            }
        }
    }
}
