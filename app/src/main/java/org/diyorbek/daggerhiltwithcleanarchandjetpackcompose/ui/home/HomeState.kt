package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.home

import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.Photo
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.PhotoDTO

data class HomeState(
    val isLoading: Boolean = false,
    val message: String = "",
    val success: List<Photo> = emptyList()
)
