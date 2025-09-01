package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.model.AttendanceRepository
import com.example.tapntrack.mvp.view.IManageUsersView

class ManageUsersPresenter(private val attendanceRepository: AttendanceRepository) : IManageUsersPresenter {
    
    private var view: IManageUsersView? = null
    
    override fun attachView(view: IManageUsersView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun loadUsers() {
        view?.showProgress()
        
        try {
            val users = attendanceRepository.getUsers()
            view?.displayUsers(users)
        } catch (e: Exception) {
            view?.onUsersLoadFailed("Failed to load users")
        }
        
        view?.hideProgress()
    }
    
    override fun onDashboardClicked() {
        view?.navigateToDashboard()
    }
    
    override fun onLogsClicked() {
        view?.navigateToLogs()
    }
    
    override fun onSettingsClicked() {
        view?.navigateToSettings()
    }
}
