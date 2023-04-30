package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: PhotoRepository
): ViewModel(){
    private val _state: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> get() = _state

    fun onEvent(event: DetailEvent){
        if (event is DetailEvent.onGetProduct){
            viewModelScope.launch {
                repository.getOneRemotePhotoById(event.id)
                    .onStart {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                    .catch {
                        _state.value = _state.value.copy(isLoading = false, message = it.message.toString())
                    }
                    .collect{
                        _state.value = _state.value.copy(success = it.body(), isLoading = false)
                    }
            }
        }
    }
}
