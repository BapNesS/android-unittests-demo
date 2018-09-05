package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionTestCheating {

    @Test
    fun reply_badAnswer_ok() {
        // GIVEN
        val question = Question("The label")
        val correctAnswer = Answer("Correct")
        question.addCorrectAnswer(correctAnswer)
        val badAnswer = Answer("Bad")
        question.addBadAnswer(badAnswer)

        question.selectAnswer(badAnswer)

        // WHEN
        val isSelectedAnswerCorrect = question.reply()

        // THEN
        assertTrue(isSelectedAnswerCorrect)
    }

}
