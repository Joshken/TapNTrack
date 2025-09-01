package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.presenter.IPasswordChangedPresenter
import com.example.tapntrack.mvp.presenter.PasswordChangedPresenter
import com.example.tapntrack.mvp.view.IPasswordChangedView

class ActivityPasswordChanged : AppCompatActivity(), IPasswordChangedView {

    private lateinit var signInButton: Button
    private lateinit var backToLoginButton: Button
    
    private lateinit var presenter: IPasswordChangedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_changed)

        // Initialize presenter
        presenter = PasswordChangedPresenter()
        presenter.attachView(this)

        // Initialize views
        signInButton = findViewById(R.id.signInButton)
        backToLoginButton = findViewById(R.id.backToLoginButton)

        // Set up click listeners
        signInButton.setOnClickListener {
            presenter.onSignInClicked()
        }

        backToLoginButton.setOnClickListener {
            presenter.onBackToLoginClicked()
        }
    }

    override fun navigateToLogin() {
        // Navigate to Login activity and clear the activity stack
        val intent = Intent(this, ActivityLogin::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
