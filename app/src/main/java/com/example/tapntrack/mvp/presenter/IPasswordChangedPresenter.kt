package com.example.tapntrack.mvp.presenter

import com.example.tapntrack.mvp.view.IPasswordChangedView

interface IPasswordChangedPresenter {
    fun attachView(view: IPasswordChangedView)
    fun detachView()
    fun onSignInClicked()
    fun onBackToLoginClicked()
}
