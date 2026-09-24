package com.inspiredandroid.kai.ui.monitoring

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inspiredandroid.kai.daemon.KaiTask
import com.inspiredandroid.kai.ui.glassSurface
import com.inspiredandroid.kai.ui.handCursor

@Composable
fun TaskCard(
    task: KaiTask,
    onKill: () -> Unit,
    onAttach: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Animation for the "Live Pulse" dot
    val infiniteTransition = rememberInfiniteTransition()
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .glassSurface(shape = RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Live Pulse Dot
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(
                                if (task.status == "RUNNING") Color(0xFF4ADE80) else Color.Gray
                            )
                            .alpha(if (task.status == "RUNNING") pulseAlpha else 1f)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = task.command,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
                
                Badge(
                    containerColor = if (task.status == "RUNNING") Color(0xFF4ADE80).copy(alpha = 0.2f) else Color.Gray.copy(alpha = 0.2f),
                    contentColor = if (task.status == "RUNNING") Color(0xFF4ADE80) else Color.Gray
                ) {
                    Text(task.status, fontSize = 10.sp)
                }
            }

            // Metrics Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val mem = task.metrics?.mem_kb ?: 0
                Text(
                    text = "Memory: ${mem / 1024} MB",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextButton(
                        onClick = onAttach,
                        modifier = Modifier.handCursor(),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Logs", fontSize = 12.sp)
                    }
                    
                    TextButton(
                        onClick = onKill,
                        modifier = Modifier.handCursor(),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Kill", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
