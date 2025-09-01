package com.example.tapntrack.mvp.view

interface INewPasswordView {
    fun showProgress()
    fun hideProgress()
    fun onPasswordResetSuccess()
    fun onPasswordResetFailed(message: String)
    fun showValidationError(field: String, message: String)
    fun navigateToPasswordChanged()
    fun navigateBack()
}
