package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ISettingsView

class SettingsPresenter : ISettingsPresenter {
    
    private var view: ISettingsView? = null
    
    override fun attachView(view: ISettingsView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun logout() {
        view?.showProgress()
        
        // In a real app, you would clear user session, tokens, etc.
        // For demo purposes, we'll just simulate success
        
        view?.onLogoutSuccess()
        view?.navigateToLogin()
        view?.hideProgress()
    }
    
    override fun onDashboardClicked() {
        view?.navigateToDashboard()
    }
    
    override fun onLogsClicked() {
        view?.navigateToLogs()
    }
    
    override fun onManageUsersClicked() {
        view?.navigateToManageUsers()
    }
}
