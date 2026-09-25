
                                        expanded = false
                                        onClick(model.id)
                                    isSelected = currentSelectedModel?.id == model.id,
                                    model = model,
                                    onClick = {
                                    },
                                )
                                ModelCard(
                                else -> 2
                                model.subtitle.contains(searchQuery, ignoreCase = true) -> 1
                                name.contains(searchQuery, ignoreCase = true) -> 0
                            GridCells.Adaptive(300.dp),
                            contentPadding = PaddingValues(8.dp),
                            gridState = gridState,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            items(sortedModels, key = { it.id }) { model ->
                            label = { Text(stringResource(Res.string.model_filter_free)) },
                            label = { Text(stringResource(option.labelRes)) },
                            model.displayName?.contains(searchQuery, ignoreCase = true) == true
                            model.id.contains(searchQuery, ignoreCase = true) ||
                            model.subtitle.contains(searchQuery, ignoreCase = true) ||
                            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                            modifier = Modifier.handCursor(),
                            onClick = { freeFilterOnly = !freeFilterOnly },
                            onClick = { sortOption = option },
                            selected = freeFilterOnly,
                            selected = sortOption == option,
                            state = gridState,
                            val name = model.displayName ?: model.id
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            when {
                            }
                        )
                        ) {
                        FilterChip(
                        LazyVerticalGrid(
                        VerticalScrollbarForGrid(
                        base
                        base.sortedBy { model ->
                        color = MaterialTheme.colorScheme.onBackground,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        color = arenaScoreColor(score),
                        contentDescription = null,
                        imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                        matchesFree && matchesSearch
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.padding(24.dp),
                        onQueryChange = { searchQuery = it },
                        placeholder = stringResource(Res.string.settings_model_search),
                        query = searchQuery,
                        stringResource(Res.string.settings_model_label),
                        style = MaterialTheme.typography.bodyMedium,
                        style = MaterialTheme.typography.labelSmall,
                        text = "$score",
                        text = stringResource(Res.string.model_free_empty),
                        tint = MaterialTheme.colorScheme.onBackground,
                        val matchesFree = !freeFilterOnly || model.isFreeTier
                        val matchesSearch = searchQuery.isBlank() ||
                        }
                    )
                    .clickable { expanded = true },
                    .handCursor()
                    .matchParentSize()
                    Box {
                    FreeTierBadge(isSelected = isSelected)
                    Icon(
                    KaiSearchField(
                    ModelSortOption.entries.forEach { option ->
                    Spacer(Modifier.width(8.dp))
                    Text(
                    color = primaryColor,
                    color = secondaryColor,
                    expanded = false
                    gridState.requestScrollToItem(0)
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    if (!hasFreeModels) freeFilterOnly = false
                    if (hasFreeModels) {
                    if (searchQuery.isBlank()) {
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    pickerModels.filter { model ->
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.labelSmall,
                    style = MaterialTheme.typography.titleMedium,
                    text = it,
                    text = title,
                    val base = filteredModels.sortedWith(sortOption.comparator)
                    }
                    } else {
                )
                ) {
                // Reset free filter when the service has no free models.
                LaunchedEffect(hasFreeModels) {
                LaunchedEffect(sortOption, freeFilterOnly) {
                MaterialTheme.colorScheme.primaryContainer
                MaterialTheme.colorScheme.surfaceContainerHigh
                Row(
                Spacer(Modifier.height(6.dp))
                Text(
                if (model.isFreeTier) {
                if (pickerModels.size > 6) {
                if (sortedModels.isEmpty() && freeFilterOnly) {
                label = {
                model.arenaScore?.let { score ->
                modifier = Modifier
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = {
                onValueChange = {},
                readOnly = true,
                sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
                trailingIcon = {
                val filteredModels = remember(pickerModels, searchQuery, freeFilterOnly) {
                val gridState = rememberLazyGridState()
                val hasFreeModels = remember(pickerModels) { pickerModels.any { it.isFreeTier } }
                val sortedModels = remember(filteredModels, sortOption, searchQuery) {
                value = currentSelectedModel?.let { it.displayName ?: it.id } ?: "",
                var freeFilterOnly by remember { mutableStateOf(false) }
                var searchQuery by remember { mutableStateOf("") }
                var sortOption by remember { mutableStateOf(ModelSortOption.Score) }
                }
                } else {
                },
            )
            ) {
            // Transparent overlay to capture clicks reliably on all platforms
            Box(
            KaiOutlinedTextField(
            ModalBottomSheet(
            Row(verticalAlignment = Alignment.CenterVertically) {
            color = content,
            containerColor = if (isSelected) {
            detailText?.let {
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            modifier = Modifier.padding(16.dp),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            secondary?.let {
            style = MaterialTheme.typography.labelMedium,
            text = stringResource(Res.string.model_free_badge),
            }
            } else {
            },
        )
        ) {
        ),
        .joinToString("  ·  ").ifEmpty { null }
        Box(
        Color(0xFF1B5E20)
        Color.White
        Column(
        MaterialTheme.colorScheme.onPrimaryContainer
        MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
        MaterialTheme.colorScheme.onSurface
        MaterialTheme.colorScheme.onSurfaceVariant
        MaterialTheme.colorScheme.primaryContainer
        Text(
        color = background,
        colors = CardDefaults.cardColors(
        if (expanded) {
        modifier = Modifier.handCursor().clip(CardDefaults.shape).clickable { onClick() },
        shape = CardDefaults.shape,
        shape = RoundedCornerShape(4.dp),
        }
    ) {
    // Provider list only — synthetic manual entries stay out of the picker grid.
    Card(
    Ctx(Res.string.model_sort_context, compareByDescending<SettingsModel> { it.contextWindow }.thenBy { it.id }),
    Date(Res.string.model_sort_date, compareByDescending<SettingsModel> { it.releaseDate }.thenBy { it.id }),
    Score(Res.string.model_sort_score, compareByDescending<SettingsModel> { it.arenaScore }.thenBy { it.id }),
    Surface(
    currentSelectedModel: SettingsModel?,
    else -> Color(0xFFEF6C00)
    if (pickerModels.isNotEmpty()) {
    models: ImmutableList<SettingsModel>,
    onClick: (String) -> Unit,
    score >= 1250 -> Color(0xFFF9A825)
    score >= 1300 -> Color(0xFF9E9D24)
    score >= 1350 -> Color(0xFF558B2F)
    score >= 1400 -> Color(0xFF2E7D32)
    val background = if (isSelected) {
    val comparator: Comparator<SettingsModel>,
    val content = if (isSelected) {
    val contextText = model.contextWindow?.let { formatContextWindow(it) }
    val detailText = listOfNotNull(releaseText, model.parameterCount, contextText)
    val displayName = model.displayName?.takeIf { it.isNotBlank() && it != model.id }
    val labelRes: StringResource,
    val pickerModels = remember(models) { models.filter { !it.isManualEntry } }
    val primaryColor = if (isSelected) {
    val releaseText = model.releaseDate?.let { formatReleaseDate(it) }
    val secondary = if (displayName == null && model.subtitle.isNotBlank()) model.subtitle else null
    val secondaryColor = if (isSelected) {
    val title = displayName ?: model.id
    var expanded by remember { mutableStateOf(false) }
    }
    } else {
) {
@Composable
@OptIn(ExperimentalMaterial3Api::class)
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.formatContextWindow
import com.inspiredandroid.kai.formatReleaseDate
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.KaiSearchField
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForGrid
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_arrow_drop_down
import kai.composeapp.generated.resources.model_filter_free
import kai.composeapp.generated.resources.model_free_badge
import kai.composeapp.generated.resources.model_free_empty
import kai.composeapp.generated.resources.model_sort_context
import kai.composeapp.generated.resources.model_sort_date
import kai.composeapp.generated.resources.model_sort_score
import kai.composeapp.generated.resources.settings_model_label
import kai.composeapp.generated.resources.settings_model_search
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun ModelSelection(
package com.inspiredandroid.kai.ui.settings
private enum class ModelSortOption(
private fun FreeTierBadge(isSelected: Boolean) {
private fun ModelCard(model: SettingsModel, isSelected: Boolean, onClick: () -> Unit) {
private fun arenaScoreColor(score: Int): Color = when {
}
