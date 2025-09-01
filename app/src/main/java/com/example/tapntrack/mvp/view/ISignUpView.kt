package com.example.tapntrack.mvp.view

import com.example.tapntrack.mvp.model.User

interface ISignUpView {
    fun showProgress()
    fun hideProgress()
    fun onSignUpSuccess(user: User)
    fun onSignUpFailed(message: String)
    fun showValidationError(field: String, message: String)
    fun navigateToDashboard()
    fun navigateBack()
}
