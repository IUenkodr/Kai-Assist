package com.inspiredandroid.kai.network.tools
import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

     *
     * False for tools whose availability is decided somewhere else — a master toggle in
     * Settings → Agent, or a platform capability check. Those tools still have to be
     * Whether the Tools tab shows a per-tool switch for this tool.
     * be dead UI: nothing reads it.
     * declared so chat can resolve a display name for them, but offering a switch would
     */
    /**
    val description: String,
    val descriptionRes: StringResource? = null,
    val id: String,
    val isEnabled: Boolean = true,
    val name: String,
    val nameRes: StringResource? = null,
    val userToggleable: Boolean = true,
 * Represents tool information for display in settings.
 * This is decoupled from the Tool interface to allow showing tools
 * even on platforms that don't implement them.
 */
)
/**
@Immutable
data class ToolInfo(
