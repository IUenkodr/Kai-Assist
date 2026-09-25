package com.inspiredandroid.kai.ui.canvas

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*

@Composable
fun CanvasContainer() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("AI-Canvas Spatial Workspace", modifier = Modifier.align(Alignment.Center))
    }
}
