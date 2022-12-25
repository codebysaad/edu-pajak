package com.saadfauzi.edupajak.ui.screens.detail

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
class DetailViewModel @Inject constructor(private val repository: PajakRepository) : ViewModel() {
    private val _taxes = MutableStateFlow<StateManagement<PajakEntity>>(StateManagement.Loading)
    val taxes = _taxes.asStateFlow()

    fun getTaxes(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTaxes(id)
                .catch { _taxes.value = StateManagement.Error(it.message.toString()) }
                .collect { _taxes.value = StateManagement.Success(it) }
        }
    }

    fun updateBookmarkedTaxes(id: Int, isBookmarked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBookmarkedTaxes(id, isBookmarked)
        }
    }
}