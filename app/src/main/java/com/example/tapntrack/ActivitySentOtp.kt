package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.presenter.ISentOtpPresenter
import com.example.tapntrack.mvp.presenter.SentOtpPresenter
import com.example.tapntrack.mvp.view.ISentOtpView

class ActivitySentOtp : AppCompatActivity(), ISentOtpView {

    private lateinit var emailDisplay: TextView
    private lateinit var continueButton: Button
    private lateinit var backButton: ImageView
    
    private lateinit var presenter: ISentOtpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sent_otp)

        // Initialize presenter
        presenter = SentOtpPresenter()
        presenter.attachView(this)

        // Initialize views
        emailDisplay = findViewById(R.id.emailDisplay)
        continueButton = findViewById(R.id.continueButton)
        backButton = findViewById(R.id.backButton)

        // Get email from intent
        val email = intent.getStringExtra("email") ?: "user@example.com"
        displayEmail(email)

        // Set up click listeners
        continueButton.setOnClickListener {
            presenter.onContinueClicked(email)
        }

        backButton.setOnClickListener {
            presenter.onBackClicked()
        }
    }

    override fun displayEmail(email: String) {
        emailDisplay.text = email
    }

    override fun navigateToEnterOtp(email: String) {
        val intent = Intent(this, ActivityEnterOtp::class.java)
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
