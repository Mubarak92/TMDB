package com.mubarak.tmdb

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mubarak.tmdb.ui.commen.MainScaffold
import com.mubarak.tmdb.ui.commen.SplashViewModel
import com.mubarak.tmdb.ui.screens.settings.LocaleManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            val context = LocalContext.current

            val savedLocale = LocaleManager.getSavedLocale(context)

            CompositionLocalProvider(LocalContext provides context) {
                    val resources = context.resources
                    val config = Configuration(resources.configuration)
                    config.setLocale(savedLocale)
                    resources.updateConfiguration(config, resources.displayMetrics)
                    MainScaffold()
            }
        }
    }
}
