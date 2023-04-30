package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.ui.detail

sealed interface DetailEvent{

    data class onGetProduct(val id: Int): DetailEvent

}