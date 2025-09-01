package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ILogsView

interface ILogsPresenter {
    fun attachView(view: ILogsView)
    fun detachView()
    fun loadAttendanceLogs(date: String)
    fun onDateSelected(date: String)
    fun onDashboardClicked()
    fun onManageUsersClicked()
    fun onSettingsClicked()
}
