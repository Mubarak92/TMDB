package com.mubarak.tmdb.ui.screens.settings

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.Destination
import java.util.Locale

@Destination
@Composable
fun SettingsScreen() {
    val context = LocalContext.current

    Column {
        Button(onClick = { LocaleManager.setLocale(context, "ar") }) {
            Text(text = "Arabic")
        }

        Button(onClick = { LocaleManager.setLocale(context, "en-US") }) {
            Text(text = "English")
        }
    }
}



object LocaleManager {
     const val PREF_SELECTED_LANGUAGE = "selected_language"

    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Save selected language to SharedPreferences
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(PREF_SELECTED_LANGUAGE, languageCode).apply()
    }

    fun getSavedLocale(context: Context): Locale {
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val savedLanguage = sharedPreferences.getString(PREF_SELECTED_LANGUAGE, "en") ?: "en"
        return Locale(savedLanguage)
    }
}