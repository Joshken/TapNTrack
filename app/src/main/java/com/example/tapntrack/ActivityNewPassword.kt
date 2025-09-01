package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.UserRepository
import com.example.tapntrack.mvp.presenter.INewPasswordPresenter
import com.example.tapntrack.mvp.presenter.NewPasswordPresenter
import com.example.tapntrack.mvp.view.INewPasswordView

class ActivityNewPassword : AppCompatActivity(), INewPasswordView {

    private lateinit var newPasswordInput: EditText
    private lateinit var confirmNewPasswordInput: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var backButton: ImageView
    
    private lateinit var presenter: INewPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        // Initialize presenter
        presenter = NewPasswordPresenter(UserRepository())
        presenter.attachView(this)

        // Initialize views
        newPasswordInput = findViewById(R.id.newPasswordInput)
        confirmNewPasswordInput = findViewById(R.id.confirmNewPasswordInput)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
        backButton = findViewById(R.id.backButton)

        // Set up click listeners
        resetPasswordButton.setOnClickListener {
            val newPassword = newPasswordInput.text.toString().trim()
            val confirmPassword = confirmNewPasswordInput.text.toString().trim()
            presenter.resetPassword(newPassword, confirmPassword)
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

    override fun onPasswordResetSuccess() {
        Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onPasswordResetFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showValidationError(field: String, message: String) {
        when (field) {
            "newPassword" -> newPasswordInput.error = message
            "confirmPassword" -> confirmNewPasswordInput.error = message
        }
    }

    override fun navigateToPasswordChanged() {
        val intent = Intent(this, ActivityPasswordChanged::class.java)
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
