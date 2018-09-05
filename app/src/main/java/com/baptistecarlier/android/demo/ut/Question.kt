package com.baptistecarlier.android.demo.ut

import android.util.Log

class Question(val label: String) {

    lateinit var badAnswer: Answer
    lateinit var correctAnswer: Answer
    var selectedAnswer: Answer? = null

    fun addBadAnswer(answer: Answer) {
        badAnswer = answer
    }

    fun addCorrectAnswer(answer: Answer) {
        correctAnswer = answer
    }

    fun reply() : Boolean {
        if ( !BuildConfig.CANT_CHEAT_VERSION ) {
            return true
        }
        return correctAnswer.equals(selectedAnswer)
    }

    fun selectAnswer(answer: Answer) {
        selectedAnswer = answer
        Log.d("TAG", "Select Answer : "+answer.value)
    }

}