package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.presenter.IForgotPasswordPresenter
import com.example.tapntrack.mvp.presenter.ForgotPasswordPresenter
import com.example.tapntrack.mvp.view.IForgotPasswordView

class ActivityForgotPassword : AppCompatActivity(), IForgotPasswordView {

    private lateinit var emailInput: EditText
    private lateinit var sendResetCodeButton: Button
    private lateinit var backButton: ImageView
    
    private lateinit var presenter: IForgotPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // Initialize presenter
        presenter = ForgotPasswordPresenter(UserRepository())
        presenter.attachView(this)

        // Initialize views
        emailInput = findViewById(R.id.emailInput)
        sendResetCodeButton = findViewById(R.id.sendResetCodeButton)
        backButton = findViewById(R.id.backButton)

        // Set up click listeners
        sendResetCodeButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            presenter.sendResetCode(email)
        }

        backButton.setOnClickListener {
            presenter.onBackClicked()
        }
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun onResetCodeSent(email: String) {
        Toast.makeText(this, "Reset code sent to $email", Toast.LENGTH_SHORT).show()
    }

    override fun onResetCodeFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationError(field: String, message: String) {
        when (field) {
            "email" -> emailInput.error = message
        }
    }

    override fun navigateToSentOtp(email: String) {
        val intent = Intent(this, ActivitySentOtp::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }

    override fun navigateBack() {
        finish() // Go back to previous activity
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
