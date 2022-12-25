package com.saadfauzi.edupajak.ui.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Bookmark : Screens("bookmark")
    object Profile : Screens("profile")
    object Detail : Screens("home/{pajakId}") {
        fun createRoute(pajakId: Int) = "home/$pajakId"
    }
}
