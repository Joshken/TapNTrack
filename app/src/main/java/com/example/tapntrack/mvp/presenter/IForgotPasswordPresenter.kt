package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IForgotPasswordView

interface IForgotPasswordPresenter {
    fun attachView(view: IForgotPasswordView)
    fun detachView()
    fun sendResetCode(email: String)
    fun onBackClicked()
}
