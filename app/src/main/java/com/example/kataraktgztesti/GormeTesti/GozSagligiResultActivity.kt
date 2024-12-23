package com.example.kataraktgztesti.GormeTesti

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kataraktgztesti.AnaSayfaActivity
import com.example.kataraktgztesti.R
import com.example.kataraktgztesti.RenkKoru.Constans
import com.example.kataraktgztesti.databinding.ActivityGozSagligiResultBinding

class GozSagligiResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGozSagligiResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGozSagligiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalQuestion = intent.getIntExtra(Constans.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constans.CORRECT_ANSWERS,0)

        binding.tvScore.text = "Puanınız $correctAnswers / $totalQuestion"



        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, AnaSayfaActivity::class.java))
            finish()
        }

    }
}