package com.example.your_app_name // Replace with your actual package name

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcardapp2.R

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome) // Ensure this is the correct layout file name

        // Initialize UI elements
        welcomeTextView = findViewById(R.id.textView)
        startButton = findViewById(R.id.button)

        // Set click listener for the Start button
        startButton.setOnClickListener {
            // Create an Intent to start the QuizActivity
            val intent = Intent(this, MainActivity::class.java)  // Replace QuizActivity if needed
            startActivity(intent)
        }
    }
}
