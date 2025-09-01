package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ISentOtpView

class SentOtpPresenter : ISentOtpPresenter {
    
    private var view: ISentOtpView? = null
    
    override fun attachView(view: ISentOtpView) {
        this.view = view
    }
    
    override fun detachView() {
        this.view = null
    }
    
    override fun onContinueClicked(email: String) {
        view?.navigateToEnterOtp(email)
    }
    
    override fun onBackClicked() {
        view?.navigateBack()
    }
}
