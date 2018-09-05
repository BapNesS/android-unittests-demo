package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionFactoryTest {

    @Test
    fun getQuestions__notEmpty() {
        // GIVEN
        val questionFactory = QuestionFactory()

        // WHEN
        val list = questionFactory.getQuestions()

        // THEN
        assertNotEquals(0, list.size)
    }
}
