package com.example.tapntrack

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ActivityLogs : AppCompatActivity() {

    private lateinit var dateText: TextView
    private val calendar = Calendar.getInstance()
    private val dateFormatter = SimpleDateFormat("M/d/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        // Initialize views
        dateText = findViewById(R.id.dateText)

        // Set current date
        updateDateDisplay()

        // Set click listener for date picker
        dateText.setOnClickListener {
            showDatePicker()
        }
    }

    private fun updateDateDisplay() {
        dateText.text = dateFormatter.format(calendar.time)
    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateDisplay()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}
