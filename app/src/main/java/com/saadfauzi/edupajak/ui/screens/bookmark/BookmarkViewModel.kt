package com.saadfauzi.edupajak.ui.screens.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadfauzi.edupajak.data.local.PajakEntity
import com.saadfauzi.edupajak.data.repository.PajakRepository
import com.saadfauzi.edupajak.utilities.StateManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val repository: PajakRepository) : ViewModel() {
    private val _allBookmarkedTaxes = MutableStateFlow<StateManagement<List<PajakEntity>>>(StateManagement.Loading)
    val allBookmarkedTaxes = _allBookmarkedTaxes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllBookmarkedTaxes()
                .catch { _allBookmarkedTaxes.value = StateManagement.Error(it.message.toString()) }
                .collect { _allBookmarkedTaxes.value = StateManagement.Success(it) }
        }
    }

    fun updateFavoriteTourism(id: Int, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookmarkedTaxes(id, isFavorite)
        }
    }
}