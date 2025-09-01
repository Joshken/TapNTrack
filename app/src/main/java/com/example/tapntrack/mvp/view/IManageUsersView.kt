package com.example.tapntrack.mvp.view

import com.example.tapntrack.mvp.model.User

interface IManageUsersView {
    fun showProgress()
    fun hideProgress()
    fun displayUsers(users: List<User>)
    fun onUsersLoadFailed(message: String)
    fun navigateToDashboard()
    fun navigateToLogs()
    fun navigateToSettings()
}
