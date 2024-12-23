package com.example.kataraktgztesti.RenkKoru


import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kataraktgztesti.databinding.ActivityRenkKoruTestiBinding

class RenkKoruTestiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRenkKoruTestiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRenkKoruTestiBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.baslaBtn.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
            finish()
        }



    }

}