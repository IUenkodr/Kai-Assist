
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                color = MaterialTheme.colorScheme.outlineVariant,
                maxLines = 2,
                onClick = { onSelect(skill) },
                overflow = TextOverflow.Ellipsis,
                shape = RoundedCornerShape(16.dp),
                skill = skill,
                style = MaterialTheme.typography.bodySmall,
                text = skill.description,
                width = 1.dp,
            )
            .background(MaterialTheme.colorScheme.surface)
            .border(
            .clickable { onClick() }
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .handCursor()
            .heightIn(max = 200.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
            SkillRow(
            Text(
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium,
            skills
            skills.filter { it.id.startsWith(q) || it.id.contains(q) }
            style = MaterialTheme.typography.bodyMedium,
            text = "/${skill.id}",
        )
        Text(
        for (skill in filtered) {
        if (q.isEmpty()) {
        if (skill.description.isNotEmpty()) {
        modifier = Modifier
        modifier = modifier
        val q = query.lowercase()
        }
        } else {
    ) {
    Column(
    if (filtered.isEmpty()) return
    modifier: Modifier = Modifier,
    onSelect: (SkillManifest) -> Unit,
    query: String,
    skills: ImmutableList<SkillManifest>,
    val filtered = remember(skills, query) {
    val scrollState = rememberScrollState()
    }
 * Drop-down list of skills shown above the chat composer when the user types `/`.
 * Selection replaces the leading `/<query>` token with `/<id> `, leaving the
 * cursor positioned for follow-up args.
 */
) {
/**
@Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.ui.handCursor
import kotlinx.collections.immutable.ImmutableList
internal fun SkillAutocomplete(
package com.inspiredandroid.kai.ui.chat.composables
private fun SkillRow(skill: SkillManifest, onClick: () -> Unit) {
}
