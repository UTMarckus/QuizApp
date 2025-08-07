package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "score"
    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        questions.add(Question(
            1,
            "What country does this flag belong?",
            R.drawable.flag_of_argentina,
            "Argentina",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            2,
            "What country does this flag belong?",
            R.drawable.flag_of_brazil,
            "Brazil",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            3,
            "What country does this flag belong?",
            R.drawable.flag_of_finland,
            "Finland",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            4,
            "What country does this flag belong?",
            R.drawable.flag_of_france,
            "France",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            5,
            "What country does this flag belong?",
            R.drawable.flag_of_germany,
            "Germany",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            6,
            "What country does this flag belong?",
            R.drawable.flag_of_india,
            "India",
            "Argentina",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            7,
            "What country does this flag belong?",
            R.drawable.flag_of_italy,
            "Italy",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            8,
            "What country does this flag belong?",
            R.drawable.flag_of_nigeria,
            "Nigeria",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            9,
            "What country does this flag belong?",
            R.drawable.flag_of_romania,
            "Romania",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        questions.add(Question(
            10,
            "What country does this flag belong?",
            R.drawable.flag_of_spain,
            "Spain",
            "India",
            "Iran",
            "Ireland",
            1
        ))

        return questions
    }
}