package com.baptistecarlier.android.demo.ut

class Game {

    var score = 0
    var currentQuestionPosition = 0
    var confirmed = false

    lateinit var questions: List<Question>

    fun init() {
        questions = QuestionFactory().getQuestions()
    }

    fun isEndOfTrial() : Boolean {
        return currentQuestionPosition+1 == 3
    }

    fun hasNext(): Boolean {
        return questions.size != (currentQuestionPosition+1)
    }

    fun goNextQuestion() : Question {
        confirmed = false
        currentQuestionPosition++
        return currentQuestion()
    }

    fun currentQuestion() : Question {
        return questions.get(currentQuestionPosition)
    }

    fun confirmAnswer(): Boolean {
        confirmed = true
        return currentQuestion().reply()
    }

    fun isConfirmed() : Boolean {
        return confirmed
    }

    fun incScore() {
        score++
    }

}