package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ISentOtpView

interface ISentOtpPresenter {
    fun attachView(view: ISentOtpView)
    fun detachView()
    fun onContinueClicked(email: String)
    fun onBackClicked()
}
