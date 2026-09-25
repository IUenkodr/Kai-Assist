import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController
import nl.marc_apps.tts.TextToSpeechEngine
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.rememberTextToSpeechOrNull

        navController = navController,
        null
        rememberTextToSpeechOrNull(TextToSpeechEngine.SystemDefault)
        textToSpeech = textToSpeech,
    )
    // Defer TTS initialization until after the first frame
    App(
    LaunchedEffect(Unit) { ttsReady = true }
    val navController = rememberNavController()
    val textToSpeech: TextToSpeechInstance? = if (ttsReady) {
    var ttsReady by remember { mutableStateOf(false) }
    }
    } else {
fun MainViewController() = ComposeUIViewController {
package com.inspiredandroid.kai
}
