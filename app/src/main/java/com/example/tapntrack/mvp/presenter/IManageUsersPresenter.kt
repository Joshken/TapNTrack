package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IManageUsersView

interface IManageUsersPresenter {
    fun attachView(view: IManageUsersView)
    fun detachView()
    fun loadUsers()
    fun onDashboardClicked()
    fun onLogsClicked()
    fun onSettingsClicked()
}
