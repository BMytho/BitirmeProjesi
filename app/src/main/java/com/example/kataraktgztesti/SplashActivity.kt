package com.example.kataraktgztesti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kataraktgztesti.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // XML ile bağlama işlemi
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button tıklama işlemi
        binding.mainBtn.setOnClickListener {
            // AnaSayfaActivity'e geçiş
            startActivity(Intent(this, AnaSayfaActivity::class.java))
        }
    }
}
