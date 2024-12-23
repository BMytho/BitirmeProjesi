package com.example.kataraktgztesti.GormeTesti

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kataraktgztesti.R
import com.example.kataraktgztesti.RenkKoru.Constans
import com.example.kataraktgztesti.RenkKoru.Question
import com.example.kataraktgztesti.RenkKoru.RenkKoruResultActivity
import com.example.kataraktgztesti.databinding.ActivityGozSagligiTestBinding

class GozSagligiTestActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGozSagligiTestBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGozSagligiTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sorular listesini getQuestions2() ile yükle
        mQuestionsList = Constans.getQuestions2()

        setQuestion()

        // Tıklama olaylarını ayarla
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()
        enableOptions()

        // Soruları ve görselleri ayarla
        binding.tvQuestions.text = question.questions
        binding.renkTestIV.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        // Buton metni
        binding.btnSubmit.text = if (mCurrentPosition == mQuestionsList!!.size) "Bitir" else "Onayla"

        // İlerleme çubuğu
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition/${binding.progressBar.max}"
    }

    private fun defaultOptionView() {
        val options = arrayListOf<TextView>(
            binding.tvOptionOne,
            binding.tvOptionTwo,
            binding.tvOptionThree,
            binding.tvOptionFour
        )

        for (option in options) {
            option.setTextColor(resources.getColor(R.color.black))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    private fun enableOptions() {
        binding.tvOptionOne.isEnabled = true
        binding.tvOptionTwo.isEnabled = true
        binding.tvOptionThree.isEnabled = true
        binding.tvOptionFour.isEnabled = true
    }

    private fun disableOptions() {
        binding.tvOptionOne.isEnabled = false
        binding.tvOptionTwo.isEnabled = false
        binding.tvOptionThree.isEnabled = false
        binding.tvOptionFour.isEnabled = false
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> selectedOptionView(binding.tvOptionOne, 1)
            R.id.tv_optionTwo -> selectedOptionView(binding.tvOptionTwo, 2)
            R.id.tv_optionThree -> selectedOptionView(binding.tvOptionThree, 3)
            R.id.tv_optionFour -> selectedOptionView(binding.tvOptionFour, 4)
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            enableOptions()
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, RenkKoruResultActivity::class.java)
                            intent.putExtra(Constans.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constans.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList!![mCurrentPosition - 1]

                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                        answerView(mSelectedOptionPosition, R.drawable.correct_option_border)
                    }

                    disableOptions()

                    binding.btnSubmit.text = if (mCurrentPosition == mQuestionsList!!.size) "Bitir" else "Sonraki"
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> binding.tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> binding.tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> binding.tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> binding.tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#7cfc00"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
    }
}
