package com.example.quizapp
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcardapp2.R

class MainActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is in Japan.",
        "World War II ended in 1945.",
        "Julius Caesar was a Roman Emperor.",
        "The Berlin Wall fell in 1989."
    )
    private val answers = arrayOf(true, false, true, false, true)
    private var currentQuestion = 0
    private var score = 0
    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var resultText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionText = findViewById(R.id.questionText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        resultText = findViewById(R.id.resultText)
        showQuestion()
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }

    private fun showQuestion() {
        if (currentQuestion < questions.size) {
            questionText.text = "${currentQuestion + 1}. ${questions[currentQuestion]}"
        } else {
            questionText.text = "Quiz Finished!"
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            resultText.text = "You got $score out of ${questions.size}.\n" +
                    if (score >= 3) " Great job!" else " Keep practicing!"
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestion]) {
            resultText.text = " Correct!"
            score++
        } else {
            resultText.text = " Incorrect!"
        }
        currentQuestion++
        showQuestion()
    }
}