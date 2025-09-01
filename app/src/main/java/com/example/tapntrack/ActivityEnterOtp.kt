package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.presenter.IEnterOtpPresenter
import com.example.tapntrack.mvp.presenter.EnterOtpPresenter
import com.example.tapntrack.mvp.view.IEnterOtpView

class ActivityEnterOtp : AppCompatActivity(), IEnterOtpView {

    private lateinit var emailDisplay: TextView
    private lateinit var otpInput: EditText
    private lateinit var verifyCodeButton: Button
    private lateinit var resendCodeLink: TextView
    private lateinit var backButton: ImageView
    
    private lateinit var presenter: IEnterOtpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_otp)

        // Initialize presenter
        presenter = EnterOtpPresenter(UserRepository())
        presenter.attachView(this)

        // Initialize views
        emailDisplay = findViewById(R.id.emailDisplay)
        otpInput = findViewById(R.id.otpInput)
        verifyCodeButton = findViewById(R.id.verifyCodeButton)
        resendCodeLink = findViewById(R.id.resendCodeLink)
        backButton = findViewById(R.id.backButton)

        // Get email from intent
        val email = intent.getStringExtra("email") ?: "user@example.com"
        displayEmail(email)

        // Set up click listeners
        verifyCodeButton.setOnClickListener {
            val otp = otpInput.text.toString().trim()
            presenter.verifyOtp(email, otp)
        }

        resendCodeLink.setOnClickListener {
            presenter.resendCode(email)
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

    override fun displayEmail(email: String) {
        emailDisplay.text = email
    }

    override fun onOtpVerified(email: String) {
        Toast.makeText(this, "Code verified successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onOtpVerificationFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationError(field: String, message: String) {
        when (field) {
            "otp" -> otpInput.error = message
        }
    }

    override fun onResendCodeSuccess(email: String) {
        Toast.makeText(this, "Reset code resent to $email", Toast.LENGTH_LONG).show()
    }

    override fun onResendCodeFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToNewPassword(email: String) {
        val intent = Intent(this, ActivityNewPassword::class.java)
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
