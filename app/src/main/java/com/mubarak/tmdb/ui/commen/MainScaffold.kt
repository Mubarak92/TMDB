package com.mubarak.tmdb.ui.commen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.navigation.compose.rememberNavController
import com.mubarak.tmdb.ui.screens.NavGraphs
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.ramcosta.composedestinations.DestinationsNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold() {
    SetStatusBarColor(DarkBlue)
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Box (modifier = Modifier.padding(it)){
            DestinationsNavHost(
                modifier = Modifier.focusTarget(),
                navController = navController,
                navGraph = NavGraphs.root
            )
        }
    }
}