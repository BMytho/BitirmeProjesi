package com.example.kataraktgztesti.GormeTesti

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kataraktgztesti.R
import com.example.kataraktgztesti.RenkKoru.QuizActivity
import com.example.kataraktgztesti.databinding.ActivityGozSagligiBaslamaBinding

class GozSagligiBaslamaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGozSagligiBaslamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGozSagligiBaslamaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.baslaBtn.setOnClickListener {
            startActivity(Intent(this, GozSagligiTestActivity::class.java))
            finish()
        }
    }
}