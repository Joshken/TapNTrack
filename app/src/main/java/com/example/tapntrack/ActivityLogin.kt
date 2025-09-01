package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.User
import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.presenter.ILoginPresenter
import com.example.tapntrack.mvp.presenter.LoginPresenter
import com.example.tapntrack.mvp.view.ILoginView

class ActivityLogin : AppCompatActivity(), ILoginView {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signInButton: Button
    private lateinit var forgotPasswordLink: TextView
    private lateinit var signUpLink: TextView
    
    private lateinit var presenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize presenter
        presenter = LoginPresenter(UserRepository())
        presenter.attachView(this)

        // Initialize views
        usernameInput = findViewById(R.id.usernameInput)
        passwordInput = findViewById(R.id.passwordInput)
        signInButton = findViewById(R.id.signInButton)
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink)
        signUpLink = findViewById(R.id.signUpLink)

        // Set up click listeners
        signInButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            presenter.login(username, password)
        }

        forgotPasswordLink.setOnClickListener {
            presenter.onForgotPasswordClicked()
        }

        signUpLink.setOnClickListener {
            presenter.onSignUpClicked()
        }
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun onLoginSuccess(user: User) {
        Toast.makeText(this, "Welcome ${user.name}!", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationError(field: String, message: String) {
        when (field) {
            "username" -> usernameInput.error = message
            "password" -> passwordInput.error = message
        }
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
        finish() // Close login activity so user can't go back
    }

    override fun navigateToSignUp() {
        val intent = Intent(this, ActivitySignUp::class.java)
        startActivity(intent)
    }

    override fun navigateToForgotPassword() {
        val intent = Intent(this, ActivityForgotPassword::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
