package com.inspiredandroid.kai.ui.canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
package com.inspiredandroid.kai.ui.canvas


@Composable
fun DraggableCanvasCard(obj: CanvasObject) {
    Card(modifier = Modifier.padding(8.dp)) {
        Text("Canvas Object ${obj.id}", modifier = Modifier.padding(16.dp))
    }
}
