package com.baptistecarlier.android.demo.ut

import org.junit.Test

import org.junit.Assert.*

class QuestionFactoryTestFree {

    @Test
    fun getQuestions_buildConfigField_sizeIsThree() {
        // GIVEN
        val questionFactory = QuestionFactory()

        // WHEN
        val list = questionFactory.getQuestions()

        // THEN
        assertEquals(3, list.size)
    }
}
