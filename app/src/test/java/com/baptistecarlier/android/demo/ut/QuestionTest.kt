package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionTest {

    @Test
    fun reply_correctAnswer_ok() {
        // GIVEN
        val question = Question("The label")
        val correctAnswer = Answer("Correct")
        question.addCorrectAnswer(correctAnswer)
        val badAnswer = Answer("Bad")
        question.addBadAnswer(badAnswer)

        question.selectAnswer(correctAnswer)

        // WHEN
        val isSelectedAnswerCorrect = question.reply()

        // THEN
        assertTrue(isSelectedAnswerCorrect)
    }

}
