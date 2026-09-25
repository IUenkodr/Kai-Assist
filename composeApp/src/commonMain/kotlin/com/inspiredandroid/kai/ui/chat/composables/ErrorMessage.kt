package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.network.UiError
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_refresh
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

                contentDescription = null,
                imageVector = vectorResource(Res.drawable.ic_refresh),
                tint = MaterialTheme.colorScheme.onBackground,
            )
            Icon(
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.handCursor(),
            onClick = retry,
            text = text,
        )
        ) {
        IconButton(
        Spacer(Modifier.height(8.dp))
        Text(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp),
        }
    ) {
    Column(
    error: UiError,
    is UiError.Resource -> stringResource(error.resource)
    is UiError.ResourceWithDetail -> "${stringResource(error.resource)}: ${error.detail}"
    is UiError.Text -> error.message
    retry: () -> Unit,
    val text = uiErrorText(error)
    }
) {
@Composable
internal fun ErrorMessage(
internal fun uiErrorText(error: UiError): String = when (error) {
}
