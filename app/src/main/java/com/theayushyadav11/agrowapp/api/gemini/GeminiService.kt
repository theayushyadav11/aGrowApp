package com.theayushyadav11.agrowapp.api.gemini

import com.theayushyadav11.agrowapp.util.ConstantsPrivate.Companion.GEMINI_API_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GeminiService {
    @POST("v1beta/models/gemini-1.5-flash:generateContent?key=$GEMINI_API_KEY")
    suspend fun generateContent(
        @Body request: Prompt
    ): Response<GeminiResponse>
}