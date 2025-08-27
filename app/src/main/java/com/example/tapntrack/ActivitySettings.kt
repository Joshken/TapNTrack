package com.example.tapntrack

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class ActivitySettings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize views
        val logoutButton = findViewById<Button>(R.id.logoutButton)
        val notificationsSwitch = findViewById<Switch>(R.id.notificationsSwitch)

        // Set click listener for logout button
        logoutButton.setOnClickListener {
            // TODO: Implement logout functionality
            // This could include clearing user data, navigating to login screen, etc.
        }

        // Set listener for notifications switch
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // TODO: Implement notifications toggle functionality
        }
    }
}
