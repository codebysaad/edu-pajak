package com.saadfauzi.edupajak.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.ui.components.*
import com.saadfauzi.edupajak.utilities.StateManagement

@Composable
fun HomeScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val homeState by homeViewModel.homeState

    homeViewModel.allTaxes.collectAsState(StateManagement.Loading).value.let { state ->
        when (state) {
            is StateManagement.Loading -> LoadingIndicator()
            is StateManagement.Error -> ErrorContent()
            is StateManagement.Success -> {
                HomeContent(
                    listTaxes = state.data,
                    navController = navController,
                    scaffoldState = scaffoldState,
                    query = homeState.query,
                    onQueryChange = homeViewModel::onQueryChange,
                    onUpdateBookmarkedTaxes = homeViewModel::updateFavoriteTourism
                )
                Log.i("HomeScreen", state.data.toString())
            }
        }
    }
}

@Composable
fun HomeContent(
    listTaxes: List<PajakEntity>,
    navController: NavController,
    scaffoldState: ScaffoldState,
    query: String,
    onQueryChange: (String) -> Unit,
    onUpdateBookmarkedTaxes: (id: Int, isBookmarked: Boolean) -> Unit
) {
    Column {
        TopAppBar()
        SearchBar(query = query, onQueryChange = onQueryChange)
        when (listTaxes.isEmpty()) {
            true -> EmptyContent()
            false -> AvailableData(listTaxes, navController, scaffoldState, onUpdateBookmarkedTaxes)
        }
    }
}

