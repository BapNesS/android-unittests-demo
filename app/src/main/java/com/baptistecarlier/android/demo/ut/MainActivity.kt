package com.baptistecarlier.android.demo.ut

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.baptistecarlier.android.demo.ut.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintLayout
import android.transition.TransitionManager
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    val myGame = Game()

    lateinit var question: Question
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate view and obtain an instance of the binding class.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        myGame.init()
        question = myGame.currentQuestion()

        binding.setVariable(BR.question, question)
        binding.executePendingBindings()
    }

    // region Old way binding refresh
    fun selectBadAnswer(v: View) {
        question.selectedAnswer = question.badAnswer
        binding.invalidateAll()
    }

    fun selectCorrectAnswer(v: View) {
        question.selectedAnswer = question.correctAnswer
        binding.invalidateAll()
    }
    // endregion

    fun bottomButtonClick(v: View) {
        Log.d("TAG", "bottomButtonClick")
        if ( myGame.isConfirmed() ) {
            progress()
        } else {
            confirm()
        }
    }

    fun confirm() {
        Log.d("TAG", "confirm")
        val isOk = myGame.confirmAnswer()
        if (isOk) {
            myGame.incScore()
            confirmButton.text = "Correct, go next"
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.setHorizontalBias(confirmButton.id, 1F)
            TransitionManager.beginDelayedTransition(constraintLayout)
            set.applyTo(constraintLayout)
        } else {
            confirmButton.text = "Wrong, go next"
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.setHorizontalBias(confirmButton.id, 0F)
            TransitionManager.beginDelayedTransition(constraintLayout)
            set.applyTo(constraintLayout)
        }
    }

    fun progress() {
        badAnswer.isChecked = false
        correctAnswer.isChecked = false

        Log.d("TAG", "progress")
        if ( !myGame.hasNext() ) {
            val sb = StringBuilder()
            if (!BuildConfig.PAID_VERSION) {
                sb.append("[TRIAL VERSION] ")
            }
            sb.append("Score : ")
            sb.append(myGame.score)
            sb.append("/")
            sb.append(myGame.questions.size)
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show()
        } else {
            question = myGame.goNextQuestion()
            binding.setVariable(BR.question, question)
            binding.invalidateAll()

            confirmButton.text = "Confirm"
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.setHorizontalBias(confirmButton.id, 0.5F)
            TransitionManager.beginDelayedTransition(constraintLayout)
            set.applyTo(constraintLayout)
        }
    }

}
