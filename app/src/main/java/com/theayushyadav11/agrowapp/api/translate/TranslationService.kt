package com.theayushyadav11.agrowapp.api.translate

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslationService {
    @Headers("Accept:application/json", "Content-Type:application/json")
    @POST("/mymemory/")
    suspend fun translate(@Body request: Translation): Response<TranslateResponse>
}