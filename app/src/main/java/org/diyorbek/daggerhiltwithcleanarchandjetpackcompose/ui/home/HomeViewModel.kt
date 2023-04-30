package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {
    private val TAG = "HomeViewModel"
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> get() = _state

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            repository.getAllRemotePhotos()
                .onStart {
                    _state.value = _state.value.copy(isLoading = true)
                }
                .catch {
                    _state.value =
                        _state.value.copy(isLoading = false, message = it.message.toString())
                }
                .collect {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        success = it.body() ?: emptyList()
                    )
                    Log.d(TAG, "loadProducts: ${it.body().toString()}")
                }
        }
    }
}