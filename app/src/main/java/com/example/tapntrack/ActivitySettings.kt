package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.presenter.ISettingsPresenter
import com.example.tapntrack.mvp.presenter.SettingsPresenter
import com.example.tapntrack.mvp.view.ISettingsView

class ActivitySettings : AppCompatActivity(), ISettingsView {

    private lateinit var logoutButton: Button
    private lateinit var notificationsSwitch: Switch
    
    private lateinit var presenter: ISettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize presenter
        presenter = SettingsPresenter()
        presenter.attachView(this)

        // Initialize views
        logoutButton = findViewById(R.id.logoutButton)
        notificationsSwitch = findViewById(R.id.notificationsSwitch)

        // Set up click listeners
        logoutButton.setOnClickListener {
            presenter.logout()
        }

        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle notifications toggle
            Toast.makeText(this, "Notifications ${if (isChecked) "enabled" else "disabled"}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun onLogoutSuccess() {
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onLogoutFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLogin() {
        // Navigate to Login activity and clear the activity stack
        val intent = Intent(this, ActivityLogin::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, ActivityDashboard::class.java)
        startActivity(intent)
    }

    override fun navigateToLogs() {
        val intent = Intent(this, ActivityLogs::class.java)
        startActivity(intent)
    }

    override fun navigateToManageUsers() {
        val intent = Intent(this, ActivityManageUsers::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
