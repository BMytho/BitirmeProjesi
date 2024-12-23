package com.example.kataraktgztesti.RenkKoru

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kataraktgztesti.R
import com.example.kataraktgztesti.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = Constans.getQuestions()
        setQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }
    private fun setQuestion() {
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()
        enableOptions() // Seçenekleri yeniden etkinleştir

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "Bitir"
        } else {
            binding.btnSubmit.text = "Onayla"
        }

        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition/${binding.progressBar.max}"

        binding.tvQuestions.text = question.questions
        binding.renkTestIV.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun disableOptions() {
        binding.tvOptionOne.isEnabled = false
        binding.tvOptionTwo.isEnabled = false
        binding.tvOptionThree.isEnabled = false
        binding.tvOptionFour.isEnabled = false
    }

    private fun enableOptions() {
        binding.tvOptionOne.isEnabled = true
        binding.tvOptionTwo.isEnabled = true
        binding.tvOptionThree.isEnabled = true
        binding.tvOptionFour.isEnabled = true
    }



    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for(option in options){
            option.setTextColor(resources.getColor(R.color.black))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> {
                selectedOptionView(tv = binding.tvOptionOne, selectedOptionNum = 1)
            }
            R.id.tv_optionTwo -> {
                selectedOptionView(tv = binding.tvOptionTwo, selectedOptionNum = 2)
            }
            R.id.tv_optionThree -> {
                selectedOptionView(tv = binding.tvOptionThree, selectedOptionNum = 3)
            }
            R.id.tv_optionFour -> {
                selectedOptionView(tv = binding.tvOptionFour, selectedOptionNum = 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            enableOptions() // Yeni soru için seçenekleri etkinleştir
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, RenkKoruResultActivity::class.java)
                            intent.putExtra(Constans.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constans.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                        answerView(mSelectedOptionPosition, R.drawable.correct_option_border)
                    }

                    // Seçim yapıldıktan sonra seçenekleri kilitle
                    disableOptions()

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        binding.btnSubmit.text = "Bitir"
                    } else {
                        binding.btnSubmit.text = "Sonraki Soru"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }



    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1->{
                binding.tvOptionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                binding.tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                binding.tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


    @SuppressLint("SuspiciousIndentation")
    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum


            tv.setTextColor(Color.parseColor("#7cfc00"))
            tv.setTypeface(tv.typeface,Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this,R.drawable.default_option_border)

    }


}