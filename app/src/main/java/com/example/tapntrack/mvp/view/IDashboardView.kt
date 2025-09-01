package com.example.tapntrack.mvp.view

interface IDashboardView {
    fun showProgress()
    fun hideProgress()
    fun displayDashboardStats(totalAttendance: Int, activeUsers: Int)
    fun onStatsLoadFailed(message: String)
    fun navigateToLogs()
    fun navigateToManageUsers()
    fun navigateToSettings()
}
