package com.example.tapntrack.mvp.view

interface ISentOtpView {
    fun displayEmail(email: String)
    fun navigateToEnterOtp(email: String)
    fun navigateBack()
}
