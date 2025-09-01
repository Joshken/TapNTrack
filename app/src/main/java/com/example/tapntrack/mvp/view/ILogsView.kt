package com.example.tapntrack.mvp.view

import com.example.tapntrack.mvp.model.AttendanceLog

interface ILogsView {
    fun showProgress()
    fun hideProgress()
    fun displayAttendanceLogs(logs: List<AttendanceLog>)
    fun displaySelectedDate(date: String)
    fun onLogsLoadFailed(message: String)
    fun navigateToDashboard()
    fun navigateToManageUsers()
    fun navigateToSettings()
}
