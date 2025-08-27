package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns

class ActivityForgotPassword : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var sendResetCodeButton: Button
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // Initialize views
        emailInput = findViewById(R.id.emailInput)
        sendResetCodeButton = findViewById(R.id.sendResetCodeButton)
        backButton = findViewById(R.id.backButton)

        // Set up click listeners
        sendResetCodeButton.setOnClickListener {
            sendResetCode()
        }

        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
    }

    private fun sendResetCode() {
        val email = emailInput.text.toString().trim()

        // Validation
        if (email.isEmpty()) {
            emailInput.error = "Email is required"
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Please enter a valid email address"
            return
        }

        // For demo purposes, show success message and navigate to next screen
        // In a real app, you would send the reset code to the email
        Toast.makeText(this, "Reset code sent to $email", Toast.LENGTH_SHORT).show()
        
        // Navigate to Sent OTP screen
        val intent = Intent(this, ActivitySentOtp::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }
}
