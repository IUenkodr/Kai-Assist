package com.inspiredandroid.kai
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.navigation.compose.rememberNavController
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.logo
import nl.marc_apps.tts.TextToSpeechEngine
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.experimental.ExperimentalDesktopTarget
import nl.marc_apps.tts.rememberTextToSpeechOrNull
import org.jetbrains.compose.resources.painterResource

                navController = navController,
                null
                rememberTextToSpeechOrNull(TextToSpeechEngine.Google)
                textToSpeech = textToSpeech,
            )
            // Defer TTS initialization until after the first frame
            App(
            LaunchedEffect(Unit) { ttsReady = true }
            icon = painterResource(Res.drawable.logo),
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Kai 9000",
            val navController = rememberNavController()
            val textToSpeech: TextToSpeechInstance? = if (ttsReady) {
            var ttsReady by remember { mutableStateOf(false) }
            }
            } else {
        ) {
        System.setProperty("sun.java2d.uiScale", "auto")
        System.setProperty("sun.java2d.uiScale.enabled", "true")
        Window(
        val windowState = rememberWindowState(size = DpSize(1280.dp, 800.dp))
        }
    // Help AWT/Skiko pick up HiDPI on Linux/Wayland (Sway, GNOME fractional scaling).
    // Without this, the JVM ignores GDK_SCALE and renders at 1× on a hi-res monitor.
    System.setProperty("apple.awt.application.appearance", "system")
    application {
    if (System.getProperty("sun.java2d.uiScale") == null) {
    if (System.getProperty("sun.java2d.uiScale.enabled") == null) {
    }
@file:OptIn(ExperimentalDesktopTarget::class)
@file:Suppress("ktlint:standard:filename")
fun main() {
}
