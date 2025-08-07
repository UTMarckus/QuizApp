package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityResultBinding
import com.example.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            val score = intent.getIntExtra(Constants.SCORE, 0)
            val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
            trophyNameTv.text = intent.getStringExtra(Constants.USER_NAME)
            scoreTv.text = "Your score is $score out of $totalQuestions"

            finishBtn.setOnClickListener {
                Intent(this@ResultActivity, MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}
