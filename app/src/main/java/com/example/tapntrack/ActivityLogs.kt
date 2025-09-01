package com.example.tapntrack

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.presenter.ILogsPresenter
import com.example.tapntrack.mvp.presenter.LogsPresenter
import com.example.tapntrack.mvp.view.ILogsView
import java.text.SimpleDateFormat
import java.util.*

class ActivityLogs : AppCompatActivity(), ILogsView {

    private lateinit var dateText: TextView
    
    private lateinit var presenter: ILogsPresenter
    private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        // Initialize presenter
        presenter = LogsPresenter(AttendanceRepository())
        presenter.attachView(this)

        // Initialize views
        dateText = findViewById(R.id.dateText)

        // Set current date
        val currentDate = dateFormat.format(Date())
        displaySelectedDate(currentDate)

        // Set up click listeners
        dateText.setOnClickListener {
            showDatePicker()
        }

        // Load attendance logs for current date
        presenter.loadAttendanceLogs(currentDate)
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance().apply {
                    set(selectedYear, selectedMonth, selectedDay)
                }
                val formattedDate = dateFormat.format(selectedDate.time)
                presenter.onDateSelected(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    override fun showProgress() {
        // Show loading indicator if needed
    }

    override fun hideProgress() {
        // Hide loading indicator if needed
    }

    override fun displayAttendanceLogs(logs: List<com.example.tapntrack.mvp.model.AttendanceLog>) {
        // In a real app, you would populate a RecyclerView with the logs
        // For now, we'll just show a count
        // This would be implemented with an adapter
    }

    override fun displaySelectedDate(date: String) {
        dateText.text = date
    }

    override fun onLogsLoadFailed(message: String) {
        // Handle error - could show a toast or error message
    }

    override fun navigateToDashboard() {
        val intent = Intent(this, ActivityDashboard::class.java)
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
