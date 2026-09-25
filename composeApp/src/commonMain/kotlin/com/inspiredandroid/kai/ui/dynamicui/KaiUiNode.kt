
    /** "single" (default), "multi", or "none" for display-only tags. */
    @Contextual val children: ImmutableList<KaiUiNode> = persistentListOf(),
    @Contextual val chips: ImmutableList<ChipItem> = persistentListOf(),
    @Contextual val headers: ImmutableList<String> = persistentListOf(),
    @Contextual val items: ImmutableList<KaiUiNode> = persistentListOf(),
    @Contextual val options: ImmutableList<String> = persistentListOf(),
    @Contextual val rows: ImmutableList<@Contextual ImmutableList<String>> = persistentListOf(),
    @Contextual val tabs: ImmutableList<TabItem> = persistentListOf(),
    @SerialName("body")
    @SerialName("caption")
    @SerialName("error")
    @SerialName("filled")
    @SerialName("headline")
    @SerialName("info")
    @SerialName("outlined")
    @SerialName("success")
    @SerialName("text")
    @SerialName("title")
    @SerialName("tonal")
    @SerialName("warning")
    BODY,
    CAPTION,
    ERROR,
    FILLED,
    HEADLINE,
    INFO,
    OUTLINED,
    SUCCESS,
    TEXT,
    TITLE,
    TONAL,
    WARNING,
    override val id: String = "",
    override val id: String? = null,
    val action: UiAction? = null,
    val alt: String? = null,
    val aspectRatio: Float? = null,
    val bold: Boolean? = null,
    val checked: Boolean? = null,
    val code: String = "",
    val color: String? = null,
    val contentAlignment: String? = null,
    val description: String? = null,
    val enabled: Boolean? = null,
    val expanded: Boolean? = null,
    val height: Int? = null,
    val id: String?
    val imageUrl: String? = null,
    val italic: Boolean? = null,
    val label: String = "",
    val label: String? = null,
    val language: String? = null,
    val max: Float? = null,
    val message: String = "",
    val min: Float? = null,
    val multiline: Boolean? = null,
    val name: String = "",
    val name: String? = null,
    val ordered: Boolean? = null,
    val placeholder: String? = null,
    val seconds: Int = 0,
    val selected: String? = null,
    val selectedIndex: Int? = null,
    val selection: String = "single",
    val severity: AlertSeverity? = null,
    val size: Int? = null,
    val source: String? = null,
    val step: Float? = null,
    val style: TextNodeStyle? = null,
    val text: String = "",
    val title: String = "",
    val title: String? = null,
    val url: String = "",
    val value: Float? = null,
    val value: String = "",
    val value: String? = null,
    val variant: ButtonVariant? = null,
)
) : KaiUiNode
// --- Content nodes (additional) ---
// --- Content nodes ---
// --- Data display nodes ---
// --- Display nodes ---
// --- Enums ---
// --- Feedback nodes ---
// --- Interactive nodes (additional) ---
// --- Interactive nodes ---
// --- Layout nodes (additional) ---
// --- Layout nodes ---
// --- Selection nodes ---
@Immutable
@SerialName("accordion")
@SerialName("alert")
@SerialName("avatar")
@SerialName("badge")
@SerialName("box")
@SerialName("button")
@SerialName("card")
@SerialName("checkbox")
@SerialName("chip_group")
@SerialName("code")
@SerialName("column")
@SerialName("countdown")
@SerialName("divider")
@SerialName("icon")
@SerialName("image")
@SerialName("list")
@SerialName("progress")
@SerialName("quote")
@SerialName("radio_group")
@SerialName("row")
@SerialName("select")
@SerialName("slider")
@SerialName("stat")
@SerialName("switch")
@SerialName("table")
@SerialName("tabs")
@SerialName("text")
@SerialName("text_input")
@Serializable
data class AccordionNode(
data class AlertNode(
data class AvatarNode(
data class BadgeNode(
data class BoxNode(
data class ButtonNode(
data class CardNode(
data class CheckboxNode(
data class ChipGroupNode(
data class ChipItem(
data class CodeNode(
data class ColumnNode(
data class CountdownNode(
data class DividerNode(
data class IconNode(
data class ImageNode(
data class ListNode(
data class ProgressNode(
data class QuoteNode(
data class RadioGroupNode(
data class RowNode(
data class SelectNode(
data class SliderNode(
data class StatNode(
data class SwitchNode(
data class TabItem(
data class TableNode(
data class TabsNode(
data class TextInputNode(
data class TextNode(
enum class AlertSeverity {
enum class ButtonVariant {
enum class TextNodeStyle {
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
package com.inspiredandroid.kai.ui.dynamicui
sealed interface KaiUiNode {
}
