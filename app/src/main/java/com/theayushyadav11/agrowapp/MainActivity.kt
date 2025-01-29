package com.theayushyadav11.agrowapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.theayushyadav11.agrowapp.api.gemini.GeminiRetrofitInstance
import com.theayushyadav11.agrowapp.api.gemini.Prompt
import com.theayushyadav11.agrowapp.api.translate.RetrofitInstance
import com.theayushyadav11.agrowapp.api.translate.Translation
import com.theayushyadav11.agrowapp.api.translate.TranslationService
import com.theayushyadav11.agrowapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val translate = Translation("en", "tel", "Hi how are you my son is very good")
        val promptText = "What is the capital of india"
        val prompt = Prompt(
            contents = listOf(
                mapOf(
                    "parts" to listOf(
                        mapOf("text" to promptText)
                    )
                )
            )
        )
//        lifecycleScope.launch {
//             val response = RetrofitInstance.api.translate(translate)
//             if (response.isSuccessful) {
//                 val translation = response.body()
//                 println(translation?.translation)
//                 binding.text.text=translation?.translation.toString()
//             }
//
//        }

//        lifecycleScope.launch {
//            val response = GeminiRetrofitInstance.geminiApi.generateContent(prompt)
//            if (response.isSuccessful) {
//                val translation = response.body()
//                println(translation?.content)
//                binding.text.text=translation?.content.toString()
//            }
//
//        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = GeminiRetrofitInstance.geminiApi.generateContent(Prompt("What is the capital of India?"))
                if (response.isSuccessful) {
                    val text = response.body()?.candidates?.firstOrNull()
                        ?.get("content")
                        ?.let { it as? Map<*, *> }
                        ?.get("parts")
                        ?.let { it as? List<*> }
                        ?.firstOrNull()
                        ?.let { it as? Map<*, *> }
                        ?.get("text")
                        ?.toString()

                    println("Gemini Response: $text")
                } else {
                    println("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            }
        }

    }
}