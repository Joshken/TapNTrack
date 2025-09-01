package com.example.tapntrack.mvp.view

interface IForgotPasswordView {
    fun showProgress()
    fun hideProgress()
    fun onResetCodeSent(email: String)
    fun onResetCodeFailed(message: String)
    fun showValidationError(field: String, message: String)
    fun navigateToSentOtp(email: String)
    fun navigateBack()
}
