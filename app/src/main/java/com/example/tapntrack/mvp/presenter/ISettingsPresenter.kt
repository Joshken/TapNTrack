package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ISettingsView

interface ISettingsPresenter {
    fun attachView(view: ISettingsView)
    fun detachView()
    fun logout()
    fun onDashboardClicked()
    fun onLogsClicked()
    fun onManageUsersClicked()
}
