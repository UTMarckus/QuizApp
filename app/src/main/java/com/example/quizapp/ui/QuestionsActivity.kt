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

    private val currentPosition = 1
    private var selectedOption = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            optionOneTextView.setOnClickListener(this@QuestionsActivity)
            optionTwoTextView.setOnClickListener(this@QuestionsActivity)
            optionThreeTextView.setOnClickListener(this@QuestionsActivity)
            optionFourTextView.setOnClickListener(this@QuestionsActivity)
        }

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

            checkButton.text = if (currentPosition == questionsList?.size) "Finish" else "Check"
        }
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
        }
    }
}
