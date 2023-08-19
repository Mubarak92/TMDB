package com.mubarak.tmdb

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.mubarak.tmdb.ui.commen.MainScaffold
import com.mubarak.tmdb.ui.screens.settings.LocaleManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
