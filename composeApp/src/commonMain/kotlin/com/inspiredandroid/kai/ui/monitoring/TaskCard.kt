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

                
                    
                                if (task.status == "RUNNING") Color(0xFF4ADE80) else Color.Gray
                            )
                            .alpha(if (task.status == "RUNNING") pulseAlpha else 1f)
                            .background(
                            .clip(CircleShape)
                            .size(8.dp)
                        Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(16.dp))
                        Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Kill", fontSize = 12.sp)
                        Text("Logs", fontSize = 12.sp)
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                        modifier = Modifier
                        modifier = Modifier.handCursor(),
                        onClick = onAttach,
                        onClick = onKill,
                        style = MaterialTheme.typography.bodyMedium,
                        text = task.command,
                    )
                    ) {
                    // Live Pulse Dot
                    Box(
                    Spacer(Modifier.width(8.dp))
                    Text(
                    Text(task.status, fontSize = 10.sp)
                    TextButton(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                    containerColor = if (task.status == "RUNNING") Color(0xFF4ADE80).copy(alpha = 0.2f) else Color.Gray.copy(alpha = 0.2f),
                    contentColor = if (task.status == "RUNNING") Color(0xFF4ADE80) else Color.Gray
                    style = MaterialTheme.typography.labelSmall,
                    text = "Memory: ${mem / 1024} MB",
                    }
                )
                ) {
                Badge(
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                modifier = Modifier.fillMaxWidth(),
                val mem = task.metrics?.mem_kb ?: 0
                verticalAlignment = Alignment.CenterVertically
                verticalAlignment = Alignment.CenterVertically,
                }
            ) {
            .fillMaxWidth()
            .glassSurface(shape = RoundedCornerShape(20.dp)),
            // Metrics Row
            Row(
            animation = tween(1000, easing = LinearEasing),
            modifier = Modifier.padding(16.dp),
            repeatMode = RepeatMode.Reverse
            verticalArrangement = Arrangement.spacedBy(12.dp)
            }
        )
        ) {
        Column(
        animationSpec = infiniteRepeatable(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        initialValue = 0.3f,
        modifier = modifier
        targetValue = 1f,
        }
    )
    ) {
    // Animation for the "Live Pulse" dot
    Card(
    modifier: Modifier = Modifier
    onAttach: () -> Unit,
    onKill: () -> Unit,
    task: KaiTask,
    val infiniteTransition = rememberInfiniteTransition()
    val pulseAlpha by infiniteTransition.animateFloat(
    }
) {
@Composable
fun TaskCard(
}
