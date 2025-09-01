package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.User
import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.presenter.ISignUpPresenter
import com.example.tapntrack.mvp.presenter.SignUpPresenter
import com.example.tapntrack.mvp.view.ISignUpView

class ActivitySignUp : AppCompatActivity(), ISignUpView {

    private lateinit var fullNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var signUpButton: Button
    private lateinit var backButton: ImageView
    private lateinit var loginLink: TextView
    
    private lateinit var presenter: ISignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize presenter
        presenter = SignUpPresenter(UserRepository())
        presenter.attachView(this)

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
            val fullName = fullNameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()
            
            presenter.signUp(fullName, email, username, password, confirmPassword)
        }

        backButton.setOnClickListener {
            presenter.onBackClicked()
        }

        loginLink.setOnClickListener {
            presenter.onBackClicked()
        }
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun onSignUpSuccess(user: User) {
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_LONG).show()
    }

    override fun onSignUpFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationError(field: String, message: String) {
        when (field) {
            "fullName" -> fullNameInput.error = message
            "email" -> emailInput.error = message
            "username" -> usernameInput.error = message
            "password" -> passwordInput.error = message
            "confirmPassword" -> confirmPasswordInput.error = message
        }
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
        finish() // Close signup activity
    }

    override fun navigateBack() {
        finish() // Go back to previous activity
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
