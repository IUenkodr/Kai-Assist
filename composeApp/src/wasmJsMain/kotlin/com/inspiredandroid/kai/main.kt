
                        "#settings"
                    else -> ""
                    navController.navigate(Home)
                    navController.navigate(Settings)
                    route.startsWith(Settings.serializer().descriptor.serialName) -> {
                    }
                else -> {
                initRoute.endsWith("settings") -> {
                val route = entry.destination.route.orEmpty()
                when {
                }
            navController = navController,
            navController.bindToBrowserNavigation { entry ->
            null
            rememberTextToSpeechOrNull(TextToSpeechEngine.Google)
            textToSpeech = textToSpeech,
            val initRoute = window.location.hash.substringAfter('#', "")
            when {
            }
        )
        // Defer TTS initialization until after the first frame
        App(
        LaunchedEffect(Unit) {
        LaunchedEffect(Unit) { ttsReady = true }
        val navController = rememberNavController()
        val textToSpeech = if (ttsReady) {
        var ttsReady by remember { mutableStateOf(false) }
        }
        } else {
    ComposeViewport(body) {
    document.getElementById("loader")?.remove()
    val body = document.body ?: return
    }
@OptIn(ExperimentalComposeUiApi::class)
@file:OptIn(ExperimentalBrowserHistoryApi::class)
@file:Suppress("ktlint:standard:filename")
fun main() {
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import androidx.navigation.compose.rememberNavController
import kotlinx.browser.document
import kotlinx.browser.window
import nl.marc_apps.tts.TextToSpeechEngine
import nl.marc_apps.tts.rememberTextToSpeechOrNull
package com.inspiredandroid.kai
}
