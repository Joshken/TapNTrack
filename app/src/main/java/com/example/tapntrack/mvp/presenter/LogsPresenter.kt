package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.view.ILogsView
import java.text.SimpleDateFormat
import java.util.*

class LogsPresenter(private val attendanceRepository: AttendanceRepository) : ILogsPresenter {
    
    private var view: ILogsView? = null
    
    override fun attachView(view: ILogsView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun loadAttendanceLogs(date: String) {
        view?.showProgress()
        
        try {
            val logs = attendanceRepository.getAttendanceLogs(date)
            view?.displayAttendanceLogs(logs)
        } catch (e: Exception) {
            view?.onLogsLoadFailed("Failed to load attendance logs")
        }
        
        view?.hideProgress()
    }
    
    override fun onDateSelected(date: String) {
        view?.displaySelectedDate(date)
        loadAttendanceLogs(date)
    }
    
    override fun onDashboardClicked() {
        view?.navigateToDashboard()
    }
    
    override fun onManageUsersClicked() {
        view?.navigateToManageUsers()
    }
    
    override fun onSettingsClicked() {
        view?.navigateToSettings()
    }
}
