package com.mubarak.tmdb.ui.commen

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mubarak.tmdb.ui.screens.NavGraphs
import com.mubarak.tmdb.ui.screens.appCurrentDestinationAsState
import com.mubarak.tmdb.ui.screens.destinations.Destination
import com.mubarak.tmdb.ui.screens.destinations.DirectionDestination
import com.mubarak.tmdb.ui.screens.destinations.MainScreenDestination
import com.mubarak.tmdb.ui.screens.startAppDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Parent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }

    ) {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root
        )
    }
}

@SuppressLint("ResourceType")
@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    //if you are using material 2 then you  should use  bottom navigation bar
    NavigationBar {
        BottomBarDestination.values().forEach { destination ->
            //similarly with material 2  use bottom nav item
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                        val navigationRoutes = BottomBarDestination.values()

                        val firstBottomBarDestination =
                            navController.currentBackStack.value.firstOrNull() { navBackStackEntry ->
                                checkForDestinations(
                                    navigationRoutes,
                                    navBackStackEntry
                                )
                            }?.destination
                        // remove all navigation items from the stack
                        // so only the currently selected screen remains in the stack
                        if (firstBottomBarDestination != null) {
                            popUpTo(firstBottomBarDestination.id) {
                                inclusive = true
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}

fun checkForDestinations(
    navigationRoutes: Array<BottomBarDestination>,
    navBackStackEntry: NavBackStackEntry
): Boolean {
    navigationRoutes.forEach {
        if (it.direction.route == navBackStackEntry.destination.route) {
            return true
        }

    }
    return false
}


enum class BottomBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    HOME(MainScreenDestination, Icons.Default.Home, com.mubarak.tmdb.R.string.app_name),
    SETTINGS(MainScreenDestination, Icons.Default.Settings, com.mubarak.tmdb.R.string.music),

}