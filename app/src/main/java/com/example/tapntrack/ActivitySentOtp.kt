package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySentOtp : AppCompatActivity() {

    private lateinit var emailDisplay: TextView
    private lateinit var continueButton: Button
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sent_otp)

        // Initialize views
        emailDisplay = findViewById(R.id.emailDisplay)
        continueButton = findViewById(R.id.continueButton)
        backButton = findViewById(R.id.backButton)

        // Get email from intent
        val email = intent.getStringExtra("email") ?: "user@example.com"
        emailDisplay.text = email

        // Set up click listeners
        continueButton.setOnClickListener {
            navigateToEnterOtp(email)
        }

        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
    }

    private fun navigateToEnterOtp(email: String) {
        val intent = Intent(this, ActivityEnterOtp::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }
}
