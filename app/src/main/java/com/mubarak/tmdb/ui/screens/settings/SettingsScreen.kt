package com.mubarak.tmdb.ui.screens.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.mubarak.tmdb.MainActivity
import com.ramcosta.composedestinations.annotation.Destination
import java.util.Locale

@Destination
@Composable
fun SettingsScreen() {
    val context = LocalContext.current as Activity
    val intent = Intent(context, MainActivity::class.java)
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            LocaleManager.setLocale(context, "ar")
            isLoading = isLoading.not()
            context.startActivity(intent)
            context.finish()
        }) {
            Text(text = "Arabic")

        }

        Button(onClick = {
            LocaleManager.setLocale(context, "en-US")
            isLoading = isLoading.not()
            context.startActivity(intent)
            context.finish()

        }) {
            Text(text = "English")
        }
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

    }
}


@Preview
@Composable
fun SettingsScreenPreView() {
    SettingsScreen()
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