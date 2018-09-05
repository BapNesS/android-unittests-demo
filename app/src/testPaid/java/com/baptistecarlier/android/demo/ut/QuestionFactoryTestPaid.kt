package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionFactoryTestPaid {

    @Test
    fun getQuestions_buildConfigField_sizeIsTen() {
        // GIVEN
        val questionFactory = QuestionFactory()

        // WHEN
        val list = questionFactory.getQuestions()

        // THEN
        assertEquals(10, list.size)
    }
}
