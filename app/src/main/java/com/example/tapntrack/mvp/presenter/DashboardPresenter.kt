package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.view.IDashboardView

class DashboardPresenter(private val attendanceRepository: AttendanceRepository) : IDashboardPresenter {
    
    private var view: IDashboardView? = null
    
    override fun attachView(view: IDashboardView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun loadDashboardStats() {
        view?.showProgress()
        
        try {
            val stats = attendanceRepository.getDashboardStats()
            val totalAttendance = stats["totalAttendance"] ?: 0
            val activeUsers = stats["activeUsers"] ?: 0
            
            view?.displayDashboardStats(totalAttendance, activeUsers)
        } catch (e: Exception) {
            view?.onStatsLoadFailed("Failed to load dashboard stats")
        }
        
        view?.hideProgress()
    }
    
    override fun onDailyAttendanceClicked() {
        view?.navigateToLogs()
    }
    
    override fun onManageUsersClicked() {
        view?.navigateToManageUsers()
    }
    
    override fun onSettingsClicked() {
        view?.navigateToSettings()
    }
}
