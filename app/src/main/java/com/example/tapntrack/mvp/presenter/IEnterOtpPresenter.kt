package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IEnterOtpView

interface IEnterOtpPresenter {
    fun attachView(view: IEnterOtpView)
    fun detachView()
    fun verifyOtp(email: String, otp: String)
    fun resendCode(email: String)
    fun onBackClicked()
}
