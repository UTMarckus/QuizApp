package com.example.quizapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityQuestionsBinding
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding

    private var questionsList: MutableList<Question>? = null

    private val currentPosition = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionsList = Constants.getQuestions()

        setQuestions()
    }

    private fun setQuestions() {
        val question = questionsList?.get(currentPosition - 1)

        binding.run {
            imageFlag.setImageResource(question?.image ?: R.drawable.ic_launcher_foreground)
            progressBar.progress = currentPosition
            progressTextView.text = "$currentPosition/${binding.progressBar.max}"
            questionTextView.text = question?.question
            optionOneTextView.text = question?.option1
            optionTwoTextView.text = question?.option2
            optionThreeTextView.text = question?.option3
            optionFourTextView.text = question?.option4
        }
    }
}
