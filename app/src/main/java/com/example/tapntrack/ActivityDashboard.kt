package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize views
        val dailyAttendanceButton = findViewById<Button>(R.id.dailyAttendanceButton)

        // Set click listener for Daily Attendance button
        dailyAttendanceButton.setOnClickListener {
            // Navigate to logs activity
            val intent = Intent(this, ActivityLogs::class.java)
            startActivity(intent)
        }
    }
}
