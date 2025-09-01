package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ILoginView

interface ILoginPresenter {
    fun attachView(view: ILoginView)
    fun detachView()
    fun login(username: String, password: String)
    fun onSignUpClicked()
    fun onForgotPasswordClicked()
}
