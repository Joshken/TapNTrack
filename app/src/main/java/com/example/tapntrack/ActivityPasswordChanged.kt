package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityPasswordChanged : AppCompatActivity() {

    private lateinit var signInButton: Button
    private lateinit var backToLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_changed)

        // Initialize views
        signInButton = findViewById(R.id.signInButton)
        backToLoginButton = findViewById(R.id.backToLoginButton)

        // Set up click listeners
        signInButton.setOnClickListener {
            navigateToLogin()
        }

        backToLoginButton.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        // Navigate to Login activity and clear the activity stack
        val intent = Intent(this, ActivityLogin::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
