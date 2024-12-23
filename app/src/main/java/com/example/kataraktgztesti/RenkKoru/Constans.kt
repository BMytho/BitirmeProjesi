package com.example.kataraktgztesti.RenkKoru

import com.example.kataraktgztesti.R

object Constans {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(id = 1,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru12,
            optionOne = "12",
            optionTwo = "21",
            optionThree = "34",
            optionFour = "45",
            correctAnswer = 1
        )
        val que2 = Question(id = 2,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru5,
            optionOne = "12",
            optionTwo = "5",
            optionThree = "15",
            optionFour = "Hiçbiri",
            correctAnswer = 2
        )
        val que3 = Question(id = 3,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru7,
            optionOne = "14",
            optionTwo = "7",
            optionThree = "Hiçbiri",
            optionFour = "9",
            correctAnswer = 2
        )
        val que4 = Question(id = 4,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru16,
            optionOne = "Hiçbiri",
            optionTwo = "28",
            optionThree = "16",
            optionFour = "26",
            correctAnswer = 3
        )
        val que5 = Question(id = 5,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru73,
            optionOne = "Hiçbiri",
            optionTwo = "78",
            optionThree = "23",
            optionFour = "73",
            correctAnswer = 4
        )
        val que6 = Question(id = 6,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkorux,
            optionOne = "Hiçbiri",
            optionTwo = "5",
            optionThree = "14",
            optionFour = "41",
            correctAnswer = 1
        )
        val que7 = Question(id = 7,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru45,
            optionOne = "45",
            optionTwo = "Hiçbiri",
            optionThree = "28",
            optionFour = "14",
            correctAnswer = 2
        )
        val que8 = Question(id = 8,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru26,
            optionOne = "2",
            optionTwo = "6",
            optionThree = "Hiçbiri",
            optionFour = "26",
            correctAnswer = 4
        )
        val que9 = Question(id = 9,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru8,
            optionOne = "9",
            optionTwo = "Hiçbiri",
            optionThree = "8",
            optionFour = "6",
            correctAnswer = 3
        )
        val que10 = Question(id = 10,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru29,
            optionOne = "28",
            optionTwo = "79",
            optionThree = "29",
            optionFour = "Hiçbiri",
            correctAnswer = 3
        )

        val que11 = Question(id = 11,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru3,
            optionOne = "Hiçbiri",
            optionTwo = "5",
            optionThree = "8",
            optionFour = "3",
            correctAnswer = 4
        )
        val que12 = Question(id = 12,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru74,
            optionOne = "72",
            optionTwo = "21",
            optionThree = "74",
            optionFour = "Hiçbiri",
            correctAnswer = 3
        )
        val que13 = Question(id = 13,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru6,
            optionOne = "6",
            optionTwo = "8",
            optionThree = "12",
            optionFour = "Hiçbiri",
            correctAnswer = 1
        )
        val que14 = Question(id = 14,
            "Bu resimdeki sayı nedir ?",
            R.drawable.renkkoru456,
            optionOne = "46",
            optionTwo = "Hiçbiri",
            optionThree = "43",
            optionFour = "45",
            correctAnswer = 4
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)
        questionsList.add(que13)
        questionsList.add(que14)
        return questionsList
    }

    fun getQuestions2(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(id = 1,
            "Bu resimdeki sayı nedir ?",
            R.drawable.solq,
            optionOne = "Q",
            optionTwo = "O",
            optionThree = "U",
            optionFour = "C",
            correctAnswer = 1)

        val que2 = Question(id = 2,
            "Bu resimdeki sayı nedir ?",
            R.drawable.solg,
            optionOne = "O",
            optionTwo = "C",
            optionThree = "D",
            optionFour = "G",
            correctAnswer = 4)

        val que3 = Question(id = 3,
            "Bu resimdeki sayı nedir ?",
            R.drawable.solj,
            optionOne = "I",
            optionTwo = "J",
            optionThree = "L",
            optionFour = "Y",
            correctAnswer = 2)

        val que4 = Question(id = 4,
            "Bu resimdeki sayı nedir ?",
            R.drawable.solz,
            optionOne = "R",
            optionTwo = "S",
            optionThree = "Z",
            optionFour = "45",
            correctAnswer = 3)

        val que5 = Question(id = 5,
            "Bu resimdeki sayı nedir ?",
            R.drawable.solc,
            optionOne = "C",
            optionTwo = "O",
            optionThree = "Ç",
            optionFour = "G",
            correctAnswer = 1)

        val que6 = Question(id = 6,
            "Bu resimdeki sayı nedir ?",
            R.drawable.soln,
            optionOne = "Y",
            optionTwo = "H",
            optionThree = "N",
            optionFour = "M",
            correctAnswer = 3)

        val que7 = Question(id = 7,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sola,
            optionOne = "A",
            optionTwo = "H",
            optionThree = "M",
            optionFour = "Y",
            correctAnswer = 1)

        val que8 = Question(id = 8,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sage,
            optionOne = "T",
            optionTwo = "Y",
            optionThree = "R",
            optionFour = "E",
            correctAnswer = 4)

        val que9 = Question(id = 9,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sagy,
            optionOne = "U",
            optionTwo = "Y",
            optionThree = "V",
            optionFour = "H",
            correctAnswer = 2)

        val que10 = Question(id = 10,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sagd,
            optionOne = "H",
            optionTwo = "C",
            optionThree = "D",
            optionFour = "O",
            correctAnswer = 3)

        val que11 = Question(id = 11,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sagl,
            optionOne = "I",
            optionTwo = "L",
            optionThree = "K",
            optionFour = "T",
            correctAnswer = 2)

        val que12 = Question(id = 12,
            "Bu resimdeki sayı nedir ?",
            R.drawable.sagc,
            optionOne = "Ç",
            optionTwo = "D",
            optionThree = "C",
            optionFour = "O",
            correctAnswer = 3)

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)

        return questionsList
    }
}