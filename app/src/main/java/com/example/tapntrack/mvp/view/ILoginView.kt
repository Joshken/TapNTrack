package com.example.tapntrack.mvp.view

import com.example.tapntrack.mvp.model.User

interface ILoginView {
    fun showProgress()
    fun hideProgress()
    fun onLoginSuccess(user: User)
    fun onLoginFailed(message: String)
    fun showValidationError(field: String, message: String)
    fun navigateToDashboard()
    fun navigateToSignUp()
    fun navigateToForgotPassword()
}
