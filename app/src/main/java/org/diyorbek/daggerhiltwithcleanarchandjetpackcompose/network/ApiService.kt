package org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.network


import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.Photo
import org.diyorbek.daggerhiltwithcleanarchandjetpackcompose.model.PhotoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("Content-type:application/json")

    @GET("search?query=nature")
    suspend fun getAllPhotos(): Response<List<Photo>>

    @GET("photos/{id}")
    suspend fun getOnePhotoById(
        @Path("id")id: Int
    ): Response<Photo>
}