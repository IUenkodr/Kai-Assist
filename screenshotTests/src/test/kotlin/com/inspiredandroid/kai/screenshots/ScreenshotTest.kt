
                    content()
                FakeTextToSpeechInstance(),
                LocalInspectionMode provides true,
                LocalPreviewImages provides previewImages,
                Theme(colorScheme = colorScheme) {
                initialSandboxOpen = true,
                isSandboxAvailable = true,
                previewSandboxLines = ScreenshotTestData.sandboxTerminalLines,
                previewSandboxState = ScreenshotTestData.sandboxState,
                sandboxState = ScreenshotTestData.sandboxState,
                uiState = ScreenshotTestData.chatEmptyState,
                uiState = ScreenshotTestData.chatWithDynamicUi,
                uiState = ScreenshotTestData.chatWithMessages,
                uiState = ScreenshotTestData.freeConnected,
                uiState = ScreenshotTestData.settingsAgent,
                uiState = ScreenshotTestData.settingsTools,
                }
            "android:Theme.Material.Light.NoActionBar"
            "android:Theme.Material.NoActionBar"
            )
            ) {
            ChatScreenContent(
            CompositionLocalProvider(
            SettingsScreenContent(
            }
        colorScheme: ColorScheme,
        content: @Composable () -> Unit,
        deviceConfig = DeviceConfig.PIXEL_9A.copy(softButtons = false),
        loadPreviewImage("resource://cacio_e_pepe.png", "/cacio_e_pepe.png")
        loadPreviewImage("resource://orc_survival.png", "/orc_survival.png")
        maxPercentDifference = 0.1,
        paparazzi.snap(DarkColorScheme) {
        paparazzi.snap(LightColorScheme) {
        previewImages[key] = bitmap.asImageBitmap()
        setResourceReaderAndroidContext(paparazzi.context)
        showSystemUi = true,
        snapshot {
        unsafeUpdateConfig(theme = theme)
        val bitmap = BitmapFactory.decodeStream(javaClass.getResourceAsStream(resourcePath)) ?: return
        val theme = if (colorScheme == DarkColorScheme) {
        }
        } else {
    )
    ) {
    @Before
    @Test
    @get:Rule
    fun Paparazzi.snap(
    fun chatEmptyState_light() {
    fun chatWithDynamicUi_light() {
    fun chatWithMessages_dark() {
    fun settingsAgent_dark() {
    fun settingsFree_dark() {
    fun settingsSandbox_dark() {
    fun settingsTools_light() {
    fun setup() {
    private fun loadPreviewImage(key: String, resourcePath: String) {
    private val previewImages = mutableMapOf<String, ImageBitmap>()
    val paparazzi = Paparazzi(
    }
@OptIn(ExperimentalResourceApi::class)
@file:OptIn(ExperimentalVoiceApi::class)
class ScreenshotTest {
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
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.setResourceReaderAndroidContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test
package com.inspiredandroid.kai.screenshots
}
