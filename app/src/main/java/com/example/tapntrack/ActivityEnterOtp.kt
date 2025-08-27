package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityEnterOtp : AppCompatActivity() {

    private lateinit var emailDisplay: TextView
    private lateinit var otpInput: EditText
    private lateinit var verifyCodeButton: Button
    private lateinit var resendCodeLink: TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_otp)

        // Initialize views
        emailDisplay = findViewById(R.id.emailDisplay)
        otpInput = findViewById(R.id.otpInput)
        verifyCodeButton = findViewById(R.id.verifyCodeButton)
        resendCodeLink = findViewById(R.id.resendCodeLink)
        backButton = findViewById(R.id.backButton)

        // Get email from intent
        val email = intent.getStringExtra("email") ?: "user@example.com"
        emailDisplay.text = email

        // Set up click listeners
        verifyCodeButton.setOnClickListener {
            verifyOtp(email)
        }

        resendCodeLink.setOnClickListener {
            resendCode(email)
        }

        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
    }

    private fun verifyOtp(email: String) {
        val otp = otpInput.text.toString().trim()

        // Validation
        if (otp.isEmpty()) {
            otpInput.error = "Please enter the reset code"
            return
        }

        if (otp.length != 6) {
            otpInput.error = "Please enter a 6-digit code"
            return
        }

        // For demo purposes, accept any 6-digit code
        // In a real app, you would validate the OTP against the backend
        Toast.makeText(this, "Code verified successfully", Toast.LENGTH_SHORT).show()
        
        // Navigate to New Password screen
        val intent = Intent(this, ActivityNewPassword::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }

    private fun resendCode(email: String) {
        // For demo purposes, show a message
        // In a real app, you would resend the OTP to the email
        Toast.makeText(this, "Reset code resent to $email", Toast.LENGTH_LONG).show()
    }
}
