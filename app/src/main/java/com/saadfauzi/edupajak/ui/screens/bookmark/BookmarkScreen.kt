package com.saadfauzi.edupajak.ui.screens.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.ui.components.*
import com.saadfauzi.edupajak.utilities.StateManagement

@Composable
fun BookmarkScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val bookmarkViewModel = hiltViewModel<BookmarkViewModel>()

    bookmarkViewModel.allBookmarkedTaxes.collectAsState(StateManagement.Loading).value.let { state ->
        when (state) {
            is StateManagement.Loading -> LoadingIndicator()
            is StateManagement.Error -> ErrorContent()
            is StateManagement.Success -> {
                FavoriteContent(
                    bookmarkedTaxes = state.data,
                    navController = navController,
                    scaffoldState = scaffoldState,
                    onUpdateBookmarkedTaxes = bookmarkViewModel::updateFavoriteTourism
                )
            }
        }
    }
}

@Composable
fun FavoriteContent(
    bookmarkedTaxes: List<PajakEntity>,
    navController: NavController,
    scaffoldState: ScaffoldState,
    onUpdateBookmarkedTaxes: (id: Int, isFavorite: Boolean) -> Unit
) {
    Column {
        TopAppBar()
        when (bookmarkedTaxes.isEmpty()) {
            true -> EmptyContent()
            false -> AvailableData(bookmarkedTaxes, navController, scaffoldState, onUpdateBookmarkedTaxes)
        }
    }
}