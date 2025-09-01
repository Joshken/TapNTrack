package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.INewPasswordView

interface INewPasswordPresenter {
    fun attachView(view: INewPasswordView)
    fun detachView()
    fun resetPassword(newPassword: String, confirmPassword: String)
    fun onBackClicked()
}
