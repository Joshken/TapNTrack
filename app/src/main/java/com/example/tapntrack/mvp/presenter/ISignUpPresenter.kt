package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.ISignUpView

interface ISignUpPresenter {
    fun attachView(view: ISignUpView)
    fun detachView()
    fun signUp(fullName: String, email: String, username: String, password: String, confirmPassword: String)
    fun onBackClicked()
}
