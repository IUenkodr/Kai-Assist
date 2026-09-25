package com.inspiredandroid.kai.screenshots
import android.graphics.BitmapFactory
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.inspiredandroid.kai.ui.DarkColorScheme
import com.inspiredandroid.kai.ui.LightColorScheme
import com.inspiredandroid.kai.ui.Theme
import com.inspiredandroid.kai.ui.chat.ChatScreenContent
import com.inspiredandroid.kai.ui.dynamicui.LocalPreviewImages
import com.inspiredandroid.kai.ui.settings.SettingsScreenContent
import java.util.Locale
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.setResourceReaderAndroidContext
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

                    content()
                FakeTextToSpeechInstance(),
                LocalInspectionMode provides true,
                LocalPreviewImages provides previewImages,
                Theme(colorScheme = colorScheme) {
                initialSandboxOpen = true,
                isSandboxAvailable = true,
                locale = deviceLocale,
                previewSandboxLines = ScreenshotTestData.sandboxTerminalLines,
                previewSandboxState = ScreenshotTestData.sandboxState,
                softButtons = false,
                uiState = ScreenshotTestData.chatEmptyState,
                uiState = ScreenshotTestData.localizedChatWithDynamicUi(locale),
                uiState = ScreenshotTestData.localizedChatWithMessages(locale),
                }
            "${parts[0]}-r${parts[1]}"
            "android:Theme.Material.Light.NoActionBar"
            "android:Theme.Material.NoActionBar"
            )
            ) {
            ),
            ChatScreenContent(
            CompositionLocalProvider(
            Locale(locale)
            Locale(parts[0], parts[1])
            SettingsScreenContent(uiState = ScreenshotTestData.freeConnected)
            SettingsScreenContent(uiState = ScreenshotTestData.settingsAgent)
            SettingsScreenContent(uiState = ScreenshotTestData.settingsTools)
            deviceConfig = DeviceConfig.PIXEL_9A.copy(
            locale
            val parts = locale.split("-")
            }
        )
        @JvmStatic
        @Parameterized.Parameters(name = "{1}")
        Locale.setDefault(newLocale)
        Locale.setDefault(originalLocale)
        colorScheme: ColorScheme,
        content: @Composable () -> Unit,
        deviceConfig = DeviceConfig.PIXEL_9A.copy(softButtons = false),
        fun locales() = StoreLocales.all
        loadPreviewImage("resource://cacio_e_pepe.png", "/cacio_e_pepe.png")
        loadPreviewImage("resource://orc_survival.png", "/orc_survival.png")
        name: String,
        originalLocale = Locale.getDefault()
        paparazzi.snapshot(name = "store_${playStoreLocale}_$name") {
        paparazzi.unsafeUpdateConfig(
        paparazzi.unsafeUpdateConfig(theme = theme)
        previewImages[key] = bitmap.asImageBitmap()
        setResourceReaderAndroidContext(paparazzi.context)
        showSystemUi = true,
        snap("01", LightColorScheme) {
        snap("02", DarkColorScheme) {
        snap("03", LightColorScheme) {
        snap("04", DarkColorScheme) {
        snap("05", LightColorScheme) {
        snap("06", DarkColorScheme) {
        snap("07", DarkColorScheme) {
        useDeviceResolution = true,
        val bitmap = BitmapFactory.decodeStream(javaClass.getResourceAsStream(resourcePath)) ?: return
        val deviceLocale = if (locale.contains("-")) {
        val newLocale = if (locale.contains("-")) {
        val theme = if (colorScheme == DarkColorScheme) {
        }
        } else {
    )
    ) {
    @After
    @Before
    @OptIn(ExperimentalResourceApi::class)
    @Test
    @get:Rule
    companion object {
    fun chatEmptyState() {
    fun chatWithDynamicUi() {
    fun chatWithMessages() {
    fun settingsAgent() {
    fun settingsFree() {
    fun settingsSandbox() {
    fun settingsTools() {
    fun setup() {
    fun tearDown() {
    private fun loadPreviewImage(key: String, resourcePath: String) {
    private fun snap(
    private lateinit var originalLocale: Locale
    private val locale: String,
    private val playStoreLocale: String,
    private val previewImages = mutableMapOf<String, ImageBitmap>()
    val paparazzi = Paparazzi(
    }
) {
@RunWith(Parameterized::class)
@file:OptIn(ExperimentalVoiceApi::class)
class StoreScreenshotTest(
}
