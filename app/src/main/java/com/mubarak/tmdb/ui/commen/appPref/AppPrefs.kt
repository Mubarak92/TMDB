package com.mubarak.tmdb.ui.commen.appPref

import android.content.Context
import android.content.SharedPreferences
import com.mubarak.tmdb.ui.screens.settings.LocaleManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPrefs @Inject constructor(
    @ApplicationContext private val context: Context
) : IAppPrefs {
    // This preference is not cleared/deleted when the user logs out
    private var appConfigPreference: SharedPreferences = context.applicationContext.getSharedPreferences(
        APP_PREF_CONFIG, Context.MODE_PRIVATE
    )

    private fun defaultLang(): String {
        val savedLocale = LocaleManager.getSavedLocale(context).toLanguageTag()
        val isLangSupported = savedLocale in supportedLang
        return if (isLangSupported) savedLocale else ENGLISH
    }

    override var locale: String
        get() = appConfigPreference.getString(PREF_LOCALE, null) ?: defaultLang()
        set(value) {
            appConfigPreference.edit().putString(PREF_LOCALE, value).apply()
        }


    companion object {
        private const val ENGLISH = "en-US"
        private const val ARABIC = "ar"
        private val supportedLang = arrayOf(ARABIC, ENGLISH)
        private const val APP_PREF_CONFIG = "APP_PREF_CONFIG"
        private const val PREF_LOCALE = "pref_locale"
    }
}