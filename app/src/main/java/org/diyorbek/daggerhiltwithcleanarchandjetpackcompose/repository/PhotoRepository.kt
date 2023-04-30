package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.repository

import kotlinx.coroutines.flow.flow
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.network.ApiService
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val apiService: ApiService
){

    suspend fun getAllRemotePhotos() = flow { emit(apiService.getAllPhotos()) }

    suspend fun getOneRemotePhotoById(id: Int) = flow { emit(apiService.getOnePhotoById(id)) }
}