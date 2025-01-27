package com.theayushyadav11.agrowapp.api.translate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api:TranslationService by lazy{

        Retrofit.Builder()
            .baseUrl("https://deep-translator-api.azurewebsites.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslationService::class.java)
    }
}