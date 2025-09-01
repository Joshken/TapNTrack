package com.example.tapntrack.mvp.view

interface ISettingsView {
    fun showProgress()
    fun hideProgress()
    fun onLogoutSuccess()
    fun onLogoutFailed(message: String)
    fun navigateToLogin()
    fun navigateToDashboard()
    fun navigateToLogs()
    fun navigateToManageUsers()
}
