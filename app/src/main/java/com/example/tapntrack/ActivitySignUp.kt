package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns

class ActivitySignUp : AppCompatActivity() {

    private lateinit var fullNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var signUpButton: Button
    private lateinit var backButton: ImageView
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        fullNameInput = findViewById(R.id.fullNameInput)
        emailInput = findViewById(R.id.emailInput)
        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        signUpButton = findViewById(R.id.signUpButton)
        backButton = findViewById(R.id.backButton)
        loginLink = findViewById(R.id.loginLink)

        // Set up click listeners
        signUpButton.setOnClickListener {
            performSignUp()
        }

        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }

        loginLink.setOnClickListener {
            finish() // Go back to login activity
        }
    }

    private fun performSignUp() {
        val fullName = fullNameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val username = usernameInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()
        val confirmPassword = confirmPasswordInput.text.toString().trim()

        // Validation
        if (fullName.isEmpty()) {
            fullNameInput.error = "Full name is required"
            return
        }

        if (email.isEmpty()) {
            emailInput.error = "Email is required"
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Please enter a valid email address"
            return
        }

        if (username.isEmpty()) {
            usernameInput.error = "Username is required"
            return
        }

        if (username.length < 3) {
            usernameInput.error = "Username must be at least 3 characters"
            return
        }

        if (password.isEmpty()) {
            passwordInput.error = "Password is required"
            return
        }

        if (password.length < 6) {
            passwordInput.error = "Password must be at least 6 characters"
            return
        }

        if (confirmPassword.isEmpty()) {
            confirmPasswordInput.error = "Please confirm your password"
            return
        }

        if (password != confirmPassword) {
            confirmPasswordInput.error = "Passwords do not match"
            return
        }

        // For demo purposes, show success message and navigate to Dashboard
        // In a real app, you would send the data to a backend service
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_LONG).show()
        
        // Navigate to Dashboard
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
        finish() // Close signup activity
    }
}
