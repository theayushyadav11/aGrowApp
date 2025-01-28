package com.theayushyadav11.agrowapp.api.translate

import com.theayushyadav11.agrowapp.util.Constants.Companion.TRANSLATOR_API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api:TranslationService by lazy{

        Retrofit.Builder()
            .baseUrl(TRANSLATOR_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslationService::class.java)
    }
}