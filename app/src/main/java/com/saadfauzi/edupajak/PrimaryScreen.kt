package com.saadfauzi.edupajak

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.saadfauzi.edupajak.ui.navigation.NavigationItem
import com.saadfauzi.edupajak.ui.navigation.Screens
import com.saadfauzi.edupajak.ui.screens.bookmark.BookmarkScreen
import com.saadfauzi.edupajak.ui.screens.detail.DetailScreen
import com.saadfauzi.edupajak.ui.screens.home.HomeScreen
import com.saadfauzi.edupajak.ui.screens.profile.ProfileScreen

@Composable
fun PrimaryScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screens.Detail.route) {
                BottomBar(navController, currentRoute)
            }
        },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(hostState = it) { data ->
                Snackbar(snackbarData = data, shape = RoundedCornerShape(8.dp))
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(navController, scaffoldState)
            }
            composable(
                route = Screens.Detail.route,
                arguments = listOf(
                    navArgument("pajakId") { type = NavType.IntType }
                )
            ) {
                val tourismId = it.arguments?.getInt("pajakId") ?: 0
                DetailScreen(tourismId, navController, scaffoldState)
            }
            composable(Screens.Bookmark.route) {
                BookmarkScreen(navController, scaffoldState)
            }
            composable(Screens.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    currentRoute: String?,
) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Rounded.Home,
            screens = Screens.Home
        ),
        NavigationItem(
            title = "Bookmark",
            icon = Icons.Rounded.Favorite,
            screens = Screens.Bookmark
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Rounded.Person,
            screens = Screens.Profile
        ),
    )

    BottomNavigation(backgroundColor = Color.White) {
        navigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screens.route,
                selectedContentColor = MaterialTheme.colors.primaryVariant,
                unselectedContentColor = Color.Gray,
                onClick = {
                    navController.navigate(item.screens.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}