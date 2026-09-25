package com.inspiredandroid.kai.ui.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor

                    Icon(Icons.Filled.Clear, contentDescription = clearContentDescription)
                    modifier = Modifier.handCursor(),
                    onClick = { onQueryChange("") },
                ) {
                IconButton(
                }
            disabledBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            null
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            {
            }
        ),
        colors = OutlinedTextFieldDefaults.colors(
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
        onValueChange = onQueryChange,
        placeholder = { Text(placeholder) },
        shape = RoundedCornerShape(28.dp),
        singleLine = true,
        trailingIcon = if (query.isNotEmpty()) {
        value = query,
        } else {
        },
    )
    OutlinedTextField(
    clearContentDescription: String? = null,
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit,
    placeholder: String,
    query: String,
) {
@Composable
fun KaiSearchField(
}
