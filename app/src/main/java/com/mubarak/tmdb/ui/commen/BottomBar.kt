package com.mubarak.tmdb.ui.commen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.mubarak.tmdb.ui.screens.NavGraphs
import com.mubarak.tmdb.ui.screens.appCurrentDestinationAsState
import com.mubarak.tmdb.ui.screens.destinations.Destination
import com.mubarak.tmdb.ui.screens.destinations.DirectionDestination
import com.mubarak.tmdb.ui.screens.destinations.DiscoverScreenDestination
import com.mubarak.tmdb.ui.screens.destinations.FavoriteScreenDestination
import com.mubarak.tmdb.ui.screens.destinations.MainScreenDestination
import com.mubarak.tmdb.ui.screens.destinations.PeopleScreenDestination
import com.mubarak.tmdb.ui.screens.destinations.SettingsScreenDestination
import com.mubarak.tmdb.ui.screens.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomBar(
    navController: NavController,
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    NavigationBar () {
        BottomBarDestination.values().forEach { destination ->
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
                        if (firstBottomBarDestination != null) {
                            popUpTo(firstBottomBarDestination.id) {
                                inclusive = false
                                saveState = false
                            }
                        }
                        launchSingleTop = true
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
    HOME(MainScreenDestination, Icons.Default.Home, com.mubarak.tmdb.R.string.home),
    PEOPLE(PeopleScreenDestination, Icons.Default.Person, com.mubarak.tmdb.R.string.people),
    DISCOVER(DiscoverScreenDestination, Icons.Default.List, com.mubarak.tmdb.R.string.discover),
    FAVORITE(FavoriteScreenDestination, Icons.Default.Favorite, com.mubarak.tmdb.R.string.favorite),
    SETTINGS(SettingsScreenDestination, Icons.Default.Settings, com.mubarak.tmdb.R.string.settings),
}