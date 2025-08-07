package com.example.quizapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityQuestionsBinding
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants
import androidx.core.graphics.toColorInt

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding

    private var questionsList: MutableList<Question>? = null

    private var currentQuestion: Question? = null
    private var questionsCounter = 0
    private var selectedOption = 0
    private var isAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            optionOneTextView.setOnClickListener(this@QuestionsActivity)
            optionTwoTextView.setOnClickListener(this@QuestionsActivity)
            optionThreeTextView.setOnClickListener(this@QuestionsActivity)
            optionFourTextView.setOnClickListener(this@QuestionsActivity)
            checkButton.setOnClickListener(this@QuestionsActivity)
        }

        questionsList = Constants.getQuestions()

        showNextQuestion()
    }

    private fun showNextQuestion() {
        resetOptionsView()

        currentQuestion = questionsList?.get(questionsCounter)

        binding.run {
            imageFlag.setImageResource(currentQuestion?.image ?: R.drawable.ic_launcher_foreground)
            progressBar.progress = questionsCounter
            progressTextView.text = "${questionsCounter + 1}/${binding.progressBar.max}"
            questionTextView.text = currentQuestion?.question
            optionOneTextView.text = currentQuestion?.option1
            optionTwoTextView.text = currentQuestion?.option2
            optionThreeTextView.text = currentQuestion?.option3
            optionFourTextView.text = currentQuestion?.option4

            checkButton.text = if (questionsCounter == questionsList?.size) "Finish" else "Check"

            questionsCounter++
            isAnswered = false
        }
    }

    private fun checkAnswer() {
        isAnswered = true

        if(currentQuestion?.answer != selectedOption) {
            setWrongAnswerBg(when(selectedOption) {
                1 -> binding.optionOneTextView
                2 -> binding.optionTwoTextView
                3 -> binding.optionThreeTextView
                else -> binding.optionFourTextView
            })
        }

        setCorrectAnswerBg(when(currentQuestion?.answer) {
            1 -> binding.optionOneTextView
            2 -> binding.optionTwoTextView
            3 -> binding.optionThreeTextView
            else -> binding.optionFourTextView
        })

        binding.checkButton.text = "Next"
    }

    private fun resetOptionsView() {
        getOptionsList().forEach {
            it.setTextColor("#7A8089".toColorInt())
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }


    private fun setOptionSelected(textView: TextView, selectOptionNumber: Int) {
        resetOptionsView()

        textView.setTextColor("#363A43".toColorInt())
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

        selectedOption = selectOptionNumber
    }

    private fun setCorrectAnswerBg(view: TextView) {
        view.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
    }

    private fun setWrongAnswerBg(view: TextView) {
        view.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
    }

    private fun getOptionsList(): List<TextView> = listOf(
        binding.optionOneTextView,
        binding.optionTwoTextView,
        binding.optionThreeTextView,
        binding.optionFourTextView
    )

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_one_text_view -> setOptionSelected(binding.optionOneTextView, 1)
            R.id.option_two_text_view -> setOptionSelected(binding.optionTwoTextView, 2)
            R.id.option_three_text_view -> setOptionSelected(binding.optionThreeTextView, 3)
            R.id.option_four_text_view -> setOptionSelected(binding.optionFourTextView, 4)
            R.id.check_button -> {
                if (isAnswered) {
                    showNextQuestion()
                } else {
                    checkAnswer()
                }
                selectedOption = 0
            }
        }
    }
}
