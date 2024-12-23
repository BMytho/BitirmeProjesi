package com.example.kataraktgztesti.RenkKoru

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kataraktgztesti.AnaSayfaActivity
import com.example.kataraktgztesti.databinding.ActivityRenkKoruResultBinding

class RenkKoruResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRenkKoruResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRenkKoruResultBinding.inflate(layoutInflater)
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