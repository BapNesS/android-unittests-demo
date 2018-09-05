package com.baptistecarlier.android.demo.ut

class QuestionFactory {

    fun getQuestions(): List<Question> {
        var list = getAllQuestions()
        if ( !BuildConfig.PAID_VERSION ) {
            val chunked = list.chunked(3)
            return chunked[0]
        }
        return list
    }

    private fun getAllQuestions(): List<Question> {
        var finalList = mutableListOf<Question>()

        lateinit var question: Question

        // 1
        question = Question("What's the main color of the Sun?")
        question.addBadAnswer(Answer("Purple"))
        question.addCorrectAnswer(Answer("Yellow"))
        finalList.add(question)

        // 2
        question = Question("What's the main color of the sea?")
        question.addCorrectAnswer(Answer("Blue"))
        question.addBadAnswer(Answer("Yellow"))
        finalList.add(question)

        // 3
        question = Question("What's the main color of the wine?")
        question.addBadAnswer(Answer("Blue"))
        question.addCorrectAnswer(Answer("Red"))
        finalList.add(question)

        // 4
        question = Question("What's the main color of a black hole?")
        question.addBadAnswer(Answer("Red"))
        question.addCorrectAnswer(Answer("Black"))
        finalList.add(question)

        // 5
        question = Question("What's the color of the grass?")
        question.addCorrectAnswer(Answer("Green"))
        question.addBadAnswer(Answer("Black"))
        finalList.add(question)

        // 6
        question = Question("What's the color of milk?")
        question.addBadAnswer(Answer("Green"))
        question.addCorrectAnswer(Answer("White"))
        finalList.add(question)

        // 7
        question = Question("What's the main color of chocolat?")
        question.addCorrectAnswer(Answer("Brown"))
        question.addBadAnswer(Answer("White"))
        finalList.add(question)

        // 8
        question = Question("What's the main color of a pig?")
        question.addBadAnswer(Answer("Brown"))
        question.addCorrectAnswer(Answer("Pink"))
        finalList.add(question)

        // 9
        question = Question("What's the main color of orange juice?")
        question.addCorrectAnswer(Answer("Orange"))
        question.addBadAnswer(Answer("Pink"))
        finalList.add(question)

        // 9
        question = Question("What's the main color of an eggplant?")
        question.addBadAnswer(Answer("Orange"))
        question.addCorrectAnswer(Answer("Purple"))
        finalList.add(question)

        return finalList
    }

}