package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IDashboardView

interface IDashboardPresenter {
    fun attachView(view: IDashboardView)
    fun detachView()
    fun loadDashboardStats()
    fun onDailyAttendanceClicked()
    fun onManageUsersClicked()
    fun onSettingsClicked()
}
