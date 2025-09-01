package com.example.tapntrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.presenter.IDashboardPresenter
import com.example.tapntrack.mvp.presenter.DashboardPresenter
import com.example.tapntrack.mvp.view.IDashboardView

class ActivityDashboard : AppCompatActivity(), IDashboardView {

    private lateinit var totalAttendanceText: TextView
    private lateinit var activeUsersText: TextView
    private lateinit var dailyAttendanceButton: Button
    
    private lateinit var presenter: IDashboardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize presenter
        presenter = DashboardPresenter(AttendanceRepository())
        presenter.attachView(this)

        // Initialize views
        totalAttendanceText = findViewById(R.id.totalAttendanceText)
        activeUsersText = findViewById(R.id.activeUsersText)
        dailyAttendanceButton = findViewById(R.id.dailyAttendanceButton)

        // Set up click listeners
        dailyAttendanceButton.setOnClickListener {
            presenter.onDailyAttendanceClicked()
        }

        // Load dashboard stats
        presenter.loadDashboardStats()
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun displayDashboardStats(totalAttendance: Int, activeUsers: Int) {
        totalAttendanceText.text = totalAttendance.toString()
        activeUsersText.text = activeUsers.toString()
    }

    override fun onStatsLoadFailed(message: String) {
        // Handle error - could show a toast or error message
    }

    override fun navigateToLogs() {
        val intent = Intent(this, ActivityLogs::class.java)
        startActivity(intent)
    }

    override fun navigateToManageUsers() {
        val intent = Intent(this, ActivityManageUsers::class.java)
        startActivity(intent)
    }

    override fun navigateToSettings() {
        val intent = Intent(this, ActivitySettings::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
