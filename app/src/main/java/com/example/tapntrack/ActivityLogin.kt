package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityLogin : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signInButton: Button
    private lateinit var forgotPasswordLink: TextView
    private lateinit var signUpLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        signInButton = findViewById(R.id.signInButton)
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink)
        signUpLink = findViewById(R.id.signUpLink)

        // Set up click listeners
        signInButton.setOnClickListener {
            performLogin()
        }

        forgotPasswordLink.setOnClickListener {
            showForgotPasswordDialog()
        }

        signUpLink.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun performLogin() {
        val username = usernameInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        // Basic validation
        if (username.isEmpty()) {
            usernameInput.error = "Username is required"
            return
        }

        if (password.isEmpty()) {
            passwordInput.error = "Password is required"
            return
        }

        // For demo purposes, accept any non-empty credentials
        // In a real app, you would validate against a backend service
        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Navigate to Dashboard
            val intent = Intent(this, ActivityDashboard::class.java)
            startActivity(intent)
            finish() // Close login activity so user can't go back
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showForgotPasswordDialog() {
        val intent = Intent(this, ActivityForgotPassword::class.java)
        startActivity(intent)
    }

    private fun navigateToSignUp() {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }
}
