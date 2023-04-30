package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail

import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.Photo


data class DetailState(
    val isLoading: Boolean = false,
    val message: String = "",
    val success: Photo? = null
)
