package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IPasswordChangedView

class PasswordChangedPresenter : IPasswordChangedPresenter {
    
    private var view: IPasswordChangedView? = null
    
    override fun attachView(view: IPasswordChangedView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun onSignInClicked() {
        view?.navigateToLogin()
    }
    
    override fun onBackToLoginClicked() {
        view?.navigateToLogin()
    }
}
