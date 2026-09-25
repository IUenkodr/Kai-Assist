import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.longOrNull

                ChipItem(label = item.content, value = item.content)
                ChipItem(label = label, value = value)
                TabItem(label = item.content, children = persistentListOf())
                TextNode(value = obj.readString("subtitle"), style = TextNodeStyle.CAPTION),
                TextNode(value = obj.readString("title"), style = TextNodeStyle.TITLE),
                children = item.readNodeList("children"),
                label = item.readString("label"),
                null
                val label = item.readString("label")
                val value = item.readString("value", default = label)
            "event" in obj -> "callback"
            "targetId" in obj -> "toggle"
            "url" in obj -> "open_url"
            )
            ),
            ?: values.joinToString(", ") { it.toStringLike() }
            bold = obj.readNullableBoolean("bold"),
            children = persistentListOf(
            collectFrom = obj.readStringList("collectFrom").takeIf { it.isNotEmpty() },
            color = obj.readNullableString("color"),
            data = obj.readCallbackDataMap(),
            else -> "callback"
            else -> null
            event = obj.readString("event"),
            false
            false -> "single"
            id = obj.readId(),
            if (element.isString) CallbackAction(event = element.content) else CallbackAction(event = element.content)
            is JsonArray -> row.map { it.toStringLike() }.toImmutableList()
            is JsonArray, is JsonObject -> JsonPrimitive(value.toStringLike())
            is JsonObject -> TabItem(
            is JsonObject -> parseNode(element)
            is JsonObject -> row.values.map { it.toStringLike() }.toImmutableList()
            is JsonObject -> {
            is JsonPrimitive -> if (element !is JsonNull && element.isString) TextNode(value = element.content) else null
            is JsonPrimitive -> if (item !is JsonNull && item.isString) {
            is JsonPrimitive -> if (row is JsonNull) persistentListOf("") else persistentListOf(row.content)
            is JsonPrimitive -> if (value is JsonNull) JsonPrimitive("") else value
            italic = obj.readNullableBoolean("italic"),
            null
            null -> "single"
            style = style,
            true
            true -> "multi"
            value = obj.readString(textKey),
            }
            } else {
        "callback", "toggle", "open_url", "copy_to_clipboard" -> declaredType
        "copy_to_clipboard" -> CopyToClipboardAction(text = obj.readString("text"))
        "false", "no", "0" -> false
        "open_url" -> OpenUrlAction(url = obj.readString("url"))
        "toggle" -> ToggleAction(targetId = obj.readString("targetId"))
        "true", "yes", "1" -> true
        )
        ?: obj.readNullableFloat("aspect_ratio"),
        LABEL_KEYS.firstNotNullOfOrNull { (this[it] as? JsonPrimitive)?.content }
        chips = obj.readChipList("chips"),
        else -> CallbackAction(
        else -> null
        else -> when {
        explicitSelection
        id = obj.readRequiredId(),
        is JsonArray -> CallbackAction(event = element.toStringLike())
        is JsonArray -> element.map { it.toStringLike() }.toImmutableList()
        is JsonObject -> buildActionFromObject(element)
        is JsonObject -> persistentListOf(element.toStringLike())
        is JsonPrimitive ->
        is JsonPrimitive -> if (element is JsonNull) persistentListOf() else persistentListOf(element.content)
        return ColumnNode(
        return TextNode(
        return if (it == 1L) {
        return parseColumnNode(obj)
        selection = selection,
        val explicitStyle = parseTextStyle(obj.readNullableString("style"))
        val style = explicitStyle ?: if (textKey == "title") TextNodeStyle.TITLE else null
        when (element) {
        when (item) {
        when (obj.readNullableBoolean("multiSelect")) {
        when (row) {
        when (value) {
        }
        } else if (it == 0L) {
        } else {
    "accordion" -> parseAccordionNode(obj)
    "alert" -> parseAlertNode(obj)
    "avatar" -> parseAvatarNode(obj)
    "badge" -> parseBadgeNode(obj)
    "body" -> TextNodeStyle.BODY
    "box" -> parseBoxNode(obj)
    "button" -> parseButtonNode(obj)
    "caption" -> TextNodeStyle.CAPTION
    "card" -> parseCardNode(obj)
    "checkbox" -> parseCheckboxNode(obj)
    "chip_group" -> parseChipGroupNode(obj)
    "code" -> parseCodeNode(obj)
    "column" -> parseColumnNode(obj)
    "countdown" -> parseCountdownNode(obj)
    "divider" -> parseDividerNode(obj)
    "error" -> AlertSeverity.ERROR
    "filled" -> ButtonVariant.FILLED
    "headline" -> TextNodeStyle.HEADLINE
    "icon" -> parseIconNode(obj)
    "image" -> parseImageNode(obj)
    "info" -> AlertSeverity.INFO
    "list" -> parseListNode(obj)
    "outlined" -> ButtonVariant.OUTLINED
    "progress" -> parseProgressNode(obj)
    "quote" -> parseQuoteNode(obj)
    "radio_group" -> parseRadioGroupNode(obj)
    "row" -> parseRowNode(obj)
    "select" -> parseSelectNode(obj)
    "slider" -> parseSliderNode(obj)
    "stat" -> parseStatNode(obj)
    "success" -> AlertSeverity.SUCCESS
    "switch" -> parseSwitchNode(obj)
    "table" -> parseTableNode(obj)
    "tabs" -> parseTabsNode(obj)
    "text" -> ButtonVariant.TEXT
    "text" -> parseTextNode(obj)
    "text_input" -> parseTextInputNode(obj)
    "title" -> TextNodeStyle.TITLE
    "tonal" -> ButtonVariant.TONAL
    "warning" -> AlertSeverity.WARNING
    )
    // (preserves the old top-level block fallback for bare untyped objects).
    // Legacy migration: HTML-style `src` → `url`.
    // Legacy migration: multiSelect:Boolean → selection:String
    // Prefer the most-specific text-bearing key. Priority mirrors the old LABEL_KEYS
    // `{"children": [...]}` with no type and no text-bearing key → treat as column
    // `{"title":"...","subtitle":"..."}` → column with styled title + caption. Checked
    // as text nodes. `title` gets an implicit TITLE style unless the object specifies one.
    // first because both fields in one object is a strong signal.
    // order so typeless `{"value":"..."}` items inside `children`/`items` lists render
    action = obj.readAction("action"),
    alt = obj.readNullableString("alt"),
    aspectRatio = obj.readNullableFloat("aspectRatio")
    bold = obj.readNullableBoolean("bold"),
    checked = obj.readNullableBoolean("checked"),
    children = obj.readNodeList("children"),
    code = obj.readString("code"),
    color = obj.readNullableString("color"),
    contentAlignment = obj.readNullableString("contentAlignment"),
    description = obj.readNullableString("description"),
    element.booleanOrNull?.let { return it }
    element.doubleOrNull?.let { return it.toFloat() }
    element.doubleOrNull?.let { return it.toInt() }
    element.intOrNull?.let { return it }
    element.longOrNull?.let {
    element.longOrNull?.let { return it.toFloat() }
    element.longOrNull?.let { return it.toInt() }
    else -> null
    else -> null // unknown type → silently dropped
    enabled = obj.readNullableBoolean("enabled"),
    expanded = obj.readNullableBoolean("expanded"),
    headers = obj.readStringList("headers"),
    height = obj.readNullableInt("height"),
    id = obj.readId(),
    id = obj.readRequiredId(),
    if (!element.isString) return null
    if ("children" in obj) {
    if ("title" in obj && "subtitle" in obj) {
    if (element !is JsonPrimitive) return null
    if (element is JsonNull) return null
    if (textKey != null) {
    imageUrl = obj.readNullableString("imageUrl"),
    is JsonArray -> joinToString(", ") { it.toStringLike() }
    is JsonObject -> parseObjectNode(element)
    is JsonObject -> {
    is JsonPrimitive -> if (element.isString) TextNode(value = element.content) else null
    is JsonPrimitive -> if (this is JsonNull) "" else content
    italic = obj.readNullableBoolean("italic"),
    items = obj.readNodeList("items"),
    label = obj.readNullableString("label"),
    label = obj.readString("label"),
    language = obj.readNullableString("language"),
    max = obj.readNullableFloat("max"),
    message = obj.readString("message"),
    min = obj.readNullableFloat("min"),
    multiline = obj.readNullableBoolean("multiline"),
    name = obj.readNullableString("name"),
    name = obj.readString("name"),
    null -> inferBareObject(obj)
    options = obj.readStringList("options"),
    ordered = obj.readNullableBoolean("ordered"),
    placeholder = obj.readNullableString("placeholder"),
    return ChipGroupNode(
    return array.map { row ->
    return array.mapNotNull { element ->
    return array.mapNotNull { item ->
    return dataObj.mapValues { (_, value) ->
    return element.content.toFloatOrNull()
    return element.content.toIntOrNull()
    return element.toStringLike()
    return null
    return when (element) {
    return when (element.content.lowercase()) {
    return when (type) {
    rows = obj.readTableRows("rows"),
    seconds = obj.readInt("seconds"),
    selected = obj.readNullableString("selected"),
    selectedIndex = obj.readNullableInt("selectedIndex"),
    severity = parseAlertSeverity(obj.readNullableString("severity")),
    size = obj.readNullableInt("size"),
    source = obj.readNullableString("source"),
    step = obj.readNullableFloat("step"),
    style = parseTextStyle(obj.readNullableString("style")),
    tabs = obj.readTabList("tabs"),
    text = obj.readString("text"),
    title = obj.readNullableString("title"),
    title = obj.readString("title"),
    url = obj.readString("url").ifEmpty { obj.readString("src") },
    val array = this[key] as? JsonArray ?: return persistentListOf()
    val dataObj = this[key] as? JsonObject ?: return null
    val declaredType = obj.readNullableString("type")
    val element = this[key] ?: return default
    val element = this[key] ?: return null
    val element = this[key] ?: return persistentListOf()
    val explicitSelection = obj.readString("selection")
    val selection = if (explicitSelection.isNotEmpty()) {
    val textKey = listOf("value", "content", "text", "title", "label").firstOrNull { it in obj }
    val type = when (declaredType) {
    value = obj.readNullableFloat("value"),
    value = obj.readNullableString("value"),
    value = obj.readString("value"),
    variant = parseButtonVariant(obj.readNullableString("variant")),
    }
    } else {
    }.toImmutableList()
 *
 * - A `JsonObject` → recursively built via [parseNode]; unknown types are filtered out
 * - A primitive string → wrapped as `TextNode(value = content)`
 * - Array of arrays → each row coerced element-wise to string
 * - Array of objects → each object's values in insertion order
 * - Array of primitives → each wrapped as a single-cell row
 * - Array → comma-joined contents
 * - Bool primitives (`true`/`false`)
 * - JsonNull → `""`
 * - Missing → `emptyList()`
 * - Missing/null → `emptyList()`
 * - Numeric `1`/`0` → true/false
 * - Object → first [LABEL_KEYS] primitive match, else comma-joined values
 * - Primitive → its `content`
 * - Single object → `listOf(labelKey-hit)` if any
 * - Single primitive → `listOf(content)`
 * - String `"true"`/`"yes"`/`"1"` → true; `"false"`/`"no"`/`"0"` → false (case-insensitive)
 * - `JsonArray` of any elements (each coerced via [toStringLike])
 * - `JsonNull` or anything else → skipped
 * Anything else or absent → null.
 * Build a [KaiUiNode] from an arbitrary [JsonElement], or return null if the element can't
 * Coerce any [JsonElement] to a string, best-effort:
 * Covers `children` and `items`.
 * Covers `options`, `headers`, `collectFrom`.
 * LLMs commonly send ints like `75` for `Float?` fields — this handles that.
 * Matches the old `labelKeys` constant from the previous parser.
 * Preferred keys when extracting a string from an arbitrary JsonObject, in priority order.
 * Read [CallbackAction.data] — a `Map<String, JsonPrimitive>?`. Preserves existing
 * Read `ChipGroupNode.chips`. Accepts bare strings (wrapped as `{label=s, value=s}`)
 * Read `TableNode.rows`. Accepts:
 * Read `TabsNode.tabs`. Accepts bare strings (wrapped with empty children) or
 * Read a [UiAction] field. Absent or `JsonNull` → null. Primitive/array → wrapped as a
 * Read a boolean field. Accepts:
 * Read a float field. Accepts numeric primitives of any size and numeric strings.
 * Read a list of child nodes. Accepts a `JsonArray` where each element is:
 * Read a list of strings. Accepts:
 * Read a string field, coercing objects/arrays best-effort.
 * Read an integer field. Accepts ints, floats (via `toInt()`), and numeric strings.
 * Recover a typed node from an object that lacks a `type` discriminator by matching
 * Style fields (`bold`, `italic`, `color`, `style`, `id`) on the source object are
 * The [default] parameter only fires when the key is absent. If the key is present but
 * [CallbackAction] with the content as the event. Object with a known `type` discriminator
 * `children` array keeps its formatting.
 * `{label, children}` objects.
 * and arrays to string primitives via [toStringLike].
 * carried over when constructing a `TextNode`, so `{"value":"x","bold":true}` inside a
 * common LLM shortcuts. Returns null if nothing matches so the caller can drop the object.
 * fields are present.
 * holds an uncoercible object, the returned value is `""` (empty join) — not [default] —
 * is built via the matching action builder; otherwise the type is inferred from which
 * or full `{label, value}` objects.
 * primitives (so bools/numbers stay typed for `dataAsStrings`), flattens nested objects
 * represent any known node type.
 * so that callers can distinguish "field missing" (default) from "field present but
 * unrecoverable" (empty).
 */
)
/**
/** For interactive nodes where `id: String` is non-nullable. Absent → `""`. */
/** Read an integer field with a default for the missing/uncoercible case. */
/** Read an optional string field. Absent keys and `JsonNull` both return null. */
/** Thin wrapper for the nullable `override val id: String?` common to most nodes. */
//
// =============================================================================================
// Action readers
// Collection readers
// Content node builders
// Data display node builders
// Enum parsers — hand-rolled to avoid reflection, match @SerialName strings exactly
// Feedback / display node builders
// Interactive node builders
// Layout node builders
// Philosophy: every reader here knows the expected type because the builder calls the
// Scalar readers
// String-like coercion — the single source of truth for primitive/array/object → string
// This replaces the old field-name-keyed coercion pipeline in KaiUiParser with direct
// Tolerant field-by-field builders that turn a JsonElement tree into a KaiUiNode.
// Top-level dispatcher
// construction, so each LLM-mistake handler lives next to the field it owns.
// inferBareObject — typeless shortcuts used by LLMs
// its data-class default and the node still builds. Unknown node `type` discriminators
// return null and are filtered out of `children`/`items` by readNodeList.
// right one. Readers never throw — if a value can't be coerced, the field falls back to
internal fun JsonElement.toStringLike(): String = when (this) {
internal fun JsonObject.readAction(key: String): UiAction? {
internal fun JsonObject.readCallbackDataMap(key: String = "data"): Map<String, JsonPrimitive>? {
internal fun JsonObject.readChipList(key: String): ImmutableList<ChipItem> {
internal fun JsonObject.readId(): String? = readNullableString("id")
internal fun JsonObject.readInt(key: String, default: Int = 0): Int = readNullableInt(key) ?: default
internal fun JsonObject.readNodeList(key: String): ImmutableList<KaiUiNode> {
internal fun JsonObject.readNullableBoolean(key: String): Boolean? {
internal fun JsonObject.readNullableFloat(key: String): Float? {
internal fun JsonObject.readNullableInt(key: String): Int? {
internal fun JsonObject.readNullableString(key: String): String? {
internal fun JsonObject.readRequiredId(): String = readString("id")
internal fun JsonObject.readString(key: String, default: String = ""): String {
internal fun JsonObject.readStringList(key: String): ImmutableList<String> {
internal fun JsonObject.readTabList(key: String): ImmutableList<TabItem> {
internal fun JsonObject.readTableRows(key: String): ImmutableList<ImmutableList<String>> {
internal fun parseNode(element: JsonElement): KaiUiNode? = when (element) {
package com.inspiredandroid.kai.ui.dynamicui
private fun buildActionFromObject(obj: JsonObject): UiAction {
private fun inferBareObject(obj: JsonObject): KaiUiNode? {
private fun parseAccordionNode(obj: JsonObject): AccordionNode = AccordionNode(
private fun parseAlertNode(obj: JsonObject): AlertNode = AlertNode(
private fun parseAlertSeverity(raw: String?): AlertSeverity? = when (raw) {
private fun parseAvatarNode(obj: JsonObject): AvatarNode = AvatarNode(
private fun parseBadgeNode(obj: JsonObject): BadgeNode = BadgeNode(
private fun parseBoxNode(obj: JsonObject): BoxNode = BoxNode(
private fun parseButtonNode(obj: JsonObject): ButtonNode = ButtonNode(
private fun parseButtonVariant(raw: String?): ButtonVariant? = when (raw) {
private fun parseCardNode(obj: JsonObject): CardNode = CardNode(
private fun parseCheckboxNode(obj: JsonObject): CheckboxNode = CheckboxNode(
private fun parseChipGroupNode(obj: JsonObject): ChipGroupNode {
private fun parseCodeNode(obj: JsonObject): CodeNode = CodeNode(
private fun parseColumnNode(obj: JsonObject): ColumnNode = ColumnNode(
private fun parseCountdownNode(obj: JsonObject): CountdownNode = CountdownNode(
private fun parseDividerNode(obj: JsonObject): DividerNode = DividerNode(id = obj.readId())
private fun parseIconNode(obj: JsonObject): IconNode = IconNode(
private fun parseImageNode(obj: JsonObject): ImageNode = ImageNode(
private fun parseListNode(obj: JsonObject): ListNode = ListNode(
private fun parseObjectNode(obj: JsonObject): KaiUiNode? = when (obj.readNullableString("type")) {
private fun parseProgressNode(obj: JsonObject): ProgressNode = ProgressNode(
private fun parseQuoteNode(obj: JsonObject): QuoteNode = QuoteNode(
private fun parseRadioGroupNode(obj: JsonObject): RadioGroupNode = RadioGroupNode(
private fun parseRowNode(obj: JsonObject): RowNode = RowNode(
private fun parseSelectNode(obj: JsonObject): SelectNode = SelectNode(
private fun parseSliderNode(obj: JsonObject): SliderNode = SliderNode(
private fun parseStatNode(obj: JsonObject): StatNode = StatNode(
private fun parseSwitchNode(obj: JsonObject): SwitchNode = SwitchNode(
private fun parseTableNode(obj: JsonObject): TableNode = TableNode(
private fun parseTabsNode(obj: JsonObject): TabsNode = TabsNode(
private fun parseTextInputNode(obj: JsonObject): TextInputNode = TextInputNode(
private fun parseTextNode(obj: JsonObject): TextNode = TextNode(
private fun parseTextStyle(raw: String?): TextNodeStyle? = when (raw) {
private val LABEL_KEYS = listOf("value", "text", "label", "title", "name", "content")
}
