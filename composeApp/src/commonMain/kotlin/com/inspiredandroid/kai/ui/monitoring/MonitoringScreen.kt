package com.inspiredandroid.kai.ui.monitoring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.inspiredandroid.kai.daemon.DaemonViewModel
import com.inspiredandroid.kai.ui.glassSurface
import kotlinx.coroutines.delay

@Composable
fun MonitoringScreen(
    viewModel: DaemonViewModel,
    modifier: Modifier = Modifier
) {
    val tasks by viewModel.tasks.collectAsState()
    var selectedTaskId by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .glassSurface(alpha = 0.8f)
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Command Center",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            if (tasks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No background tasks active",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(tasks.toList()) { (id, task) ->
                        TaskCard(
                            task = task,
                            modifier = Modifier.fillMaxWidth(),
                            onAttach = { selectedTaskId = id },
                            onKill = { viewModel.killTask(id) }
                        )
                    }
                }
            }
        }

        selectedTaskId?.let { taskId ->
            LogViewerOverlay(
                taskId = taskId,
                onClose = { selectedTaskId = null }
            )
        }
    }
}

@Composable
private fun LogViewerOverlay(
    taskId: String,
    onClose: () -> Unit
) {
    var logs by remember(taskId) {
        mutableStateOf("Loading logs...")
    }

    LaunchedEffect(taskId) {
        delay(1_000)
        logs = "Streaming logs for $taskId...\n" +
            "[System] PTY attached\n" +
            "[Daemon] Reading output..."
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.8f))
            .clip(RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = logs,
                modifier = Modifier.weight(1f),
                color = Color(0xFF00FF00),
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )

            Button(
                onClick = onClose,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Close")
            }
        }
    }
}
