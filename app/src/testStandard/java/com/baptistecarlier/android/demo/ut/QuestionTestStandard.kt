package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionTestStandard {

    @Test
    fun reply_badAnswer_ko() {
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
        assertFalse(isSelectedAnswerCorrect)
    }

}
