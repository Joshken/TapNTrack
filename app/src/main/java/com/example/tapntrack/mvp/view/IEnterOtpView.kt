package com.example.tapntrack.mvp.view

interface IEnterOtpView {
    fun showProgress()
    fun hideProgress()
    fun displayEmail(email: String)
    fun onOtpVerified(email: String)
    fun onOtpVerificationFailed(message: String)
    fun showValidationError(field: String, message: String)
    fun onResendCodeSuccess(email: String)
    fun onResendCodeFailed(message: String)
    fun navigateToNewPassword(email: String)
    fun navigateBack()
}
