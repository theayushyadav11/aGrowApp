package com.theayushyadav11.agrowapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.theayushyadav11.agrowapp.api.translate.RetrofitInstance
import com.theayushyadav11.agrowapp.api.translate.Translation
import com.theayushyadav11.agrowapp.api.translate.TranslationService
import com.theayushyadav11.agrowapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val translate = Translation("en", "tel", "Hi how are you my son is very good")

        lifecycleScope.launch {
             val response = RetrofitInstance.api.translate(translate)
             if (response.isSuccessful) {
                 val translation = response.body()
                 println(translation?.translation)
                 binding.text.text=translation?.translation.toString()
             }

        }
    }
}