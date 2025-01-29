package com.theayushyadav11.agrowapp.api.gemini

import com.theayushyadav11.agrowapp.util.Constants.Companion.GEMINI_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GeminiRetrofitInstance {

    val geminiApi: GeminiService by lazy {
        Retrofit.Builder()
            .baseUrl(GEMINI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeminiService::class.java)
    }
}