package com.inspiredandroid.kai
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.ui.DarkColorScheme
import com.inspiredandroid.kai.ui.LightColorScheme
import io.github.vinceglb.filekit.FileKit
import io.github.vinceglb.filekit.dialogs.init
import nl.marc_apps.tts.TextToSpeechEngine
import nl.marc_apps.tts.TextToSpeechFactory
import nl.marc_apps.tts.TextToSpeechInstance
import org.koin.android.ext.android.get

                            android.graphics.Color.TRANSPARENT,
                        )
                        SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
                        SystemBarStyle.light(
                        requestReview(this@MainActivity)
                    if (appOpens % 5 == 0) {
                    navigationBarStyle = if (isDarkTheme) {
                    statusBarStyle = if (isDarkTheme) {
                    }
                    } else {
                    },
                )
                .orEmpty()
                ?.toString()
                ?.trim()
                ThemeMode.Dark, ThemeMode.OledBlack -> true
                ThemeMode.Light -> false
                ThemeMode.System -> systemInDark
                darkColorScheme = darkScheme,
                dataRepository.requestOpenShare(sharedText)
                enableEdgeToEdge(
                isKoinStarted = true,
                lightColorScheme = lightScheme,
                navController = navController,
                null
                onAppOpens = { appOpens ->
                rememberSystemTextToSpeechOrNull()
                textToSpeech = textToSpeech,
                val dataRepository: DataRepository = get()
                },
            )
            // ChatViewModel has already consumed it.
            // Clear the action so a configuration change doesn't re-trigger a fresh
            // Defer TTS initialization until after the first frame
            // Drop the action and extra so rotation doesn't re-apply the share after
            // Drop the extra so a configuration change (screen rotation) doesn't re-trigger
            // chat after ChatViewModel has already consumed the request.
            // the deep-link after ChatViewModel has already consumed it.
            ?: TextToSpeechFactory(context, TextToSpeechEngine.Google).createOrNull()
            App(
            LaunchedEffect(Unit) { ttsReady = true }
            LaunchedEffect(isDarkTheme) {
            daemonController.start()
            dataRepository.requestOpenAssist()
            dataRepository.requestOpenHeartbeat()
            if (sharedText.isNotEmpty()) {
            intent.action = null
            intent.removeExtra(EXTRA_OPEN_HEARTBEAT)
            intent.removeExtra(Intent.EXTRA_TEXT)
            textToSpeech = null
            textToSpeech?.close()
            val context = LocalContext.current
            val darkScheme: ColorScheme = if (dynamicColor) dynamicDarkColorScheme(context) else DarkColorScheme
            val dataRepository: DataRepository = get()
            val isDarkTheme = when (themeMode) {
            val lightScheme: ColorScheme = if (dynamicColor) dynamicLightColorScheme(context) else LightColorScheme
            val navController = rememberNavController()
            val sharedText = intent.getCharSequenceExtra(Intent.EXTRA_TEXT)
            val systemInDark = isSystemInDarkTheme()
            val textToSpeech = if (ttsReady) {
            val themeMode by appSettings.themeModeFlow.collectAsStateWithLifecycle()
            var ttsReady by remember { mutableStateOf(false) }
            }
            } else {
        // EMUI/Huawei) sometimes kill the foreground service while the activity
        // Re-assert the daemon every time the activity is brought to the foreground.
        // `onCreate`-only is not enough: aggressive OEM battery managers (MIUI,
        // close and reopen the app for scheduling to resume. `startForegroundService`
        // is idempotent when the service is already up.
        // is still alive in the background — without this, the user has to fully
        FileKit.init(this)
        autoStartDaemon()
        enableEdgeToEdge()
        handleDeepLinkIntent(intent)
        if (daemonController is AndroidDaemonController && daemonController.shouldAutoStart()) {
        if (intent?.action == Intent.ACTION_ASSIST) {
        if (intent?.action == Intent.ACTION_SEND) {
        if (intent?.getBooleanExtra(EXTRA_OPEN_HEARTBEAT, false) == true) {
        onDispose {
        setContent {
        setIntent(intent)
        super.onCreate(savedInstanceState)
        super.onNewIntent(intent)
        super.onStart()
        textToSpeech = TextToSpeechFactory(context, TextToSpeechEngine.SystemDefault).createOrNull()
        val appSettings: AppSettings = get()
        val daemonController: DaemonController = get()
        val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
        }
    App(navController = rememberNavController())
    DisposableEffect(Unit) {
    LaunchedEffect(Unit) {
    override fun onCreate(savedInstanceState: Bundle?) {
    override fun onNewIntent(intent: Intent) {
    override fun onStart() {
    private fun autoStartDaemon() {
    private fun handleDeepLinkIntent(intent: Intent?) {
    return textToSpeech
    val context = LocalContext.current.applicationContext
    var textToSpeech by remember { mutableStateOf<TextToSpeechInstance?>(null) }
    }
 * Google's engine is only used when the system default fails to initialise, which happens on
 * Speaks with the engine the user selected in the system text-to-speech settings, so a
 * devices where no default engine is configured.
 * third-party engine (Sherpa, RHVoice, eSpeak, ...) is honoured instead of being overridden.
 */
/**
@Composable
@Preview
class MainActivity : ComponentActivity() {
fun AppAndroidPreview() {
private fun rememberSystemTextToSpeechOrNull(): TextToSpeechInstance? {
}
