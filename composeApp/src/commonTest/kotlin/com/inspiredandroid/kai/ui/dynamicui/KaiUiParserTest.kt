
                """{"type":"button","label":"Submit","action":{"type":"callback","event":"submit",
                """{"type":"chip_group","id":"tags","chips":[
                """{"type":"column","children":[
                """{"type":"list","items":[
                """{"type":"tabs","tabs":[
                "data":{"user":{"name":"alice"},"tags":["a","b"]}}}""",
                {"label":"Rust","value":{"content":"rust"}}
                {"label":"Untyped object with label field"}
                {"label":{"text":"Kotlin"},"value":"kotlin"},
                {"label":{"title":"Overview"},"children":[{"type":"text","value":"a"}]},
                {"label":{"title":"Specs"},"children":[{"type":"text","value":"b"}]}
                {"text":"Untyped object with text field"},
                {"type": "button", "label": "Click", "action": {"type": "callback", "event": "click"}}
                {"type": "text", "value": "Title", "style": "headline"},
                {"type":"accordion","title":"More","expanded":"yes","children":[]},
                {"type":"checkbox","id":"c","label":"Agree","checked":"1"},
                {"type":"list","ordered":"true","items":[{"type":"text","value":"a"}]},
                {"type":"spacer","height":8}
                {"type":"switch","id":"s","label":"Dark","checked":"false"}
                {"type":"text","value":"Header","style":"title"},
                {"type":"text","value":"Inside"},
                {"value":"AI employees as social creators"},
                {"value":"Gut health micro-movements"}
                {"value":"Nostalgia platforms comeback"},
                {"value":"Styled text","style":"title","bold":true,"color":"primary"}
              "children": [
              "type": "column",
              ]
            ),
            ]}
            ]}""",
            assertIs<ButtonNode>(child)
            parseUi(
            parseUi("""{"type":"button","label":"Docs","action":{"url":"https://example.com"}}"""),
            parseUi("""{"type":"button","label":"Go","action":{"event":"go_clicked","data":{"x":"1"}}}"""),
            parseUi("""{"type":"button","label":"Reveal","action":{"targetId":"hidden_box"}}"""),
            parseUi("""{"type":"button","label":"Submit","action":"submit_form"}"""),
            parseUi("""{"type":"image","src":"https://example.com/a.jpg","alt":"photo"}"""),
            parseUi("""{"type":"image","url":"https://example.com/a.jpg","aspectRatio":1.78}"""),
            parseUi("""{"type":"image","url":"https://example.com/a.jpg","aspectRatio":2}"""),
            parseUi("""{"type":"image","url":"https://example.com/a.jpg","aspect_ratio":1.5}"""),
            parseUi("""{"type":"image","url":"https://example.com/a.jpg","height":160}"""),
            parseUi("""{"type":"text","value":"Hello","bold":"true","italic":"no"}"""),
            {
            {"type":"card","padding":12,"children":[
            {"type":"column","children":[{"type":"button","label":"38","action":{"type":"callback","event":"answer_q1","data":{"answer":"38"}},"variant":"filled"},{"type":"button","label":"40","action":{"type":"callback","event":"answer_q1","data":{"answer":"40"}},"variant":"filled"},{"type":"button","label":"42","action":{"type":"callback","event":"answer_q1","data":{"answer":"42"}},"variant":"filled"},{"type":"button","label":"44","action":{"type":"callback","event":"answer_q1","data":{"answer":"44"}},"variant":"filled"}}]}
            {"type":"column","children":[{"type":"button","label":"42","action":{"type":"callback","event":"answer","data":{"answer":"42"}},"variant":"filled"}]}
            {"type":"spacer","size":16},
            {"type":"text","value":"2, 6, 12, 20, 30, ?","style":"title"}
            {"type":"text","value":"After"},
            {"type":"text","value":"Before"},
            {"type":"text","value":"Complete the sequence:","style":"body","bold":true}
            {"type":"text","value":"Good luck","style":"body"}
            {"type":"text","value":"Pick one:","style":"title"}
            {"type":"text","value":"Question 1 of 3","style":"caption","color":"secondary"}
            {"type":"text","value":"Question 1 of 3","style":"caption"}
            {"type":"text","value":"Question 1","style":"caption"}
            {invalid json here}
            }
        """.trimIndent()
        )
        // At least the first complete child should be recovered
        // Back-compat: old assistant messages may contain spacer children and
        // Covered indirectly by the "non-composite + JsonObject → primitive" rule inside
        // Extra ] where } is expected — sanitizeJson should skip it
        // LLMs sometimes send booleans or numbers in the data map instead of strings
        // Legacy kai-ui blocks in historical chat messages used multiSelect:Boolean.
        // Real-world broken output: each button is missing its closing `}` before the
        // Real-world kimi-k2.5 output: list items emitted as {"value":"..."} without a type field
        // Real-world kimi-k2.5 output: multi-line NDJSON where the column line has an extra }
        // Real-world kimi-k2.5 output: single column with buttons, extra } before ]}
        // Simulates LLM adding an extra } inside a nested line
        // Simulates LLM response cut off inside a deeply nested structure
        // The invalid line is skipped, but the 3 valid lines parse
        // The markdown parser requires the opening fence to end the line; the body must start on
        // Well-formed JSON but the type isn't one we render — shows up as a KaiUiError so the
        // comma that separates it from the next button in the array. The first failure
        // is at offset 139 — `,{` inside button1 where a key is expected.
        // renderer can at least fall back to displaying the raw JSON instead of silently
        // sanitizeJson repairs the extra } so all 4 lines parse including buttons
        // spacing/padding properties on containers. The parser must still render them,
        // swallowing the assistant's response.
        // the data object. Verifies recursion walks into data correctly.
        // the next line. This is a well-formed CommonMark fenced block.
        // treating spacer as no-op and ignoring the removed fields.
        ]}"""
        assertEquals("$1,234", node.value)
        assertEquals("12% increase", node.description)
        assertEquals("3", node.value)
        assertEquals("42", data["count"])
        assertEquals("A Title", child.value)
        assertEquals("AI employees as social creators", first.value)
        assertEquals("Ag", (row.children[1] as ButtonNode).label)
        assertEquals("All roses fade quickly", (column.children[0] as ButtonNode).label)
        assertEquals("Au", (row.children[0] as ButtonNode).label)
        assertEquals("Be kind", quote.text)
        assertEquals("Be the change.", node.text)
        assertEquals("Blue", node.selected)
        assertEquals("Click me", button.label)
        assertEquals("Click me", child.value)
        assertEquals("Complete", (node.children[0] as TextNode).value)
        assertEquals("Dark Mode", node.label)
        assertEquals("Fe", (row.children[2] as ButtonNode).label)
        assertEquals("File saved successfully", node.message)
        assertEquals("First item", first.value)
        assertEquals("First", (node.children[0] as TextNode).value)
        assertEquals("Gandhi", node.source)
        assertEquals("Gut health micro-movements", third.value)
        assertEquals("Header", (column.children[0] as TextNode).value)
        assertEquals("Hello world", node.text)
        assertEquals("Hello", child.value)
        assertEquals("Hello", node.value)
        assertEquals("Hello", textNode.value)
        assertEquals("Hi", node.value)
        assertEquals("Jane", node.name)
        assertEquals("John Doe", node.name)
        assertEquals("Kotlin", chipGroup.chips[0].label)
        assertEquals("Kotlin", node.chips[0].label)
        assertEquals("M", node.selected)
        assertEquals("More details", node.title)
        assertEquals("My Subtitle", subtitle.value)
        assertEquals("My Title", title.value)
        assertEquals("Name", node.label)
        assertEquals("None of these follow", (column.children[3] as ButtonNode).label)
        assertEquals("Nostalgia platforms comeback", second.value)
        assertEquals("Overview", tabs.tabs[0].label)
        assertEquals("Question 1 of 3", (column.children[0] as TextNode).value)
        assertEquals("Revenue", node.label)
        assertEquals("Rust", chipGroup.chips[1].label)
        assertEquals("Second item", second.value)
        assertEquals("Specs", tabs.tabs[1].label)
        assertEquals("Styled text", text.value)
        assertEquals("Success", node.title)
        assertEquals("Tab 1", node.tabs[0].label)
        assertEquals("Time left", node.label)
        assertEquals("Untyped object with label field", (column.children[2] as TextNode).value)
        assertEquals("Untyped object with text field", (column.children[1] as TextNode).value)
        assertEquals("Uploading...", node.label)
        assertEquals("a, b", data["tags"]?.content)
        assertEquals("alice", data["user"]?.content)
        assertEquals("anon", quote.source)
        assertEquals("center", node.contentAlignment)
        assertEquals("continue", action.event)
        assertEquals("dark_mode", node.id)
        assertEquals("details", toggle.targetId)
        assertEquals("error", node.color)
        assertEquals("fun main() { println(\"Hello\") }", node.code)
        assertEquals("go_clicked", callback.event)
        assertEquals("green", chipGroup.chips[2].label)
        assertEquals("hello", text.value)
        assertEquals("hidden_box", action.targetId)
        assertEquals("https://example.com", action.url)
        assertEquals("https://example.com", openUrl.url)
        assertEquals("https://example.com/a.jpg", image.url)
        assertEquals("https://example.com/photo.jpg", node.imageUrl)
        assertEquals("kotlin", chipGroup.chips[0].value)
        assertEquals("kotlin", node.chips[0].value)
        assertEquals("kotlin", node.language)
        assertEquals("line one, line two", node.value)
        assertEquals("multi", multiNode.selection)
        assertEquals("multi", node.selection)
        assertEquals("name", node.id)
        assertEquals("photo", image.alt)
        assertEquals("primary", node.color)
        assertEquals("primary", text.color)
        assertEquals("red", chipGroup.chips[0].label)
        assertEquals("red", chipGroup.chips[0].value)
        assertEquals("rust", chipGroup.chips[1].value)
        assertEquals("single", singleNode.selection)
        assertEquals("star", node.name)
        assertEquals("submit", action.event)
        assertEquals("submit_form", callback.event)
        assertEquals("test", data["name"])
        assertEquals("timer_done", action.event)
        assertEquals("true", data["continue"])
        assertEquals("volume", node.id)
        assertEquals(0.7f, node.value)
        assertEquals(0f, node.min)
        assertEquals(1, blocks.size)
        assertEquals(1, card.children.size)
        assertEquals(1, column.children.size)
        assertEquals(1, node.children.size)
        assertEquals(1, node.tabs[0].children.size)
        assertEquals(1, uiBlocks.size)
        assertEquals(1.5f, image.aspectRatio)
        assertEquals(1.78f, image.aspectRatio)
        assertEquals(100f, node.max)
        assertEquals(160, image.height)
        assertEquals(2, child.children.size)
        assertEquals(2, chipGroup.chips.size)
        assertEquals(2, column.children.size)
        assertEquals(2, node.children.size)
        assertEquals(2, node.chips.size)
        assertEquals(2, node.items.size)
        assertEquals(2, node.tabs.size)
        assertEquals(2, tabs.tabs.size)
        assertEquals(2.0f, image.aspectRatio)
        assertEquals(3, blocks.size)
        assertEquals(3, chipGroup.chips.size)
        assertEquals(3, column.children.size)
        assertEquals(3, list.items.size)
        assertEquals(3, row.children.size)
        assertEquals(300, node.seconds)
        assertEquals(32, node.size)
        assertEquals(4, buttonsColumn.children.size)
        assertEquals(4, column.children.size)
        assertEquals(48, node.size)
        assertEquals(5, blocks.size)
        assertEquals(5f, node.step)
        assertEquals(60, node.seconds)
        assertEquals(7, column.children.size)
        assertEquals(75f, node.value)
        assertEquals(AlertSeverity.SUCCESS, node.severity)
        assertEquals(ButtonVariant.OUTLINED, node.variant)
        assertEquals(ButtonVariant.TEXT, node.variant)
        assertEquals(ButtonVariant.TONAL, node.variant)
        assertEquals(TextNodeStyle.TITLE, text.style)
        assertEquals(false, (column.children[3] as SwitchNode).checked)
        assertEquals(false, node.expanded)
        assertEquals(false, text.italic)
        assertEquals(listOf("Col A", "Col B"), table.headers)
        assertEquals(listOf("Red", "Blue", "Green"), node.options)
        assertEquals(listOf("S", "M", "L", "XL"), node.options)
        assertEquals(listOf("a", "b"), select.options)
        assertEquals(listOf("col1", "col2"), table.headers)
        assertEquals(listOf("name", "email"), action.collectFrom)
        assertEquals(listOf("y", "n"), radio.options)
        assertEquals(listOf(listOf("1", "2"), listOf("3", "4")), table.rows)
        assertEquals(listOf(listOf("a", "b")), table.rows)
        assertEquals(null, node.action)
        assertEquals(null, node.value)
        assertEquals(true, (column.children[0] as ListNode).ordered)
        assertEquals(true, (column.children[1] as AccordionNode).expanded)
        assertEquals(true, (column.children[2] as CheckboxNode).checked)
        assertEquals(true, node.checked)
        assertEquals(true, text.bold)
        assertFalse(hasUiBlocks(message))
        assertIs<ButtonNode>(buttonsColumn.children[0])
        assertIs<ButtonNode>(node.children[1])
        assertIs<ColumnNode>(child)
        assertIs<ColumnNode>(column)
        assertIs<ColumnNode>(column.children[3])
        assertIs<ColumnNode>(parseUi(json))
        assertIs<KaiUiBlock>(blocks[1])
        assertIs<KaiUiBlock>(blocks[3])
        assertIs<KaiUiError>(blocks[0])
        assertIs<Paragraph>(blocks[0])
        assertIs<Paragraph>(blocks[2])
        assertIs<Paragraph>(blocks[4])
        assertIs<TextNode>(card.children[0])
        assertIs<TextNode>(child)
        assertIs<TextNode>(column.children[0])
        assertIs<TextNode>(column.children[1])
        assertIs<TextNode>(column.children[2])
        assertIs<TextNode>(first)
        assertIs<TextNode>(node)
        assertIs<TextNode>(node.children[0])
        assertIs<TextNode>(node.tabs[0].children[0])
        assertIs<TextNode>(second)
        assertIs<TextNode>(subtitle)
        assertIs<TextNode>(title)
        assertIs<TextNode>(uiBlock.node)
        assertNull(image.aspectRatio)
        assertNull(image.height)
        assertNull(node.imageUrl)
        assertNull(node.source)
        assertTrue(hasUiBlocks(message))
        assertTrue(node.children.isNotEmpty())
        for (child in column.children) {
        return ui.node
        val action = assertIs<CallbackAction>(node.action)
        val action = assertIs<OpenUrlAction>(button.action)
        val action = assertIs<ToggleAction>(button.action)
        val action = button.action as CallbackAction
        val block = """
        val blocks = parseMarkdown(message).blocks
        val button = assertIs<ButtonNode>(
        val button = assertIs<ButtonNode>(parseUi("""{"type":"button","label":{"label":"Click me"},"action":{"type":"callback","event":"tap"}}"""))
        val button = assertIs<ButtonNode>(parseUi(json))
        val buttonsColumn = assertIs<ColumnNode>(column.children[3])
        val callback = assertIs<CallbackAction>(button.action)
        val card = assertIs<CardNode>(column.children[2])
        val child = node.children[0]
        val chipGroup = assertIs<ChipGroupNode>(
        val chipGroup = assertIs<ChipGroupNode>(parseUi("""{"type":"chip_group","id":"tags","chips":["red","blue","green"]}"""))
        val column = (blocks[1] as KaiUiBlock).node
        val column = assertIs<ColumnNode>(
        val column = assertIs<ColumnNode>(parseUi(block))
        val column = assertIs<ColumnNode>(parseUi(json))
        val column = uiBlocks[0].node
        val data = action.dataAsStrings!!
        val data = callback.data!!
        val first = assertIs<TextNode>(list.items[0])
        val first = node.items[0]
        val image = assertIs<ImageNode>(
        val json = """
        val json = """{"type":"accordion","title":"More details","children":[{"type":"text","value":"Hidden content"}],"expanded":false}"""
        val json = """{"type":"alert","message":"File saved successfully","title":"Success","severity":"success"}"""
        val json = """{"type":"avatar","name":"Jane","imageUrl":"https://example.com/photo.jpg"}"""
        val json = """{"type":"avatar","name":"John Doe","size":48}"""
        val json = """{"type":"badge","value":"3","color":"error"}"""
        val json = """{"type":"bottom_bar","buttons":[{"label":"Home","icon":"home"}]}"""
        val json = """{"type":"box","children":[{"type":"text","value":"Centered"}],"contentAlignment":"center"}"""
        val json = """{"type":"button","label":"Cancel","variant":"outlined"}"""
        val json = """{"type":"button","label":"Continue","action":{"type":"callback","event":"continue","data":{"continue":true,"count":42,"name":"test"}}}"""
        val json = """{"type":"button","label":"Maybe","variant":"tonal"}"""
        val json = """{"type":"button","label":"Skip","variant":"text"}"""
        val json = """{"type":"button","label":"Submit","action":{"type":"callback","event":"submit","collectFrom":["name","email"]}}"""
        val json = """{"type":"button","label":"Toggle","action":{"type":"toggle","targetId":"details"}}"""
        val json = """{"type":"button","label":"Visit","action":{"type":"open_url","url":"https://example.com"}}"""
        val json = """{"type":"chip_group","id":"tags","chips":[{"label":"Kotlin","value":"kotlin"},{"label":"Java","value":"java"}],"selection":"multi"}"""
        val json = """{"type":"code","code":"fun main() { println(\"Hello\") }","language":"kotlin"}"""
        val json = """{"type":"column","children":[{"label":"Click me"}]}"""
        val json = """{"type":"column","children":[{"text":"Hello","icon":"check"}]}"""
        val json = """{"type":"column","children":[{"title":"A Title"}]}"""
        val json = """{"type":"column","children":[{"title":"My Title","subtitle":"My Subtitle","icon":"settings"}]}"""
        val json = """{"type":"column","children":[{"type":"button","label":"All roses fade quickly","action":{"type":"callback","event":"answer_q2","data":{"answer":"all"}},"variant":"filled"},{"type":"button","label":"Some roses fade quickly","action":{"type":"callback","event":"answer_q2","data":{"answer":"some"}},"variant":"filled"},{"type":"button","label":"No roses fade quickly","action":{"type":"callback","event":"answer_q2","data":{"answer":"none"}},"variant":"filled"},{"type":"button","label":"None of these follow","action":{"type":"callback","event":"answer_q2","data":{"answer":"none_follow"}},"variant":"filled"}}]}"""
        val json = """{"type":"column","children":[{"type":"text","value":"A"},{"type":"text","value":"B"}]]}"""
        val json = """{"type":"column","children":[{"type":"text","value":"A"}]}}}"""
        val json = """{"type":"column","children":[{"type":"text","value":"Complete"},{"type":"text","value":"Trun"""
        val json = """{"type":"column","children":[{"type":"text","value":"First"},"""
        val json = """{"type":"column","children":[{"type":"text","value":"Keep"},{"type":"bottom_bar","buttons":[]}]}"""
        val json = """{"type":"column","children":[{"type":"text","value":"OK"}],"spa"""
        val json = """{"type":"column","children":[{"type":"text","value":"Wilderness Survival","style":"headline","bold":true},{"type":"text","value":"You wake up in a cold pine forest.","style":"body"},{"type":"divider"},{"type":"text","value":"Status","style":"title"},{"type":"row","children":[{"type":"card","children":[{"type":"text","value":"Health: 80/100","style":"body"}]},{"type":"card","children":[{"type":"text","value":"Hunger: 30/100","style":"body"}]},{"type":"card","children":[{"type":"text","value":"Energy: 70/100","style":"body"}]}]},{"type":"text","value":"What do you want to do?","style":"title"},{"type":"column","children":[{"type":"button","label":"Follow river","action":{"type":"callback","event":"survival_choice","data":{"choice":"river"}},"variant":"filled"},{"type":"button","label":"Head to mountains","action":{"type":"callback","event":"survival_choice","data":{"choice":"mountains"}},"variant":"filled"},{"type":"button","label":"Stay & build camp here","action":{"type":"callback","event":"survival_choice","data":{"choice":"camp"}},"variant":"filled"}]}]}"""
        val json = """{"type":"column","children=[{"type":"text","value":"Hello"}]}"""
        val json = """{"type":"column","spacing":16,"padding":8,"children":[
        val json = """{"type":"countdown","seconds":300,"label":"Time left"}"""
        val json = """{"type":"countdown","seconds":60,"label":"Hurry!","action":{"type":"callback","event":"timer_done"}}"""
        val json = """{"type":"icon","name":"star","size":32,"color":"primary"}"""
        val json = """{"type":"list","items":[{"content":"First item"},{"content":"Second item"}]}"""
        val json = """{"type":"progress","label":"Loading..."}"""
        val json = """{"type":"progress","value":0.7,"label":"Uploading..."}"""
        val json = """{"type":"quote","text":"Be the change.","source":"Gandhi"}"""
        val json = """{"type":"quote","text":"Hello world"}"""
        val json = """{"type":"radio_group","id":"size","label":"Size","options":["S","M","L","XL"],"selected":"M"}"""
        val json = """{"type":"row","children":[{"type":"button","label":"Au","action":{"type":"callback","event":"answer","data":{"question":1,"answer":"Au"}},{"type":"button","label":"Ag","action":{"type":"callback","event":"answer","data":{"question":1,"answer":"Ag"}},{"type":"button","label":"Fe","action":{"type":"callback","event":"answer","data":{"question":1,"answer":"Fe"}}}}}]}"""
        val json = """{"type":"select","id":"color","label":"Color","options":["Red","Blue","Green"],"selected":"Blue"}"""
        val json = """{"type":"slider","id":"volume","label":"Volume","value":75,"min":0,"max":100,"step":5}"""
        val json = """{"type":"stat","value":"$1,234","label":"Revenue","description":"12% increase"}"""
        val json = """{"type":"switch","id":"dark_mode","label":"Dark Mode","checked":true}"""
        val json = """{"type":"tabs","tabs":[{"label":"Tab 1","children":[{"type":"text","value":"Content 1"}]},{"label":"Tab 2","children":[{"type":"text","value":"Content 2"}]}],"selectedIndex":0}"""
        val json = """{"type":"text","value":"Hi"}}"""
        val json = """{"type":"text","value":["line one","line two"]}"""
        val json = """{"type":"text_input","id":"name","label":"Name"}"""
        val list = assertIs<ListNode>(
        val message = "Before\n```kai-ui\n{\"type\":\"text\",\"value\":\"Hello\"}\n```\nAfter"
        val message = "First block:\n```kai-ui\n{\"type\":\"text\",\"value\":\"A\"}\n```\nMiddle text\n```kai-ui\n{\"type\":\"text\",\"value\":\"B\"}\n```\nEnd"
        val message = "Hello\n```kai-ui\n{\"type\":\"text\",\"value\":\"Hi\"}\n```\nBye"
        val message = "Here's a quiz:\n```kai-ui\n$block\n```\nGood luck!"
        val message = "Sure! Let's see how sharp you are today.\n\n```kai-ui\n$block\n```\n\nTake your shot!"
        val message = "Which statement is necessarily true?\n\n```kai-ui\n$json\n```"
        val message = "```kai-ui\n$json\n```"
        val message = "```kai-ui\n$json\n```\n\nType \"stop game\" anytime to quit."
        val message = "```kai-ui\n{\"type\":\"text\",\"value\":\"Hi\"}\n```"
        val message = "```kai-ui\n{invalid json}\n```"
        val message = "```kotlin\nval x = 1\n```"
        val message = "kai-ui\n```\n{\"type\":\"text\",\"value\":\"Hello\"}\n```"
        val message = "kai-ui\n```json\n{\"type\":\"text\",\"value\":\"Hello\"}\n```"
        val multiJson = """{"type":"chip_group","id":"tags","chips":[{"label":"A"}],"multiSelect":true}"""
        val multiNode = assertIs<ChipGroupNode>(parseUi(multiJson))
        val node = assertIs<AccordionNode>(parseUi(json))
        val node = assertIs<AlertNode>(parseUi(json))
        val node = assertIs<AvatarNode>(parseUi(json))
        val node = assertIs<BadgeNode>(parseUi(json))
        val node = assertIs<BoxNode>(parseUi(json))
        val node = assertIs<ButtonNode>(parseUi(json))
        val node = assertIs<ChipGroupNode>(parseUi(json))
        val node = assertIs<CodeNode>(parseUi(json))
        val node = assertIs<ColumnNode>(parseUi(json))
        val node = assertIs<CountdownNode>(parseUi(json))
        val node = assertIs<IconNode>(parseUi(json))
        val node = assertIs<ListNode>(parseUi(json))
        val node = assertIs<ProgressNode>(parseUi(json))
        val node = assertIs<QuoteNode>(parseUi(json))
        val node = assertIs<RadioGroupNode>(parseUi(json))
        val node = assertIs<SelectNode>(parseUi(json))
        val node = assertIs<SliderNode>(parseUi(json))
        val node = assertIs<StatNode>(parseUi(json))
        val node = assertIs<SwitchNode>(parseUi(json))
        val node = assertIs<TabsNode>(parseUi(json))
        val node = assertIs<TextInputNode>(parseUi(json))
        val node = assertIs<TextNode>(parseUi(json))
        val node = uiBlocks[0].node
        val openUrl = assertIs<OpenUrlAction>(button.action)
        val quote = assertIs<QuoteNode>(parseUi("""{"type":"quote","text":{"content":"Be kind"},"source":"anon"}"""))
        val radio = assertIs<RadioGroupNode>(parseUi("""{"type":"radio_group","id":"pick","options":[{"label":"Yes","value":"y"},{"label":"No","value":"n"}]}"""))
        val result = KaiUiParser.parseUiBlockBody(json)
        val row = assertIs<RowNode>(parseUi(json))
        val second = assertIs<TextNode>(list.items[1])
        val second = node.items[1]
        val select = assertIs<SelectNode>(parseUi("""{"type":"select","id":"pick","options":[{"label":"Alpha","value":"a"},{"label":"Beta","value":"b"}]}"""))
        val singleJson = """{"type":"chip_group","id":"tags","chips":[{"label":"A"}],"multiSelect":false}"""
        val singleNode = assertIs<ChipGroupNode>(parseUi(singleJson))
        val subtitle = child.children[1]
        val table = assertIs<TableNode>(parseUi("""{"type":"table","headers":["col1","col2"],"rows":[{"col1":"1","col2":"2"},{"col1":"3","col2":"4"}]}"""))
        val table = assertIs<TableNode>(parseUi("""{"type":"table","headers":[{"name":"Col A"},{"name":"Col B"}],"rows":[["a","b"]]}"""))
        val tabs = assertIs<TabsNode>(
        val text = assertIs<TextNode>(
        val text = assertIs<TextNode>(column.children.single())
        val text = assertIs<TextNode>(parseUi("""{"type":"text","value":{"text":"hello"}}"""))
        val textNode = assertIs<TextNode>(uiBlock.node)
        val third = assertIs<TextNode>(list.items[2])
        val title = child.children[0]
        val toggle = assertIs<ToggleAction>(button.action)
        val ui = assertIs<KaiUiParser.UiBlockResult.Ui>(result)
        val uiBlock = assertIs<KaiUiBlock>(blocks[0])
        val uiBlock = blocks[1] as KaiUiBlock
        val uiBlocks = blocks.filterIsInstance<KaiUiBlock>()
        }
    // --- Shape coercion: LLMs sometimes put objects or wrong-shaped lists where the data
    // --- Tests for new node types ---
    // --- Truncated JSON recovery tests ---
    // fixMissingTypes so the parser recovers instead of crashing the whole block.
    // model expects a plain string or a List<String>. These regressions pin the behaviour of
    @Test
    fun `callback action with collectFrom`() {
    fun `callback data with non-string values`() {
    fun `closes object before next array element when LLM omits brace`() {
    fun `coerces bare string action to callback`() {
    fun `coerces button label as object with label field`() {
    fun `coerces chip group chips as bare strings`() {
    fun `coerces chip label and value when sent as objects`() {
    fun `coerces nested objects in CallbackAction data to primitives`() {
    fun `coerces quote text as object`() {
    fun `coerces radio group options as list of objects`() {
    fun `coerces select options as list of objects`() {
    fun `coerces string booleans for known boolean fields`() {
    fun `coerces tab label when sent as object`() {
    fun `coerces table headers as list of objects`() {
    fun `coerces table rows as list of objects`() {
    fun `coerces text node bold and italic as strings`() {
    fun `coerces text value as object with nested text field`() {
    fun `coerces untyped action object with event as callback`() {
    fun `coerces untyped action object with targetId as toggle`() {
    fun `coerces untyped action object with url as open_url`() {
    fun `detects kai-ui as plain text followed by json code block`() {
    fun `detects kai-ui as plain text followed by untagged code block`() {
    fun `detects kai-ui blocks`() {
    fun `extra closing bracket inside nested structure is skipped`() {
    fun `fixes equals sign instead of colon in key-value separator`() {
    fun `flattens array value to string when primitive expected`() {
    fun `handles extra trailing braces from LLM`() {
    fun `handles multiple extra trailing braces`() {
    fun `infers column from object with title and subtitle but no type`() {
    fun `infers text node from object with label but no type`() {
    fun `infers text node from object with text field but no type`() {
    fun `infers text node from object with title only but no type`() {
    fun `interactive nodes require id`() {
    fun `invalid json produces error segment`() {
    fun `legacy image without aspectRatio has null`() {
    fun `legacy spacer nodes and spacing fields are silently dropped`() {
    fun `migrates image src to url`() {
    fun `migrates legacy multiSelect to selection`() {
    fun `multi-line skips malformed line and renders the rest`() {
    fun `multi-line with extra closing brace in nested column from LLM`() {
    fun `multiple ui blocks in one message`() {
    fun `no false positive on regular code blocks`() {
    fun `open url action`() {
    fun `parses accordion node`() {
    fun `parses alert node`() {
    fun `parses avatar node with image url`() {
    fun `parses avatar node`() {
    fun `parses badge node`() {
    fun `parses box node`() {
    fun `parses button with outlined variant`() {
    fun `parses button with text variant`() {
    fun `parses button with tonal variant`() {
    fun `parses chip_group node`() {
    fun `parses code node`() {
    fun `parses column with children`() {
    fun `parses complex nested kai-ui from kimi model`() {
    fun `parses countdown node with action`() {
    fun `parses countdown node`() {
    fun `parses icon node`() {
    fun `parses image with aspectRatio`() {
    fun `parses image with integer aspectRatio`() {
    fun `parses image with snake_case aspect_ratio`() {
    fun `parses kai-ui block when body and closing fence share line with newline before body`() {
    fun `parses list items with content field instead of type`() {
    fun `parses multi-line JSON objects as column`() {
    fun `parses progress node determinate`() {
    fun `parses progress node indeterminate`() {
    fun `parses quote node without source`() {
    fun `parses quote node`() {
    fun `parses radio_group node`() {
    fun `parses slider node`() {
    fun `parses stat node`() {
    fun `parses switch node`() {
    fun `parses tabs node`() {
    fun `parses text node`() {
    fun `preserves style fields when wrapping untyped object in children`() {
    fun `recovers truncated JSON after comma`() {
    fun `recovers truncated JSON mid-key`() {
    fun `recovers truncated JSON mid-value in nested object`() {
    fun `select node with options`() {
    fun `single-line column with extra closing brace in children`() {
    fun `strips unknown child node from children`() {
    fun `toggle action`() {
    fun `unknown top-level node type produces error block`() {
    fun `wraps untyped objects inside children as text nodes`() {
    fun `wraps untyped objects inside list items as text nodes`() {
    private fun hasUiBlocks(message: String): Boolean = parseMarkdown(message).blocks.any { it is KaiUiBlock || it is KaiUiError }
    private fun parseUi(json: String): KaiUiNode {
    }
class KaiUiParserTest {
import com.inspiredandroid.kai.ui.markdown.KaiUiBlock
import com.inspiredandroid.kai.ui.markdown.KaiUiError
import com.inspiredandroid.kai.ui.markdown.Paragraph
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertTrue
package com.inspiredandroid.kai.ui.dynamicui
}
