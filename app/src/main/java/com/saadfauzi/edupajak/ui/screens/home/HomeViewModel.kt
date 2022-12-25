package com.saadfauzi.edupajak.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.data.repository.PajakRepository
import com.saadfauzi.edupajak.utilities.DataPajak
import com.saadfauzi.edupajak.utilities.StateManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PajakRepository) : ViewModel() {
    private val _allTaxes = MutableStateFlow<StateManagement<List<PajakEntity>>>(StateManagement.Loading)
    val allTaxes = _allTaxes.asStateFlow()

    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> = _homeState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllTaxes().collect { taxes ->
                when (taxes.isEmpty()) {
                    true -> repository.insertAllTaxes(DataPajak.taxes)
                    else -> _allTaxes.value = StateManagement.Success(taxes)
                }
            }
        }
    }

    private fun searchTourism(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchTaxes(query)
                .catch { _allTaxes.value = StateManagement.Error(it.message.toString()) }
                .collect { _allTaxes.value = StateManagement.Success(it) }
        }
    }

    fun updateFavoriteTourism(id: Int, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookmarkedTaxes(id, isFavorite)
        }
    }

    fun onQueryChange(query: String) {
        _homeState.value = _homeState.value.copy(query = query)
        searchTourism(query)
    }
}