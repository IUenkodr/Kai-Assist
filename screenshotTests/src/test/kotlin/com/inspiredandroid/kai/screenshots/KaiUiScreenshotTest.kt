import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.inspiredandroid.kai.ui.DarkColorScheme
import com.inspiredandroid.kai.ui.LightColorScheme
import com.inspiredandroid.kai.ui.Theme
import com.inspiredandroid.kai.ui.chat.ChatScreenContent
import com.inspiredandroid.kai.ui.chat.ChatUiState
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.dynamicui.KaiUiParser
import com.inspiredandroid.kai.ui.dynamicui.KaiUiParser.UiBlockResult
import com.inspiredandroid.kai.ui.dynamicui.KaiUiRenderer
import com.inspiredandroid.kai.ui.dynamicui.LocalPreviewImages
import kotlinx.collections.immutable.persistentListOf
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.setResourceReaderAndroidContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

                            "**Actionable Tips**: Receive personalized recommendations to reduce your footprint.",
                            "**Automated Insights**: Integrate with smart devices and apps for seamless data collection.",
                            "**Business Tools**: Track and report emissions for ESG compliance."
                            "**Gamification**: Earn rewards for hitting sustainability milestones.",
                            "**Real-Time Tracking**: Monitor energy, transportation, and consumption habits.",
                            {"type":"badge","value":"Pro","color":"primary"},
                            {"type":"badge","value":"Verified","color":"secondary"}
                            {"type":"badge","value":"promote","color":"primary"}
                            {"type":"button","label":"Delete","variant":"text","action":{"type":"callback","event":"delete","data":{"id":"1"}}}
                            {"type":"button","label":"Delete","variant":"text","action":{"type":"callback","event":"delete","data":{"id":"2"}}}
                            {"type":"button","label":"Demote","variant":"outlined","action":{"type":"callback","event":"demote","data":{"id":"1"}}},
                            {"type":"button","label":"Demote","variant":"outlined","action":{"type":"callback","event":"demote","data":{"id":"2"}}},
                            {"type":"icon","name":"flight"},
                            {"type":"icon","name":"location_on"},
                            {"type":"icon","name":"pets"},
                            {"type":"icon","name":"star"},
                            {"type":"text","value":"10:00 AM - 10:15 AM","style":"caption"}
                            {"type":"text","value":"2:00 PM - 3:00 PM","style":"caption"}
                            {"type":"text","value":"4:00 PM - 5:00 PM","style":"caption"}
                            {"type":"text","value":"Cat named Pixel","style":"body","bold":true}
                            {"type":"text","value":"Dark mode, concise answers","style":"body","bold":true}
                            {"type":"text","value":"Design Review","style":"body","bold":true},
                            {"type":"text","value":"Lives in Berlin, moved from Munich","style":"body","bold":true}
                            {"type":"text","value":"Recalled 2 times","style":"caption"},
                            {"type":"text","value":"Recalled 3 times","style":"caption"},
                            {"type":"text","value":"Recalled 4 times","style":"caption"},
                            {"type":"text","value":"Software engineer, mainly Kotlin","style":"body","bold":true}
                            {"type":"text","value":"Sprint Planning","style":"body","bold":true},
                            {"type":"text","value":"Team Standup","style":"body","bold":true},
                            {"type":"text","value":"Travels often, prefers window seats","style":"body","bold":true}
                        History(id = "1", role = History.Role.USER, content = "Give me a brain teaser quiz"),
                        History(id = "2", role = History.Role.ASSISTANT, content = kaiUiContent),
                        ["1","Alice","9850","42"],
                        ["2","Bob","8720","38"],
                        ["3","Charlie","7630","35"],
                        ["4","Diana","6540","31"]
                        ],"ordered":false}
                        ]}
                        ]},
                        {"label":"Circular Economy","value":"circular_economy"},
                        {"label":"E-Waste Reduction","value":"e_waste"},
                        {"label":"Renewable Energy","value":"renewable_energy"},
                        {"label":"Smart Cities","value":"smart_cities"},
                        {"label":"Sustainable Agriculture","value":"sustainable_agriculture"},
                        {"label":"Water Conservation","value":"water_conservation"}
                        {"type":"button","label":"Explore Another Idea","action":{"type":"callback","event":"explore_sustainable_idea"},"variant":"outlined"}
                        {"type":"button","label":"Refine This Idea","action":{"type":"callback","event":"refine_ecopulse"},"variant":"filled"},
                        {"type":"column","children":[
                        {"type":"icon","name":"calendar","color":"primary"},
                        {"type":"icon","name":"calendar"},
                        {"type":"icon","name":"check","color":"primary"},
                        {"type":"icon","name":"email","color":"primary"},
                        {"type":"icon","name":"star","color":"primary"},
                        {"type":"list","items":[
                        {"type":"row","children":[
                        {"type":"text","value":"12 Unread","style":"body","bold":true}
                        {"type":"text","value":"3 Meetings","style":"body","bold":true}
                        {"type":"text","value":"7 Tasks Done","style":"body","bold":true}
                        {"type":"text","value":"Published \"Getting Started with KMP\"","style":"body"}
                        {"type":"text","value":"Recalled 14 times \u2022 Promoted to system prompt","style":"caption","color":"primary"},
                        {"type":"text","value":"Recalled 9 times \u2022 Promoted to system prompt","style":"caption","color":"primary"},
                        {"type":"text","value":"Simon Schubert","style":"title","bold":true},
                    "rows":[
                    ),
                    ]
                    ],"selection":"multi"},
                    ]}
                    ]},
                    actions = ScreenshotTestData.chatEmptyState.actions,
                    content()
                    history = persistentListOf(
                    isInteractive = true,
                    isInteractiveMode = true,
                    modifier = Modifier.padding(12.dp),
                    node = ui.node,
                    onCallback = { _, _ -> },
                    wrapInCard = true,
                    {"label":"Happy","value":"happy"},
                    {"label":"Kotlin","value":"kotlin"},
                    {"label":"Music","value":"music"},
                    {"label":"Neutral","value":"neutral"},
                    {"label":"Rust","value":"rust"},
                    {"label":"Sad","value":"sad"}
                    {"label":"Science","value":"science"},
                    {"label":"Sports","value":"sports"},
                    {"label":"Swift","value":"swift"},
                    {"label":"Technology","value":"tech"},
                    {"label":"Travel","value":"travel"}
                    {"label":"TypeScript","value":"ts"}
                    {"type":"accordion","title":"Core Features","expanded":false,"children":[
                    {"type":"avatar","name":"Jane Doe","size":48},
                    {"type":"avatar","name":"Simon Schubert","size":48},
                    {"type":"avatar","name":"Simon Schubert","size":56},
                    {"type":"avatar","size":48}
                    {"type":"badge","value":"!","color":"error"}
                    {"type":"badge","value":"3","color":"primary"},
                    {"type":"badge","value":"New","color":"secondary"},
                    {"type":"badge","value":"\u23f1 20 min","color":"secondary"},
                    {"type":"badge","value":"\u2b50 4.9/5","color":"primary"}
                    {"type":"badge","value":"\uD83C\uDF7D 2 servings","color":"secondary"},
                    {"type":"badge","value":"\ud83d\udd25 Torch","color":"tertiary"}
                    {"type":"badge","value":"\ud83d\udde1\ufe0f Iron Sword","color":"secondary"},
                    {"type":"badge","value":"\ud83d\udee1\ufe0f Shield","color":"secondary"},
                    {"type":"badge","value":"\ud83e\udded Health Potion","color":"primary"},
                    {"type":"button","label":"Add Memory","variant":"filled","action":{"type":"callback","event":"add_memory"}},
                    {"type":"button","label":"Brainstorm","action":{"type":"callback","event":"brainstorm_sustainable_project","collectFrom":["sustainable_themes"]},"variant":"filled"}
                    {"type":"button","label":"Cancel","variant":"outlined","action":{"type":"callback","event":"cancel"}},
                    {"type":"button","label":"Export All","variant":"outlined","action":{"type":"callback","event":"export"}}
                    {"type":"button","label":"Filled","variant":"filled","action":{"type":"callback","event":"x"}},
                    {"type":"button","label":"Outlined","variant":"outlined","action":{"type":"callback","event":"x"}}
                    {"type":"button","label":"Save","variant":"filled","action":{"type":"callback","event":"save","collectFrom":["display_name","language","dark_mode","notifications","font_size","interests"]}}
                    {"type":"button","label":"Tonal","variant":"tonal","action":{"type":"callback","event":"x"}},
                    {"type":"chip_group","id":"sustainable_themes","chips":[
                    {"type":"column","children":[
                    {"type":"icon","name":"arrow_forward"}
                    {"type":"icon","name":"check","color":"success"},
                    {"type":"icon","name":"close"},
                    {"type":"icon","name":"delete","color":"error"},
                    {"type":"icon","name":"edit"},
                    {"type":"icon","name":"email"}
                    {"type":"icon","name":"favorite","color":"error"}
                    {"type":"icon","name":"favorite","color":"error"},
                    {"type":"icon","name":"home"},
                    {"type":"icon","name":"info"},
                    {"type":"icon","name":"notifications"},
                    {"type":"icon","name":"person"},
                    {"type":"icon","name":"refresh"}
                    {"type":"icon","name":"search"},
                    {"type":"icon","name":"settings"},
                    {"type":"icon","name":"share"},
                    {"type":"icon","name":"star","color":"primary"},
                    {"type":"icon","name":"warning","color":"warning"},
                    {"type":"quote","text":"What if we built a platform that helps individuals and businesses reduce their carbon footprint\u2014without sacrificing convenience?","source":"Hypothetical You"},
                    {"type":"row","children":[
                    {"type":"spacer","size":16},
                    {"type":"spacer","size":8},
                    {"type":"spacer"},
                    {"type":"stat","value":"$56K","label":"Revenue"},
                    {"type":"stat","value":"1,234","label":"Users","description":"↑ 12%"},
                    {"type":"stat","value":"1.2K","label":"Followers"},
                    {"type":"stat","value":"12","label":"Total"},
                    {"type":"stat","value":"127","label":"Posts"},
                    {"type":"stat","value":"2","label":"\ud83d\udee1\ufe0f DEF"},
                    {"type":"stat","value":"20/20","label":"\u2764\ufe0f HP"},
                    {"type":"stat","value":"3","label":"Promoted"},
                    {"type":"stat","value":"342","label":"Following"}
                    {"type":"stat","value":"5","label":"\u2694\ufe0f DMG"}
                    {"type":"stat","value":"50g","label":"\ud83d\udcb0 Gold"},
                    {"type":"stat","value":"87","label":"Recalled"}
                    {"type":"stat","value":"99.9%","label":"Uptime"}
                    {"type":"switch","id":"dark","label":"Dark mode"}
                    {"type":"text","value":"150g Pecorino Romano, finely grated"},
                    {"type":"text","value":"2 hours ago","style":"caption","color":"secondary"}
                    {"type":"text","value":"2 tsp black peppercorns"},
                    {"type":"text","value":"200g tonnarelli or spaghetti"},
                    {"type":"text","value":"A real-time carbon footprint tracker and reduction platform for individuals and businesses.","style":"body"},
                    {"type":"text","value":"Bread"},
                    {"type":"text","value":"Butter"}
                    {"type":"text","value":"Card Title","style":"title"},
                    {"type":"text","value":"Cards group related content together.","style":"body"}
                    {"type":"text","value":"Centered in a Box","style":"caption"}
                    {"type":"text","value":"Detailed information goes here.","style":"body"}
                    {"type":"text","value":"Eggs"},
                    {"type":"text","value":"Kai is a personal AI assistant that remembers your preferences and gets things done.","style":"body"}
                    {"type":"text","value":"Kai stores key facts about you locally and recalls them in future conversations.","style":"body"}
                    {"type":"text","value":"Let\u2019s design a project that merges technology with sustainability. Here\u2019s a concept to explore:","style":"body"},
                    {"type":"text","value":"Milk"},
                    {"type":"text","value":"Mix grated Pecorino with a few tablespoons of warm pasta water to form a smooth cream.","style":"body"}
                    {"type":"text","value":"Or, brainstorm a different sustainable tech project:","style":"title","bold":true},
                    {"type":"text","value":"Project Name: **EcoPulse**","style":"title","bold":true},
                    {"type":"text","value":"Row with icon and text","style":"body"},
                    {"type":"text","value":"Salt for pasta water"}
                    {"type":"text","value":"This shows general information.","style":"caption"}
                    {"type":"text","value":"Toast peppercorns in a dry pan until fragrant, crush coarsely. Boil pasta until al dente, reserve pasta water.","style":"body"}
                    {"type":"text","value":"Toss hot pasta with crushed pepper off heat. Add the Pecorino cream and toss vigorously, adding pasta water until silky.","style":"body"}
                    {"type":"text","value":"Welcome to the overview tab.","style":"body"},
                    {"type":"text","value":"Yes. All memory is stored on-device and never shared.","style":"body"}
                )
                ),
                FakeTextToSpeechInstance(),
                KaiUiRenderer(
                Theme(colorScheme = colorScheme) {
                ]}
                ]},
                isInteractive = true,
                modifier = Modifier.padding(12.dp),
                node = ui.node,
                onCallback = { _, _ -> },
                uiState = ChatUiState(
                wrapInCard = wrapInCard,
                {"label":"Details","children":[
                {"label":"Overview","children":[
                {"label":"Settings","children":[
                {"type":"accordion","title":"How does memory work?","children":[
                {"type":"accordion","title":"Is my data private?","children":[
                {"type":"accordion","title":"Step 1: Toast pepper & cook pasta","children":[
                {"type":"accordion","title":"Step 2: Make the sauce","children":[
                {"type":"accordion","title":"Step 3: Combine","children":[
                {"type":"accordion","title":"What is Kai?","expanded":true,"children":[
                {"type":"alert","severity":"error","title":"Error","message":"Something went wrong."}
                {"type":"alert","severity":"info","message":"Informational message"},
                {"type":"alert","severity":"info","title":"Info","message":"This is an informational alert."},
                {"type":"alert","severity":"success","title":"Success","message":"Operation completed successfully!"},
                {"type":"alert","severity":"warning","message":"\ud83d\udc7a Two orcs block the left passage! They sit around a small fire, gnawing on bones. They haven't noticed you yet."},
                {"type":"alert","severity":"warning","title":"Warning","message":"Please review before continuing."},
                {"type":"box","contentAlignment":"center","children":[
                {"type":"button","label":"Disabled Button","variant":"filled","enabled":false}
                {"type":"button","label":"Edit Profile","variant":"outlined","action":{"type":"callback","event":"edit_profile"}}
                {"type":"button","label":"Filled Button","variant":"filled","action":{"type":"callback","event":"click"}},
                {"type":"button","label":"Outlined Button","variant":"outlined","action":{"type":"callback","event":"click"}},
                {"type":"button","label":"Text Button","variant":"text","action":{"type":"callback","event":"click"}},
                {"type":"button","label":"Tonal Button","variant":"tonal","action":{"type":"callback","event":"click"}},
                {"type":"button","label":"\u2694\ufe0f Attack with sword","variant":"filled","action":{"type":"callback","event":"attack"}},
                {"type":"button","label":"\ud83d\udc68\u200d\ud83e\uddb2 Take the right tunnel","variant":"outlined","action":{"type":"callback","event":"right_tunnel"}}
                {"type":"button","label":"\ud83e\udd2b Sneak past in the shadows","variant":"outlined","action":{"type":"callback","event":"sneak"}},
                {"type":"card","children":[
                {"type":"checkbox","id":"agree","label":"I agree to the terms"},
                {"type":"checkbox","id":"c1","label":"Checkbox option"},
                {"type":"chip_group","id":"ch1","selection":"multi","chips":[{"label":"Tag 1","value":"1"},{"label":"Tag 2","value":"2"},{"label":"Tag 3","value":"3"}]},
                {"type":"chip_group","id":"interests","selection":"multi","chips":[
                {"type":"chip_group","id":"mood","chips":[
                {"type":"chip_group","id":"tags","selection":"multi","chips":[
                {"type":"code","language":"kotlin","code":"fun greet(name: String): String {\n    return \"Hello, ${'$'}name!\"\n}"}
                {"type":"code","language":"kotlin","code":"println(\"Hello\")"},
                {"type":"countdown","seconds":14400,"label":"Next meeting in"}
                {"type":"countdown","seconds":3723,"label":"Time remaining"},
                {"type":"countdown","seconds":600,"label":"Countdown"},
                {"type":"divider"},
                {"type":"image","url":"preview://image"},
                {"type":"list","ordered":false,"items":[
                {"type":"list","ordered":true,"items":[
                {"type":"list","ordered":true,"items":[{"type":"text","value":"First item"},{"type":"text","value":"Second item"}]},
                {"type":"progress","label":"Indeterminate"},
                {"type":"progress","label":"Sprint progress","value":0.65},
                {"type":"progress","label":"Upload progress","value":0.7},
                {"type":"progress","value":0.5,"label":"50%"},
                {"type":"quote","text":"Building the future, one line of code at a time."},
                {"type":"quote","text":"The only way to do great work is to love what you do.","source":"Steve Jobs"},
                {"type":"radio_group","id":"r1","label":"Radio","options":["Alpha","Beta","Gamma"],"selected":"Alpha"},
                {"type":"radio_group","id":"size","label":"Size","options":["Small","Medium","Large"],"selected":"Medium"},
                {"type":"row","children":[
                {"type":"select","id":"country","label":"Country","options":["USA","Germany","Japan","Brazil"],"selected":"Germany"},
                {"type":"select","id":"language","label":"Language","options":["English","German","Japanese","Portuguese"],"selected":"English"},
                {"type":"select","id":"sel1","label":"Dropdown","options":["Option A","Option B","Option C"]},
                {"type":"slider","id":"font_size","label":"Font Size","min":12,"max":24,"value":16,"step":1},
                {"type":"slider","id":"sl1","label":"Slider","value":50,"min":0,"max":100},
                {"type":"slider","id":"volume","label":"Volume","min":0,"max":100,"value":65,"step":5}
                {"type":"spacer","height":4},
                {"type":"spacer","height":8},
                {"type":"switch","id":"dark_mode","label":"Dark Mode","checked":true},
                {"type":"switch","id":"notifications","label":"Enable notifications"},
                {"type":"switch","id":"notifications","label":"Push Notifications","checked":false},
                {"type":"switch","id":"s1","label":"Toggle switch"},
                {"type":"table","headers":["Name","Value"],"rows":[["Alpha","100"],["Beta","200"]]},
                {"type":"table","headers":["Rank","Player","Score","Level"],
                {"type":"text","value":"Avatars","style":"title"},
                {"type":"text","value":"Badges","style":"title"},
                {"type":"text","value":"Body text with normal styling. This is the default text style used for paragraphs.","style":"body"},
                {"type":"text","value":"Bold text","bold":true},
                {"type":"text","value":"Button Variants","style":"title","bold":true},
                {"type":"text","value":"Buttons","style":"title"},
                {"type":"text","value":"Cacio e Pepe","style":"headline","bold":true},
                {"type":"text","value":"Caption text - smaller, secondary information","style":"caption"},
                {"type":"text","value":"Cards & Layout","style":"title","bold":true},
                {"type":"text","value":"Chapter 1 \u2022 The Beginning","style":"caption","color":"secondary"},
                {"type":"text","value":"Chips","style":"title"},
                {"type":"text","value":"Classic Roman pasta \u2022 2 servings","style":"caption","color":"secondary"},
                {"type":"text","value":"Code Block","style":"title","bold":true},
                {"type":"text","value":"Colored text","color":"primary"}
                {"type":"text","value":"Component Showcase","style":"headline","bold":true},
                {"type":"text","value":"Customize your experience","style":"caption"},
                {"type":"text","value":"Daily Dashboard","style":"headline","bold":true},
                {"type":"text","value":"Data","style":"title"},
                {"type":"text","value":"Display Elements","style":"headline","bold":true},
                {"type":"text","value":"FAQ","style":"title","bold":true},
                {"type":"text","value":"Facts & Preferences","style":"title","bold":true},
                {"type":"text","value":"Feedback","style":"title","bold":true},
                {"type":"text","value":"Feedback","style":"title"},
                {"type":"text","value":"Form Inputs","style":"title","bold":true},
                {"type":"text","value":"Headline Text","style":"headline","bold":true},
                {"type":"text","value":"Icons","style":"title","bold":true},
                {"type":"text","value":"Ingredients","style":"title"},
                {"type":"text","value":"Inputs","style":"title"},
                {"type":"text","value":"Instructions","style":"title"},
                {"type":"text","value":"Italic text","italic":true},
                {"type":"text","value":"Kai remembers what matters to you. Frequently used memories get promoted into the system prompt.","style":"body","color":"secondary"},
                {"type":"text","value":"Leaderboard","style":"title","bold":true},
                {"type":"text","value":"Multi Select","style":"title"},
                {"type":"text","value":"Our Memories","style":"headline","bold":true},
                {"type":"text","value":"Preferences","style":"headline","bold":true},
                {"type":"text","value":"Promoted","style":"title","bold":true,"color":"primary"},
                {"type":"text","value":"Quote","style":"title"},
                {"type":"text","value":"Recent Activity","style":"title"},
                {"type":"text","value":"Shopping List","style":"title","bold":true},
                {"type":"text","value":"Single Select","style":"title"},
                {"type":"text","value":"Stats","style":"title"},
                {"type":"text","value":"Sustainable Tech Project \uD83C\uDF31","style":"headline","bold":true},
                {"type":"text","value":"The tunnel forks. To the left, faint firelight flickers. To the right, silence — and a cold draft that makes your torch sputter.","style":"body"},
                {"type":"text","value":"Title Text","style":"title"},
                {"type":"text","value":"Upcoming","style":"title"},
                {"type":"text","value":"Wednesday, April 2","style":"caption"},
                {"type":"text","value":"You descend deeper into the darkness. The air grows thick with the smell of damp stone and something rotten. Your torchlight dances across crude carvings on the walls — warnings, perhaps, from those who came before. A low growl echoes from somewhere ahead.","style":"body"},
                {"type":"text","value":"\u2694\ufe0f The Goblin Tunnels","style":"headline","bold":true},
                {"type":"text","value":"\ud83c\udf92 Inventory","style":"title"},
                {"type":"text_input","id":"bio","label":"Bio","placeholder":"Tell us about yourself","multiline":true},
                {"type":"text_input","id":"display_name","label":"Display Name","value":"Simon"},
                {"type":"text_input","id":"i1","label":"Text Field","placeholder":"Type here..."},
                {"type":"text_input","id":"name","label":"Full Name","placeholder":"Enter your name"},
                }
            """]}""" +
            """]},""" +
            """{"type":"button","label":"17 sheep","variant":"outlined","action":{"type":"callback","event":"answer","data":{"value":"17"}}},""" +
            """{"type":"button","label":"8 sheep","variant":"outlined","action":{"type":"callback","event":"answer","data":{"value":"8"}}},""" +
            """{"type":"button","label":"9 sheep","variant":"outlined","action":{"type":"callback","event":"answer","data":{"value":"9"}}},""" +
            """{"type":"card","children":[""" +
            """{"type":"column","children":[
            """{"type":"column","children":[""" +
            """{"type":"countdown","seconds":45,"label":"Time remaining"},""" +
            """{"type":"divider"},""" +
            """{"type":"progress","value":0.4,"label":"4 of 10"},""" +
            """{"type":"spacer","height":8},""" +
            """{"type":"tabs","tabs":[
            """{"type":"text","value":"A farmer has 17 sheep. All but 9 run away. How many sheep does the farmer have left?","style":"body"}""" +
            """{"type":"text","value":"Brain Teaser #4","style":"headline","bold":true},""" +
            """{"type":"text","value":"Question 4 of 10","style":"caption","color":"secondary"}""" +
            """{"type":"text","value":"Select your answer:","style":"title"},""" +
            "\n```"
            "android:Theme.Material.Light.NoActionBar"
            "android:Theme.Material.NoActionBar"
            )
            ChatScreenContent(
            CompositionLocalProvider(LocalInspectionMode provides true) {
            CompositionLocalProvider(LocalPreviewImages provides mapOf(imageUrl to imageBitmap)) {
            KaiUiRenderer(
            ],"selectedIndex":0}""",
            ]}""",
            colorScheme = LightColorScheme,
            deviceConfig = DeviceConfig.PIXEL_9A.copy(softButtons = false),
            imageResource = "/cacio_e_pepe.png",
            imageResource = "/orc_survival.png",
            json = """{"type":"column","children":[
            theme = theme,
            }
        )
        colorScheme: ColorScheme = DarkColorScheme,
        colorScheme: ColorScheme,
        content: @Composable () -> Unit,
        deviceConfig = DeviceConfig.PIXEL_9A.copy(softButtons = false),
        imageResource: String,
        imageUrl: String = "preview://image",
        json: String,
        maxPercentDifference = 0.1,
        paparazzi.snapFullScreen(LightColorScheme) {
        paparazzi.snapKaiUi(
        paparazzi.snapKaiUi(kaiUiJson)
        paparazzi.snapKaiUiWithImage(
        setResourceReaderAndroidContext(paparazzi.context)
        showSystemUi = false,
        snap(colorScheme) {
        snapshot {
        unsafeUpdateConfig(
        unsafeUpdateConfig(theme = theme)
        val bitmap = BitmapFactory.decodeStream(javaClass.getResourceAsStream(imageResource))
        val imageBitmap = bitmap.asImageBitmap()
        val kaiUiContent = "```kai-ui\n" +
        val kaiUiJson = """{"type":"column","children":[{"type":"text","value":"\u23f1\ufe0f Time's Up!","style":"headline","bold":true},{"type":"alert","message":"You didn't submit your answers in time!","severity":"warning"},{"type":"card","children":[{"type":"text","value":"Score: 0/3","style":"headline","bold":true},{"type":"text","value":"The clock beat you this round.","style":"body"}]},{"type":"divider"},{"type":"text","value":"Here are the answers:","style":"title"},{"type":"accordion","title":"Q1: 64, 32, 16, 8, 4, ? = 2","expanded":false,"children":[{"type":"text","value":"Dividing by 2 each time. Classic halving sequence.","style":"body"}]},{"type":"accordion","title":"Q2: Odd shape = Circle","expanded":false,"children":[{"type":"text","value":"Circle is the only shape without straight lines or angles.","style":"body"}]},{"type":"accordion","title":"Q3: 100 machines, 100 widgets = 5 minutes","expanded":false,"children":[{"type":"text","value":"If 5 machines take 5 minutes to make 5 widgets, each machine makes 1 widget in 5 minutes. So 100 machines make 100 widgets in 5 minutes.","style":"body"}]},{"type":"divider"},{"type":"button","label":"Try Again","action":{"type":"callback","event":"retry"},"variant":"filled"}]}"""
        val theme = if (colorScheme == DarkColorScheme) {
        val ui = KaiUiParser.parseUiBlockBody(json) as UiBlockResult.Ui
        wrapInCard: Boolean = true,
        }
        } else {
    )
    ) {
    // --- All elements combined (light) ---
    // --- Buttons ---
    // --- Chips ---
    // --- Code block ---
    // --- Data: List ---
    // --- Data: Table ---
    // --- Display elements (quote, badge, stat, avatar) ---
    // --- Feedback ---
    // --- Form inputs ---
    // --- Icons ---
    // --- Layout ---
    // --- Navigation: Accordion ---
    // --- Navigation: Tabs ---
    // --- Scenario: Dashboard ---
    // --- Scenario: Memories ---
    // --- Scenario: Quiz in progress (full chat screen) ---
    // --- Scenario: Quiz with timer expired ---
    // --- Scenario: Recipe card ---
    // --- Scenario: Settings form ---
    // --- Scenario: Survival game ---
    // --- Scenario: Sustainable tech brainstorm ---
    // --- Scenario: User profile ---
    // --- Text styles ---
    @Before
    @Test
    @get:Rule
    fun accordion() {
    fun allElements_light() {
    fun buttonVariants() {
    fun chipGroup() {
    fun codeBlock() {
    fun displayElements() {
    fun feedbackElements() {
    fun formInputs() {
    fun icons() {
    fun layoutElements() {
    fun list() {
    fun scenario_dashboard_dark() {
    fun scenario_memories_dark() {
    fun scenario_quizInProgress_light() {
    fun scenario_quizTimerExpired_dark() {
    fun scenario_recipeCard_light() {
    fun scenario_settingsForm_light() {
    fun scenario_survivalGame_dark() {
    fun scenario_sustainableTech_light() {
    fun scenario_userProfile_dark() {
    fun setup() {
    fun table() {
    fun tabs() {
    fun textStyles() {
    private fun Paparazzi.snap(
    private fun Paparazzi.snapFullScreen(
    private fun Paparazzi.snapKaiUi(
    private fun Paparazzi.snapKaiUiWithImage(
    val paparazzi = Paparazzi(
    }
 * Screenshot tests for all kai-ui component types and realistic screen scenarios.
 */
/**
@OptIn(ExperimentalResourceApi::class)
@file:OptIn(ExperimentalVoiceApi::class)
class KaiUiScreenshotTest {
package com.inspiredandroid.kai.screenshots
}
