package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityNewPassword : AppCompatActivity() {

    private lateinit var newPasswordInput: EditText
    private lateinit var confirmNewPasswordInput: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        // Initialize views
        newPasswordInput = findViewById(R.id.newPasswordInput)
        confirmNewPasswordInput = findViewById(R.id.confirmNewPasswordInput)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
        backButton = findViewById(R.id.backButton)

        // Set up click listeners
        resetPasswordButton.setOnClickListener {
            resetPassword()
        }

        backButton.setOnClickListener {
            finish() // Go back to previous activity
        }
    }

    private fun resetPassword() {
        val newPassword = newPasswordInput.text.toString().trim()
        val confirmPassword = confirmNewPasswordInput.text.toString().trim()

        // Validation
        if (newPassword.isEmpty()) {
            newPasswordInput.error = "New password is required"
            return
        }

        if (newPassword.length < 6) {
            newPasswordInput.error = "Password must be at least 6 characters"
            return
        }

        if (confirmPassword.isEmpty()) {
            confirmNewPasswordInput.error = "Please confirm your password"
            return
        }

        if (newPassword != confirmPassword) {
            confirmNewPasswordInput.error = "Passwords do not match"
            return
        }

        // For demo purposes, show success message and navigate to success screen
        // In a real app, you would update the password in the backend
        Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show()
        
        // Navigate to Password Changed Success screen
        val intent = Intent(this, ActivityPasswordChanged::class.java)
        startActivity(intent)
    }
}
